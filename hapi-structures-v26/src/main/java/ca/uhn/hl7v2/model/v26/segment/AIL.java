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


package ca.uhn.hl7v2.model.v26.segment;

// import ca.uhn.hl7v2.model.v26.group.*;
import ca.uhn.hl7v2.model.v26.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 AIL message segment (Appointment Information - Location Resource). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>AIL-1: Set ID - AIL (SI) <b> </b>
     * <li>AIL-2: Segment Action Code (ID) <b>optional </b>
     * <li>AIL-3: Location Resource ID (PL) <b>optional repeating</b>
     * <li>AIL-4: Location Type - AIL (CWE) <b>optional </b>
     * <li>AIL-5: Location Group (CWE) <b>optional </b>
     * <li>AIL-6: Start Date/Time (DTM) <b>optional </b>
     * <li>AIL-7: Start Date/Time Offset (NM) <b>optional </b>
     * <li>AIL-8: Start Date/Time Offset Units (CNE) <b>optional </b>
     * <li>AIL-9: Duration (NM) <b>optional </b>
     * <li>AIL-10: Duration Units (CNE) <b>optional </b>
     * <li>AIL-11: Allow Substitution Code (IS) <b>optional </b>
     * <li>AIL-12: Filler Status Code (CWE) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class AIL extends AbstractSegment {

    /** 
     * Creates a new AIL segment
     */
    public AIL(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "Set ID - AIL");
                                              this.add(ID.class, false, 1, 3, new Object[]{ getMessage(), new Integer(206) }, "Segment Action Code");
                                  this.add(PL.class, false, 0, 80, new Object[]{ getMessage() }, "Location Resource ID");
                                  this.add(CWE.class, false, 1, 250, new Object[]{ getMessage() }, "Location Type - AIL");
                                  this.add(CWE.class, false, 1, 250, new Object[]{ getMessage() }, "Location Group");
                                  this.add(DTM.class, false, 1, 24, new Object[]{ getMessage() }, "Start Date/Time");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Start Date/Time Offset");
                                  this.add(CNE.class, false, 1, 250, new Object[]{ getMessage() }, "Start Date/Time Offset Units");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Duration");
                                  this.add(CNE.class, false, 1, 250, new Object[]{ getMessage() }, "Duration Units");
                                              this.add(IS.class, false, 1, 10, new Object[]{ getMessage(), new Integer(279) }, "Allow Substitution Code");
                                  this.add(CWE.class, false, 1, 250, new Object[]{ getMessage() }, "Filler Status Code");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating AIL - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * AIL-1: "Set ID - AIL" - creates it if necessary
     */
    public SI getSetIDAIL() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AIL-1: "Set ID - AIL" - creates it if necessary
     */
    public SI getAil1_SetIDAIL() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * AIL-2: "Segment Action Code" - creates it if necessary
     */
    public ID getSegmentActionCode() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AIL-2: "Segment Action Code" - creates it if necessary
     */
    public ID getAil2_SegmentActionCode() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Location Resource ID (AIL-3).
     */
    public PL[] getLocationResourceID() {
    	PL[] retVal = this.getTypedField(3, new PL[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Location Resource ID (AIL-3).
     */
    public PL[] getAil3_LocationResourceID() {
    	PL[] retVal = this.getTypedField(3, new PL[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Location Resource ID (AIL-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getLocationResourceIDReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * AIL-3: "Location Resource ID" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public PL getLocationResourceID(int rep) { 
		PL retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * AIL-3: "Location Resource ID" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public PL getAil3_LocationResourceID(int rep) { 
		PL retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Location Resource ID (AIL-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAil3_LocationResourceIDReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * AIL-3: "Location Resource ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PL insertLocationResourceID(int rep) throws HL7Exception { 
        return (PL) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * AIL-3: "Location Resource ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PL insertAil3_LocationResourceID(int rep) throws HL7Exception { 
        return (PL) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * AIL-3: "Location Resource ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PL removeLocationResourceID(int rep) throws HL7Exception { 
        return (PL) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * AIL-3: "Location Resource ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PL removeAil3_LocationResourceID(int rep) throws HL7Exception { 
        return (PL) super.removeRepetition(3, rep);
    }




    /**
     * Returns
     * AIL-4: "Location Type - AIL" - creates it if necessary
     */
    public CWE getLocationTypeAIL() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AIL-4: "Location Type - AIL" - creates it if necessary
     */
    public CWE getAil4_LocationTypeAIL() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * AIL-5: "Location Group" - creates it if necessary
     */
    public CWE getLocationGroup() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AIL-5: "Location Group" - creates it if necessary
     */
    public CWE getAil5_LocationGroup() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * AIL-6: "Start Date/Time" - creates it if necessary
     */
    public DTM getStartDateTime() { 
		DTM retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AIL-6: "Start Date/Time" - creates it if necessary
     */
    public DTM getAil6_StartDateTime() { 
		DTM retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * AIL-7: "Start Date/Time Offset" - creates it if necessary
     */
    public NM getStartDateTimeOffset() { 
		NM retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AIL-7: "Start Date/Time Offset" - creates it if necessary
     */
    public NM getAil7_StartDateTimeOffset() { 
		NM retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * AIL-8: "Start Date/Time Offset Units" - creates it if necessary
     */
    public CNE getStartDateTimeOffsetUnits() { 
		CNE retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AIL-8: "Start Date/Time Offset Units" - creates it if necessary
     */
    public CNE getAil8_StartDateTimeOffsetUnits() { 
		CNE retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * AIL-9: "Duration" - creates it if necessary
     */
    public NM getDuration() { 
		NM retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AIL-9: "Duration" - creates it if necessary
     */
    public NM getAil9_Duration() { 
		NM retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * AIL-10: "Duration Units" - creates it if necessary
     */
    public CNE getDurationUnits() { 
		CNE retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AIL-10: "Duration Units" - creates it if necessary
     */
    public CNE getAil10_DurationUnits() { 
		CNE retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * AIL-11: "Allow Substitution Code" - creates it if necessary
     */
    public IS getAllowSubstitutionCode() { 
		IS retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AIL-11: "Allow Substitution Code" - creates it if necessary
     */
    public IS getAil11_AllowSubstitutionCode() { 
		IS retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * AIL-12: "Filler Status Code" - creates it if necessary
     */
    public CWE getFillerStatusCode() { 
		CWE retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AIL-12: "Filler Status Code" - creates it if necessary
     */
    public CWE getAil12_FillerStatusCode() { 
		CWE retVal = this.getTypedField(12, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new ID(getMessage(), new Integer( 206 ));
          case 2: return new PL(getMessage());
          case 3: return new CWE(getMessage());
          case 4: return new CWE(getMessage());
          case 5: return new DTM(getMessage());
          case 6: return new NM(getMessage());
          case 7: return new CNE(getMessage());
          case 8: return new NM(getMessage());
          case 9: return new CNE(getMessage());
          case 10: return new IS(getMessage(), new Integer( 279 ));
          case 11: return new CWE(getMessage());
          default: return null;
       }
   }


}

