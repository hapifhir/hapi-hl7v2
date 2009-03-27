package ca.uhn.hl7v2.model.v25.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 XTN (Extended Telecommunication Number) data type.  Consists of the following components: </p><ol>
 * <li>Telephone Number (ST)</li>
 * <li>Telecommunication Use Code (ID)</li>
 * <li>Telecommunication Equipment Type (ID)</li>
 * <li>Email Address (ST)</li>
 * <li>Country Code (NM)</li>
 * <li>Area/City Code (NM)</li>
 * <li>Local Number (NM)</li>
 * <li>Extension (NM)</li>
 * <li>Any Text (ST)</li>
 * <li>Extension Prefix (ST)</li>
 * <li>Speed Dial Code (ST)</li>
 * <li>Unformatted Telephone number (ST)</li>
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
		data = new Type[12];
		data[0] = new ST(message);
		data[1] = new ID(message, 201);
		data[2] = new ID(message, 202);
		data[3] = new ST(message);
		data[4] = new NM(message);
		data[5] = new NM(message);
		data[6] = new NM(message);
		data[7] = new NM(message);
		data[8] = new ST(message);
		data[9] = new ST(message);
		data[10] = new ST(message);
		data[11] = new ST(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 12 element XTN composite"); 
		} 
	} 
	/**
	 * Returns Telephone Number (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getTelephoneNumber() {
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
	 * Returns Telecommunication Use Code (component #1).  This is a convenience method that saves you from 
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
	 * Returns Telecommunication Equipment Type (component #2).  This is a convenience method that saves you from 
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
	 * Returns Email Address (component #3).  This is a convenience method that saves you from 
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
	 * Returns Area/City Code (component #5).  This is a convenience method that saves you from 
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
	 * Returns Local Number (component #6).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getLocalNumber() {
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
	 * Returns Any Text (component #8).  This is a convenience method that saves you from 
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

	/**
	 * Returns Extension Prefix (component #9).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getExtensionPrefix() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(9);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Speed Dial Code (component #10).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getSpeedDialCode() {
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
	 * Returns Unformatted Telephone number (component #11).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getUnformattedTelephoneNumber() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(11);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}