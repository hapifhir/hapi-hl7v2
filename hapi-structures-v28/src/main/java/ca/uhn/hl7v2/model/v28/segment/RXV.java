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
 *<p>Represents an HL7 RXV message segment (Pharmacy/Treatment Infusion). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>RXV-1: Set ID - RXV (SI) <b>optional </b>
     * <li>RXV-2: Bolus Type (ID) <b> </b>
     * <li>RXV-3: Bolus Dose Amount (NM) <b>optional </b>
     * <li>RXV-4: Bolus Dose Amount Units (CWE) <b>optional </b>
     * <li>RXV-5: Bolus Dose Volume (NM) <b>optional </b>
     * <li>RXV-6: Bolus Dose Volume Units (CWE) <b>optional </b>
     * <li>RXV-7: PCA Type (ID) <b> </b>
     * <li>RXV-8: PCA Dose Amount (NM) <b>optional </b>
     * <li>RXV-9: PCA Dose Amount Units (CWE) <b>optional </b>
     * <li>RXV-10: PCA Dose Amount Volume (NM) <b>optional </b>
     * <li>RXV-11: PCA Dose Amount Volume Units (CWE) <b>optional </b>
     * <li>RXV-12: Max Dose Amount (NM) <b>optional </b>
     * <li>RXV-13: Max Dose Amount Units (CWE) <b>optional </b>
     * <li>RXV-14: Max Dose Amount Volume (NM) <b>optional </b>
     * <li>RXV-15: Max Dose Amount Volume Units (CWE) <b>optional </b>
     * <li>RXV-16: Max Dose per Time (CQ) <b> </b>
     * <li>RXV-17: Lockout Interval (CQ) <b>optional </b>
     * <li>RXV-18: Syringe Manufacturer (CWE) <b>optional </b>
     * <li>RXV-19: Syringe Model Number (CWE) <b>optional </b>
     * <li>RXV-20: Syringe Size (NM) <b>optional </b>
     * <li>RXV-21: Syringe Size Units (CWE) <b>optional </b>
     * <li>RXV-22: Action Code (ID) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class RXV extends AbstractSegment {

    /** 
     * Creates a new RXV segment
     */
    public RXV(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, false, 1, 0, new Object[]{ getMessage() }, "Set ID - RXV");
                                              this.add(ID.class, true, 1, 1, new Object[]{ getMessage(), new Integer(917) }, "Bolus Type");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Bolus Dose Amount");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Bolus Dose Amount Units");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Bolus Dose Volume");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Bolus Dose Volume Units");
                                              this.add(ID.class, true, 1, 2, new Object[]{ getMessage(), new Integer(918) }, "PCA Type");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "PCA Dose Amount");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "PCA Dose Amount Units");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "PCA Dose Amount Volume");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "PCA Dose Amount Volume Units");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Max Dose Amount");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Max Dose Amount Units");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Max Dose Amount Volume");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Max Dose Amount Volume Units");
                                  this.add(CQ.class, true, 1, 0, new Object[]{ getMessage() }, "Max Dose per Time");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Lockout Interval");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Syringe Manufacturer");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Syringe Model Number");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Syringe Size");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Syringe Size Units");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(206) }, "Action Code");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating RXV - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * RXV-1: "Set ID - RXV" - creates it if necessary
     */
    public SI getSetIDRXV() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXV-1: "Set ID - RXV" - creates it if necessary
     */
    public SI getRxv1_SetIDRXV() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * RXV-2: "Bolus Type" - creates it if necessary
     */
    public ID getBolusType() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXV-2: "Bolus Type" - creates it if necessary
     */
    public ID getRxv2_BolusType() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * RXV-3: "Bolus Dose Amount" - creates it if necessary
     */
    public NM getBolusDoseAmount() { 
		NM retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXV-3: "Bolus Dose Amount" - creates it if necessary
     */
    public NM getRxv3_BolusDoseAmount() { 
		NM retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * RXV-4: "Bolus Dose Amount Units" - creates it if necessary
     */
    public CWE getBolusDoseAmountUnits() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXV-4: "Bolus Dose Amount Units" - creates it if necessary
     */
    public CWE getRxv4_BolusDoseAmountUnits() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * RXV-5: "Bolus Dose Volume" - creates it if necessary
     */
    public NM getBolusDoseVolume() { 
		NM retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXV-5: "Bolus Dose Volume" - creates it if necessary
     */
    public NM getRxv5_BolusDoseVolume() { 
		NM retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * RXV-6: "Bolus Dose Volume Units" - creates it if necessary
     */
    public CWE getBolusDoseVolumeUnits() { 
		CWE retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXV-6: "Bolus Dose Volume Units" - creates it if necessary
     */
    public CWE getRxv6_BolusDoseVolumeUnits() { 
		CWE retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * RXV-7: "PCA Type" - creates it if necessary
     */
    public ID getPCAType() { 
		ID retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXV-7: "PCA Type" - creates it if necessary
     */
    public ID getRxv7_PCAType() { 
		ID retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * RXV-8: "PCA Dose Amount" - creates it if necessary
     */
    public NM getPCADoseAmount() { 
		NM retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXV-8: "PCA Dose Amount" - creates it if necessary
     */
    public NM getRxv8_PCADoseAmount() { 
		NM retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * RXV-9: "PCA Dose Amount Units" - creates it if necessary
     */
    public CWE getPCADoseAmountUnits() { 
		CWE retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXV-9: "PCA Dose Amount Units" - creates it if necessary
     */
    public CWE getRxv9_PCADoseAmountUnits() { 
		CWE retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * RXV-10: "PCA Dose Amount Volume" - creates it if necessary
     */
    public NM getPCADoseAmountVolume() { 
		NM retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXV-10: "PCA Dose Amount Volume" - creates it if necessary
     */
    public NM getRxv10_PCADoseAmountVolume() { 
		NM retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * RXV-11: "PCA Dose Amount Volume Units" - creates it if necessary
     */
    public CWE getPCADoseAmountVolumeUnits() { 
		CWE retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXV-11: "PCA Dose Amount Volume Units" - creates it if necessary
     */
    public CWE getRxv11_PCADoseAmountVolumeUnits() { 
		CWE retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * RXV-12: "Max Dose Amount" - creates it if necessary
     */
    public NM getMaxDoseAmount() { 
		NM retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXV-12: "Max Dose Amount" - creates it if necessary
     */
    public NM getRxv12_MaxDoseAmount() { 
		NM retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * RXV-13: "Max Dose Amount Units" - creates it if necessary
     */
    public CWE getMaxDoseAmountUnits() { 
		CWE retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXV-13: "Max Dose Amount Units" - creates it if necessary
     */
    public CWE getRxv13_MaxDoseAmountUnits() { 
		CWE retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * RXV-14: "Max Dose Amount Volume" - creates it if necessary
     */
    public NM getMaxDoseAmountVolume() { 
		NM retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXV-14: "Max Dose Amount Volume" - creates it if necessary
     */
    public NM getRxv14_MaxDoseAmountVolume() { 
		NM retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * RXV-15: "Max Dose Amount Volume Units" - creates it if necessary
     */
    public CWE getMaxDoseAmountVolumeUnits() { 
		CWE retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXV-15: "Max Dose Amount Volume Units" - creates it if necessary
     */
    public CWE getRxv15_MaxDoseAmountVolumeUnits() { 
		CWE retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * RXV-16: "Max Dose per Time" - creates it if necessary
     */
    public CQ getMaxDosePerTime() { 
		CQ retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXV-16: "Max Dose per Time" - creates it if necessary
     */
    public CQ getRxv16_MaxDosePerTime() { 
		CQ retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * RXV-17: "Lockout Interval" - creates it if necessary
     */
    public CQ getLockoutInterval() { 
		CQ retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXV-17: "Lockout Interval" - creates it if necessary
     */
    public CQ getRxv17_LockoutInterval() { 
		CQ retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * RXV-18: "Syringe Manufacturer" - creates it if necessary
     */
    public CWE getSyringeManufacturer() { 
		CWE retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXV-18: "Syringe Manufacturer" - creates it if necessary
     */
    public CWE getRxv18_SyringeManufacturer() { 
		CWE retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * RXV-19: "Syringe Model Number" - creates it if necessary
     */
    public CWE getSyringeModelNumber() { 
		CWE retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXV-19: "Syringe Model Number" - creates it if necessary
     */
    public CWE getRxv19_SyringeModelNumber() { 
		CWE retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * RXV-20: "Syringe Size" - creates it if necessary
     */
    public NM getSyringeSize() { 
		NM retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXV-20: "Syringe Size" - creates it if necessary
     */
    public NM getRxv20_SyringeSize() { 
		NM retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * RXV-21: "Syringe Size Units" - creates it if necessary
     */
    public CWE getSyringeSizeUnits() { 
		CWE retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXV-21: "Syringe Size Units" - creates it if necessary
     */
    public CWE getRxv21_SyringeSizeUnits() { 
		CWE retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * RXV-22: "Action Code" - creates it if necessary
     */
    public ID getActionCode() { 
		ID retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXV-22: "Action Code" - creates it if necessary
     */
    public ID getRxv22_ActionCode() { 
		ID retVal = this.getTypedField(22, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new ID(getMessage(), new Integer( 917 ));
          case 2: return new NM(getMessage());
          case 3: return new CWE(getMessage());
          case 4: return new NM(getMessage());
          case 5: return new CWE(getMessage());
          case 6: return new ID(getMessage(), new Integer( 918 ));
          case 7: return new NM(getMessage());
          case 8: return new CWE(getMessage());
          case 9: return new NM(getMessage());
          case 10: return new CWE(getMessage());
          case 11: return new NM(getMessage());
          case 12: return new CWE(getMessage());
          case 13: return new NM(getMessage());
          case 14: return new CWE(getMessage());
          case 15: return new CQ(getMessage());
          case 16: return new CQ(getMessage());
          case 17: return new CWE(getMessage());
          case 18: return new CWE(getMessage());
          case 19: return new NM(getMessage());
          case 20: return new CWE(getMessage());
          case 21: return new ID(getMessage(), new Integer( 206 ));
          default: return null;
       }
   }


}

