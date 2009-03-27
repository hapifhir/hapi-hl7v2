package ca.uhn.hl7v2.model.v231.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 CD (channel definition) data type.  Consists of the following components: </p><ol>
 * <li>channel identifier (WVI)</li>
 * <li>electrode names (WVS)</li>
 * <li>channel sensitivity/units (CSU)</li>
 * <li>calibration parameters (CCP)</li>
 * <li>sampling frequency (NM)</li>
 * <li>minimum/maximum data values (NR)</li>
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
	 * Returns channel identifier (component #0).  This is a convenience method that saves you from 
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
	 * Returns electrode names (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public WVS getElectrodeNames() {
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
	 * Returns channel sensitivity/units (component #2).  This is a convenience method that saves you from 
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
	 * Returns calibration parameters (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CCP getCalibrationParameters() {
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
	 * Returns sampling frequency (component #4).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getSamplingFrequency() {
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
	 * Returns minimum/maximum data values (component #5).  This is a convenience method that saves you from 
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