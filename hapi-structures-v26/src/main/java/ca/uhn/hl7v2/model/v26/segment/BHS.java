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
 *<p>Represents an HL7 BHS message segment (Batch Header). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>BHS-1: Batch Field Separator (ST) <b> </b>
     * <li>BHS-2: Batch Encoding Characters (ST) <b> </b>
     * <li>BHS-3: Batch Sending Application (HD) <b>optional </b>
     * <li>BHS-4: Batch Sending Facility (HD) <b>optional </b>
     * <li>BHS-5: Batch Receiving Application (HD) <b>optional </b>
     * <li>BHS-6: Batch Receiving Facility (HD) <b>optional </b>
     * <li>BHS-7: Batch Creation Date/Time (DTM) <b>optional </b>
     * <li>BHS-8: Batch Security (ST) <b>optional </b>
     * <li>BHS-9: Batch Name/ID/Type (ST) <b>optional </b>
     * <li>BHS-10: Batch Comment (ST) <b>optional </b>
     * <li>BHS-11: Batch Control ID (ST) <b>optional </b>
     * <li>BHS-12: Reference Batch Control ID (ST) <b>optional </b>
     * <li>BHS-13: Batch Sending Network Address (HD) <b>optional </b>
     * <li>BHS-14: Batch Receiving Network Address (HD) <b>optional </b>
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
                                  this.add(ST.class, true, 1, 1, new Object[]{ getMessage() }, "Batch Field Separator");
                                  this.add(ST.class, true, 1, 4, new Object[]{ getMessage() }, "Batch Encoding Characters");
                                  this.add(HD.class, false, 1, 227, new Object[]{ getMessage() }, "Batch Sending Application");
                                  this.add(HD.class, false, 1, 227, new Object[]{ getMessage() }, "Batch Sending Facility");
                                  this.add(HD.class, false, 1, 227, new Object[]{ getMessage() }, "Batch Receiving Application");
                                  this.add(HD.class, false, 1, 227, new Object[]{ getMessage() }, "Batch Receiving Facility");
                                  this.add(DTM.class, false, 1, 24, new Object[]{ getMessage() }, "Batch Creation Date/Time");
                                  this.add(ST.class, false, 1, 40, new Object[]{ getMessage() }, "Batch Security");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "Batch Name/ID/Type");
                                  this.add(ST.class, false, 1, 80, new Object[]{ getMessage() }, "Batch Comment");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "Batch Control ID");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "Reference Batch Control ID");
                                  this.add(HD.class, false, 1, 227, new Object[]{ getMessage() }, "Batch Sending Network Address");
                                  this.add(HD.class, false, 1, 227, new Object[]{ getMessage() }, "Batch Receiving Network Address");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating BHS - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * BHS-1: "Batch Field Separator" - creates it if necessary
     */
    public ST getBatchFieldSeparator() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BHS-1: "Batch Field Separator" - creates it if necessary
     */
    public ST getBhs1_BatchFieldSeparator() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * BHS-2: "Batch Encoding Characters" - creates it if necessary
     */
    public ST getBatchEncodingCharacters() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BHS-2: "Batch Encoding Characters" - creates it if necessary
     */
    public ST getBhs2_BatchEncodingCharacters() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * BHS-3: "Batch Sending Application" - creates it if necessary
     */
    public HD getBatchSendingApplication() { 
		HD retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BHS-3: "Batch Sending Application" - creates it if necessary
     */
    public HD getBhs3_BatchSendingApplication() { 
		HD retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * BHS-4: "Batch Sending Facility" - creates it if necessary
     */
    public HD getBatchSendingFacility() { 
		HD retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BHS-4: "Batch Sending Facility" - creates it if necessary
     */
    public HD getBhs4_BatchSendingFacility() { 
		HD retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * BHS-5: "Batch Receiving Application" - creates it if necessary
     */
    public HD getBatchReceivingApplication() { 
		HD retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BHS-5: "Batch Receiving Application" - creates it if necessary
     */
    public HD getBhs5_BatchReceivingApplication() { 
		HD retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * BHS-6: "Batch Receiving Facility" - creates it if necessary
     */
    public HD getBatchReceivingFacility() { 
		HD retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BHS-6: "Batch Receiving Facility" - creates it if necessary
     */
    public HD getBhs6_BatchReceivingFacility() { 
		HD retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * BHS-7: "Batch Creation Date/Time" - creates it if necessary
     */
    public DTM getBatchCreationDateTime() { 
		DTM retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BHS-7: "Batch Creation Date/Time" - creates it if necessary
     */
    public DTM getBhs7_BatchCreationDateTime() { 
		DTM retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * BHS-8: "Batch Security" - creates it if necessary
     */
    public ST getBatchSecurity() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BHS-8: "Batch Security" - creates it if necessary
     */
    public ST getBhs8_BatchSecurity() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * BHS-9: "Batch Name/ID/Type" - creates it if necessary
     */
    public ST getBatchNameIDType() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BHS-9: "Batch Name/ID/Type" - creates it if necessary
     */
    public ST getBhs9_BatchNameIDType() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * BHS-10: "Batch Comment" - creates it if necessary
     */
    public ST getBatchComment() { 
		ST retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BHS-10: "Batch Comment" - creates it if necessary
     */
    public ST getBhs10_BatchComment() { 
		ST retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * BHS-11: "Batch Control ID" - creates it if necessary
     */
    public ST getBatchControlID() { 
		ST retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BHS-11: "Batch Control ID" - creates it if necessary
     */
    public ST getBhs11_BatchControlID() { 
		ST retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * BHS-12: "Reference Batch Control ID" - creates it if necessary
     */
    public ST getReferenceBatchControlID() { 
		ST retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BHS-12: "Reference Batch Control ID" - creates it if necessary
     */
    public ST getBhs12_ReferenceBatchControlID() { 
		ST retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * BHS-13: "Batch Sending Network Address" - creates it if necessary
     */
    public HD getBatchSendingNetworkAddress() { 
		HD retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BHS-13: "Batch Sending Network Address" - creates it if necessary
     */
    public HD getBhs13_BatchSendingNetworkAddress() { 
		HD retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * BHS-14: "Batch Receiving Network Address" - creates it if necessary
     */
    public HD getBatchReceivingNetworkAddress() { 
		HD retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * BHS-14: "Batch Receiving Network Address" - creates it if necessary
     */
    public HD getBhs14_BatchReceivingNetworkAddress() { 
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

