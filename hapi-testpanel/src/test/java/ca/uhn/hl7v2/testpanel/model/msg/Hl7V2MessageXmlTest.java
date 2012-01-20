/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is ""  Description:
 * ""
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2001.  All Rights Reserved.
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
 */
package ca.uhn.hl7v2.testpanel.model.msg;

import static org.junit.Assert.*;

import java.beans.PropertyVetoException;

import org.junit.Test;

import ca.uhn.hl7v2.testpanel.model.msg.Hl7V2MessageXml;
import ca.uhn.hl7v2.testpanel.util.Range;
import ca.uhn.hl7v2.testpanel.util.XmlScanner;

public class Hl7V2MessageXmlTest {

	@Test
	public void testSetHighlitedPathBasedOnRange() throws PropertyVetoException {
			
	        String message = "<ORU_R01 xmlns=\"urn:hl7-org:v2xml\">\r\n" + 
	                "    <MSH>\r\n" + 
	                "        <MSH.1>|</MSH.1>\r\n" + 
	                "        <MSH.2>^~\\&amp;</MSH.2>\r\n" + 
	                "        <MSH.3>LABMI1</MSH.3>\r\n" + 
	                "        <MSH.5>DMCRES</MSH.5>\r\n" + 
	                "        <MSH.7>\r\n" + 
	                "            <TS.1>19951010134000</TS.1>\r\n" + 
	                "        </MSH.7>\r\n" + 
	                "        <MSH.9>\r\n" + 
	                "            <CM_MSG.1>ORU</CM_MSG.1>\r\n" + 
	                "            <CM_MSG.2>R01</CM_MSG.2>\r\n" + 
	                "        </MSH.9>\r\n" + 
	                "        <MSH.10>LABMI1199510101340007</MSH.10>\r\n" + 
	                "        <MSH.11>D</MSH.11>\r\n" + 
	                "        <MSH.12>2.2</MSH.12>\r\n" + 
	                "        <MSH.15>AL</MSH.15>\r\n" + 
	                "    </MSH>\r\n" +
	                "</ORU_R01>";
	        Hl7V2MessageXml msg = new Hl7V2MessageXml();
	        msg.setSourceMessage(message);
	        message = msg.getSourceMessage(); // in case message impl decides to reformat

	        msg.setHighlitedPathBasedOnRange(new Range(message.indexOf("19951010134000")));
			assertEquals("/MSH-7-1", msg.getHighlitedPath());

	}

