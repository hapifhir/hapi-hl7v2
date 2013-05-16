/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "DefaultValidator.java".  Description: 
"A default conformance validator." 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2003.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  �GPL�), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

 */

package ca.uhn.hl7v2.conf.check;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.HapiContextSupport;
import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.hl7v2.conf.parser.ProfileParser;
import ca.uhn.hl7v2.conf.spec.RuntimeProfile;
import ca.uhn.hl7v2.conf.spec.message.AbstractComponent;
import ca.uhn.hl7v2.conf.spec.message.AbstractSegmentContainer;
import ca.uhn.hl7v2.conf.spec.message.Component;
import ca.uhn.hl7v2.conf.spec.message.Field;
import ca.uhn.hl7v2.conf.spec.message.ProfileStructure;
import ca.uhn.hl7v2.conf.spec.message.Seg;
import ca.uhn.hl7v2.conf.spec.message.SegGroup;
import ca.uhn.hl7v2.conf.spec.message.StaticDef;
import ca.uhn.hl7v2.conf.spec.message.SubComponent;
import ca.uhn.hl7v2.conf.store.CodeStore;
import ca.uhn.hl7v2.conf.store.ProfileStoreFactory;
import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Primitive;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Structure;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.parser.EncodingCharacters;
import ca.uhn.hl7v2.parser.GenericParser;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.util.Terser;

/**
 * A default conformance profile validator.
 * 
 * Note: this class is currently NOT thread-safe!
 * 
 * @author Bryan Tripp
 */
public class DefaultValidator extends HapiContextSupport implements Validator {

	private EncodingCharacters enc; // used to check for content in parts of a message
	private static final Logger log = LoggerFactory.getLogger(DefaultValidator.class);
	private boolean validateChildren = true;
	private CodeStore codeStore;

	/** Creates a new instance of DefaultValidator */
	public DefaultValidator() {
	    this(new DefaultHapiContext());
	}
	
    public DefaultValidator(HapiContext context) {
        super(context);
        enc = new EncodingCharacters('|', null); // the | is assumed later -- don't change
    }	

	/**
	 * If set to false (default is true), each testXX and validateXX method will only test the
	 * direct object it is responsible for, not its children.
	 */
	public void setValidateChildren(boolean validateChildren) {
		this.validateChildren = validateChildren;
	}

	/**
	 * <p>
	 * Provides a code store to use to provide the code tables which will be used to validate coded
	 * value types. If a code store has not been set (which is the default),
	 * {@link ProfileStoreFactory} will be checked for an appropriate code store, and if none is
	 * found then coded values will not be validated.
	 * </p>
	 */
	public void setCodeStore(CodeStore theCodeStore) {
		codeStore = theCodeStore;
	}

	/**
	 * @see Validator#validate
	 */
	public HL7Exception[] validate(Message message, StaticDef profile) throws ProfileException,
			HL7Exception {
		List<HL7Exception> exList = new ArrayList<HL7Exception>();
		Terser t = new Terser(message);

        checkMessageType(t.get("/MSH-9-1"), profile, exList);
        checkEventType(t.get("/MSH-9-2"), profile, exList);
        checkMessageStructure(t.get("/MSH-9-3"), profile, exList);

        exList.addAll(doTestGroup(message, profile, profile.getIdentifier(),
				validateChildren));
		return exList.toArray(new HL7Exception[exList.size()]);
	}


    protected void checkEventType(String evType, StaticDef profile, List<HL7Exception> exList) throws HL7Exception {
        if (!evType.equals(profile.getEventType())
                && !profile.getEventType().equalsIgnoreCase("ALL")) {
            HL7Exception e = new ProfileNotFollowedException("Event type " + evType
                    + " doesn't match profile type of " + profile.getEventType());
            exList.add(e);
        }
    }

    protected void checkMessageType(String msgType, StaticDef profile, List<HL7Exception> exList) throws HL7Exception {
        if (!msgType.equals(profile.getMsgType())) {
            HL7Exception e = new ProfileNotFollowedException("Message type " + msgType
                    + " doesn't match profile type of " + profile.getMsgType());
            exList.add(e);
        }
    }

    protected void checkMessageStructure(String msgStruct, StaticDef profile, List<HL7Exception> exList) {
        if (msgStruct == null || !msgStruct.equals(profile.getMsgStructID())) {
            HL7Exception e = new ProfileNotFollowedException("Message structure " + msgStruct
                    + " doesn't match profile type of " + profile.getMsgStructID());
            exList.add(e);
        }
    }

