package ca.uhn.hl7v2.parser;

import java.io.IOException;
import java.io.InputStream;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Primitive;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Structure;
import ca.uhn.hl7v2.model.Varies;
import ca.uhn.hl7v2.model.v23.message.SIU_S12;
import ca.uhn.hl7v2.model.v24.datatype.HD;
import ca.uhn.hl7v2.model.v24.datatype.SI;
import ca.uhn.hl7v2.model.v24.message.ACK;
import ca.uhn.hl7v2.model.v24.message.ADT_A01;
import ca.uhn.hl7v2.model.v24.message.ORU_R01;
import ca.uhn.hl7v2.model.v24.segment.EVN;
import ca.uhn.hl7v2.model.v24.segment.PID;
import ca.uhn.hl7v2.model.v25.message.ADT_A03;
import ca.uhn.hl7v2.model.v25.message.ADT_A45;
import ca.uhn.hl7v2.model.v25.message.REF_I12;
import ca.uhn.hl7v2.model.v25.segment.PV1;
import ca.uhn.hl7v2.model.v251.message.ADT_A17;
import ca.uhn.hl7v2.util.Terser;
import ca.uhn.hl7v2.validation.EncodingRule;
import ca.uhn.hl7v2.validation.MessageRule;
import ca.uhn.hl7v2.validation.ValidationException;
import ca.uhn.hl7v2.validation.impl.DefaultValidation;
import ca.uhn.hl7v2.validation.impl.MessageRuleBinding;
import ca.uhn.hl7v2.validation.impl.RuleBinding;
import ca.uhn.hl7v2.validation.impl.SizeRule;
import ca.uhn.hl7v2.validation.impl.ValidationContextImpl;

public class NewPipeParserTest extends TestCase {
    private Parser parser;
    private static final Log ourLog = LogFactory.getLog(NewPipeParserTest.class);

    public void setUp() throws Exception {
        parser = new PipeParser();
    }

    /**
     * ADT^A45 has the structure:
     * 
     * <pre>
     * MSH 
     * [ { SFT } ] 
     * EVN 
     * PID 
     * [ PD1 ] 
     *    MERGE_INFO 
     *    {
     *    MRG 
     *    PV1 
     *    } 
     *    MERGE_INFO
     * </pre>
     * 
     * This test checks for correct behaviour if a required segment at the tail
     * of the message is missing
     */
    public void testMissingRequiredLastSegment() throws HL7Exception {

        String messageText = "MSH|^~\\&|4265-ADT|4265|eReferral|eReferral|201004141020||ADT^A45^ADT_A45|102416|T^|2.5^^|||NE|AL|CAN|8859/1\r"
                + "EVN|A45|201004141020|\r"
                + "PID|1||7010226^^^4265^MR~0000000000^^^CANON^JHN^^^^^^GP~1736465^^^4265^VN||Park^Green^^^MS.^^L||19890812|F|||123 TestingLane^^TORONTO^CA-ON^M5G2C2^CAN^H^~^^^^^^^||^PRN^PH^^1^416^2525252^|^^^^^^^||||||||||||||||N\r"
                + "PV1|1|I||||^^^WP^1469^^^^^^^^|||||||||||^Derkach^Peter.^^^Dr.||20913000131|||||||||||||||||||||||||201004011340|201004141018";

        ADT_A45 msg = new ADT_A45();
        msg.setParser(parser);
        msg.parse(messageText);

        Assert.assertEquals("7010226", msg.getPID().getPid3_PatientIdentifierList(0).getIDNumber().getValue());
        PV1 pv1 = (PV1) msg.get("PV1");
        Assert.assertEquals("I", pv1.getPv12_PatientClass().encode());

        ourLog.info("\r\n" + msg.toString());

    }

    public void testTwoSegmentsWithSameName() throws EncodingNotSupportedException, HL7Exception {

        String messageText = "MSH|^~\\&|ULTRA|TML|TML||200903120021||ORU^R01|66239404|T|2.3.1||||||\r"
                + "EVN|A01|201002130003||||201002130003|G^4265^L\r"
                + "PID|1||3678347^^^UHN^MR^G^4265^^^^^~9635915532^vp^^CANON^JHN^G^4265^^^20120517^^~||LEIGHTON^RACHEL^DIAMOND^^^^U||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6H 2T9^CAN^H||^PRN^PH^^1^416^7676333|^WPN^PH^^1^905^7436333^6001||||\r"
                + "PV1||E|Emerg^EmergAcute^Interview^G^4265^^^N^EmergAcute^Interview^Emerg^185 2 16^|||Emerg^Gen Wait^GenWait13^G^4265^^^^Gen Wait^GenWait13^Emerg^185 6 13^|141378^Rauchwerger^David^^^Dr.^MD^^^L^^^EI^^^^^^^^^^^^^|||||||A|||141378^Rauchwerger^David^^^Dr.^MD^^^L^^^EI^^^^^^^^^^^^^|EP^|292007135^^^UHN^VN^G^4265^^^^^||||||||||||||||||||G|||||200905030022|||||||V|\r"
                + "PID|2||0877410^^^UHN^MR^^^^^^^~3135063059^^^CANON^JHN^^^^^^^~||Lex^Tamara^Christina^^Miss^^L^^^^^200905030044^^~||19801120|F|||441 Margueretta St^^Toronto^ON^M6H2S6^Can^H^^^^^^^~|1811|(416)533-5113^PRN^PH^^^^^^^^^~|(416)532-0206^WPN^PH^^^^^^^^^|eng^ English^03ZPtlang^^^|S^Single^03ZMtSt^^^|PDI^ Patient did not indicate^03ZRelgn^^^|292007138^^^UHN^VN^^^^^^^~||||||||||||N|||200905030044||||||\r"
                + "BLG|||MOHLTC";

        ADT_A17 msg = new ADT_A17();
        msg.setParser(parser);
        msg.parse(messageText);

        ourLog.info(msg.encode());

        Assert.assertEquals("2", msg.getPID2().getPid1_SetIDPID().encode());

    }

