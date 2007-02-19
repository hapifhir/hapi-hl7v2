/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "GenericCompositeTest .java".  Description:
 * "Unit test class for ca.uhn.hl7v2.model.GenericComposite "
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

import ca.uhn.hl7v2.parser.DefaultModelClassFactory;

import junit.framework.TestCase;

/**
 * Unit test class for ca.uhn.hl7v2.model.GenericComposite
 * 
 * @author 
 */

public class GenericCompositeTest extends TestCase {
	GenericComposite genericComposite;
    Message message;
	
	/**
	 * Constructor for GenericCompositeTest.
	 * 
	 * @param testName
	 */
	public GenericCompositeTest(String testName) {
		super(testName);
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(GenericCompositeTest.class);
	}

	/**
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
        message = new GenericMessage.V25(new DefaultModelClassFactory());
		genericComposite = new GenericComposite(message);
	}

	/**
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		genericComposite = null;
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
		assertNotNull("Should have a valid GenericCompositeTest object", genericComposite);
	}

	/**
	 * Testing getComponent(), attempting to get components at various indexes
	 */
	public void testGetComponent() throws DataTypeException {
		class TestSpec {
			int number;
			Object outcome;
			Exception exception = null;
			
			TestSpec(int number, Object outcome) {
				this.number = number;
				this.outcome = outcome;
			}
			
			public String toString() {
				return "[ " + number + " : "
					+ (outcome != null ? outcome : "null")
 			    	+ (exception != null ? " [ " + exception.toString() + " ]":" ]");
			}
			
			public boolean executeTest() {
				GenericComposite gc = new GenericComposite(message);
				try {
					Object retval = gc.getComponent(number);
					if (retval != null) {
						return retval.getClass().equals(outcome);
					} else {
						return outcome == null;
					}
				} catch (Exception e) {
					if (((Class) outcome).isAssignableFrom(e.getClass())) {
						return true;
					} else {
						this.exception = e;
						return (e.getClass().equals(outcome));
					}
				}
			}
		}//inner class
    	
		TestSpec [] tests = {
			new TestSpec(-1, IndexOutOfBoundsException.class),
			new TestSpec(0, Varies.class),
			new TestSpec(1, Varies.class),
			new TestSpec(2, Varies.class),
			new TestSpec(100, Varies.class),
		};
		
		ArrayList failedTests = new ArrayList();

		for (int i = 0; i < tests.length ; i++) {
			if ( ! tests[ i ].executeTest() ) 
         		failedTests.add( tests[ i ] );
		}

   		assertEquals("Failures: " + failedTests, 0, failedTests.size()); 
	}

	/**
	 * Testing getComponents()
	 */
	public void testGetComponents() throws DataTypeException {
		class TestSpec {
			int number;
			int returnedArraySize;
			Exception exception = null;
			
			TestSpec(int number, int retSize) {
				this.number = number;
				this.returnedArraySize = retSize;
			}
			
			public String toString() {
				return "[ " + number + " : "
					+ returnedArraySize
					+ (exception != null ? " [ " + exception.toString() + " ]":" ]");
			}
			
			public boolean executeTest() {
				GenericComposite gc = new GenericComposite(message);
				try {
					// create some components
					gc.getComponent(number);
					// ignore exceptions (first test spec) 
				} catch (Exception e) {}
				Type[] retval = gc.getComponents();
				return retval.length == returnedArraySize;
			}
		}//inner class
    	
		TestSpec [] tests = {
			new TestSpec(-1, 0),
			new TestSpec(0, 1),
			new TestSpec(1, 2),
			new TestSpec(2, 3),
			new TestSpec(100, 101),
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
		assertEquals(genericComposite.getName(),"UNKNOWN");
	}
}
