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


package ca.uhn.hl7v2.model.v281.segment;

// import ca.uhn.hl7v2.model.v281.group.*;
import ca.uhn.hl7v2.model.v281.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 EQP message segment (Equipment/log Service). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>EQP-1: Event type (CWE) <b> </b>
     * <li>EQP-2: File Name (ST) <b>optional </b>
     * <li>EQP-3: Start Date/Time (DTM) <b> </b>
     * <li>EQP-4: End Date/Time (DTM) <b>optional </b>
     * <li>EQP-5: Transaction Data (FT) <b> </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class EQP extends AbstractSegment {

    /** 
     * Creates a new EQP segment
     */
    public EQP(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Event type");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "File Name");
                                  this.add(DTM.class, true, 1, 0, new Object[]{ getMessage() }, "Start Date/Time");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "End Date/Time");
                                  this.add(FT.class, true, 1, 0, new Object[]{ getMessage() }, "Transaction Data");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating EQP - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * EQP-1: "Event type" - creates it if necessary
     */
    public CWE getEventType() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * EQP-1: "Event type" - creates it if necessary
     */
    public CWE getEqp1_EventType() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * EQP-2: "File Name" - creates it if necessary
     */
    public ST getFileName() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * EQP-2: "File Name" - creates it if necessary
     */
    public ST getEqp2_FileName() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * EQP-3: "Start Date/Time" - creates it if necessary
     */
    public DTM getStartDateTime() { 
		DTM retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * EQP-3: "Start Date/Time" - creates it if necessary
     */
    public DTM getEqp3_StartDateTime() { 
		DTM retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * EQP-4: "End Date/Time" - creates it if necessary
     */
    public DTM getEndDateTime() { 
		DTM retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * EQP-4: "End Date/Time" - creates it if necessary
     */
    public DTM getEqp4_EndDateTime() { 
		DTM retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * EQP-5: "Transaction Data" - creates it if necessary
     */
    public FT getTransactionData() { 
		FT retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * EQP-5: "Transaction Data" - creates it if necessary
     */
    public FT getEqp5_TransactionData() { 
		FT retVal = this.getTypedField(5, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CWE(getMessage());
          case 1: return new ST(getMessage());
          case 2: return new DTM(getMessage());
          case 3: return new DTM(getMessage());
          case 4: return new FT(getMessage());
          default: return null;
       }
   }


}

