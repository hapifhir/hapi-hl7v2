package ca.uhn.hl7v2.model.v25.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 CX (Extended Composite ID with Check Digit) data type.  Consists of the following components: </p><ol>
 * <li>ID Number (ST)</li>
 * <li>Check Digit (ST)</li>
 * <li>Check Digit Scheme (ID)</li>
 * <li>Assigning Authority (HD)</li>
 * <li>Identifier Type Code (ID)</li>
 * <li>Assigning Facility (HD)</li>
 * <li>Effective Date (DT)</li>
 * <li>Expiration Date (DT)</li>
 * <li>Assigning Jurisdiction (CWE)</li>
 * <li>Assigning Agency or Department (CWE)</li>
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
		data = new Type[10];
		data[0] = new ST(message);
		data[1] = new ST(message);
		data[2] = new ID(message, 61);
		data[3] = new HD(message);
		data[4] = new ID(message, 203);
		data[5] = new HD(message);
		data[6] = new DT(message);
		data[7] = new DT(message);
		data[8] = new CWE(message);
		data[9] = new CWE(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 10 element CX composite"); 
		} 
	} 
	/**
	 * Returns ID Number (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getIDNumber() {
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
	 * Returns Check Digit (component #1).  This is a convenience method that saves you from 
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
	 * Returns Check Digit Scheme (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getCheckDigitScheme() {
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
	 * Returns Assigning Authority (component #3).  This is a convenience method that saves you from 
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
	 * Returns Identifier Type Code (component #4).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getIdentifierTypeCode() {
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
	 * Returns Assigning Facility (component #5).  This is a convenience method that saves you from 
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

	/**
	 * Returns Effective Date (component #6).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public DT getEffectiveDate() {
	   DT ret = null;
	   try {
	      ret = (DT)getComponent(6);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Expiration Date (component #7).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public DT getExpirationDate() {
	   DT ret = null;
	   try {
	      ret = (DT)getComponent(7);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Assigning Jurisdiction (component #8).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CWE getAssigningJurisdiction() {
	   CWE ret = null;
	   try {
	      ret = (CWE)getComponent(8);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Assigning Agency or Department (component #9).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CWE getAssigningAgencyOrDepartment() {
	   CWE ret = null;
	   try {
	      ret = (CWE)getComponent(9);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}