	/**
	 * Tests a group against a group section of a profile.
	 */
	public List<HL7Exception> testGroup(Group group, SegGroup profile, String profileID)
			throws ProfileException {
		return doTestGroup(group, profile, profileID, true);
	}

	protected List<HL7Exception> doTestGroup(Group group, AbstractSegmentContainer profile,
			String profileID, boolean theValidateChildren) throws ProfileException {
		List<HL7Exception> exList = new ArrayList<HL7Exception>();
		List<String> allowedStructures = new ArrayList<String>();

		for (ProfileStructure struct : profile) {

			// only test a structure in detail if it isn't X
			if (!struct.getUsage().equalsIgnoreCase("X")) {
				allowedStructures.add(struct.getName());

				// see which instances have content
				try {
					List<Structure> instancesWithContent = new ArrayList<Structure>();
					for (Structure instance : group.getAll(struct.getName())) {
						if (!instance.isEmpty())
							instancesWithContent.add(instance);
					}

					testCardinality(instancesWithContent.size(), struct.getMin(),
							struct.getMax(), struct.getUsage(), struct.getName(), exList);

					// test children on instances with content
					if (theValidateChildren) {
						for (Structure s : instancesWithContent) {
                            exList.addAll(testStructure(s, struct, profileID));
						}
					}

				} catch (HL7Exception he) {
					exList.add(new ProfileNotHL7CompliantException(struct.getName()
							+ " not found in message"));
				}
			}
		}

		// complain about X structures that have content
       checkForExtraStructures(group, allowedStructures, exList);

		return exList;
	}

	/**
	 * Checks a group's children against a list of allowed structures for the group (ie those
	 * mentioned in the profile with usage other than X). Returns a list of exceptions representing
	 * structures that appear in the message but are not supposed to.
	 */
	protected void checkForExtraStructures(Group group, List<String> allowedStructures, List<HL7Exception> exList)
			throws ProfileException {
		for (String childName : group.getNames()) {
			if (!allowedStructures.contains(childName)) {
				try {
					for (Structure rep : group.getAll(childName)) {
						if (!rep.isEmpty()) {
							HL7Exception e = new XElementPresentException("The structure "
									+ childName + " appears in the message but not in the profile");
							exList.add(e);
						}
					}
				} catch (HL7Exception he) {
					throw new ProfileException("Problem checking profile", he);
				}
			}
		}
	}

	/**
	 * Checks cardinality and creates an appropriate exception if out of bounds. The usage code is
	 * needed because if min cardinality is > 0, the min # of reps is only required if the usage
	 * code is 'R' (see HL7 v2.5 section 2.12.6.4).
	 * 
	 * @param reps the number of reps
	 * @param min the minimum number of reps
	 * @param max the maximum number of reps (-1 means *)
	 * @param usage the usage code
	 * @param name the name of the repeating structure (used in exception msg)
	 * @return null if cardinality OK, exception otherwise
	 */
	protected HL7Exception testCardinality(int reps, int min, int max, String usage, String name, List<HL7Exception> exList) {
		HL7Exception e = null;
		if (reps < min && usage.equalsIgnoreCase("R")) {
            e = new ProfileNotFollowedException(name + " must have at least " + min
					+ " repetitions (has " + reps + ")");
		} else if (max > 0 && reps > max) {
            e = new ProfileNotFollowedException(name + " must have no more than " + max
					+ " repetitions (has " + reps + ")");
		}
        if (e != null) exList.add(e);
        return e;
	}

	/**
	 * Tests a structure (segment or group) against the corresponding part of a profile.
	 */
	public List<HL7Exception> testStructure(Structure s, ProfileStructure profile, String profileID)
			throws ProfileException {
		List<HL7Exception> exList = new ArrayList<HL7Exception>();
		if (profile instanceof Seg) {
			if (Segment.class.isAssignableFrom(s.getClass())) {
				exList.addAll(doTestSegment((Segment) s, (Seg) profile, profileID, validateChildren));
			} else {
				exList.add(new ProfileNotHL7CompliantException(
						"Mismatch between a segment in the profile and the structure "
								+ s.getClass().getName() + " in the message"));
			}
		} else if (profile instanceof SegGroup) {
			if (Group.class.isAssignableFrom(s.getClass())) {
                exList.addAll(testGroup((Group) s, (SegGroup) profile, profileID));
			} else {
				exList.add(new ProfileNotHL7CompliantException(
						"Mismatch between a group in the profile and the structure "
								+ s.getClass().getName() + " in the message"));
			}
		}
		return exList;
	}

