package ca.uhn.hl7v2.model.v22.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 CM_LA1 (Location with address information) data type.  Consists of the following components: </p><ol>
 * <li>Dispense / Deliver to Location (CM_INTERNAL_LOCATION)</li>
 * <li>location (AD)</li>
 * </ol>
 */
public class CM_LA1 extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a CM_LA1.
	 * @param message the Message to which this Type belongs
	 */
	public CM_LA1(Message message) {
		super(message);
		data = new Type[2];
		data[0] = new CM_INTERNAL_LOCATION(message);
		data[1] = new AD(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 2 element CM_LA1 composite"); 
		} 
	} 
	/**
	 * Returns Dispense / Deliver to Location (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CM_INTERNAL_LOCATION getDispenseDeliverToLocation() {
	   CM_INTERNAL_LOCATION ret = null;
	   try {
	      ret = (CM_INTERNAL_LOCATION)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns location (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public AD getLocation() {
	   AD ret = null;
	   try {
	      ret = (AD)getComponent(1);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}