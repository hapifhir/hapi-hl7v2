package ca.uhn.hl7v2.model.v231.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 DLN (driver's license number) data type.  Consists of the following components: </p><ol>
 * <li>Driver´s License Number (ST)</li>
 * <li>Issuing State, province, country (IS)</li>
 * <li>expiration date (DT)</li>
 * </ol>
 */
public class DLN extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a DLN.
	 * @param message the Message to which this Type belongs
	 */
	public DLN(Message message) {
		super(message);
		data = new Type[3];
		data[0] = new ST(message);
		data[1] = new IS(message, 0);
		data[2] = new DT(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 3 element DLN composite"); 
		} 
	} 
	/**
	 * Returns Driver´s License Number (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getDriverSLicenseNumber() {
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
	 * Returns Issuing State, province, country (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getIssuingStateProvinceCountry() {
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
	 * Returns expiration date (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public DT getExpirationDate() {
	   DT ret = null;
	   try {
	      ret = (DT)getComponent(2);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}