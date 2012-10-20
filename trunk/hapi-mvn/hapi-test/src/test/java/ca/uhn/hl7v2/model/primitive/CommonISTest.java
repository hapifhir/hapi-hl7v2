/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "CommonISTest.java".  Description:
 * "Unit test class for ca.uhn.hl7v2.model.primitive.CommonIS"
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
package ca.uhn.hl7v2.model.primitive;

import static ca.uhn.hl7v2.TestSpecBuilder.buildSpecs;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import ca.uhn.hl7v2.TestSpec;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.GenericMessage;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.validation.ValidationContext;
import ca.uhn.hl7v2.validation.impl.ValidationContextFactory;

/**
 * Unit test class for ca.uhn.hl7v2.model.primitive.CommonIS
 *
 * No TableRepository used yet
 * 
 * @author Leslie Mann
 */
public class CommonISTest {

    private static final ModelClassFactory MCF = new DefaultModelClassFactory();
    private static final ValidationContext VC = ValidationContextFactory.defaultValidation();
    
    private IS commonIS;
	
	
	
	@Before
	public void setUp() throws Exception {
		commonIS = new IS(new GenericMessage.V25(MCF), 2) {
        };
	}

	/*
	 ********************************************************** 
	 * Test Cases
	 ********************************************************** 
	 */

	/**
	 * Test default constructor 
	 */
	@Test
	public void testConstructor() {
		assertNotNull("Should have a CommonIS object", commonIS);
	}

	public static class SetGetSpec extends TestSpec<String, String> {

        @Override
        protected String transform(String input) throws Throwable {
            Message message = new GenericMessage.V25(MCF);
            message.setValidationContext(VC);
            IS is = new ca.uhn.hl7v2.model.v25.datatype.IS(message, 0);
            is.setTable(2);
            is.setValue(input);
            return is.getValue();
        }
	    
	}
	
	/**
	 * Test for void set/getValue(int, String)
	 */
	@Test
	public void testSetGetValueStringAndTable() throws DataTypeException {
		buildSpecs(SetGetSpec.class)
			.add(null, (String)null)
			.add("", "")
            .add("\"\"", "\"\"")
            .add("\"\"", "\"\"")
			.add("ISString", "ISString")
			.add(getString(200, 'a'), getString(200, 'a'))
			.add(getString(201, 'a'), DataTypeException.class)
			.executeTests();
	}

	/**
	 * Testing ability to return the code value
	 */
	@Test
	public void testGetValue() throws DataTypeException {
		commonIS = new IS(new GenericMessage.V25(MCF), 2) {
        };
        commonIS.setValue("Value");
		assertEquals("Should get code value back.", "Value", commonIS.getValue());
	}
	
	/**
	 * Testing ability to return the number of the HL7 code table
	 */
    @Test
	public void testGetTable() throws DataTypeException {
        commonIS = new IS(new GenericMessage.V25(MCF), 2) {
        };
        commonIS.setValue("Value");
		assertEquals("Should get table number back.", 2, commonIS.getTable());
	}


    /*
     * Returns a string of character c repeated length times
     */
    private String getString(int length, char c) {
        char[] chars = new char[length];
        Arrays.fill(chars, c);
        return new String(chars);
    }


}
