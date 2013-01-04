package ca.uhn.hl7v2.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit test cases for EncodedMessageComparator
 * @author bryan
 */
public class EncodedMessageComparatorTest {
    
    @Test
    public void testStandardizeER7() {
        String nonStandard = "MSH|^~\\&|Fake Sending App~&&^^^~~~|Fake Sending Facility||Fake Receiving Facility|200108151718||ACK^A01&&^ACK~|20|P|2.4|||||||||&&&&|&|~|~~~&&\n\n\nMSA|AA\r\n";
        String standard = "MSH|^~\\&|Fake Sending App|Fake Sending Facility||Fake Receiving Facility|200108151718||ACK^A01^ACK|20|P|2.4\rMSA|AA\r";
        
        String result = EncodedMessageComparator.standardizeER7(nonStandard);
        assertEquals(standard, result);
    }
    
    @Test
    public void testStandardizeXML() throws Exception {
        String nonStandard = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ACK>\r\n    <!-- comment -->    <MSH >\n   <?foo data='bar'?>       <MSH.1>|</MSH.1   >\n\n\n        <MSH.2>^~\\&amp;</MSH.2>\n        <MSH.3>\n            <HD.1>Fake Sending App</HD.1>\n        </MSH.3>\n        <MSH.4>\n            <HD.1>Fake Sending Facility</HD.1>\n        </MSH.4>\n        <MSH.6>\n            <HD.1>Fake Receiving Facility</HD.1>\n        </MSH.6>\n        <MSH.7>\n            <TS.1 Type='ST' LongName='time of an event' >200108151718-0500</TS.1>\n        </MSH.7>\n        <MSH.9>\n            <CM_MSG.1>ACK</CM_MSG.1>\n            <CM_MSG.2>A01</CM_MSG.2>\n            <CM_MSG.3>ACK</CM_MSG.3>\n        </MSH.9>\n        <MSH.10>20</MSH.10>\n        <MSH.11>\n            <PT.1>P</PT.1>\n        </MSH.11>\n        <MSH.12>\n            <VID.1>2.4</VID.1>\n        </MSH.12>\n    </MSH>\n    <MSA>\n        <MSA.1>AA</MSA.1>\n    </MSA>\n</ACK>\n";
        String standard = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ACK>\n    <MSH>\n        <MSH.1>|</MSH.1>\n        <MSH.2>^~\\&amp;</MSH.2>\n        <MSH.3>\n            <HD.1>Fake Sending App</HD.1>\n        </MSH.3>\n        <MSH.4>\n            <HD.1>Fake Sending Facility</HD.1>\n        </MSH.4>\n        <MSH.6>\n            <HD.1>Fake Receiving Facility</HD.1>\n        </MSH.6>\n        <MSH.7>\n            <TS.1>200108151718-0500</TS.1>\n        </MSH.7>\n        <MSH.9>\n            <CM_MSG.1>ACK</CM_MSG.1>\n            <CM_MSG.2>A01</CM_MSG.2>\n            <CM_MSG.3>ACK</CM_MSG.3>\n        </MSH.9>\n        <MSH.10>20</MSH.10>\n        <MSH.11>\n            <PT.1>P</PT.1>\n        </MSH.11>\n        <MSH.12>\n            <VID.1>2.4</VID.1>\n        </MSH.12>\n    </MSH>\n    <MSA>\n        <MSA.1>AA</MSA.1>\n    </MSA>\n</ACK>\n";
        String result = EncodedMessageComparator.standardizeXML(nonStandard);
        assertEquals(standard, result);
    }
    
