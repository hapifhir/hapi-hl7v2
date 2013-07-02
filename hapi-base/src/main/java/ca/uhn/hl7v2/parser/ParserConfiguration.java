package ca.uhn.hl7v2.parser;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.GenericMessage;
import ca.uhn.hl7v2.model.Varies;
import ca.uhn.hl7v2.util.Terser;
import ca.uhn.hl7v2.util.idgenerator.FileBasedHiLoGenerator;
import ca.uhn.hl7v2.util.idgenerator.IDGenerator;
import ca.uhn.hl7v2.validation.ValidationContext;

/**
 * Contains configuration which will be applied to any parsers which are a part of the given
 * HAPI Context.
 * 
 * @see HapiContext#getParserConfiguration()
 */
public class ParserConfiguration {

	/**
	 * @link {@link UnexpectedSegmentBehaviourEnum#ADD_INLINE}
	 */
	// NB if you change the default, edit the javadoc for the enum itself
	public static final UnexpectedSegmentBehaviourEnum DEFAULT_UNEXPECTED_SEGMENT_BEHAVIOUR = UnexpectedSegmentBehaviourEnum.ADD_INLINE;

	private boolean allowUnknownVersions;
	private boolean escapeSubcomponentDelimiterInPrimitive = false;
	private IDGenerator idGenerator = new FileBasedHiLoGenerator();
	private String myDefaultObx2Type;
	private boolean myEncodeEmptyMandatorySegments = true;
	private Set<String> myForcedEncode = new HashSet<String>();
	private String myInvalidObx2Type;
	private UnexpectedSegmentBehaviourEnum myUnexpectedSegmentBehaviour;
	private boolean nonGreedyMode = false;
	private boolean prettyPrintWhenEncodingXml = true;
	private boolean validating = true;

	/**
	 * <p>
	 * Forces the parser to encode certain segments/fields, even if they contain
	 * no content. This method may be called multiple times with multiple path
	 * definitions, and each path definition contains the path to the segment or
	 * field which needs to be forced.
	 * </p>
	 * <p>
	 * Path definitions are similar in format to {@link Terser Terser} paths.
	 * They contain a slash-separated lookup path to reach a given segment, and
	 * optionally a field number. The following are examples of paths which
	 * could be added here, as well as the sample output for an otherwise empty
	 * ORU^R01 message:
	 * </p>
	 * <table cellpadding="2" cellspacing="2" border="0">
	 * <thead>
	 * <tr>
	 * <th style="background: #FFA0FF;">Forced Encode Path</th>
	 * <th style="background: #FFA0FF;">Encode Output</th>
	 * </tr>
	 * </thead>
	 * <tr>
	 * <td>None (for illustration purposes)</td>
	 * <td style=" font-family: monospace;">
	 * MSH|^~\&amp;|||||||ORU^R01^ORU_R01||T|2.4</td>
	 * </tr>
	 * <tr>
	 * <td style="background: #E0E0E0;">PATIENT_RESULT/ORDER_OBSERVATION/ORC</td>
	 * <td style="background: #E0E0E0; font-family: monospace;">
	 * MSH|^~\&amp;|||||||ORU^R01^ORU_R01||T|2.4<br>
	 * ORC|</td>
	 * </tr>
	 * <tr>
	 * <td>PATIENT_RESULT/ORDER_OBSERVATION/ORC-4</td>
	 * <td style=" font-family: monospace;">
	 * MSH|^~\&amp;|||||||ORU^R01^ORU_R01||T|2.4<br>
	 * ORC||||</td>
	 * </tr>
	 * <tr>
	 * <td style="background: #E0E0E0;">PATIENT_RESULT/ORDER_OBSERVATION/ORC-4-2
	 * </td>
	 * <td style="background: #E0E0E0; font-family: monospace;">
	 * MSH|^~\&amp;|||||||ORU^R01^ORU_R01||T|2.4<br>
	 * ORC||||^</td>
	 * </tr>
	 * </table>
	 * <p>
	 * While empty segments do not generally have any meaning according to HL7,
	 * this may be useful when transmitting to systems which rely on segments
	 * being received even if they have no content.
	 * </p>
	 * <p>
	 * Note that this configuration item currently only applies to
	 * {@link PipeParser}
	 * </p>
	 *
     * @param theForcedEncode path definition
	 * @since 2.0
	 */
	public void addForcedEncode(String theForcedEncode) {
		if (theForcedEncode == null) {
			throw new NullPointerException("forced encode may not be null");
		}

		int lastSlashIndex = theForcedEncode.lastIndexOf('/');
		lastSlashIndex = Math.max(lastSlashIndex, 0);

		if (lastSlashIndex == 0) {
			if (!theForcedEncode.matches("[A-Z0-9]{3}(-[0-9]+){0,2}$")) {
				throw new IllegalArgumentException("Definition must end with a segment name or field lookup, e.g. MSH or MSH-2");
			}
		} else {
			if (lastSlashIndex == theForcedEncode.length() || !theForcedEncode.substring(lastSlashIndex + 1).matches("[A-Z0-9]{3}(-[0-9]+){0,2}$")) {
				throw new IllegalArgumentException("Definition must end with a segment name or field lookup, e.g. MSH or MSH-2");
			}
		}
		myForcedEncode.add(theForcedEncode);
	}

