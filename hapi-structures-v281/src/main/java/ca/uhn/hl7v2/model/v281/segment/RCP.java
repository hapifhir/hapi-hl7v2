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
 *<p>Represents an HL7 RCP message segment (Response Control Parameter). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>RCP-1: Query Priority (ID) <b>optional </b>
     * <li>RCP-2: Quantity Limited Request (CQ) <b>optional </b>
     * <li>RCP-3: Response Modality (CNE) <b>optional </b>
     * <li>RCP-4: Execution and Delivery Time (DTM) <b>optional </b>
     * <li>RCP-5: Modify Indicator (ID) <b>optional </b>
     * <li>RCP-6: Sort-by Field (SRT) <b>optional repeating</b>
     * <li>RCP-7: Segment group inclusion (ID) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class RCP extends AbstractSegment {

    /** 
     * Creates a new RCP segment
     */
    public RCP(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(91) }, "Query Priority");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Quantity Limited Request");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Response Modality");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Execution and Delivery Time");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(395) }, "Modify Indicator");
                                  this.add(SRT.class, false, 0, 0, new Object[]{ getMessage() }, "Sort-by Field");
                                              this.add(ID.class, false, 0, 0, new Object[]{ getMessage(), new Integer(391) }, "Segment group inclusion");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating RCP - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * RCP-1: "Query Priority" - creates it if necessary
     */
    public ID getQueryPriority() { 
		ID retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RCP-1: "Query Priority" - creates it if necessary
     */
    public ID getRcp1_QueryPriority() { 
		ID retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * RCP-2: "Quantity Limited Request" - creates it if necessary
     */
    public CQ getQuantityLimitedRequest() { 
		CQ retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RCP-2: "Quantity Limited Request" - creates it if necessary
     */
    public CQ getRcp2_QuantityLimitedRequest() { 
		CQ retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * RCP-3: "Response Modality" - creates it if necessary
     */
    public CNE getResponseModality() { 
		CNE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RCP-3: "Response Modality" - creates it if necessary
     */
    public CNE getRcp3_ResponseModality() { 
		CNE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * RCP-4: "Execution and Delivery Time" - creates it if necessary
     */
    public DTM getExecutionAndDeliveryTime() { 
		DTM retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RCP-4: "Execution and Delivery Time" - creates it if necessary
     */
    public DTM getRcp4_ExecutionAndDeliveryTime() { 
		DTM retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * RCP-5: "Modify Indicator" - creates it if necessary
     */
    public ID getModifyIndicator() { 
		ID retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RCP-5: "Modify Indicator" - creates it if necessary
     */
    public ID getRcp5_ModifyIndicator() { 
		ID retVal = this.getTypedField(5, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Sort-by Field (RCP-6).
     */
    public SRT[] getSortByField() {
    	SRT[] retVal = this.getTypedField(6, new SRT[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Sort-by Field (RCP-6).
     */
    public SRT[] getRcp6_SortByField() {
    	SRT[] retVal = this.getTypedField(6, new SRT[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Sort-by Field (RCP-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSortByFieldReps() {
    	return this.getReps(6);
    }


    /**
     * Returns a specific repetition of
     * RCP-6: "Sort-by Field" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public SRT getSortByField(int rep) { 
		SRT retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RCP-6: "Sort-by Field" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public SRT getRcp6_SortByField(int rep) { 
		SRT retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Sort-by Field (RCP-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRcp6_SortByFieldReps() {
    	return this.getReps(6);
    }


    /**
     * Inserts a repetition of
     * RCP-6: "Sort-by Field" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public SRT insertSortByField(int rep) throws HL7Exception { 
        return (SRT) super.insertRepetition(6, rep);
    }


    /**
     * Inserts a repetition of
     * RCP-6: "Sort-by Field" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public SRT insertRcp6_SortByField(int rep) throws HL7Exception { 
        return (SRT) super.insertRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * RCP-6: "Sort-by Field" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public SRT removeSortByField(int rep) throws HL7Exception { 
        return (SRT) super.removeRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * RCP-6: "Sort-by Field" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public SRT removeRcp6_SortByField(int rep) throws HL7Exception { 
        return (SRT) super.removeRepetition(6, rep);
    }



    /**
     * Returns all repetitions of Segment group inclusion (RCP-7).
     */
    public ID[] getSegmentGroupInclusion() {
    	ID[] retVal = this.getTypedField(7, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Segment group inclusion (RCP-7).
     */
    public ID[] getRcp7_SegmentGroupInclusion() {
    	ID[] retVal = this.getTypedField(7, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Segment group inclusion (RCP-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSegmentGroupInclusionReps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * RCP-7: "Segment group inclusion" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getSegmentGroupInclusion(int rep) { 
		ID retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RCP-7: "Segment group inclusion" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getRcp7_SegmentGroupInclusion(int rep) { 
		ID retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Segment group inclusion (RCP-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRcp7_SegmentGroupInclusionReps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * RCP-7: "Segment group inclusion" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertSegmentGroupInclusion(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * RCP-7: "Segment group inclusion" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertRcp7_SegmentGroupInclusion(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * RCP-7: "Segment group inclusion" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeSegmentGroupInclusion(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * RCP-7: "Segment group inclusion" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeRcp7_SegmentGroupInclusion(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(7, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ID(getMessage(), new Integer( 91 ));
          case 1: return new CQ(getMessage());
          case 2: return new CNE(getMessage());
          case 3: return new DTM(getMessage());
          case 4: return new ID(getMessage(), new Integer( 395 ));
          case 5: return new SRT(getMessage());
          case 6: return new ID(getMessage(), new Integer( 391 ));
          default: return null;
       }
   }


}