	/**
	 * Tests a segment against a segment section of a profile.
	 */
	public List<HL7Exception> testSegment(ca.uhn.hl7v2.model.Segment segment, Seg profile,
			String profileID) throws ProfileException {
		return doTestSegment(segment, profile, profileID, true);
	}

	protected List<HL7Exception> doTestSegment(ca.uhn.hl7v2.model.Segment segment, Seg profile,
			String profileID, boolean theValidateChildren) throws ProfileException {
		List<HL7Exception> exList = new ArrayList<HL7Exception>();
		List<Integer> allowedFields = new ArrayList<Integer>();

		for (int i = 1; i <= profile.getFields(); i++) {
			Field field = profile.getField(i);

			// only test a field in detail if it isn't X
			if (!field.getUsage().equalsIgnoreCase("X")) {
				allowedFields.add(i);

				// see which instances have content
				try {
					Type[] instances = segment.getField(i);
					List<Type> instancesWithContent = new ArrayList<Type>();
					for (Type instance : instances) {
						if (!instance.isEmpty())
							instancesWithContent.add(instance);
					}

					HL7Exception ce = testCardinality(instancesWithContent.size(), field.getMin(),
							field.getMax(), field.getUsage(), field.getName(), exList);
					if (ce != null) {
						ce.setFieldPosition(i);
					}

					// test field instances with content
					if (theValidateChildren) {
						for (Type s : instancesWithContent) {
							// escape field value when checking length
                            boolean escape = !(profile.getName().equalsIgnoreCase("MSH") && i < 3);
                            List<HL7Exception> childExceptions = doTestField(s, field, escape,
									profileID, validateChildren);
							for (HL7Exception ex : childExceptions) {
                                ex.setFieldPosition(i);
							}
                            exList.addAll(childExceptions);
						}
					}

				} catch (HL7Exception he) {
					exList.add(new ProfileNotHL7CompliantException("Field " + i
							+ " not found in message"));
				}
			}

		}

		// complain about X fields with content
		checkForExtraFields(segment, allowedFields, exList);

		for (HL7Exception ex : exList) {
            ex.setSegmentName(profile.getName());
		}
		return exList;
	}

	/**
	 * Checks a segment against a list of allowed fields (ie those mentioned in the profile with
	 * usage other than X). Returns a list of exceptions representing field that appear but are not
	 * supposed to.
	 * 
	 * @param allowedFields an array of Integers containing field #s of allowed fields
	 */
	protected void checkForExtraFields(Segment segment, List<Integer> allowedFields, List<HL7Exception> exList)
			throws ProfileException {
		for (int i = 1; i <= segment.numFields(); i++) {
			if (!allowedFields.contains(i)) {
				try {
					Type[] reps = segment.getField(i);
					for (Type rep : reps) {
						if (!rep.isEmpty()) {
							HL7Exception e = new XElementPresentException("Field " + i + " in "
									+ segment.getName()
									+ " appears in the message but not in the profile");
							exList.add(e);
						}
					}
				} catch (HL7Exception he) {
					throw new ProfileException("Problem testing against profile", he);
				}
			}
		}
	}

	/**
	 * Tests a Type against the corresponding section of a profile.
	 * 
	 * @param encoded optional encoded form of type (if you want to specify this -- if null, default
	 *            pipe-encoded form is used to check length and constant val)
	 */
	public List<HL7Exception> testType(Type type, AbstractComponent<?> profile, String encoded,
			String profileID) {
		List<HL7Exception> exList = new ArrayList<HL7Exception>();
		if (encoded == null)
			encoded = PipeParser.encode(type, this.enc);

		testUsage(encoded, profile.getUsage(), profile.getName(), exList);

		if (!profile.getUsage().equals("X")) {
            checkDataType(profile.getDatatype(), type, exList);
            checkLength(profile.getLength(), profile.getName(), encoded, exList);
            checkConstantValue(profile.getConstantValue(), encoded, exList);

            testTypeAgainstTable(type, profile, profileID, exList);
		}

		return exList;
	}

    protected void checkConstantValue(String value, String encoded, List<HL7Exception> exList) {
        // check constant value
        if (value != null && value.length() > 0) {
            if (!encoded.equals(value))
                exList.add(new ProfileNotFollowedException("'" + encoded
                        + "' doesn't equal constant value of '" + value + "'"));
        }
    }

    protected void checkLength(long length, String name, String encoded, List<HL7Exception> exList) {
        // check length
        if (encoded.length() > length)
            exList.add(new ProfileNotFollowedException("The type " + name
                    + " has length " + encoded.length() + " which exceeds max of "
                    + length));
    }

