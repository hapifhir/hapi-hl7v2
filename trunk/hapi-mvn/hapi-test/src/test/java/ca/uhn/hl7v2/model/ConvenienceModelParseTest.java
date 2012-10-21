package ca.uhn.hl7v2.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ca.uhn.hl7v2.parser.PipeParser;

public class ConvenienceModelParseTest {
    private PipeParser parser;

    @Before
  	public void setUp() throws Exception {
		parser = new PipeParser();
	}

    @Test
    public void testMessageParse() throws Exception {

		String string = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r"
				+ "PID|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r"
				+ "PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST\r"
				+ "ORC|RE||T09-100442-RET-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r"
				+ "OBR|0||T09-100442-RET-0^^OLIS_Site_ID^ISO|RET^RETICULOCYTE COUNT^HL79901 literal|||200905011106|||||||200905011106||OLIST^BLAKE^DONALD^THOR^^^^L^921379||7870279|7870279|T09-100442|MOHLTC|200905011130||B7|F||1^^^200905011106^^R\r"
				+ "OBX|1|NM|Z114099^Erc^L||4.00|tril/L|3.90-5.60||||F|||200905011111|PMH\r"
				+ "ZPI|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r";

		Message message = new ca.uhn.hl7v2.model.v23.message.ORU_R01();
        message.parse(string);

		String reEncoded = parser.encode(message);
		assertEquals(string, reEncoded);

    }

}
