/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "CreateAMessage.java".  Description:
 * "Example Code"
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2001.  All Rights Reserved.
 *
 * Contributor(s): James Agnew
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  �GPL�), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 *
 */
package ca.uhn.hl7v2.examples;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.v24.message.ADT_A01;
import ca.uhn.hl7v2.model.v24.segment.MSH;
import ca.uhn.hl7v2.model.v24.segment.PID;
import ca.uhn.hl7v2.parser.Parser;

/**
 * Example transmitting a message
 * 
 * @author <a href="mailto:jamesagnew@sourceforge.net">James Agnew</a>
 * @version $Revision: 1.4 $ updated on $Date: 2009-10-03 15:29:05 $ by $Author: jamesagnew $
 */
public class CreateAMessage
{

    /**
     * @param args
     * @throws HL7Exception 
     */
    public static void main(String[] args) throws Exception {
        
        ADT_A01 adt = new ADT_A01();
        adt.initQuickstart("ADT", "A01", "P");
        
        // Populate the MSH Segment
        MSH mshSegment = adt.getMSH();
        mshSegment.getSendingApplication().getNamespaceID().setValue("TestSendingSystem");
        mshSegment.getSequenceNumber().setValue("123");
        
        // Populate the PID Segment
        PID pid = adt.getPID(); 
        pid.getPatientName(0).getFamilyName().getSurname().setValue("Doe");
        pid.getPatientName(0).getGivenName().setValue("John");
        pid.getPatientIdentifierList(0).getID().setValue("123456");

        /*
         * In a real situation, of course, many more segments and fields would be populated
         */
        
        // Now, let's encode the message and look at the output
        HapiContext context = new DefaultHapiContext();
        Parser parser = context.getPipeParser();
        String encodedMessage = parser.encode(adt);
        System.out.println("Printing ER7 Encoded Message:");
        System.out.println(encodedMessage);
        
        /*
         * Prints:
         * 
         * MSH|^~\&|TestSendingSystem||||200701011539||ADT^A01^ADT A01||||123
         * PID|||123456||Doe^John
         */

        // Next, let's use the XML parser to encode as XML
        parser = context.getXMLParser();
        encodedMessage = parser.encode(adt);
        System.out.println("Printing XML Encoded Message:");
        System.out.println(encodedMessage);
        
        /*
         * Prints:
         * 
         * <?xml version="1.0" encoding="UTF-8"?>
			<ADT_A01 xmlns="urn:hl7-org:v2xml">
			    <MSH>
			        <MSH.1>|</MSH.1>
			        <MSH.2>^~\&amp;</MSH.2>
			        <MSH.3>
			            <HD.1>TestSendingSystem</HD.1>
			        </MSH.3>
			        <MSH.7>
			            <TS.1>200701011539</TS.1>
			        </MSH.7>
			        <MSH.9>
			            <MSG.1>ADT</MSG.1>
			            <MSG.2>A01</MSG.2>
			            <MSG.3>ADT A01</MSG.3>
			        </MSH.9>
			        <MSH.13>123</MSH.13>
			    </MSH>
			    <PID>
			        <PID.3>
			            <CX.1>123456</CX.1>
			        </PID.3>
			        <PID.5>
			            <XPN.1>
			                <FN.1>Doe</FN.1>
			            </XPN.1>
			            <XPN.2>John</XPN.2>
			        </PID.5>
			    </PID>
			</ADT_A01>
         */

    }

}
