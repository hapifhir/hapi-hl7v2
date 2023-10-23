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


package ca.uhn.hl7v2.model.v22.segment;

// import ca.uhn.hl7v2.model.v22.group.*;
import ca.uhn.hl7v2.model.v22.datatype.*;
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
     * <li>NK1-1: Set ID - Next of Kin (SI) <b> </b>
     * <li>NK1-2: NK Name (PN) <b>optional </b>
     * <li>NK1-3: Relationship (CE) <b>optional </b>
     * <li>NK1-4: Address (AD) <b>optional </b>
     * <li>NK1-5: Phone Number (TN) <b>optional repeating</b>
     * <li>NK1-6: Business Phone Number (TN) <b>optional </b>
     * <li>NK1-7: Contact Role (CE) <b>optional </b>
     * <li>NK1-8: Start Date (DT) <b>optional </b>
     * <li>NK1-9: End Date (DT) <b>optional </b>
     * <li>NK1-10: Next of Kin (ST) <b>optional </b>
     * <li>NK1-11: Next of kin job code / class (CM_JOB_CODE) <b>optional </b>
     * <li>NK1-12: Next of Kin Employee Number (ST) <b>optional </b>
     * <li>NK1-13: Organization Name (ST) <b>optional </b>
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
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "Set ID - Next of Kin");
                                  this.add(PN.class, false, 1, 48, new Object[]{ getMessage() }, "NK Name");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Relationship");
                                  this.add(AD.class, false, 1, 106, new Object[]{ getMessage() }, "Address");
                                  this.add(TN.class, false, 3, 40, new Object[]{ getMessage() }, "Phone Number");
                                  this.add(TN.class, false, 1, 40, new Object[]{ getMessage() }, "Business Phone Number");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Contact Role");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Start Date");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "End Date");
                                  this.add(ST.class, false, 1, 60, new Object[]{ getMessage() }, "Next of Kin");
                                  this.add(CM_JOB_CODE.class, false, 1, 60, new Object[]{ getMessage() }, "Next of kin job code / class");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "Next of Kin Employee Number");
                                  this.add(ST.class, false, 1, 60, new Object[]{ getMessage() }, "Organization Name");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating NK1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * NK1-1: "Set ID - Next of Kin" - creates it if necessary
     */
    public SI getSetIDNextOfKin() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-1: "Set ID - Next of Kin" - creates it if necessary
     */
    public SI getNk11_SetIDNextOfKin() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * NK1-2: "NK Name" - creates it if necessary
     */
    public PN getNKName() { 
		PN retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-2: "NK Name" - creates it if necessary
     */
    public PN getNk12_NKName() { 
		PN retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * NK1-3: "Relationship" - creates it if necessary
     */
    public CE getRelationship() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-3: "Relationship" - creates it if necessary
     */
    public CE getNk13_Relationship() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * NK1-4: "Address" - creates it if necessary
     */
    public AD getAddress() { 
		AD retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-4: "Address" - creates it if necessary
     */
    public AD getNk14_Address() { 
		AD retVal = this.getTypedField(4, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Phone Number (NK1-5).
     */
    public TN[] getPhoneNumber() {
    	TN[] retVal = this.getTypedField(5, new TN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Phone Number (NK1-5).
     */
    public TN[] getNk15_PhoneNumber() {
    	TN[] retVal = this.getTypedField(5, new TN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Phone Number (NK1-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPhoneNumberReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * NK1-5: "Phone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TN getPhoneNumber(int rep) { 
		TN retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * NK1-5: "Phone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TN getNk15_PhoneNumber(int rep) { 
		TN retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Phone Number (NK1-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getNk15_PhoneNumberReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * NK1-5: "Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN insertPhoneNumber(int rep) throws HL7Exception { 
        return (TN) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * NK1-5: "Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN insertNk15_PhoneNumber(int rep) throws HL7Exception { 
        return (TN) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * NK1-5: "Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN removePhoneNumber(int rep) throws HL7Exception { 
        return (TN) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * NK1-5: "Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN removeNk15_PhoneNumber(int rep) throws HL7Exception { 
        return (TN) super.removeRepetition(5, rep);
    }




    /**
     * Returns
     * NK1-6: "Business Phone Number" - creates it if necessary
     */
    public TN getBusinessPhoneNumber() { 
		TN retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-6: "Business Phone Number" - creates it if necessary
     */
    public TN getNk16_BusinessPhoneNumber() { 
		TN retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * NK1-7: "Contact Role" - creates it if necessary
     */
    public CE getContactRole() { 
		CE retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-7: "Contact Role" - creates it if necessary
     */
    public CE getNk17_ContactRole() { 
		CE retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * NK1-8: "Start Date" - creates it if necessary
     */
    public DT getStartDate() { 
		DT retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-8: "Start Date" - creates it if necessary
     */
    public DT getNk18_StartDate() { 
		DT retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * NK1-9: "End Date" - creates it if necessary
     */
    public DT getEndDate() { 
		DT retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-9: "End Date" - creates it if necessary
     */
    public DT getNk19_EndDate() { 
		DT retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * NK1-10: "Next of Kin" - creates it if necessary
     */
    public ST getNextOfKin() { 
		ST retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-10: "Next of Kin" - creates it if necessary
     */
    public ST getNk110_NextOfKin() { 
		ST retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * NK1-11: "Next of kin job code / class" - creates it if necessary
     */
    public CM_JOB_CODE getNextOfKinJobCodeClass() { 
		CM_JOB_CODE retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-11: "Next of kin job code / class" - creates it if necessary
     */
    public CM_JOB_CODE getNk111_NextOfKinJobCodeClass() { 
		CM_JOB_CODE retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * NK1-12: "Next of Kin Employee Number" - creates it if necessary
     */
    public ST getNextOfKinEmployeeNumber() { 
		ST retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-12: "Next of Kin Employee Number" - creates it if necessary
     */
    public ST getNk112_NextOfKinEmployeeNumber() { 
		ST retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * NK1-13: "Organization Name" - creates it if necessary
     */
    public ST getOrganizationName() { 
		ST retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-13: "Organization Name" - creates it if necessary
     */
    public ST getNk113_OrganizationName() { 
		ST retVal = this.getTypedField(13, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new PN(getMessage());
          case 2: return new CE(getMessage());
          case 3: return new AD(getMessage());
          case 4: return new TN(getMessage());
          case 5: return new TN(getMessage());
          case 6: return new CE(getMessage());
          case 7: return new DT(getMessage());
          case 8: return new DT(getMessage());
          case 9: return new ST(getMessage());
          case 10: return new CM_JOB_CODE(getMessage());
          case 11: return new ST(getMessage());
          case 12: return new ST(getMessage());
          default: return null;
       }
   }


}

