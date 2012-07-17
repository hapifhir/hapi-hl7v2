package ca.uhn.hl7v2.util.idgenerator;

import java.io.IOException;

import ca.uhn.hl7v2.util.idgenerator.IDGenerator;

public class DummyIDGenerator implements IDGenerator {

	static final String TEST_ID = "ifunhvsruivnh";

	public String getID() throws IOException {
		return TEST_ID;
	}
	
}