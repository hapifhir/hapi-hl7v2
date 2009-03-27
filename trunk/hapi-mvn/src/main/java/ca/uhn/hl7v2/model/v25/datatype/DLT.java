package ca.uhn.hl7v2.model.v25.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 DLT (Delta) data type.  Consists of the following components: </p><ol>
 * <li>Normal Range (NR)</li>
 * <li>Numeric Threshold (NM)</li>
 * <li>Change Computation (ID)</li>
 * <li>Days Retained (NM)</li>
 * </ol>
 */
public class DLT extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a DLT.
	 * @param message the Message to which this Type belongs
	 */
	public DLT(Message message) {
		super(message);
		data = new Type[4];
		data[0] = new NR(message);
		data[1] = new NM(message);
		data[2] = new ID(message, 523);
		data[3] = new NM(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 4 element DLT composite"); 
		} 
	} 
	/**
	 * Returns Normal Range (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NR getNormalRange() {
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
	 * Returns Numeric Threshold (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getNumericThreshold() {
	   NM ret = null;
	   try {
	      ret = (NM)getComponent(1);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Change Computation (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getChangeComputation() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(2);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Days Retained (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getDaysRetained() {
	   NM ret = null;
	   try {
	      ret = (NM)getComponent(3);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}