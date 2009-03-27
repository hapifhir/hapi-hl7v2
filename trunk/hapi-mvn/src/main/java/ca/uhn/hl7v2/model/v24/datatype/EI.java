package ca.uhn.hl7v2.model.v24.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 EI (entity identifier) data type.  Consists of the following components: </p><ol>
 * <li>entity identifier (ST)</li>
 * <li>namespace ID (IS)</li>
 * <li>universal ID (ST)</li>
 * <li>universal ID type (ID)</li>
 * </ol>
 */
public class EI extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a EI.
	 * @param message the Message to which this Type belongs
	 */
	public EI(Message message) {
		super(message);
		data = new Type[4];
		data[0] = new ST(message);
		data[1] = new IS(message, 300);
		data[2] = new ST(message);
		data[3] = new ID(message, 301);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 4 element EI composite"); 
		} 
	} 
	/**
	 * Returns entity identifier (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getEntityIdentifier() {
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
	 * Returns namespace ID (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getNamespaceID() {
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
	 * Returns universal ID (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getUniversalID() {
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
	 * Returns universal ID type (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getUniversalIDType() {
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