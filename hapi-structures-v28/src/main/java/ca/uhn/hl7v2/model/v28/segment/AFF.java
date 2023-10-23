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
 *<p>Represents an HL7 AFF message segment (Professional Affiliation). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>AFF-1: Set ID - AFF (SI) <b> </b>
     * <li>AFF-2: Professional Organization (XON) <b> </b>
     * <li>AFF-3: Professional Organization Address (XAD) <b>optional </b>
     * <li>AFF-4: Professional Organization Affiliation Date Range (DR) <b>optional repeating</b>
     * <li>AFF-5: Professional Affiliation Additional Information (ST) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class AFF extends AbstractSegment {

    /** 
     * Creates a new AFF segment
     */
    public AFF(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "Set ID - AFF");
                                  this.add(XON.class, true, 1, 0, new Object[]{ getMessage() }, "Professional Organization");
                                  this.add(XAD.class, false, 1, 0, new Object[]{ getMessage() }, "Professional Organization Address");
                                  this.add(DR.class, false, 0, 0, new Object[]{ getMessage() }, "Professional Organization Affiliation Date Range");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Professional Affiliation Additional Information");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating AFF - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * AFF-1: "Set ID - AFF" - creates it if necessary
     */
    public SI getSetIDAFF() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AFF-1: "Set ID - AFF" - creates it if necessary
     */
    public SI getAff1_SetIDAFF() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * AFF-2: "Professional Organization" - creates it if necessary
     */
    public XON getProfessionalOrganization() { 
		XON retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AFF-2: "Professional Organization" - creates it if necessary
     */
    public XON getAff2_ProfessionalOrganization() { 
		XON retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * AFF-3: "Professional Organization Address" - creates it if necessary
     */
    public XAD getProfessionalOrganizationAddress() { 
		XAD retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AFF-3: "Professional Organization Address" - creates it if necessary
     */
    public XAD getAff3_ProfessionalOrganizationAddress() { 
		XAD retVal = this.getTypedField(3, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Professional Organization Affiliation Date Range (AFF-4).
     */
    public DR[] getProfessionalOrganizationAffiliationDateRange() {
    	DR[] retVal = this.getTypedField(4, new DR[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Professional Organization Affiliation Date Range (AFF-4).
     */
    public DR[] getAff4_ProfessionalOrganizationAffiliationDateRange() {
    	DR[] retVal = this.getTypedField(4, new DR[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Professional Organization Affiliation Date Range (AFF-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getProfessionalOrganizationAffiliationDateRangeReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * AFF-4: "Professional Organization Affiliation Date Range" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public DR getProfessionalOrganizationAffiliationDateRange(int rep) { 
		DR retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * AFF-4: "Professional Organization Affiliation Date Range" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public DR getAff4_ProfessionalOrganizationAffiliationDateRange(int rep) { 
		DR retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Professional Organization Affiliation Date Range (AFF-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAff4_ProfessionalOrganizationAffiliationDateRangeReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * AFF-4: "Professional Organization Affiliation Date Range" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DR insertProfessionalOrganizationAffiliationDateRange(int rep) throws HL7Exception { 
        return (DR) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * AFF-4: "Professional Organization Affiliation Date Range" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DR insertAff4_ProfessionalOrganizationAffiliationDateRange(int rep) throws HL7Exception { 
        return (DR) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * AFF-4: "Professional Organization Affiliation Date Range" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DR removeProfessionalOrganizationAffiliationDateRange(int rep) throws HL7Exception { 
        return (DR) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * AFF-4: "Professional Organization Affiliation Date Range" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DR removeAff4_ProfessionalOrganizationAffiliationDateRange(int rep) throws HL7Exception { 
        return (DR) super.removeRepetition(4, rep);
    }




    /**
     * Returns
     * AFF-5: "Professional Affiliation Additional Information" - creates it if necessary
     */
    public ST getProfessionalAffiliationAdditionalInformation() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AFF-5: "Professional Affiliation Additional Information" - creates it if necessary
     */
    public ST getAff5_ProfessionalAffiliationAdditionalInformation() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new XON(getMessage());
          case 2: return new XAD(getMessage());
          case 3: return new DR(getMessage());
          case 4: return new ST(getMessage());
          default: return null;
       }
   }


}

