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
 *<p>Represents an HL7 PDC message segment (PDC - product detail country segment). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PDC-1: Manufacturer/Distributor (XON) <b> repeating</b>
     * <li>PDC-2: Country (CE) <b> </b>
     * <li>PDC-3: Brand Name (ST) <b> </b>
     * <li>PDC-4: Device Family Name (ST) <b>optional </b>
     * <li>PDC-5: Generic Name (CE) <b>optional </b>
     * <li>PDC-6: Model Identifier (ST) <b>optional repeating</b>
     * <li>PDC-7: Catalogue Identifier (ST) <b>optional </b>
     * <li>PDC-8: Other Identifier (ST) <b>optional repeating</b>
     * <li>PDC-9: Product Code (CE) <b>optional </b>
     * <li>PDC-10: Marketing Basis (ID) <b>optional </b>
     * <li>PDC-11: Marketing Approval ID (ST) <b>optional </b>
     * <li>PDC-12: Labeled Shelf Life (CQ) <b>optional </b>
     * <li>PDC-13: Expected Shelf Life (CQ) <b>optional </b>
     * <li>PDC-14: Date First Marketed (TS) <b>optional </b>
     * <li>PDC-15: Date Last Marketed (TS) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class PDC extends AbstractSegment {

    /** 
     * Creates a new PDC segment
     */
    public PDC(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(XON.class, true, 0, 80, new Object[]{ getMessage() }, "Manufacturer/Distributor");
                                  this.add(CE.class, true, 1, 60, new Object[]{ getMessage() }, "Country");
                                  this.add(ST.class, true, 1, 60, new Object[]{ getMessage() }, "Brand Name");
                                  this.add(ST.class, false, 1, 60, new Object[]{ getMessage() }, "Device Family Name");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Generic Name");
                                  this.add(ST.class, false, 0, 60, new Object[]{ getMessage() }, "Model Identifier");
                                  this.add(ST.class, false, 1, 60, new Object[]{ getMessage() }, "Catalogue Identifier");
                                  this.add(ST.class, false, 0, 60, new Object[]{ getMessage() }, "Other Identifier");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Product Code");
                                              this.add(ID.class, false, 1, 4, new Object[]{ getMessage(), new Integer(330) }, "Marketing Basis");
                                  this.add(ST.class, false, 1, 60, new Object[]{ getMessage() }, "Marketing Approval ID");
                                  this.add(CQ.class, false, 1, 12, new Object[]{ getMessage() }, "Labeled Shelf Life");
                                  this.add(CQ.class, false, 1, 12, new Object[]{ getMessage() }, "Expected Shelf Life");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Date First Marketed");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Date Last Marketed");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PDC - this is probably a bug in the source code generator.", e);
       }
    }


    /**
     * Returns all repetitions of Manufacturer/Distributor (PDC-1).
     */
    public XON[] getManufacturerDistributor() {
    	XON[] retVal = this.getTypedField(1, new XON[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Manufacturer/Distributor (PDC-1).
     */
    public XON[] getPdc1_ManufacturerDistributor() {
    	XON[] retVal = this.getTypedField(1, new XON[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Manufacturer/Distributor (PDC-1).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getManufacturerDistributorReps() {
    	return this.getReps(1);
    }


    /**
     * Returns a specific repetition of
     * PDC-1: "Manufacturer/Distributor" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getManufacturerDistributor(int rep) { 
		XON retVal = this.getTypedField(1, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PDC-1: "Manufacturer/Distributor" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getPdc1_ManufacturerDistributor(int rep) { 
		XON retVal = this.getTypedField(1, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Manufacturer/Distributor (PDC-1).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPdc1_ManufacturerDistributorReps() {
    	return this.getReps(1);
    }


    /**
     * Inserts a repetition of
     * PDC-1: "Manufacturer/Distributor" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertManufacturerDistributor(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(1, rep);
    }


    /**
     * Inserts a repetition of
     * PDC-1: "Manufacturer/Distributor" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertPdc1_ManufacturerDistributor(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(1, rep);
    }


    /**
     * Removes a repetition of
     * PDC-1: "Manufacturer/Distributor" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removeManufacturerDistributor(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(1, rep);
    }


    /**
     * Removes a repetition of
     * PDC-1: "Manufacturer/Distributor" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removePdc1_ManufacturerDistributor(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(1, rep);
    }




    /**
     * Returns
     * PDC-2: "Country" - creates it if necessary
     */
    public CE getCountry() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PDC-2: "Country" - creates it if necessary
     */
    public CE getPdc2_Country() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * PDC-3: "Brand Name" - creates it if necessary
     */
    public ST getBrandName() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PDC-3: "Brand Name" - creates it if necessary
     */
    public ST getPdc3_BrandName() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * PDC-4: "Device Family Name" - creates it if necessary
     */
    public ST getDeviceFamilyName() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PDC-4: "Device Family Name" - creates it if necessary
     */
    public ST getPdc4_DeviceFamilyName() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * PDC-5: "Generic Name" - creates it if necessary
     */
    public CE getGenericName() { 
		CE retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PDC-5: "Generic Name" - creates it if necessary
     */
    public CE getPdc5_GenericName() { 
		CE retVal = this.getTypedField(5, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Model Identifier (PDC-6).
     */
    public ST[] getModelIdentifier() {
    	ST[] retVal = this.getTypedField(6, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Model Identifier (PDC-6).
     */
    public ST[] getPdc6_ModelIdentifier() {
    	ST[] retVal = this.getTypedField(6, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Model Identifier (PDC-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getModelIdentifierReps() {
    	return this.getReps(6);
    }


    /**
     * Returns a specific repetition of
     * PDC-6: "Model Identifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getModelIdentifier(int rep) { 
		ST retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PDC-6: "Model Identifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getPdc6_ModelIdentifier(int rep) { 
		ST retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Model Identifier (PDC-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPdc6_ModelIdentifierReps() {
    	return this.getReps(6);
    }


    /**
     * Inserts a repetition of
     * PDC-6: "Model Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertModelIdentifier(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(6, rep);
    }


    /**
     * Inserts a repetition of
     * PDC-6: "Model Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertPdc6_ModelIdentifier(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * PDC-6: "Model Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeModelIdentifier(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * PDC-6: "Model Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removePdc6_ModelIdentifier(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(6, rep);
    }




    /**
     * Returns
     * PDC-7: "Catalogue Identifier" - creates it if necessary
     */
    public ST getCatalogueIdentifier() { 
		ST retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PDC-7: "Catalogue Identifier" - creates it if necessary
     */
    public ST getPdc7_CatalogueIdentifier() { 
		ST retVal = this.getTypedField(7, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Other Identifier (PDC-8).
     */
    public ST[] getOtherIdentifier() {
    	ST[] retVal = this.getTypedField(8, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Other Identifier (PDC-8).
     */
    public ST[] getPdc8_OtherIdentifier() {
    	ST[] retVal = this.getTypedField(8, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Other Identifier (PDC-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOtherIdentifierReps() {
    	return this.getReps(8);
    }


    /**
     * Returns a specific repetition of
     * PDC-8: "Other Identifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getOtherIdentifier(int rep) { 
		ST retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PDC-8: "Other Identifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getPdc8_OtherIdentifier(int rep) { 
		ST retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Other Identifier (PDC-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPdc8_OtherIdentifierReps() {
    	return this.getReps(8);
    }


    /**
     * Inserts a repetition of
     * PDC-8: "Other Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertOtherIdentifier(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(8, rep);
    }


    /**
     * Inserts a repetition of
     * PDC-8: "Other Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertPdc8_OtherIdentifier(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * PDC-8: "Other Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeOtherIdentifier(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * PDC-8: "Other Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removePdc8_OtherIdentifier(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(8, rep);
    }




    /**
     * Returns
     * PDC-9: "Product Code" - creates it if necessary
     */
    public CE getProductCode() { 
		CE retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PDC-9: "Product Code" - creates it if necessary
     */
    public CE getPdc9_ProductCode() { 
		CE retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * PDC-10: "Marketing Basis" - creates it if necessary
     */
    public ID getMarketingBasis() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PDC-10: "Marketing Basis" - creates it if necessary
     */
    public ID getPdc10_MarketingBasis() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * PDC-11: "Marketing Approval ID" - creates it if necessary
     */
    public ST getMarketingApprovalID() { 
		ST retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PDC-11: "Marketing Approval ID" - creates it if necessary
     */
    public ST getPdc11_MarketingApprovalID() { 
		ST retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * PDC-12: "Labeled Shelf Life" - creates it if necessary
     */
    public CQ getLabeledShelfLife() { 
		CQ retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PDC-12: "Labeled Shelf Life" - creates it if necessary
     */
    public CQ getPdc12_LabeledShelfLife() { 
		CQ retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * PDC-13: "Expected Shelf Life" - creates it if necessary
     */
    public CQ getExpectedShelfLife() { 
		CQ retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PDC-13: "Expected Shelf Life" - creates it if necessary
     */
    public CQ getPdc13_ExpectedShelfLife() { 
		CQ retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * PDC-14: "Date First Marketed" - creates it if necessary
     */
    public TS getDateFirstMarketed() { 
		TS retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PDC-14: "Date First Marketed" - creates it if necessary
     */
    public TS getPdc14_DateFirstMarketed() { 
		TS retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * PDC-15: "Date Last Marketed" - creates it if necessary
     */
    public TS getDateLastMarketed() { 
		TS retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PDC-15: "Date Last Marketed" - creates it if necessary
     */
    public TS getPdc15_DateLastMarketed() { 
		TS retVal = this.getTypedField(15, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new XON(getMessage());
          case 1: return new CE(getMessage());
          case 2: return new ST(getMessage());
          case 3: return new ST(getMessage());
          case 4: return new CE(getMessage());
          case 5: return new ST(getMessage());
          case 6: return new ST(getMessage());
          case 7: return new ST(getMessage());
          case 8: return new CE(getMessage());
          case 9: return new ID(getMessage(), new Integer( 330 ));
          case 10: return new ST(getMessage());
          case 11: return new CQ(getMessage());
          case 12: return new CQ(getMessage());
          case 13: return new TS(getMessage());
          case 14: return new TS(getMessage());
          default: return null;
       }
   }


}

