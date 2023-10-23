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
 *<p>Represents an HL7 FHS message segment (FILE HEADER). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>FHS-1: File Field Separator (ST) <b> </b>
     * <li>FHS-2: File Encoding Characters (ST) <b> </b>
     * <li>FHS-3: File Sending Application (ST) <b>optional </b>
     * <li>FHS-4: File Sending Facility (ST) <b>optional </b>
     * <li>FHS-5: File Receiving Application (ST) <b>optional </b>
     * <li>FHS-6: File Receiving Facility (ST) <b>optional </b>
     * <li>FHS-7: File creation date / time (TS) <b>optional </b>
     * <li>FHS-8: File Security (ST) <b>optional </b>
     * <li>FHS-9: File name / ID (ST) <b>optional </b>
     * <li>FHS-10: File Header Comment (ST) <b>optional </b>
     * <li>FHS-11: File Control ID (ST) <b>optional </b>
     * <li>FHS-12: Reference File Control ID (ST) <b>optional </b>
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
                                  this.add(ST.class, true, 1, 1, new Object[]{ getMessage() }, "File Field Separator");
                                  this.add(ST.class, true, 1, 4, new Object[]{ getMessage() }, "File Encoding Characters");
                                  this.add(ST.class, false, 1, 15, new Object[]{ getMessage() }, "File Sending Application");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "File Sending Facility");
                                  this.add(ST.class, false, 1, 30, new Object[]{ getMessage() }, "File Receiving Application");
                                  this.add(ST.class, false, 1, 30, new Object[]{ getMessage() }, "File Receiving Facility");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "File creation date / time");
                                  this.add(ST.class, false, 1, 40, new Object[]{ getMessage() }, "File Security");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "File name / ID");
                                  this.add(ST.class, false, 1, 80, new Object[]{ getMessage() }, "File Header Comment");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "File Control ID");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "Reference File Control ID");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating FHS - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * FHS-1: "File Field Separator" - creates it if necessary
     */
    public ST getFileFieldSeparator() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FHS-1: "File Field Separator" - creates it if necessary
     */
    public ST getFhs1_FileFieldSeparator() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * FHS-2: "File Encoding Characters" - creates it if necessary
     */
    public ST getFileEncodingCharacters() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FHS-2: "File Encoding Characters" - creates it if necessary
     */
    public ST getFhs2_FileEncodingCharacters() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * FHS-3: "File Sending Application" - creates it if necessary
     */
    public ST getFileSendingApplication() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FHS-3: "File Sending Application" - creates it if necessary
     */
    public ST getFhs3_FileSendingApplication() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * FHS-4: "File Sending Facility" - creates it if necessary
     */
    public ST getFileSendingFacility() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FHS-4: "File Sending Facility" - creates it if necessary
     */
    public ST getFhs4_FileSendingFacility() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * FHS-5: "File Receiving Application" - creates it if necessary
     */
    public ST getFileReceivingApplication() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FHS-5: "File Receiving Application" - creates it if necessary
     */
    public ST getFhs5_FileReceivingApplication() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * FHS-6: "File Receiving Facility" - creates it if necessary
     */
    public ST getFileReceivingFacility() { 
		ST retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FHS-6: "File Receiving Facility" - creates it if necessary
     */
    public ST getFhs6_FileReceivingFacility() { 
		ST retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * FHS-7: "File creation date / time" - creates it if necessary
     */
    public TS getFileCreationDateTime() { 
		TS retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FHS-7: "File creation date / time" - creates it if necessary
     */
    public TS getFhs7_FileCreationDateTime() { 
		TS retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * FHS-8: "File Security" - creates it if necessary
     */
    public ST getFileSecurity() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FHS-8: "File Security" - creates it if necessary
     */
    public ST getFhs8_FileSecurity() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * FHS-9: "File name / ID" - creates it if necessary
     */
    public ST getFileNameID() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FHS-9: "File name / ID" - creates it if necessary
     */
    public ST getFhs9_FileNameID() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * FHS-10: "File Header Comment" - creates it if necessary
     */
    public ST getFileHeaderComment() { 
		ST retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FHS-10: "File Header Comment" - creates it if necessary
     */
    public ST getFhs10_FileHeaderComment() { 
		ST retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * FHS-11: "File Control ID" - creates it if necessary
     */
    public ST getFileControlID() { 
		ST retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FHS-11: "File Control ID" - creates it if necessary
     */
    public ST getFhs11_FileControlID() { 
		ST retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * FHS-12: "Reference File Control ID" - creates it if necessary
     */
    public ST getReferenceFileControlID() { 
		ST retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FHS-12: "Reference File Control ID" - creates it if necessary
     */
    public ST getFhs12_ReferenceFileControlID() { 
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

