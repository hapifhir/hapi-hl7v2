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


package ca.uhn.hl7v2.model.v28.segment;

// import ca.uhn.hl7v2.model.v28.group.*;
import ca.uhn.hl7v2.model.v28.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 FHS message segment (File Header). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>FHS-1: File Field Separator (ST) <b> </b>
     * <li>FHS-2: File Encoding Characters (ST) <b> </b>
     * <li>FHS-3: File Sending Application (HD) <b>optional </b>
     * <li>FHS-4: File Sending Facility (HD) <b>optional </b>
     * <li>FHS-5: File Receiving Application (HD) <b>optional </b>
     * <li>FHS-6: File Receiving Facility (HD) <b>optional </b>
     * <li>FHS-7: File Creation Date/Time (DTM) <b>optional </b>
     * <li>FHS-8: File Security (ST) <b>optional </b>
     * <li>FHS-9: File Name/ID (ST) <b>optional </b>
     * <li>FHS-10: File Header Comment (ST) <b>optional </b>
     * <li>FHS-11: File Control ID (ST) <b>optional </b>
     * <li>FHS-12: Reference File Control ID (ST) <b>optional </b>
     * <li>FHS-13: File Sending Network Address (HD) <b>optional </b>
     * <li>FHS-14: File Receiving Network Address (HD) <b>optional </b>
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
                                  this.add(ST.class, true, 1, 5, new Object[]{ getMessage() }, "File Encoding Characters");
                                  this.add(HD.class, false, 1, 0, new Object[]{ getMessage() }, "File Sending Application");
                                  this.add(HD.class, false, 1, 0, new Object[]{ getMessage() }, "File Sending Facility");
                                  this.add(HD.class, false, 1, 0, new Object[]{ getMessage() }, "File Receiving Application");
                                  this.add(HD.class, false, 1, 0, new Object[]{ getMessage() }, "File Receiving Facility");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "File Creation Date/Time");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "File Security");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "File Name/ID");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "File Header Comment");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "File Control ID");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Reference File Control ID");
                                  this.add(HD.class, false, 1, 0, new Object[]{ getMessage() }, "File Sending Network Address");
                                  this.add(HD.class, false, 1, 0, new Object[]{ getMessage() }, "File Receiving Network Address");
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
    public HD getFileSendingApplication() { 
		HD retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FHS-3: "File Sending Application" - creates it if necessary
     */
    public HD getFhs3_FileSendingApplication() { 
		HD retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * FHS-4: "File Sending Facility" - creates it if necessary
     */
    public HD getFileSendingFacility() { 
		HD retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FHS-4: "File Sending Facility" - creates it if necessary
     */
    public HD getFhs4_FileSendingFacility() { 
		HD retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * FHS-5: "File Receiving Application" - creates it if necessary
     */
    public HD getFileReceivingApplication() { 
		HD retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FHS-5: "File Receiving Application" - creates it if necessary
     */
    public HD getFhs5_FileReceivingApplication() { 
		HD retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * FHS-6: "File Receiving Facility" - creates it if necessary
     */
    public HD getFileReceivingFacility() { 
		HD retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FHS-6: "File Receiving Facility" - creates it if necessary
     */
    public HD getFhs6_FileReceivingFacility() { 
		HD retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * FHS-7: "File Creation Date/Time" - creates it if necessary
     */
    public DTM getFileCreationDateTime() { 
		DTM retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FHS-7: "File Creation Date/Time" - creates it if necessary
     */
    public DTM getFhs7_FileCreationDateTime() { 
		DTM retVal = this.getTypedField(7, 0);
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
     * FHS-9: "File Name/ID" - creates it if necessary
     */
    public ST getFileNameID() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FHS-9: "File Name/ID" - creates it if necessary
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



    /**
     * Returns
     * FHS-13: "File Sending Network Address" - creates it if necessary
     */
    public HD getFileSendingNetworkAddress() { 
		HD retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FHS-13: "File Sending Network Address" - creates it if necessary
     */
    public HD getFhs13_FileSendingNetworkAddress() { 
		HD retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * FHS-14: "File Receiving Network Address" - creates it if necessary
     */
    public HD getFileReceivingNetworkAddress() { 
		HD retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FHS-14: "File Receiving Network Address" - creates it if necessary
     */
    public HD getFhs14_FileReceivingNetworkAddress() { 
		HD retVal = this.getTypedField(14, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ST(getMessage());
          case 1: return new ST(getMessage());
          case 2: return new HD(getMessage());
          case 3: return new HD(getMessage());
          case 4: return new HD(getMessage());
          case 5: return new HD(getMessage());
          case 6: return new DTM(getMessage());
          case 7: return new ST(getMessage());
          case 8: return new ST(getMessage());
          case 9: return new ST(getMessage());
          case 10: return new ST(getMessage());
          case 11: return new ST(getMessage());
          case 12: return new HD(getMessage());
          case 13: return new HD(getMessage());
          default: return null;
       }
   }


}

