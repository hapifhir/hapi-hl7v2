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

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang.Validate;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.hl7v2.conf.spec.message.Component;
import ca.uhn.hl7v2.conf.spec.message.Field;
import ca.uhn.hl7v2.conf.spec.message.ProfileStructure;
import ca.uhn.hl7v2.conf.spec.message.Seg;
import ca.uhn.hl7v2.conf.spec.message.SegGroup;
import ca.uhn.hl7v2.conf.spec.message.StaticDef;
import ca.uhn.hl7v2.conf.spec.message.SubComponent;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.DoNotCacheStructure;
import ca.uhn.hl7v2.model.GenericSegment;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Structure;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.parser.ModelClassFactory;

@DoNotCacheStructure
public class ConformanceMessage extends AbstractMessage implements ConformanceStructureHolder {

	private final StaticDef myConfDefinition;
	private ConformanceStructureHolderSupport mySupport;
	private String myTablesId;

	public ConformanceMessage(StaticDef theConfDefinition) {
		super(new NullModelClassFactory());

		mySupport = new ConformanceStructureHolderSupport(this, theConfDefinition);
		myConfDefinition = theConfDefinition;
	}

	public ConformanceMessage(StaticDef theConfDefinition, ConformanceStructureHolderSupport theSupport) {
		this(theConfDefinition);

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
		Validate.notEmpty(theName);
		
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
			insertRepetition(theName, retVal, theRep);
		}
		return retVal;
	}

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
	public StaticDef getConfDefinition() {
		return myConfDefinition;
	}

	
	@Override
	public ConformanceMessage getMessage() {
		return this;
	}

//	/**
//	 * {@inheritDoc}
//	 */
//	@Override
//	public String addNonstandardSegment(String theName) throws HL7Exception {
//		String segment = mySupport.addNonstandardSegment(theName);
//		return segment;
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
	public String getName() {
		return myConfDefinition.getMsgStructID();
	}

	/**
	 * @return the tablesId
	 */
	public String getTablesId() {
		return myTablesId;
	}

