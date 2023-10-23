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
 *<p>Represents an HL7 LRL message segment (Location Relationship). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>LRL-1: Primary Key Value - LRL (PL) <b> </b>
     * <li>LRL-2: Segment Action Code (ID) <b>optional </b>
     * <li>LRL-3: Segment Unique Key (EI) <b>optional </b>
     * <li>LRL-4: Location Relationship ID (CWE) <b> </b>
     * <li>LRL-5: Organizational Location Relationship Value (XON) <b>optional repeating</b>
     * <li>LRL-6: Patient Location Relationship Value (PL) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class LRL extends AbstractSegment {

    /** 
     * Creates a new LRL segment
     */
    public LRL(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(PL.class, true, 1, 0, new Object[]{ getMessage() }, "Primary Key Value - LRL");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(206) }, "Segment Action Code");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Segment Unique Key");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Location Relationship ID");
                                  this.add(XON.class, false, 0, 0, new Object[]{ getMessage() }, "Organizational Location Relationship Value");
                                  this.add(PL.class, false, 1, 0, new Object[]{ getMessage() }, "Patient Location Relationship Value");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating LRL - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * LRL-1: "Primary Key Value - LRL" - creates it if necessary
     */
    public PL getPrimaryKeyValueLRL() { 
		PL retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * LRL-1: "Primary Key Value - LRL" - creates it if necessary
     */
    public PL getLrl1_PrimaryKeyValueLRL() { 
		PL retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * LRL-2: "Segment Action Code" - creates it if necessary
     */
    public ID getSegmentActionCode() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * LRL-2: "Segment Action Code" - creates it if necessary
     */
    public ID getLrl2_SegmentActionCode() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * LRL-3: "Segment Unique Key" - creates it if necessary
     */
    public EI getSegmentUniqueKey() { 
		EI retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * LRL-3: "Segment Unique Key" - creates it if necessary
     */
    public EI getLrl3_SegmentUniqueKey() { 
		EI retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * LRL-4: "Location Relationship ID" - creates it if necessary
     */
    public CWE getLocationRelationshipID() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * LRL-4: "Location Relationship ID" - creates it if necessary
     */
    public CWE getLrl4_LocationRelationshipID() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Organizational Location Relationship Value (LRL-5).
     */
    public XON[] getOrganizationalLocationRelationshipValue() {
    	XON[] retVal = this.getTypedField(5, new XON[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Organizational Location Relationship Value (LRL-5).
     */
    public XON[] getLrl5_OrganizationalLocationRelationshipValue() {
    	XON[] retVal = this.getTypedField(5, new XON[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Organizational Location Relationship Value (LRL-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOrganizationalLocationRelationshipValueReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * LRL-5: "Organizational Location Relationship Value" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getOrganizationalLocationRelationshipValue(int rep) { 
		XON retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * LRL-5: "Organizational Location Relationship Value" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getLrl5_OrganizationalLocationRelationshipValue(int rep) { 
		XON retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Organizational Location Relationship Value (LRL-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getLrl5_OrganizationalLocationRelationshipValueReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * LRL-5: "Organizational Location Relationship Value" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertOrganizationalLocationRelationshipValue(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * LRL-5: "Organizational Location Relationship Value" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertLrl5_OrganizationalLocationRelationshipValue(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * LRL-5: "Organizational Location Relationship Value" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removeOrganizationalLocationRelationshipValue(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * LRL-5: "Organizational Location Relationship Value" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removeLrl5_OrganizationalLocationRelationshipValue(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(5, rep);
    }




    /**
     * Returns
     * LRL-6: "Patient Location Relationship Value" - creates it if necessary
     */
    public PL getPatientLocationRelationshipValue() { 
		PL retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * LRL-6: "Patient Location Relationship Value" - creates it if necessary
     */
    public PL getLrl6_PatientLocationRelationshipValue() { 
		PL retVal = this.getTypedField(6, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new PL(getMessage());
          case 1: return new ID(getMessage(), new Integer( 206 ));
          case 2: return new EI(getMessage());
          case 3: return new CWE(getMessage());
          case 4: return new XON(getMessage());
          case 5: return new PL(getMessage());
          default: return null;
       }
   }


}

