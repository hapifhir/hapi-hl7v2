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


package ca.uhn.hl7v2.model.v23.segment;

// import ca.uhn.hl7v2.model.v23.group.*;
import ca.uhn.hl7v2.model.v23.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 RXC message segment (Pharmacy component order segment). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>RXC-1: RX Component Type (ID) <b> </b>
     * <li>RXC-2: Component Code (CE) <b> </b>
     * <li>RXC-3: Component Amount (NM) <b> </b>
     * <li>RXC-4: Component Units (CE) <b> </b>
     * <li>RXC-5: Component Strength (NM) <b>optional </b>
     * <li>RXC-6: Component Strength Units (CE) <b>optional </b>
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
                                              this.add(ID.class, true, 1, 1, new Object[]{ getMessage(), new Integer(166) }, "RX Component Type");
                                  this.add(CE.class, true, 1, 100, new Object[]{ getMessage() }, "Component Code");
                                  this.add(NM.class, true, 1, 20, new Object[]{ getMessage() }, "Component Amount");
                                  this.add(CE.class, true, 1, 60, new Object[]{ getMessage() }, "Component Units");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Component Strength");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Component Strength Units");
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
    public CE getComponentCode() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXC-2: "Component Code" - creates it if necessary
     */
    public CE getRxc2_ComponentCode() { 
		CE retVal = this.getTypedField(2, 0);
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
    public CE getComponentUnits() { 
		CE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXC-4: "Component Units" - creates it if necessary
     */
    public CE getRxc4_ComponentUnits() { 
		CE retVal = this.getTypedField(4, 0);
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
    public CE getComponentStrengthUnits() { 
		CE retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXC-6: "Component Strength Units" - creates it if necessary
     */
    public CE getRxc6_ComponentStrengthUnits() { 
		CE retVal = this.getTypedField(6, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ID(getMessage(), new Integer( 166 ));
          case 1: return new CE(getMessage());
          case 2: return new NM(getMessage());
          case 3: return new CE(getMessage());
          case 4: return new NM(getMessage());
          case 5: return new CE(getMessage());
          default: return null;
       }
   }


}

