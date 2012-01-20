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

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.conf.spec.message.SegGroup;
import ca.uhn.hl7v2.model.AbstractGroup;
import ca.uhn.hl7v2.model.GenericSegment;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Structure;

public class ConformanceGroup extends AbstractGroup implements ConformanceStructure<ConformanceGroup>, ConformanceStructureHolder {

	private SegGroup myConfDefinition;

	private ConformanceStructureHolderSupport mySupport;

	public ConformanceGroup(Group theParent, SegGroup theConfDefinition) {
		super(theParent, (((ConformanceMessage)theParent.getMessage()).getModelClassFactory()));
		
		mySupport = new ConformanceStructureHolderSupport(this, theConfDefinition);
		myConfDefinition = theConfDefinition;
	}

	public ConformanceGroup(Message theMessage, ConformanceStructureHolderSupport theSupport, SegGroup theConfDefinition) {
		this(theMessage, theConfDefinition);
		
		myConfDefinition = theConfDefinition;
		mySupport = theSupport;
	}
	/**
	 * Internal method for adding child structures
	 */
	public void addChild(ConformanceStructure<?> theStructure, String theName, short theMinReps, short theMaxReps) throws HL7Exception {
		int num = mySupport.getChildCount();
		mySupport.addChild(theStructure, theName, theMinReps, theMaxReps);
		super.insert(theStructure.getClass(), mySupport.isRequired(theName), mySupport.isRepeating(theName), num, theName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Structure get(String theName, int theRep) throws HL7Exception {
		
		Structure retVal = mySupport.getNonStandardSegmentIfNameExists(theName, theRep);
		if (retVal != null) {
			return retVal;
		}
		
		Structure[] currentReps = getAll(theName);
		int currentRepsNum = currentReps.length;
		if (theRep > currentRepsNum) {
			throw new HL7Exception("Can't create rep " + theRep + " as there are currently only " + currentRepsNum);
		}

		if (theRep < currentRepsNum) {
			return super.get(theName, theRep);
		}
		
		if (getClass(theName) == GenericSegment.class) {
			retVal = super.get(theName, theRep);
		} else {
			retVal = mySupport.get(theName, theRep);
		}
		insertRepetition(theName, retVal, theRep);
		return retVal;
	}

//	/**
//	 * {@inheritDoc}
//	 */
//	@Override
//	public String addNonstandardSegment(String theName) throws HL7Exception {
//		return mySupport.addNonstandardSegment(theName);
//	}
//
//	/**
//	 * {@inheritDoc}
//	 */
//	@Override
//	public String addNonstandardSegment(String theName, int theIndex) throws HL7Exception {
//		return mySupport.addNonstandardSegment(theName, theIndex);
//	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Structure[] getAll(String theName) throws HL7Exception {
		Structure[] retVal = mySupport.getAllNonStandardSegmentsIfNameExists(theName);
		if (retVal == null) {
			return super.getAll(theName);
		}
		return retVal;
	}
	/**
	 * @return the confDefinition
	 */
	public SegGroup getConfDefinition() {
		return myConfDefinition;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return mySupport.getName();
	}

//	/**
//	 * {@inheritDoc}
//	 */
//	@Override
//	public String[] getNames() {
//		return mySupport.getNames();
//	}

	/**
	 * {@inheritDoc}
	 */
	public ConformanceGroup instantiateClone() throws HL7Exception {
		ConformanceStructureHolderSupport support = mySupport.instantiateClone();
		ConformanceGroup retVal = new ConformanceGroup(getMessage(), support, myConfDefinition);
		
		int idx = 0;
		for (String next : getNames()) {
			Class<? extends Structure> clazz = getClass(next);
			boolean rep = isRepeating(next);
			boolean req = isRequired(next);
			
			retVal.insert(clazz, req, rep, idx, next);
			
			idx++;
		}
		
		return retVal;
	}

	/**
	 * {@inheritDoc} 
	 */
	@Override
	protected Structure tryToInstantiateStructure(Class<? extends Structure> theC, String theName) throws HL7Exception {
		return mySupport.get(theName, 0);
	}

}
