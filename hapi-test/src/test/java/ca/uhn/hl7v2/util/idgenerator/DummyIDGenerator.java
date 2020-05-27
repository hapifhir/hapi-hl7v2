package ca.uhn.hl7v2.util.idgenerator;

import ca.uhn.hl7v2.util.idgenerator.IDGenerator;

public class DummyIDGenerator implements IDGenerator {

	static final String TEST_ID = "ifunhvsruivnh";

	public String getID() {
		return TEST_ID;
	}
	
}