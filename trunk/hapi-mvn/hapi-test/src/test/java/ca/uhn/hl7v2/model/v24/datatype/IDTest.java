package ca.uhn.hl7v2.model.v24.datatype;

import java.util.ArrayList;

import junit.framework.TestCase;

import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.GenericMessage;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.validation.impl.DefaultValidation;

/**
 * Unit test class for ca.uhn.hl7v2.model.v24.datatype.ID
 * 
 * No TableRepository used yet
 *
 * @author Leslie Mann, Elmar Hinz
 */
public class IDTest extends TestCase {
	private int table;
	private String value;
	private ID ID;

	/**
	 * Constructor for IDTest.
	 * @param name
	 */
	public IDTest(String testName) {
		super(testName);
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(IDTest.class);
	}

	/**
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		table = 5;
		value = "test";
		ID = new ID(new GenericMessage.V25(new DefaultModelClassFactory()), table);
	}

	/**
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		ID = null;
	}

	/*
	 ********************************************************** 
	 * Test Cases
	 ********************************************************** 
	 */
	 
	 /**
	  * Test for default constructor
	  */
	 public void testConstructor() {
	 	assertNotNull("Should have a valid ID object", ID);
	 }

	 /**
	  * Test for table and value constructor
	  */
//	 public void testConstructorString() throws DataTypeException {
//		ID = new ID(table, value);
//	 	assertNotNull("Should have a valid ID object", ID);
//	 }

	/**
	 * Test for void set/getValue(int, String)
	 */
	public void testSetGetValueStringAndTable() throws DataTypeException {
		class TestSpec {
			String value;
			int table;
			Object outcome;
			Exception exception = null;

			TestSpec(int table, String value, Object outcome) {
				this.value = value;
				this.table = table;
				this.outcome = outcome;
			}

			public String toString() {
				return "[ " + table + " " + value + " : "
					+ (outcome != null ? outcome : "null")
					+ (exception != null ? " [ " + exception.toString() + " ]"	: " ]");
			}

			public boolean executeTest() {
                Message message = new GenericMessage.V25(new DefaultModelClassFactory());
                message.setValidationContext(new DefaultValidation());
                
				ID id = new ID(message, table);
				try {
					id.setValue(value);
					String retval = id.getValue();
					if (retval != null) {
						return retval.equals(outcome);
					} else {
						return outcome == null;
					}
				} catch (Exception e) {
					if (e.getClass().equals(outcome)) {
						return true;
					} else {
						this.exception = e;
						return (e.getClass().equals(outcome));
					}
				}
			}
		} //inner class

		TestSpec[] tests = {
			new TestSpec(2, null, null),
			new TestSpec(2, "", ""),
			new TestSpec(2, "IDString", "IDString"),
			//new TestSpec(-1, "IDString", DataTypeException.class), //can't test this -- it assumes a DB connection 
			new TestSpec(2, getString(200, 'a'), getString(200, 'a')),
			new TestSpec(2, getString(201, 'a'), DataTypeException.class),
		};

		ArrayList failedTests = new ArrayList();

		for (int i = 0; i < tests.length; i++) {
			if (!tests[i].executeTest())
				failedTests.add(tests[i]);
		}

		assertEquals("Failures: " + failedTests, 0, failedTests.size());
	}

	/**
	 * Test for void set/getValue(String)
	 * table set
	 */
	public void testSetGetValueString() throws DataTypeException {
		class TestSpec {
			String value;
			Object outcome;
			ID ID;
			Exception exception = null;

			TestSpec(String value, Object outcome) throws DataTypeException {
				this.value = value;
				this.outcome = outcome;

                Message message = new GenericMessage.V25(new DefaultModelClassFactory());
                message.setValidationContext(new DefaultValidation());
                this.ID = new ID(message, 1);
                this.ID.setValue("ID");
			}

			public String toString() {
				return "[ " + value + " : "
					+ (outcome != null ? outcome : "null")
					+ (exception != null ? " [ " + exception.toString() + " ]"	: " ]");
			}

			public boolean executeTest() {
				try {
					ID.setValue(value);
					String retval = ID.getValue();
					if (retval != null) {
						return retval.equals(outcome);
					} else {
						return outcome == null;
					}
				} catch (Exception e) {
					if (e.getClass().equals(outcome)) {
						return true;
					} else {
						this.exception = e;
						return (e.getClass().equals(outcome));
					}
				}
			}
		} //inner class

		TestSpec[] tests = {
			new TestSpec(null, null),
			new TestSpec("", ""),
			new TestSpec("IDString", "IDString"),
			new TestSpec(getString(200, 'a'), getString(200, 'a')),
			new TestSpec(getString(201, 'a'), DataTypeException.class),
		};

		ArrayList failedTests = new ArrayList();

		for (int i = 0; i < tests.length; i++) {
			if (!tests[i].executeTest())
				failedTests.add(tests[i]);
		}

		assertEquals("Failures: " + failedTests, 0, failedTests.size());
	}

	/**
	 * Testing ability to return the code value
	 */
	public void testGetValue() throws DataTypeException {
		ID = new ID(new GenericMessage.V25(new DefaultModelClassFactory()), table);
        ID.setValue(value);
		assertEquals("Should get code value back.", value, ID.getValue());
	}
	
	/**
	 * Testing ability to return the number of the HL7 code table
	 */
	public void testGetTable() throws DataTypeException {
		ID = new ID(new GenericMessage.V25(new DefaultModelClassFactory()), table);
        ID.setValue(value);
		assertEquals("Should get table number back.", table, ID.getTable());
	}

	/*
	 * Returns a string of character c repeated length times
	 */
	private String getString(int length, char c) {
		StringBuffer buf = new StringBuffer(length);
		
		for (int i=0;i<length;i++) {
			buf.append(c);
		}
		int l = buf.length();
		return buf.toString();
	}
}
