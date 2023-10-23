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
 *<p>Represents an HL7 VTQ message segment (Virtual Table Query Request). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>VTQ-1: Query tag (ST) <b>optional </b>
     * <li>VTQ-2: Query/ Response Format Code (ID) <b> </b>
     * <li>VTQ-3: VT Query Name (CE) <b> </b>
     * <li>VTQ-4: Virtual Table Name (CE) <b> </b>
     * <li>VTQ-5: Selection Criteria (QSC) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class VTQ extends AbstractSegment {

    /** 
     * Creates a new VTQ segment
     */
    public VTQ(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ST.class, false, 1, 32, new Object[]{ getMessage() }, "Query tag");
                                              this.add(ID.class, true, 1, 1, new Object[]{ getMessage(), new Integer(106) }, "Query/ Response Format Code");
                                  this.add(CE.class, true, 1, 60, new Object[]{ getMessage() }, "VT Query Name");
                                  this.add(CE.class, true, 1, 60, new Object[]{ getMessage() }, "Virtual Table Name");
                                  this.add(QSC.class, false, 0, 256, new Object[]{ getMessage() }, "Selection Criteria");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating VTQ - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * VTQ-1: "Query tag" - creates it if necessary
     */
    public ST getQueryTag() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * VTQ-1: "Query tag" - creates it if necessary
     */
    public ST getVtq1_QueryTag() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * VTQ-2: "Query/ Response Format Code" - creates it if necessary
     */
    public ID getQueryResponseFormatCode() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * VTQ-2: "Query/ Response Format Code" - creates it if necessary
     */
    public ID getVtq2_QueryResponseFormatCode() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * VTQ-3: "VT Query Name" - creates it if necessary
     */
    public CE getVTQueryName() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * VTQ-3: "VT Query Name" - creates it if necessary
     */
    public CE getVtq3_VTQueryName() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * VTQ-4: "Virtual Table Name" - creates it if necessary
     */
    public CE getVirtualTableName() { 
		CE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * VTQ-4: "Virtual Table Name" - creates it if necessary
     */
    public CE getVtq4_VirtualTableName() { 
		CE retVal = this.getTypedField(4, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Selection Criteria (VTQ-5).
     */
    public QSC[] getSelectionCriteria() {
    	QSC[] retVal = this.getTypedField(5, new QSC[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Selection Criteria (VTQ-5).
     */
    public QSC[] getVtq5_SelectionCriteria() {
    	QSC[] retVal = this.getTypedField(5, new QSC[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Selection Criteria (VTQ-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSelectionCriteriaReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * VTQ-5: "Selection Criteria" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public QSC getSelectionCriteria(int rep) { 
		QSC retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * VTQ-5: "Selection Criteria" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public QSC getVtq5_SelectionCriteria(int rep) { 
		QSC retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Selection Criteria (VTQ-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getVtq5_SelectionCriteriaReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * VTQ-5: "Selection Criteria" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public QSC insertSelectionCriteria(int rep) throws HL7Exception { 
        return (QSC) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * VTQ-5: "Selection Criteria" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public QSC insertVtq5_SelectionCriteria(int rep) throws HL7Exception { 
        return (QSC) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * VTQ-5: "Selection Criteria" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public QSC removeSelectionCriteria(int rep) throws HL7Exception { 
        return (QSC) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * VTQ-5: "Selection Criteria" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public QSC removeVtq5_SelectionCriteria(int rep) throws HL7Exception { 
        return (QSC) super.removeRepetition(5, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ST(getMessage());
          case 1: return new ID(getMessage(), new Integer( 106 ));
          case 2: return new CE(getMessage());
          case 3: return new CE(getMessage());
          case 4: return new QSC(getMessage());
          default: return null;
       }
   }


}

