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


package ca.uhn.hl7v2.model.v26.segment;

// import ca.uhn.hl7v2.model.v26.group.*;
import ca.uhn.hl7v2.model.v26.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 NDS message segment (Notification Detail). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>NDS-1: Notification Reference Number (NM) <b> </b>
     * <li>NDS-2: Notification Date/Time (DTM) <b> </b>
     * <li>NDS-3: Notification Alert Severity (CWE) <b> </b>
     * <li>NDS-4: Notification Code (CWE) <b> </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class NDS extends AbstractSegment {

    /** 
     * Creates a new NDS segment
     */
    public NDS(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(NM.class, true, 1, 20, new Object[]{ getMessage() }, "Notification Reference Number");
                                  this.add(DTM.class, true, 1, 24, new Object[]{ getMessage() }, "Notification Date/Time");
                                  this.add(CWE.class, true, 1, 705, new Object[]{ getMessage() }, "Notification Alert Severity");
                                  this.add(CWE.class, true, 1, 705, new Object[]{ getMessage() }, "Notification Code");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating NDS - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * NDS-1: "Notification Reference Number" - creates it if necessary
     */
    public NM getNotificationReferenceNumber() { 
		NM retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NDS-1: "Notification Reference Number" - creates it if necessary
     */
    public NM getNds1_NotificationReferenceNumber() { 
		NM retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * NDS-2: "Notification Date/Time" - creates it if necessary
     */
    public DTM getNotificationDateTime() { 
		DTM retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NDS-2: "Notification Date/Time" - creates it if necessary
     */
    public DTM getNds2_NotificationDateTime() { 
		DTM retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * NDS-3: "Notification Alert Severity" - creates it if necessary
     */
    public CWE getNotificationAlertSeverity() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NDS-3: "Notification Alert Severity" - creates it if necessary
     */
    public CWE getNds3_NotificationAlertSeverity() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * NDS-4: "Notification Code" - creates it if necessary
     */
    public CWE getNotificationCode() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NDS-4: "Notification Code" - creates it if necessary
     */
    public CWE getNds4_NotificationCode() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new NM(getMessage());
          case 1: return new DTM(getMessage());
          case 2: return new CWE(getMessage());
          case 3: return new CWE(getMessage());
          default: return null;
       }
   }


}

