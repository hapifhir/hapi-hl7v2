package ca.uhn.hl7v2.parser;

import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.model.v251.message.ACK;

/**
 * Tests all generated message structures to ensure that they can be instantiated correctly
 */
public class MessageStructuresTest {

	private static Logger ourLog = LoggerFactory.getLogger(MessageStructuresTest.class);

	private static final Set<String> SKIP = new HashSet<String>();

	static {
		SKIP.add("ca.uhn.hl7v2.model.v23.message.RRE_O02");
		SKIP.add("ca.uhn.hl7v2.model.v23.message.ORU_W01");
		SKIP.add("ca.uhn.hl7v2.model.v231.message.ROR_ROR");
		SKIP.add("ca.uhn.hl7v2.model.v231.message.MFN_M07");
		SKIP.add("ca.uhn.hl7v2.model.v24.message.QRY_P04");
		SKIP.add("ca.uhn.hl7v2.model.v26.message.BRP_O30");
	}

	@Test
	public void testAllMessages() throws Exception {

		AbstractModelClassFactory amcf = new DefaultModelClassFactory();
		Map<Version, Properties> map = amcf.getEventMap();
		for (Version nextVersion : Version.values()) {

			Properties structures = map.get(nextVersion);
			for (Map.Entry<Object, Object> nextEntry : structures.entrySet()) {
				String nextStructure = nextEntry.getValue().toString();
				if ("?".equals(nextStructure)) {
					continue;
				}

				String className = DefaultModelClassFactory.getVersionPackageName(nextVersion
						.getVersion()) + "message." + nextStructure;

				/*
				 * The DB has a few weird entries we ignore
				 * 
				 * TODO: investigate why
				 */
				if (SKIP.contains(className)) continue;

				ourLog.debug("Instantiating " + className);
				Class<?> clazz = Class.forName(className);

				try {
					clazz.getConstructor(new Class<?>[0]).newInstance(new Object[0]);
				} catch (Exception e) {
					Assert.fail("Error instantiating " + className + " - " + e.getMessage());
				}
			}

		}

	}

	/**
	 * Make sure the "reps" methods are generated
	 */
	public void testRepsMethods() throws HL7Exception {

		ACK ack = new ACK();
		ack.getERR().getErr1_ErrorCodeAndLocationReps();
		ack.getERR().getErrorCodeAndLocationReps();
		ack.getERRAll();

	}

}
