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
 *<p>Represents an HL7 QRD message segment (QUERY DEFINITION). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>QRD-1: Query date / time (TS) <b> </b>
     * <li>QRD-2: Query Format Code (ID) <b> </b>
     * <li>QRD-3: Query Priority (ID) <b> </b>
     * <li>QRD-4: Query ID (ST) <b> </b>
     * <li>QRD-5: Deferred Response Type (ID) <b>optional </b>
     * <li>QRD-6: Deferred response date / time (TS) <b>optional </b>
     * <li>QRD-7: Quantity Limited Request (CQ_QUANTITY) <b> </b>
     * <li>QRD-8: Who Subject Filter (ST) <b> repeating</b>
     * <li>QRD-9: What Subject Filter (ID) <b> repeating</b>
     * <li>QRD-10: What Department Data Code (ST) <b> repeating</b>
     * <li>QRD-11: What data code value qualifier (CM_VR) <b>optional repeating</b>
     * <li>QRD-12: Query Results Level (ID) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class QRD extends AbstractSegment {

    /** 
     * Creates a new QRD segment
     */
    public QRD(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(TS.class, true, 1, 26, new Object[]{ getMessage() }, "Query date / time");
                                              this.add(ID.class, true, 1, 1, new Object[]{ getMessage(), new Integer(106) }, "Query Format Code");
                                              this.add(ID.class, true, 1, 1, new Object[]{ getMessage(), new Integer(91) }, "Query Priority");
                                  this.add(ST.class, true, 1, 10, new Object[]{ getMessage() }, "Query ID");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(107) }, "Deferred Response Type");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Deferred response date / time");
                                  this.add(CQ_QUANTITY.class, true, 1, 10, new Object[]{ getMessage() }, "Quantity Limited Request");
                                  this.add(ST.class, true, 0, 20, new Object[]{ getMessage() }, "Who Subject Filter");
                                              this.add(ID.class, true, 0, 3, new Object[]{ getMessage(), new Integer(48) }, "What Subject Filter");
                                  this.add(ST.class, true, 0, 20, new Object[]{ getMessage() }, "What Department Data Code");
                                  this.add(CM_VR.class, false, 0, 20, new Object[]{ getMessage() }, "What data code value qualifier");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(108) }, "Query Results Level");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating QRD - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * QRD-1: "Query date / time" - creates it if necessary
     */
    public TS getQueryDateTime() { 
		TS retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * QRD-1: "Query date / time" - creates it if necessary
     */
    public TS getQrd1_QueryDateTime() { 
		TS retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * QRD-2: "Query Format Code" - creates it if necessary
     */
    public ID getQueryFormatCode() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * QRD-2: "Query Format Code" - creates it if necessary
     */
    public ID getQrd2_QueryFormatCode() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * QRD-3: "Query Priority" - creates it if necessary
     */
    public ID getQueryPriority() { 
		ID retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * QRD-3: "Query Priority" - creates it if necessary
     */
    public ID getQrd3_QueryPriority() { 
		ID retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * QRD-4: "Query ID" - creates it if necessary
     */
    public ST getQueryID() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * QRD-4: "Query ID" - creates it if necessary
     */
    public ST getQrd4_QueryID() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * QRD-5: "Deferred Response Type" - creates it if necessary
     */
    public ID getDeferredResponseType() { 
		ID retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * QRD-5: "Deferred Response Type" - creates it if necessary
     */
    public ID getQrd5_DeferredResponseType() { 
		ID retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * QRD-6: "Deferred response date / time" - creates it if necessary
     */
    public TS getDeferredResponseDateTime() { 
		TS retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * QRD-6: "Deferred response date / time" - creates it if necessary
     */
    public TS getQrd6_DeferredResponseDateTime() { 
		TS retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * QRD-7: "Quantity Limited Request" - creates it if necessary
     */
    public CQ_QUANTITY getQuantityLimitedRequest() { 
		CQ_QUANTITY retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * QRD-7: "Quantity Limited Request" - creates it if necessary
     */
    public CQ_QUANTITY getQrd7_QuantityLimitedRequest() { 
		CQ_QUANTITY retVal = this.getTypedField(7, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Who Subject Filter (QRD-8).
     */
    public ST[] getWhoSubjectFilter() {
    	ST[] retVal = this.getTypedField(8, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Who Subject Filter (QRD-8).
     */
    public ST[] getQrd8_WhoSubjectFilter() {
    	ST[] retVal = this.getTypedField(8, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Who Subject Filter (QRD-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getWhoSubjectFilterReps() {
    	return this.getReps(8);
    }


    /**
     * Returns a specific repetition of
     * QRD-8: "Who Subject Filter" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getWhoSubjectFilter(int rep) { 
		ST retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * QRD-8: "Who Subject Filter" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getQrd8_WhoSubjectFilter(int rep) { 
		ST retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Who Subject Filter (QRD-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getQrd8_WhoSubjectFilterReps() {
    	return this.getReps(8);
    }


    /**
     * Inserts a repetition of
     * QRD-8: "Who Subject Filter" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertWhoSubjectFilter(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(8, rep);
    }


    /**
     * Inserts a repetition of
     * QRD-8: "Who Subject Filter" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertQrd8_WhoSubjectFilter(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * QRD-8: "Who Subject Filter" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeWhoSubjectFilter(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * QRD-8: "Who Subject Filter" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeQrd8_WhoSubjectFilter(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(8, rep);
    }



    /**
     * Returns all repetitions of What Subject Filter (QRD-9).
     */
    public ID[] getWhatSubjectFilter() {
    	ID[] retVal = this.getTypedField(9, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of What Subject Filter (QRD-9).
     */
    public ID[] getQrd9_WhatSubjectFilter() {
    	ID[] retVal = this.getTypedField(9, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of What Subject Filter (QRD-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getWhatSubjectFilterReps() {
    	return this.getReps(9);
    }


    /**
     * Returns a specific repetition of
     * QRD-9: "What Subject Filter" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getWhatSubjectFilter(int rep) { 
		ID retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * QRD-9: "What Subject Filter" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getQrd9_WhatSubjectFilter(int rep) { 
		ID retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of What Subject Filter (QRD-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getQrd9_WhatSubjectFilterReps() {
    	return this.getReps(9);
    }


    /**
     * Inserts a repetition of
     * QRD-9: "What Subject Filter" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertWhatSubjectFilter(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(9, rep);
    }


    /**
     * Inserts a repetition of
     * QRD-9: "What Subject Filter" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertQrd9_WhatSubjectFilter(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * QRD-9: "What Subject Filter" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeWhatSubjectFilter(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * QRD-9: "What Subject Filter" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeQrd9_WhatSubjectFilter(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(9, rep);
    }



    /**
     * Returns all repetitions of What Department Data Code (QRD-10).
     */
    public ST[] getWhatDepartmentDataCode() {
    	ST[] retVal = this.getTypedField(10, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of What Department Data Code (QRD-10).
     */
    public ST[] getQrd10_WhatDepartmentDataCode() {
    	ST[] retVal = this.getTypedField(10, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of What Department Data Code (QRD-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getWhatDepartmentDataCodeReps() {
    	return this.getReps(10);
    }


    /**
     * Returns a specific repetition of
     * QRD-10: "What Department Data Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getWhatDepartmentDataCode(int rep) { 
		ST retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * QRD-10: "What Department Data Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getQrd10_WhatDepartmentDataCode(int rep) { 
		ST retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of What Department Data Code (QRD-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getQrd10_WhatDepartmentDataCodeReps() {
    	return this.getReps(10);
    }


    /**
     * Inserts a repetition of
     * QRD-10: "What Department Data Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertWhatDepartmentDataCode(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(10, rep);
    }


    /**
     * Inserts a repetition of
     * QRD-10: "What Department Data Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertQrd10_WhatDepartmentDataCode(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * QRD-10: "What Department Data Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeWhatDepartmentDataCode(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * QRD-10: "What Department Data Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeQrd10_WhatDepartmentDataCode(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(10, rep);
    }



    /**
     * Returns all repetitions of What data code value qualifier (QRD-11).
     */
    public CM_VR[] getWhatDataCodeValueQualifier() {
    	CM_VR[] retVal = this.getTypedField(11, new CM_VR[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of What data code value qualifier (QRD-11).
     */
    public CM_VR[] getQrd11_WhatDataCodeValueQualifier() {
    	CM_VR[] retVal = this.getTypedField(11, new CM_VR[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of What data code value qualifier (QRD-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getWhatDataCodeValueQualifierReps() {
    	return this.getReps(11);
    }


    /**
     * Returns a specific repetition of
     * QRD-11: "What data code value qualifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_VR getWhatDataCodeValueQualifier(int rep) { 
		CM_VR retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * QRD-11: "What data code value qualifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_VR getQrd11_WhatDataCodeValueQualifier(int rep) { 
		CM_VR retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of What data code value qualifier (QRD-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getQrd11_WhatDataCodeValueQualifierReps() {
    	return this.getReps(11);
    }


    /**
     * Inserts a repetition of
     * QRD-11: "What data code value qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_VR insertWhatDataCodeValueQualifier(int rep) throws HL7Exception { 
        return (CM_VR) super.insertRepetition(11, rep);
    }


    /**
     * Inserts a repetition of
     * QRD-11: "What data code value qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_VR insertQrd11_WhatDataCodeValueQualifier(int rep) throws HL7Exception { 
        return (CM_VR) super.insertRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * QRD-11: "What data code value qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_VR removeWhatDataCodeValueQualifier(int rep) throws HL7Exception { 
        return (CM_VR) super.removeRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * QRD-11: "What data code value qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_VR removeQrd11_WhatDataCodeValueQualifier(int rep) throws HL7Exception { 
        return (CM_VR) super.removeRepetition(11, rep);
    }




    /**
     * Returns
     * QRD-12: "Query Results Level" - creates it if necessary
     */
    public ID getQueryResultsLevel() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * QRD-12: "Query Results Level" - creates it if necessary
     */
    public ID getQrd12_QueryResultsLevel() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new TS(getMessage());
          case 1: return new ID(getMessage(), new Integer( 106 ));
          case 2: return new ID(getMessage(), new Integer( 91 ));
          case 3: return new ST(getMessage());
          case 4: return new ID(getMessage(), new Integer( 107 ));
          case 5: return new TS(getMessage());
          case 6: return new CQ_QUANTITY(getMessage());
          case 7: return new ST(getMessage());
          case 8: return new ID(getMessage(), new Integer( 48 ));
          case 9: return new ST(getMessage());
          case 10: return new CM_VR(getMessage());
          case 11: return new ID(getMessage(), new Integer( 108 ));
          default: return null;
       }
   }


}

