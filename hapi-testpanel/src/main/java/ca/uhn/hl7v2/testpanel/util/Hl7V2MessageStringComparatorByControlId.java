package ca.uhn.hl7v2.testpanel.util;

import java.util.Comparator;

import org.apache.commons.lang.StringUtils;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.util.Terser;

public class Hl7V2MessageStringComparatorByControlId implements Comparator<String> {
	private static final PipeParser ourParser = PipeParser.getInstanceWithNoValidation();

	@Override
	public int compare(String theS1, String theS2) {

		if (theS1 == null && theS2 == null) {
			return 0;
		}
		if (theS1 == null) {
			return 1;
		}
		if (theS2 == null) {
			return -1;
		}

		Message o1;
		Message o2;
		try {
			o1 = ourParser.parse(theS1);
			o2 = ourParser.parse(theS2);
		} catch (HL7Exception e) {
			throw new Error(e);
		}

		try {
			String c1 = new Terser(o1).get("/MSH-10");
			String c2 = new Terser(o2).get("/MSH-10");

			c1 = StringUtils.defaultString(c1);
			c2 = StringUtils.defaultString(c2);

			return c1.compareToIgnoreCase(c2);

		} catch (HL7Exception e) {
			throw new Error(e);
		}

	}

}