package ca.uhn.hl7v2.parser;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import ca.uhn.hl7v2.model.Varies;
import ca.uhn.hl7v2.util.Terser;

public class ParserConfiguration {

	private String myDefaultObx2Type;
	private boolean myEncodeEmptyMandatorySegments = true;
	private Set<String> myForcedEncode = new HashSet<String>();
	private String myInvalidObx2Type;

	/**
	 * <p>
	 * Forces the parser to encode certain segments/fields, even if they contain
	 * no content. This method may be called multiple times with multiple path
	 * definitions, and each path definition contains the path to the segment or
	 * field which needs to be forced.
	 * </p>
	 * <p>
	 * Path definitions are similar in format to {@link Terser Terser} paths.
	 * They contain a slash-separated lookup path to reach a given segment, and
	 * optionally a field number. The following are examples of paths which
	 * could be added here, as well as the sample output for an otherwise empty
	 * ORU^R01 message:
	 * </p>
	 * <table>
	 * <thead>
	 * <tr>
	 * <th>Forced Encode Path</th>
	 * <th>Encode Output</th>
	 * </tr>
	 * </thead>
	 * <tr>
	 * <td>None (for illustration purposes)</td>
	 * <td>MSH|^~\&amp;|||||||ORU^R01^ORU_R01||T|2.4</td>
	 * </tr>
	 * <tr>
	 * <td>PATIENT_RESULT/ORDER_OBSERVATION/ORC</td>
	 * <td>MSH|^~\&amp;|||||||ORU^R01^ORU_R01||T|2.4<br>
	 * ORC|</td>
	 * </tr>
	 * <tr>
	 * <td>PATIENT_RESULT/ORDER_OBSERVATION/ORC-4</td>
	 * <td>MSH|^~\&amp;|||||||ORU^R01^ORU_R01||T|2.4<br>
	 * ORC||||</td>
	 * </tr>
	 * <tr>
	 * <td>PATIENT_RESULT/ORDER_OBSERVATION/ORC-4-2</td>
	 * <td>MSH|^~\&amp;|||||||ORU^R01^ORU_R01||T|2.4<br>
	 * ORC||||^</td>
	 * </tr>
	 * </table>
	 * <p>
	 * While empty segments do not generally have any meaning according to HL7,
	 * this may be useful when transmitting to systems which rely on segments
	 * being received even if they have no content.
	 * </p>
	 * <p>
	 * Note that this configuration item currently only applies to
	 * {@link PipeParser}
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
			if (!theForcedEncode.matches("[A-Z0-9]{3}(-[0-9]+){0,2}$")) {
				throw new IllegalArgumentException("Definition must end with a segment name or field lookup, e.g. MSH or MSH-2");
			}
		} else {
			if (lastSlashIndex == theForcedEncode.length() || !theForcedEncode.substring(lastSlashIndex + 1).matches("[A-Z0-9]{3}(-[0-9]+){0,2}$")) {
				throw new IllegalArgumentException("Definition must end with a segment name or field lookup, e.g. MSH or MSH-2");
			}
		}
		myForcedEncode.add(theForcedEncode);
	}

	/**
	 * Removes a forced encode entry
	 * 
	 * @see #addForcedEncode(String)
	 * @since 1.3
	 */
	public void removeForcedEncode(String theForcedEncode) {
		if (theForcedEncode == null) {
			throw new NullPointerException("forced encode may not be null");
		}
		
		myForcedEncode.remove(theForcedEncode);
	}
	
	boolean determineForcedEncodeIncludesTerserPath(String theTerserPath) {
		for (String next : getForcedEncode()) {
			if (next.startsWith(theTerserPath)) {
				return true;
			}
		}
		return false;
	}

	int determineForcedFieldNumForTerserPath(String theCurrentTerserPath) {
		int forceUpToFieldNum = 0;
		for (String nextPath : getForcedEncode()) {
			if (nextPath.startsWith(theCurrentTerserPath) && nextPath.length() > theCurrentTerserPath.length()) {
				int endOfFieldDef = nextPath.indexOf('-', theCurrentTerserPath.length() + 1);
				if (endOfFieldDef == -1) {
					endOfFieldDef = nextPath.length();
				}
				String fieldNumString = nextPath.substring(theCurrentTerserPath.length() + 1, endOfFieldDef);
				forceUpToFieldNum = Math.max(forceUpToFieldNum, Integer.parseInt(fieldNumString));
			}
		}
		return forceUpToFieldNum;
	}

	/**
	 * Returns the default datatype ("ST", "NM", etc) for an OBX segment with a
	 * missing OBX-2 value
	 * 
	 * @return Returns the default datatype ("ST", "NM", etc) for an OBX segment
	 *         with a missing OBX-2 value
	 * @see #setDefaultObx2Type(String)
	 */
	public String getDefaultObx2Type() {
		return myDefaultObx2Type;
	}

	/**
	 * @return Returns the forced encode strings added by
	 *         {@link #addForcedEncode(String)}
	 * 
	 * @see #addForcedEncode(String)
	 * @since 1.3
	 */
	public Set<String> getForcedEncode() {
		return Collections.unmodifiableSet(myForcedEncode);
	}

	/**
	 * @return Returns <code>true</code> if empty segments should still be
	 *         encoded if they are mandatory within their message structure.
	 * @see #setEncodeEmptyMandatoryFirstSegments(boolean)
	 */
	public boolean isEncodeEmptyMandatorySegments() {
		return myEncodeEmptyMandatorySegments;
	}

