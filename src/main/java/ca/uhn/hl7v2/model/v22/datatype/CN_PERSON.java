package ca.uhn.hl7v2.model.v22.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 CN_PERSON (CN für Personen) data type.  Consists of the following components: </p><ol>
 * <li>ID number (ID)</li>
 * <li>family name (ST)</li>
 * <li>given name (ST)</li>
 * <li>middle initial or name (ST)</li>
 * <li>suffix (e.g. JR or III) (ST)</li>
 * <li>prefix (e.g. DR) (ST)</li>
 * <li>degree (e.g. MD) (ST)</li>
 * <li>source table id (ID)</li>
 * </ol>
 */
public class CN_PERSON extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a CN_PERSON.
	 * @param message the Message to which this Type belongs
	 */
	public CN_PERSON(Message message) {
		super(message);
		data = new Type[8];
		data[0] = new ID(message, 0);
		data[1] = new ST(message);
		data[2] = new ST(message);
		data[3] = new ST(message);
		data[4] = new ST(message);
		data[5] = new ST(message);
		data[6] = new ST(message);
		data[7] = new ID(message, 0);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 8 element CN_PERSON composite"); 
		} 
	} 
	/**
	 * Returns ID number (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getIDNumber() {
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
	 * Returns family name (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getFamilyName() {
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
	 * Returns given name (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getGivenName() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(2);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns middle initial or name (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getMiddleInitialOrName() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(3);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns suffix (e.g. JR or III) (component #4).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getSuffixEgJRorIII() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(4);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns prefix (e.g. DR) (component #5).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getPrefixEgDR() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(5);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns degree (e.g. MD) (component #6).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getDegreeEgMD() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(6);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns source table id (component #7).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getSourceTableId() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(7);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}