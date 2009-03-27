package ca.uhn.hl7v2.model.v23.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 CE (coded element) data type.  Consists of the following components: </p><ol>
 * <li>identifier (ID)</li>
 * <li>text (ST)</li>
 * <li>name of coding system (ST)</li>
 * <li>alternate identifier (ID)</li>
 * <li>alternate text (ST)</li>
 * <li>name of alternate coding system (ST)</li>
 * </ol>
 */
public class CE extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a CE.
	 * @param message the Message to which this Type belongs
	 */
	public CE(Message message) {
		super(message);
		data = new Type[6];
		data[0] = new ID(message, 0);
		data[1] = new ST(message);
		data[2] = new ST(message);
		data[3] = new ID(message, 0);
		data[4] = new ST(message);
		data[5] = new ST(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 6 element CE composite"); 
		} 
	} 
	/**
	 * Returns identifier (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getIdentifier() {
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
	 * Returns text (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getText() {
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
	 * Returns name of coding system (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getNameOfCodingSystem() {
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
	 * Returns alternate identifier (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getAlternateIdentifier() {
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
	 * Returns alternate text (component #4).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getAlternateText() {
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
	 * Returns name of alternate coding system (component #5).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getNameOfAlternateCodingSystem() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(5);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}