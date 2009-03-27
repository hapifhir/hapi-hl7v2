package ca.uhn.hl7v2.model.v25.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 RPT (Repeat Pattern) data type.  Consists of the following components: </p><ol>
 * <li>Repeat Pattern Code (CWE)</li>
 * <li>Calendar Alignment (ID)</li>
 * <li>Phase Range Begin Value (NM)</li>
 * <li>Phase Range End Value (NM)</li>
 * <li>Period Quantity (NM)</li>
 * <li>Period Units (IS)</li>
 * <li>Institution Specified Time (ID)</li>
 * <li>Event (ID)</li>
 * <li>Event Offset Quantity (NM)</li>
 * <li>Event Offset Units (IS)</li>
 * <li>General Timing Specification (GTS)</li>
 * </ol>
 */
public class RPT extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a RPT.
	 * @param message the Message to which this Type belongs
	 */
	public RPT(Message message) {
		super(message);
		data = new Type[11];
		data[0] = new CWE(message);
		data[1] = new ID(message, 527);
		data[2] = new NM(message);
		data[3] = new NM(message);
		data[4] = new NM(message);
		data[5] = new IS(message, 0);
		data[6] = new ID(message, 136);
		data[7] = new ID(message, 528);
		data[8] = new NM(message);
		data[9] = new IS(message, 0);
		data[10] = new GTS(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 11 element RPT composite"); 
		} 
	} 
	/**
	 * Returns Repeat Pattern Code (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CWE getRepeatPatternCode() {
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
	 * Returns Calendar Alignment (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getCalendarAlignment() {
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
	 * Returns Phase Range Begin Value (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getPhaseRangeBeginValue() {
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
	 * Returns Phase Range End Value (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getPhaseRangeEndValue() {
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
	 * Returns Period Quantity (component #4).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getPeriodQuantity() {
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
	 * Returns Period Units (component #5).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getPeriodUnits() {
	   IS ret = null;
	   try {
	      ret = (IS)getComponent(5);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Institution Specified Time (component #6).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getInstitutionSpecifiedTime() {
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
	 * Returns Event (component #7).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getEvent() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(7);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Event Offset Quantity (component #8).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getEventOffsetQuantity() {
	   NM ret = null;
	   try {
	      ret = (NM)getComponent(8);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Event Offset Units (component #9).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getEventOffsetUnits() {
	   IS ret = null;
	   try {
	      ret = (IS)getComponent(9);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns General Timing Specification (component #10).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public GTS getGeneralTimingSpecification() {
	   GTS ret = null;
	   try {
	      ret = (GTS)getComponent(10);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}