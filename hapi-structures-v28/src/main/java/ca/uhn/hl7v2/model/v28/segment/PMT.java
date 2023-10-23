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
 *<p>Represents an HL7 PMT message segment (Payment Information). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PMT-1: Payment/Remittance Advice Number (EI) <b> </b>
     * <li>PMT-2: Payment/Remittance Effective Date/Time (DTM) <b> </b>
     * <li>PMT-3: Payment/Remittance Expiration Date/Time (DTM) <b> </b>
     * <li>PMT-4: Payment Method (CWE) <b> </b>
     * <li>PMT-5: Payment/Remittance Date/Time (DTM) <b> </b>
     * <li>PMT-6: Payment/Remittance Amount (CP) <b> </b>
     * <li>PMT-7: Check Number (EI) <b>optional </b>
     * <li>PMT-8: Payee Bank Identification (XON) <b>optional </b>
     * <li>PMT-9: Payee Transit Number (ST) <b>optional </b>
     * <li>PMT-10: Payee Bank Account ID (CX) <b>optional </b>
     * <li>PMT-11: Payment Organization (XON) <b> </b>
     * <li>PMT-12: ESR-Code-Line (ST) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class PMT extends AbstractSegment {

    /** 
     * Creates a new PMT segment
     */
    public PMT(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(EI.class, true, 1, 0, new Object[]{ getMessage() }, "Payment/Remittance Advice Number");
                                  this.add(DTM.class, true, 1, 0, new Object[]{ getMessage() }, "Payment/Remittance Effective Date/Time");
                                  this.add(DTM.class, true, 1, 0, new Object[]{ getMessage() }, "Payment/Remittance Expiration Date/Time");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Payment Method");
                                  this.add(DTM.class, true, 1, 0, new Object[]{ getMessage() }, "Payment/Remittance Date/Time");
                                  this.add(CP.class, true, 1, 0, new Object[]{ getMessage() }, "Payment/Remittance Amount");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Check Number");
                                  this.add(XON.class, false, 1, 0, new Object[]{ getMessage() }, "Payee Bank Identification");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Payee Transit Number");
                                  this.add(CX.class, false, 1, 0, new Object[]{ getMessage() }, "Payee Bank Account ID");
                                  this.add(XON.class, true, 1, 0, new Object[]{ getMessage() }, "Payment Organization");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "ESR-Code-Line");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PMT - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * PMT-1: "Payment/Remittance Advice Number" - creates it if necessary
     */
    public EI getPaymentRemittanceAdviceNumber() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PMT-1: "Payment/Remittance Advice Number" - creates it if necessary
     */
    public EI getPmt1_PaymentRemittanceAdviceNumber() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * PMT-2: "Payment/Remittance Effective Date/Time" - creates it if necessary
     */
    public DTM getPaymentRemittanceEffectiveDateTime() { 
		DTM retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PMT-2: "Payment/Remittance Effective Date/Time" - creates it if necessary
     */
    public DTM getPmt2_PaymentRemittanceEffectiveDateTime() { 
		DTM retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * PMT-3: "Payment/Remittance Expiration Date/Time" - creates it if necessary
     */
    public DTM getPaymentRemittanceExpirationDateTime() { 
		DTM retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PMT-3: "Payment/Remittance Expiration Date/Time" - creates it if necessary
     */
    public DTM getPmt3_PaymentRemittanceExpirationDateTime() { 
		DTM retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * PMT-4: "Payment Method" - creates it if necessary
     */
    public CWE getPaymentMethod() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PMT-4: "Payment Method" - creates it if necessary
     */
    public CWE getPmt4_PaymentMethod() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * PMT-5: "Payment/Remittance Date/Time" - creates it if necessary
     */
    public DTM getPaymentRemittanceDateTime() { 
		DTM retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PMT-5: "Payment/Remittance Date/Time" - creates it if necessary
     */
    public DTM getPmt5_PaymentRemittanceDateTime() { 
		DTM retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * PMT-6: "Payment/Remittance Amount" - creates it if necessary
     */
    public CP getPaymentRemittanceAmount() { 
		CP retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PMT-6: "Payment/Remittance Amount" - creates it if necessary
     */
    public CP getPmt6_PaymentRemittanceAmount() { 
		CP retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * PMT-7: "Check Number" - creates it if necessary
     */
    public EI getCheckNumber() { 
		EI retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PMT-7: "Check Number" - creates it if necessary
     */
    public EI getPmt7_CheckNumber() { 
		EI retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * PMT-8: "Payee Bank Identification" - creates it if necessary
     */
    public XON getPayeeBankIdentification() { 
		XON retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PMT-8: "Payee Bank Identification" - creates it if necessary
     */
    public XON getPmt8_PayeeBankIdentification() { 
		XON retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * PMT-9: "Payee Transit Number" - creates it if necessary
     */
    public ST getPayeeTransitNumber() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PMT-9: "Payee Transit Number" - creates it if necessary
     */
    public ST getPmt9_PayeeTransitNumber() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * PMT-10: "Payee Bank Account ID" - creates it if necessary
     */
    public CX getPayeeBankAccountID() { 
		CX retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PMT-10: "Payee Bank Account ID" - creates it if necessary
     */
    public CX getPmt10_PayeeBankAccountID() { 
		CX retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * PMT-11: "Payment Organization" - creates it if necessary
     */
    public XON getPaymentOrganization() { 
		XON retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PMT-11: "Payment Organization" - creates it if necessary
     */
    public XON getPmt11_PaymentOrganization() { 
		XON retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * PMT-12: "ESR-Code-Line" - creates it if necessary
     */
    public ST getESRCodeLine() { 
		ST retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PMT-12: "ESR-Code-Line" - creates it if necessary
     */
    public ST getPmt12_ESRCodeLine() { 
		ST retVal = this.getTypedField(12, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new EI(getMessage());
          case 1: return new DTM(getMessage());
          case 2: return new DTM(getMessage());
          case 3: return new CWE(getMessage());
          case 4: return new DTM(getMessage());
          case 5: return new CP(getMessage());
          case 6: return new EI(getMessage());
          case 7: return new XON(getMessage());
          case 8: return new ST(getMessage());
          case 9: return new CX(getMessage());
          case 10: return new XON(getMessage());
          case 11: return new ST(getMessage());
          default: return null;
       }
   }


}

