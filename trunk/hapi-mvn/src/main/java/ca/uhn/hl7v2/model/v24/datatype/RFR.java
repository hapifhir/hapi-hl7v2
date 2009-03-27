package ca.uhn.hl7v2.model.v24.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 RFR (reference range) data type.  Consists of the following components: </p><ol>
 * <li>numeric range (NR)</li>
 * <li>administrative sex (IS)</li>
 * <li>age range (NR)</li>
 * <li>gestational range (NR)</li>
 * <li>species (TX)</li>
 * <li>race/subspecies (ST)</li>
 * <li>conditions (TX)</li>
 * </ol>
 */
public class RFR extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a RFR.
	 * @param message the Message to which this Type belongs
	 */
	public RFR(Message message) {
		super(message);
		data = new Type[7];
		data[0] = new NR(message);
		data[1] = new IS(message, 0);
		data[2] = new NR(message);
		data[3] = new NR(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 7 element RFR composite"); 
		} 
	} 
	/**
	 * Returns numeric range (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NR getNumericRange() {
	   NR ret = null;
	   try {
	      ret = (NR)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns administrative sex (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getAdministrativeSex() {
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
	public NR getAgeRange() {
	   NR ret = null;
	   try {
	      ret = (NR)getComponent(2);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns gestational range (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NR getGestationalRange() {
	   NR ret = null;
	   try {
	      ret = (NR)getComponent(3);
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