/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "GroupDef.java".  Description: 
"Contains the information needed to create source code for a Group (a 
  Group is a part of a message that may repeat, and that contains two or 
  more segments or other groups)" 

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
import java.util.HashMap;

/**
 * Contains the information needed to create source code for a Group (a 
 * Group is a part of a message that may repeat, and that contains two or 
 * more segments or other groups).   
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 */
public class GroupDef implements StructureDef {

	private ArrayList<StructureDef> elements;
    private String messageName;
    private String groupName;
    private String description;
    private boolean required;
    private boolean repeating;
    private HashMap existingNames;
    private String myIndexName;
    
    
    /** Creates new GroupDef */
    public GroupDef(String messageName, String groupName, boolean required, boolean repeating, String description) {
        this.messageName = messageName;
        this.groupName = groupName;
        this.elements = new ArrayList();
        this.required = required;
        this.repeating = repeating;
        this.description = description;
        this.existingNames = new HashMap();
    }

    /**
     * Returns the Java class name of this Group.  This is derived from the 
     * message structure and the group elements.  This should only be called 
     * after all the elements are added.  
     */
    public String getName() {
        String result = null;
        
        if (groupName != null && groupName.length() > 0) {
            result = messageName + "_" + groupName;
        } else {
            StringBuffer name = new StringBuffer();
            name.append(messageName);
            name.append("_");
            String[] children = getChildSegments();
            for (int i = 0; i < children.length; i++) {
                name.append(children[i]);
            }        
            result = name.toString();            
        }
        
        return result;
    }
    
    /**
     * @return group name without message name prepended  
     */
    public String getUnqualifiedName() {
        String name = getName();
        return name.substring(messageName.length() + 1);
    }
        
    /**
     * Adds an element (segment or group) to this group.  
     */
    public void addStructure(StructureDef s) {
        elements.add(s);
        
        String indexName = getIndexName(s.getUnqualifiedName());
        s.setIndexName(indexName);
    }
    
    /**
     * Returns the structures in this group. 
     */
    public StructureDef[] getStructures() {
        StructureDef[] ret = new StructureDef[elements.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (StructureDef)elements.get(i);
        }
        return ret;
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
     * Returns the name by which a particular structure can be accessed (eg for use 
     * in writing accessor source code).  This may differ from the class name of the 
     * structure of there are >1 structures in the same group with the same class.  
     * For example in ADT_A01 there are two ROL's that are not in sub-groups - AbstractGroup 
     * stores the first one under the name ROL and the second under the name ROL2.  This 
     * method returns names using the same naming scheme.  The order in which this 
     * method is called matters: it should be called ONCE for each element of the group in the 
     * order in which they appear.  
     */
    public String getIndexName(String name) {
        //see if this name is already being used 
        Object o = existingNames.get(name);
        int c = 2;
        String newName = name;
        while (o != null) {
            newName = name + c++;
            o = existingNames.get(newName);
        }
        name = newName;
        existingNames.put(name, name);
        return name;
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
        ArrayList deepChildList = new ArrayList();
        for (int i = 0; i < elements.size(); i++) {
            StructureDef childStruct = (StructureDef) elements.get(i);
            String[] childStructChildren = childStruct.getChildSegments();
            for (int j = 0; j < childStructChildren.length; j++) {
                deepChildList.add(childStructChildren[j]);
            }
        }
        String[] result = new String[deepChildList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = (String) deepChildList.get(i);
        }
        return result; 
    }

    /**
     * {@inheritDoc}
     */
	public String toString() {
		return "GroupDef[" + groupName +"]";
	}

    public boolean isGroup() {
        return true;
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
        return false;
    }    
    
}