    public void testDTInObx2() throws EncodingNotSupportedException, HL7Exception {

        String string = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r"
                + "ZPI|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r"
                + "PID|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r"
                + "PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST\r"
                + "ORC|RE||T09-100442-RET-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r"
                + "OBR|0||T09-100442-RET-0^^OLIS_Site_ID^ISO|RET^RETICULOCYTE COUNT^HL79901 literal|||200905011106|||||||200905011106||OLIST^BLAKE^DONALD^THOR^^^^L^921379||7870279|7870279|T09-100442|MOHLTC|200905011130||B7|F||1^^^200905011106^^R\r"
                + "OBX|8|DT|GDT-00108^Device Implant Date^GDT-LATITUDE||20090505||||||F||\r";

        ca.uhn.hl7v2.model.v231.message.ORU_R01 msg = new ca.uhn.hl7v2.model.v231.message.ORU_R01();
        msg.setParser(new PipeParser());
        msg.parse(string);

        ourLog.info(msg.encode());

    }

    public void testInvalidLengthInObx2() throws EncodingNotSupportedException, HL7Exception {

        String string = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.4\r"
                + "ZPI|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r"
                + "PID|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r"
                + "PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST\r"
                + "ORC|RE||T09-100442-RET-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r"
                + "OBR|0||T09-100442-RET-0^^OLIS_Site_ID^ISO|RET^RETICULOCYTE COUNT^HL79901 literal|||200905011106|||||||200905011106||OLIST^BLAKE^DONALD^THOR^^^^L^921379||7870279|7870279|T09-100442|MOHLTC|200905011130||B7|F||1^^^200905011106^^R\r"
                + "OBX|8|MED|GDT-00108^Device Implant Date^GDT-LATITUDE||20090505||||||F||\r";

        ca.uhn.hl7v2.model.v24.message.ORU_R01 msg = new ca.uhn.hl7v2.model.v24.message.ORU_R01();
        msg.setParser(new PipeParser());

        System.setProperty(Varies.INVALID_OBX2_TYPE_PROP, "ST");
        msg.parse(string);

        ourLog.info(msg.encode());

        System.clearProperty(Varies.INVALID_OBX2_TYPE_PROP);
        try {
            msg.parse(string);
            fail();
        } catch (HL7Exception e) {

        }

    }

    public void testUnexpectedSegmentAtEng() throws EncodingNotSupportedException, HL7Exception {
        String messageText = "MSH|^~\\&|REG|G|||201002220026||ADT^A14|33186452|P|2.2|||||\r" + "EVN|A14|201002220026|||14380\r"
                + "PID||^^|222^454554^HN637|324334244^^|TEST^PATIENT^Luis^^Mr.^Mr.|\r"
                + "PV1||E|^^^^^^^^|^||^^^^^^^^|^^^^^^^|^^^^^^^||^^|||||||^^^^^^^|^|3243^|^|||||||||||||||||||G||||^^^^^^^^|43865896||||||\r" + "PV2||||||||||||||||||^||||N\r"
                + "NK1|1|TEST^NKGuy^^^^|CHD^ Son|123 Fake Street^^Toronto^ON^M6J 3H2^Can^M|(416)123-4567|(416)123-4567|NK||||||\r"
                + "IN1|1||0012343001|  OHIP||||||||||||^^^^^|||^^^^^^M|||||||||||||||||||||||||^^^^^^M\r" + "IN2||||||2216\r" + "ZIN||||||||||||||||||";

        parser.setValidationContext(new ValidationContextImpl());
        parser.parse(messageText);

    }

