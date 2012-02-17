/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "GroupPointer.java".  Description: 
"A GroupPointer is used when parsing traditionally encoded HL7 messages" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

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

package ca.uhn.hl7v2.parser;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Group;

/**
 * A GroupPointer is used when parsing traditionally encoded HL7 messages. 
 * It acts as a placeholder for a unique group "slot" in a message structure. 
 * There is one GroupPointer per unique Group path (even if the group 
 * repeats, and regardless of whether any instances exist).  
 *
 * @deprecated MessageIterator is now used 
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 */
public class GroupPointer extends Pointer {

    private PipeParser parser;
    private Group parent;
    private String name;
    private boolean repeating;
    private EncodingCharacters encodingChars;
    private Pointer[] children;
    private Group currentGroup = null;
    private int childAtWhichToStart;

    /** 
     * Creates new GroupPointer 
     */
    public GroupPointer(PipeParser parser, Group parent, int position, EncodingCharacters encodingChars)
        throws HL7Exception {
        this.parser = parser;
        this.parent = parent;
        this.name = parent.getNames()[position];
        this.repeating = parent.isRepeating(this.name);
        this.encodingChars = encodingChars;
        //this.createNewInstance();  
    }

    /**
     * Parses the given String, which must contain a single traditionally encoded 
     * message segment, into the current repetition of the message Group  
     * underlying this Pointer by forwarding it to each of it's children until 
     * one of them succeeds.    
     */
    public int setSegment(String segment, boolean orderedCorrectly) throws HL7Exception {
        if (this.currentGroup == null)
            createNewInstance(); //make first instance of the group
        int status = tryToFillChildren(segment, orderedCorrectly);
        if ((status == Pointer.FILL_FAILED_FULL || status == Pointer.FILL_FAILED_OUT_OF_ORDER)
            && this.repeating
            && orderedCorrectly) {
            createNewInstance();
            status = tryToFillChildren(segment, orderedCorrectly);
        }
        return status;
    }

    private int tryToFillChildren(String segment, boolean orderedCorrectlyInParent) throws HL7Exception {
        int status = Pointer.FILL_FAILED_WRONG_SEGMENT;
        int c = 0;
        boolean fullOneExists = false;
        boolean rightSegmentWrongOrder = false;

        //loop through children ... 
        //note: can't just stop if FILL_FAILED_FULL b/c have to check all nesting levels 
        while (status != Pointer.FILL_OK && c < this.children.length) {
            boolean orderedCorrectly = orderedCorrectlyInParent;
            if (c < childAtWhichToStart)
                orderedCorrectly = false;

            status = children[c++].setSegment(segment, orderedCorrectly);
            if (status == Pointer.FILL_FAILED_FULL)
                fullOneExists = true;
            if (status == Pointer.FILL_FAILED_OUT_OF_ORDER)
                rightSegmentWrongOrder = true;
        }

        //note: but if there was a FILL_FAILED_FULL at any point, can't return FILL_FAILED_WRONG_SEGMENT
        if (fullOneExists && status == Pointer.FILL_FAILED_WRONG_SEGMENT)
            status = Pointer.FILL_FAILED_FULL;
        if (rightSegmentWrongOrder && status == Pointer.FILL_FAILED_WRONG_SEGMENT)
            status = Pointer.FILL_FAILED_OUT_OF_ORDER;

        //if filled, update start location so that subsequent segments can't be 
        //parsed into locations prior to this one 
        if (status == Pointer.FILL_OK)
            childAtWhichToStart = c - 1;

        return status;
    }

    /** 
     * Creates a new, empty repetition of the underlying Group and sets up 
     * Pointers to it's components.  
     * @thows HL7Exception if there is already 1 rep and group is non-repeating
     */
    private void createNewInstance() throws HL7Exception {
        //find next rep # ... 
        int nextRepNum = parent.getAll(this.name).length;

        this.currentGroup = (Group) parent.get(this.name, nextRepNum);
        this.childAtWhichToStart = 0;

        //set up pointers for children ... 
        String[] childNames = currentGroup.getNames();
        this.children = new Pointer[childNames.length];
        for (int i = 0; i < childNames.length; i++) {
            Pointer p;
            //make new SegmentPointer or GroupPointer depending on whether child is a Group ... 
            Class<?> childClass = currentGroup.getClass(childNames[i]);
            if (Group.class.isAssignableFrom(childClass)) {
                p = new GroupPointer(this.parser, currentGroup, i, this.encodingChars);
            }
            else {
                p = new SegmentPointer(this.parser, currentGroup, i, encodingChars);
            }

            this.children[i] = p;
        }

    }

}
