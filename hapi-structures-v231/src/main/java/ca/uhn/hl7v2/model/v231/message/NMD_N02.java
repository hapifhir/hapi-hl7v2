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
 * <p>Represents a NMD_N02 message structure (see chapter 14). This structure contains the 
 * following elements: </p>
 * <ul>
		                 * <li>1: MSH (MSH - message header segment) <b> </b> </li>
		                 * <li>2: NMD_N02_NCKNTENSTNTENSCNTE (a Group object) <b> repeating</b> </li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class NMD_N02 extends AbstractMessage  {

    /**
     * Creates a new NMD_N02 message with DefaultModelClassFactory. 
     */ 
    public NMD_N02() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new NMD_N02 message with custom ModelClassFactory.
     */
    public NMD_N02(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
	                          this.add(NMD_N02_NCKNTENSTNTENSCNTE.class, true, true);
	       } catch(HL7Exception e) {
          log.error("Unexpected error creating NMD_N02 - this is probably a bug in the source code generator.", e);
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
     * the first repetition of 
     * NCKNTENSTNTENSCNTE (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public NMD_N02_NCKNTENSTNTENSCNTE getNCKNTENSTNTENSCNTE() { 
       return getTyped("NCKNTENSTNTENSCNTE", NMD_N02_NCKNTENSTNTENSCNTE.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * NCKNTENSTNTENSCNTE (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public NMD_N02_NCKNTENSTNTENSCNTE getNCKNTENSTNTENSCNTE(int rep) { 
       return getTyped("NCKNTENSTNTENSCNTE", rep, NMD_N02_NCKNTENSTNTENSCNTE.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of NCKNTENSTNTENSCNTE 
     * </p>
     * 
     */ 
    public int getNCKNTENSTNTENSCNTEReps() { 
    	return getReps("NCKNTENSTNTENSCNTE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of NCKNTENSTNTENSCNTE.
     * <p>
     * <p>
     * Note that unlike {@link #getNCKNTENSTNTENSCNTE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<NMD_N02_NCKNTENSTNTENSCNTE> getNCKNTENSTNTENSCNTEAll() throws HL7Exception {
    	return getAllAsList("NCKNTENSTNTENSCNTE", NMD_N02_NCKNTENSTNTENSCNTE.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of NCKNTENSTNTENSCNTE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertNCKNTENSTNTENSCNTE(NMD_N02_NCKNTENSTNTENSCNTE structure, int rep) throws HL7Exception { 
       super.insertRepetition( "NCKNTENSTNTENSCNTE", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of NCKNTENSTNTENSCNTE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public NMD_N02_NCKNTENSTNTENSCNTE insertNCKNTENSTNTENSCNTE(int rep) throws HL7Exception { 
       return (NMD_N02_NCKNTENSTNTENSCNTE)super.insertRepetition("NCKNTENSTNTENSCNTE", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of NCKNTENSTNTENSCNTE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public NMD_N02_NCKNTENSTNTENSCNTE removeNCKNTENSTNTENSCNTE(int rep) throws HL7Exception { 
       return (NMD_N02_NCKNTENSTNTENSCNTE)super.removeRepetition("NCKNTENSTNTENSCNTE", rep);
    }



}

