/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "GenericPrimitiveTest.java".  Description:
 * "Unit test class for ca.uhn.hl7v2.model.GenericPrimitive"
 *
 * The Initial Developer of the Original Code is Leslie Mann. Copyright (C)
 * 2002.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  �GPL�), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 *
 */
package ca.uhn.hl7v2.model;

import java.util.ArrayList;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;

import junit.framework.TestCase;

/**
 * Unit test class for ca.uhn.hl7v2.model.GenericPrimitive
 * 
 * @author 
 */

public class GenericPrimitiveTest extends TestCase {
	GenericPrimitive genericPrimitive;
    GenericMessage message;
	
	/**
	 * Constructor for GenericPrimitiveTest.
	 * 
	 * @param testName
	 */
	public GenericPrimitiveTest(String testName) {
		super(testName);
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(GenericPrimitiveTest.class);
	}

	/**
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
        message = new GenericMessage.V25(new DefaultModelClassFactory());
        message.initQuickstart("ADT", "A01", "T");
		genericPrimitive = new GenericPrimitive(message);
	}

	/**
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		genericPrimitive = null;
	}

	/*
	 ********************************************************** 
	 * Test Cases
	 ********************************************************** 
	 */
	 
	/**
	 * Testing default constructor
	 */
	public void testConstructor() {
		assertNotNull("Should have a valid GenericPrimitiveTest object", genericPrimitive);
	}

	public void testClear() throws HL7Exception {
		
		genericPrimitive.parse("AAAA");
		genericPrimitive.clear();
		assertEquals(null, genericPrimitive.getValue());
	}
	
	/**
	 * Testing set/getValue() with various date strings
	 */
	public void testSetGetValue() throws DataTypeException {
		class TestSpec {
			String value;
			Object outcome;
			Exception exception = null;
			
			TestSpec(String value, Object outcome) {
				this.value = value;
				this.outcome = outcome;
			}
			
			public String toString() {
				return "[ " + value + " : "
					+ (outcome != null ? outcome : "null")
 			    	+ (exception != null ? " [ " + exception.toString() + " ]":" ]");
			}
			
			public boolean executeTest() {
				GenericPrimitive gp = new GenericPrimitive(message);
				try {
					gp.setValue(value);
					String retval = gp.getValue();
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
		}//inner class
    	
		TestSpec [] tests = {
			new TestSpec(null, null),
			new TestSpec("", ""),
			new TestSpec(" ", " "),
			new TestSpec("abcdefghijklmnopqrstuv","abcdefghijklmnopqrstuv"),
			new TestSpec("1234aBCDerfgkyuy^asdflkasd|adsjkl","1234aBCDerfgkyuy^asdflkasd|adsjkl"),
			new TestSpec(" ", " "),
			new TestSpec("", ""),
			new TestSpec(null, null),
		};
		
		ArrayList failedTests = new ArrayList();

		for (int i = 0; i < tests.length ; i++) {
			if ( ! tests[ i ].executeTest() ) 
         		failedTests.add( tests[ i ] );
		}

   		assertEquals("Failures: " + failedTests, 0, failedTests.size()); 
	}

	/**
	 * Testing getName()
	 */
	public void testGetName() {
		assertEquals(genericPrimitive.getName(),"UNKNOWN");
	}
}
