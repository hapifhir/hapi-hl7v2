/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is ""  Description:
 * ""
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2001.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  "GPL"), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 */
package ca.uhn.hl7v2.testpanel.util;

import org.apache.commons.lang.Validate;

public class Range {

	private final int myEnd;
	private final int myStart;

	public Range(int theStartAndEnd) {
		this(theStartAndEnd, theStartAndEnd);
	}

	public Range(int theStart, int theEnd) {
		Validate.isTrue(theStart >= 0, "theStart: " + theStart);
		Validate.isTrue(theEnd >= 0, "theEnd: " + theStart);

		if (theStart > theEnd) {
			myEnd = theStart;
			myStart = theEnd;
		} else {
			myStart = theStart;
			myEnd = theEnd;
		}
	}

	public Range add(int theAmount) {
		return new Range(myStart + theAmount, myEnd + theAmount);
	}

	public Range addToBoth(int theDelta) {
		return new Range(myStart + theDelta, myEnd + theDelta);
	}

	public Range addToEnd(int theDelta) {
		return new Range(myStart, myEnd + theDelta);
	}

	public String applyTo(String theMessage) {
		int end = myEnd;
		if (theMessage.length() < myEnd) {
			end = theMessage.length();
		}
		return theMessage.substring(myStart, end);
	}

	public boolean contains(int theDot) {
		return myStart <= theDot && myEnd >= theDot;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object theObj) {
		if (theObj == null || (!(theObj instanceof Range))) {
			return false;
		}

		Range o = (Range) theObj;
		if (myStart != o.myStart) {
			return false;
		}
		if (myEnd != o.myEnd) {
			return false;
		}

		return true;
	}

	public int getDelta() {
		return myEnd - myStart;
	}

	/**
	 * @return the end
	 */
	public int getEnd() {
		return myEnd;
	}

	/**
	 * @return the start
	 */
	public int getStart() {
		return myStart;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return myStart * myEnd;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Range[" + myStart + ", " + myEnd + "]";
	}

	public Range overlay(Range theRange) {
		return new Range(Math.min(myStart, theRange.getStart()), Math.max(myEnd, theRange.getEnd()));
	}

}
