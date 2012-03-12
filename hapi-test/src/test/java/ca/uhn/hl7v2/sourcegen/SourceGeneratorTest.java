/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "CommonDTTest.java".  Description:
 * "Unit test class for ca.uhn.hl7v2.model.primitive.CommonDT"
 *
 * The Initial Developer of the Original Code is Bryan Tripp. Copyright (C)
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
package ca.uhn.hl7v2.sourcegen;

import java.util.ArrayList;

import junit.framework.TestCase;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;


/**
 * Unit test class for ca.uhn.hl7v2.sourcegen.SourceGenerator
 * 
 * @author Bryan Tripp, Leslie Mann
 */

public class SourceGeneratorTest extends TestCase {
	private SourceGenerator sourceGenerator;
	
	/**
	 * Constructor for TemplateTest.
	 * @param testName
	 */
	public SourceGeneratorTest(String testName) {
		super(testName);
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(SourceGeneratorTest.class);
	}

	/**
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		sourceGenerator = new SourceGenerator();
	}

	/**
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		sourceGenerator = null;
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
		assertNotNull("Should have a valid SourceGeneratorTest object", sourceGenerator);
	}

	/**
	 * Testing getVersionPackagePath() with various version strings
	 */
	public void testGetVersionPackagePath() throws DataTypeException {
		class TestSpec {
			String ver;
			Object outcome;
			Exception exception = null;
			
			TestSpec(String ver, Object outcome) {
				this.ver = ver;
				this.outcome = outcome;
			}
			
			public String toString() {
				return "[ " + ver + " : "
					+ (outcome != null ? outcome : "null")
 			    	+ (exception != null ? " [ " + exception.toString() + " ]":" ]");
			}
			
			public boolean executeTest() {
				try {
					String retval = DefaultModelClassFactory.getVersionPackagePath(ver);
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
			new TestSpec(null, HL7Exception.class),
			new TestSpec("", HL7Exception.class),
			new TestSpec(" ", HL7Exception.class),
			new TestSpec("2", HL7Exception.class),
			new TestSpec("20", HL7Exception.class),
			new TestSpec("2", HL7Exception.class),
			new TestSpec("2.1", "ca/uhn/hl7v2/model/v21/"),
			new TestSpec("2.2", "ca/uhn/hl7v2/model/v22/"),
			new TestSpec("2.3", "ca/uhn/hl7v2/model/v23/"),
			new TestSpec("2.3.1", "ca/uhn/hl7v2/model/v231/"),
			new TestSpec("2.4", "ca/uhn/hl7v2/model/v24/"),
			new TestSpec("2.5", "ca/uhn/hl7v2/model/v25/"),
			new TestSpec("2.5.1", "ca/uhn/hl7v2/model/v251/"),
			new TestSpec("2.6", "ca/uhn/hl7v2/model/v26/")
		};
		
		ArrayList<TestSpec> failedTests = new ArrayList<TestSpec>();

		for (int i = 0; i < tests.length ; i++) {
			if ( ! tests[ i ].executeTest() ) 
         		failedTests.add( tests[ i ] );
		}

   		assertEquals("Failures: " + failedTests, 0, failedTests.size()); 
	}

	/**
	 * Testing getVersionPackageName() with various version strings
	 */
	public void testGetVersionPackageName() throws DataTypeException {
		class TestSpec {
			String ver;
			Object outcome;
			Exception exception = null;
			
			TestSpec(String ver, Object outcome) {
				this.ver = ver;
				this.outcome = outcome;
			}
			
			public String toString() {
				return "[ " + ver + " : "
					+ (outcome != null ? outcome : "null")
					+ (exception != null ? " [ " + exception.toString() + " ]":" ]");
			}
			
			public boolean executeTest() {
				try {
					String retval = DefaultModelClassFactory.getVersionPackageName(ver);
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
			new TestSpec(null, HL7Exception.class),
			new TestSpec("", HL7Exception.class),
			new TestSpec(" ", HL7Exception.class),
			new TestSpec("2", HL7Exception.class),
			new TestSpec("20", HL7Exception.class),
			new TestSpec("2", HL7Exception.class),
			new TestSpec("2.1", "ca.uhn.hl7v2.model.v21."),
			new TestSpec("2.2", "ca.uhn.hl7v2.model.v22."),
			new TestSpec("2.3", "ca.uhn.hl7v2.model.v23."),
			new TestSpec("2.3.1", "ca.uhn.hl7v2.model.v231."),
			new TestSpec("2.4", "ca.uhn.hl7v2.model.v24."),
			new TestSpec("2.5", "ca.uhn.hl7v2.model.v25."),
			new TestSpec("2.5.1", "ca.uhn.hl7v2.model.v251."),
			new TestSpec("2.6", "ca.uhn.hl7v2.model.v26.")
		};
		
		ArrayList<TestSpec> failedTests = new ArrayList<TestSpec>();

		for (int i = 0; i < tests.length ; i++) {
			if ( ! tests[ i ].executeTest() ) 
				failedTests.add( tests[ i ] );
		}

		assertEquals("Failures: " + failedTests, 0, failedTests.size()); 
	}

	/** Tests makeAccessorName() */
	public void testMakeAccessorName() {        
		class TestSpec {
			String fieldDesc;
			Object outcome;
			Exception exception = null;
			
			TestSpec(String fieldDesc, Object outcome) {
				this.fieldDesc = fieldDesc;
				this.outcome = outcome;
			}
			
			public String toString() {
				return "[ " + fieldDesc + " : "
					+ (outcome != null ? outcome : "null")
					+ (exception != null ? " [ " + exception.toString() + " ]":" ]");
			}
			
			public boolean executeTest() {
				try {
					String retval = "get" + SourceGenerator.makeAccessorName(fieldDesc, "");
					return retval.equals(outcome);
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
			new TestSpec("name of coding system", "getNameOfCodingSystem"),
			new TestSpec("name (OF) coding system", "getNameCodingSystem"),
			new TestSpec("name of (coding) system", "getNameOfCodingSystem"),
			new TestSpec("name of coding ***..& system", "getNameOfCodingSystem"),
			new TestSpec("name of (cod (ing)) system", "getNameOfCodingSystem"),
			new TestSpec("name of coding (system)", "getNameOfCodingSystem"),    
			new TestSpec("name of (cod (ing)) () system", "getNameOfCodingSystem"),            
			new TestSpec("foo (TS)", "getFoo"),
			new TestSpec("(INTERNAL)", "getINTERNAL"),
		};

		for (int i = 0; i < tests.length ; i++) {
			if ( ! tests[ i ].executeTest() ) 
				fail( tests[ i ].toString() );
		}

	}


	/** Tests getAlternateType() */
	public void testGetAlternateType() {
		class TestSpec {
			String type;
			String ver;
			Object outcome;
			Exception exception = null;
			
			TestSpec(String type, String ver, Object outcome) {
				this.type = type;
				this.ver = ver;
				this.outcome = outcome;
			}
			
			public String toString() {
				return "[ " + type + "," + ver + " : "
					+ (outcome != null ? outcome : "null")
					+ (exception != null ? " [ " + exception.toString() + " ]":" ]");
			}
			
			public boolean executeTest() {
				try {
					String retval = SourceGenerator.getAlternateType(type, ver);
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
			//new TestSpec(null, "2.4",null),  
			new TestSpec("", "2.4", ""),
			new TestSpec("Varies", "2.4", "Varies"),
			new TestSpec("varies", "2.4", "Varies"),
			new TestSpec("varies", "0.4", "Varies"),
			new TestSpec("test", "2.4", "test"),
		};

		ArrayList<TestSpec> failedTests = new ArrayList<TestSpec>();

		for (int i = 0; i < tests.length ; i++) {
			if ( ! tests[ i ].executeTest() ) 
				failedTests.add( tests[ i ] );
		}

		assertEquals("Failures: " + failedTests, 0, failedTests.size()); 
	}
}
