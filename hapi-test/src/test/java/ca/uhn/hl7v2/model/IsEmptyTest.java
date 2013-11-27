package ca.uhn.hl7v2.model;

import ca.uhn.hl7v2.model.v231.datatype.CE;
import ca.uhn.hl7v2.model.v231.datatype.ST;
import ca.uhn.hl7v2.model.v231.message.ADT_A08;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 */
public class IsEmptyTest {

    private final String ACTIVE_NULL = "\"\"";
    private ADT_A08 hl7In;

    @Before
    public void setup() throws Exception {
        hl7In = new ADT_A08();
    }

    @Test
    public void testIsEmptyInEmptyMessage() throws Exception {
        hl7In.initQuickstart("ADT", "A08", "P");
        ST ssnNumber = hl7In.getPID().getPid19_SSNNumberPatient();
        assertTrue(ssnNumber.isEmpty());
        ssnNumber.parse("");
        assertTrue(ssnNumber.isEmpty());
        ssnNumber.parse("^^^^^");
        assertTrue(ssnNumber.isEmpty());
        ssnNumber.parse(ACTIVE_NULL);
        assertFalse(ssnNumber.isEmpty());
        ssnNumber.parse(ACTIVE_NULL + "^^^^");
        assertFalse(ssnNumber.isEmpty());

        assertFalse(hl7In.getPID().isEmpty());
        assertTrue(hl7In.getPD1().isEmpty());
        assertTrue(hl7In.getNK1().isEmpty());
        assertTrue(hl7In.getIN1IN2IN3().isEmpty());
        assertTrue(hl7In.getIN1IN2IN3().getIN1().isEmpty());

    }

    @Test
    public void testIsEmptyInValidMessage1() throws Exception {
        String inputHl7 = "MSH|^~\\&|HOMER|fake|DGATE-FAKE^prjHbcisRawIn|99999|20130923023038||ADT^A08|2013092302303834022003|P|2.3|||AL|AL|AUS|ASCII|ENG\r"
                + "EVN|A08|20130923023038|\r"
                + "PID|1|\"\"|708010^^^MRN^MR|PENSION NO^^^DSS^PE|SURNAME^GIVEN^^^MRS^^L||19381216|F||14|UNIT A/1 FAKE ST^\"\"^BRISBANE^^4000^\"\"^P||12345678^PRN^^^^^12345678||86^ENGLISH ONLY|W|2233|708010-4|4072469157||||1101||||||20130923|Y\r";
        hl7In.parse(inputHl7);
        ST ssnNumber = hl7In.getPID().getPid19_SSNNumberPatient();
        CE primaryLanguage = hl7In.getPID().getPid15_PrimaryLanguage();
        assertFalse(ssnNumber.isEmpty());
        assertFalse(primaryLanguage.isEmpty());
        assertFalse(primaryLanguage.getCe1_Identifier().isEmpty());

        // Test emptiness of repeatable(/not-repeatable segments and groups
        assertFalse(hl7In.getPID().isEmpty());
        assertTrue(hl7In.getPD1().isEmpty());
        assertTrue(hl7In.getNK1().isEmpty());
        assertTrue(hl7In.getIN1IN2IN3().isEmpty());
        assertTrue(hl7In.getIN1IN2IN3().getIN1().isEmpty());
    }

    @Test
    public void testIsEmptyInValidMessage2() throws Exception {
        String inputHl7 = "MSH|^~\\&|HOMER|fake|DGATE-FAKE^prjHbcisRawIn|99999|20130923023038||ADT^A08|2013092302303834022003|P|2.3|||AL|AL|AUS|ASCII|ENG\r"
                + "EVN|A08|20130923023038|\r"
                + "PID|1|\"\"|708010^^^MRN^MR|PENSION NO^^^DSS^PE|SURNAME^GIVEN^^^MRS^^L||19381216|F||14|UNIT A/1 FAKE ST^\"\"^BRISBANE^^4000^\"\"^P||12345678^PRN^^^^^12345678||^^^^^|W|2233|708010-4|||||1101||||||20130923|Y\r";
        hl7In.parse(inputHl7);
        ST ssnNumber = hl7In.getPID().getPid19_SSNNumberPatient();
        CE primaryLanguage = hl7In.getPID().getPid15_PrimaryLanguage();
        assertTrue(ssnNumber.isEmpty());
        assertTrue(primaryLanguage.isEmpty());
        assertTrue(primaryLanguage.getCe1_Identifier().isEmpty());
        assertTrue(primaryLanguage.getCe2_Text().isEmpty());
        assertTrue(primaryLanguage.getCe3_NameOfCodingSystem().isEmpty());
        assertTrue(primaryLanguage.getCe4_AlternateIdentifier().isEmpty());
        assertTrue(primaryLanguage.getCe5_AlternateText().isEmpty());
        assertTrue(primaryLanguage.getCe6_NameOfAlternateCodingSystem().isEmpty());
    }
}
