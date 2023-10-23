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
 *<p>Represents an HL7 BTX message segment (Blood Product Transfusion/Disposition). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>BTX-1: Set ID - BTX (SI) <b> </b>
     * <li>BTX-2: BC Donation ID (EI) <b>optional </b>
     * <li>BTX-3: BC Component (CNE) <b>optional </b>
     * <li>BTX-4: BC Blood Group (CNE) <b>optional </b>
     * <li>BTX-5: CP Commercial Product (CWE) <b>optional </b>
     * <li>BTX-6: CP Manufacturer (XON) <b>optional </b>
     * <li>BTX-7: CP Lot Number (EI) <b>optional </b>
     * <li>BTX-8: BP Quantity (NM) <b> </b>
     * <li>BTX-9: BP Amount (NM) <b>optional </b>
     * <li>BTX-10: BP Units (CWE) <b>optional </b>
     * <li>BTX-11: BP Transfusion/Disposition Status (CWE) <b> </b>
     * <li>BTX-12: BP Message Status (ID) <b> </b>
     * <li>BTX-13: BP Date/Time of Status (DTM) <b> </b>
     * <li>BTX-14: BP Transfusion Administrator (XCN) <b>optional </b>
     * <li>BTX-15: BP Transfusion Verifier (XCN) <b>optional </b>
     * <li>BTX-16: BP Transfusion Start Date/Time of Status (DTM) <b>optional </b>
     * <li>BTX-17: BP Transfusion End Date/Time of Status (DTM) <b>optional </b>
     * <li>BTX-18: BP Adverse Reaction Type (CWE) <b>optional repeating</b>
     * <li>BTX-19: BP Transfusion Interrupted Reason (CWE) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class BTX extends AbstractSegment {

    /** 
     * Creates a new BTX segment
     */
    public BTX(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "Set ID - BTX");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "BC Donation ID");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "BC Component");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "BC Blood Group");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "CP Commercial Product");
                                  this.add(XON.class, false, 1, 0, new Object[]{ getMessage() }, "CP Manufacturer");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "CP Lot Number");
                                  this.add(NM.class, true, 1, 0, new Object[]{ getMessage() }, "BP Quantity");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "BP Amount");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "BP Units");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "BP Transfusion/Disposition Status");
                                              this.add(ID.class, true, 1, 1, new Object[]{ getMessage(), new Integer(511) }, "BP Message Status");
                                  this.add(DTM.class, true, 1, 0, new Object[]{ getMessage() }, "BP Date/Time of Status");
                                  this.add(XCN.class, false, 1, 0, new Object[]{ getMessage() }, "BP Transfusion Administrator");
                                  this.add(XCN.class, false, 1, 0, new Object[]{ getMessage() }, "BP Transfusion Verifier");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "BP Transfusion Start Date/Time of Status");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "BP Transfusion End Date/Time of Status");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "BP Adverse Reaction Type");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "BP Transfusion Interrupted Reason");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating BTX - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * BTX-1: "Set ID - BTX" - creates it if necessary
     */
    public SI getSetIDBTX() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BTX-1: "Set ID - BTX" - creates it if necessary
     */
    public SI getBtx1_SetIDBTX() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * BTX-2: "BC Donation ID" - creates it if necessary
     */
    public EI getBCDonationID() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BTX-2: "BC Donation ID" - creates it if necessary
     */
    public EI getBtx2_BCDonationID() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * BTX-3: "BC Component" - creates it if necessary
     */
    public CNE getBCComponent() { 
		CNE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BTX-3: "BC Component" - creates it if necessary
     */
    public CNE getBtx3_BCComponent() { 
		CNE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * BTX-4: "BC Blood Group" - creates it if necessary
     */
    public CNE getBCBloodGroup() { 
		CNE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BTX-4: "BC Blood Group" - creates it if necessary
     */
    public CNE getBtx4_BCBloodGroup() { 
		CNE retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * BTX-5: "CP Commercial Product" - creates it if necessary
     */
    public CWE getCPCommercialProduct() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BTX-5: "CP Commercial Product" - creates it if necessary
     */
    public CWE getBtx5_CPCommercialProduct() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * BTX-6: "CP Manufacturer" - creates it if necessary
     */
    public XON getCPManufacturer() { 
		XON retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BTX-6: "CP Manufacturer" - creates it if necessary
     */
    public XON getBtx6_CPManufacturer() { 
		XON retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * BTX-7: "CP Lot Number" - creates it if necessary
     */
    public EI getCPLotNumber() { 
		EI retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BTX-7: "CP Lot Number" - creates it if necessary
     */
    public EI getBtx7_CPLotNumber() { 
		EI retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * BTX-8: "BP Quantity" - creates it if necessary
     */
    public NM getBPQuantity() { 
		NM retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BTX-8: "BP Quantity" - creates it if necessary
     */
    public NM getBtx8_BPQuantity() { 
		NM retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * BTX-9: "BP Amount" - creates it if necessary
     */
    public NM getBPAmount() { 
		NM retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BTX-9: "BP Amount" - creates it if necessary
     */
    public NM getBtx9_BPAmount() { 
		NM retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * BTX-10: "BP Units" - creates it if necessary
     */
    public CWE getBPUnits() { 
		CWE retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BTX-10: "BP Units" - creates it if necessary
     */
    public CWE getBtx10_BPUnits() { 
		CWE retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * BTX-11: "BP Transfusion/Disposition Status" - creates it if necessary
     */
    public CWE getBPTransfusionDispositionStatus() { 
		CWE retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BTX-11: "BP Transfusion/Disposition Status" - creates it if necessary
     */
    public CWE getBtx11_BPTransfusionDispositionStatus() { 
		CWE retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * BTX-12: "BP Message Status" - creates it if necessary
     */
    public ID getBPMessageStatus() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BTX-12: "BP Message Status" - creates it if necessary
     */
    public ID getBtx12_BPMessageStatus() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * BTX-13: "BP Date/Time of Status" - creates it if necessary
     */
    public DTM getBPDateTimeOfStatus() { 
		DTM retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BTX-13: "BP Date/Time of Status" - creates it if necessary
     */
    public DTM getBtx13_BPDateTimeOfStatus() { 
		DTM retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * BTX-14: "BP Transfusion Administrator" - creates it if necessary
     */
    public XCN getBPTransfusionAdministrator() { 
		XCN retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BTX-14: "BP Transfusion Administrator" - creates it if necessary
     */
    public XCN getBtx14_BPTransfusionAdministrator() { 
		XCN retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * BTX-15: "BP Transfusion Verifier" - creates it if necessary
     */
    public XCN getBPTransfusionVerifier() { 
		XCN retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BTX-15: "BP Transfusion Verifier" - creates it if necessary
     */
    public XCN getBtx15_BPTransfusionVerifier() { 
		XCN retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * BTX-16: "BP Transfusion Start Date/Time of Status" - creates it if necessary
     */
    public DTM getBPTransfusionStartDateTimeOfStatus() { 
		DTM retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BTX-16: "BP Transfusion Start Date/Time of Status" - creates it if necessary
     */
    public DTM getBtx16_BPTransfusionStartDateTimeOfStatus() { 
		DTM retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * BTX-17: "BP Transfusion End Date/Time of Status" - creates it if necessary
     */
    public DTM getBPTransfusionEndDateTimeOfStatus() { 
		DTM retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BTX-17: "BP Transfusion End Date/Time of Status" - creates it if necessary
     */
    public DTM getBtx17_BPTransfusionEndDateTimeOfStatus() { 
		DTM retVal = this.getTypedField(17, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of BP Adverse Reaction Type (BTX-18).
     */
    public CWE[] getBPAdverseReactionType() {
    	CWE[] retVal = this.getTypedField(18, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of BP Adverse Reaction Type (BTX-18).
     */
    public CWE[] getBtx18_BPAdverseReactionType() {
    	CWE[] retVal = this.getTypedField(18, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of BP Adverse Reaction Type (BTX-18).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getBPAdverseReactionTypeReps() {
    	return this.getReps(18);
    }


    /**
     * Returns a specific repetition of
     * BTX-18: "BP Adverse Reaction Type" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getBPAdverseReactionType(int rep) { 
		CWE retVal = this.getTypedField(18, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * BTX-18: "BP Adverse Reaction Type" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getBtx18_BPAdverseReactionType(int rep) { 
		CWE retVal = this.getTypedField(18, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of BP Adverse Reaction Type (BTX-18).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getBtx18_BPAdverseReactionTypeReps() {
    	return this.getReps(18);
    }


    /**
     * Inserts a repetition of
     * BTX-18: "BP Adverse Reaction Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertBPAdverseReactionType(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(18, rep);
    }


    /**
     * Inserts a repetition of
     * BTX-18: "BP Adverse Reaction Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertBtx18_BPAdverseReactionType(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(18, rep);
    }


    /**
     * Removes a repetition of
     * BTX-18: "BP Adverse Reaction Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeBPAdverseReactionType(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(18, rep);
    }


    /**
     * Removes a repetition of
     * BTX-18: "BP Adverse Reaction Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeBtx18_BPAdverseReactionType(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(18, rep);
    }




    /**
     * Returns
     * BTX-19: "BP Transfusion Interrupted Reason" - creates it if necessary
     */
    public CWE getBPTransfusionInterruptedReason() { 
		CWE retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BTX-19: "BP Transfusion Interrupted Reason" - creates it if necessary
     */
    public CWE getBtx19_BPTransfusionInterruptedReason() { 
		CWE retVal = this.getTypedField(19, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new EI(getMessage());
          case 2: return new CNE(getMessage());
          case 3: return new CNE(getMessage());
          case 4: return new CWE(getMessage());
          case 5: return new XON(getMessage());
          case 6: return new EI(getMessage());
          case 7: return new NM(getMessage());
          case 8: return new NM(getMessage());
          case 9: return new CWE(getMessage());
          case 10: return new CWE(getMessage());
          case 11: return new ID(getMessage(), new Integer( 511 ));
          case 12: return new DTM(getMessage());
          case 13: return new XCN(getMessage());
          case 14: return new XCN(getMessage());
          case 15: return new DTM(getMessage());
          case 16: return new DTM(getMessage());
          case 17: return new CWE(getMessage());
          case 18: return new CWE(getMessage());
          default: return null;
       }
   }


}

