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


package ca.uhn.hl7v2.model.v26.segment;

// import ca.uhn.hl7v2.model.v26.group.*;
import ca.uhn.hl7v2.model.v26.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 VAR message segment (Variance). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>VAR-1: Variance Instance ID (EI) <b> </b>
     * <li>VAR-2: Documented Date/Time (DTM) <b> </b>
     * <li>VAR-3: Stated Variance Date/Time (DTM) <b>optional </b>
     * <li>VAR-4: Variance Originator (XCN) <b>optional repeating</b>
     * <li>VAR-5: Variance Classification (CWE) <b>optional </b>
     * <li>VAR-6: Variance Description (ST) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class VAR extends AbstractSegment {

    /** 
     * Creates a new VAR segment
     */
    public VAR(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(EI.class, true, 1, 60, new Object[]{ getMessage() }, "Variance Instance ID");
                                  this.add(DTM.class, true, 1, 24, new Object[]{ getMessage() }, "Documented Date/Time");
                                  this.add(DTM.class, false, 1, 24, new Object[]{ getMessage() }, "Stated Variance Date/Time");
                                  this.add(XCN.class, false, 0, 250, new Object[]{ getMessage() }, "Variance Originator");
                                  this.add(CWE.class, false, 1, 705, new Object[]{ getMessage() }, "Variance Classification");
                                  this.add(ST.class, false, 0, 512, new Object[]{ getMessage() }, "Variance Description");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating VAR - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * VAR-1: "Variance Instance ID" - creates it if necessary
     */
    public EI getVarianceInstanceID() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * VAR-1: "Variance Instance ID" - creates it if necessary
     */
    public EI getVar1_VarianceInstanceID() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * VAR-2: "Documented Date/Time" - creates it if necessary
     */
    public DTM getDocumentedDateTime() { 
		DTM retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * VAR-2: "Documented Date/Time" - creates it if necessary
     */
    public DTM getVar2_DocumentedDateTime() { 
		DTM retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * VAR-3: "Stated Variance Date/Time" - creates it if necessary
     */
    public DTM getStatedVarianceDateTime() { 
		DTM retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * VAR-3: "Stated Variance Date/Time" - creates it if necessary
     */
    public DTM getVar3_StatedVarianceDateTime() { 
		DTM retVal = this.getTypedField(3, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Variance Originator (VAR-4).
     */
    public XCN[] getVarianceOriginator() {
    	XCN[] retVal = this.getTypedField(4, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Variance Originator (VAR-4).
     */
    public XCN[] getVar4_VarianceOriginator() {
    	XCN[] retVal = this.getTypedField(4, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Variance Originator (VAR-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getVarianceOriginatorReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * VAR-4: "Variance Originator" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getVarianceOriginator(int rep) { 
		XCN retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * VAR-4: "Variance Originator" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getVar4_VarianceOriginator(int rep) { 
		XCN retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Variance Originator (VAR-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getVar4_VarianceOriginatorReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * VAR-4: "Variance Originator" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertVarianceOriginator(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * VAR-4: "Variance Originator" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertVar4_VarianceOriginator(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * VAR-4: "Variance Originator" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeVarianceOriginator(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * VAR-4: "Variance Originator" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeVar4_VarianceOriginator(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(4, rep);
    }




    /**
     * Returns
     * VAR-5: "Variance Classification" - creates it if necessary
     */
    public CWE getVarianceClassification() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * VAR-5: "Variance Classification" - creates it if necessary
     */
    public CWE getVar5_VarianceClassification() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Variance Description (VAR-6).
     */
    public ST[] getVarianceDescription() {
    	ST[] retVal = this.getTypedField(6, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Variance Description (VAR-6).
     */
    public ST[] getVar6_VarianceDescription() {
    	ST[] retVal = this.getTypedField(6, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Variance Description (VAR-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getVarianceDescriptionReps() {
    	return this.getReps(6);
    }


    /**
     * Returns a specific repetition of
     * VAR-6: "Variance Description" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getVarianceDescription(int rep) { 
		ST retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * VAR-6: "Variance Description" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getVar6_VarianceDescription(int rep) { 
		ST retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Variance Description (VAR-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getVar6_VarianceDescriptionReps() {
    	return this.getReps(6);
    }


    /**
     * Inserts a repetition of
     * VAR-6: "Variance Description" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertVarianceDescription(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(6, rep);
    }


    /**
     * Inserts a repetition of
     * VAR-6: "Variance Description" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertVar6_VarianceDescription(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * VAR-6: "Variance Description" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeVarianceDescription(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * VAR-6: "Variance Description" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeVar6_VarianceDescription(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(6, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new EI(getMessage());
          case 1: return new DTM(getMessage());
          case 2: return new DTM(getMessage());
          case 3: return new XCN(getMessage());
          case 4: return new CWE(getMessage());
          case 5: return new ST(getMessage());
          default: return null;
       }
   }


}

