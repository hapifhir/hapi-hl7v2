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


package ca.uhn.hl7v2.model.v25.segment;

// import ca.uhn.hl7v2.model.v25.group.*;
import ca.uhn.hl7v2.model.v25.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 DSC message segment (Continuation Pointer). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>DSC-1: Continuation Pointer (ST) <b>optional </b>
     * <li>DSC-2: Continuation Style (ID) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class DSC extends AbstractSegment {

    /** 
     * Creates a new DSC segment
     */
    public DSC(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ST.class, false, 1, 180, new Object[]{ getMessage() }, "Continuation Pointer");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(398) }, "Continuation Style");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating DSC - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * DSC-1: "Continuation Pointer" - creates it if necessary
     */
    public ST getContinuationPointer() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DSC-1: "Continuation Pointer" - creates it if necessary
     */
    public ST getDsc1_ContinuationPointer() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * DSC-2: "Continuation Style" - creates it if necessary
     */
    public ID getContinuationStyle() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DSC-2: "Continuation Style" - creates it if necessary
     */
    public ID getDsc2_ContinuationStyle() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ST(getMessage());
          case 1: return new ID(getMessage(), new Integer( 398 ));
          default: return null;
       }
   }


}

