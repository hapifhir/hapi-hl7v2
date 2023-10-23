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
 *<p>Represents an HL7 BPO message segment (Blood product order). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>BPO-1: Set ID - BPO (SI) <b> </b>
     * <li>BPO-2: BP Universal Service Identifier (CWE) <b> </b>
     * <li>BPO-3: BP  Processing Requirements (CWE) <b>optional repeating</b>
     * <li>BPO-4: BP Quantity (NM) <b> </b>
     * <li>BPO-5: BP Amount (NM) <b>optional </b>
     * <li>BPO-6: BP Units (CWE) <b>optional </b>
     * <li>BPO-7: BP Intended Use Date/Time (DTM) <b>optional </b>
     * <li>BPO-8: BP Intended Dispense From Location (PL) <b>optional </b>
     * <li>BPO-9: BP Intended Dispense From Address (XAD) <b>optional </b>
     * <li>BPO-10: BP Requested Dispense Date/Time (DTM) <b>optional </b>
     * <li>BPO-11: BP Requested Dispense To Location (PL) <b>optional </b>
     * <li>BPO-12: BP Requested Dispense To Address (XAD) <b>optional </b>
     * <li>BPO-13: BP Indication for Use (CWE) <b>optional repeating</b>
     * <li>BPO-14: BP Informed Consent Indicator (ID) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class BPO extends AbstractSegment {

    /** 
     * Creates a new BPO segment
     */
    public BPO(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "Set ID - BPO");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "BP Universal Service Identifier");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "BP  Processing Requirements");
                                  this.add(NM.class, true, 1, 0, new Object[]{ getMessage() }, "BP Quantity");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "BP Amount");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "BP Units");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "BP Intended Use Date/Time");
                                  this.add(PL.class, false, 1, 0, new Object[]{ getMessage() }, "BP Intended Dispense From Location");
                                  this.add(XAD.class, false, 1, 0, new Object[]{ getMessage() }, "BP Intended Dispense From Address");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "BP Requested Dispense Date/Time");
                                  this.add(PL.class, false, 1, 0, new Object[]{ getMessage() }, "BP Requested Dispense To Location");
                                  this.add(XAD.class, false, 1, 0, new Object[]{ getMessage() }, "BP Requested Dispense To Address");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "BP Indication for Use");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "BP Informed Consent Indicator");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating BPO - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * BPO-1: "Set ID - BPO" - creates it if necessary
     */
    public SI getSetIDBPO() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BPO-1: "Set ID - BPO" - creates it if necessary
     */
    public SI getBpo1_SetIDBPO() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * BPO-2: "BP Universal Service Identifier" - creates it if necessary
     */
    public CWE getBPUniversalServiceIdentifier() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BPO-2: "BP Universal Service Identifier" - creates it if necessary
     */
    public CWE getBpo2_BPUniversalServiceIdentifier() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of BP  Processing Requirements (BPO-3).
     */
    public CWE[] getBPProcessingRequirements() {
    	CWE[] retVal = this.getTypedField(3, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of BP  Processing Requirements (BPO-3).
     */
    public CWE[] getBpo3_BPProcessingRequirements() {
    	CWE[] retVal = this.getTypedField(3, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of BP  Processing Requirements (BPO-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getBPProcessingRequirementsReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * BPO-3: "BP  Processing Requirements" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getBPProcessingRequirements(int rep) { 
		CWE retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * BPO-3: "BP  Processing Requirements" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getBpo3_BPProcessingRequirements(int rep) { 
		CWE retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of BP  Processing Requirements (BPO-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getBpo3_BPProcessingRequirementsReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * BPO-3: "BP  Processing Requirements" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertBPProcessingRequirements(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * BPO-3: "BP  Processing Requirements" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertBpo3_BPProcessingRequirements(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * BPO-3: "BP  Processing Requirements" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeBPProcessingRequirements(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * BPO-3: "BP  Processing Requirements" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeBpo3_BPProcessingRequirements(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(3, rep);
    }




    /**
     * Returns
     * BPO-4: "BP Quantity" - creates it if necessary
     */
    public NM getBPQuantity() { 
		NM retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BPO-4: "BP Quantity" - creates it if necessary
     */
    public NM getBpo4_BPQuantity() { 
		NM retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * BPO-5: "BP Amount" - creates it if necessary
     */
    public NM getBPAmount() { 
		NM retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BPO-5: "BP Amount" - creates it if necessary
     */
    public NM getBpo5_BPAmount() { 
		NM retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * BPO-6: "BP Units" - creates it if necessary
     */
    public CWE getBPUnits() { 
		CWE retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BPO-6: "BP Units" - creates it if necessary
     */
    public CWE getBpo6_BPUnits() { 
		CWE retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * BPO-7: "BP Intended Use Date/Time" - creates it if necessary
     */
    public DTM getBPIntendedUseDateTime() { 
		DTM retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BPO-7: "BP Intended Use Date/Time" - creates it if necessary
     */
    public DTM getBpo7_BPIntendedUseDateTime() { 
		DTM retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * BPO-8: "BP Intended Dispense From Location" - creates it if necessary
     */
    public PL getBPIntendedDispenseFromLocation() { 
		PL retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BPO-8: "BP Intended Dispense From Location" - creates it if necessary
     */
    public PL getBpo8_BPIntendedDispenseFromLocation() { 
		PL retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * BPO-9: "BP Intended Dispense From Address" - creates it if necessary
     */
    public XAD getBPIntendedDispenseFromAddress() { 
		XAD retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BPO-9: "BP Intended Dispense From Address" - creates it if necessary
     */
    public XAD getBpo9_BPIntendedDispenseFromAddress() { 
		XAD retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * BPO-10: "BP Requested Dispense Date/Time" - creates it if necessary
     */
    public DTM getBPRequestedDispenseDateTime() { 
		DTM retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BPO-10: "BP Requested Dispense Date/Time" - creates it if necessary
     */
    public DTM getBpo10_BPRequestedDispenseDateTime() { 
		DTM retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * BPO-11: "BP Requested Dispense To Location" - creates it if necessary
     */
    public PL getBPRequestedDispenseToLocation() { 
		PL retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BPO-11: "BP Requested Dispense To Location" - creates it if necessary
     */
    public PL getBpo11_BPRequestedDispenseToLocation() { 
		PL retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * BPO-12: "BP Requested Dispense To Address" - creates it if necessary
     */
    public XAD getBPRequestedDispenseToAddress() { 
		XAD retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BPO-12: "BP Requested Dispense To Address" - creates it if necessary
     */
    public XAD getBpo12_BPRequestedDispenseToAddress() { 
		XAD retVal = this.getTypedField(12, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of BP Indication for Use (BPO-13).
     */
    public CWE[] getBPIndicationForUse() {
    	CWE[] retVal = this.getTypedField(13, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of BP Indication for Use (BPO-13).
     */
    public CWE[] getBpo13_BPIndicationForUse() {
    	CWE[] retVal = this.getTypedField(13, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of BP Indication for Use (BPO-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getBPIndicationForUseReps() {
    	return this.getReps(13);
    }


    /**
     * Returns a specific repetition of
     * BPO-13: "BP Indication for Use" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getBPIndicationForUse(int rep) { 
		CWE retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * BPO-13: "BP Indication for Use" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getBpo13_BPIndicationForUse(int rep) { 
		CWE retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of BP Indication for Use (BPO-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getBpo13_BPIndicationForUseReps() {
    	return this.getReps(13);
    }


    /**
     * Inserts a repetition of
     * BPO-13: "BP Indication for Use" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertBPIndicationForUse(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(13, rep);
    }


    /**
     * Inserts a repetition of
     * BPO-13: "BP Indication for Use" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertBpo13_BPIndicationForUse(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * BPO-13: "BP Indication for Use" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeBPIndicationForUse(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * BPO-13: "BP Indication for Use" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeBpo13_BPIndicationForUse(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(13, rep);
    }




    /**
     * Returns
     * BPO-14: "BP Informed Consent Indicator" - creates it if necessary
     */
    public ID getBPInformedConsentIndicator() { 
		ID retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BPO-14: "BP Informed Consent Indicator" - creates it if necessary
     */
    public ID getBpo14_BPInformedConsentIndicator() { 
		ID retVal = this.getTypedField(14, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new CWE(getMessage());
          case 2: return new CWE(getMessage());
          case 3: return new NM(getMessage());
          case 4: return new NM(getMessage());
          case 5: return new CWE(getMessage());
          case 6: return new DTM(getMessage());
          case 7: return new PL(getMessage());
          case 8: return new XAD(getMessage());
          case 9: return new DTM(getMessage());
          case 10: return new PL(getMessage());
          case 11: return new XAD(getMessage());
          case 12: return new CWE(getMessage());
          case 13: return new ID(getMessage(), new Integer( 136 ));
          default: return null;
       }
   }


}