    /**
     * In SIU_S12, Groups begin with RGS and have nested subgroups as well
     */
    public void testNestedRepeatingGroups() throws EncodingNotSupportedException, HL7Exception {

        String messageText = "MSH|^~\\&|ORSOS|G|PRECASE^SCHEDULING||20100406132803||SIU^S14| 38762|P|2.3\r"
                + // -
                "SCH|ADS|569576||||G014080|||379|MIN^MINUTES|^^^20100407161000|51873^AL-RADI OO||||ADS||||ADS\r"
                + "PID||990119205^^^R1^MR|990119205|000533921J^^^R1^VN|TEST MP3^TEST MP3|||||||||||||000533921J\r"
                + "PV1|1|U|||||51873^AL-RADI OO|51873^AL-RADI OO|||||||||||569576^R1 caseno\r" + "DG1|1|||||U\r" + "RGS|1|1|abc\r"
                + "AIS|1|1|G014080^BYPASS AXILLOFEMORAL|20100406161000|||255|000000\r" + "AIG|1|1|51873|STAFF|||||20100407164000\r" + "AIL|1|1|OR 4^OR 4||||||40800|0\r"
                + "AIP|1|1|51873^ALRADI^OSMAN|^1\r" + "RGS|2|2|abc\r" + "AIS|2|2|G11455^BYPASS AORTOCORONARY USING RADIAL ARTERY|20100406161000|||15\r"
                + "AIG|2|2|33043|STAFF|||||20100407212500\r" + "AIL|2|2|OR 4^OR 4|||||||0\r" + "AIP|2|2|33043^AUNE^KELLY|^1\r" + "RGS|3|3|abc\r"
                + "AIS|3|3|G014045^ANGIOPLASTY|20100406161000|||5\r" + "AIG|3|3|102694|STAFF|||||20100407214000\r" + "AIL|3|3|OR 4^OR 4|||||||0\r"
                + "AIP|3|3|102694^ANGELINI^MARK|^1\r" + "RGS|4|4|abc\r" + "AIS|4|4|G11045^BYPASS AORTOCORONARY LITA|20100406161000|||60\r"
                + "AIG|4|4|T1240UHN|STAFF|||||20100407214500\r" + "AIL|4|4|OR 4^OR 4|||||||0\r" + "AIP|4|4|T1240UHN^ASTA^JOHN|^1\r";

        SIU_S12 parsed = (SIU_S12) parser.parse(messageText);
        Assert.assertEquals("1", parsed.getRESOURCES(0).getRGS().getSetIDRGS().getValue());
        Assert.assertEquals("2", parsed.getRESOURCES(1).getRGS().getSetIDRGS().getValue());
        Assert.assertEquals("3", parsed.getRESOURCES(2).getRGS().getSetIDRGS().getValue());
        Assert.assertEquals("4", parsed.getRESOURCES(3).getRGS().getSetIDRGS().getValue());

    }

    public void testAL1Reps() throws IOException, EncodingNotSupportedException, HL7Exception {
        InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("ca/uhn/hl7v2/parser/adt_a03.txt");
        byte[] bytes = new byte[10000];
        StringBuffer buffer = new StringBuffer();
        int count;
        while ((count = stream.read(bytes)) > 0) {
            buffer.append(new String(bytes), 0, count);
        }

        String er7Message = buffer.toString();

        ca.uhn.hl7v2.model.v25.message.ADT_A03 message = (ADT_A03) parser.parse(er7Message);

        System.out.println(message.getAL1Reps());
        System.out.println(parser.encode(message));
    }

    public void testGetVersion() throws Exception {
        String message = "MSH|^~\\&|3|4|5|6|7|8|9|10|11|12|13|||\rMSA|foo\rERR|bar|||";
        assertEquals("12", parser.getVersion(message));
        message = "MSH|^~\\&|STML|001|STML|001|20020307142717||ADT^A08|01501|T|2.2|||AL|NE\rEVN|A08|20020307142652";
        assertEquals("2.2", parser.getVersion(message));
        message = "MSH|^~\\&|STML|001|STML|001|20020307142717||ADT^A08|01501|T|2.2^x^x|||AL|NE\rEVN|A08|20020307142652";
        assertEquals("2.2", parser.getVersion(message));
    }

    public void testGetAckID() throws Exception {
        String message = "MSH|foo|foo";
        String ackID = parser.getAckID(message);
        assertEquals(null, ackID);
        message = "MSH|^~\\&|STML|001|STML|001|20020307142616||ADT^A05|01500|T|2.2|||AL|NE\rEVN|A05|20020307142547|200203081424\rPID|0001||000005222||TEST^BRIAN||19700623|M||C|30815 RAYBURN^^LIVONIA^MI^48154-0000^USA||(313)422-2182|||S||0001445|380-96-9087\rPV1|0001|O|PR|EL|T0468423||00410^KRISHNAN AMBA MD|||PRO||||1||||O||2||||||||||||||||||||||||||0000000.00|0000000.00|0000000.00|0000000.00\rPV2|||^IV THERAPY|||||20020308\rOBX|0001|ST|ADMIT DIAGNOSIS TEXT\rOBX|0002|ST|1010.1^WEIGHT(KG)^AS4\rOBX|0003|ST|1010.3^HEIGHT(CM)^AS4\rOBX|0004|ST|ALLERGY FREE TEXT\rGT1|0001|0003225|TEST^BRIAN||30815 RAYBURN^^LIVONIA^MI^48154-0000^USA|(313)422-2182||19700623|M||SE|380969087|||||^^^^^USA|||1\rIN1|0001|09|210|BCBSM BC OF MI|600 EAST LAFAYETTE^^DETROIT^MI^48226-0000^USA|||77777|FULL BC|||||||TEST^BRIAN|SE|19700623|30815 RAYBURN^^LIVONIA^MI^48154-0000^USA|Y|Y||||||Y|Y|20020307||||||21009|XYZ380969087||||||1|M|^^^^^USA\rIN2||380969087|||||||||||||||||||N|||||||SPR^LM^00677.00~ICU^LM^02068.00\rIN1|0002|09|211|BCBSM BS OF MI P/C PLAN|600 EAST LAFAYETTE^^DETROIT^MI^48226-0000^USA|||77777|FULL|||||||TEST^BRIAN|SE|19700623|30815 RAYBURN^^LIVONIA^MI^48154-0000^USA|Y|N||||||Y|Y|20020307||||||21109|XYZ380969087||||||1|M|^^^^^USA\rIN2||380969087|||||||||||||||||||N";
        ackID = parser.getAckID(message);
        assertEquals(null, ackID);
    }

