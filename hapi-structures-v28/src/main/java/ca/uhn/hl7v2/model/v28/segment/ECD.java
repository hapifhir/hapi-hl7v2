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
 *<p>Represents an HL7 ECD message segment (Equipment Command). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>ECD-1: Reference Command Number (NM) <b> </b>
     * <li>ECD-2: Remote Control Command (CWE) <b> </b>
     * <li>ECD-3: Response Required (ID) <b>optional </b>
     * <li>ECD-4: Requested Completion Time (NULLDT) <b>optional </b>
     * <li>ECD-5: Parameters (TX) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class ECD extends AbstractSegment {

    /** 
     * Creates a new ECD segment
     */
    public ECD(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(NM.class, true, 1, 0, new Object[]{ getMessage() }, "Reference Command Number");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Remote Control Command");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Response Required");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Requested Completion Time");
                                  this.add(TX.class, false, 0, 0, new Object[]{ getMessage() }, "Parameters");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating ECD - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * ECD-1: "Reference Command Number" - creates it if necessary
     */
    public NM getReferenceCommandNumber() { 
		NM retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ECD-1: "Reference Command Number" - creates it if necessary
     */
    public NM getEcd1_ReferenceCommandNumber() { 
		NM retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * ECD-2: "Remote Control Command" - creates it if necessary
     */
    public CWE getRemoteControlCommand() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ECD-2: "Remote Control Command" - creates it if necessary
     */
    public CWE getEcd2_RemoteControlCommand() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * ECD-3: "Response Required" - creates it if necessary
     */
    public ID getResponseRequired() { 
		ID retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ECD-3: "Response Required" - creates it if necessary
     */
    public ID getEcd3_ResponseRequired() { 
		ID retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * ECD-4: "Requested Completion Time" - creates it if necessary
     */
    public NULLDT getRequestedCompletionTime() { 
		NULLDT retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ECD-4: "Requested Completion Time" - creates it if necessary
     */
    public NULLDT getEcd4_RequestedCompletionTime() { 
		NULLDT retVal = this.getTypedField(4, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Parameters (ECD-5).
     */
    public TX[] getParameters() {
    	TX[] retVal = this.getTypedField(5, new TX[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Parameters (ECD-5).
     */
    public TX[] getEcd5_Parameters() {
    	TX[] retVal = this.getTypedField(5, new TX[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Parameters (ECD-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getParametersReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * ECD-5: "Parameters" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TX getParameters(int rep) { 
		TX retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ECD-5: "Parameters" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TX getEcd5_Parameters(int rep) { 
		TX retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Parameters (ECD-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getEcd5_ParametersReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * ECD-5: "Parameters" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX insertParameters(int rep) throws HL7Exception { 
        return (TX) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * ECD-5: "Parameters" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX insertEcd5_Parameters(int rep) throws HL7Exception { 
        return (TX) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * ECD-5: "Parameters" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX removeParameters(int rep) throws HL7Exception { 
        return (TX) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * ECD-5: "Parameters" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX removeEcd5_Parameters(int rep) throws HL7Exception { 
        return (TX) super.removeRepetition(5, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new NM(getMessage());
          case 1: return new CWE(getMessage());
          case 2: return new ID(getMessage(), new Integer( 136 ));
          case 3: return new NULLDT(getMessage());
          case 4: return new TX(getMessage());
          default: return null;
       }
   }


}

