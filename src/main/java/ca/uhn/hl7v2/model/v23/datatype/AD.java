package ca.uhn.hl7v2.model.v23.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 AD (address) data type.  Consists of the following components: </p><ol>
 * <li>street address (ST)</li>
 * <li>other designation (ST)</li>
 * <li>city (ST)</li>
 * <li>state or province (ST)</li>
 * <li>zip or postal code (ST)</li>
 * <li>country (ID)</li>
 * <li>address type (ID)</li>
 * <li>other geographic designation (ST)</li>
 * </ol>
 */
public class AD extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a AD.
	 * @param message the Message to which this Type belongs
	 */
	public AD(Message message) {
		super(message);
		data = new Type[8];
		data[0] = new ST(message);
		data[1] = new ST(message);
		data[2] = new ST(message);
		data[3] = new ST(message);
		data[4] = new ST(message);
		data[5] = new ID(message, 0);
		data[6] = new ID(message, 0);
		data[7] = new ST(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 8 element AD composite"); 
		} 
	} 
	/**
	 * Returns street address (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getStreetAddress() {
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
	 * Returns other designation (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getOtherDesignation() {
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
	 * Returns city (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getCity() {
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
	 * Returns state or province (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getStateOrProvince() {
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
	 * Returns zip or postal code (component #4).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getZipOrPostalCode() {
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
	 * Returns country (component #5).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getCountry() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(5);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns address type (component #6).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getAddressType() {
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
	 * Returns other geographic designation (component #7).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getOtherGeographicDesignation() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(7);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}