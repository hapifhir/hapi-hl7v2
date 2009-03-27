package ca.uhn.hl7v2.model.v22.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 CM_BATCH_TOTAL (CM for Batch Totals) data type.  Consists of the following components: </p><ol>
 * <li>Batch total 1 (NM)</li>
 * <li>Batch total 2 (NM)</li>
 * </ol>
 */
public class CM_BATCH_TOTAL extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a CM_BATCH_TOTAL.
	 * @param message the Message to which this Type belongs
	 */
	public CM_BATCH_TOTAL(Message message) {
		super(message);
		data = new Type[2];
		data[0] = new NM(message);
		data[1] = new NM(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 2 element CM_BATCH_TOTAL composite"); 
		} 
	} 
	/**
	 * Returns Batch total 1 (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getBatchTotal1() {
	   NM ret = null;
	   try {
	      ret = (NM)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Batch total 2 (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getBatchTotal2() {
	   NM ret = null;
	   try {
	      ret = (NM)getComponent(1);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}