package ca.uhn.hl7v2.model.v25.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 ED (Encapsulated Data) data type.  Consists of the following components: </p><ol>
 * <li>Source Application (HD)</li>
 * <li>Type of Data (ID)</li>
 * <li>Data Subtype (ID)</li>
 * <li>Encoding (ID)</li>
 * <li>Data (TX)</li>
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
		data[4] = new TX(message);
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
	 * Returns Source Application (component #0).  This is a convenience method that saves you from 
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
	 * Returns Type of Data (component #1).  This is a convenience method that saves you from 
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
	 * Returns Data Subtype (component #2).  This is a convenience method that saves you from 
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
	 * Returns Encoding (component #3).  This is a convenience method that saves you from 
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
	 * Returns Data (component #4).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public TX getData() {
	   TX ret = null;
	   try {
	      ret = (TX)getComponent(4);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}