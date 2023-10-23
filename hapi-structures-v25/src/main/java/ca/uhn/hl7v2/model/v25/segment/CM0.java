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
 *<p>Represents an HL7 CM0 message segment (Clinical Study Master). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>CM0-1: Set ID - CM0 (SI) <b>optional </b>
     * <li>CM0-2: Sponsor Study ID (EI) <b> </b>
     * <li>CM0-3: Alternate Study ID (EI) <b>optional repeating</b>
     * <li>CM0-4: Title of Study (ST) <b> </b>
     * <li>CM0-5: Chairman of Study (XCN) <b>optional repeating</b>
     * <li>CM0-6: Last IRB Approval Date (DT) <b>optional </b>
     * <li>CM0-7: Total Accrual to Date (NM) <b>optional </b>
     * <li>CM0-8: Last Accrual Date (DT) <b>optional </b>
     * <li>CM0-9: Contact for Study (XCN) <b>optional repeating</b>
     * <li>CM0-10: Contact's Telephone Number (XTN) <b>optional </b>
     * <li>CM0-11: Contact's Address (XAD) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class CM0 extends AbstractSegment {

    /** 
     * Creates a new CM0 segment
     */
    public CM0(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, false, 1, 4, new Object[]{ getMessage() }, "Set ID - CM0");
                                  this.add(EI.class, true, 1, 60, new Object[]{ getMessage() }, "Sponsor Study ID");
                                  this.add(EI.class, false, 0, 60, new Object[]{ getMessage() }, "Alternate Study ID");
                                  this.add(ST.class, true, 1, 300, new Object[]{ getMessage() }, "Title of Study");
                                  this.add(XCN.class, false, 0, 250, new Object[]{ getMessage() }, "Chairman of Study");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Last IRB Approval Date");
                                  this.add(NM.class, false, 1, 8, new Object[]{ getMessage() }, "Total Accrual to Date");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Last Accrual Date");
                                  this.add(XCN.class, false, 0, 250, new Object[]{ getMessage() }, "Contact for Study");
                                  this.add(XTN.class, false, 1, 250, new Object[]{ getMessage() }, "Contact's Telephone Number");
                                  this.add(XAD.class, false, 0, 250, new Object[]{ getMessage() }, "Contact's Address");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating CM0 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * CM0-1: "Set ID - CM0" - creates it if necessary
     */
    public SI getSetIDCM0() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CM0-1: "Set ID - CM0" - creates it if necessary
     */
    public SI getCm01_SetIDCM0() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * CM0-2: "Sponsor Study ID" - creates it if necessary
     */
    public EI getSponsorStudyID() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CM0-2: "Sponsor Study ID" - creates it if necessary
     */
    public EI getCm02_SponsorStudyID() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Alternate Study ID (CM0-3).
     */
    public EI[] getAlternateStudyID() {
    	EI[] retVal = this.getTypedField(3, new EI[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Alternate Study ID (CM0-3).
     */
    public EI[] getCm03_AlternateStudyID() {
    	EI[] retVal = this.getTypedField(3, new EI[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Alternate Study ID (CM0-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAlternateStudyIDReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * CM0-3: "Alternate Study ID" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getAlternateStudyID(int rep) { 
		EI retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * CM0-3: "Alternate Study ID" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getCm03_AlternateStudyID(int rep) { 
		EI retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Alternate Study ID (CM0-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCm03_AlternateStudyIDReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * CM0-3: "Alternate Study ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertAlternateStudyID(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * CM0-3: "Alternate Study ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertCm03_AlternateStudyID(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * CM0-3: "Alternate Study ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removeAlternateStudyID(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * CM0-3: "Alternate Study ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removeCm03_AlternateStudyID(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(3, rep);
    }




    /**
     * Returns
     * CM0-4: "Title of Study" - creates it if necessary
     */
    public ST getTitleOfStudy() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CM0-4: "Title of Study" - creates it if necessary
     */
    public ST getCm04_TitleOfStudy() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Chairman of Study (CM0-5).
     */
    public XCN[] getChairmanOfStudy() {
    	XCN[] retVal = this.getTypedField(5, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Chairman of Study (CM0-5).
     */
    public XCN[] getCm05_ChairmanOfStudy() {
    	XCN[] retVal = this.getTypedField(5, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Chairman of Study (CM0-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getChairmanOfStudyReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * CM0-5: "Chairman of Study" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getChairmanOfStudy(int rep) { 
		XCN retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * CM0-5: "Chairman of Study" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getCm05_ChairmanOfStudy(int rep) { 
		XCN retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Chairman of Study (CM0-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCm05_ChairmanOfStudyReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * CM0-5: "Chairman of Study" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertChairmanOfStudy(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * CM0-5: "Chairman of Study" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertCm05_ChairmanOfStudy(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * CM0-5: "Chairman of Study" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeChairmanOfStudy(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * CM0-5: "Chairman of Study" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeCm05_ChairmanOfStudy(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(5, rep);
    }




    /**
     * Returns
     * CM0-6: "Last IRB Approval Date" - creates it if necessary
     */
    public DT getLastIRBApprovalDate() { 
		DT retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CM0-6: "Last IRB Approval Date" - creates it if necessary
     */
    public DT getCm06_LastIRBApprovalDate() { 
		DT retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * CM0-7: "Total Accrual to Date" - creates it if necessary
     */
    public NM getTotalAccrualToDate() { 
		NM retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CM0-7: "Total Accrual to Date" - creates it if necessary
     */
    public NM getCm07_TotalAccrualToDate() { 
		NM retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * CM0-8: "Last Accrual Date" - creates it if necessary
     */
    public DT getLastAccrualDate() { 
		DT retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CM0-8: "Last Accrual Date" - creates it if necessary
     */
    public DT getCm08_LastAccrualDate() { 
		DT retVal = this.getTypedField(8, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Contact for Study (CM0-9).
     */
    public XCN[] getContactForStudy() {
    	XCN[] retVal = this.getTypedField(9, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Contact for Study (CM0-9).
     */
    public XCN[] getCm09_ContactForStudy() {
    	XCN[] retVal = this.getTypedField(9, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Contact for Study (CM0-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getContactForStudyReps() {
    	return this.getReps(9);
    }


    /**
     * Returns a specific repetition of
     * CM0-9: "Contact for Study" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getContactForStudy(int rep) { 
		XCN retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * CM0-9: "Contact for Study" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getCm09_ContactForStudy(int rep) { 
		XCN retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Contact for Study (CM0-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCm09_ContactForStudyReps() {
    	return this.getReps(9);
    }


    /**
     * Inserts a repetition of
     * CM0-9: "Contact for Study" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertContactForStudy(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(9, rep);
    }


    /**
     * Inserts a repetition of
     * CM0-9: "Contact for Study" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertCm09_ContactForStudy(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * CM0-9: "Contact for Study" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeContactForStudy(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * CM0-9: "Contact for Study" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeCm09_ContactForStudy(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(9, rep);
    }




    /**
     * Returns
     * CM0-10: "Contact's Telephone Number" - creates it if necessary
     */
    public XTN getContactSTelephoneNumber() { 
		XTN retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CM0-10: "Contact's Telephone Number" - creates it if necessary
     */
    public XTN getCm010_ContactSTelephoneNumber() { 
		XTN retVal = this.getTypedField(10, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Contact's Address (CM0-11).
     */
    public XAD[] getContactSAddress() {
    	XAD[] retVal = this.getTypedField(11, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Contact's Address (CM0-11).
     */
    public XAD[] getCm011_ContactSAddress() {
    	XAD[] retVal = this.getTypedField(11, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Contact's Address (CM0-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getContactSAddressReps() {
    	return this.getReps(11);
    }


    /**
     * Returns a specific repetition of
     * CM0-11: "Contact's Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getContactSAddress(int rep) { 
		XAD retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * CM0-11: "Contact's Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getCm011_ContactSAddress(int rep) { 
		XAD retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Contact's Address (CM0-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCm011_ContactSAddressReps() {
    	return this.getReps(11);
    }


    /**
     * Inserts a repetition of
     * CM0-11: "Contact's Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertContactSAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(11, rep);
    }


    /**
     * Inserts a repetition of
     * CM0-11: "Contact's Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertCm011_ContactSAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * CM0-11: "Contact's Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeContactSAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * CM0-11: "Contact's Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeCm011_ContactSAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(11, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new EI(getMessage());
          case 2: return new EI(getMessage());
          case 3: return new ST(getMessage());
          case 4: return new XCN(getMessage());
          case 5: return new DT(getMessage());
          case 6: return new NM(getMessage());
          case 7: return new DT(getMessage());
          case 8: return new XCN(getMessage());
          case 9: return new XTN(getMessage());
          case 10: return new XAD(getMessage());
          default: return null;
       }
   }


}

