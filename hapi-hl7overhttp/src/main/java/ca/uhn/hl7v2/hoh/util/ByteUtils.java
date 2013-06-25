package ca.uhn.hl7v2.hoh.util;

public class ByteUtils {

	// non instantiable
	private ByteUtils() {}
	
	/**
	 * Formats a byte array for logging
	 */
	public static String formatBytesForLogging(int numBytes, int theOffset, byte... theBytes) {
		StringBuilder b = new StringBuilder();
		int end = numBytes + theOffset;
		for (int i = theOffset; i < end; i++) {
			byte nextByte = theBytes[i];
			if (nextByte < ' ' || nextByte > 126) {
				b.append('[');
				b.append((int) nextByte);
				b.append(']');
			} else {
				b.append((char) nextByte);
			}
		}

		return (b.toString());
	}
	
}
