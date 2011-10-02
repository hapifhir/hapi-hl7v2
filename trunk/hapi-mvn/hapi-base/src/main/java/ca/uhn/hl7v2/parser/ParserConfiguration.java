package ca.uhn.hl7v2.parser;

import java.util.HashSet;
import java.util.Set;

import ca.uhn.hl7v2.util.Terser;


public class ParserConfiguration {

    private Set<String> myForcedEncode = new HashSet<String>();
    
	
    /**
     * <p>
     * Forces the parser to encode certain segments/fields, even if they contain no content. This
     * method may be called multiple times with multiple path definitions, and each path definition
     * contains the path to the segment or field which needs to be forced.
     * </p>
     * <p>
     * Path definitions are similar in format to {@link Terser Terser} paths. They contain
     * a slash-separated lookup path to reach a given segment, and optionally a field number. The
     * following are examples of paths which could be added here, as well as the sample output for 
     * an otherwise empty ORU^R01 message:
     * </p>
     * <table>
     *    <th>
     *       <td>Forced Encode Path</td>
     *       <td>Encode Output</td>
     *    </th>
     *    <tr>
     *       <td>None (for illustration purposes)</td>
     *       <td>MSH|^~\&amp;|||||||ORU^R01^ORU_R01||T|2.4</td>
     *    </tr>
     *    <tr>
     *       <td>PATIENT_RESULT/ORDER_OBSERVATION/ORC</td>
     *       <td>MSH|^~\&amp;|||||||ORU^R01^ORU_R01||T|2.4<br>ORC|</td>
     *    </tr>
     *    <tr>
     *       <td>PATIENT_RESULT/ORDER_OBSERVATION/ORC-4</td>
     *       <td>MSH|^~\&amp;|||||||ORU^R01^ORU_R01||T|2.4<br>ORC||||</td>
     *    </tr>
     *    <tr>
     *       <td>PATIENT_RESULT/ORDER_OBSERVATION/ORC-4-2</td>
     *       <td>MSH|^~\&amp;|||||||ORU^R01^ORU_R01||T|2.4<br>ORC||||^</td>
     *    </tr>
     * </table>
     * <p>
     * While empty segments do not generally have any meaning according
     * to HL7, this may be useful when transmitting to systems which rely on segments
     * being received even if they have no content.
     * </p>
     * 
     * @since 1.3
     */
	public void addForcedEncode(String theForcedEncode) {
		if (theForcedEncode == null) {
			throw new NullPointerException("forced encode may not be null");
		}
		
		int lastSlashIndex = theForcedEncode.lastIndexOf('/');
		lastSlashIndex = Math.max(lastSlashIndex, 0);

		if (lastSlashIndex == 0) {
			if (!theForcedEncode.matches("[A-Z]{3}(-[0-9]+){0,2}$")) {
				throw new IllegalArgumentException("Definition must end with a segment name or field lookup, e.g. MSH or MSH-2");
			}
		} else {
			if (lastSlashIndex == theForcedEncode.length() || !theForcedEncode.substring(lastSlashIndex + 1).matches("[A-Z]{3}(-[0-9]+){0,2}$")) {
				throw new IllegalArgumentException("Definition must end with a segment name or field lookup, e.g. MSH or MSH-2");
			}
		}
		myForcedEncode.add(theForcedEncode);
	}


	/**
	 * @return Returns the forced encode strings added by {@link #addForcedEncode(String)}
	 * 
	 * @see #addForcedEncode(String)
	 * @since 1.3
	 */
	public Set<String> getForcedEncode() {
		return myForcedEncode;
	}
	
	
}