    /**
     * If there are multiple locations in a group that have the right type for a
     * segment, it should be placed in the first location following the last
     * location that was filled. It shouldn't be placed in a location preceding
     * previously used locations.
     */
    public void testCorrectSegmentOrderWithMultipleOptions() throws Exception {
        String message = "MSH|^~\\&|^QueryServices||||20021011161756.297-0500||ORU^R01|1|D|2.4\r" + // 
                "ORC|\r" + //
                "OBX|\r" + //
                "NTE|||test|\r";
        ORU_R01 msg = (ORU_R01) parser.parse(message);
        String val = msg.getPATIENT_RESULT(0).getORDER_OBSERVATION().getOBSERVATION(0).getNTE(0).getComment(0).getValue();

        System.out.println(parser.encode(msg));
        assertEquals("test", val);
    }

    public void testNonStandardSegmentNearStart() throws EncodingNotSupportedException, HL7Exception {
        String string = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r"
                + "ZPI|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r"
                + "PID|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r"
                + "PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST\r"
                + "ORC|RE||T09-100442-RET-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r"
                + "OBR|0||T09-100442-RET-0^^OLIS_Site_ID^ISO|RET^RETICULOCYTE COUNT^HL79901 literal|||200905011106|||||||200905011106||OLIST^BLAKE^DONALD^THOR^^^^L^921379||7870279|7870279|T09-100442|MOHLTC|200905011130||B7|F||1^^^200905011106^^R\r"
                + "OBX|1|NM|Z114099^Erc^L||4.00|tril/L|3.90-5.60||||F|||200905011111|PMH\r";

        ca.uhn.hl7v2.model.v23.message.ORU_R01 message = (ca.uhn.hl7v2.model.v23.message.ORU_R01) parser.parse(string);

        String reEncoded = parser.encode(message);
        System.out.println(reEncoded);
        assertEquals(string, reEncoded);

        String pidMrn = message.getRESPONSE().getPATIENT().getPID().getPid3_PatientIDInternalID(0).getCx1_ID().getValue();
        assertEquals("7005728", pidMrn);
    }

    public void testNonStandardSegmentNearEnd() throws EncodingNotSupportedException, HL7Exception {
        String string = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r"
                + "PID|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r"
                + "PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST\r"
                + "ORC|RE||T09-100442-RET-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r"
                + "OBR|0||T09-100442-RET-0^^OLIS_Site_ID^ISO|RET^RETICULOCYTE COUNT^HL79901 literal|||200905011106|||||||200905011106||OLIST^BLAKE^DONALD^THOR^^^^L^921379||7870279|7870279|T09-100442|MOHLTC|200905011130||B7|F||1^^^200905011106^^R\r"
                + "OBX|1|NM|Z114099^Erc^L||4.00|tril/L|3.90-5.60||||F|||200905011111|PMH\r"
                + "ZPI|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r";

        Message message = parser.parse(string);

        String reEncoded = parser.encode(message);
        System.out.println(reEncoded);
        assertEquals(string, reEncoded);

    }

    public void testNonStandardSegmentAfterEnd() throws EncodingNotSupportedException, HL7Exception {
        String string = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r"
                + "PID|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r"
                + "PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST\r"
                + "ORC|RE||T09-100442-RET-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r"
                + "OBR|0||T09-100442-RET-0^^OLIS_Site_ID^ISO|RET^RETICULOCYTE COUNT^HL79901 literal|||200905011106|||||||200905011106||OLIST^BLAKE^DONALD^THOR^^^^L^921379||7870279|7870279|T09-100442|MOHLTC|200905011130||B7|F||1^^^200905011106^^R\r"
                + "OBX|1|NM|Z114099^Erc^L||4.00|tril/L|3.90-5.60||||F|||200905011111|PMH\r" + "DSC|1\r"
                + "ZPI|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r";

        Message message = parser.parse(string);

        String reEncoded = parser.encode(message);
        System.out.println(reEncoded);
        assertEquals(string, reEncoded);

    }

    /**
     * Test repeating segment location
     */
    public void testRepeatingSegment() throws Exception {
        String message = "MSH|^~\\&|^QueryServices||||20021011161756.297-0500||ORU^R01|1|D|2.4\r" + //
                "ORC|\r" + //
                "OBX|1\r" + //
                "OBX|2\r" + //
                "OBX|3\r" + //
                "NTE|||test|\r";
        ORU_R01 msg = (ORU_R01) parser.parse(message);

        assertEquals("1", msg.getPATIENT_RESULT(0).getORDER_OBSERVATION().getOBSERVATION(0).getOBX().getSetIDOBX().getValue());
        assertEquals("2", msg.getPATIENT_RESULT(0).getORDER_OBSERVATION().getOBSERVATION(1).getOBX().getSetIDOBX().getValue());
        assertEquals("3", msg.getPATIENT_RESULT(0).getORDER_OBSERVATION().getOBSERVATION(2).getOBX().getSetIDOBX().getValue());

    }

    /**
     * If a repeating group has an optional first child,
     */
    public void testRepeatingGroupWithOptionalFirstSegment() throws Exception {
        String message = "MSH|^~\\&|^QueryServices||||20021011161756.297-0500||ORU^R01|1|D|2.4\r" + // 
                "ORC|\r" + // 
                "CTI|\r" + //
                "OBR|\r" + //
                "NTE|||test|\r";
        ORU_R01 msg = (ORU_R01) parser.parse(message);

        System.out.println(parser.encode(msg));

        String val = msg.getPATIENT_RESULT(0).getORDER_OBSERVATION(0).getNTE().getComment(0).getValue();
        assertEquals(null, val);

        val = msg.getPATIENT_RESULT(0).getORDER_OBSERVATION(1).getNTE().getComment(0).getValue();
        assertEquals("test", val);

        val = msg.getPATIENT_RESULT(1).getORDER_OBSERVATION(0).getNTE().getComment(0).getValue();
        assertEquals(null, val);

        val = msg.getPATIENT_RESULT(1).getORDER_OBSERVATION(1).getNTE().getComment(0).getValue();
        assertEquals(null, val);

    }

