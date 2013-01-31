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

import java.util.Stack;

/**
 * Location class to determine the location of an element
 * 
 * @author Christian Ohr
 */
public class Location {

    private Stack<GroupLocation> groups = new Stack<GroupLocation>();
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
        this.groups = new Stack<GroupLocation>();
        groups.addAll(l.groups);
		this.segmentName = l.segmentName;
		this.segmentRepetition = l.segmentRepetition;
		this.field = l.field;
		this.fieldRepetition = l.fieldRepetition;
		this.component = l.component;
		this.subcomponent = l.subcomponent;
	}
	
	public boolean isUnknown() {
	    return this == UNKNOWN;
	}

    public Location pushGroup(String name, int rep) {
        groups.push(new Location.GroupLocation(name, rep));
        return this;
    }

    public void popGroup() {
        groups.pop();
    }

	public String getSegmentName() {
		return segmentName;
	}

	public Location withSegmentName(String segmentName) {
		this.segmentName = segmentName;
		return this;
	}

	public int getSegmentRepetition() {
		return segmentRepetition;
	}

	public Location withSegmentRepetition(int segmentRepetition) {
		this.segmentRepetition = segmentRepetition;
		return this;
	}

	public int getField() {
		return field;
	}

	public Location withField(int field) {
		this.field = field;
		return this;
	}

	public int getFieldRepetition() {
		return fieldRepetition;
	}

	public Location withFieldRepetition(int fieldRepetition) {
		this.fieldRepetition = fieldRepetition;
		return this;
	}

	public int getComponent() {
		return component;
	}

	public Location withComponent(int component) {
		this.component = component;
		return this;
	}

	public int getSubcomponent() {
		return subcomponent;
	}

	public Location withSubcomponent(int subcomponent) {
		this.subcomponent = subcomponent;
		return this;
	}

	/**
	 * Bulk setter for field indices
	 * 
	 * @param indices integer array as returned by Terser#getIndices
	 */
	public Location withFieldIndizes(int[] indices) {
		field = indices[0];
		fieldRepetition = indices[1];
		component = indices[2];
		subcomponent = indices[3];
		return this;
	}


	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
        if (!groups.isEmpty()) {
            sb.append('/');
            for (GroupLocation gl : groups) {
                sb.append(gl.groupName);
                if (gl.repetition >= 0) {
                    sb.append('(')
                    .append(gl.repetition)
                    .append(")");
                }
                sb.append("/");
            }
        }
		if (segmentName != null) {
			sb.append(segmentName);
			if (segmentRepetition > 0) {
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
			if (sb.length() == 0) sb.append("unknown location");
		}
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
        result = prime * result + ((groups == null) ? 0 : groups.hashCode());
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
		if (groups == null) {
		    if (other.groups != null)
		        return false;
		} else if (!groups.equals(other.groups))
		    return false;
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

    private class GroupLocation {
        String groupName;
        int repetition;

        private GroupLocation(String groupName, int repetition) {
            this.groupName = groupName;
            this.repetition = repetition;
        }
    }

}