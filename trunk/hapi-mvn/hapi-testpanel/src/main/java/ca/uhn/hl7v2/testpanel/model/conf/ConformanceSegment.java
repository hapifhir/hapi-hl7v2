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
import java.util.List;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.conf.spec.message.Seg;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Type;


public class ConformanceSegment extends AbstractSegment implements ConformanceStructure<ConformanceSegment> {

	private static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
	private Seg myConfDefinition;
	private List<Integer> myMinReps = new ArrayList<Integer>();
	private List<Boolean> myPrototypeHasBeenUsed = new ArrayList<Boolean>();
	private List<ConformanceType<?>> myPrototypes = new ArrayList<ConformanceType<?>>();

	public ConformanceSegment(ConformanceStructureHolder theParent, Seg theConfDefinition) {
		super(theParent, ((ConformanceMessage)theParent.getMessage()).getModelClassFactory());
		
		myConfDefinition = theConfDefinition;
	}

	/**
	 * Add a child prototype
	 */
	void addChild(ConformanceType<?> theChild, String theName, int theMinReps, int theMaxReps, int theLength) throws HL7Exception {
		super.add(theChild.getClass(), theMinReps > 0, theMaxReps, theLength, EMPTY_OBJECT_ARRAY, theName);

		myMinReps.add(theMinReps);
		myPrototypes.add(theChild);
		myPrototypeHasBeenUsed.add(Boolean.FALSE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return myConfDefinition.getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Type createNewTypeWithoutReflection(int theField) {
		if (Boolean.TRUE.equals(myPrototypeHasBeenUsed.get(theField))) {
			return myPrototypes.get(theField).instantiateClone();
		}
		
		myPrototypeHasBeenUsed.set(theField, Boolean.TRUE);
		return myPrototypes.get(theField);
	}
	
	/**
	 * @return the confDefinition
	 */
	public Seg getConfDefinition() {
		return myConfDefinition;
	}

	public int getMinReps(int theFieldNum) {
		return myMinReps.get(theFieldNum-1);
	}
	
	/**
	 * Create a clone of this segment (for the same message)
	 */
	public ConformanceSegment instantiateClone() throws HL7Exception {
		ConformanceSegment retVal = new ConformanceSegment((ConformanceStructureHolder) getParent(), myConfDefinition);
		
		int index = 0;
		for (ConformanceType<?> next : myPrototypes) {
			ConformanceType<?> clone = next.instantiateClone();
			index++;
			retVal.addChild(clone, getNames()[index-1], getMinReps(index), getMaxCardinality(index), getLength(index));
		}
		
		return retVal;
	}

	public short getMinReps() {
		return myConfDefinition.getMin();
	}

	public short getMaxReps() {
		return myConfDefinition.getMax();
	}
	
}
