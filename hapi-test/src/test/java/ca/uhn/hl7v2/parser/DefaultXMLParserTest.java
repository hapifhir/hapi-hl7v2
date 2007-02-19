package ca.uhn.hl7v2.parser;

import ca.uhn.hl7v2.model.v25.message.ACK;
import ca.uhn.hl7v2.util.Terser;
import junit.framework.*;

import java.util.*;
import java.io.*;


import ca.uhn.hl7v2.*;
import ca.uhn.hl7v2.model.primitive.*;
import ca.uhn.hl7v2.model.v231.message.ADT_A01;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.v231.segment.*;
import ca.uhn.hl7v2.util.MessageIDGenerator;
import ca.uhn.hl7v2.model.v231.datatype.*;

import org.jdom.*;
import org.jdom.input.DOMBuilder;
import org.jdom.Namespace;

import org.jdom.input.*;
import org.jdom.output.*;
import org.jdom.xpath.*;


/**
 * JUnit test harness for DefaultXMLParser
 * @author  Bryan Tripp
 */
public class DefaultXMLParserTest extends TestCase {

    /** Creates a new instance of DefaultXMLParserTest */
    public DefaultXMLParserTest(String arg) {
        super(arg);
    }

//    public void testMakeGroupClassName() {
//        assertEquals("ADT_A01_INSURANCE", DefaultXMLParser.makeGroupClassName("ADT_A01.INSURANCE"));
//        assertEquals("ACK_INSURANCE", DefaultXMLParser.makeGroupClassName("ACK.INSURANCE"));        
//    }
    
    public void testMakeGroupElementName() {
        assertEquals("ADT_A01.INSURANCE", DefaultXMLParser.makeGroupElementName("ADT_A01", "INSURANCE"));
        assertEquals("ACK.INSURANCE", DefaultXMLParser.makeGroupElementName("ACK", "INSURANCE"));                
        assertEquals("ORU_R01.PATIENT_RESULT", 
                DefaultXMLParser.makeGroupElementName("ORU_R01", "PATIENT_RESULT"));
        assertEquals("ACK.PATIENT_RESULT", DefaultXMLParser.makeGroupElementName("ACK", "PATIENT_RESULT"));
    }
    
    public void testParse() throws Exception {
        Parser parser = new DefaultXMLParser();
        ACK ack = (ACK) parser.parse(getMessage1());
        assertEquals("AA", ack.getMSA().getAcknowledgmentCode().getValue());
    }
    
    public void testParseExtras() throws Exception {
        Parser parser = new DefaultXMLParser();
        ACK ack = (ACK) parser.parse(getMessage2());
        assertEquals("AA", ack.getMSA().getAcknowledgmentCode().getValue());
        Terser t = new Terser(ack);
        assertEquals("extra field", t.get("MSA-10"));
        assertEquals("1", t.get("PID-1"));
    }
    
    // test if the xml document has the right hl7.org default namespace
    public void testEncodeDocumentNamespace() throws HL7Exception, org.jdom.JDOMException, java.io.IOException {
        DefaultXMLParser parser = new DefaultXMLParser();
        ADT_A01 adtMessage = createADTMessage();

        org.w3c.dom.Document doc = parser.encodeDocument(adtMessage);
        DOMBuilder builder = new DOMBuilder();
        org.jdom.Document jdomdoc = builder.build(doc);

        // verify that the right default namespace is present
        assertEquals("urn:hl7-org:v2xml", jdomdoc.getRootElement().getNamespace().getURI());
    }

    // test if the characterset encoding is correct - by means of storing the xml in a file, read from file and verify content
    public void testEncodeDocumentEncoding() throws HL7Exception, org.jdom.JDOMException, java.io.IOException {
        DefaultXMLParser parser = new DefaultXMLParser();
        ADT_A01 adtMessage = createADTMessage();

        org.w3c.dom.Document doc = parser.encodeDocument(adtMessage);
        DOMBuilder builder = new DOMBuilder();
        org.jdom.Document jdomdoc = builder.build(doc);

        // output the xml document to a temporary file
        XMLOutputter outp = new XMLOutputter();
        outp.setTextTrim(true);
        outp.setIndent("  ");
        outp.setNewlines(true);
        File tmpfile = File.createTempFile("hapi_xml_test", null);
        tmpfile.deleteOnExit();
        FileOutputStream fos = new FileOutputStream(tmpfile);
        // store the xml message in a file - default encoding = utf-8
        outp.output(jdomdoc, fos);
        
        // read the temp file into an input stream
        FileInputStream fis = new FileInputStream(tmpfile);
        org.jdom.Document jdominputdoc = builder.build(fis);
        
        // verify that the patient name still contains the righ french characters
        org.jdom.Element nameNode= (org.jdom.Element)(XPath.selectSingleNode(jdominputdoc,"//PID.5/XPN.2"));
        assertEquals("Jérôme", nameNode.getText());
    }
    