    protected void checkDataType(String dataType, Type type, List<HL7Exception> exList) {
        // check datatype
        String typeName = type.getName();
        if (!typeName.equals(dataType)) {
            exList.add(new ProfileNotHL7CompliantException("HL7 datatype " + typeName
                    + " doesn't match profile datatype " + dataType));
        }
    }

    /**
	 * Tests whether the given type falls within a maximum length.
	 * 
	 * @return null of OK, an HL7Exception otherwise
	 */
	public HL7Exception testLength(Type type, int maxLength) {
		HL7Exception e = null;
		String encoded = PipeParser.encode(type, this.enc);
		if (encoded.length() > maxLength) {
			e = new ProfileNotFollowedException("Length of " + encoded.length()
					+ " exceeds maximum of " + maxLength);
		}
		return e;
	}

	/**
	 * Tests an element against the corresponding usage code. The element is required in its encoded
	 * form.
	 * 
	 * @param encoded the pipe-encoded message element
	 * @param usage the usage code (e.g. "CE")
	 * @param name the name of the element (for use in exception messages)
	 * @return null if there is no problem, an HL7Exception otherwise
	 */
	protected void testUsage(String encoded, String usage, String name, List<HL7Exception> exList) {
		if (usage.equalsIgnoreCase("R")) {
			if (encoded.length() == 0)
				exList.add(new ProfileNotFollowedException("Required element " + name + " is missing"));
		} else if (usage.equalsIgnoreCase("RE")) {
			// can't test anything
		} else if (usage.equalsIgnoreCase("O")) {
			// can't test anything
		} else if (usage.equalsIgnoreCase("C")) {
			// can't test anything yet -- wait for condition syntax in v2.6
		} else if (usage.equalsIgnoreCase("CE")) {
			// can't test anything
		} else if (usage.equalsIgnoreCase("X")) {
			if (encoded.length() > 0)
				exList.add(new XElementPresentException("Element \"" + name
						+ "\" is present but specified as not used (X)"));
		} else if (usage.equalsIgnoreCase("B")) {
			// can't test anything
		}
	}

	/**
	 * Tests table values for ID, IS, and CE types. An empty list is returned for all other types or
	 * if the table name or number is missing.
	 */
    protected void testTypeAgainstTable(Type type, AbstractComponent<?> profile,
			String profileID, List<HL7Exception> exList) {
		if (profile.getTable() != null
				&& (type.getName().equals("IS") || type.getName().equals("ID"))) {
			String codeSystem = String.format("HL7%1$4s", profile.getTable()).replace(" ", "0");
			String value = ((Primitive) type).getValue();
			addTableTestResult(profileID, codeSystem, value, exList);
		} else if (type.getName().equals("CE")) {
			String value = Terser.getPrimitive(type, 1, 1).getValue();
			String codeSystem = Terser.getPrimitive(type, 3, 1).getValue();
			addTableTestResult(profileID, codeSystem, value, exList);

			value = Terser.getPrimitive(type, 4, 1).getValue();
			codeSystem = Terser.getPrimitive(type, 6, 1).getValue();
			addTableTestResult(profileID, codeSystem, value, exList);
		}
	}

	protected void addTableTestResult(String profileID, String codeSystem, String value, List<HL7Exception> exList) {
		if (codeSystem != null && value != null && validateChildren) {
			testValueAgainstTable(profileID, codeSystem, value, exList);
		}
	}

	protected void testValueAgainstTable(String profileID, String codeSystem, String value, List<HL7Exception> exList) {
		CodeStore store = codeStore;
		if (codeStore == null) {
			store = getHapiContext().getCodeStoreRegistry().getCodeStore(profileID, codeSystem);
		}

		if (store == null) {
			log.info(
					"Not checking value {}: no code store was found for profile {} code system {}",
					new Object[] { value, profileID, codeSystem });
		} else {
			if (!store.knowsCodes(codeSystem)) {
				log.warn("Not checking value {}: Don't have a table for code system {}", value,
						codeSystem);
			} else if (!store.isValidCode(codeSystem, value)) {
				exList.add(new ProfileNotFollowedException("Code '" + value + "' not found in table "
						+ codeSystem + ", profile " + profileID));
			}
		}

	}

	public List<HL7Exception> testField(Type type, Field profile, boolean escape, String profileID)
			throws ProfileException, HL7Exception {
		return doTestField(type, profile, escape, profileID, true);
	}

