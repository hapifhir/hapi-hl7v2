package ca.uhn.hl7v2.parser;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.v23.message.ORU_R01;
import ca.uhn.hl7v2.validation.impl.ValidationContextImpl;
import junit.framework.*;
import java.io.*;

/**
 * JUnit test cases for Escape.  
 * @author bryan
 */
public class EscapeTest extends TestCase {
    
    private EncodingCharacters enc;
    
    public EscapeTest(java.lang.String testName) {
        super(testName);
        this.enc = new EncodingCharacters('|', null);
    }
    
    public static void main(java.lang.String[] args) throws HL7Exception {
		new EscapeTest("aaa").testFormattingCharacters();

        junit.textui.TestRunner.run(suite());
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite(EscapeTest.class);
        return suite;
    }
    
    public void testUnescape() throws Exception {
        String uu = getUuencodedEscapedString();
        String result = Escape.unescape(uu, enc); 
        //System.out.println(uu);
        //System.out.println(result);
        //BufferedWriter out = new BufferedWriter(new FileWriter("c:/hapi/foo.txt"));
        //out.write(result);
        //out.close();
    }
    
    /** 
     * Loads an escaped, uuencoded string from a file -- this is real data
     * provided by Mark Lee of Skeva Tech.  
     */
    private String getUuencodedEscapedString() throws IOException {
        ClassLoader loader = this.getClass().getClassLoader();
        InputStream inStream = loader.getResourceAsStream("ca/uhn/hl7v2/parser/uuencoded_escaped.txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(inStream));
        String line = null;
        StringBuffer content = new StringBuffer();
        while ( (line = in.readLine()) != null) {
            content.append(line);
        }
        in.close();
        return content.toString();
    }
    
    /** 
     * Loads a uuencoded string from a file (not escaped) -- this is real data
     * provided by Mark Lee of Skeva Tech.  
     */
    private String getUuencodedString() throws IOException {
        ClassLoader loader = this.getClass().getClassLoader();
        InputStream inStream = loader.getResourceAsStream("ca/uhn/hl7v2/parser/uuencoded.txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(inStream));
        String line = null;
        StringBuffer content = new StringBuffer();
        while ( (line = in.readLine()) != null) {
            content.append(line);
        }
        in.close();
        return content.toString();
    }

	public void testFormattingCharacters() throws HL7Exception {

		String msg = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200911231509||ORU|5951|T|2.3\r" +
				"PID|||7005728^^^TML^MR||LEIGHTON^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6H 2T9||(416)888-8888||||||1014071185^KR\r" +
				"PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST|||||||||^N\r" +
				"ORC|RE||T09-106575-CHO-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r" +
				"OBR|0||T09-106575-CHO-0^^OLIS_Site_ID^ISO|CHO^CHOLESTEROL (SERUM)^HL79901 literal|||200911231455|||||||200911231455||OLIST^BLAKE^DONALD^THOR^^^^L^921379||10015716|10015716|T09-106575|MOHLTC|200911231509||B1|F||1^^^200911231455^^R\r" +
				"NTE|1|L|\\.br\\                  Lipid - Target Levels for Treatment \\.br\\\\.br\\  ****************************************************************\\.br\\  \\F\\  Risk   \\F\\                  \\F\\                                 \\F\\\\.br\\  \\F\\ Level   \\F\\ 10-year CAD risk \\F\\         Recommendations         \\F\\\\.br\\  \\F\\---------\\F\\------------------\\F\\---------------------------------\\F\\\\.br\\  \\F\\         \\F\\                  \\F\\Treatment targets:               \\F\\\\.br\\  \\F\\High*    \\F\\      >=20%       \\F\\ Primary:   LDL-C    <2.0 mmol/L \\F\\\\.br\\  \\F\\         \\F\\                  \\F\\ Secondary: TC/HDL-C <4.0        \\F\\\\.br\\  \\F\\---------\\F\\------------------\\F\\---------------------------------\\F\\\\.br\\  \\F\\         \\F\\                  \\F\\Treat when:                      \\F\\\\.br\\  \\F\\Moderate \\F\\    10 - 19 %     \\F\\            LDL-C    >=3.5 mmol/L\\F\\\\.br\\  \\F\\         \\F\\                  \\F\\         or TC/HDL-C >=5.0       \\F\\\\.br\\  \\F\\---------\\F\\------------------\\F\\---------------------------------\\F\\\\.br\\  \\F\\         \\F\\                  \\F\\Treat when:                      \\F\\\\.br\\  \\F\\Low      \\F\\      <10%        \\F\\            LDL-C    >=5.0 mmol/L\\F\\\\.br\\  \\F\\         \\F\\                  \\F\\         or TC/HDL-C >=6.0       \\F\\\\.br\\****************************************************************\\.br\\  Notes:\\.br\\  *  10-year coronary artery disease (CAD) risk is accessed by\\.br\\     Framingham risk estimate tables.\\.br\\  *  *High risk includes CAD, peripheral artery disease, cerebro-\\.br\\     vascular disease (CVD) and most patients with chronic kidney\\.br\\     disease or established diabetes mellitus.\\.br\\  *  The patient must have been fasting for at least 12 hours prior\\.br\\     to taking ablood sample.\\.br\\  *  Calculation:  LDL-C (mmol/L) = Chol - (HDL-C + 0.46 x TG).\\.br\\     Calculation is invalid if TG exceed 4.5 mmol/L.\\.br\\  Ref:  McPherson R et al. Can J Cardiol. 2006 Sep;22(11):913-27\r" +
				"OBX|1|NM|Z049107^Cholesterol-serum^L||2.30|mmol/L|||||F|||200911231508|STP\r" +
				"OBX|2|FT|Z101068^Tech Comment^L||Lab STP||||||F|||200911231508|STP";

		ORU_R01 message = new ORU_R01();
		message.setValidationContext(new ValidationContextImpl());

		message.parse(msg);

		String encoded = message.encode();
		System.out.println("Encoded message: \r\n" + encoded);

		assertEquals(msg.trim(), encoded.trim());

	}


}
