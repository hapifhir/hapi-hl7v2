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
 *<p>Represents an HL7 DG1 message segment (DIAGNOSIS). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>DG1-1: SET ID - DIAGNOSIS (SI) <b> </b>
     * <li>DG1-2: DIAGNOSIS CODING METHOD (ID) <b> </b>
     * <li>DG1-3: DIAGNOSIS CODE (ID) <b>optional </b>
     * <li>DG1-4: DIAGNOSIS DESCRIPTION (ST) <b>optional </b>
     * <li>DG1-5: DIAGNOSIS DATE/TIME (TS) <b>optional </b>
     * <li>DG1-6: DIAGNOSIS/DRG TYPE (ID) <b> </b>
     * <li>DG1-7: MAJOR DIAGNOSTIC CATEGORY (ST) <b>optional </b>
     * <li>DG1-8: DIAGNOSTIC RELATED GROUP (ID) <b>optional </b>
     * <li>DG1-9: DRG APPROVAL INDICATOR (ID) <b>optional </b>
     * <li>DG1-10: DRG GROUPER REVIEW CODE (ID) <b>optional </b>
     * <li>DG1-11: OUTLIER TYPE (ID) <b>optional </b>
     * <li>DG1-12: OUTLIER DAYS (NM) <b>optional </b>
     * <li>DG1-13: OUTLIER COST (NM) <b>optional </b>
     * <li>DG1-14: GROUPER VERSION AND TYPE (ST) <b>optional </b>
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
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "SET ID - DIAGNOSIS");
                                              this.add(ID.class, true, 1, 2, new Object[]{ getMessage(), new Integer(53) }, "DIAGNOSIS CODING METHOD");
                                              this.add(ID.class, false, 1, 8, new Object[]{ getMessage(), new Integer(51) }, "DIAGNOSIS CODE");
                                  this.add(ST.class, false, 1, 40, new Object[]{ getMessage() }, "DIAGNOSIS DESCRIPTION");
                                  this.add(TS.class, false, 1, 19, new Object[]{ getMessage() }, "DIAGNOSIS DATE/TIME");
                                              this.add(ID.class, true, 1, 2, new Object[]{ getMessage(), new Integer(52) }, "DIAGNOSIS/DRG TYPE");
                                  this.add(ST.class, false, 1, 4, new Object[]{ getMessage() }, "MAJOR DIAGNOSTIC CATEGORY");
                                              this.add(ID.class, false, 1, 4, new Object[]{ getMessage(), new Integer(55) }, "DIAGNOSTIC RELATED GROUP");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(0) }, "DRG APPROVAL INDICATOR");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(56) }, "DRG GROUPER REVIEW CODE");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(83) }, "OUTLIER TYPE");
                                  this.add(NM.class, false, 1, 3, new Object[]{ getMessage() }, "OUTLIER DAYS");
                                  this.add(NM.class, false, 1, 12, new Object[]{ getMessage() }, "OUTLIER COST");
                                  this.add(ST.class, false, 1, 4, new Object[]{ getMessage() }, "GROUPER VERSION AND TYPE");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating DG1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * DG1-1: "SET ID - DIAGNOSIS" - creates it if necessary
     */
    public SI getSETIDDIAGNOSIS() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-1: "SET ID - DIAGNOSIS" - creates it if necessary
     */
    public SI getDg11_SETIDDIAGNOSIS() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-2: "DIAGNOSIS CODING METHOD" - creates it if necessary
     */
    public ID getDIAGNOSISCODINGMETHOD() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-2: "DIAGNOSIS CODING METHOD" - creates it if necessary
     */
    public ID getDg12_DIAGNOSISCODINGMETHOD() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-3: "DIAGNOSIS CODE" - creates it if necessary
     */
    public ID getDIAGNOSISCODE() { 
		ID retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-3: "DIAGNOSIS CODE" - creates it if necessary
     */
    public ID getDg13_DIAGNOSISCODE() { 
		ID retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-4: "DIAGNOSIS DESCRIPTION" - creates it if necessary
     */
    public ST getDIAGNOSISDESCRIPTION() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-4: "DIAGNOSIS DESCRIPTION" - creates it if necessary
     */
    public ST getDg14_DIAGNOSISDESCRIPTION() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-5: "DIAGNOSIS DATE/TIME" - creates it if necessary
     */
    public TS getDIAGNOSISDATETIME() { 
		TS retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-5: "DIAGNOSIS DATE/TIME" - creates it if necessary
     */
    public TS getDg15_DIAGNOSISDATETIME() { 
		TS retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-6: "DIAGNOSIS/DRG TYPE" - creates it if necessary
     */
    public ID getDIAGNOSISDRGTYPE() { 
		ID retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-6: "DIAGNOSIS/DRG TYPE" - creates it if necessary
     */
    public ID getDg16_DIAGNOSISDRGTYPE() { 
		ID retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-7: "MAJOR DIAGNOSTIC CATEGORY" - creates it if necessary
     */
    public ST getMAJORDIAGNOSTICCATEGORY() { 
		ST retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-7: "MAJOR DIAGNOSTIC CATEGORY" - creates it if necessary
     */
    public ST getDg17_MAJORDIAGNOSTICCATEGORY() { 
		ST retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-8: "DIAGNOSTIC RELATED GROUP" - creates it if necessary
     */
    public ID getDIAGNOSTICRELATEDGROUP() { 
		ID retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-8: "DIAGNOSTIC RELATED GROUP" - creates it if necessary
     */
    public ID getDg18_DIAGNOSTICRELATEDGROUP() { 
		ID retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-9: "DRG APPROVAL INDICATOR" - creates it if necessary
     */
    public ID getDRGAPPROVALINDICATOR() { 
		ID retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-9: "DRG APPROVAL INDICATOR" - creates it if necessary
     */
    public ID getDg19_DRGAPPROVALINDICATOR() { 
		ID retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-10: "DRG GROUPER REVIEW CODE" - creates it if necessary
     */
    public ID getDRGGROUPERREVIEWCODE() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-10: "DRG GROUPER REVIEW CODE" - creates it if necessary
     */
    public ID getDg110_DRGGROUPERREVIEWCODE() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-11: "OUTLIER TYPE" - creates it if necessary
     */
    public ID getOUTLIERTYPE() { 
		ID retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-11: "OUTLIER TYPE" - creates it if necessary
     */
    public ID getDg111_OUTLIERTYPE() { 
		ID retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-12: "OUTLIER DAYS" - creates it if necessary
     */
    public NM getOUTLIERDAYS() { 
		NM retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-12: "OUTLIER DAYS" - creates it if necessary
     */
    public NM getDg112_OUTLIERDAYS() { 
		NM retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-13: "OUTLIER COST" - creates it if necessary
     */
    public NM getOUTLIERCOST() { 
		NM retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-13: "OUTLIER COST" - creates it if necessary
     */
    public NM getDg113_OUTLIERCOST() { 
		NM retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-14: "GROUPER VERSION AND TYPE" - creates it if necessary
     */
    public ST getGROUPERVERSIONANDTYPE() { 
		ST retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-14: "GROUPER VERSION AND TYPE" - creates it if necessary
     */
    public ST getDg114_GROUPERVERSIONANDTYPE() { 
		ST retVal = this.getTypedField(14, 0);
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
          case 6: return new ST(getMessage());
          case 7: return new ID(getMessage(), new Integer( 55 ));
          case 8: return new ID(getMessage(), new Integer( 0 ));
          case 9: return new ID(getMessage(), new Integer( 56 ));
          case 10: return new ID(getMessage(), new Integer( 83 ));
          case 11: return new NM(getMessage());
          case 12: return new NM(getMessage());
          case 13: return new ST(getMessage());
          default: return null;
       }
   }


}

