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


package ca.uhn.hl7v2.model.v25.segment;

// import ca.uhn.hl7v2.model.v25.group.*;
import ca.uhn.hl7v2.model.v25.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 ERQ message segment (Event replay query). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>ERQ-1: Query Tag (ST) <b>optional </b>
     * <li>ERQ-2: Event Identifier (CE) <b> </b>
     * <li>ERQ-3: Input Parameter List (QIP) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class ERQ extends AbstractSegment {

    /** 
     * Creates a new ERQ segment
     */
    public ERQ(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ST.class, false, 1, 32, new Object[]{ getMessage() }, "Query Tag");
                                  this.add(CE.class, true, 1, 250, new Object[]{ getMessage() }, "Event Identifier");
                                  this.add(QIP.class, false, 0, 256, new Object[]{ getMessage() }, "Input Parameter List");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating ERQ - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * ERQ-1: "Query Tag" - creates it if necessary
     */
    public ST getQueryTag() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ERQ-1: "Query Tag" - creates it if necessary
     */
    public ST getErq1_QueryTag() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * ERQ-2: "Event Identifier" - creates it if necessary
     */
    public CE getEventIdentifier() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ERQ-2: "Event Identifier" - creates it if necessary
     */
    public CE getErq2_EventIdentifier() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Input Parameter List (ERQ-3).
     */
    public QIP[] getInputParameterList() {
    	QIP[] retVal = this.getTypedField(3, new QIP[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Input Parameter List (ERQ-3).
     */
    public QIP[] getErq3_InputParameterList() {
    	QIP[] retVal = this.getTypedField(3, new QIP[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Input Parameter List (ERQ-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getInputParameterListReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * ERQ-3: "Input Parameter List" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public QIP getInputParameterList(int rep) { 
		QIP retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ERQ-3: "Input Parameter List" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public QIP getErq3_InputParameterList(int rep) { 
		QIP retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Input Parameter List (ERQ-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getErq3_InputParameterListReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * ERQ-3: "Input Parameter List" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public QIP insertInputParameterList(int rep) throws HL7Exception { 
        return (QIP) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * ERQ-3: "Input Parameter List" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public QIP insertErq3_InputParameterList(int rep) throws HL7Exception { 
        return (QIP) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * ERQ-3: "Input Parameter List" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public QIP removeInputParameterList(int rep) throws HL7Exception { 
        return (QIP) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * ERQ-3: "Input Parameter List" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public QIP removeErq3_InputParameterList(int rep) throws HL7Exception { 
        return (QIP) super.removeRepetition(3, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ST(getMessage());
          case 1: return new CE(getMessage());
          case 2: return new QIP(getMessage());
          default: return null;
       }
   }


}

