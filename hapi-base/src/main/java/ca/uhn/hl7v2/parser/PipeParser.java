/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "PipeParser.java".  Description:
 * "An implementation of Parser that supports traditionally encoded (i.e"
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2001.  All Rights Reserved.
 *
 * Contributor(s): Kenneth Beaton.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  "GPL"), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 *
 */

package ca.uhn.hl7v2.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.ErrorCode;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.model.AbstractSuperMessage;
import ca.uhn.hl7v2.model.DoNotCacheStructure;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Primitive;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Structure;
import ca.uhn.hl7v2.model.SuperStructure;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.Varies;
import ca.uhn.hl7v2.util.ReflectionUtil;
import ca.uhn.hl7v2.util.Terser;
import ca.uhn.hl7v2.validation.impl.NoValidation;
import ca.uhn.hl7v2.validation.impl.ValidationContextFactory;

/**
 * An implementation of Parser that supports traditionally encoded (ie delimited
 * with characters like |, ^, and ~) HL7 messages. Unexpected segments and
 * fields are parsed into generic elements that are added to the message.
 * 
 * @see ParserConfiguration for configuration options which may affect parser encoding and decoding behaviour
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 */
public class PipeParser extends Parser {

	private static final Logger log = LoggerFactory.getLogger(PipeParser.class);

	/**
	 * The HL7 ER7 segment delimiter (see section 2.8 of spec)
	 */
	final static String SEGMENT_DELIMITER = "\r";

	private final HashMap<Class<? extends Message>, HashMap<String, StructureDefinition>> myStructureDefinitions = new HashMap<Class<? extends Message>, HashMap<String, StructureDefinition>>();

	/**
	 * System property key. If value is "true", legacy mode will default to true
	 * 
	 * @see #isLegacyMode()
	 * @deprecated This will be removed in HAPI 3.0
	 */
	public static final String DEFAULT_LEGACY_MODE_PROPERTY = "ca.uhn.hl7v2.parser.PipeParser.default_legacy_mode";

	private Boolean myLegacyMode = null;

	public PipeParser() {
		super();
	}

	/**
	 * @param context
	 *            the context containing all configuration items to be used
	 */
	public PipeParser(HapiContext context) {
		super(context);
	}

	/**
	 * Creates a new PipeParser
	 * 
	 * @param theFactory
	 *            custom factory to use for model class lookup
	 */
	public PipeParser(ModelClassFactory theFactory) {
		super(theFactory);
	}

	/**
	 * Returns a String representing the encoding of the given message, if the
	 * encoding is recognized. For example if the given message appears to be
	 * encoded using HL7 2.x XML rules then "XML" would be returned. If the
	 * encoding is not recognized then null is returned. That this method
	 * returns a specific encoding does not guarantee that the message is
	 * correctly encoded (e.g. well formed XML) - just that it is not encoded
	 * using any other encoding than the one returned.
	 */
	public String getEncoding(String message) {
		return EncodingDetector.isEr7Encoded(message) ? getDefaultEncoding() : null;
	}

	/**
	 * @return the preferred encoding of this Parser
	 */
	public String getDefaultEncoding() {
		return "VB";
	}

	/**
	 * @deprecated this method should not be public
	 * @param message HL7 message
	 * @return message structure
	 * @throws HL7Exception
	 */
	public String getMessageStructure(String message) throws HL7Exception {
		return getStructure(message).messageStructure;
	}

	/**
	 * @return the message structure from MSH-9-3
	 */
	private MessageStructure getStructure(String message) throws HL7Exception {
		EncodingCharacters ec = getEncodingChars(message);
		String messageStructure;
		boolean explicityDefined = true;
		String wholeFieldNine;
		try {
			String[] fields = split(message.substring(0, Math.max(message.indexOf(SEGMENT_DELIMITER), message.length())), String.valueOf(ec.getFieldSeparator()));
			wholeFieldNine = fields[8];

			// message structure is component 3 but we'll accept a composite of
			// 1 and 2 if there is no component 3 ...
			// if component 1 is ACK, then the structure is ACK regardless of
			// component 2
			String[] comps = split(wholeFieldNine, String.valueOf(ec.getComponentSeparator()));
			if (comps.length >= 3) {
				messageStructure = comps[2];
			} else if (comps.length > 0 && comps[0] != null && comps[0].equals("ACK")) {
				messageStructure = "ACK";
			} else if (comps.length == 2) {
				explicityDefined = false;
				messageStructure = comps[0] + "_" + comps[1];
			}
			/*
			 * else if (comps.length == 1 && comps[0] != null &&
			 * comps[0].equals("ACK")) { messageStructure = "ACK"; //it's common
			 * for people to only populate component 1 in an ACK msg }
			 */
			else {
				StringBuilder buf = new StringBuilder("Can't determine message structure from MSH-9: ");
				buf.append(wholeFieldNine);
				if (comps.length < 3) {
					buf.append(" HINT: there are only ");
					buf.append(comps.length);
					buf.append(" of 3 components present");
				}
				throw new HL7Exception(buf.toString(), ErrorCode.UNSUPPORTED_MESSAGE_TYPE);
			}
		} catch (IndexOutOfBoundsException e) {
			throw new HL7Exception("Can't find message structure (MSH-9-3): " + e.getMessage(), ErrorCode.UNSUPPORTED_MESSAGE_TYPE);
		}

		return new MessageStructure(messageStructure, explicityDefined);
	}

