/**
 *
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2001.  All Rights Reserved.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  "GPL"), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 */
package ca.uhn.hl7v2.testpanel.util.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.AbstractGroup;
import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Primitive;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Structure;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.Varies;
import ca.uhn.hl7v2.parser.EncodingCharacters;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.testpanel.ex.UnexpectedTestFailureException;
import ca.uhn.hl7v2.testpanel.util.Pair;
import ca.uhn.hl7v2.validation.impl.ValidationContextImpl;

public class Hl7V2MessageCompare {
	// ~ Instance fields
	// ------------------------------------------------------------------------------------------------

	private Message myActualMessage;
	private GroupComparison myComparison;

	private EncodingCharacters myEncodingCharacters = new EncodingCharacters('|', null);

	private PipeParser myEncodingParser;
	private Message myExpectedMessage;
	private Set<String> myFieldsToIgnore;
	private String myExpectedDesc = BulkHl7V2Comparison.EXPECTED_DESC;
	private String myActualDesc = BulkHl7V2Comparison.ACTUAL_DESC;

	/**
	 * Constructor
	 */
	public Hl7V2MessageCompare() {
		myEncodingParser = new PipeParser();
		myEncodingParser.setValidationContext(new ValidationContextImpl());
	}

	/**
	 * Constructor
	 */
	public Hl7V2MessageCompare(PipeParser theParser) {
		myEncodingParser = theParser;
	}

	// ~ Constructors
	// ---------------------------------------------------------------------------------------------------

	private void addRemainingStructures(Group theStructure, int theStartingNameIndex, int theAfterEndingIndex, List<StructureComparison> theStructureComparisons, boolean theIsMessage1) throws HL7Exception {
		String[] names = theStructure.getNames();

		for (int i = theStartingNameIndex; i < theAfterEndingIndex; i++) {
			Structure[] reps = theStructure.getAll(names[i]);

			for (Structure structure : reps) {
				if (structure instanceof Group) {
					theStructureComparisons.add(new ExtraGroup((Group) structure, theIsMessage1));
				} else {
					if (theIsMessage1) {
						theStructureComparisons.add(new SegmentComparison(structure.getName(), (Segment) structure, null));
					} else {
						theStructureComparisons.add(new SegmentComparison(structure.getName(), null, (Segment) structure));
					}
				}
			}
		}
	}

	// ~ Methods
	// --------------------------------------------------------------------------------------------------------

	private void clearComponentIndex(Type[] theFieldReps, int theComponentIndex) throws HL7Exception {

		for (Type type : theFieldReps) {

			int extraComponentIndex = -1;

			if (type instanceof Primitive) {
				Primitive p = (Primitive) type;
				if (theComponentIndex < 2) {
					p.setValue("");
				} else {
					extraComponentIndex = theComponentIndex - 1;
				}
			} else {
				Composite c = (Composite) type;
				if (theComponentIndex <= c.getComponents().length) {
					c.getComponents()[theComponentIndex - 1].parse("");
				} else {
					extraComponentIndex = theComponentIndex - c.getComponents().length;
				}
			}

			if (extraComponentIndex != -1) {
				if (type.getExtraComponents().numComponents() >= (theComponentIndex)) {
					type.getExtraComponents().getComponent(extraComponentIndex).parse("");
				}
			}

		}

	}

	/**
	 * {@inheritDoc }
	 */
	public void compare(Message theExpectMessage, Message theActualMessage) throws UnexpectedTestFailureException {
		try {
			myExpectedMessage = theExpectMessage;
			myActualMessage = theActualMessage;

			myExpectedMessage = myEncodingParser.parse(theExpectMessage.encode());
			myActualMessage = myEncodingParser.parse(theActualMessage.encode());

			stripEmptyStructures(theExpectMessage);
			stripEmptyStructures(theActualMessage);

			myComparison = compareGroups(theExpectMessage, theActualMessage);
		} catch (HL7Exception ex) {
			throw new UnexpectedTestFailureException(ex);
		}
	}

