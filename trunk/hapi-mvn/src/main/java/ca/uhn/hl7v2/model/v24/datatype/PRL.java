package ca.uhn.hl7v2.model.v24.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 PRL (parent result link) data type.  Consists of the following components: </p><ol>
 * <li>OBX-3 observation identifier of parent result (CE)</li>
 * <li>OBX-4 sub-ID of parent result (ST)</li>
 * <li>part of OBX-5 observation result from parent (TX)</li>
 * </ol>
 */
public class PRL extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a PRL.
	 * @param message the Message to which this Type belongs
	 */
	public PRL(Message message) {
		super(message);
		data = new Type[3];
		data[0] = new CE(message);
		data[1] = new ST(message);
		data[2] = new TX(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 3 element PRL composite"); 
		} 
	} 
	/**
	 * Returns OBX-3 observation identifier of parent result (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CE getOBX3ObservationIdentifierOfParentResult() {
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
	 * Returns OBX-4 sub-ID of parent result (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getOBX4SubIDOfParentResult() {
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
	 * Returns part of OBX-5 observation result from parent (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public TX getPartOfOBX5ObservationResultFromParent() {
	   TX ret = null;
	   try {
	      ret = (TX)getComponent(2);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}