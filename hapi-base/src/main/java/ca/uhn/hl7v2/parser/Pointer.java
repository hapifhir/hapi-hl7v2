/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "Pointer.java".  Description: 
"A Pointer is a placeholder used in parsing traditionally encoded messages 
  (which do not explicitly identify segment groups)" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  “GPL”), in which case the provisions of the GPL are 
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
 * <p>A Pointer is a placeholder used in parsing traditionally encoded messages 
 * (which do not explicitly identify segment groups).  Implementations of Pointer 
 * include SegmentPointer, which "points" to a Segment slot.  This pointer can 
 * exist whether or not the underlying Segment object has been created.  There is 
 * only one pointer per slot - multiple repetitions are accessed through the 
 * same pointer.  <code>prepNewInstance</code> is used to create a new rep.  
 * <code>setSegment(String segment)</code> is responsible for parsing the given 
 * segment string <i>into</i> the current rep of the underlying Segment.  Similarly 
 * there is a subclass called GroupPointer that points to a Group slot.  
 * GroupPointer's <code>setSegment(...)</code> method just forwards the request to 
 * it's children (which are GroupPointers and SegmentPointers). </p>
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 */
public abstract class Pointer {

    public static final int FILL_FAILED_WRONG_SEGMENT = 0;
    public static final int FILL_FAILED_FULL = 1;
    public static final int FILL_OK = 2;
    public static final int FILL_FAILED_OUT_OF_ORDER = 3;

    protected Group parent;
    protected int position;
    protected boolean repeating;
    protected EncodingCharacters encodingChars;

    /**
     * Parses the given String, which must contain a single traditionally encoded 
     * message segment, into the current repetition of the message Structure 
     * underlying this Pointer.  
     * @param segment the segment to parse 
     * @param correctOrder false if this segment should not actually be parsed because the 
     *      current location precedes the location of a segment that has already been 
     *      parsed.  In this case, the return value should be either FILL_FAILED_FULL, 
     *      FILL_FAILED_WRONG_SEGMENT, or FILL_FAILED_OUT_OF_ORDER, but the segment should not 
     *      be parsed.  
     * @return an int indicating the success or flavours of failure of the request
     */
    public abstract int setSegment(String segment, boolean correctOrder) throws HL7Exception;

}
