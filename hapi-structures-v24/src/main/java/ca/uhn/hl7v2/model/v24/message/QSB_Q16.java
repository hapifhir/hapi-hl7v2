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


package ca.uhn.hl7v2.model.v24.message;

import ca.uhn.hl7v2.model.v24.group.*;
import ca.uhn.hl7v2.model.v24.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.*;


/**
 * <p>Represents a QSB_Q16 message structure (see chapter 5). This structure contains the 
 * following elements: </p>
 * <ul>
		                 * <li>1: MSH (Message Header) <b> </b> </li>
		                 * <li>2: QPD (Query Parameter Definition) <b> </b> </li>
		                 * <li>3: RCP (Response Control Parameter) <b> </b> </li>
		                 * <li>4: DSC (Continuation Pointer) <b>optional </b> </li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class QSB_Q16 extends AbstractMessage  {

    /**
     * Creates a new QSB_Q16 message with DefaultModelClassFactory. 
     */ 
    public QSB_Q16() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new QSB_Q16 message with custom ModelClassFactory.
     */
    public QSB_Q16(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
	                          this.add(QPD.class, true, false);
	                          this.add(RCP.class, true, false);
	                          this.add(DSC.class, false, false);
	       } catch(HL7Exception e) {
          log.error("Unexpected error creating QSB_Q16 - this is probably a bug in the source code generator.", e);
       }
    }


    /** 
     * Returns "2.4"
     */
    public String getVersion() {
       return "2.4";
    }




    /**
     * <p>
     * Returns
     * MSH (Message Header) - creates it if necessary
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
     * QPD (Query Parameter Definition) - creates it if necessary
     * </p>
     * 
     *
     */
    public QPD getQPD() { 
       return getTyped("QPD", QPD.class);
    }





    /**
     * <p>
     * Returns
     * RCP (Response Control Parameter) - creates it if necessary
     * </p>
     * 
     *
     */
    public RCP getRCP() { 
       return getTyped("RCP", RCP.class);
    }





    /**
     * <p>
     * Returns
     * DSC (Continuation Pointer) - creates it if necessary
     * </p>
     * 
     *
     */
    public DSC getDSC() { 
       return getTyped("DSC", DSC.class);
    }




}

