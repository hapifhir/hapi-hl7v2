package ca.uhn.hl7v2.model.v25.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 MSG (Message Type) data type.  Consists of the following components: </p><ol>
 * <li>Message Code (ID)</li>
 * <li>Trigger Event (ID)</li>
 * <li>Message Structure (ID)</li>
 * </ol>
 */
public class MSG extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a MSG.
	 * @param message the Message to which this Type belongs
	 */
	public MSG(Message message) {
		super(message);
		data = new Type[3];
		data[0] = new ID(message, 76);
		data[1] = new ID(message, 3);
		data[2] = new ID(message, 354);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 3 element MSG composite"); 
		} 
	} 
	/**
	 * Returns Message Code (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getMessageCode() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Trigger Event (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getTriggerEvent() {
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
	 * Returns Message Structure (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getMessageStructure() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(2);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}