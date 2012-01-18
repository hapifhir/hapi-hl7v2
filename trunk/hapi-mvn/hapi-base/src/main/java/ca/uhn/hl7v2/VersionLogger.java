package ca.uhn.hl7v2;

import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
            try {
                InputStream is = VersionLogger.class.getResourceAsStream("/ca/uhn/hl7v2/hapi-version.properties");
                Properties p = new Properties();
                p.load(is);
                ourVersion = p.getProperty("version");
				LOG.info("HAPI version is: " + ourVersion);
            } catch (Exception e) {
                // ignore
            }
            ourInitialized = true;
        }
    }

	/**
	 * @return Returns the current version of HAPI
	 */
	public static String getVersion() {
		return ourVersion;
	}
    
}
