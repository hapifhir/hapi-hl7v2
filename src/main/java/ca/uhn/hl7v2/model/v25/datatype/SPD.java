package ca.uhn.hl7v2.model.v25.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 SPD (Specialty Description) data type.  Consists of the following components: </p><ol>
 * <li>Specialty Name (ST)</li>
 * <li>Governing Board (ST)</li>
 * <li>Eligible or Certified (ID)</li>
 * <li>Date of Certification (DT)</li>
 * </ol>
 */
public class SPD extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a SPD.
	 * @param message the Message to which this Type belongs
	 */
	public SPD(Message message) {
		super(message);
		data = new Type[4];
		data[0] = new ST(message);
		data[1] = new ST(message);
		data[2] = new ID(message, 337);
		data[3] = new DT(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 4 element SPD composite"); 
		} 
	} 
	/**
	 * Returns Specialty Name (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getSpecialtyName() {
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
	 * Returns Governing Board (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getGoverningBoard() {
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
	 * Returns Eligible or Certified (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getEligibleOrCertified() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(2);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Date of Certification (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public DT getDateOfCertification() {
	   DT ret = null;
	   try {
	      ret = (DT)getComponent(3);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}