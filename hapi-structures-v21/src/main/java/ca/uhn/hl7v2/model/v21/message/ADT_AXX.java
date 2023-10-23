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


package ca.uhn.hl7v2.model.v21.message;

import ca.uhn.hl7v2.model.v21.group.*;
import ca.uhn.hl7v2.model.v21.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.*;


/**
 * <p>Represents a ADT_AXX message structure (see chapter ). This structure contains the 
 * following elements: </p>
 * <ul>
		                 * <li>1: MSH () <b> </b> <ul><li>Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A18, ADT_A20, ADT_A21, ADT_A22, ADT_A23, ADT_A24]</li></ul></li>
		                 * <li>2: EVN () <b> </b> <ul><li>Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A18, ADT_A20, ADT_A21, ADT_A22, ADT_A23, ADT_A24]</li></ul></li>
		                 * <li>3: PID () <b>optional </b> <ul><li>Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A18, ADT_A21, ADT_A22, ADT_A23, ADT_A24]</li></ul></li>
		                 * <li>4: MRG () <b>optional </b> <ul><li>Used for the following structures: [ADT_A18]</li></ul></li>
		                 * <li>5: PD1 () <b>optional </b> <ul><li>Used for the following structures: [ADT_A14]</li></ul></li>
		                 * <li>6: NK1 () <b>optional </b> <ul><li>Used for the following structures: [ADT_A01, ADT_A04, ADT_A05, ADT_A08, ADT_A14]</li></ul></li>
		                 * <li>7: PV1 () <b>optional </b> <ul><li>Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A18, ADT_A21, ADT_A22, ADT_A23, ADT_A24]</li></ul></li>
		                 * <li>8: DG1 () <b>optional </b> <ul><li>Used for the following structures: [ADT_A01, ADT_A04, ADT_A05, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16]</li></ul></li>
		                 * <li>9: ADT_AXX_PATIENT () <b>optional repeating</b> </li>
		                 * <li>10: NPU () <b>optional </b> <ul><li>Used for the following structures: [ADT_A20]</li></ul></li>
		                 * <li>11: PID () <b>optional </b> <ul><li>Used for the following structures: [ADT_A24]</li></ul></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class ADT_AXX extends AbstractSuperMessage  {

    /**
     * Creates a new ADT_AXX message with DefaultModelClassFactory. 
     */ 
    public ADT_AXX() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new ADT_AXX message with custom ModelClassFactory.
     */
    public ADT_AXX(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
	          this.addSuperstructureApplication("MSH", "ADT_A01"); 
	          this.addSuperstructureApplication("MSH", "ADT_A02"); 
	          this.addSuperstructureApplication("MSH", "ADT_A03"); 
	          this.addSuperstructureApplication("MSH", "ADT_A04"); 
	          this.addSuperstructureApplication("MSH", "ADT_A05"); 
	          this.addSuperstructureApplication("MSH", "ADT_A06"); 
	          this.addSuperstructureApplication("MSH", "ADT_A07"); 
	          this.addSuperstructureApplication("MSH", "ADT_A08"); 
	          this.addSuperstructureApplication("MSH", "ADT_A09"); 
	          this.addSuperstructureApplication("MSH", "ADT_A10"); 
	          this.addSuperstructureApplication("MSH", "ADT_A11"); 
	          this.addSuperstructureApplication("MSH", "ADT_A12"); 
	          this.addSuperstructureApplication("MSH", "ADT_A13"); 
	          this.addSuperstructureApplication("MSH", "ADT_A14"); 
	          this.addSuperstructureApplication("MSH", "ADT_A15"); 
	          this.addSuperstructureApplication("MSH", "ADT_A16"); 
	          this.addSuperstructureApplication("MSH", "ADT_A17"); 
	          this.addSuperstructureApplication("MSH", "ADT_A18"); 
	          this.addSuperstructureApplication("MSH", "ADT_A20"); 
	          this.addSuperstructureApplication("MSH", "ADT_A21"); 
	          this.addSuperstructureApplication("MSH", "ADT_A22"); 
	          this.addSuperstructureApplication("MSH", "ADT_A23"); 
	          this.addSuperstructureApplication("MSH", "ADT_A24"); 
	                          this.add(EVN.class, true, false);
	          this.addSuperstructureApplication("EVN", "ADT_A01"); 
	          this.addSuperstructureApplication("EVN", "ADT_A02"); 
	          this.addSuperstructureApplication("EVN", "ADT_A03"); 
	          this.addSuperstructureApplication("EVN", "ADT_A04"); 
	          this.addSuperstructureApplication("EVN", "ADT_A05"); 
	          this.addSuperstructureApplication("EVN", "ADT_A06"); 
	          this.addSuperstructureApplication("EVN", "ADT_A07"); 
	          this.addSuperstructureApplication("EVN", "ADT_A08"); 
	          this.addSuperstructureApplication("EVN", "ADT_A09"); 
	          this.addSuperstructureApplication("EVN", "ADT_A10"); 
	          this.addSuperstructureApplication("EVN", "ADT_A11"); 
	          this.addSuperstructureApplication("EVN", "ADT_A12"); 
	          this.addSuperstructureApplication("EVN", "ADT_A13"); 
	          this.addSuperstructureApplication("EVN", "ADT_A14"); 
	          this.addSuperstructureApplication("EVN", "ADT_A15"); 
	          this.addSuperstructureApplication("EVN", "ADT_A16"); 
	          this.addSuperstructureApplication("EVN", "ADT_A17"); 
	          this.addSuperstructureApplication("EVN", "ADT_A18"); 
	          this.addSuperstructureApplication("EVN", "ADT_A20"); 
	          this.addSuperstructureApplication("EVN", "ADT_A21"); 
	          this.addSuperstructureApplication("EVN", "ADT_A22"); 
	          this.addSuperstructureApplication("EVN", "ADT_A23"); 
	          this.addSuperstructureApplication("EVN", "ADT_A24"); 
	                          this.add(PID.class, false, false);
	          this.addSuperstructureApplication("PID", "ADT_A01"); 
	          this.addSuperstructureApplication("PID", "ADT_A02"); 
	          this.addSuperstructureApplication("PID", "ADT_A03"); 
	          this.addSuperstructureApplication("PID", "ADT_A04"); 
	          this.addSuperstructureApplication("PID", "ADT_A05"); 
	          this.addSuperstructureApplication("PID", "ADT_A06"); 
	          this.addSuperstructureApplication("PID", "ADT_A07"); 
	          this.addSuperstructureApplication("PID", "ADT_A08"); 
	          this.addSuperstructureApplication("PID", "ADT_A09"); 
	          this.addSuperstructureApplication("PID", "ADT_A10"); 
	          this.addSuperstructureApplication("PID", "ADT_A11"); 
	          this.addSuperstructureApplication("PID", "ADT_A12"); 
	          this.addSuperstructureApplication("PID", "ADT_A13"); 
	          this.addSuperstructureApplication("PID", "ADT_A14"); 
	          this.addSuperstructureApplication("PID", "ADT_A15"); 
	          this.addSuperstructureApplication("PID", "ADT_A16"); 
	          this.addSuperstructureApplication("PID", "ADT_A18"); 
	          this.addSuperstructureApplication("PID", "ADT_A21"); 
	          this.addSuperstructureApplication("PID", "ADT_A22"); 
	          this.addSuperstructureApplication("PID", "ADT_A23"); 
	          this.addSuperstructureApplication("PID", "ADT_A24"); 
	                          this.add(MRG.class, false, false);
	          this.addSuperstructureApplication("MRG", "ADT_A18"); 
	                          this.add(PD1.class, false, false);
	          this.addSuperstructureApplication("PD1", "ADT_A14"); 
	                          this.add(NK1.class, false, false);
	          this.addSuperstructureApplication("NK1", "ADT_A01"); 
	          this.addSuperstructureApplication("NK1", "ADT_A04"); 
	          this.addSuperstructureApplication("NK1", "ADT_A05"); 
	          this.addSuperstructureApplication("NK1", "ADT_A08"); 
	          this.addSuperstructureApplication("NK1", "ADT_A14"); 
	                          this.add(PV1.class, false, false);
	          this.addSuperstructureApplication("PV1", "ADT_A01"); 
	          this.addSuperstructureApplication("PV1", "ADT_A02"); 
	          this.addSuperstructureApplication("PV1", "ADT_A03"); 
	          this.addSuperstructureApplication("PV1", "ADT_A04"); 
	          this.addSuperstructureApplication("PV1", "ADT_A05"); 
	          this.addSuperstructureApplication("PV1", "ADT_A06"); 
	          this.addSuperstructureApplication("PV1", "ADT_A07"); 
	          this.addSuperstructureApplication("PV1", "ADT_A08"); 
	          this.addSuperstructureApplication("PV1", "ADT_A09"); 
	          this.addSuperstructureApplication("PV1", "ADT_A10"); 
	          this.addSuperstructureApplication("PV1", "ADT_A11"); 
	          this.addSuperstructureApplication("PV1", "ADT_A12"); 
	          this.addSuperstructureApplication("PV1", "ADT_A13"); 
	          this.addSuperstructureApplication("PV1", "ADT_A14"); 
	          this.addSuperstructureApplication("PV1", "ADT_A15"); 
	          this.addSuperstructureApplication("PV1", "ADT_A16"); 
	          this.addSuperstructureApplication("PV1", "ADT_A18"); 
	          this.addSuperstructureApplication("PV1", "ADT_A21"); 
	          this.addSuperstructureApplication("PV1", "ADT_A22"); 
	          this.addSuperstructureApplication("PV1", "ADT_A23"); 
	          this.addSuperstructureApplication("PV1", "ADT_A24"); 
	                          this.add(DG1.class, false, false);
	          this.addSuperstructureApplication("DG1", "ADT_A01"); 
	          this.addSuperstructureApplication("DG1", "ADT_A04"); 
	          this.addSuperstructureApplication("DG1", "ADT_A05"); 
	          this.addSuperstructureApplication("DG1", "ADT_A08"); 
	          this.addSuperstructureApplication("DG1", "ADT_A09"); 
	          this.addSuperstructureApplication("DG1", "ADT_A10"); 
	          this.addSuperstructureApplication("DG1", "ADT_A11"); 
	          this.addSuperstructureApplication("DG1", "ADT_A12"); 
	          this.addSuperstructureApplication("DG1", "ADT_A13"); 
	          this.addSuperstructureApplication("DG1", "ADT_A14"); 
	          this.addSuperstructureApplication("DG1", "ADT_A15"); 
	          this.addSuperstructureApplication("DG1", "ADT_A16"); 
	                          this.add(ADT_AXX_PATIENT.class, false, true);
	                          this.add(NPU.class, false, false);
	          this.addSuperstructureApplication("NPU", "ADT_A20"); 
	                          this.add(PID.class, false, false);
	          this.addSuperstructureApplication("PID2", "ADT_A24"); 
	       } catch(HL7Exception e) {
          log.error("Unexpected error creating ADT_AXX - this is probably a bug in the source code generator.", e);
       }
    }

	public java.util.List<String> getChildNamesForStructure(String theStructure) {
		java.util.ArrayList<String> retVal = new java.util.ArrayList<String>();
			if ( "ADT_A01".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("NK1"); 
					retVal.add("PV1"); 
					retVal.add("DG1"); 
				}
			if ( "ADT_A02".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PV1"); 
				}
			if ( "ADT_A03".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PV1"); 
				}
			if ( "ADT_A04".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("NK1"); 
					retVal.add("PV1"); 
					retVal.add("DG1"); 
				}
			if ( "ADT_A05".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("NK1"); 
					retVal.add("PV1"); 
					retVal.add("DG1"); 
				}
			if ( "ADT_A06".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PV1"); 
				}
			if ( "ADT_A07".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PV1"); 
				}
			if ( "ADT_A08".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("NK1"); 
					retVal.add("PV1"); 
					retVal.add("DG1"); 
				}
			if ( "ADT_A09".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PV1"); 
					retVal.add("DG1"); 
				}
			if ( "ADT_A10".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PV1"); 
					retVal.add("DG1"); 
				}
			if ( "ADT_A11".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PV1"); 
					retVal.add("DG1"); 
				}
			if ( "ADT_A12".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PV1"); 
					retVal.add("DG1"); 
				}
			if ( "ADT_A13".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PV1"); 
					retVal.add("DG1"); 
				}
			if ( "ADT_A14".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PD1"); 
					retVal.add("NK1"); 
					retVal.add("PV1"); 
					retVal.add("DG1"); 
				}
			if ( "ADT_A15".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PV1"); 
					retVal.add("DG1"); 
				}
			if ( "ADT_A16".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PV1"); 
					retVal.add("DG1"); 
				}
			if ( "ADT_A17".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("EVN"); 
					retVal.add("PATIENT"); 
				}
			if ( "ADT_A18".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("MRG"); 
					retVal.add("PV1"); 
				}
			if ( "ADT_A20".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("EVN"); 
					retVal.add("NPU"); 
				}
			if ( "ADT_A21".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PV1"); 
				}
			if ( "ADT_A22".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PV1"); 
				}
			if ( "ADT_A23".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PV1"); 
				}
			if ( "ADT_A24".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PV1"); 
					retVal.add("PID2"); 
				}
			return retVal;
	}

    /** 
     * Returns "2.1"
     */
    public String getVersion() {
       return "2.1";
    }




    /**
     * <p>
     * Returns
     * MSH () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A18, ADT_A20, ADT_A21, ADT_A22, ADT_A23, ADT_A24]
     *
     */
    public MSH getMSH() { 
       return getTyped("MSH", MSH.class);
    }





    /**
     * <p>
     * Returns
     * EVN () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A18, ADT_A20, ADT_A21, ADT_A22, ADT_A23, ADT_A24]
     *
     */
    public EVN getEVN() { 
       return getTyped("EVN", EVN.class);
    }





    /**
     * <p>
     * Returns
     * PID () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A18, ADT_A21, ADT_A22, ADT_A23, ADT_A24]
     *
     */
    public PID getPID() { 
       return getTyped("PID", PID.class);
    }





    /**
     * <p>
     * Returns
     * MRG () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A18]
     *
     */
    public MRG getMRG() { 
       return getTyped("MRG", MRG.class);
    }





    /**
     * <p>
     * Returns
     * PD1 () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A14]
     *
     */
    public PD1 getPD1() { 
       return getTyped("PD1", PD1.class);
    }





    /**
     * <p>
     * Returns
     * NK1 () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A04, ADT_A05, ADT_A08, ADT_A14]
     *
     */
    public NK1 getNK1() { 
       return getTyped("NK1", NK1.class);
    }





    /**
     * <p>
     * Returns
     * PV1 () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A18, ADT_A21, ADT_A22, ADT_A23, ADT_A24]
     *
     */
    public PV1 getPV1() { 
       return getTyped("PV1", PV1.class);
    }





    /**
     * <p>
     * Returns
     * DG1 () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A04, ADT_A05, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16]
     *
     */
    public DG1 getDG1() { 
       return getTyped("DG1", DG1.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * PATIENT () - creates it if necessary
     * </p>
     * 
     *
     */
    public ADT_AXX_PATIENT getPATIENT() { 
       return getTyped("PATIENT", ADT_AXX_PATIENT.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * PATIENT () - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ADT_AXX_PATIENT getPATIENT(int rep) { 
       return getTyped("PATIENT", rep, ADT_AXX_PATIENT.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of PATIENT 
     * </p>
     * 
     */ 
    public int getPATIENTReps() { 
    	return getReps("PATIENT");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PATIENT.
     * <p>
     * <p>
     * Note that unlike {@link #getPATIENT()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<ADT_AXX_PATIENT> getPATIENTAll() throws HL7Exception {
    	return getAllAsList("PATIENT", ADT_AXX_PATIENT.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of PATIENT ()
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPATIENT(ADT_AXX_PATIENT structure, int rep) throws HL7Exception { 
       super.insertRepetition( "PATIENT", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of PATIENT ()
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ADT_AXX_PATIENT insertPATIENT(int rep) throws HL7Exception { 
       return (ADT_AXX_PATIENT)super.insertRepetition("PATIENT", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of PATIENT ()
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ADT_AXX_PATIENT removePATIENT(int rep) throws HL7Exception { 
       return (ADT_AXX_PATIENT)super.removeRepetition("PATIENT", rep);
    }




    /**
     * <p>
     * Returns
     * NPU () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A20]
     *
     */
    public NPU getNPU() { 
       return getTyped("NPU", NPU.class);
    }





    /**
     * <p>
     * Returns
     * PID2 () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A24]
     *
     */
    public PID getPID2() { 
       return getTyped("PID2", PID.class);
    }




}

