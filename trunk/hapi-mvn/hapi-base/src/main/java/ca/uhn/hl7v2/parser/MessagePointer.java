/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "MessagePointer.java".  Description: 
"A MessagePointer is used when parsing traditionally encoded HL7 messages" 

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

/*
 * Created on October 15, 2001, 4:17 PM
 */

package ca.uhn.hl7v2.parser;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Message;

/**
 * A MessagePointer is used when parsing traditionally encoded HL7 messages. 
 * This is similar to a GroupPointer except that there is only one underlying 
 * instance of the Message, and it has no parent.  
 *
 * @deprecated PipeParser now uses MessageIterator
 * @see GroupPointer   
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 */
public class MessagePointer {

    private PipeParser parser;
    private EncodingCharacters encodingChars;
    private Pointer[] children;
    private Message message;
    private int childAtWhichToStart = 0;

    /** 
     * Creates new GroupPointer 
     */
    public MessagePointer(PipeParser parser, Message message, EncodingCharacters encodingChars) throws HL7Exception {
        this.parser = parser;
        this.message = message;
        this.encodingChars = encodingChars;
        makeChildren();
    }

    /**
     * Parses the given String, which must contain a single traditionally encoded 
     * message segment, by forwarding it to child GroupPointers and SegmentPointers  
     * until one of them succeeds.  
     */
    public int setSegment(String segment) throws HL7Exception {
        int status = tryToFillChildren(segment);
        return status;
    }

    private int tryToFillChildren(String segment) throws HL7Exception {
        int status = Pointer.FILL_FAILED_WRONG_SEGMENT;
        int c = 0;
        //loop through children ... 
        //note: can't just stop if FILL_FAILED_FULL b/c have to check all nesting levels 
        while (status != Pointer.FILL_OK && c < this.children.length) {
            boolean correctOrder = (c >= childAtWhichToStart ? true : false);
            status = children[c++].setSegment(segment, correctOrder);
        }
        if (status == Pointer.FILL_OK)
            childAtWhichToStart = c - 1;
        return status;
    }

    /** 
     * Creates a new, empty repetition of the underlying Group and sets up 
     * Pointers to it's components.  
     * @thows HL7Exception if there is already 1 rep and group is non-repeating
     */
    private void makeChildren() throws HL7Exception {

        //set up pointers for children ... 
        String[] childNames = message.getNames();
        this.children = new Pointer[childNames.length];
        for (int i = 0; i < childNames.length; i++) {
            Pointer p;
            //make new SegmentPointer or GroupPointer depending on whether child is a Group ... 
            Class childClass = message.getClass(childNames[i]);
            if (Group.class.isAssignableFrom(childClass)) {
                p = new GroupPointer(this.parser, message, i, this.encodingChars);
            }
            else {
                p = new SegmentPointer(this.parser, message, i, encodingChars);
            }

            this.children[i] = p;
        }

    }

}
