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


package ca.uhn.hl7v2.model.v24.segment;

// import ca.uhn.hl7v2.model.v24.group.*;
import ca.uhn.hl7v2.model.v24.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 ABS message segment (Abstract). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>ABS-1: Discharge Care Provider (XCN) <b>optional </b>
     * <li>ABS-2: Transfer Medical Service Code (CE) <b>optional </b>
     * <li>ABS-3: Severity of Illness Code (CE) <b>optional </b>
     * <li>ABS-4: Date/Time of Attestation (TS) <b>optional </b>
     * <li>ABS-5: Attested By (XCN) <b>optional </b>
     * <li>ABS-6: Triage Code (CE) <b>optional </b>
     * <li>ABS-7: Abstract Completion Date/Time (TS) <b>optional </b>
     * <li>ABS-8: Abstracted By (XCN) <b>optional </b>
     * <li>ABS-9: Case Category Code (CE) <b>optional </b>
     * <li>ABS-10: Caesarian Section Indicator (ID) <b>optional </b>
     * <li>ABS-11: Gestation Category Code (CE) <b>optional </b>
     * <li>ABS-12: Gestation Period - Weeks (NM) <b>optional </b>
     * <li>ABS-13: Newborn Code (CE) <b>optional </b>
     * <li>ABS-14: Stillborn Indicator (ID) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class ABS extends AbstractSegment {

    /** 
     * Creates a new ABS segment
     */
    public ABS(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(XCN.class, false, 1, 250, new Object[]{ getMessage() }, "Discharge Care Provider");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Transfer Medical Service Code");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Severity of Illness Code");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Date/Time of Attestation");
                                  this.add(XCN.class, false, 1, 250, new Object[]{ getMessage() }, "Attested By");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Triage Code");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Abstract Completion Date/Time");
                                  this.add(XCN.class, false, 1, 250, new Object[]{ getMessage() }, "Abstracted By");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Case Category Code");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Caesarian Section Indicator");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Gestation Category Code");
                                  this.add(NM.class, false, 1, 3, new Object[]{ getMessage() }, "Gestation Period - Weeks");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Newborn Code");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Stillborn Indicator");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating ABS - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * ABS-1: "Discharge Care Provider" - creates it if necessary
     */
    public XCN getDischargeCareProvider() { 
		XCN retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ABS-1: "Discharge Care Provider" - creates it if necessary
     */
    public XCN getAbs1_DischargeCareProvider() { 
		XCN retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * ABS-2: "Transfer Medical Service Code" - creates it if necessary
     */
    public CE getTransferMedicalServiceCode() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ABS-2: "Transfer Medical Service Code" - creates it if necessary
     */
    public CE getAbs2_TransferMedicalServiceCode() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * ABS-3: "Severity of Illness Code" - creates it if necessary
     */
    public CE getSeverityOfIllnessCode() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ABS-3: "Severity of Illness Code" - creates it if necessary
     */
    public CE getAbs3_SeverityOfIllnessCode() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * ABS-4: "Date/Time of Attestation" - creates it if necessary
     */
    public TS getDateTimeOfAttestation() { 
		TS retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ABS-4: "Date/Time of Attestation" - creates it if necessary
     */
    public TS getAbs4_DateTimeOfAttestation() { 
		TS retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * ABS-5: "Attested By" - creates it if necessary
     */
    public XCN getAttestedBy() { 
		XCN retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ABS-5: "Attested By" - creates it if necessary
     */
    public XCN getAbs5_AttestedBy() { 
		XCN retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * ABS-6: "Triage Code" - creates it if necessary
     */
    public CE getTriageCode() { 
		CE retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ABS-6: "Triage Code" - creates it if necessary
     */
    public CE getAbs6_TriageCode() { 
		CE retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * ABS-7: "Abstract Completion Date/Time" - creates it if necessary
     */
    public TS getAbstractCompletionDateTime() { 
		TS retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ABS-7: "Abstract Completion Date/Time" - creates it if necessary
     */
    public TS getAbs7_AbstractCompletionDateTime() { 
		TS retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * ABS-8: "Abstracted By" - creates it if necessary
     */
    public XCN getAbstractedBy() { 
		XCN retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ABS-8: "Abstracted By" - creates it if necessary
     */
    public XCN getAbs8_AbstractedBy() { 
		XCN retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * ABS-9: "Case Category Code" - creates it if necessary
     */
    public CE getCaseCategoryCode() { 
		CE retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ABS-9: "Case Category Code" - creates it if necessary
     */
    public CE getAbs9_CaseCategoryCode() { 
		CE retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * ABS-10: "Caesarian Section Indicator" - creates it if necessary
     */
    public ID getCaesarianSectionIndicator() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ABS-10: "Caesarian Section Indicator" - creates it if necessary
     */
    public ID getAbs10_CaesarianSectionIndicator() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * ABS-11: "Gestation Category Code" - creates it if necessary
     */
    public CE getGestationCategoryCode() { 
		CE retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ABS-11: "Gestation Category Code" - creates it if necessary
     */
    public CE getAbs11_GestationCategoryCode() { 
		CE retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * ABS-12: "Gestation Period - Weeks" - creates it if necessary
     */
    public NM getGestationPeriodWeeks() { 
		NM retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ABS-12: "Gestation Period - Weeks" - creates it if necessary
     */
    public NM getAbs12_GestationPeriodWeeks() { 
		NM retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * ABS-13: "Newborn Code" - creates it if necessary
     */
    public CE getNewbornCode() { 
		CE retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ABS-13: "Newborn Code" - creates it if necessary
     */
    public CE getAbs13_NewbornCode() { 
		CE retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * ABS-14: "Stillborn Indicator" - creates it if necessary
     */
    public ID getStillbornIndicator() { 
		ID retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ABS-14: "Stillborn Indicator" - creates it if necessary
     */
    public ID getAbs14_StillbornIndicator() { 
		ID retVal = this.getTypedField(14, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new XCN(getMessage());
          case 1: return new CE(getMessage());
          case 2: return new CE(getMessage());
          case 3: return new TS(getMessage());
          case 4: return new XCN(getMessage());
          case 5: return new CE(getMessage());
          case 6: return new TS(getMessage());
          case 7: return new XCN(getMessage());
          case 8: return new CE(getMessage());
          case 9: return new ID(getMessage(), new Integer( 136 ));
          case 10: return new CE(getMessage());
          case 11: return new NM(getMessage());
          case 12: return new CE(getMessage());
          case 13: return new ID(getMessage(), new Integer( 136 ));
          default: return null;
       }
   }


}

