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
 *<p>Represents an HL7 CSP message segment (Clinical Study Phase). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>CSP-1: Study Phase Identifier (CWE) <b> </b>
     * <li>CSP-2: Date/time Study Phase Began (DTM) <b> </b>
     * <li>CSP-3: Date/time Study Phase Ended (DTM) <b>optional </b>
     * <li>CSP-4: Study Phase Evaluability (CWE) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class CSP extends AbstractSegment {

    /** 
     * Creates a new CSP segment
     */
    public CSP(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CWE.class, true, 1, 705, new Object[]{ getMessage() }, "Study Phase Identifier");
                                  this.add(DTM.class, true, 1, 24, new Object[]{ getMessage() }, "Date/time Study Phase Began");
                                  this.add(DTM.class, false, 1, 24, new Object[]{ getMessage() }, "Date/time Study Phase Ended");
                                  this.add(CWE.class, false, 1, 705, new Object[]{ getMessage() }, "Study Phase Evaluability");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating CSP - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * CSP-1: "Study Phase Identifier" - creates it if necessary
     */
    public CWE getStudyPhaseIdentifier() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CSP-1: "Study Phase Identifier" - creates it if necessary
     */
    public CWE getCsp1_StudyPhaseIdentifier() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * CSP-2: "Date/time Study Phase Began" - creates it if necessary
     */
    public DTM getDateTimeStudyPhaseBegan() { 
		DTM retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CSP-2: "Date/time Study Phase Began" - creates it if necessary
     */
    public DTM getCsp2_DateTimeStudyPhaseBegan() { 
		DTM retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * CSP-3: "Date/time Study Phase Ended" - creates it if necessary
     */
    public DTM getDateTimeStudyPhaseEnded() { 
		DTM retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CSP-3: "Date/time Study Phase Ended" - creates it if necessary
     */
    public DTM getCsp3_DateTimeStudyPhaseEnded() { 
		DTM retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * CSP-4: "Study Phase Evaluability" - creates it if necessary
     */
    public CWE getStudyPhaseEvaluability() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CSP-4: "Study Phase Evaluability" - creates it if necessary
     */
    public CWE getCsp4_StudyPhaseEvaluability() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CWE(getMessage());
          case 1: return new DTM(getMessage());
          case 2: return new DTM(getMessage());
          case 3: return new CWE(getMessage());
          default: return null;
       }
   }


}

