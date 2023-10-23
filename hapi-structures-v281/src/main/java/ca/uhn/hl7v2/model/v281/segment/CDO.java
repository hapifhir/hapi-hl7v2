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
 *<p>Represents an HL7 CDO message segment (Cumulative Dosage). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>CDO-1: Set ID - CDO (SI) <b>optional </b>
     * <li>CDO-2: Action Code (ID) <b>optional </b>
     * <li>CDO-3: Cumulative Dosage Limit (CQ) <b>optional </b>
     * <li>CDO-4: Cumulative Dosage Limit Time Interval (CQ) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class CDO extends AbstractSegment {

    /** 
     * Creates a new CDO segment
     */
    public CDO(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, false, 1, 0, new Object[]{ getMessage() }, "Set ID - CDO");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(206) }, "Action Code");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Cumulative Dosage Limit");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Cumulative Dosage Limit Time Interval");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating CDO - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * CDO-1: "Set ID - CDO" - creates it if necessary
     */
    public SI getSetIDCDO() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CDO-1: "Set ID - CDO" - creates it if necessary
     */
    public SI getCdo1_SetIDCDO() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * CDO-2: "Action Code" - creates it if necessary
     */
    public ID getActionCode() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CDO-2: "Action Code" - creates it if necessary
     */
    public ID getCdo2_ActionCode() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * CDO-3: "Cumulative Dosage Limit" - creates it if necessary
     */
    public CQ getCumulativeDosageLimit() { 
		CQ retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CDO-3: "Cumulative Dosage Limit" - creates it if necessary
     */
    public CQ getCdo3_CumulativeDosageLimit() { 
		CQ retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * CDO-4: "Cumulative Dosage Limit Time Interval" - creates it if necessary
     */
    public CQ getCumulativeDosageLimitTimeInterval() { 
		CQ retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CDO-4: "Cumulative Dosage Limit Time Interval" - creates it if necessary
     */
    public CQ getCdo4_CumulativeDosageLimitTimeInterval() { 
		CQ retVal = this.getTypedField(4, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new ID(getMessage(), new Integer( 206 ));
          case 2: return new CQ(getMessage());
          case 3: return new CQ(getMessage());
          default: return null;
       }
   }


}

