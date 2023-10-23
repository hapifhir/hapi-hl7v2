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


package ca.uhn.hl7v2.model.v23.segment;

// import ca.uhn.hl7v2.model.v23.group.*;
import ca.uhn.hl7v2.model.v23.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 MRG message segment (Merge patient information). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>MRG-1: Prior Patient ID - Internal (CX) <b> repeating</b>
     * <li>MRG-2: Prior Alternate Patient ID (CX) <b>optional repeating</b>
     * <li>MRG-3: Prior Patient Account Number (CX) <b>optional </b>
     * <li>MRG-4: Prior Patient ID - External (CX) <b>optional </b>
     * <li>MRG-5: Prior Visit Number (CX) <b>optional </b>
     * <li>MRG-6: Prior Alternate Visit ID (CX) <b>optional </b>
     * <li>MRG-7: Prior Patient Name (XPN) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class MRG extends AbstractSegment {

    /** 
     * Creates a new MRG segment
     */
    public MRG(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CX.class, true, 0, 20, new Object[]{ getMessage() }, "Prior Patient ID - Internal");
                                  this.add(CX.class, false, 0, 16, new Object[]{ getMessage() }, "Prior Alternate Patient ID");
                                  this.add(CX.class, false, 1, 20, new Object[]{ getMessage() }, "Prior Patient Account Number");
                                  this.add(CX.class, false, 1, 16, new Object[]{ getMessage() }, "Prior Patient ID - External");
                                  this.add(CX.class, false, 1, 0, new Object[]{ getMessage() }, "Prior Visit Number");
                                  this.add(CX.class, false, 1, 0, new Object[]{ getMessage() }, "Prior Alternate Visit ID");
                                  this.add(XPN.class, false, 1, 0, new Object[]{ getMessage() }, "Prior Patient Name");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating MRG - this is probably a bug in the source code generator.", e);
       }
    }


    /**
     * Returns all repetitions of Prior Patient ID - Internal (MRG-1).
     */
    public CX[] getPriorPatientIDInternal() {
    	CX[] retVal = this.getTypedField(1, new CX[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Prior Patient ID - Internal (MRG-1).
     */
    public CX[] getMrg1_PriorPatientIDInternal() {
    	CX[] retVal = this.getTypedField(1, new CX[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Prior Patient ID - Internal (MRG-1).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPriorPatientIDInternalReps() {
    	return this.getReps(1);
    }


    /**
     * Returns a specific repetition of
     * MRG-1: "Prior Patient ID - Internal" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getPriorPatientIDInternal(int rep) { 
		CX retVal = this.getTypedField(1, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * MRG-1: "Prior Patient ID - Internal" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getMrg1_PriorPatientIDInternal(int rep) { 
		CX retVal = this.getTypedField(1, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Prior Patient ID - Internal (MRG-1).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getMrg1_PriorPatientIDInternalReps() {
    	return this.getReps(1);
    }


    /**
     * Inserts a repetition of
     * MRG-1: "Prior Patient ID - Internal" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertPriorPatientIDInternal(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(1, rep);
    }


    /**
     * Inserts a repetition of
     * MRG-1: "Prior Patient ID - Internal" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertMrg1_PriorPatientIDInternal(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(1, rep);
    }


    /**
     * Removes a repetition of
     * MRG-1: "Prior Patient ID - Internal" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removePriorPatientIDInternal(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(1, rep);
    }


    /**
     * Removes a repetition of
     * MRG-1: "Prior Patient ID - Internal" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeMrg1_PriorPatientIDInternal(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(1, rep);
    }



    /**
     * Returns all repetitions of Prior Alternate Patient ID (MRG-2).
     */
    public CX[] getPriorAlternatePatientID() {
    	CX[] retVal = this.getTypedField(2, new CX[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Prior Alternate Patient ID (MRG-2).
     */
    public CX[] getMrg2_PriorAlternatePatientID() {
    	CX[] retVal = this.getTypedField(2, new CX[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Prior Alternate Patient ID (MRG-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPriorAlternatePatientIDReps() {
    	return this.getReps(2);
    }


    /**
     * Returns a specific repetition of
     * MRG-2: "Prior Alternate Patient ID" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getPriorAlternatePatientID(int rep) { 
		CX retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * MRG-2: "Prior Alternate Patient ID" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getMrg2_PriorAlternatePatientID(int rep) { 
		CX retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Prior Alternate Patient ID (MRG-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getMrg2_PriorAlternatePatientIDReps() {
    	return this.getReps(2);
    }


    /**
     * Inserts a repetition of
     * MRG-2: "Prior Alternate Patient ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertPriorAlternatePatientID(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(2, rep);
    }


    /**
     * Inserts a repetition of
     * MRG-2: "Prior Alternate Patient ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertMrg2_PriorAlternatePatientID(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * MRG-2: "Prior Alternate Patient ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removePriorAlternatePatientID(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * MRG-2: "Prior Alternate Patient ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeMrg2_PriorAlternatePatientID(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(2, rep);
    }




    /**
     * Returns
     * MRG-3: "Prior Patient Account Number" - creates it if necessary
     */
    public CX getPriorPatientAccountNumber() { 
		CX retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MRG-3: "Prior Patient Account Number" - creates it if necessary
     */
    public CX getMrg3_PriorPatientAccountNumber() { 
		CX retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * MRG-4: "Prior Patient ID - External" - creates it if necessary
     */
    public CX getPriorPatientIDExternal() { 
		CX retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MRG-4: "Prior Patient ID - External" - creates it if necessary
     */
    public CX getMrg4_PriorPatientIDExternal() { 
		CX retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * MRG-5: "Prior Visit Number" - creates it if necessary
     */
    public CX getPriorVisitNumber() { 
		CX retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MRG-5: "Prior Visit Number" - creates it if necessary
     */
    public CX getMrg5_PriorVisitNumber() { 
		CX retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * MRG-6: "Prior Alternate Visit ID" - creates it if necessary
     */
    public CX getPriorAlternateVisitID() { 
		CX retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MRG-6: "Prior Alternate Visit ID" - creates it if necessary
     */
    public CX getMrg6_PriorAlternateVisitID() { 
		CX retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * MRG-7: "Prior Patient Name" - creates it if necessary
     */
    public XPN getPriorPatientName() { 
		XPN retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MRG-7: "Prior Patient Name" - creates it if necessary
     */
    public XPN getMrg7_PriorPatientName() { 
		XPN retVal = this.getTypedField(7, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CX(getMessage());
          case 1: return new CX(getMessage());
          case 2: return new CX(getMessage());
          case 3: return new CX(getMessage());
          case 4: return new CX(getMessage());
          case 5: return new CX(getMessage());
          case 6: return new XPN(getMessage());
          default: return null;
       }
   }


}

