package ca.uhn.hl7v2.model.v231.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 ED (encapsulated data) data type.  Consists of the following components: </p><ol>
 * <li>source application (HD)</li>
 * <li>type of data (ID)</li>
 * <li>data subtype (ID)</li>
 * <li>encoding (ID)</li>
 * <li>data (ST)</li>
 * </ol>
 */
public class ED extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a ED.
	 * @param message the Message to which this Type belongs
	 */
	public ED(Message message) {
		super(message);
		data = new Type[5];
		data[0] = new HD(message);
		data[1] = new ID(message, 191);
		data[2] = new ID(message, 291);
		data[3] = new ID(message, 299);
		data[4] = new ST(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 5 element ED composite"); 
		} 
	} 
	/**
	 * Returns source application (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public HD getSourceApplication() {
	   HD ret = null;
	   try {
	      ret = (HD)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns type of data (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getTypeOfData() {
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
	 * Returns data subtype (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getDataSubtype() {
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
	 * Returns encoding (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getEncoding() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(3);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns data (component #4).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getData() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(4);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}