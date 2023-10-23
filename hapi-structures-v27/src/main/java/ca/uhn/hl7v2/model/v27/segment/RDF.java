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


package ca.uhn.hl7v2.model.v27.segment;

// import ca.uhn.hl7v2.model.v27.group.*;
import ca.uhn.hl7v2.model.v27.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 RDF message segment (Table Row Definition). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>RDF-1: Number of Columns per Row (NM) <b> </b>
     * <li>RDF-2: Column Description (RCD) <b> repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class RDF extends AbstractSegment {

    /** 
     * Creates a new RDF segment
     */
    public RDF(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(NM.class, true, 1, 0, new Object[]{ getMessage() }, "Number of Columns per Row");
                                  this.add(RCD.class, true, 0, 0, new Object[]{ getMessage() }, "Column Description");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating RDF - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * RDF-1: "Number of Columns per Row" - creates it if necessary
     */
    public NM getNumberOfColumnsPerRow() { 
		NM retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RDF-1: "Number of Columns per Row" - creates it if necessary
     */
    public NM getRdf1_NumberOfColumnsPerRow() { 
		NM retVal = this.getTypedField(1, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Column Description (RDF-2).
     */
    public RCD[] getColumnDescription() {
    	RCD[] retVal = this.getTypedField(2, new RCD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Column Description (RDF-2).
     */
    public RCD[] getRdf2_ColumnDescription() {
    	RCD[] retVal = this.getTypedField(2, new RCD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Column Description (RDF-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getColumnDescriptionReps() {
    	return this.getReps(2);
    }


    /**
     * Returns a specific repetition of
     * RDF-2: "Column Description" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public RCD getColumnDescription(int rep) { 
		RCD retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RDF-2: "Column Description" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public RCD getRdf2_ColumnDescription(int rep) { 
		RCD retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Column Description (RDF-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRdf2_ColumnDescriptionReps() {
    	return this.getReps(2);
    }


    /**
     * Inserts a repetition of
     * RDF-2: "Column Description" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public RCD insertColumnDescription(int rep) throws HL7Exception { 
        return (RCD) super.insertRepetition(2, rep);
    }


    /**
     * Inserts a repetition of
     * RDF-2: "Column Description" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public RCD insertRdf2_ColumnDescription(int rep) throws HL7Exception { 
        return (RCD) super.insertRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * RDF-2: "Column Description" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public RCD removeColumnDescription(int rep) throws HL7Exception { 
        return (RCD) super.removeRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * RDF-2: "Column Description" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public RCD removeRdf2_ColumnDescription(int rep) throws HL7Exception { 
        return (RCD) super.removeRepetition(2, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new NM(getMessage());
          case 1: return new RCD(getMessage());
          default: return null;
       }
   }


}

