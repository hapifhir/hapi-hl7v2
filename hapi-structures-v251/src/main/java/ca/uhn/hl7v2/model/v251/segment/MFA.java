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


package ca.uhn.hl7v2.model.v251.segment;

// import ca.uhn.hl7v2.model.v251.group.*;
import ca.uhn.hl7v2.model.v251.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 MFA message segment (Master File Acknowledgment). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>MFA-1: Record-Level Event Code (ID) <b> </b>
     * <li>MFA-2: MFN Control ID (ST) <b>optional </b>
     * <li>MFA-3: Event Completion Date/Time (TS) <b>optional </b>
     * <li>MFA-4: MFN Record Level Error Return (CE) <b> </b>
     * <li>MFA-5: Primary Key Value - MFA (Varies) <b> repeating</b>
     * <li>MFA-6: Primary Key Value Type - MFA (ID) <b> repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class MFA extends AbstractSegment {

    /** 
     * Creates a new MFA segment
     */
    public MFA(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                              this.add(ID.class, true, 1, 3, new Object[]{ getMessage(), new Integer(180) }, "Record-Level Event Code");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "MFN Control ID");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Event Completion Date/Time");
                                  this.add(CE.class, true, 1, 250, new Object[]{ getMessage() }, "MFN Record Level Error Return");
                                  this.add(Varies.class, true, 0, 250, new Object[]{ getMessage() }, "Primary Key Value - MFA");
                                              this.add(ID.class, true, 0, 3, new Object[]{ getMessage(), new Integer(355) }, "Primary Key Value Type - MFA");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating MFA - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * MFA-1: "Record-Level Event Code" - creates it if necessary
     */
    public ID getRecordLevelEventCode() { 
		ID retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MFA-1: "Record-Level Event Code" - creates it if necessary
     */
    public ID getMfa1_RecordLevelEventCode() { 
		ID retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * MFA-2: "MFN Control ID" - creates it if necessary
     */
    public ST getMFNControlID() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MFA-2: "MFN Control ID" - creates it if necessary
     */
    public ST getMfa2_MFNControlID() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * MFA-3: "Event Completion Date/Time" - creates it if necessary
     */
    public TS getEventCompletionDateTime() { 
		TS retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MFA-3: "Event Completion Date/Time" - creates it if necessary
     */
    public TS getMfa3_EventCompletionDateTime() { 
		TS retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * MFA-4: "MFN Record Level Error Return" - creates it if necessary
     */
    public CE getMFNRecordLevelErrorReturn() { 
		CE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MFA-4: "MFN Record Level Error Return" - creates it if necessary
     */
    public CE getMfa4_MFNRecordLevelErrorReturn() { 
		CE retVal = this.getTypedField(4, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Primary Key Value - MFA (MFA-5).
     */
    public Varies[] getPrimaryKeyValueMFA() {
    	Varies[] retVal = this.getTypedField(5, new Varies[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Primary Key Value - MFA (MFA-5).
     */
    public Varies[] getMfa5_PrimaryKeyValueMFA() {
    	Varies[] retVal = this.getTypedField(5, new Varies[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Primary Key Value - MFA (MFA-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPrimaryKeyValueMFAReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * MFA-5: "Primary Key Value - MFA" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public Varies getPrimaryKeyValueMFA(int rep) { 
		Varies retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * MFA-5: "Primary Key Value - MFA" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public Varies getMfa5_PrimaryKeyValueMFA(int rep) { 
		Varies retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Primary Key Value - MFA (MFA-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getMfa5_PrimaryKeyValueMFAReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * MFA-5: "Primary Key Value - MFA" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public Varies insertPrimaryKeyValueMFA(int rep) throws HL7Exception { 
        return (Varies) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * MFA-5: "Primary Key Value - MFA" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public Varies insertMfa5_PrimaryKeyValueMFA(int rep) throws HL7Exception { 
        return (Varies) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * MFA-5: "Primary Key Value - MFA" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public Varies removePrimaryKeyValueMFA(int rep) throws HL7Exception { 
        return (Varies) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * MFA-5: "Primary Key Value - MFA" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public Varies removeMfa5_PrimaryKeyValueMFA(int rep) throws HL7Exception { 
        return (Varies) super.removeRepetition(5, rep);
    }



    /**
     * Returns all repetitions of Primary Key Value Type - MFA (MFA-6).
     */
    public ID[] getPrimaryKeyValueTypeMFA() {
    	ID[] retVal = this.getTypedField(6, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Primary Key Value Type - MFA (MFA-6).
     */
    public ID[] getMfa6_PrimaryKeyValueTypeMFA() {
    	ID[] retVal = this.getTypedField(6, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Primary Key Value Type - MFA (MFA-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPrimaryKeyValueTypeMFAReps() {
    	return this.getReps(6);
    }


    /**
     * Returns a specific repetition of
     * MFA-6: "Primary Key Value Type - MFA" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getPrimaryKeyValueTypeMFA(int rep) { 
		ID retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * MFA-6: "Primary Key Value Type - MFA" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getMfa6_PrimaryKeyValueTypeMFA(int rep) { 
		ID retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Primary Key Value Type - MFA (MFA-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getMfa6_PrimaryKeyValueTypeMFAReps() {
    	return this.getReps(6);
    }


    /**
     * Inserts a repetition of
     * MFA-6: "Primary Key Value Type - MFA" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertPrimaryKeyValueTypeMFA(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(6, rep);
    }


    /**
     * Inserts a repetition of
     * MFA-6: "Primary Key Value Type - MFA" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertMfa6_PrimaryKeyValueTypeMFA(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * MFA-6: "Primary Key Value Type - MFA" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removePrimaryKeyValueTypeMFA(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * MFA-6: "Primary Key Value Type - MFA" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeMfa6_PrimaryKeyValueTypeMFA(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(6, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ID(getMessage(), new Integer( 180 ));
          case 1: return new ST(getMessage());
          case 2: return new TS(getMessage());
          case 3: return new CE(getMessage());
          case 4: return new Varies(getMessage());
          case 5: return new ID(getMessage(), new Integer( 355 ));
          default: return null;
       }
   }


}

