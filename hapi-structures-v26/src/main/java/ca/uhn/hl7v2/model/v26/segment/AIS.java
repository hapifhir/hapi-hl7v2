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
 *<p>Represents an HL7 AIS message segment (Appointment Information). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>AIS-1: Set ID - AIS (SI) <b> </b>
     * <li>AIS-2: Segment Action Code (ID) <b>optional </b>
     * <li>AIS-3: Universal Service Identifier (CWE) <b> </b>
     * <li>AIS-4: Start Date/Time (DTM) <b>optional </b>
     * <li>AIS-5: Start Date/Time Offset (NM) <b>optional </b>
     * <li>AIS-6: Start Date/Time Offset Units (CNE) <b>optional </b>
     * <li>AIS-7: Duration (NM) <b>optional </b>
     * <li>AIS-8: Duration Units (CNE) <b>optional </b>
     * <li>AIS-9: Allow Substitution Code (IS) <b>optional </b>
     * <li>AIS-10: Filler Status Code (CWE) <b>optional </b>
     * <li>AIS-11: Placer Supplemental Service Information (CWE) <b>optional repeating</b>
     * <li>AIS-12: Filler Supplemental Service Information (CWE) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class AIS extends AbstractSegment {

    /** 
     * Creates a new AIS segment
     */
    public AIS(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "Set ID - AIS");
                                              this.add(ID.class, false, 1, 3, new Object[]{ getMessage(), new Integer(206) }, "Segment Action Code");
                                  this.add(CWE.class, true, 1, 705, new Object[]{ getMessage() }, "Universal Service Identifier");
                                  this.add(DTM.class, false, 1, 24, new Object[]{ getMessage() }, "Start Date/Time");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Start Date/Time Offset");
                                  this.add(CNE.class, false, 1, 250, new Object[]{ getMessage() }, "Start Date/Time Offset Units");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Duration");
                                  this.add(CNE.class, false, 1, 250, new Object[]{ getMessage() }, "Duration Units");
                                              this.add(IS.class, false, 1, 10, new Object[]{ getMessage(), new Integer(279) }, "Allow Substitution Code");
                                  this.add(CWE.class, false, 1, 250, new Object[]{ getMessage() }, "Filler Status Code");
                                  this.add(CWE.class, false, 0, 705, new Object[]{ getMessage() }, "Placer Supplemental Service Information");
                                  this.add(CWE.class, false, 0, 705, new Object[]{ getMessage() }, "Filler Supplemental Service Information");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating AIS - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * AIS-1: "Set ID - AIS" - creates it if necessary
     */
    public SI getSetIDAIS() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AIS-1: "Set ID - AIS" - creates it if necessary
     */
    public SI getAis1_SetIDAIS() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * AIS-2: "Segment Action Code" - creates it if necessary
     */
    public ID getSegmentActionCode() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AIS-2: "Segment Action Code" - creates it if necessary
     */
    public ID getAis2_SegmentActionCode() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * AIS-3: "Universal Service Identifier" - creates it if necessary
     */
    public CWE getUniversalServiceIdentifier() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AIS-3: "Universal Service Identifier" - creates it if necessary
     */
    public CWE getAis3_UniversalServiceIdentifier() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * AIS-4: "Start Date/Time" - creates it if necessary
     */
    public DTM getStartDateTime() { 
		DTM retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AIS-4: "Start Date/Time" - creates it if necessary
     */
    public DTM getAis4_StartDateTime() { 
		DTM retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * AIS-5: "Start Date/Time Offset" - creates it if necessary
     */
    public NM getStartDateTimeOffset() { 
		NM retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AIS-5: "Start Date/Time Offset" - creates it if necessary
     */
    public NM getAis5_StartDateTimeOffset() { 
		NM retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * AIS-6: "Start Date/Time Offset Units" - creates it if necessary
     */
    public CNE getStartDateTimeOffsetUnits() { 
		CNE retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AIS-6: "Start Date/Time Offset Units" - creates it if necessary
     */
    public CNE getAis6_StartDateTimeOffsetUnits() { 
		CNE retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * AIS-7: "Duration" - creates it if necessary
     */
    public NM getDuration() { 
		NM retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AIS-7: "Duration" - creates it if necessary
     */
    public NM getAis7_Duration() { 
		NM retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * AIS-8: "Duration Units" - creates it if necessary
     */
    public CNE getDurationUnits() { 
		CNE retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AIS-8: "Duration Units" - creates it if necessary
     */
    public CNE getAis8_DurationUnits() { 
		CNE retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * AIS-9: "Allow Substitution Code" - creates it if necessary
     */
    public IS getAllowSubstitutionCode() { 
		IS retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AIS-9: "Allow Substitution Code" - creates it if necessary
     */
    public IS getAis9_AllowSubstitutionCode() { 
		IS retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * AIS-10: "Filler Status Code" - creates it if necessary
     */
    public CWE getFillerStatusCode() { 
		CWE retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AIS-10: "Filler Status Code" - creates it if necessary
     */
    public CWE getAis10_FillerStatusCode() { 
		CWE retVal = this.getTypedField(10, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Placer Supplemental Service Information (AIS-11).
     */
    public CWE[] getPlacerSupplementalServiceInformation() {
    	CWE[] retVal = this.getTypedField(11, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Placer Supplemental Service Information (AIS-11).
     */
    public CWE[] getAis11_PlacerSupplementalServiceInformation() {
    	CWE[] retVal = this.getTypedField(11, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Placer Supplemental Service Information (AIS-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPlacerSupplementalServiceInformationReps() {
    	return this.getReps(11);
    }


    /**
     * Returns a specific repetition of
     * AIS-11: "Placer Supplemental Service Information" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getPlacerSupplementalServiceInformation(int rep) { 
		CWE retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * AIS-11: "Placer Supplemental Service Information" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getAis11_PlacerSupplementalServiceInformation(int rep) { 
		CWE retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Placer Supplemental Service Information (AIS-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAis11_PlacerSupplementalServiceInformationReps() {
    	return this.getReps(11);
    }


    /**
     * Inserts a repetition of
     * AIS-11: "Placer Supplemental Service Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertPlacerSupplementalServiceInformation(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(11, rep);
    }


    /**
     * Inserts a repetition of
     * AIS-11: "Placer Supplemental Service Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertAis11_PlacerSupplementalServiceInformation(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * AIS-11: "Placer Supplemental Service Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removePlacerSupplementalServiceInformation(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * AIS-11: "Placer Supplemental Service Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeAis11_PlacerSupplementalServiceInformation(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(11, rep);
    }



    /**
     * Returns all repetitions of Filler Supplemental Service Information (AIS-12).
     */
    public CWE[] getFillerSupplementalServiceInformation() {
    	CWE[] retVal = this.getTypedField(12, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Filler Supplemental Service Information (AIS-12).
     */
    public CWE[] getAis12_FillerSupplementalServiceInformation() {
    	CWE[] retVal = this.getTypedField(12, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Filler Supplemental Service Information (AIS-12).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getFillerSupplementalServiceInformationReps() {
    	return this.getReps(12);
    }


    /**
     * Returns a specific repetition of
     * AIS-12: "Filler Supplemental Service Information" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getFillerSupplementalServiceInformation(int rep) { 
		CWE retVal = this.getTypedField(12, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * AIS-12: "Filler Supplemental Service Information" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getAis12_FillerSupplementalServiceInformation(int rep) { 
		CWE retVal = this.getTypedField(12, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Filler Supplemental Service Information (AIS-12).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAis12_FillerSupplementalServiceInformationReps() {
    	return this.getReps(12);
    }


    /**
     * Inserts a repetition of
     * AIS-12: "Filler Supplemental Service Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertFillerSupplementalServiceInformation(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(12, rep);
    }


    /**
     * Inserts a repetition of
     * AIS-12: "Filler Supplemental Service Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertAis12_FillerSupplementalServiceInformation(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(12, rep);
    }


    /**
     * Removes a repetition of
     * AIS-12: "Filler Supplemental Service Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeFillerSupplementalServiceInformation(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(12, rep);
    }


    /**
     * Removes a repetition of
     * AIS-12: "Filler Supplemental Service Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeAis12_FillerSupplementalServiceInformation(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(12, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new ID(getMessage(), new Integer( 206 ));
          case 2: return new CWE(getMessage());
          case 3: return new DTM(getMessage());
          case 4: return new NM(getMessage());
          case 5: return new CNE(getMessage());
          case 6: return new NM(getMessage());
          case 7: return new CNE(getMessage());
          case 8: return new IS(getMessage(), new Integer( 279 ));
          case 9: return new CWE(getMessage());
          case 10: return new CWE(getMessage());
          case 11: return new CWE(getMessage());
          default: return null;
       }
   }


}

