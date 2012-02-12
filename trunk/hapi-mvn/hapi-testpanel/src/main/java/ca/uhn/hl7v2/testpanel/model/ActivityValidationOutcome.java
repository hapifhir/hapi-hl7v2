package ca.uhn.hl7v2.testpanel.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import ca.uhn.hl7v2.HL7Exception;

public class ActivityValidationOutcome extends ActivityBase {

	private HL7Exception[] myIssues;

	public ActivityValidationOutcome(Date theTimestamp, HL7Exception... theIssues) {
		super(theTimestamp);

		myIssues = theIssues != null ? theIssues : new HL7Exception[0];
	}

	/**
	 * @return the validated
	 */
	public boolean isValidated() {
		return myIssues.length == 0;
	}

	/**
	 * @return the issues
	 */
	public List<HL7Exception> getIssues() {
		return Arrays.asList(myIssues);
	}

}
