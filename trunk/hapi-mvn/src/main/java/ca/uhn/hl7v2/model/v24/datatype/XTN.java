package ca.uhn.hl7v2.model.v24.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 XTN (extended telecommunication number) data type.  Consists of the following components: </p><ol>
 * <li>[(999)] 999-9999 [X99999][C any text] (TN)</li>
 * <li>telecommunication use code (ID)</li>
 * <li>telecommunication equipment type (ID) (ID)</li>
 * <li>Email address (ST)</li>
 * <li>Country Code (NM)</li>
 * <li>Area/city code (NM)</li>
 * <li>Phone number (NM)</li>
 * <li>Extension (NM)</li>
 * <li>any text (ST)</li>
 * </ol>
 */
public class XTN extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a XTN.
	 * @param message the Message to which this Type belongs
	 */
	public XTN(Message message) {
		super(message);
		data = new Type[9];
		data[0] = new TN(message);
		data[1] = new ID(message, 0);
		data[2] = new ID(message, 0);
		data[3] = new ST(message);
		data[4] = new NM(message);
		data[5] = new NM(message);
		data[6] = new NM(message);
		data[7] = new NM(message);
		data[8] = new ST(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 9 element XTN composite"); 
		} 
	} 
	/**
	 * Returns [(999)] 999-9999 [X99999][C any text] (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public TN get9999999X99999CAnyText() {
	   TN ret = null;
	   try {
	      ret = (TN)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns telecommunication use code (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getTelecommunicationUseCode() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(1);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns telecommunication equipment type (ID) (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getTelecommunicationEquipmentType() {
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
	 * Returns Email address (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getEmailAddress() {
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
	 * Returns Country Code (component #4).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getCountryCode() {
	   NM ret = null;
	   try {
	      ret = (NM)getComponent(4);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Area/city code (component #5).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getAreaCityCode() {
	   NM ret = null;
	   try {
	      ret = (NM)getComponent(5);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Phone number (component #6).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getPhoneNumber() {
	   NM ret = null;
	   try {
	      ret = (NM)getComponent(6);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Extension (component #7).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getExtension() {
	   NM ret = null;
	   try {
	      ret = (NM)getComponent(7);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns any text (component #8).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getAnyText() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(8);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}