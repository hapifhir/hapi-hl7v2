/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is ""  Description:
 * ""
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2001.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
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
package ca.uhn.hl7v2.testpanel.model.conf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.conf.spec.message.AbstractSegmentContainer;
import ca.uhn.hl7v2.conf.spec.message.SegGroup;
import ca.uhn.hl7v2.conf.spec.message.StaticDef;
import ca.uhn.hl7v2.model.GenericSegment;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Structure;

public class ConformanceStructureHolderSupport implements ConformanceStructureHolder {

	private AbstractSegmentContainer myConfDefinition;
	private Group myGroup;
	private List<Short> myMaxReps = new ArrayList<Short>();
	private List<Short> myMinReps = new ArrayList<Short>();
	private List<String> myNames = new ArrayList<String>();
	private Map<String, List<Segment>> myNamesToNonStandardSegments = new HashMap<String, List<Segment>>();
	private Map<String, Integer> myNameToIndex = new HashMap<String, Integer>();
	private List<ConformanceStructure<?>> myPrototypes = new ArrayList<ConformanceStructure<?>>();

	public ConformanceStructureHolderSupport(Group theGroup, AbstractSegmentContainer theConfDefinition) {
		myConfDefinition = theConfDefinition;
		myGroup = theGroup;
	}

	public void addChild(ConformanceStructure<?> theStructure, String theName, short theMinReps, short theMaxReps) throws HL7Exception {
		String name = theName;
        if (nameExists(name)) {
            int version = 2;
            String newName = name;
            while (nameExists(newName)) {
                newName = name + version++;
            }
            name = newName;
        }
		
		myNameToIndex.put(name, myNames.size());
		myMinReps.add(theMinReps);
		myMaxReps.add(theMaxReps);
		myNames.add(theName);
		myPrototypes.add(theStructure);
	}

	public String addNonstandardSegment(String theName) throws HL7Exception {
		return addNonstandardSegment(theName, myNames.size());
	}

	public String addNonstandardSegment(String theName, int theIndex) throws HL7Exception {
        String name = null;
		if (nameExists(theName)) {
            int version = 2;
            String newName = theName;
            while (nameExists(newName)) {
                newName = theName + version++;
            }
            name = newName;
        } else {
        	name = theName;
        }

		myMinReps.add(theIndex, (short) 0);
		myMaxReps.add(theIndex, (short) 0);
		myNames.add(theIndex, name);
		myPrototypes.add(theIndex, null);
		myNamesToNonStandardSegments.put(name, new ArrayList<Segment>());
		
		int index = 0;
		for (String next : myNames) {
			myNameToIndex.put(next, index++);
		}
		
		return name;
	}

	public Segment getNonStandardSegmentIfNameExists(String theName, int theIndex) throws HL7Exception {
		List<Segment> segments = myNamesToNonStandardSegments.get(theName);
		if (segments == null) {
			return null;
		}
		if (theIndex > segments.size()) {
			throw new HL7Exception("Invalid index " + theIndex + ", must be <= " + segments.size());
		}
		if (segments.size() == theIndex) {
			segments.add(new GenericSegment(myGroup, theName));
		}
		return segments.get(theIndex);
	}
	
	
	public Structure get(String theName) throws HL7Exception {
		throw new UnsupportedOperationException();
	}

	public Structure get(String theName, int theRep) throws HL7Exception {
		int index = getIndex(theName);
		Structure retVal;
		if (myPrototypes.get(index) == null) {
			retVal = new GenericSegment(myGroup, theName);
		} else if (theRep == 0) {
			retVal = myPrototypes.get(index);
		} else {
			retVal = myPrototypes.get(index).instantiateClone();
		}
		return retVal;
	}

	public Structure[] getAll(String theName) throws HL7Exception {
		throw new UnsupportedOperationException();
	}

	public int getChildCount() {
		return myNames.size();
	}

	public Class<? extends Structure> getClass(String theName) {
		throw new UnsupportedOperationException();
	}

	private int getIndex(String theName) throws HL7Exception {
		Integer retVal = myNameToIndex.get(theName);
		if (retVal == null) {
			throw new HL7Exception("Unknown name: " + theName);
		}
		return retVal;
	}

	public Message getMessage() {
		throw new UnsupportedOperationException();
	}

	public String getName() {
		if (myConfDefinition instanceof StaticDef) {
			StaticDef sd = (StaticDef)myConfDefinition;
			return sd.getMsgType() + "^" + sd.getEventType();
		} else {
			return ((SegGroup)myConfDefinition).getName();
		}
	}

	public String[] getNames() {
		return myNames.toArray(new String[myNames.size()]);
	}

	/**
	 * @return the namesToNonStandardSegments
	 */
	public Map<String, List<Segment>> getNamesToNonStandardSegments() {
		return myNamesToNonStandardSegments;
	}

	public Group getParent() {
		throw new UnsupportedOperationException();
	}

	public ConformanceStructureHolderSupport instantiateClone() throws HL7Exception {
		ConformanceStructureHolderSupport retVal = new ConformanceStructureHolderSupport(myGroup, myConfDefinition);

		for (int i = 0; i < myNames.size(); i++) {

			ConformanceStructure<?> structure = myPrototypes.get(i).instantiateClone();
			retVal.addChild(structure, myNames.get(i), myMinReps.get(i), myMaxReps.get(i));

		}

		return retVal;
	}

	public boolean isGroup(String theName) throws HL7Exception {
		throw new UnsupportedOperationException();
	}

	public boolean isRepeating(String theName) throws HL7Exception {
		int index = getIndex(theName);
		return myMaxReps.get(index) > 1 || myMaxReps.get(index) == -1;
	}

	public boolean isRequired(String theName) throws HL7Exception {
		int index = getIndex(theName);
		return myMinReps.get(index) > 0;
	}

	private boolean nameExists(String theName) {
		return myNameToIndex.containsKey(theName);
	}

	public Structure[] getAllNonStandardSegmentsIfNameExists(String theName) {
		List<Segment> segments = myNamesToNonStandardSegments.get(theName);
		if (segments == null) {
			return null;
		}
		return segments.toArray(new Structure[segments.size()]);
	}

}