	/**
	 * Returns the value provides a default datatype ("ST", "NM", etc) for an
	 * OBX segment with an invalid OBX-2 value.
	 * 
	 * @return Returns the value provides a default datatype ("ST", "NM", etc)
	 *         for an OBX segment with an invalid OBX-2 value.
	 * @see #setInvalidObx2Type(String)
	 */
	public String getInvalidObx2Type() {
		return myInvalidObx2Type;
	}

	/**
	 * <p>
	 * If this property is set, the value provides a default datatype ("ST",
	 * "NM", etc) for an OBX segment with a missing OBX-2 value. This is useful
	 * when parsing messages from systems which do not correctly populate OBX-2.
	 * </p>
	 * <p>
	 * For example, if this property is set to "ST", and the following OBX
	 * segment is encountered:
	 * 
	 * <pre>
	 * OBX|||||This is a value
	 * </pre>
	 * 
	 * It will be parsed as though it had read:
	 * 
	 * <pre>
	 * OBX||ST|||This is a value
	 * </pre>
	 * 
	 * </p>
	 * <p>
	 * Note that this configuration can also be set globally using the system
	 * property {@link Varies#DEFAULT_OBX2_TYPE_PROP}, but any value provided to
	 * {@link ParserConfiguration} takes priority over the system property.
	 * </p>
	 * 
	 * @param theDefaultObx2Type
	 *            If this property is set, the value provides a default datatype
	 *            ("ST", "NM", etc) for an OBX segment with a missing OBX-2
	 *            value
	 * @see #setInvalidObx2Type(String)
	 * @see Varies#INVALID_OBX2_TYPE_PROP
	 */
	public void setDefaultObx2Type(String theDefaultObx2Type) {
		myDefaultObx2Type = theDefaultObx2Type;
	}

	/**
	 * <p>
	 * If set to <code>true</code> (default is <code>true</code>), when encoding
	 * a group using the PipeParser where the first segment is required, but no
	 * data has been populated in that segment, the empty segment is now still
	 * encoded if needed as a blank segment in order to give parsers a hint
	 * about which group subsequent segments are in. This helps to ensure that
	 * messages can be "round tripped", meaning that a message which is parsed,
	 * encoded, and then re-parsed should contain exactly the same structure
	 * from beginning to end.
	 * </p>
	 * <p>
	 * </p>
	 * For example, in an ORU^R01 message with a populated OBX segment, but no
	 * data in the mandatory OBR segment which begins the ORDER_OBSERVATION
	 * group the message would still contain an empty OBR segment when encoded:
	 * 
	 * <pre>
	 * 	MSH|^~\&|REG|W|||201103230042||ORU^R01|32153168|P|2.5
	 * 	OBR|
	 * 	OBX||ST|||Value Data
	 * </pre>
	 * 
	 * Previously, the following encoding would have occurred, which would have
	 * incorrectly been parsed as having a custom OBX segment instead of having
	 * a normal ORDER_OBSERVATION group:
	 * 
	 * <pre>
	 * 	MSH|^~\&|REG|W|||201103230042||ORU^R01|32153168|P|2.5
	 * 	OBX||ST|||Value Data
	 * </pre>
	 * 
	 * @param theEncodeEmptyMandatorySegments
	 *            If set to <code>true</code> (default is <code>true</code>),
	 *            when encoding a group using the PipeParser where the first
	 *            segment is required, but no data has been populated in that
	 *            segment, the empty segment is now still encoded if needed as a
	 *            blank segment in order to give parsers a hint about which
	 *            group subsequent segments are in
	 */
	public void setEncodeEmptyMandatoryFirstSegments(boolean theEncodeEmptyMandatorySegments) {
		myEncodeEmptyMandatorySegments = theEncodeEmptyMandatorySegments;
	}

	/**
	 * <p>
	 * If this property is set, the value provides a default datatype ("ST",
	 * "NM", etc) for an OBX segment with an invalid OBX-2 value. This is useful
	 * when parsing messages from systems which do not correctly populate OBX-2.
	 * </p>
	 * <p>
	 * For example, if this property is set to "ST", and the following OBX
	 * segment is encountered:
	 * 
	 * <pre>
	 * OBX||INVALID|||This is a value
	 * </pre>
	 * 
	 * It will be parsed as though it had read:
	 * 
	 * <pre>
	 * OBX||ST|||This is a value
	 * </pre>
	 * 
	 * </p>
	 * <p>
	 * Note that this configuration can also be set globally using the system
	 * property {@link Varies#INVALID_OBX2_TYPE_PROP}, but any value provided to
	 * {@link ParserConfiguration} takes priority over the system property.
	 * </p>
	 * 
	 * @param theDefaultObx2Type
	 *            If this property is set, the value provides a default datatype
	 *            ("ST", "NM", etc) for an OBX segment with an invalid OBX-2
	 *            value. This is useful when parsing messages from systems which
	 *            do not correctly populate OBX-2.
	 * @see ParserConfiguration#setDefaultObx2Type(String)
	 * @see Varies#DEFAULT_OBX2_TYPE_PROP
	 */
	public void setInvalidObx2Type(String theInvalidObx2Type) {
		myInvalidObx2Type = theInvalidObx2Type;
	}

}
