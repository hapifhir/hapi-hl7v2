/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "GenericPrimitiveTest.java".  Description:
 * "Unit test class for ca.uhn.hl7v2.model.tests.GenericPrimitive"
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
package ca.uhn.hl7v2.model.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.ops4j.pax.exam.CoreOptions.equinox;
import static org.ops4j.pax.exam.CoreOptions.felix;
import static org.ops4j.pax.exam.CoreOptions.frameworks;
import static org.ops4j.pax.exam.CoreOptions.knopflerfish;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.options;
import static org.ops4j.pax.exam.CoreOptions.systemProperty;
import static org.ops4j.pax.exam.CoreOptions.wrappedBundle;
import static org.ops4j.pax.exam.container.def.PaxRunnerOptions.logProfile;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Inject;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.osgi.framework.BundleContext;

import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.GenericMessage;
import ca.uhn.hl7v2.model.GenericPrimitive;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;


/**
 * Unit test class for ca.uhn.hl7v2.model.tests.GenericPrimitive
 * 
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 */
@RunWith(JUnit4TestRunner.class)
public class GenericPrimitiveTest  {
	
    // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(GenericPrimitiveTest.class);
    
    @Inject
    BundleContext bundleContext;
    
    @Configuration
    public static Option[] configure() {
	return options(frameworks(equinox(), felix(), knopflerfish())
		, logProfile()
		, systemProperty("org.ops4j.pax.logging.DefaultServiceLog.level").value("INFO")
		, mavenBundle().groupId("org.ops4j.pax.url").artifactId("pax-url-mvn").version("0.4.0")
		, wrappedBundle(mavenBundle().groupId("org.ops4j.base").artifactId("ops4j-base-util").version("0.5.3"))
		, mavenBundle().groupId("ca.uhn.hapi").artifactId("hapi-osgi-base").version("1.0-beta1")
//		, vmOption("-Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5006" )


	);
    }
    
        GenericPrimitive genericPrimitive;
        GenericMessage message;
	
	@Before
    	public void BeforeTheTest() throws Exception {
	        message = new GenericMessage.V25(new DefaultModelClassFactory());
		genericPrimitive = new GenericPrimitive(message);
	}

	@After
	public void AfterTheTest() throws Exception {
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
	@Test
	public void testConstructor() {
		assertNotNull("Should have a valid GenericPrimitiveTest object", genericPrimitive);
	}

	/**
	 * Testing set/getValue() with various date strings
	 */
	@Test
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
	@Test
	public void testGetName() {
		assertEquals(genericPrimitive.getName(),"UNKNOWN");
	}
}
