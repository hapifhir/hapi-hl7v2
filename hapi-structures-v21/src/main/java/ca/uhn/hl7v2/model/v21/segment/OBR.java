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


package ca.uhn.hl7v2.model.v21.segment;

// import ca.uhn.hl7v2.model.v21.group.*;
import ca.uhn.hl7v2.model.v21.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 OBR message segment (OBSERVATION REQUEST). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>OBR-1: SET ID - OBSERVATION REQUEST (SI) <b>optional </b>
     * <li>OBR-2: PLACER ORDER # (CM) <b>optional </b>
     * <li>OBR-3: FILLER ORDER # (CM) <b>optional </b>
     * <li>OBR-4: UNIVERSAL SERVICE IDENT. (CE) <b> </b>
     * <li>OBR-5: PRIORITY (ST) <b>optional </b>
     * <li>OBR-6: REQUESTED DATE-TIME (TS) <b>optional </b>
     * <li>OBR-7: OBSERVATION DATE/TIME (TS) <b> </b>
     * <li>OBR-8: OBSERVATION END DATE/TIME (TS) <b> </b>
     * <li>OBR-9: COLLECTION VOLUME (CQ) <b> </b>
     * <li>OBR-10: COLLECTOR IDENTIFIER (CN) <b>optional repeating</b>
     * <li>OBR-11: SPECIMEN ACTION CODE (ST) <b>optional </b>
     * <li>OBR-12: DANGER CODE (CM) <b>optional </b>
     * <li>OBR-13: RELEVANT CLINICAL INFO. (ST) <b>optional </b>
     * <li>OBR-14: SPECIMEN RECEIVED DATE/TIME (TS) <b> </b>
     * <li>OBR-15: SPECIMEN SOURCE (CM) <b>optional </b>
     * <li>OBR-16: ORDERING PROVIDER (CN) <b>optional repeating</b>
     * <li>OBR-17: ORDER CALL-BACK PHONE NUM (TN) <b>optional repeating</b>
     * <li>OBR-18: PLACERS FIELD #1 (ST) <b>optional </b>
     * <li>OBR-19: PLACERS FIELD #2 (ST) <b>optional </b>
     * <li>OBR-20: FILLERS FIELD #1 (ST) <b>optional </b>
     * <li>OBR-21: FILLERS FIELD #2 (ST) <b>optional </b>
     * <li>OBR-22: RESULTS RPT/STATUS CHNG - DATE/T (TS) <b> </b>
     * <li>OBR-23: CHARGE TO PRACTICE (CM) <b>optional </b>
     * <li>OBR-24: DIAGNOSTIC SERV SECT ID (ID) <b>optional </b>
     * <li>OBR-25: RESULT STATUS (ID) <b>optional </b>
     * <li>OBR-26: LINKED RESULTS (CE) <b>optional </b>
     * <li>OBR-27: QUANTITY/TIMING (CM) <b>optional repeating</b>
     * <li>OBR-28: RESULT COPIES TO (CN) <b>optional repeating</b>
     * <li>OBR-29: PARENT ACCESSION # (CM) <b>optional </b>
     * <li>OBR-30: TRANSPORTATION MODE (ID) <b>optional </b>
     * <li>OBR-31: REASON FOR STUDY (CE) <b>optional repeating</b>
     * <li>OBR-32: PRINCIPAL RESULT INTERPRETER (CN) <b>optional </b>
     * <li>OBR-33: ASSISTANT RESULT INTERPRETER (CN) <b>optional </b>
     * <li>OBR-34: TECHNICIAN (CN) <b>optional </b>
     * <li>OBR-35: TRANSCRIPTIONIST (CN) <b>optional </b>
     * <li>OBR-36: SCHEDULED - DATE/TIME (TS) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class OBR extends AbstractSegment {

    /** 
     * Creates a new OBR segment
     */
    public OBR(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, false, 1, 4, new Object[]{ getMessage() }, "SET ID - OBSERVATION REQUEST");
                                  this.add(CM.class, false, 1, 75, new Object[]{ getMessage() }, "PLACER ORDER #");
                                  this.add(CM.class, false, 1, 75, new Object[]{ getMessage() }, "FILLER ORDER #");
                                  this.add(CE.class, true, 1, 200, new Object[]{ getMessage() }, "UNIVERSAL SERVICE IDENT.");
                                  this.add(ST.class, false, 1, 2, new Object[]{ getMessage() }, "PRIORITY");
                                  this.add(TS.class, false, 1, 19, new Object[]{ getMessage() }, "REQUESTED DATE-TIME");
                                  this.add(TS.class, true, 1, 19, new Object[]{ getMessage() }, "OBSERVATION DATE/TIME");
                                  this.add(TS.class, true, 1, 19, new Object[]{ getMessage() }, "OBSERVATION END DATE/TIME");
                                  this.add(CQ.class, true, 1, 20, new Object[]{ getMessage() }, "COLLECTION VOLUME");
                                  this.add(CN.class, false, 0, 60, new Object[]{ getMessage() }, "COLLECTOR IDENTIFIER");
                                  this.add(ST.class, false, 1, 1, new Object[]{ getMessage() }, "SPECIMEN ACTION CODE");
                                  this.add(CM.class, false, 1, 60, new Object[]{ getMessage() }, "DANGER CODE");
                                  this.add(ST.class, false, 1, 300, new Object[]{ getMessage() }, "RELEVANT CLINICAL INFO.");
                                  this.add(TS.class, true, 1, 19, new Object[]{ getMessage() }, "SPECIMEN RECEIVED DATE/TIME");
                                  this.add(CM.class, false, 1, 300, new Object[]{ getMessage() }, "SPECIMEN SOURCE");
                                  this.add(CN.class, false, 0, 60, new Object[]{ getMessage() }, "ORDERING PROVIDER");
                                  this.add(TN.class, false, 2, 40, new Object[]{ getMessage() }, "ORDER CALL-BACK PHONE NUM");
                                  this.add(ST.class, false, 1, 60, new Object[]{ getMessage() }, "PLACERS FIELD #1");
                                  this.add(ST.class, false, 1, 60, new Object[]{ getMessage() }, "PLACERS FIELD #2");
                                  this.add(ST.class, false, 1, 60, new Object[]{ getMessage() }, "FILLERS FIELD #1");
                                  this.add(ST.class, false, 1, 60, new Object[]{ getMessage() }, "FILLERS FIELD #2");
                                  this.add(TS.class, true, 1, 19, new Object[]{ getMessage() }, "RESULTS RPT/STATUS CHNG - DATE/T");
                                  this.add(CM.class, false, 1, 40, new Object[]{ getMessage() }, "CHARGE TO PRACTICE");
                                              this.add(ID.class, false, 1, 10, new Object[]{ getMessage(), new Integer(74) }, "DIAGNOSTIC SERV SECT ID");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(123) }, "RESULT STATUS");
                                  this.add(CE.class, false, 1, 200, new Object[]{ getMessage() }, "LINKED RESULTS");
                                  this.add(CM.class, false, 0, 200, new Object[]{ getMessage() }, "QUANTITY/TIMING");
                                  this.add(CN.class, false, 5, 80, new Object[]{ getMessage() }, "RESULT COPIES TO");
                                  this.add(CM.class, false, 1, 150, new Object[]{ getMessage() }, "PARENT ACCESSION #");
                                              this.add(ID.class, false, 1, 20, new Object[]{ getMessage(), new Integer(124) }, "TRANSPORTATION MODE");
                                  this.add(CE.class, false, 0, 300, new Object[]{ getMessage() }, "REASON FOR STUDY");
                                  this.add(CN.class, false, 1, 60, new Object[]{ getMessage() }, "PRINCIPAL RESULT INTERPRETER");
                                  this.add(CN.class, false, 1, 60, new Object[]{ getMessage() }, "ASSISTANT RESULT INTERPRETER");
                                  this.add(CN.class, false, 1, 60, new Object[]{ getMessage() }, "TECHNICIAN");
                                  this.add(CN.class, false, 1, 60, new Object[]{ getMessage() }, "TRANSCRIPTIONIST");
                                  this.add(TS.class, false, 1, 19, new Object[]{ getMessage() }, "SCHEDULED - DATE/TIME");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating OBR - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * OBR-1: "SET ID - OBSERVATION REQUEST" - creates it if necessary
     */
    public SI getSETIDOBSERVATIONREQUEST() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-1: "SET ID - OBSERVATION REQUEST" - creates it if necessary
     */
    public SI getObr1_SETIDOBSERVATIONREQUEST() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-2: "PLACER ORDER #" - creates it if necessary
     */
    public CM getPLACERORDER() { 
		CM retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-2: "PLACER ORDER #" - creates it if necessary
     */
    public CM getObr2_PLACERORDER() { 
		CM retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-3: "FILLER ORDER #" - creates it if necessary
     */
    public CM getFILLERORDER() { 
		CM retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-3: "FILLER ORDER #" - creates it if necessary
     */
    public CM getObr3_FILLERORDER() { 
		CM retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-4: "UNIVERSAL SERVICE IDENT." - creates it if necessary
     */
    public CE getUNIVERSALSERVICEIDENT() { 
		CE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-4: "UNIVERSAL SERVICE IDENT." - creates it if necessary
     */
    public CE getObr4_UNIVERSALSERVICEIDENT() { 
		CE retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-5: "PRIORITY" - creates it if necessary
     */
    public ST getPRIORITY() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-5: "PRIORITY" - creates it if necessary
     */
    public ST getObr5_PRIORITY() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-6: "REQUESTED DATE-TIME" - creates it if necessary
     */
    public TS getREQUESTEDDATETIME() { 
		TS retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-6: "REQUESTED DATE-TIME" - creates it if necessary
     */
    public TS getObr6_REQUESTEDDATETIME() { 
		TS retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-7: "OBSERVATION DATE/TIME" - creates it if necessary
     */
    public TS getOBSERVATIONDATETIME() { 
		TS retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-7: "OBSERVATION DATE/TIME" - creates it if necessary
     */
    public TS getObr7_OBSERVATIONDATETIME() { 
		TS retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-8: "OBSERVATION END DATE/TIME" - creates it if necessary
     */
    public TS getOBSERVATIONENDDATETIME() { 
		TS retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-8: "OBSERVATION END DATE/TIME" - creates it if necessary
     */
    public TS getObr8_OBSERVATIONENDDATETIME() { 
		TS retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-9: "COLLECTION VOLUME" - creates it if necessary
     */
    public CQ getCOLLECTIONVOLUME() { 
		CQ retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-9: "COLLECTION VOLUME" - creates it if necessary
     */
    public CQ getObr9_COLLECTIONVOLUME() { 
		CQ retVal = this.getTypedField(9, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of COLLECTOR IDENTIFIER (OBR-10).
     */
    public CN[] getCOLLECTORIDENTIFIER() {
    	CN[] retVal = this.getTypedField(10, new CN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of COLLECTOR IDENTIFIER (OBR-10).
     */
    public CN[] getObr10_COLLECTORIDENTIFIER() {
    	CN[] retVal = this.getTypedField(10, new CN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of COLLECTOR IDENTIFIER (OBR-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCOLLECTORIDENTIFIERReps() {
    	return this.getReps(10);
    }


    /**
     * Returns a specific repetition of
     * OBR-10: "COLLECTOR IDENTIFIER" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CN getCOLLECTORIDENTIFIER(int rep) { 
		CN retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-10: "COLLECTOR IDENTIFIER" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CN getObr10_COLLECTORIDENTIFIER(int rep) { 
		CN retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of COLLECTOR IDENTIFIER (OBR-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObr10_COLLECTORIDENTIFIERReps() {
    	return this.getReps(10);
    }


    /**
     * Inserts a repetition of
     * OBR-10: "COLLECTOR IDENTIFIER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CN insertCOLLECTORIDENTIFIER(int rep) throws HL7Exception { 
        return (CN) super.insertRepetition(10, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-10: "COLLECTOR IDENTIFIER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CN insertObr10_COLLECTORIDENTIFIER(int rep) throws HL7Exception { 
        return (CN) super.insertRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * OBR-10: "COLLECTOR IDENTIFIER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CN removeCOLLECTORIDENTIFIER(int rep) throws HL7Exception { 
        return (CN) super.removeRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * OBR-10: "COLLECTOR IDENTIFIER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CN removeObr10_COLLECTORIDENTIFIER(int rep) throws HL7Exception { 
        return (CN) super.removeRepetition(10, rep);
    }




    /**
     * Returns
     * OBR-11: "SPECIMEN ACTION CODE" - creates it if necessary
     */
    public ST getSPECIMENACTIONCODE() { 
		ST retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-11: "SPECIMEN ACTION CODE" - creates it if necessary
     */
    public ST getObr11_SPECIMENACTIONCODE() { 
		ST retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-12: "DANGER CODE" - creates it if necessary
     */
    public CM getDANGERCODE() { 
		CM retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-12: "DANGER CODE" - creates it if necessary
     */
    public CM getObr12_DANGERCODE() { 
		CM retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-13: "RELEVANT CLINICAL INFO." - creates it if necessary
     */
    public ST getRELEVANTCLINICALINFO() { 
		ST retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-13: "RELEVANT CLINICAL INFO." - creates it if necessary
     */
    public ST getObr13_RELEVANTCLINICALINFO() { 
		ST retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-14: "SPECIMEN RECEIVED DATE/TIME" - creates it if necessary
     */
    public TS getSPECIMENRECEIVEDDATETIME() { 
		TS retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-14: "SPECIMEN RECEIVED DATE/TIME" - creates it if necessary
     */
    public TS getObr14_SPECIMENRECEIVEDDATETIME() { 
		TS retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-15: "SPECIMEN SOURCE" - creates it if necessary
     */
    public CM getSPECIMENSOURCE() { 
		CM retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-15: "SPECIMEN SOURCE" - creates it if necessary
     */
    public CM getObr15_SPECIMENSOURCE() { 
		CM retVal = this.getTypedField(15, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of ORDERING PROVIDER (OBR-16).
     */
    public CN[] getORDERINGPROVIDER() {
    	CN[] retVal = this.getTypedField(16, new CN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of ORDERING PROVIDER (OBR-16).
     */
    public CN[] getObr16_ORDERINGPROVIDER() {
    	CN[] retVal = this.getTypedField(16, new CN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of ORDERING PROVIDER (OBR-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getORDERINGPROVIDERReps() {
    	return this.getReps(16);
    }


    /**
     * Returns a specific repetition of
     * OBR-16: "ORDERING PROVIDER" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CN getORDERINGPROVIDER(int rep) { 
		CN retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-16: "ORDERING PROVIDER" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CN getObr16_ORDERINGPROVIDER(int rep) { 
		CN retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of ORDERING PROVIDER (OBR-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObr16_ORDERINGPROVIDERReps() {
    	return this.getReps(16);
    }


    /**
     * Inserts a repetition of
     * OBR-16: "ORDERING PROVIDER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CN insertORDERINGPROVIDER(int rep) throws HL7Exception { 
        return (CN) super.insertRepetition(16, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-16: "ORDERING PROVIDER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CN insertObr16_ORDERINGPROVIDER(int rep) throws HL7Exception { 
        return (CN) super.insertRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * OBR-16: "ORDERING PROVIDER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CN removeORDERINGPROVIDER(int rep) throws HL7Exception { 
        return (CN) super.removeRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * OBR-16: "ORDERING PROVIDER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CN removeObr16_ORDERINGPROVIDER(int rep) throws HL7Exception { 
        return (CN) super.removeRepetition(16, rep);
    }



    /**
     * Returns all repetitions of ORDER CALL-BACK PHONE NUM (OBR-17).
     */
    public TN[] getORDERCALLBACKPHONENUM() {
    	TN[] retVal = this.getTypedField(17, new TN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of ORDER CALL-BACK PHONE NUM (OBR-17).
     */
    public TN[] getObr17_ORDERCALLBACKPHONENUM() {
    	TN[] retVal = this.getTypedField(17, new TN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of ORDER CALL-BACK PHONE NUM (OBR-17).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getORDERCALLBACKPHONENUMReps() {
    	return this.getReps(17);
    }


    /**
     * Returns a specific repetition of
     * OBR-17: "ORDER CALL-BACK PHONE NUM" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TN getORDERCALLBACKPHONENUM(int rep) { 
		TN retVal = this.getTypedField(17, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-17: "ORDER CALL-BACK PHONE NUM" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TN getObr17_ORDERCALLBACKPHONENUM(int rep) { 
		TN retVal = this.getTypedField(17, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of ORDER CALL-BACK PHONE NUM (OBR-17).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObr17_ORDERCALLBACKPHONENUMReps() {
    	return this.getReps(17);
    }


    /**
     * Inserts a repetition of
     * OBR-17: "ORDER CALL-BACK PHONE NUM" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN insertORDERCALLBACKPHONENUM(int rep) throws HL7Exception { 
        return (TN) super.insertRepetition(17, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-17: "ORDER CALL-BACK PHONE NUM" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN insertObr17_ORDERCALLBACKPHONENUM(int rep) throws HL7Exception { 
        return (TN) super.insertRepetition(17, rep);
    }


    /**
     * Removes a repetition of
     * OBR-17: "ORDER CALL-BACK PHONE NUM" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN removeORDERCALLBACKPHONENUM(int rep) throws HL7Exception { 
        return (TN) super.removeRepetition(17, rep);
    }


    /**
     * Removes a repetition of
     * OBR-17: "ORDER CALL-BACK PHONE NUM" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN removeObr17_ORDERCALLBACKPHONENUM(int rep) throws HL7Exception { 
        return (TN) super.removeRepetition(17, rep);
    }




    /**
     * Returns
     * OBR-18: "PLACERS FIELD #1" - creates it if necessary
     */
    public ST getPLACERSFIELD1() { 
		ST retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-18: "PLACERS FIELD #1" - creates it if necessary
     */
    public ST getObr18_PLACERSFIELD1() { 
		ST retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-19: "PLACERS FIELD #2" - creates it if necessary
     */
    public ST getPLACERSFIELD2() { 
		ST retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-19: "PLACERS FIELD #2" - creates it if necessary
     */
    public ST getObr19_PLACERSFIELD2() { 
		ST retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-20: "FILLERS FIELD #1" - creates it if necessary
     */
    public ST getFILLERSFIELD1() { 
		ST retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-20: "FILLERS FIELD #1" - creates it if necessary
     */
    public ST getObr20_FILLERSFIELD1() { 
		ST retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-21: "FILLERS FIELD #2" - creates it if necessary
     */
    public ST getFILLERSFIELD2() { 
		ST retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-21: "FILLERS FIELD #2" - creates it if necessary
     */
    public ST getObr21_FILLERSFIELD2() { 
		ST retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-22: "RESULTS RPT/STATUS CHNG - DATE/T" - creates it if necessary
     */
    public TS getRESULTSRPTSTATUSCHNGDATET() { 
		TS retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-22: "RESULTS RPT/STATUS CHNG - DATE/T" - creates it if necessary
     */
    public TS getObr22_RESULTSRPTSTATUSCHNGDATET() { 
		TS retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-23: "CHARGE TO PRACTICE" - creates it if necessary
     */
    public CM getCHARGETOPRACTICE() { 
		CM retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-23: "CHARGE TO PRACTICE" - creates it if necessary
     */
    public CM getObr23_CHARGETOPRACTICE() { 
		CM retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-24: "DIAGNOSTIC SERV SECT ID" - creates it if necessary
     */
    public ID getDIAGNOSTICSERVSECTID() { 
		ID retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-24: "DIAGNOSTIC SERV SECT ID" - creates it if necessary
     */
    public ID getObr24_DIAGNOSTICSERVSECTID() { 
		ID retVal = this.getTypedField(24, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-25: "RESULT STATUS" - creates it if necessary
     */
    public ID getRESULTSTATUS() { 
		ID retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-25: "RESULT STATUS" - creates it if necessary
     */
    public ID getObr25_RESULTSTATUS() { 
		ID retVal = this.getTypedField(25, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-26: "LINKED RESULTS" - creates it if necessary
     */
    public CE getLINKEDRESULTS() { 
		CE retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-26: "LINKED RESULTS" - creates it if necessary
     */
    public CE getObr26_LINKEDRESULTS() { 
		CE retVal = this.getTypedField(26, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of QUANTITY/TIMING (OBR-27).
     */
    public CM[] getQUANTITYTIMING() {
    	CM[] retVal = this.getTypedField(27, new CM[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of QUANTITY/TIMING (OBR-27).
     */
    public CM[] getObr27_QUANTITYTIMING() {
    	CM[] retVal = this.getTypedField(27, new CM[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of QUANTITY/TIMING (OBR-27).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getQUANTITYTIMINGReps() {
    	return this.getReps(27);
    }


    /**
     * Returns a specific repetition of
     * OBR-27: "QUANTITY/TIMING" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM getQUANTITYTIMING(int rep) { 
		CM retVal = this.getTypedField(27, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-27: "QUANTITY/TIMING" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM getObr27_QUANTITYTIMING(int rep) { 
		CM retVal = this.getTypedField(27, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of QUANTITY/TIMING (OBR-27).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObr27_QUANTITYTIMINGReps() {
    	return this.getReps(27);
    }


    /**
     * Inserts a repetition of
     * OBR-27: "QUANTITY/TIMING" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM insertQUANTITYTIMING(int rep) throws HL7Exception { 
        return (CM) super.insertRepetition(27, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-27: "QUANTITY/TIMING" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM insertObr27_QUANTITYTIMING(int rep) throws HL7Exception { 
        return (CM) super.insertRepetition(27, rep);
    }


    /**
     * Removes a repetition of
     * OBR-27: "QUANTITY/TIMING" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM removeQUANTITYTIMING(int rep) throws HL7Exception { 
        return (CM) super.removeRepetition(27, rep);
    }


    /**
     * Removes a repetition of
     * OBR-27: "QUANTITY/TIMING" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM removeObr27_QUANTITYTIMING(int rep) throws HL7Exception { 
        return (CM) super.removeRepetition(27, rep);
    }



    /**
     * Returns all repetitions of RESULT COPIES TO (OBR-28).
     */
    public CN[] getRESULTCOPIESTO() {
    	CN[] retVal = this.getTypedField(28, new CN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of RESULT COPIES TO (OBR-28).
     */
    public CN[] getObr28_RESULTCOPIESTO() {
    	CN[] retVal = this.getTypedField(28, new CN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of RESULT COPIES TO (OBR-28).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRESULTCOPIESTOReps() {
    	return this.getReps(28);
    }


    /**
     * Returns a specific repetition of
     * OBR-28: "RESULT COPIES TO" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CN getRESULTCOPIESTO(int rep) { 
		CN retVal = this.getTypedField(28, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-28: "RESULT COPIES TO" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CN getObr28_RESULTCOPIESTO(int rep) { 
		CN retVal = this.getTypedField(28, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of RESULT COPIES TO (OBR-28).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObr28_RESULTCOPIESTOReps() {
    	return this.getReps(28);
    }


    /**
     * Inserts a repetition of
     * OBR-28: "RESULT COPIES TO" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CN insertRESULTCOPIESTO(int rep) throws HL7Exception { 
        return (CN) super.insertRepetition(28, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-28: "RESULT COPIES TO" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CN insertObr28_RESULTCOPIESTO(int rep) throws HL7Exception { 
        return (CN) super.insertRepetition(28, rep);
    }


    /**
     * Removes a repetition of
     * OBR-28: "RESULT COPIES TO" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CN removeRESULTCOPIESTO(int rep) throws HL7Exception { 
        return (CN) super.removeRepetition(28, rep);
    }


    /**
     * Removes a repetition of
     * OBR-28: "RESULT COPIES TO" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CN removeObr28_RESULTCOPIESTO(int rep) throws HL7Exception { 
        return (CN) super.removeRepetition(28, rep);
    }




    /**
     * Returns
     * OBR-29: "PARENT ACCESSION #" - creates it if necessary
     */
    public CM getPARENTACCESSION() { 
		CM retVal = this.getTypedField(29, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-29: "PARENT ACCESSION #" - creates it if necessary
     */
    public CM getObr29_PARENTACCESSION() { 
		CM retVal = this.getTypedField(29, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-30: "TRANSPORTATION MODE" - creates it if necessary
     */
    public ID getTRANSPORTATIONMODE() { 
		ID retVal = this.getTypedField(30, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-30: "TRANSPORTATION MODE" - creates it if necessary
     */
    public ID getObr30_TRANSPORTATIONMODE() { 
		ID retVal = this.getTypedField(30, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of REASON FOR STUDY (OBR-31).
     */
    public CE[] getREASONFORSTUDY() {
    	CE[] retVal = this.getTypedField(31, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of REASON FOR STUDY (OBR-31).
     */
    public CE[] getObr31_REASONFORSTUDY() {
    	CE[] retVal = this.getTypedField(31, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of REASON FOR STUDY (OBR-31).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getREASONFORSTUDYReps() {
    	return this.getReps(31);
    }


    /**
     * Returns a specific repetition of
     * OBR-31: "REASON FOR STUDY" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getREASONFORSTUDY(int rep) { 
		CE retVal = this.getTypedField(31, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-31: "REASON FOR STUDY" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getObr31_REASONFORSTUDY(int rep) { 
		CE retVal = this.getTypedField(31, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of REASON FOR STUDY (OBR-31).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObr31_REASONFORSTUDYReps() {
    	return this.getReps(31);
    }


    /**
     * Inserts a repetition of
     * OBR-31: "REASON FOR STUDY" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertREASONFORSTUDY(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(31, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-31: "REASON FOR STUDY" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertObr31_REASONFORSTUDY(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(31, rep);
    }


    /**
     * Removes a repetition of
     * OBR-31: "REASON FOR STUDY" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeREASONFORSTUDY(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(31, rep);
    }


    /**
     * Removes a repetition of
     * OBR-31: "REASON FOR STUDY" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeObr31_REASONFORSTUDY(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(31, rep);
    }




    /**
     * Returns
     * OBR-32: "PRINCIPAL RESULT INTERPRETER" - creates it if necessary
     */
    public CN getPRINCIPALRESULTINTERPRETER() { 
		CN retVal = this.getTypedField(32, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-32: "PRINCIPAL RESULT INTERPRETER" - creates it if necessary
     */
    public CN getObr32_PRINCIPALRESULTINTERPRETER() { 
		CN retVal = this.getTypedField(32, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-33: "ASSISTANT RESULT INTERPRETER" - creates it if necessary
     */
    public CN getASSISTANTRESULTINTERPRETER() { 
		CN retVal = this.getTypedField(33, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-33: "ASSISTANT RESULT INTERPRETER" - creates it if necessary
     */
    public CN getObr33_ASSISTANTRESULTINTERPRETER() { 
		CN retVal = this.getTypedField(33, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-34: "TECHNICIAN" - creates it if necessary
     */
    public CN getTECHNICIAN() { 
		CN retVal = this.getTypedField(34, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-34: "TECHNICIAN" - creates it if necessary
     */
    public CN getObr34_TECHNICIAN() { 
		CN retVal = this.getTypedField(34, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-35: "TRANSCRIPTIONIST" - creates it if necessary
     */
    public CN getTRANSCRIPTIONIST() { 
		CN retVal = this.getTypedField(35, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-35: "TRANSCRIPTIONIST" - creates it if necessary
     */
    public CN getObr35_TRANSCRIPTIONIST() { 
		CN retVal = this.getTypedField(35, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-36: "SCHEDULED - DATE/TIME" - creates it if necessary
     */
    public TS getSCHEDULEDDATETIME() { 
		TS retVal = this.getTypedField(36, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-36: "SCHEDULED - DATE/TIME" - creates it if necessary
     */
    public TS getObr36_SCHEDULEDDATETIME() { 
		TS retVal = this.getTypedField(36, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new CM(getMessage());
          case 2: return new CM(getMessage());
          case 3: return new CE(getMessage());
          case 4: return new ST(getMessage());
          case 5: return new TS(getMessage());
          case 6: return new TS(getMessage());
          case 7: return new TS(getMessage());
          case 8: return new CQ(getMessage());
          case 9: return new CN(getMessage());
          case 10: return new ST(getMessage());
          case 11: return new CM(getMessage());
          case 12: return new ST(getMessage());
          case 13: return new TS(getMessage());
          case 14: return new CM(getMessage());
          case 15: return new CN(getMessage());
          case 16: return new TN(getMessage());
          case 17: return new ST(getMessage());
          case 18: return new ST(getMessage());
          case 19: return new ST(getMessage());
          case 20: return new ST(getMessage());
          case 21: return new TS(getMessage());
          case 22: return new CM(getMessage());
          case 23: return new ID(getMessage(), new Integer( 74 ));
          case 24: return new ID(getMessage(), new Integer( 123 ));
          case 25: return new CE(getMessage());
          case 26: return new CM(getMessage());
          case 27: return new CN(getMessage());
          case 28: return new CM(getMessage());
          case 29: return new ID(getMessage(), new Integer( 124 ));
          case 30: return new CE(getMessage());
          case 31: return new CN(getMessage());
          case 32: return new CN(getMessage());
          case 33: return new CN(getMessage());
          case 34: return new CN(getMessage());
          case 35: return new TS(getMessage());
          default: return null;
       }
   }


}

