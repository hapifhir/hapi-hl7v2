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


package ca.uhn.hl7v2.model.v281.group;

import ca.uhn.hl7v2.model.v281.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a EHC_E15_PAYMENT_REMITTANCE_DETAIL_INFO group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: IPR (Invoice Processing Results) <b>  </b></li>
                         * <li>2: IVC (Invoice Segment) <b>  </b></li>
                         * <li>3: EHC_E15_PRODUCT_SERVICE_SECTION (a Group object) <b> repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class EHC_E15_PAYMENT_REMITTANCE_DETAIL_INFO extends AbstractGroup {

    /** 
     * Creates a new EHC_E15_PAYMENT_REMITTANCE_DETAIL_INFO group
     */
    public EHC_E15_PAYMENT_REMITTANCE_DETAIL_INFO(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(IPR.class, true, false, false);
                                  this.add(IVC.class, true, false, false);
                                  this.add(EHC_E15_PRODUCT_SERVICE_SECTION.class, true, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating EHC_E15_PAYMENT_REMITTANCE_DETAIL_INFO - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.8.1"
     */
    public String getVersion() {
       return "2.8.1";
    }



    /**
     * Returns
     * IPR (Invoice Processing Results) - creates it if necessary
     */
    public IPR getIPR() { 
       IPR retVal = getTyped("IPR", IPR.class);
       return retVal;
    }




    /**
     * Returns
     * IVC (Invoice Segment) - creates it if necessary
     */
    public IVC getIVC() { 
       IVC retVal = getTyped("IVC", IVC.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * PRODUCT_SERVICE_SECTION (a Group object) - creates it if necessary
     */
    public EHC_E15_PRODUCT_SERVICE_SECTION getPRODUCT_SERVICE_SECTION() { 
       EHC_E15_PRODUCT_SERVICE_SECTION retVal = getTyped("PRODUCT_SERVICE_SECTION", EHC_E15_PRODUCT_SERVICE_SECTION.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PRODUCT_SERVICE_SECTION (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public EHC_E15_PRODUCT_SERVICE_SECTION getPRODUCT_SERVICE_SECTION(int rep) { 
       EHC_E15_PRODUCT_SERVICE_SECTION retVal = getTyped("PRODUCT_SERVICE_SECTION", rep, EHC_E15_PRODUCT_SERVICE_SECTION.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PRODUCT_SERVICE_SECTION 
     */ 
    public int getPRODUCT_SERVICE_SECTIONReps() {  
        return getReps("PRODUCT_SERVICE_SECTION");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PRODUCT_SERVICE_SECTION.
     * <p>
     * <p>
     * Note that unlike {@link #getPRODUCT_SERVICE_SECTION()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<EHC_E15_PRODUCT_SERVICE_SECTION> getPRODUCT_SERVICE_SECTIONAll() throws HL7Exception {
    	return getAllAsList("PRODUCT_SERVICE_SECTION", EHC_E15_PRODUCT_SERVICE_SECTION.class);
    } 

    /**
     * Inserts a specific repetition of PRODUCT_SERVICE_SECTION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPRODUCT_SERVICE_SECTION(EHC_E15_PRODUCT_SERVICE_SECTION structure, int rep) throws HL7Exception { 
       super.insertRepetition("PRODUCT_SERVICE_SECTION", structure, rep);
    }


    /**
     * Inserts a specific repetition of PRODUCT_SERVICE_SECTION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public EHC_E15_PRODUCT_SERVICE_SECTION insertPRODUCT_SERVICE_SECTION(int rep) throws HL7Exception { 
       return (EHC_E15_PRODUCT_SERVICE_SECTION)super.insertRepetition("PRODUCT_SERVICE_SECTION", rep);
    }


    /**
     * Removes a specific repetition of PRODUCT_SERVICE_SECTION (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public EHC_E15_PRODUCT_SERVICE_SECTION removePRODUCT_SERVICE_SECTION(int rep) throws HL7Exception { 
       return (EHC_E15_PRODUCT_SERVICE_SECTION)super.removeRepetition("PRODUCT_SERVICE_SECTION", rep);
    }



}

