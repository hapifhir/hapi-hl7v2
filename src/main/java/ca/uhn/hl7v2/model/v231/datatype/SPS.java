package ca.uhn.hl7v2.model.v231.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 SPS (specimen source) data type.  Consists of the following components: </p><ol>
 * <li>specimen source name or code (CE)</li>
 * <li>additives (TX)</li>
 * <li>freetext (TX)</li>
 * <li>body site (CE)</li>
 * <li>site modifier (CE)</li>
 * <li>collection modifier method code (CE)</li>
 * <li>specimen role (CE)</li>
 * </ol>
 */
public class SPS extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a SPS.
	 * @param message the Message to which this Type belongs
	 */
	public SPS(Message message) {
		super(message);
		data = new Type[7];
		data[0] = new CE(message);
		data[1] = new TX(message);
		data[2] = new TX(message);
		data[3] = new CE(message);
		data[4] = new CE(message);
		data[5] = new CE(message);
		data[6] = new CE(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 7 element SPS composite"); 
		} 
	} 
	/**
	 * Returns specimen source name or code (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CE getSpecimenSourceNameOrCode() {
	   CE ret = null;
	   try {
	      ret = (CE)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns additives (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public TX getAdditives() {
	   TX ret = null;
	   try {
	      ret = (TX)getComponent(1);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns freetext (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public TX getFreetext() {
	   TX ret = null;
	   try {
	      ret = (TX)getComponent(2);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns body site (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CE getBodySite() {
	   CE ret = null;
	   try {
	      ret = (CE)getComponent(3);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns site modifier (component #4).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CE getSiteModifier() {
	   CE ret = null;
	   try {
	      ret = (CE)getComponent(4);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns collection modifier method code (component #5).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CE getCollectionModifierMethodCode() {
	   CE ret = null;
	   try {
	      ret = (CE)getComponent(5);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns specimen role (component #6).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CE getSpecimenRole() {
	   CE ret = null;
	   try {
	      ret = (CE)getComponent(6);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}