    @Test
    public void testEquivalent() throws Exception {
        //should all be equivalent
        String ER7A = "MSH|^~\\&|Fake Sending App~&&^^^~~~|Fake Sending Facility||Fake Receiving Facility|200108151718||ACK^A01&&^ACK~|20|P|2.4|||||||||&&&&|&|~|~~~&&\n\n\nMSA|AA\r\n";
        String ER7B = "MSH|^~\\&|Fake Sending App|Fake Sending Facility||Fake Receiving Facility|200108151718||ACK^A01^ACK|20|P|2.4\nMSA|AA\n";
        String XMLA = "<?xml version=\"1.0\"?>\n<ACK xmlns=\"urn:hl7-org:v2xml\">\r\n        <MSH>\n          <MSH.1>|</MSH.1   >\n\n\n        <MSH.2>^~\\&amp;</MSH.2>\n        <MSH.3>\n            <HD.1>Fake Sending App</HD.1>\n        </MSH.3>\n        <MSH.4>\n            <HD.1>Fake Sending Facility</HD.1>\n        </MSH.4>\n        <MSH.6>\n            <HD.1>Fake Receiving Facility</HD.1>\n        </MSH.6>\n        <MSH.7>\n            <TS.1>200108151718</TS.1>\n        </MSH.7>\n        <MSH.9>\n            <CM_MSG.1>ACK</CM_MSG.1>\n            <CM_MSG.2>A01</CM_MSG.2>\n            <CM_MSG.3>ACK</CM_MSG.3>\n        </MSH.9>\n        <MSH.10>20</MSH.10>\n        <MSH.11>\n            <PT.1>P</PT.1>\n        </MSH.11>\n        <MSH.12>\n            <VID.1>2.4</VID.1>\n        </MSH.12>\n    </MSH>\n    <MSA>\n        <MSA.1>AA</MSA.1>\n    </MSA>\n</ACK>\n";
        String XMLB = "<?xml version=\"1.0\"?>\n<ACK xmlns=\"urn:hl7-org:v2xml\">\n    <MSH>\n        <MSH.1>|</MSH.1>\n        <MSH.2>^~\\&amp;</MSH.2>\n        <MSH.3>\n            <HD.1>Fake Sending App</HD.1>\n        </MSH.3>\n        <MSH.4>\n            <HD.1>Fake Sending Facility</HD.1>\n        </MSH.4>\n        <MSH.6>\n            <HD.1>Fake Receiving Facility</HD.1>\n        </MSH.6>\n        <MSH.7>\n            <TS.1>200108151718</TS.1>\n        </MSH.7>\n        <MSH.9>\n            <CM_MSG.1>ACK</CM_MSG.1>\n            <CM_MSG.2>A01</CM_MSG.2>\n            <CM_MSG.3>ACK</CM_MSG.3>\n        </MSH.9>\n        <MSH.10>20</MSH.10>\n        <MSH.11>\n            <PT.1>P</PT.1>\n        </MSH.11>\n        <MSH.12>\n            <VID.1>2.4</VID.1>\n        </MSH.12>\n    </MSH>\n    <MSA>\n        <MSA.1>AA</MSA.1>\n    </MSA>\n</ACK>\n";
        String XMLC = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<ACK xmlns=\"urn:hl7-org:v2xml\">\r\n<MSH>\r\n<MSH.1>|</MSH.1>\r\n<MSH.2>^~\\&amp;</MSH.2>\r\n<MSH.3>\r\n<HD.1>Fake Sending App</HD.1>\r\n</MSH.3>\r\n<MSH.4>\r\n<HD.1>Fake Sending Facility</HD.1>\r\n</MSH.4>\r\n<MSH.6>\r\n<HD.1>Fake Receiving Facility</HD.1>\r\n</MSH.6>\r\n<MSH.7>\r\n<TS.1>200108151718</TS.1>\r\n</MSH.7>\r\n<MSH.9>\r\n<MSG.1>ACK</MSG.1>\r\n<MSG.2>A01</MSG.2>\r\n<MSG.3>ACK</MSG.3>\r\n</MSH.9>\r\n<MSH.10>20</MSH.10>\r\n<MSH.11>\r\n<PT.1>P</PT.1>\r\n</MSH.11>\r\n<MSH.12>\r\n<VID.1>2.4</VID.1>\r\n</MSH.12>\r\n</MSH>\r\n<MSA>\r\n<MSA.1>AA</MSA.1>\r\n</MSA>\r\n</ACK>";
        assertTrue(EncodedMessageComparator.equivalent(ER7A, ER7B));
        assertTrue(EncodedMessageComparator.equivalent(XMLA, XMLB));
        assertTrue(EncodedMessageComparator.equivalent(ER7A, XMLC));
    }
    
}
