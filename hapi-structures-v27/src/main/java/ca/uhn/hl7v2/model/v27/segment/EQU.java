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
 *<p>Represents an HL7 EQU message segment (Equipment Detail). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>EQU-1: Equipment Instance Identifier (EI) <b> </b>
     * <li>EQU-2: Event Date/Time (DTM) <b> </b>
     * <li>EQU-3: Equipment State (CWE) <b>optional </b>
     * <li>EQU-4: Local/Remote Control State (CWE) <b>optional </b>
     * <li>EQU-5: Alert Level (CWE) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class EQU extends AbstractSegment {

    /** 
     * Creates a new EQU segment
     */
    public EQU(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(EI.class, true, 1, 0, new Object[]{ getMessage() }, "Equipment Instance Identifier");
                                  this.add(DTM.class, true, 1, 0, new Object[]{ getMessage() }, "Event Date/Time");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Equipment State");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Local/Remote Control State");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Alert Level");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating EQU - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * EQU-1: "Equipment Instance Identifier" - creates it if necessary
     */
    public EI getEquipmentInstanceIdentifier() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * EQU-1: "Equipment Instance Identifier" - creates it if necessary
     */
    public EI getEqu1_EquipmentInstanceIdentifier() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * EQU-2: "Event Date/Time" - creates it if necessary
     */
    public DTM getEventDateTime() { 
		DTM retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * EQU-2: "Event Date/Time" - creates it if necessary
     */
    public DTM getEqu2_EventDateTime() { 
		DTM retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * EQU-3: "Equipment State" - creates it if necessary
     */
    public CWE getEquipmentState() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * EQU-3: "Equipment State" - creates it if necessary
     */
    public CWE getEqu3_EquipmentState() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * EQU-4: "Local/Remote Control State" - creates it if necessary
     */
    public CWE getLocalRemoteControlState() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * EQU-4: "Local/Remote Control State" - creates it if necessary
     */
    public CWE getEqu4_LocalRemoteControlState() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * EQU-5: "Alert Level" - creates it if necessary
     */
    public CWE getAlertLevel() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * EQU-5: "Alert Level" - creates it if necessary
     */
    public CWE getEqu5_AlertLevel() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new EI(getMessage());
          case 1: return new DTM(getMessage());
          case 2: return new CWE(getMessage());
          case 3: return new CWE(getMessage());
          case 4: return new CWE(getMessage());
          default: return null;
       }
   }


}

