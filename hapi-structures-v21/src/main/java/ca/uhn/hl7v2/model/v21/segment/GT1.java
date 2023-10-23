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
 *<p>Represents an HL7 GT1 message segment (GUARANTOR). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>GT1-1: SET ID - GUARANTOR (SI) <b> </b>
     * <li>GT1-2: GUARANTOR NUMBER (ID) <b>optional </b>
     * <li>GT1-3: GUARANTOR NAME (PN) <b> </b>
     * <li>GT1-4: GUARANTOR SPOUSE NAME (PN) <b>optional </b>
     * <li>GT1-5: GUARANTOR ADDRESS (AD) <b>optional </b>
     * <li>GT1-6: GUARANTOR PH. NUM.- HOME (TN) <b>optional </b>
     * <li>GT1-7: GUARANTOR PH. NUM-BUSINESS (TN) <b>optional </b>
     * <li>GT1-8: GUARANTOR DATE OF BIRTH (DT) <b>optional </b>
     * <li>GT1-9: GUARANTOR SEX (ID) <b>optional </b>
     * <li>GT1-10: GUARANTOR TYPE (ID) <b>optional </b>
     * <li>GT1-11: GUARANTOR RELATIONSHIP (ID) <b>optional </b>
     * <li>GT1-12: GUARANTOR SSN (ST) <b>optional </b>
     * <li>GT1-13: GUARANTOR DATE - BEGIN (DT) <b>optional </b>
     * <li>GT1-14: GUARANTOR DATE - END (DT) <b>optional </b>
     * <li>GT1-15: GUARANTOR PRIORITY (NM) <b>optional </b>
     * <li>GT1-16: GUARANTOR EMPLOYER NAME (ST) <b>optional </b>
     * <li>GT1-17: GUARANTOR EMPLOYER ADDRESS (AD) <b>optional </b>
     * <li>GT1-18: GUARANTOR EMPLOY PHONE # (TN) <b>optional </b>
     * <li>GT1-19: GUARANTOR EMPLOYEE ID NUM (ST) <b>optional </b>
     * <li>GT1-20: GUARANTOR EMPLOYMENT STATUS (ID) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class GT1 extends AbstractSegment {

    /** 
     * Creates a new GT1 segment
     */
    public GT1(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "SET ID - GUARANTOR");
                                              this.add(ID.class, false, 1, 20, new Object[]{ getMessage(), new Integer(0) }, "GUARANTOR NUMBER");
                                  this.add(PN.class, true, 1, 48, new Object[]{ getMessage() }, "GUARANTOR NAME");
                                  this.add(PN.class, false, 1, 48, new Object[]{ getMessage() }, "GUARANTOR SPOUSE NAME");
                                  this.add(AD.class, false, 1, 106, new Object[]{ getMessage() }, "GUARANTOR ADDRESS");
                                  this.add(TN.class, false, 1, 40, new Object[]{ getMessage() }, "GUARANTOR PH. NUM.- HOME");
                                  this.add(TN.class, false, 1, 40, new Object[]{ getMessage() }, "GUARANTOR PH. NUM-BUSINESS");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "GUARANTOR DATE OF BIRTH");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(1) }, "GUARANTOR SEX");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(68) }, "GUARANTOR TYPE");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(63) }, "GUARANTOR RELATIONSHIP");
                                  this.add(ST.class, false, 1, 11, new Object[]{ getMessage() }, "GUARANTOR SSN");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "GUARANTOR DATE - BEGIN");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "GUARANTOR DATE - END");
                                  this.add(NM.class, false, 1, 2, new Object[]{ getMessage() }, "GUARANTOR PRIORITY");
                                  this.add(ST.class, false, 1, 45, new Object[]{ getMessage() }, "GUARANTOR EMPLOYER NAME");
                                  this.add(AD.class, false, 1, 106, new Object[]{ getMessage() }, "GUARANTOR EMPLOYER ADDRESS");
                                  this.add(TN.class, false, 1, 40, new Object[]{ getMessage() }, "GUARANTOR EMPLOY PHONE #");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "GUARANTOR EMPLOYEE ID NUM");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(66) }, "GUARANTOR EMPLOYMENT STATUS");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating GT1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * GT1-1: "SET ID - GUARANTOR" - creates it if necessary
     */
    public SI getSETIDGUARANTOR() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-1: "SET ID - GUARANTOR" - creates it if necessary
     */
    public SI getGt11_SETIDGUARANTOR() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-2: "GUARANTOR NUMBER" - creates it if necessary
     */
    public ID getGUARANTORNUMBER() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-2: "GUARANTOR NUMBER" - creates it if necessary
     */
    public ID getGt12_GUARANTORNUMBER() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-3: "GUARANTOR NAME" - creates it if necessary
     */
    public PN getGUARANTORNAME() { 
		PN retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-3: "GUARANTOR NAME" - creates it if necessary
     */
    public PN getGt13_GUARANTORNAME() { 
		PN retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-4: "GUARANTOR SPOUSE NAME" - creates it if necessary
     */
    public PN getGUARANTORSPOUSENAME() { 
		PN retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-4: "GUARANTOR SPOUSE NAME" - creates it if necessary
     */
    public PN getGt14_GUARANTORSPOUSENAME() { 
		PN retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-5: "GUARANTOR ADDRESS" - creates it if necessary
     */
    public AD getGUARANTORADDRESS() { 
		AD retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-5: "GUARANTOR ADDRESS" - creates it if necessary
     */
    public AD getGt15_GUARANTORADDRESS() { 
		AD retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-6: "GUARANTOR PH. NUM.- HOME" - creates it if necessary
     */
    public TN getGUARANTORPHNUMHOME() { 
		TN retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-6: "GUARANTOR PH. NUM.- HOME" - creates it if necessary
     */
    public TN getGt16_GUARANTORPHNUMHOME() { 
		TN retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-7: "GUARANTOR PH. NUM-BUSINESS" - creates it if necessary
     */
    public TN getGUARANTORPHNUMBUSINESS() { 
		TN retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-7: "GUARANTOR PH. NUM-BUSINESS" - creates it if necessary
     */
    public TN getGt17_GUARANTORPHNUMBUSINESS() { 
		TN retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-8: "GUARANTOR DATE OF BIRTH" - creates it if necessary
     */
    public DT getGUARANTORDATEOFBIRTH() { 
		DT retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-8: "GUARANTOR DATE OF BIRTH" - creates it if necessary
     */
    public DT getGt18_GUARANTORDATEOFBIRTH() { 
		DT retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-9: "GUARANTOR SEX" - creates it if necessary
     */
    public ID getGUARANTORSEX() { 
		ID retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-9: "GUARANTOR SEX" - creates it if necessary
     */
    public ID getGt19_GUARANTORSEX() { 
		ID retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-10: "GUARANTOR TYPE" - creates it if necessary
     */
    public ID getGUARANTORTYPE() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-10: "GUARANTOR TYPE" - creates it if necessary
     */
    public ID getGt110_GUARANTORTYPE() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-11: "GUARANTOR RELATIONSHIP" - creates it if necessary
     */
    public ID getGUARANTORRELATIONSHIP() { 
		ID retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-11: "GUARANTOR RELATIONSHIP" - creates it if necessary
     */
    public ID getGt111_GUARANTORRELATIONSHIP() { 
		ID retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-12: "GUARANTOR SSN" - creates it if necessary
     */
    public ST getGUARANTORSSN() { 
		ST retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-12: "GUARANTOR SSN" - creates it if necessary
     */
    public ST getGt112_GUARANTORSSN() { 
		ST retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-13: "GUARANTOR DATE - BEGIN" - creates it if necessary
     */
    public DT getGUARANTORDATEBEGIN() { 
		DT retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-13: "GUARANTOR DATE - BEGIN" - creates it if necessary
     */
    public DT getGt113_GUARANTORDATEBEGIN() { 
		DT retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-14: "GUARANTOR DATE - END" - creates it if necessary
     */
    public DT getGUARANTORDATEEND() { 
		DT retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-14: "GUARANTOR DATE - END" - creates it if necessary
     */
    public DT getGt114_GUARANTORDATEEND() { 
		DT retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-15: "GUARANTOR PRIORITY" - creates it if necessary
     */
    public NM getGUARANTORPRIORITY() { 
		NM retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-15: "GUARANTOR PRIORITY" - creates it if necessary
     */
    public NM getGt115_GUARANTORPRIORITY() { 
		NM retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-16: "GUARANTOR EMPLOYER NAME" - creates it if necessary
     */
    public ST getGUARANTOREMPLOYERNAME() { 
		ST retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-16: "GUARANTOR EMPLOYER NAME" - creates it if necessary
     */
    public ST getGt116_GUARANTOREMPLOYERNAME() { 
		ST retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-17: "GUARANTOR EMPLOYER ADDRESS" - creates it if necessary
     */
    public AD getGUARANTOREMPLOYERADDRESS() { 
		AD retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-17: "GUARANTOR EMPLOYER ADDRESS" - creates it if necessary
     */
    public AD getGt117_GUARANTOREMPLOYERADDRESS() { 
		AD retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-18: "GUARANTOR EMPLOY PHONE #" - creates it if necessary
     */
    public TN getGUARANTOREMPLOYPHONE() { 
		TN retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-18: "GUARANTOR EMPLOY PHONE #" - creates it if necessary
     */
    public TN getGt118_GUARANTOREMPLOYPHONE() { 
		TN retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-19: "GUARANTOR EMPLOYEE ID NUM" - creates it if necessary
     */
    public ST getGUARANTOREMPLOYEEIDNUM() { 
		ST retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-19: "GUARANTOR EMPLOYEE ID NUM" - creates it if necessary
     */
    public ST getGt119_GUARANTOREMPLOYEEIDNUM() { 
		ST retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-20: "GUARANTOR EMPLOYMENT STATUS" - creates it if necessary
     */
    public ID getGUARANTOREMPLOYMENTSTATUS() { 
		ID retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-20: "GUARANTOR EMPLOYMENT STATUS" - creates it if necessary
     */
    public ID getGt120_GUARANTOREMPLOYMENTSTATUS() { 
		ID retVal = this.getTypedField(20, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new ID(getMessage(), new Integer( 0 ));
          case 2: return new PN(getMessage());
          case 3: return new PN(getMessage());
          case 4: return new AD(getMessage());
          case 5: return new TN(getMessage());
          case 6: return new TN(getMessage());
          case 7: return new DT(getMessage());
          case 8: return new ID(getMessage(), new Integer( 1 ));
          case 9: return new ID(getMessage(), new Integer( 68 ));
          case 10: return new ID(getMessage(), new Integer( 63 ));
          case 11: return new ST(getMessage());
          case 12: return new DT(getMessage());
          case 13: return new DT(getMessage());
          case 14: return new NM(getMessage());
          case 15: return new ST(getMessage());
          case 16: return new AD(getMessage());
          case 17: return new TN(getMessage());
          case 18: return new ST(getMessage());
          case 19: return new ID(getMessage(), new Integer( 66 ));
          default: return null;
       }
   }


}

