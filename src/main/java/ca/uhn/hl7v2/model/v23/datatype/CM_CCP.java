package ca.uhn.hl7v2.model.v23.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 CM_CCP (channel calibration parameters) data type.  Consists of the following components: </p><ol>
 * <li>sensitivity correction factor (NM)</li>
 * <li>baseline (NM)</li>
 * <li>time skew (NM)</li>
 * </ol>
 */
public class CM_CCP extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a CM_CCP.
	 * @param message the Message to which this Type belongs
	 */
	public CM_CCP(Message message) {
		super(message);
		data = new Type[3];
		data[0] = new NM(message);
		data[1] = new NM(message);
		data[2] = new NM(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 3 element CM_CCP composite"); 
		} 
	} 
	/**
	 * Returns sensitivity correction factor (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getSensitivityCorrectionFactor() {
	   NM ret = null;
	   try {
	      ret = (NM)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns baseline (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getBaseline() {
	   NM ret = null;
	   try {
	      ret = (NM)getComponent(1);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns time skew (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getTimeSkew() {
	   NM ret = null;
	   try {
	      ret = (NM)getComponent(2);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}