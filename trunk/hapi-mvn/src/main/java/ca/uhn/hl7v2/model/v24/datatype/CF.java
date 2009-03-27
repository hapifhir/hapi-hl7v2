package ca.uhn.hl7v2.model.v24.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 CF (coded element with formatted values) data type.  Consists of the following components: </p><ol>
 * <li>identifier (ID) (ID)</li>
 * <li>formatted text (FT)</li>
 * <li>name of coding system (IS)</li>
 * <li>alternate identifier (ID) (ID)</li>
 * <li>alternate formatted text (FT)</li>
 * <li>name of alternate coding system (IS)</li>
 * </ol>
 */
public class CF extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a CF.
	 * @param message the Message to which this Type belongs
	 */
	public CF(Message message) {
		super(message);
		data = new Type[6];
		data[0] = new ID(message, 0);
		data[1] = new FT(message);
		data[2] = new IS(message, 0);
		data[3] = new ID(message, 0);
		data[4] = new FT(message);
		data[5] = new IS(message, 0);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 6 element CF composite"); 
		} 
	} 
	/**
	 * Returns identifier (ID) (component #0).  This is a convenience method that saves you from 
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
	 * Returns formatted text (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public FT getFormattedText() {
	   FT ret = null;
	   try {
	      ret = (FT)getComponent(1);
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
	public IS getNameOfCodingSystem() {
	   IS ret = null;
	   try {
	      ret = (IS)getComponent(2);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns alternate identifier (ID) (component #3).  This is a convenience method that saves you from 
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
	 * Returns alternate formatted text (component #4).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public FT getAlternateFormattedText() {
	   FT ret = null;
	   try {
	      ret = (FT)getComponent(4);
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
	public IS getNameOfAlternateCodingSystem() {
	   IS ret = null;
	   try {
	      ret = (IS)getComponent(5);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}