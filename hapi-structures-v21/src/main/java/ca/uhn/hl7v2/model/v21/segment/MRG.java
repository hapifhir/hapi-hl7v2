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
 *<p>Represents an HL7 MRG message segment (MERGE PATIENT INFORMATION). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>MRG-1: PRIOR PATIENT ID - INTERNAL (CK) <b> </b>
     * <li>MRG-2: PRIOR ALTERNATE PATIENT ID (CK) <b>optional </b>
     * <li>MRG-3: PRIOR PATIENT ACCOUNT NUMBER (CK) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class MRG extends AbstractSegment {

    /** 
     * Creates a new MRG segment
     */
    public MRG(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CK.class, true, 1, 16, new Object[]{ getMessage() }, "PRIOR PATIENT ID - INTERNAL");
                                  this.add(CK.class, false, 1, 16, new Object[]{ getMessage() }, "PRIOR ALTERNATE PATIENT ID");
                                  this.add(CK.class, false, 1, 20, new Object[]{ getMessage() }, "PRIOR PATIENT ACCOUNT NUMBER");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating MRG - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * MRG-1: "PRIOR PATIENT ID - INTERNAL" - creates it if necessary
     */
    public CK getPRIORPATIENTIDINTERNAL() { 
		CK retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MRG-1: "PRIOR PATIENT ID - INTERNAL" - creates it if necessary
     */
    public CK getMrg1_PRIORPATIENTIDINTERNAL() { 
		CK retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * MRG-2: "PRIOR ALTERNATE PATIENT ID" - creates it if necessary
     */
    public CK getPRIORALTERNATEPATIENTID() { 
		CK retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MRG-2: "PRIOR ALTERNATE PATIENT ID" - creates it if necessary
     */
    public CK getMrg2_PRIORALTERNATEPATIENTID() { 
		CK retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * MRG-3: "PRIOR PATIENT ACCOUNT NUMBER" - creates it if necessary
     */
    public CK getPRIORPATIENTACCOUNTNUMBER() { 
		CK retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MRG-3: "PRIOR PATIENT ACCOUNT NUMBER" - creates it if necessary
     */
    public CK getMrg3_PRIORPATIENTACCOUNTNUMBER() { 
		CK retVal = this.getTypedField(3, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CK(getMessage());
          case 1: return new CK(getMessage());
          case 2: return new CK(getMessage());
          default: return null;
       }
   }


}

