package ca.uhn.hl7v2.hoh.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Methods for dealing with GZip encoding
 */
public class GZipUtils {

	/**
	 * Non instantiable
	 */
	private GZipUtils() {
		// nothing
	}
	
	/**
	 * Compresses a byte array
	 */
	public static byte[] compress(byte[] theBytes) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		GZIPOutputStream gos = new GZIPOutputStream(bos);
		gos.write(theBytes);
		gos.close();
		return bos.toByteArray();
	}
	
	/**
	 * Compresses a byte array
	 */
	public static byte[] uncompress(byte[] theBytes) throws IOException {
		ByteArrayInputStream bis = new ByteArrayInputStream(theBytes);
		GZIPInputStream gos = new GZIPInputStream(bis);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		IOUtils.copy(gos, bos);		
		return bos.toByteArray();
	}

}
