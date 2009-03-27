package ca.uhn.hl7v2.model.v24.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 XCN (extended composite ID number and name for persons) data type.  Consists of the following components: </p><ol>
 * <li>ID number (ST) (ST)</li>
 * <li>family name (FN)</li>
 * <li>given name (ST)</li>
 * <li>second and further given names or initials thereof (ST)</li>
 * <li>suffix (e.g., JR or III) (ST)</li>
 * <li>prefix (e.g., DR) (ST)</li>
 * <li>degree (e.g., MD) (IS)</li>
 * <li>source table (IS)</li>
 * <li>assigning authority (HD)</li>
 * <li>name type code (ID)</li>
 * <li>identifier check digit (ST)</li>
 * <li>code identifying the check digit scheme employed (ID)</li>
 * <li>identifier type code (IS) (IS)</li>
 * <li>assigning facility (HD)</li>
 * <li>Name Representation code (ID)</li>
 * <li>name context (CE)</li>
 * <li>name validity range (DR)</li>
 * <li>name assembly order (ID)</li>
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
		data = new Type[18];
		data[0] = new ST(message);
		data[1] = new FN(message);
		data[2] = new ST(message);
		data[3] = new ST(message);
		data[4] = new ST(message);
		data[5] = new ST(message);
		data[6] = new IS(message, 0);
		data[7] = new IS(message, 0);
		data[8] = new HD(message);
		data[9] = new ID(message, 0);
		data[10] = new ST(message);
		data[11] = new ID(message, 0);
		data[12] = new IS(message, 0);
		data[13] = new HD(message);
		data[14] = new ID(message, 0);
		data[15] = new CE(message);
		data[16] = new DR(message);
		data[17] = new ID(message, 0);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 18 element XCN composite"); 
		} 
	} 
	/**
	 * Returns ID number (ST) (component #0).  This is a convenience method that saves you from 
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
	 * Returns family name (component #1).  This is a convenience method that saves you from 
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
	 * Returns given name (component #2).  This is a convenience method that saves you from 
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
	 * Returns second and further given names or initials thereof (component #3).  This is a convenience method that saves you from 
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
	 * Returns suffix (e.g., JR or III) (component #4).  This is a convenience method that saves you from 
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
	 * Returns prefix (e.g., DR) (component #5).  This is a convenience method that saves you from 
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
	 * Returns degree (e.g., MD) (component #6).  This is a convenience method that saves you from 
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
	 * Returns source table (component #7).  This is a convenience method that saves you from 
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
	 * Returns assigning authority (component #8).  This is a convenience method that saves you from 
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
	 * Returns name type code (component #9).  This is a convenience method that saves you from 
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
	 * Returns identifier check digit (component #10).  This is a convenience method that saves you from 
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
	 * Returns code identifying the check digit scheme employed (component #11).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getCodeIdentifyingTheCheckDigitSchemeEmployed() {
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
	 * Returns identifier type code (IS) (component #12).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getIdentifierTypeCode() {
	   IS ret = null;
	   try {
	      ret = (IS)getComponent(12);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns assigning facility (component #13).  This is a convenience method that saves you from 
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
	 * Returns Name Representation code (component #14).  This is a convenience method that saves you from 
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
	 * Returns name context (component #15).  This is a convenience method that saves you from 
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
	 * Returns name validity range (component #16).  This is a convenience method that saves you from 
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
	 * Returns name assembly order (component #17).  This is a convenience method that saves you from 
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

}