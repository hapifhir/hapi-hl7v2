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
 * <p>Represents a VXX_V02 message structure (see chapter ?). This structure contains the 
 * following elements: </p>
 * <ul>
		                 * <li>1: MSH (MSH - message header segment) <b> </b> </li>
		                 * <li>2: MSA (MSA - message acknowledgment segment) <b> </b> </li>
		                 * <li>3: QRD (QRD - original-style query definition segment) <b> </b> </li>
		                 * <li>4: QRF (QRF - original style query filter segment) <b>optional </b> </li>
		                 * <li>5: VXX_V02_PIDNK1 (a Group object) <b> repeating</b> </li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class VXX_V02 extends AbstractMessage  {

    /**
     * Creates a new VXX_V02 message with DefaultModelClassFactory. 
     */ 
    public VXX_V02() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new VXX_V02 message with custom ModelClassFactory.
     */
    public VXX_V02(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
	                          this.add(MSA.class, true, false);
	                          this.add(QRD.class, true, false);
	                          this.add(QRF.class, false, false);
	                          this.add(VXX_V02_PIDNK1.class, true, true);
	       } catch(HL7Exception e) {
          log.error("Unexpected error creating VXX_V02 - this is probably a bug in the source code generator.", e);
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
     * QRD (QRD - original-style query definition segment) - creates it if necessary
     * </p>
     * 
     *
     */
    public QRD getQRD() { 
       return getTyped("QRD", QRD.class);
    }





    /**
     * <p>
     * Returns
     * QRF (QRF - original style query filter segment) - creates it if necessary
     * </p>
     * 
     *
     */
    public QRF getQRF() { 
       return getTyped("QRF", QRF.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * PIDNK1 (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public VXX_V02_PIDNK1 getPIDNK1() { 
       return getTyped("PIDNK1", VXX_V02_PIDNK1.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * PIDNK1 (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public VXX_V02_PIDNK1 getPIDNK1(int rep) { 
       return getTyped("PIDNK1", rep, VXX_V02_PIDNK1.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of PIDNK1 
     * </p>
     * 
     */ 
    public int getPIDNK1Reps() { 
    	return getReps("PIDNK1");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PIDNK1.
     * <p>
     * <p>
     * Note that unlike {@link #getPIDNK1()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<VXX_V02_PIDNK1> getPIDNK1All() throws HL7Exception {
    	return getAllAsList("PIDNK1", VXX_V02_PIDNK1.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of PIDNK1 (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPIDNK1(VXX_V02_PIDNK1 structure, int rep) throws HL7Exception { 
       super.insertRepetition( "PIDNK1", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of PIDNK1 (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public VXX_V02_PIDNK1 insertPIDNK1(int rep) throws HL7Exception { 
       return (VXX_V02_PIDNK1)super.insertRepetition("PIDNK1", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of PIDNK1 (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public VXX_V02_PIDNK1 removePIDNK1(int rep) throws HL7Exception { 
       return (VXX_V02_PIDNK1)super.removeRepetition("PIDNK1", rep);
    }



}

