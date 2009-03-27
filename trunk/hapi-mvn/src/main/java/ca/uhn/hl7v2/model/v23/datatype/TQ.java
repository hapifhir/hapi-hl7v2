package ca.uhn.hl7v2.model.v23.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 TQ (timing quantity) data type.  Consists of the following components: </p><ol>
 * <li>quantity (CQ)</li>
 * <li>interval (CM_RI)</li>
 * <li>duration (ST)</li>
 * <li>start date/time (TS)</li>
 * <li>end date/time (TS)</li>
 * <li>priority (ST)</li>
 * <li>condition (ST)</li>
 * <li>text (TX) (TX)</li>
 * <li>conjunction (ST)</li>
 * <li>order sequencing (CM_OSD)</li>
 * </ol>
 */
public class TQ extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a TQ.
	 * @param message the Message to which this Type belongs
	 */
	public TQ(Message message) {
		super(message);
		data = new Type[10];
		data[0] = new CQ(message);
		data[1] = new CM_RI(message);
		data[2] = new ST(message);
		data[3] = new TS(message);
		data[4] = new TS(message);
		data[5] = new ST(message);
		data[6] = new ST(message);
		data[7] = new TX(message);
		data[8] = new ST(message);
		data[9] = new CM_OSD(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 10 element TQ composite"); 
		} 
	} 
	/**
	 * Returns quantity (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CQ getQuantity() {
	   CQ ret = null;
	   try {
	      ret = (CQ)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns interval (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CM_RI getInterval() {
	   CM_RI ret = null;
	   try {
	      ret = (CM_RI)getComponent(1);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns duration (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getDuration() {
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
	 * Returns start date/time (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public TS getStartDateTime() {
	   TS ret = null;
	   try {
	      ret = (TS)getComponent(3);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns end date/time (component #4).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public TS getEndDateTime() {
	   TS ret = null;
	   try {
	      ret = (TS)getComponent(4);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns priority (component #5).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getPriority() {
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
	 * Returns condition (component #6).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getCondition() {
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
	 * Returns text (TX) (component #7).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public TX getText() {
	   TX ret = null;
	   try {
	      ret = (TX)getComponent(7);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns conjunction (component #8).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getConjunction() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(8);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns order sequencing (component #9).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CM_OSD getOrderSequencing() {
	   CM_OSD ret = null;
	   try {
	      ret = (CM_OSD)getComponent(9);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}