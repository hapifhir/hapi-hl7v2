/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "EncapsulatedData.java".  Description:
 * "Example Code"
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2001.  All Rights Reserved.
 *
 * Contributor(s): Alessandro Delprete
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

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.v231.datatype.ED;
import ca.uhn.hl7v2.model.v231.message.MDM_T02;
import ca.uhn.hl7v2.model.v231.segment.OBX;
import ca.uhn.hl7v2.parser.PipeParser;

public class EncapsulatedData {

	public static void main(String[] args) throws MessagingException, IOException, HL7Exception {

		/*
		 * In this example, a CDA r2 document is being embedded as mime content
		 * in an MDM_T02 message.
		 */
		
		MDM_T02 mdmMessage = new MDM_T02();
		
		// A few basic MSH fields are populated. In a real situation, this would not be enough
        // to produce a valid message, but for demonstration purposes we'll skip a few
        // fields.
		mdmMessage.initQuickstart("MDM", "T02", "P");

        OBX obx = mdmMessage.getOBX();
		
        // This is not a complete CDA document, but it serves as a good example
        String sampleClinicalDocument = "<ClinicalDocument xsi:schemaLocation=\"urn:hl7-org:v3 CDA.ReleaseTwo.CommitteeBallot03.Aug.2004.xsd\" templateId=\"2.16.840.1.113883.3.27.1776\">\r\n" + 
        		"   <id extension=\"c266\" root=\"2.16.840.1.113883.3.933\"/>\r\n" + 
        		"   <code code=\"11488-4\" codeSystem=\"2.16.840.1.113883.6.1\" displayName=\"Consultation note\"/>\r\n" + 
        		"   <title>Good Health Clinic Consultation Note</title>\r\n" + 
        		"   <effectiveTime value=\"20000407\"/>\r\n" + 
        		"</ClinicalDocument>";
        

		MimeMultipart mimeMessage = new MimeMultipart();
		MimeBodyPart bodyPart = new MimeBodyPart();
		bodyPart.setText(sampleClinicalDocument);
		mimeMessage.addBodyPart(bodyPart);
		
		// send the MIME message into a ByteArrayOutputStream
		ByteArrayOutputStream byte1 = new ByteArrayOutputStream();
		mimeMessage.writeTo(byte1);

		// set the value of ED with the String
		ED encapsuledData = new ED(mdmMessage);

		encapsuledData.getTypeOfData().setValue("multipart");
		encapsuledData.getDataSubtype().setValue("x-hl7-cda-level-one");
		encapsuledData.getEncoding().setValue("A");
		
		encapsuledData.getData().setValue( byte1.toString() );

		// setting the data in the OBX segment
		obx.getObservationIdentifier().getIdentifier().setValue("1");
		obx.getValueType().setValue("CE");
		obx.getObservationValue(0).setData(encapsuledData);
		
		// Print the message out
		System.out.println(new PipeParser().encode(mdmMessage));
		
		/*
			The following output is produced. Note that the newlines are unix newlines (\n)
			and not (\r), so they are OK to use within a segment.

			MSH|^~\&
			OBX||CE|1||^multipart^x-hl7-cda-level-one^A^------=_Part_0_605645.1247937122564\X000d\
			\X000d\
			<ClinicalDocument xsi:schemaLocation="urn:hl7-org:v3 CDA.ReleaseTwo.CommitteeBallot03.Aug.2004.xsd" templateId="2.16.840.1.113883.3.27.1776">\X000d\
			   <id extension="c266" root="2.16.840.1.113883.3.933"/>\X000d\
			   <code code="11488-4" codeSystem="2.16.840.1.113883.6.1" displayName="Consultation note"/>\X000d\
			   <title>Good Health Clinic Consultation Note</title>\X000d\
			   <effectiveTime value="20000407"/>\X000d\
			</ClinicalDocument>\X000d\
			------=_Part_0_605645.1247937122564--\X000d\
		
		 */
	}
	
}
