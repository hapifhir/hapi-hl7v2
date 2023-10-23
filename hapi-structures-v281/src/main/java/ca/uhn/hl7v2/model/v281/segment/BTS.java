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
 *<p>Represents an HL7 BTS message segment (Batch Trailer). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>BTS-1: Batch Message Count (ST) <b>optional </b>
     * <li>BTS-2: Batch Comment (ST) <b>optional </b>
     * <li>BTS-3: Batch Totals (NM) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class BTS extends AbstractSegment {

    /** 
     * Creates a new BTS segment
     */
    public BTS(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Batch Message Count");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Batch Comment");
                                  this.add(NM.class, false, 0, 0, new Object[]{ getMessage() }, "Batch Totals");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating BTS - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * BTS-1: "Batch Message Count" - creates it if necessary
     */
    public ST getBatchMessageCount() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BTS-1: "Batch Message Count" - creates it if necessary
     */
    public ST getBts1_BatchMessageCount() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * BTS-2: "Batch Comment" - creates it if necessary
     */
    public ST getBatchComment() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BTS-2: "Batch Comment" - creates it if necessary
     */
    public ST getBts2_BatchComment() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Batch Totals (BTS-3).
     */
    public NM[] getBatchTotals() {
    	NM[] retVal = this.getTypedField(3, new NM[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Batch Totals (BTS-3).
     */
    public NM[] getBts3_BatchTotals() {
    	NM[] retVal = this.getTypedField(3, new NM[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Batch Totals (BTS-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getBatchTotalsReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * BTS-3: "Batch Totals" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public NM getBatchTotals(int rep) { 
		NM retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * BTS-3: "Batch Totals" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public NM getBts3_BatchTotals(int rep) { 
		NM retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Batch Totals (BTS-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getBts3_BatchTotalsReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * BTS-3: "Batch Totals" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM insertBatchTotals(int rep) throws HL7Exception { 
        return (NM) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * BTS-3: "Batch Totals" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM insertBts3_BatchTotals(int rep) throws HL7Exception { 
        return (NM) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * BTS-3: "Batch Totals" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM removeBatchTotals(int rep) throws HL7Exception { 
        return (NM) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * BTS-3: "Batch Totals" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM removeBts3_BatchTotals(int rep) throws HL7Exception { 
        return (NM) super.removeRepetition(3, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ST(getMessage());
          case 1: return new ST(getMessage());
          case 2: return new NM(getMessage());
          default: return null;
       }
   }


}

