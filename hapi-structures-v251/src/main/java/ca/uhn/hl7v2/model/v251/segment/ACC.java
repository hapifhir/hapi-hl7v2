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


package ca.uhn.hl7v2.model.v251.segment;

// import ca.uhn.hl7v2.model.v251.group.*;
import ca.uhn.hl7v2.model.v251.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 ACC message segment (Accident). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>ACC-1: Accident Date/Time (TS) <b>optional </b>
     * <li>ACC-2: Accident Code (CE) <b>optional </b>
     * <li>ACC-3: Accident Location (ST) <b>optional </b>
     * <li>ACC-4: Auto Accident State (CE) <b>optional </b>
     * <li>ACC-5: Accident Job Related Indicator (ID) <b>optional </b>
     * <li>ACC-6: Accident Death Indicator (ID) <b>optional </b>
     * <li>ACC-7: Entered By (XCN) <b>optional </b>
     * <li>ACC-8: Accident Description (ST) <b>optional </b>
     * <li>ACC-9: Brought In By (ST) <b>optional </b>
     * <li>ACC-10: Police Notified Indicator (ID) <b>optional </b>
     * <li>ACC-11: Accident Address (XAD) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class ACC extends AbstractSegment {

    /** 
     * Creates a new ACC segment
     */
    public ACC(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Accident Date/Time");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Accident Code");
                                  this.add(ST.class, false, 1, 25, new Object[]{ getMessage() }, "Accident Location");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Auto Accident State");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Accident Job Related Indicator");
                                              this.add(ID.class, false, 1, 12, new Object[]{ getMessage(), new Integer(136) }, "Accident Death Indicator");
                                  this.add(XCN.class, false, 1, 250, new Object[]{ getMessage() }, "Entered By");
                                  this.add(ST.class, false, 1, 25, new Object[]{ getMessage() }, "Accident Description");
                                  this.add(ST.class, false, 1, 80, new Object[]{ getMessage() }, "Brought In By");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Police Notified Indicator");
                                  this.add(XAD.class, false, 1, 250, new Object[]{ getMessage() }, "Accident Address");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating ACC - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * ACC-1: "Accident Date/Time" - creates it if necessary
     */
    public TS getAccidentDateTime() { 
		TS retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ACC-1: "Accident Date/Time" - creates it if necessary
     */
    public TS getAcc1_AccidentDateTime() { 
		TS retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * ACC-2: "Accident Code" - creates it if necessary
     */
    public CE getAccidentCode() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ACC-2: "Accident Code" - creates it if necessary
     */
    public CE getAcc2_AccidentCode() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * ACC-3: "Accident Location" - creates it if necessary
     */
    public ST getAccidentLocation() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ACC-3: "Accident Location" - creates it if necessary
     */
    public ST getAcc3_AccidentLocation() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * ACC-4: "Auto Accident State" - creates it if necessary
     */
    public CE getAutoAccidentState() { 
		CE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ACC-4: "Auto Accident State" - creates it if necessary
     */
    public CE getAcc4_AutoAccidentState() { 
		CE retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * ACC-5: "Accident Job Related Indicator" - creates it if necessary
     */
    public ID getAccidentJobRelatedIndicator() { 
		ID retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ACC-5: "Accident Job Related Indicator" - creates it if necessary
     */
    public ID getAcc5_AccidentJobRelatedIndicator() { 
		ID retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * ACC-6: "Accident Death Indicator" - creates it if necessary
     */
    public ID getAccidentDeathIndicator() { 
		ID retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ACC-6: "Accident Death Indicator" - creates it if necessary
     */
    public ID getAcc6_AccidentDeathIndicator() { 
		ID retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * ACC-7: "Entered By" - creates it if necessary
     */
    public XCN getEnteredBy() { 
		XCN retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ACC-7: "Entered By" - creates it if necessary
     */
    public XCN getAcc7_EnteredBy() { 
		XCN retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * ACC-8: "Accident Description" - creates it if necessary
     */
    public ST getAccidentDescription() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ACC-8: "Accident Description" - creates it if necessary
     */
    public ST getAcc8_AccidentDescription() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * ACC-9: "Brought In By" - creates it if necessary
     */
    public ST getBroughtInBy() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ACC-9: "Brought In By" - creates it if necessary
     */
    public ST getAcc9_BroughtInBy() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * ACC-10: "Police Notified Indicator" - creates it if necessary
     */
    public ID getPoliceNotifiedIndicator() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ACC-10: "Police Notified Indicator" - creates it if necessary
     */
    public ID getAcc10_PoliceNotifiedIndicator() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * ACC-11: "Accident Address" - creates it if necessary
     */
    public XAD getAccidentAddress() { 
		XAD retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ACC-11: "Accident Address" - creates it if necessary
     */
    public XAD getAcc11_AccidentAddress() { 
		XAD retVal = this.getTypedField(11, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new TS(getMessage());
          case 1: return new CE(getMessage());
          case 2: return new ST(getMessage());
          case 3: return new CE(getMessage());
          case 4: return new ID(getMessage(), new Integer( 136 ));
          case 5: return new ID(getMessage(), new Integer( 136 ));
          case 6: return new XCN(getMessage());
          case 7: return new ST(getMessage());
          case 8: return new ST(getMessage());
          case 9: return new ID(getMessage(), new Integer( 136 ));
          case 10: return new XAD(getMessage());
          default: return null;
       }
   }


}

