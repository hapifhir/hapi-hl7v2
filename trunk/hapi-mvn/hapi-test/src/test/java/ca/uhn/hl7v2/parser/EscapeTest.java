package ca.uhn.hl7v2.parser;

 import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

 import ca.uhn.hl7v2.DefaultHapiContext;
 import ca.uhn.hl7v2.HapiContext;
 import org.junit.Test;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.v23.message.ORU_R01;
import ca.uhn.hl7v2.model.v24.datatype.FT;
import ca.uhn.hl7v2.validation.impl.ValidationContextImpl;

/**
 * JUnit test cases for Escape.  
 * @author bryan
 */
public class EscapeTest {
    
    private EncodingCharacters enc = new EncodingCharacters('|', null);
    private Escaping esc = new DefaultEscaping();
    
	@Test
    public void testUnescape() throws Exception {
        String uu = getUuencodedEscapedString();
        esc.unescape(uu, enc);
    }
    
	@Test
    public void testSimpleEscape() {
        String actual = esc.escape("GLUCOSE^1H POST 75 G GLUCOSE PO:SCNC:PT:SER/PLAS:QN", enc);
        String expected = "GLUCOSE\\S\\1H POST 75 G GLUCOSE PO:SCNC:PT:SER/PLAS:QN";
        assertEquals(expected, actual);
    }

	// Escaping of truncation # is not implemented yet. It may only be escaped if it is the first character that
	// exceeds the conformance length of the component (ch 2.5.5.2). As of now, this information is not
	// available yet.
	@Test
	public void testTruncationEscape() {
		String actual = esc.escape("Truncation#escape", enc);
		String expected = "Truncation#escape";
		assertEquals(expected, actual);
	}
    
