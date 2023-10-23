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
 *<p>Represents an HL7 NSC message segment (STATUS CHANGE). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>NSC-1: NETWORK CHANGE TYPE (ID) <b> </b>
     * <li>NSC-2: CURRENT CPU (ST) <b>optional </b>
     * <li>NSC-3: CURRENT FILESERVER (ST) <b>optional </b>
     * <li>NSC-4: CURRENT APPLICATION (ST) <b>optional </b>
     * <li>NSC-5: CURRENT FACILITY (ST) <b>optional </b>
     * <li>NSC-6: NEW CPU (ST) <b>optional </b>
     * <li>NSC-7: NEW FILESERVER (ST) <b>optional </b>
     * <li>NSC-8: NEW APPLICATION (ST) <b>optional </b>
     * <li>NSC-9: NEW FACILITY (ST) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class NSC extends AbstractSegment {

    /** 
     * Creates a new NSC segment
     */
    public NSC(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                              this.add(ID.class, true, 1, 4, new Object[]{ getMessage(), new Integer(0) }, "NETWORK CHANGE TYPE");
                                  this.add(ST.class, false, 1, 30, new Object[]{ getMessage() }, "CURRENT CPU");
                                  this.add(ST.class, false, 1, 30, new Object[]{ getMessage() }, "CURRENT FILESERVER");
                                  this.add(ST.class, false, 1, 30, new Object[]{ getMessage() }, "CURRENT APPLICATION");
                                  this.add(ST.class, false, 1, 30, new Object[]{ getMessage() }, "CURRENT FACILITY");
                                  this.add(ST.class, false, 1, 30, new Object[]{ getMessage() }, "NEW CPU");
                                  this.add(ST.class, false, 1, 30, new Object[]{ getMessage() }, "NEW FILESERVER");
                                  this.add(ST.class, false, 1, 30, new Object[]{ getMessage() }, "NEW APPLICATION");
                                  this.add(ST.class, false, 1, 30, new Object[]{ getMessage() }, "NEW FACILITY");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating NSC - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * NSC-1: "NETWORK CHANGE TYPE" - creates it if necessary
     */
    public ID getNETWORKCHANGETYPE() { 
		ID retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NSC-1: "NETWORK CHANGE TYPE" - creates it if necessary
     */
    public ID getNsc1_NETWORKCHANGETYPE() { 
		ID retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * NSC-2: "CURRENT CPU" - creates it if necessary
     */
    public ST getCURRENTCPU() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NSC-2: "CURRENT CPU" - creates it if necessary
     */
    public ST getNsc2_CURRENTCPU() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * NSC-3: "CURRENT FILESERVER" - creates it if necessary
     */
    public ST getCURRENTFILESERVER() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NSC-3: "CURRENT FILESERVER" - creates it if necessary
     */
    public ST getNsc3_CURRENTFILESERVER() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * NSC-4: "CURRENT APPLICATION" - creates it if necessary
     */
    public ST getCURRENTAPPLICATION() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NSC-4: "CURRENT APPLICATION" - creates it if necessary
     */
    public ST getNsc4_CURRENTAPPLICATION() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * NSC-5: "CURRENT FACILITY" - creates it if necessary
     */
    public ST getCURRENTFACILITY() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NSC-5: "CURRENT FACILITY" - creates it if necessary
     */
    public ST getNsc5_CURRENTFACILITY() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * NSC-6: "NEW CPU" - creates it if necessary
     */
    public ST getNEWCPU() { 
		ST retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NSC-6: "NEW CPU" - creates it if necessary
     */
    public ST getNsc6_NEWCPU() { 
		ST retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * NSC-7: "NEW FILESERVER" - creates it if necessary
     */
    public ST getNEWFILESERVER() { 
		ST retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NSC-7: "NEW FILESERVER" - creates it if necessary
     */
    public ST getNsc7_NEWFILESERVER() { 
		ST retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * NSC-8: "NEW APPLICATION" - creates it if necessary
     */
    public ST getNEWAPPLICATION() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NSC-8: "NEW APPLICATION" - creates it if necessary
     */
    public ST getNsc8_NEWAPPLICATION() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * NSC-9: "NEW FACILITY" - creates it if necessary
     */
    public ST getNEWFACILITY() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NSC-9: "NEW FACILITY" - creates it if necessary
     */
    public ST getNsc9_NEWFACILITY() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ID(getMessage(), new Integer( 0 ));
          case 1: return new ST(getMessage());
          case 2: return new ST(getMessage());
          case 3: return new ST(getMessage());
          case 4: return new ST(getMessage());
          case 5: return new ST(getMessage());
          case 6: return new ST(getMessage());
          case 7: return new ST(getMessage());
          case 8: return new ST(getMessage());
          default: return null;
       }
   }


}

