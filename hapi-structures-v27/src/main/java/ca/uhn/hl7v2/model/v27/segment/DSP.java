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


package ca.uhn.hl7v2.model.v27.segment;

// import ca.uhn.hl7v2.model.v27.group.*;
import ca.uhn.hl7v2.model.v27.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 DSP message segment (Display Data). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>DSP-1: Set ID - DSP (SI) <b>optional </b>
     * <li>DSP-2: Display Level (SI) <b>optional </b>
     * <li>DSP-3: Data Line (TX) <b> </b>
     * <li>DSP-4: Logical Break Point (ST) <b>optional </b>
     * <li>DSP-5: Result ID (TX) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class DSP extends AbstractSegment {

    /** 
     * Creates a new DSP segment
     */
    public DSP(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, false, 1, 4, new Object[]{ getMessage() }, "Set ID - DSP");
                                  this.add(SI.class, false, 1, 4, new Object[]{ getMessage() }, "Display Level");
                                  this.add(TX.class, true, 1, 0, new Object[]{ getMessage() }, "Data Line");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Logical Break Point");
                                  this.add(TX.class, false, 1, 0, new Object[]{ getMessage() }, "Result ID");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating DSP - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * DSP-1: "Set ID - DSP" - creates it if necessary
     */
    public SI getSetIDDSP() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DSP-1: "Set ID - DSP" - creates it if necessary
     */
    public SI getDsp1_SetIDDSP() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * DSP-2: "Display Level" - creates it if necessary
     */
    public SI getDisplayLevel() { 
		SI retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DSP-2: "Display Level" - creates it if necessary
     */
    public SI getDsp2_DisplayLevel() { 
		SI retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * DSP-3: "Data Line" - creates it if necessary
     */
    public TX getDataLine() { 
		TX retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DSP-3: "Data Line" - creates it if necessary
     */
    public TX getDsp3_DataLine() { 
		TX retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * DSP-4: "Logical Break Point" - creates it if necessary
     */
    public ST getLogicalBreakPoint() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DSP-4: "Logical Break Point" - creates it if necessary
     */
    public ST getDsp4_LogicalBreakPoint() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * DSP-5: "Result ID" - creates it if necessary
     */
    public TX getResultID() { 
		TX retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DSP-5: "Result ID" - creates it if necessary
     */
    public TX getDsp5_ResultID() { 
		TX retVal = this.getTypedField(5, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new SI(getMessage());
          case 2: return new TX(getMessage());
          case 3: return new ST(getMessage());
          case 4: return new TX(getMessage());
          default: return null;
       }
   }


}

