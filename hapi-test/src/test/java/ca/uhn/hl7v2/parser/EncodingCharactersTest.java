package ca.uhn.hl7v2.parser;

import org.junit.Test;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.v24.message.ORU_R01;

public class EncodingCharactersTest  {

    @Test(expected=HL7Exception.class)
	public void testValidateMSH2() throws HL7Exception {

		// MSH-2 has only three chars
		String msgString = "MSH|~\\&|PHCN_ULTRA|2220|HSIE|2220|201106161233||ORU^R01|72313573|T|2.4|||AL|AL|AU\r\n"
				+ "PV1||I|^DIS^DIS^2220|||||0129296H^BRAUN^GARY|7MPH^MPH-HL7-RESULT FEED|||||||||I|^^^2220\r\n"
				+ "ORC|RE|^HNAM_ORDERID|11-6879530-GAS-0^PHCN_ULTRA||RE\r\n"
				+ "OBR|1|^HNAM_ORDERID|11-6879530-GAS-0^PHCN_ULTRA|GAS^GASES (BLOOD)|||201106161000|||||||||0129296H^BRAUN^GARY^^^DR^^^2220^^^^Provider Num||||1295102|7MPH|201106161233||GRP|F||^^^201106161203\r\n"
				+ "OBX|1|FT|GAS^^LN|| Biochemistry (Whole Blood Sample) - Type Venous\\.br\\\\.br\\ Analysis Date : 16/06/2011\\.br\\ Analysis Time : 12:21\\.br\\\\.br\\ Measured Parameters :\\.br\\ pH : \\H\\ 7.28\\N\\ (7.38-7.43) *\\.br\\ pCO2 : \\H\\ 117\\N\\ mmHg (35-45) ***\\.br\\ pO2 : \\H\\ 37\\N\\ mmHg\\.br\\ Sodium : 140 mmol/L (136-142)\\.br\\ Potassium : 3.8 mmol/L (3.8-5.0)\\.br\\ Chloride : \\H\\ 83\\N\\ mmol/L (95-110) *\\.br\\ Ionised Calcium : 1.23 mmol/L (1.15-1.29)\\.br\\ Lactate : \\H\\ 2.1\\N\\ mmol/L (0.5-2.0) *\\.br\\ Glucose : \\H\\ 10.9\\N\\ mmol/L (4.0-7.8) *\\.br\\ Haemoglobin : 13.9 g/dL (11.5-16.5)\\.br\\ FO2Hb : \\H\\ 60.7\\N\\ % (94.0-97.0) *\\.br\\ FCOHb : \\H\\ 2.1\\N\\ % (< 1.5) *\\.br\\ FmetHb : 0.5 % (< 1.5)\\.br\\ FHHb : \\H\\ 36.7\\N\\ % (< 5.0) *\\.br\\ Haematocrit : 42.6 % (37.0-47.0)\\.br\\\\.br\\ Calculated (37 \\S\\o C) :\\.br\\ Actual HCO3 : \\H\\ 54\\N\\ mmol/L (20-24) ***\\.br\\ Standard HCO3 : \\H\\ 43\\N\\ mmol/L (22-26) *\\.br\\ Base Excess : \\H\\ +19.6\\N\\ mmol/L (-3.3 - +1.2) *\\.br\\ Oxygen Saturation : \\H\\ 62.5\\N\\ %\\.br\\\\.br\\ Note: The reference intervals for pH, pCO2 and pO2 apply for arterial\\.br\\ samples only.|||A|||F ";

		ORU_R01 msg = new ORU_R01();
		msg.parse(msgString);
		msg.encode().replace('\r', '\n');	
	}
	
	
}
