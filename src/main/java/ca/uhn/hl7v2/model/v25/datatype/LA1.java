package ca.uhn.hl7v2.model.v25.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 LA1 (Location with Address Variation 1) data type.  Consists of the following components: </p><ol>
 * <li>Point of Care (IS)</li>
 * <li>Room (IS)</li>
 * <li>Bed (IS)</li>
 * <li>Facility (HD)</li>
 * <li>Location Status (IS)</li>
 * <li>Patient Location Type (IS)</li>
 * <li>Building (IS)</li>
 * <li>Floor (IS)</li>
 * <li>Address (AD)</li>
 * </ol>
 */
public class LA1 extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a LA1.
	 * @param message the Message to which this Type belongs
	 */
	public LA1(Message message) {
		super(message);
		data = new Type[9];
		data[0] = new IS(message, 302);
		data[1] = new IS(message, 303);
		data[2] = new IS(message, 304);
		data[3] = new HD(message);
		data[4] = new IS(message, 306);
		data[5] = new IS(message, 305);
		data[6] = new IS(message, 307);
		data[7] = new IS(message, 308);
		data[8] = new AD(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 9 element LA1 composite"); 
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
	 * Returns Address (component #8).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public AD getAddress() {
	   AD ret = null;
	   try {
	      ret = (AD)getComponent(8);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}