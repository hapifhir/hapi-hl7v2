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


package ca.uhn.hl7v2.model.v28.segment;

// import ca.uhn.hl7v2.model.v28.group.*;
import ca.uhn.hl7v2.model.v28.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 PDA message segment (Patient Death and Autopsy). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PDA-1: Death Cause Code (CWE) <b>optional repeating</b>
     * <li>PDA-2: Death Location (PL) <b>optional </b>
     * <li>PDA-3: Death Certified Indicator (ID) <b>optional </b>
     * <li>PDA-4: Death Certificate Signed Date/Time (DTM) <b>optional </b>
     * <li>PDA-5: Death Certified By (XCN) <b>optional </b>
     * <li>PDA-6: Autopsy Indicator (ID) <b>optional </b>
     * <li>PDA-7: Autopsy Start and End Date/Time (DR) <b>optional </b>
     * <li>PDA-8: Autopsy Performed By (XCN) <b>optional </b>
     * <li>PDA-9: Coroner Indicator (ID) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class PDA extends AbstractSegment {

    /** 
     * Creates a new PDA segment
     */
    public PDA(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Death Cause Code");
                                  this.add(PL.class, false, 1, 0, new Object[]{ getMessage() }, "Death Location");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Death Certified Indicator");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Death Certificate Signed Date/Time");
                                  this.add(XCN.class, false, 1, 0, new Object[]{ getMessage() }, "Death Certified By");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Autopsy Indicator");
                                  this.add(DR.class, false, 1, 0, new Object[]{ getMessage() }, "Autopsy Start and End Date/Time");
                                  this.add(XCN.class, false, 1, 0, new Object[]{ getMessage() }, "Autopsy Performed By");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Coroner Indicator");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PDA - this is probably a bug in the source code generator.", e);
       }
    }


    /**
     * Returns all repetitions of Death Cause Code (PDA-1).
     */
    public CWE[] getDeathCauseCode() {
    	CWE[] retVal = this.getTypedField(1, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Death Cause Code (PDA-1).
     */
    public CWE[] getPda1_DeathCauseCode() {
    	CWE[] retVal = this.getTypedField(1, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Death Cause Code (PDA-1).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getDeathCauseCodeReps() {
    	return this.getReps(1);
    }


    /**
     * Returns a specific repetition of
     * PDA-1: "Death Cause Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getDeathCauseCode(int rep) { 
		CWE retVal = this.getTypedField(1, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PDA-1: "Death Cause Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getPda1_DeathCauseCode(int rep) { 
		CWE retVal = this.getTypedField(1, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Death Cause Code (PDA-1).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPda1_DeathCauseCodeReps() {
    	return this.getReps(1);
    }


    /**
     * Inserts a repetition of
     * PDA-1: "Death Cause Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertDeathCauseCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(1, rep);
    }


    /**
     * Inserts a repetition of
     * PDA-1: "Death Cause Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertPda1_DeathCauseCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(1, rep);
    }


    /**
     * Removes a repetition of
     * PDA-1: "Death Cause Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeDeathCauseCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(1, rep);
    }


    /**
     * Removes a repetition of
     * PDA-1: "Death Cause Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removePda1_DeathCauseCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(1, rep);
    }




    /**
     * Returns
     * PDA-2: "Death Location" - creates it if necessary
     */
    public PL getDeathLocation() { 
		PL retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PDA-2: "Death Location" - creates it if necessary
     */
    public PL getPda2_DeathLocation() { 
		PL retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * PDA-3: "Death Certified Indicator" - creates it if necessary
     */
    public ID getDeathCertifiedIndicator() { 
		ID retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PDA-3: "Death Certified Indicator" - creates it if necessary
     */
    public ID getPda3_DeathCertifiedIndicator() { 
		ID retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * PDA-4: "Death Certificate Signed Date/Time" - creates it if necessary
     */
    public DTM getDeathCertificateSignedDateTime() { 
		DTM retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PDA-4: "Death Certificate Signed Date/Time" - creates it if necessary
     */
    public DTM getPda4_DeathCertificateSignedDateTime() { 
		DTM retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * PDA-5: "Death Certified By" - creates it if necessary
     */
    public XCN getDeathCertifiedBy() { 
		XCN retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PDA-5: "Death Certified By" - creates it if necessary
     */
    public XCN getPda5_DeathCertifiedBy() { 
		XCN retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * PDA-6: "Autopsy Indicator" - creates it if necessary
     */
    public ID getAutopsyIndicator() { 
		ID retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PDA-6: "Autopsy Indicator" - creates it if necessary
     */
    public ID getPda6_AutopsyIndicator() { 
		ID retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * PDA-7: "Autopsy Start and End Date/Time" - creates it if necessary
     */
    public DR getAutopsyStartAndEndDateTime() { 
		DR retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PDA-7: "Autopsy Start and End Date/Time" - creates it if necessary
     */
    public DR getPda7_AutopsyStartAndEndDateTime() { 
		DR retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * PDA-8: "Autopsy Performed By" - creates it if necessary
     */
    public XCN getAutopsyPerformedBy() { 
		XCN retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PDA-8: "Autopsy Performed By" - creates it if necessary
     */
    public XCN getPda8_AutopsyPerformedBy() { 
		XCN retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * PDA-9: "Coroner Indicator" - creates it if necessary
     */
    public ID getCoronerIndicator() { 
		ID retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PDA-9: "Coroner Indicator" - creates it if necessary
     */
    public ID getPda9_CoronerIndicator() { 
		ID retVal = this.getTypedField(9, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CWE(getMessage());
          case 1: return new PL(getMessage());
          case 2: return new ID(getMessage(), new Integer( 136 ));
          case 3: return new DTM(getMessage());
          case 4: return new XCN(getMessage());
          case 5: return new ID(getMessage(), new Integer( 136 ));
          case 6: return new DR(getMessage());
          case 7: return new XCN(getMessage());
          case 8: return new ID(getMessage(), new Integer( 136 ));
          default: return null;
       }
   }


}

