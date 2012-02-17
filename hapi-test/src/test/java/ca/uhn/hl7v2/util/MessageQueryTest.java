/*
 * Created on 10-Nov-2004
 */
package ca.uhn.hl7v2.util;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.util.MessageQuery.Result;
import junit.framework.TestCase;

/**
 * Unit tests for MessageQuery.  
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:30 $ by $Author: jamesagnew $
 */
@SuppressWarnings("deprecation")
public class MessageQueryTest extends TestCase {

    private PipeParser myParser = new PipeParser();
    private static String myMsg1 = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|LABGL1199510021807427|P|2.4||||||x~y|\r"
        + "PID|||T12345~T2~T3||TEST^PATIENT^P||19601002|M||||||||||123456\r"
        + "PV1|||NER|||||||GSU||||||||E||||||||||||||||||||||||||19951002174900|19951006\r"
        + "OBR|1||09527539021001920|1001920^BLOOD GASES, ARTERIAL^^^ABG|||19951002180200|||||||19951002180300||||1793559||0952753902||19951002180700||350|F||^^^^^RT\r"
        + "OBX||NM|1001910^PATIENT TEMPERATURE, ARTERIAL^^^TEMP CORR|0001|37.0~37.1~37.2||||||F|||19951002180700||42\r"
        + "OBX||TX|1001912^FIO2, ARTERIAL^^^FIO2 art|0001|*|%||A|||F|||19951002180700||42\r";
    
    public MessageQueryTest(String theString) {
        super(theString);
    }
    
    
    public void testBasic() throws Exception {
        Message msg = myParser.parse(myMsg1);
        
        String query = "select /MSH-3 as foo";
        MessageQuery.Result result = MessageQuery.query(msg, query);
        assertEquals(true, result.next());
        assertEquals("LABGL1", result.get(0));
        assertEquals("LABGL1", result.get("foo"));
        assertEquals(false, result.next());
        
        query = "select /.PID-3 as x, /.PID-5-1 as y";
        result = MessageQuery.query(msg, query);
        assertEquals(true, result.next());
        assertEquals("T12345", result.get("x"));
        assertEquals("TEST", result.get("y"));
        assertEquals(false, result.next());        
    }
    
    public void testSingleLoopPoint() throws Exception {
        Message msg = myParser.parse(myMsg1);
        String query = "select {id} as id loop id = /.PID-3(*)";
        MessageQuery.Result result = MessageQuery.query(msg, query);
        assertEquals(true, result.next());
        assertEquals("T12345", result.get("id"));
        assertEquals(true, result.next());
        assertEquals("T2", result.get("id"));
        assertEquals(true, result.next());
        assertEquals("T3", result.get("id"));
        assertEquals(false, result.next());         
    }
    
    public void testIndependedentLoopPoints() throws Exception {
        Message msg = myParser.parse(myMsg1);
        String query = "select {id} as id, {charset} as charset loop charset = /.MSH-18(*), id = /.PID-3(*)";
        MessageQuery.Result result = MessageQuery.query(msg, query);
        assertEquals(true, result.next());
        assertEquals("x", result.get("charset"));
        assertEquals("T12345", result.get("id"));
        assertEquals(true, result.next());
        assertEquals("x", result.get("charset"));
        assertEquals("T2", result.get("id"));
        assertEquals(true, result.next());
        assertEquals("x", result.get("charset"));
        assertEquals("T3", result.get("id"));
        assertEquals(true, result.next());
        assertEquals("y", result.get("charset"));
        assertEquals("T12345", result.get("id"));
        assertEquals(true, result.next());
        assertEquals("y", result.get("charset"));
        assertEquals("T2", result.get("id"));
        assertEquals(true, result.next());
        assertEquals("y", result.get("charset"));
        assertEquals("T3", result.get("id"));
        assertEquals(false, result.next());
    }
    
    public void testFoundRepeatedSegment() throws Exception {
        Message msg = myParser.parse(myMsg1);
        String query = "select {obx}/OBX-2 as type loop obx = /.OBSERVATION(*)";
        MessageQuery.Result result = MessageQuery.query(msg, query);
        assertEquals(true, result.next());
        assertEquals("NM", result.get("type"));
        assertEquals(true, result.next());
        assertEquals("TX", result.get("type"));
        assertEquals(false, result.next());        
    }
    
    public void testNestedLoopPoints() throws Exception {
        Message msg = myParser.parse(myMsg1);
        String query = "select {obx}/OBX-2 as type, {result} as value loop obx = /.OBSERVATION(*), result = {obx}/OBX-5(*)";
        MessageQuery.Result result = MessageQuery.query(msg, query);
        assertEquals(true, result.next());
        assertEquals("NM", result.get("type"));        
        assertEquals("37.0", result.get("value"));
        assertEquals(true, result.next());
        assertEquals("NM", result.get("type"));        
        assertEquals("37.1", result.get("value"));
        assertEquals(true, result.next());
        assertEquals("NM", result.get("type"));        
        assertEquals("37.2", result.get("value"));
        assertEquals(true, result.next());
        assertEquals("TX", result.get("type"));        
        assertEquals("*", result.get("value"));
        assertEquals(false, result.next());
    }
    
