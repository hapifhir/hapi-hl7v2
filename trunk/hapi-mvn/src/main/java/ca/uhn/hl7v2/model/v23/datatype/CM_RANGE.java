package ca.uhn.hl7v2.model.v23.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 CM_RANGE (Wertebereich) data type.  Consists of the following components: </p><ol>
 * <li>Low Value (CE)</li>
 * <li>High Value (CE)</li>
 * </ol>
 */
public class CM_RANGE extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a CM_RANGE.
	 * @param message the Message to which this Type belongs
	 */
	public CM_RANGE(Message message) {
		super(message);
		data = new Type[2];
		data[0] = new CE(message);
		data[1] = new CE(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 2 element CM_RANGE composite"); 
		} 
	} 
	/**
	 * Returns Low Value (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CE getLowValue() {
	   CE ret = null;
	   try {
	      ret = (CE)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns High Value (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CE getHighValue() {
	   CE ret = null;
	   try {
	      ret = (CE)getComponent(1);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}