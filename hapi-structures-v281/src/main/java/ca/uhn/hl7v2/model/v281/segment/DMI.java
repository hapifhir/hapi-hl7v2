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
 *<p>Represents an HL7 DMI message segment (DRG Master File Information). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>DMI-1: Diagnostic Related Group (CNE) <b>optional </b>
     * <li>DMI-2: Major Diagnostic Category (CNE) <b>optional </b>
     * <li>DMI-3: Lower and Upper Trim Points (NR) <b>optional </b>
     * <li>DMI-4: Average Length of Stay (NM) <b>optional </b>
     * <li>DMI-5: Relative Weight (NM) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class DMI extends AbstractSegment {

    /** 
     * Creates a new DMI segment
     */
    public DMI(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Diagnostic Related Group");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Major Diagnostic Category");
                                  this.add(NR.class, false, 1, 0, new Object[]{ getMessage() }, "Lower and Upper Trim Points");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Average Length of Stay");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Relative Weight");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating DMI - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * DMI-1: "Diagnostic Related Group" - creates it if necessary
     */
    public CNE getDiagnosticRelatedGroup() { 
		CNE retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DMI-1: "Diagnostic Related Group" - creates it if necessary
     */
    public CNE getDmi1_DiagnosticRelatedGroup() { 
		CNE retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * DMI-2: "Major Diagnostic Category" - creates it if necessary
     */
    public CNE getMajorDiagnosticCategory() { 
		CNE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DMI-2: "Major Diagnostic Category" - creates it if necessary
     */
    public CNE getDmi2_MajorDiagnosticCategory() { 
		CNE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * DMI-3: "Lower and Upper Trim Points" - creates it if necessary
     */
    public NR getLowerAndUpperTrimPoints() { 
		NR retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DMI-3: "Lower and Upper Trim Points" - creates it if necessary
     */
    public NR getDmi3_LowerAndUpperTrimPoints() { 
		NR retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * DMI-4: "Average Length of Stay" - creates it if necessary
     */
    public NM getAverageLengthOfStay() { 
		NM retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DMI-4: "Average Length of Stay" - creates it if necessary
     */
    public NM getDmi4_AverageLengthOfStay() { 
		NM retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * DMI-5: "Relative Weight" - creates it if necessary
     */
    public NM getRelativeWeight() { 
		NM retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DMI-5: "Relative Weight" - creates it if necessary
     */
    public NM getDmi5_RelativeWeight() { 
		NM retVal = this.getTypedField(5, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CNE(getMessage());
          case 1: return new CNE(getMessage());
          case 2: return new NR(getMessage());
          case 3: return new NM(getMessage());
          case 4: return new NM(getMessage());
          default: return null;
       }
   }


}

