package ca.uhn.hl7v2.model.v231.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 CCP (channel calibration parameters) data type.  Consists of the following components: </p><ol>
 * <li>channel calibration sensitivity correction factor (NM)</li>
 * <li>channel calibration baseline (NM)</li>
 * <li>channel calibration time skew (NM)</li>
 * </ol>
 */
public class CCP extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a CCP.
	 * @param message the Message to which this Type belongs
	 */
	public CCP(Message message) {
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
			throw new DataTypeException("Element " + number + " doesn't exist in 3 element CCP composite"); 
		} 
	} 
	/**
	 * Returns channel calibration sensitivity correction factor (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getChannelCalibrationSensitivityCorrectionFactor() {
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
	 * Returns channel calibration baseline (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getChannelCalibrationBaseline() {
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
	 * Returns channel calibration time skew (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getChannelCalibrationTimeSkew() {
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