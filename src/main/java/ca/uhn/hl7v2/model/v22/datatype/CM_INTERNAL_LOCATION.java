package ca.uhn.hl7v2.model.v22.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 CM_INTERNAL_LOCATION (CM für Ortsangaben im Krankenhaus) data type.  Consists of the following components: </p><ol>
 * <li>nurse unit (Station) (ID)</li>
 * <li>Room (ID)</li>
 * <li>Bed (ID)</li>
 * <li>Facility ID (ID)</li>
 * <li>Bed Status (ID)</li>
 * <li>Etage (ID)</li>
 * <li>Klinik (ID)</li>
 * <li>Zentrum (ID)</li>
 * </ol>
 */
public class CM_INTERNAL_LOCATION extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a CM_INTERNAL_LOCATION.
	 * @param message the Message to which this Type belongs
	 */
	public CM_INTERNAL_LOCATION(Message message) {
		super(message);
		data = new Type[8];
		data[0] = new ID(message, 0);
		data[1] = new ID(message, 0);
		data[2] = new ID(message, 0);
		data[3] = new ID(message, 0);
		data[4] = new ID(message, 0);
		data[5] = new ID(message, 0);
		data[6] = new ID(message, 0);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 8 element CM_INTERNAL_LOCATION composite"); 
		} 
	} 
	/**
	 * Returns nurse unit (Station) (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getNurseUnitStation() {
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
	 * Returns Room (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getRoom() {
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
	 * Returns Bed (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getBed() {
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
	 * Returns Facility ID (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getFacilityID() {
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
	 * Returns Bed Status (component #4).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getBedStatus() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(4);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Etage (component #5).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getEtage() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(5);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Klinik (component #6).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getKlinik() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(6);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Zentrum (component #7).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getZentrum() {
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