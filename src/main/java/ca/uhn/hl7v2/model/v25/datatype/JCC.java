package ca.uhn.hl7v2.model.v25.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 JCC (Job Code/Class) data type.  Consists of the following components: </p><ol>
 * <li>Job Code (IS)</li>
 * <li>Job Class (IS)</li>
 * <li>Job Description Text (TX)</li>
 * </ol>
 */
public class JCC extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a JCC.
	 * @param message the Message to which this Type belongs
	 */
	public JCC(Message message) {
		super(message);
		data = new Type[3];
		data[0] = new IS(message, 327);
		data[1] = new IS(message, 328);
		data[2] = new TX(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 3 element JCC composite"); 
		} 
	} 
	/**
	 * Returns Job Code (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getJobCode() {
	   IS ret = null;
	   try {
	      ret = (IS)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Job Class (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getJobClass() {
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
	 * Returns Job Description Text (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public TX getJobDescriptionText() {
	   TX ret = null;
	   try {
	      ret = (TX)getComponent(2);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}