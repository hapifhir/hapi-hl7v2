package ca.uhn.hl7v2.model.v25.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 SRT (Sort Order) data type.  Consists of the following components: </p><ol>
 * <li>Sort-by Field (ST)</li>
 * <li>Sequencing (ID)</li>
 * </ol>
 */
public class SRT extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a SRT.
	 * @param message the Message to which this Type belongs
	 */
	public SRT(Message message) {
		super(message);
		data = new Type[2];
		data[0] = new ST(message);
		data[1] = new ID(message, 397);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 2 element SRT composite"); 
		} 
	} 
	/**
	 * Returns Sort-by Field (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getSortByField() {
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
	 * Returns Sequencing (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getSequencing() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(1);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}