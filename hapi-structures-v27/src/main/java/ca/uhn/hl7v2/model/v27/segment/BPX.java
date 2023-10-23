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
 *<p>Represents an HL7 BPX message segment (Blood product dispense status). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>BPX-1: Set ID - BPX (SI) <b> </b>
     * <li>BPX-2: BP Dispense Status (CWE) <b> </b>
     * <li>BPX-3: BP Status (ID) <b> </b>
     * <li>BPX-4: BP Date/Time of Status (DTM) <b> </b>
     * <li>BPX-5: BC Donation ID (EI) <b>optional </b>
     * <li>BPX-6: BC Component (CNE) <b>optional </b>
     * <li>BPX-7: BC Donation Type / Intended Use (CNE) <b>optional </b>
     * <li>BPX-8: CP Commercial Product (CWE) <b>optional </b>
     * <li>BPX-9: CP Manufacturer (XON) <b>optional </b>
     * <li>BPX-10: CP Lot Number (EI) <b>optional </b>
     * <li>BPX-11: BP Blood Group (CNE) <b>optional </b>
     * <li>BPX-12: BC Special Testing (CNE) <b>optional repeating</b>
     * <li>BPX-13: BP Expiration Date/Time (DTM) <b>optional </b>
     * <li>BPX-14: BP Quantity (NM) <b> </b>
     * <li>BPX-15: BP Amount (NM) <b>optional </b>
     * <li>BPX-16: BP Units (CWE) <b>optional </b>
     * <li>BPX-17: BP Unique ID (EI) <b>optional </b>
     * <li>BPX-18: BP Actual Dispensed To Location (PL) <b>optional </b>
     * <li>BPX-19: BP Actual Dispensed To Address (XAD) <b>optional </b>
     * <li>BPX-20: BP Dispensed to Receiver (XCN) <b>optional </b>
     * <li>BPX-21: BP Dispensing Individual (XCN) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class BPX extends AbstractSegment {

    /** 
     * Creates a new BPX segment
     */
    public BPX(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "Set ID - BPX");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "BP Dispense Status");
                                              this.add(ID.class, true, 1, 1, new Object[]{ getMessage(), new Integer(511) }, "BP Status");
                                  this.add(DTM.class, true, 1, 0, new Object[]{ getMessage() }, "BP Date/Time of Status");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "BC Donation ID");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "BC Component");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "BC Donation Type / Intended Use");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "CP Commercial Product");
                                  this.add(XON.class, false, 1, 0, new Object[]{ getMessage() }, "CP Manufacturer");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "CP Lot Number");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "BP Blood Group");
                                  this.add(CNE.class, false, 0, 0, new Object[]{ getMessage() }, "BC Special Testing");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "BP Expiration Date/Time");
                                  this.add(NM.class, true, 1, 0, new Object[]{ getMessage() }, "BP Quantity");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "BP Amount");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "BP Units");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "BP Unique ID");
                                  this.add(PL.class, false, 1, 0, new Object[]{ getMessage() }, "BP Actual Dispensed To Location");
                                  this.add(XAD.class, false, 1, 0, new Object[]{ getMessage() }, "BP Actual Dispensed To Address");
                                  this.add(XCN.class, false, 1, 0, new Object[]{ getMessage() }, "BP Dispensed to Receiver");
                                  this.add(XCN.class, false, 1, 0, new Object[]{ getMessage() }, "BP Dispensing Individual");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating BPX - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * BPX-1: "Set ID - BPX" - creates it if necessary
     */
    public SI getSetIDBPX() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BPX-1: "Set ID - BPX" - creates it if necessary
     */
    public SI getBpx1_SetIDBPX() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * BPX-2: "BP Dispense Status" - creates it if necessary
     */
    public CWE getBPDispenseStatus() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BPX-2: "BP Dispense Status" - creates it if necessary
     */
    public CWE getBpx2_BPDispenseStatus() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * BPX-3: "BP Status" - creates it if necessary
     */
    public ID getBPStatus() { 
		ID retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BPX-3: "BP Status" - creates it if necessary
     */
    public ID getBpx3_BPStatus() { 
		ID retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * BPX-4: "BP Date/Time of Status" - creates it if necessary
     */
    public DTM getBPDateTimeOfStatus() { 
		DTM retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BPX-4: "BP Date/Time of Status" - creates it if necessary
     */
    public DTM getBpx4_BPDateTimeOfStatus() { 
		DTM retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * BPX-5: "BC Donation ID" - creates it if necessary
     */
    public EI getBCDonationID() { 
		EI retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BPX-5: "BC Donation ID" - creates it if necessary
     */
    public EI getBpx5_BCDonationID() { 
		EI retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * BPX-6: "BC Component" - creates it if necessary
     */
    public CNE getBCComponent() { 
		CNE retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BPX-6: "BC Component" - creates it if necessary
     */
    public CNE getBpx6_BCComponent() { 
		CNE retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * BPX-7: "BC Donation Type / Intended Use" - creates it if necessary
     */
    public CNE getBCDonationTypeIntendedUse() { 
		CNE retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BPX-7: "BC Donation Type / Intended Use" - creates it if necessary
     */
    public CNE getBpx7_BCDonationTypeIntendedUse() { 
		CNE retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * BPX-8: "CP Commercial Product" - creates it if necessary
     */
    public CWE getCPCommercialProduct() { 
		CWE retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BPX-8: "CP Commercial Product" - creates it if necessary
     */
    public CWE getBpx8_CPCommercialProduct() { 
		CWE retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * BPX-9: "CP Manufacturer" - creates it if necessary
     */
    public XON getCPManufacturer() { 
		XON retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BPX-9: "CP Manufacturer" - creates it if necessary
     */
    public XON getBpx9_CPManufacturer() { 
		XON retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * BPX-10: "CP Lot Number" - creates it if necessary
     */
    public EI getCPLotNumber() { 
		EI retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BPX-10: "CP Lot Number" - creates it if necessary
     */
    public EI getBpx10_CPLotNumber() { 
		EI retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * BPX-11: "BP Blood Group" - creates it if necessary
     */
    public CNE getBPBloodGroup() { 
		CNE retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BPX-11: "BP Blood Group" - creates it if necessary
     */
    public CNE getBpx11_BPBloodGroup() { 
		CNE retVal = this.getTypedField(11, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of BC Special Testing (BPX-12).
     */
    public CNE[] getBCSpecialTesting() {
    	CNE[] retVal = this.getTypedField(12, new CNE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of BC Special Testing (BPX-12).
     */
    public CNE[] getBpx12_BCSpecialTesting() {
    	CNE[] retVal = this.getTypedField(12, new CNE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of BC Special Testing (BPX-12).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getBCSpecialTestingReps() {
    	return this.getReps(12);
    }


    /**
     * Returns a specific repetition of
     * BPX-12: "BC Special Testing" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CNE getBCSpecialTesting(int rep) { 
		CNE retVal = this.getTypedField(12, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * BPX-12: "BC Special Testing" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CNE getBpx12_BCSpecialTesting(int rep) { 
		CNE retVal = this.getTypedField(12, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of BC Special Testing (BPX-12).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getBpx12_BCSpecialTestingReps() {
    	return this.getReps(12);
    }


    /**
     * Inserts a repetition of
     * BPX-12: "BC Special Testing" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE insertBCSpecialTesting(int rep) throws HL7Exception { 
        return (CNE) super.insertRepetition(12, rep);
    }


    /**
     * Inserts a repetition of
     * BPX-12: "BC Special Testing" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE insertBpx12_BCSpecialTesting(int rep) throws HL7Exception { 
        return (CNE) super.insertRepetition(12, rep);
    }


    /**
     * Removes a repetition of
     * BPX-12: "BC Special Testing" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE removeBCSpecialTesting(int rep) throws HL7Exception { 
        return (CNE) super.removeRepetition(12, rep);
    }


    /**
     * Removes a repetition of
     * BPX-12: "BC Special Testing" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE removeBpx12_BCSpecialTesting(int rep) throws HL7Exception { 
        return (CNE) super.removeRepetition(12, rep);
    }




    /**
     * Returns
     * BPX-13: "BP Expiration Date/Time" - creates it if necessary
     */
    public DTM getBPExpirationDateTime() { 
		DTM retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BPX-13: "BP Expiration Date/Time" - creates it if necessary
     */
    public DTM getBpx13_BPExpirationDateTime() { 
		DTM retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * BPX-14: "BP Quantity" - creates it if necessary
     */
    public NM getBPQuantity() { 
		NM retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BPX-14: "BP Quantity" - creates it if necessary
     */
    public NM getBpx14_BPQuantity() { 
		NM retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * BPX-15: "BP Amount" - creates it if necessary
     */
    public NM getBPAmount() { 
		NM retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BPX-15: "BP Amount" - creates it if necessary
     */
    public NM getBpx15_BPAmount() { 
		NM retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * BPX-16: "BP Units" - creates it if necessary
     */
    public CWE getBPUnits() { 
		CWE retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BPX-16: "BP Units" - creates it if necessary
     */
    public CWE getBpx16_BPUnits() { 
		CWE retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * BPX-17: "BP Unique ID" - creates it if necessary
     */
    public EI getBPUniqueID() { 
		EI retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BPX-17: "BP Unique ID" - creates it if necessary
     */
    public EI getBpx17_BPUniqueID() { 
		EI retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * BPX-18: "BP Actual Dispensed To Location" - creates it if necessary
     */
    public PL getBPActualDispensedToLocation() { 
		PL retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BPX-18: "BP Actual Dispensed To Location" - creates it if necessary
     */
    public PL getBpx18_BPActualDispensedToLocation() { 
		PL retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * BPX-19: "BP Actual Dispensed To Address" - creates it if necessary
     */
    public XAD getBPActualDispensedToAddress() { 
		XAD retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BPX-19: "BP Actual Dispensed To Address" - creates it if necessary
     */
    public XAD getBpx19_BPActualDispensedToAddress() { 
		XAD retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * BPX-20: "BP Dispensed to Receiver" - creates it if necessary
     */
    public XCN getBPDispensedToReceiver() { 
		XCN retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BPX-20: "BP Dispensed to Receiver" - creates it if necessary
     */
    public XCN getBpx20_BPDispensedToReceiver() { 
		XCN retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * BPX-21: "BP Dispensing Individual" - creates it if necessary
     */
    public XCN getBPDispensingIndividual() { 
		XCN retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BPX-21: "BP Dispensing Individual" - creates it if necessary
     */
    public XCN getBpx21_BPDispensingIndividual() { 
		XCN retVal = this.getTypedField(21, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new CWE(getMessage());
          case 2: return new ID(getMessage(), new Integer( 511 ));
          case 3: return new DTM(getMessage());
          case 4: return new EI(getMessage());
          case 5: return new CNE(getMessage());
          case 6: return new CNE(getMessage());
          case 7: return new CWE(getMessage());
          case 8: return new XON(getMessage());
          case 9: return new EI(getMessage());
          case 10: return new CNE(getMessage());
          case 11: return new CNE(getMessage());
          case 12: return new DTM(getMessage());
          case 13: return new NM(getMessage());
          case 14: return new NM(getMessage());
          case 15: return new CWE(getMessage());
          case 16: return new EI(getMessage());
          case 17: return new PL(getMessage());
          case 18: return new XAD(getMessage());
          case 19: return new XCN(getMessage());
          case 20: return new XCN(getMessage());
          default: return null;
       }
   }


}

