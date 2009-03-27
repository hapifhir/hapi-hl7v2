package ca.uhn.hl7v2.model.v25.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 DIN (Date and Institution Name) data type.  Consists of the following components: </p><ol>
 * <li>Date (TS)</li>
 * <li>Institution Name (CE)</li>
 * </ol>
 */
public class DIN extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a DIN.
	 * @param message the Message to which this Type belongs
	 */
	public DIN(Message message) {
		super(message);
		data = new Type[2];
		data[0] = new TS(message);
		data[1] = new CE(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 2 element DIN composite"); 
		} 
	} 
	/**
	 * Returns Date (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public TS getDate() {
	   TS ret = null;
	   try {
	      ret = (TS)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Institution Name (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CE getInstitutionName() {
	   CE ret = null;
	   try {
	      ret = (CE)getComponent(1);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}