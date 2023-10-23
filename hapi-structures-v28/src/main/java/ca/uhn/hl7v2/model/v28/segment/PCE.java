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
 *<p>Represents an HL7 PCE message segment (Patient Charge Cost Center Exceptions). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PCE-1: Set ID - PCE (SI) <b> </b>
     * <li>PCE-2: Cost Center Account Number (CX) <b>optional </b>
     * <li>PCE-3: Transaction Code (CWE) <b>optional </b>
     * <li>PCE-4: Transaction amount - unit (CP) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class PCE extends AbstractSegment {

    /** 
     * Creates a new PCE segment
     */
    public PCE(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "Set ID - PCE");
                                  this.add(CX.class, false, 1, 0, new Object[]{ getMessage() }, "Cost Center Account Number");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Transaction Code");
                                  this.add(CP.class, false, 1, 0, new Object[]{ getMessage() }, "Transaction amount - unit");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PCE - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * PCE-1: "Set ID - PCE" - creates it if necessary
     */
    public SI getSetIDPCE() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PCE-1: "Set ID - PCE" - creates it if necessary
     */
    public SI getPce1_SetIDPCE() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * PCE-2: "Cost Center Account Number" - creates it if necessary
     */
    public CX getCostCenterAccountNumber() { 
		CX retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PCE-2: "Cost Center Account Number" - creates it if necessary
     */
    public CX getPce2_CostCenterAccountNumber() { 
		CX retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * PCE-3: "Transaction Code" - creates it if necessary
     */
    public CWE getTransactionCode() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PCE-3: "Transaction Code" - creates it if necessary
     */
    public CWE getPce3_TransactionCode() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * PCE-4: "Transaction amount - unit" - creates it if necessary
     */
    public CP getTransactionAmountUnit() { 
		CP retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PCE-4: "Transaction amount - unit" - creates it if necessary
     */
    public CP getPce4_TransactionAmountUnit() { 
		CP retVal = this.getTypedField(4, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new CX(getMessage());
          case 2: return new CWE(getMessage());
          case 3: return new CP(getMessage());
          default: return null;
       }
   }


}

