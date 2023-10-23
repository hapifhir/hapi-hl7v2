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


package ca.uhn.hl7v2.model.v22.segment;

// import ca.uhn.hl7v2.model.v22.group.*;
import ca.uhn.hl7v2.model.v22.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 DG1 message segment (DIAGNOSIS). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>DG1-1: Set ID - diagnosis (SI) <b> </b>
     * <li>DG1-2: Diagnosis coding method (ID) <b> </b>
     * <li>DG1-3: Diagnosis code (ID) <b>optional </b>
     * <li>DG1-4: Diagnosis description (ST) <b>optional </b>
     * <li>DG1-5: Diagnosis date / time (TS) <b>optional </b>
     * <li>DG1-6: Diagnosis / DRG type (ID) <b> </b>
     * <li>DG1-7: Major diagnostic category (CE) <b>optional </b>
     * <li>DG1-8: Diagnostic related group (ID) <b>optional </b>
     * <li>DG1-9: DRG approval indicator (ID) <b>optional </b>
     * <li>DG1-10: DRG grouper review code (ID) <b>optional </b>
     * <li>DG1-11: Outlier type (ID) <b>optional </b>
     * <li>DG1-12: Outlier days (NM) <b>optional </b>
     * <li>DG1-13: Outlier cost (NM) <b>optional </b>
     * <li>DG1-14: Grouper version and type (ST) <b>optional </b>
     * <li>DG1-15: Diagnosis / DRG priority (NM) <b>optional </b>
     * <li>DG1-16: Diagnosing clinician (CN) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class DG1 extends AbstractSegment {

    /** 
     * Creates a new DG1 segment
     */
    public DG1(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "Set ID - diagnosis");
                                              this.add(ID.class, true, 1, 2, new Object[]{ getMessage(), new Integer(53) }, "Diagnosis coding method");
                                              this.add(ID.class, false, 1, 8, new Object[]{ getMessage(), new Integer(51) }, "Diagnosis code");
                                  this.add(ST.class, false, 1, 40, new Object[]{ getMessage() }, "Diagnosis description");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Diagnosis date / time");
                                              this.add(ID.class, true, 1, 2, new Object[]{ getMessage(), new Integer(52) }, "Diagnosis / DRG type");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Major diagnostic category");
                                              this.add(ID.class, false, 1, 4, new Object[]{ getMessage(), new Integer(55) }, "Diagnostic related group");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(0) }, "DRG approval indicator");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(56) }, "DRG grouper review code");
                                              this.add(ID.class, false, 1, 60, new Object[]{ getMessage(), new Integer(83) }, "Outlier type");
                                  this.add(NM.class, false, 1, 3, new Object[]{ getMessage() }, "Outlier days");
                                  this.add(NM.class, false, 1, 12, new Object[]{ getMessage() }, "Outlier cost");
                                  this.add(ST.class, false, 1, 4, new Object[]{ getMessage() }, "Grouper version and type");
                                  this.add(NM.class, false, 1, 2, new Object[]{ getMessage() }, "Diagnosis / DRG priority");
                                  this.add(CN.class, false, 1, 60, new Object[]{ getMessage() }, "Diagnosing clinician");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating DG1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * DG1-1: "Set ID - diagnosis" - creates it if necessary
     */
    public SI getSetIDDiagnosis() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-1: "Set ID - diagnosis" - creates it if necessary
     */
    public SI getDg11_SetIDDiagnosis() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-2: "Diagnosis coding method" - creates it if necessary
     */
    public ID getDiagnosisCodingMethod() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-2: "Diagnosis coding method" - creates it if necessary
     */
    public ID getDg12_DiagnosisCodingMethod() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-3: "Diagnosis code" - creates it if necessary
     */
    public ID getDiagnosisCode() { 
		ID retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-3: "Diagnosis code" - creates it if necessary
     */
    public ID getDg13_DiagnosisCode() { 
		ID retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-4: "Diagnosis description" - creates it if necessary
     */
    public ST getDiagnosisDescription() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-4: "Diagnosis description" - creates it if necessary
     */
    public ST getDg14_DiagnosisDescription() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-5: "Diagnosis date / time" - creates it if necessary
     */
    public TS getDiagnosisDateTime() { 
		TS retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-5: "Diagnosis date / time" - creates it if necessary
     */
    public TS getDg15_DiagnosisDateTime() { 
		TS retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-6: "Diagnosis / DRG type" - creates it if necessary
     */
    public ID getDiagnosisDRGType() { 
		ID retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-6: "Diagnosis / DRG type" - creates it if necessary
     */
    public ID getDg16_DiagnosisDRGType() { 
		ID retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-7: "Major diagnostic category" - creates it if necessary
     */
    public CE getMajorDiagnosticCategory() { 
		CE retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-7: "Major diagnostic category" - creates it if necessary
     */
    public CE getDg17_MajorDiagnosticCategory() { 
		CE retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-8: "Diagnostic related group" - creates it if necessary
     */
    public ID getDiagnosticRelatedGroup() { 
		ID retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-8: "Diagnostic related group" - creates it if necessary
     */
    public ID getDg18_DiagnosticRelatedGroup() { 
		ID retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-9: "DRG approval indicator" - creates it if necessary
     */
    public ID getDRGApprovalIndicator() { 
		ID retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-9: "DRG approval indicator" - creates it if necessary
     */
    public ID getDg19_DRGApprovalIndicator() { 
		ID retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-10: "DRG grouper review code" - creates it if necessary
     */
    public ID getDRGGrouperReviewCode() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-10: "DRG grouper review code" - creates it if necessary
     */
    public ID getDg110_DRGGrouperReviewCode() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-11: "Outlier type" - creates it if necessary
     */
    public ID getOutlierType() { 
		ID retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-11: "Outlier type" - creates it if necessary
     */
    public ID getDg111_OutlierType() { 
		ID retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-12: "Outlier days" - creates it if necessary
     */
    public NM getOutlierDays() { 
		NM retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-12: "Outlier days" - creates it if necessary
     */
    public NM getDg112_OutlierDays() { 
		NM retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-13: "Outlier cost" - creates it if necessary
     */
    public NM getOutlierCost() { 
		NM retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-13: "Outlier cost" - creates it if necessary
     */
    public NM getDg113_OutlierCost() { 
		NM retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-14: "Grouper version and type" - creates it if necessary
     */
    public ST getGrouperVersionAndType() { 
		ST retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-14: "Grouper version and type" - creates it if necessary
     */
    public ST getDg114_GrouperVersionAndType() { 
		ST retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-15: "Diagnosis / DRG priority" - creates it if necessary
     */
    public NM getDiagnosisDRGPriority() { 
		NM retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-15: "Diagnosis / DRG priority" - creates it if necessary
     */
    public NM getDg115_DiagnosisDRGPriority() { 
		NM retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-16: "Diagnosing clinician" - creates it if necessary
     */
    public CN getDiagnosingClinician() { 
		CN retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-16: "Diagnosing clinician" - creates it if necessary
     */
    public CN getDg116_DiagnosingClinician() { 
		CN retVal = this.getTypedField(16, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new ID(getMessage(), new Integer( 53 ));
          case 2: return new ID(getMessage(), new Integer( 51 ));
          case 3: return new ST(getMessage());
          case 4: return new TS(getMessage());
          case 5: return new ID(getMessage(), new Integer( 52 ));
          case 6: return new CE(getMessage());
          case 7: return new ID(getMessage(), new Integer( 55 ));
          case 8: return new ID(getMessage(), new Integer( 0 ));
          case 9: return new ID(getMessage(), new Integer( 56 ));
          case 10: return new ID(getMessage(), new Integer( 83 ));
          case 11: return new NM(getMessage());
          case 12: return new NM(getMessage());
          case 13: return new ST(getMessage());
          case 14: return new NM(getMessage());
          case 15: return new CN(getMessage());
          default: return null;
       }
   }


}

