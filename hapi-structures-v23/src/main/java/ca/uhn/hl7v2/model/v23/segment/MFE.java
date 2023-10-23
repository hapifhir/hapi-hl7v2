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
 *<p>Represents an HL7 MFE message segment (Master file entry segment). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>MFE-1: Record-Level Event Code (ID) <b> </b>
     * <li>MFE-2: MFN Control ID (ST) <b>optional </b>
     * <li>MFE-3: Effective Date/Time (TS) <b>optional </b>
     * <li>MFE-4: Primary Key Value (CE) <b> repeating</b>
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
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "MFN Control ID");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Effective Date/Time");
                                  this.add(CE.class, true, 0, 60, new Object[]{ getMessage() }, "Primary Key Value");
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
    public TS getEffectiveDateTime() { 
		TS retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MFE-3: "Effective Date/Time" - creates it if necessary
     */
    public TS getMfe3_EffectiveDateTime() { 
		TS retVal = this.getTypedField(3, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Primary Key Value (MFE-4).
     */
    public CE[] getPrimaryKeyValue() {
    	CE[] retVal = this.getTypedField(4, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Primary Key Value (MFE-4).
     */
    public CE[] getMfe4_PrimaryKeyValue() {
    	CE[] retVal = this.getTypedField(4, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Primary Key Value (MFE-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPrimaryKeyValueReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * MFE-4: "Primary Key Value" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getPrimaryKeyValue(int rep) { 
		CE retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * MFE-4: "Primary Key Value" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getMfe4_PrimaryKeyValue(int rep) { 
		CE retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Primary Key Value (MFE-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getMfe4_PrimaryKeyValueReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * MFE-4: "Primary Key Value" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertPrimaryKeyValue(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * MFE-4: "Primary Key Value" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertMfe4_PrimaryKeyValue(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * MFE-4: "Primary Key Value" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removePrimaryKeyValue(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * MFE-4: "Primary Key Value" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeMfe4_PrimaryKeyValue(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(4, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ID(getMessage(), new Integer( 180 ));
          case 1: return new ST(getMessage());
          case 2: return new TS(getMessage());
          case 3: return new CE(getMessage());
          default: return null;
       }
   }


}

