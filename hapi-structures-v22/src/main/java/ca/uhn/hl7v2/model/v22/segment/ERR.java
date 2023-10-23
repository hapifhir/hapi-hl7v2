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
 *<p>Represents an HL7 ERR message segment (ERROR). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>ERR-1: Error Code and Location (CM_ELD) <b> repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class ERR extends AbstractSegment {

    /** 
     * Creates a new ERR segment
     */
    public ERR(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CM_ELD.class, true, 0, 80, new Object[]{ getMessage() }, "Error Code and Location");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating ERR - this is probably a bug in the source code generator.", e);
       }
    }


    /**
     * Returns all repetitions of Error Code and Location (ERR-1).
     */
    public CM_ELD[] getErrorCodeAndLocation() {
    	CM_ELD[] retVal = this.getTypedField(1, new CM_ELD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Error Code and Location (ERR-1).
     */
    public CM_ELD[] getErr1_ErrorCodeAndLocation() {
    	CM_ELD[] retVal = this.getTypedField(1, new CM_ELD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Error Code and Location (ERR-1).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getErrorCodeAndLocationReps() {
    	return this.getReps(1);
    }


    /**
     * Returns a specific repetition of
     * ERR-1: "Error Code and Location" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_ELD getErrorCodeAndLocation(int rep) { 
		CM_ELD retVal = this.getTypedField(1, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ERR-1: "Error Code and Location" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_ELD getErr1_ErrorCodeAndLocation(int rep) { 
		CM_ELD retVal = this.getTypedField(1, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Error Code and Location (ERR-1).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getErr1_ErrorCodeAndLocationReps() {
    	return this.getReps(1);
    }


    /**
     * Inserts a repetition of
     * ERR-1: "Error Code and Location" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_ELD insertErrorCodeAndLocation(int rep) throws HL7Exception { 
        return (CM_ELD) super.insertRepetition(1, rep);
    }


    /**
     * Inserts a repetition of
     * ERR-1: "Error Code and Location" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_ELD insertErr1_ErrorCodeAndLocation(int rep) throws HL7Exception { 
        return (CM_ELD) super.insertRepetition(1, rep);
    }


    /**
     * Removes a repetition of
     * ERR-1: "Error Code and Location" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_ELD removeErrorCodeAndLocation(int rep) throws HL7Exception { 
        return (CM_ELD) super.removeRepetition(1, rep);
    }


    /**
     * Removes a repetition of
     * ERR-1: "Error Code and Location" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_ELD removeErr1_ErrorCodeAndLocation(int rep) throws HL7Exception { 
        return (CM_ELD) super.removeRepetition(1, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CM_ELD(getMessage());
          default: return null;
       }
   }


}

