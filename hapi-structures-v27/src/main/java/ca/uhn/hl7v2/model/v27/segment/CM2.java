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


package ca.uhn.hl7v2.model.v27.segment;

// import ca.uhn.hl7v2.model.v27.group.*;
import ca.uhn.hl7v2.model.v27.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 CM2 message segment (Clinical Study Schedule Master). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>CM2-1: Set ID- CM2 (SI) <b>optional </b>
     * <li>CM2-2: Scheduled Time Point (CWE) <b> </b>
     * <li>CM2-3: Description of Time Point (ST) <b>optional </b>
     * <li>CM2-4: Events Scheduled This Time Point (CWE) <b> repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class CM2 extends AbstractSegment {

    /** 
     * Creates a new CM2 segment
     */
    public CM2(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, false, 1, 4, new Object[]{ getMessage() }, "Set ID- CM2");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Scheduled Time Point");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Description of Time Point");
                                  this.add(CWE.class, true, 200, 0, new Object[]{ getMessage() }, "Events Scheduled This Time Point");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating CM2 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * CM2-1: "Set ID- CM2" - creates it if necessary
     */
    public SI getSetIDCM2() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CM2-1: "Set ID- CM2" - creates it if necessary
     */
    public SI getCm21_SetIDCM2() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * CM2-2: "Scheduled Time Point" - creates it if necessary
     */
    public CWE getScheduledTimePoint() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CM2-2: "Scheduled Time Point" - creates it if necessary
     */
    public CWE getCm22_ScheduledTimePoint() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * CM2-3: "Description of Time Point" - creates it if necessary
     */
    public ST getDescriptionOfTimePoint() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CM2-3: "Description of Time Point" - creates it if necessary
     */
    public ST getCm23_DescriptionOfTimePoint() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Events Scheduled This Time Point (CM2-4).
     */
    public CWE[] getEventsScheduledThisTimePoint() {
    	CWE[] retVal = this.getTypedField(4, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Events Scheduled This Time Point (CM2-4).
     */
    public CWE[] getCm24_EventsScheduledThisTimePoint() {
    	CWE[] retVal = this.getTypedField(4, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Events Scheduled This Time Point (CM2-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getEventsScheduledThisTimePointReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * CM2-4: "Events Scheduled This Time Point" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getEventsScheduledThisTimePoint(int rep) { 
		CWE retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * CM2-4: "Events Scheduled This Time Point" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getCm24_EventsScheduledThisTimePoint(int rep) { 
		CWE retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Events Scheduled This Time Point (CM2-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCm24_EventsScheduledThisTimePointReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * CM2-4: "Events Scheduled This Time Point" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertEventsScheduledThisTimePoint(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * CM2-4: "Events Scheduled This Time Point" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertCm24_EventsScheduledThisTimePoint(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * CM2-4: "Events Scheduled This Time Point" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeEventsScheduledThisTimePoint(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * CM2-4: "Events Scheduled This Time Point" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeCm24_EventsScheduledThisTimePoint(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(4, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new CWE(getMessage());
          case 2: return new ST(getMessage());
          case 3: return new CWE(getMessage());
          default: return null;
       }
   }


}

