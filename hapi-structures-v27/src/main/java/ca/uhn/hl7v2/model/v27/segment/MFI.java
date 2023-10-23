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


package ca.uhn.hl7v2.model.v27.segment;

// import ca.uhn.hl7v2.model.v27.group.*;
import ca.uhn.hl7v2.model.v27.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 MFI message segment (Master File Identification). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>MFI-1: Master File Identifier (CWE) <b> </b>
     * <li>MFI-2: Master File Application Identifier (HD) <b>optional repeating</b>
     * <li>MFI-3: File-Level Event Code (ID) <b> </b>
     * <li>MFI-4: Entered Date/Time (DTM) <b>optional </b>
     * <li>MFI-5: Effective Date/Time (DTM) <b>optional </b>
     * <li>MFI-6: Response Level Code (ID) <b> </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class MFI extends AbstractSegment {

    /** 
     * Creates a new MFI segment
     */
    public MFI(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Master File Identifier");
                                  this.add(HD.class, false, 0, 0, new Object[]{ getMessage() }, "Master File Application Identifier");
                                              this.add(ID.class, true, 1, 3, new Object[]{ getMessage(), new Integer(178) }, "File-Level Event Code");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Entered Date/Time");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Effective Date/Time");
                                              this.add(ID.class, true, 1, 2, new Object[]{ getMessage(), new Integer(179) }, "Response Level Code");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating MFI - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * MFI-1: "Master File Identifier" - creates it if necessary
     */
    public CWE getMasterFileIdentifier() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MFI-1: "Master File Identifier" - creates it if necessary
     */
    public CWE getMfi1_MasterFileIdentifier() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Master File Application Identifier (MFI-2).
     */
    public HD[] getMasterFileApplicationIdentifier() {
    	HD[] retVal = this.getTypedField(2, new HD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Master File Application Identifier (MFI-2).
     */
    public HD[] getMfi2_MasterFileApplicationIdentifier() {
    	HD[] retVal = this.getTypedField(2, new HD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Master File Application Identifier (MFI-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getMasterFileApplicationIdentifierReps() {
    	return this.getReps(2);
    }


    /**
     * Returns a specific repetition of
     * MFI-2: "Master File Application Identifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public HD getMasterFileApplicationIdentifier(int rep) { 
		HD retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * MFI-2: "Master File Application Identifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public HD getMfi2_MasterFileApplicationIdentifier(int rep) { 
		HD retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Master File Application Identifier (MFI-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getMfi2_MasterFileApplicationIdentifierReps() {
    	return this.getReps(2);
    }


    /**
     * Inserts a repetition of
     * MFI-2: "Master File Application Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public HD insertMasterFileApplicationIdentifier(int rep) throws HL7Exception { 
        return (HD) super.insertRepetition(2, rep);
    }


    /**
     * Inserts a repetition of
     * MFI-2: "Master File Application Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public HD insertMfi2_MasterFileApplicationIdentifier(int rep) throws HL7Exception { 
        return (HD) super.insertRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * MFI-2: "Master File Application Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public HD removeMasterFileApplicationIdentifier(int rep) throws HL7Exception { 
        return (HD) super.removeRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * MFI-2: "Master File Application Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public HD removeMfi2_MasterFileApplicationIdentifier(int rep) throws HL7Exception { 
        return (HD) super.removeRepetition(2, rep);
    }




    /**
     * Returns
     * MFI-3: "File-Level Event Code" - creates it if necessary
     */
    public ID getFileLevelEventCode() { 
		ID retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MFI-3: "File-Level Event Code" - creates it if necessary
     */
    public ID getMfi3_FileLevelEventCode() { 
		ID retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * MFI-4: "Entered Date/Time" - creates it if necessary
     */
    public DTM getEnteredDateTime() { 
		DTM retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MFI-4: "Entered Date/Time" - creates it if necessary
     */
    public DTM getMfi4_EnteredDateTime() { 
		DTM retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * MFI-5: "Effective Date/Time" - creates it if necessary
     */
    public DTM getEffectiveDateTime() { 
		DTM retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MFI-5: "Effective Date/Time" - creates it if necessary
     */
    public DTM getMfi5_EffectiveDateTime() { 
		DTM retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * MFI-6: "Response Level Code" - creates it if necessary
     */
    public ID getResponseLevelCode() { 
		ID retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MFI-6: "Response Level Code" - creates it if necessary
     */
    public ID getMfi6_ResponseLevelCode() { 
		ID retVal = this.getTypedField(6, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CWE(getMessage());
          case 1: return new HD(getMessage());
          case 2: return new ID(getMessage(), new Integer( 178 ));
          case 3: return new DTM(getMessage());
          case 4: return new DTM(getMessage());
          case 5: return new ID(getMessage(), new Integer( 179 ));
          default: return null;
       }
   }


}

