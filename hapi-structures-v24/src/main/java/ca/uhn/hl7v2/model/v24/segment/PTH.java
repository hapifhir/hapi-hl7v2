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


package ca.uhn.hl7v2.model.v24.segment;

// import ca.uhn.hl7v2.model.v24.group.*;
import ca.uhn.hl7v2.model.v24.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 PTH message segment (Pathway). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PTH-1: Action Code (ID) <b> </b>
     * <li>PTH-2: Pathway ID (CE) <b> </b>
     * <li>PTH-3: Pathway Instance ID (EI) <b> </b>
     * <li>PTH-4: Pathway Established Date/Time (TS) <b> </b>
     * <li>PTH-5: Pathway Life Cycle Status (CE) <b>optional </b>
     * <li>PTH-6: Change Pathway Life Cycle Status Date/Time (TS) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class PTH extends AbstractSegment {

    /** 
     * Creates a new PTH segment
     */
    public PTH(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                              this.add(ID.class, true, 1, 2, new Object[]{ getMessage(), new Integer(287) }, "Action Code");
                                  this.add(CE.class, true, 1, 250, new Object[]{ getMessage() }, "Pathway ID");
                                  this.add(EI.class, true, 1, 60, new Object[]{ getMessage() }, "Pathway Instance ID");
                                  this.add(TS.class, true, 1, 26, new Object[]{ getMessage() }, "Pathway Established Date/Time");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Pathway Life Cycle Status");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Change Pathway Life Cycle Status Date/Time");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PTH - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * PTH-1: "Action Code" - creates it if necessary
     */
    public ID getActionCode() { 
		ID retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PTH-1: "Action Code" - creates it if necessary
     */
    public ID getPth1_ActionCode() { 
		ID retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * PTH-2: "Pathway ID" - creates it if necessary
     */
    public CE getPathwayID() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PTH-2: "Pathway ID" - creates it if necessary
     */
    public CE getPth2_PathwayID() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * PTH-3: "Pathway Instance ID" - creates it if necessary
     */
    public EI getPathwayInstanceID() { 
		EI retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PTH-3: "Pathway Instance ID" - creates it if necessary
     */
    public EI getPth3_PathwayInstanceID() { 
		EI retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * PTH-4: "Pathway Established Date/Time" - creates it if necessary
     */
    public TS getPathwayEstablishedDateTime() { 
		TS retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PTH-4: "Pathway Established Date/Time" - creates it if necessary
     */
    public TS getPth4_PathwayEstablishedDateTime() { 
		TS retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * PTH-5: "Pathway Life Cycle Status" - creates it if necessary
     */
    public CE getPathwayLifeCycleStatus() { 
		CE retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PTH-5: "Pathway Life Cycle Status" - creates it if necessary
     */
    public CE getPth5_PathwayLifeCycleStatus() { 
		CE retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * PTH-6: "Change Pathway Life Cycle Status Date/Time" - creates it if necessary
     */
    public TS getChangePathwayLifeCycleStatusDateTime() { 
		TS retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PTH-6: "Change Pathway Life Cycle Status Date/Time" - creates it if necessary
     */
    public TS getPth6_ChangePathwayLifeCycleStatusDateTime() { 
		TS retVal = this.getTypedField(6, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ID(getMessage(), new Integer( 287 ));
          case 1: return new CE(getMessage());
          case 2: return new EI(getMessage());
          case 3: return new TS(getMessage());
          case 4: return new CE(getMessage());
          case 5: return new TS(getMessage());
          default: return null;
       }
   }


}

