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
 *<p>Represents an HL7 OVR message segment (Override Segment). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>OVR-1: Business Rule Override Type (CWE) <b>optional </b>
     * <li>OVR-2: Business Rule Override Code (CWE) <b>optional </b>
     * <li>OVR-3: Override Comments (TX) <b>optional </b>
     * <li>OVR-4: Override Entered By (XCN) <b>optional </b>
     * <li>OVR-5: Override Authorized By (XCN) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class OVR extends AbstractSegment {

    /** 
     * Creates a new OVR segment
     */
    public OVR(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Business Rule Override Type");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Business Rule Override Code");
                                  this.add(TX.class, false, 1, 0, new Object[]{ getMessage() }, "Override Comments");
                                  this.add(XCN.class, false, 1, 0, new Object[]{ getMessage() }, "Override Entered By");
                                  this.add(XCN.class, false, 1, 0, new Object[]{ getMessage() }, "Override Authorized By");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating OVR - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * OVR-1: "Business Rule Override Type" - creates it if necessary
     */
    public CWE getBusinessRuleOverrideType() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OVR-1: "Business Rule Override Type" - creates it if necessary
     */
    public CWE getOvr1_BusinessRuleOverrideType() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * OVR-2: "Business Rule Override Code" - creates it if necessary
     */
    public CWE getBusinessRuleOverrideCode() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OVR-2: "Business Rule Override Code" - creates it if necessary
     */
    public CWE getOvr2_BusinessRuleOverrideCode() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * OVR-3: "Override Comments" - creates it if necessary
     */
    public TX getOverrideComments() { 
		TX retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OVR-3: "Override Comments" - creates it if necessary
     */
    public TX getOvr3_OverrideComments() { 
		TX retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * OVR-4: "Override Entered By" - creates it if necessary
     */
    public XCN getOverrideEnteredBy() { 
		XCN retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OVR-4: "Override Entered By" - creates it if necessary
     */
    public XCN getOvr4_OverrideEnteredBy() { 
		XCN retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * OVR-5: "Override Authorized By" - creates it if necessary
     */
    public XCN getOverrideAuthorizedBy() { 
		XCN retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OVR-5: "Override Authorized By" - creates it if necessary
     */
    public XCN getOvr5_OverrideAuthorizedBy() { 
		XCN retVal = this.getTypedField(5, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CWE(getMessage());
          case 1: return new CWE(getMessage());
          case 2: return new TX(getMessage());
          case 3: return new XCN(getMessage());
          case 4: return new XCN(getMessage());
          default: return null;
       }
   }


}

