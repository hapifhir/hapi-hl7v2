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


package ca.uhn.hl7v2.model.v23.segment;

// import ca.uhn.hl7v2.model.v23.group.*;
import ca.uhn.hl7v2.model.v23.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 PSH message segment (Product Summary Header). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PSH-1: Report Type (ST) <b> </b>
     * <li>PSH-2: Report Form Identifier (ST) <b>optional </b>
     * <li>PSH-3: Report Date (TS) <b> </b>
     * <li>PSH-4: Report Interval Start Date (TS) <b>optional </b>
     * <li>PSH-5: Report Interval End Date (TS) <b>optional </b>
     * <li>PSH-6: Quantity Manufactured (CQ) <b>optional </b>
     * <li>PSH-7: Quantity Distributed (CQ) <b>optional </b>
     * <li>PSH-8: Quantity Distributed Method (ID) <b>optional </b>
     * <li>PSH-9: Quantity Distributed Comment (FT) <b>optional </b>
     * <li>PSH-10: Quantity in Use (CQ) <b>optional </b>
     * <li>PSH-11: Quantity in Use Method (ID) <b>optional </b>
     * <li>PSH-12: Quantity in Use Comment (FT) <b>optional </b>
     * <li>PSH-13: Number of Product Experience Reports Filed by Facility (NM) <b>optional repeating</b>
     * <li>PSH-14: Number of Product Experience Reports Filed by Distributor (NM) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class PSH extends AbstractSegment {

    /** 
     * Creates a new PSH segment
     */
    public PSH(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ST.class, true, 1, 60, new Object[]{ getMessage() }, "Report Type");
                                  this.add(ST.class, false, 1, 60, new Object[]{ getMessage() }, "Report Form Identifier");
                                  this.add(TS.class, true, 1, 26, new Object[]{ getMessage() }, "Report Date");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Report Interval Start Date");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Report Interval End Date");
                                  this.add(CQ.class, false, 1, 12, new Object[]{ getMessage() }, "Quantity Manufactured");
                                  this.add(CQ.class, false, 1, 12, new Object[]{ getMessage() }, "Quantity Distributed");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(329) }, "Quantity Distributed Method");
                                  this.add(FT.class, false, 1, 600, new Object[]{ getMessage() }, "Quantity Distributed Comment");
                                  this.add(CQ.class, false, 1, 12, new Object[]{ getMessage() }, "Quantity in Use");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(329) }, "Quantity in Use Method");
                                  this.add(FT.class, false, 1, 600, new Object[]{ getMessage() }, "Quantity in Use Comment");
                                  this.add(NM.class, false, 8, 2, new Object[]{ getMessage() }, "Number of Product Experience Reports Filed by Facility");
                                  this.add(NM.class, false, 8, 2, new Object[]{ getMessage() }, "Number of Product Experience Reports Filed by Distributor");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PSH - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * PSH-1: "Report Type" - creates it if necessary
     */
    public ST getReportType() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSH-1: "Report Type" - creates it if necessary
     */
    public ST getPsh1_ReportType() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * PSH-2: "Report Form Identifier" - creates it if necessary
     */
    public ST getReportFormIdentifier() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSH-2: "Report Form Identifier" - creates it if necessary
     */
    public ST getPsh2_ReportFormIdentifier() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * PSH-3: "Report Date" - creates it if necessary
     */
    public TS getReportDate() { 
		TS retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSH-3: "Report Date" - creates it if necessary
     */
    public TS getPsh3_ReportDate() { 
		TS retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * PSH-4: "Report Interval Start Date" - creates it if necessary
     */
    public TS getReportIntervalStartDate() { 
		TS retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSH-4: "Report Interval Start Date" - creates it if necessary
     */
    public TS getPsh4_ReportIntervalStartDate() { 
		TS retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * PSH-5: "Report Interval End Date" - creates it if necessary
     */
    public TS getReportIntervalEndDate() { 
		TS retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSH-5: "Report Interval End Date" - creates it if necessary
     */
    public TS getPsh5_ReportIntervalEndDate() { 
		TS retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * PSH-6: "Quantity Manufactured" - creates it if necessary
     */
    public CQ getQuantityManufactured() { 
		CQ retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSH-6: "Quantity Manufactured" - creates it if necessary
     */
    public CQ getPsh6_QuantityManufactured() { 
		CQ retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * PSH-7: "Quantity Distributed" - creates it if necessary
     */
    public CQ getQuantityDistributed() { 
		CQ retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSH-7: "Quantity Distributed" - creates it if necessary
     */
    public CQ getPsh7_QuantityDistributed() { 
		CQ retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * PSH-8: "Quantity Distributed Method" - creates it if necessary
     */
    public ID getQuantityDistributedMethod() { 
		ID retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSH-8: "Quantity Distributed Method" - creates it if necessary
     */
    public ID getPsh8_QuantityDistributedMethod() { 
		ID retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * PSH-9: "Quantity Distributed Comment" - creates it if necessary
     */
    public FT getQuantityDistributedComment() { 
		FT retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSH-9: "Quantity Distributed Comment" - creates it if necessary
     */
    public FT getPsh9_QuantityDistributedComment() { 
		FT retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * PSH-10: "Quantity in Use" - creates it if necessary
     */
    public CQ getQuantityInUse() { 
		CQ retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSH-10: "Quantity in Use" - creates it if necessary
     */
    public CQ getPsh10_QuantityInUse() { 
		CQ retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * PSH-11: "Quantity in Use Method" - creates it if necessary
     */
    public ID getQuantityInUseMethod() { 
		ID retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSH-11: "Quantity in Use Method" - creates it if necessary
     */
    public ID getPsh11_QuantityInUseMethod() { 
		ID retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * PSH-12: "Quantity in Use Comment" - creates it if necessary
     */
    public FT getQuantityInUseComment() { 
		FT retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSH-12: "Quantity in Use Comment" - creates it if necessary
     */
    public FT getPsh12_QuantityInUseComment() { 
		FT retVal = this.getTypedField(12, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Number of Product Experience Reports Filed by Facility (PSH-13).
     */
    public NM[] getNumberOfProductExperienceReportsFiledByFacility() {
    	NM[] retVal = this.getTypedField(13, new NM[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Number of Product Experience Reports Filed by Facility (PSH-13).
     */
    public NM[] getPsh13_NumberOfProductExperienceReportsFiledByFacility() {
    	NM[] retVal = this.getTypedField(13, new NM[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Number of Product Experience Reports Filed by Facility (PSH-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getNumberOfProductExperienceReportsFiledByFacilityReps() {
    	return this.getReps(13);
    }


    /**
     * Returns a specific repetition of
     * PSH-13: "Number of Product Experience Reports Filed by Facility" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public NM getNumberOfProductExperienceReportsFiledByFacility(int rep) { 
		NM retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PSH-13: "Number of Product Experience Reports Filed by Facility" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public NM getPsh13_NumberOfProductExperienceReportsFiledByFacility(int rep) { 
		NM retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Number of Product Experience Reports Filed by Facility (PSH-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPsh13_NumberOfProductExperienceReportsFiledByFacilityReps() {
    	return this.getReps(13);
    }


    /**
     * Inserts a repetition of
     * PSH-13: "Number of Product Experience Reports Filed by Facility" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM insertNumberOfProductExperienceReportsFiledByFacility(int rep) throws HL7Exception { 
        return (NM) super.insertRepetition(13, rep);
    }


    /**
     * Inserts a repetition of
     * PSH-13: "Number of Product Experience Reports Filed by Facility" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM insertPsh13_NumberOfProductExperienceReportsFiledByFacility(int rep) throws HL7Exception { 
        return (NM) super.insertRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * PSH-13: "Number of Product Experience Reports Filed by Facility" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM removeNumberOfProductExperienceReportsFiledByFacility(int rep) throws HL7Exception { 
        return (NM) super.removeRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * PSH-13: "Number of Product Experience Reports Filed by Facility" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM removePsh13_NumberOfProductExperienceReportsFiledByFacility(int rep) throws HL7Exception { 
        return (NM) super.removeRepetition(13, rep);
    }



    /**
     * Returns all repetitions of Number of Product Experience Reports Filed by Distributor (PSH-14).
     */
    public NM[] getNumberOfProductExperienceReportsFiledByDistributor() {
    	NM[] retVal = this.getTypedField(14, new NM[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Number of Product Experience Reports Filed by Distributor (PSH-14).
     */
    public NM[] getPsh14_NumberOfProductExperienceReportsFiledByDistributor() {
    	NM[] retVal = this.getTypedField(14, new NM[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Number of Product Experience Reports Filed by Distributor (PSH-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getNumberOfProductExperienceReportsFiledByDistributorReps() {
    	return this.getReps(14);
    }


    /**
     * Returns a specific repetition of
     * PSH-14: "Number of Product Experience Reports Filed by Distributor" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public NM getNumberOfProductExperienceReportsFiledByDistributor(int rep) { 
		NM retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PSH-14: "Number of Product Experience Reports Filed by Distributor" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public NM getPsh14_NumberOfProductExperienceReportsFiledByDistributor(int rep) { 
		NM retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Number of Product Experience Reports Filed by Distributor (PSH-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPsh14_NumberOfProductExperienceReportsFiledByDistributorReps() {
    	return this.getReps(14);
    }


    /**
     * Inserts a repetition of
     * PSH-14: "Number of Product Experience Reports Filed by Distributor" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM insertNumberOfProductExperienceReportsFiledByDistributor(int rep) throws HL7Exception { 
        return (NM) super.insertRepetition(14, rep);
    }


    /**
     * Inserts a repetition of
     * PSH-14: "Number of Product Experience Reports Filed by Distributor" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM insertPsh14_NumberOfProductExperienceReportsFiledByDistributor(int rep) throws HL7Exception { 
        return (NM) super.insertRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * PSH-14: "Number of Product Experience Reports Filed by Distributor" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM removeNumberOfProductExperienceReportsFiledByDistributor(int rep) throws HL7Exception { 
        return (NM) super.removeRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * PSH-14: "Number of Product Experience Reports Filed by Distributor" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM removePsh14_NumberOfProductExperienceReportsFiledByDistributor(int rep) throws HL7Exception { 
        return (NM) super.removeRepetition(14, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ST(getMessage());
          case 1: return new ST(getMessage());
          case 2: return new TS(getMessage());
          case 3: return new TS(getMessage());
          case 4: return new TS(getMessage());
          case 5: return new CQ(getMessage());
          case 6: return new CQ(getMessage());
          case 7: return new ID(getMessage(), new Integer( 329 ));
          case 8: return new FT(getMessage());
          case 9: return new CQ(getMessage());
          case 10: return new ID(getMessage(), new Integer( 329 ));
          case 11: return new FT(getMessage());
          case 12: return new NM(getMessage());
          case 13: return new NM(getMessage());
          default: return null;
       }
   }


}

