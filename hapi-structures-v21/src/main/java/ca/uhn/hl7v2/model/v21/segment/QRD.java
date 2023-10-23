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


package ca.uhn.hl7v2.model.v21.segment;

// import ca.uhn.hl7v2.model.v21.group.*;
import ca.uhn.hl7v2.model.v21.datatype.*;
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
     * <li>QRD-1: QUERY DATE/TIME (TS) <b> </b>
     * <li>QRD-2: QUERY FORMAT CODE (ID) <b> </b>
     * <li>QRD-3: QUERY PRIORITY (ID) <b> </b>
     * <li>QRD-4: QUERY ID (ST) <b> </b>
     * <li>QRD-5: DEFERRED RESPONSE TYPE (ID) <b>optional </b>
     * <li>QRD-6: DEFERRED RESPONSE DATE/TIME (TS) <b>optional </b>
     * <li>QRD-7: QUANTITY LIMITED REQUEST (CQ) <b> </b>
     * <li>QRD-8: WHO SUBJECT FILTER (ST) <b> repeating</b>
     * <li>QRD-9: WHAT SUBJECT FILTER (ID) <b> repeating</b>
     * <li>QRD-10: WHAT DEPARTMENT DATA CODE (ST) <b> repeating</b>
     * <li>QRD-11: WHAT DATA CODE VALUE QUAL. (ST) <b>optional repeating</b>
     * <li>QRD-12: QUERY RESULTS LEVEL (ID) <b>optional </b>
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
                                  this.add(TS.class, true, 1, 19, new Object[]{ getMessage() }, "QUERY DATE/TIME");
                                              this.add(ID.class, true, 1, 1, new Object[]{ getMessage(), new Integer(106) }, "QUERY FORMAT CODE");
                                              this.add(ID.class, true, 1, 1, new Object[]{ getMessage(), new Integer(91) }, "QUERY PRIORITY");
                                  this.add(ST.class, true, 1, 10, new Object[]{ getMessage() }, "QUERY ID");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(107) }, "DEFERRED RESPONSE TYPE");
                                  this.add(TS.class, false, 1, 19, new Object[]{ getMessage() }, "DEFERRED RESPONSE DATE/TIME");
                                  this.add(CQ.class, true, 1, 5, new Object[]{ getMessage() }, "QUANTITY LIMITED REQUEST");
                                  this.add(ST.class, true, 0, 20, new Object[]{ getMessage() }, "WHO SUBJECT FILTER");
                                              this.add(ID.class, true, 0, 3, new Object[]{ getMessage(), new Integer(48) }, "WHAT SUBJECT FILTER");
                                  this.add(ST.class, true, 0, 20, new Object[]{ getMessage() }, "WHAT DEPARTMENT DATA CODE");
                                  this.add(ST.class, false, 0, 20, new Object[]{ getMessage() }, "WHAT DATA CODE VALUE QUAL.");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(108) }, "QUERY RESULTS LEVEL");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating QRD - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * QRD-1: "QUERY DATE/TIME" - creates it if necessary
     */
    public TS getQUERYDATETIME() { 
		TS retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * QRD-1: "QUERY DATE/TIME" - creates it if necessary
     */
    public TS getQrd1_QUERYDATETIME() { 
		TS retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * QRD-2: "QUERY FORMAT CODE" - creates it if necessary
     */
    public ID getQUERYFORMATCODE() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * QRD-2: "QUERY FORMAT CODE" - creates it if necessary
     */
    public ID getQrd2_QUERYFORMATCODE() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * QRD-3: "QUERY PRIORITY" - creates it if necessary
     */
    public ID getQUERYPRIORITY() { 
		ID retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * QRD-3: "QUERY PRIORITY" - creates it if necessary
     */
    public ID getQrd3_QUERYPRIORITY() { 
		ID retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * QRD-4: "QUERY ID" - creates it if necessary
     */
    public ST getQUERYID() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * QRD-4: "QUERY ID" - creates it if necessary
     */
    public ST getQrd4_QUERYID() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * QRD-5: "DEFERRED RESPONSE TYPE" - creates it if necessary
     */
    public ID getDEFERREDRESPONSETYPE() { 
		ID retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * QRD-5: "DEFERRED RESPONSE TYPE" - creates it if necessary
     */
    public ID getQrd5_DEFERREDRESPONSETYPE() { 
		ID retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * QRD-6: "DEFERRED RESPONSE DATE/TIME" - creates it if necessary
     */
    public TS getDEFERREDRESPONSEDATETIME() { 
		TS retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * QRD-6: "DEFERRED RESPONSE DATE/TIME" - creates it if necessary
     */
    public TS getQrd6_DEFERREDRESPONSEDATETIME() { 
		TS retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * QRD-7: "QUANTITY LIMITED REQUEST" - creates it if necessary
     */
    public CQ getQUANTITYLIMITEDREQUEST() { 
		CQ retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * QRD-7: "QUANTITY LIMITED REQUEST" - creates it if necessary
     */
    public CQ getQrd7_QUANTITYLIMITEDREQUEST() { 
		CQ retVal = this.getTypedField(7, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of WHO SUBJECT FILTER (QRD-8).
     */
    public ST[] getWHOSUBJECTFILTER() {
    	ST[] retVal = this.getTypedField(8, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of WHO SUBJECT FILTER (QRD-8).
     */
    public ST[] getQrd8_WHOSUBJECTFILTER() {
    	ST[] retVal = this.getTypedField(8, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of WHO SUBJECT FILTER (QRD-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getWHOSUBJECTFILTERReps() {
    	return this.getReps(8);
    }


    /**
     * Returns a specific repetition of
     * QRD-8: "WHO SUBJECT FILTER" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getWHOSUBJECTFILTER(int rep) { 
		ST retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * QRD-8: "WHO SUBJECT FILTER" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getQrd8_WHOSUBJECTFILTER(int rep) { 
		ST retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of WHO SUBJECT FILTER (QRD-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getQrd8_WHOSUBJECTFILTERReps() {
    	return this.getReps(8);
    }


    /**
     * Inserts a repetition of
     * QRD-8: "WHO SUBJECT FILTER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertWHOSUBJECTFILTER(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(8, rep);
    }


    /**
     * Inserts a repetition of
     * QRD-8: "WHO SUBJECT FILTER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertQrd8_WHOSUBJECTFILTER(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * QRD-8: "WHO SUBJECT FILTER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeWHOSUBJECTFILTER(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * QRD-8: "WHO SUBJECT FILTER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeQrd8_WHOSUBJECTFILTER(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(8, rep);
    }



    /**
     * Returns all repetitions of WHAT SUBJECT FILTER (QRD-9).
     */
    public ID[] getWHATSUBJECTFILTER() {
    	ID[] retVal = this.getTypedField(9, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of WHAT SUBJECT FILTER (QRD-9).
     */
    public ID[] getQrd9_WHATSUBJECTFILTER() {
    	ID[] retVal = this.getTypedField(9, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of WHAT SUBJECT FILTER (QRD-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getWHATSUBJECTFILTERReps() {
    	return this.getReps(9);
    }


    /**
     * Returns a specific repetition of
     * QRD-9: "WHAT SUBJECT FILTER" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getWHATSUBJECTFILTER(int rep) { 
		ID retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * QRD-9: "WHAT SUBJECT FILTER" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getQrd9_WHATSUBJECTFILTER(int rep) { 
		ID retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of WHAT SUBJECT FILTER (QRD-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getQrd9_WHATSUBJECTFILTERReps() {
    	return this.getReps(9);
    }


    /**
     * Inserts a repetition of
     * QRD-9: "WHAT SUBJECT FILTER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertWHATSUBJECTFILTER(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(9, rep);
    }


    /**
     * Inserts a repetition of
     * QRD-9: "WHAT SUBJECT FILTER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertQrd9_WHATSUBJECTFILTER(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * QRD-9: "WHAT SUBJECT FILTER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeWHATSUBJECTFILTER(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * QRD-9: "WHAT SUBJECT FILTER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeQrd9_WHATSUBJECTFILTER(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(9, rep);
    }



    /**
     * Returns all repetitions of WHAT DEPARTMENT DATA CODE (QRD-10).
     */
    public ST[] getWHATDEPARTMENTDATACODE() {
    	ST[] retVal = this.getTypedField(10, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of WHAT DEPARTMENT DATA CODE (QRD-10).
     */
    public ST[] getQrd10_WHATDEPARTMENTDATACODE() {
    	ST[] retVal = this.getTypedField(10, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of WHAT DEPARTMENT DATA CODE (QRD-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getWHATDEPARTMENTDATACODEReps() {
    	return this.getReps(10);
    }


    /**
     * Returns a specific repetition of
     * QRD-10: "WHAT DEPARTMENT DATA CODE" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getWHATDEPARTMENTDATACODE(int rep) { 
		ST retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * QRD-10: "WHAT DEPARTMENT DATA CODE" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getQrd10_WHATDEPARTMENTDATACODE(int rep) { 
		ST retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of WHAT DEPARTMENT DATA CODE (QRD-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getQrd10_WHATDEPARTMENTDATACODEReps() {
    	return this.getReps(10);
    }


    /**
     * Inserts a repetition of
     * QRD-10: "WHAT DEPARTMENT DATA CODE" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertWHATDEPARTMENTDATACODE(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(10, rep);
    }


    /**
     * Inserts a repetition of
     * QRD-10: "WHAT DEPARTMENT DATA CODE" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertQrd10_WHATDEPARTMENTDATACODE(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * QRD-10: "WHAT DEPARTMENT DATA CODE" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeWHATDEPARTMENTDATACODE(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * QRD-10: "WHAT DEPARTMENT DATA CODE" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeQrd10_WHATDEPARTMENTDATACODE(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(10, rep);
    }



    /**
     * Returns all repetitions of WHAT DATA CODE VALUE QUAL. (QRD-11).
     */
    public ST[] getWHATDATACODEVALUEQUAL() {
    	ST[] retVal = this.getTypedField(11, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of WHAT DATA CODE VALUE QUAL. (QRD-11).
     */
    public ST[] getQrd11_WHATDATACODEVALUEQUAL() {
    	ST[] retVal = this.getTypedField(11, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of WHAT DATA CODE VALUE QUAL. (QRD-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getWHATDATACODEVALUEQUALReps() {
    	return this.getReps(11);
    }


    /**
     * Returns a specific repetition of
     * QRD-11: "WHAT DATA CODE VALUE QUAL." - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getWHATDATACODEVALUEQUAL(int rep) { 
		ST retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * QRD-11: "WHAT DATA CODE VALUE QUAL." - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getQrd11_WHATDATACODEVALUEQUAL(int rep) { 
		ST retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of WHAT DATA CODE VALUE QUAL. (QRD-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getQrd11_WHATDATACODEVALUEQUALReps() {
    	return this.getReps(11);
    }


    /**
     * Inserts a repetition of
     * QRD-11: "WHAT DATA CODE VALUE QUAL." at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertWHATDATACODEVALUEQUAL(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(11, rep);
    }


    /**
     * Inserts a repetition of
     * QRD-11: "WHAT DATA CODE VALUE QUAL." at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertQrd11_WHATDATACODEVALUEQUAL(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * QRD-11: "WHAT DATA CODE VALUE QUAL." at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeWHATDATACODEVALUEQUAL(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * QRD-11: "WHAT DATA CODE VALUE QUAL." at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeQrd11_WHATDATACODEVALUEQUAL(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(11, rep);
    }




    /**
     * Returns
     * QRD-12: "QUERY RESULTS LEVEL" - creates it if necessary
     */
    public ID getQUERYRESULTSLEVEL() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * QRD-12: "QUERY RESULTS LEVEL" - creates it if necessary
     */
    public ID getQrd12_QUERYRESULTSLEVEL() { 
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
          case 6: return new CQ(getMessage());
          case 7: return new ST(getMessage());
          case 8: return new ID(getMessage(), new Integer( 48 ));
          case 9: return new ST(getMessage());
          case 10: return new ST(getMessage());
          case 11: return new ID(getMessage(), new Integer( 108 ));
          default: return null;
       }
   }


}

