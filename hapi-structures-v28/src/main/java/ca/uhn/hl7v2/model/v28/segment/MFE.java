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


package ca.uhn.hl7v2.model.v28.segment;

// import ca.uhn.hl7v2.model.v28.group.*;
import ca.uhn.hl7v2.model.v28.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 MFE message segment (Master File Entry). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>MFE-1: Record-Level Event Code (ID) <b> </b>
     * <li>MFE-2: MFN Control ID (ST) <b>optional </b>
     * <li>MFE-3: Effective Date/Time (DTM) <b>optional </b>
     * <li>MFE-4: Primary Key Value - MFE (Varies) <b> repeating</b>
     * <li>MFE-5: Primary Key Value Type (ID) <b> repeating</b>
     * <li>MFE-6: Entered Date/Time (DTM) <b>optional </b>
     * <li>MFE-7: Entered By (XCN) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class MFE extends AbstractSegment {

    /** 
     * Creates a new MFE segment
     */
    public MFE(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                              this.add(ID.class, true, 1, 3, new Object[]{ getMessage(), new Integer(180) }, "Record-Level Event Code");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "MFN Control ID");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Effective Date/Time");
                                  this.add(Varies.class, true, 0, 0, new Object[]{ getMessage() }, "Primary Key Value - MFE");
                                              this.add(ID.class, true, 0, 3, new Object[]{ getMessage(), new Integer(355) }, "Primary Key Value Type");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Entered Date/Time");
                                  this.add(XCN.class, false, 1, 0, new Object[]{ getMessage() }, "Entered By");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating MFE - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * MFE-1: "Record-Level Event Code" - creates it if necessary
     */
    public ID getRecordLevelEventCode() { 
		ID retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MFE-1: "Record-Level Event Code" - creates it if necessary
     */
    public ID getMfe1_RecordLevelEventCode() { 
		ID retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * MFE-2: "MFN Control ID" - creates it if necessary
     */
    public ST getMFNControlID() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MFE-2: "MFN Control ID" - creates it if necessary
     */
    public ST getMfe2_MFNControlID() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * MFE-3: "Effective Date/Time" - creates it if necessary
     */
    public DTM getEffectiveDateTime() { 
		DTM retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MFE-3: "Effective Date/Time" - creates it if necessary
     */
    public DTM getMfe3_EffectiveDateTime() { 
		DTM retVal = this.getTypedField(3, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Primary Key Value - MFE (MFE-4).
     */
    public Varies[] getPrimaryKeyValueMFE() {
    	Varies[] retVal = this.getTypedField(4, new Varies[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Primary Key Value - MFE (MFE-4).
     */
    public Varies[] getMfe4_PrimaryKeyValueMFE() {
    	Varies[] retVal = this.getTypedField(4, new Varies[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Primary Key Value - MFE (MFE-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPrimaryKeyValueMFEReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * MFE-4: "Primary Key Value - MFE" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public Varies getPrimaryKeyValueMFE(int rep) { 
		Varies retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * MFE-4: "Primary Key Value - MFE" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public Varies getMfe4_PrimaryKeyValueMFE(int rep) { 
		Varies retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Primary Key Value - MFE (MFE-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getMfe4_PrimaryKeyValueMFEReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * MFE-4: "Primary Key Value - MFE" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public Varies insertPrimaryKeyValueMFE(int rep) throws HL7Exception { 
        return (Varies) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * MFE-4: "Primary Key Value - MFE" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public Varies insertMfe4_PrimaryKeyValueMFE(int rep) throws HL7Exception { 
        return (Varies) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * MFE-4: "Primary Key Value - MFE" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public Varies removePrimaryKeyValueMFE(int rep) throws HL7Exception { 
        return (Varies) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * MFE-4: "Primary Key Value - MFE" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public Varies removeMfe4_PrimaryKeyValueMFE(int rep) throws HL7Exception { 
        return (Varies) super.removeRepetition(4, rep);
    }



    /**
     * Returns all repetitions of Primary Key Value Type (MFE-5).
     */
    public ID[] getPrimaryKeyValueType() {
    	ID[] retVal = this.getTypedField(5, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Primary Key Value Type (MFE-5).
     */
    public ID[] getMfe5_PrimaryKeyValueType() {
    	ID[] retVal = this.getTypedField(5, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Primary Key Value Type (MFE-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPrimaryKeyValueTypeReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * MFE-5: "Primary Key Value Type" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getPrimaryKeyValueType(int rep) { 
		ID retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * MFE-5: "Primary Key Value Type" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getMfe5_PrimaryKeyValueType(int rep) { 
		ID retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Primary Key Value Type (MFE-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getMfe5_PrimaryKeyValueTypeReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * MFE-5: "Primary Key Value Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertPrimaryKeyValueType(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * MFE-5: "Primary Key Value Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertMfe5_PrimaryKeyValueType(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * MFE-5: "Primary Key Value Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removePrimaryKeyValueType(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * MFE-5: "Primary Key Value Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeMfe5_PrimaryKeyValueType(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(5, rep);
    }




    /**
     * Returns
     * MFE-6: "Entered Date/Time" - creates it if necessary
     */
    public DTM getEnteredDateTime() { 
		DTM retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MFE-6: "Entered Date/Time" - creates it if necessary
     */
    public DTM getMfe6_EnteredDateTime() { 
		DTM retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * MFE-7: "Entered By" - creates it if necessary
     */
    public XCN getEnteredBy() { 
		XCN retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MFE-7: "Entered By" - creates it if necessary
     */
    public XCN getMfe7_EnteredBy() { 
		XCN retVal = this.getTypedField(7, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ID(getMessage(), new Integer( 180 ));
          case 1: return new ST(getMessage());
          case 2: return new DTM(getMessage());
          case 3: return new Varies(getMessage());
          case 4: return new ID(getMessage(), new Integer( 355 ));
          case 5: return new DTM(getMessage());
          case 6: return new XCN(getMessage());
          default: return null;
       }
   }


}