	boolean determineForcedEncodeIncludesTerserPath(String theTerserPath) {
		for (String next : getForcedEncode()) {
			if (next.startsWith(theTerserPath)) {
				return true;
			}
		}
		return false;
	}

	int determineForcedFieldNumForTerserPath(String theCurrentTerserPath) {
		int forceUpToFieldNum = 0;
		for (String nextPath : getForcedEncode()) {
			if (nextPath.startsWith(theCurrentTerserPath) && nextPath.length() > theCurrentTerserPath.length()) {
				int endOfFieldDef = nextPath.indexOf('-', theCurrentTerserPath.length() + 1);
				if (endOfFieldDef == -1) {
					endOfFieldDef = nextPath.length();
				}
				String fieldNumString = nextPath.substring(theCurrentTerserPath.length() + 1, endOfFieldDef);
				forceUpToFieldNum = Math.max(forceUpToFieldNum, Integer.parseInt(fieldNumString));
			}
		}
		return forceUpToFieldNum;
	}

	/**
	 * Returns the default datatype ("ST", "NM", etc) for an OBX segment with a
	 * missing OBX-2 value
	 * 
	 * @return Returns the default datatype ("ST", "NM", etc) for an OBX segment
	 *         with a missing OBX-2 value
	 * @see #setDefaultObx2Type(String)
	 */
	public String getDefaultObx2Type() {
		return myDefaultObx2Type;
	}

	/**
	 * @return Returns the forced encode strings added by
	 *         {@link #addForcedEncode(String)}
	 * 
	 * @see #addForcedEncode(String)
	 * @since 1.3
	 */
	public Set<String> getForcedEncode() {
		return Collections.unmodifiableSet(myForcedEncode);
	}

	/**
	 * @return the ID Generator to be used for generating IDs for new messages
	 */
	public IDGenerator getIdGenerator() {
		return idGenerator;
	}

	/**
	 * Returns the value provides a default datatype ("ST", "NM", etc) for an
	 * OBX segment with an invalid OBX-2 value.
	 * 
	 * @return Returns the value provides a default datatype ("ST", "NM", etc)
	 *         for an OBX segment with an invalid OBX-2 value.
	 * @see #setInvalidObx2Type(String)
	 */
	public String getInvalidObx2Type() {
		return myInvalidObx2Type;
	}

	/**
	 * Returns the behaviour to use when parsing a message and a nonstandard
	 * segment is found. Default is
	 * {@link #DEFAULT_UNEXPECTED_SEGMENT_BEHAVIOUR}
     *
     * @return the behaviour to use when a nonstandard egment is found
	 */
	public UnexpectedSegmentBehaviourEnum getUnexpectedSegmentBehaviour() {
		if (myUnexpectedSegmentBehaviour == null) {
			myUnexpectedSegmentBehaviour = DEFAULT_UNEXPECTED_SEGMENT_BEHAVIOUR;
		}
		return myUnexpectedSegmentBehaviour;
	}

