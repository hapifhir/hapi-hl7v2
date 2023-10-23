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


package ca.uhn.hl7v2.model.v231.segment;

// import ca.uhn.hl7v2.model.v231.group.*;
import ca.uhn.hl7v2.model.v231.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 URD message segment (URD - results/update definition segment). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>URD-1: R/U Date/Time (TS) <b>optional </b>
     * <li>URD-2: Report Priority (ID) <b>optional </b>
     * <li>URD-3: R/U Who Subject Definition (XCN) <b> repeating</b>
     * <li>URD-4: R/U What Subject Definition (CE) <b>optional repeating</b>
     * <li>URD-5: R/U What Department Code (CE) <b>optional repeating</b>
     * <li>URD-6: R/U Display/Print Locations (ST) <b>optional repeating</b>
     * <li>URD-7: R/U Results Level (ID) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class URD extends AbstractSegment {

    /** 
     * Creates a new URD segment
     */
    public URD(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "R/U Date/Time");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(109) }, "Report Priority");
                                  this.add(XCN.class, true, 0, 60, new Object[]{ getMessage() }, "R/U Who Subject Definition");
                                  this.add(CE.class, false, 0, 60, new Object[]{ getMessage() }, "R/U What Subject Definition");
                                  this.add(CE.class, false, 0, 60, new Object[]{ getMessage() }, "R/U What Department Code");
                                  this.add(ST.class, false, 0, 20, new Object[]{ getMessage() }, "R/U Display/Print Locations");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(108) }, "R/U Results Level");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating URD - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * URD-1: "R/U Date/Time" - creates it if necessary
     */
    public TS getRUDateTime() { 
		TS retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * URD-1: "R/U Date/Time" - creates it if necessary
     */
    public TS getUrd1_RUDateTime() { 
		TS retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * URD-2: "Report Priority" - creates it if necessary
     */
    public ID getReportPriority() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * URD-2: "Report Priority" - creates it if necessary
     */
    public ID getUrd2_ReportPriority() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of R/U Who Subject Definition (URD-3).
     */
    public XCN[] getRUWhoSubjectDefinition() {
    	XCN[] retVal = this.getTypedField(3, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of R/U Who Subject Definition (URD-3).
     */
    public XCN[] getUrd3_RUWhoSubjectDefinition() {
    	XCN[] retVal = this.getTypedField(3, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of R/U Who Subject Definition (URD-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRUWhoSubjectDefinitionReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * URD-3: "R/U Who Subject Definition" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getRUWhoSubjectDefinition(int rep) { 
		XCN retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * URD-3: "R/U Who Subject Definition" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getUrd3_RUWhoSubjectDefinition(int rep) { 
		XCN retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of R/U Who Subject Definition (URD-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUrd3_RUWhoSubjectDefinitionReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * URD-3: "R/U Who Subject Definition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertRUWhoSubjectDefinition(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * URD-3: "R/U Who Subject Definition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertUrd3_RUWhoSubjectDefinition(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * URD-3: "R/U Who Subject Definition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeRUWhoSubjectDefinition(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * URD-3: "R/U Who Subject Definition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeUrd3_RUWhoSubjectDefinition(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(3, rep);
    }



    /**
     * Returns all repetitions of R/U What Subject Definition (URD-4).
     */
    public CE[] getRUWhatSubjectDefinition() {
    	CE[] retVal = this.getTypedField(4, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of R/U What Subject Definition (URD-4).
     */
    public CE[] getUrd4_RUWhatSubjectDefinition() {
    	CE[] retVal = this.getTypedField(4, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of R/U What Subject Definition (URD-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRUWhatSubjectDefinitionReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * URD-4: "R/U What Subject Definition" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getRUWhatSubjectDefinition(int rep) { 
		CE retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * URD-4: "R/U What Subject Definition" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getUrd4_RUWhatSubjectDefinition(int rep) { 
		CE retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of R/U What Subject Definition (URD-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUrd4_RUWhatSubjectDefinitionReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * URD-4: "R/U What Subject Definition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertRUWhatSubjectDefinition(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * URD-4: "R/U What Subject Definition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertUrd4_RUWhatSubjectDefinition(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * URD-4: "R/U What Subject Definition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeRUWhatSubjectDefinition(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * URD-4: "R/U What Subject Definition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeUrd4_RUWhatSubjectDefinition(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(4, rep);
    }



    /**
     * Returns all repetitions of R/U What Department Code (URD-5).
     */
    public CE[] getRUWhatDepartmentCode() {
    	CE[] retVal = this.getTypedField(5, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of R/U What Department Code (URD-5).
     */
    public CE[] getUrd5_RUWhatDepartmentCode() {
    	CE[] retVal = this.getTypedField(5, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of R/U What Department Code (URD-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRUWhatDepartmentCodeReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * URD-5: "R/U What Department Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getRUWhatDepartmentCode(int rep) { 
		CE retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * URD-5: "R/U What Department Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getUrd5_RUWhatDepartmentCode(int rep) { 
		CE retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of R/U What Department Code (URD-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUrd5_RUWhatDepartmentCodeReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * URD-5: "R/U What Department Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertRUWhatDepartmentCode(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * URD-5: "R/U What Department Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertUrd5_RUWhatDepartmentCode(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * URD-5: "R/U What Department Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeRUWhatDepartmentCode(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * URD-5: "R/U What Department Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeUrd5_RUWhatDepartmentCode(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(5, rep);
    }



    /**
     * Returns all repetitions of R/U Display/Print Locations (URD-6).
     */
    public ST[] getRUDisplayPrintLocations() {
    	ST[] retVal = this.getTypedField(6, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of R/U Display/Print Locations (URD-6).
     */
    public ST[] getUrd6_RUDisplayPrintLocations() {
    	ST[] retVal = this.getTypedField(6, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of R/U Display/Print Locations (URD-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRUDisplayPrintLocationsReps() {
    	return this.getReps(6);
    }


    /**
     * Returns a specific repetition of
     * URD-6: "R/U Display/Print Locations" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getRUDisplayPrintLocations(int rep) { 
		ST retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * URD-6: "R/U Display/Print Locations" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getUrd6_RUDisplayPrintLocations(int rep) { 
		ST retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of R/U Display/Print Locations (URD-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUrd6_RUDisplayPrintLocationsReps() {
    	return this.getReps(6);
    }


    /**
     * Inserts a repetition of
     * URD-6: "R/U Display/Print Locations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertRUDisplayPrintLocations(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(6, rep);
    }


    /**
     * Inserts a repetition of
     * URD-6: "R/U Display/Print Locations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertUrd6_RUDisplayPrintLocations(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * URD-6: "R/U Display/Print Locations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeRUDisplayPrintLocations(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * URD-6: "R/U Display/Print Locations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeUrd6_RUDisplayPrintLocations(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(6, rep);
    }




    /**
     * Returns
     * URD-7: "R/U Results Level" - creates it if necessary
     */
    public ID getRUResultsLevel() { 
		ID retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * URD-7: "R/U Results Level" - creates it if necessary
     */
    public ID getUrd7_RUResultsLevel() { 
		ID retVal = this.getTypedField(7, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new TS(getMessage());
          case 1: return new ID(getMessage(), new Integer( 109 ));
          case 2: return new XCN(getMessage());
          case 3: return new CE(getMessage());
          case 4: return new CE(getMessage());
          case 5: return new ST(getMessage());
          case 6: return new ID(getMessage(), new Integer( 108 ));
          default: return null;
       }
   }


}

