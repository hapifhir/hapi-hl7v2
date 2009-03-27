package ca.uhn.hl7v2.model.v25.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 CSU (Channel Sensitivity) data type.  Consists of the following components: </p><ol>
 * <li>Channel Sensitivity (NM)</li>
 * <li>Unit of Measure Identifier (ST)</li>
 * <li>Unit of Measure Description (ST)</li>
 * <li>Unit of Measure Coding System (ID)</li>
 * <li>Alternate Unit of Measure Identifier (ST)</li>
 * <li>Alternate Unit of Measure Description (ST)</li>
 * <li>Alternate Unit of Measure Coding System (ID)</li>
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
		data[3] = new ID(message, 396);
		data[4] = new ST(message);
		data[5] = new ST(message);
		data[6] = new ID(message, 396);
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
	 * Returns Channel Sensitivity (component #0).  This is a convenience method that saves you from 
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
	 * Returns Unit of Measure Identifier (component #1).  This is a convenience method that saves you from 
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
	 * Returns Unit of Measure Description (component #2).  This is a convenience method that saves you from 
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
	 * Returns Unit of Measure Coding System (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getUnitOfMeasureCodingSystem() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(3);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Alternate Unit of Measure Identifier (component #4).  This is a convenience method that saves you from 
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
	 * Returns Alternate Unit of Measure Description (component #5).  This is a convenience method that saves you from 
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
	 * Returns Alternate Unit of Measure Coding System (component #6).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getAlternateUnitOfMeasureCodingSystem() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(6);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}