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

import java.util.ArrayList;
import java.util.TimeZone;

import junit.framework.TestCase;

/**
 * Unit test class for ca.uhn.hl7v2.model.DataTypeUtil
 * 
 * @author Leslie Mann
 */

public class DataTypeUtilTest extends TestCase {

	/**
	 * Constructor for DataTypeUtilTest.
	 * @param testName
	 */
	public DataTypeUtilTest(String testName) {
		super(testName);
	}

	/**
	 * Testing preAppendZeroes()
	 */
 	public void testPreAppendZeroes() {
		class TestSpec {
			int num;
			int totalDigitLength;
			Object outcome;
		
			TestSpec(int num, int totalDigitLength, Object outcome) {
				this.num = num;
				this.totalDigitLength = totalDigitLength;
				this.outcome = outcome;
			}
		
			public String toString() {
				return outcome.toString();
			}
		
			public boolean executeTest() {
				String retval = DataTypeUtil.preAppendZeroes(num,totalDigitLength);
				if (retval != null) {
					return retval.equals(outcome);
				} else {
					return outcome == null;
				}
			}
		}//inner class
    	
		TestSpec [] tests = {
			new TestSpec(1, 0, "1"),
			new TestSpec(1, 1, "1"),
			new TestSpec(1, 2, "01"),
			new TestSpec(1, 3, "001"),
			new TestSpec(1, 4, "0001"),
			new TestSpec(21, 0, "21"),
			new TestSpec(21, 1, "21"),
			new TestSpec(21, 2, "21"),
			new TestSpec(21, 3, "021"),
			new TestSpec(21, 4, "0021"),
			new TestSpec(54321, 0, "54321"),
			new TestSpec(54321, 1, "54321"),
			new TestSpec(54321, 2, "54321"),
			new TestSpec(54321, 3, "54321"),
			new TestSpec(54321, 4, "54321"),
			new TestSpec(54321, 5, "54321"),
			new TestSpec(54321, 6, "054321"),
			new TestSpec(54321, 7, "0054321"),
		};
	
		ArrayList<TestSpec> failedTests = new ArrayList<TestSpec>();

		for (int i = 0; i < tests.length ; i++) {
			if ( ! tests[ i ].executeTest() ) 
				failedTests.add( tests[ i ] );
		}

		assertEquals("Failures: " + failedTests, 0, failedTests.size()); 
	}

	public void testGetLocalGMTOffset() {
		TimeZone tz = TimeZone.getDefault();
		int offset = tz.getRawOffset();
		
		int hours = offset/(60*60*1000);
		int minutes = (offset - (hours*(60*60*1000)))/(60*1000);
		int gmtOffset = hours * 100 + minutes;
		
		assertEquals("GMT offset", gmtOffset, DataTypeUtil.getLocalGMTOffset());
	}

}
