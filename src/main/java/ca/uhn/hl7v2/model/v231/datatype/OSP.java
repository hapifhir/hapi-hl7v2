package ca.uhn.hl7v2.model.v231.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 OSP (occurence span) data type.  Consists of the following components: </p><ol>
 * <li>occurrence span code (CE)</li>
 * <li>occurrence span start date (DT)</li>
 * <li>occurrence span stop date (DT)</li>
 * </ol>
 */
public class OSP extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a OSP.
	 * @param message the Message to which this Type belongs
	 */
	public OSP(Message message) {
		super(message);
		data = new Type[3];
		data[0] = new CE(message);
		data[1] = new DT(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 3 element OSP composite"); 
		} 
	} 
	/**
	 * Returns occurrence span code (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CE getOccurrenceSpanCode() {
	   CE ret = null;
	   try {
	      ret = (CE)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns occurrence span start date (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public DT getOccurrenceSpanStartDate() {
	   DT ret = null;
	   try {
	      ret = (DT)getComponent(1);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns occurrence span stop date (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public DT getOccurrenceSpanStopDate() {
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