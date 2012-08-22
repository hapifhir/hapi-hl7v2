package ca.uhn.hl7v2.testpanel.util;

public interface ISendProgressCallback extends IProgressCallback {

	void updateAvgThroughputPerSecond(int theThroughput);
	
	void updateAvgResponseTimeMillis(int theMillis);
	
}