	/**
	 * Returns object that contains the field separator and encoding characters
	 * for this message.
	 * 
	 * @throws HL7Exception
	 */
	private static EncodingCharacters getEncodingChars(String message) throws HL7Exception {
		if (message.length() < 8) {
			throw new HL7Exception("Invalid message content: \"" + message + "\"");
		}
		return new EncodingCharacters(message.charAt(3), message.substring(4, 8));
	}

	/**
	 * Parses a message string and returns the corresponding Message object.
	 * Unexpected segments added at the end of their group.
	 * 
	 * @throws HL7Exception
	 *             if the message is not correctly formatted.
	 * @throws EncodingNotSupportedException
	 *             if the message encoded is not supported by this parser.
	 */
	protected Message doParse(String message, String version) throws HL7Exception {

		// try to instantiate a message object of the right class
		MessageStructure structure = getStructure(message);
		Message m = instantiateMessage(structure.messageStructure, version, structure.explicitlyDefined);
		// Note: this will change in future to reuse the Parser's/HapiContext's
		// ValidationContext.
		m.setValidationContext(getValidationContext());
		
		m.setParser(this);
		
		parse(m, message);

		return m;
	}

	/**
	 * {@inheritDoc}
	 */
	protected Message doParseForSpecificPackage(String message, String version, String packageName) throws HL7Exception {

		// try to instantiate a message object of the right class
		MessageStructure structure = getStructure(message);
		Message m = instantiateMessageInASpecificPackage(structure.messageStructure, version, structure.explicitlyDefined, packageName);

		parse(m, message);

		return m;
	}

	/**
	 * Generates (or returns the cached value of) the message
	 */
	private IStructureDefinition getStructureDefinition(Message theMessage) throws HL7Exception {

		Class<? extends Message> clazz = theMessage.getClass();
		HashMap<String, StructureDefinition> definitions = myStructureDefinitions.get(clazz);

		StructureDefinition retVal;
		if (definitions != null) {
			retVal = definitions.get(theMessage.getName());
			if (retVal != null) {
				return retVal;
			}
		}

		if (theMessage instanceof SuperStructure) {
			Set<String> appliesTo = ((SuperStructure) theMessage).getStructuresWhichChildAppliesTo("MSH");
			if (!appliesTo.contains(theMessage.getName())) {
				throw new HL7Exception("Superstructure " + theMessage.getClass().getSimpleName() + " does not apply to message " + theMessage.getName() + ", can not parse.");
			}
		}
		
		if (clazz.isAnnotationPresent(DoNotCacheStructure.class)) {
			Holder<StructureDefinition> previousLeaf = new Holder<StructureDefinition>();
			retVal = createStructureDefinition(theMessage, previousLeaf, theMessage.getName());
		} else {
			Message message = ReflectionUtil.instantiateMessage(clazz, getFactory());
			Holder<StructureDefinition> previousLeaf = new Holder<StructureDefinition>();
			retVal = createStructureDefinition(message, previousLeaf, theMessage.getName());

			if (!myStructureDefinitions.containsKey(clazz)) {
				myStructureDefinitions.put(clazz, new HashMap<String, StructureDefinition>());
			}
			myStructureDefinitions.get(clazz).put(theMessage.getName(), retVal);
		}

		return retVal;
	}

	private StructureDefinition createStructureDefinition(Structure theStructure, Holder<StructureDefinition> thePreviousLeaf, String theStructureName) throws HL7Exception {

		StructureDefinition retVal = new StructureDefinition();
		retVal.setName(theStructure.getName());

		if (theStructure instanceof Group) {
			retVal.setSegment(false);
			Group group = (Group) theStructure;
			int index = 0;
			List<String> childNames = Arrays.asList(group.getNames());
			
			/*
			 * For SuperStructures, which can hold more than one type of structure,
			 * we only actually bring in the child names that are actually a part
			 * of the structure we are trying to parse
			 */
			if (theStructure instanceof SuperStructure) {
				String struct = theStructureName;
				Map<String, String> evtMap = new DefaultModelClassFactory().getEventMapForVersion(Version.versionOf(theStructure.getMessage().getVersion()));
				if (evtMap.containsKey(struct)) {
					struct = evtMap.get(struct);
				}
				childNames = ((SuperStructure) theStructure).getChildNamesForStructure(struct);
			}
			
			for (String nextName : childNames) {
				Structure nextChild = group.get(nextName);
				StructureDefinition structureDefinition = createStructureDefinition(nextChild, thePreviousLeaf, theStructureName);
				structureDefinition.setNameAsItAppearsInParent(nextName);
				structureDefinition.setRepeating(group.isRepeating(nextName));
				structureDefinition.setRequired(group.isRequired(nextName));
				structureDefinition.setChoiceElement(group.isChoiceElement(nextName));
				structureDefinition.setPosition(index++);
				structureDefinition.setParent(retVal);
				retVal.addChild(structureDefinition);
			}
		} else {
			if (thePreviousLeaf.getObject() != null) {
				thePreviousLeaf.getObject().setNextLeaf(retVal);
			}
			thePreviousLeaf.setObject(retVal);
			retVal.setSegment(true);
		}

		return retVal;
	}

