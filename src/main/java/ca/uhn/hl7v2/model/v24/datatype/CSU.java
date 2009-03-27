package ca.uhn.hl7v2.model.v24.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 CSU (channel sensitivity/units) data type.  Consists of the following components: </p><ol>
 * <li>channel sensitivity (NM)</li>
 * <li>unit of measure identifier (ST)</li>
 * <li>unit of measure description (ST)</li>
 * <li>unit of measure coding system (IS)</li>
 * <li>alternate unit of measure identifier (ST)</li>
 * <li>alternate unit of measure description (ST)</li>
 * <li>alternate unit of measure coding system (IS)</li>
 * </ol>
 */
public class CSU extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a CSU.
	 * @param message the Message to which this Type belongs
	 */
	public CSU(Message message) {
		super(message);
		data = new Type[7];
		data[0] = new NM(message);
		data[1] = new ST(message);
		data[2] = new ST(message);
		data[3] = new IS(message, 0);
		data[4] = new ST(message);
		data[5] = new ST(message);
		data[6] = new IS(message, 0);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 7 element CSU composite"); 
		} 
	} 
	/**
	 * Returns channel sensitivity (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getChannelSensitivity() {
	   NM ret = null;
	   try {
	      ret = (NM)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns unit of measure identifier (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getUnitOfMeasureIdentifier() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(1);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns unit of measure description (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getUnitOfMeasureDescription() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(2);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns unit of measure coding system (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getUnitOfMeasureCodingSystem() {
	   IS ret = null;
	   try {
	      ret = (IS)getComponent(3);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns alternate unit of measure identifier (component #4).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getAlternateUnitOfMeasureIdentifier() {
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
	 * Returns alternate unit of measure description (component #5).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getAlternateUnitOfMeasureDescription() {
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
	 * Returns alternate unit of measure coding system (component #6).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getAlternateUnitOfMeasureCodingSystem() {
	   IS ret = null;
	   try {
	      ret = (IS)getComponent(6);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}