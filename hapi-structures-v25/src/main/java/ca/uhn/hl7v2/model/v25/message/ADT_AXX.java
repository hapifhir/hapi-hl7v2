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


package ca.uhn.hl7v2.model.v25.message;

import ca.uhn.hl7v2.model.v25.group.*;
import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.*;


/**
 * <p>Represents a ADT_AXX message structure (see chapter ). This structure contains the 
 * following elements: </p>
 * <ul>
		                 * <li>1: MSH () <b> </b> <ul><li>Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A18, ADT_A20, ADT_A21, ADT_A22, ADT_A23, ADT_A24, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A30, ADT_A31, ADT_A32, ADT_A33, ADT_A34, ADT_A35, ADT_A36, ADT_A37, ADT_A38, ADT_A39, ADT_A40, ADT_A41, ADT_A42, ADT_A43, ADT_A44, ADT_A45, ADT_A46, ADT_A47, ADT_A48, ADT_A49, ADT_A50, ADT_A51, ADT_A52, ADT_A53, ADT_A54, ADT_A55, ADT_A60, ADT_A61, ADT_A62]</li></ul></li>
		                 * <li>2: SFT () <b>optional repeating</b> <ul><li>Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A18, ADT_A20, ADT_A21, ADT_A22, ADT_A23, ADT_A24, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A30, ADT_A31, ADT_A32, ADT_A33, ADT_A34, ADT_A35, ADT_A36, ADT_A37, ADT_A38, ADT_A39, ADT_A40, ADT_A41, ADT_A42, ADT_A43, ADT_A44, ADT_A45, ADT_A46, ADT_A47, ADT_A48, ADT_A49, ADT_A50, ADT_A51, ADT_A52, ADT_A53, ADT_A54, ADT_A55, ADT_A60, ADT_A61, ADT_A62]</li></ul></li>
		                 * <li>3: EVN () <b> </b> <ul><li>Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A18, ADT_A20, ADT_A21, ADT_A22, ADT_A23, ADT_A24, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A30, ADT_A31, ADT_A32, ADT_A33, ADT_A34, ADT_A35, ADT_A36, ADT_A37, ADT_A38, ADT_A39, ADT_A40, ADT_A41, ADT_A42, ADT_A43, ADT_A44, ADT_A45, ADT_A46, ADT_A47, ADT_A48, ADT_A49, ADT_A50, ADT_A51, ADT_A52, ADT_A53, ADT_A54, ADT_A55, ADT_A60, ADT_A61, ADT_A62]</li></ul></li>
		                 * <li>4: PID () <b>optional </b> <ul><li>Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A18, ADT_A21, ADT_A22, ADT_A23, ADT_A24, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A30, ADT_A31, ADT_A32, ADT_A33, ADT_A34, ADT_A35, ADT_A36, ADT_A37, ADT_A38, ADT_A45, ADT_A46, ADT_A47, ADT_A48, ADT_A49, ADT_A50, ADT_A51, ADT_A52, ADT_A53, ADT_A54, ADT_A55, ADT_A60, ADT_A61, ADT_A62]</li></ul></li>
		                 * <li>5: PD1 () <b>optional </b> <ul><li>Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A18, ADT_A21, ADT_A22, ADT_A23, ADT_A24, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A30, ADT_A31, ADT_A32, ADT_A33, ADT_A34, ADT_A35, ADT_A36, ADT_A37, ADT_A38, ADT_A45, ADT_A46, ADT_A47, ADT_A48, ADT_A49, ADT_A50, ADT_A51, ADT_A52, ADT_A53, ADT_A54, ADT_A55, ADT_A61, ADT_A62]</li></ul></li>
		                 * <li>6: ROL () <b>optional repeating</b> <ul><li>Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A28, ADT_A31, ADT_A54, ADT_A61, ADT_A62]</li></ul></li>
		                 * <li>7: MRG () <b>optional </b> <ul><li>Used for the following structures: [ADT_A06, ADT_A07, ADT_A18, ADT_A30, ADT_A34, ADT_A35, ADT_A36, ADT_A46, ADT_A47, ADT_A48, ADT_A49, ADT_A50, ADT_A51]</li></ul></li>
		                 * <li>8: NK1 () <b>optional repeating</b> <ul><li>Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A16, ADT_A28, ADT_A31]</li></ul></li>
		                 * <li>9: PV1 () <b>optional </b> <ul><li>Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A18, ADT_A21, ADT_A22, ADT_A23, ADT_A24, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A31, ADT_A32, ADT_A33, ADT_A37, ADT_A38, ADT_A50, ADT_A51, ADT_A52, ADT_A53, ADT_A54, ADT_A55, ADT_A60, ADT_A61, ADT_A62]</li></ul></li>
		                 * <li>10: PV2 () <b>optional </b> <ul><li>Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A21, ADT_A22, ADT_A23, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A31, ADT_A32, ADT_A33, ADT_A38, ADT_A52, ADT_A53, ADT_A54, ADT_A55, ADT_A60, ADT_A61, ADT_A62]</li></ul></li>
		                 * <li>11: ROL () <b>optional repeating</b> <ul><li>Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A28, ADT_A31, ADT_A54]</li></ul></li>
		                 * <li>12: DB1 () <b>optional repeating</b> <ul><li>Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A21, ADT_A22, ADT_A23, ADT_A24, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A31, ADT_A32, ADT_A33, ADT_A37, ADT_A38]</li></ul></li>
		                 * <li>13: OBX () <b>optional repeating</b> <ul><li>Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A21, ADT_A22, ADT_A23, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A31, ADT_A32, ADT_A33, ADT_A38]</li></ul></li>
		                 * <li>14: AL1 () <b>optional repeating</b> <ul><li>Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A16, ADT_A28, ADT_A31]</li></ul></li>
		                 * <li>15: DG1 () <b>optional repeating</b> <ul><li>Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A28, ADT_A31, ADT_A38]</li></ul></li>
		                 * <li>16: DRG () <b>optional </b> <ul><li>Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A16, ADT_A28, ADT_A31, ADT_A38]</li></ul></li>
		                 * <li>17: ADT_AXX_PROCEDURE () <b>optional repeating</b> <ul><li>Used for the following structures: [ADT_A08, ADT_A04, ADT_A13, ADT_A14, ADT_A28, ADT_A31, ADT_A07]</li></ul></li>
		                 * <li>18: GT1 () <b>optional repeating</b> <ul><li>Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A16, ADT_A28, ADT_A31]</li></ul></li>
		                 * <li>19: ADT_AXX_INSURANCE () <b>optional repeating</b> <ul><li>Used for the following structures: [ADT_A08, ADT_A04, ADT_A13, ADT_A14, ADT_A28, ADT_A31, ADT_A07]</li></ul></li>
		                 * <li>20: ACC () <b>optional </b> <ul><li>Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A16, ADT_A28, ADT_A31]</li></ul></li>
		                 * <li>21: UB1 () <b>optional </b> <ul><li>Used for the following structures: [ADT_A01, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A28, ADT_A31]</li></ul></li>
		                 * <li>22: UB2 () <b>optional </b> <ul><li>Used for the following structures: [ADT_A01, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A28, ADT_A31]</li></ul></li>
		                 * <li>23: PDA () <b>optional </b> <ul><li>Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A08, ADT_A13]</li></ul></li>
		                 * <li>24: PID () <b>optional </b> <ul><li>Used for the following structures: [ADT_A17, ADT_A24, ADT_A37]</li></ul></li>
		                 * <li>25: PD1 () <b>optional </b> <ul><li>Used for the following structures: [ADT_A17, ADT_A24, ADT_A37]</li></ul></li>
		                 * <li>26: PV1 () <b>optional </b> <ul><li>Used for the following structures: [ADT_A17, ADT_A24, ADT_A37]</li></ul></li>
		                 * <li>27: PV2 () <b>optional </b> <ul><li>Used for the following structures: [ADT_A17]</li></ul></li>
		                 * <li>28: DB1 () <b>optional repeating</b> <ul><li>Used for the following structures: [ADT_A17, ADT_A24, ADT_A37]</li></ul></li>
		                 * <li>29: OBX () <b>optional repeating</b> <ul><li>Used for the following structures: [ADT_A17]</li></ul></li>
		                 * <li>30: NPU () <b>optional </b> <ul><li>Used for the following structures: [ADT_A20]</li></ul></li>
		                 * <li>31: ADT_AXX_PATIENT () <b>optional repeating</b> <ul><li>Used for the following structures: [ADT_A40, ADT_A41, ADT_A42, ADT_A44]</li></ul></li>
		                 * <li>32: ADT_AXX_MERGE_INFO () <b>optional repeating</b> </li>
		                 * <li>33: IAM () <b>optional repeating</b> <ul><li>Used for the following structures: [ADT_A60]</li></ul></li>
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
	          this.addSuperstructureApplication("MSH", "ADT_A25"); 
	          this.addSuperstructureApplication("MSH", "ADT_A26"); 
	          this.addSuperstructureApplication("MSH", "ADT_A27"); 
	          this.addSuperstructureApplication("MSH", "ADT_A28"); 
	          this.addSuperstructureApplication("MSH", "ADT_A29"); 
	          this.addSuperstructureApplication("MSH", "ADT_A30"); 
	          this.addSuperstructureApplication("MSH", "ADT_A31"); 
	          this.addSuperstructureApplication("MSH", "ADT_A32"); 
	          this.addSuperstructureApplication("MSH", "ADT_A33"); 
	          this.addSuperstructureApplication("MSH", "ADT_A34"); 
	          this.addSuperstructureApplication("MSH", "ADT_A35"); 
	          this.addSuperstructureApplication("MSH", "ADT_A36"); 
	          this.addSuperstructureApplication("MSH", "ADT_A37"); 
	          this.addSuperstructureApplication("MSH", "ADT_A38"); 
	          this.addSuperstructureApplication("MSH", "ADT_A39"); 
	          this.addSuperstructureApplication("MSH", "ADT_A40"); 
	          this.addSuperstructureApplication("MSH", "ADT_A41"); 
	          this.addSuperstructureApplication("MSH", "ADT_A42"); 
	          this.addSuperstructureApplication("MSH", "ADT_A43"); 
	          this.addSuperstructureApplication("MSH", "ADT_A44"); 
	          this.addSuperstructureApplication("MSH", "ADT_A45"); 
	          this.addSuperstructureApplication("MSH", "ADT_A46"); 
	          this.addSuperstructureApplication("MSH", "ADT_A47"); 
	          this.addSuperstructureApplication("MSH", "ADT_A48"); 
	          this.addSuperstructureApplication("MSH", "ADT_A49"); 
	          this.addSuperstructureApplication("MSH", "ADT_A50"); 
	          this.addSuperstructureApplication("MSH", "ADT_A51"); 
	          this.addSuperstructureApplication("MSH", "ADT_A52"); 
	          this.addSuperstructureApplication("MSH", "ADT_A53"); 
	          this.addSuperstructureApplication("MSH", "ADT_A54"); 
	          this.addSuperstructureApplication("MSH", "ADT_A55"); 
	          this.addSuperstructureApplication("MSH", "ADT_A60"); 
	          this.addSuperstructureApplication("MSH", "ADT_A61"); 
	          this.addSuperstructureApplication("MSH", "ADT_A62"); 
	                          this.add(SFT.class, false, true);
	          this.addSuperstructureApplication("SFT", "ADT_A01"); 
	          this.addSuperstructureApplication("SFT", "ADT_A02"); 
	          this.addSuperstructureApplication("SFT", "ADT_A03"); 
	          this.addSuperstructureApplication("SFT", "ADT_A04"); 
	          this.addSuperstructureApplication("SFT", "ADT_A05"); 
	          this.addSuperstructureApplication("SFT", "ADT_A06"); 
	          this.addSuperstructureApplication("SFT", "ADT_A07"); 
	          this.addSuperstructureApplication("SFT", "ADT_A08"); 
	          this.addSuperstructureApplication("SFT", "ADT_A09"); 
	          this.addSuperstructureApplication("SFT", "ADT_A10"); 
	          this.addSuperstructureApplication("SFT", "ADT_A11"); 
	          this.addSuperstructureApplication("SFT", "ADT_A12"); 
	          this.addSuperstructureApplication("SFT", "ADT_A13"); 
	          this.addSuperstructureApplication("SFT", "ADT_A14"); 
	          this.addSuperstructureApplication("SFT", "ADT_A15"); 
	          this.addSuperstructureApplication("SFT", "ADT_A16"); 
	          this.addSuperstructureApplication("SFT", "ADT_A17"); 
	          this.addSuperstructureApplication("SFT", "ADT_A18"); 
	          this.addSuperstructureApplication("SFT", "ADT_A20"); 
	          this.addSuperstructureApplication("SFT", "ADT_A21"); 
	          this.addSuperstructureApplication("SFT", "ADT_A22"); 
	          this.addSuperstructureApplication("SFT", "ADT_A23"); 
	          this.addSuperstructureApplication("SFT", "ADT_A24"); 
	          this.addSuperstructureApplication("SFT", "ADT_A25"); 
	          this.addSuperstructureApplication("SFT", "ADT_A26"); 
	          this.addSuperstructureApplication("SFT", "ADT_A27"); 
	          this.addSuperstructureApplication("SFT", "ADT_A28"); 
	          this.addSuperstructureApplication("SFT", "ADT_A29"); 
	          this.addSuperstructureApplication("SFT", "ADT_A30"); 
	          this.addSuperstructureApplication("SFT", "ADT_A31"); 
	          this.addSuperstructureApplication("SFT", "ADT_A32"); 
	          this.addSuperstructureApplication("SFT", "ADT_A33"); 
	          this.addSuperstructureApplication("SFT", "ADT_A34"); 
	          this.addSuperstructureApplication("SFT", "ADT_A35"); 
	          this.addSuperstructureApplication("SFT", "ADT_A36"); 
	          this.addSuperstructureApplication("SFT", "ADT_A37"); 
	          this.addSuperstructureApplication("SFT", "ADT_A38"); 
	          this.addSuperstructureApplication("SFT", "ADT_A39"); 
	          this.addSuperstructureApplication("SFT", "ADT_A40"); 
	          this.addSuperstructureApplication("SFT", "ADT_A41"); 
	          this.addSuperstructureApplication("SFT", "ADT_A42"); 
	          this.addSuperstructureApplication("SFT", "ADT_A43"); 
	          this.addSuperstructureApplication("SFT", "ADT_A44"); 
	          this.addSuperstructureApplication("SFT", "ADT_A45"); 
	          this.addSuperstructureApplication("SFT", "ADT_A46"); 
	          this.addSuperstructureApplication("SFT", "ADT_A47"); 
	          this.addSuperstructureApplication("SFT", "ADT_A48"); 
	          this.addSuperstructureApplication("SFT", "ADT_A49"); 
	          this.addSuperstructureApplication("SFT", "ADT_A50"); 
	          this.addSuperstructureApplication("SFT", "ADT_A51"); 
	          this.addSuperstructureApplication("SFT", "ADT_A52"); 
	          this.addSuperstructureApplication("SFT", "ADT_A53"); 
	          this.addSuperstructureApplication("SFT", "ADT_A54"); 
	          this.addSuperstructureApplication("SFT", "ADT_A55"); 
	          this.addSuperstructureApplication("SFT", "ADT_A60"); 
	          this.addSuperstructureApplication("SFT", "ADT_A61"); 
	          this.addSuperstructureApplication("SFT", "ADT_A62"); 
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
	          this.addSuperstructureApplication("EVN", "ADT_A25"); 
	          this.addSuperstructureApplication("EVN", "ADT_A26"); 
	          this.addSuperstructureApplication("EVN", "ADT_A27"); 
	          this.addSuperstructureApplication("EVN", "ADT_A28"); 
	          this.addSuperstructureApplication("EVN", "ADT_A29"); 
	          this.addSuperstructureApplication("EVN", "ADT_A30"); 
	          this.addSuperstructureApplication("EVN", "ADT_A31"); 
	          this.addSuperstructureApplication("EVN", "ADT_A32"); 
	          this.addSuperstructureApplication("EVN", "ADT_A33"); 
	          this.addSuperstructureApplication("EVN", "ADT_A34"); 
	          this.addSuperstructureApplication("EVN", "ADT_A35"); 
	          this.addSuperstructureApplication("EVN", "ADT_A36"); 
	          this.addSuperstructureApplication("EVN", "ADT_A37"); 
	          this.addSuperstructureApplication("EVN", "ADT_A38"); 
	          this.addSuperstructureApplication("EVN", "ADT_A39"); 
	          this.addSuperstructureApplication("EVN", "ADT_A40"); 
	          this.addSuperstructureApplication("EVN", "ADT_A41"); 
	          this.addSuperstructureApplication("EVN", "ADT_A42"); 
	          this.addSuperstructureApplication("EVN", "ADT_A43"); 
	          this.addSuperstructureApplication("EVN", "ADT_A44"); 
	          this.addSuperstructureApplication("EVN", "ADT_A45"); 
	          this.addSuperstructureApplication("EVN", "ADT_A46"); 
	          this.addSuperstructureApplication("EVN", "ADT_A47"); 
	          this.addSuperstructureApplication("EVN", "ADT_A48"); 
	          this.addSuperstructureApplication("EVN", "ADT_A49"); 
	          this.addSuperstructureApplication("EVN", "ADT_A50"); 
	          this.addSuperstructureApplication("EVN", "ADT_A51"); 
	          this.addSuperstructureApplication("EVN", "ADT_A52"); 
	          this.addSuperstructureApplication("EVN", "ADT_A53"); 
	          this.addSuperstructureApplication("EVN", "ADT_A54"); 
	          this.addSuperstructureApplication("EVN", "ADT_A55"); 
	          this.addSuperstructureApplication("EVN", "ADT_A60"); 
	          this.addSuperstructureApplication("EVN", "ADT_A61"); 
	          this.addSuperstructureApplication("EVN", "ADT_A62"); 
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
	          this.addSuperstructureApplication("PID", "ADT_A17"); 
	          this.addSuperstructureApplication("PID", "ADT_A18"); 
	          this.addSuperstructureApplication("PID", "ADT_A21"); 
	          this.addSuperstructureApplication("PID", "ADT_A22"); 
	          this.addSuperstructureApplication("PID", "ADT_A23"); 
	          this.addSuperstructureApplication("PID", "ADT_A24"); 
	          this.addSuperstructureApplication("PID", "ADT_A25"); 
	          this.addSuperstructureApplication("PID", "ADT_A26"); 
	          this.addSuperstructureApplication("PID", "ADT_A27"); 
	          this.addSuperstructureApplication("PID", "ADT_A28"); 
	          this.addSuperstructureApplication("PID", "ADT_A29"); 
	          this.addSuperstructureApplication("PID", "ADT_A30"); 
	          this.addSuperstructureApplication("PID", "ADT_A31"); 
	          this.addSuperstructureApplication("PID", "ADT_A32"); 
	          this.addSuperstructureApplication("PID", "ADT_A33"); 
	          this.addSuperstructureApplication("PID", "ADT_A34"); 
	          this.addSuperstructureApplication("PID", "ADT_A35"); 
	          this.addSuperstructureApplication("PID", "ADT_A36"); 
	          this.addSuperstructureApplication("PID", "ADT_A37"); 
	          this.addSuperstructureApplication("PID", "ADT_A38"); 
	          this.addSuperstructureApplication("PID", "ADT_A45"); 
	          this.addSuperstructureApplication("PID", "ADT_A46"); 
	          this.addSuperstructureApplication("PID", "ADT_A47"); 
	          this.addSuperstructureApplication("PID", "ADT_A48"); 
	          this.addSuperstructureApplication("PID", "ADT_A49"); 
	          this.addSuperstructureApplication("PID", "ADT_A50"); 
	          this.addSuperstructureApplication("PID", "ADT_A51"); 
	          this.addSuperstructureApplication("PID", "ADT_A52"); 
	          this.addSuperstructureApplication("PID", "ADT_A53"); 
	          this.addSuperstructureApplication("PID", "ADT_A54"); 
	          this.addSuperstructureApplication("PID", "ADT_A55"); 
	          this.addSuperstructureApplication("PID", "ADT_A60"); 
	          this.addSuperstructureApplication("PID", "ADT_A61"); 
	          this.addSuperstructureApplication("PID", "ADT_A62"); 
	                          this.add(PD1.class, false, false);
	          this.addSuperstructureApplication("PD1", "ADT_A01"); 
	          this.addSuperstructureApplication("PD1", "ADT_A02"); 
	          this.addSuperstructureApplication("PD1", "ADT_A03"); 
	          this.addSuperstructureApplication("PD1", "ADT_A04"); 
	          this.addSuperstructureApplication("PD1", "ADT_A05"); 
	          this.addSuperstructureApplication("PD1", "ADT_A06"); 
	          this.addSuperstructureApplication("PD1", "ADT_A07"); 
	          this.addSuperstructureApplication("PD1", "ADT_A08"); 
	          this.addSuperstructureApplication("PD1", "ADT_A09"); 
	          this.addSuperstructureApplication("PD1", "ADT_A10"); 
	          this.addSuperstructureApplication("PD1", "ADT_A11"); 
	          this.addSuperstructureApplication("PD1", "ADT_A12"); 
	          this.addSuperstructureApplication("PD1", "ADT_A13"); 
	          this.addSuperstructureApplication("PD1", "ADT_A14"); 
	          this.addSuperstructureApplication("PD1", "ADT_A15"); 
	          this.addSuperstructureApplication("PD1", "ADT_A16"); 
	          this.addSuperstructureApplication("PD1", "ADT_A17"); 
	          this.addSuperstructureApplication("PD1", "ADT_A18"); 
	          this.addSuperstructureApplication("PD1", "ADT_A21"); 
	          this.addSuperstructureApplication("PD1", "ADT_A22"); 
	          this.addSuperstructureApplication("PD1", "ADT_A23"); 
	          this.addSuperstructureApplication("PD1", "ADT_A24"); 
	          this.addSuperstructureApplication("PD1", "ADT_A25"); 
	          this.addSuperstructureApplication("PD1", "ADT_A26"); 
	          this.addSuperstructureApplication("PD1", "ADT_A27"); 
	          this.addSuperstructureApplication("PD1", "ADT_A28"); 
	          this.addSuperstructureApplication("PD1", "ADT_A29"); 
	          this.addSuperstructureApplication("PD1", "ADT_A30"); 
	          this.addSuperstructureApplication("PD1", "ADT_A31"); 
	          this.addSuperstructureApplication("PD1", "ADT_A32"); 
	          this.addSuperstructureApplication("PD1", "ADT_A33"); 
	          this.addSuperstructureApplication("PD1", "ADT_A34"); 
	          this.addSuperstructureApplication("PD1", "ADT_A35"); 
	          this.addSuperstructureApplication("PD1", "ADT_A36"); 
	          this.addSuperstructureApplication("PD1", "ADT_A37"); 
	          this.addSuperstructureApplication("PD1", "ADT_A38"); 
	          this.addSuperstructureApplication("PD1", "ADT_A45"); 
	          this.addSuperstructureApplication("PD1", "ADT_A46"); 
	          this.addSuperstructureApplication("PD1", "ADT_A47"); 
	          this.addSuperstructureApplication("PD1", "ADT_A48"); 
	          this.addSuperstructureApplication("PD1", "ADT_A49"); 
	          this.addSuperstructureApplication("PD1", "ADT_A50"); 
	          this.addSuperstructureApplication("PD1", "ADT_A51"); 
	          this.addSuperstructureApplication("PD1", "ADT_A52"); 
	          this.addSuperstructureApplication("PD1", "ADT_A53"); 
	          this.addSuperstructureApplication("PD1", "ADT_A54"); 
	          this.addSuperstructureApplication("PD1", "ADT_A55"); 
	          this.addSuperstructureApplication("PD1", "ADT_A61"); 
	          this.addSuperstructureApplication("PD1", "ADT_A62"); 
	                          this.add(ROL.class, false, true);
	          this.addSuperstructureApplication("ROL", "ADT_A01"); 
	          this.addSuperstructureApplication("ROL", "ADT_A02"); 
	          this.addSuperstructureApplication("ROL", "ADT_A03"); 
	          this.addSuperstructureApplication("ROL", "ADT_A04"); 
	          this.addSuperstructureApplication("ROL", "ADT_A05"); 
	          this.addSuperstructureApplication("ROL", "ADT_A06"); 
	          this.addSuperstructureApplication("ROL", "ADT_A07"); 
	          this.addSuperstructureApplication("ROL", "ADT_A08"); 
	          this.addSuperstructureApplication("ROL", "ADT_A13"); 
	          this.addSuperstructureApplication("ROL", "ADT_A14"); 
	          this.addSuperstructureApplication("ROL", "ADT_A15"); 
	          this.addSuperstructureApplication("ROL", "ADT_A16"); 
	          this.addSuperstructureApplication("ROL", "ADT_A28"); 
	          this.addSuperstructureApplication("ROL", "ADT_A31"); 
	          this.addSuperstructureApplication("ROL", "ADT_A54"); 
	          this.addSuperstructureApplication("ROL", "ADT_A61"); 
	          this.addSuperstructureApplication("ROL", "ADT_A62"); 
	                          this.add(MRG.class, false, false);
	          this.addSuperstructureApplication("MRG", "ADT_A06"); 
	          this.addSuperstructureApplication("MRG", "ADT_A07"); 
	          this.addSuperstructureApplication("MRG", "ADT_A18"); 
	          this.addSuperstructureApplication("MRG", "ADT_A30"); 
	          this.addSuperstructureApplication("MRG", "ADT_A34"); 
	          this.addSuperstructureApplication("MRG", "ADT_A35"); 
	          this.addSuperstructureApplication("MRG", "ADT_A36"); 
	          this.addSuperstructureApplication("MRG", "ADT_A46"); 
	          this.addSuperstructureApplication("MRG", "ADT_A47"); 
	          this.addSuperstructureApplication("MRG", "ADT_A48"); 
	          this.addSuperstructureApplication("MRG", "ADT_A49"); 
	          this.addSuperstructureApplication("MRG", "ADT_A50"); 
	          this.addSuperstructureApplication("MRG", "ADT_A51"); 
	                          this.add(NK1.class, false, true);
	          this.addSuperstructureApplication("NK1", "ADT_A01"); 
	          this.addSuperstructureApplication("NK1", "ADT_A03"); 
	          this.addSuperstructureApplication("NK1", "ADT_A04"); 
	          this.addSuperstructureApplication("NK1", "ADT_A05"); 
	          this.addSuperstructureApplication("NK1", "ADT_A06"); 
	          this.addSuperstructureApplication("NK1", "ADT_A07"); 
	          this.addSuperstructureApplication("NK1", "ADT_A08"); 
	          this.addSuperstructureApplication("NK1", "ADT_A13"); 
	          this.addSuperstructureApplication("NK1", "ADT_A14"); 
	          this.addSuperstructureApplication("NK1", "ADT_A16"); 
	          this.addSuperstructureApplication("NK1", "ADT_A28"); 
	          this.addSuperstructureApplication("NK1", "ADT_A31"); 
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
	          this.addSuperstructureApplication("PV1", "ADT_A17"); 
	          this.addSuperstructureApplication("PV1", "ADT_A18"); 
	          this.addSuperstructureApplication("PV1", "ADT_A21"); 
	          this.addSuperstructureApplication("PV1", "ADT_A22"); 
	          this.addSuperstructureApplication("PV1", "ADT_A23"); 
	          this.addSuperstructureApplication("PV1", "ADT_A24"); 
	          this.addSuperstructureApplication("PV1", "ADT_A25"); 
	          this.addSuperstructureApplication("PV1", "ADT_A26"); 
	          this.addSuperstructureApplication("PV1", "ADT_A27"); 
	          this.addSuperstructureApplication("PV1", "ADT_A28"); 
	          this.addSuperstructureApplication("PV1", "ADT_A29"); 
	          this.addSuperstructureApplication("PV1", "ADT_A31"); 
	          this.addSuperstructureApplication("PV1", "ADT_A32"); 
	          this.addSuperstructureApplication("PV1", "ADT_A33"); 
	          this.addSuperstructureApplication("PV1", "ADT_A37"); 
	          this.addSuperstructureApplication("PV1", "ADT_A38"); 
	          this.addSuperstructureApplication("PV1", "ADT_A50"); 
	          this.addSuperstructureApplication("PV1", "ADT_A51"); 
	          this.addSuperstructureApplication("PV1", "ADT_A52"); 
	          this.addSuperstructureApplication("PV1", "ADT_A53"); 
	          this.addSuperstructureApplication("PV1", "ADT_A54"); 
	          this.addSuperstructureApplication("PV1", "ADT_A55"); 
	          this.addSuperstructureApplication("PV1", "ADT_A60"); 
	          this.addSuperstructureApplication("PV1", "ADT_A61"); 
	          this.addSuperstructureApplication("PV1", "ADT_A62"); 
	                          this.add(PV2.class, false, false);
	          this.addSuperstructureApplication("PV2", "ADT_A01"); 
	          this.addSuperstructureApplication("PV2", "ADT_A02"); 
	          this.addSuperstructureApplication("PV2", "ADT_A03"); 
	          this.addSuperstructureApplication("PV2", "ADT_A04"); 
	          this.addSuperstructureApplication("PV2", "ADT_A05"); 
	          this.addSuperstructureApplication("PV2", "ADT_A06"); 
	          this.addSuperstructureApplication("PV2", "ADT_A07"); 
	          this.addSuperstructureApplication("PV2", "ADT_A08"); 
	          this.addSuperstructureApplication("PV2", "ADT_A09"); 
	          this.addSuperstructureApplication("PV2", "ADT_A10"); 
	          this.addSuperstructureApplication("PV2", "ADT_A11"); 
	          this.addSuperstructureApplication("PV2", "ADT_A12"); 
	          this.addSuperstructureApplication("PV2", "ADT_A13"); 
	          this.addSuperstructureApplication("PV2", "ADT_A14"); 
	          this.addSuperstructureApplication("PV2", "ADT_A15"); 
	          this.addSuperstructureApplication("PV2", "ADT_A16"); 
	          this.addSuperstructureApplication("PV2", "ADT_A17"); 
	          this.addSuperstructureApplication("PV2", "ADT_A21"); 
	          this.addSuperstructureApplication("PV2", "ADT_A22"); 
	          this.addSuperstructureApplication("PV2", "ADT_A23"); 
	          this.addSuperstructureApplication("PV2", "ADT_A25"); 
	          this.addSuperstructureApplication("PV2", "ADT_A26"); 
	          this.addSuperstructureApplication("PV2", "ADT_A27"); 
	          this.addSuperstructureApplication("PV2", "ADT_A28"); 
	          this.addSuperstructureApplication("PV2", "ADT_A29"); 
	          this.addSuperstructureApplication("PV2", "ADT_A31"); 
	          this.addSuperstructureApplication("PV2", "ADT_A32"); 
	          this.addSuperstructureApplication("PV2", "ADT_A33"); 
	          this.addSuperstructureApplication("PV2", "ADT_A38"); 
	          this.addSuperstructureApplication("PV2", "ADT_A52"); 
	          this.addSuperstructureApplication("PV2", "ADT_A53"); 
	          this.addSuperstructureApplication("PV2", "ADT_A54"); 
	          this.addSuperstructureApplication("PV2", "ADT_A55"); 
	          this.addSuperstructureApplication("PV2", "ADT_A60"); 
	          this.addSuperstructureApplication("PV2", "ADT_A61"); 
	          this.addSuperstructureApplication("PV2", "ADT_A62"); 
	                          this.add(ROL.class, false, true);
	          this.addSuperstructureApplication("ROL2", "ADT_A01"); 
	          this.addSuperstructureApplication("ROL2", "ADT_A02"); 
	          this.addSuperstructureApplication("ROL2", "ADT_A03"); 
	          this.addSuperstructureApplication("ROL2", "ADT_A04"); 
	          this.addSuperstructureApplication("ROL2", "ADT_A05"); 
	          this.addSuperstructureApplication("ROL2", "ADT_A06"); 
	          this.addSuperstructureApplication("ROL2", "ADT_A07"); 
	          this.addSuperstructureApplication("ROL2", "ADT_A08"); 
	          this.addSuperstructureApplication("ROL2", "ADT_A13"); 
	          this.addSuperstructureApplication("ROL2", "ADT_A14"); 
	          this.addSuperstructureApplication("ROL2", "ADT_A15"); 
	          this.addSuperstructureApplication("ROL2", "ADT_A16"); 
	          this.addSuperstructureApplication("ROL2", "ADT_A28"); 
	          this.addSuperstructureApplication("ROL2", "ADT_A31"); 
	          this.addSuperstructureApplication("ROL2", "ADT_A54"); 
	                          this.add(DB1.class, false, true);
	          this.addSuperstructureApplication("DB1", "ADT_A01"); 
	          this.addSuperstructureApplication("DB1", "ADT_A02"); 
	          this.addSuperstructureApplication("DB1", "ADT_A03"); 
	          this.addSuperstructureApplication("DB1", "ADT_A04"); 
	          this.addSuperstructureApplication("DB1", "ADT_A05"); 
	          this.addSuperstructureApplication("DB1", "ADT_A06"); 
	          this.addSuperstructureApplication("DB1", "ADT_A07"); 
	          this.addSuperstructureApplication("DB1", "ADT_A08"); 
	          this.addSuperstructureApplication("DB1", "ADT_A09"); 
	          this.addSuperstructureApplication("DB1", "ADT_A10"); 
	          this.addSuperstructureApplication("DB1", "ADT_A11"); 
	          this.addSuperstructureApplication("DB1", "ADT_A12"); 
	          this.addSuperstructureApplication("DB1", "ADT_A13"); 
	          this.addSuperstructureApplication("DB1", "ADT_A14"); 
	          this.addSuperstructureApplication("DB1", "ADT_A15"); 
	          this.addSuperstructureApplication("DB1", "ADT_A16"); 
	          this.addSuperstructureApplication("DB1", "ADT_A17"); 
	          this.addSuperstructureApplication("DB1", "ADT_A21"); 
	          this.addSuperstructureApplication("DB1", "ADT_A22"); 
	          this.addSuperstructureApplication("DB1", "ADT_A23"); 
	          this.addSuperstructureApplication("DB1", "ADT_A24"); 
	          this.addSuperstructureApplication("DB1", "ADT_A25"); 
	          this.addSuperstructureApplication("DB1", "ADT_A26"); 
	          this.addSuperstructureApplication("DB1", "ADT_A27"); 
	          this.addSuperstructureApplication("DB1", "ADT_A28"); 
	          this.addSuperstructureApplication("DB1", "ADT_A29"); 
	          this.addSuperstructureApplication("DB1", "ADT_A31"); 
	          this.addSuperstructureApplication("DB1", "ADT_A32"); 
	          this.addSuperstructureApplication("DB1", "ADT_A33"); 
	          this.addSuperstructureApplication("DB1", "ADT_A37"); 
	          this.addSuperstructureApplication("DB1", "ADT_A38"); 
	                          this.add(OBX.class, false, true);
	          this.addSuperstructureApplication("OBX", "ADT_A01"); 
	          this.addSuperstructureApplication("OBX", "ADT_A02"); 
	          this.addSuperstructureApplication("OBX", "ADT_A03"); 
	          this.addSuperstructureApplication("OBX", "ADT_A04"); 
	          this.addSuperstructureApplication("OBX", "ADT_A05"); 
	          this.addSuperstructureApplication("OBX", "ADT_A06"); 
	          this.addSuperstructureApplication("OBX", "ADT_A07"); 
	          this.addSuperstructureApplication("OBX", "ADT_A08"); 
	          this.addSuperstructureApplication("OBX", "ADT_A09"); 
	          this.addSuperstructureApplication("OBX", "ADT_A10"); 
	          this.addSuperstructureApplication("OBX", "ADT_A11"); 
	          this.addSuperstructureApplication("OBX", "ADT_A12"); 
	          this.addSuperstructureApplication("OBX", "ADT_A13"); 
	          this.addSuperstructureApplication("OBX", "ADT_A14"); 
	          this.addSuperstructureApplication("OBX", "ADT_A15"); 
	          this.addSuperstructureApplication("OBX", "ADT_A16"); 
	          this.addSuperstructureApplication("OBX", "ADT_A17"); 
	          this.addSuperstructureApplication("OBX", "ADT_A21"); 
	          this.addSuperstructureApplication("OBX", "ADT_A22"); 
	          this.addSuperstructureApplication("OBX", "ADT_A23"); 
	          this.addSuperstructureApplication("OBX", "ADT_A25"); 
	          this.addSuperstructureApplication("OBX", "ADT_A26"); 
	          this.addSuperstructureApplication("OBX", "ADT_A27"); 
	          this.addSuperstructureApplication("OBX", "ADT_A28"); 
	          this.addSuperstructureApplication("OBX", "ADT_A29"); 
	          this.addSuperstructureApplication("OBX", "ADT_A31"); 
	          this.addSuperstructureApplication("OBX", "ADT_A32"); 
	          this.addSuperstructureApplication("OBX", "ADT_A33"); 
	          this.addSuperstructureApplication("OBX", "ADT_A38"); 
	                          this.add(AL1.class, false, true);
	          this.addSuperstructureApplication("AL1", "ADT_A01"); 
	          this.addSuperstructureApplication("AL1", "ADT_A03"); 
	          this.addSuperstructureApplication("AL1", "ADT_A04"); 
	          this.addSuperstructureApplication("AL1", "ADT_A05"); 
	          this.addSuperstructureApplication("AL1", "ADT_A06"); 
	          this.addSuperstructureApplication("AL1", "ADT_A07"); 
	          this.addSuperstructureApplication("AL1", "ADT_A08"); 
	          this.addSuperstructureApplication("AL1", "ADT_A13"); 
	          this.addSuperstructureApplication("AL1", "ADT_A14"); 
	          this.addSuperstructureApplication("AL1", "ADT_A16"); 
	          this.addSuperstructureApplication("AL1", "ADT_A28"); 
	          this.addSuperstructureApplication("AL1", "ADT_A31"); 
	                          this.add(DG1.class, false, true);
	          this.addSuperstructureApplication("DG1", "ADT_A01"); 
	          this.addSuperstructureApplication("DG1", "ADT_A03"); 
	          this.addSuperstructureApplication("DG1", "ADT_A04"); 
	          this.addSuperstructureApplication("DG1", "ADT_A05"); 
	          this.addSuperstructureApplication("DG1", "ADT_A06"); 
	          this.addSuperstructureApplication("DG1", "ADT_A07"); 
	          this.addSuperstructureApplication("DG1", "ADT_A08"); 
	          this.addSuperstructureApplication("DG1", "ADT_A09"); 
	          this.addSuperstructureApplication("DG1", "ADT_A10"); 
	          this.addSuperstructureApplication("DG1", "ADT_A11"); 
	          this.addSuperstructureApplication("DG1", "ADT_A12"); 
	          this.addSuperstructureApplication("DG1", "ADT_A13"); 
	          this.addSuperstructureApplication("DG1", "ADT_A14"); 
	          this.addSuperstructureApplication("DG1", "ADT_A15"); 
	          this.addSuperstructureApplication("DG1", "ADT_A16"); 
	          this.addSuperstructureApplication("DG1", "ADT_A28"); 
	          this.addSuperstructureApplication("DG1", "ADT_A31"); 
	          this.addSuperstructureApplication("DG1", "ADT_A38"); 
	                          this.add(DRG.class, false, false);
	          this.addSuperstructureApplication("DRG", "ADT_A01"); 
	          this.addSuperstructureApplication("DRG", "ADT_A03"); 
	          this.addSuperstructureApplication("DRG", "ADT_A04"); 
	          this.addSuperstructureApplication("DRG", "ADT_A05"); 
	          this.addSuperstructureApplication("DRG", "ADT_A06"); 
	          this.addSuperstructureApplication("DRG", "ADT_A07"); 
	          this.addSuperstructureApplication("DRG", "ADT_A08"); 
	          this.addSuperstructureApplication("DRG", "ADT_A13"); 
	          this.addSuperstructureApplication("DRG", "ADT_A14"); 
	          this.addSuperstructureApplication("DRG", "ADT_A16"); 
	          this.addSuperstructureApplication("DRG", "ADT_A28"); 
	          this.addSuperstructureApplication("DRG", "ADT_A31"); 
	          this.addSuperstructureApplication("DRG", "ADT_A38"); 
	                          this.add(ADT_AXX_PROCEDURE.class, false, true);
	          this.addSuperstructureApplication("PROCEDURE", "ADT_A08"); 
	          this.addSuperstructureApplication("PROCEDURE", "ADT_A04"); 
	          this.addSuperstructureApplication("PROCEDURE", "ADT_A13"); 
	          this.addSuperstructureApplication("PROCEDURE", "ADT_A14"); 
	          this.addSuperstructureApplication("PROCEDURE", "ADT_A28"); 
	          this.addSuperstructureApplication("PROCEDURE", "ADT_A31"); 
	          this.addSuperstructureApplication("PROCEDURE", "ADT_A07"); 
	                          this.add(GT1.class, false, true);
	          this.addSuperstructureApplication("GT1", "ADT_A01"); 
	          this.addSuperstructureApplication("GT1", "ADT_A03"); 
	          this.addSuperstructureApplication("GT1", "ADT_A04"); 
	          this.addSuperstructureApplication("GT1", "ADT_A05"); 
	          this.addSuperstructureApplication("GT1", "ADT_A06"); 
	          this.addSuperstructureApplication("GT1", "ADT_A07"); 
	          this.addSuperstructureApplication("GT1", "ADT_A08"); 
	          this.addSuperstructureApplication("GT1", "ADT_A13"); 
	          this.addSuperstructureApplication("GT1", "ADT_A14"); 
	          this.addSuperstructureApplication("GT1", "ADT_A16"); 
	          this.addSuperstructureApplication("GT1", "ADT_A28"); 
	          this.addSuperstructureApplication("GT1", "ADT_A31"); 
	                          this.add(ADT_AXX_INSURANCE.class, false, true);
	          this.addSuperstructureApplication("INSURANCE", "ADT_A08"); 
	          this.addSuperstructureApplication("INSURANCE", "ADT_A04"); 
	          this.addSuperstructureApplication("INSURANCE", "ADT_A13"); 
	          this.addSuperstructureApplication("INSURANCE", "ADT_A14"); 
	          this.addSuperstructureApplication("INSURANCE", "ADT_A28"); 
	          this.addSuperstructureApplication("INSURANCE", "ADT_A31"); 
	          this.addSuperstructureApplication("INSURANCE", "ADT_A07"); 
	                          this.add(ACC.class, false, false);
	          this.addSuperstructureApplication("ACC", "ADT_A01"); 
	          this.addSuperstructureApplication("ACC", "ADT_A03"); 
	          this.addSuperstructureApplication("ACC", "ADT_A04"); 
	          this.addSuperstructureApplication("ACC", "ADT_A05"); 
	          this.addSuperstructureApplication("ACC", "ADT_A06"); 
	          this.addSuperstructureApplication("ACC", "ADT_A07"); 
	          this.addSuperstructureApplication("ACC", "ADT_A08"); 
	          this.addSuperstructureApplication("ACC", "ADT_A13"); 
	          this.addSuperstructureApplication("ACC", "ADT_A14"); 
	          this.addSuperstructureApplication("ACC", "ADT_A16"); 
	          this.addSuperstructureApplication("ACC", "ADT_A28"); 
	          this.addSuperstructureApplication("ACC", "ADT_A31"); 
	                          this.add(UB1.class, false, false);
	          this.addSuperstructureApplication("UB1", "ADT_A01"); 
	          this.addSuperstructureApplication("UB1", "ADT_A04"); 
	          this.addSuperstructureApplication("UB1", "ADT_A05"); 
	          this.addSuperstructureApplication("UB1", "ADT_A06"); 
	          this.addSuperstructureApplication("UB1", "ADT_A07"); 
	          this.addSuperstructureApplication("UB1", "ADT_A08"); 
	          this.addSuperstructureApplication("UB1", "ADT_A13"); 
	          this.addSuperstructureApplication("UB1", "ADT_A14"); 
	          this.addSuperstructureApplication("UB1", "ADT_A28"); 
	          this.addSuperstructureApplication("UB1", "ADT_A31"); 
	                          this.add(UB2.class, false, false);
	          this.addSuperstructureApplication("UB2", "ADT_A01"); 
	          this.addSuperstructureApplication("UB2", "ADT_A04"); 
	          this.addSuperstructureApplication("UB2", "ADT_A05"); 
	          this.addSuperstructureApplication("UB2", "ADT_A06"); 
	          this.addSuperstructureApplication("UB2", "ADT_A07"); 
	          this.addSuperstructureApplication("UB2", "ADT_A08"); 
	          this.addSuperstructureApplication("UB2", "ADT_A13"); 
	          this.addSuperstructureApplication("UB2", "ADT_A14"); 
	          this.addSuperstructureApplication("UB2", "ADT_A28"); 
	          this.addSuperstructureApplication("UB2", "ADT_A31"); 
	                          this.add(PDA.class, false, false);
	          this.addSuperstructureApplication("PDA", "ADT_A01"); 
	          this.addSuperstructureApplication("PDA", "ADT_A02"); 
	          this.addSuperstructureApplication("PDA", "ADT_A03"); 
	          this.addSuperstructureApplication("PDA", "ADT_A04"); 
	          this.addSuperstructureApplication("PDA", "ADT_A08"); 
	          this.addSuperstructureApplication("PDA", "ADT_A13"); 
	                          this.add(PID.class, false, false);
	          this.addSuperstructureApplication("PID2", "ADT_A17"); 
	          this.addSuperstructureApplication("PID2", "ADT_A24"); 
	          this.addSuperstructureApplication("PID2", "ADT_A37"); 
	                          this.add(PD1.class, false, false);
	          this.addSuperstructureApplication("PD12", "ADT_A17"); 
	          this.addSuperstructureApplication("PD12", "ADT_A24"); 
	          this.addSuperstructureApplication("PD12", "ADT_A37"); 
	                          this.add(PV1.class, false, false);
	          this.addSuperstructureApplication("PV12", "ADT_A17"); 
	          this.addSuperstructureApplication("PV12", "ADT_A24"); 
	          this.addSuperstructureApplication("PV12", "ADT_A37"); 
	                          this.add(PV2.class, false, false);
	          this.addSuperstructureApplication("PV22", "ADT_A17"); 
	                          this.add(DB1.class, false, true);
	          this.addSuperstructureApplication("DB12", "ADT_A17"); 
	          this.addSuperstructureApplication("DB12", "ADT_A24"); 
	          this.addSuperstructureApplication("DB12", "ADT_A37"); 
	                          this.add(OBX.class, false, true);
	          this.addSuperstructureApplication("OBX2", "ADT_A17"); 
	                          this.add(NPU.class, false, false);
	          this.addSuperstructureApplication("NPU", "ADT_A20"); 
	                          this.add(ADT_AXX_PATIENT.class, false, true);
	          this.addSuperstructureApplication("PATIENT", "ADT_A40"); 
	          this.addSuperstructureApplication("PATIENT", "ADT_A41"); 
	          this.addSuperstructureApplication("PATIENT", "ADT_A42"); 
	          this.addSuperstructureApplication("PATIENT", "ADT_A44"); 
	                          this.add(ADT_AXX_MERGE_INFO.class, false, true);
	                          this.add(IAM.class, false, true);
	          this.addSuperstructureApplication("IAM", "ADT_A60"); 
	       } catch(HL7Exception e) {
          log.error("Unexpected error creating ADT_AXX - this is probably a bug in the source code generator.", e);
       }
    }

	public java.util.List<String> getChildNamesForStructure(String theStructure) {
		java.util.ArrayList<String> retVal = new java.util.ArrayList<String>();
			if ( "ADT_A01".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("SFT"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PD1"); 
					retVal.add("ROL"); 
					retVal.add("NK1"); 
					retVal.add("PV1"); 
					retVal.add("PV2"); 
					retVal.add("ROL2"); 
					retVal.add("DB1"); 
					retVal.add("OBX"); 
					retVal.add("AL1"); 
					retVal.add("DG1"); 
					retVal.add("DRG"); 
					retVal.add("PROCEDURE"); 
					retVal.add("GT1"); 
					retVal.add("INSURANCE"); 
					retVal.add("ACC"); 
					retVal.add("UB1"); 
					retVal.add("UB2"); 
					retVal.add("PDA"); 
				}
			if ( "ADT_A02".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("SFT"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PD1"); 
					retVal.add("ROL"); 
					retVal.add("PV1"); 
					retVal.add("PV2"); 
					retVal.add("ROL2"); 
					retVal.add("DB1"); 
					retVal.add("OBX"); 
					retVal.add("PDA"); 
				}
			if ( "ADT_A03".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("SFT"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PD1"); 
					retVal.add("ROL"); 
					retVal.add("NK1"); 
					retVal.add("PV1"); 
					retVal.add("PV2"); 
					retVal.add("ROL2"); 
					retVal.add("DB1"); 
					retVal.add("AL1"); 
					retVal.add("DG1"); 
					retVal.add("DRG"); 
					retVal.add("PROCEDURE"); 
					retVal.add("OBX"); 
					retVal.add("GT1"); 
					retVal.add("INSURANCE"); 
					retVal.add("ACC"); 
					retVal.add("PDA"); 
				}
			if ( "ADT_A05".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("SFT"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PD1"); 
					retVal.add("ROL"); 
					retVal.add("NK1"); 
					retVal.add("PV1"); 
					retVal.add("PV2"); 
					retVal.add("ROL2"); 
					retVal.add("DB1"); 
					retVal.add("OBX"); 
					retVal.add("AL1"); 
					retVal.add("DG1"); 
					retVal.add("DRG"); 
					retVal.add("PROCEDURE"); 
					retVal.add("GT1"); 
					retVal.add("INSURANCE"); 
					retVal.add("ACC"); 
					retVal.add("UB1"); 
					retVal.add("UB2"); 
				}
			if ( "ADT_A06".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("SFT"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PD1"); 
					retVal.add("ROL"); 
					retVal.add("MRG"); 
					retVal.add("NK1"); 
					retVal.add("PV1"); 
					retVal.add("PV2"); 
					retVal.add("ROL2"); 
					retVal.add("DB1"); 
					retVal.add("OBX"); 
					retVal.add("AL1"); 
					retVal.add("DG1"); 
					retVal.add("DRG"); 
					retVal.add("PROCEDURE"); 
					retVal.add("GT1"); 
					retVal.add("INSURANCE"); 
					retVal.add("ACC"); 
					retVal.add("UB1"); 
					retVal.add("UB2"); 
				}
			if ( "ADT_A09".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("SFT"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PD1"); 
					retVal.add("PV1"); 
					retVal.add("PV2"); 
					retVal.add("DB1"); 
					retVal.add("OBX"); 
					retVal.add("DG1"); 
				}
			if ( "ADT_A12".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("SFT"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PD1"); 
					retVal.add("PV1"); 
					retVal.add("PV2"); 
					retVal.add("DB1"); 
					retVal.add("OBX"); 
					retVal.add("DG1"); 
				}
			if ( "ADT_A15".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("SFT"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PD1"); 
					retVal.add("ROL"); 
					retVal.add("PV1"); 
					retVal.add("PV2"); 
					retVal.add("ROL2"); 
					retVal.add("DB1"); 
					retVal.add("OBX"); 
					retVal.add("DG1"); 
				}
			if ( "ADT_A16".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("SFT"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PD1"); 
					retVal.add("ROL"); 
					retVal.add("NK1"); 
					retVal.add("PV1"); 
					retVal.add("PV2"); 
					retVal.add("ROL2"); 
					retVal.add("DB1"); 
					retVal.add("OBX"); 
					retVal.add("AL1"); 
					retVal.add("DG1"); 
					retVal.add("DRG"); 
					retVal.add("PROCEDURE"); 
					retVal.add("GT1"); 
					retVal.add("INSURANCE"); 
					retVal.add("ACC"); 
				}
			if ( "ADT_A17".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("SFT"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PD1"); 
					retVal.add("PV1"); 
					retVal.add("PV2"); 
					retVal.add("DB1"); 
					retVal.add("OBX"); 
					retVal.add("PID2"); 
					retVal.add("PD12"); 
					retVal.add("PV12"); 
					retVal.add("PV22"); 
					retVal.add("DB12"); 
					retVal.add("OBX2"); 
				}
			if ( "ADT_A18".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("SFT"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PD1"); 
					retVal.add("MRG"); 
					retVal.add("PV1"); 
				}
			if ( "ADT_A20".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("SFT"); 
					retVal.add("EVN"); 
					retVal.add("NPU"); 
				}
			if ( "ADT_A21".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("SFT"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PD1"); 
					retVal.add("PV1"); 
					retVal.add("PV2"); 
					retVal.add("DB1"); 
					retVal.add("OBX"); 
				}
			if ( "ADT_A24".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("SFT"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PD1"); 
					retVal.add("PV1"); 
					retVal.add("DB1"); 
					retVal.add("PID2"); 
					retVal.add("PD12"); 
					retVal.add("PV12"); 
					retVal.add("DB12"); 
				}
			if ( "ADT_A30".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("SFT"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PD1"); 
					retVal.add("MRG"); 
				}
			if ( "ADT_A37".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("SFT"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PD1"); 
					retVal.add("PV1"); 
					retVal.add("DB1"); 
					retVal.add("PID2"); 
					retVal.add("PD12"); 
					retVal.add("PV12"); 
					retVal.add("DB12"); 
				}
			if ( "ADT_A38".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("SFT"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PD1"); 
					retVal.add("PV1"); 
					retVal.add("PV2"); 
					retVal.add("DB1"); 
					retVal.add("OBX"); 
					retVal.add("DG1"); 
					retVal.add("DRG"); 
				}
			if ( "ADT_A39".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("SFT"); 
					retVal.add("EVN"); 
					retVal.add("PATIENT"); 
				}
			if ( "ADT_A43".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("SFT"); 
					retVal.add("EVN"); 
					retVal.add("PATIENT"); 
				}
			if ( "ADT_A45".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("SFT"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PD1"); 
					retVal.add("MERGE_INFO"); 
				}
			if ( "ADT_A50".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("SFT"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PD1"); 
					retVal.add("MRG"); 
					retVal.add("PV1"); 
				}
			if ( "ADT_A52".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("SFT"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PD1"); 
					retVal.add("PV1"); 
					retVal.add("PV2"); 
				}
			if ( "ADT_A54".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("SFT"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PD1"); 
					retVal.add("ROL"); 
					retVal.add("PV1"); 
					retVal.add("PV2"); 
					retVal.add("ROL2"); 
				}
			if ( "ADT_A60".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("SFT"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PV1"); 
					retVal.add("PV2"); 
					retVal.add("IAM"); 
				}
			if ( "ADT_A61".equals(theStructure) ) {
					retVal.add("MSH"); 
					retVal.add("SFT"); 
					retVal.add("EVN"); 
					retVal.add("PID"); 
					retVal.add("PD1"); 
					retVal.add("PV1"); 
					retVal.add("ROL"); 
					retVal.add("PV2"); 
				}
			return retVal;
	}

    /** 
     * Returns "2.5"
     */
    public String getVersion() {
       return "2.5";
    }




    /**
     * <p>
     * Returns
     * MSH () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A18, ADT_A20, ADT_A21, ADT_A22, ADT_A23, ADT_A24, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A30, ADT_A31, ADT_A32, ADT_A33, ADT_A34, ADT_A35, ADT_A36, ADT_A37, ADT_A38, ADT_A39, ADT_A40, ADT_A41, ADT_A42, ADT_A43, ADT_A44, ADT_A45, ADT_A46, ADT_A47, ADT_A48, ADT_A49, ADT_A50, ADT_A51, ADT_A52, ADT_A53, ADT_A54, ADT_A55, ADT_A60, ADT_A61, ADT_A62]
     *
     */
    public MSH getMSH() { 
       return getTyped("MSH", MSH.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * SFT () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A18, ADT_A20, ADT_A21, ADT_A22, ADT_A23, ADT_A24, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A30, ADT_A31, ADT_A32, ADT_A33, ADT_A34, ADT_A35, ADT_A36, ADT_A37, ADT_A38, ADT_A39, ADT_A40, ADT_A41, ADT_A42, ADT_A43, ADT_A44, ADT_A45, ADT_A46, ADT_A47, ADT_A48, ADT_A49, ADT_A50, ADT_A51, ADT_A52, ADT_A53, ADT_A54, ADT_A55, ADT_A60, ADT_A61, ADT_A62]
     *
     */
    public SFT getSFT() { 
       return getTyped("SFT", SFT.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * SFT () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A18, ADT_A20, ADT_A21, ADT_A22, ADT_A23, ADT_A24, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A30, ADT_A31, ADT_A32, ADT_A33, ADT_A34, ADT_A35, ADT_A36, ADT_A37, ADT_A38, ADT_A39, ADT_A40, ADT_A41, ADT_A42, ADT_A43, ADT_A44, ADT_A45, ADT_A46, ADT_A47, ADT_A48, ADT_A49, ADT_A50, ADT_A51, ADT_A52, ADT_A53, ADT_A54, ADT_A55, ADT_A60, ADT_A61, ADT_A62]
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SFT getSFT(int rep) { 
       return getTyped("SFT", rep, SFT.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of SFT 
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A18, ADT_A20, ADT_A21, ADT_A22, ADT_A23, ADT_A24, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A30, ADT_A31, ADT_A32, ADT_A33, ADT_A34, ADT_A35, ADT_A36, ADT_A37, ADT_A38, ADT_A39, ADT_A40, ADT_A41, ADT_A42, ADT_A43, ADT_A44, ADT_A45, ADT_A46, ADT_A47, ADT_A48, ADT_A49, ADT_A50, ADT_A51, ADT_A52, ADT_A53, ADT_A54, ADT_A55, ADT_A60, ADT_A61, ADT_A62]
     */ 
    public int getSFTReps() { 
    	return getReps("SFT");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of SFT.
     * <p>
     * <p>
     * Note that unlike {@link #getSFT()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A18, ADT_A20, ADT_A21, ADT_A22, ADT_A23, ADT_A24, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A30, ADT_A31, ADT_A32, ADT_A33, ADT_A34, ADT_A35, ADT_A36, ADT_A37, ADT_A38, ADT_A39, ADT_A40, ADT_A41, ADT_A42, ADT_A43, ADT_A44, ADT_A45, ADT_A46, ADT_A47, ADT_A48, ADT_A49, ADT_A50, ADT_A51, ADT_A52, ADT_A53, ADT_A54, ADT_A55, ADT_A60, ADT_A61, ADT_A62]
     */ 
    public java.util.List<SFT> getSFTAll() throws HL7Exception {
    	return getAllAsList("SFT", SFT.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of SFT ()
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A18, ADT_A20, ADT_A21, ADT_A22, ADT_A23, ADT_A24, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A30, ADT_A31, ADT_A32, ADT_A33, ADT_A34, ADT_A35, ADT_A36, ADT_A37, ADT_A38, ADT_A39, ADT_A40, ADT_A41, ADT_A42, ADT_A43, ADT_A44, ADT_A45, ADT_A46, ADT_A47, ADT_A48, ADT_A49, ADT_A50, ADT_A51, ADT_A52, ADT_A53, ADT_A54, ADT_A55, ADT_A60, ADT_A61, ADT_A62]
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertSFT(SFT structure, int rep) throws HL7Exception { 
       super.insertRepetition( "SFT", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of SFT ()
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A18, ADT_A20, ADT_A21, ADT_A22, ADT_A23, ADT_A24, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A30, ADT_A31, ADT_A32, ADT_A33, ADT_A34, ADT_A35, ADT_A36, ADT_A37, ADT_A38, ADT_A39, ADT_A40, ADT_A41, ADT_A42, ADT_A43, ADT_A44, ADT_A45, ADT_A46, ADT_A47, ADT_A48, ADT_A49, ADT_A50, ADT_A51, ADT_A52, ADT_A53, ADT_A54, ADT_A55, ADT_A60, ADT_A61, ADT_A62]
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SFT insertSFT(int rep) throws HL7Exception { 
       return (SFT)super.insertRepetition("SFT", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of SFT ()
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A18, ADT_A20, ADT_A21, ADT_A22, ADT_A23, ADT_A24, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A30, ADT_A31, ADT_A32, ADT_A33, ADT_A34, ADT_A35, ADT_A36, ADT_A37, ADT_A38, ADT_A39, ADT_A40, ADT_A41, ADT_A42, ADT_A43, ADT_A44, ADT_A45, ADT_A46, ADT_A47, ADT_A48, ADT_A49, ADT_A50, ADT_A51, ADT_A52, ADT_A53, ADT_A54, ADT_A55, ADT_A60, ADT_A61, ADT_A62]
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SFT removeSFT(int rep) throws HL7Exception { 
       return (SFT)super.removeRepetition("SFT", rep);
    }




    /**
     * <p>
     * Returns
     * EVN () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A18, ADT_A20, ADT_A21, ADT_A22, ADT_A23, ADT_A24, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A30, ADT_A31, ADT_A32, ADT_A33, ADT_A34, ADT_A35, ADT_A36, ADT_A37, ADT_A38, ADT_A39, ADT_A40, ADT_A41, ADT_A42, ADT_A43, ADT_A44, ADT_A45, ADT_A46, ADT_A47, ADT_A48, ADT_A49, ADT_A50, ADT_A51, ADT_A52, ADT_A53, ADT_A54, ADT_A55, ADT_A60, ADT_A61, ADT_A62]
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
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A18, ADT_A21, ADT_A22, ADT_A23, ADT_A24, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A30, ADT_A31, ADT_A32, ADT_A33, ADT_A34, ADT_A35, ADT_A36, ADT_A37, ADT_A38, ADT_A45, ADT_A46, ADT_A47, ADT_A48, ADT_A49, ADT_A50, ADT_A51, ADT_A52, ADT_A53, ADT_A54, ADT_A55, ADT_A60, ADT_A61, ADT_A62]
     *
     */
    public PID getPID() { 
       return getTyped("PID", PID.class);
    }





    /**
     * <p>
     * Returns
     * PD1 () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A18, ADT_A21, ADT_A22, ADT_A23, ADT_A24, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A30, ADT_A31, ADT_A32, ADT_A33, ADT_A34, ADT_A35, ADT_A36, ADT_A37, ADT_A38, ADT_A45, ADT_A46, ADT_A47, ADT_A48, ADT_A49, ADT_A50, ADT_A51, ADT_A52, ADT_A53, ADT_A54, ADT_A55, ADT_A61, ADT_A62]
     *
     */
    public PD1 getPD1() { 
       return getTyped("PD1", PD1.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * ROL () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A28, ADT_A31, ADT_A54, ADT_A61, ADT_A62]
     *
     */
    public ROL getROL() { 
       return getTyped("ROL", ROL.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * ROL () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A28, ADT_A31, ADT_A54, ADT_A61, ADT_A62]
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ROL getROL(int rep) { 
       return getTyped("ROL", rep, ROL.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of ROL 
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A28, ADT_A31, ADT_A54, ADT_A61, ADT_A62]
     */ 
    public int getROLReps() { 
    	return getReps("ROL");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ROL.
     * <p>
     * <p>
     * Note that unlike {@link #getROL()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A28, ADT_A31, ADT_A54, ADT_A61, ADT_A62]
     */ 
    public java.util.List<ROL> getROLAll() throws HL7Exception {
    	return getAllAsList("ROL", ROL.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of ROL ()
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A28, ADT_A31, ADT_A54, ADT_A61, ADT_A62]
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertROL(ROL structure, int rep) throws HL7Exception { 
       super.insertRepetition( "ROL", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of ROL ()
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A28, ADT_A31, ADT_A54, ADT_A61, ADT_A62]
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ROL insertROL(int rep) throws HL7Exception { 
       return (ROL)super.insertRepetition("ROL", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of ROL ()
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A28, ADT_A31, ADT_A54, ADT_A61, ADT_A62]
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ROL removeROL(int rep) throws HL7Exception { 
       return (ROL)super.removeRepetition("ROL", rep);
    }




    /**
     * <p>
     * Returns
     * MRG () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A06, ADT_A07, ADT_A18, ADT_A30, ADT_A34, ADT_A35, ADT_A36, ADT_A46, ADT_A47, ADT_A48, ADT_A49, ADT_A50, ADT_A51]
     *
     */
    public MRG getMRG() { 
       return getTyped("MRG", MRG.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * NK1 () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A16, ADT_A28, ADT_A31]
     *
     */
    public NK1 getNK1() { 
       return getTyped("NK1", NK1.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * NK1 () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A16, ADT_A28, ADT_A31]
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public NK1 getNK1(int rep) { 
       return getTyped("NK1", rep, NK1.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of NK1 
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A16, ADT_A28, ADT_A31]
     */ 
    public int getNK1Reps() { 
    	return getReps("NK1");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of NK1.
     * <p>
     * <p>
     * Note that unlike {@link #getNK1()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A16, ADT_A28, ADT_A31]
     */ 
    public java.util.List<NK1> getNK1All() throws HL7Exception {
    	return getAllAsList("NK1", NK1.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of NK1 ()
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A16, ADT_A28, ADT_A31]
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertNK1(NK1 structure, int rep) throws HL7Exception { 
       super.insertRepetition( "NK1", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of NK1 ()
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A16, ADT_A28, ADT_A31]
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public NK1 insertNK1(int rep) throws HL7Exception { 
       return (NK1)super.insertRepetition("NK1", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of NK1 ()
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A16, ADT_A28, ADT_A31]
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public NK1 removeNK1(int rep) throws HL7Exception { 
       return (NK1)super.removeRepetition("NK1", rep);
    }




    /**
     * <p>
     * Returns
     * PV1 () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A18, ADT_A21, ADT_A22, ADT_A23, ADT_A24, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A31, ADT_A32, ADT_A33, ADT_A37, ADT_A38, ADT_A50, ADT_A51, ADT_A52, ADT_A53, ADT_A54, ADT_A55, ADT_A60, ADT_A61, ADT_A62]
     *
     */
    public PV1 getPV1() { 
       return getTyped("PV1", PV1.class);
    }





    /**
     * <p>
     * Returns
     * PV2 () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A21, ADT_A22, ADT_A23, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A31, ADT_A32, ADT_A33, ADT_A38, ADT_A52, ADT_A53, ADT_A54, ADT_A55, ADT_A60, ADT_A61, ADT_A62]
     *
     */
    public PV2 getPV2() { 
       return getTyped("PV2", PV2.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * ROL2 () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A28, ADT_A31, ADT_A54]
     *
     */
    public ROL getROL2() { 
       return getTyped("ROL2", ROL.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * ROL2 () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A28, ADT_A31, ADT_A54]
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ROL getROL2(int rep) { 
       return getTyped("ROL2", rep, ROL.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of ROL2 
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A28, ADT_A31, ADT_A54]
     */ 
    public int getROL2Reps() { 
    	return getReps("ROL2");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ROL2.
     * <p>
     * <p>
     * Note that unlike {@link #getROL2()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A28, ADT_A31, ADT_A54]
     */ 
    public java.util.List<ROL> getROL2All() throws HL7Exception {
    	return getAllAsList("ROL2", ROL.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of ROL2 ()
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A28, ADT_A31, ADT_A54]
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertROL2(ROL structure, int rep) throws HL7Exception { 
       super.insertRepetition( "ROL2", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of ROL2 ()
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A28, ADT_A31, ADT_A54]
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ROL insertROL2(int rep) throws HL7Exception { 
       return (ROL)super.insertRepetition("ROL2", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of ROL2 ()
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A28, ADT_A31, ADT_A54]
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ROL removeROL2(int rep) throws HL7Exception { 
       return (ROL)super.removeRepetition("ROL2", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * DB1 () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A21, ADT_A22, ADT_A23, ADT_A24, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A31, ADT_A32, ADT_A33, ADT_A37, ADT_A38]
     *
     */
    public DB1 getDB1() { 
       return getTyped("DB1", DB1.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * DB1 () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A21, ADT_A22, ADT_A23, ADT_A24, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A31, ADT_A32, ADT_A33, ADT_A37, ADT_A38]
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public DB1 getDB1(int rep) { 
       return getTyped("DB1", rep, DB1.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of DB1 
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A21, ADT_A22, ADT_A23, ADT_A24, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A31, ADT_A32, ADT_A33, ADT_A37, ADT_A38]
     */ 
    public int getDB1Reps() { 
    	return getReps("DB1");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of DB1.
     * <p>
     * <p>
     * Note that unlike {@link #getDB1()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A21, ADT_A22, ADT_A23, ADT_A24, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A31, ADT_A32, ADT_A33, ADT_A37, ADT_A38]
     */ 
    public java.util.List<DB1> getDB1All() throws HL7Exception {
    	return getAllAsList("DB1", DB1.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of DB1 ()
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A21, ADT_A22, ADT_A23, ADT_A24, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A31, ADT_A32, ADT_A33, ADT_A37, ADT_A38]
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertDB1(DB1 structure, int rep) throws HL7Exception { 
       super.insertRepetition( "DB1", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of DB1 ()
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A21, ADT_A22, ADT_A23, ADT_A24, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A31, ADT_A32, ADT_A33, ADT_A37, ADT_A38]
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public DB1 insertDB1(int rep) throws HL7Exception { 
       return (DB1)super.insertRepetition("DB1", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of DB1 ()
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A21, ADT_A22, ADT_A23, ADT_A24, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A31, ADT_A32, ADT_A33, ADT_A37, ADT_A38]
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public DB1 removeDB1(int rep) throws HL7Exception { 
       return (DB1)super.removeRepetition("DB1", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * OBX () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A21, ADT_A22, ADT_A23, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A31, ADT_A32, ADT_A33, ADT_A38]
     *
     */
    public OBX getOBX() { 
       return getTyped("OBX", OBX.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * OBX () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A21, ADT_A22, ADT_A23, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A31, ADT_A32, ADT_A33, ADT_A38]
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public OBX getOBX(int rep) { 
       return getTyped("OBX", rep, OBX.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of OBX 
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A21, ADT_A22, ADT_A23, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A31, ADT_A32, ADT_A33, ADT_A38]
     */ 
    public int getOBXReps() { 
    	return getReps("OBX");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of OBX.
     * <p>
     * <p>
     * Note that unlike {@link #getOBX()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A21, ADT_A22, ADT_A23, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A31, ADT_A32, ADT_A33, ADT_A38]
     */ 
    public java.util.List<OBX> getOBXAll() throws HL7Exception {
    	return getAllAsList("OBX", OBX.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of OBX ()
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A21, ADT_A22, ADT_A23, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A31, ADT_A32, ADT_A33, ADT_A38]
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertOBX(OBX structure, int rep) throws HL7Exception { 
       super.insertRepetition( "OBX", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of OBX ()
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A21, ADT_A22, ADT_A23, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A31, ADT_A32, ADT_A33, ADT_A38]
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OBX insertOBX(int rep) throws HL7Exception { 
       return (OBX)super.insertRepetition("OBX", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of OBX ()
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A17, ADT_A21, ADT_A22, ADT_A23, ADT_A25, ADT_A26, ADT_A27, ADT_A28, ADT_A29, ADT_A31, ADT_A32, ADT_A33, ADT_A38]
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OBX removeOBX(int rep) throws HL7Exception { 
       return (OBX)super.removeRepetition("OBX", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * AL1 () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A16, ADT_A28, ADT_A31]
     *
     */
    public AL1 getAL1() { 
       return getTyped("AL1", AL1.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * AL1 () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A16, ADT_A28, ADT_A31]
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public AL1 getAL1(int rep) { 
       return getTyped("AL1", rep, AL1.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of AL1 
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A16, ADT_A28, ADT_A31]
     */ 
    public int getAL1Reps() { 
    	return getReps("AL1");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of AL1.
     * <p>
     * <p>
     * Note that unlike {@link #getAL1()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A16, ADT_A28, ADT_A31]
     */ 
    public java.util.List<AL1> getAL1All() throws HL7Exception {
    	return getAllAsList("AL1", AL1.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of AL1 ()
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A16, ADT_A28, ADT_A31]
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertAL1(AL1 structure, int rep) throws HL7Exception { 
       super.insertRepetition( "AL1", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of AL1 ()
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A16, ADT_A28, ADT_A31]
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public AL1 insertAL1(int rep) throws HL7Exception { 
       return (AL1)super.insertRepetition("AL1", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of AL1 ()
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A16, ADT_A28, ADT_A31]
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public AL1 removeAL1(int rep) throws HL7Exception { 
       return (AL1)super.removeRepetition("AL1", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * DG1 () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A28, ADT_A31, ADT_A38]
     *
     */
    public DG1 getDG1() { 
       return getTyped("DG1", DG1.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * DG1 () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A28, ADT_A31, ADT_A38]
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public DG1 getDG1(int rep) { 
       return getTyped("DG1", rep, DG1.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of DG1 
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A28, ADT_A31, ADT_A38]
     */ 
    public int getDG1Reps() { 
    	return getReps("DG1");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of DG1.
     * <p>
     * <p>
     * Note that unlike {@link #getDG1()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A28, ADT_A31, ADT_A38]
     */ 
    public java.util.List<DG1> getDG1All() throws HL7Exception {
    	return getAllAsList("DG1", DG1.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of DG1 ()
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A28, ADT_A31, ADT_A38]
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertDG1(DG1 structure, int rep) throws HL7Exception { 
       super.insertRepetition( "DG1", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of DG1 ()
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A28, ADT_A31, ADT_A38]
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public DG1 insertDG1(int rep) throws HL7Exception { 
       return (DG1)super.insertRepetition("DG1", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of DG1 ()
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A09, ADT_A10, ADT_A11, ADT_A12, ADT_A13, ADT_A14, ADT_A15, ADT_A16, ADT_A28, ADT_A31, ADT_A38]
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public DG1 removeDG1(int rep) throws HL7Exception { 
       return (DG1)super.removeRepetition("DG1", rep);
    }




    /**
     * <p>
     * Returns
     * DRG () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A16, ADT_A28, ADT_A31, ADT_A38]
     *
     */
    public DRG getDRG() { 
       return getTyped("DRG", DRG.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * PROCEDURE () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A08, ADT_A04, ADT_A13, ADT_A14, ADT_A28, ADT_A31, ADT_A07]
     *
     */
    public ADT_AXX_PROCEDURE getPROCEDURE() { 
       return getTyped("PROCEDURE", ADT_AXX_PROCEDURE.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * PROCEDURE () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A08, ADT_A04, ADT_A13, ADT_A14, ADT_A28, ADT_A31, ADT_A07]
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ADT_AXX_PROCEDURE getPROCEDURE(int rep) { 
       return getTyped("PROCEDURE", rep, ADT_AXX_PROCEDURE.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of PROCEDURE 
     * </p>
     * Used for the following structures: [ADT_A08, ADT_A04, ADT_A13, ADT_A14, ADT_A28, ADT_A31, ADT_A07]
     */ 
    public int getPROCEDUREReps() { 
    	return getReps("PROCEDURE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PROCEDURE.
     * <p>
     * <p>
     * Note that unlike {@link #getPROCEDURE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * Used for the following structures: [ADT_A08, ADT_A04, ADT_A13, ADT_A14, ADT_A28, ADT_A31, ADT_A07]
     */ 
    public java.util.List<ADT_AXX_PROCEDURE> getPROCEDUREAll() throws HL7Exception {
    	return getAllAsList("PROCEDURE", ADT_AXX_PROCEDURE.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of PROCEDURE ()
     * </p>
     * Used for the following structures: [ADT_A08, ADT_A04, ADT_A13, ADT_A14, ADT_A28, ADT_A31, ADT_A07]
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPROCEDURE(ADT_AXX_PROCEDURE structure, int rep) throws HL7Exception { 
       super.insertRepetition( "PROCEDURE", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of PROCEDURE ()
     * </p>
     * Used for the following structures: [ADT_A08, ADT_A04, ADT_A13, ADT_A14, ADT_A28, ADT_A31, ADT_A07]
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ADT_AXX_PROCEDURE insertPROCEDURE(int rep) throws HL7Exception { 
       return (ADT_AXX_PROCEDURE)super.insertRepetition("PROCEDURE", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of PROCEDURE ()
     * </p>
     * Used for the following structures: [ADT_A08, ADT_A04, ADT_A13, ADT_A14, ADT_A28, ADT_A31, ADT_A07]
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ADT_AXX_PROCEDURE removePROCEDURE(int rep) throws HL7Exception { 
       return (ADT_AXX_PROCEDURE)super.removeRepetition("PROCEDURE", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * GT1 () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A16, ADT_A28, ADT_A31]
     *
     */
    public GT1 getGT1() { 
       return getTyped("GT1", GT1.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * GT1 () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A16, ADT_A28, ADT_A31]
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public GT1 getGT1(int rep) { 
       return getTyped("GT1", rep, GT1.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of GT1 
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A16, ADT_A28, ADT_A31]
     */ 
    public int getGT1Reps() { 
    	return getReps("GT1");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of GT1.
     * <p>
     * <p>
     * Note that unlike {@link #getGT1()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A16, ADT_A28, ADT_A31]
     */ 
    public java.util.List<GT1> getGT1All() throws HL7Exception {
    	return getAllAsList("GT1", GT1.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of GT1 ()
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A16, ADT_A28, ADT_A31]
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertGT1(GT1 structure, int rep) throws HL7Exception { 
       super.insertRepetition( "GT1", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of GT1 ()
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A16, ADT_A28, ADT_A31]
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public GT1 insertGT1(int rep) throws HL7Exception { 
       return (GT1)super.insertRepetition("GT1", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of GT1 ()
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A16, ADT_A28, ADT_A31]
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public GT1 removeGT1(int rep) throws HL7Exception { 
       return (GT1)super.removeRepetition("GT1", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * INSURANCE () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A08, ADT_A04, ADT_A13, ADT_A14, ADT_A28, ADT_A31, ADT_A07]
     *
     */
    public ADT_AXX_INSURANCE getINSURANCE() { 
       return getTyped("INSURANCE", ADT_AXX_INSURANCE.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * INSURANCE () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A08, ADT_A04, ADT_A13, ADT_A14, ADT_A28, ADT_A31, ADT_A07]
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ADT_AXX_INSURANCE getINSURANCE(int rep) { 
       return getTyped("INSURANCE", rep, ADT_AXX_INSURANCE.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of INSURANCE 
     * </p>
     * Used for the following structures: [ADT_A08, ADT_A04, ADT_A13, ADT_A14, ADT_A28, ADT_A31, ADT_A07]
     */ 
    public int getINSURANCEReps() { 
    	return getReps("INSURANCE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of INSURANCE.
     * <p>
     * <p>
     * Note that unlike {@link #getINSURANCE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * Used for the following structures: [ADT_A08, ADT_A04, ADT_A13, ADT_A14, ADT_A28, ADT_A31, ADT_A07]
     */ 
    public java.util.List<ADT_AXX_INSURANCE> getINSURANCEAll() throws HL7Exception {
    	return getAllAsList("INSURANCE", ADT_AXX_INSURANCE.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of INSURANCE ()
     * </p>
     * Used for the following structures: [ADT_A08, ADT_A04, ADT_A13, ADT_A14, ADT_A28, ADT_A31, ADT_A07]
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertINSURANCE(ADT_AXX_INSURANCE structure, int rep) throws HL7Exception { 
       super.insertRepetition( "INSURANCE", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of INSURANCE ()
     * </p>
     * Used for the following structures: [ADT_A08, ADT_A04, ADT_A13, ADT_A14, ADT_A28, ADT_A31, ADT_A07]
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ADT_AXX_INSURANCE insertINSURANCE(int rep) throws HL7Exception { 
       return (ADT_AXX_INSURANCE)super.insertRepetition("INSURANCE", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of INSURANCE ()
     * </p>
     * Used for the following structures: [ADT_A08, ADT_A04, ADT_A13, ADT_A14, ADT_A28, ADT_A31, ADT_A07]
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ADT_AXX_INSURANCE removeINSURANCE(int rep) throws HL7Exception { 
       return (ADT_AXX_INSURANCE)super.removeRepetition("INSURANCE", rep);
    }




    /**
     * <p>
     * Returns
     * ACC () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A03, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A16, ADT_A28, ADT_A31]
     *
     */
    public ACC getACC() { 
       return getTyped("ACC", ACC.class);
    }





    /**
     * <p>
     * Returns
     * UB1 () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A28, ADT_A31]
     *
     */
    public UB1 getUB1() { 
       return getTyped("UB1", UB1.class);
    }





    /**
     * <p>
     * Returns
     * UB2 () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A04, ADT_A05, ADT_A06, ADT_A07, ADT_A08, ADT_A13, ADT_A14, ADT_A28, ADT_A31]
     *
     */
    public UB2 getUB2() { 
       return getTyped("UB2", UB2.class);
    }





    /**
     * <p>
     * Returns
     * PDA () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A01, ADT_A02, ADT_A03, ADT_A04, ADT_A08, ADT_A13]
     *
     */
    public PDA getPDA() { 
       return getTyped("PDA", PDA.class);
    }





    /**
     * <p>
     * Returns
     * PID2 () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A17, ADT_A24, ADT_A37]
     *
     */
    public PID getPID2() { 
       return getTyped("PID2", PID.class);
    }





    /**
     * <p>
     * Returns
     * PD12 () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A17, ADT_A24, ADT_A37]
     *
     */
    public PD1 getPD12() { 
       return getTyped("PD12", PD1.class);
    }





    /**
     * <p>
     * Returns
     * PV12 () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A17, ADT_A24, ADT_A37]
     *
     */
    public PV1 getPV12() { 
       return getTyped("PV12", PV1.class);
    }





    /**
     * <p>
     * Returns
     * PV22 () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A17]
     *
     */
    public PV2 getPV22() { 
       return getTyped("PV22", PV2.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * DB12 () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A17, ADT_A24, ADT_A37]
     *
     */
    public DB1 getDB12() { 
       return getTyped("DB12", DB1.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * DB12 () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A17, ADT_A24, ADT_A37]
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public DB1 getDB12(int rep) { 
       return getTyped("DB12", rep, DB1.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of DB12 
     * </p>
     * Used for the following structures: [ADT_A17, ADT_A24, ADT_A37]
     */ 
    public int getDB12Reps() { 
    	return getReps("DB12");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of DB12.
     * <p>
     * <p>
     * Note that unlike {@link #getDB12()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * Used for the following structures: [ADT_A17, ADT_A24, ADT_A37]
     */ 
    public java.util.List<DB1> getDB12All() throws HL7Exception {
    	return getAllAsList("DB12", DB1.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of DB12 ()
     * </p>
     * Used for the following structures: [ADT_A17, ADT_A24, ADT_A37]
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertDB12(DB1 structure, int rep) throws HL7Exception { 
       super.insertRepetition( "DB12", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of DB12 ()
     * </p>
     * Used for the following structures: [ADT_A17, ADT_A24, ADT_A37]
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public DB1 insertDB12(int rep) throws HL7Exception { 
       return (DB1)super.insertRepetition("DB12", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of DB12 ()
     * </p>
     * Used for the following structures: [ADT_A17, ADT_A24, ADT_A37]
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public DB1 removeDB12(int rep) throws HL7Exception { 
       return (DB1)super.removeRepetition("DB12", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * OBX2 () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A17]
     *
     */
    public OBX getOBX2() { 
       return getTyped("OBX2", OBX.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * OBX2 () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A17]
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public OBX getOBX2(int rep) { 
       return getTyped("OBX2", rep, OBX.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of OBX2 
     * </p>
     * Used for the following structures: [ADT_A17]
     */ 
    public int getOBX2Reps() { 
    	return getReps("OBX2");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of OBX2.
     * <p>
     * <p>
     * Note that unlike {@link #getOBX2()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * Used for the following structures: [ADT_A17]
     */ 
    public java.util.List<OBX> getOBX2All() throws HL7Exception {
    	return getAllAsList("OBX2", OBX.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of OBX2 ()
     * </p>
     * Used for the following structures: [ADT_A17]
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertOBX2(OBX structure, int rep) throws HL7Exception { 
       super.insertRepetition( "OBX2", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of OBX2 ()
     * </p>
     * Used for the following structures: [ADT_A17]
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OBX insertOBX2(int rep) throws HL7Exception { 
       return (OBX)super.insertRepetition("OBX2", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of OBX2 ()
     * </p>
     * Used for the following structures: [ADT_A17]
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OBX removeOBX2(int rep) throws HL7Exception { 
       return (OBX)super.removeRepetition("OBX2", rep);
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
     * the first repetition of 
     * PATIENT () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A40, ADT_A41, ADT_A42, ADT_A44]
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
     * Used for the following structures: [ADT_A40, ADT_A41, ADT_A42, ADT_A44]
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
     * Used for the following structures: [ADT_A40, ADT_A41, ADT_A42, ADT_A44]
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
     * Used for the following structures: [ADT_A40, ADT_A41, ADT_A42, ADT_A44]
     */ 
    public java.util.List<ADT_AXX_PATIENT> getPATIENTAll() throws HL7Exception {
    	return getAllAsList("PATIENT", ADT_AXX_PATIENT.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of PATIENT ()
     * </p>
     * Used for the following structures: [ADT_A40, ADT_A41, ADT_A42, ADT_A44]
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
     * Used for the following structures: [ADT_A40, ADT_A41, ADT_A42, ADT_A44]
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
     * Used for the following structures: [ADT_A40, ADT_A41, ADT_A42, ADT_A44]
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ADT_AXX_PATIENT removePATIENT(int rep) throws HL7Exception { 
       return (ADT_AXX_PATIENT)super.removeRepetition("PATIENT", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * MERGE_INFO () - creates it if necessary
     * </p>
     * 
     *
     */
    public ADT_AXX_MERGE_INFO getMERGE_INFO() { 
       return getTyped("MERGE_INFO", ADT_AXX_MERGE_INFO.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * MERGE_INFO () - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ADT_AXX_MERGE_INFO getMERGE_INFO(int rep) { 
       return getTyped("MERGE_INFO", rep, ADT_AXX_MERGE_INFO.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of MERGE_INFO 
     * </p>
     * 
     */ 
    public int getMERGE_INFOReps() { 
    	return getReps("MERGE_INFO");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of MERGE_INFO.
     * <p>
     * <p>
     * Note that unlike {@link #getMERGE_INFO()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<ADT_AXX_MERGE_INFO> getMERGE_INFOAll() throws HL7Exception {
    	return getAllAsList("MERGE_INFO", ADT_AXX_MERGE_INFO.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of MERGE_INFO ()
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertMERGE_INFO(ADT_AXX_MERGE_INFO structure, int rep) throws HL7Exception { 
       super.insertRepetition( "MERGE_INFO", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of MERGE_INFO ()
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ADT_AXX_MERGE_INFO insertMERGE_INFO(int rep) throws HL7Exception { 
       return (ADT_AXX_MERGE_INFO)super.insertRepetition("MERGE_INFO", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of MERGE_INFO ()
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ADT_AXX_MERGE_INFO removeMERGE_INFO(int rep) throws HL7Exception { 
       return (ADT_AXX_MERGE_INFO)super.removeRepetition("MERGE_INFO", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * IAM () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A60]
     *
     */
    public IAM getIAM() { 
       return getTyped("IAM", IAM.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * IAM () - creates it if necessary
     * </p>
     * Used for the following structures: [ADT_A60]
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public IAM getIAM(int rep) { 
       return getTyped("IAM", rep, IAM.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of IAM 
     * </p>
     * Used for the following structures: [ADT_A60]
     */ 
    public int getIAMReps() { 
    	return getReps("IAM");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of IAM.
     * <p>
     * <p>
     * Note that unlike {@link #getIAM()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * Used for the following structures: [ADT_A60]
     */ 
    public java.util.List<IAM> getIAMAll() throws HL7Exception {
    	return getAllAsList("IAM", IAM.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of IAM ()
     * </p>
     * Used for the following structures: [ADT_A60]
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertIAM(IAM structure, int rep) throws HL7Exception { 
       super.insertRepetition( "IAM", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of IAM ()
     * </p>
     * Used for the following structures: [ADT_A60]
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public IAM insertIAM(int rep) throws HL7Exception { 
       return (IAM)super.insertRepetition("IAM", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of IAM ()
     * </p>
     * Used for the following structures: [ADT_A60]
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public IAM removeIAM(int rep) throws HL7Exception { 
       return (IAM)super.removeRepetition("IAM", rep);
    }



}

