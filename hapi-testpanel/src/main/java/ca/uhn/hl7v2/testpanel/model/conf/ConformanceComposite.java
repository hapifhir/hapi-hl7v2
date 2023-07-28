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
import ca.uhn.hl7v2.Location;
import ca.uhn.hl7v2.conf.spec.message.AbstractComponent;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.ExtraComponents;
import ca.uhn.hl7v2.model.MessageVisitor;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.Varies;


public class ConformanceComposite extends AbstractType implements Composite, ConformanceType<ConformanceComposite> {

	private List<Type> myChildren = new ArrayList<Type>();
	private List<String> myName = new ArrayList<String>();
	private AbstractComponent<?> myConfDefinition;

	/**
	 * Constructor
	 */
	public ConformanceComposite(ConformanceMessage theMessage, AbstractComponent<?> theConfDefinition) {
		super(theMessage);
		
		myConfDefinition = theConfDefinition;
	}

	/**
	 * @return the confDefinition
	 */
	public AbstractComponent<?> getConfDefinition() {
		return myConfDefinition;
	}

	/**
	 * Internal method for adding a child definition
	 */
	void addChild(ConformanceType<? extends Type> theChild, String theName) {
		myChildren.add(theChild);
		myName.add(theName);
	}
	
	@Override
	public ConformanceMessage getMessage() {
		return (ConformanceMessage) super.getMessage();
	}

	/**
	 * {@inheritDoc}
	 */
	public Type getComponent(int theNumber) throws DataTypeException {
		return myChildren.get(theNumber);
	}

	/**
	 * {@inheritDoc}
	 */
	public Type[] getComponents() {
		return myChildren.toArray(new Type[myChildren.size()]);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return myConfDefinition.getDatatype();
	}

	/**
	 * Returns the name of the given child
	 */
	public String getName(int theNumber) {
		return myName.get(theNumber);
	}

	/**
	 * {@inheritDoc}
	 */
	public ConformanceComposite instantiateClone() {
		ConformanceComposite retVal = new ConformanceComposite((ConformanceMessage) getMessage(), myConfDefinition);
		
		int index = 0;
		for (Type next : myChildren) {
			ConformanceType<? extends Type> nextCtype = (ConformanceType<?>)next;
			ConformanceType<?> clone = nextCtype.instantiateClone();
			retVal.addChild(clone, myName.get(index));
			
			index++;
		}
		
		return retVal;
	}

    public boolean accept(MessageVisitor visitor, Location location) throws HL7Exception {
    	throw new UnsupportedOperationException();
    }

}
