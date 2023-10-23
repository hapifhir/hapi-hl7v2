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
 *<p>Represents an HL7 SCP message segment (Sterilizer Configuration (Anti-Microbial Devices)). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>SCP-1: Number Of Decontamination/Sterilization Devices (NM) <b>optional </b>
     * <li>SCP-2: Labor Calculation Type (CWE) <b>optional </b>
     * <li>SCP-3: Date Format (CWE) <b>optional </b>
     * <li>SCP-4: Device Number (EI) <b>optional </b>
     * <li>SCP-5: Device Name (ST) <b>optional </b>
     * <li>SCP-6: Device Model Name (ST) <b>optional </b>
     * <li>SCP-7: Device Type (CWE) <b>optional </b>
     * <li>SCP-8: Lot Control (CWE) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class SCP extends AbstractSegment {

    /** 
     * Creates a new SCP segment
     */
    public SCP(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Number Of Decontamination/Sterilization Devices");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Labor Calculation Type");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Date Format");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Device Number");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Device Name");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Device Model Name");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Device Type");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Lot Control");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating SCP - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * SCP-1: "Number Of Decontamination/Sterilization Devices" - creates it if necessary
     */
    public NM getNumberOfDecontaminationSterilizationDevices() { 
		NM retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCP-1: "Number Of Decontamination/Sterilization Devices" - creates it if necessary
     */
    public NM getScp1_NumberOfDecontaminationSterilizationDevices() { 
		NM retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * SCP-2: "Labor Calculation Type" - creates it if necessary
     */
    public CWE getLaborCalculationType() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCP-2: "Labor Calculation Type" - creates it if necessary
     */
    public CWE getScp2_LaborCalculationType() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * SCP-3: "Date Format" - creates it if necessary
     */
    public CWE getDateFormat() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCP-3: "Date Format" - creates it if necessary
     */
    public CWE getScp3_DateFormat() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * SCP-4: "Device Number" - creates it if necessary
     */
    public EI getDeviceNumber() { 
		EI retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCP-4: "Device Number" - creates it if necessary
     */
    public EI getScp4_DeviceNumber() { 
		EI retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * SCP-5: "Device Name" - creates it if necessary
     */
    public ST getDeviceName() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCP-5: "Device Name" - creates it if necessary
     */
    public ST getScp5_DeviceName() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * SCP-6: "Device Model Name" - creates it if necessary
     */
    public ST getDeviceModelName() { 
		ST retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCP-6: "Device Model Name" - creates it if necessary
     */
    public ST getScp6_DeviceModelName() { 
		ST retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * SCP-7: "Device Type" - creates it if necessary
     */
    public CWE getDeviceType() { 
		CWE retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCP-7: "Device Type" - creates it if necessary
     */
    public CWE getScp7_DeviceType() { 
		CWE retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * SCP-8: "Lot Control" - creates it if necessary
     */
    public CWE getLotControl() { 
		CWE retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCP-8: "Lot Control" - creates it if necessary
     */
    public CWE getScp8_LotControl() { 
		CWE retVal = this.getTypedField(8, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new NM(getMessage());
          case 1: return new CWE(getMessage());
          case 2: return new CWE(getMessage());
          case 3: return new EI(getMessage());
          case 4: return new ST(getMessage());
          case 5: return new ST(getMessage());
          case 6: return new CWE(getMessage());
          case 7: return new CWE(getMessage());
          default: return null;
       }
   }


}

