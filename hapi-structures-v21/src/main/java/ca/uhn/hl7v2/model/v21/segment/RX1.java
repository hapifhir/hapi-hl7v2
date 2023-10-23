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
 *<p>Represents an HL7 RX1 message segment (PHARMACY ORDER). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>RX1-1: UNUSED (ST) <b>optional </b>
     * <li>RX1-2: UNUSED Number 2 (ST) <b>optional </b>
     * <li>RX1-3: ROUTE (ST) <b>optional </b>
     * <li>RX1-4: SITE ADMINISTERED (ST) <b>optional </b>
     * <li>RX1-5: IV SOLUTION RATE (CQ) <b>optional </b>
     * <li>RX1-6: DRUG STRENGTH (CQ) <b>optional </b>
     * <li>RX1-7: FINAL CONCENTRATION (NM) <b>optional </b>
     * <li>RX1-8: FINAL VOLUME IN ML. (NM) <b>optional </b>
     * <li>RX1-9: DRUG DOSE (CM) <b>optional </b>
     * <li>RX1-10: DRUG ROLE (ID) <b>optional </b>
     * <li>RX1-11: PRESCRIPTION SEQUENCE # (NM) <b>optional </b>
     * <li>RX1-12: QUANTITY DISPENSED (CQ) <b>optional </b>
     * <li>RX1-13: UNUSED Number 3 (ST) <b>optional </b>
     * <li>RX1-14: DRUG ID (CE) <b>optional </b>
     * <li>RX1-15: COMPONENT DRUG IDS (ID) <b>optional repeating</b>
     * <li>RX1-16: PRESCRIPTION TYPE (ID) <b>optional </b>
     * <li>RX1-17: SUBSTITUTION STATUS (ID) <b>optional </b>
     * <li>RX1-18: RX ORDER STATUS (ID) <b>optional </b>
     * <li>RX1-19: NUMBER OF REFILLS (NM) <b>optional </b>
     * <li>RX1-20: UNUSED Number 4 (ST) <b>optional </b>
     * <li>RX1-21: REFILLS REMAINING (NM) <b>optional </b>
     * <li>RX1-22: DEA CLASS (ID) <b>optional </b>
     * <li>RX1-23: ORDERING MD'S DEA NUMBER (NM) <b>optional </b>
     * <li>RX1-24: UNUSED Number 5 (ST) <b>optional </b>
     * <li>RX1-25: LAST REFILL DATE/TIME (TS) <b>optional </b>
     * <li>RX1-26: RX NUMBER (ST) <b>optional </b>
     * <li>RX1-27: PRN STATUS (ID) <b>optional </b>
     * <li>RX1-28: PHARMACY INSTRUCTIONS (TX) <b>optional repeating</b>
     * <li>RX1-29: PATIENT INSTRUCTIONS (TX) <b>optional repeating</b>
     * <li>RX1-30: INSTRUCTIONS (SIG) (TX) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class RX1 extends AbstractSegment {

    /** 
     * Creates a new RX1 segment
     */
    public RX1(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "UNUSED");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "UNUSED Number 2");
                                  this.add(ST.class, false, 1, 8, new Object[]{ getMessage() }, "ROUTE");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "SITE ADMINISTERED");
                                  this.add(CQ.class, false, 1, 10, new Object[]{ getMessage() }, "IV SOLUTION RATE");
                                  this.add(CQ.class, false, 1, 14, new Object[]{ getMessage() }, "DRUG STRENGTH");
                                  this.add(NM.class, false, 1, 10, new Object[]{ getMessage() }, "FINAL CONCENTRATION");
                                  this.add(NM.class, false, 1, 10, new Object[]{ getMessage() }, "FINAL VOLUME IN ML.");
                                  this.add(CM.class, false, 1, 10, new Object[]{ getMessage() }, "DRUG DOSE");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(0) }, "DRUG ROLE");
                                  this.add(NM.class, false, 1, 3, new Object[]{ getMessage() }, "PRESCRIPTION SEQUENCE #");
                                  this.add(CQ.class, false, 1, 4, new Object[]{ getMessage() }, "QUANTITY DISPENSED");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "UNUSED Number 3");
                                  this.add(CE.class, false, 1, 5, new Object[]{ getMessage() }, "DRUG ID");
                                              this.add(ID.class, false, 5, 5, new Object[]{ getMessage(), new Integer(0) }, "COMPONENT DRUG IDS");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(0) }, "PRESCRIPTION TYPE");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(0) }, "SUBSTITUTION STATUS");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(38) }, "RX ORDER STATUS");
                                  this.add(NM.class, false, 1, 3, new Object[]{ getMessage() }, "NUMBER OF REFILLS");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "UNUSED Number 4");
                                  this.add(NM.class, false, 1, 3, new Object[]{ getMessage() }, "REFILLS REMAINING");
                                              this.add(ID.class, false, 1, 5, new Object[]{ getMessage(), new Integer(0) }, "DEA CLASS");
                                  this.add(NM.class, false, 1, 10, new Object[]{ getMessage() }, "ORDERING MD'S DEA NUMBER");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "UNUSED Number 5");
                                  this.add(TS.class, false, 1, 19, new Object[]{ getMessage() }, "LAST REFILL DATE/TIME");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "RX NUMBER");
                                              this.add(ID.class, false, 1, 5, new Object[]{ getMessage(), new Integer(0) }, "PRN STATUS");
                                  this.add(TX.class, false, 5, 80, new Object[]{ getMessage() }, "PHARMACY INSTRUCTIONS");
                                  this.add(TX.class, false, 5, 80, new Object[]{ getMessage() }, "PATIENT INSTRUCTIONS");
                                  this.add(TX.class, false, 0, 500, new Object[]{ getMessage() }, "INSTRUCTIONS (SIG)");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating RX1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * RX1-1: "UNUSED" - creates it if necessary
     */
    public ST getUNUSED() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RX1-1: "UNUSED" - creates it if necessary
     */
    public ST getRx11_UNUSED() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * RX1-2: "UNUSED Number 2" - creates it if necessary
     */
    public ST getUNUSEDNumber2() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RX1-2: "UNUSED Number 2" - creates it if necessary
     */
    public ST getRx12_UNUSEDNumber2() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * RX1-3: "ROUTE" - creates it if necessary
     */
    public ST getROUTE() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RX1-3: "ROUTE" - creates it if necessary
     */
    public ST getRx13_ROUTE() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * RX1-4: "SITE ADMINISTERED" - creates it if necessary
     */
    public ST getSITEADMINISTERED() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RX1-4: "SITE ADMINISTERED" - creates it if necessary
     */
    public ST getRx14_SITEADMINISTERED() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * RX1-5: "IV SOLUTION RATE" - creates it if necessary
     */
    public CQ getIVSOLUTIONRATE() { 
		CQ retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RX1-5: "IV SOLUTION RATE" - creates it if necessary
     */
    public CQ getRx15_IVSOLUTIONRATE() { 
		CQ retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * RX1-6: "DRUG STRENGTH" - creates it if necessary
     */
    public CQ getDRUGSTRENGTH() { 
		CQ retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RX1-6: "DRUG STRENGTH" - creates it if necessary
     */
    public CQ getRx16_DRUGSTRENGTH() { 
		CQ retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * RX1-7: "FINAL CONCENTRATION" - creates it if necessary
     */
    public NM getFINALCONCENTRATION() { 
		NM retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RX1-7: "FINAL CONCENTRATION" - creates it if necessary
     */
    public NM getRx17_FINALCONCENTRATION() { 
		NM retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * RX1-8: "FINAL VOLUME IN ML." - creates it if necessary
     */
    public NM getFINALVOLUMEINML() { 
		NM retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RX1-8: "FINAL VOLUME IN ML." - creates it if necessary
     */
    public NM getRx18_FINALVOLUMEINML() { 
		NM retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * RX1-9: "DRUG DOSE" - creates it if necessary
     */
    public CM getDRUGDOSE() { 
		CM retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RX1-9: "DRUG DOSE" - creates it if necessary
     */
    public CM getRx19_DRUGDOSE() { 
		CM retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * RX1-10: "DRUG ROLE" - creates it if necessary
     */
    public ID getDRUGROLE() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RX1-10: "DRUG ROLE" - creates it if necessary
     */
    public ID getRx110_DRUGROLE() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * RX1-11: "PRESCRIPTION SEQUENCE #" - creates it if necessary
     */
    public NM getPRESCRIPTIONSEQUENCE() { 
		NM retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RX1-11: "PRESCRIPTION SEQUENCE #" - creates it if necessary
     */
    public NM getRx111_PRESCRIPTIONSEQUENCE() { 
		NM retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * RX1-12: "QUANTITY DISPENSED" - creates it if necessary
     */
    public CQ getQUANTITYDISPENSED() { 
		CQ retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RX1-12: "QUANTITY DISPENSED" - creates it if necessary
     */
    public CQ getRx112_QUANTITYDISPENSED() { 
		CQ retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * RX1-13: "UNUSED Number 3" - creates it if necessary
     */
    public ST getUNUSEDNumber3() { 
		ST retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RX1-13: "UNUSED Number 3" - creates it if necessary
     */
    public ST getRx113_UNUSEDNumber3() { 
		ST retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * RX1-14: "DRUG ID" - creates it if necessary
     */
    public CE getDRUGID() { 
		CE retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RX1-14: "DRUG ID" - creates it if necessary
     */
    public CE getRx114_DRUGID() { 
		CE retVal = this.getTypedField(14, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of COMPONENT DRUG IDS (RX1-15).
     */
    public ID[] getCOMPONENTDRUGIDS() {
    	ID[] retVal = this.getTypedField(15, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of COMPONENT DRUG IDS (RX1-15).
     */
    public ID[] getRx115_COMPONENTDRUGIDS() {
    	ID[] retVal = this.getTypedField(15, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of COMPONENT DRUG IDS (RX1-15).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCOMPONENTDRUGIDSReps() {
    	return this.getReps(15);
    }


    /**
     * Returns a specific repetition of
     * RX1-15: "COMPONENT DRUG IDS" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getCOMPONENTDRUGIDS(int rep) { 
		ID retVal = this.getTypedField(15, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RX1-15: "COMPONENT DRUG IDS" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getRx115_COMPONENTDRUGIDS(int rep) { 
		ID retVal = this.getTypedField(15, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of COMPONENT DRUG IDS (RX1-15).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRx115_COMPONENTDRUGIDSReps() {
    	return this.getReps(15);
    }


    /**
     * Inserts a repetition of
     * RX1-15: "COMPONENT DRUG IDS" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertCOMPONENTDRUGIDS(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(15, rep);
    }


    /**
     * Inserts a repetition of
     * RX1-15: "COMPONENT DRUG IDS" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertRx115_COMPONENTDRUGIDS(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(15, rep);
    }


    /**
     * Removes a repetition of
     * RX1-15: "COMPONENT DRUG IDS" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeCOMPONENTDRUGIDS(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(15, rep);
    }


    /**
     * Removes a repetition of
     * RX1-15: "COMPONENT DRUG IDS" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeRx115_COMPONENTDRUGIDS(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(15, rep);
    }




    /**
     * Returns
     * RX1-16: "PRESCRIPTION TYPE" - creates it if necessary
     */
    public ID getPRESCRIPTIONTYPE() { 
		ID retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RX1-16: "PRESCRIPTION TYPE" - creates it if necessary
     */
    public ID getRx116_PRESCRIPTIONTYPE() { 
		ID retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * RX1-17: "SUBSTITUTION STATUS" - creates it if necessary
     */
    public ID getSUBSTITUTIONSTATUS() { 
		ID retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RX1-17: "SUBSTITUTION STATUS" - creates it if necessary
     */
    public ID getRx117_SUBSTITUTIONSTATUS() { 
		ID retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * RX1-18: "RX ORDER STATUS" - creates it if necessary
     */
    public ID getRXORDERSTATUS() { 
		ID retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RX1-18: "RX ORDER STATUS" - creates it if necessary
     */
    public ID getRx118_RXORDERSTATUS() { 
		ID retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * RX1-19: "NUMBER OF REFILLS" - creates it if necessary
     */
    public NM getNUMBEROFREFILLS() { 
		NM retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RX1-19: "NUMBER OF REFILLS" - creates it if necessary
     */
    public NM getRx119_NUMBEROFREFILLS() { 
		NM retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * RX1-20: "UNUSED Number 4" - creates it if necessary
     */
    public ST getUNUSEDNumber4() { 
		ST retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RX1-20: "UNUSED Number 4" - creates it if necessary
     */
    public ST getRx120_UNUSEDNumber4() { 
		ST retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * RX1-21: "REFILLS REMAINING" - creates it if necessary
     */
    public NM getREFILLSREMAINING() { 
		NM retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RX1-21: "REFILLS REMAINING" - creates it if necessary
     */
    public NM getRx121_REFILLSREMAINING() { 
		NM retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * RX1-22: "DEA CLASS" - creates it if necessary
     */
    public ID getDEACLASS() { 
		ID retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RX1-22: "DEA CLASS" - creates it if necessary
     */
    public ID getRx122_DEACLASS() { 
		ID retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * RX1-23: "ORDERING MD'S DEA NUMBER" - creates it if necessary
     */
    public NM getORDERINGMDSDEANUMBER() { 
		NM retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RX1-23: "ORDERING MD'S DEA NUMBER" - creates it if necessary
     */
    public NM getRx123_ORDERINGMDSDEANUMBER() { 
		NM retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * RX1-24: "UNUSED Number 5" - creates it if necessary
     */
    public ST getUNUSEDNumber5() { 
		ST retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RX1-24: "UNUSED Number 5" - creates it if necessary
     */
    public ST getRx124_UNUSEDNumber5() { 
		ST retVal = this.getTypedField(24, 0);
		return retVal;
    }



    /**
     * Returns
     * RX1-25: "LAST REFILL DATE/TIME" - creates it if necessary
     */
    public TS getLASTREFILLDATETIME() { 
		TS retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RX1-25: "LAST REFILL DATE/TIME" - creates it if necessary
     */
    public TS getRx125_LASTREFILLDATETIME() { 
		TS retVal = this.getTypedField(25, 0);
		return retVal;
    }



    /**
     * Returns
     * RX1-26: "RX NUMBER" - creates it if necessary
     */
    public ST getRXNUMBER() { 
		ST retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RX1-26: "RX NUMBER" - creates it if necessary
     */
    public ST getRx126_RXNUMBER() { 
		ST retVal = this.getTypedField(26, 0);
		return retVal;
    }



    /**
     * Returns
     * RX1-27: "PRN STATUS" - creates it if necessary
     */
    public ID getPRNSTATUS() { 
		ID retVal = this.getTypedField(27, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RX1-27: "PRN STATUS" - creates it if necessary
     */
    public ID getRx127_PRNSTATUS() { 
		ID retVal = this.getTypedField(27, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of PHARMACY INSTRUCTIONS (RX1-28).
     */
    public TX[] getPHARMACYINSTRUCTIONS() {
    	TX[] retVal = this.getTypedField(28, new TX[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of PHARMACY INSTRUCTIONS (RX1-28).
     */
    public TX[] getRx128_PHARMACYINSTRUCTIONS() {
    	TX[] retVal = this.getTypedField(28, new TX[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of PHARMACY INSTRUCTIONS (RX1-28).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPHARMACYINSTRUCTIONSReps() {
    	return this.getReps(28);
    }


    /**
     * Returns a specific repetition of
     * RX1-28: "PHARMACY INSTRUCTIONS" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TX getPHARMACYINSTRUCTIONS(int rep) { 
		TX retVal = this.getTypedField(28, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RX1-28: "PHARMACY INSTRUCTIONS" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TX getRx128_PHARMACYINSTRUCTIONS(int rep) { 
		TX retVal = this.getTypedField(28, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of PHARMACY INSTRUCTIONS (RX1-28).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRx128_PHARMACYINSTRUCTIONSReps() {
    	return this.getReps(28);
    }


    /**
     * Inserts a repetition of
     * RX1-28: "PHARMACY INSTRUCTIONS" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX insertPHARMACYINSTRUCTIONS(int rep) throws HL7Exception { 
        return (TX) super.insertRepetition(28, rep);
    }


    /**
     * Inserts a repetition of
     * RX1-28: "PHARMACY INSTRUCTIONS" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX insertRx128_PHARMACYINSTRUCTIONS(int rep) throws HL7Exception { 
        return (TX) super.insertRepetition(28, rep);
    }


    /**
     * Removes a repetition of
     * RX1-28: "PHARMACY INSTRUCTIONS" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX removePHARMACYINSTRUCTIONS(int rep) throws HL7Exception { 
        return (TX) super.removeRepetition(28, rep);
    }


    /**
     * Removes a repetition of
     * RX1-28: "PHARMACY INSTRUCTIONS" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX removeRx128_PHARMACYINSTRUCTIONS(int rep) throws HL7Exception { 
        return (TX) super.removeRepetition(28, rep);
    }



    /**
     * Returns all repetitions of PATIENT INSTRUCTIONS (RX1-29).
     */
    public TX[] getPATIENTINSTRUCTIONS() {
    	TX[] retVal = this.getTypedField(29, new TX[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of PATIENT INSTRUCTIONS (RX1-29).
     */
    public TX[] getRx129_PATIENTINSTRUCTIONS() {
    	TX[] retVal = this.getTypedField(29, new TX[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of PATIENT INSTRUCTIONS (RX1-29).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPATIENTINSTRUCTIONSReps() {
    	return this.getReps(29);
    }


    /**
     * Returns a specific repetition of
     * RX1-29: "PATIENT INSTRUCTIONS" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TX getPATIENTINSTRUCTIONS(int rep) { 
		TX retVal = this.getTypedField(29, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RX1-29: "PATIENT INSTRUCTIONS" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TX getRx129_PATIENTINSTRUCTIONS(int rep) { 
		TX retVal = this.getTypedField(29, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of PATIENT INSTRUCTIONS (RX1-29).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRx129_PATIENTINSTRUCTIONSReps() {
    	return this.getReps(29);
    }


    /**
     * Inserts a repetition of
     * RX1-29: "PATIENT INSTRUCTIONS" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX insertPATIENTINSTRUCTIONS(int rep) throws HL7Exception { 
        return (TX) super.insertRepetition(29, rep);
    }


    /**
     * Inserts a repetition of
     * RX1-29: "PATIENT INSTRUCTIONS" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX insertRx129_PATIENTINSTRUCTIONS(int rep) throws HL7Exception { 
        return (TX) super.insertRepetition(29, rep);
    }


    /**
     * Removes a repetition of
     * RX1-29: "PATIENT INSTRUCTIONS" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX removePATIENTINSTRUCTIONS(int rep) throws HL7Exception { 
        return (TX) super.removeRepetition(29, rep);
    }


    /**
     * Removes a repetition of
     * RX1-29: "PATIENT INSTRUCTIONS" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX removeRx129_PATIENTINSTRUCTIONS(int rep) throws HL7Exception { 
        return (TX) super.removeRepetition(29, rep);
    }



    /**
     * Returns all repetitions of INSTRUCTIONS (SIG) (RX1-30).
     */
    public TX[] getINSTRUCTIONS() {
    	TX[] retVal = this.getTypedField(30, new TX[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of INSTRUCTIONS (SIG) (RX1-30).
     */
    public TX[] getRx130_INSTRUCTIONS() {
    	TX[] retVal = this.getTypedField(30, new TX[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of INSTRUCTIONS (SIG) (RX1-30).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getINSTRUCTIONSReps() {
    	return this.getReps(30);
    }


    /**
     * Returns a specific repetition of
     * RX1-30: "INSTRUCTIONS (SIG)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TX getINSTRUCTIONS(int rep) { 
		TX retVal = this.getTypedField(30, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RX1-30: "INSTRUCTIONS (SIG)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TX getRx130_INSTRUCTIONS(int rep) { 
		TX retVal = this.getTypedField(30, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of INSTRUCTIONS (SIG) (RX1-30).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRx130_INSTRUCTIONSReps() {
    	return this.getReps(30);
    }


    /**
     * Inserts a repetition of
     * RX1-30: "INSTRUCTIONS (SIG)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX insertINSTRUCTIONS(int rep) throws HL7Exception { 
        return (TX) super.insertRepetition(30, rep);
    }


    /**
     * Inserts a repetition of
     * RX1-30: "INSTRUCTIONS (SIG)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX insertRx130_INSTRUCTIONS(int rep) throws HL7Exception { 
        return (TX) super.insertRepetition(30, rep);
    }


    /**
     * Removes a repetition of
     * RX1-30: "INSTRUCTIONS (SIG)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX removeINSTRUCTIONS(int rep) throws HL7Exception { 
        return (TX) super.removeRepetition(30, rep);
    }


    /**
     * Removes a repetition of
     * RX1-30: "INSTRUCTIONS (SIG)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX removeRx130_INSTRUCTIONS(int rep) throws HL7Exception { 
        return (TX) super.removeRepetition(30, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ST(getMessage());
          case 1: return new ST(getMessage());
          case 2: return new ST(getMessage());
          case 3: return new ST(getMessage());
          case 4: return new CQ(getMessage());
          case 5: return new CQ(getMessage());
          case 6: return new NM(getMessage());
          case 7: return new NM(getMessage());
          case 8: return new CM(getMessage());
          case 9: return new ID(getMessage(), new Integer( 0 ));
          case 10: return new NM(getMessage());
          case 11: return new CQ(getMessage());
          case 12: return new ST(getMessage());
          case 13: return new CE(getMessage());
          case 14: return new ID(getMessage(), new Integer( 0 ));
          case 15: return new ID(getMessage(), new Integer( 0 ));
          case 16: return new ID(getMessage(), new Integer( 0 ));
          case 17: return new ID(getMessage(), new Integer( 38 ));
          case 18: return new NM(getMessage());
          case 19: return new ST(getMessage());
          case 20: return new NM(getMessage());
          case 21: return new ID(getMessage(), new Integer( 0 ));
          case 22: return new NM(getMessage());
          case 23: return new ST(getMessage());
          case 24: return new TS(getMessage());
          case 25: return new ST(getMessage());
          case 26: return new ID(getMessage(), new Integer( 0 ));
          case 27: return new TX(getMessage());
          case 28: return new TX(getMessage());
          case 29: return new TX(getMessage());
          default: return null;
       }
   }


}

