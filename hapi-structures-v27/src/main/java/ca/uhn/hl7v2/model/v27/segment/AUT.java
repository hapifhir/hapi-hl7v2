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
 *<p>Represents an HL7 AUT message segment (Authorization Information). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>AUT-1: Authorizing Payor, Plan ID (CWE) <b>optional </b>
     * <li>AUT-2: Authorizing Payor, Company ID (CWE) <b> </b>
     * <li>AUT-3: Authorizing Payor, Company Name (ST) <b>optional </b>
     * <li>AUT-4: Authorization Effective Date (DTM) <b>optional </b>
     * <li>AUT-5: Authorization Expiration Date (DTM) <b>optional </b>
     * <li>AUT-6: Authorization Identifier (EI) <b>optional </b>
     * <li>AUT-7: Reimbursement Limit (CP) <b>optional </b>
     * <li>AUT-8: Requested Number of Treatments (CQ) <b>optional </b>
     * <li>AUT-9: Authorized Number of Treatments (CQ) <b>optional </b>
     * <li>AUT-10: Process Date (DTM) <b>optional </b>
     * <li>AUT-11: Requested Discipline(s) (CWE) <b>optional repeating</b>
     * <li>AUT-12: Authorized Discipline(s) (CWE) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class AUT extends AbstractSegment {

    /** 
     * Creates a new AUT segment
     */
    public AUT(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Authorizing Payor, Plan ID");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Authorizing Payor, Company ID");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Authorizing Payor, Company Name");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Authorization Effective Date");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Authorization Expiration Date");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Authorization Identifier");
                                  this.add(CP.class, false, 1, 0, new Object[]{ getMessage() }, "Reimbursement Limit");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Requested Number of Treatments");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Authorized Number of Treatments");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Process Date");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Requested Discipline(s)");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Authorized Discipline(s)");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating AUT - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * AUT-1: "Authorizing Payor, Plan ID" - creates it if necessary
     */
    public CWE getAuthorizingPayorPlanID() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-1: "Authorizing Payor, Plan ID" - creates it if necessary
     */
    public CWE getAut1_AuthorizingPayorPlanID() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-2: "Authorizing Payor, Company ID" - creates it if necessary
     */
    public CWE getAuthorizingPayorCompanyID() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-2: "Authorizing Payor, Company ID" - creates it if necessary
     */
    public CWE getAut2_AuthorizingPayorCompanyID() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-3: "Authorizing Payor, Company Name" - creates it if necessary
     */
    public ST getAuthorizingPayorCompanyName() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-3: "Authorizing Payor, Company Name" - creates it if necessary
     */
    public ST getAut3_AuthorizingPayorCompanyName() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-4: "Authorization Effective Date" - creates it if necessary
     */
    public DTM getAuthorizationEffectiveDate() { 
		DTM retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-4: "Authorization Effective Date" - creates it if necessary
     */
    public DTM getAut4_AuthorizationEffectiveDate() { 
		DTM retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-5: "Authorization Expiration Date" - creates it if necessary
     */
    public DTM getAuthorizationExpirationDate() { 
		DTM retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-5: "Authorization Expiration Date" - creates it if necessary
     */
    public DTM getAut5_AuthorizationExpirationDate() { 
		DTM retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-6: "Authorization Identifier" - creates it if necessary
     */
    public EI getAuthorizationIdentifier() { 
		EI retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-6: "Authorization Identifier" - creates it if necessary
     */
    public EI getAut6_AuthorizationIdentifier() { 
		EI retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-7: "Reimbursement Limit" - creates it if necessary
     */
    public CP getReimbursementLimit() { 
		CP retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-7: "Reimbursement Limit" - creates it if necessary
     */
    public CP getAut7_ReimbursementLimit() { 
		CP retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-8: "Requested Number of Treatments" - creates it if necessary
     */
    public CQ getRequestedNumberOfTreatments() { 
		CQ retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-8: "Requested Number of Treatments" - creates it if necessary
     */
    public CQ getAut8_RequestedNumberOfTreatments() { 
		CQ retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-9: "Authorized Number of Treatments" - creates it if necessary
     */
    public CQ getAuthorizedNumberOfTreatments() { 
		CQ retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-9: "Authorized Number of Treatments" - creates it if necessary
     */
    public CQ getAut9_AuthorizedNumberOfTreatments() { 
		CQ retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-10: "Process Date" - creates it if necessary
     */
    public DTM getProcessDate() { 
		DTM retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-10: "Process Date" - creates it if necessary
     */
    public DTM getAut10_ProcessDate() { 
		DTM retVal = this.getTypedField(10, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Requested Discipline(s) (AUT-11).
     */
    public CWE[] getRequestedDisciplineS() {
    	CWE[] retVal = this.getTypedField(11, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Requested Discipline(s) (AUT-11).
     */
    public CWE[] getAut11_RequestedDisciplineS() {
    	CWE[] retVal = this.getTypedField(11, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Requested Discipline(s) (AUT-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRequestedDisciplineSReps() {
    	return this.getReps(11);
    }


    /**
     * Returns a specific repetition of
     * AUT-11: "Requested Discipline(s)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getRequestedDisciplineS(int rep) { 
		CWE retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * AUT-11: "Requested Discipline(s)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getAut11_RequestedDisciplineS(int rep) { 
		CWE retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Requested Discipline(s) (AUT-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAut11_RequestedDisciplineSReps() {
    	return this.getReps(11);
    }


    /**
     * Inserts a repetition of
     * AUT-11: "Requested Discipline(s)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertRequestedDisciplineS(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(11, rep);
    }


    /**
     * Inserts a repetition of
     * AUT-11: "Requested Discipline(s)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertAut11_RequestedDisciplineS(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * AUT-11: "Requested Discipline(s)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeRequestedDisciplineS(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * AUT-11: "Requested Discipline(s)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeAut11_RequestedDisciplineS(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(11, rep);
    }



    /**
     * Returns all repetitions of Authorized Discipline(s) (AUT-12).
     */
    public CWE[] getAuthorizedDisciplineS() {
    	CWE[] retVal = this.getTypedField(12, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Authorized Discipline(s) (AUT-12).
     */
    public CWE[] getAut12_AuthorizedDisciplineS() {
    	CWE[] retVal = this.getTypedField(12, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Authorized Discipline(s) (AUT-12).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAuthorizedDisciplineSReps() {
    	return this.getReps(12);
    }


    /**
     * Returns a specific repetition of
     * AUT-12: "Authorized Discipline(s)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getAuthorizedDisciplineS(int rep) { 
		CWE retVal = this.getTypedField(12, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * AUT-12: "Authorized Discipline(s)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getAut12_AuthorizedDisciplineS(int rep) { 
		CWE retVal = this.getTypedField(12, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Authorized Discipline(s) (AUT-12).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAut12_AuthorizedDisciplineSReps() {
    	return this.getReps(12);
    }


    /**
     * Inserts a repetition of
     * AUT-12: "Authorized Discipline(s)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertAuthorizedDisciplineS(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(12, rep);
    }


    /**
     * Inserts a repetition of
     * AUT-12: "Authorized Discipline(s)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertAut12_AuthorizedDisciplineS(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(12, rep);
    }


    /**
     * Removes a repetition of
     * AUT-12: "Authorized Discipline(s)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeAuthorizedDisciplineS(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(12, rep);
    }


    /**
     * Removes a repetition of
     * AUT-12: "Authorized Discipline(s)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeAut12_AuthorizedDisciplineS(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(12, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CWE(getMessage());
          case 1: return new CWE(getMessage());
          case 2: return new ST(getMessage());
          case 3: return new DTM(getMessage());
          case 4: return new DTM(getMessage());
          case 5: return new EI(getMessage());
          case 6: return new CP(getMessage());
          case 7: return new CQ(getMessage());
          case 8: return new CQ(getMessage());
          case 9: return new DTM(getMessage());
          case 10: return new CWE(getMessage());
          case 11: return new CWE(getMessage());
          default: return null;
       }
   }


}