    /**
     * If there is a location in a certain group that is the right type for a
     * certain segment, and a later segment has already been populated, and the
     * group is repeating, then a new group instance should be created and the
     * segment should be placed there.
     */
    public void testParseIntoNewGroupIfMisorderedInCurrentGroup() throws Exception {
        String message = "MSH|^~\\&|^QueryServices||||20021011161756.297-0500||ORU^R01|1|D|2.4\r" + // 
                "ORC|\r" + // 
                "CTI|\r" + //
                "ORC|\r" + //
                "NTE|||test|\r";
        ORU_R01 msg = (ORU_R01) parser.parse(message);

        System.out.println(parser.encode(msg));

        String val = msg.getPATIENT_RESULT(0).getORDER_OBSERVATION(0).getNTE().getComment(0).getValue();
        assertEquals(null, val);

        val = msg.getPATIENT_RESULT(0).getORDER_OBSERVATION(1).getNTE().getComment(0).getValue();
        assertEquals("test", val);

        val = msg.getPATIENT_RESULT(1).getORDER_OBSERVATION(0).getNTE().getComment(0).getValue();
        assertEquals(null, val);

        val = msg.getPATIENT_RESULT(1).getORDER_OBSERVATION(1).getNTE().getComment(0).getValue();
        assertEquals(null, val);

    }

    /**
     * Check that parsing an empty segment doesn't crash
     */
    public void testParseEmptySegment() throws EncodingNotSupportedException, HL7Exception {
        String message = "MSH|^~\\&|||||20080627102031.292+0100||ADT^A31^ADT_A31|EJ557600005480760|P|2.3|||||BE|8859/1|FR\r\n" + "EVN||20080627101943+0100\r\n"
                + "PID|||M07869D^^^ADMISSION^^ISSTLUC||DUPONT^JEAN||19701004000000+0100|M\r\n" + "PD1\r\n" + "PV1||N";
        parser.parse(message);
    }

    /**
     * If there is a potential location for a segment in a certain group, but
     * the entire group is out of order, the segment should not be placed there
     * (in a current or subsequent repetition).
     */
    public void testNotParseIntoNewGroupIfWholeGroupMisordered() throws Exception {
        String message = "MSH|^~\\&|^QueryServices||||20021011161756.297-0500||ORU^R01|1|D|2.4\r" + //
                "DSC|\r" + // 
                "PID||test|\r";
        ORU_R01 msg = (ORU_R01) parser.parse(message);
        verifyIDNull(msg.getPATIENT_RESULT(0).getPATIENT().getPID());
        verifyIDNull(msg.getPATIENT_RESULT(1).getPATIENT().getPID());
    }

    /** Make sure PID-2 not valued */
    private void verifyIDNull(PID pid) {
        String val = pid.getPatientID().getID().getValue();
        assertTrue(val == null || val.length() == 0);
    }

    public void testComponents() throws Exception {
        // test normal component, subcomponent
        String message = "MSH|^~\\&|^QueryServices||||20021011161756.297-0500||ORU^R01|1|D|2.4\rPID|||||x&y^z|\r";
        ORU_R01 msg = (ORU_R01) parser.parse(message);
        PID pid = msg.getPATIENT_RESULT().getPATIENT().getPID();
        assertEquals("x", pid.getPatientName(0).getFamilyName().getSurname().getValue());
        assertEquals("y", pid.getPatientName(0).getFamilyName().getOwnSurnamePrefix().getValue());
        assertEquals("z", pid.getPatientName(0).getGivenName().getValue());
    }

    public void testExtraComponents() throws Exception {
        // an extra subcomponent on a primitive field is treated as an
        // ExtraComponent of the Primitive
        String message = "MSH|^~\\&|^QueryServices||||20021011161756.297-0500||ORU^R01|1|D|2.4\rPID|4&y\r";
        ORU_R01 msg = (ORU_R01) parser.parse(message);
        SI si = msg.getPATIENT_RESULT().getPATIENT().getPID().getSetIDPID();
        assertEquals("4", si.getValue());
        assertEquals("y", ((Primitive) si.getExtraComponents().getComponent(0).getData()).getValue());

        // an extra COMPONENT on a primitive field is also treated in this way,
        // and replaces the subcomp if both are present
        message = "MSH|^~\\&|^QueryServices||||20021011161756.297-0500||ORU^R01|1|D|2.4\rPID|4&y^x\r";
        msg = (ORU_R01) parser.parse(message);
        si = msg.getPATIENT_RESULT().getPATIENT().getPID().getSetIDPID();
        assertEquals("4", si.getValue());
        assertEquals("x", ((Primitive) si.getExtraComponents().getComponent(0).getData()).getValue());

        // subcomponents on extra components are recognized as such
        message = "MSH|^~\\&|^QueryServices||||20021011161756.297-0500||ORU^R01|1|D|2.4\rPID|4&y^x&z\r";
        msg = (ORU_R01) parser.parse(message);
        si = msg.getPATIENT_RESULT().getPATIENT().getPID().getSetIDPID();
        assertEquals("4", si.getValue());
        // assertEquals("z", ((Primitive)
        // si.getExtraComponents().getComponent(0).getExtraComponents().getComponent(0).getData()).getValue());
        Composite c = (Composite) si.getExtraComponents().getComponent(0).getData();
        assertEquals("z", ((Primitive) ((Varies) c.getComponent(1)).getData()).getValue());
    }

