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


package ca.uhn.hl7v2.model.v24.segment;

// import ca.uhn.hl7v2.model.v24.group.*;
import ca.uhn.hl7v2.model.v24.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 ORG message segment (Practitioner Organization Unit). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>ORG-1: Set ID - ORG (SI) <b> </b>
     * <li>ORG-2: Organization Unit Code (CE) <b>optional </b>
     * <li>ORG-3: Organization Unit Type Code - ORG (CE) <b>optional </b>
     * <li>ORG-4: Primary Org Unit Indicator (ID) <b>optional </b>
     * <li>ORG-5: Practitioner Org Unit Identifier (CX) <b>optional </b>
     * <li>ORG-6: Health Care Provider Type Code (CE) <b>optional </b>
     * <li>ORG-7: Health Care Provider Classification Code (CE) <b>optional </b>
     * <li>ORG-8: Health Care Provider Area of Specialization Code (CE) <b>optional </b>
     * <li>ORG-9: Effective Date Range (DR) <b>optional </b>
     * <li>ORG-10: Employment Status Code (CE) <b>optional </b>
     * <li>ORG-11: Board Approval Indicator (ID) <b>optional </b>
     * <li>ORG-12: Primary Care Physician Indicator (ID) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class ORG extends AbstractSegment {

    /** 
     * Creates a new ORG segment
     */
    public ORG(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 60, new Object[]{ getMessage() }, "Set ID - ORG");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Organization Unit Code");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Organization Unit Type Code - ORG");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Primary Org Unit Indicator");
                                  this.add(CX.class, false, 1, 60, new Object[]{ getMessage() }, "Practitioner Org Unit Identifier");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Health Care Provider Type Code");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Health Care Provider Classification Code");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Health Care Provider Area of Specialization Code");
                                  this.add(DR.class, false, 1, 52, new Object[]{ getMessage() }, "Effective Date Range");
                                  this.add(CE.class, false, 1, 2, new Object[]{ getMessage() }, "Employment Status Code");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Board Approval Indicator");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Primary Care Physician Indicator");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating ORG - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * ORG-1: "Set ID - ORG" - creates it if necessary
     */
    public SI getSetIDORG() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORG-1: "Set ID - ORG" - creates it if necessary
     */
    public SI getOrg1_SetIDORG() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * ORG-2: "Organization Unit Code" - creates it if necessary
     */
    public CE getOrganizationUnitCode() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORG-2: "Organization Unit Code" - creates it if necessary
     */
    public CE getOrg2_OrganizationUnitCode() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * ORG-3: "Organization Unit Type Code - ORG" - creates it if necessary
     */
    public CE getOrganizationUnitTypeCodeORG() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORG-3: "Organization Unit Type Code - ORG" - creates it if necessary
     */
    public CE getOrg3_OrganizationUnitTypeCodeORG() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * ORG-4: "Primary Org Unit Indicator" - creates it if necessary
     */
    public ID getPrimaryOrgUnitIndicator() { 
		ID retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORG-4: "Primary Org Unit Indicator" - creates it if necessary
     */
    public ID getOrg4_PrimaryOrgUnitIndicator() { 
		ID retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * ORG-5: "Practitioner Org Unit Identifier" - creates it if necessary
     */
    public CX getPractitionerOrgUnitIdentifier() { 
		CX retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORG-5: "Practitioner Org Unit Identifier" - creates it if necessary
     */
    public CX getOrg5_PractitionerOrgUnitIdentifier() { 
		CX retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * ORG-6: "Health Care Provider Type Code" - creates it if necessary
     */
    public CE getHealthCareProviderTypeCode() { 
		CE retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORG-6: "Health Care Provider Type Code" - creates it if necessary
     */
    public CE getOrg6_HealthCareProviderTypeCode() { 
		CE retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * ORG-7: "Health Care Provider Classification Code" - creates it if necessary
     */
    public CE getHealthCareProviderClassificationCode() { 
		CE retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORG-7: "Health Care Provider Classification Code" - creates it if necessary
     */
    public CE getOrg7_HealthCareProviderClassificationCode() { 
		CE retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * ORG-8: "Health Care Provider Area of Specialization Code" - creates it if necessary
     */
    public CE getHealthCareProviderAreaOfSpecializationCode() { 
		CE retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORG-8: "Health Care Provider Area of Specialization Code" - creates it if necessary
     */
    public CE getOrg8_HealthCareProviderAreaOfSpecializationCode() { 
		CE retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * ORG-9: "Effective Date Range" - creates it if necessary
     */
    public DR getEffectiveDateRange() { 
		DR retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORG-9: "Effective Date Range" - creates it if necessary
     */
    public DR getOrg9_EffectiveDateRange() { 
		DR retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * ORG-10: "Employment Status Code" - creates it if necessary
     */
    public CE getEmploymentStatusCode() { 
		CE retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORG-10: "Employment Status Code" - creates it if necessary
     */
    public CE getOrg10_EmploymentStatusCode() { 
		CE retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * ORG-11: "Board Approval Indicator" - creates it if necessary
     */
    public ID getBoardApprovalIndicator() { 
		ID retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORG-11: "Board Approval Indicator" - creates it if necessary
     */
    public ID getOrg11_BoardApprovalIndicator() { 
		ID retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * ORG-12: "Primary Care Physician Indicator" - creates it if necessary
     */
    public ID getPrimaryCarePhysicianIndicator() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORG-12: "Primary Care Physician Indicator" - creates it if necessary
     */
    public ID getOrg12_PrimaryCarePhysicianIndicator() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new CE(getMessage());
          case 2: return new CE(getMessage());
          case 3: return new ID(getMessage(), new Integer( 136 ));
          case 4: return new CX(getMessage());
          case 5: return new CE(getMessage());
          case 6: return new CE(getMessage());
          case 7: return new CE(getMessage());
          case 8: return new DR(getMessage());
          case 9: return new CE(getMessage());
          case 10: return new ID(getMessage(), new Integer( 136 ));
          case 11: return new ID(getMessage(), new Integer( 136 ));
          default: return null;
       }
   }


}

