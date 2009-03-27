package ca.uhn.hl7v2.model.v25.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 RP (Reference Pointer) data type.  Consists of the following components: </p><ol>
 * <li>Pointer (ST)</li>
 * <li>Application ID (HD)</li>
 * <li>Type of Data (ID)</li>
 * <li>Subtype (ID)</li>
 * </ol>
 */
public class RP extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a RP.
	 * @param message the Message to which this Type belongs
	 */
	public RP(Message message) {
		super(message);
		data = new Type[4];
		data[0] = new ST(message);
		data[1] = new HD(message);
		data[2] = new ID(message, 191);
		data[3] = new ID(message, 291);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 4 element RP composite"); 
		} 
	} 
	/**
	 * Returns Pointer (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getPointer() {
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
	 * Returns Application ID (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public HD getApplicationID() {
	   HD ret = null;
	   try {
	      ret = (HD)getComponent(1);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Type of Data (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getTypeOfData() {
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
	 * Returns Subtype (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getSubtype() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(3);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}