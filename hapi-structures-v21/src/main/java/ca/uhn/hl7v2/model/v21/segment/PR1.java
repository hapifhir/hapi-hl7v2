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
 *<p>Represents an HL7 PR1 message segment (PROCEDURES). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PR1-1: SET ID - PROCEDURE (SI) <b> repeating</b>
     * <li>PR1-2: PROCEDURE CODING METHOD. (ID) <b> </b>
     * <li>PR1-3: PROCEDURE CODE (ID) <b> </b>
     * <li>PR1-4: PROCEDURE DESCRIPTION (ST) <b>optional </b>
     * <li>PR1-5: PROCEDURE DATE/TIME (TS) <b> </b>
     * <li>PR1-6: PROCEDURE TYPE (ID) <b> </b>
     * <li>PR1-7: PROCEDURE MINUTES (NM) <b>optional </b>
     * <li>PR1-8: ANESTHESIOLOGIST (CN) <b>optional </b>
     * <li>PR1-9: ANESTHESIA CODE (ID) <b>optional </b>
     * <li>PR1-10: ANESTHESIA MINUTES (NM) <b>optional </b>
     * <li>PR1-11: SURGEON (CN) <b>optional </b>
     * <li>PR1-12: RESIDENT CODE (CN) <b>optional </b>
     * <li>PR1-13: CONSENT CODE (ID) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class PR1 extends AbstractSegment {

    /** 
     * Creates a new PR1 segment
     */
    public PR1(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 0, 4, new Object[]{ getMessage() }, "SET ID - PROCEDURE");
                                              this.add(ID.class, true, 1, 2, new Object[]{ getMessage(), new Integer(89) }, "PROCEDURE CODING METHOD.");
                                              this.add(ID.class, true, 1, 10, new Object[]{ getMessage(), new Integer(88) }, "PROCEDURE CODE");
                                  this.add(ST.class, false, 1, 40, new Object[]{ getMessage() }, "PROCEDURE DESCRIPTION");
                                  this.add(TS.class, true, 1, 19, new Object[]{ getMessage() }, "PROCEDURE DATE/TIME");
                                              this.add(ID.class, true, 1, 2, new Object[]{ getMessage(), new Integer(90) }, "PROCEDURE TYPE");
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "PROCEDURE MINUTES");
                                  this.add(CN.class, false, 1, 60, new Object[]{ getMessage() }, "ANESTHESIOLOGIST");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(19) }, "ANESTHESIA CODE");
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "ANESTHESIA MINUTES");
                                  this.add(CN.class, false, 1, 60, new Object[]{ getMessage() }, "SURGEON");
                                  this.add(CN.class, false, 1, 60, new Object[]{ getMessage() }, "RESIDENT CODE");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(59) }, "CONSENT CODE");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PR1 - this is probably a bug in the source code generator.", e);
       }
    }


    /**
     * Returns all repetitions of SET ID - PROCEDURE (PR1-1).
     */
    public SI[] getSETIDPROCEDURE() {
    	SI[] retVal = this.getTypedField(1, new SI[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of SET ID - PROCEDURE (PR1-1).
     */
    public SI[] getPr11_SETIDPROCEDURE() {
    	SI[] retVal = this.getTypedField(1, new SI[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of SET ID - PROCEDURE (PR1-1).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSETIDPROCEDUREReps() {
    	return this.getReps(1);
    }


    /**
     * Returns a specific repetition of
     * PR1-1: "SET ID - PROCEDURE" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public SI getSETIDPROCEDURE(int rep) { 
		SI retVal = this.getTypedField(1, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PR1-1: "SET ID - PROCEDURE" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public SI getPr11_SETIDPROCEDURE(int rep) { 
		SI retVal = this.getTypedField(1, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of SET ID - PROCEDURE (PR1-1).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPr11_SETIDPROCEDUREReps() {
    	return this.getReps(1);
    }


    /**
     * Inserts a repetition of
     * PR1-1: "SET ID - PROCEDURE" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public SI insertSETIDPROCEDURE(int rep) throws HL7Exception { 
        return (SI) super.insertRepetition(1, rep);
    }


    /**
     * Inserts a repetition of
     * PR1-1: "SET ID - PROCEDURE" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public SI insertPr11_SETIDPROCEDURE(int rep) throws HL7Exception { 
        return (SI) super.insertRepetition(1, rep);
    }


    /**
     * Removes a repetition of
     * PR1-1: "SET ID - PROCEDURE" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public SI removeSETIDPROCEDURE(int rep) throws HL7Exception { 
        return (SI) super.removeRepetition(1, rep);
    }


    /**
     * Removes a repetition of
     * PR1-1: "SET ID - PROCEDURE" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public SI removePr11_SETIDPROCEDURE(int rep) throws HL7Exception { 
        return (SI) super.removeRepetition(1, rep);
    }




    /**
     * Returns
     * PR1-2: "PROCEDURE CODING METHOD." - creates it if necessary
     */
    public ID getPROCEDURECODINGMETHOD() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-2: "PROCEDURE CODING METHOD." - creates it if necessary
     */
    public ID getPr12_PROCEDURECODINGMETHOD() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * PR1-3: "PROCEDURE CODE" - creates it if necessary
     */
    public ID getPROCEDURECODE() { 
		ID retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-3: "PROCEDURE CODE" - creates it if necessary
     */
    public ID getPr13_PROCEDURECODE() { 
		ID retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * PR1-4: "PROCEDURE DESCRIPTION" - creates it if necessary
     */
    public ST getPROCEDUREDESCRIPTION() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-4: "PROCEDURE DESCRIPTION" - creates it if necessary
     */
    public ST getPr14_PROCEDUREDESCRIPTION() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * PR1-5: "PROCEDURE DATE/TIME" - creates it if necessary
     */
    public TS getPROCEDUREDATETIME() { 
		TS retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-5: "PROCEDURE DATE/TIME" - creates it if necessary
     */
    public TS getPr15_PROCEDUREDATETIME() { 
		TS retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * PR1-6: "PROCEDURE TYPE" - creates it if necessary
     */
    public ID getPROCEDURETYPE() { 
		ID retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-6: "PROCEDURE TYPE" - creates it if necessary
     */
    public ID getPr16_PROCEDURETYPE() { 
		ID retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * PR1-7: "PROCEDURE MINUTES" - creates it if necessary
     */
    public NM getPROCEDUREMINUTES() { 
		NM retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-7: "PROCEDURE MINUTES" - creates it if necessary
     */
    public NM getPr17_PROCEDUREMINUTES() { 
		NM retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * PR1-8: "ANESTHESIOLOGIST" - creates it if necessary
     */
    public CN getANESTHESIOLOGIST() { 
		CN retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-8: "ANESTHESIOLOGIST" - creates it if necessary
     */
    public CN getPr18_ANESTHESIOLOGIST() { 
		CN retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * PR1-9: "ANESTHESIA CODE" - creates it if necessary
     */
    public ID getANESTHESIACODE() { 
		ID retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-9: "ANESTHESIA CODE" - creates it if necessary
     */
    public ID getPr19_ANESTHESIACODE() { 
		ID retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * PR1-10: "ANESTHESIA MINUTES" - creates it if necessary
     */
    public NM getANESTHESIAMINUTES() { 
		NM retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-10: "ANESTHESIA MINUTES" - creates it if necessary
     */
    public NM getPr110_ANESTHESIAMINUTES() { 
		NM retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * PR1-11: "SURGEON" - creates it if necessary
     */
    public CN getSURGEON() { 
		CN retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-11: "SURGEON" - creates it if necessary
     */
    public CN getPr111_SURGEON() { 
		CN retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * PR1-12: "RESIDENT CODE" - creates it if necessary
     */
    public CN getRESIDENTCODE() { 
		CN retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-12: "RESIDENT CODE" - creates it if necessary
     */
    public CN getPr112_RESIDENTCODE() { 
		CN retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * PR1-13: "CONSENT CODE" - creates it if necessary
     */
    public ID getCONSENTCODE() { 
		ID retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-13: "CONSENT CODE" - creates it if necessary
     */
    public ID getPr113_CONSENTCODE() { 
		ID retVal = this.getTypedField(13, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new ID(getMessage(), new Integer( 89 ));
          case 2: return new ID(getMessage(), new Integer( 88 ));
          case 3: return new ST(getMessage());
          case 4: return new TS(getMessage());
          case 5: return new ID(getMessage(), new Integer( 90 ));
          case 6: return new NM(getMessage());
          case 7: return new CN(getMessage());
          case 8: return new ID(getMessage(), new Integer( 19 ));
          case 9: return new NM(getMessage());
          case 10: return new CN(getMessage());
          case 11: return new CN(getMessage());
          case 12: return new ID(getMessage(), new Integer( 59 ));
          default: return null;
       }
   }


}

