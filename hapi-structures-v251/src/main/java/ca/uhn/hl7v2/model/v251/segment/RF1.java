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


package ca.uhn.hl7v2.model.v251.segment;

// import ca.uhn.hl7v2.model.v251.group.*;
import ca.uhn.hl7v2.model.v251.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 RF1 message segment (Referral Information). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>RF1-1: Referral Status (CE) <b>optional </b>
     * <li>RF1-2: Referral Priority (CE) <b>optional </b>
     * <li>RF1-3: Referral Type (CE) <b>optional </b>
     * <li>RF1-4: Referral Disposition (CE) <b>optional repeating</b>
     * <li>RF1-5: Referral Category (CE) <b>optional </b>
     * <li>RF1-6: Originating Referral Identifier (EI) <b> </b>
     * <li>RF1-7: Effective Date (TS) <b>optional </b>
     * <li>RF1-8: Expiration Date (TS) <b>optional </b>
     * <li>RF1-9: Process Date (TS) <b>optional </b>
     * <li>RF1-10: Referral Reason (CE) <b>optional repeating</b>
     * <li>RF1-11: External Referral Identifier (EI) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class RF1 extends AbstractSegment {

    /** 
     * Creates a new RF1 segment
     */
    public RF1(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Referral Status");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Referral Priority");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Referral Type");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Referral Disposition");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Referral Category");
                                  this.add(EI.class, true, 1, 30, new Object[]{ getMessage() }, "Originating Referral Identifier");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Effective Date");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Expiration Date");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Process Date");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Referral Reason");
                                  this.add(EI.class, false, 0, 30, new Object[]{ getMessage() }, "External Referral Identifier");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating RF1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * RF1-1: "Referral Status" - creates it if necessary
     */
    public CE getReferralStatus() { 
		CE retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RF1-1: "Referral Status" - creates it if necessary
     */
    public CE getRf11_ReferralStatus() { 
		CE retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * RF1-2: "Referral Priority" - creates it if necessary
     */
    public CE getReferralPriority() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RF1-2: "Referral Priority" - creates it if necessary
     */
    public CE getRf12_ReferralPriority() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * RF1-3: "Referral Type" - creates it if necessary
     */
    public CE getReferralType() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RF1-3: "Referral Type" - creates it if necessary
     */
    public CE getRf13_ReferralType() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Referral Disposition (RF1-4).
     */
    public CE[] getReferralDisposition() {
    	CE[] retVal = this.getTypedField(4, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Referral Disposition (RF1-4).
     */
    public CE[] getRf14_ReferralDisposition() {
    	CE[] retVal = this.getTypedField(4, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Referral Disposition (RF1-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getReferralDispositionReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * RF1-4: "Referral Disposition" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getReferralDisposition(int rep) { 
		CE retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RF1-4: "Referral Disposition" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getRf14_ReferralDisposition(int rep) { 
		CE retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Referral Disposition (RF1-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRf14_ReferralDispositionReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * RF1-4: "Referral Disposition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertReferralDisposition(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * RF1-4: "Referral Disposition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertRf14_ReferralDisposition(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * RF1-4: "Referral Disposition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeReferralDisposition(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * RF1-4: "Referral Disposition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeRf14_ReferralDisposition(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(4, rep);
    }




    /**
     * Returns
     * RF1-5: "Referral Category" - creates it if necessary
     */
    public CE getReferralCategory() { 
		CE retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RF1-5: "Referral Category" - creates it if necessary
     */
    public CE getRf15_ReferralCategory() { 
		CE retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * RF1-6: "Originating Referral Identifier" - creates it if necessary
     */
    public EI getOriginatingReferralIdentifier() { 
		EI retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RF1-6: "Originating Referral Identifier" - creates it if necessary
     */
    public EI getRf16_OriginatingReferralIdentifier() { 
		EI retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * RF1-7: "Effective Date" - creates it if necessary
     */
    public TS getEffectiveDate() { 
		TS retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RF1-7: "Effective Date" - creates it if necessary
     */
    public TS getRf17_EffectiveDate() { 
		TS retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * RF1-8: "Expiration Date" - creates it if necessary
     */
    public TS getExpirationDate() { 
		TS retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RF1-8: "Expiration Date" - creates it if necessary
     */
    public TS getRf18_ExpirationDate() { 
		TS retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * RF1-9: "Process Date" - creates it if necessary
     */
    public TS getProcessDate() { 
		TS retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RF1-9: "Process Date" - creates it if necessary
     */
    public TS getRf19_ProcessDate() { 
		TS retVal = this.getTypedField(9, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Referral Reason (RF1-10).
     */
    public CE[] getReferralReason() {
    	CE[] retVal = this.getTypedField(10, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Referral Reason (RF1-10).
     */
    public CE[] getRf110_ReferralReason() {
    	CE[] retVal = this.getTypedField(10, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Referral Reason (RF1-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getReferralReasonReps() {
    	return this.getReps(10);
    }


    /**
     * Returns a specific repetition of
     * RF1-10: "Referral Reason" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getReferralReason(int rep) { 
		CE retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RF1-10: "Referral Reason" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getRf110_ReferralReason(int rep) { 
		CE retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Referral Reason (RF1-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRf110_ReferralReasonReps() {
    	return this.getReps(10);
    }


    /**
     * Inserts a repetition of
     * RF1-10: "Referral Reason" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertReferralReason(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(10, rep);
    }


    /**
     * Inserts a repetition of
     * RF1-10: "Referral Reason" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertRf110_ReferralReason(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * RF1-10: "Referral Reason" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeReferralReason(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * RF1-10: "Referral Reason" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeRf110_ReferralReason(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(10, rep);
    }



    /**
     * Returns all repetitions of External Referral Identifier (RF1-11).
     */
    public EI[] getExternalReferralIdentifier() {
    	EI[] retVal = this.getTypedField(11, new EI[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of External Referral Identifier (RF1-11).
     */
    public EI[] getRf111_ExternalReferralIdentifier() {
    	EI[] retVal = this.getTypedField(11, new EI[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of External Referral Identifier (RF1-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getExternalReferralIdentifierReps() {
    	return this.getReps(11);
    }


    /**
     * Returns a specific repetition of
     * RF1-11: "External Referral Identifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getExternalReferralIdentifier(int rep) { 
		EI retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RF1-11: "External Referral Identifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getRf111_ExternalReferralIdentifier(int rep) { 
		EI retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of External Referral Identifier (RF1-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRf111_ExternalReferralIdentifierReps() {
    	return this.getReps(11);
    }


    /**
     * Inserts a repetition of
     * RF1-11: "External Referral Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertExternalReferralIdentifier(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(11, rep);
    }


    /**
     * Inserts a repetition of
     * RF1-11: "External Referral Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertRf111_ExternalReferralIdentifier(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * RF1-11: "External Referral Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removeExternalReferralIdentifier(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * RF1-11: "External Referral Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removeRf111_ExternalReferralIdentifier(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(11, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CE(getMessage());
          case 1: return new CE(getMessage());
          case 2: return new CE(getMessage());
          case 3: return new CE(getMessage());
          case 4: return new CE(getMessage());
          case 5: return new EI(getMessage());
          case 6: return new TS(getMessage());
          case 7: return new TS(getMessage());
          case 8: return new TS(getMessage());
          case 9: return new CE(getMessage());
          case 10: return new EI(getMessage());
          default: return null;
       }
   }


}

