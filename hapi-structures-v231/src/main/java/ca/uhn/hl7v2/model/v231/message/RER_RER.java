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


package ca.uhn.hl7v2.model.v231.message;

import ca.uhn.hl7v2.model.v231.group.*;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.*;


/**
 * <p>Represents a RER_RER message structure (see chapter ?). This structure contains the 
 * following elements: </p>
 * <ul>
		                 * <li>1: MSH (MSH - message header segment) <b> </b> </li>
		                 * <li>2: MSA (MSA - message acknowledgment segment) <b> </b> </li>
		                 * <li>3: ERR (ERR - error segment) <b>optional </b> </li>
		                 * <li>4: RER_RER_QRDQRFPIDNTEORCRXERXRRXC (a Group object) <b> repeating</b> </li>
		                 * <li>5: DSC (DSC - Continuation pointer segment) <b>optional </b> </li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class RER_RER extends AbstractMessage  {

    /**
     * Creates a new RER_RER message with DefaultModelClassFactory. 
     */ 
    public RER_RER() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new RER_RER message with custom ModelClassFactory.
     */
    public RER_RER(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
	                          this.add(MSA.class, true, false);
	                          this.add(ERR.class, false, false);
	                          this.add(RER_RER_QRDQRFPIDNTEORCRXERXRRXC.class, true, true);
	                          this.add(DSC.class, false, false);
	       } catch(HL7Exception e) {
          log.error("Unexpected error creating RER_RER - this is probably a bug in the source code generator.", e);
       }
    }


    /** 
     * Returns "2.3.1"
     */
    public String getVersion() {
       return "2.3.1";
    }




    /**
     * <p>
     * Returns
     * MSH (MSH - message header segment) - creates it if necessary
     * </p>
     * 
     *
     */
    public MSH getMSH() { 
       return getTyped("MSH", MSH.class);
    }





    /**
     * <p>
     * Returns
     * MSA (MSA - message acknowledgment segment) - creates it if necessary
     * </p>
     * 
     *
     */
    public MSA getMSA() { 
       return getTyped("MSA", MSA.class);
    }





    /**
     * <p>
     * Returns
     * ERR (ERR - error segment) - creates it if necessary
     * </p>
     * 
     *
     */
    public ERR getERR() { 
       return getTyped("ERR", ERR.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * QRDQRFPIDNTEORCRXERXRRXC (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public RER_RER_QRDQRFPIDNTEORCRXERXRRXC getQRDQRFPIDNTEORCRXERXRRXC() { 
       return getTyped("QRDQRFPIDNTEORCRXERXRRXC", RER_RER_QRDQRFPIDNTEORCRXERXRRXC.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * QRDQRFPIDNTEORCRXERXRRXC (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RER_RER_QRDQRFPIDNTEORCRXERXRRXC getQRDQRFPIDNTEORCRXERXRRXC(int rep) { 
       return getTyped("QRDQRFPIDNTEORCRXERXRRXC", rep, RER_RER_QRDQRFPIDNTEORCRXERXRRXC.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of QRDQRFPIDNTEORCRXERXRRXC 
     * </p>
     * 
     */ 
    public int getQRDQRFPIDNTEORCRXERXRRXCReps() { 
    	return getReps("QRDQRFPIDNTEORCRXERXRRXC");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of QRDQRFPIDNTEORCRXERXRRXC.
     * <p>
     * <p>
     * Note that unlike {@link #getQRDQRFPIDNTEORCRXERXRRXC()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<RER_RER_QRDQRFPIDNTEORCRXERXRRXC> getQRDQRFPIDNTEORCRXERXRRXCAll() throws HL7Exception {
    	return getAllAsList("QRDQRFPIDNTEORCRXERXRRXC", RER_RER_QRDQRFPIDNTEORCRXERXRRXC.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of QRDQRFPIDNTEORCRXERXRRXC (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertQRDQRFPIDNTEORCRXERXRRXC(RER_RER_QRDQRFPIDNTEORCRXERXRRXC structure, int rep) throws HL7Exception { 
       super.insertRepetition( "QRDQRFPIDNTEORCRXERXRRXC", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of QRDQRFPIDNTEORCRXERXRRXC (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RER_RER_QRDQRFPIDNTEORCRXERXRRXC insertQRDQRFPIDNTEORCRXERXRRXC(int rep) throws HL7Exception { 
       return (RER_RER_QRDQRFPIDNTEORCRXERXRRXC)super.insertRepetition("QRDQRFPIDNTEORCRXERXRRXC", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of QRDQRFPIDNTEORCRXERXRRXC (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RER_RER_QRDQRFPIDNTEORCRXERXRRXC removeQRDQRFPIDNTEORCRXERXRRXC(int rep) throws HL7Exception { 
       return (RER_RER_QRDQRFPIDNTEORCRXERXRRXC)super.removeRepetition("QRDQRFPIDNTEORCRXERXRRXC", rep);
    }




    /**
     * <p>
     * Returns
     * DSC (DSC - Continuation pointer segment) - creates it if necessary
     * </p>
     * 
     *
     */
    public DSC getDSC() { 
       return getTyped("DSC", DSC.class);
    }




}

