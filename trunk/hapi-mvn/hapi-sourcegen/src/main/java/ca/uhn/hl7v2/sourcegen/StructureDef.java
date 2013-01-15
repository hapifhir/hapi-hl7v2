/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "StructureDef.java".  Description: 
"Information about a structure within a message (e.g" 

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

import java.util.List;

import ca.uhn.hl7v2.model.Group;

/**
 * Information about a structure within a message (eg group, segment) 
 * that is used in creating source for a Group class. 
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 */
public interface StructureDef {

	/**
	 * For superstructures, returns the message structures this structure is associated with
	 */
	public List<String> getAssociatedStructures();
	
    /**
     * Returns the name of the structure.
     */
    public String getName();
    
    /**
     * Returns a text description of the structure.
     */
    public String getDescription();
    
    /**
     * Returns true if this structure is required in the Group.  
     */ 
    public boolean isRequired();

    /**
     * @see Group#isChoiceElement(String)
     */
    boolean isChoice();
    
    /**
     * Returns true if this structure is a segment.  
     */ 
    public boolean isSegment();
    
    /**
     * Returns true if this structure can repeat in the Group.  
     */ 
    public boolean isRepeating();

    /**
     * Returns true if this structure can repeat in the Group.  
     */ 
    public boolean isGroup();
    
    /**
     * Returns a list of the names of the segments that are children of this Structure.  
     * If the structure is a Segment, a 1-element array is returned containing the segment 
     * name.  If a Group, an array of all the segments in the Group, including those nested
     * in subgroups (depth first).  This method is used to support the XML SIG's convention 
     * for deriving group names. 
     */
    public String[] getChildSegments(); 
    
    /**
     * @return Returns the name without any prefix qualification. This is only different for
     * group definitions, where the qualification is the message type (i.e. this will 
     * return PROCEDURE instead of ADT_A01_PROCEDURE)
     */
    public String getUnqualifiedName();
    
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
    public String getIndexName();
    
    /**
     * {@see #getIndexName()}
     */
    public void setIndexName(String theIndexName);
}

