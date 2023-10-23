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


package ca.uhn.hl7v2.model.v21.segment;

// import ca.uhn.hl7v2.model.v21.group.*;
import ca.uhn.hl7v2.model.v21.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 BTS message segment (BATCH TRAILER). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>BTS-1: BATCH MESSAGE COUNT (ST) <b>optional </b>
     * <li>BTS-2: BATCH COMMENT (ST) <b>optional </b>
     * <li>BTS-3: BATCH TOTALS (CM) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class BTS extends AbstractSegment {

    /** 
     * Creates a new BTS segment
     */
    public BTS(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ST.class, false, 1, 10, new Object[]{ getMessage() }, "BATCH MESSAGE COUNT");
                                  this.add(ST.class, false, 1, 80, new Object[]{ getMessage() }, "BATCH COMMENT");
                                  this.add(CM.class, false, 1, 100, new Object[]{ getMessage() }, "BATCH TOTALS");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating BTS - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * BTS-1: "BATCH MESSAGE COUNT" - creates it if necessary
     */
    public ST getBATCHMESSAGECOUNT() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BTS-1: "BATCH MESSAGE COUNT" - creates it if necessary
     */
    public ST getBts1_BATCHMESSAGECOUNT() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * BTS-2: "BATCH COMMENT" - creates it if necessary
     */
    public ST getBATCHCOMMENT() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BTS-2: "BATCH COMMENT" - creates it if necessary
     */
    public ST getBts2_BATCHCOMMENT() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * BTS-3: "BATCH TOTALS" - creates it if necessary
     */
    public CM getBATCHTOTALS() { 
		CM retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BTS-3: "BATCH TOTALS" - creates it if necessary
     */
    public CM getBts3_BATCHTOTALS() { 
		CM retVal = this.getTypedField(3, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ST(getMessage());
          case 1: return new ST(getMessage());
          case 2: return new CM(getMessage());
          default: return null;
       }
   }


}