	/**
	 * Parses a segment string and populates the given Segment object.
	 * Unexpected fields are added as Varies' at the end of the segment.
     *
	 * @param destination segment to parse the segment string into
     * @param segment encoded segment
     * @param encodingChars encoding characters to be used
	 * @throws HL7Exception
	 *             if the given string does not contain the given segment or if
	 *             the string is not encoded properly
	 */
	public void parse(Segment destination, String segment, EncodingCharacters encodingChars) throws HL7Exception {
		parse(destination, segment, encodingChars, 0);
	}

	/**
	 * Parses a segment string and populates the given Segment object.
	 * Unexpected fields are added as Varies' at the end of the segment.
	 *
     * @param destination segment to parse the segment string into
     * @param segment encoded segment
     * @param encodingChars encoding characters to be used
	 * @param theRepetition the repetition number of this segment within its group
	 * @throws HL7Exception
	 *             if the given string does not contain the given segment or if
	 *             the string is not encoded properly
	 */
	public void parse(Segment destination, String segment, EncodingCharacters encodingChars, int theRepetition) throws HL7Exception {
		int fieldOffset = 0;
		if (isDelimDefSegment(destination.getName())) {
			fieldOffset = 1;
			// set field 1 to fourth character of string
			Terser.set(destination, 1, 0, 1, 1, String.valueOf(encodingChars.getFieldSeparator()));
		}

		String[] fields = split(segment, String.valueOf(encodingChars.getFieldSeparator()));
		// destination.setName(fields[0]);
		for (int i = 1; i < fields.length; i++) {
			String[] reps = split(fields[i], String.valueOf(encodingChars.getRepetitionSeparator()));

			// MSH-2 will get split incorrectly so we have to fudge it ...
			boolean isMSH2 = isDelimDefSegment(destination.getName()) && i + fieldOffset == 2;
			if (isMSH2) {
				reps = new String[1];
				reps[0] = fields[i];
			}

			for (int j = 0; j < reps.length; j++) {
				try {
					log.trace("Parsing field {} repetition {}", i + fieldOffset, j);
					Type field = destination.getField(i + fieldOffset, j);
					if (isMSH2) {
						Terser.getPrimitive(field, 1, 1).setValue(reps[j]);
					} else {
						parse(field, reps[j], encodingChars);
					}
				} catch (HL7Exception e) {
					// set the field location and throw again ...
					e.setFieldPosition(i);
					if (theRepetition > 1) {
						e.setSegmentRepetition(theRepetition);
					}
					e.setSegmentName(destination.getName());
					throw e;
				}
			}
		}

		// set data type of OBX-5
		if (destination.getClass().getName().contains("OBX")) {
			Varies.fixOBX5(destination, getFactory(), getHapiContext().getParserConfiguration());
		}

	}

	/**
	 * @return true if the segment is MSH, FHS, or BHS. These need special
	 *         treatment because they define delimiters.
	 * @param theSegmentName
	 *            segment name
	 */
	private static boolean isDelimDefSegment(String theSegmentName) {
		boolean is = false;
		if (theSegmentName.equals("MSH") || theSegmentName.equals("FHS") || theSegmentName.equals("BHS")) {
			is = true;
		}
		return is;
	}

	/**
	 * Fills a field with values from an unparsed string representing the field.
	 * 
	 * @param destinationField
	 *            the field Type
	 * @param data
	 *            the field string (including all components and subcomponents;
	 *            not including field delimiters)
	 * @param encodingCharacters
	 *            the encoding characters used in the message
	 */
	@Override
	public void parse(Type destinationField, String data, EncodingCharacters encodingCharacters) throws HL7Exception {
		String[] components = split(data, String.valueOf(encodingCharacters.getComponentSeparator()));
		for (int i = 0; i < components.length; i++) {
			String[] subcomponents = split(components[i], String.valueOf(encodingCharacters.getSubcomponentSeparator()));
			for (int j = 0; j < subcomponents.length; j++) {
				String val = subcomponents[j];
				if (val != null) {
					val = getParserConfiguration().getEscaping().unescape(val, encodingCharacters);
				}
				Terser.getPrimitive(destinationField, i + 1, j + 1).setValue(val);
			}
		}
	}

