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
 *<p>Represents an HL7 MSH message segment (MESSAGE HEADER). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>MSH-1: FIELD SEPARATOR (ST) <b> </b>
     * <li>MSH-2: ENCODING CHARACTERS (ST) <b> </b>
     * <li>MSH-3: SENDING APPLICATION (ST) <b>optional </b>
     * <li>MSH-4: SENDING FACILITY (ST) <b>optional </b>
     * <li>MSH-5: RECEIVING APPLICATION (ST) <b>optional </b>
     * <li>MSH-6: RECEIVING FACILITY (ST) <b>optional </b>
     * <li>MSH-7: DATE/TIME OF MESSAGE (TS) <b>optional </b>
     * <li>MSH-8: Security (ST) <b>optional </b>
     * <li>MSH-9: MESSAGE TYPE (CM_MSG) <b> </b>
     * <li>MSH-10: MESSAGE CONTROL ID (ST) <b> </b>
     * <li>MSH-11: PROCESSING ID (ID) <b> </b>
     * <li>MSH-12: VERSION ID (NM) <b> </b>
     * <li>MSH-13: SEQUENCE NUMBER (NM) <b>optional </b>
     * <li>MSH-14: CONTINUATION POINTER (ST) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class MSH extends AbstractSegment {

    /** 
     * Creates a new MSH segment
     */
    public MSH(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ST.class, true, 1, 1, new Object[]{ getMessage() }, "FIELD SEPARATOR");
                                  this.add(ST.class, true, 1, 4, new Object[]{ getMessage() }, "ENCODING CHARACTERS");
                                  this.add(ST.class, false, 1, 15, new Object[]{ getMessage() }, "SENDING APPLICATION");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "SENDING FACILITY");
                                  this.add(ST.class, false, 1, 15, new Object[]{ getMessage() }, "RECEIVING APPLICATION");
                                  this.add(ST.class, false, 1, 30, new Object[]{ getMessage() }, "RECEIVING FACILITY");
                                  this.add(TS.class, false, 1, 19, new Object[]{ getMessage() }, "DATE/TIME OF MESSAGE");
                                  this.add(ST.class, false, 1, 40, new Object[]{ getMessage() }, "Security");
                                  this.add(CM_MSG.class, true, 1, 7, new Object[]{ getMessage() }, "MESSAGE TYPE");
                                  this.add(ST.class, true, 1, 20, new Object[]{ getMessage() }, "MESSAGE CONTROL ID");
                                              this.add(ID.class, true, 1, 1, new Object[]{ getMessage(), new Integer(103) }, "PROCESSING ID");
                                  this.add(NM.class, true, 1, 8, new Object[]{ getMessage() }, "VERSION ID");
                                  this.add(NM.class, false, 1, 15, new Object[]{ getMessage() }, "SEQUENCE NUMBER");
                                  this.add(ST.class, false, 1, 180, new Object[]{ getMessage() }, "CONTINUATION POINTER");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating MSH - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * MSH-1: "FIELD SEPARATOR" - creates it if necessary
     */
    public ST getFIELDSEPARATOR() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-1: "FIELD SEPARATOR" - creates it if necessary
     */
    public ST getMsh1_FIELDSEPARATOR() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * MSH-2: "ENCODING CHARACTERS" - creates it if necessary
     */
    public ST getENCODINGCHARACTERS() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-2: "ENCODING CHARACTERS" - creates it if necessary
     */
    public ST getMsh2_ENCODINGCHARACTERS() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * MSH-3: "SENDING APPLICATION" - creates it if necessary
     */
    public ST getSENDINGAPPLICATION() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-3: "SENDING APPLICATION" - creates it if necessary
     */
    public ST getMsh3_SENDINGAPPLICATION() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * MSH-4: "SENDING FACILITY" - creates it if necessary
     */
    public ST getSENDINGFACILITY() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-4: "SENDING FACILITY" - creates it if necessary
     */
    public ST getMsh4_SENDINGFACILITY() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * MSH-5: "RECEIVING APPLICATION" - creates it if necessary
     */
    public ST getRECEIVINGAPPLICATION() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-5: "RECEIVING APPLICATION" - creates it if necessary
     */
    public ST getMsh5_RECEIVINGAPPLICATION() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * MSH-6: "RECEIVING FACILITY" - creates it if necessary
     */
    public ST getRECEIVINGFACILITY() { 
		ST retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-6: "RECEIVING FACILITY" - creates it if necessary
     */
    public ST getMsh6_RECEIVINGFACILITY() { 
		ST retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * MSH-7: "DATE/TIME OF MESSAGE" - creates it if necessary
     */
    public TS getDATETIMEOFMESSAGE() { 
		TS retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-7: "DATE/TIME OF MESSAGE" - creates it if necessary
     */
    public TS getMsh7_DATETIMEOFMESSAGE() { 
		TS retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * MSH-8: "Security" - creates it if necessary
     */
    public ST getSecurity() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-8: "Security" - creates it if necessary
     */
    public ST getMsh8_Security() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * MSH-9: "MESSAGE TYPE" - creates it if necessary
     */
    public CM_MSG getMESSAGETYPE() { 
		CM_MSG retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-9: "MESSAGE TYPE" - creates it if necessary
     */
    public CM_MSG getMsh9_MESSAGETYPE() { 
		CM_MSG retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * MSH-10: "MESSAGE CONTROL ID" - creates it if necessary
     */
    public ST getMESSAGECONTROLID() { 
		ST retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-10: "MESSAGE CONTROL ID" - creates it if necessary
     */
    public ST getMsh10_MESSAGECONTROLID() { 
		ST retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * MSH-11: "PROCESSING ID" - creates it if necessary
     */
    public ID getPROCESSINGID() { 
		ID retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-11: "PROCESSING ID" - creates it if necessary
     */
    public ID getMsh11_PROCESSINGID() { 
		ID retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * MSH-12: "VERSION ID" - creates it if necessary
     */
    public NM getVERSIONID() { 
		NM retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-12: "VERSION ID" - creates it if necessary
     */
    public NM getMsh12_VERSIONID() { 
		NM retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * MSH-13: "SEQUENCE NUMBER" - creates it if necessary
     */
    public NM getSEQUENCENUMBER() { 
		NM retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-13: "SEQUENCE NUMBER" - creates it if necessary
     */
    public NM getMsh13_SEQUENCENUMBER() { 
		NM retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * MSH-14: "CONTINUATION POINTER" - creates it if necessary
     */
    public ST getCONTINUATIONPOINTER() { 
		ST retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-14: "CONTINUATION POINTER" - creates it if necessary
     */
    public ST getMsh14_CONTINUATIONPOINTER() { 
		ST retVal = this.getTypedField(14, 0);
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
          case 8: return new CM_MSG(getMessage());
          case 9: return new ST(getMessage());
          case 10: return new ID(getMessage(), new Integer( 103 ));
          case 11: return new NM(getMessage());
          case 12: return new NM(getMessage());
          case 13: return new ST(getMessage());
          default: return null;
       }
   }


}

