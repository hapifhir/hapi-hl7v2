package ca.uhn.hl7v2.model.v25.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 CD (Channel Definition) data type.  Consists of the following components: </p><ol>
 * <li>Channel Identifier (WVI)</li>
 * <li>Waveform Source (WVS)</li>
 * <li>Channel Sensitivity/Units (CSU)</li>
 * <li>Channel Calibration Parameters (CCP)</li>
 * <li>Channel Sampling Frequency (NM)</li>
 * <li>Minimum/Maximum Data Values (NR)</li>
 * </ol>
 */
public class CD extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a CD.
	 * @param message the Message to which this Type belongs
	 */
	public CD(Message message) {
		super(message);
		data = new Type[6];
		data[0] = new WVI(message);
		data[1] = new WVS(message);
		data[2] = new CSU(message);
		data[3] = new CCP(message);
		data[4] = new NM(message);
		data[5] = new NR(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 6 element CD composite"); 
		} 
	} 
	/**
	 * Returns Channel Identifier (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public WVI getChannelIdentifier() {
	   WVI ret = null;
	   try {
	      ret = (WVI)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Waveform Source (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public WVS getWaveformSource() {
	   WVS ret = null;
	   try {
	      ret = (WVS)getComponent(1);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Channel Sensitivity/Units (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CSU getChannelSensitivityUnits() {
	   CSU ret = null;
	   try {
	      ret = (CSU)getComponent(2);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Channel Calibration Parameters (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CCP getChannelCalibrationParameters() {
	   CCP ret = null;
	   try {
	      ret = (CCP)getComponent(3);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Channel Sampling Frequency (component #4).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getChannelSamplingFrequency() {
	   NM ret = null;
	   try {
	      ret = (NM)getComponent(4);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Minimum/Maximum Data Values (component #5).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NR getMinimumMaximumDataValues() {
	   NR ret = null;
	   try {
	      ret = (NR)getComponent(5);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}