	private FieldComparison compareFields(Segment theSegment1, Segment theSegment2, int theI) throws HL7Exception {

		String fieldDescriptor = theSegment1.getName() + "-" + (theI + 1);

		// Check for fields
		boolean ignore = (myFieldsToIgnore != null) && (myFieldsToIgnore.contains(fieldDescriptor));

		Type[] reps1 = theSegment1.getField(theI + 1);
		Type[] reps2 = theSegment2.getField(theI + 1);

		// Check for components (e.g. PID-3-2)
		if (myFieldsToIgnore != null) {
			for (String fieldsToIgnore : myFieldsToIgnore) {
				if (fieldsToIgnore.length() > fieldDescriptor.length() + 1) {
					if (fieldsToIgnore.startsWith(fieldDescriptor)) {
						String componentIndexStr = fieldsToIgnore.substring(fieldDescriptor.length() + 1);
						int componentIndex = Integer.parseInt(componentIndexStr);
						clearComponentIndex(reps1, componentIndex);
						clearComponentIndex(reps2, componentIndex);
					}
				}
			}
		}

		int maxReps = (reps1.length > reps2.length) ? reps1.length : reps2.length;

		List<Type> sameFields = new ArrayList<Type>();
		List<Type> diffFields1 = new ArrayList<Type>();
		List<Type> diffFields2 = new ArrayList<Type>();

		if (!ignore) {
			for (int i = 0; i < maxReps; i++) {
				if (i >= reps1.length) {
					if (reps2[i] == null || reps2[i].encode() == null || reps2[i].encode().isEmpty()) {
						sameFields.add(reps2[i]);
						diffFields1.add(null);
						diffFields2.add(null);
					} else {
						sameFields.add(null);
						diffFields1.add(null);
						diffFields2.add(reps2[i]);
					}
				} else if (i >= reps2.length) {
					Type type = reps1[i];
					if (type == null || type.encode() == null || type.encode().isEmpty()) {
						sameFields.add(reps1[i]);
						diffFields1.add(null);
						diffFields2.add(null);
					} else {
						sameFields.add(null);
						diffFields1.add(reps1[i]);
						diffFields2.add(null);
					}
				} else {
					if (compareTypes(reps1[i], reps2[i])) {
						sameFields.add(reps1[i]);
						diffFields1.add(null);
						diffFields2.add(null);
					} else {
						sameFields.add(null);
						diffFields1.add(reps1[i]);
						diffFields2.add(reps2[i]);
					}
				}
			}
		}

		return new FieldComparison(theSegment1.getNames()[theI], sameFields, diffFields1, diffFields2);
	}

	private GroupComparison compareGroups(Group theStructure1, Group theStructure2) throws HL7Exception {
		List<String> originalNames1 = Arrays.asList(theStructure1.getNames());
		ArrayList<String> names1 = new ArrayList<String>(originalNames1);
		for (Iterator<String> iter = names1.iterator(); iter.hasNext();) {
			String nextName = iter.next();
			if (theStructure1.getAll(nextName).length == 0) {
				iter.remove();
			}
		}

		List<String> originalNames2 = Arrays.asList(theStructure2.getNames());
		ArrayList<String> names2 = new ArrayList<String>(originalNames2);
		for (Iterator<String> iter = names2.iterator(); iter.hasNext();) {
			String nextName = iter.next();
			if (theStructure2.getAll(nextName).length == 0) {
				iter.remove();
			}
		}

		List<StructureComparison> structureComparisons = new ArrayList<StructureComparison>();

		int nameIdx1 = 0;
		int nameIdx2 = 0;

		while ((nameIdx1 < names1.size()) || (nameIdx2 < names2.size())) {
			Pair<Integer> nextSameIdx = findNextSameIndex(names1, names2, nameIdx1, nameIdx2);

			// If we're at the end of the matching segments
			if (nextSameIdx == null) {
				addRemainingStructures(theStructure1, nameIdx1, names1.size(), structureComparisons, true);
				addRemainingStructures(theStructure2, nameIdx2, names2.size(), structureComparisons, false);

				break;
			}

			addRemainingStructures(theStructure1, nameIdx1, nextSameIdx.getValue1(), structureComparisons, true);
			addRemainingStructures(theStructure2, nameIdx2, nextSameIdx.getValue2(), structureComparisons, false);

			Structure[] children1 = theStructure1.getAll(names1.get(nextSameIdx.getValue1()));
			Structure[] children2 = theStructure2.getAll(names2.get(nextSameIdx.getValue2()));
			int lowerCommonIndex = (children1.length < children2.length) ? children1.length : children2.length;

			for (int i = 0; i < lowerCommonIndex; i++) {
				Structure child1 = children1[i];
				Structure child2 = children2[i];

				if (child1 instanceof Segment) {
					structureComparisons.add(compareSegments((Segment) child1, (Segment) child2));
				} else {
					structureComparisons.add(compareGroups((Group) child1, (Group) child2));
				}
			}

			for (int i = lowerCommonIndex; i < children1.length; i++) {
				if (children1[i] instanceof Segment) {
					structureComparisons.add(new SegmentComparison(children1[i].getName(), (Segment) children1[i], null));
				} else {
					structureComparisons.add(new GroupComparison((Group) children1[i], null));
				}
			}

			for (int i = lowerCommonIndex; i < children2.length; i++) {
				if (children2[i] instanceof Segment) {
					structureComparisons.add(new SegmentComparison(children2[i].getName(), null, (Segment) children2[i]));
				} else {
					structureComparisons.add(new GroupComparison(null, (Group) children2[i]));
				}
			}

			nameIdx1 = nextSameIdx.getValue1() + 1;
			nameIdx2 = nextSameIdx.getValue2() + 1;
		}

		return new GroupComparison(structureComparisons);
	}

