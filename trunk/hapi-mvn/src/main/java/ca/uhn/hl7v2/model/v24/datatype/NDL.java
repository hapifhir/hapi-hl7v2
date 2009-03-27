package ca.uhn.hl7v2.model.v24.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 NDL (observing practitioner) data type.  Consists of the following components: </p><ol>
 * <li>OP name (CNN)</li>
 * <li>start date/time (TS)</li>
 * <li>end date/time (TS)</li>
 * <li>point of care (IS) (IS)</li>
 * <li>room (IS)</li>
 * <li>bed (IS)</li>
 * <li>facility (HD) (HD)</li>
 * <li>location status (IS)</li>
 * <li>person location type (IS)</li>
 * <li>building (IS)</li>
 * <li>floor (IS)</li>
 * </ol>
 */
public class NDL extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a NDL.
	 * @param message the Message to which this Type belongs
	 */
	public NDL(Message message) {
		super(message);
		data = new Type[11];
		data[0] = new CNN(message);
		data[1] = new TS(message);
		data[2] = new TS(message);
		data[3] = new IS(message, 0);
		data[4] = new IS(message, 0);
		data[5] = new IS(message, 0);
		data[6] = new HD(message);
		data[7] = new IS(message, 0);
		data[8] = new IS(message, 0);
		data[9] = new IS(message, 0);
		data[10] = new IS(message, 0);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 11 element NDL composite"); 
		} 
	} 
	/**
	 * Returns OP name (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CNN getOPName() {
	   CNN ret = null;
	   try {
	      ret = (CNN)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns start date/time (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public TS getStartDateTime() {
	   TS ret = null;
	   try {
	      ret = (TS)getComponent(1);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns end date/time (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public TS getEndDateTime() {
	   TS ret = null;
	   try {
	      ret = (TS)getComponent(2);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns point of care (IS) (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getPointOfCare() {
	   IS ret = null;
	   try {
	      ret = (IS)getComponent(3);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns room (component #4).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getRoom() {
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
	 * Returns bed (component #5).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getBed() {
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
	 * Returns facility (HD) (component #6).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public HD getFacility() {
	   HD ret = null;
	   try {
	      ret = (HD)getComponent(6);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns location status (component #7).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getLocationStatus() {
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
	 * Returns person location type (component #8).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getPersonLocationType() {
	   IS ret = null;
	   try {
	      ret = (IS)getComponent(8);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns building (component #9).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getBuilding() {
	   IS ret = null;
	   try {
	      ret = (IS)getComponent(9);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns floor (component #10).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getFloor() {
	   IS ret = null;
	   try {
	      ret = (IS)getComponent(10);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}