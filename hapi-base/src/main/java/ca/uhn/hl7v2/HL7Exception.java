/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "HL7Exception.java".  Description: 
"Represents an exception encountered while processing 
  an HL7 message" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  "GPL"), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

*/

package ca.uhn.hl7v2;

import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.util.Terser;

/** 
 * Represents an exception encountered while processing 
 * an HL7 message.  
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 */
@SuppressWarnings("serial")
public class HL7Exception extends Exception {

    /** Original mode: Application Accept - Enhanced mode: Application acknowledgment: Accept */
    public static final int ACK_AA = 1;

    /** Original mode: Application Error - Enhanced mode: Application acknowledgment: Error */
    public static final int ACK_AE = 2;

    /** Original mode: Application Reject - Enhanced mode: Application acknowledgment: Reject */
    public static final int ACK_AR = 3;

    /** Enhanced mode: Accept acknowledgment: Commit Accept */
    public static final int ACK_CA = 4;

    /** Enhanced mode: Accept acknowledgment: Commit Error */
    public static final int ACK_CE = 5;

    /** Enhanced mode: Accept acknowledgment: Commit Reject */
    public static final int ACK_CR = 6;


    public static final int MESSAGE_ACCEPTED = 0;
    public static final int SEGMENT_SEQUENCE_ERROR = 100;
    public static final int REQUIRED_FIELD_MISSING = 101;
    public static final int DATA_TYPE_ERROR = 102;
    public static final int TABLE_VALUE_NOT_FOUND = 103;
    public static final int UNSUPPORTED_MESSAGE_TYPE = 200;
    public static final int UNSUPPORTED_EVENT_CODE = 201;
    public static final int UNSUPPORTED_PROCESSING_ID = 202;
    public static final int UNSUPPORTED_VERSION_ID = 203;
    public static final int UNKNOWN_KEY_IDENTIFIER = 204;
    public static final int DUPLICATE_KEY_IDENTIFIER = 205;
    public static final int APPLICATION_RECORD_LOCKED = 206;
    public static final int APPLICATION_INTERNAL_ERROR = 207;

    private String segment = null;
    private int segmentRep = -1;
    private int fieldPosition = -1;
    private int errCode = -1;

    /** 
     * Creates an HL7Exception.
     *  
     * @param errorCondition a code describing the the error condition, from HL7
     *        table 0357 (see section 2.16.8 of standard v 2.4) - HL7Exception defines 
     *        these codes as integer constants that can be used here (e.g. 
     *        HL7Exception.UNSUPPORTED_MESSAGE_TYPE)
     * 
     * @param cause The exception that caused this exception to be thrown.
     */
    public HL7Exception(String message, int errorCondition, Throwable cause) {
        super(message, cause);
        this.errCode = errorCondition;
    }

    /** 
     * Creates an HL7Exception.
     *  
     * @param errorCondition a code describing the the error condition, from HL7
     *        table 0357 (see section 2.16.8 of standard v 2.4) - HL7Exception defines 
     *        these codes as integer constants that can be used here (e.g. 
     *        HL7Exception.UNSUPPORTED_MESSAGE_TYPE)
     */
    public HL7Exception(String message, int errorCondition) {
        super(message);
        this.errCode = errorCondition;
    }

    /**
     * Creates an HL7Exception with the code APPLICATION_INTERNAL_ERROR
     * 
     * @param cause The excption that caused this exception tobe thrown.
     */
    public HL7Exception(String message, Throwable cause) {
        super(message, cause);
        this.errCode = HL7Exception.APPLICATION_INTERNAL_ERROR;
    }
    
    /**
     * Creates an HL7Exception with the code APPLICATION_INTERNAL_ERROR
     * 
     * @param cause The excption that caused this exception tobe thrown.
     */
    public HL7Exception(Throwable cause) {
        super(cause);
        this.errCode = HL7Exception.APPLICATION_INTERNAL_ERROR;
    }

