package ca.uhn.hl7v2.model.v25.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 XPN (Extended Person Name) data type.  Consists of the following components: </p><ol>
 * <li>Family Name (FN)</li>
 * <li>Given Name (ST)</li>
 * <li>Second and Further Given Names or Initials Thereof (ST)</li>
 * <li>Suffix (e.g., JR or III) (ST)</li>
 * <li>Prefix (e.g., DR) (ST)</li>
 * <li>Degree (e.g., MD) (IS)</li>
 * <li>Name Type Code (ID)</li>
 * <li>Name Representation Code (ID)</li>
 * <li>Name Context (CE)</li>
 * <li>Name Validity Range (DR)</li>
 * <li>Name Assembly Order (ID)</li>
 * <li>Effective Date (TS)</li>
 * <li>Expiration Date (TS)</li>
 * <li>Professional Suffix (ST)</li>
 * </ol>
 */
public class XPN extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a XPN.
	 * @param message the Message to which this Type belongs
	 */
	public XPN(Message message) {
		super(message);
		data = new Type[14];
		data[0] = new FN(message);
		data[1] = new ST(message);
		data[2] = new ST(message);
		data[3] = new ST(message);
		data[4] = new ST(message);
		data[5] = new IS(message, 360);
		data[6] = new ID(message, 200);
		data[7] = new ID(message, 465);
		data[8] = new CE(message);
		data[9] = new DR(message);
		data[10] = new ID(message, 444);
		data[11] = new TS(message);
		data[12] = new TS(message);
		data[13] = new ST(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 14 element XPN composite"); 
		} 
	} 
	/**
	 * Returns Family Name (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public FN getFamilyName() {
	   FN ret = null;
	   try {
	      ret = (FN)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Given Name (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getGivenName() {
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
	 * Returns Second and Further Given Names or Initials Thereof (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getSecondAndFurtherGivenNamesOrInitialsThereof() {
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
	 * Returns Suffix (e.g., JR or III) (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getSuffixEgJRorIII() {
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
	 * Returns Prefix (e.g., DR) (component #4).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getPrefixEgDR() {
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
	 * Returns Degree (e.g., MD) (component #5).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getDegreeEgMD() {
	   IS ret = null;
	   try {
	      ret = (IS)getComponent(5);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Name Type Code (component #6).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getNameTypeCode() {
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
	 * Returns Name Representation Code (component #7).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getNameRepresentationCode() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(7);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Name Context (component #8).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CE getNameContext() {
	   CE ret = null;
	   try {
	      ret = (CE)getComponent(8);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Name Validity Range (component #9).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public DR getNameValidityRange() {
	   DR ret = null;
	   try {
	      ret = (DR)getComponent(9);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Name Assembly Order (component #10).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getNameAssemblyOrder() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(10);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Effective Date (component #11).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public TS getEffectiveDate() {
	   TS ret = null;
	   try {
	      ret = (TS)getComponent(11);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Expiration Date (component #12).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public TS getExpirationDate() {
	   TS ret = null;
	   try {
	      ret = (TS)getComponent(12);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Professional Suffix (component #13).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getProfessionalSuffix() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(13);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}