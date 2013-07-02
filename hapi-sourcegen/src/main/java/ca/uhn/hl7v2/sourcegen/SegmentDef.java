/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "SegmentDef.java".  Description: 
"Information about a message segment used in the creation of 
  source code for a Group class" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  �GPL�), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

*/

package ca.uhn.hl7v2.sourcegen;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.plexus.util.StringUtils;

import edu.emory.mathcs.backport.java.util.Collections;

/**
 * Information about a message segment used in the creation of 
 * source code for a Group class.  SegmentDef is a slight misnomer because this 
 * also includes group start/end indicators, with group names.  
 *   
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 */
public class SegmentDef implements StructureDef {

    private String name;
    private String groupName;
    private String description;
    private boolean required;
    private boolean repeating;
    private String myIndexName;
    private List<DatatypeDef> myFieldDefs = new ArrayList<DatatypeDef>();
	private boolean choice;
	private List<String> associatedStructures;
    
	/** Creates new SegmentDef */
    public SegmentDef(String name, String groupName, boolean required, boolean repeating, boolean choice, String description) {
        this.name = name;
        this.groupName = groupName;
        this.required = required;
        this.repeating = repeating;
        this.description = StringUtils.defaultString(description);
        this.choice = choice;
    }

    /**
	 * @return the choice
	 */
	public boolean isChoice() {
		return choice;
	}

	public void addFieldDef(DatatypeDef theFieldDef) {
        myFieldDefs.add(theFieldDef);
    }
    
    public List<DatatypeDef> getFieldDefs() {
        return myFieldDefs;
    }

    /**
     * @return name of segment 
     */
    public String getName() {
        String result = this.name;
        if (result != null && result.equals("?")) {
            result = "GenericSegment";
        }
        return result;
    }
    
    /**
     * @return name of group, if this is not really a segment but a group start indicator 
     */
    public String getGroupName() {
        return this.groupName;
    }
    
    /**
     * Returns true if this structure is required in the Group.  
     */
    public boolean isRequired() {
        return this.required;
    }
    
    /**
     * Returns true if this structure can repeat in the Group.  
     */    
    public boolean isRepeating() {
        return this.repeating;
    }
    
    /**
     * Returns a text description of the structure.
     */
    public String getDescription() {
        return this.description;
    }
    
    /**
     * Returns a list of the names of the segments that are children of this Structure.
     * If the structure is a Segment, a 1-element array is returned containing the segment
     * name.  If a Group, an array of all the segments in the Group, including those nested
     * in subgroups (depth first).  This method is used to support the XML SIG's convention
     * for deriving group names.
     */
    public String[] getChildSegments() {
        String[] result = {getName()};
        return result;
    }

    /**
     * {@inheritDoc}
     */
    public String toString() {
        return "SegmentDef[name=" + name + ", groupName=" + groupName + ", description=" + description + "]";
    }

    public boolean isGroup() {
        return false;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getUnqualifiedName() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    public String getIndexName() {
        return myIndexName;
    }

    /**
     * {@inheritDoc}
     */
    public void setIndexName(String theIndexName) {
        myIndexName = theIndexName;
    }    

    /**
     * {@inheritDoc}
     */
    public boolean isSegment() {
        return true;
    }    
    
    /**
	 * @return the associatedStructures
	 */
	public List<String> getAssociatedStructures() {
		if (associatedStructures == null) {
			associatedStructures = new ArrayList<String>();
		}
		return associatedStructures;
	}

	/**
	 * @param theAssociatedStructures the associatedStructures to set
	 */
	public void addAssociatedStructure(String theAssociatedStructure) {
		if (getAssociatedStructures().contains(theAssociatedStructure)) {
			return;
		}
		getAssociatedStructures().add(theAssociatedStructure);
		Collections.sort(getAssociatedStructures());
	}

    
}
