package ca.uhn.hl7v2.testpanel.api;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class WorkingStatusBean {

	private String myMessage;
	private StatusEnum myStatus;
	
	public WorkingStatusBean() {
		super();
	}
	

	public WorkingStatusBean(String theMessage, StatusEnum theStatus) {
		super();
		myMessage = theMessage;
		myStatus = theStatus;
	}


	@Override
	public boolean equals(Object theObj) {
		if (!(theObj instanceof WorkingStatusBean)) {
			return false;
		}
		WorkingStatusBean sb = ((WorkingStatusBean)theObj);
		return new EqualsBuilder().append(myMessage, sb.myMessage).append(myStatus, sb.myStatus).isEquals();
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return myMessage;
	}

	/**
	 * @return the status
	 */
	public StatusEnum getStatus() {
		return myStatus;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(myMessage).append(myStatus).toHashCode();
	}

	/**
	 * @param theMessage the message to set
	 */
	public void setMessage(String theMessage) {
		myMessage = theMessage;
	}

	/**
	 * @param theStatus the status to set
	 */
	public void setStatus(StatusEnum theStatus) {
		myStatus = theStatus;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public enum StatusEnum{
		ERROR,
		OK,
		WORKING
	}

}