    public void testEncodeDocumentStructure() throws HL7Exception, org.jdom.JDOMException, java.io.IOException {
        DefaultXMLParser parser = new DefaultXMLParser();
        ADT_A01 adtMessage = createADTMessage();

        org.w3c.dom.Document doc = parser.encodeDocument(adtMessage);
        DOMBuilder builder = new DOMBuilder();
        org.jdom.Document jdomdoc = builder.build(doc);

        // root element should be ADT_A01
        assertEquals("ADT_A01", jdomdoc.getRootElement().getName());
        
        // verify child nodes of ADT_A01
        java.util.List childNodes = jdomdoc.getRootElement().getChildren();
        org.jdom.Element childNode;
        childNode = (org.jdom.Element)childNodes.get(0);
        assertEquals("MSH", childNode.getName());
        childNode = (org.jdom.Element)childNodes.get(1);
        assertEquals("EVN", childNode.getName());
        childNode = (org.jdom.Element)childNodes.get(2);
        assertEquals("PID", childNode.getName());
        childNode = (org.jdom.Element)childNodes.get(3);
        assertEquals("PV1", childNode.getName());
        childNode = (org.jdom.Element)childNodes.get(4);
        assertEquals("OBX", childNode.getName());
        childNode = (org.jdom.Element)childNodes.get(5);
        assertEquals("OBX", childNode.getName());
        childNode = (org.jdom.Element)childNodes.get(6);
        assertEquals("OBX", childNode.getName());
        
        // insurance group - should be ADT_A01.IN1IN2IN3_SUPPGRP for a v2.3.1 message
        org.jdom.Element insuranceNode = (org.jdom.Element)childNodes.get(7);
        //assertEquals("ADT_A01.INSURANCE", insuranceNode.getName());
        //assertEquals("ADT_A01.IN1IN2IN3_SUPPGRP", insuranceNode.getName());
        assertEquals("ADT_A01.IN1IN2IN3", insuranceNode.getName());
        java.util.List insuranceChildNodes = insuranceNode.getChildren();
        childNode = (org.jdom.Element)insuranceChildNodes.get(0);
        assertEquals("IN1", childNode.getName());
        
        // verify repetitive fields - patient name
        org.jdom.Element name1Node= (org.jdom.Element)(XPath.selectSingleNode(jdomdoc,"//PID/PID.5[1]/XPN.1/FN.1"));
        assertEquals("De Vos", name1Node.getText());
        org.jdom.Element name2Node= (org.jdom.Element)(XPath.selectSingleNode(jdomdoc,"//PID/PID.5[2]/XPN.1/FN.1"));
        assertEquals("Albers", name2Node.getText());
        
        // empty fields should not be present
        org.jdom.Element alternatePatientIDNode= (org.jdom.Element)(XPath.selectSingleNode(jdomdoc,"//PID/PID.4"));
        assertNull("Empty node present in xml", alternatePatientIDNode);
        
    }

    // test if all text formatting escape sequences are tranlated properly
    public void testEncodeDocumentEscapechars() throws HL7Exception, org.jdom.JDOMException, java.io.IOException {
        DefaultXMLParser parser = new DefaultXMLParser();
        ADT_A01 adtMessage = createADTMessage();

        org.w3c.dom.Document doc = parser.encodeDocument(adtMessage);
        DOMBuilder builder = new DOMBuilder();
        org.jdom.Document jdomdoc = builder.build(doc);
        
        org.jdom.Element remarkNode= (org.jdom.Element)(XPath.selectSingleNode(jdomdoc,"//OBX[3]/OBX.5"));
        
        XMLOutputter outp = new XMLOutputter();
        outp.setTextTrim(false);
        outp.setIndent("");
        outp.setNewlines(false);
        
        StringBuffer sbExpectedResult = new StringBuffer("<OBX.5>");
        sbExpectedResult.append("start highlighting <escape V=\"H\"/>here<escape V=\"N\"/> normal again");
        sbExpectedResult.append("<escape V=\".br\"/>start at new line");
        sbExpectedResult.append("<escape V=\".br\"/>skip 5 vertical spaces<escape V=\".sp5\"/> ");
        sbExpectedResult.append("and indent 10 spaces<escape V=\".in+10\"/> ");
        sbExpectedResult.append("and temporary indent 1 space<escape V=\".ti+1\"/> here");
        sbExpectedResult.append("<escape V=\".br\"/>end of remark");
        sbExpectedResult.append("</OBX.5>");
        
        String expected = sbExpectedResult.toString();
        String actual = outp.outputString(remarkNode);
        assertEquals(expected, actual);

    } 
    
