package ca.uhn.hl7v2.model.v25.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 PRL (Parent Result Link) data type.  Consists of the following components: </p><ol>
 * <li>Parent Observation Identifier (CE)</li>
 * <li>Parent Observation Sub-identifier (ST)</li>
 * <li>Parent Observation Value Descriptor (TX)</li>
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
	 * Returns Parent Observation Identifier (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CE getParentObservationIdentifier() {
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
	 * Returns Parent Observation Sub-identifier (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getParentObservationSubIdentifier() {
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
	 * Returns Parent Observation Value Descriptor (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public TX getParentObservationValueDescriptor() {
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