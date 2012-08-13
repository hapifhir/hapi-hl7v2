package ca.uhn.hl7v2.testpanel.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import ca.uhn.hl7v2.testpanel.util.IProgressCallback.OperationCancelRequestedException;
import ca.uhn.hl7v2.util.Hl7InputStreamMessageStringIterator;

/**
 * Sorts an entire file of HL7 v2 messages
 */
public class Hl7V2FileSorter {

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(Hl7V2FileSorter.class);

	private boolean myAppendOutputFile;
	private Comparator<String> myComparator;
	private File myInputFile;
	private File myOutputFile;
	int myMaxiumumFileSize = 5000;
	private IProgressCallback myProgressCallback;
	
	public void setAppendOutputFile(boolean theAppend) {
		myAppendOutputFile = theAppend;
	}

	/**
	 * @param theComparator the comparator to set
	 */
	public void setComparator(Comparator<String> theComparator) {
		myComparator = theComparator;
	}

	/**
	 * @param theInputFile
	 *            the inputFile to set
	 */
	public void setInputFile(File theInputFile) {
		myInputFile = theInputFile;
	}

	/**
	 * @param theOutputFile the outputFile to set
	 */
	public void setOutputFile(File theOutputFile) {
		myOutputFile = theOutputFile;
	}

	/**
	 * @param theProgressCallback the progressCallback to set
	 */
	public void setProgressCallback(IProgressCallback theProgressCallback) {
		myProgressCallback = theProgressCallback;
	}

	/**
	 * Performs the actual sort
	 */
	public void sort() throws Exception {

		myProgressCallback.activityStarted();
		File inputFile = myInputFile;
		File outputFile = myOutputFile;

		try {
			doSort(inputFile, outputFile, 0.0, 1.0);
		} finally {
			myProgressCallback.activityStopped();
		}
		
	}

	private void doSort(File inputFile, File outputFile, double theProgressStart, double theProgressEnd) throws FileNotFoundException, OperationCancelRequestedException, IOException {
		double progressHalfWidth = (theProgressEnd - theProgressStart) * 0.5;

		List<File> tempInputFiles = new ArrayList<File>();
		List<String> currentFileMessages = new ArrayList<String>();
		Reader reader = new FileReader(inputFile);
		CharCountingReaderWrapper inputCharCountingReader = new CharCountingReaderWrapper(reader);
		FileWriter outputWriter = null;
		try {

			long maximumFileSize = inputFile.length() / 5;
			
			ourLog.info("Starting to read input file");
			Hl7InputStreamMessageStringIterator iter = new Hl7InputStreamMessageStringIterator(inputCharCountingReader);
			int totalNumMessages = 0;
			int count = 0;
			long currentFileByteCountStart = 0;
			while (iter.hasNext()) {

				if (count++ % 100 == 0) {
					long currentCount = inputCharCountingReader.getCount();
					long currentTotal = inputFile.length();
					double currentProgress = theProgressStart + (((double) currentCount) / currentTotal) * progressHalfWidth;
					myProgressCallback.progressUpdate(currentProgress);
				}

				currentFileMessages.add(iter.next());

				ourLog.debug("Temp buffer has " + currentFileMessages.size() + " msgs");

				long currentFileByteCount = inputCharCountingReader.getCount() - currentFileByteCountStart;
				if (currentFileByteCount > maximumFileSize || !iter.hasNext()) {

					totalNumMessages += currentFileMessages.size();
					ourLog.info("Sorting next batch of messages and writing them to a file, now have " + totalNumMessages + " msgs in " + (tempInputFiles.size() + 1) + " files");

					Collections.sort(currentFileMessages, myComparator);

					File tempFile = File.createTempFile("temp_hl7_sorter", ".hl7");
					tempFile.deleteOnExit();
					tempInputFiles.add(tempFile);

					FileWriter writer = new FileWriter(tempFile);
					for (String message : currentFileMessages) {
						writer.append(message);
						writer.append('\r');
					}
					writer.close();
					currentFileMessages.clear();

					ourLog.info("Done writing to temporary file: " + tempFile.getAbsolutePath());

					currentFileByteCountStart = inputCharCountingReader.getCount();
					
				}

			}

			ourLog.info("Have " + tempInputFiles.size() + " input files, now going to merge-sort them");

			/*
			 * We now have a bunch of split up files which contain a portion of
			 * the input messages. These files have been sorted within
			 * themselves, but obviously not yet sorted relative to each other.
			 */

			List<PushBackIterator<String>> inputIters = new ArrayList<PushBackIterator<String>>();
			for (File nextInputFile : tempInputFiles) {
				inputIters.add(new PushBackIterator<String>(new Hl7InputStreamMessageStringIterator(new FileReader(nextInputFile))));
			}

			outputWriter = new FileWriter(outputFile, myAppendOutputFile);

			boolean foundAtLeastOneMessage;
			int totalOutput = 0;
			do {
				foundAtLeastOneMessage = false;

				// Get one message from each file
				ArrayList<String> inputMessages = new ArrayList<String>();
				for (Iterator<PushBackIterator<String>> iterIter = inputIters.iterator(); iterIter.hasNext();) {
					PushBackIterator<String> nextIter = iterIter.next();
					if (nextIter.hasNext()) {
						inputMessages.add(nextIter.next());
						foundAtLeastOneMessage = true;
					}
				}

				ArrayList<String> sortedInputMessages = new ArrayList<String>(inputMessages);
				Collections.sort(sortedInputMessages, myComparator);

				// Only write the message from the file with the message which
				// was
				// first overall
				// The rest get pushed back
				String nextMessage = sortedInputMessages.size() > 0 ? sortedInputMessages.remove(0) : null;
				if (nextMessage != null) {
					outputWriter.append(nextMessage);
					outputWriter.append('\n');
					totalOutput++;

					for (PushBackIterator<String> next : inputIters) {
						if (next.previous() != null && sortedInputMessages.contains(next.previous())) {
							next.pushBack();
						}
					}

					if (totalOutput % 100 == 0) {
						double percent = (((double) totalOutput / (double) totalNumMessages));
						
						double progress = theProgressStart + progressHalfWidth + (percent * progressHalfWidth);
						myProgressCallback.progressUpdate(progress);
						
						ourLog.info("Now written " + NumberFormat.getPercentInstance().format(percent) + ", " + totalOutput + " messages");
					}

				}

			} while (foundAtLeastOneMessage);

		} finally {
			if (outputWriter != null) {
				outputWriter.close();
			}
			inputCharCountingReader.close();
			for (File next : tempInputFiles) {
				ourLog.info("Deleting temporary file: {}", next.getName());
				next.delete();
			}
			ourLog.info("Done sorting {} into {}", inputFile.getName(), outputFile.getName());
		}
	}

}
