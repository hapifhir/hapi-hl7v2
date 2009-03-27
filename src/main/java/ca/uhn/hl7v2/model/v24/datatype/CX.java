package ca.uhn.hl7v2.model.v24.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 CX (extended composite ID with check digit) data type.  Consists of the following components: </p><ol>
 * <li>ID (ST)</li>
 * <li>check digit (ST) (ST)</li>
 * <li>code identifying the check digit scheme employed (ID)</li>
 * <li>assigning authority (HD)</li>
 * <li>identifier type code (ID) (ID)</li>
 * <li>assigning facility (HD)</li>
 * <li>effective date (DT) (DT)</li>
 * <li>expiration date (DT)</li>
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
		data = new Type[8];
		data[0] = new ST(message);
		data[1] = new ST(message);
		data[2] = new ID(message, 0);
		data[3] = new HD(message);
		data[4] = new ID(message, 203);
		data[5] = new HD(message);
		data[6] = new DT(message);
		data[7] = new DT(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 8 element CX composite"); 
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
	 * Returns check digit (ST) (component #1).  This is a convenience method that saves you from 
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
	 * Returns identifier type code (ID) (component #4).  This is a convenience method that saves you from 
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

	/**
	 * Returns effective date (DT) (component #6).  This is a convenience method that saves you from 
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
	 * Returns expiration date (component #7).  This is a convenience method that saves you from 
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

}