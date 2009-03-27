package ca.uhn.hl7v2.model.v23.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 CM_PCF (Pre-certification required) data type.  Consists of the following components: </p><ol>
 * <li>pre-certification patient type (IS)</li>
 * <li>pre-certification required (ID)</li>
 * <li>pre-certification windwow (TS)</li>
 * </ol>
 */
public class CM_PCF extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a CM_PCF.
	 * @param message the Message to which this Type belongs
	 */
	public CM_PCF(Message message) {
		super(message);
		data = new Type[3];
		data[0] = new IS(message, 0);
		data[1] = new ID(message, 0);
		data[2] = new TS(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 3 element CM_PCF composite"); 
		} 
	} 
	/**
	 * Returns pre-certification patient type (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getPreCertificationPatientType() {
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
	 * Returns pre-certification required (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getPreCertificationRequired() {
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
	 * Returns pre-certification windwow (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public TS getPreCertificationWindwow() {
	   TS ret = null;
	   try {
	      ret = (TS)getComponent(2);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}