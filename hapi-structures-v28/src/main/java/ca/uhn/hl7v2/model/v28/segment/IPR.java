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
 *<p>Represents an HL7 IPR message segment (Invoice Processing Results). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>IPR-1: IPR Identifier (EI) <b> </b>
     * <li>IPR-2: Provider Cross Reference Identifier (EI) <b> </b>
     * <li>IPR-3: Payer Cross Reference Identifier (EI) <b> </b>
     * <li>IPR-4: IPR Status (CWE) <b> </b>
     * <li>IPR-5: IPR Date/Time (DTM) <b> </b>
     * <li>IPR-6: Adjudicated/Paid Amount (CP) <b>optional </b>
     * <li>IPR-7: Expected Payment Date/Time (DTM) <b>optional </b>
     * <li>IPR-8: IPR Checksum (ST) <b> </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class IPR extends AbstractSegment {

    /** 
     * Creates a new IPR segment
     */
    public IPR(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(EI.class, true, 1, 0, new Object[]{ getMessage() }, "IPR Identifier");
                                  this.add(EI.class, true, 1, 0, new Object[]{ getMessage() }, "Provider Cross Reference Identifier");
                                  this.add(EI.class, true, 1, 0, new Object[]{ getMessage() }, "Payer Cross Reference Identifier");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "IPR Status");
                                  this.add(DTM.class, true, 1, 0, new Object[]{ getMessage() }, "IPR Date/Time");
                                  this.add(CP.class, false, 1, 0, new Object[]{ getMessage() }, "Adjudicated/Paid Amount");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Expected Payment Date/Time");
                                  this.add(ST.class, true, 1, 0, new Object[]{ getMessage() }, "IPR Checksum");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating IPR - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * IPR-1: "IPR Identifier" - creates it if necessary
     */
    public EI getIPRIdentifier() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IPR-1: "IPR Identifier" - creates it if necessary
     */
    public EI getIpr1_IPRIdentifier() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * IPR-2: "Provider Cross Reference Identifier" - creates it if necessary
     */
    public EI getProviderCrossReferenceIdentifier() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IPR-2: "Provider Cross Reference Identifier" - creates it if necessary
     */
    public EI getIpr2_ProviderCrossReferenceIdentifier() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * IPR-3: "Payer Cross Reference Identifier" - creates it if necessary
     */
    public EI getPayerCrossReferenceIdentifier() { 
		EI retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IPR-3: "Payer Cross Reference Identifier" - creates it if necessary
     */
    public EI getIpr3_PayerCrossReferenceIdentifier() { 
		EI retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * IPR-4: "IPR Status" - creates it if necessary
     */
    public CWE getIPRStatus() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IPR-4: "IPR Status" - creates it if necessary
     */
    public CWE getIpr4_IPRStatus() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * IPR-5: "IPR Date/Time" - creates it if necessary
     */
    public DTM getIPRDateTime() { 
		DTM retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IPR-5: "IPR Date/Time" - creates it if necessary
     */
    public DTM getIpr5_IPRDateTime() { 
		DTM retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * IPR-6: "Adjudicated/Paid Amount" - creates it if necessary
     */
    public CP getAdjudicatedPaidAmount() { 
		CP retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IPR-6: "Adjudicated/Paid Amount" - creates it if necessary
     */
    public CP getIpr6_AdjudicatedPaidAmount() { 
		CP retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * IPR-7: "Expected Payment Date/Time" - creates it if necessary
     */
    public DTM getExpectedPaymentDateTime() { 
		DTM retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IPR-7: "Expected Payment Date/Time" - creates it if necessary
     */
    public DTM getIpr7_ExpectedPaymentDateTime() { 
		DTM retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * IPR-8: "IPR Checksum" - creates it if necessary
     */
    public ST getIPRChecksum() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IPR-8: "IPR Checksum" - creates it if necessary
     */
    public ST getIpr8_IPRChecksum() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new EI(getMessage());
          case 1: return new EI(getMessage());
          case 2: return new EI(getMessage());
          case 3: return new CWE(getMessage());
          case 4: return new DTM(getMessage());
          case 5: return new CP(getMessage());
          case 6: return new DTM(getMessage());
          case 7: return new ST(getMessage());
          default: return null;
       }
   }


}

