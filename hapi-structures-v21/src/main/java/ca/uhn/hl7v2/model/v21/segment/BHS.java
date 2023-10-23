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
 *<p>Represents an HL7 BHS message segment (BATCH HEADER). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>BHS-1: BATCH FIELD SEPARATOR (ST) <b> </b>
     * <li>BHS-2: BATCH ENCODING CHARACTERS (ST) <b> </b>
     * <li>BHS-3: BATCH SENDING APPLICATION (ST) <b>optional </b>
     * <li>BHS-4: BATCH SENDING FACILITY (ST) <b>optional </b>
     * <li>BHS-5: BATCH RECEIVING APPLICATION (ST) <b>optional </b>
     * <li>BHS-6: BATCH RECEIVING FACILITY (ST) <b>optional </b>
     * <li>BHS-7: BATCH CREATION DATE/TIME (TS) <b>optional </b>
     * <li>BHS-8: BATCH SECURITY (ST) <b>optional </b>
     * <li>BHS-9: BATCH NAME/ID/TYPE (ST) <b>optional </b>
     * <li>BHS-10: BATCH COMMENT (ST) <b>optional </b>
     * <li>BHS-11: BATCH CONTROL ID (ST) <b>optional </b>
     * <li>BHS-12: REFERENCE BATCH CONTROL ID (ST) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class BHS extends AbstractSegment {

    /** 
     * Creates a new BHS segment
     */
    public BHS(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ST.class, true, 1, 1, new Object[]{ getMessage() }, "BATCH FIELD SEPARATOR");
                                  this.add(ST.class, true, 1, 3, new Object[]{ getMessage() }, "BATCH ENCODING CHARACTERS");
                                  this.add(ST.class, false, 1, 15, new Object[]{ getMessage() }, "BATCH SENDING APPLICATION");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "BATCH SENDING FACILITY");
                                  this.add(ST.class, false, 1, 15, new Object[]{ getMessage() }, "BATCH RECEIVING APPLICATION");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "BATCH RECEIVING FACILITY");
                                  this.add(TS.class, false, 1, 19, new Object[]{ getMessage() }, "BATCH CREATION DATE/TIME");
                                  this.add(ST.class, false, 1, 40, new Object[]{ getMessage() }, "BATCH SECURITY");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "BATCH NAME/ID/TYPE");
                                  this.add(ST.class, false, 1, 80, new Object[]{ getMessage() }, "BATCH COMMENT");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "BATCH CONTROL ID");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "REFERENCE BATCH CONTROL ID");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating BHS - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * BHS-1: "BATCH FIELD SEPARATOR" - creates it if necessary
     */
    public ST getBATCHFIELDSEPARATOR() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BHS-1: "BATCH FIELD SEPARATOR" - creates it if necessary
     */
    public ST getBhs1_BATCHFIELDSEPARATOR() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * BHS-2: "BATCH ENCODING CHARACTERS" - creates it if necessary
     */
    public ST getBATCHENCODINGCHARACTERS() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BHS-2: "BATCH ENCODING CHARACTERS" - creates it if necessary
     */
    public ST getBhs2_BATCHENCODINGCHARACTERS() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * BHS-3: "BATCH SENDING APPLICATION" - creates it if necessary
     */
    public ST getBATCHSENDINGAPPLICATION() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BHS-3: "BATCH SENDING APPLICATION" - creates it if necessary
     */
    public ST getBhs3_BATCHSENDINGAPPLICATION() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * BHS-4: "BATCH SENDING FACILITY" - creates it if necessary
     */
    public ST getBATCHSENDINGFACILITY() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BHS-4: "BATCH SENDING FACILITY" - creates it if necessary
     */
    public ST getBhs4_BATCHSENDINGFACILITY() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * BHS-5: "BATCH RECEIVING APPLICATION" - creates it if necessary
     */
    public ST getBATCHRECEIVINGAPPLICATION() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BHS-5: "BATCH RECEIVING APPLICATION" - creates it if necessary
     */
    public ST getBhs5_BATCHRECEIVINGAPPLICATION() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * BHS-6: "BATCH RECEIVING FACILITY" - creates it if necessary
     */
    public ST getBATCHRECEIVINGFACILITY() { 
		ST retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BHS-6: "BATCH RECEIVING FACILITY" - creates it if necessary
     */
    public ST getBhs6_BATCHRECEIVINGFACILITY() { 
		ST retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * BHS-7: "BATCH CREATION DATE/TIME" - creates it if necessary
     */
    public TS getBATCHCREATIONDATETIME() { 
		TS retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BHS-7: "BATCH CREATION DATE/TIME" - creates it if necessary
     */
    public TS getBhs7_BATCHCREATIONDATETIME() { 
		TS retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * BHS-8: "BATCH SECURITY" - creates it if necessary
     */
    public ST getBATCHSECURITY() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BHS-8: "BATCH SECURITY" - creates it if necessary
     */
    public ST getBhs8_BATCHSECURITY() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * BHS-9: "BATCH NAME/ID/TYPE" - creates it if necessary
     */
    public ST getBATCHNAMEIDTYPE() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BHS-9: "BATCH NAME/ID/TYPE" - creates it if necessary
     */
    public ST getBhs9_BATCHNAMEIDTYPE() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * BHS-10: "BATCH COMMENT" - creates it if necessary
     */
    public ST getBATCHCOMMENT() { 
		ST retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BHS-10: "BATCH COMMENT" - creates it if necessary
     */
    public ST getBhs10_BATCHCOMMENT() { 
		ST retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * BHS-11: "BATCH CONTROL ID" - creates it if necessary
     */
    public ST getBATCHCONTROLID() { 
		ST retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BHS-11: "BATCH CONTROL ID" - creates it if necessary
     */
    public ST getBhs11_BATCHCONTROLID() { 
		ST retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * BHS-12: "REFERENCE BATCH CONTROL ID" - creates it if necessary
     */
    public ST getREFERENCEBATCHCONTROLID() { 
		ST retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BHS-12: "REFERENCE BATCH CONTROL ID" - creates it if necessary
     */
    public ST getBhs12_REFERENCEBATCHCONTROLID() { 
		ST retVal = this.getTypedField(12, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ST(getMessage());
          case 1: return new ST(getMessage());
          case 2: return new ST(getMessage());
          case 3: return new ST(getMessage());
          case 4: return new ST(getMessage());
          case 5: return new ST(getMessage());
          case 6: return new TS(getMessage());
          case 7: return new ST(getMessage());
          case 8: return new ST(getMessage());
          case 9: return new ST(getMessage());
          case 10: return new ST(getMessage());
          case 11: return new ST(getMessage());
          default: return null;
       }
   }


}

