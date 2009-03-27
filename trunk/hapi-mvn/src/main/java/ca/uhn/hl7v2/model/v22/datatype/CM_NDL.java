package ca.uhn.hl7v2.model.v22.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 CM_NDL (observing practitioner) data type.  Consists of the following components: </p><ol>
 * <li>interpreter / technician (CN)</li>
 * <li>start date/time (TS)</li>
 * <li>end date/time (TS)</li>
 * <li>location (CM_INTERNAL_LOCATION)</li>
 * </ol>
 */
public class CM_NDL extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a CM_NDL.
	 * @param message the Message to which this Type belongs
	 */
	public CM_NDL(Message message) {
		super(message);
		data = new Type[4];
		data[0] = new CN(message);
		data[1] = new TS(message);
		data[2] = new TS(message);
		data[3] = new CM_INTERNAL_LOCATION(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 4 element CM_NDL composite"); 
		} 
	} 
	/**
	 * Returns interpreter / technician (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CN getInterpreterTechnician() {
	   CN ret = null;
	   try {
	      ret = (CN)getComponent(0);
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
	 * Returns location (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CM_INTERNAL_LOCATION getLocation() {
	   CM_INTERNAL_LOCATION ret = null;
	   try {
	      ret = (CM_INTERNAL_LOCATION)getComponent(3);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}