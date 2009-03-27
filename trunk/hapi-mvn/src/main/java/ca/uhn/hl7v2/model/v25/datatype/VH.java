package ca.uhn.hl7v2.model.v25.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 VH (Visiting Hours) data type.  Consists of the following components: </p><ol>
 * <li>Start Day Range (ID)</li>
 * <li>End Day Range (ID)</li>
 * <li>Start Hour Range (TM)</li>
 * <li>End Hour Range (TM)</li>
 * </ol>
 */
public class VH extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a VH.
	 * @param message the Message to which this Type belongs
	 */
	public VH(Message message) {
		super(message);
		data = new Type[4];
		data[0] = new ID(message, 267);
		data[1] = new ID(message, 267);
		data[2] = new TM(message);
		data[3] = new TM(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 4 element VH composite"); 
		} 
	} 
	/**
	 * Returns Start Day Range (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getStartDayRange() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns End Day Range (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getEndDayRange() {
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
	 * Returns Start Hour Range (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public TM getStartHourRange() {
	   TM ret = null;
	   try {
	      ret = (TM)getComponent(2);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns End Hour Range (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public TM getEndHourRange() {
	   TM ret = null;
	   try {
	      ret = (TM)getComponent(3);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}