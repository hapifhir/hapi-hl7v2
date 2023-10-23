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
 *<p>Represents an HL7 QRI message segment (Query Response Instance). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>QRI-1: Candidate Confidence (NM) <b>optional </b>
     * <li>QRI-2: Match Reason Code (IS) <b>optional repeating</b>
     * <li>QRI-3: Algorithm Descriptor (CE) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class QRI extends AbstractSegment {

    /** 
     * Creates a new QRI segment
     */
    public QRI(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(NM.class, false, 1, 10, new Object[]{ getMessage() }, "Candidate Confidence");
                                              this.add(IS.class, false, 0, 2, new Object[]{ getMessage(), new Integer(392) }, "Match Reason Code");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Algorithm Descriptor");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating QRI - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * QRI-1: "Candidate Confidence" - creates it if necessary
     */
    public NM getCandidateConfidence() { 
		NM retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * QRI-1: "Candidate Confidence" - creates it if necessary
     */
    public NM getQri1_CandidateConfidence() { 
		NM retVal = this.getTypedField(1, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Match Reason Code (QRI-2).
     */
    public IS[] getMatchReasonCode() {
    	IS[] retVal = this.getTypedField(2, new IS[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Match Reason Code (QRI-2).
     */
    public IS[] getQri2_MatchReasonCode() {
    	IS[] retVal = this.getTypedField(2, new IS[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Match Reason Code (QRI-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getMatchReasonCodeReps() {
    	return this.getReps(2);
    }


    /**
     * Returns a specific repetition of
     * QRI-2: "Match Reason Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getMatchReasonCode(int rep) { 
		IS retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * QRI-2: "Match Reason Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getQri2_MatchReasonCode(int rep) { 
		IS retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Match Reason Code (QRI-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getQri2_MatchReasonCodeReps() {
    	return this.getReps(2);
    }


    /**
     * Inserts a repetition of
     * QRI-2: "Match Reason Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertMatchReasonCode(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(2, rep);
    }


    /**
     * Inserts a repetition of
     * QRI-2: "Match Reason Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertQri2_MatchReasonCode(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * QRI-2: "Match Reason Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removeMatchReasonCode(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * QRI-2: "Match Reason Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removeQri2_MatchReasonCode(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(2, rep);
    }




    /**
     * Returns
     * QRI-3: "Algorithm Descriptor" - creates it if necessary
     */
    public CE getAlgorithmDescriptor() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * QRI-3: "Algorithm Descriptor" - creates it if necessary
     */
    public CE getQri3_AlgorithmDescriptor() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new NM(getMessage());
          case 1: return new IS(getMessage(), new Integer( 392 ));
          case 2: return new CE(getMessage());
          default: return null;
       }
   }


}

