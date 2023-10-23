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
 *<p>Represents an HL7 CNS message segment (Clear Notification). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>CNS-1: Starting Notification Reference Number (NM) <b>optional </b>
     * <li>CNS-2: Ending Notification Reference Number (NM) <b>optional </b>
     * <li>CNS-3: Starting Notification Date/Time (DTM) <b>optional </b>
     * <li>CNS-4: Ending Notification Date/Time (DTM) <b>optional </b>
     * <li>CNS-5: Starting Notification Code (CWE) <b>optional </b>
     * <li>CNS-6: Ending Notification Code (CWE) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class CNS extends AbstractSegment {

    /** 
     * Creates a new CNS segment
     */
    public CNS(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Starting Notification Reference Number");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Ending Notification Reference Number");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Starting Notification Date/Time");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Ending Notification Date/Time");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Starting Notification Code");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Ending Notification Code");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating CNS - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * CNS-1: "Starting Notification Reference Number" - creates it if necessary
     */
    public NM getStartingNotificationReferenceNumber() { 
		NM retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CNS-1: "Starting Notification Reference Number" - creates it if necessary
     */
    public NM getCns1_StartingNotificationReferenceNumber() { 
		NM retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * CNS-2: "Ending Notification Reference Number" - creates it if necessary
     */
    public NM getEndingNotificationReferenceNumber() { 
		NM retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CNS-2: "Ending Notification Reference Number" - creates it if necessary
     */
    public NM getCns2_EndingNotificationReferenceNumber() { 
		NM retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * CNS-3: "Starting Notification Date/Time" - creates it if necessary
     */
    public DTM getStartingNotificationDateTime() { 
		DTM retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CNS-3: "Starting Notification Date/Time" - creates it if necessary
     */
    public DTM getCns3_StartingNotificationDateTime() { 
		DTM retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * CNS-4: "Ending Notification Date/Time" - creates it if necessary
     */
    public DTM getEndingNotificationDateTime() { 
		DTM retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CNS-4: "Ending Notification Date/Time" - creates it if necessary
     */
    public DTM getCns4_EndingNotificationDateTime() { 
		DTM retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * CNS-5: "Starting Notification Code" - creates it if necessary
     */
    public CWE getStartingNotificationCode() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CNS-5: "Starting Notification Code" - creates it if necessary
     */
    public CWE getCns5_StartingNotificationCode() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * CNS-6: "Ending Notification Code" - creates it if necessary
     */
    public CWE getEndingNotificationCode() { 
		CWE retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CNS-6: "Ending Notification Code" - creates it if necessary
     */
    public CWE getCns6_EndingNotificationCode() { 
		CWE retVal = this.getTypedField(6, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new NM(getMessage());
          case 1: return new NM(getMessage());
          case 2: return new DTM(getMessage());
          case 3: return new DTM(getMessage());
          case 4: return new CWE(getMessage());
          case 5: return new CWE(getMessage());
          default: return null;
       }
   }


}

