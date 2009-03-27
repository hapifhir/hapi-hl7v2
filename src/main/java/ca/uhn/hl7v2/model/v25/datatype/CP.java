package ca.uhn.hl7v2.model.v25.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 CP (Composite Price) data type.  Consists of the following components: </p><ol>
 * <li>Price (MO)</li>
 * <li>Price Type (ID)</li>
 * <li>From Value (NM)</li>
 * <li>To Value (NM)</li>
 * <li>Range Units (CE)</li>
 * <li>Range Type (ID)</li>
 * </ol>
 */
public class CP extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a CP.
	 * @param message the Message to which this Type belongs
	 */
	public CP(Message message) {
		super(message);
		data = new Type[6];
		data[0] = new MO(message);
		data[1] = new ID(message, 205);
		data[2] = new NM(message);
		data[3] = new NM(message);
		data[4] = new CE(message);
		data[5] = new ID(message, 298);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 6 element CP composite"); 
		} 
	} 
	/**
	 * Returns Price (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public MO getPrice() {
	   MO ret = null;
	   try {
	      ret = (MO)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Price Type (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getPriceType() {
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
	 * Returns From Value (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getFromValue() {
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
	 * Returns To Value (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getToValue() {
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
	 * Returns Range Units (component #4).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CE getRangeUnits() {
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
	 * Returns Range Type (component #5).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getRangeType() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(5);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}