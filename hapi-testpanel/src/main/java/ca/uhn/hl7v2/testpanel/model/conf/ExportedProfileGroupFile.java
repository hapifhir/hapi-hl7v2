package ca.uhn.hl7v2.testpanel.model.conf;

import static org.apache.commons.lang.StringUtils.*;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.hl7v2.conf.parser.ProfileParser;
import ca.uhn.hl7v2.conf.spec.RuntimeProfile;
import ca.uhn.hl7v2.testpanel.model.conf.ProfileGroup.Entry;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ExportedProfileGroupFile")
public class ExportedProfileGroupFile {

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(ExportedProfileGroupFile.class);

	@XmlElement(name = "profileGroup")
	private ProfileGroup myProfileGroup;

	@XmlElement(name = "profile")
	private List<ProfileWithContents> myProfiles;

	@XmlElement(name = "tableFile")
	private List<TableFile> myTableFiles;

	/**
	 * Constructor
	 */
	public ExportedProfileGroupFile() {
		// nothing
	}

	public ExportedProfileGroupFile(ProfileGroup theProfileGroup, TableFileList theTableFileList) throws IOException {

		ExportedProfileGroupFile exported = new ExportedProfileGroupFile();
		exported.setProfileGroup(theProfileGroup);

		Set<String> profileIds = new HashSet<String>();
		Set<String> tablesIds = new HashSet<String>();
		for (Entry next : theProfileGroup.getEntries()) {
			if (!profileIds.add(next.getProfileProxy().getId())) {
				continue; // don't add the same profile twice
			}

			ProfileWithContents contents = new ProfileWithContents();
			contents.setContents(next.getProfileProxy().getProfileAsString());
			contents.setId(next.getProfileProxy().getId());
			exported.getProfiles().add(contents);

			String tablesId = next.getTablesId();
			if (isNotBlank(tablesId) && tablesIds.add(tablesId)) {
				TableFile tableFile = theTableFileList.getTableFile(tablesId);
				exported.getTableFiles().add(tableFile);
			}
		}

	}

	/**
	 * @return the profileGroup
	 */
	public ProfileGroup getProfileGroup() {
		return myProfileGroup;
	}

	/**
	 * @return the profiles
	 */
	public List<ProfileWithContents> getProfiles() {
		if (myProfiles == null) {
			myProfiles = new ArrayList<ExportedProfileGroupFile.ProfileWithContents>();
		}
		return myProfiles;
	}

	/**
	 * @return the tableFiles
	 */
	public List<TableFile> getTableFiles() {
		if (myTableFiles == null) {
			myTableFiles = new ArrayList<TableFile>();
		}
		return myTableFiles;
	}

	/**
	 * @param theProfileGroup
	 *            the profileGroup to set
	 */
	public void setProfileGroup(ProfileGroup theProfileGroup) {
		myProfileGroup = theProfileGroup;
	}

	public static ExportedProfileGroupFile loadFromUrl(URL theImportUrl) {
		try {
			Object unmarshal = JAXBContext.newInstance(ExportedProfileGroupFile.class).createUnmarshaller().unmarshal(theImportUrl);
			if ((unmarshal != null) && !(unmarshal instanceof ExportedProfileGroupFile)) {
				ourLog.error("Found wrong type: " + unmarshal.getClass().getName());
			}
			return (ExportedProfileGroupFile) unmarshal;
		} catch (JAXBException e) {
			ourLog.error("Failed to read profile group file from URL: " + theImportUrl, e);
			return null;
		}
	}

	@XmlType()
	public static class ProfileWithContents {

		@XmlElement(name = "contents")
		private String myContents;

		@XmlAttribute(name = "id")
		private String myId;

		/**
		 * @return the contents
		 */
		public String getContents() {
			return myContents;
		}

		/**
		 * @return the id
		 */
		public String getId() {
			return myId;
		}

		/**
		 * @param theContents
		 *            the contents to set
		 */
		public void setContents(String theContents) {
			myContents = theContents;
		}

		/**
		 * @param theId
		 *            the id to set
		 */
		public void setId(String theId) {
			myId = theId;
		}
	}

	/**
	 * Replaces all IDs within this file with new ones (maintaining existing
	 * links but with new IDs)
	 */
	public void renumberEverything() {
		Map<String, String> ids = new HashMap<String, String>();
		getProfileGroup().setId(mapId(ids, getProfileGroup().getId()));
		for (Entry next : getProfileGroup().getEntries()) {
			next.setTablesId(mapId(ids, next.getTablesId()));
			next.getProfileProxy().setId(mapId(ids, next.getProfileProxy().getId()));
		}
		for (ProfileWithContents next : getProfiles()) {
			next.setId(mapId(ids, next.getId()));
		}
		for (TableFile next : getTableFiles()) {
			next.setId(mapId(ids, next.getId()));
		}
	}

	private static String mapId(Map<String, String> theIds, String theId) {
		if (theId == null) {
			return null;
		}
		String retVal = theIds.get(theId);
		if (retVal == null) {
			retVal = UUID.randomUUID().toString();
			theIds.put(theId, retVal);
		}
		return retVal;
	}

	/**
	 * Associate the profile contents with the profile group
	 */
	public void hydrate() throws IOException, ProfileException {
		Map<String, RuntimeProfile> parsedProfiles = new HashMap<String, RuntimeProfile>();

		ProfileParser p = new ProfileParser(false);
		for (ProfileWithContents next : getProfiles()) {
			ourLog.info("Restoring runtime profile (conformance profile) with id: {}", next.getId());
			parsedProfiles.put(next.getId(), p.parse(next.getContents()));
		}

		for (Entry next : myProfileGroup.getEntries()) {
			String id = next.getProfileProxy().getId();
			RuntimeProfile profile = parsedProfiles.get(id);
			if (profile == null) {
				throw new IOException("Exported file is inconsistent: Missing profile entry with id: " + id);
			}
		}
	}

	public CharSequence exportConfigToXm() {
		StringWriter w = new StringWriter();
		JAXB.marshal(this, w);
		return w.toString();
	}

}
