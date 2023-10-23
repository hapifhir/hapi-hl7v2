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
 *<p>Represents an HL7 SHP message segment (Shipment). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>SHP-1: Shipment ID (EI) <b> </b>
     * <li>SHP-2: Internal Shipment ID (EI) <b>optional repeating</b>
     * <li>SHP-3: Shipment Status (CWE) <b>optional </b>
     * <li>SHP-4: Shipment Status Date/Time (DTM) <b> </b>
     * <li>SHP-5: Shipment Status Reason (TX) <b>optional </b>
     * <li>SHP-6: Shipment Priority (CWE) <b>optional </b>
     * <li>SHP-7: Shipment Confidentiality (CWE) <b>optional repeating</b>
     * <li>SHP-8: Number of Packages in Shipment (NM) <b>optional </b>
     * <li>SHP-9: Shipment Condition (CWE) <b>optional repeating</b>
     * <li>SHP-10: Shipment Handling Code (CWE) <b>optional repeating</b>
     * <li>SHP-11: Shipment Risk Code (CWE) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class SHP extends AbstractSegment {

    /** 
     * Creates a new SHP segment
     */
    public SHP(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(EI.class, true, 1, 0, new Object[]{ getMessage() }, "Shipment ID");
                                  this.add(EI.class, false, 0, 0, new Object[]{ getMessage() }, "Internal Shipment ID");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Shipment Status");
                                  this.add(DTM.class, true, 1, 0, new Object[]{ getMessage() }, "Shipment Status Date/Time");
                                  this.add(TX.class, false, 1, 0, new Object[]{ getMessage() }, "Shipment Status Reason");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Shipment Priority");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Shipment Confidentiality");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Number of Packages in Shipment");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Shipment Condition");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Shipment Handling Code");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Shipment Risk Code");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating SHP - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * SHP-1: "Shipment ID" - creates it if necessary
     */
    public EI getShipmentID() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SHP-1: "Shipment ID" - creates it if necessary
     */
    public EI getShp1_ShipmentID() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Internal Shipment ID (SHP-2).
     */
    public EI[] getInternalShipmentID() {
    	EI[] retVal = this.getTypedField(2, new EI[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Internal Shipment ID (SHP-2).
     */
    public EI[] getShp2_InternalShipmentID() {
    	EI[] retVal = this.getTypedField(2, new EI[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Internal Shipment ID (SHP-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getInternalShipmentIDReps() {
    	return this.getReps(2);
    }


    /**
     * Returns a specific repetition of
     * SHP-2: "Internal Shipment ID" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getInternalShipmentID(int rep) { 
		EI retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * SHP-2: "Internal Shipment ID" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getShp2_InternalShipmentID(int rep) { 
		EI retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Internal Shipment ID (SHP-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getShp2_InternalShipmentIDReps() {
    	return this.getReps(2);
    }


    /**
     * Inserts a repetition of
     * SHP-2: "Internal Shipment ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertInternalShipmentID(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(2, rep);
    }


    /**
     * Inserts a repetition of
     * SHP-2: "Internal Shipment ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertShp2_InternalShipmentID(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * SHP-2: "Internal Shipment ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removeInternalShipmentID(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * SHP-2: "Internal Shipment ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removeShp2_InternalShipmentID(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(2, rep);
    }




    /**
     * Returns
     * SHP-3: "Shipment Status" - creates it if necessary
     */
    public CWE getShipmentStatus() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SHP-3: "Shipment Status" - creates it if necessary
     */
    public CWE getShp3_ShipmentStatus() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * SHP-4: "Shipment Status Date/Time" - creates it if necessary
     */
    public DTM getShipmentStatusDateTime() { 
		DTM retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SHP-4: "Shipment Status Date/Time" - creates it if necessary
     */
    public DTM getShp4_ShipmentStatusDateTime() { 
		DTM retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * SHP-5: "Shipment Status Reason" - creates it if necessary
     */
    public TX getShipmentStatusReason() { 
		TX retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SHP-5: "Shipment Status Reason" - creates it if necessary
     */
    public TX getShp5_ShipmentStatusReason() { 
		TX retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * SHP-6: "Shipment Priority" - creates it if necessary
     */
    public CWE getShipmentPriority() { 
		CWE retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SHP-6: "Shipment Priority" - creates it if necessary
     */
    public CWE getShp6_ShipmentPriority() { 
		CWE retVal = this.getTypedField(6, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Shipment Confidentiality (SHP-7).
     */
    public CWE[] getShipmentConfidentiality() {
    	CWE[] retVal = this.getTypedField(7, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Shipment Confidentiality (SHP-7).
     */
    public CWE[] getShp7_ShipmentConfidentiality() {
    	CWE[] retVal = this.getTypedField(7, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Shipment Confidentiality (SHP-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getShipmentConfidentialityReps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * SHP-7: "Shipment Confidentiality" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getShipmentConfidentiality(int rep) { 
		CWE retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * SHP-7: "Shipment Confidentiality" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getShp7_ShipmentConfidentiality(int rep) { 
		CWE retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Shipment Confidentiality (SHP-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getShp7_ShipmentConfidentialityReps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * SHP-7: "Shipment Confidentiality" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertShipmentConfidentiality(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * SHP-7: "Shipment Confidentiality" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertShp7_ShipmentConfidentiality(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * SHP-7: "Shipment Confidentiality" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeShipmentConfidentiality(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * SHP-7: "Shipment Confidentiality" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeShp7_ShipmentConfidentiality(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(7, rep);
    }




    /**
     * Returns
     * SHP-8: "Number of Packages in Shipment" - creates it if necessary
     */
    public NM getNumberOfPackagesInShipment() { 
		NM retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SHP-8: "Number of Packages in Shipment" - creates it if necessary
     */
    public NM getShp8_NumberOfPackagesInShipment() { 
		NM retVal = this.getTypedField(8, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Shipment Condition (SHP-9).
     */
    public CWE[] getShipmentCondition() {
    	CWE[] retVal = this.getTypedField(9, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Shipment Condition (SHP-9).
     */
    public CWE[] getShp9_ShipmentCondition() {
    	CWE[] retVal = this.getTypedField(9, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Shipment Condition (SHP-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getShipmentConditionReps() {
    	return this.getReps(9);
    }


    /**
     * Returns a specific repetition of
     * SHP-9: "Shipment Condition" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getShipmentCondition(int rep) { 
		CWE retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * SHP-9: "Shipment Condition" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getShp9_ShipmentCondition(int rep) { 
		CWE retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Shipment Condition (SHP-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getShp9_ShipmentConditionReps() {
    	return this.getReps(9);
    }


    /**
     * Inserts a repetition of
     * SHP-9: "Shipment Condition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertShipmentCondition(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(9, rep);
    }


    /**
     * Inserts a repetition of
     * SHP-9: "Shipment Condition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertShp9_ShipmentCondition(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * SHP-9: "Shipment Condition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeShipmentCondition(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * SHP-9: "Shipment Condition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeShp9_ShipmentCondition(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(9, rep);
    }



    /**
     * Returns all repetitions of Shipment Handling Code (SHP-10).
     */
    public CWE[] getShipmentHandlingCode() {
    	CWE[] retVal = this.getTypedField(10, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Shipment Handling Code (SHP-10).
     */
    public CWE[] getShp10_ShipmentHandlingCode() {
    	CWE[] retVal = this.getTypedField(10, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Shipment Handling Code (SHP-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getShipmentHandlingCodeReps() {
    	return this.getReps(10);
    }


    /**
     * Returns a specific repetition of
     * SHP-10: "Shipment Handling Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getShipmentHandlingCode(int rep) { 
		CWE retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * SHP-10: "Shipment Handling Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getShp10_ShipmentHandlingCode(int rep) { 
		CWE retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Shipment Handling Code (SHP-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getShp10_ShipmentHandlingCodeReps() {
    	return this.getReps(10);
    }


    /**
     * Inserts a repetition of
     * SHP-10: "Shipment Handling Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertShipmentHandlingCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(10, rep);
    }


    /**
     * Inserts a repetition of
     * SHP-10: "Shipment Handling Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertShp10_ShipmentHandlingCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * SHP-10: "Shipment Handling Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeShipmentHandlingCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * SHP-10: "Shipment Handling Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeShp10_ShipmentHandlingCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(10, rep);
    }



    /**
     * Returns all repetitions of Shipment Risk Code (SHP-11).
     */
    public CWE[] getShipmentRiskCode() {
    	CWE[] retVal = this.getTypedField(11, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Shipment Risk Code (SHP-11).
     */
    public CWE[] getShp11_ShipmentRiskCode() {
    	CWE[] retVal = this.getTypedField(11, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Shipment Risk Code (SHP-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getShipmentRiskCodeReps() {
    	return this.getReps(11);
    }


    /**
     * Returns a specific repetition of
     * SHP-11: "Shipment Risk Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getShipmentRiskCode(int rep) { 
		CWE retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * SHP-11: "Shipment Risk Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getShp11_ShipmentRiskCode(int rep) { 
		CWE retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Shipment Risk Code (SHP-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getShp11_ShipmentRiskCodeReps() {
    	return this.getReps(11);
    }


    /**
     * Inserts a repetition of
     * SHP-11: "Shipment Risk Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertShipmentRiskCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(11, rep);
    }


    /**
     * Inserts a repetition of
     * SHP-11: "Shipment Risk Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertShp11_ShipmentRiskCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * SHP-11: "Shipment Risk Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeShipmentRiskCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * SHP-11: "Shipment Risk Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeShp11_ShipmentRiskCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(11, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new EI(getMessage());
          case 1: return new EI(getMessage());
          case 2: return new CWE(getMessage());
          case 3: return new DTM(getMessage());
          case 4: return new TX(getMessage());
          case 5: return new CWE(getMessage());
          case 6: return new CWE(getMessage());
          case 7: return new NM(getMessage());
          case 8: return new CWE(getMessage());
          case 9: return new CWE(getMessage());
          case 10: return new CWE(getMessage());
          default: return null;
       }
   }


}

