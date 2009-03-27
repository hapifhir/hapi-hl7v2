package ca.uhn.hl7v2.model.v25.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 XCN (Extended Composite ID Number and Name for Persons) data type.  Consists of the following components: </p><ol>
 * <li>ID Number (ST)</li>
 * <li>Family Name (FN)</li>
 * <li>Given Name (ST)</li>
 * <li>Second and Further Given Names or Initials Thereof (ST)</li>
 * <li>Suffix (e.g., JR or III) (ST)</li>
 * <li>Prefix (e.g., DR) (ST)</li>
 * <li>Degree (e.g., MD) (IS)</li>
 * <li>Source Table (IS)</li>
 * <li>Assigning Authority (HD)</li>
 * <li>Name Type Code (ID)</li>
 * <li>Identifier Check Digit (ST)</li>
 * <li>Check Digit Scheme (ID)</li>
 * <li>Identifier Type Code (ID)</li>
 * <li>Assigning Facility (HD)</li>
 * <li>Name Representation Code (ID)</li>
 * <li>Name Context (CE)</li>
 * <li>Name Validity Range (DR)</li>
 * <li>Name Assembly Order (ID)</li>
 * <li>Effective Date (TS)</li>
 * <li>Expiration Date (TS)</li>
 * <li>Professional Suffix (ST)</li>
 * <li>Assigning Jurisdiction (CWE)</li>
 * <li>Assigning Agency or Department (CWE)</li>
 * </ol>
 */
public class XCN extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a XCN.
	 * @param message the Message to which this Type belongs
	 */
	public XCN(Message message) {
		super(message);
		data = new Type[23];
		data[0] = new ST(message);
		data[1] = new FN(message);
		data[2] = new ST(message);
		data[3] = new ST(message);
		data[4] = new ST(message);
		data[5] = new ST(message);
		data[6] = new IS(message, 360);
		data[7] = new IS(message, 297);
		data[8] = new HD(message);
		data[9] = new ID(message, 200);
		data[10] = new ST(message);
		data[11] = new ID(message, 61);
		data[12] = new ID(message, 203);
		data[13] = new HD(message);
		data[14] = new ID(message, 465);
		data[15] = new CE(message);
		data[16] = new DR(message);
		data[17] = new ID(message, 444);
		data[18] = new TS(message);
		data[19] = new TS(message);
		data[20] = new ST(message);
		data[21] = new CWE(message);
		data[22] = new CWE(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 23 element XCN composite"); 
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
	 * Returns Family Name (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public FN getFamilyName() {
	   FN ret = null;
	   try {
	      ret = (FN)getComponent(1);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Given Name (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getGivenName() {
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
	 * Returns Second and Further Given Names or Initials Thereof (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getSecondAndFurtherGivenNamesOrInitialsThereof() {
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
	 * Returns Suffix (e.g., JR or III) (component #4).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getSuffixEgJRorIII() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(4);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Prefix (e.g., DR) (component #5).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getPrefixEgDR() {
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
	 * Returns Degree (e.g., MD) (component #6).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getDegreeEgMD() {
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
	 * Returns Source Table (component #7).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getSourceTable() {
	   IS ret = null;
	   try {
	      ret = (IS)getComponent(7);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Assigning Authority (component #8).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public HD getAssigningAuthority() {
	   HD ret = null;
	   try {
	      ret = (HD)getComponent(8);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Name Type Code (component #9).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getNameTypeCode() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(9);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Identifier Check Digit (component #10).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getIdentifierCheckDigit() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(10);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Check Digit Scheme (component #11).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getCheckDigitScheme() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(11);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Identifier Type Code (component #12).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getIdentifierTypeCode() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(12);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Assigning Facility (component #13).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public HD getAssigningFacility() {
	   HD ret = null;
	   try {
	      ret = (HD)getComponent(13);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Name Representation Code (component #14).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getNameRepresentationCode() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(14);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Name Context (component #15).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CE getNameContext() {
	   CE ret = null;
	   try {
	      ret = (CE)getComponent(15);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Name Validity Range (component #16).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public DR getNameValidityRange() {
	   DR ret = null;
	   try {
	      ret = (DR)getComponent(16);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Name Assembly Order (component #17).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getNameAssemblyOrder() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(17);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Effective Date (component #18).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public TS getEffectiveDate() {
	   TS ret = null;
	   try {
	      ret = (TS)getComponent(18);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Expiration Date (component #19).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public TS getExpirationDate() {
	   TS ret = null;
	   try {
	      ret = (TS)getComponent(19);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Professional Suffix (component #20).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getProfessionalSuffix() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(20);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Assigning Jurisdiction (component #21).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CWE getAssigningJurisdiction() {
	   CWE ret = null;
	   try {
	      ret = (CWE)getComponent(21);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Assigning Agency or Department (component #22).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CWE getAssigningAgencyOrDepartment() {
	   CWE ret = null;
	   try {
	      ret = (CWE)getComponent(22);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}