    public void testWhere() throws Exception {
        Message msg = myParser.parse(myMsg1);
        String query = "select {result} as value loop obx = /.OBSERVATION(*), result = {obx}/OBX-5(*) where {obx}/OBX-2 = 'TX'";
        MessageQuery.Result result = MessageQuery.query(msg, query);
        assertEquals(true, result.next());
        assertEquals("*", result.get("value"));
        assertEquals(false, result.next());

        query = "select {result} as value loop obx = /.OBSERVATION(*), result = {obx}/OBX-5(*) where {obx}/OBX-2 like 'T.?'";
        result = MessageQuery.query(msg, query);
        assertEquals(true, result.next());
        assertEquals("*", result.get("value"));
        assertEquals(false, result.next());
    
        query = "select {result} as value loop obx = /.OBSERVATION(*), result = {obx}/OBX-5(*) where {obx}/OBX-2 = 'TX', /.MSH-3 = '---'";
        result = MessageQuery.query(msg, query);
        assertEquals(false, result.next());
    }

    //from Neal ... tests case where data are null in one row but there are good data in later rows
    // (needs locked Terser)
    public void testExtractORU_R01() throws HL7Exception, EncodingNotSupportedException {
        Parser parser = new PipeParser();

        String msgText;
        Message msg;
        msgText = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|LABGL1199510021807427|P|2.4||||||x~y|\r"
                + "PID|||T12345||TEST^PATIENT^P||19601002|M||||||||||123456\r"
                + "PV1|||NER|||||||GSU||||||||E||||||||||||||||||||||||||19951002174900|19951006\r"
                + "OBR|1|123|09527539021001920|1001920^BLOOD GASES, ARTERIAL^^^ABG|||199510021802|||||||19951002180300||||1793559||0952753902||19951002180700||350|F||^^^^^RT\r"
                + "OBX||NM|1001910^PATIENT TEMPERATURE, ARTERIAL^^^TEMP CORR|0001|37.0~37.1||||||F|||19951002180700||42\r"
//                + "NTE|0||hello\r"
//                + "NTE|0||hello\r"
//                + "NTE|0||hello\r"
                + "OBX||TX|1001912^FIO2, ARTERIAL^^^FIO2 art|0001|foo|%||A|||F|||19951002180700||42\r"
                //+ "NTE|0||hello\r"
                + "OBX||TX|1001912^FIO2, ARTERIAL^^^FIO2 art|0001|foo|%||A|||F|||19951002180700||42\r"
                + "NTE|0||hello\r"
                + "OBX||TX|1001912^FIO2, ARTERIAL^^^FIO2 art|0001|foo|%||A|||F|||19951002180700||42\r"
                + "NTE|0||hello\r"
                + "NTE|1||hello\r"
                + "NTE|2||Ms. Choi\r"
                + "NTE|3||opinion with regards metastatic adenocarcinoma.\r"
                + "NTE|4||hello\r";
        msg = parser.parse(msgText);
//        TreePanel.showInNewWindow(msg);

        //ORU_R01_PIDPD1NK1NTEPV1PV2ORCOBRNTECTDOBXNTEFT1CTI(1)

        //String qString = "select /.PID-3-1 as mrn, {order}/OBR-2-1 as orderNum, {nte}-3-1 as nte "
        //        + "loop order = /.ORU_R01_ORCOBRNTECTDOBXNTEFT1CTI(*), "
        //        + "obx = {order}/ORU_R01_OBXNTE(*), " + "nte = {obx}/NTE(*) ";
        
        String qString = "select /.PID-3-1 as mrn, /.ORDER_OBSERVATION/OBR-2-1 as orderNum, "
                + "{nte}-3-1 as nte "
                + "loop obx = /.ORDER_OBSERVATION/OBSERVATION(*2), "
                + "nte = {obx}/NTE(*) "; 

        Result res = MessageQuery.query(msg, qString);
        assertTrue(res.next());
        assertEquals("", res.get("nte"));
        assertTrue(res.next());
        assertEquals("hello", res.get("nte"));

        qString = "select /.PID-3-1 as mrn, /.ORDER_OBSERVATION/OBR-2-1 as orderNum, "
            + "{nte}-3-1 as nte "
            + "loop obx = /.ORDER_OBSERVATION/OBSERVATION(*2), "
            + "nte = {obx}/NTE(*) " 
            + "where {nte}-3-1 like '.+'";
            
        res = MessageQuery.query(msg, qString);
        assertTrue(res.next());
        assertEquals("hello", res.get("nte"));
        assertTrue(res.next());
        assertEquals("hello", res.get("nte"));
        assertTrue(res.next());
        assertEquals("hello", res.get("nte"));
        assertTrue(res.next());
        assertEquals("Ms. Choi", res.get("nte"));

//        qString = "select /.PID-3-1 as mrn, /.ORU_R01_ORCOBRNTECTDOBXNTEFT1CTI/OBR-2-1 as orderNum, "
//            + "{obx}/OBX-2 as dummy, {nte}-3-1 as nte "
//            + "loop obx = /.ORU_R01_ORCOBRNTECTDOBXNTEFT1CTI/ORU_R01_OBXNTE(*), "
//            + "nte = {obx}/NTE(*) " 
//            + "where {nte}-3-1 like '.+'";
//            
//        res = MessageQuery.query(msg, qString);
//        
//        System.out.println("\n\nEXTRACTING RESULT DATA");
//        while (res.next()) {
//            String field1 = res.get("mrn");
//            String field2 = res.get("orderNum");
//            String field3 = res.get("nte");
//            System.out.println("row data:  " + field1 + " " + field2 + " "
//                    + field3);
//        }

//        try {
//            Thread.sleep(1000 * 60 * 2);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }
    
}
