/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "Version.java".  Description: 
"An enumeration of supported HL7 versions" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2012.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  "GPL"), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 
 */
package ca.uhn.hl7v2;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ca.uhn.hl7v2.model.GenericMessage;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.Parser;

public enum Version {

	V21("2.1"), // -
	V22("2.2"), // -
	V23("2.3"), // -
	V231("2.3.1"), // -
	V24("2.4"), // -
	V25("2.5"), // -
	V251("2.5.1"), // -
	V26("2.6"); // -

	private String version;
	private static ArrayList<Version> ourVersionsOnClasspath;
	private static final Map<Version, Boolean> ourIsOnClasspath = new HashMap<Version, Boolean>();

	Version(String version) {
		this.version = version;
	}

	/**
	 * Returns a version string (e.g. "2.1", or "2.5.1")
	 */
	public String getVersion() {
		return version;
	}

	public String getPackageVersion() {
		return "v" + version.replace(".", "");
	}

	/**
	 * Returns <code>true</code> if theVersion is a valid HL7
	 * version string representing a known version, e.g. "2.4", "2.6"
	 */
	public static boolean supportsVersion(String theVersion) {
		return versionOf(theVersion) != null;
	}

	/**
	 * @param version The version string, e.g. "2.1" or "2.6"
	 */
	public static Version versionOf(String version) {
		for (Version v : Version.values()) {
			if (v.getVersion().equals(version)) {
				return v;
			}
		}
		return null;
	}

	/**
	 * @param someVersions set of versions to be tested
	 * @return <code>true</code> if someVersions contain all supported HL7 versions
	 */
	public static boolean allVersions(Set<Version> someVersions) {
		return someVersions != null && someVersions.size() == values().length;
	}

	/**
	 * Returns true if this version is greater than the specified version
	 */
	public boolean isGreaterThan(Version theVersion) {
		return compareTo(theVersion) > 0;
	}

	/**
	 * Returns the newest available version of the message structure classes
	 * on the classpath, or <code>null</code> if none are found
	 */
	public static Version latestVersion() {
		Version[] versions = Version.values();
		if (versions.length > 0) {
			return versions[versions.length - 1];
		} else {
			return null;
		}
	}

	public static Version[] asOf(Version v) {
		List<Version> versions = new ArrayList<Version>();
		for (Version version : Version.values()) {
			if (version.compareTo(v) >= 0)
				versions.add(version);
		}
		return versions.toArray(new Version[versions.size()]);
	}

	public static Version[] except(Version v) {
		List<Version> versions = new ArrayList<Version>();
		for (Version version : Version.values()) {
			if (version.compareTo(v) != 0)
				versions.add(version);
		}
		return versions.toArray(new Version[versions.size()]);
	}

	public static Version[] before(Version v) {
		List<Version> versions = new ArrayList<Version>();
		for (Version version : Version.values()) {
			if (version.compareTo(v) < 0)
				versions.add(version);
		}
		return versions.toArray(new Version[versions.size()]);
	}

	public String modelPackageName() {
		return String
				.format("%s.model.%s.", getClass().getPackage().getName(), getPackageVersion());
	}

	/**
	 * Returns <code>true</code> if the structure
	 * classes for this particular version are available
	 * on the classpath.
	 */
	public synchronized boolean available() {
		Boolean retVal = ourIsOnClasspath.get(this);
		if (retVal == null) {
			String resource = "ca/uhn/hl7v2/parser/eventmap/" + getVersion() + ".properties";
            InputStream in = Parser.class.getClassLoader().getResourceAsStream(resource);
            try {
			    retVal = in != null;
			    ourIsOnClasspath.put(this, retVal);
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (Exception e) {
                        // Ignore
                    }
                }
            }
		}
		return retVal;
	}
	
	/**
	 * Returns a list of all versions for which the structure JARs have been
	 * found on the classpath.
	 */
	public static synchronized List<Version> availableVersions() {
		if (ourVersionsOnClasspath == null) {
			ourVersionsOnClasspath = new ArrayList<Version>();
			for (Version next : values()) {
				if (next.available()) {
					ourVersionsOnClasspath.add(next);
				}
			}
		}
		return ourVersionsOnClasspath;
	}
	
	/**
	 * <p>
	 * Returns the lowest version for which the structure classes are found
	 * on the classes. For instance, if <code>hapi-structures-v24-[version].jar</code>
	 * is the only structure JAR on the current JVM classpath, {@link Version#V24} will
	 * be returned.
	 * <p>
	 * <p>
	 * Returns <code>null</code> if none are found
	 * </p>
	 */
	public static Version lowestAvailableVersion() {
		List<Version> availableVersions = availableVersions();
		if (availableVersions.size() >0) {
			return availableVersions.get(0);
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Returns the highest version for which the structure classes are found
	 * on the classes. For instance, if <code>hapi-structures-v24-[version].jar</code>
	 * is the only structure JAR on the current JVM classpath, {@link Version#V24} will
	 * be returned.
	 * <p>
	 * </>
	 * If no structure JARs at all are found, returns a default value of
	 * {@link Version#V25}
	 * </p>
	 */
	public static Version highestAvailableVersionOrDefault() {
		List<Version> availableVersions = availableVersions();
		if (availableVersions.size() >0) {
			return availableVersions.get(availableVersions.size() - 1);
		} else {
			return Version.V25;
		}
	}

	/**
	 * Construct and return a new {@link GenericMessage} for the given version
	 */
	public GenericMessage newGenericMessage(ModelClassFactory mcf) {
		switch (this) {
		case V21:
			return new GenericMessage.V21(mcf);
		case V22:
			return new GenericMessage.V22(mcf);
		case V23:
			return new GenericMessage.V23(mcf);
		case V231:
			return new GenericMessage.V231(mcf);
		case V24:
			return new GenericMessage.V24(mcf);
		case V25:
			return new GenericMessage.V25(mcf);
		case V251:
			return new GenericMessage.V251(mcf);
		case V26:
			return new GenericMessage.V26(mcf);
		default:
			throw new Error("Unknown version (this is a HAPI bug): " + this.getVersion());
		}
	}
	
}
