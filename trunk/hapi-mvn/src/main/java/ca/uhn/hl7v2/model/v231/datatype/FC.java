package ca.uhn.hl7v2.model.v231.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 FC (financial class) data type.  Consists of the following components: </p><ol>
 * <li>Financial Class (IS)</li>
 * <li>Effective Date (TS)</li>
 * </ol>
 */
public class FC extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a FC.
	 * @param message the Message to which this Type belongs
	 */
	public FC(Message message) {
		super(message);
		data = new Type[2];
		data[0] = new IS(message, 64);
		data[1] = new TS(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 2 element FC composite"); 
		} 
	} 
	/**
	 * Returns Financial Class (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getFinancialClass() {
	   IS ret = null;
	   try {
	      ret = (IS)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Effective Date (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public TS getEffectiveDate() {
	   TS ret = null;
	   try {
	      ret = (TS)getComponent(1);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}