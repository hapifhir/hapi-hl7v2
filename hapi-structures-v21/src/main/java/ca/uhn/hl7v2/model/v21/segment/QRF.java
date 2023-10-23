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
 *<p>Represents an HL7 QRF message segment (QUERY FILTER). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>QRF-1: WHERE SUBJECT FILTER (ST) <b> repeating</b>
     * <li>QRF-2: WHEN DATA START DATE/TIME (TS) <b>optional </b>
     * <li>QRF-3: WHEN DATA END DATE/TIME (TS) <b>optional </b>
     * <li>QRF-4: WHAT USER QUALIFIER (ST) <b>optional repeating</b>
     * <li>QRF-5: OTHER QRY SUBJECT FILTER (ST) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class QRF extends AbstractSegment {

    /** 
     * Creates a new QRF segment
     */
    public QRF(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ST.class, true, 0, 20, new Object[]{ getMessage() }, "WHERE SUBJECT FILTER");
                                  this.add(TS.class, false, 1, 19, new Object[]{ getMessage() }, "WHEN DATA START DATE/TIME");
                                  this.add(TS.class, false, 1, 19, new Object[]{ getMessage() }, "WHEN DATA END DATE/TIME");
                                  this.add(ST.class, false, 0, 20, new Object[]{ getMessage() }, "WHAT USER QUALIFIER");
                                  this.add(ST.class, false, 0, 20, new Object[]{ getMessage() }, "OTHER QRY SUBJECT FILTER");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating QRF - this is probably a bug in the source code generator.", e);
       }
    }


    /**
     * Returns all repetitions of WHERE SUBJECT FILTER (QRF-1).
     */
    public ST[] getWHERESUBJECTFILTER() {
    	ST[] retVal = this.getTypedField(1, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of WHERE SUBJECT FILTER (QRF-1).
     */
    public ST[] getQrf1_WHERESUBJECTFILTER() {
    	ST[] retVal = this.getTypedField(1, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of WHERE SUBJECT FILTER (QRF-1).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getWHERESUBJECTFILTERReps() {
    	return this.getReps(1);
    }


    /**
     * Returns a specific repetition of
     * QRF-1: "WHERE SUBJECT FILTER" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getWHERESUBJECTFILTER(int rep) { 
		ST retVal = this.getTypedField(1, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * QRF-1: "WHERE SUBJECT FILTER" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getQrf1_WHERESUBJECTFILTER(int rep) { 
		ST retVal = this.getTypedField(1, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of WHERE SUBJECT FILTER (QRF-1).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getQrf1_WHERESUBJECTFILTERReps() {
    	return this.getReps(1);
    }


    /**
     * Inserts a repetition of
     * QRF-1: "WHERE SUBJECT FILTER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertWHERESUBJECTFILTER(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(1, rep);
    }


    /**
     * Inserts a repetition of
     * QRF-1: "WHERE SUBJECT FILTER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertQrf1_WHERESUBJECTFILTER(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(1, rep);
    }


    /**
     * Removes a repetition of
     * QRF-1: "WHERE SUBJECT FILTER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeWHERESUBJECTFILTER(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(1, rep);
    }


    /**
     * Removes a repetition of
     * QRF-1: "WHERE SUBJECT FILTER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeQrf1_WHERESUBJECTFILTER(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(1, rep);
    }




    /**
     * Returns
     * QRF-2: "WHEN DATA START DATE/TIME" - creates it if necessary
     */
    public TS getWHENDATASTARTDATETIME() { 
		TS retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * QRF-2: "WHEN DATA START DATE/TIME" - creates it if necessary
     */
    public TS getQrf2_WHENDATASTARTDATETIME() { 
		TS retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * QRF-3: "WHEN DATA END DATE/TIME" - creates it if necessary
     */
    public TS getWHENDATAENDDATETIME() { 
		TS retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * QRF-3: "WHEN DATA END DATE/TIME" - creates it if necessary
     */
    public TS getQrf3_WHENDATAENDDATETIME() { 
		TS retVal = this.getTypedField(3, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of WHAT USER QUALIFIER (QRF-4).
     */
    public ST[] getWHATUSERQUALIFIER() {
    	ST[] retVal = this.getTypedField(4, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of WHAT USER QUALIFIER (QRF-4).
     */
    public ST[] getQrf4_WHATUSERQUALIFIER() {
    	ST[] retVal = this.getTypedField(4, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of WHAT USER QUALIFIER (QRF-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getWHATUSERQUALIFIERReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * QRF-4: "WHAT USER QUALIFIER" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getWHATUSERQUALIFIER(int rep) { 
		ST retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * QRF-4: "WHAT USER QUALIFIER" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getQrf4_WHATUSERQUALIFIER(int rep) { 
		ST retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of WHAT USER QUALIFIER (QRF-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getQrf4_WHATUSERQUALIFIERReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * QRF-4: "WHAT USER QUALIFIER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertWHATUSERQUALIFIER(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * QRF-4: "WHAT USER QUALIFIER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertQrf4_WHATUSERQUALIFIER(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * QRF-4: "WHAT USER QUALIFIER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeWHATUSERQUALIFIER(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * QRF-4: "WHAT USER QUALIFIER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeQrf4_WHATUSERQUALIFIER(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(4, rep);
    }



    /**
     * Returns all repetitions of OTHER QRY SUBJECT FILTER (QRF-5).
     */
    public ST[] getOTHERQRYSUBJECTFILTER() {
    	ST[] retVal = this.getTypedField(5, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of OTHER QRY SUBJECT FILTER (QRF-5).
     */
    public ST[] getQrf5_OTHERQRYSUBJECTFILTER() {
    	ST[] retVal = this.getTypedField(5, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of OTHER QRY SUBJECT FILTER (QRF-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOTHERQRYSUBJECTFILTERReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * QRF-5: "OTHER QRY SUBJECT FILTER" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getOTHERQRYSUBJECTFILTER(int rep) { 
		ST retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * QRF-5: "OTHER QRY SUBJECT FILTER" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getQrf5_OTHERQRYSUBJECTFILTER(int rep) { 
		ST retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of OTHER QRY SUBJECT FILTER (QRF-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getQrf5_OTHERQRYSUBJECTFILTERReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * QRF-5: "OTHER QRY SUBJECT FILTER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertOTHERQRYSUBJECTFILTER(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * QRF-5: "OTHER QRY SUBJECT FILTER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertQrf5_OTHERQRYSUBJECTFILTER(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * QRF-5: "OTHER QRY SUBJECT FILTER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeOTHERQRYSUBJECTFILTER(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * QRF-5: "OTHER QRY SUBJECT FILTER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeQrf5_OTHERQRYSUBJECTFILTER(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(5, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ST(getMessage());
          case 1: return new TS(getMessage());
          case 2: return new TS(getMessage());
          case 3: return new ST(getMessage());
          case 4: return new ST(getMessage());
          default: return null;
       }
   }


}