    public void testExtraFieldReps() throws Exception {
        String message = "MSH|^~\\&|one~two~three||||||ORU^R01|1|D|2.4\r";
        ORU_R01 msg = (ORU_R01) parser.parse(message);
        assertEquals("three", ((HD) msg.getMSH().getField(3, 2)).getNamespaceID().getValue());
    }

    public void testEscape() throws Exception {
        ACK ack = new ACK();
        ack.getMSH().getFieldSeparator().setValue("|");
        ack.getMSH().getEncodingCharacters().setValue("^~\\&");
        ack.getMSA().getAcknowledgementCode().setValue("|");
        String expected = "MSH|^~\\&\rMSA|\\F\\\r";
        String actual = this.parser.encode(ack);
        assertEquals(expected, actual);
    }

    public void testUnescape() throws Exception {
        String text = "MSH|^~\\&|\\F\\||||||ORU^R01|1|D|2.4\r";
        Message message = this.parser.parse(text);
        Terser t = new Terser(message);
        assertEquals("|", t.get("MSH-3"));
    }

    public void testEarlyNonStandard() throws EncodingNotSupportedException, HL7Exception {
        String message = "MSH|^~\\&|IRIS|SANTER|AMB_R|SANTER|200803051508||ADT^A03|263206|P|2.5\r\n"
                + "EVN||200803051509||||200803031508\r\n"
                + "ZZZ|aaa\r\n"
                + "PID|||5520255^^^PK^PK~ZZZZZZ83M64Z148R^^^CF^CF~ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103^99991231~^^^^TEAM||ZZZ^ZZZ||19830824|F||||||||||||||||||||||N\r\n"
                + "PV1||I|6402DH^^^^^^^^MED. 1 - ONCOLOGIA^^OSPEDALE MAGGIORE DI LODI&LODI|||^^^^^^^^^^OSPEDALE MAGGIORE DI LODI&LODI|13936^TEST^TEST||||||||||5068^TEST2^TEST2||2008003369||||||||||||||||||||||||||200803031508\r\n"
                + "PR1|1||1111^Mastoplastica|Protesi|20090224|02|";

        Message parsed = parser.parse(message);
        // This caused a hang at one point in development

    }

    public void testValidation() throws Exception {
        ValidationContextImpl context = new ValidationContextImpl();
        context.getEncodingRuleBindings().add(new RuleBinding("*", "*", new FooEncodingRule()));
        context.getMessageRuleBindings().add(new MessageRuleBinding("*", "*", "*", new BarMessageRule()));
        context.getPrimitiveRuleBindings().add(new RuleBinding("*", "NM", new SizeRule(5)));
        parser.setValidationContext(context);

        String text = "MSH|^~\\&|bar|foo|||||ORU^R01|1|D|2.4|12345\r";
        Message m = parser.parse(text);

        try {
            text = "MSH|^~\\&|ba|foo|||||ORU^R01|1|D|2.4|12345\r";
            m = parser.parse(text);
            fail("Shoud have failed message rule");
        } catch (HL7Exception e) {
        }

        try {
            text = "MSH|^~\\&|bar|fo|||||ORU^R01|1|D|2.4|12345\r";
            m = parser.parse(text);
            fail("Shoud have failed encoding rule");
        } catch (HL7Exception e) {
        }

        try {
            text = "MSH|^~\\&|ba|foo|||||ORU^R01|1|D|2.4|123456\r";
            m = parser.parse(text);
            fail("Shoud have failed datatype rule on field 13");
        } catch (HL7Exception e) {
        }
    }

    /**
     * If a non-repeating segment is found to be repeating, the extra should be
     * added as a non standard segment.
     */
    public void testDuplicateSegment() throws HL7Exception {
        String message = "MSH|^~\\&|^QueryServices||||20021011161756.297-0500||ADT^A01|1|D|2.4\r" + //
                "EVN|R01\r" + //
                "EVN|R02\r" + //
                "PID|1\r" + //
                "IN1|1\r" + //
                "IN1|2\r" + //
                "PID|2\r";

        ADT_A01 parsed = (ADT_A01) parser.parse(message);
        System.out.println(parser.encode(parsed));

        ourLog.info("\r\n" + parsed.toString());

        assertEquals("R01", parsed.getEVN().getEventTypeCode().getValue());

        EVN group = (EVN) parsed.get("EVN2");
        assertNotNull(group);
        assertEquals("R02", group.getEventTypeCode().getValue());

        assertEquals("1", parsed.getPID().getSetIDPID().getValue());

        Structure rep2 = parsed.get("EVN2");

        assertTrue(rep2 instanceof EVN);
    }

