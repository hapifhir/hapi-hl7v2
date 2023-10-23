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


package ca.uhn.hl7v2.model.v27.segment;

// import ca.uhn.hl7v2.model.v27.group.*;
import ca.uhn.hl7v2.model.v27.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 REL message segment (Clinical Relationship Segment). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>REL-1: Set ID -REL (SI) <b>optional </b>
     * <li>REL-2: Relationship Type (CWE) <b> </b>
     * <li>REL-3: This Relationship Instance Identifier (EI) <b> </b>
     * <li>REL-4: Source Information Instance Identifier (EI) <b> </b>
     * <li>REL-5: Target Information Instance Identifier (EI) <b> </b>
     * <li>REL-6: Asserting Entity Instance ID (EI) <b>optional </b>
     * <li>REL-7: Asserting Person (XCN) <b>optional </b>
     * <li>REL-8: Asserting Organization (XON) <b>optional </b>
     * <li>REL-9: Assertor Address (XAD) <b>optional </b>
     * <li>REL-10: Assertor Contact (XTN) <b>optional </b>
     * <li>REL-11: Assertion Date Range (DR) <b>optional </b>
     * <li>REL-12: Negation Indicator (ID) <b>optional </b>
     * <li>REL-13: Certainty of Relationship (CWE) <b>optional </b>
     * <li>REL-14: Priority No (NM) <b>optional </b>
     * <li>REL-15: Priority  Sequence No (rel preference for consideration) (NM) <b>optional </b>
     * <li>REL-16: Separability Indicator (ID) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class REL extends AbstractSegment {

    /** 
     * Creates a new REL segment
     */
    public REL(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, false, 1, 4, new Object[]{ getMessage() }, "Set ID -REL");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Relationship Type");
                                  this.add(EI.class, true, 1, 0, new Object[]{ getMessage() }, "This Relationship Instance Identifier");
                                  this.add(EI.class, true, 1, 0, new Object[]{ getMessage() }, "Source Information Instance Identifier");
                                  this.add(EI.class, true, 1, 0, new Object[]{ getMessage() }, "Target Information Instance Identifier");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Asserting Entity Instance ID");
                                  this.add(XCN.class, false, 1, 0, new Object[]{ getMessage() }, "Asserting Person");
                                  this.add(XON.class, false, 1, 0, new Object[]{ getMessage() }, "Asserting Organization");
                                  this.add(XAD.class, false, 1, 0, new Object[]{ getMessage() }, "Assertor Address");
                                  this.add(XTN.class, false, 1, 0, new Object[]{ getMessage() }, "Assertor Contact");
                                  this.add(DR.class, false, 1, 0, new Object[]{ getMessage() }, "Assertion Date Range");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Negation Indicator");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Certainty of Relationship");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Priority No");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Priority  Sequence No (rel preference for consideration)");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Separability Indicator");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating REL - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * REL-1: "Set ID -REL" - creates it if necessary
     */
    public SI getSetIDREL() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * REL-1: "Set ID -REL" - creates it if necessary
     */
    public SI getRel1_SetIDREL() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * REL-2: "Relationship Type" - creates it if necessary
     */
    public CWE getRelationshipType() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * REL-2: "Relationship Type" - creates it if necessary
     */
    public CWE getRel2_RelationshipType() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * REL-3: "This Relationship Instance Identifier" - creates it if necessary
     */
    public EI getThisRelationshipInstanceIdentifier() { 
		EI retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * REL-3: "This Relationship Instance Identifier" - creates it if necessary
     */
    public EI getRel3_ThisRelationshipInstanceIdentifier() { 
		EI retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * REL-4: "Source Information Instance Identifier" - creates it if necessary
     */
    public EI getSourceInformationInstanceIdentifier() { 
		EI retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * REL-4: "Source Information Instance Identifier" - creates it if necessary
     */
    public EI getRel4_SourceInformationInstanceIdentifier() { 
		EI retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * REL-5: "Target Information Instance Identifier" - creates it if necessary
     */
    public EI getTargetInformationInstanceIdentifier() { 
		EI retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * REL-5: "Target Information Instance Identifier" - creates it if necessary
     */
    public EI getRel5_TargetInformationInstanceIdentifier() { 
		EI retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * REL-6: "Asserting Entity Instance ID" - creates it if necessary
     */
    public EI getAssertingEntityInstanceID() { 
		EI retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * REL-6: "Asserting Entity Instance ID" - creates it if necessary
     */
    public EI getRel6_AssertingEntityInstanceID() { 
		EI retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * REL-7: "Asserting Person" - creates it if necessary
     */
    public XCN getAssertingPerson() { 
		XCN retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * REL-7: "Asserting Person" - creates it if necessary
     */
    public XCN getRel7_AssertingPerson() { 
		XCN retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * REL-8: "Asserting Organization" - creates it if necessary
     */
    public XON getAssertingOrganization() { 
		XON retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * REL-8: "Asserting Organization" - creates it if necessary
     */
    public XON getRel8_AssertingOrganization() { 
		XON retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * REL-9: "Assertor Address" - creates it if necessary
     */
    public XAD getAssertorAddress() { 
		XAD retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * REL-9: "Assertor Address" - creates it if necessary
     */
    public XAD getRel9_AssertorAddress() { 
		XAD retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * REL-10: "Assertor Contact" - creates it if necessary
     */
    public XTN getAssertorContact() { 
		XTN retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * REL-10: "Assertor Contact" - creates it if necessary
     */
    public XTN getRel10_AssertorContact() { 
		XTN retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * REL-11: "Assertion Date Range" - creates it if necessary
     */
    public DR getAssertionDateRange() { 
		DR retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * REL-11: "Assertion Date Range" - creates it if necessary
     */
    public DR getRel11_AssertionDateRange() { 
		DR retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * REL-12: "Negation Indicator" - creates it if necessary
     */
    public ID getNegationIndicator() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * REL-12: "Negation Indicator" - creates it if necessary
     */
    public ID getRel12_NegationIndicator() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * REL-13: "Certainty of Relationship" - creates it if necessary
     */
    public CWE getCertaintyOfRelationship() { 
		CWE retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * REL-13: "Certainty of Relationship" - creates it if necessary
     */
    public CWE getRel13_CertaintyOfRelationship() { 
		CWE retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * REL-14: "Priority No" - creates it if necessary
     */
    public NM getPriorityNo() { 
		NM retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * REL-14: "Priority No" - creates it if necessary
     */
    public NM getRel14_PriorityNo() { 
		NM retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * REL-15: "Priority  Sequence No (rel preference for consideration)" - creates it if necessary
     */
    public NM getPrioritySequenceNoRelpreferenceforconsideration() { 
		NM retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * REL-15: "Priority  Sequence No (rel preference for consideration)" - creates it if necessary
     */
    public NM getRel15_PrioritySequenceNoRelpreferenceforconsideration() { 
		NM retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * REL-16: "Separability Indicator" - creates it if necessary
     */
    public ID getSeparabilityIndicator() { 
		ID retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * REL-16: "Separability Indicator" - creates it if necessary
     */
    public ID getRel16_SeparabilityIndicator() { 
		ID retVal = this.getTypedField(16, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new CWE(getMessage());
          case 2: return new EI(getMessage());
          case 3: return new EI(getMessage());
          case 4: return new EI(getMessage());
          case 5: return new EI(getMessage());
          case 6: return new XCN(getMessage());
          case 7: return new XON(getMessage());
          case 8: return new XAD(getMessage());
          case 9: return new XTN(getMessage());
          case 10: return new DR(getMessage());
          case 11: return new ID(getMessage(), new Integer( 136 ));
          case 12: return new CWE(getMessage());
          case 13: return new NM(getMessage());
          case 14: return new NM(getMessage());
          case 15: return new ID(getMessage(), new Integer( 136 ));
          default: return null;
       }
   }


}

