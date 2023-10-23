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


package ca.uhn.hl7v2.model.v28.segment;

// import ca.uhn.hl7v2.model.v28.group.*;
import ca.uhn.hl7v2.model.v28.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 DB1 message segment (Disability). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>DB1-1: Set ID - DB1 (SI) <b> </b>
     * <li>DB1-2: Disabled Person Code (CWE) <b>optional </b>
     * <li>DB1-3: Disabled Person Identifier (CX) <b>optional repeating</b>
     * <li>DB1-4: Disability Indicator (ID) <b>optional </b>
     * <li>DB1-5: Disability Start Date (DT) <b>optional </b>
     * <li>DB1-6: Disability End Date (DT) <b>optional </b>
     * <li>DB1-7: Disability Return to Work Date (DT) <b>optional </b>
     * <li>DB1-8: Disability Unable to Work Date (DT) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class DB1 extends AbstractSegment {

    /** 
     * Creates a new DB1 segment
     */
    public DB1(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "Set ID - DB1");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Disabled Person Code");
                                  this.add(CX.class, false, 0, 0, new Object[]{ getMessage() }, "Disabled Person Identifier");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Disability Indicator");
                                  this.add(DT.class, false, 1, 0, new Object[]{ getMessage() }, "Disability Start Date");
                                  this.add(DT.class, false, 1, 0, new Object[]{ getMessage() }, "Disability End Date");
                                  this.add(DT.class, false, 1, 0, new Object[]{ getMessage() }, "Disability Return to Work Date");
                                  this.add(DT.class, false, 1, 0, new Object[]{ getMessage() }, "Disability Unable to Work Date");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating DB1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * DB1-1: "Set ID - DB1" - creates it if necessary
     */
    public SI getSetIDDB1() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DB1-1: "Set ID - DB1" - creates it if necessary
     */
    public SI getDb11_SetIDDB1() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * DB1-2: "Disabled Person Code" - creates it if necessary
     */
    public CWE getDisabledPersonCode() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DB1-2: "Disabled Person Code" - creates it if necessary
     */
    public CWE getDb12_DisabledPersonCode() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Disabled Person Identifier (DB1-3).
     */
    public CX[] getDisabledPersonIdentifier() {
    	CX[] retVal = this.getTypedField(3, new CX[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Disabled Person Identifier (DB1-3).
     */
    public CX[] getDb13_DisabledPersonIdentifier() {
    	CX[] retVal = this.getTypedField(3, new CX[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Disabled Person Identifier (DB1-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getDisabledPersonIdentifierReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * DB1-3: "Disabled Person Identifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getDisabledPersonIdentifier(int rep) { 
		CX retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * DB1-3: "Disabled Person Identifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getDb13_DisabledPersonIdentifier(int rep) { 
		CX retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Disabled Person Identifier (DB1-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getDb13_DisabledPersonIdentifierReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * DB1-3: "Disabled Person Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertDisabledPersonIdentifier(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * DB1-3: "Disabled Person Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertDb13_DisabledPersonIdentifier(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * DB1-3: "Disabled Person Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeDisabledPersonIdentifier(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * DB1-3: "Disabled Person Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeDb13_DisabledPersonIdentifier(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(3, rep);
    }




    /**
     * Returns
     * DB1-4: "Disability Indicator" - creates it if necessary
     */
    public ID getDisabilityIndicator() { 
		ID retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DB1-4: "Disability Indicator" - creates it if necessary
     */
    public ID getDb14_DisabilityIndicator() { 
		ID retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * DB1-5: "Disability Start Date" - creates it if necessary
     */
    public DT getDisabilityStartDate() { 
		DT retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DB1-5: "Disability Start Date" - creates it if necessary
     */
    public DT getDb15_DisabilityStartDate() { 
		DT retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * DB1-6: "Disability End Date" - creates it if necessary
     */
    public DT getDisabilityEndDate() { 
		DT retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DB1-6: "Disability End Date" - creates it if necessary
     */
    public DT getDb16_DisabilityEndDate() { 
		DT retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * DB1-7: "Disability Return to Work Date" - creates it if necessary
     */
    public DT getDisabilityReturnToWorkDate() { 
		DT retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DB1-7: "Disability Return to Work Date" - creates it if necessary
     */
    public DT getDb17_DisabilityReturnToWorkDate() { 
		DT retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * DB1-8: "Disability Unable to Work Date" - creates it if necessary
     */
    public DT getDisabilityUnableToWorkDate() { 
		DT retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DB1-8: "Disability Unable to Work Date" - creates it if necessary
     */
    public DT getDb18_DisabilityUnableToWorkDate() { 
		DT retVal = this.getTypedField(8, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new CWE(getMessage());
          case 2: return new CX(getMessage());
          case 3: return new ID(getMessage(), new Integer( 136 ));
          case 4: return new DT(getMessage());
          case 5: return new DT(getMessage());
          case 6: return new DT(getMessage());
          case 7: return new DT(getMessage());
          default: return null;
       }
   }


}

