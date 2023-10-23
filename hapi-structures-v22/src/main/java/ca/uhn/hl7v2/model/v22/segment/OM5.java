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
 *<p>Represents an HL7 OM5 message segment (OBSERVATION BATTERIES). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>OM5-1: Segment Type ID (ST) <b>optional </b>
     * <li>OM5-2: Sequence Number - Test/ Observation Master File (NM) <b>optional </b>
     * <li>OM5-3: Tests / observations included within an ordered test battery (CE) <b>optional repeating</b>
     * <li>OM5-4: Observation ID Suffixes (ST) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class OM5 extends AbstractSegment {

    /** 
     * Creates a new OM5 segment
     */
    public OM5(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ST.class, false, 1, 3, new Object[]{ getMessage() }, "Segment Type ID");
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "Sequence Number - Test/ Observation Master File");
                                  this.add(CE.class, false, 0, 200, new Object[]{ getMessage() }, "Tests / observations included within an ordered test battery");
                                  this.add(ST.class, false, 1, 200, new Object[]{ getMessage() }, "Observation ID Suffixes");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating OM5 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * OM5-1: "Segment Type ID" - creates it if necessary
     */
    public ST getSegmentTypeID() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM5-1: "Segment Type ID" - creates it if necessary
     */
    public ST getOm51_SegmentTypeID() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * OM5-2: "Sequence Number - Test/ Observation Master File" - creates it if necessary
     */
    public NM getSequenceNumberTestObservationMasterFile() { 
		NM retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM5-2: "Sequence Number - Test/ Observation Master File" - creates it if necessary
     */
    public NM getOm52_SequenceNumberTestObservationMasterFile() { 
		NM retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Tests / observations included within an ordered test battery (OM5-3).
     */
    public CE[] getTestsObservationsIncludedWithinAnOrderedTestBattery() {
    	CE[] retVal = this.getTypedField(3, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Tests / observations included within an ordered test battery (OM5-3).
     */
    public CE[] getOm53_TestsObservationsIncludedWithinAnOrderedTestBattery() {
    	CE[] retVal = this.getTypedField(3, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Tests / observations included within an ordered test battery (OM5-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getTestsObservationsIncludedWithinAnOrderedTestBatteryReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * OM5-3: "Tests / observations included within an ordered test battery" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getTestsObservationsIncludedWithinAnOrderedTestBattery(int rep) { 
		CE retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM5-3: "Tests / observations included within an ordered test battery" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getOm53_TestsObservationsIncludedWithinAnOrderedTestBattery(int rep) { 
		CE retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Tests / observations included within an ordered test battery (OM5-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm53_TestsObservationsIncludedWithinAnOrderedTestBatteryReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * OM5-3: "Tests / observations included within an ordered test battery" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertTestsObservationsIncludedWithinAnOrderedTestBattery(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * OM5-3: "Tests / observations included within an ordered test battery" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertOm53_TestsObservationsIncludedWithinAnOrderedTestBattery(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * OM5-3: "Tests / observations included within an ordered test battery" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeTestsObservationsIncludedWithinAnOrderedTestBattery(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * OM5-3: "Tests / observations included within an ordered test battery" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeOm53_TestsObservationsIncludedWithinAnOrderedTestBattery(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(3, rep);
    }




    /**
     * Returns
     * OM5-4: "Observation ID Suffixes" - creates it if necessary
     */
    public ST getObservationIDSuffixes() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM5-4: "Observation ID Suffixes" - creates it if necessary
     */
    public ST getOm54_ObservationIDSuffixes() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ST(getMessage());
          case 1: return new NM(getMessage());
          case 2: return new CE(getMessage());
          case 3: return new ST(getMessage());
          default: return null;
       }
   }


}