    /**
     * See http://sourceforge.net/tracker/index.php?func=detail&aid=1536200&
     * group_id=38899&atid=423835
     * 
     * @throws EncodingNotSupportedException
     *             -
     * @throws HL7Exception
     *             -
     */
    public void testInvalidSegmentName() throws EncodingNotSupportedException, HL7Exception {

        String msg = "MSH|^~\\&||Big Laboratory^33D0123456^CLIA|GEN2|NYSDOH|20060802101649||ORU^R01|200608021016491003|D|2.3\r\n"
                + "I|||13198751^^^^^Big Laboratory&33D0123456&CLIA||DREST^NATALIE^||19500101|F|||123 MAIN ST^^SPRINGFIELD^NY^12345||^^^^^518^1234567\r\n"
                + "OBR|1||13198751|^^^207252^CULTURE,SALMONELLA/SHIG^L|||200607280943|||||||20060729101650|STOOL-STOOL&STOOL-STOOL|^HERTZ, JOHN Q|^^^^^518^5551212||||||||F\r\n"
                + "ZLR|456 WASHINGTON BLVD^SUITE 100^ALBANY^NY^12345|HERTZ^JOHN^Q^^^MD|456 WASHINGTON BLVD^SUITE 100^ALBANY^NY^12345|^^^^^518^4567890\r\n"
                + "OBX|1|CE|^^^60101058^CULTURE,SALMONELLA/SHIGELLA,STOOL^L|1|^^^SASP^Salmonella sp., not typhi^L||||||F|||200608011318|33D0123456^Big Laboratory^CLIA";
        Message message = parser.parse(msg);

    }

    public void testNonPipeDelimitor() throws EncodingNotSupportedException, HL7Exception {
        String msg = "MSH^~|\\&^HDRVTLS^552~DAYTDEV.FO-BAYPINES.MED.VA.GOV~DNS^GMRV VDEF IESIDE^200HD~HDR.MED.VA.GOV~DNS^20061006151615-0800^^ORU~R01^55253408603^T^2.4^^^AL^NE^US\r\n"
                + "ORC^RE^^6240020~552_120.5^^^^^^^^^^OBS23~325~~~~~~~23 HOUR OBSERVATION^^^^552~DAYTON~L^^^^DAYTON\r\n"
                + "OBR^^^6240020~552_120.5^4500635~PAIN~99VA120.51^^^200610061445-0800^20061006144607-0800^^^^^^^^^^^^^^20061006144607-0800^^^E^^^^^^^^^123456&NURSE&THREE&A&III&MS&RN&VistA200\r\n"
                + "OBX^^ST^4500635~PAIN~99VA120.51^^3^~~L^^^^^W^^^^^123456&NURSE&THREE&A&III&MS&RN&VistA200\r\n"
                + "OBX^^CE^Error Reasons^^4500627~INCORRECT READING~99VA8985.1^^^^^^W^^^^^123456&NURSE&THREE&A&III&MS&RN&VistA200\r\n" + "ZSC^^291^OBSERVATION SURGERY";

        parser.parse(msg);

    }

    public void testUnknownVersion() throws EncodingNotSupportedException, HL7Exception {

        String message = "MSH|^~\\&|^QueryServices||||20021011161756.297-0500||ORU^R01|1|D|2.999\r" + // 
                "ORC|ORC1\r" + //
                "OBX|1\r" + //
                "NTE|||NTE1|\r" + //
                "ZNT|ZNT1\r" + //
                "ORC|ORC2";

        try {
            ORU_R01 parsed = (ORU_R01) parser.parse(message);
            fail(parser.encode(parsed));
        } catch (HL7Exception e) {
            assertEquals(HL7Exception.UNSUPPORTED_VERSION_ID, e.getErrorCode());
        }

    }

    public void testParseNonStandardSegment() throws EncodingNotSupportedException, HL7Exception {

        String message = "MSH|^~\\&|^QueryServices||||20021011161756.297-0500||ORU^R01|1|D|2.4\r" + // 
                "ORC|ORC1\r" + //
                "OBX|1\r" + //
                "NTE|||NTE1|\r" + //
                "ZNT|ZNT1\r" + //
                "ORC|ORC2";

        ORU_R01 parsed = (ORU_R01) parser.parse(message);
        System.out.println(parser.encode(parsed));

        assertEquals("ORC1", parsed.getPATIENT_RESULT(0).getORDER_OBSERVATION(0).getORC().getOrderControl().getValue());
        assertEquals("1", parsed.getPATIENT_RESULT(0).getORDER_OBSERVATION(0).getOBSERVATION(0).getOBX().getSetIDOBX().getValue());
        assertEquals("NTE1", parsed.getPATIENT_RESULT(0).getORDER_OBSERVATION(0).getOBSERVATION(0).getNTE(0).getComment(0).getValue());
        assertEquals("ORC2", parsed.getPATIENT_RESULT(0).getORDER_OBSERVATION(1).getORC().getOrderControl().getValue());
        Segment znt = (Segment) parsed.getPATIENT_RESULT(0).getORDER_OBSERVATION(0).getOBSERVATION(0).get("ZNT");
        assertNotNull(znt);
        assertEquals("ZNT1", ((Primitive) ((Varies) znt.getField(1, 0)).getData()).getValue());

        message = "MSH|^~\\&|^QueryServices||||20021011161756.297-0500||ORU^R01|1|D|2.4\r" + // 
                "ORC|ORC1\r" + //
                "OBX|1\r" + //
                "NTE|||NTE1|\r" + //
                "ZNT|ZNT1";

        parsed = (ORU_R01) parser.parse(message);
        System.out.println(parser.encode(parsed));

        assertEquals("ORC1", parsed.getPATIENT_RESULT(0).getORDER_OBSERVATION(0).getORC().getOrderControl().getValue());
        assertEquals("1", parsed.getPATIENT_RESULT(0).getORDER_OBSERVATION(0).getOBSERVATION(0).getOBX().getSetIDOBX().getValue());
        assertEquals("NTE1", parsed.getPATIENT_RESULT(0).getORDER_OBSERVATION(0).getOBSERVATION(0).getNTE(0).getComment(0).getValue());
        znt = (Segment) parsed.getPATIENT_RESULT(0).getORDER_OBSERVATION(0).getOBSERVATION(0).get("ZNT");
        assertNotNull(znt);
        assertEquals("ZNT1", ((Primitive) ((Varies) znt.getField(1, 0)).getData()).getValue());

    }

