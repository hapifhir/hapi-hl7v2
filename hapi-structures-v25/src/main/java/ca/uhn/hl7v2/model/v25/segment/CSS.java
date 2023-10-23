/*
 * This class is an auto-generated source file for a HAPI
 * HL7 v2.x standard structure class.
 *
 * For more information, visit: http://hl7api.sourceforge.net/
 * 
 * The contents of this file are subject to the Mozilla Public License Version 1.1 
 * (the "License"); you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
 * Software distributed under the License is distributed on an "AS IS" basis, 
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
 * specific language governing rights and limitations under the License. 
 * 
 * The Original Code is "[file_name]".  Description: 
 * "[one_line_description]" 
 * 
 * The Initial Developer of the Original Code is University Health Network. Copyright (C) 
 * 2012.  All Rights Reserved. 
 * 
 * Contributor(s): ______________________________________. 
 * 
 * Alternatively, the contents of this file may be used under the terms of the 
 * GNU General Public License (the  "GPL"), in which case the provisions of the GPL are 
 * applicable instead of those above.  If you wish to allow use of your version of this 
 * file only under the terms of the GPL and not to allow others to use your version 
 * of this file under the MPL, indicate your decision by deleting  the provisions above 
 * and replace  them with the notice and other provisions required by the GPL License.  
 * If you do not delete the provisions above, a recipient may use your version of 
 * this file under either the MPL or the GPL. 
 * 
 */


package ca.uhn.hl7v2.model.v25.segment;

// import ca.uhn.hl7v2.model.v25.group.*;
import ca.uhn.hl7v2.model.v25.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 CSS message segment (Clinical Study Data Schedule Segment). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>CSS-1: Study Scheduled Time Point (CE) <b> </b>
     * <li>CSS-2: Study Scheduled Patient Time Point (TS) <b>optional </b>
     * <li>CSS-3: Study Quality Control Codes (CE) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class CSS extends AbstractSegment {

    /** 
     * Creates a new CSS segment
     */
    public CSS(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CE.class, true, 1, 250, new Object[]{ getMessage() }, "Study Scheduled Time Point");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Study Scheduled Patient Time Point");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Study Quality Control Codes");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating CSS - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * CSS-1: "Study Scheduled Time Point" - creates it if necessary
     */
    public CE getStudyScheduledTimePoint() { 
		CE retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CSS-1: "Study Scheduled Time Point" - creates it if necessary
     */
    public CE getCss1_StudyScheduledTimePoint() { 
		CE retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * CSS-2: "Study Scheduled Patient Time Point" - creates it if necessary
     */
    public TS getStudyScheduledPatientTimePoint() { 
		TS retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CSS-2: "Study Scheduled Patient Time Point" - creates it if necessary
     */
    public TS getCss2_StudyScheduledPatientTimePoint() { 
		TS retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Study Quality Control Codes (CSS-3).
     */
    public CE[] getStudyQualityControlCodes() {
    	CE[] retVal = this.getTypedField(3, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Study Quality Control Codes (CSS-3).
     */
    public CE[] getCss3_StudyQualityControlCodes() {
    	CE[] retVal = this.getTypedField(3, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Study Quality Control Codes (CSS-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getStudyQualityControlCodesReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * CSS-3: "Study Quality Control Codes" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getStudyQualityControlCodes(int rep) { 
		CE retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * CSS-3: "Study Quality Control Codes" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getCss3_StudyQualityControlCodes(int rep) { 
		CE retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Study Quality Control Codes (CSS-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCss3_StudyQualityControlCodesReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * CSS-3: "Study Quality Control Codes" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertStudyQualityControlCodes(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * CSS-3: "Study Quality Control Codes" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertCss3_StudyQualityControlCodes(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * CSS-3: "Study Quality Control Codes" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeStudyQualityControlCodes(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * CSS-3: "Study Quality Control Codes" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeCss3_StudyQualityControlCodes(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(3, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CE(getMessage());
          case 1: return new TS(getMessage());
          case 2: return new CE(getMessage());
          default: return null;
       }
   }


}