    private ADT_A01 createADTMessage() throws DataTypeException, HL7Exception, java.io.IOException
    {
        ADT_A01 adtA01Message = new ADT_A01();
        // MSH segment
        createMSH("ADT", "A08", "ADT_A01", adtA01Message.getMSH());

        // EVN segment
        EVN segEVN;
        segEVN = adtA01Message.getEVN();
        segEVN.getEventOccurred().getTimeOfAnEvent().setValue(adtA01Message.getMSH().getDateTimeOfMessage().getTimeOfAnEvent().getValue());
        segEVN.getRecordedDateTime().getTimeOfAnEvent().setValue(adtA01Message.getMSH().getDateTimeOfMessage().getTimeOfAnEvent().getValue());
        segEVN.getEventTypeCode().setValue(adtA01Message.getMSH().getMessageType().getTriggerEvent().getValue());
        segEVN.getOperatorID(0).getIDNumber().setValue("nico");
        
        // PID segment
        createPID(adtA01Message.getPID());
        
        // PV1 segment
        PV1 segPV1;
        segPV1 = adtA01Message.getPV1();
        segPV1.getPatientClass().setValue("I");
        segPV1.getVisitNumber().getID().setValue("v123456");
        
        // OBX for weight
        OBX segOBXWeight;
        segOBXWeight = adtA01Message.getOBX(0);
        segOBXWeight.getSetIDOBX().setValue("1");
        segOBXWeight.getValueType().setValue("ST");
        segOBXWeight.getObservationIdentifier().getIdentifier().setValue("WEIGHT");
        segOBXWeight.getObservationIdentifier().getText().setValue("Weight");
        ST weightData = new ST(null);
        weightData.setValue("79");
        segOBXWeight.getObservationValue(0).setData(weightData);

        // length
        OBX segOBXLength;
        segOBXLength = adtA01Message.getOBX(1);
        segOBXLength.getSetIDOBX().setValue("2");
        segOBXLength.getValueType().setValue("ST");
        segOBXLength.getObservationIdentifier().getIdentifier().setValue("LENGTH");
        segOBXLength.getObservationIdentifier().getText().setValue("Length");
        ST lengthData = new ST(null);
        lengthData.setValue("180");
        segOBXLength.getObservationValue(0).setData(lengthData);
        
        // formatting test
        OBX segOBXRemark;
        segOBXRemark = adtA01Message.getOBX(2);
        segOBXRemark.getSetIDOBX().setValue("3");
        segOBXRemark.getValueType().setValue("FT");
        segOBXRemark.getObservationIdentifier().getIdentifier().setValue("REMARK");
        segOBXRemark.getObservationIdentifier().getText().setValue("Remark");
        FT remarkData = new FT(null);
        StringBuffer sbValue = new StringBuffer("start highlighting \\H\\here\\N\\ normal again");
        sbValue.append("\\.br\\start at new line\\.br\\");
        sbValue.append("skip 5 vertical spaces\\.sp5\\");
        sbValue.append(" and indent 10 spaces\\.in+10\\");
        sbValue.append(" and temporary indent 1 space\\.ti+1\\ here\\.br\\end of remark");
        remarkData.setValue(sbValue.toString());
        segOBXRemark.getObservationValue(0).setData(remarkData);
        
        // insurance data
        IN1 segIN1;
        segIN1 = adtA01Message.getIN1IN2IN3(0).getIN1();
        segIN1.getSetIDIN1().setValue("1");
        segIN1.getPlanType().setValue("2");
        segIN1.getInsuranceCompanyID(0).getID().setValue("310");
        segIN1.getInsuranceCompanyName(0).getIDNumber().setValue("310");
        segIN1.getInsuranceCompanyName(0).getOrganizationName().setValue("CM Tielt");
        
        return adtA01Message;
    }

    private boolean createMSH(String sMessageType, String sTriggerEvent, 
        String sMessageStructure, MSH segMSH)  throws DataTypeException, HL7Exception, java.io.IOException
    {
        segMSH.getFieldSeparator().setValue("|");
        segMSH.getEncodingCharacters().setValue("^~\\&");
        segMSH.getSendingApplication().getNamespaceID().setValue("CARE2X");
        segMSH.getReceivingApplication().getNamespaceID().setValue("RIS");
        segMSH.getProcessingID().getProcessingID().setValue("P");
        segMSH.getMessageType().getMessageType().setValue(sMessageType);
        segMSH.getMessageType().getTriggerEvent().setValue(sTriggerEvent);
        segMSH.getMessageType().getMessageStructure().setValue(sMessageStructure);
        GregorianCalendar now = new GregorianCalendar();
        now.setTime(new Date());
        segMSH.getDateTimeOfMessage().getTimeOfAnEvent().setValue(CommonTS.toHl7TSFormat(now));
        segMSH.getVersionID().getVersionID().setValue("2.3.1");
        segMSH.getCharacterSet(0).setValue("8859/1");
        segMSH.getMessageControlID().setValue(MessageIDGenerator.getInstance().getNewID());
        
         return true;
    }
    
