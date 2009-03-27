package ca.uhn.hl7v2.model.v24.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 MA (multiplexed array) data type.  Consists of the following components: </p><ol>
 * <li>sample 1 from channel 1 (NM)</li>
 * <li>sample 1 from channel 2 (NM)</li>
 * <li>sample 1 from channel 3 (NM)</li>
 * <li>sample 1 from channel 4 (NM)</li>
 * <li>sample 1 from channel 5 (NM)</li>
 * <li>sample 1 from channel 6 (NM)</li>
 * </ol>
 */
public class MA extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a MA.
	 * @param message the Message to which this Type belongs
	 */
	public MA(Message message) {
		super(message);
		data = new Type[6];
		data[0] = new NM(message);
		data[1] = new NM(message);
		data[2] = new NM(message);
		data[3] = new NM(message);
		data[4] = new NM(message);
		data[5] = new NM(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 6 element MA composite"); 
		} 
	} 
	/**
	 * Returns sample 1 from channel 1 (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getSample1FromChannel1() {
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
	 * Returns sample 1 from channel 2 (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getSample1FromChannel2() {
	   NM ret = null;
	   try {
	      ret = (NM)getComponent(1);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns sample 1 from channel 3 (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getSample1FromChannel3() {
	   NM ret = null;
	   try {
	      ret = (NM)getComponent(2);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns sample 1 from channel 4 (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getSample1FromChannel4() {
	   NM ret = null;
	   try {
	      ret = (NM)getComponent(3);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns sample 1 from channel 5 (component #4).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getSample1FromChannel5() {
	   NM ret = null;
	   try {
	      ret = (NM)getComponent(4);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns sample 1 from channel 6 (component #5).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getSample1FromChannel6() {
	   NM ret = null;
	   try {
	      ret = (NM)getComponent(5);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}