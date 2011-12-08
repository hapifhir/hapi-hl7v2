/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "SegmentPointer.java".  Description: 
"A SegmentPointer is used when parsing traditionally encoded HL7 messages" 

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
 * Created on October 15, 2001, 3:19 PM
 */

package ca.uhn.hl7v2.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Segment;

/**
 * A SegmentPointer is used when parsing traditionally encoded HL7 messages. 
 * It acts as a placeholder for a unique segment "slot" in a message structure. 
 * There is one SegmentPointer per unique segment path (even if the segment 
 * repeats, and regardless of whether any instances exist).  
 *
 * @deprecated PipeParser now uses MessageIterator
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 */
public class SegmentPointer extends Pointer {

    private static final Logger log = LoggerFactory.getLogger(SegmentPointer.class);
    private PipeParser parser;
    private Group parent;
    private String name;
    private EncodingCharacters encodingChars;
    private boolean repeating;
    private Segment currSegment = null;
    private boolean currSegmentFull = true;

    /** 
     * Creates new SegmentPointer 
     * @param parser the PipeParser used to parse segments 
     * @param parent the Group object that would be the parent of any instances of the 
     *      Segment underlying this SegmentPointer
     * @param position the position (among siblings; from 0) of the underlying Segment 
     * @param encodingChars array of encoding characters, starting w/ field delim
     */
    public SegmentPointer(PipeParser parser, Group parent, int position, EncodingCharacters encodingChars)
        throws HL7Exception {
        this.parser = parser;
        this.parent = parent;
        this.encodingChars = encodingChars;
        this.name = parent.getNames()[position];
        this.repeating = parent.isRepeating(this.name);

    }

    /**
     * Parses the given String, which must contain a single traditionally encoded 
     * message segment, into the current repetition of the message Structure 
     * underlying this Pointer.  See Pointer static fields for return values. 
     * @throws HL7Exception if there is an error during parsing 
     */
    public int setSegment(String segment, boolean correctOrder) throws HL7Exception {
        int status = Pointer.FILL_FAILED_WRONG_SEGMENT;

        //make sure segment is right kind
        if (segment.substring(0, 3).equals(this.name)) {
            if (correctOrder) {
                //make sure empty rep exists
                if (prepEmptyInstance()) {
                    try {
                        this.parser.parse(this.currSegment, segment, this.encodingChars);
                    }
                    catch (HL7Exception e) {
                        //add segment name info and re-throw
                        e.setSegmentName(this.name);
                        throw e;
                    }
                    this.currSegmentFull = true;
                    status = Pointer.FILL_OK;
                }
                else {
                    status = Pointer.FILL_FAILED_FULL;
                }
            }
            else {
                status = Pointer.FILL_FAILED_OUT_OF_ORDER;
            }
        }
        log.debug(
            "Attempt to put segment " + segment.substring(0, 3) + " in " + this.name + ": code = " + status);
        return status;
    }

    /** 
     * Ensures that there is an empty repetition of the underlying message Structure.  
     * @returns true if successful, false if structure is non-repeating and full. 
     */
    private boolean prepEmptyInstance() throws HL7Exception {
        boolean success = false;

        if (this.currSegment == null || (this.repeating && this.currSegmentFull)) {
            int numExisting = parent.getAll(this.name).length;
            this.currSegment = (Segment) parent.get(this.name, numExisting); //get next rep            
            this.currSegmentFull = false;
            success = true;
        }
        else if (!this.currSegmentFull) {
            success = true;
        }

        return success;
    }

}
