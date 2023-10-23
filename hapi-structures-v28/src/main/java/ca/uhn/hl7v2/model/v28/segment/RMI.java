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


package ca.uhn.hl7v2.model.v28.segment;

// import ca.uhn.hl7v2.model.v28.group.*;
import ca.uhn.hl7v2.model.v28.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 RMI message segment (Risk Management Incident). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>RMI-1: Risk Management Incident Code (CWE) <b>optional </b>
     * <li>RMI-2: Date/Time Incident (DTM) <b>optional </b>
     * <li>RMI-3: Incident Type Code (CWE) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class RMI extends AbstractSegment {

    /** 
     * Creates a new RMI segment
     */
    public RMI(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Risk Management Incident Code");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Date/Time Incident");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Incident Type Code");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating RMI - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * RMI-1: "Risk Management Incident Code" - creates it if necessary
     */
    public CWE getRiskManagementIncidentCode() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RMI-1: "Risk Management Incident Code" - creates it if necessary
     */
    public CWE getRmi1_RiskManagementIncidentCode() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * RMI-2: "Date/Time Incident" - creates it if necessary
     */
    public DTM getDateTimeIncident() { 
		DTM retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RMI-2: "Date/Time Incident" - creates it if necessary
     */
    public DTM getRmi2_DateTimeIncident() { 
		DTM retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * RMI-3: "Incident Type Code" - creates it if necessary
     */
    public CWE getIncidentTypeCode() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RMI-3: "Incident Type Code" - creates it if necessary
     */
    public CWE getRmi3_IncidentTypeCode() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CWE(getMessage());
          case 1: return new DTM(getMessage());
          case 2: return new CWE(getMessage());
          default: return null;
       }
   }


}

