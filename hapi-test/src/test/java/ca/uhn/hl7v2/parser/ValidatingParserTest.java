package ca.uhn.hl7v2.parser;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.Message;
import org.junit.Test;

/**
 * @author Christian Ohr
 */
public class ValidatingParserTest {

    @Test
    public void testValidation() throws Exception {
        String inValidMessage = "MSH|^~\\&|MedSeries|CAISI_1-2|PLS|3910|200903230934||ADT^A31^ADT_A05|75535037-1237815294895|P^T|2.4\r"
                + "EVN|A31|THIS-IS-NOT-DATE-VALUE\r"
                + "PID|1||29^^CAISI_1-2^PI~\"\"||Test300^Leticia^^^^^L||19770202|M||||||||||||||||||||||";

        HapiContext context = new DefaultHapiContext();
        context.getParserConfiguration().setValidating(false); // disable validation
        PipeParser parser = context.getPipeParser();
        Message hapiMsg = parser.parse(inValidMessage); // successfull parsed
        XMLParser xmlParser = context.getXMLParser();
        String xmlDoc = xmlParser.encode(hapiMsg,"XML");
        xmlParser.parse(xmlDoc); // validation still disabled
    }
}
