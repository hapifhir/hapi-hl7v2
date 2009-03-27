package ca.uhn.hl7v2.model.v25.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 LA2 (Location with Address Variation 2) data type.  Consists of the following components: </p><ol>
 * <li>Point of Care (IS)</li>
 * <li>Room (IS)</li>
 * <li>Bed (IS)</li>
 * <li>Facility (HD)</li>
 * <li>Location Status (IS)</li>
 * <li>Patient Location Type (IS)</li>
 * <li>Building (IS)</li>
 * <li>Floor (IS)</li>
 * <li>Street Address (ST)</li>
 * <li>Other Designation (ST)</li>
 * <li>City (ST)</li>
 * <li>State or Province (ST)</li>
 * <li>Zip or Postal Code (ST)</li>
 * <li>Country (ID)</li>
 * <li>Address Type (ID)</li>
 * <li>Other Geographic Designation (ST)</li>
 * </ol>
 */
public class LA2 extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a LA2.
	 * @param message the Message to which this Type belongs
	 */
	public LA2(Message message) {
		super(message);
		data = new Type[16];
		data[0] = new IS(message, 302);
		data[1] = new IS(message, 303);
		data[2] = new IS(message, 304);
		data[3] = new HD(message);
		data[4] = new IS(message, 306);
		data[5] = new IS(message, 305);
		data[6] = new IS(message, 307);
		data[7] = new IS(message, 308);
		data[8] = new ST(message);
		data[9] = new ST(message);
		data[10] = new ST(message);
		data[11] = new ST(message);
		data[12] = new ST(message);
		data[13] = new ID(message, 399);
		data[14] = new ID(message, 190);
		data[15] = new ST(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 16 element LA2 composite"); 
		} 
	} 
	/**
	 * Returns Point of Care (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getPointOfCare() {
	   IS ret = null;
	   try {
	      ret = (IS)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Room (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getRoom() {
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
	 * Returns Bed (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getBed() {
	   IS ret = null;
	   try {
	      ret = (IS)getComponent(2);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Facility (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public HD getFacility() {
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
	 * Returns Location Status (component #4).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getLocationStatus() {
	   IS ret = null;
	   try {
	      ret = (IS)getComponent(4);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Patient Location Type (component #5).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getPatientLocationType() {
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
	 * Returns Building (component #6).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getBuilding() {
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
	 * Returns Floor (component #7).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getFloor() {
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
	 * Returns Street Address (component #8).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getStreetAddress() {
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
	 * Returns Other Designation (component #9).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getOtherDesignation() {
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
	 * Returns City (component #10).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getCity() {
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
	 * Returns State or Province (component #11).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getStateOrProvince() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(11);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Zip or Postal Code (component #12).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getZipOrPostalCode() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(12);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Country (component #13).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getCountry() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(13);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Address Type (component #14).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getAddressType() {
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
	 * Returns Other Geographic Designation (component #15).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getOtherGeographicDesignation() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(15);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}