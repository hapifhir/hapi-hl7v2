package ca.uhn.hl7v2.hoh.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * Utilities for dealing with IO
 */
public class IOUtils {

	public static final int DEFAULT_BUFFER_SIZE = 1024 * 4;
	public static final String FILE_PATH_SEP = System.getProperty("file.separator");

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(IOUtils.class);

	/**
	 * Non instantiable
	 */
	private IOUtils() {
		super();
	}

	/**
	 * <p>
	 * Copy bytes from a large (over 2GB) <code>InputStream</code> to an
	 * <code>OutputStream</code>.
	 * </p>
	 * <p>
	 * This method is based on an implementation from Apache Commons-IO
	 * </p>
	 * 
	 * @param input
	 *            the <code>InputStream</code> to read from
	 * @param output
	 *            the <code>OutputStream</code> to write to
	 * @return the number of bytes copied
	 * @throws NullPointerException
	 *             if the input or output is null
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	public static long copy(InputStream input, OutputStream output) throws IOException {
		byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
		long count = 0;
		int n = 0;
		while (-1 != (n = input.read(buffer))) {
			output.write(buffer, 0, n);
			count += n;
		}
		return count;
	}

	public static long copyWhileDataAvailable(InputStream input, OutputStream output) throws IOException {
		byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
		long count = 0;
		int n = 0;
		while (input.available() > 0 && -1 != (n = input.read(buffer))) {
			output.write(buffer, 0, n);
			count += n;
		}
		return count;
	}

	public static void deleteAllFromDirectory(File theWorkfilesDir) {
		File[] listFiles = theWorkfilesDir.listFiles();
		if (listFiles.length == 0) {
			return;
		}
		ourLog.info("Deleting {} files from {}", listFiles.length, theWorkfilesDir.getAbsoluteFile());
		for (File next : listFiles) {
			ourLog.info("Deleting existing file: " + next);
			next.delete();
		}
	}

	public static void deleteAllFromDirectoryExcept(File theDirectory, List<File> theExcept) throws IOException {
		File[] listFiles = theDirectory.listFiles();
		if (listFiles.length == 0) {
			return;
		}
		ourLog.info("Deleting unneeded files from {}", theDirectory.getAbsoluteFile());
		for (File nextFile : listFiles) {
			boolean keep = false;
			for (File nextExcept : theExcept) {
				if (nextFile.getCanonicalPath().equals(nextExcept.getCanonicalPath())) {
					keep = true;
					break;
				}
			}
			if (!keep) {
				ourLog.info("Deleting existing file: " + nextFile);
				nextFile.delete();
			}
		}
	}

	/**
	 * Read a classpath resource into a byte array
	 */
	public static byte[] readClasspathIntoByteArray(String theString) throws IOException {
		InputStream res = IOUtils.class.getResourceAsStream(theString);
		return readInputStreamIntoByteArray(res);
	}

	public static byte[] readInputStreamIntoByteArraWhileDataAvailable(InputStream res) throws IOException {
		java.io.ByteArrayOutputStream bos = new ByteArrayOutputStream();
		copyWhileDataAvailable(res, bos);
		return bos.toByteArray();
	}

	/**
	 * Read an entire input stream into a byte array
	 */
	public static byte[] readInputStreamIntoByteArray(InputStream res) throws IOException {
		java.io.ByteArrayOutputStream bos = new ByteArrayOutputStream();
		copy(res, bos);
		return bos.toByteArray();
	}

}