    public void testEmptySegment() throws EncodingNotSupportedException, HL7Exception {
        String msg = "MSH|^~\\&|1444-ADT|1444|S-ADT|SIMS|20071023160622||ADT^A03^ADT_A05|Q67084255T54052896X2|P^T|2.5|||NE|AL|CAN|8859/1\r\n"
                + "EVN|A03|20071023160622\r\n"
                + "PID|1||00J8804997^^^1444^MR~165640^^^CANON^JHN^^^^^WT||Aalan^Angus^^^^^L||19620404|F|||101 Ames Ave^^Toronto^CA- ON^M2N7J6^CAN^H||^PRN^PH^^1^416^5551545|^PRN^PH^^1^416^2227788|| C||||||||||||||N\r\n"
                + "PV1";
        Message message = parser.parse(msg);
    }

    private static class FooEncodingRule implements EncodingRule {
        /**
         * @see ca.uhn.hl7v2.validation.EncodingRule#test(java.lang.String)
         */
        public ValidationException[] test(String arg0) {
            if (arg0.indexOf("foo") < 0) {
                return new ValidationException[] { new ValidationException("Not enough foo") };
            } else {
                return new ValidationException[] {};
            }
        }

        /**
         * @see ca.uhn.hl7v2.validation.Rule#getDescription()
         */
        public String getDescription() {
            return null;
        }

        /**
         * @see ca.uhn.hl7v2.validation.Rule#getSectionReference()
         */
        public String getSectionReference() {
            return null;
        }
    }

    private static class BarMessageRule implements MessageRule {

        /**
         * @see ca.uhn.hl7v2.validation.MessageRule#test(ca.uhn.hl7v2.model.Message)
         */
        public ValidationException[] test(Message arg0) {
            Terser t = new Terser(arg0);
            String msh3;
            try {
                msh3 = t.get("/MSH-3");
            } catch (HL7Exception e) {
                return new ValidationException[] { new ValidationException("Bad bar") };
            }
            if (!msh3.equals("bar")) {
                return new ValidationException[] { new ValidationException("Not enough bar") };
            } else {
                return new ValidationException[] {};
            }
        }

        /**
         * @see ca.uhn.hl7v2.validation.Rule#getDescription()
         */
        public String getDescription() {
            return null;
        }

        /**
         * @see ca.uhn.hl7v2.validation.Rule#getSectionReference()
         */
        public String getSectionReference() {
            return null;
        }
    }

    /**
     * Make sure IS and ID datatypes are supported as OBX-5 values
     */
    public void testParseObx5WithTypeRequiringTable() throws EncodingNotSupportedException, HL7Exception {

        String string = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r"
                + "ZPI|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r"
                + "PID|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r"
                + "PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST\r"
                + "ORC|RE||T09-100442-RET-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r"
                + "OBR|0||T09-100442-RET-0^^OLIS_Site_ID^ISO|RET^RETICULOCYTE COUNT^HL79901 literal|||200905011106|||||||200905011106||OLIST^BLAKE^DONALD^THOR^^^^L^921379||7870279|7870279|T09-100442|MOHLTC|200905011130||B7|F||1^^^200905011106^^R\r"
                + "OBX|1|IS|Z114099^Erc^L||ABC||||||F|||200905011111|PMH\r";

        parser.parse(string);

    }

    public void testMissingSegment() throws EncodingNotSupportedException, HL7Exception {

        String messageString = "MSH|^~\\&|BLAH|Default Facility|||20100604104559||REF^I12^REF_I12|||2.5\r\n" + "SFT|BLAH|BLAH|BLAH|2010/06/04 10:44, branch : trunk\r\n"
                + "RF1||||||15|20100601000000\r\n" + "PRD|RP^Referring Provider|foo^doctor^^^DR|^^^^^^O||||999998\r\n"
                + "PRD|RT^Referred to Provider|moto^moto^^^r6|^^^^^^O||^^^^^^^^^^^411||8\r\n" + "PID|1||^^^^^^20100525^21000101^ON||aaa^aaa^^^^^L||19000101|M|||^^^ON^^^H\r\n"
                + "NTE|||asfd notes|^APPOINTMENT_NOTES\r\n" + "NTE|||engine oil problem, and maybe needs new plugs|^REASON_FOR_CONSULTATION\r\n"
                + "NTE|||86k km|^CLINICAL_INFORMATION\r\n" + "NTE|||goes too slow|^CONCURRENT_PROBLEMS\r\n" + "NTE|||91 octane|^CURRENT_MEDICATIONS\r\n"
                + "NTE|||scooters|^ALLERGIES";

        REF_I12 message = (REF_I12) parser.parse(messageString);

        ourLog.info("Structure is: " + message.printStructure());

        ourLog.info("Going to parse/encode");
        message.parse(message.encode());

        ourLog.info("Structure is: " + message.printStructure());

    }

}
