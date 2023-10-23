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
 *<p>Represents an HL7 AUT message segment (Authorization Information). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>AUT-1: Authorizing Payor, Plan ID (CE) <b>optional </b>
     * <li>AUT-2: Authorizing Payor, Company ID (CE) <b> </b>
     * <li>AUT-3: Authorizing Payor, Company Name (ST) <b>optional </b>
     * <li>AUT-4: Authorization Effective Date (TS) <b>optional </b>
     * <li>AUT-5: Authorization Expiration Date (TS) <b>optional </b>
     * <li>AUT-6: Authorization Identifier (EI) <b>optional </b>
     * <li>AUT-7: Reimbursement Limit (CP) <b>optional </b>
     * <li>AUT-8: Requested Number of Treatments (NM) <b>optional </b>
     * <li>AUT-9: Authorized Number of Treatments (NM) <b>optional </b>
     * <li>AUT-10: Process Date (TS) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class AUT extends AbstractSegment {

    /** 
     * Creates a new AUT segment
     */
    public AUT(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CE.class, false, 1, 200, new Object[]{ getMessage() }, "Authorizing Payor, Plan ID");
                                  this.add(CE.class, true, 1, 200, new Object[]{ getMessage() }, "Authorizing Payor, Company ID");
                                  this.add(ST.class, false, 1, 45, new Object[]{ getMessage() }, "Authorizing Payor, Company Name");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Authorization Effective Date");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Authorization Expiration Date");
                                  this.add(EI.class, false, 1, 30, new Object[]{ getMessage() }, "Authorization Identifier");
                                  this.add(CP.class, false, 1, 25, new Object[]{ getMessage() }, "Reimbursement Limit");
                                  this.add(NM.class, false, 1, 2, new Object[]{ getMessage() }, "Requested Number of Treatments");
                                  this.add(NM.class, false, 1, 2, new Object[]{ getMessage() }, "Authorized Number of Treatments");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Process Date");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating AUT - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * AUT-1: "Authorizing Payor, Plan ID" - creates it if necessary
     */
    public CE getAuthorizingPayorPlanID() { 
		CE retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-1: "Authorizing Payor, Plan ID" - creates it if necessary
     */
    public CE getAut1_AuthorizingPayorPlanID() { 
		CE retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-2: "Authorizing Payor, Company ID" - creates it if necessary
     */
    public CE getAuthorizingPayorCompanyID() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-2: "Authorizing Payor, Company ID" - creates it if necessary
     */
    public CE getAut2_AuthorizingPayorCompanyID() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-3: "Authorizing Payor, Company Name" - creates it if necessary
     */
    public ST getAuthorizingPayorCompanyName() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-3: "Authorizing Payor, Company Name" - creates it if necessary
     */
    public ST getAut3_AuthorizingPayorCompanyName() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-4: "Authorization Effective Date" - creates it if necessary
     */
    public TS getAuthorizationEffectiveDate() { 
		TS retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-4: "Authorization Effective Date" - creates it if necessary
     */
    public TS getAut4_AuthorizationEffectiveDate() { 
		TS retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-5: "Authorization Expiration Date" - creates it if necessary
     */
    public TS getAuthorizationExpirationDate() { 
		TS retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-5: "Authorization Expiration Date" - creates it if necessary
     */
    public TS getAut5_AuthorizationExpirationDate() { 
		TS retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-6: "Authorization Identifier" - creates it if necessary
     */
    public EI getAuthorizationIdentifier() { 
		EI retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-6: "Authorization Identifier" - creates it if necessary
     */
    public EI getAut6_AuthorizationIdentifier() { 
		EI retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-7: "Reimbursement Limit" - creates it if necessary
     */
    public CP getReimbursementLimit() { 
		CP retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-7: "Reimbursement Limit" - creates it if necessary
     */
    public CP getAut7_ReimbursementLimit() { 
		CP retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-8: "Requested Number of Treatments" - creates it if necessary
     */
    public NM getRequestedNumberOfTreatments() { 
		NM retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-8: "Requested Number of Treatments" - creates it if necessary
     */
    public NM getAut8_RequestedNumberOfTreatments() { 
		NM retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-9: "Authorized Number of Treatments" - creates it if necessary
     */
    public NM getAuthorizedNumberOfTreatments() { 
		NM retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-9: "Authorized Number of Treatments" - creates it if necessary
     */
    public NM getAut9_AuthorizedNumberOfTreatments() { 
		NM retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-10: "Process Date" - creates it if necessary
     */
    public TS getProcessDate() { 
		TS retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-10: "Process Date" - creates it if necessary
     */
    public TS getAut10_ProcessDate() { 
		TS retVal = this.getTypedField(10, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CE(getMessage());
          case 1: return new CE(getMessage());
          case 2: return new ST(getMessage());
          case 3: return new TS(getMessage());
          case 4: return new TS(getMessage());
          case 5: return new EI(getMessage());
          case 6: return new CP(getMessage());
          case 7: return new NM(getMessage());
          case 8: return new NM(getMessage());
          case 9: return new TS(getMessage());
          default: return null;
       }
   }


}

