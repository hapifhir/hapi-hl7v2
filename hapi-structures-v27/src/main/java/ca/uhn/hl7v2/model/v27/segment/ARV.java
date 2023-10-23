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
 *<p>Represents an HL7 ARV message segment (Access Restriction). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>ARV-1: Set ID (SI) <b>optional </b>
     * <li>ARV-2: Access Restriction Action Code (CNE) <b> </b>
     * <li>ARV-3: Access Restriction Value (CWE) <b> </b>
     * <li>ARV-4: Access Restriction Reason (CWE) <b>optional repeating</b>
     * <li>ARV-5: Special Access Restriction Instructions (ST) <b>optional repeating</b>
     * <li>ARV-6: Access Restriction Date Range (DR) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class ARV extends AbstractSegment {

    /** 
     * Creates a new ARV segment
     */
    public ARV(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, false, 1, 4, new Object[]{ getMessage() }, "Set ID");
                                  this.add(CNE.class, true, 1, 0, new Object[]{ getMessage() }, "Access Restriction Action Code");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Access Restriction Value");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Access Restriction Reason");
                                  this.add(ST.class, false, 0, 0, new Object[]{ getMessage() }, "Special Access Restriction Instructions");
                                  this.add(DR.class, false, 1, 0, new Object[]{ getMessage() }, "Access Restriction Date Range");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating ARV - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * ARV-1: "Set ID" - creates it if necessary
     */
    public SI getSetID() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ARV-1: "Set ID" - creates it if necessary
     */
    public SI getArv1_SetID() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * ARV-2: "Access Restriction Action Code" - creates it if necessary
     */
    public CNE getAccessRestrictionActionCode() { 
		CNE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ARV-2: "Access Restriction Action Code" - creates it if necessary
     */
    public CNE getArv2_AccessRestrictionActionCode() { 
		CNE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * ARV-3: "Access Restriction Value" - creates it if necessary
     */
    public CWE getAccessRestrictionValue() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ARV-3: "Access Restriction Value" - creates it if necessary
     */
    public CWE getArv3_AccessRestrictionValue() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Access Restriction Reason (ARV-4).
     */
    public CWE[] getAccessRestrictionReason() {
    	CWE[] retVal = this.getTypedField(4, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Access Restriction Reason (ARV-4).
     */
    public CWE[] getArv4_AccessRestrictionReason() {
    	CWE[] retVal = this.getTypedField(4, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Access Restriction Reason (ARV-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAccessRestrictionReasonReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * ARV-4: "Access Restriction Reason" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getAccessRestrictionReason(int rep) { 
		CWE retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ARV-4: "Access Restriction Reason" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getArv4_AccessRestrictionReason(int rep) { 
		CWE retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Access Restriction Reason (ARV-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getArv4_AccessRestrictionReasonReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * ARV-4: "Access Restriction Reason" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertAccessRestrictionReason(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * ARV-4: "Access Restriction Reason" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertArv4_AccessRestrictionReason(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * ARV-4: "Access Restriction Reason" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeAccessRestrictionReason(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * ARV-4: "Access Restriction Reason" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeArv4_AccessRestrictionReason(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(4, rep);
    }



    /**
     * Returns all repetitions of Special Access Restriction Instructions (ARV-5).
     */
    public ST[] getSpecialAccessRestrictionInstructions() {
    	ST[] retVal = this.getTypedField(5, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Special Access Restriction Instructions (ARV-5).
     */
    public ST[] getArv5_SpecialAccessRestrictionInstructions() {
    	ST[] retVal = this.getTypedField(5, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Special Access Restriction Instructions (ARV-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSpecialAccessRestrictionInstructionsReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * ARV-5: "Special Access Restriction Instructions" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getSpecialAccessRestrictionInstructions(int rep) { 
		ST retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ARV-5: "Special Access Restriction Instructions" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getArv5_SpecialAccessRestrictionInstructions(int rep) { 
		ST retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Special Access Restriction Instructions (ARV-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getArv5_SpecialAccessRestrictionInstructionsReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * ARV-5: "Special Access Restriction Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertSpecialAccessRestrictionInstructions(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * ARV-5: "Special Access Restriction Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertArv5_SpecialAccessRestrictionInstructions(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * ARV-5: "Special Access Restriction Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeSpecialAccessRestrictionInstructions(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * ARV-5: "Special Access Restriction Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeArv5_SpecialAccessRestrictionInstructions(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(5, rep);
    }




    /**
     * Returns
     * ARV-6: "Access Restriction Date Range" - creates it if necessary
     */
    public DR getAccessRestrictionDateRange() { 
		DR retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ARV-6: "Access Restriction Date Range" - creates it if necessary
     */
    public DR getArv6_AccessRestrictionDateRange() { 
		DR retVal = this.getTypedField(6, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new CNE(getMessage());
          case 2: return new CWE(getMessage());
          case 3: return new CWE(getMessage());
          case 4: return new ST(getMessage());
          case 5: return new DR(getMessage());
          default: return null;
       }
   }


}

