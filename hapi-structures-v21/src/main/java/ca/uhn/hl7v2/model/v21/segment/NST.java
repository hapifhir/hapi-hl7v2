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
 *<p>Represents an HL7 NST message segment (STATISTICS). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>NST-1: STATISTICS AVAILABLE (ID) <b> </b>
     * <li>NST-2: SOURCE IDENTIFIER (ST) <b>optional </b>
     * <li>NST-3: SOURCE TYPE (ID) <b>optional </b>
     * <li>NST-4: STATISTICS START (TS) <b>optional </b>
     * <li>NST-5: STATISTICS END (TS) <b>optional </b>
     * <li>NST-6: RECEIVE CHARACTER COUNT (NM) <b>optional </b>
     * <li>NST-7: SEND CHARACTER COUNT (NM) <b>optional </b>
     * <li>NST-8: MESSAGES RECEIVED (NM) <b>optional </b>
     * <li>NST-9: MESSAGES SENT (NM) <b>optional </b>
     * <li>NST-10: CHECKSUM ERRORS RECEIVED (NM) <b>optional </b>
     * <li>NST-11: LENGTH ERRORS RECEIVED (NM) <b>optional </b>
     * <li>NST-12: OTHER ERRORS RECEIVED (NM) <b>optional </b>
     * <li>NST-13: CONNECT TIMEOUTS (NM) <b>optional </b>
     * <li>NST-14: RECEIVE TIMEOUTS (NM) <b>optional </b>
     * <li>NST-15: NETWORK ERRORS (NM) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class NST extends AbstractSegment {

    /** 
     * Creates a new NST segment
     */
    public NST(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                              this.add(ID.class, true, 1, 1, new Object[]{ getMessage(), new Integer(0) }, "STATISTICS AVAILABLE");
                                  this.add(ST.class, false, 1, 30, new Object[]{ getMessage() }, "SOURCE IDENTIFIER");
                                              this.add(ID.class, false, 1, 3, new Object[]{ getMessage(), new Integer(0) }, "SOURCE TYPE");
                                  this.add(TS.class, false, 1, 19, new Object[]{ getMessage() }, "STATISTICS START");
                                  this.add(TS.class, false, 1, 19, new Object[]{ getMessage() }, "STATISTICS END");
                                  this.add(NM.class, false, 1, 10, new Object[]{ getMessage() }, "RECEIVE CHARACTER COUNT");
                                  this.add(NM.class, false, 1, 10, new Object[]{ getMessage() }, "SEND CHARACTER COUNT");
                                  this.add(NM.class, false, 1, 10, new Object[]{ getMessage() }, "MESSAGES RECEIVED");
                                  this.add(NM.class, false, 1, 10, new Object[]{ getMessage() }, "MESSAGES SENT");
                                  this.add(NM.class, false, 1, 10, new Object[]{ getMessage() }, "CHECKSUM ERRORS RECEIVED");
                                  this.add(NM.class, false, 1, 10, new Object[]{ getMessage() }, "LENGTH ERRORS RECEIVED");
                                  this.add(NM.class, false, 1, 10, new Object[]{ getMessage() }, "OTHER ERRORS RECEIVED");
                                  this.add(NM.class, false, 1, 10, new Object[]{ getMessage() }, "CONNECT TIMEOUTS");
                                  this.add(NM.class, false, 1, 10, new Object[]{ getMessage() }, "RECEIVE TIMEOUTS");
                                  this.add(NM.class, false, 1, 10, new Object[]{ getMessage() }, "NETWORK ERRORS");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating NST - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * NST-1: "STATISTICS AVAILABLE" - creates it if necessary
     */
    public ID getSTATISTICSAVAILABLE() { 
		ID retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NST-1: "STATISTICS AVAILABLE" - creates it if necessary
     */
    public ID getNst1_STATISTICSAVAILABLE() { 
		ID retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * NST-2: "SOURCE IDENTIFIER" - creates it if necessary
     */
    public ST getSOURCEIDENTIFIER() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NST-2: "SOURCE IDENTIFIER" - creates it if necessary
     */
    public ST getNst2_SOURCEIDENTIFIER() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * NST-3: "SOURCE TYPE" - creates it if necessary
     */
    public ID getSOURCETYPE() { 
		ID retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NST-3: "SOURCE TYPE" - creates it if necessary
     */
    public ID getNst3_SOURCETYPE() { 
		ID retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * NST-4: "STATISTICS START" - creates it if necessary
     */
    public TS getSTATISTICSSTART() { 
		TS retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NST-4: "STATISTICS START" - creates it if necessary
     */
    public TS getNst4_STATISTICSSTART() { 
		TS retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * NST-5: "STATISTICS END" - creates it if necessary
     */
    public TS getSTATISTICSEND() { 
		TS retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NST-5: "STATISTICS END" - creates it if necessary
     */
    public TS getNst5_STATISTICSEND() { 
		TS retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * NST-6: "RECEIVE CHARACTER COUNT" - creates it if necessary
     */
    public NM getRECEIVECHARACTERCOUNT() { 
		NM retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NST-6: "RECEIVE CHARACTER COUNT" - creates it if necessary
     */
    public NM getNst6_RECEIVECHARACTERCOUNT() { 
		NM retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * NST-7: "SEND CHARACTER COUNT" - creates it if necessary
     */
    public NM getSENDCHARACTERCOUNT() { 
		NM retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NST-7: "SEND CHARACTER COUNT" - creates it if necessary
     */
    public NM getNst7_SENDCHARACTERCOUNT() { 
		NM retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * NST-8: "MESSAGES RECEIVED" - creates it if necessary
     */
    public NM getMESSAGESRECEIVED() { 
		NM retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NST-8: "MESSAGES RECEIVED" - creates it if necessary
     */
    public NM getNst8_MESSAGESRECEIVED() { 
		NM retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * NST-9: "MESSAGES SENT" - creates it if necessary
     */
    public NM getMESSAGESSENT() { 
		NM retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NST-9: "MESSAGES SENT" - creates it if necessary
     */
    public NM getNst9_MESSAGESSENT() { 
		NM retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * NST-10: "CHECKSUM ERRORS RECEIVED" - creates it if necessary
     */
    public NM getCHECKSUMERRORSRECEIVED() { 
		NM retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NST-10: "CHECKSUM ERRORS RECEIVED" - creates it if necessary
     */
    public NM getNst10_CHECKSUMERRORSRECEIVED() { 
		NM retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * NST-11: "LENGTH ERRORS RECEIVED" - creates it if necessary
     */
    public NM getLENGTHERRORSRECEIVED() { 
		NM retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NST-11: "LENGTH ERRORS RECEIVED" - creates it if necessary
     */
    public NM getNst11_LENGTHERRORSRECEIVED() { 
		NM retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * NST-12: "OTHER ERRORS RECEIVED" - creates it if necessary
     */
    public NM getOTHERERRORSRECEIVED() { 
		NM retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NST-12: "OTHER ERRORS RECEIVED" - creates it if necessary
     */
    public NM getNst12_OTHERERRORSRECEIVED() { 
		NM retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * NST-13: "CONNECT TIMEOUTS" - creates it if necessary
     */
    public NM getCONNECTTIMEOUTS() { 
		NM retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NST-13: "CONNECT TIMEOUTS" - creates it if necessary
     */
    public NM getNst13_CONNECTTIMEOUTS() { 
		NM retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * NST-14: "RECEIVE TIMEOUTS" - creates it if necessary
     */
    public NM getRECEIVETIMEOUTS() { 
		NM retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NST-14: "RECEIVE TIMEOUTS" - creates it if necessary
     */
    public NM getNst14_RECEIVETIMEOUTS() { 
		NM retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * NST-15: "NETWORK ERRORS" - creates it if necessary
     */
    public NM getNETWORKERRORS() { 
		NM retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NST-15: "NETWORK ERRORS" - creates it if necessary
     */
    public NM getNst15_NETWORKERRORS() { 
		NM retVal = this.getTypedField(15, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ID(getMessage(), new Integer( 0 ));
          case 1: return new ST(getMessage());
          case 2: return new ID(getMessage(), new Integer( 0 ));
          case 3: return new TS(getMessage());
          case 4: return new TS(getMessage());
          case 5: return new NM(getMessage());
          case 6: return new NM(getMessage());
          case 7: return new NM(getMessage());
          case 8: return new NM(getMessage());
          case 9: return new NM(getMessage());
          case 10: return new NM(getMessage());
          case 11: return new NM(getMessage());
          case 12: return new NM(getMessage());
          case 13: return new NM(getMessage());
          case 14: return new NM(getMessage());
          default: return null;
       }
   }


}