	/**
	 * If set to <code>true</code> (default is <code>false</code>) the parser
	 * will allow messages to parse, even if they contain a version which is not
	 * known to the parser. When operating in this mode, if a message arrives
	 * with an unknown version string, the parser will attempt to parse it using
	 * a {@link GenericMessage Generic Message} class instead of a specific HAPI
	 * structure class. Default is <code>false</code>.
     *
     * @return true if parsing messages with unknown versions is allowed
	 */
	public boolean isAllowUnknownVersions() {
		return this.allowUnknownVersions;
	}

	/**
     * Returns <code>true</code> if empty segments should still be encoded
     * if they are mandatory within their message structure.  Default is <code>false</code>.
	 * @return <code>true</code> if empty segments should still be encoded
     *
	 * @see #setEncodeEmptyMandatoryFirstSegments(boolean)
	 */
	public boolean isEncodeEmptyMandatorySegments() {
		return myEncodeEmptyMandatorySegments;
	}

	/**
     * Returns code>true</code> if subcomponent delimiters in OBX-5 shall be
     *         ignored. Default is <code>false</code>.
	 * @return <code>true</code> if subcomponent delimiters in OBX-5 shall be
	 *         ignored
	 */
	public boolean isEscapeSubcomponentDelimiterInPrimitive() {
		return escapeSubcomponentDelimiterInPrimitive;
	}

	/**
	 * Returns <code>true</code> if the parser should parse in non-greedy mode. Default
	 * is <code>false</code>
	 * 
	 * @see #setNonGreedyMode(boolean) for an explanation of non-greedy mode
	 */
	public boolean isNonGreedyMode() {
		return nonGreedyMode;
	}

	/**
	 * If set to <code>true</code> (which is the default), {@link XMLParser XML Parsers}
	 * will attempt to pretty-print the XML they generate. This means the messages will look
	 * nicer to humans, but may take up slightly more space/bandwidth.
	 */
	public boolean isPrettyPrintWhenEncodingXml() {
		return prettyPrintWhenEncodingXml;
	}

	/**
     * Returns <code>true</code> if the parser validates using a configured
     *         {@link ValidationContext}. Default is <code>true</code>.
	 * @return <code>true</code> if the parser validates using a configured
	 *         {@link ValidationContext}
	 */
	public boolean isValidating() {
		return validating;
	}

	/**
	 * Removes a forced encode entry
	 *
     * @param theForcedEncode path definition to be removed
	 * @see #addForcedEncode(String)
	 * @since 1.3
	 */
	public void removeForcedEncode(String theForcedEncode) {
		if (theForcedEncode == null) {
			throw new NullPointerException("forced encode may not be null");
		}

		myForcedEncode.remove(theForcedEncode);
	}

	/**
	 * If set to <code>true</code> (default is <code>false</code>) the parser
	 * will allow messages to parse, even if they contain a version which is not
	 * known to the parser. When operating in this mode, if a message arrives
	 * with an unknown version string, the parser will attempt to parse it using
	 * a {@link GenericMessage Generic Message} class instead of a specific HAPI
	 * structure class.
     *
     * @param theAllowUnknownVersions true if parsing unknown versions shall be allowed
	 */
	public void setAllowUnknownVersions(boolean theAllowUnknownVersions) {
		allowUnknownVersions = theAllowUnknownVersions;
	}

	/**
	 * <p>
	 * If this property is set, the value provides a default datatype ("ST",
	 * "NM", etc) for an OBX segment with a missing OBX-2 value. This is useful
	 * when parsing messages from systems which do not correctly populate OBX-2.
	 * </p>
	 * <p>
	 * For example, if this property is set to "ST", and the following OBX
	 * segment is encountered:
	 * 
	 * <pre>
	 * OBX|||||This is a value
	 * </pre>
	 * 
	 * It will be parsed as though it had read:
	 * 
	 * <pre>
	 * OBX||ST|||This is a value
	 * </pre>
	 * 
	 * </p>
	 * <p>
	 * Note that this configuration can also be set globally using the system
	 * property {@link Varies#DEFAULT_OBX2_TYPE_PROP}, but any value provided to
	 * {@link ParserConfiguration} takes priority over the system property.
	 * </p>
	 * 
	 * @param theDefaultObx2Type
	 *            If this property is set, the value provides a default datatype
	 *            ("ST", "NM", etc) for an OBX segment with a missing OBX-2
	 *            value
	 * @see #setInvalidObx2Type(String)
	 * @see Varies#INVALID_OBX2_TYPE_PROP
	 */
	public void setDefaultObx2Type(String theDefaultObx2Type) {
		myDefaultObx2Type = theDefaultObx2Type;
	}

