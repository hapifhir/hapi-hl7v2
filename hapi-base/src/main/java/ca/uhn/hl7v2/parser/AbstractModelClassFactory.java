/**
The contents of this file are subject to the Mozilla Public License Version 1.1
(the "License"); you may not use this file except in compliance with the License.
You may obtain a copy of the License at http://www.mozilla.org/MPL/
Software distributed under the License is distributed on an "AS IS" basis,
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
specific language governing rights and limitations under the License.

The Initial Developer of the Original Code is University Health Network. Copyright (C)
2001.  All Rights Reserved.

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
package ca.uhn.hl7v2.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.Version;

/**
 * Abstract base class for {@link ModelClassFactory} implementations that read event maps from the
 * file system.
 * <p>
 * The directory can be set using {@link #setEventMapDirectory(String)} and defaults to
 * <code>ca/uhn/hl7v2/parser/eventmap/</code>. The file itself is a property file named after the
 * HL7 version (e.g. <code>2.4.properties</code>).
 * 
 * @author Christian Ohr
 */
@SuppressWarnings("serial")
public abstract class AbstractModelClassFactory implements ModelClassFactory {

	protected static final String DEFAULT_EVENT_MAP_DIRECTORY = "ca/uhn/hl7v2/parser/eventmap/";

	private String eventMapDirectory = DEFAULT_EVENT_MAP_DIRECTORY;
	private Map<Version, Properties> eventMap;

	/**
	 * @return the directory where to read the eventmap file from
	 */
	public String getEventMapDirectory() {
		return eventMapDirectory;
	}

	/**
	 * @param eventMapDirectory the directory where to read the eventmap file from
	 */
	public void setEventMapDirectory(String eventMapPrefix) {
		this.eventMapDirectory = eventMapPrefix;
	}

	/**
	 * @see ca.uhn.hl7v2.parser.ModelClassFactory#getMessageStructureForEvent(java.lang.String,
	 *      ca.uhn.hl7v2.Version)
	 */
	public String getMessageStructureForEvent(String name, Version version) throws HL7Exception {
		Properties p = getEventMap().get(version);
		if (p == null)
			throw new HL7Exception("No map found for version " + version
					+ ". Only the following are available: " + getEventMap().keySet());
		return p.getProperty(name);
	}

	/**
	 * Initializes the event map once and returns it.
	 * <p>
	 * This method is package private for testing reasons.
	 *  
	 * @return the event map
	 * @throws HL7Exception
	 */
	synchronized Map<Version, Properties> getEventMap() throws HL7Exception {
		if (eventMap == null) {
			try {
				eventMap = loadMessageStructures();
			} catch (IOException e) {
				throw new HL7Exception("Could not load event map", e);
			}
		}
		return eventMap;
	}

	/**
	 * Load event map from a external resource
	 * 
	 * @return the event map
	 * @throws IOException
	 */
	protected Map<Version, Properties> loadMessageStructures() throws IOException {
		Map<Version, Properties> map = new HashMap<Version, Properties>();
		for (Version v : Version.values()) {
			String resource = getEventMapDirectory() + v.getVersion() + ".properties";
			InputStream in = getResource(resource);
			if (in != null) {
				try {
					Properties structures = new Properties();
					structures.load(in);
					map.put(v, structures);
				} finally {
					in.close();
				}
			}
		}
		return map;
	}

	private InputStream getResource(String resource) {
		InputStream in = null;
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		if (loader != null) {
			in = loader.getResourceAsStream(resource);
		}
		if (in == null) {
			loader = AbstractModelClassFactory.class.getClassLoader();
			if (loader != null) {
				in = loader.getResourceAsStream(resource);
			}
		}
		if (in == null) {
			in = ClassLoader.getSystemResourceAsStream(resource);
		}
		return in;
	}

}
