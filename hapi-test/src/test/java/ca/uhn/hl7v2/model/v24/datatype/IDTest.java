/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "CommonIDTest.java".  Description:
 * "Unit test class for ca.uhn.hl7v2.model.primitive.CommonID"
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
package ca.uhn.hl7v2.model.v24.datatype;

import java.util.Arrays;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.IndexedErrorCollector;
import ca.uhn.hl7v2.TestSpec;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.GenericMessage;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.validation.impl.ValidationContextFactory;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static ca.uhn.hl7v2.TestSpecBuilder.buildSpecs;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit test class for ca.uhn.hl7v2.model.primitive.CommonID
 * 
 * No TableRepository used yet
 *
 * @author Leslie Mann
 */
public class IDTest {

    private static HapiContext context;

    @Rule public IndexedErrorCollector collector = new IndexedErrorCollector();

    @BeforeClass
    public static void setupBefore() {
        context = new DefaultHapiContext(ValidationContextFactory.defaultValidation());
    }

	static private class Params {
	    int table;
	    String value;
	}
	
	static Params param(int table, String value) {
	    Params p = new Params();
	    p.table = table;
	    p.value = value;
	    return p;
	}
	 
	 /**
	  * Test for default constructor
	  */
	@SuppressWarnings("serial")
    @Test
	 public void testConstructor() {
	    ID commonID = new ID(new GenericMessage.V24(new DefaultModelClassFactory()), 5) {
        };
	 	assertNotNull("Should have a valid ID object", commonID);
	 }
    
	/**
	 * Test for void set/getValue(int, String)
	 */
	
    public static class SetGetSpec extends TestSpec<Params, String> {

        @Override
        protected String transform(Params input) throws Throwable {
            Message message = context.newMessage(GenericMessage.V24.class);
            ID id = new ca.uhn.hl7v2.model.v24.datatype.ID(message);
            id.setTable(input.table);
            id.setValue(input.value);
            return id.getValue();
        }
        
    }
    
	@Test
	public void testSetGetValueStringAndTable() throws DataTypeException {
	    buildSpecs(SetGetSpec.class)
			.add(param(2, null), (String)null)
			.add(param(2, ""), "")
            .add(param(-1,"\"\""), "\"\"")
            .add(param(0,"\"\""), "\"\"")
			.add(param(2, "IDString"), "IDString")
			.add(param(2, getString(200, 'a')), getString(200, 'a'))
			.add(param(2, getString(201, 'a')), DataTypeException.class)			
			.executeTests(collector);
	}


	/**
	 * Testing ability to return the code value
	 */
	@SuppressWarnings("serial")
    @Test
	public void testGetValue() throws DataTypeException {
		ID commonID = new ID(new GenericMessage.V24(new DefaultModelClassFactory()), 5) {
        };
        commonID.setValue("test");
		assertEquals("Should get code value back.", "test", commonID.getValue());
	}
	
	/**
	 * Testing ability to return the number of the HL7 code table
	 */
	@SuppressWarnings("serial")
    @Test
	public void testGetTable() throws DataTypeException {
		ID commonID = new ID(new GenericMessage.V24(new DefaultModelClassFactory()), 5) {
        };
        commonID.setValue("test");
		assertEquals("Should get table number back.", 5, commonID.getTable());
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
