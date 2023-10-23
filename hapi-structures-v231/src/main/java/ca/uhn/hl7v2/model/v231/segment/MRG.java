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


package ca.uhn.hl7v2.model.v231.segment;

// import ca.uhn.hl7v2.model.v231.group.*;
import ca.uhn.hl7v2.model.v231.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 MRG message segment (MRG - merge patient information segment-). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>MRG-1: Prior Patient Identifier List (CX) <b> repeating</b>
     * <li>MRG-2: Prior Alternate Patient ID (CX) <b>optional repeating</b>
     * <li>MRG-3: Prior Patient Account Number (CX) <b>optional </b>
     * <li>MRG-4: Prior Patient ID (CX) <b>optional </b>
     * <li>MRG-5: Prior Visit Number (CX) <b>optional </b>
     * <li>MRG-6: Prior Alternate Visit ID (CX) <b>optional </b>
     * <li>MRG-7: Prior Patient Name (XPN) <b>optional repeating</b>
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
                                  this.add(CX.class, true, 0, 20, new Object[]{ getMessage() }, "Prior Patient Identifier List");
                                  this.add(CX.class, false, 0, 20, new Object[]{ getMessage() }, "Prior Alternate Patient ID");
                                  this.add(CX.class, false, 1, 20, new Object[]{ getMessage() }, "Prior Patient Account Number");
                                  this.add(CX.class, false, 1, 20, new Object[]{ getMessage() }, "Prior Patient ID");
                                  this.add(CX.class, false, 1, 20, new Object[]{ getMessage() }, "Prior Visit Number");
                                  this.add(CX.class, false, 1, 20, new Object[]{ getMessage() }, "Prior Alternate Visit ID");
                                  this.add(XPN.class, false, 0, 48, new Object[]{ getMessage() }, "Prior Patient Name");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating MRG - this is probably a bug in the source code generator.", e);
       }
    }


    /**
     * Returns all repetitions of Prior Patient Identifier List (MRG-1).
     */
    public CX[] getPriorPatientIdentifierList() {
    	CX[] retVal = this.getTypedField(1, new CX[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Prior Patient Identifier List (MRG-1).
     */
    public CX[] getMrg1_PriorPatientIdentifierList() {
    	CX[] retVal = this.getTypedField(1, new CX[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Prior Patient Identifier List (MRG-1).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPriorPatientIdentifierListReps() {
    	return this.getReps(1);
    }


    /**
     * Returns a specific repetition of
     * MRG-1: "Prior Patient Identifier List" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getPriorPatientIdentifierList(int rep) { 
		CX retVal = this.getTypedField(1, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * MRG-1: "Prior Patient Identifier List" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getMrg1_PriorPatientIdentifierList(int rep) { 
		CX retVal = this.getTypedField(1, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Prior Patient Identifier List (MRG-1).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getMrg1_PriorPatientIdentifierListReps() {
    	return this.getReps(1);
    }


    /**
     * Inserts a repetition of
     * MRG-1: "Prior Patient Identifier List" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertPriorPatientIdentifierList(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(1, rep);
    }


    /**
     * Inserts a repetition of
     * MRG-1: "Prior Patient Identifier List" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertMrg1_PriorPatientIdentifierList(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(1, rep);
    }


    /**
     * Removes a repetition of
     * MRG-1: "Prior Patient Identifier List" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removePriorPatientIdentifierList(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(1, rep);
    }


    /**
     * Removes a repetition of
     * MRG-1: "Prior Patient Identifier List" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeMrg1_PriorPatientIdentifierList(int rep) throws HL7Exception { 
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
     * MRG-4: "Prior Patient ID" - creates it if necessary
     */
    public CX getPriorPatientID() { 
		CX retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MRG-4: "Prior Patient ID" - creates it if necessary
     */
    public CX getMrg4_PriorPatientID() { 
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
     * Returns all repetitions of Prior Patient Name (MRG-7).
     */
    public XPN[] getPriorPatientName() {
    	XPN[] retVal = this.getTypedField(7, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Prior Patient Name (MRG-7).
     */
    public XPN[] getMrg7_PriorPatientName() {
    	XPN[] retVal = this.getTypedField(7, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Prior Patient Name (MRG-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPriorPatientNameReps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * MRG-7: "Prior Patient Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getPriorPatientName(int rep) { 
		XPN retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * MRG-7: "Prior Patient Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getMrg7_PriorPatientName(int rep) { 
		XPN retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Prior Patient Name (MRG-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getMrg7_PriorPatientNameReps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * MRG-7: "Prior Patient Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertPriorPatientName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * MRG-7: "Prior Patient Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertMrg7_PriorPatientName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * MRG-7: "Prior Patient Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removePriorPatientName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * MRG-7: "Prior Patient Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeMrg7_PriorPatientName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(7, rep);
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

