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


package ca.uhn.hl7v2.model.v21.segment;

// import ca.uhn.hl7v2.model.v21.group.*;
import ca.uhn.hl7v2.model.v21.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 NK1 message segment (NEXT OF KIN). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>NK1-1: SET ID - NEXT OF KIN (SI) <b> </b>
     * <li>NK1-2: NEXT OF KIN NAME (PN) <b>optional </b>
     * <li>NK1-3: NEXT OF KIN RELATIONSHIP (ST) <b>optional </b>
     * <li>NK1-4: NEXT OF KIN - ADDRESS (AD) <b>optional </b>
     * <li>NK1-5: NEXT OF KIN - PHONE NUMBER (TN) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class NK1 extends AbstractSegment {

    /** 
     * Creates a new NK1 segment
     */
    public NK1(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "SET ID - NEXT OF KIN");
                                  this.add(PN.class, false, 1, 48, new Object[]{ getMessage() }, "NEXT OF KIN NAME");
                                  this.add(ST.class, false, 1, 15, new Object[]{ getMessage() }, "NEXT OF KIN RELATIONSHIP");
                                  this.add(AD.class, false, 1, 106, new Object[]{ getMessage() }, "NEXT OF KIN - ADDRESS");
                                  this.add(TN.class, false, 0, 40, new Object[]{ getMessage() }, "NEXT OF KIN - PHONE NUMBER");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating NK1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * NK1-1: "SET ID - NEXT OF KIN" - creates it if necessary
     */
    public SI getSETIDNEXTOFKIN() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-1: "SET ID - NEXT OF KIN" - creates it if necessary
     */
    public SI getNk11_SETIDNEXTOFKIN() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * NK1-2: "NEXT OF KIN NAME" - creates it if necessary
     */
    public PN getNEXTOFKINNAME() { 
		PN retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-2: "NEXT OF KIN NAME" - creates it if necessary
     */
    public PN getNk12_NEXTOFKINNAME() { 
		PN retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * NK1-3: "NEXT OF KIN RELATIONSHIP" - creates it if necessary
     */
    public ST getNEXTOFKINRELATIONSHIP() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-3: "NEXT OF KIN RELATIONSHIP" - creates it if necessary
     */
    public ST getNk13_NEXTOFKINRELATIONSHIP() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * NK1-4: "NEXT OF KIN - ADDRESS" - creates it if necessary
     */
    public AD getNEXTOFKINADDRESS() { 
		AD retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-4: "NEXT OF KIN - ADDRESS" - creates it if necessary
     */
    public AD getNk14_NEXTOFKINADDRESS() { 
		AD retVal = this.getTypedField(4, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of NEXT OF KIN - PHONE NUMBER (NK1-5).
     */
    public TN[] getNEXTOFKINPHONENUMBER() {
    	TN[] retVal = this.getTypedField(5, new TN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of NEXT OF KIN - PHONE NUMBER (NK1-5).
     */
    public TN[] getNk15_NEXTOFKINPHONENUMBER() {
    	TN[] retVal = this.getTypedField(5, new TN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of NEXT OF KIN - PHONE NUMBER (NK1-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getNEXTOFKINPHONENUMBERReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * NK1-5: "NEXT OF KIN - PHONE NUMBER" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TN getNEXTOFKINPHONENUMBER(int rep) { 
		TN retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * NK1-5: "NEXT OF KIN - PHONE NUMBER" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TN getNk15_NEXTOFKINPHONENUMBER(int rep) { 
		TN retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of NEXT OF KIN - PHONE NUMBER (NK1-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getNk15_NEXTOFKINPHONENUMBERReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * NK1-5: "NEXT OF KIN - PHONE NUMBER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN insertNEXTOFKINPHONENUMBER(int rep) throws HL7Exception { 
        return (TN) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * NK1-5: "NEXT OF KIN - PHONE NUMBER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN insertNk15_NEXTOFKINPHONENUMBER(int rep) throws HL7Exception { 
        return (TN) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * NK1-5: "NEXT OF KIN - PHONE NUMBER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN removeNEXTOFKINPHONENUMBER(int rep) throws HL7Exception { 
        return (TN) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * NK1-5: "NEXT OF KIN - PHONE NUMBER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN removeNk15_NEXTOFKINPHONENUMBER(int rep) throws HL7Exception { 
        return (TN) super.removeRepetition(5, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new PN(getMessage());
          case 2: return new ST(getMessage());
          case 3: return new AD(getMessage());
          case 4: return new TN(getMessage());
          default: return null;
       }
   }


}

