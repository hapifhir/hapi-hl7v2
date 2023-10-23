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


package ca.uhn.hl7v2.model.v25.segment;

// import ca.uhn.hl7v2.model.v25.group.*;
import ca.uhn.hl7v2.model.v25.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 AIG message segment (Appointment Information _ General Resource). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>AIG-1: Set ID - AIG (SI) <b> </b>
     * <li>AIG-2: Segment Action Code (ID) <b>optional </b>
     * <li>AIG-3: Resource ID (CE) <b>optional </b>
     * <li>AIG-4: Resource Type (CE) <b> </b>
     * <li>AIG-5: Resource Group (CE) <b>optional repeating</b>
     * <li>AIG-6: Resource Quantity (NM) <b>optional </b>
     * <li>AIG-7: Resource Quantity Units (CE) <b>optional </b>
     * <li>AIG-8: Start Date/Time (TS) <b>optional </b>
     * <li>AIG-9: Start Date/Time Offset (NM) <b>optional </b>
     * <li>AIG-10: Start Date/Time Offset Units (CE) <b>optional </b>
     * <li>AIG-11: Duration (NM) <b>optional </b>
     * <li>AIG-12: Duration Units (CE) <b>optional </b>
     * <li>AIG-13: Allow Substitution Code (IS) <b>optional </b>
     * <li>AIG-14: Filler Status Code (CE) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class AIG extends AbstractSegment {

    /** 
     * Creates a new AIG segment
     */
    public AIG(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "Set ID - AIG");
                                              this.add(ID.class, false, 1, 3, new Object[]{ getMessage(), new Integer(206) }, "Segment Action Code");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Resource ID");
                                  this.add(CE.class, true, 1, 250, new Object[]{ getMessage() }, "Resource Type");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Resource Group");
                                  this.add(NM.class, false, 1, 5, new Object[]{ getMessage() }, "Resource Quantity");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Resource Quantity Units");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Start Date/Time");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Start Date/Time Offset");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Start Date/Time Offset Units");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Duration");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Duration Units");
                                              this.add(IS.class, false, 1, 10, new Object[]{ getMessage(), new Integer(279) }, "Allow Substitution Code");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Filler Status Code");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating AIG - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * AIG-1: "Set ID - AIG" - creates it if necessary
     */
    public SI getSetIDAIG() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AIG-1: "Set ID - AIG" - creates it if necessary
     */
    public SI getAig1_SetIDAIG() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * AIG-2: "Segment Action Code" - creates it if necessary
     */
    public ID getSegmentActionCode() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AIG-2: "Segment Action Code" - creates it if necessary
     */
    public ID getAig2_SegmentActionCode() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * AIG-3: "Resource ID" - creates it if necessary
     */
    public CE getResourceID() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AIG-3: "Resource ID" - creates it if necessary
     */
    public CE getAig3_ResourceID() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * AIG-4: "Resource Type" - creates it if necessary
     */
    public CE getResourceType() { 
		CE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AIG-4: "Resource Type" - creates it if necessary
     */
    public CE getAig4_ResourceType() { 
		CE retVal = this.getTypedField(4, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Resource Group (AIG-5).
     */
    public CE[] getResourceGroup() {
    	CE[] retVal = this.getTypedField(5, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Resource Group (AIG-5).
     */
    public CE[] getAig5_ResourceGroup() {
    	CE[] retVal = this.getTypedField(5, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Resource Group (AIG-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getResourceGroupReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * AIG-5: "Resource Group" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getResourceGroup(int rep) { 
		CE retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * AIG-5: "Resource Group" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getAig5_ResourceGroup(int rep) { 
		CE retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Resource Group (AIG-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAig5_ResourceGroupReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * AIG-5: "Resource Group" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertResourceGroup(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * AIG-5: "Resource Group" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertAig5_ResourceGroup(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * AIG-5: "Resource Group" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeResourceGroup(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * AIG-5: "Resource Group" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeAig5_ResourceGroup(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(5, rep);
    }




    /**
     * Returns
     * AIG-6: "Resource Quantity" - creates it if necessary
     */
    public NM getResourceQuantity() { 
		NM retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AIG-6: "Resource Quantity" - creates it if necessary
     */
    public NM getAig6_ResourceQuantity() { 
		NM retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * AIG-7: "Resource Quantity Units" - creates it if necessary
     */
    public CE getResourceQuantityUnits() { 
		CE retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AIG-7: "Resource Quantity Units" - creates it if necessary
     */
    public CE getAig7_ResourceQuantityUnits() { 
		CE retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * AIG-8: "Start Date/Time" - creates it if necessary
     */
    public TS getStartDateTime() { 
		TS retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AIG-8: "Start Date/Time" - creates it if necessary
     */
    public TS getAig8_StartDateTime() { 
		TS retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * AIG-9: "Start Date/Time Offset" - creates it if necessary
     */
    public NM getStartDateTimeOffset() { 
		NM retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AIG-9: "Start Date/Time Offset" - creates it if necessary
     */
    public NM getAig9_StartDateTimeOffset() { 
		NM retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * AIG-10: "Start Date/Time Offset Units" - creates it if necessary
     */
    public CE getStartDateTimeOffsetUnits() { 
		CE retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AIG-10: "Start Date/Time Offset Units" - creates it if necessary
     */
    public CE getAig10_StartDateTimeOffsetUnits() { 
		CE retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * AIG-11: "Duration" - creates it if necessary
     */
    public NM getDuration() { 
		NM retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AIG-11: "Duration" - creates it if necessary
     */
    public NM getAig11_Duration() { 
		NM retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * AIG-12: "Duration Units" - creates it if necessary
     */
    public CE getDurationUnits() { 
		CE retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AIG-12: "Duration Units" - creates it if necessary
     */
    public CE getAig12_DurationUnits() { 
		CE retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * AIG-13: "Allow Substitution Code" - creates it if necessary
     */
    public IS getAllowSubstitutionCode() { 
		IS retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AIG-13: "Allow Substitution Code" - creates it if necessary
     */
    public IS getAig13_AllowSubstitutionCode() { 
		IS retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * AIG-14: "Filler Status Code" - creates it if necessary
     */
    public CE getFillerStatusCode() { 
		CE retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AIG-14: "Filler Status Code" - creates it if necessary
     */
    public CE getAig14_FillerStatusCode() { 
		CE retVal = this.getTypedField(14, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new ID(getMessage(), new Integer( 206 ));
          case 2: return new CE(getMessage());
          case 3: return new CE(getMessage());
          case 4: return new CE(getMessage());
          case 5: return new NM(getMessage());
          case 6: return new CE(getMessage());
          case 7: return new TS(getMessage());
          case 8: return new NM(getMessage());
          case 9: return new CE(getMessage());
          case 10: return new NM(getMessage());
          case 11: return new CE(getMessage());
          case 12: return new IS(getMessage(), new Integer( 279 ));
          case 13: return new CE(getMessage());
          default: return null;
       }
   }


}

