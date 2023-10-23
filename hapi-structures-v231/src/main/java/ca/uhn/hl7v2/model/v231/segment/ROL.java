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


package ca.uhn.hl7v2.model.v231.segment;

// import ca.uhn.hl7v2.model.v231.group.*;
import ca.uhn.hl7v2.model.v231.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 ROL message segment (Role). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>ROL-1: Role Instance ID (EI) <b> </b>
     * <li>ROL-2: Action Code (ID) <b> </b>
     * <li>ROL-3: Role-ROL (CE) <b> </b>
     * <li>ROL-4: Role Person (XCN) <b> repeating</b>
     * <li>ROL-5: Role Begin Date/Time (TS) <b>optional </b>
     * <li>ROL-6: Role End Date/Time (TS) <b>optional </b>
     * <li>ROL-7: Role Duration (CE) <b>optional </b>
     * <li>ROL-8: Role Action Reason (CE) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class ROL extends AbstractSegment {

    /** 
     * Creates a new ROL segment
     */
    public ROL(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(EI.class, true, 1, 60, new Object[]{ getMessage() }, "Role Instance ID");
                                              this.add(ID.class, true, 1, 2, new Object[]{ getMessage(), new Integer(287) }, "Action Code");
                                  this.add(CE.class, true, 1, 80, new Object[]{ getMessage() }, "Role-ROL");
                                  this.add(XCN.class, true, 0, 80, new Object[]{ getMessage() }, "Role Person");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Role Begin Date/Time");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Role End Date/Time");
                                  this.add(CE.class, false, 1, 80, new Object[]{ getMessage() }, "Role Duration");
                                  this.add(CE.class, false, 1, 80, new Object[]{ getMessage() }, "Role Action Reason");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating ROL - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * ROL-1: "Role Instance ID" - creates it if necessary
     */
    public EI getRoleInstanceID() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ROL-1: "Role Instance ID" - creates it if necessary
     */
    public EI getRol1_RoleInstanceID() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * ROL-2: "Action Code" - creates it if necessary
     */
    public ID getActionCode() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ROL-2: "Action Code" - creates it if necessary
     */
    public ID getRol2_ActionCode() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * ROL-3: "Role-ROL" - creates it if necessary
     */
    public CE getRoleROL() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ROL-3: "Role-ROL" - creates it if necessary
     */
    public CE getRol3_RoleROL() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Role Person (ROL-4).
     */
    public XCN[] getRolePerson() {
    	XCN[] retVal = this.getTypedField(4, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Role Person (ROL-4).
     */
    public XCN[] getRol4_RolePerson() {
    	XCN[] retVal = this.getTypedField(4, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Role Person (ROL-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRolePersonReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * ROL-4: "Role Person" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getRolePerson(int rep) { 
		XCN retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ROL-4: "Role Person" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getRol4_RolePerson(int rep) { 
		XCN retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Role Person (ROL-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRol4_RolePersonReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * ROL-4: "Role Person" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertRolePerson(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * ROL-4: "Role Person" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertRol4_RolePerson(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * ROL-4: "Role Person" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeRolePerson(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * ROL-4: "Role Person" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeRol4_RolePerson(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(4, rep);
    }




    /**
     * Returns
     * ROL-5: "Role Begin Date/Time" - creates it if necessary
     */
    public TS getRoleBeginDateTime() { 
		TS retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ROL-5: "Role Begin Date/Time" - creates it if necessary
     */
    public TS getRol5_RoleBeginDateTime() { 
		TS retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * ROL-6: "Role End Date/Time" - creates it if necessary
     */
    public TS getRoleEndDateTime() { 
		TS retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ROL-6: "Role End Date/Time" - creates it if necessary
     */
    public TS getRol6_RoleEndDateTime() { 
		TS retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * ROL-7: "Role Duration" - creates it if necessary
     */
    public CE getRoleDuration() { 
		CE retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ROL-7: "Role Duration" - creates it if necessary
     */
    public CE getRol7_RoleDuration() { 
		CE retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * ROL-8: "Role Action Reason" - creates it if necessary
     */
    public CE getRoleActionReason() { 
		CE retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ROL-8: "Role Action Reason" - creates it if necessary
     */
    public CE getRol8_RoleActionReason() { 
		CE retVal = this.getTypedField(8, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new EI(getMessage());
          case 1: return new ID(getMessage(), new Integer( 287 ));
          case 2: return new CE(getMessage());
          case 3: return new XCN(getMessage());
          case 4: return new TS(getMessage());
          case 5: return new TS(getMessage());
          case 6: return new CE(getMessage());
          case 7: return new CE(getMessage());
          default: return null;
       }
   }


}

