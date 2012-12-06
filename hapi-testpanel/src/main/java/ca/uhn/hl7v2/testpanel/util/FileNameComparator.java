package ca.uhn.hl7v2.testpanel.util;

import java.io.File;
import java.util.Comparator;

/**
 * Comparator which sorts by file name
 */
public class FileNameComparator implements Comparator<File> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compare(File theO1, File theO2) {
		if (theO1 == null && theO2 == null) {
			return 0;
		}
		
		if (theO1 == null) {
			return -1;
		}
		
		if (theO2 == null) {
			return 1;
		}
		
		return theO1.getName().compareTo(theO2.getName());
	}

}
