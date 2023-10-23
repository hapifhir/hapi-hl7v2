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
 *<p>Represents an HL7 AL1 message segment (Patient allergy information). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>AL1-1: Set ID - AL1 (SI) <b> </b>
     * <li>AL1-2: Allergy Type (ID) <b>optional </b>
     * <li>AL1-3: Allergy Code/Mnemonic/ Description (CE) <b> </b>
     * <li>AL1-4: Allergy Severity (ID) <b>optional </b>
     * <li>AL1-5: Allergy Reaction (ST) <b>optional </b>
     * <li>AL1-6: Identification Date (DT) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class AL1 extends AbstractSegment {

    /** 
     * Creates a new AL1 segment
     */
    public AL1(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "Set ID - AL1");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(127) }, "Allergy Type");
                                  this.add(CE.class, true, 1, 60, new Object[]{ getMessage() }, "Allergy Code/Mnemonic/ Description");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(128) }, "Allergy Severity");
                                  this.add(ST.class, false, 1, 15, new Object[]{ getMessage() }, "Allergy Reaction");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Identification Date");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating AL1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * AL1-1: "Set ID - AL1" - creates it if necessary
     */
    public SI getSetIDAL1() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AL1-1: "Set ID - AL1" - creates it if necessary
     */
    public SI getAl11_SetIDAL1() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * AL1-2: "Allergy Type" - creates it if necessary
     */
    public ID getAllergyType() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AL1-2: "Allergy Type" - creates it if necessary
     */
    public ID getAl12_AllergyType() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * AL1-3: "Allergy Code/Mnemonic/ Description" - creates it if necessary
     */
    public CE getAllergyCodeMnemonicDescription() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AL1-3: "Allergy Code/Mnemonic/ Description" - creates it if necessary
     */
    public CE getAl13_AllergyCodeMnemonicDescription() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * AL1-4: "Allergy Severity" - creates it if necessary
     */
    public ID getAllergySeverity() { 
		ID retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AL1-4: "Allergy Severity" - creates it if necessary
     */
    public ID getAl14_AllergySeverity() { 
		ID retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * AL1-5: "Allergy Reaction" - creates it if necessary
     */
    public ST getAllergyReaction() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AL1-5: "Allergy Reaction" - creates it if necessary
     */
    public ST getAl15_AllergyReaction() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * AL1-6: "Identification Date" - creates it if necessary
     */
    public DT getIdentificationDate() { 
		DT retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AL1-6: "Identification Date" - creates it if necessary
     */
    public DT getAl16_IdentificationDate() { 
		DT retVal = this.getTypedField(6, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new ID(getMessage(), new Integer( 127 ));
          case 2: return new CE(getMessage());
          case 3: return new ID(getMessage(), new Integer( 128 ));
          case 4: return new ST(getMessage());
          case 5: return new DT(getMessage());
          default: return null;
       }
   }


}

