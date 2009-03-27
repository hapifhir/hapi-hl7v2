package ca.uhn.hl7v2.model.v22.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 CM_PARENT_RESULT (undefined CM data type) data type.  Consists of the following components: </p><ol>
 * <li>observation identifier (OBX-3) of parent result (CE)</li>
 * <li>sub-ID (OBX-4) of parent result (ST)</li>
 * <li>result (OBX-5) from parent (CE)</li>
 * </ol>
 */
public class CM_PARENT_RESULT extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a CM_PARENT_RESULT.
	 * @param message the Message to which this Type belongs
	 */
	public CM_PARENT_RESULT(Message message) {
		super(message);
		data = new Type[3];
		data[0] = new CE(message);
		data[1] = new ST(message);
		data[2] = new CE(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 3 element CM_PARENT_RESULT composite"); 
		} 
	} 
	/**
	 * Returns observation identifier (OBX-3) of parent result (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CE getObservationIdentifierOBX3OfParentResult() {
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
	 * Returns sub-ID (OBX-4) of parent result (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getSubIDOBX4OfParentResult() {
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
	 * Returns result (OBX-5) from parent (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CE getResultOBX5FromParent() {
	   CE ret = null;
	   try {
	      ret = (CE)getComponent(2);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}