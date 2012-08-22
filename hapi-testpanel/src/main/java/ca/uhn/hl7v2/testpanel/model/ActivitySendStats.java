package ca.uhn.hl7v2.testpanel.model;

import java.util.Date;

public class ActivitySendStats extends ActivityBase {

	public ActivitySendStats(Date theTimestamp) {
	    super(theTimestamp);
	    // TODO Auto-generated constructor stub
    }

	
	public static class Factory
	{
		private int mySendCount;
	}
	
}