//	/**
//	 * {@inheritDoc}
//	 */
//	@Override
//	public String[] getNames() {
//		String[] retVal = mySupport.getNames();
//		return retVal;
//	}

	private void setTablesId(String theTablesId) {
		myTablesId = theTablesId;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Structure tryToInstantiateStructure(Class<? extends Structure> theC, String theName) throws HL7Exception {
		if (theC.equals(GenericSegment.class)) {
			try {
				return theC.getConstructor(Group.class, String.class).newInstance(this, theName);
			} catch (InstantiationException e) {
				throw new HL7Exception(e);
			} catch (IllegalAccessException e) {
				throw new HL7Exception(e);
			} catch (IllegalArgumentException e) {
				throw new HL7Exception(e);
			} catch (SecurityException e) {
				throw new HL7Exception(e);
			} catch (InvocationTargetException e) {
				throw new HL7Exception(e);
			} catch (NoSuchMethodException e) {
				throw new HL7Exception(e);
			}
		}
		return mySupport.get(theName, 0);
	}

	private static void addChildren(ConformanceStructureHolder theParent, Seg theChildDef) throws HL7Exception {
		ConformanceSegment segment = new ConformanceSegment(theParent, theChildDef);
		theParent.addChild(segment, theChildDef.getName(), theChildDef.getMin(), theChildDef.getMax());

		for (int i = 0; i < theChildDef.getFields(); i++) {
			Field fieldDef = theChildDef.getField(i + 1);
			if (fieldDef.getComponents() == 0) {
				addPrimitive(segment, fieldDef);
			} else {
				ConformanceComposite field = new ConformanceComposite(((ConformanceMessage) theParent.getMessage()), fieldDef);

				for (int j = 0; j < fieldDef.getComponents(); j++) {
					Component componentDef = fieldDef.getComponent(j + 1);
					if (componentDef.getSubComponents() == 0) {
						addPrimitive(field, componentDef);
					} else {

						ConformanceComposite component = new ConformanceComposite(((ConformanceMessage) theParent.getMessage()), componentDef);
						for (int k = 0; k < componentDef.getSubComponents(); k++) {
							SubComponent subComponentDef = componentDef.getSubComponent(k + 1);
							ConformancePrimitive subComponent = new ConformancePrimitive(theParent.getMessage(), subComponentDef);
							component.addChild(subComponent, subComponentDef.getName());
						}

						field.addChild(component, componentDef.getName());
					}
				}

				segment.addChild(field, fieldDef.getName(), fieldDef.getMin(), fieldDef.getMax(), (int) fieldDef.getLength());
			}
		}

	}

	private static void addChildren(ConformanceStructureHolder theParent, SegGroup theChildDef) throws HL7Exception {

		if (theChildDef.getChildren() == 1 && theChildDef.getChild(1) instanceof SegGroup) {
			SegGroup child = (SegGroup) theChildDef.getChild(1);
			try {
				if (theChildDef.getMin() == 0) {
					child.setMin(theChildDef.getMin());
				}
				if (theChildDef.getMax() == -1) {
					child.setMax(theChildDef.getMax());
				}
				if (theChildDef.getName().length() > child.getName().length()) {
					child.setName(theChildDef.getName());
				}
			} catch (ProfileException e) {
				throw new HL7Exception(e);
			}
			theChildDef = child;
		}

		ConformanceGroup child = new ConformanceGroup(theParent, theChildDef);
		theParent.addChild(child, theChildDef.getName(), theChildDef.getMin(), theChildDef.getMax());

		for (int i = 0; i < theChildDef.getChildren(); i++) {
			ProfileStructure childDef = theChildDef.getChild(i + 1);
			if (childDef instanceof Seg) {
				addChildren(child, (Seg) childDef);
			} else {
				addChildren(child, (SegGroup) childDef);
			}
		}

	}

	private static void addPrimitive(ConformanceComposite theComposite, Component theChild) {
		ConformancePrimitive primitive = new ConformancePrimitive(theComposite.getMessage(), theChild);
		theComposite.addChild(primitive, theChild.getName());
	}

	private static void addPrimitive(ConformanceSegment theSegment, Field theField) throws HL7Exception {
		ConformancePrimitive primitive = new ConformancePrimitive(theSegment.getMessage(), theField);
		theSegment.addChild(primitive, theField.getName(), theField.getMin(), theField.getMax(), (int) theField.getLength());
	}

	public static ConformanceMessage newInstanceFromStaticDef(StaticDef theStaticDef, String theTablesId) throws HL7Exception {
		ConformanceMessage retVal = new ConformanceMessage(theStaticDef);

		for (int i = 0; i < theStaticDef.getChildren(); i++) {
			ProfileStructure childDef = theStaticDef.getChild(i + 1);
			if (childDef instanceof Seg) {
				addChildren(retVal, (Seg) childDef);
			} else {
				addChildren(retVal, (SegGroup) childDef);
			}
		}

		retVal.setTablesId(theTablesId);
		
		return retVal;
	}

	/**
	 * Null implementation of MCF - Always throws UnsupportedOperationException
	 */
	private static class NullModelClassFactory implements ModelClassFactory {

		public Class<? extends Group> getGroupClass(String theName, String theVersion) throws HL7Exception {
			throw new UnsupportedOperationException();
		}

		public Class<? extends Message> getMessageClass(String theName, String theVersion, boolean theIsExplicit) throws HL7Exception {
			throw new UnsupportedOperationException();
		}

		public Class<? extends Message> getMessageClassInASpecificPackage(String theName, String theVersion, boolean theIsExplicit, String thePackageName) throws HL7Exception {
			throw new UnsupportedOperationException();
		}

		public Class<? extends Segment> getSegmentClass(String theName, String theVersion) throws HL7Exception {
			return GenericSegment.class;
		}

		public Class<? extends Type> getTypeClass(String theName, String theVersion) throws HL7Exception {
			throw new UnsupportedOperationException();
		}

	}

}
