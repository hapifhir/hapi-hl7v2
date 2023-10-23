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
 *<p>Represents an HL7 GP1 message segment (Grouping/Reimbursement - Visit). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>GP1-1: Type of Bill Code (CWE) <b> </b>
     * <li>GP1-2: Revenue Code (CWE) <b>optional repeating</b>
     * <li>GP1-3: Overall Claim Disposition Code (CWE) <b>optional </b>
     * <li>GP1-4: OCE Edits per Visit Code (CWE) <b>optional repeating</b>
     * <li>GP1-5: Outlier Cost (CP) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class GP1 extends AbstractSegment {

    /** 
     * Creates a new GP1 segment
     */
    public GP1(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Type of Bill Code");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Revenue Code");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Overall Claim Disposition Code");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "OCE Edits per Visit Code");
                                  this.add(CP.class, false, 1, 0, new Object[]{ getMessage() }, "Outlier Cost");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating GP1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * GP1-1: "Type of Bill Code" - creates it if necessary
     */
    public CWE getTypeOfBillCode() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GP1-1: "Type of Bill Code" - creates it if necessary
     */
    public CWE getGp11_TypeOfBillCode() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Revenue Code (GP1-2).
     */
    public CWE[] getRevenueCode() {
    	CWE[] retVal = this.getTypedField(2, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Revenue Code (GP1-2).
     */
    public CWE[] getGp12_RevenueCode() {
    	CWE[] retVal = this.getTypedField(2, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Revenue Code (GP1-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRevenueCodeReps() {
    	return this.getReps(2);
    }


    /**
     * Returns a specific repetition of
     * GP1-2: "Revenue Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getRevenueCode(int rep) { 
		CWE retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * GP1-2: "Revenue Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getGp12_RevenueCode(int rep) { 
		CWE retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Revenue Code (GP1-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGp12_RevenueCodeReps() {
    	return this.getReps(2);
    }


    /**
     * Inserts a repetition of
     * GP1-2: "Revenue Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertRevenueCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(2, rep);
    }


    /**
     * Inserts a repetition of
     * GP1-2: "Revenue Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertGp12_RevenueCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * GP1-2: "Revenue Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeRevenueCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * GP1-2: "Revenue Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeGp12_RevenueCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(2, rep);
    }




    /**
     * Returns
     * GP1-3: "Overall Claim Disposition Code" - creates it if necessary
     */
    public CWE getOverallClaimDispositionCode() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GP1-3: "Overall Claim Disposition Code" - creates it if necessary
     */
    public CWE getGp13_OverallClaimDispositionCode() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of OCE Edits per Visit Code (GP1-4).
     */
    public CWE[] getOCEEditsPerVisitCode() {
    	CWE[] retVal = this.getTypedField(4, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of OCE Edits per Visit Code (GP1-4).
     */
    public CWE[] getGp14_OCEEditsPerVisitCode() {
    	CWE[] retVal = this.getTypedField(4, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of OCE Edits per Visit Code (GP1-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOCEEditsPerVisitCodeReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * GP1-4: "OCE Edits per Visit Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getOCEEditsPerVisitCode(int rep) { 
		CWE retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * GP1-4: "OCE Edits per Visit Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getGp14_OCEEditsPerVisitCode(int rep) { 
		CWE retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of OCE Edits per Visit Code (GP1-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGp14_OCEEditsPerVisitCodeReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * GP1-4: "OCE Edits per Visit Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertOCEEditsPerVisitCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * GP1-4: "OCE Edits per Visit Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertGp14_OCEEditsPerVisitCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * GP1-4: "OCE Edits per Visit Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeOCEEditsPerVisitCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * GP1-4: "OCE Edits per Visit Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeGp14_OCEEditsPerVisitCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(4, rep);
    }




    /**
     * Returns
     * GP1-5: "Outlier Cost" - creates it if necessary
     */
    public CP getOutlierCost() { 
		CP retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GP1-5: "Outlier Cost" - creates it if necessary
     */
    public CP getGp15_OutlierCost() { 
		CP retVal = this.getTypedField(5, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CWE(getMessage());
          case 1: return new CWE(getMessage());
          case 2: return new CWE(getMessage());
          case 3: return new CWE(getMessage());
          case 4: return new CP(getMessage());
          default: return null;
       }
   }


}

