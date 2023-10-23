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


package ca.uhn.hl7v2.model.v25.segment;

// import ca.uhn.hl7v2.model.v25.group.*;
import ca.uhn.hl7v2.model.v25.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 LAN message segment (Language Detail). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>LAN-1: Set ID _ LAN (SI) <b> </b>
     * <li>LAN-2: Language Code (CE) <b> </b>
     * <li>LAN-3: Language Ability Code (CE) <b>optional repeating</b>
     * <li>LAN-4: Language Proficiency Code (CE) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class LAN extends AbstractSegment {

    /** 
     * Creates a new LAN segment
     */
    public LAN(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 60, new Object[]{ getMessage() }, "Set ID _ LAN");
                                  this.add(CE.class, true, 1, 250, new Object[]{ getMessage() }, "Language Code");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Language Ability Code");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Language Proficiency Code");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating LAN - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * LAN-1: "Set ID _ LAN" - creates it if necessary
     */
    public SI getSetIDLAN() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * LAN-1: "Set ID _ LAN" - creates it if necessary
     */
    public SI getLan1_SetIDLAN() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * LAN-2: "Language Code" - creates it if necessary
     */
    public CE getLanguageCode() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * LAN-2: "Language Code" - creates it if necessary
     */
    public CE getLan2_LanguageCode() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Language Ability Code (LAN-3).
     */
    public CE[] getLanguageAbilityCode() {
    	CE[] retVal = this.getTypedField(3, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Language Ability Code (LAN-3).
     */
    public CE[] getLan3_LanguageAbilityCode() {
    	CE[] retVal = this.getTypedField(3, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Language Ability Code (LAN-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getLanguageAbilityCodeReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * LAN-3: "Language Ability Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getLanguageAbilityCode(int rep) { 
		CE retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * LAN-3: "Language Ability Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getLan3_LanguageAbilityCode(int rep) { 
		CE retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Language Ability Code (LAN-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getLan3_LanguageAbilityCodeReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * LAN-3: "Language Ability Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertLanguageAbilityCode(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * LAN-3: "Language Ability Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertLan3_LanguageAbilityCode(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * LAN-3: "Language Ability Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeLanguageAbilityCode(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * LAN-3: "Language Ability Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeLan3_LanguageAbilityCode(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(3, rep);
    }




    /**
     * Returns
     * LAN-4: "Language Proficiency Code" - creates it if necessary
     */
    public CE getLanguageProficiencyCode() { 
		CE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * LAN-4: "Language Proficiency Code" - creates it if necessary
     */
    public CE getLan4_LanguageProficiencyCode() { 
		CE retVal = this.getTypedField(4, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new CE(getMessage());
          case 2: return new CE(getMessage());
          case 3: return new CE(getMessage());
          default: return null;
       }
   }


}

