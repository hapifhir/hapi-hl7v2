package ca.uhn.hl7v2.model.v23.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 CX (extended composite ID with check digit) data type.  Consists of the following components: </p><ol>
 * <li>ID (ST)</li>
 * <li>check digit (ST)</li>
 * <li>code identifying the check digit scheme employed (ID)</li>
 * <li>assigning authority (HD)</li>
 * <li>identifier type code (IS)</li>
 * <li>assigning facility (HD)</li>
 * </ol>
 */
public class CX extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a CX.
	 * @param message the Message to which this Type belongs
	 */
	public CX(Message message) {
		super(message);
		data = new Type[6];
		data[0] = new ST(message);
		data[1] = new ST(message);
		data[2] = new ID(message, 0);
		data[3] = new HD(message);
		data[4] = new IS(message, 203);
		data[5] = new HD(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 6 element CX composite"); 
		} 
	} 
	/**
	 * Returns ID (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getID() {
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

	/**
	 * Returns identifier type code (component #4).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getIdentifierTypeCode() {
	   IS ret = null;
	   try {
	      ret = (IS)getComponent(4);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns assigning facility (component #5).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public HD getAssigningFacility() {
	   HD ret = null;
	   try {
	      ret = (HD)getComponent(5);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}