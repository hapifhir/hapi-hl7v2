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
 *<p>Represents an HL7 BUI message segment (Blood Unit Information). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>BUI-1: Set ID - BUI (SI) <b>optional </b>
     * <li>BUI-2: Blood Unit Identifier (EI) <b> </b>
     * <li>BUI-3: Blood Unit Type (CWE) <b> </b>
     * <li>BUI-4: Blood Unit Weight (NM) <b> </b>
     * <li>BUI-5: Weight Units (CNE) <b> </b>
     * <li>BUI-6: Blood Unit Volume (NM) <b> </b>
     * <li>BUI-7: Volume Units (CNE) <b> </b>
     * <li>BUI-8: Container Catalog Number (ST) <b> </b>
     * <li>BUI-9: Container Lot Number (ST) <b> </b>
     * <li>BUI-10: Container Manufacturer (XON) <b> </b>
     * <li>BUI-11: Transport Temperature (NR) <b> </b>
     * <li>BUI-12: Transport Temperature Units (CNE) <b> </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class BUI extends AbstractSegment {

    /** 
     * Creates a new BUI segment
     */
    public BUI(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, false, 1, 0, new Object[]{ getMessage() }, "Set ID - BUI");
                                  this.add(EI.class, true, 1, 0, new Object[]{ getMessage() }, "Blood Unit Identifier");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Blood Unit Type");
                                  this.add(NM.class, true, 1, 0, new Object[]{ getMessage() }, "Blood Unit Weight");
                                  this.add(CNE.class, true, 1, 0, new Object[]{ getMessage() }, "Weight Units");
                                  this.add(NM.class, true, 1, 0, new Object[]{ getMessage() }, "Blood Unit Volume");
                                  this.add(CNE.class, true, 1, 0, new Object[]{ getMessage() }, "Volume Units");
                                  this.add(ST.class, true, 1, 0, new Object[]{ getMessage() }, "Container Catalog Number");
                                  this.add(ST.class, true, 1, 0, new Object[]{ getMessage() }, "Container Lot Number");
                                  this.add(XON.class, true, 1, 0, new Object[]{ getMessage() }, "Container Manufacturer");
                                  this.add(NR.class, true, 1, 0, new Object[]{ getMessage() }, "Transport Temperature");
                                  this.add(CNE.class, true, 1, 0, new Object[]{ getMessage() }, "Transport Temperature Units");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating BUI - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * BUI-1: "Set ID - BUI" - creates it if necessary
     */
    public SI getSetIDBUI() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BUI-1: "Set ID - BUI" - creates it if necessary
     */
    public SI getBui1_SetIDBUI() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * BUI-2: "Blood Unit Identifier" - creates it if necessary
     */
    public EI getBloodUnitIdentifier() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BUI-2: "Blood Unit Identifier" - creates it if necessary
     */
    public EI getBui2_BloodUnitIdentifier() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * BUI-3: "Blood Unit Type" - creates it if necessary
     */
    public CWE getBloodUnitType() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BUI-3: "Blood Unit Type" - creates it if necessary
     */
    public CWE getBui3_BloodUnitType() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * BUI-4: "Blood Unit Weight" - creates it if necessary
     */
    public NM getBloodUnitWeight() { 
		NM retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BUI-4: "Blood Unit Weight" - creates it if necessary
     */
    public NM getBui4_BloodUnitWeight() { 
		NM retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * BUI-5: "Weight Units" - creates it if necessary
     */
    public CNE getWeightUnits() { 
		CNE retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BUI-5: "Weight Units" - creates it if necessary
     */
    public CNE getBui5_WeightUnits() { 
		CNE retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * BUI-6: "Blood Unit Volume" - creates it if necessary
     */
    public NM getBloodUnitVolume() { 
		NM retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BUI-6: "Blood Unit Volume" - creates it if necessary
     */
    public NM getBui6_BloodUnitVolume() { 
		NM retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * BUI-7: "Volume Units" - creates it if necessary
     */
    public CNE getVolumeUnits() { 
		CNE retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BUI-7: "Volume Units" - creates it if necessary
     */
    public CNE getBui7_VolumeUnits() { 
		CNE retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * BUI-8: "Container Catalog Number" - creates it if necessary
     */
    public ST getContainerCatalogNumber() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BUI-8: "Container Catalog Number" - creates it if necessary
     */
    public ST getBui8_ContainerCatalogNumber() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * BUI-9: "Container Lot Number" - creates it if necessary
     */
    public ST getContainerLotNumber() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BUI-9: "Container Lot Number" - creates it if necessary
     */
    public ST getBui9_ContainerLotNumber() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * BUI-10: "Container Manufacturer" - creates it if necessary
     */
    public XON getContainerManufacturer() { 
		XON retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BUI-10: "Container Manufacturer" - creates it if necessary
     */
    public XON getBui10_ContainerManufacturer() { 
		XON retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * BUI-11: "Transport Temperature" - creates it if necessary
     */
    public NR getTransportTemperature() { 
		NR retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BUI-11: "Transport Temperature" - creates it if necessary
     */
    public NR getBui11_TransportTemperature() { 
		NR retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * BUI-12: "Transport Temperature Units" - creates it if necessary
     */
    public CNE getTransportTemperatureUnits() { 
		CNE retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BUI-12: "Transport Temperature Units" - creates it if necessary
     */
    public CNE getBui12_TransportTemperatureUnits() { 
		CNE retVal = this.getTypedField(12, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new EI(getMessage());
          case 2: return new CWE(getMessage());
          case 3: return new NM(getMessage());
          case 4: return new CNE(getMessage());
          case 5: return new NM(getMessage());
          case 6: return new CNE(getMessage());
          case 7: return new ST(getMessage());
          case 8: return new ST(getMessage());
          case 9: return new XON(getMessage());
          case 10: return new NR(getMessage());
          case 11: return new CNE(getMessage());
          default: return null;
       }
   }


}

