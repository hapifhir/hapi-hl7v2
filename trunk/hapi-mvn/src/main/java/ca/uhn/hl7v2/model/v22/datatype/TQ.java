package ca.uhn.hl7v2.model.v22.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 TQ (timing quantity) data type.  Consists of the following components: </p><ol>
 * <li>Quantity (CQ_QUANTITY)</li>
 * <li>interval (CM_RI)</li>
 * <li>duration (ST)</li>
 * <li>start date/time (TS)</li>
 * <li>end date/time (TS)</li>
 * <li>priority (ID)</li>
 * <li>condition (ST)</li>
 * <li>text (TX) (TX)</li>
 * <li>conjunction (ID)</li>
 * <li>order sequencing (ST)</li>
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
		data[0] = new CQ_QUANTITY(message);
		data[1] = new CM_RI(message);
		data[2] = new ST(message);
		data[3] = new TS(message);
		data[4] = new TS(message);
		data[5] = new ID(message, 0);
		data[6] = new ST(message);
		data[7] = new TX(message);
		data[8] = new ID(message, 0);
		data[9] = new ST(message);
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
	 * Returns Quantity (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CQ_QUANTITY getQuantity() {
	   CQ_QUANTITY ret = null;
	   try {
	      ret = (CQ_QUANTITY)getComponent(0);
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
	public ID getPriority() {
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
	public ID getConjunction() {
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
	 * Returns order sequencing (component #9).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getOrderSequencing() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(9);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}