    /**
     * Creates an HL7Exception with the code APPLICATION_INTERNAL_ERROR
     */
    public HL7Exception(String message) {
        super(message);
        this.errCode = HL7Exception.APPLICATION_INTERNAL_ERROR;
    }

    /**
     * Sets the name of the segment where the error occured. 
     */
    public void setSegmentName(String segmentName) {
        this.segment = segmentName;
    }

    /** 
     * Returns the name of the segment where the error occured, if this has been set
     * (null otherwise).
     */
    public String getSegmentName() {
        return this.segment;
    }

    /** 
     * Sets the sequence number of the segment where the error occured if there 
     * are multiplt segments with the same name (ie the sequenceNum'th segment 
     * with the name specified in <code>setSegmentName</code>).  Numbering 
     * starts at 1.
     */
    public void setSegmentRepetition(int sequenceNum) {
        this.segmentRep = sequenceNum;
    }

    /**
     * Returns the sequence number of the segment where the error occured (if there 
     * are multiple segments with the same name) if this has been set, -1 otherwise - 
     * numbering starts at 1.
     */
    public int getSegmentRepetition() {
        return this.segmentRep;
    }

    /** 
     * Sets the field number (within a segment) where the error occured; numbering 
     * starts at 1. 
     */
    public void setFieldPosition(int fieldNum) {
        this.fieldPosition = fieldNum;
    }

    /** 
     * Returns the field number within the segment where the error occured if it has been 
     * set, -1 otherwise; numbering starts at 1.
     */
    public int getFieldPosition() {
        return this.fieldPosition;
    }
    
    /**
     * @return Returns the error code associated with this exception, or <code>-1</code> if none
     */
    public int getErrorCode() {
        return this.errCode;
    }

    /**
     * Overrides Throwable.getMessage() to add the field location of the problem if 
     * available.
     */
    public String getMessage() {
        StringBuffer msg = new StringBuffer();
        msg.append(super.getMessage());
        if (getSegmentName() != null) {
            msg.append(": Segment: ");
            msg.append(getSegmentName());
        }
        if (getSegmentRepetition() != -1) {
            msg.append(" (rep ");
            msg.append(getSegmentRepetition());
            msg.append(")");
        }
        if (getFieldPosition() != -1) {
            msg.append(" Field #");
            msg.append(getFieldPosition());
        }
        return msg.toString();
    }

    /**
     * Populates the given error segment with information from this Exception.
     */
    public void populate(Segment errorSegment, String theJdbcUrl) throws HL7Exception {
        //make sure it's an ERR
        if (!errorSegment.getName().equals("ERR"))
            throw new HL7Exception(
                "Can only populate an ERR segment with an exception -- got: " + errorSegment.getClass().getName());

        int rep = errorSegment.getField(1).length; //append after existing reps

        if (this.getSegmentName() != null)
            Terser.set(errorSegment, 1, rep, 1, 1, this.getSegmentName());

        if (this.getSegmentRepetition() >= 0)
            Terser.set(errorSegment, 1, rep, 2, 1, String.valueOf(this.getSegmentRepetition()));

        if (this.getFieldPosition() >= 0)
            Terser.set(errorSegment, 1, rep, 3, 1, String.valueOf(this.getFieldPosition()));

        Terser.set(errorSegment, 1, rep, 4, 1, String.valueOf(this.errCode));
        Terser.set(errorSegment, 1, rep, 4, 3, "hl70357");
        Terser.set(errorSegment, 1, rep, 4, 5, this.getMessage());

        //try to get error condition text
//        try {
            // FIXME: make this work
            String desc = "ERROR"; // TableRepository.getInstance(theJdbcUrl).getDescription(357, String.valueOf(this.errCode));
            Terser.set(errorSegment, 1, rep, 4, 2, desc);
//        }
//        catch (LookupException e) {
//            ourLog.debug(
//                "Warning: LookupException getting error condition text (are we connected to a TableRepository?)", e);
//        } catch (SQLException e) {
//            throw new HL7Exception(e);
//        }
    }
}