package ca.uhn.hl7v2.model.v23.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 CM_OSD (order sequence) data type.  Consists of the following components: </p><ol>
 * <li>sequence/results flag (ID)</li>
 * <li>placer order number entity identifier (ST)</li>
 * <li>placer order number namespace ID (IS)</li>
 * <li>filler order number entity identifier (ST)</li>
 * <li>filler order number namespace ID (IS)</li>
 * <li>sequence condition value (ST)</li>
 * <li>maximum number of repeats (NM)</li>
 * <li>placer order number universal ID (ST)</li>
 * <li>placer order number universal ID type (ID)</li>
 * <li>filler order number universal ID (ST)</li>
 * <li>filler order number universal ID type (ID)</li>
 * </ol>
 */
public class CM_OSD extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a CM_OSD.
	 * @param message the Message to which this Type belongs
	 */
	public CM_OSD(Message message) {
		super(message);
		data = new Type[11];
		data[0] = new ID(message, 0);
		data[1] = new ST(message);
		data[2] = new IS(message, 0);
		data[3] = new ST(message);
		data[4] = new IS(message, 0);
		data[5] = new ST(message);
		data[6] = new NM(message);
		data[7] = new ST(message);
		data[8] = new ID(message, 0);
		data[9] = new ST(message);
		data[10] = new ID(message, 0);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 11 element CM_OSD composite"); 
		} 
	} 
	/**
	 * Returns sequence/results flag (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getSequenceResultsFlag() {
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
	 * Returns placer order number entity identifier (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getPlacerOrderNumberEntityIdentifier() {
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
	 * Returns placer order number namespace ID (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getPlacerOrderNumberNamespaceID() {
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
	 * Returns filler order number entity identifier (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getFillerOrderNumberEntityIdentifier() {
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
	 * Returns filler order number namespace ID (component #4).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getFillerOrderNumberNamespaceID() {
	   IS ret = null;
	   try {
	      ret = (IS)getComponent(4);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns sequence condition value (component #5).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getSequenceConditionValue() {
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
	 * Returns maximum number of repeats (component #6).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getMaximumNumberOfRepeats() {
	   NM ret = null;
	   try {
	      ret = (NM)getComponent(6);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns placer order number universal ID (component #7).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getPlacerOrderNumberUniversalID() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(7);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns placer order number universal ID type (component #8).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getPlacerOrderNumberUniversalIDType() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(8);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns filler order number universal ID (component #9).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getFillerOrderNumberUniversalID() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(9);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns filler order number universal ID type (component #10).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getFillerOrderNumberUniversalIDType() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(10);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}