package ca.uhn.hl7v2.model.v25.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 SPS (Specimen Source) data type.  Consists of the following components: </p><ol>
 * <li>Specimen Source Name or Code (CWE)</li>
 * <li>Additives (CWE)</li>
 * <li>Specimen Collection Method (TX)</li>
 * <li>Body Site (CWE)</li>
 * <li>Site Modifier (CWE)</li>
 * <li>Collection Method Modifier Code (CWE)</li>
 * <li>Specimen Role (CWE)</li>
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
		data[0] = new CWE(message);
		data[1] = new CWE(message);
		data[2] = new TX(message);
		data[3] = new CWE(message);
		data[4] = new CWE(message);
		data[5] = new CWE(message);
		data[6] = new CWE(message);
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
	 * Returns Specimen Source Name or Code (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CWE getSpecimenSourceNameOrCode() {
	   CWE ret = null;
	   try {
	      ret = (CWE)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Additives (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CWE getAdditives() {
	   CWE ret = null;
	   try {
	      ret = (CWE)getComponent(1);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Specimen Collection Method (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public TX getSpecimenCollectionMethod() {
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
	 * Returns Body Site (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CWE getBodySite() {
	   CWE ret = null;
	   try {
	      ret = (CWE)getComponent(3);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Site Modifier (component #4).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CWE getSiteModifier() {
	   CWE ret = null;
	   try {
	      ret = (CWE)getComponent(4);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Collection Method Modifier Code (component #5).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CWE getCollectionMethodModifierCode() {
	   CWE ret = null;
	   try {
	      ret = (CWE)getComponent(5);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Specimen Role (component #6).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CWE getSpecimenRole() {
	   CWE ret = null;
	   try {
	      ret = (CWE)getComponent(6);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}