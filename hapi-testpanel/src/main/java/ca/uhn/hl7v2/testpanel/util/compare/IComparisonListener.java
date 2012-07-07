package ca.uhn.hl7v2.testpanel.util.compare;

public interface IComparisonListener {

	void failure(Hl7V2MessageCompare theComparison);
	
	void success(Hl7V2MessageCompare theComparison);

	void progressLog(String theMsgLine);
	
}
