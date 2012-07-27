package ca.uhn.hl7v2.testpanel.util;

import java.io.StringReader;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.model.Varies;
import ca.uhn.hl7v2.testpanel.ex.UnexpectedTestFailureException;
import ca.uhn.hl7v2.testpanel.util.compare.BulkHl7V2Comparison;
import ca.uhn.hl7v2.testpanel.util.compare.Hl7V2MessageCompare;
import ca.uhn.hl7v2.testpanel.util.compare.IComparisonListener;
import ca.uhn.hl7v2.util.Hl7InputStreamMessageIterator;

public class BulkHl7V2ComparisonTest {

	private static final Logger ourLog = LoggerFactory.getLogger(BulkHl7V2ComparisonTest.class);
	
	@Test
	public void testInvalidMessageTypeComparison() throws UnexpectedTestFailureException {

		System.setProperty(Varies.DEFAULT_OBX2_TYPE_PROP, "ST");
		System.setProperty(Varies.INVALID_OBX2_TYPE_PROP, "ST");
		
		String actual = 
			"MSH|^~\\&|||||||ORD^ORU|||2.2\r"+
			"OBX|||00350^Hb H Test^HDS||.|^^HDS||N|||F||||||1/5101/14\r";
		 
		String expected = 
				"MSH|^~\\&|||||||ORD^ORU|||2.2\r"+
			"OBX|||00350^Hb H Test^HDS^^^|||^^HDS||N|||F||||||1/5101/14\r";

		BulkHl7V2Comparison cmp = new BulkHl7V2Comparison();
		cmp.setActualMessages(new Hl7InputStreamMessageIterator(new StringReader(actual)));
		cmp.setExpectedMessages(new Hl7InputStreamMessageIterator(new StringReader(expected)));

		cmp.addComparisonListener(new IComparisonListener() {
			
			@Override
			public void success(Hl7V2MessageCompare theComparison) {
				// ignore
			}
			
			
			@Override
			public void progressLog(String theMsgLine) {
				ourLog.info(theMsgLine);
			}
			
			
			@Override
			public void failure(Hl7V2MessageCompare theComparison) {
				if (theComparison.describeDifference().contains("ST")) {
					Assert.fail(theComparison.describeDifference());
				}
			}
		});
		cmp.compare();
		
	}
	
	
}