	private SegmentComparison compareSegments(Segment theSegment1, Segment theSegment2) throws HL7Exception {
		assert theSegment1.getName().equals(theSegment2.getName());

		List<FieldComparison> fieldComparisons = new ArrayList<FieldComparison>();

		for (int i = 0; i < theSegment1.numFields(); i++) {
			FieldComparison nextFieldComparison = compareFields(theSegment1, theSegment2, i);
			fieldComparisons.add(nextFieldComparison);
		}

		return new SegmentComparison(theSegment1.getName(), fieldComparisons);
	}

	private boolean compareTypes(Type theType1, Type theType2) {
		if (theType1 instanceof Primitive && theType2 instanceof Primitive) {
			Primitive type1 = (Primitive) theType1;
			Primitive type2 = (Primitive) theType2;

			return StringUtils.equals(type1.getValue(), type2.getValue());
		} else if (theType1 instanceof Varies && theType2 instanceof Varies) {
			Varies type1 = (Varies) theType1;
			Varies type2 = (Varies) theType2;

			return compareTypes(type1.getData(), type2.getData());
		} else if (theType1 instanceof Composite && theType2 instanceof Composite) {
			Composite type1 = (Composite) theType1;
			Composite type2 = (Composite) theType2;
			Type[] components1 = type1.getComponents();
			Type[] components2 = type2.getComponents();

			if (components1.length != components2.length) {
				return false;
			}

			for (int i = 0; i < components1.length; i++) {
				if (!compareTypes(components1[i], components2[i])) {
					return false;
				}
			}

			return true;
		} else {
			return false;
		}
	}

	/**
	 * {@inheritDoc }
	 */
	public String describeDifference() {
		StringBuilder retVal = new StringBuilder();

		for (SegmentComparison nextSegment : myComparison.flattenMessage()) {
			if (nextSegment.getExpectSegment() != null) {
				retVal.append(myExpectedDesc).append(": ").append(PipeParser.encode(nextSegment.getExpectSegment(), myEncodingCharacters)).append("\r\n");
			}

			if (nextSegment.getActualSegment() != null) {
				retVal.append(myActualDesc).append(": ").append(PipeParser.encode(nextSegment.getActualSegment(), myEncodingCharacters)).append("\r\n");
			}

			if (!nextSegment.isSame() && (nextSegment.getFieldComparisons() != null)) {
				int fieldIndex = 0;

				for (FieldComparison next : nextSegment.getFieldComparisons()) {
					fieldIndex++;

					for (int rep = 1; rep <= next.getDiffFieldsActual().size(); rep++) {
						if (next.getSameFields().get(rep - 1) == null) {
							retVal.append(nextSegment.getName());
							retVal.append("-");
							retVal.append(fieldIndex);
							retVal.append("(");
							retVal.append(rep);
							retVal.append(") - ");
							retVal.append(next.getFieldName());
							retVal.append(":\r\n");

							Type expectedType = next.getDiffFieldsExpected().get(rep - 1);
							retVal.append("  ").append(myExpectedDesc).append(": ").append(encode(expectedType)).append("\r\n");

							Type actualType = next.getDiffFieldsActual().get(rep - 1);
							retVal.append("  ").append(myActualDesc).append(": ").append(encode(actualType));
							retVal.append("\r\n");
						}
					}
				}
			}
		}

		return retVal.toString();
	}