	/**
	 * <p>
	 * If set to <code>true</code> (default is <code>true</code>), when encoding
	 * a group using the PipeParser where the first segment is required, but no
	 * data has been populated in that segment, the empty segment is now still
	 * encoded if needed as a blank segment in order to give parsers a hint
	 * about which group subsequent segments are in. This helps to ensure that
	 * messages can be "round tripped", meaning that a message which is parsed,
	 * encoded, and then re-parsed should contain exactly the same structure
	 * from beginning to end.
	 * </p>
	 * <p>
	 * </p>
	 * For example, in an ORU^R01 message with a populated OBX segment, but no
	 * data in the mandatory OBR segment which begins the ORDER_OBSERVATION
	 * group the message would still contain an empty OBR segment when encoded:
	 * 
	 * <pre>
	 * 	MSH|^~\&|REG|W|||201103230042||ORU^R01|32153168|P|2.5
	 * 	OBR|
	 * 	OBX||ST|||Value Data
	 * </pre>
	 * 
	 * Previously, the following encoding would have occurred, which would have
	 * incorrectly been parsed as having a custom OBX segment instead of having
	 * a normal ORDER_OBSERVATION group:
	 * 
	 * <pre>
	 * 	MSH|^~\&|REG|W|||201103230042||ORU^R01|32153168|P|2.5
	 * 	OBX||ST|||Value Data
	 * </pre>
	 * 
	 * @param theEncodeEmptyMandatorySegments
	 *            If set to <code>true</code> (default is <code>true</code>),
	 *            when encoding a group using the PipeParser where the first
	 *            segment is required, but no data has been populated in that
	 *            segment, the empty segment is now still encoded if needed as a
	 *            blank segment in order to give parsers a hint about which
	 *            group subsequent segments are in
	 */
	public void setEncodeEmptyMandatoryFirstSegments(boolean theEncodeEmptyMandatorySegments) {
		myEncodeEmptyMandatorySegments = theEncodeEmptyMandatorySegments;
	}

	/**
	 * Set to <code>true</code> if subcomponent delimiters in OBX-5 shall be
	 * ignored
     * @param escapeSubcomponentDelimiterInPrimitive boolean flag to enable or disable this behavior
	 */
	public void setEscapeSubcomponentDelimiterInPrimitive(boolean escapeSubcomponentDelimiterInPrimitive) {
		this.escapeSubcomponentDelimiterInPrimitive = escapeSubcomponentDelimiterInPrimitive;
	}

	/**
	 * @param idGenerator
	 *            the {@link IDGenerator} to be used for generating IDs for new
	 *            messages, preferable initialized using the methods described
	 *            in IDGeneratorFactory.
	 * 
	 * @see IDGenerator
	 */
	public void setIdGenerator(IDGenerator idGenerator) {
		this.idGenerator = idGenerator;
	}

