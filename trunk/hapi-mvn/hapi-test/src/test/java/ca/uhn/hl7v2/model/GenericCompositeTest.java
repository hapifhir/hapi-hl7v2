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

import static ca.uhn.hl7v2.TestSpecBuilder.buildSpecs;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import ca.uhn.hl7v2.IndexedErrorCollector;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;

/**
 * Unit test class for ca.uhn.hl7v2.model.GenericComposite
 * 
 * @author 
 */

public class GenericCompositeTest  {
	private static GenericComposite genericComposite;
	private static Message message;
	
    @Rule public IndexedErrorCollector collector = new IndexedErrorCollector();

    @BeforeClass
	public static void setUp() throws Exception {
        message = new GenericMessage.V25(new DefaultModelClassFactory());
		genericComposite = new GenericComposite(message);
	}

	 
	/**
	 * Testing default constructor
	 */
    @Test
	public void testConstructor() {
		assertNotNull("Should have a valid GenericCompositeTest object", genericComposite);
	}

	public static class GetComponentSpec extends ca.uhn.hl7v2.TestSpec<Integer, Class<? extends Type>> {

        @Override
        protected Class<? extends Type> transform(Integer input) throws Throwable {
            GenericComposite gc = new GenericComposite(message);
            return gc.getComponent(input).getClass();
        }
	    
	}
	
	/**
	 * Testing getComponent(), attempting to get components at various indexes
	 */
    @Test
	public void testGetComponent() throws DataTypeException {
    	
		buildSpecs(GetComponentSpec.class)
			.add(-1, ArrayIndexOutOfBoundsException.class)
			.add(0, Varies.class)
			.add(1, Varies.class)
			.add(2, Varies.class)
			.add(100, Varies.class)
			.executeTests(collector);
	}

    public static class GetComponentsSpec extends ca.uhn.hl7v2.TestSpec<Integer, Integer> {

        @Override
        protected Integer transform(Integer input) throws Throwable {
            GenericComposite gc = new GenericComposite(message);
            try { 
                gc.getComponent(input); 
            } catch (Exception e) { // ignore exception
            }
            Type[] retval = gc.getComponents();
            return retval.length; 
        }
        
    }
    
	/**
	 * Testing getComponents()
	 */
    @Test
	public void testGetComponents() throws DataTypeException {
		buildSpecs(GetComponentsSpec.class)
			.add(-1, 0)
			.add(0, 1)
			.add(1, 2)
			.add(2, 3)
			.add(100, 101)
			.executeTests(collector);
	}

	/**
	 * Testing getName()
	 */
	@Test
	public void testGetName() {
		assertEquals(genericComposite.getName(),"UNKNOWN");
	}
}
