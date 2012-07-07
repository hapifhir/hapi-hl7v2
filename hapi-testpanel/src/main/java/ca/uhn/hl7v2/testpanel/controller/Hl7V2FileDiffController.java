package ca.uhn.hl7v2.testpanel.controller;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.SwingUtilities;

import org.apache.commons.lang.StringUtils;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.testpanel.ui.tools.Hl7V2FileDiffDialog;
import ca.uhn.hl7v2.testpanel.util.CharCountingReaderWrapper;
import ca.uhn.hl7v2.testpanel.util.compare.BulkHl7V2Comparison;
import ca.uhn.hl7v2.testpanel.util.compare.Hl7V2MessageCompare;
import ca.uhn.hl7v2.testpanel.util.compare.IComparisonListener;
import ca.uhn.hl7v2.util.Hl7InputStreamMessageIterator;
import ca.uhn.hl7v2.util.Terser;

public class Hl7V2FileDiffController {

	private static final int OUTPUT_LINES = 1000;
	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(Hl7V2FileDiffController.class);

	public static final String PROP_RUNNING = Hl7V2FileDiffController.class.getName() + "_RUNNING";
	public static final String PROP_FAILED = Hl7V2FileDiffController.class.getName() + "_FAILED";
	public static final String PROP_PERCENT_DONE = Hl7V2FileDiffController.class.getName() + "_PERCENT_DONE";
	public static final String PROP_OUTPUT = Hl7V2FileDiffController.class.getName() + "_OUTPUT";

	private final PropertyChangeSupport myPcs = new PropertyChangeSupport(this);
	private boolean myRunning;
	private final Hl7V2FileDiffDialog myView;
	private final Controller myMasterController;
	private long myFile1Size;
	private long myFile2Size;
	private CharCountingReaderWrapper myCountingReader1;
	private CharCountingReaderWrapper myCountingReader2;
	private Hl7InputStreamMessageIterator myMessageIter1;
	private Hl7InputStreamMessageIterator myMessageIter2;
	private BulkHl7V2Comparison myCompare;
	private RunningThread myThread;
	private boolean myFailed;
	private int myPercentDone;
	private String[] myOutput = new String[OUTPUT_LINES];
	private int myOutputNextIndex = 0;
	private int myOutputSize = 0;
	private int myNumMessagesTotal;
	private int myNumMessagesPassed;
	private int myNumMessagesFailed;

	public Hl7V2FileDiffController(Controller theMasterController) {
		myMasterController = theMasterController;
		myView = new Hl7V2FileDiffDialog(this);
	}