	/**
	 * <p>
	 * If this property is set, the value provides a default datatype ("ST",
	 * "NM", etc) for an OBX segment with an invalid OBX-2 value. This is useful
	 * when parsing messages from systems which do not correctly populate OBX-2.
	 * </p>
	 * <p>
	 * For example, if this property is set to "ST", and the following OBX
	 * segment is encountered:
	 * 
	 * <pre>
	 * OBX||INVALID|||This is a value
	 * </pre>
	 * 
	 * It will be parsed as though it had read:
	 * 
	 * <pre>
	 * OBX||ST|||This is a value
	 * </pre>
	 * 
	 * </p>
	 * <p>
	 * Note that this configuration can also be set globally using the system
	 * property {@link Varies#INVALID_OBX2_TYPE_PROP}, but any value provided to
	 * {@link ParserConfiguration} takes priority over the system property.
	 * </p>
	 * 
	 * @param theInvalidObx2Type
	 *            If this property is set, the value provides a default datatype
	 *            ("ST", "NM", etc) for an OBX segment with an invalid OBX-2
	 *            value. This is useful when parsing messages from systems which
	 *            do not correctly populate OBX-2.
	 * @see ParserConfiguration#setDefaultObx2Type(String)
	 * @see Varies#DEFAULT_OBX2_TYPE_PROP
	 */
	public void setInvalidObx2Type(String theInvalidObx2Type) {
		myInvalidObx2Type = theInvalidObx2Type;
	}

	/**
	 * If set to <code>true</code> (default is <code>false</code>), pipe parser will be
	 * put in non-greedy mode. This setting applies only to {@link PipeParser Pipe Parsers} and
	 * will have no effect on {@link XMLParser XML Parsers}.
	 * 
	 * <p>
	 * In non-greedy mode, if the message structure being parsed has an ambiguous
	 * choice of where to put a segment because there is a segment matching the
	 * current segment name in both a later position in the message, and
	 * in an earlier position as a part of a repeating group, the earlier
	 * position will be chosen.
	 * </p>
	 * <p>
	 * This is perhaps best explained with an example. Consider the following structure:
	 * </p>
	 * <pre>
	 * MSH
	 * GROUP_1 (start)
	 * {
	 *    AAA
	 *    BBB
	 *    GROUP_2 (start)
	 *    {
	 *       AAA
	 *    }
	 *    GROUP_2 (end)
	 * }
	 * GROUP_1 (end)
	 * </pre>
	 * <p>
	 * </p>
	 * For the above example, consider a message containing the following segments:<br/>
	 * <code>MSH<br/>
	 * AAA<br/>
	 * BBB<br/>
	 * AAA</code>
	 * </p>
	 * <p>
	 * In this example, when the second AAA segment is encountered, there are two
	 * possible choices. It would be placed in GROUP_2, or it could be placed in 
	 * a second repetition of GROUP_1. By default it will be placed in GROUP_2, but
	 * in non-greedy mode it will be put in a new repetition of GROUP_1.
	 * </p>
	 * <p>
	 * This mode is useful for example when parsing OML^O21 messages containing
	 * multiple orders.
	 * </p>
	 */
	public void setNonGreedyMode(boolean theNonGreedyMode) {
		nonGreedyMode = theNonGreedyMode;
	}

	/**
	 * If set to <code>true</code> (which is the default), {@link XMLParser XML Parsers}
	 * will attempt to pretty-print the XML they generate. This means the messages will look
	 * nicer to humans, but may take up slightly more space/bandwidth.
	 */
	public void setPrettyPrintWhenEncodingXml(boolean thePrettyPrintWhenEncodingXml) {
		prettyPrintWhenEncodingXml = thePrettyPrintWhenEncodingXml;
	}

	/**
	 * Sets the behaviour to use when parsing a message and a nonstandard
	 * segment is found
     *
     * @param theUnexpectedSegmentBehaviour behaviour to use when a nonstandard segment is found
     */
	public void setUnexpectedSegmentBehaviour(UnexpectedSegmentBehaviourEnum theUnexpectedSegmentBehaviour) {
		if (theUnexpectedSegmentBehaviour == null) {
			throw new NullPointerException("UnexpectedSegmentBehaviour can not be null");
		}
		myUnexpectedSegmentBehaviour = theUnexpectedSegmentBehaviour;
	}

	/**
	 * Determines whether the parser validates using a configured
	 * {@link ValidationContext} or not. This allows to disable message
	 * validation although a validation context is defined.
	 * 
	 * @param validating
	 *            <code>true</code> if parser shall validate, <code>false</code>
	 *            if not
	 */
	public void setValidating(boolean validating) {
		this.validating = validating;
	}

}
