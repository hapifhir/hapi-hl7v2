package ca.uhn.hl7v2.testpanel.util.compare;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.testpanel.api.IMessageTransformer;
import ca.uhn.hl7v2.testpanel.ex.UnexpectedTestFailureException;
import ca.uhn.hl7v2.util.Terser;

public class BulkHl7V2Comparison {

	static final String ACTUAL_DESC = "Actual";
	static final String EXPECTED_DESC = "Expected";

	private static final Logger ourLog = Logger.getLogger(BulkHl7V2Comparison.class.getName());
	
	private Iterator<Message> myActualMessages;
	private List<IMessageTransformer<Message>> myActualMessageTransformers = new ArrayList<IMessageTransformer<Message>>();
	private boolean myCancelled;
	private Iterator<Message> myExpectedMessages;
	private List<IMessageTransformer<Message>> myExpectedMessageTransformers = new ArrayList<IMessageTransformer<Message>>();
	private Set<String> myFieldsToIgnore = new HashSet<String>();
	private List<IComparisonListener> myListeners = new ArrayList<IComparisonListener>();
	private PipeParser myParser;
	private boolean myStopOnFirstFailure;
	private int myTotalMessages = -1;
	private String myExpectedDesc = EXPECTED_DESC;
	private String myActualDesc = ACTUAL_DESC;
	private boolean myHaveFailure;

	public BulkHl7V2Comparison() {
		myParser = PipeParser.getInstanceWithNoValidation();
	}

	public void addActualMessageTransformer(IMessageTransformer<Message> theTransformer) {
		myActualMessageTransformers.add(theTransformer);
	}
	
	public void addExpectedMessageTransformer(IMessageTransformer<Message> theTransformer) {
		myExpectedMessageTransformers.add(theTransformer);
	}
	/**
	 * @param theFieldToIgnore
	 *            the terserPathsToIgnore to set
	 */
	public void addFieldToIgnore(String theFieldToIgnore) {
		myFieldsToIgnore.add(theFieldToIgnore);
	}
	
	/**
	 * Request that the comparison stop running
	 */
	public void cancel() {
		myCancelled = true;
	}

	public void compare() throws UnexpectedTestFailureException {
		myHaveFailure = false;

		int actualIndex = 0;
		int expectedIndex = 0;
		
		while (myActualMessages.hasNext() && myExpectedMessages.hasNext() && !myCancelled) {
						
			Message actualMessage = myActualMessages.next();
			Message expectedMessage = myExpectedMessages.next();

			for (IMessageTransformer<Message> next : myExpectedMessageTransformers) {
				expectedMessage = next.transform(expectedMessage);
			}
			for (IMessageTransformer<Message> next : myActualMessageTransformers) {
				actualMessage = next.transform(actualMessage);
			}
			
			Terser aTerser = new Terser(actualMessage);
			Terser eTerser = new Terser(expectedMessage);
			
			StringBuilder msg = new StringBuilder();
			msg.append("Comparing message " + (actualIndex + 1));
			if (myTotalMessages != -1) {
				msg.append((actualIndex + 1) + "/" + myTotalMessages);
			}
			try {
	            msg.append(" - MSH-10 " + myExpectedDesc + "[" + eTerser.get("/.MSH-10") + "] " + myActualDesc + "[" + aTerser.get("/.MSH-10") + "]");
            } catch (HL7Exception e) {
            	// ignore, just for logging
            }
            String msgLine = msg.toString();
			ourLog.info(msgLine);
            
			for (IComparisonListener next : myListeners) {
				next.progressLog(msgLine);
			}
			
			Hl7V2MessageCompare comparison = new Hl7V2MessageCompare(myParser);
			comparison.setFieldsToIgnore(myFieldsToIgnore);
			comparison.setExpectedAndActualDescription(myExpectedDesc, myActualDesc);
			comparison.compare(expectedMessage, actualMessage);
			
			notyfyListeners(comparison);

			if (!comparison.isSame()) {
				myHaveFailure = true;
				if (myStopOnFirstFailure) {
					break;
				}
			}
			
			actualIndex++;
			expectedIndex++;
		}
		
	}
	
	
	/**
     * @return the haveFailure
     */
    public boolean isHaveFailure() {
    	return myHaveFailure;
    }

	/**
	 * @return the stopOnFirstFailure
	 */
	public boolean isStopOnFirstFailure() {
		return myStopOnFirstFailure;
	}

	private void notyfyListeners(Hl7V2MessageCompare theCompare) {
		if (theCompare.isSame()) {
			for (IComparisonListener next : myListeners) {
				next.success(theCompare);
			}
		}else {
			for (IComparisonListener next : myListeners) {
				next.failure(theCompare);
			}
		}
	}

	/**
	 * @param theActualMessages
	 *            the actualMessages to set
	 */
	public void setActualMessages(Iterator<Message> theActualMessages) {
		myTotalMessages = -1;
		myActualMessages = theActualMessages;
	}

	/**
	 * @param theActualMessages
	 *            the actualMessages to set
	 */
	public void setActualMessages(List<Message> theActualMessages) {
		myTotalMessages = theActualMessages.size();
		myActualMessages = theActualMessages.iterator();
	}
	
	/**
	 * @param theExpectedMessages
	 *            the expectedMessages to set
	 */
	public void setExpectedMessages(Iterator<Message> theExpectedMessages) {
		myExpectedMessages = theExpectedMessages;
	}

	/**
	 * @param theExpectedMessages
	 *            the expectedMessages to set
	 */
	public void setExpectedMessages(List<Message> theExpectedMessages) {
		myExpectedMessages = theExpectedMessages.iterator();
	}


	/**
	 * @param theStopOnFirstFailure
	 *            the stopOnFirstFailure to set
	 */
	public void setStopOnFirstFailure(boolean theStopOnFirstFailure) {
		myStopOnFirstFailure = theStopOnFirstFailure;
	}

	public void addComparisonListener(IComparisonListener theListeners) {
		myListeners.add(theListeners);
	}

	public void setActualAndExpectedDescription(String theString, String theString2) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * By default the tools will print the words "expected" and "actual" in descriptions
	 * but this can be overridden with alternate phrases.
	 */
	public void setExpectedAndActualDescription(String theExpectedDesc, String theActualDesc) {
		myExpectedDesc = theExpectedDesc;
		myActualDesc = theActualDesc;
	}
	
}
