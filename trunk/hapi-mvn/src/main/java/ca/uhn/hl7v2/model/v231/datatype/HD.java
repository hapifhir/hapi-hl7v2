package ca.uhn.hl7v2.model.v231.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 HD (hierarchic designator) data type.  Consists of the following components: </p><ol>
 * <li>namespace ID (IS)</li>
 * <li>universal ID (ST)</li>
 * <li>universal ID type (ID)</li>
 * </ol>
 */
public class HD extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a HD.
	 * @param message the Message to which this Type belongs
	 */
	public HD(Message message) {
		super(message);
		data = new Type[3];
		data[0] = new IS(message, 300);
		data[1] = new ST(message);
		data[2] = new ID(message, 301);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 3 element HD composite"); 
		} 
	} 
	/**
	 * Returns namespace ID (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getNamespaceID() {
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
	 * Returns universal ID (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getUniversalID() {
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
	 * Returns universal ID type (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getUniversalIDType() {
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