	private String encode(Type theType) {
		if (theType == null) {
			return "";
		}

		return PipeParser.encode(theType, myEncodingCharacters);
	}

	/**
	 * @return the actualMessage
	 */
	public Message getActualMessage() {
		return myActualMessage;
	}

	/**
	 * @return the expectedMessage
	 */
	public Message getExpectedMessage() {
		return myExpectedMessage;
	}

	public GroupComparison getMessageComparison() {
		return myComparison;
	}

	private boolean hasData(Structure theStructure) throws HL7Exception {
		if (theStructure instanceof Group) {
			Group g = (Group) theStructure;
			for (int nameIndex = 0; nameIndex < g.getNames().length; nameIndex++) {
				String nextName = g.getNames()[nameIndex];
				Structure[] nextReps = g.getAll(nextName);
				for (int repIndex = 0; repIndex < nextReps.length; repIndex++) {
					Structure nextRep = nextReps[repIndex];
					if (hasData(nextRep)) {
						return true;
					}
				}
			}
		} else {
			Segment s = (Segment) theStructure;
			for (int nameIndex = 0; nameIndex < s.getNames().length; nameIndex++) {
				Type[] nextReps = s.getField(nameIndex + 1);
				for (int repIndex = 0; repIndex < nextReps.length; repIndex++) {
					Type nextRep = nextReps[repIndex];
					if (StringUtils.isNotEmpty(nextRep.encode())) {
						return true;
					}
				}
			}
		}

		return false;
	}

	/**
	 * {@inheritDoc }
	 */
	public boolean isSame() {
		return myComparison.isSame();
	}

	public void setFieldsToIgnore(Set<String> theFieldsToIgnore) {
		myFieldsToIgnore = theFieldsToIgnore;
	}

	private void stripEmptyStructures(Group theMessage) throws HL7Exception {
		for (String nextName : theMessage.getNames()) {
			for (int i = 0; i < theMessage.getAll(nextName).length; i++) {
				Structure structure = theMessage.get(nextName, i);
				if (structure instanceof Group) {
					stripEmptyStructures((Group) structure);
				}

				if (!hasData(structure) && !theMessage.isRequired(nextName)) {
					((AbstractGroup) theMessage).removeRepetition(nextName, i);
				}
			}
		}
	}

	public static Pair<Integer> findNextSameIndex(ArrayList<String> theNames1, ArrayList<String> theNames2, int theStartingIndex1, int theStartingIndex2) {
		Pair<Integer> found1 = null;
		BOTH: for (int i1 = theStartingIndex1; i1 < theNames1.size(); i1++) {
			for (int i2 = theStartingIndex2; i2 < theNames2.size(); i2++) {
				if (nameIsEqual(theNames1, theNames2, i1, i2)) {
					found1 = new Pair<Integer>(i1, i2);

					break BOTH;
				}
			}
		}

		Pair<Integer> found2 = null;
		BOTH: for (int i2 = theStartingIndex2; i2 < theNames2.size(); i2++) {
			for (int i1 = theStartingIndex1; i1 < theNames1.size(); i1++) {
				if (nameIsEqual(theNames1, theNames2, i1, i2)) {
					found2 = new Pair<Integer>(i1, i2);

					break BOTH;
				}
			}
		}

		if (found1 == null) {
			return found2;
		} else if (found2 == null) {
			return found1;
		} else if (found1.getValue1() < found2.getValue1()) {
			return found1;
		} else {
			return found2;
		}
	}

	private static boolean nameIsEqual(ArrayList<String> theNames1, ArrayList<String> theNames2, int i1, int i2) {
		String name1 = theNames1.get(i1);
		if (!name1.contains("_") && name1.length() > 3) {
			name1 = name1.substring(0, 3);
		}

		String name2 = theNames2.get(i2);
		if (!name2.contains("_") && name2.length() > 3) {
			name2 = name2.substring(0, 3);
		}

		return StringUtils.equals(name1, name2);
	}

	/**
	 * @see BulkHl7V2Comparison#setActualAndExpectedDescription(String, String)
	 */
	public void setExpectedAndActualDescription(String theExpectedDesc, String theActualDesc) {
		myExpectedDesc = theExpectedDesc;
		myActualDesc = theActualDesc;
	}

}
