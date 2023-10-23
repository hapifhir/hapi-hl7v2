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
 *<p>Represents an HL7 RXA message segment (PHARMACY AADMINISTRATION). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>RXA-1: Give Sub-ID Counter (NM) <b> </b>
     * <li>RXA-2: Administration Sub-ID Counter (NM) <b> </b>
     * <li>RXA-3: Date / time start of administration (TS) <b> </b>
     * <li>RXA-4: Date / time end of administration (TS) <b> </b>
     * <li>RXA-5: Administered Code (CE) <b> </b>
     * <li>RXA-6: Administered Amount (NM) <b> </b>
     * <li>RXA-7: Administered Units (CE) <b>optional </b>
     * <li>RXA-8: Administered Dosage Form (CE) <b>optional </b>
     * <li>RXA-9: Administration Notes (ST) <b>optional </b>
     * <li>RXA-10: Administering Provider (CN) <b>optional </b>
     * <li>RXA-11: Administered-at Location (CM_LA1) <b>optional </b>
     * <li>RXA-12: Administered Per (Time Unit) (ST) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class RXA extends AbstractSegment {

    /** 
     * Creates a new RXA segment
     */
    public RXA(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(NM.class, true, 1, 4, new Object[]{ getMessage() }, "Give Sub-ID Counter");
                                  this.add(NM.class, true, 1, 4, new Object[]{ getMessage() }, "Administration Sub-ID Counter");
                                  this.add(TS.class, true, 1, 26, new Object[]{ getMessage() }, "Date / time start of administration");
                                  this.add(TS.class, true, 1, 26, new Object[]{ getMessage() }, "Date / time end of administration");
                                  this.add(CE.class, true, 1, 100, new Object[]{ getMessage() }, "Administered Code");
                                  this.add(NM.class, true, 1, 20, new Object[]{ getMessage() }, "Administered Amount");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Administered Units");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Administered Dosage Form");
                                  this.add(ST.class, false, 1, 200, new Object[]{ getMessage() }, "Administration Notes");
                                  this.add(CN.class, false, 1, 200, new Object[]{ getMessage() }, "Administering Provider");
                                  this.add(CM_LA1.class, false, 1, 12, new Object[]{ getMessage() }, "Administered-at Location");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "Administered Per (Time Unit)");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating RXA - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * RXA-1: "Give Sub-ID Counter" - creates it if necessary
     */
    public NM getGiveSubIDCounter() { 
		NM retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXA-1: "Give Sub-ID Counter" - creates it if necessary
     */
    public NM getRxa1_GiveSubIDCounter() { 
		NM retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * RXA-2: "Administration Sub-ID Counter" - creates it if necessary
     */
    public NM getAdministrationSubIDCounter() { 
		NM retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXA-2: "Administration Sub-ID Counter" - creates it if necessary
     */
    public NM getRxa2_AdministrationSubIDCounter() { 
		NM retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * RXA-3: "Date / time start of administration" - creates it if necessary
     */
    public TS getDateTimeStartOfAdministration() { 
		TS retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXA-3: "Date / time start of administration" - creates it if necessary
     */
    public TS getRxa3_DateTimeStartOfAdministration() { 
		TS retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * RXA-4: "Date / time end of administration" - creates it if necessary
     */
    public TS getDateTimeEndOfAdministration() { 
		TS retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXA-4: "Date / time end of administration" - creates it if necessary
     */
    public TS getRxa4_DateTimeEndOfAdministration() { 
		TS retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * RXA-5: "Administered Code" - creates it if necessary
     */
    public CE getAdministeredCode() { 
		CE retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXA-5: "Administered Code" - creates it if necessary
     */
    public CE getRxa5_AdministeredCode() { 
		CE retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * RXA-6: "Administered Amount" - creates it if necessary
     */
    public NM getAdministeredAmount() { 
		NM retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXA-6: "Administered Amount" - creates it if necessary
     */
    public NM getRxa6_AdministeredAmount() { 
		NM retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * RXA-7: "Administered Units" - creates it if necessary
     */
    public CE getAdministeredUnits() { 
		CE retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXA-7: "Administered Units" - creates it if necessary
     */
    public CE getRxa7_AdministeredUnits() { 
		CE retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * RXA-8: "Administered Dosage Form" - creates it if necessary
     */
    public CE getAdministeredDosageForm() { 
		CE retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXA-8: "Administered Dosage Form" - creates it if necessary
     */
    public CE getRxa8_AdministeredDosageForm() { 
		CE retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * RXA-9: "Administration Notes" - creates it if necessary
     */
    public ST getAdministrationNotes() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXA-9: "Administration Notes" - creates it if necessary
     */
    public ST getRxa9_AdministrationNotes() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * RXA-10: "Administering Provider" - creates it if necessary
     */
    public CN getAdministeringProvider() { 
		CN retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXA-10: "Administering Provider" - creates it if necessary
     */
    public CN getRxa10_AdministeringProvider() { 
		CN retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * RXA-11: "Administered-at Location" - creates it if necessary
     */
    public CM_LA1 getAdministeredAtLocation() { 
		CM_LA1 retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXA-11: "Administered-at Location" - creates it if necessary
     */
    public CM_LA1 getRxa11_AdministeredAtLocation() { 
		CM_LA1 retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * RXA-12: "Administered Per (Time Unit)" - creates it if necessary
     */
    public ST getAdministeredPerTimeUnit() { 
		ST retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXA-12: "Administered Per (Time Unit)" - creates it if necessary
     */
    public ST getRxa12_AdministeredPerTimeUnit() { 
		ST retVal = this.getTypedField(12, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new NM(getMessage());
          case 1: return new NM(getMessage());
          case 2: return new TS(getMessage());
          case 3: return new TS(getMessage());
          case 4: return new CE(getMessage());
          case 5: return new NM(getMessage());
          case 6: return new CE(getMessage());
          case 7: return new CE(getMessage());
          case 8: return new ST(getMessage());
          case 9: return new CN(getMessage());
          case 10: return new CM_LA1(getMessage());
          case 11: return new ST(getMessage());
          default: return null;
       }
   }


}

