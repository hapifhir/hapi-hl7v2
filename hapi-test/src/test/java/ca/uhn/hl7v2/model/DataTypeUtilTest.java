/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "DataTypeUtilTest.java".  Description:
 * "Unit test class for ca.uhn.hl7v2.model.DataTypeUtil"
 *
 * The Initial Developer of the Original Code is Leslie Mann. Copyright (C)
 * 2003.  All Rights Reserved.
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
import static ca.uhn.hl7v2.TestSpecBuilder.ints;
import static org.junit.Assert.assertEquals;

import java.util.TimeZone;

import org.junit.Rule;
import org.junit.Test;

import ca.uhn.hl7v2.IndexedErrorCollector;

/**
 * Unit test class for ca.uhn.hl7v2.model.DataTypeUtil
 * 
 * @author Leslie Mann
 */

public class DataTypeUtilTest {

    @Rule public IndexedErrorCollector collector = new IndexedErrorCollector();

    public static class PreAppendZeroesSpec extends ca.uhn.hl7v2.TestSpec<int[], String> {

        @Override
        protected String transform(int[] input) throws Throwable {
            return DataTypeUtil.preAppendZeroes(input[0],input[1]);
        }
        
    }
    
	/**
	 * Testing preAppendZeroes()
	 */
    @Test
 	public void testPreAppendZeroes() {
		buildSpecs(PreAppendZeroesSpec.class)
			.add(ints(1, 0), "1")
			.add(ints(1, 1), "1")
			.add(ints(1, 2), "01")
			.add(ints(1, 3), "001")
			.add(ints(1, 4), "0001")
			.add(ints(21, 0), "21")
			.add(ints(21, 1), "21")
			.add(ints(21, 2), "21")
			.add(ints(21, 3), "021")
			.add(ints(21, 4), "0021")
			.add(ints(54321, 0), "54321")
			.add(ints(54321, 1), "54321")
			.add(ints(54321, 2), "54321")
			.add(ints(54321, 3), "54321")
			.add(ints(54321, 4), "54321")
			.add(ints(54321, 5), "54321")
			.add(ints(54321, 6), "054321")
			.add(ints(54321, 7), "0054321")
			.executeTests(collector); 
	}

    @Test
	public void testGetLocalGMTOffset() {
		TimeZone tz = TimeZone.getDefault();
		int offset = tz.getRawOffset();
		
		int hours = offset/(60*60*1000);
		int minutes = (offset - (hours*(60*60*1000)))/(60*1000);
		int gmtOffset = hours * 100 + minutes;
		
		assertEquals("GMT offset", gmtOffset, DataTypeUtil.getLocalGMTOffset());
	}

}