	/**
	 * Splits the given composite string into an array of components using the
	 * given delimiter.
     *
     * @param composite encoded composite string
     * @param delim delimiter to split upon
     * @return split string
	 */
	public static String[] split(String composite, String delim) {
		ArrayList<String> components = new ArrayList<String>();

		// defend against evil nulls
		if (composite == null)
			composite = "";
		if (delim == null)
			delim = "";

		StringTokenizer tok = new StringTokenizer(composite, delim, true);
		boolean previousTokenWasDelim = true;
		while (tok.hasMoreTokens()) {
			String thisTok = tok.nextToken();
			if (thisTok.equals(delim)) {
				if (previousTokenWasDelim)
					components.add(null);
				previousTokenWasDelim = true;
			} else {
				components.add(thisTok);
				previousTokenWasDelim = false;
			}
		}

		String[] ret = new String[components.size()];
		for (int i = 0; i < components.size(); i++) {
			ret[i] = components.get(i);
		}

		return ret;
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public String doEncode(Segment structure, EncodingCharacters encodingCharacters) throws HL7Exception {
		return encode(structure, encodingCharacters);
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public String doEncode(Type type, EncodingCharacters encodingCharacters) throws HL7Exception {
		return encode(type, encodingCharacters);
	}

	/**
	 * Encodes the given Type, using the given encoding characters. It is
	 * assumed that the Type represents a complete field rather than a
	 * component.
     *
     * @param source type to be encoded
     * @param encodingChars encoding characters to be used
     * @return encoded type
	 */
	public static String encode(Type source, EncodingCharacters encodingChars) {
		return encode(source, encodingChars, null, null);
	}

	private static String encode(Type source, EncodingCharacters encodingChars, ParserConfiguration parserConfig, String currentTerserPath) {
		if (source instanceof Varies) {
			Varies varies = (Varies) source;
			if (varies.getData() != null) {
				source = varies.getData();
			}
		}

		StringBuilder field = new StringBuilder();
		for (int i = 1; i <= Terser.numComponents(source); i++) {
			StringBuilder comp = new StringBuilder();
			for (int j = 1; j <= Terser.numSubComponents(source, i); j++) {
				Primitive p = Terser.getPrimitive(source, i, j);
				comp.append(encodePrimitive(p, parserConfig.getEscaping(), encodingChars));
				comp.append(encodingChars.getSubcomponentSeparator());
			}
			field.append(stripExtraDelimiters(comp.toString(), encodingChars.getSubcomponentSeparator()));
			field.append(encodingChars.getComponentSeparator());
		}

		int forceUpToFieldNum = 0;
		if (parserConfig != null && currentTerserPath != null) {
			for (String nextPath : parserConfig.getForcedEncode()) {
				if (nextPath.startsWith(currentTerserPath + "-") && nextPath.length() > currentTerserPath.length()) {
					int endOfFieldDef = nextPath.indexOf('-', currentTerserPath.length());
					if (endOfFieldDef == -1) {
						forceUpToFieldNum = 0;
						break;
					}
					String fieldNumString = nextPath.substring(endOfFieldDef + 1, nextPath.length());
					if (fieldNumString.length() > 0) {
						forceUpToFieldNum = Math.max(forceUpToFieldNum, Integer.parseInt(fieldNumString));
					}
				}
			}
		}

		char componentSeparator = encodingChars.getComponentSeparator();
		String retVal = stripExtraDelimiters(field.toString(), componentSeparator);

		while (forceUpToFieldNum > 0 && (countInstancesOf(retVal, componentSeparator) + 1) < forceUpToFieldNum) {
			retVal = retVal + componentSeparator;
		}

		return retVal;
	}

	private static String encodePrimitive(Primitive p, Escaping escaping, EncodingCharacters encodingChars) {
		String val = (p).getValue();
		if (val == null) {
			val = "";
		} else {
			val = escaping.escape(val, encodingChars);
		}
		return val;
	}

	/**
	 * Removes unecessary delimiters from the end of a field or segment. This
	 * seems to be more convenient than checking to see if they are needed while
	 * we are building the encoded string.
	 */
	private static String stripExtraDelimiters(String in, char delim) {
		char[] chars = in.toCharArray();

		// search from back end for first occurance of non-delimiter ...
		int c = chars.length - 1;
		boolean found = false;
		while (c >= 0 && !found) {
			if (chars[c--] != delim)
				found = true;
		}

		String ret = "";
		if (found)
			ret = String.valueOf(chars, 0, c + 2);
		return ret;
	}

	/**
	 * Formats a Message object into an HL7 message string using the given
	 * encoding.
	 * 
	 * @throws HL7Exception
	 *             if the data fields in the message do not permit encoding
	 *             (e.g. required fields are null)
	 * @throws EncodingNotSupportedException
	 *             if the requested encoding is not supported by this parser.
	 */
	protected String doEncode(Message source, String encoding) throws HL7Exception {
		if (!this.supportsEncoding(encoding))
			throw new EncodingNotSupportedException("This parser does not support the " + encoding + " encoding");

		return encode(source);
	}

	/**
	 * Formats a Message object into an HL7 message string using this parser's
	 * default encoding ("VB").
	 * 
	 * @throws HL7Exception
	 *             if the data fields in the message do not permit encoding
	 *             (e.g. required fields are null)
	 */
	protected String doEncode(Message source) throws HL7Exception {
		// get encoding characters ...
		Segment msh = (Segment) source.get("MSH");
		String fieldSepString = Terser.get(msh, 1, 0, 1, 1);

		if (fieldSepString == null)
			throw new HL7Exception("Can't encode message: MSH-1 (field separator) is missing");

		char fieldSep = '|';
		if (fieldSepString.length() > 0)
			fieldSep = fieldSepString.charAt(0);

		String encCharString = Terser.get(msh, 2, 0, 1, 1);

		if (encCharString == null)
			throw new HL7Exception("Can't encode message: MSH-2 (encoding characters) is missing");

		if (encCharString.length() != 4)
			throw new HL7Exception("Encoding characters (MSH-2) value '" + encCharString + "' invalid -- must be 4 characters", ErrorCode.DATA_TYPE_ERROR);
		EncodingCharacters en = new EncodingCharacters(fieldSep, encCharString);

		// pass down to group encoding method which will operate recursively on
		// children ...
		return encode(source, en, getParserConfiguration(), "");
	}

	/**
	 * Returns given group serialized as a pipe-encoded string - this method is
	 * called by encode(Message source, String encoding).
     *
     * @param source group to be encoded
     * @param encodingChars encoding characters to be used
     * @throws HL7Exception if an error occurred while encoding
     * @return encoded group
	 */
	public static String encode(Group source, EncodingCharacters encodingChars) throws HL7Exception {
		return encode(source, encodingChars, source.getMessage().getParser().getParserConfiguration(), "");
	}

	/**
	 * Returns given group serialized as a pipe-encoded string - this method is
	 * called by encode(Message source, String encoding).
	 */
	private static String encode(Group source, EncodingCharacters encodingChars, ParserConfiguration parserConfiguration, String currentTerserPath) throws HL7Exception {
		StringBuilder result = new StringBuilder();

		String[] names = source.getNames();

		String firstMandatorySegmentName = null;
		boolean haveEncounteredMandatorySegment = false;
		boolean haveEncounteredContent = false;
		boolean haveHadMandatorySegment = false;
		boolean haveHadSegmentBeforeMandatorySegment = false;

		for (String nextName : names) {

			source.get(nextName, 0);
			Structure[] reps = source.getAll(nextName);
			boolean nextNameIsRequired = source.isRequired(nextName);

			boolean havePreviouslyEncounteredMandatorySegment = haveEncounteredMandatorySegment;
			haveEncounteredMandatorySegment |= nextNameIsRequired;
			if (nextNameIsRequired && !haveHadMandatorySegment) {
				if (!source.isGroup(nextName)) {
					firstMandatorySegmentName = nextName;
				}
			}

			String nextTerserPath = currentTerserPath.length() > 0 ? currentTerserPath + "/" + nextName : nextName;

			// Add all reps of the next segment/group
			for (Structure rep : reps) {

				if (rep instanceof Group) {

					String encodedGroup = encode((Group) rep, encodingChars, parserConfiguration, nextTerserPath);
					result.append(encodedGroup);

					if (encodedGroup.length() > 0) {
						if (!haveHadMandatorySegment && !haveEncounteredMandatorySegment) {
							haveHadSegmentBeforeMandatorySegment = true;
						}
						if (nextNameIsRequired && !haveHadMandatorySegment && !havePreviouslyEncounteredMandatorySegment) {
							haveHadMandatorySegment = true;
						}
						haveEncounteredContent = true;
					}

				} else {

					// Check if we are configured to force the encoding of this
					// segment
					boolean encodeEmptySegments = parserConfiguration.determineForcedEncodeIncludesTerserPath(nextTerserPath);
					String segString = encode((Segment) rep, encodingChars, parserConfiguration, nextTerserPath);
					if (segString.length() >= 4 || encodeEmptySegments) {
						result.append(segString);

						if (segString.length() == 3) {
							result.append(encodingChars.getFieldSeparator());
						}

						result.append(SEGMENT_DELIMITER);

						haveEncounteredContent = true;

						if (nextNameIsRequired) {
							haveHadMandatorySegment = true;
						}

						if (!haveHadMandatorySegment && !haveEncounteredMandatorySegment) {
							haveHadSegmentBeforeMandatorySegment = true;
						}

					}

				}

			}

		}

		if (firstMandatorySegmentName != null && !haveHadMandatorySegment && !haveHadSegmentBeforeMandatorySegment && haveEncounteredContent && parserConfiguration.isEncodeEmptyMandatorySegments()) {
			return firstMandatorySegmentName.substring(0, 3) + encodingChars.getFieldSeparator() + SEGMENT_DELIMITER + result;
		} else {
			return result.toString();
		}
	}

	/**
	 * Convenience factory method which returns an instance that has a new
	 * {@link DefaultHapiContext} initialized with a {@link NoValidation
	 * NoValidation validation context}.
     *
     * @return PipeParser with disabled validation
	 */
	public static PipeParser getInstanceWithNoValidation() {
		HapiContext context = new DefaultHapiContext();
		context.setValidationContext(ValidationContextFactory.noValidation());
		return new PipeParser(context);
	}

    /**
     * Returns given segment serialized as a pipe-encoded string.
     *
     * @param source segment to be encoded
     * @param encodingChars encoding characters to be used
     * @return encoded group
     */
	public static String encode(Segment source, EncodingCharacters encodingChars) {
		return encode(source, encodingChars, null, null);
	}

	private static String encode(Segment source, EncodingCharacters encodingChars, ParserConfiguration parserConfig, String currentTerserPath) {
		StringBuilder result = new StringBuilder();
		result.append(source.getName());
		result.append(encodingChars.getFieldSeparator());

		// start at field 2 for MSH segment because field 1 is the field
		// delimiter
		int startAt = 1;
		if (isDelimDefSegment(source.getName()))
			startAt = 2;

		// loop through fields; for every field delimit any repetitions and add
		// field delimiter after ...
		int numFields = source.numFields();

		int forceUpToFieldNum = 0;
		if (parserConfig != null && currentTerserPath != null) {
			forceUpToFieldNum = parserConfig.determineForcedFieldNumForTerserPath(currentTerserPath);
		}
		numFields = Math.max(numFields, forceUpToFieldNum);

		for (int i = startAt; i <= numFields; i++) {

			String nextFieldTerserPath = currentTerserPath + "-" + i;
			if (parserConfig != null && currentTerserPath != null) {
				for (String nextPath : parserConfig.getForcedEncode()) {
					if (nextPath.startsWith(nextFieldTerserPath + "-")) {
						try {
							source.getField(i, 0);
						} catch (HL7Exception e) {
							log.error("Error while encoding segment: ", e);
						}
					}
				}
			}

			try {
				Type[] reps = source.getField(i);
				for (int j = 0; j < reps.length; j++) {
					String fieldText = encode(reps[j], encodingChars, parserConfig, nextFieldTerserPath);
					// if this is MSH-2, then it shouldn't be escaped, so
					// unescape it again
					if (isDelimDefSegment(source.getName()) && i == 2)
						fieldText = parserConfig.getEscaping().unescape(fieldText, encodingChars);
					result.append(fieldText);
					if (j < reps.length - 1)
						result.append(encodingChars.getRepetitionSeparator());
				}
			} catch (HL7Exception e) {
				log.error("Error while encoding segment: ", e);
			}
			result.append(encodingChars.getFieldSeparator());
		}

		// strip trailing delimiters ...
		char fieldSeparator = encodingChars.getFieldSeparator();
		String retVal = stripExtraDelimiters(result.toString(), fieldSeparator);

		int offset = isDelimDefSegment(source.getName()) ? 1 : 0;
		while (forceUpToFieldNum > 0 && (countInstancesOf(retVal, fieldSeparator) + offset) < forceUpToFieldNum) {
			retVal = retVal + fieldSeparator;
		}

		return retVal;
	}

	private static int countInstancesOf(String theString, char theCharToSearchFor) {
		int retVal = 0;
		for (int i = 0; i < theString.length(); i++) {
			if (theString.charAt(i) == theCharToSearchFor) {
				retVal++;
			}
		}
		return retVal;
	}

	/**
	 * Removes leading whitespace from the given string. This method was created
	 * to deal with frequent problems parsing messages that have been
	 * hand-written in windows. The intuitive way to delimit segments is to hit
	 * <ENTER> at the end of each segment, but this creates both a carriage
	 * return and a line feed, so to the parser, the first character of the next
	 * segment is the line feed.
     *
     * @param in input string
     * @return string with leading whitespaces removed
	 */
	public static String stripLeadingWhitespace(String in) {
		StringBuilder out = new StringBuilder();
		char[] chars = in.toCharArray();
		int c = 0;
		while (c < chars.length) {
			if (!Character.isWhitespace(chars[c]))
				break;
			c++;
		}
		for (int i = c; i < chars.length; i++) {
			out.append(chars[i]);
		}
		return out.toString();
	}

	/**
	 * <p>
	 * Returns a minimal amount of data from a message string, including only
	 * the data needed to send a response to the remote system. This includes
	 * the following fields:
	 * <ul>
	 * <li>field separator</li>
	 * <li>encoding characters</li>
	 * <li>processing ID</li>
	 * <li>message control ID</li>
	 * </ul>
	 * This method is intended for use when there is an error parsing a message,
	 * (so the Message object is unavailable) but an error message must be sent
	 * back to the remote system including some of the information in the
	 * inbound message. This method parses only that required information,
	 * hopefully avoiding the condition that caused the original error. The
	 * other fields in the returned MSH segment are empty.
	 * </p>
	 */
	public Segment getCriticalResponseData(String message) throws HL7Exception {
		// try to get MSH segment
		int locStartMSH = message.indexOf("MSH");
		if (locStartMSH < 0)
			throw new HL7Exception("Couldn't find MSH segment in message: " + message, ErrorCode.SEGMENT_SEQUENCE_ERROR);
		int locEndMSH = message.indexOf('\r', locStartMSH + 1);
		if (locEndMSH < 0)
			locEndMSH = message.length();
		String mshString = message.substring(locStartMSH, locEndMSH);

		// find out what the field separator is
		char fieldSep = mshString.charAt(3);

		// get field array
		String[] fields = split(mshString, String.valueOf(fieldSep));

		try {
			// parse required fields
			String encChars = fields[1];
			char compSep = encChars.charAt(0);
			String messControlID = fields[9];
			String[] procIDComps = split(fields[10], String.valueOf(compSep));

			// fill MSH segment
			String version = null;
			try {
				version = getVersion(message);
			} catch (Exception e) { /* use the default */
			}

			if (version == null) {
				Version availableVersion = Version.highestAvailableVersionOrDefault();
				version = availableVersion.getVersion();
			}

			Segment msh = Parser.makeControlMSH(version, getFactory());
			Terser.set(msh, 1, 0, 1, 1, String.valueOf(fieldSep));
			Terser.set(msh, 2, 0, 1, 1, encChars);
			Terser.set(msh, 10, 0, 1, 1, messControlID);
			Terser.set(msh, 11, 0, 1, 1, procIDComps[0]);
			Terser.set(msh, 12, 0, 1, 1, version);
			return msh;

		} catch (Exception e) {
			throw new HL7Exception("Can't parse critical fields from MSH segment (" + e.getClass().getName() + ": " + e.getMessage() + "): " + mshString, ErrorCode.REQUIRED_FIELD_MISSING, e);
		}

	}

	/**
	 * For response messages, returns the value of MSA-2 (the message ID of the
	 * message sent by the sending system). This value may be needed prior to
	 * main message parsing, so that (particularly in a multi-threaded scenario)
	 * the message can be routed to the thread that sent the request. We need
	 * this information first so that any parse exceptions are thrown to the
	 * correct thread. Returns null if MSA-2 can not be found (e.g. if the
	 * message is not a response message).
	 */
	public String getAckID(String message) {
		String ackID = null;
		int startMSA = message.indexOf("\rMSA");
		if (startMSA >= 0) {
			int startFieldOne = startMSA + 5;
			char fieldDelim = message.charAt(startFieldOne - 1);
			int start = message.indexOf(fieldDelim, startFieldOne) + 1;
			int end = message.indexOf(fieldDelim, start);
			int segEnd = message.indexOf(String.valueOf(SEGMENT_DELIMITER), start);
			if (segEnd > start && segEnd < end)
				end = segEnd;

			// if there is no field delim after MSH-2, need to go to end of
			// message, but not including end seg delim if it exists
			if (end < 0) {
				if (message.charAt(message.length() - 1) == '\r') {
					end = message.length() - 1;
				} else {
					end = message.length();
				}
			}
			if (start > 0 && end > start) {
				ackID = message.substring(start, end);
			}
		}
		log.trace("ACK ID: {}", ackID);
		return ackID;
	}

	/**
	 * Defaults to <code>false</code>
	 * 
	 * @see #isLegacyMode()
	 * @deprecated This will be removed in HAPI 3.0
	 */
	public void setLegacyMode(boolean legacyMode) {
		this.myLegacyMode = legacyMode;
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public String encode(Message source) throws HL7Exception {
		if (myLegacyMode != null && myLegacyMode) {

			@SuppressWarnings("deprecation")
			OldPipeParser oldPipeParser = new OldPipeParser(getFactory());

			return oldPipeParser.encode(source);
		}
		return super.encode(source);
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public Message parse(String message) throws HL7Exception {
		if (myLegacyMode != null && myLegacyMode) {

			@SuppressWarnings("deprecation")
			OldPipeParser oldPipeParser = new OldPipeParser(getFactory());

			return oldPipeParser.parse(message);
		}
		return super.parse(message);
	}

	/**
	 * <p>
	 * Returns <code>true</code> if legacy mode is on.
	 * </p>
	 * <p>
	 * Prior to release 1.0, when an unexpected segment was encountered in a
	 * message, HAPI would recurse to the deepest nesting in the last group it
	 * encountered after the current position in the message, and deposit the
	 * segment there. This could lead to unusual behaviour where all segments
	 * afterward would not be in an expected spot within the message.
	 * </p>
	 * <p>
	 * This should normally be set to false, but any code written before the
	 * release of HAPI 1.0 which depended on this behaviour might need legacy
	 * mode to be set to true.
	 * </p>
	 * <p>
	 * Defaults to <code>false</code>. Note that this method only overrides
	 * behaviour of the {@link #parse(java.lang.String)} and
	 * {@link #encode(ca.uhn.hl7v2.model.Message) } methods
	 * </p>
	 * 
	 * @deprecated This will be removed in HAPI 3.0
	 */
	public boolean isLegacyMode() {
		if (myLegacyMode == null)
			return (Boolean.parseBoolean(System.getProperty(DEFAULT_LEGACY_MODE_PROPERTY)));
		return this.myLegacyMode;
	}

	/**
	 * Returns the version ID (MSH-12) from the given message, without fully
	 * parsing the message. The version is needed prior to parsing in order to
	 * determine the message class into which the text of the message should be
	 * parsed.
	 * 
	 * @throws HL7Exception
	 *             if the version field can not be found.
	 */
	public String getVersion(String message) throws HL7Exception {
		int startMSH = message.indexOf("MSH");
		int endMSH = message.indexOf(PipeParser.SEGMENT_DELIMITER, startMSH);
		if (endMSH < 0)
			endMSH = message.length();
		String msh = message.substring(startMSH, endMSH);
		String fieldSep;
		if (msh.length() > 3) {
			fieldSep = String.valueOf(msh.charAt(3));
		} else {
			throw new HL7Exception("Can't find field separator in MSH: " + msh, ErrorCode.UNSUPPORTED_VERSION_ID);
		}

		String[] fields = split(msh, fieldSep);

		String compSep;
		if (fields.length >= 2 && fields[1] != null && fields[1].length() == 4) {
			compSep = String.valueOf(fields[1].charAt(0)); // get component
															// separator as 1st
															// encoding char
		} else {
			throw new HL7Exception("Invalid or incomplete encoding characters - MSH-2 is " + fields[1], ErrorCode.REQUIRED_FIELD_MISSING);
		}

		String version;
		if (fields.length >= 12) {
			String[] comp = split(fields[11], compSep);
			if (comp.length >= 1) {
				version = comp[0];
			} else {
				throw new HL7Exception("Can't find version ID - MSH.12 is " + fields[11], ErrorCode.REQUIRED_FIELD_MISSING);
			}
		} else if (getParserConfiguration().isAllowUnknownVersions()) {
			return Version.highestAvailableVersionOrDefault().getVersion();
		} else {
			throw new HL7Exception("Can't find version ID - MSH has only " + fields.length + " fields.", ErrorCode.REQUIRED_FIELD_MISSING);
		}
		return version;
	}

	@Override
	public void parse(Message message, String string) throws HL7Exception {
		if (message instanceof AbstractSuperMessage && message.getName() == null) {
			String structure = getStructure(string).messageStructure;
			((AbstractSuperMessage) message).setName(structure);
		}
		
		IStructureDefinition structureDef = getStructureDefinition(message);
		MessageIterator messageIter = new MessageIterator(message, structureDef, "MSH", true);

		String[] segments = split(string, SEGMENT_DELIMITER);

		if (segments.length == 0) {
			throw new HL7Exception("Invalid message content: \"" + string + "\"");
		}

		if (segments[0] == null || segments[0].length() < 4) {
			throw new HL7Exception("Invalid message content: \"" + string + "\"");
		}

		char delim = '|';
		String prevName = null;
		int repNum = 1;
		for (int i = 0; i < segments.length; i++) {

			// get rid of any leading whitespace characters ...
			if (segments[i] != null && segments[i].length() > 0 && Character.isWhitespace(segments[i].charAt(0)))
				segments[i] = stripLeadingWhitespace(segments[i]);

			// sometimes people put extra segment delimiters at end of msg ...
			if (segments[i] != null && segments[i].length() >= 3) {

				final String name;
				if (i == 0) {
					if (segments[i].length() < 4) {
						throw new HL7Exception("Invalid message content: \"" + string + "\"");
					}
					name = segments[i].substring(0, 3);
					delim = segments[i].charAt(3);
				} else {
					if (segments[i].indexOf(delim) >= 0) {
						name = segments[i].substring(0, segments[i].indexOf(delim));
					} else {
						name = segments[i];
					}
				}

				log.trace("Parsing segment {}", name);

				if (name.equals(prevName)) {
					repNum++;
				} else {
					repNum = 1;
					prevName = name;
				}

				messageIter.setDirection(name);

				try {
					if (messageIter.hasNext()) {
						Segment next = (Segment) messageIter.next();
						parse(next, segments[i], getEncodingChars(string), repNum);
					}
				} catch (Error e) {
					if (e.getCause() instanceof HL7Exception) {
						throw (HL7Exception)e.getCause();
					}
					throw e;
				}
			}
		}
		
		applySuperStructureName(message);
	}

	/**
	 * A struct for holding a message class string and a boolean indicating
	 * whether it was defined explicitly.
	 */
	private static class MessageStructure {
		public String messageStructure;
		public boolean explicitlyDefined;

		public MessageStructure(String theMessageStructure, boolean isExplicitlyDefined) {
			messageStructure = theMessageStructure;
			explicitlyDefined = isExplicitlyDefined;
		}
	}

	private static class Holder<T> {
		private T myObject;

		public T getObject() {
			return myObject;
		}

		public void setObject(T theObject) {
			myObject = theObject;
		}
	}

}
