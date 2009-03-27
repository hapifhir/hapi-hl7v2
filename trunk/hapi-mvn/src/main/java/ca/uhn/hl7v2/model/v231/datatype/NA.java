package ca.uhn.hl7v2.model.v231.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 NA (numeric array) data type.  Consists of the following components: </p><ol>
 * <li>value1 (NM)</li>
 * <li>value2 (NM)</li>
 * <li>value3 (NM)</li>
 * <li>value4 (NM)</li>
 * </ol>
 */
public class NA extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a NA.
	 * @param message the Message to which this Type belongs
	 */
	public NA(Message message) {
		super(message);
		data = new Type[4];
		data[0] = new NM(message);
		data[1] = new NM(message);
		data[2] = new NM(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 4 element NA composite"); 
		} 
	} 
	/**
	 * Returns value1 (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getValue1() {
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
	 * Returns value2 (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getValue2() {
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
	 * Returns value3 (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getValue3() {
	   NM ret = null;
	   try {
	      ret = (NM)getComponent(2);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns value4 (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getValue4() {
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