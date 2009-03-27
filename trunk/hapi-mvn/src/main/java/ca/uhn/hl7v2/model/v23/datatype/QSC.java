package ca.uhn.hl7v2.model.v23.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 QSC (query selection criteria) data type.  Consists of the following components: </p><ol>
 * <li>name of field (ST)</li>
 * <li>relational operator (ID)</li>
 * <li>Value (ST)</li>
 * <li>relational conjunction (ID)</li>
 * </ol>
 */
public class QSC extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a QSC.
	 * @param message the Message to which this Type belongs
	 */
	public QSC(Message message) {
		super(message);
		data = new Type[4];
		data[0] = new ST(message);
		data[1] = new ID(message, 0);
		data[2] = new ST(message);
		data[3] = new ID(message, 0);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 4 element QSC composite"); 
		} 
	} 
	/**
	 * Returns name of field (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getNameOfField() {
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
	 * Returns relational operator (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getRelationalOperator() {
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
	 * Returns Value (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getValue() {
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
	 * Returns relational conjunction (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getRelationalConjunction() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(3);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}