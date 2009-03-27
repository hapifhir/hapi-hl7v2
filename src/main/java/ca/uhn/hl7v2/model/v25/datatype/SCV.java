package ca.uhn.hl7v2.model.v25.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 SCV (Scheduling Class Value Pair) data type.  Consists of the following components: </p><ol>
 * <li>Parameter Class (CWE)</li>
 * <li>Parameter Value (ST)</li>
 * </ol>
 */
public class SCV extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a SCV.
	 * @param message the Message to which this Type belongs
	 */
	public SCV(Message message) {
		super(message);
		data = new Type[2];
		data[0] = new CWE(message);
		data[1] = new ST(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 2 element SCV composite"); 
		} 
	} 
	/**
	 * Returns Parameter Class (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CWE getParameterClass() {
	   CWE ret = null;
	   try {
	      ret = (CWE)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Parameter Value (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getParameterValue() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(1);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}