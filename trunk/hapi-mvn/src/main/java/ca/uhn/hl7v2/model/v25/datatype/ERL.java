package ca.uhn.hl7v2.model.v25.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 ERL (Error Location) data type.  Consists of the following components: </p><ol>
 * <li>Segment ID (ST)</li>
 * <li>Segment Sequence (NM)</li>
 * <li>Field Position (NM)</li>
 * <li>Field Repetition (NM)</li>
 * <li>Component Number (NM)</li>
 * <li>Sub-Component Number (NM)</li>
 * </ol>
 */
public class ERL extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a ERL.
	 * @param message the Message to which this Type belongs
	 */
	public ERL(Message message) {
		super(message);
		data = new Type[6];
		data[0] = new ST(message);
		data[1] = new NM(message);
		data[2] = new NM(message);
		data[3] = new NM(message);
		data[4] = new NM(message);
		data[5] = new NM(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 6 element ERL composite"); 
		} 
	} 
	/**
	 * Returns Segment ID (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getSegmentID() {
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
	 * Returns Segment Sequence (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getSegmentSequence() {
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
	 * Returns Field Position (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getFieldPosition() {
	   NM ret = null;
	   try {
	      ret = (NM)getComponent(2);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Field Repetition (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getFieldRepetition() {
	   NM ret = null;
	   try {
	      ret = (NM)getComponent(3);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Component Number (component #4).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getComponentNumber() {
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
	 * Returns Sub-Component Number (component #5).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getSubComponentNumber() {
	   NM ret = null;
	   try {
	      ret = (NM)getComponent(5);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}