    /** 
     * Loads an escaped, uuencoded string from a file -- this is real data
     * provided by Mark Lee of Skeva Tech.  
     */
    private String getUuencodedEscapedString() throws IOException {
        ClassLoader loader = this.getClass().getClassLoader();
        InputStream inStream = loader.getResourceAsStream("ca/uhn/hl7v2/parser/uuencoded_escaped.txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(inStream));
        String line;
        StringBuffer content = new StringBuffer();
        while ( (line = in.readLine()) != null) {
            content.append(line);
        }
        in.close();
        return content.toString();
    }
    
//    /** 
//     * Loads a uuencoded string from a file (not escaped) -- this is real data
//     * provided by Mark Lee of Skeva Tech.  
//     */
//    private String getUuencodedString() throws IOException {
//        ClassLoader loader = this.getClass().getClassLoader();
//        InputStream inStream = loader.getResourceAsStream("ca/uhn/hl7v2/parser/uuencoded.txt");
//        BufferedReader in = new BufferedReader(new InputStreamReader(inStream, "US-ASCII"));
//        return IOUtil.toString(in);
//    }

	@Test
	public void testFormattingCharacters() throws HL7Exception {

		String msg = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200911231509||ORU|5951|T|2.3\r" +
				"PID|||7005728^^^TML^MR||LEIGHTON^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6H 2T9||(416)888-8888||||||1014071185^KR\r" +
				"PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST|||||||||^N\r" +
				"ORC|RE||T09-106575-CHO-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r" +
				"OBR|0||T09-106575-CHO-0^^OLIS_Site_ID^ISO|CHO^CHOLESTEROL (SERUM)^HL79901 literal|||200911231455|||||||200911231455||OLIST^BLAKE^DONALD^THOR^^^^L^921379||10015716|10015716|T09-106575|MOHLTC|200911231509||B1|F||1^^^200911231455^^R\r" +
				"NTE|1|L|\\.br\\                  Lipid - Target Levels for Treatment \\.br\\\\.br\\  ****************************************************************\\.br\\  \\F\\  Risk   \\F\\                  \\F\\                                 \\F\\\\.br\\  \\F\\ Level   \\F\\ 10-year CAD risk \\F\\         Recommendations         \\F\\\\.br\\  \\F\\---------\\F\\------------------\\F\\---------------------------------\\F\\\\.br\\  \\F\\         \\F\\                  \\F\\Treatment targets:               \\F\\\\.br\\  \\F\\High*    \\F\\      >=20%       \\F\\ Primary:   LDL-C    <2.0 mmol/L \\F\\\\.br\\  \\F\\         \\F\\                  \\F\\ Secondary: TC/HDL-C <4.0        \\F\\\\.br\\  \\F\\---------\\F\\------------------\\F\\---------------------------------\\F\\\\.br\\  \\F\\         \\F\\                  \\F\\Treat when:                      \\F\\\\.br\\  \\F\\Moderate \\F\\    10 - 19 %     \\F\\            LDL-C    >=3.5 mmol/L\\F\\\\.br\\  \\F\\         \\F\\                  \\F\\         or TC/HDL-C >=5.0       \\F\\\\.br\\  \\F\\---------\\F\\------------------\\F\\---------------------------------\\F\\\\.br\\  \\F\\         \\F\\                  \\F\\Treat when:                      \\F\\\\.br\\  \\F\\Low      \\F\\      <10%        \\F\\            LDL-C    >=5.0 mmol/L\\F\\\\.br\\  \\F\\         \\F\\                  \\F\\         or TC/HDL-C >=6.0       \\F\\\\.br\\****************************************************************\\.br\\  Notes:\\.br\\  *  10-year coronary artery disease (CAD) risk is accessed by\\.br\\     Framingham risk estimate tables.\\.br\\  *  *High risk includes CAD, peripheral artery disease, cerebro-\\.br\\     vascular disease (CVD) and most patients with chronic kidney\\.br\\     disease or established diabetes mellitus.\\.br\\  *  The patient must have been fasting for at least 12 hours prior\\.br\\     to taking ablood sample.\\.br\\  *  Calculation:  LDL-C (mmol/L) = Chol - (HDL-C + 0.46 x TG).\\.br\\     Calculation is invalid if TG exceed 4.5 mmol/L.\\.br\\  Ref:  McPherson R et al. Can J Cardiol. 2006 Sep;22(11):913-27\r" +
				"OBX|1|NM|Z049107^Cholesterol-serum^L||2.30|mmol/L|||||F|||200911231508|STP\r" +
				"OBX|2|FT|Z101068^Tech Comment^L||Lab STP||||||F|||200911231508|STP";

        HapiContext context = new DefaultHapiContext(new ValidationContextImpl());
		ORU_R01 message = context.newMessage(ORU_R01.class);

		message.parse(msg);

		String encoded = message.encode();
		// System.out.println("Encoded message: \r\n" + encoded);

		assertEquals(msg.trim(), encoded.trim());

	}
	
	// Issue 3323850
	@Test
	public void testFormattingCharacters2() throws HL7Exception {

		String msg = "MSH|^~\\&|PHCN_ULTRA|2220|HSIE|2220|201106161233||ORU^R01|72313573|T|2.4|||AL|AL|AU\r" +
					 "PV1||I|^DIS^DIS^2220|||||0129296H^BRAUN^GARY|7MPH^MPH-HL7-RESULT FEED|||||||||I|^^^2220\r" +
					 "ORC|RE|^HNAM_ORDERID|11-6879530-GAS-0^PHCN_ULTRA||RE\r" +
					 "OBR|1|^HNAM_ORDERID|11-6879530-GAS-0^PHCN_ULTRA|GAS^GASES (BLOOD)|||201106161000|||||||||0129296H^BRAUN^GARY^^^DR^^^2220^^^^Provider Num||||1295102|7MPH|201106161233||GRP|F||^^^201106161203\r" +
					 "OBX|1|FT|GAS^^LN||Biochemistry (Whole Blood Sample) - Type Venous\\.br\\\\.br\\ Analysis Date : 16/06/2011\\.br\\ Analysis Time : 12:21\\.br\\\\.br\\ Measured Parameters :\\.br\\ pH : \\H\\ 7.28\\N\\ (7.38-7.43) *\\.br\\ pCO2 : \\H\\ 117\\N\\ mmHg (35-45) ***\\.br\\ pO2 : \\H\\ 37\\N\\ mmHg\\.br\\ Sodium : 140 mmol/L (136-142)\\.br\\ Potassium : 3.8 mmol/L (3.8-5.0)\\.br\\ Chloride : \\H\\ 83\\N\\ mmol/L (95-110) *\\.br\\ Ionised Calcium : 1.23 mmol/L (1.15-1.29)\\.br\\ Lactate : \\H\\ 2.1\\N\\ mmol/L (0.5-2.0) *\\.br\\ Glucose : \\H\\ 10.9\\N\\ mmol/L (4.0-7.8) *\\.br\\ Haemoglobin : 13.9 g/dL (11.5-16.5)\\.br\\ FO2Hb : \\H\\ 60.7\\N\\ % (94.0-97.0) *\\.br\\ FCOHb : \\H\\ 2.1\\N\\ % (< 1.5) *\\.br\\ FmetHb : 0.5 % (< 1.5)\\.br\\ FHHb : \\H\\ 36.7\\N\\ % (< 5.0) *\\.br\\ Haematocrit : 42.6 % (37.0-47.0)\\.br\\\\.br\\ Calculated (37 \\S\\o C) :\\.br\\ Actual HCO3 : \\H\\ 54\\N\\ mmol/L (20-24) ***\\.br\\ Standard HCO3 : \\H\\ 43\\N\\ mmol/L (22-26) *\\.br\\ Base Excess : \\H\\ +19.6\\N\\ mmol/L (-3.3 - +1.2) *\\.br\\ Oxygen Saturation : \\H\\ 62.5\\N\\ %\\.br\\\\.br\\ Note: The reference intervals for pH, pCO2 and pO2 apply for arterial\\.br\\ samples only.|||A|||F ";

		// ca.uhn.hl7v2.model.v24.message.ORU_R01 message = new ca.uhn.hl7v2.model.v24.message.ORU_R01();
		Parser p = PipeParser.getInstanceWithNoValidation();

		ca.uhn.hl7v2.model.v24.message.ORU_R01 message = (ca.uhn.hl7v2.model.v24.message.ORU_R01)p.parse(msg);
		
		int intCountOBR = message.getPATIENT_RESULT().getORDER_OBSERVATIONReps();
		for (int i = 0; i < intCountOBR; i++) {
			message.getPATIENT_RESULT().getORDER_OBSERVATION(i).getOBR().removeObr16_OrderingProvider(0);
		}

		String encoded = message.encode();
		// System.out.println("Encoded message: \r\n" + encoded);
		assertEquals(msg.trim(), encoded.trim());
	}	

	@Test
	public void testPreserveFormattingChars() throws HL7Exception, IOException {
		
		ORU_R01 msg = new ORU_R01();
		msg.initQuickstart("ORU", "R01", "T");
		
		FT ft = new FT(msg);
		msg.getRESPONSE().getORDER_OBSERVATION().getOBSERVATION().getOBX().getObx2_ValueType().setValue("FT");
		msg.getRESPONSE().getORDER_OBSERVATION().getOBSERVATION().getOBX().getObx5_ObservationValue(0).setData(ft);
		
		ft.setValue("H \\H\\ N \\N\\ ");
		assertEquals("H \\H\\ N \\N\\ ", ft.getValue());
		assertEquals("H \\H\\ N \\N\\ ", ft.encode());

		ft.setValue("H \\C00FF\\ N");
		assertEquals("H \\C00FF\\ N", ft.getValue());
		assertEquals("H \\C00FF\\ N", ft.encode());
		
	}

}
