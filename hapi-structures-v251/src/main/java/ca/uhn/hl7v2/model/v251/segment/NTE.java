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
 *<p>Represents an HL7 NTE message segment (Notes and Comments). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>NTE-1: Set ID - NTE (SI) <b>optional </b>
     * <li>NTE-2: Source of Comment (ID) <b>optional </b>
     * <li>NTE-3: Comment (FT) <b>optional repeating</b>
     * <li>NTE-4: Comment Type (CE) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class NTE extends AbstractSegment {

    /** 
     * Creates a new NTE segment
     */
    public NTE(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, false, 1, 4, new Object[]{ getMessage() }, "Set ID - NTE");
                                              this.add(ID.class, false, 1, 8, new Object[]{ getMessage(), new Integer(105) }, "Source of Comment");
                                  this.add(FT.class, false, 0, 65536, new Object[]{ getMessage() }, "Comment");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Comment Type");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating NTE - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * NTE-1: "Set ID - NTE" - creates it if necessary
     */
    public SI getSetIDNTE() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NTE-1: "Set ID - NTE" - creates it if necessary
     */
    public SI getNte1_SetIDNTE() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * NTE-2: "Source of Comment" - creates it if necessary
     */
    public ID getSourceOfComment() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NTE-2: "Source of Comment" - creates it if necessary
     */
    public ID getNte2_SourceOfComment() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Comment (NTE-3).
     */
    public FT[] getComment() {
    	FT[] retVal = this.getTypedField(3, new FT[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Comment (NTE-3).
     */
    public FT[] getNte3_Comment() {
    	FT[] retVal = this.getTypedField(3, new FT[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Comment (NTE-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCommentReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * NTE-3: "Comment" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public FT getComment(int rep) { 
		FT retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * NTE-3: "Comment" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public FT getNte3_Comment(int rep) { 
		FT retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Comment (NTE-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getNte3_CommentReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * NTE-3: "Comment" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public FT insertComment(int rep) throws HL7Exception { 
        return (FT) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * NTE-3: "Comment" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public FT insertNte3_Comment(int rep) throws HL7Exception { 
        return (FT) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * NTE-3: "Comment" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public FT removeComment(int rep) throws HL7Exception { 
        return (FT) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * NTE-3: "Comment" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public FT removeNte3_Comment(int rep) throws HL7Exception { 
        return (FT) super.removeRepetition(3, rep);
    }




    /**
     * Returns
     * NTE-4: "Comment Type" - creates it if necessary
     */
    public CE getCommentType() { 
		CE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NTE-4: "Comment Type" - creates it if necessary
     */
    public CE getNte4_CommentType() { 
		CE retVal = this.getTypedField(4, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new ID(getMessage(), new Integer( 105 ));
          case 2: return new FT(getMessage());
          case 3: return new CE(getMessage());
          default: return null;
       }
   }


}

