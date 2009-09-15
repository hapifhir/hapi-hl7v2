/*
 * XMLParserTest.java
 *
 * Created on March 15, 2002, 12:53 PM
 */

package ca.uhn.hl7v2.parser.tests;

import static org.ops4j.pax.exam.CoreOptions.equinox;
import static org.ops4j.pax.exam.CoreOptions.felix;
import static org.ops4j.pax.exam.CoreOptions.frameworks;
import static org.ops4j.pax.exam.CoreOptions.knopflerfish;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.options;
import static org.ops4j.pax.exam.CoreOptions.systemProperty;
import static org.ops4j.pax.exam.CoreOptions.wrappedBundle;
import static org.ops4j.pax.exam.container.def.PaxRunnerOptions.logProfile;
import static org.junit.Assert.*;
import java.io.IOException;
import java.io.InputStream;


import ca.uhn.hl7v2.HL7Exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Inject;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.osgi.framework.BundleContext;
import org.w3c.dom.Document;

import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.parser.DefaultXMLParser;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.parser.XMLParser;
 
/**
 * JUnit test harness for XMLParser
 * @author Bryan Tripp
* @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 */

@RunWith(JUnit4TestRunner.class)
public class XMLParserTest {

 // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(XMLParserTest.class);
    
    @Inject
    BundleContext bundleContext;
    
    @Configuration
    public static Option[] configure() {
	return options(frameworks(equinox(), felix(), knopflerfish())
		, logProfile()
		, systemProperty("org.ops4j.pax.logging.DefaultServiceLog.level").value("INFO")
		, mavenBundle().groupId("org.ops4j.pax.url").artifactId("pax-url-mvn").version("0.4.0")
		, wrappedBundle(mavenBundle().groupId("org.ops4j.base").artifactId("ops4j-base-util").version("0.5.3"))
		, mavenBundle().groupId("ca.uhn.hapi").artifactId("hapi-osgi-base").version("1.0-beta1")
//		, vmOption("-Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5006" )


	);
    }    
    
    
    XMLParser parser;
    
    /** Creates a new instance of XMLParserTest 
     * @throws HL7Exception */
    @Before
    public void BeforeTheTest() throws HL7Exception {
	parser = new DummyXMLParser();
    }
   

    /**
     * Tests a fix to bug 2164291
     * 
     * XML parsing of segments which appear twice in a message structure definition (e.g. the
     * duplicate PID segments in a swap patient message) should be handled correctly.
     */
    @Test
    public void testParseDuplicateSegment() throws IOException, EncodingNotSupportedException, HL7Exception {
    	InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("ca/uhn/hl7v2/parser/tests/adt_a17.xml");
    	byte[] bytes = new byte[10000];
    	StringBuffer buffer = new StringBuffer();
    	int count;
    	while ((count = stream.read(bytes)) > 0) {
    		buffer.append(new String(bytes), 0, count);
    	}
    	
    	String xmlMessage = buffer.toString();
    	Message message = new DefaultXMLParser().parse(xmlMessage);
    	
    	String er7Message = new PipeParser().encode(message).replaceAll("\\r", "\r\n");

    	System.out.println("Re-encoded:\r\n" + er7Message);
    	
    	// We should have only two reps of PID
    	int firstIndex = er7Message.indexOf("PID");
    	int secondIndex = er7Message.indexOf("PID", firstIndex + 1);
    	int thirdIndex = er7Message.indexOf("PID", secondIndex + 1);
    	assertTrue(firstIndex > 0);
    	assertTrue(secondIndex > firstIndex);
    	assertTrue("Found third PID " + firstIndex + " " + secondIndex + " " + thirdIndex + ":\r\n" + er7Message, thirdIndex == -1);
    	
    }
    
    @Test
    public void testGetAckID() throws HL7Exception {
        assertEquals(parser.getAckID("<MSA.2>12</MSA.2>"), "12");
        assertEquals(parser.getAckID("<thing<foo> help >>><msa.2> *** </i forget"), "***");
        String ackID = parser.getAckID("<there is no msa.2>x</msa.2>");
        assertEquals(null, ackID);
        ackID = parser.getAckID("<msa.2>x");
        assertEquals(null, ackID);
        ackID = parser.getAckID("<MSA.2>   12   \r</MSA.2>");
        assertEquals("12", ackID);
        ackID = parser.getAckID("<?xml version=\"1.0\" standalone=\"no\"?><!DOCTYPE RSP_K22 SYSTEM \"http://localhost/DTDs/Q22Response.dtd\"><RSP_K22><MSH><MSH.1>|</MSH.1><MSH.2>^~/&amp;</MSH.2><MSH.3><HD.1>MPI</HD.1><HD.3>ISO</HD.3></MSH.3><MSH.4><HD.1>HealthLink</HD.1><HD.3>ISO</HD.3></MSH.4><MSH.5><HD.1>UHN Vista</HD.1><HD.3>ISO</HD.3></MSH.5><MSH.6><HD.1>UHN</HD.1><HD.3>ISO</HD.3></MSH.6><MSH.7>200204292049</MSH.7><MSH.9><CM_MSG_TYPE.1>RSP</CM_MSG_TYPE.1><CM_MSG_TYPE.2>K22</CM_MSG_TYPE.2><CM_MSG_TYPE.3>RSP_K22</CM_MSG_TYPE.3></MSH.9><MSH.10>200204292049100799</MSH.10><MSH.11><PT.1>P</PT.1></MSH.11><MSH.12><VID.1>2.4</VID.1></MSH.12><MSH.21>Q22</MSH.21></MSH><MSA><MSA.1>AA</MSA.1><MSA.2>876</MSA.2></MSA><QAK><QAK.2>OK</QAK.2><QAK.3><CE.1>Q22</CE.1><CE.2>");
        assertEquals("876", ackID);
    }
    
