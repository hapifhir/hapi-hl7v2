package ca.uhn.hl7v2.model.v231.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 CK (composite ID with check digit) data type.  Consists of the following components: </p><ol>
 * <li>ID number (NM) (NM)</li>
 * <li>check digit (ST)</li>
 * <li>code identifying the check digit scheme employed (ID)</li>
 * <li>assigning authority (HD)</li>
 * </ol>
 */
public class CK extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a CK.
	 * @param message the Message to which this Type belongs
	 */
	public CK(Message message) {
		super(message);
		data = new Type[4];
		data[0] = new NM(message);
		data[1] = new ST(message);
		data[2] = new ID(message, 0);
		data[3] = new HD(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 4 element CK composite"); 
		} 
	} 
	/**
	 * Returns ID number (NM) (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getIDNumber() {
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
	 * Returns check digit (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getCheckDigit() {
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
	 * Returns code identifying the check digit scheme employed (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getCodeIdentifyingTheCheckDigitSchemeEmployed() {
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
	 * Returns assigning authority (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public HD getAssigningAuthority() {
	   HD ret = null;
	   try {
	      ret = (HD)getComponent(3);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}