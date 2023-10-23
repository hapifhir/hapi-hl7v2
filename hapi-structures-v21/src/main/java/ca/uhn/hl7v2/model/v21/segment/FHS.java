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
 *<p>Represents an HL7 FHS message segment (FILE HEADER). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>FHS-1: FILE FIELD SEPARATOR (ST) <b> </b>
     * <li>FHS-2: FILE ENCODING CHARACTERS (ST) <b> </b>
     * <li>FHS-3: FILE SENDING APPLICATION (ST) <b>optional </b>
     * <li>FHS-4: FILE SENDING FACILITY (ST) <b>optional </b>
     * <li>FHS-5: FILE RECEIVING APPLICATION (ST) <b>optional </b>
     * <li>FHS-6: FILE RECEIVING FACILITY (ST) <b>optional </b>
     * <li>FHS-7: DATE/TIME OF FILE CREATION (TS) <b>optional </b>
     * <li>FHS-8: FILE SECURITY (ST) <b>optional </b>
     * <li>FHS-9: FILE NAME/ID (ST) <b>optional </b>
     * <li>FHS-10: FILE HEADER COMMENT (ST) <b>optional </b>
     * <li>FHS-11: FILE CONTROL ID (ST) <b>optional </b>
     * <li>FHS-12: REFERENCE FILE CONTROL ID (ST) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class FHS extends AbstractSegment {

    /** 
     * Creates a new FHS segment
     */
    public FHS(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ST.class, true, 1, 1, new Object[]{ getMessage() }, "FILE FIELD SEPARATOR");
                                  this.add(ST.class, true, 1, 4, new Object[]{ getMessage() }, "FILE ENCODING CHARACTERS");
                                  this.add(ST.class, false, 1, 15, new Object[]{ getMessage() }, "FILE SENDING APPLICATION");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "FILE SENDING FACILITY");
                                  this.add(ST.class, false, 1, 15, new Object[]{ getMessage() }, "FILE RECEIVING APPLICATION");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "FILE RECEIVING FACILITY");
                                  this.add(TS.class, false, 1, 19, new Object[]{ getMessage() }, "DATE/TIME OF FILE CREATION");
                                  this.add(ST.class, false, 1, 40, new Object[]{ getMessage() }, "FILE SECURITY");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "FILE NAME/ID");
                                  this.add(ST.class, false, 1, 80, new Object[]{ getMessage() }, "FILE HEADER COMMENT");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "FILE CONTROL ID");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "REFERENCE FILE CONTROL ID");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating FHS - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * FHS-1: "FILE FIELD SEPARATOR" - creates it if necessary
     */
    public ST getFILEFIELDSEPARATOR() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FHS-1: "FILE FIELD SEPARATOR" - creates it if necessary
     */
    public ST getFhs1_FILEFIELDSEPARATOR() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * FHS-2: "FILE ENCODING CHARACTERS" - creates it if necessary
     */
    public ST getFILEENCODINGCHARACTERS() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FHS-2: "FILE ENCODING CHARACTERS" - creates it if necessary
     */
    public ST getFhs2_FILEENCODINGCHARACTERS() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * FHS-3: "FILE SENDING APPLICATION" - creates it if necessary
     */
    public ST getFILESENDINGAPPLICATION() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FHS-3: "FILE SENDING APPLICATION" - creates it if necessary
     */
    public ST getFhs3_FILESENDINGAPPLICATION() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * FHS-4: "FILE SENDING FACILITY" - creates it if necessary
     */
    public ST getFILESENDINGFACILITY() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FHS-4: "FILE SENDING FACILITY" - creates it if necessary
     */
    public ST getFhs4_FILESENDINGFACILITY() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * FHS-5: "FILE RECEIVING APPLICATION" - creates it if necessary
     */
    public ST getFILERECEIVINGAPPLICATION() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FHS-5: "FILE RECEIVING APPLICATION" - creates it if necessary
     */
    public ST getFhs5_FILERECEIVINGAPPLICATION() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * FHS-6: "FILE RECEIVING FACILITY" - creates it if necessary
     */
    public ST getFILERECEIVINGFACILITY() { 
		ST retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FHS-6: "FILE RECEIVING FACILITY" - creates it if necessary
     */
    public ST getFhs6_FILERECEIVINGFACILITY() { 
		ST retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * FHS-7: "DATE/TIME OF FILE CREATION" - creates it if necessary
     */
    public TS getDATETIMEOFFILECREATION() { 
		TS retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FHS-7: "DATE/TIME OF FILE CREATION" - creates it if necessary
     */
    public TS getFhs7_DATETIMEOFFILECREATION() { 
		TS retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * FHS-8: "FILE SECURITY" - creates it if necessary
     */
    public ST getFILESECURITY() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FHS-8: "FILE SECURITY" - creates it if necessary
     */
    public ST getFhs8_FILESECURITY() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * FHS-9: "FILE NAME/ID" - creates it if necessary
     */
    public ST getFILENAMEID() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FHS-9: "FILE NAME/ID" - creates it if necessary
     */
    public ST getFhs9_FILENAMEID() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * FHS-10: "FILE HEADER COMMENT" - creates it if necessary
     */
    public ST getFILEHEADERCOMMENT() { 
		ST retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FHS-10: "FILE HEADER COMMENT" - creates it if necessary
     */
    public ST getFhs10_FILEHEADERCOMMENT() { 
		ST retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * FHS-11: "FILE CONTROL ID" - creates it if necessary
     */
    public ST getFILECONTROLID() { 
		ST retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FHS-11: "FILE CONTROL ID" - creates it if necessary
     */
    public ST getFhs11_FILECONTROLID() { 
		ST retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * FHS-12: "REFERENCE FILE CONTROL ID" - creates it if necessary
     */
    public ST getREFERENCEFILECONTROLID() { 
		ST retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FHS-12: "REFERENCE FILE CONTROL ID" - creates it if necessary
     */
    public ST getFhs12_REFERENCEFILECONTROLID() { 
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

