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
 *<p>Represents an HL7 RXC message segment (Pharmacy/Treatment Component Order). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>RXC-1: RX Component Type (ID) <b> </b>
     * <li>RXC-2: Component Code (CWE) <b> </b>
     * <li>RXC-3: Component Amount (NM) <b> </b>
     * <li>RXC-4: Component Units (CWE) <b> </b>
     * <li>RXC-5: Component Strength (NM) <b>optional </b>
     * <li>RXC-6: Component Strength Units (CWE) <b>optional </b>
     * <li>RXC-7: Supplementary Code (CWE) <b>optional repeating</b>
     * <li>RXC-8: Component Drug Strength Volume (NM) <b>optional </b>
     * <li>RXC-9: Component Drug Strength Volume Units (CWE) <b>optional </b>
     * <li>RXC-10: Dispense Amount (NM) <b>optional </b>
     * <li>RXC-11: Dispense Units (CWE) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class RXC extends AbstractSegment {

    /** 
     * Creates a new RXC segment
     */
    public RXC(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                              this.add(ID.class, true, 1, 0, new Object[]{ getMessage(), new Integer(166) }, "RX Component Type");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Component Code");
                                  this.add(NM.class, true, 1, 0, new Object[]{ getMessage() }, "Component Amount");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Component Units");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Component Strength");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Component Strength Units");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Supplementary Code");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Component Drug Strength Volume");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Component Drug Strength Volume Units");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Dispense Amount");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Dispense Units");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating RXC - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * RXC-1: "RX Component Type" - creates it if necessary
     */
    public ID getRXComponentType() { 
		ID retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXC-1: "RX Component Type" - creates it if necessary
     */
    public ID getRxc1_RXComponentType() { 
		ID retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * RXC-2: "Component Code" - creates it if necessary
     */
    public CWE getComponentCode() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXC-2: "Component Code" - creates it if necessary
     */
    public CWE getRxc2_ComponentCode() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * RXC-3: "Component Amount" - creates it if necessary
     */
    public NM getComponentAmount() { 
		NM retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXC-3: "Component Amount" - creates it if necessary
     */
    public NM getRxc3_ComponentAmount() { 
		NM retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * RXC-4: "Component Units" - creates it if necessary
     */
    public CWE getComponentUnits() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXC-4: "Component Units" - creates it if necessary
     */
    public CWE getRxc4_ComponentUnits() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * RXC-5: "Component Strength" - creates it if necessary
     */
    public NM getComponentStrength() { 
		NM retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXC-5: "Component Strength" - creates it if necessary
     */
    public NM getRxc5_ComponentStrength() { 
		NM retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * RXC-6: "Component Strength Units" - creates it if necessary
     */
    public CWE getComponentStrengthUnits() { 
		CWE retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXC-6: "Component Strength Units" - creates it if necessary
     */
    public CWE getRxc6_ComponentStrengthUnits() { 
		CWE retVal = this.getTypedField(6, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Supplementary Code (RXC-7).
     */
    public CWE[] getSupplementaryCode() {
    	CWE[] retVal = this.getTypedField(7, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Supplementary Code (RXC-7).
     */
    public CWE[] getRxc7_SupplementaryCode() {
    	CWE[] retVal = this.getTypedField(7, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Supplementary Code (RXC-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSupplementaryCodeReps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * RXC-7: "Supplementary Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getSupplementaryCode(int rep) { 
		CWE retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXC-7: "Supplementary Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getRxc7_SupplementaryCode(int rep) { 
		CWE retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Supplementary Code (RXC-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxc7_SupplementaryCodeReps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * RXC-7: "Supplementary Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertSupplementaryCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * RXC-7: "Supplementary Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertRxc7_SupplementaryCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * RXC-7: "Supplementary Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeSupplementaryCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * RXC-7: "Supplementary Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeRxc7_SupplementaryCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(7, rep);
    }




    /**
     * Returns
     * RXC-8: "Component Drug Strength Volume" - creates it if necessary
     */
    public NM getComponentDrugStrengthVolume() { 
		NM retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXC-8: "Component Drug Strength Volume" - creates it if necessary
     */
    public NM getRxc8_ComponentDrugStrengthVolume() { 
		NM retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * RXC-9: "Component Drug Strength Volume Units" - creates it if necessary
     */
    public CWE getComponentDrugStrengthVolumeUnits() { 
		CWE retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXC-9: "Component Drug Strength Volume Units" - creates it if necessary
     */
    public CWE getRxc9_ComponentDrugStrengthVolumeUnits() { 
		CWE retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * RXC-10: "Dispense Amount" - creates it if necessary
     */
    public NM getDispenseAmount() { 
		NM retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXC-10: "Dispense Amount" - creates it if necessary
     */
    public NM getRxc10_DispenseAmount() { 
		NM retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * RXC-11: "Dispense Units" - creates it if necessary
     */
    public CWE getDispenseUnits() { 
		CWE retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXC-11: "Dispense Units" - creates it if necessary
     */
    public CWE getRxc11_DispenseUnits() { 
		CWE retVal = this.getTypedField(11, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ID(getMessage(), new Integer( 166 ));
          case 1: return new CWE(getMessage());
          case 2: return new NM(getMessage());
          case 3: return new CWE(getMessage());
          case 4: return new NM(getMessage());
          case 5: return new CWE(getMessage());
          case 6: return new CWE(getMessage());
          case 7: return new NM(getMessage());
          case 8: return new CWE(getMessage());
          case 9: return new NM(getMessage());
          case 10: return new CWE(getMessage());
          default: return null;
       }
   }


}