 @Test
    public void testGetEncoding() throws Exception {
        String test1 = "<MSH>\r<MSH.1>|</MSH.1>\r<MSH.2>^~\\&amp;</MSH.2>\r</MSH>";
        String test2 = "<MSH>\r<MSH.1>|</MSH.1>\r<MSH.2>^~\\&amp;</MSH.2>\r";  //bad: no </MSH>
        assertEquals("XML", parser.getEncoding(test1));
        assertEquals(null, parser.getEncoding(test2));
    }
    
    /*public void testParse() throws Exception {
        String test1 = "<MSH>\r<MSH.1>|</MSH.1>\r<MSH.2>^~\\&amp;</MSH.2>\r</MSH>";
        Message m = parser.parse(test1);
        assertEquals(null, m);
    }*/
    
 @Test
    public void testGetVersion() throws Exception {
        String message = "<?xml version=\"1.0\"?> <!DOCTYPE QBP_Q22 SYSTEM \"http://142.224.24.144/QueryServices/xmlDtds/Q22Query.dtd\"> <!--Generated by XML Authority--><QBP_Q22>  <MSH>   <MSH.1>|</MSH.1>   <MSH.2>^~/&amp;</MSH.2>   <MSH.3>    <HD.1>UHN Vista</HD.1>    <HD.3>ISO</HD.3>   </MSH.3>   <MSH.4>    <HD.1>UHN</HD.1>    <HD.3>ISO</HD.3>   </MSH.4>   <MSH.5>    <HD.1>MPI</HD.1>    <HD.3>ISO</HD.3>   </MSH.5>   <MSH.6>    <HD.1>HealthLink</HD.1>    <HD.3>ISO</HD.3>   </MSH.6>   <MSH.7>20020429132718.734-0400</MSH.7>   <MSH.9>    <CM_MSG_TYPE.1>QBP</CM_MSG_TYPE.1>    <CM_MSG_TYPE.2>Q22</CM_MSG_TYPE.2>  <CM_MSG_TYPE.3>QBP_Q21</CM_MSG_TYPE.3>   </MSH.9>   <MSH.10>855</MSH.10>   <MSH.11>    <PT.1>P</PT.1>   </MSH.11>   <MSH.12>    <VID.1>2.4</VID.1>      </MSH.12>   <MSH.21>Q22</MSH.21>  </MSH>  <QPD>   <QPD.1>    <CE.1>Q22</CE.1>    <CE.2>Find Candidates</CE.2>    <CE.3>HL7nnnn</CE.3>   </QPD.1>   <QPD.3><QIP><QIP.1>@PID.3.1</QIP.1><QIP.2>9583518684</QIP.2></QIP><QIP><QIP.1>@PID.3.4.1</QIP.1><QIP.2>CANON</QIP.2></QIP><QIP><QIP.1>@PID.5.1.1</QIP.1><QIP.2>ECG-Acharya</QIP.2></QIP><QIP><QIP.1>@PID.5.2</QIP.1><QIP.2>Nf</QIP.2></QIP><QIP><QIP.1>@PID.5.7</QIP.1><QIP.2>L</QIP.2></QIP><QIP><QIP.1>@PID.7</QIP.1><QIP.2>197104010000</QIP.2></QIP><QIP><QIP.1>@PID.8</QIP.1><QIP.2>M</QIP.2></QIP></QPD.3>   <QPD.4>100</QPD.4>   <QPD.8><CX.4><HD.1>TTH</HD.1></CX.4></QPD.8>  <QPD.9>13831</QPD.9><QPD.10>ULTIuser2</QPD.10><QPD.11>234564</QPD.11><QPD.12>R&amp;H Med</QPD.12></QPD>  <RCP>   <RCP.1>I</RCP.1>   <RCP.2><CQ.1>100</CQ.1><CQ.2>RD</CQ.2></RCP.2>   <RCP.3>   <CE.1>R</CE.1>   </RCP.3>  </RCP> </QBP_Q22>";
        String ver = parser.getVersion(message);
        assertEquals("2.4", ver);
    }
    

//    public void testRemoveWhitespace() throws Exception {
//        assertEquals("hello", parser.removeWhitespace("\t\r\nhello "));
//        assertEquals("hello there", parser.removeWhitespace(" hello \t \rthere\r\n"));
//    }
    
    /**
     * -
     * @throws HL7Exception -
     */
 @Test
    public void testGetCriticalResponseData() throws HL7Exception {
        
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
                "    </MSH>";
        
        Segment data = parser.getCriticalResponseData(message);
        
        Type actual = data.getField(2, 0);
        String expected = "^~\\&";
        assertEquals(expected, actual.toString()); // Encoding
        
    }
    
      
 
    public class DummyXMLParser extends XMLParser {
        public DummyXMLParser() throws HL7Exception { 
            super();
        }
        
        public Message parseDocument(Document XMLMessage, String version) throws HL7Exception {
            return null;
        }
        
        public Document encodeDocument(Message source) throws HL7Exception {
            return null;
        }        
        
    }

}