	public void addOutput(final String... theLines) {
		if (!SwingUtilities.isEventDispatchThread()) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					addOutput(theLines);
				}
			});
			return;
		}

		if (theLines == null || theLines.length == 0) {
			return;
		}

		for (String string : theLines) {
			myOutput[myOutputNextIndex] = string;
			if (myOutputSize < OUTPUT_LINES) {
				myOutputSize++;
			}
			myOutputNextIndex++;
			myOutputNextIndex %= OUTPUT_LINES;
		}

		myPcs.firePropertyChange(PROP_OUTPUT, null, null);
	}

	/**
	 * @return the outputSize
	 */
	public int getOutputSize() {
		return myOutputSize;
	}

	public String getOutputLine(int theIndex) {
		if (myOutputSize < OUTPUT_LINES) {
			return myOutput[theIndex];
		} else {
			int index = (myOutputNextIndex + theIndex) % OUTPUT_LINES;
			return myOutput[index];
		}
	}

	public void addPropertyChangeListener(String theProperty, PropertyChangeListener listener) {
		this.myPcs.addPropertyChangeListener(theProperty, listener);
	}

	/**
	 * @return the running
	 */
	public boolean isRunning() {
		return myRunning;
	}

	public void removePropertyChangeListener(String theProperty, PropertyChangeListener listener) {
		this.myPcs.removePropertyChangeListener(theProperty, listener);
	}

	private void setRunning(boolean theRunning) {
		boolean oldValue = myRunning;
		myRunning = theRunning;
		myPcs.firePropertyChange(PROP_RUNNING, oldValue, theRunning);
	}

	public void show() {
		myView.setVisible(true);
		myView.requestFocusInWindow();
	}

	public void begin() {
		assert SwingUtilities.isEventDispatchThread() : "Shouldn't be called from " + Thread.currentThread().getName();

		File file1 = new File(myView.getFile1Text());
		if (file1.exists() == false) {
			myMasterController.showDialogError("File does not exist: " + myView.getFile1Text());
			return;
		}
		if (file1.isDirectory()) {
			myMasterController.showDialogError("File is a directory: " + myView.getFile1Text());
			return;
		}

		File file2 = new File(myView.getFile2Text());
		if (file2.exists() == false) {
			myMasterController.showDialogError("File does not exist: " + myView.getFile2Text());
			return;
		}
		if (file2.isDirectory()) {
			myMasterController.showDialogError("File is a directory: " + myView.getFile2Text());
			return;
		}

		myFile1Size = file1.length();
		myFile2Size = file2.length();

		try {
			myCountingReader1 = new CharCountingReaderWrapper(new BufferedReader(new FileReader(file1)));
			myCountingReader2 = new CharCountingReaderWrapper(new BufferedReader(new FileReader(file2)));
		} catch (FileNotFoundException e) {
			myMasterController.showDialogError(e.getMessage());
			return;
		}

		myMessageIter1 = new Hl7InputStreamMessageIterator(myCountingReader1);
		myMessageIter1.setIgnoreComments(true);
		myMessageIter2 = new Hl7InputStreamMessageIterator(myCountingReader2);
		myMessageIter2.setIgnoreComments(true);

		myCompare = new BulkHl7V2Comparison();
		myCompare.setStopOnFirstFailure(myView.isStopOnFirstError());
		myCompare.setExpectedMessages(myMessageIter1);
		myCompare.setActualMessages(myMessageIter2);
		myCompare.setExpectedAndActualDescription("File 1", "File 2");

		setRunning(true);
		setFailed(false);
		clearOutput();
		
		myNumMessagesTotal = 0;
		myNumMessagesFailed = 0;
		myNumMessagesPassed = 0;

		myThread = new RunningThread();
		myThread.start();

	}

	private void clearOutput() {
		myOutputNextIndex = 0;
		myOutputSize = 0;
		myPcs.firePropertyChange(PROP_OUTPUT, null, null);
	}

	/**
	 * @return the percentDone
	 */
	public int getPercentDone() {
		return myPercentDone;
	}

	/**
	 * @param thePercentDone
	 *            the percentDone to set
	 */
	public void setPercentDone(int thePercentDone) {
		int oldValue = myPercentDone;
		myPercentDone = thePercentDone;
		myPcs.firePropertyChange(PROP_PERCENT_DONE, oldValue, thePercentDone);
	}

	private void setFailed(boolean theFailed) {
		boolean oldValue = myFailed;
		myFailed = theFailed;
		myPcs.firePropertyChange(PROP_FAILED, oldValue, theFailed);
	}

	/**
	 * @return the failed
	 */
	public boolean isFailed() {
		return myFailed;
	}

	private class RunningThread extends Thread implements IComparisonListener {

		@Override
		public void run() {

			try {
				addOutput("Beginning comparison");

				myCompare.addComparisonListener(this);
				try {
					myCompare.compare();
				} catch (Exception e) {
					markFailed();
					ourLog.error("Unexpected test failure: ", e);
					addOutput("Comparison failed unexpectedly, this is probably a bug: " + e.getMessage());
					return;
				}

				if (isRunning() && !isFailed()) {
					addOutput("No differences found");
				}

			} finally {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						setRunning(false);
					}
				});
			}
		}

		public void failure(Hl7V2MessageCompare theComparison) {
			myNumMessagesTotal++;
			myNumMessagesFailed++;

			markFailed();
			updatePercentDone();
			cancelIfNeccesary();

			addOutput(" ");
			
			String controlId1 = "", controlId2 = "";
			try {
				controlId1 = new Terser(theComparison.getExpectedMessage()).get("/MSH-10");
				controlId2 = new Terser(theComparison.getActualMessage()).get("/MSH-10");
			} catch (HL7Exception e) {
				// ignore
			}
			
			StringBuilder b= new StringBuilder();
			b.append("<html><span style=\"color: red;\">Difference Found in message " + myNumMessagesTotal);
			b.append(" (Control ID ").append(controlId1);
			if (StringUtils.equals(controlId1, controlId2) == false) {
				b.append(" / ").append(controlId2);
			}
			b.append(")");
			b.append("</span></html>");
			addOutput(b.toString());
			
			if (myView.isShowWholeMessageOnError()) {
				addOutput("Message in file 1:");
				try {
					addOutput(theComparison.getExpectedMessage().printStructure().split("\\n"));
				} catch (HL7Exception e) {
					ourLog.error("Failed to print structure", e);
				}
				
				addOutput(" ");
				addOutput("Message in file 2:");
				try {
					addOutput(theComparison.getExpectedMessage().printStructure().split("\\n"));
				} catch (HL7Exception e) {
					ourLog.error("Failed to print structure", e);
				}
				
				addOutput(" ");
				addOutput("Differences:");
			}
			
			String difference = theComparison.describeDifference();
			addOutput(difference.split("\\n"));

		}

		public void success(Hl7V2MessageCompare theComparison) {
			myNumMessagesTotal++;
			myNumMessagesPassed++;
			
			updatePercentDone();
			cancelIfNeccesary();
		}

		private void cancelIfNeccesary() {
			if (!isRunning()) {
				myCompare.cancel();
			}
		}

		private void updatePercentDone() {
			int percent = (int) ((myCountingReader1.getCount() * 100) / myFile1Size);
			setPercentDone(percent);
		}

		public void markFailed() {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					setFailed(true);
				}
			});
		}

		public void progressLog(String theMsgLine) {
//			addOutput(theMsgLine);
		}

	}

	public void cancel() {
		setRunning(false);
	}

}
