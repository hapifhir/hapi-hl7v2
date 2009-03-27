package ca.uhn.hl7v2.model.v23.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 CM_RFR (reference range) data type.  Consists of the following components: </p><ol>
 * <li>reference range (CM_RANGE)</li>
 * <li>sex (IS)</li>
 * <li>age range (CM_RANGE)</li>
 * <li>age gestation (CM_RANGE)</li>
 * <li>species (TX)</li>
 * <li>race/subspecies (ST)</li>
 * <li>conditions (TX)</li>
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
		data[1] = new IS(message, 0);
		data[2] = new CM_RANGE(message);
		data[3] = new CM_RANGE(message);
		data[4] = new TX(message);
		data[5] = new ST(message);
		data[6] = new TX(message);
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
	 * Returns reference range (component #0).  This is a convenience method that saves you from 
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
	 * Returns sex (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getSex() {
	   IS ret = null;
	   try {
	      ret = (IS)getComponent(1);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns age range (component #2).  This is a convenience method that saves you from 
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
	 * Returns age gestation (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CM_RANGE getAgeGestation() {
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
	 * Returns species (component #4).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public TX getSpecies() {
	   TX ret = null;
	   try {
	      ret = (TX)getComponent(4);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns race/subspecies (component #5).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getRaceSubspecies() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(5);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns conditions (component #6).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public TX getConditions() {
	   TX ret = null;
	   try {
	      ret = (TX)getComponent(6);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}