	@Test
	public void testSetHighlitedPathBasedOnRangeWithRepetitions() throws PropertyVetoException {
		
		String message = "<?xml version=\"1.0\"?>\r\n" + 
				"<ORU_R01 xmlns=\"urn:hl7-org:v2xml\">\r\n" + 
				"    <MSH>\r\n" + 
				"        <MSH.1>|</MSH.1>\r\n" + 
				"        <MSH.2>^~\\&amp;</MSH.2>\r\n" + 
				"        <MSH.3>\r\n" + 
				"            <HD.1>ULTRA</HD.1>\r\n" + 
				"        </MSH.3>\r\n" + 
				"        <MSH.4>\r\n" + 
				"            <HD.1>TML</HD.1>\r\n" + 
				"        </MSH.4>\r\n" + 
				"        <MSH.5>\r\n" + 
				"            <HD.1>OLIS</HD.1>\r\n" + 
				"        </MSH.5>\r\n" + 
				"        <MSH.6>\r\n" + 
				"            <HD.1>OLIS</HD.1>\r\n" + 
				"        </MSH.6>\r\n" + 
				"        <MSH.7>\r\n" + 
				"            <TS.1>200905011130</TS.1>\r\n" + 
				"        </MSH.7>\r\n" + 
				"        <MSH.9>\r\n" + 
				"            <CM_MSG.1>ORU</CM_MSG.1>\r\n" + 
				"            <CM_MSG.2>R01</CM_MSG.2>\r\n" + 
				"        </MSH.9>\r\n" + 
				"        <MSH.10>20169838</MSH.10>\r\n" + 
				"        <MSH.11>\r\n" + 
				"            <PT.1>T</PT.1>\r\n" + 
				"        </MSH.11>\r\n" + 
				"        <MSH.12>2.3</MSH.12>\r\n" + 
				"    </MSH>\r\n" + 
				"    <ZPI>\r\n" + 
				"        <ZPI.3>\r\n" + 
				"            <UNKNOWN.1>7005728</UNKNOWN.1>\r\n" + 
				"            <UNKNOWN.4>TML</UNKNOWN.4>\r\n" + 
				"            <UNKNOWN.5>MR</UNKNOWN.5>\r\n" + 
				"        </ZPI.3>\r\n" + 
				"        <ZPI.5>\r\n" + 
				"            <UNKNOWN.1>TEST</UNKNOWN.1>\r\n" + 
				"            <UNKNOWN.2>RACHEL</UNKNOWN.2>\r\n" + 
				"            <UNKNOWN.3>DIAMOND</UNKNOWN.3>\r\n" + 
				"        </ZPI.5>\r\n" + 
				"        <ZPI.7>19310313</ZPI.7>\r\n" + 
				"        <ZPI.8>F</ZPI.8>\r\n" + 
				"        <ZPI.11>\r\n" + 
				"            <UNKNOWN.1>200 ANYWHERE ST</UNKNOWN.1>\r\n" + 
				"            <UNKNOWN.3>TORONTO</UNKNOWN.3>\r\n" + 
				"            <UNKNOWN.4>ON</UNKNOWN.4>\r\n" + 
				"            <UNKNOWN.5>M6G 2T9</UNKNOWN.5>\r\n" + 
				"        </ZPI.11>\r\n" + 
				"        <ZPI.13>(416)888-8888</ZPI.13>\r\n" + 
				"        <ZPI.19>\r\n" + 
				"            <UNKNOWN.1>1014071185</UNKNOWN.1>\r\n" + 
				"            <UNKNOWN.2>KR</UNKNOWN.2>\r\n" + 
				"        </ZPI.19>\r\n" + 
				"    </ZPI>\r\n" + 
				"    <ORU_R01.RESPONSE>\r\n" + 
				"        <ORU_R01.PATIENT>\r\n" + 
				"            <PID>\r\n" + 
				"                <PID.3>\r\n" + 
				"                    <CX.1>7005728</CX.1>\r\n" + 
				"                    <CX.4>\r\n" + 
				"                        <HD.1>TML</HD.1>\r\n" + 
				"                    </CX.4>\r\n" + 
				"                    <CX.5>MR</CX.5>\r\n" + 
				"                </PID.3>\r\n" + 
				"                <PID.5>\r\n" + 
				"                    <XPN.1>TEST</XPN.1>\r\n" + 
				"                    <XPN.2>RACHEL</XPN.2>\r\n" + 
				"                    <XPN.3>DIAMOND</XPN.3>\r\n" + 
				"                </PID.5>\r\n" + 
				"                <PID.7>\r\n" + 
				"                    <TS.1>19310313</TS.1>\r\n" + 
				"                </PID.7>\r\n" + 
				"                <PID.8>F</PID.8>\r\n" + 
				"                <PID.11>\r\n" + 
				"                    <XAD.1>200 ANYWHERE ST</XAD.1>\r\n" + 
				"                    <XAD.3>TORONTO</XAD.3>\r\n" + 
				"                    <XAD.4>ON</XAD.4>\r\n" + 
				"                    <XAD.5>M6G 2T9</XAD.5>\r\n" + 
				"                </PID.11>\r\n" + 
				"                <PID.13>\r\n" + 
				"                    <XTN.1>(416)888-8888</XTN.1>\r\n" + 
				"                </PID.13>\r\n" + 
				"                <PID.19>1014071185</PID.19>\r\n" + 
				"            </PID>\r\n" + 
				"            <ORU_R01.VISIT>\r\n" + 
				"                <PV1>\r\n" + 
				"                    <PV1.1>1</PV1.1>\r\n" + 
				"                    <PV1.3>\r\n" + 
				"                        <PL.1>OLIS</PL.1>\r\n" + 
				"                    </PV1.3>\r\n" + 
				"                    <PV1.7>\r\n" + 
				"                        <XCN.1>OLIST</XCN.1>\r\n" + 
				"                        <XCN.2>BLAKE</XCN.2>\r\n" + 
				"                        <XCN.3>DONALD</XCN.3>\r\n" + 
				"                        <XCN.4>THOR</XCN.4>\r\n" + 
				"                        <XCN.9>\r\n" + 
				"                            <HD.1>921379</HD.1>\r\n" + 
				"                        </XCN.9>\r\n" + 
				"                        <XCN.13>OLIST</XCN.13>\r\n" + 
				"                    </PV1.7>\r\n" + 
				"                </PV1>\r\n" + 
				"            </ORU_R01.VISIT>\r\n" + 
				"        </ORU_R01.PATIENT>\r\n" + 
				"        <ORU_R01.ORDER_OBSERVATION>\r\n" + 
				"            <ORC>\r\n" + 
				"                <ORC.1>RE</ORC.1>\r\n" + 
				"                <ORC.3>\r\n" + 
				"                    <EI.1>T09-100442-RET-0</EI.1>\r\n" + 
				"                    <EI.3>OLIS_Site_ID</EI.3>\r\n" + 
				"                    <EI.4>ISO</EI.4>\r\n" + 
				"                </ORC.3>\r\n" + 
				"                <ORC.12>\r\n" + 
				"                    <XCN.1>OLIST</XCN.1>\r\n" + 
				"                    <XCN.2>BLAKE</XCN.2>\r\n" + 
				"                    <XCN.3>DONALD</XCN.3>\r\n" + 
				"                    <XCN.4>THOR</XCN.4>\r\n" + 
				"                    <XCN.8>L</XCN.8>\r\n" + 
				"                    <XCN.9>\r\n" + 
				"                        <HD.1>921379</HD.1>\r\n" + 
				"                    </XCN.9>\r\n" + 
				"                </ORC.12>\r\n" + 
				"            </ORC>\r\n" + 
				"            <OBR>\r\n" + 
				"                <OBR.1>0</OBR.1>\r\n" + 
				"                <OBR.3>\r\n" + 
				"                    <EI.1>T09-100442-RET-0</EI.1>\r\n" + 
				"                    <EI.3>OLIS_Site_ID</EI.3>\r\n" + 
				"                    <EI.4>ISO</EI.4>\r\n" + 
				"                </OBR.3>\r\n" + 
				"                <OBR.4>\r\n" + 
				"                    <CE.1>RET</CE.1>\r\n" + 
				"                    <CE.2>RETICULOCYTE COUNT</CE.2>\r\n" + 
				"                    <CE.3>HL79901 literal</CE.3>\r\n" + 
				"                </OBR.4>\r\n" + 
				"                <OBR.7>\r\n" + 
				"                    <TS.1>200905011106</TS.1>\r\n" + 
				"                </OBR.7>\r\n" + 
				"                <OBR.14>\r\n" + 
				"                    <TS.1>200905011106</TS.1>\r\n" + 
				"                </OBR.14>\r\n" + 
				"                <OBR.16>\r\n" + 
				"                    <XCN.1>OLIST</XCN.1>\r\n" + 
				"                    <XCN.2>BLAKE</XCN.2>\r\n" + 
				"                    <XCN.3>DONALD</XCN.3>\r\n" + 
				"                    <XCN.4>THOR</XCN.4>\r\n" + 
				"                    <XCN.8>L</XCN.8>\r\n" + 
				"                    <XCN.9>\r\n" + 
				"                        <HD.1>921379</HD.1>\r\n" + 
				"                    </XCN.9>\r\n" + 
				"                </OBR.16>\r\n" + 
				"                <OBR.18>7870279</OBR.18>\r\n" + 
				"                <OBR.19>7870279</OBR.19>\r\n" + 
				"                <OBR.20>T09-100442</OBR.20>\r\n" + 
				"                <OBR.21>MOHLTC</OBR.21>\r\n" + 
				"                <OBR.22>\r\n" + 
				"                    <TS.1>200905011130</TS.1>\r\n" + 
				"                </OBR.22>\r\n" + 
				"                <OBR.24>B7</OBR.24>\r\n" + 
				"                <OBR.25>F</OBR.25>\r\n" + 
				"                <OBR.27>\r\n" + 
				"                    <TQ.1>\r\n" + 
				"                        <CQ.1>1</CQ.1>\r\n" + 
				"                    </TQ.1>\r\n" + 
				"                    <TQ.4>\r\n" + 
				"                        <TS.1>200905011106</TS.1>\r\n" + 
				"                    </TQ.4>\r\n" + 
				"                    <TQ.6>R</TQ.6>\r\n" + 
				"                </OBR.27>\r\n" + 
				"            </OBR>\r\n" + 
				"            <ORU_R01.OBSERVATION>\r\n" + 
				"                <OBX>\r\n" + 
				"                    <OBX.1>1</OBX.1>\r\n" + 
				"                    <OBX.2>IS</OBX.2>\r\n" + 
				"                    <OBX.3>\r\n" + 
				"                        <CE.1>Z114099</CE.1>\r\n" + 
				"                        <CE.2>Erc</CE.2>\r\n" + 
				"                        <CE.3>L</CE.3>\r\n" + 
				"                    </OBX.3>\r\n" + 
				"                    <OBX.5>ABC</OBX.5>\r\n" + 
				"                    <OBX.11>F</OBX.11>\r\n" + 
				"                    <OBX.14>\r\n" + 
				"                        <TS.1>200905011111</TS.1>\r\n" + 
				"                    </OBX.14>\r\n" + 
				"                    <OBX.15>\r\n" + 
				"                        <CE.1>PMH</CE.1>\r\n" + 
				"                    </OBX.15>\r\n" + 
				"                </OBX>\r\n" + 
				"            </ORU_R01.OBSERVATION>\r\n" + 
				"            <ORU_R01.OBSERVATION>\r\n" + 
				"                <OBX>\r\n" + 
				"                    <OBX.1>1</OBX.1>\r\n" + 
				"                    <OBX.2>IS</OBX.2>\r\n" + 
				"                    <OBX.3>\r\n" + 
				"                        <CE.1>Z909090</CE.1>\r\n" + 
				"                        <CE.2>Erc</CE.2>\r\n" + 
				"                        <CE.3>L</CE.3>\r\n" + 
				"                    </OBX.3>\r\n" + 
				"                    <OBX.3>\r\n" + 
				"                        <CE.1>Z919191</CE.1>\r\n" + 
				"                        <CE.2>Erc</CE.2>\r\n" + 
				"                        <CE.3>L</CE.3>\r\n" + 
				"                    </OBX.3>\r\n" + 
				"                    <OBX.5>ABC</OBX.5>\r\n" + 
				"                    <OBX.11>F</OBX.11>\r\n" + 
				"                    <OBX.14>\r\n" + 
				"                        <TS.1>200905011111</TS.1>\r\n" + 
				"                    </OBX.14>\r\n" + 
				"                    <OBX.15>\r\n" + 
				"                        <CE.1>PMH</CE.1>\r\n" + 
				"                    </OBX.15>\r\n" + 
				"                </OBX>\r\n" + 
				"            </ORU_R01.OBSERVATION>\r\n" + 
				"        </ORU_R01.ORDER_OBSERVATION>\r\n" + 
				"    </ORU_R01.RESPONSE>\r\n" + 
				"</ORU_R01>";
	
        Hl7V2MessageXml msg = new Hl7V2MessageXml();
        msg.setSourceMessage(message);
        message = msg.getSourceMessage(); // in case message impl decides to reformat

        Range range = new Range(message.indexOf("Z919191"));
		msg.setHighlitedPathBasedOnRange(range);
		assertEquals("/RESPONSE/ORDER_OBSERVATION/OBSERVATION(2)/OBX-3(2)-1", msg.getHighlitedPath());
		
	}
	
}
