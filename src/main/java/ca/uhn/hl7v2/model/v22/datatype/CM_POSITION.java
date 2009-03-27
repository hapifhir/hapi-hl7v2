package ca.uhn.hl7v2.model.v22.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 CM_POSITION (Sitzplatz bzw. Saal / Tisch / Stuhl) data type.  Consists of the following components: </p><ol>
 * <li>Saal (ST)</li>
 * <li>Tisch (ST)</li>
 * <li>Stuhl (ST)</li>
 * </ol>
 */
public class CM_POSITION extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a CM_POSITION.
	 * @param message the Message to which this Type belongs
	 */
	public CM_POSITION(Message message) {
		super(message);
		data = new Type[3];
		data[0] = new ST(message);
		data[1] = new ST(message);
		data[2] = new ST(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 3 element CM_POSITION composite"); 
		} 
	} 
	/**
	 * Returns Saal (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getSaal() {
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
	 * Returns Tisch (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getTisch() {
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
	 * Returns Stuhl (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getStuhl() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(2);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}