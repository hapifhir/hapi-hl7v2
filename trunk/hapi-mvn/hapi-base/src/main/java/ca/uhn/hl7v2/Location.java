/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "Location.java".  Description: 
"Location of an validated message element" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2012.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the "GPL"), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 
 */
package ca.uhn.hl7v2;

/**
 * Location class to determine the location of an element that caused an exception
 * 
 * @author Christian Ohr
 */
public class Location {

	private String segmentName = null;
	private int segmentRepetition = -1;
	private int field = -1;
	private int fieldRepetition = -1;
	private int component = -1;
	private int subcomponent = -1;

	public static final Location UNKNOWN = new Location();

	public Location() {
	}

	public Location(Location l) {
		this.segmentName = l.segmentName;
		this.segmentRepetition = l.segmentRepetition;
		this.field = l.field;
		this.fieldRepetition = l.fieldRepetition;
		this.component = l.component;
		this.subcomponent = l.subcomponent;
	}

	public String getSegmentName() {
		return segmentName;
	}

	public void setSegmentName(String segmentName) {
		this.segmentName = segmentName;
	}

	public int getSegmentRepetition() {
		return segmentRepetition;
	}

	public void setSegmentRepetition(int segmentRepetition) {
		this.segmentRepetition = segmentRepetition;
	}

	public int getField() {
		return field;
	}

	public void setField(int field) {
		this.field = field;
	}

	public int getFieldRepetition() {
		return fieldRepetition;
	}

	public void setFieldRepetition(int fieldRepetition) {
		this.fieldRepetition = fieldRepetition;
	}

	public int getComponent() {
		return component;
	}

	public void setComponent(int component) {
		this.component = component;
	}

	public int getSubcomponent() {
		return subcomponent;
	}

	public void setSubcomponent(int subcomponent) {
		this.subcomponent = subcomponent;
	}

	/**
	 * Bulk setter for field indices
	 * 
	 * @param indices integer array as returned by Terser#getIndices
	 */
	public void setFieldIndizes(int[] indices) {
		field = indices[0];
		fieldRepetition = indices[1];
		component = indices[2];
		subcomponent = indices[3];
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (segmentName != null) {
			sb.append(segmentName);
			if (segmentRepetition >= 0) {
				sb.append("(").append(segmentRepetition).append(")");
			}
			if (field > 0) {
				sb.append("-").append(field);
				if (fieldRepetition >= 0) {
					sb.append("(").append(fieldRepetition).append(")");
				}
				if (component > 0) {
					sb.append("-").append(component);
					if (subcomponent > 0) {
						sb.append("-").append(subcomponent);
					}
				}
			}
		} else {
			sb.append("unknown location");
		}
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + component;
		result = prime * result + field;
		result = prime * result + fieldRepetition;
		result = prime * result + ((segmentName == null) ? 0 : segmentName.hashCode());
		result = prime * result + segmentRepetition;
		result = prime * result + subcomponent;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (component != other.component)
			return false;
		if (field != other.field)
			return false;
		if (fieldRepetition != other.fieldRepetition)
			return false;
		if (segmentName == null) {
			if (other.segmentName != null)
				return false;
		} else if (!segmentName.equals(other.segmentName))
			return false;
		if (segmentRepetition != other.segmentRepetition)
			return false;
		if (subcomponent != other.subcomponent)
			return false;
		return true;
	}

}