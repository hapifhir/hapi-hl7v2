package ca.uhn.hl7v2.model.v22.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 CM_SPD (Specialty) data type.  Consists of the following components: </p><ol>
 * <li>specialty name (ST)</li>
 * <li>governing board (ST)</li>
 * <li>eligible or certified (ID)</li>
 * <li>date of certification (DT)</li>
 * </ol>
 */
public class CM_SPD extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a CM_SPD.
	 * @param message the Message to which this Type belongs
	 */
	public CM_SPD(Message message) {
		super(message);
		data = new Type[4];
		data[0] = new ST(message);
		data[1] = new ST(message);
		data[2] = new ID(message, 0);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 4 element CM_SPD composite"); 
		} 
	} 
	/**
	 * Returns specialty name (component #0).  This is a convenience method that saves you from 
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
	 * Returns governing board (component #1).  This is a convenience method that saves you from 
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
	 * Returns eligible or certified (component #2).  This is a convenience method that saves you from 
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
	 * Returns date of certification (component #3).  This is a convenience method that saves you from 
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