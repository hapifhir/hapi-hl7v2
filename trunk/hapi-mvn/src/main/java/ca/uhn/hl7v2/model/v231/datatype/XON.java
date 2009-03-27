package ca.uhn.hl7v2.model.v231.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 XON (extended composite name and identification number for organizations) data type.  Consists of the following components: </p><ol>
 * <li>organization name (ST)</li>
 * <li>organization name type code (IS)</li>
 * <li>ID number (NM) (NM)</li>
 * <li>check digit (ST)</li>
 * <li>code identifying the check digit scheme employed (ID)</li>
 * <li>assigning authority (HD)</li>
 * <li>identifier type code (IS)</li>
 * <li>assigning facility ID (HD)</li>
 * <li>Name Representation code (ID)</li>
 * </ol>
 */
public class XON extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a XON.
	 * @param message the Message to which this Type belongs
	 */
	public XON(Message message) {
		super(message);
		data = new Type[9];
		data[0] = new ST(message);
		data[1] = new IS(message, 0);
		data[2] = new NM(message);
		data[3] = new ST(message);
		data[4] = new ID(message, 0);
		data[5] = new HD(message);
		data[6] = new IS(message, 0);
		data[7] = new HD(message);
		data[8] = new ID(message, 0);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 9 element XON composite"); 
		} 
	} 
	/**
	 * Returns organization name (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getOrganizationName() {
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
	 * Returns organization name type code (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getOrganizationNameTypeCode() {
	   IS ret = null;
	   try {
	      ret = (IS)getComponent(1);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns ID number (NM) (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getIDNumber() {
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
	 * Returns check digit (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getCheckDigit() {
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
	 * Returns code identifying the check digit scheme employed (component #4).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getCodeIdentifyingTheCheckDigitSchemeEmployed() {
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
	 * Returns assigning authority (component #5).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public HD getAssigningAuthority() {
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
	 * Returns identifier type code (component #6).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getIdentifierTypeCode() {
	   IS ret = null;
	   try {
	      ret = (IS)getComponent(6);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns assigning facility ID (component #7).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public HD getAssigningFacilityID() {
	   HD ret = null;
	   try {
	      ret = (HD)getComponent(7);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Name Representation code (component #8).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getNameRepresentationCode() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(8);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}