	protected List<HL7Exception> doTestField(Type type, Field profile, boolean escape, String profileID,
			boolean theValidateChildren) throws ProfileException, HL7Exception {
		List<HL7Exception> exList = new ArrayList<HL7Exception>();

		// account for MSH 1 & 2 which aren't escaped
		String encoded = null;
		if (!escape && Primitive.class.isAssignableFrom(type.getClass()))
			encoded = ((Primitive) type).getValue();

		exList.addAll(testType(type, profile, encoded, profileID));

		// test children
		if (theValidateChildren) {
			if (profile.getComponents() > 0 && !profile.getUsage().equals("X")) {
				if (Composite.class.isAssignableFrom(type.getClass())) {
					Composite comp = (Composite) type;
					for (int i = 1; i <= profile.getComponents(); i++) {
						Component childProfile = profile.getComponent(i);
						try {
							Type child = comp.getComponent(i - 1);
							exList.addAll(doTestComponent(child, childProfile, profileID, validateChildren));
						} catch (DataTypeException de) {
							exList.add(new ProfileNotHL7CompliantException(
									"More components in profile than allowed in message: "
											+ de.getMessage()));
						}
					}
					checkExtraComponents(comp, profile.getComponents(), exList);
				} else {
					exList.add(new ProfileNotHL7CompliantException("A field has type primitive "
							+ type.getClass().getName() + " but the profile defines components"));
				}
			}
		}

		return exList;
	}

	public List<HL7Exception> testComponent(Type type, Component profile, String profileID)
			throws ProfileException, HL7Exception {
		return doTestComponent(type, profile, profileID, true);
	}

	protected List<HL7Exception> doTestComponent(Type type, Component profile, String profileID,
			boolean theValidateChildren) throws ProfileException, HL7Exception {
		List<HL7Exception> exList = new ArrayList<HL7Exception>();
		exList.addAll(testType(type, profile, null, profileID));

		// test children
		if (profile.getSubComponents() > 0 && !profile.getUsage().equals("X") && (!type.isEmpty())) {
			if (Composite.class.isAssignableFrom(type.getClass())) {
				Composite comp = (Composite) type;

				if (theValidateChildren) {
					for (int i = 1; i <= profile.getSubComponents(); i++) {
						SubComponent childProfile = profile.getSubComponent(i);
						try {
							Type child = comp.getComponent(i - 1);
							exList.addAll(testType(child, childProfile, null, profileID));
						} catch (DataTypeException de) {
							exList.add(new ProfileNotHL7CompliantException(
									"More subcomponents in profile than allowed in message: "
											+ de.getMessage()));
						}
					}
				}

                checkExtraComponents(comp, profile.getSubComponents(), exList);
			} else {
				exList.add(new ProfileNotFollowedException("A component has primitive type "
						+ type.getClass().getName() + " but the profile defines subcomponents"));
			}
		}

		return exList;
	}

	/** Tests for extra components (ie any not defined in the profile) */
	protected void checkExtraComponents(Composite comp, int numInProfile, List<HL7Exception> exList)
			throws ProfileException {
		StringBuilder extra = new StringBuilder();
		for (int i = numInProfile; i < comp.getComponents().length; i++) {
			try {
				String s = PipeParser.encode(comp.getComponent(i), enc);
				if (s.length() > 0) {
					extra.append(s).append(enc.getComponentSeparator());
				}
			} catch (DataTypeException de) {
				throw new ProfileException("Problem testing against profile", de);
			}
		}

		if (extra.length() > 0) {
			exList.add(new XElementPresentException(
					"The following components are not defined in the profile: " + extra.toString()));
		}

	}

	public static void main(String args[]) {

		if (args.length != 2) {
			System.out.println("Usage: DefaultValidator message_file profile_file");
			System.exit(1);
		}

		DefaultValidator val = new DefaultValidator();
		try {
			String msgString = loadFile(args[0]);
			Parser parser = new GenericParser();
			Message message = parser.parse(msgString);

			String profileString = loadFile(args[1]);
			ProfileParser profParser = new ProfileParser(true);
			RuntimeProfile profile = profParser.parse(profileString);

			HL7Exception[] exceptions = val.validate(message, profile.getMessage());

			System.out.println("Exceptions: ");
			for (int i = 0; i < exceptions.length; i++) {
				System.out.println((i + 1) + ". " + exceptions[i].getMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** loads file at the given path */
	private static String loadFile(String path) throws IOException {
		File file = new File(path);
		// char[] cbuf = new char[(int) file.length()];
		BufferedReader in = new BufferedReader(new FileReader(file));
		StringBuffer buf = new StringBuffer(5000);
		int c;
		while ((c = in.read()) != -1) {
			buf.append((char) c);
		}
		// in.read(cbuf, 0, (int) file.length());
		in.close();
		// return String.valueOf(cbuf);
		return buf.toString();
	}

}
