package ca.uhn.hl7v2.model.v23.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 CM_CSU (channel sensitivity/units) data type.  Consists of the following components: </p><ol>
 * <li>sensitivity (NM)</li>
 * <li>units identifier (ID)</li>
 * <li>units text (ST)</li>
 * <li>units name of coding system (ST)</li>
 * <li>units alternate identifier (ID)</li>
 * <li>units alternate text (ST)</li>
 * <li>units name of alternate coding system (ST)</li>
 * </ol>
 */
public class CM_CSU extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a CM_CSU.
	 * @param message the Message to which this Type belongs
	 */
	public CM_CSU(Message message) {
		super(message);
		data = new Type[7];
		data[0] = new NM(message);
		data[1] = new ID(message, 0);
		data[2] = new ST(message);
		data[3] = new ST(message);
		data[4] = new ID(message, 0);
		data[5] = new ST(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 7 element CM_CSU composite"); 
		} 
	} 
	/**
	 * Returns sensitivity (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getSensitivity() {
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
	 * Returns units identifier (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getUnitsIdentifier() {
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
	 * Returns units text (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getUnitsText() {
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
	 * Returns units name of coding system (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getUnitsNameOfCodingSystem() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(3);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns units alternate identifier (component #4).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getUnitsAlternateIdentifier() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(4);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns units alternate text (component #5).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getUnitsAlternateText() {
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
	 * Returns units name of alternate coding system (component #6).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getUnitsNameOfAlternateCodingSystem() {
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