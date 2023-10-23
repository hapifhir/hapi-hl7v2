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
 *<p>Represents an HL7 OBX message segment (RESULT). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>OBX-1: SET ID - OBSERVATION SIMPLE (SI) <b>optional </b>
     * <li>OBX-2: VALUE TYPE (ID) <b>optional </b>
     * <li>OBX-3: OBSERVATION IDENTIFIER (CE) <b> </b>
     * <li>OBX-4: OBSERVATION SUB-ID (NM) <b>optional </b>
     * <li>OBX-5: OBSERVATION RESULTS (Varies) <b> </b>
     * <li>OBX-6: UNITS (ID) <b>optional </b>
     * <li>OBX-7: REFERENCES RANGE (ST) <b>optional </b>
     * <li>OBX-8: ABNORMAL FLAGS (ST) <b>optional repeating</b>
     * <li>OBX-9: PROBABILITY (NM) <b>optional </b>
     * <li>OBX-10: NATURE OF ABNORMAL TEST (ID) <b>optional </b>
     * <li>OBX-11: OBSERV RESULT STATUS (ID) <b>optional </b>
     * <li>OBX-12: DATE LAST OBS NORMAL VALUES (TS) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class OBX extends AbstractSegment {

    /** 
     * Creates a new OBX segment
     */
    public OBX(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, false, 1, 4, new Object[]{ getMessage() }, "SET ID - OBSERVATION SIMPLE");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(125) }, "VALUE TYPE");
                                  this.add(CE.class, true, 1, 80, new Object[]{ getMessage() }, "OBSERVATION IDENTIFIER");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "OBSERVATION SUB-ID");
                                  this.add(Varies.class, true, 1, 65, new Object[]{ getMessage() }, "OBSERVATION RESULTS");
                                              this.add(ID.class, false, 1, 20, new Object[]{ getMessage(), new Integer(0) }, "UNITS");
                                  this.add(ST.class, false, 1, 60, new Object[]{ getMessage() }, "REFERENCES RANGE");
                                  this.add(ST.class, false, 5, 10, new Object[]{ getMessage() }, "ABNORMAL FLAGS");
                                  this.add(NM.class, false, 1, 5, new Object[]{ getMessage() }, "PROBABILITY");
                                              this.add(ID.class, false, 1, 5, new Object[]{ getMessage(), new Integer(80) }, "NATURE OF ABNORMAL TEST");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(85) }, "OBSERV RESULT STATUS");
                                  this.add(TS.class, false, 1, 19, new Object[]{ getMessage() }, "DATE LAST OBS NORMAL VALUES");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating OBX - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * OBX-1: "SET ID - OBSERVATION SIMPLE" - creates it if necessary
     */
    public SI getSETIDOBSERVATIONSIMPLE() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBX-1: "SET ID - OBSERVATION SIMPLE" - creates it if necessary
     */
    public SI getObx1_SETIDOBSERVATIONSIMPLE() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * OBX-2: "VALUE TYPE" - creates it if necessary
     */
    public ID getVALUETYPE() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBX-2: "VALUE TYPE" - creates it if necessary
     */
    public ID getObx2_VALUETYPE() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * OBX-3: "OBSERVATION IDENTIFIER" - creates it if necessary
     */
    public CE getOBSERVATIONIDENTIFIER() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBX-3: "OBSERVATION IDENTIFIER" - creates it if necessary
     */
    public CE getObx3_OBSERVATIONIDENTIFIER() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * OBX-4: "OBSERVATION SUB-ID" - creates it if necessary
     */
    public NM getOBSERVATIONSUBID() { 
		NM retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBX-4: "OBSERVATION SUB-ID" - creates it if necessary
     */
    public NM getObx4_OBSERVATIONSUBID() { 
		NM retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * OBX-5: "OBSERVATION RESULTS" - creates it if necessary
     */
    public Varies getOBSERVATIONRESULTS() { 
		Varies retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBX-5: "OBSERVATION RESULTS" - creates it if necessary
     */
    public Varies getObx5_OBSERVATIONRESULTS() { 
		Varies retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * OBX-6: "UNITS" - creates it if necessary
     */
    public ID getUNITS() { 
		ID retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBX-6: "UNITS" - creates it if necessary
     */
    public ID getObx6_UNITS() { 
		ID retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * OBX-7: "REFERENCES RANGE" - creates it if necessary
     */
    public ST getREFERENCESRANGE() { 
		ST retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBX-7: "REFERENCES RANGE" - creates it if necessary
     */
    public ST getObx7_REFERENCESRANGE() { 
		ST retVal = this.getTypedField(7, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of ABNORMAL FLAGS (OBX-8).
     */
    public ST[] getABNORMALFLAGS() {
    	ST[] retVal = this.getTypedField(8, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of ABNORMAL FLAGS (OBX-8).
     */
    public ST[] getObx8_ABNORMALFLAGS() {
    	ST[] retVal = this.getTypedField(8, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of ABNORMAL FLAGS (OBX-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getABNORMALFLAGSReps() {
    	return this.getReps(8);
    }


    /**
     * Returns a specific repetition of
     * OBX-8: "ABNORMAL FLAGS" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getABNORMALFLAGS(int rep) { 
		ST retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBX-8: "ABNORMAL FLAGS" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getObx8_ABNORMALFLAGS(int rep) { 
		ST retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of ABNORMAL FLAGS (OBX-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObx8_ABNORMALFLAGSReps() {
    	return this.getReps(8);
    }


    /**
     * Inserts a repetition of
     * OBX-8: "ABNORMAL FLAGS" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertABNORMALFLAGS(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(8, rep);
    }


    /**
     * Inserts a repetition of
     * OBX-8: "ABNORMAL FLAGS" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertObx8_ABNORMALFLAGS(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * OBX-8: "ABNORMAL FLAGS" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeABNORMALFLAGS(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * OBX-8: "ABNORMAL FLAGS" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeObx8_ABNORMALFLAGS(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(8, rep);
    }




    /**
     * Returns
     * OBX-9: "PROBABILITY" - creates it if necessary
     */
    public NM getPROBABILITY() { 
		NM retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBX-9: "PROBABILITY" - creates it if necessary
     */
    public NM getObx9_PROBABILITY() { 
		NM retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * OBX-10: "NATURE OF ABNORMAL TEST" - creates it if necessary
     */
    public ID getNATUREOFABNORMALTEST() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBX-10: "NATURE OF ABNORMAL TEST" - creates it if necessary
     */
    public ID getObx10_NATUREOFABNORMALTEST() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * OBX-11: "OBSERV RESULT STATUS" - creates it if necessary
     */
    public ID getOBSERVRESULTSTATUS() { 
		ID retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBX-11: "OBSERV RESULT STATUS" - creates it if necessary
     */
    public ID getObx11_OBSERVRESULTSTATUS() { 
		ID retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * OBX-12: "DATE LAST OBS NORMAL VALUES" - creates it if necessary
     */
    public TS getDATELASTOBSNORMALVALUES() { 
		TS retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBX-12: "DATE LAST OBS NORMAL VALUES" - creates it if necessary
     */
    public TS getObx12_DATELASTOBSNORMALVALUES() { 
		TS retVal = this.getTypedField(12, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new ID(getMessage(), new Integer( 125 ));
          case 2: return new CE(getMessage());
          case 3: return new NM(getMessage());
          case 4: return new Varies(getMessage());
          case 5: return new ID(getMessage(), new Integer( 0 ));
          case 6: return new ST(getMessage());
          case 7: return new ST(getMessage());
          case 8: return new NM(getMessage());
          case 9: return new ID(getMessage(), new Integer( 80 ));
          case 10: return new ID(getMessage(), new Integer( 85 ));
          case 11: return new TS(getMessage());
          default: return null;
       }
   }


}

