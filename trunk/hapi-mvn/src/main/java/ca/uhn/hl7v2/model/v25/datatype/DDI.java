package ca.uhn.hl7v2.model.v25.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 DDI (Daily Deductible Information) data type.  Consists of the following components: </p><ol>
 * <li>Delay Days (NM)</li>
 * <li>Monetary Amount (MO)</li>
 * <li>Number of Days (NM)</li>
 * </ol>
 */
public class DDI extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a DDI.
	 * @param message the Message to which this Type belongs
	 */
	public DDI(Message message) {
		super(message);
		data = new Type[3];
		data[0] = new NM(message);
		data[1] = new MO(message);
		data[2] = new NM(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 3 element DDI composite"); 
		} 
	} 
	/**
	 * Returns Delay Days (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getDelayDays() {
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
	 * Returns Monetary Amount (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public MO getMonetaryAmount() {
	   MO ret = null;
	   try {
	      ret = (MO)getComponent(1);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Number of Days (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getNumberOfDays() {
	   NM ret = null;
	   try {
	      ret = (NM)getComponent(2);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}