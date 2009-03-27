package ca.uhn.hl7v2.model.v22.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 CM_RFR (reference range) data type.  Consists of the following components: </p><ol>
 * <li>Reference Range (CM_RANGE)</li>
 * <li>Sex (ID)</li>
 * <li>Age Range (CM_RANGE)</li>
 * <li>Gestational Age Range (CM_RANGE)</li>
 * <li>Species (ST)</li>
 * <li>Race / Subspecies (ID)</li>
 * <li>Text Condition (ST)</li>
 * </ol>
 */
public class CM_RFR extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a CM_RFR.
	 * @param message the Message to which this Type belongs
	 */
	public CM_RFR(Message message) {
		super(message);
		data = new Type[7];
		data[0] = new CM_RANGE(message);
		data[1] = new ID(message, 0);
		data[2] = new CM_RANGE(message);
		data[3] = new CM_RANGE(message);
		data[4] = new ST(message);
		data[5] = new ID(message, 0);
		data[6] = new ST(message);
	}

	/**
	 * Returns an array containing the data elements.
	 */
	public Type[] getComponents() { 
		return this.data; 
	}

	/**
	 * Returns an individual data component.
	 * @throws DataTypeException if the given element number is out of range.
	 */
	public Type getComponent(int number) throws DataTypeException { 

		try { 
			return this.data[number]; 
		} catch (ArrayIndexOutOfBoundsException e) { 
			throw new DataTypeException("Element " + number + " doesn't exist in 7 element CM_RFR composite"); 
		} 
	} 
	/**
	 * Returns Reference Range (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CM_RANGE getReferenceRange() {
	   CM_RANGE ret = null;
	   try {
	      ret = (CM_RANGE)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Sex (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getSex() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(1);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Age Range (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CM_RANGE getAgeRange() {
	   CM_RANGE ret = null;
	   try {
	      ret = (CM_RANGE)getComponent(2);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Gestational Age Range (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CM_RANGE getGestationalAgeRange() {
	   CM_RANGE ret = null;
	   try {
	      ret = (CM_RANGE)getComponent(3);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Species (component #4).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getSpecies() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(4);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Race / Subspecies (component #5).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getRaceSubspecies() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(5);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Text Condition (component #6).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getTextCondition() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(6);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}