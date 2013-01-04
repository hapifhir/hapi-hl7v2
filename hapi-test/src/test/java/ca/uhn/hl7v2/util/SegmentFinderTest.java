package ca.uhn.hl7v2.util;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Primitive;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.v24.message.ADT_A01;
import ca.uhn.hl7v2.model.v24.segment.ROL;
import ca.uhn.hl7v2.model.v26.group.ORU_R01_ORDER_OBSERVATION;
import ca.uhn.hl7v2.model.v26.group.ORU_R01_PATIENT;
import ca.uhn.hl7v2.model.v26.message.ORU_R01;
import ca.uhn.hl7v2.model.v26.segment.PID;
import ca.uhn.hl7v2.model.v26.segment.SFT;

/**
 * JUnit tests for SegmentFinder
 * 
 * @author bryan
 */
public class SegmentFinderTest {

	private SegmentFinder finder;

	@Before
	public void setUp() throws Exception {
		ADT_A01 msg = new ADT_A01();
		msg.getROL().getActionCode().setValue("a");
		msg.getROL2().getActionCode().setValue("b");
		msg.getPROCEDURE().getROL().getActionCode().setValue("c");
		msg.getINSURANCE().getROL().getActionCode().setValue("d");
		finder = new SegmentFinder(msg);
	}

	@Test
	public void testFind() throws Exception {
		Segment s = finder.findSegment("ROL", 0);
		assertEquals("a", getTestVal(s));
		s = finder.findSegment("ROL", 0);
		assertEquals("b", getTestVal(s));
		s = finder.findSegment("ROL", 0);
		assertEquals("c", getTestVal(s));
		s = finder.findSegment("ROL", 0);
		assertEquals("d", getTestVal(s));
	}

	private String getTestVal(Segment s) {
		ROL rol = (ROL) s;
		return rol.getActionCode().getValue();
	}

	@Test
	public void testFindGroup() throws HL7Exception, IOException {

		ORU_R01 r01 = new ORU_R01();
		r01.initQuickstart("ORU", "R01", "T");

		r01.getSFT(0).getSft1_SoftwareVendorOrganization().parse("A");
		r01.getSFT(1).getSft1_SoftwareVendorOrganization().parse("B");
		r01.getSFT(2).getSft1_SoftwareVendorOrganization().parse("C");
		
		r01.getPATIENT_RESULT().getPATIENT().getPID().getPid1_SetIDPID().parse("1");
		r01.getPATIENT_RESULT().getORDER_OBSERVATION(0).getOBR().getObr1_SetIDOBR().parse("2");
		r01.getPATIENT_RESULT().getORDER_OBSERVATION(1).getOBR().getObr1_SetIDOBR().parse("3");
		r01.getPATIENT_RESULT().getORDER_OBSERVATION(2).getOBR().getObr1_SetIDOBR().parse("4");

		SegmentFinder finder = new SegmentFinder(r01);
		
		SFT sft = (SFT) finder.getSegment("SFT", 0);
		assertEquals("A", sft.getSft1_SoftwareVendorOrganization().encode());

		sft = (SFT) finder.getSegment("SFT", 1);
		assertEquals("B", sft.getSft1_SoftwareVendorOrganization().encode());

		sft = (SFT) finder.getSegment("SFT", 2);
		assertEquals("C", sft.getSft1_SoftwareVendorOrganization().encode());

		PID pid = (PID) finder.findSegment("PID", 0);
		assertEquals("1", pid.getSetIDPID().encode());

		finder = new SegmentFinder(r01);
		ORU_R01_PATIENT patient = (ORU_R01_PATIENT) finder.findGroup("PATIENT", 0);
		pid = patient.getPID();
		assertEquals("1", pid.getSetIDPID().encode());
		
		ORU_R01_ORDER_OBSERVATION oo = (ORU_R01_ORDER_OBSERVATION) finder.findGroup("ORDER_OBSERVATION", 0);
		assertEquals("2", oo.getOBR().getSetIDOBR().encode());

		// TODO: figure out why this doesn't work.. It didn't work before the latest fixes either. Probably never worked
//		oo = (ORU_R01_ORDER_OBSERVATION) finder.findGroup("ORDER_OBSERVATION", 1);
//		assertEquals("3", oo.getOBR().getSetIDOBR().encode());

	}

	@Test
	public void testPid1_1() throws Exception {
		final Message message = loadMessage();
		final SegmentFinder finder = new SegmentFinder(message);
		final Segment segment = finder.findSegment("PID", 0);
		assertEquals("1", ((Primitive) segment.getField(1, 0)).getValue());
	}

	@Test
	public void testPid2_1() throws Exception {
		final Message message = loadMessage();
		final SegmentFinder finder = new SegmentFinder(message);
		// finder.findSegment("PID", 1) doesn't work either
		final Segment segment = finder.findSegment("PID2", 0);
		assertEquals("2", ((Primitive) segment.getField(1, 0)).getValue());
	}

	private Message loadMessage() {
		return Hl7InputStreamMessageIterator.getForClasspathResource("/ca/uhn/hl7v2/util/segmentfinder_a24.hl7").next();
	}

}
