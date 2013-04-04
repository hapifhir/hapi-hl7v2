package ca.uhn.hl7v2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.DOMImplementation;

import ca.uhn.hl7v2.util.XMLUtils;

/**
 * Class to log the HAPI version when HAPI is first used (mostly for troubleshooting purposes)
 */
public class VersionLogger {

	private static boolean ourInitialized = false;
	private static String ourVersion;
	private static final Logger LOG = LoggerFactory.getLogger(VersionLogger.class);

	/**
	 * Non-instantiable
	 */
	private VersionLogger() {
		// nothing
	}

	/**
	 * Logs the HAPI version on the first time this method is invoked, does nothing afterwards
	 */
	public static void init() {
		if (!ourInitialized) {
			printHapiVersion();
			checkStructureLibraries();
			checkDOMImplementation();
			ourInitialized = true;
		}
	}

	private static void checkDOMImplementation() {
		try {
			// Check if proper XML support is available
			DOMImplementation impl = XMLUtils.getDOMImpl();
			if (impl == null) {
				LOG.warn("DOM Level 3 (Load and Save) is NOT supported by the XML library found first on your classpath!");
				LOG.warn("XML parsing and encoding as well as working with Conformance Profiles will fail.");
			}
		} catch (Throwable e) {
			LOG.warn("Error occured while trying to retrieve a DOMImplementation.", e);
			LOG.warn("XML parsing and encoding as well as working with Conformance Profiles will fail.");
		}
	}

	private static void checkStructureLibraries() {
		// Check if any structures are present
		StringBuilder sb = new StringBuilder();
		for (Version v : Version.availableVersions()) {
			sb.append(v.getVersion());
			sb.append(sb.length() > 0 ? ", " : "");
		}
		if (sb.length() == 0) {
			LOG.warn("No HL7 structure libraries found on the classpath!");
		} else {
			LOG.info("Default Structure libraries found for HL7 versions {}", sb.toString());
		}
	}

	private static void printHapiVersion() {
		InputStream is = null;
		try {
			is = VersionLogger.class
					.getResourceAsStream("/ca/uhn/hl7v2/hapi-version.properties");
			Properties p = new Properties();
			p.load(is);
			ourVersion = p.getProperty("version");
			LOG.info("HAPI version is: " + ourVersion);
		} catch (IOException e) {
			LOG.warn("Unable to determine HAPI version information", e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}
	}

	/**
	 * @return Returns the current version of HAPI
	 */
	public static String getVersion() {
		return ourVersion;
	}

}