    private boolean createPID(PID segPID) throws DataTypeException, HL7Exception
    {
        // patient identifiers
        int iNumberOfIds;
        iNumberOfIds = segPID.getPatientIdentifierList().length;
        segPID.getPatientIdentifierList(iNumberOfIds).getID().setValue("123456789");
        segPID.getPatientIdentifierList(iNumberOfIds).getAssigningAuthority().getNamespaceID().setValue("CARE2X");
            
        // legal name
        segPID.getPatientName(0).getFamilyLastName().getFamilyName().setValue("De Vos");
        segPID.getPatientName(0).getGivenName().setValue("Jérôme");
        segPID.getPatientName(0).getPrefixEgDR().setValue("Mr.");
        segPID.getPatientName(0).getMiddleInitialOrName().setValue("");
        segPID.getPatientName(0).getNameTypeCode().setValue("L");
            
        int iNameCounter;
        iNameCounter = segPID.getPatientName().length;
        segPID.getPatientName(iNameCounter).getFamilyLastName().getFamilyName().setValue("Albers");
        segPID.getPatientName(iNameCounter).getGivenName().setValue("Céline");
        segPID.getPatientName(iNameCounter).getNameTypeCode().setValue("M");

        segPID.getDateTimeOfBirth().getTimeOfAnEvent().setValue("19740612");

        segPID.getSex().setValue("F");
        segPID.getPatientAddress(0).getStreetAddress().setValue("Homestreet 10");
        segPID.getPatientAddress(0).getZipOrPostalCode().setValue("9000");
        segPID.getPatientAddress(0).getCity().setValue("Gent");
        segPID.getPatientAddress(0).getCountry().setValue("150");
        segPID.getPatientAddress(0).getAddressType().setValue("P");

        // disable phone number validation in HAPI
        System.setProperty("ca.uhn.hl7v2.model.primitive.CommonTN.validate", "false");
        segPID.getPhoneNumberHome(0).get9999999X99999CAnyText().setValue("092001234");
        segPID.getSSNNumberPatient().setValue("197412061025");
        segPID.getPhoneNumberHome(0).getEmailAddress().setValue("nicovn@users.sourceforge.net");
        segPID.getMaritalStatus().getIdentifier().setValue("M");
        segPID.getMaritalStatus().getText().setValue("Married");
        
        return true;
    }    
    

    
    public String getMessage1() {
        return "<?xml version=\"1.0\"?>"
               + " <ACK "
               + "  xmlns=\"urn:hl7-org:v2xml\">"
               + "     <MSH>"
               + "         <MSH.1>|</MSH.1>"
               + "         <MSH.2>^~\\&amp;</MSH.2>"
               + "         <MSH.7>"
               + "             <TS.1>20050621103250.424-0500</TS.1>"
               + "         </MSH.7>"
               + "         <MSH.9>"
               + "             <MSG.1>ACK</MSG.1>"
               + "         </MSH.9>"
               + "         <MSH.10>1</MSH.10>"
               + "         <MSH.11>"
               + "             <PT.1>P</PT.1>"
               + "         </MSH.11>"
               + "         <MSH.12>"
               + "             <VID.1>2.5</VID.1>"
               + "         </MSH.12>"
               + "     </MSH>"
               + "     <MSA>"
               + "         <MSA.1>AA</MSA.1>"
               + "         <MSA.2>100</MSA.2>"
               + "     </MSA>"
               + " </ACK>";
    }
    
    public String getMessage2() {
        return "<?xml version=\"1.0\"?>"
               + " <ACK "
               + "  xmlns=\"urn:hl7-org:v2xml\">"
               + "     <MSH>"
               + "         <MSH.1>|</MSH.1>"
               + "         <MSH.2>^~\\&amp;</MSH.2>"
               + "         <MSH.7>"
               + "             <TS.1>20050621103250.424-0500</TS.1>"
               + "         </MSH.7>"
               + "         <MSH.9>"
               + "             <MSG.1>ACK</MSG.1>"
               + "         </MSH.9>"
               + "         <MSH.10>1</MSH.10>"
               + "         <MSH.11>"
               + "             <PT.1>P</PT.1>"
               + "         </MSH.11>"
               + "         <MSH.12>"
               + "             <VID.1>2.5</VID.1>"
               + "         </MSH.12>"
               + "     </MSH>"
               + "     <MSA>"
               + "         <MSA.1>AA</MSA.1>"
               + "         <MSA.2>100</MSA.2>"
               + "         <MSA.10>extra field</MSA.10>"
               + "     </MSA>"
               + "     <PID>"
               + "         <PID.1>1</PID.1>"
               + "     </PID>"
               + " </ACK>";
    }
}
