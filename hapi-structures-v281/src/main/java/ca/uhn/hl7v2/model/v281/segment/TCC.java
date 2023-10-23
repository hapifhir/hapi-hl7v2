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


package ca.uhn.hl7v2.model.v281.segment;

// import ca.uhn.hl7v2.model.v281.group.*;
import ca.uhn.hl7v2.model.v281.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 TCC message segment (Test Code Configuration). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>TCC-1: Universal Service Identifier (CWE) <b> </b>
     * <li>TCC-2: Equipment Test Application Identifier (EI) <b> </b>
     * <li>TCC-3: Specimen Source (NULLDT) <b>optional </b>
     * <li>TCC-4: Auto-Dilution Factor Default (SN) <b>optional </b>
     * <li>TCC-5: Rerun Dilution Factor Default (SN) <b>optional </b>
     * <li>TCC-6: Pre-Dilution Factor Default (SN) <b>optional </b>
     * <li>TCC-7: Endogenous Content of Pre-Dilution Diluent (SN) <b>optional </b>
     * <li>TCC-8: Inventory Limits Warning Level (NM) <b>optional </b>
     * <li>TCC-9: Automatic Rerun Allowed (ID) <b>optional </b>
     * <li>TCC-10: Automatic Repeat Allowed (ID) <b>optional </b>
     * <li>TCC-11: Automatic Reflex Allowed (ID) <b>optional </b>
     * <li>TCC-12: Equipment Dynamic Range (SN) <b>optional </b>
     * <li>TCC-13: Units (CWE) <b>optional </b>
     * <li>TCC-14: Processing Type (CWE) <b>optional </b>
     * <li>TCC-15: Test Criticality (CWE) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class TCC extends AbstractSegment {

    /** 
     * Creates a new TCC segment
     */
    public TCC(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Universal Service Identifier");
                                  this.add(EI.class, true, 1, 0, new Object[]{ getMessage() }, "Equipment Test Application Identifier");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Specimen Source");
                                  this.add(SN.class, false, 1, 0, new Object[]{ getMessage() }, "Auto-Dilution Factor Default");
                                  this.add(SN.class, false, 1, 0, new Object[]{ getMessage() }, "Rerun Dilution Factor Default");
                                  this.add(SN.class, false, 1, 0, new Object[]{ getMessage() }, "Pre-Dilution Factor Default");
                                  this.add(SN.class, false, 1, 0, new Object[]{ getMessage() }, "Endogenous Content of Pre-Dilution Diluent");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Inventory Limits Warning Level");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(136) }, "Automatic Rerun Allowed");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(136) }, "Automatic Repeat Allowed");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(136) }, "Automatic Reflex Allowed");
                                  this.add(SN.class, false, 1, 0, new Object[]{ getMessage() }, "Equipment Dynamic Range");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Units");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Processing Type");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Test Criticality");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating TCC - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * TCC-1: "Universal Service Identifier" - creates it if necessary
     */
    public CWE getUniversalServiceIdentifier() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TCC-1: "Universal Service Identifier" - creates it if necessary
     */
    public CWE getTcc1_UniversalServiceIdentifier() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * TCC-2: "Equipment Test Application Identifier" - creates it if necessary
     */
    public EI getEquipmentTestApplicationIdentifier() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TCC-2: "Equipment Test Application Identifier" - creates it if necessary
     */
    public EI getTcc2_EquipmentTestApplicationIdentifier() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * TCC-3: "Specimen Source" - creates it if necessary
     */
    public NULLDT getSpecimenSource() { 
		NULLDT retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TCC-3: "Specimen Source" - creates it if necessary
     */
    public NULLDT getTcc3_SpecimenSource() { 
		NULLDT retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * TCC-4: "Auto-Dilution Factor Default" - creates it if necessary
     */
    public SN getAutoDilutionFactorDefault() { 
		SN retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TCC-4: "Auto-Dilution Factor Default" - creates it if necessary
     */
    public SN getTcc4_AutoDilutionFactorDefault() { 
		SN retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * TCC-5: "Rerun Dilution Factor Default" - creates it if necessary
     */
    public SN getRerunDilutionFactorDefault() { 
		SN retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TCC-5: "Rerun Dilution Factor Default" - creates it if necessary
     */
    public SN getTcc5_RerunDilutionFactorDefault() { 
		SN retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * TCC-6: "Pre-Dilution Factor Default" - creates it if necessary
     */
    public SN getPreDilutionFactorDefault() { 
		SN retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TCC-6: "Pre-Dilution Factor Default" - creates it if necessary
     */
    public SN getTcc6_PreDilutionFactorDefault() { 
		SN retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * TCC-7: "Endogenous Content of Pre-Dilution Diluent" - creates it if necessary
     */
    public SN getEndogenousContentOfPreDilutionDiluent() { 
		SN retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TCC-7: "Endogenous Content of Pre-Dilution Diluent" - creates it if necessary
     */
    public SN getTcc7_EndogenousContentOfPreDilutionDiluent() { 
		SN retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * TCC-8: "Inventory Limits Warning Level" - creates it if necessary
     */
    public NM getInventoryLimitsWarningLevel() { 
		NM retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TCC-8: "Inventory Limits Warning Level" - creates it if necessary
     */
    public NM getTcc8_InventoryLimitsWarningLevel() { 
		NM retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * TCC-9: "Automatic Rerun Allowed" - creates it if necessary
     */
    public ID getAutomaticRerunAllowed() { 
		ID retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TCC-9: "Automatic Rerun Allowed" - creates it if necessary
     */
    public ID getTcc9_AutomaticRerunAllowed() { 
		ID retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * TCC-10: "Automatic Repeat Allowed" - creates it if necessary
     */
    public ID getAutomaticRepeatAllowed() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TCC-10: "Automatic Repeat Allowed" - creates it if necessary
     */
    public ID getTcc10_AutomaticRepeatAllowed() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * TCC-11: "Automatic Reflex Allowed" - creates it if necessary
     */
    public ID getAutomaticReflexAllowed() { 
		ID retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TCC-11: "Automatic Reflex Allowed" - creates it if necessary
     */
    public ID getTcc11_AutomaticReflexAllowed() { 
		ID retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * TCC-12: "Equipment Dynamic Range" - creates it if necessary
     */
    public SN getEquipmentDynamicRange() { 
		SN retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TCC-12: "Equipment Dynamic Range" - creates it if necessary
     */
    public SN getTcc12_EquipmentDynamicRange() { 
		SN retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * TCC-13: "Units" - creates it if necessary
     */
    public CWE getUnits() { 
		CWE retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TCC-13: "Units" - creates it if necessary
     */
    public CWE getTcc13_Units() { 
		CWE retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * TCC-14: "Processing Type" - creates it if necessary
     */
    public CWE getProcessingType() { 
		CWE retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TCC-14: "Processing Type" - creates it if necessary
     */
    public CWE getTcc14_ProcessingType() { 
		CWE retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * TCC-15: "Test Criticality" - creates it if necessary
     */
    public CWE getTestCriticality() { 
		CWE retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TCC-15: "Test Criticality" - creates it if necessary
     */
    public CWE getTcc15_TestCriticality() { 
		CWE retVal = this.getTypedField(15, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CWE(getMessage());
          case 1: return new EI(getMessage());
          case 2: return new NULLDT(getMessage());
          case 3: return new SN(getMessage());
          case 4: return new SN(getMessage());
          case 5: return new SN(getMessage());
          case 6: return new SN(getMessage());
          case 7: return new NM(getMessage());
          case 8: return new ID(getMessage(), new Integer( 136 ));
          case 9: return new ID(getMessage(), new Integer( 136 ));
          case 10: return new ID(getMessage(), new Integer( 136 ));
          case 11: return new SN(getMessage());
          case 12: return new CWE(getMessage());
          case 13: return new CWE(getMessage());
          case 14: return new CWE(getMessage());
          default: return null;
       }
   }


}

