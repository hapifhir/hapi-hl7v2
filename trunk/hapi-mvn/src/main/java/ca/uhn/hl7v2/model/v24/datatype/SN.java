package ca.uhn.hl7v2.model.v24.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 SN (structured numeric) data type.  Consists of the following components: </p><ol>
 * <li>comparator (ST)</li>
 * <li>num1 (NM)</li>
 * <li>separator/suffix (ST)</li>
 * <li>num2 (NM)</li>
 * </ol>
 */
public class SN extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a SN.
	 * @param message the Message to which this Type belongs
	 */
	public SN(Message message) {
		super(message);
		data = new Type[4];
		data[0] = new ST(message);
		data[1] = new NM(message);
		data[2] = new ST(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 4 element SN composite"); 
		} 
	} 
	/**
	 * Returns comparator (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getComparator() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns num1 (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getNum1() {
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
	 * Returns separator/suffix (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getSeparatorSuffix() {
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
	 * Returns num2 (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getNum2() {
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