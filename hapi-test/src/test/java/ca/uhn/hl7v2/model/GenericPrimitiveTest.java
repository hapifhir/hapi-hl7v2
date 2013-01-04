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

import static ca.uhn.hl7v2.TestSpecBuilder.buildSpecs;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.IndexedErrorCollector;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;

/**
 * Unit test class for ca.uhn.hl7v2.model.GenericPrimitive
 * 
 * @author 
 */

public class GenericPrimitiveTest {
	private static GenericPrimitive genericPrimitive;
	private static GenericMessage message;
	
    @Rule public IndexedErrorCollector collector = new IndexedErrorCollector();

    @BeforeClass
	public static void setUp() throws Exception {
        message = new GenericMessage.V25(new DefaultModelClassFactory());
        message.initQuickstart("ADT", "A01", "T");
		genericPrimitive = new GenericPrimitive(message);
	}
	 
	/**
	 * Testing default constructor
	 */
    @Test
	public void testConstructor() {
		assertNotNull("Should have a valid GenericPrimitiveTest object", genericPrimitive);
	}

    @Test
    public void testClear() throws HL7Exception {	
		genericPrimitive.parse("AAAA");
		genericPrimitive.clear();
		assertNull(genericPrimitive.getValue());
	}
	
    public static class SetGetSpec extends ca.uhn.hl7v2.TestSpec<String, String> {

        @Override
        protected String transform(String input) throws Throwable {
            GenericPrimitive gp = new GenericPrimitive(message);
            gp.setValue(input);
            return gp.getValue();
        }
        
    }
	/**
	 * Testing set/getValue() with various date strings
	 */
	public void testSetGetValue() throws DataTypeException {

    	buildSpecs(SetGetSpec.class)
			.add(null, (String)null)
			.add("", "")
			.add(" ", " ")
			.add("abcdefghijklmnopqrstuv","abcdefghijklmnopqrstuv")
			.add("1234aBCDerfgkyuy^asdflkasd|adsjkl","1234aBCDerfgkyuy^asdflkasd|adsjkl")
			.add(" ", " ")
			.add("", "")
			.executeTests(collector);

	}

	/**
	 * Testing getName()
	 */
	public void testGetName() {
		assertEquals(genericPrimitive.getName(),"UNKNOWN");
	}
}
