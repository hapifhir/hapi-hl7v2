/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "GenericCompositeTest .java".  Description:
 * "Unit test class for ca.uhn.hl7v2.model.tests.GenericComposite "
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
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Inject;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.osgi.framework.BundleContext;

import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.GenericComposite;
import ca.uhn.hl7v2.model.GenericMessage;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.Varies;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;

/**
 * Unit test class for ca.uhn.hl7v2.model.tests.GenericComposite
 * 
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 */
@RunWith(JUnit4TestRunner.class)
public class GenericCompositeTest {
	
    // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(GenericCompositeTest.class);
    
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
    
    
    
    	GenericComposite genericComposite;
	Message message;
	
	@Before
	public void BeforeTheTest() throws Exception {
	    message = new GenericMessage.V25(new DefaultModelClassFactory());
		genericComposite = new GenericComposite(message);
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
		assertNotNull("Should have a valid GenericCompositeTest object", genericComposite);
	}

	/**
	 * Testing getComponent(), attempting to get components at various indexes
	 */
	@Test
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
	@Test
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
	@Test
	public void testGetName() {
		assertEquals(genericComposite.getName(),"UNKNOWN");
	}
}
