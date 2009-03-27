package ca.uhn.hl7v2.model.v25.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 XON (Extended Composite Name and Identification Number for Organizations) data type.  Consists of the following components: </p><ol>
 * <li>Organization Name (ST)</li>
 * <li>Organization Name Type Code (IS)</li>
 * <li>ID Number (NM)</li>
 * <li>Check Digit (NM)</li>
 * <li>Check Digit Scheme (ID)</li>
 * <li>Assigning Authority (HD)</li>
 * <li>Identifier Type Code (ID)</li>
 * <li>Assigning Facility (HD)</li>
 * <li>Name Representation Code (ID)</li>
 * <li>Organization Identifier (ST)</li>
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
		data = new Type[10];
		data[0] = new ST(message);
		data[1] = new IS(message, 204);
		data[2] = new NM(message);
		data[3] = new NM(message);
		data[4] = new ID(message, 61);
		data[5] = new HD(message);
		data[6] = new ID(message, 203);
		data[7] = new HD(message);
		data[8] = new ID(message, 465);
		data[9] = new ST(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 10 element XON composite"); 
		} 
	} 
	/**
	 * Returns Organization Name (component #0).  This is a convenience method that saves you from 
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
	 * Returns Organization Name Type Code (component #1).  This is a convenience method that saves you from 
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
	 * Returns ID Number (component #2).  This is a convenience method that saves you from 
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
	 * Returns Check Digit (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getCheckDigit() {
	   NM ret = null;
	   try {
	      ret = (NM)getComponent(3);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Check Digit Scheme (component #4).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getCheckDigitScheme() {
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
	 * Returns Assigning Authority (component #5).  This is a convenience method that saves you from 
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
	 * Returns Identifier Type Code (component #6).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getIdentifierTypeCode() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(6);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Assigning Facility (component #7).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public HD getAssigningFacility() {
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
	 * Returns Name Representation Code (component #8).  This is a convenience method that saves you from 
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

	/**
	 * Returns Organization Identifier (component #9).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getOrganizationIdentifier() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(9);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}