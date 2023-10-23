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
 *<p>Represents an HL7 TCD message segment (Test Code Detail). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>TCD-1: Universal Service Identifier (CE) <b> </b>
     * <li>TCD-2: Auto-Dilution Factor (SN) <b>optional </b>
     * <li>TCD-3: Rerun Dilution Factor (SN) <b>optional </b>
     * <li>TCD-4: Pre-Dilution Factor (SN) <b>optional </b>
     * <li>TCD-5: Endogenous Content of Pre-Dilution Diluent (SN) <b>optional </b>
     * <li>TCD-6: Automatic Repeat Allowed (ID) <b>optional </b>
     * <li>TCD-7: Reflex Allowed (ID) <b>optional </b>
     * <li>TCD-8: Analyte Repeat Status (CE) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class TCD extends AbstractSegment {

    /** 
     * Creates a new TCD segment
     */
    public TCD(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CE.class, true, 1, 250, new Object[]{ getMessage() }, "Universal Service Identifier");
                                  this.add(SN.class, false, 1, 20, new Object[]{ getMessage() }, "Auto-Dilution Factor");
                                  this.add(SN.class, false, 1, 20, new Object[]{ getMessage() }, "Rerun Dilution Factor");
                                  this.add(SN.class, false, 1, 20, new Object[]{ getMessage() }, "Pre-Dilution Factor");
                                  this.add(SN.class, false, 1, 20, new Object[]{ getMessage() }, "Endogenous Content of Pre-Dilution Diluent");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Automatic Repeat Allowed");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Reflex Allowed");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Analyte Repeat Status");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating TCD - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * TCD-1: "Universal Service Identifier" - creates it if necessary
     */
    public CE getUniversalServiceIdentifier() { 
		CE retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TCD-1: "Universal Service Identifier" - creates it if necessary
     */
    public CE getTcd1_UniversalServiceIdentifier() { 
		CE retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * TCD-2: "Auto-Dilution Factor" - creates it if necessary
     */
    public SN getAutoDilutionFactor() { 
		SN retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TCD-2: "Auto-Dilution Factor" - creates it if necessary
     */
    public SN getTcd2_AutoDilutionFactor() { 
		SN retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * TCD-3: "Rerun Dilution Factor" - creates it if necessary
     */
    public SN getRerunDilutionFactor() { 
		SN retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TCD-3: "Rerun Dilution Factor" - creates it if necessary
     */
    public SN getTcd3_RerunDilutionFactor() { 
		SN retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * TCD-4: "Pre-Dilution Factor" - creates it if necessary
     */
    public SN getPreDilutionFactor() { 
		SN retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TCD-4: "Pre-Dilution Factor" - creates it if necessary
     */
    public SN getTcd4_PreDilutionFactor() { 
		SN retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * TCD-5: "Endogenous Content of Pre-Dilution Diluent" - creates it if necessary
     */
    public SN getEndogenousContentOfPreDilutionDiluent() { 
		SN retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TCD-5: "Endogenous Content of Pre-Dilution Diluent" - creates it if necessary
     */
    public SN getTcd5_EndogenousContentOfPreDilutionDiluent() { 
		SN retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * TCD-6: "Automatic Repeat Allowed" - creates it if necessary
     */
    public ID getAutomaticRepeatAllowed() { 
		ID retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TCD-6: "Automatic Repeat Allowed" - creates it if necessary
     */
    public ID getTcd6_AutomaticRepeatAllowed() { 
		ID retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * TCD-7: "Reflex Allowed" - creates it if necessary
     */
    public ID getReflexAllowed() { 
		ID retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TCD-7: "Reflex Allowed" - creates it if necessary
     */
    public ID getTcd7_ReflexAllowed() { 
		ID retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * TCD-8: "Analyte Repeat Status" - creates it if necessary
     */
    public CE getAnalyteRepeatStatus() { 
		CE retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TCD-8: "Analyte Repeat Status" - creates it if necessary
     */
    public CE getTcd8_AnalyteRepeatStatus() { 
		CE retVal = this.getTypedField(8, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CE(getMessage());
          case 1: return new SN(getMessage());
          case 2: return new SN(getMessage());
          case 3: return new SN(getMessage());
          case 4: return new SN(getMessage());
          case 5: return new ID(getMessage(), new Integer( 136 ));
          case 6: return new ID(getMessage(), new Integer( 136 ));
          case 7: return new CE(getMessage());
          default: return null;
       }
   }


}

