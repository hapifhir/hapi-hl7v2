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

import java.util.List;

import org.apache.commons.lang.Validate;

import ca.uhn.hl7v2.model.Segment;

public class SegmentAndComponentPath {

	private List<Integer> myComponentPath;
	private int myRepNum = 1;
	private Segment mySegment;

	public SegmentAndComponentPath(Segment theSegment, List<Integer> theComponentPath) {
		super();
		
		Validate.notNull(theSegment);
		Validate.notNull(theComponentPath);
		Validate.notEmpty(theComponentPath);
		
		mySegment = theSegment;
		myComponentPath = theComponentPath;
	}

	public SegmentAndComponentPath(Segment theSegment, List<Integer> theComponentPath, int theRepNumber) {
		this(theSegment, theComponentPath);
		assert theRepNumber > 0;
		
		myRepNum = theRepNumber;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object theObj) {
		if (theObj == null || !((theObj instanceof SegmentAndComponentPath))) {
			return false;
		}

		SegmentAndComponentPath o = (SegmentAndComponentPath) theObj;

		return mySegment == o.mySegment && myComponentPath.equals(o.myComponentPath);
	}

	/**
	 * @return the componentPath
	 */
	public List<Integer> getComponentPath() {
		return myComponentPath;
	}

	/**
	 * @return the repNum
	 */
	public int getRepNum() {
		return myRepNum;
	}

	/**
	 * @return the segment
	 */
	public Segment getSegment() {
		return mySegment;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return mySegment.hashCode() + myComponentPath.hashCode();
	}

}
