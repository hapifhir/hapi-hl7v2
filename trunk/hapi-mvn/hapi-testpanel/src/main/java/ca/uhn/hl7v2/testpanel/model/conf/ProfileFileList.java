package ca.uhn.hl7v2.testpanel.model.conf;

import static org.apache.commons.lang.StringUtils.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.hl7v2.hoh.util.IOUtils;
import ca.uhn.hl7v2.testpanel.controller.Prefs;
import ca.uhn.hl7v2.testpanel.model.AbstractModelClass;
import ca.uhn.hl7v2.testpanel.model.conf.ProfileGroup.Entry;

public class ProfileFileList extends AbstractModelClass {

	private static final Logger ourLog = org.slf4j.LoggerFactory.getLogger(ProfileFileList.class);

	public static final String PROP_FILES = ProfileFileList.class.getName() + "_FILES";

	private HashMap<String, ProfileGroup> myIdToProfileGroups;

	private List<ProfileGroup> myProfileGroups = new ArrayList<ProfileGroup>();

	private TableFileList myTableFileList;

	public ProfileFileList(TableFileList theTableFileList) {
		myTableFileList = theTableFileList;
		
		myProfileGroups = Prefs.getOpenProfiles();
		for (ProfileGroup nextGroup : myProfileGroups) {
			for (Entry nextEntry : nextGroup.getEntries()) {
				nextEntry.setParentProfileGroup(nextGroup);
			}
		}
	}

	public void addNewFile(File theFile) throws IOException, ProfileException {
		ProfileProxy file = ProfileProxy.loadFromFile(theFile);
		myProfileGroups.add(new ProfileGroup(file));
		myIdToProfileGroups = null;

		firePropertyChange(PROP_FILES, null, null);

		updatePrefs();
	}

	@Override
	public Object exportConfigToXml() {
		return null;
	}

	/**
	 * @return Returns null if not found
	 */
	public ProfileGroup getProfile(String theProfileId) {
		initIdToProfileGroups();
		return myIdToProfileGroups.get(theProfileId);
	}

	private void initIdToProfileGroups() {
		if (myIdToProfileGroups == null) {
			myIdToProfileGroups = new HashMap<String, ProfileGroup>();
			for (ProfileGroup next : myProfileGroups) {
				myIdToProfileGroups.put(next.getId(), next);
			}
		}
	}

	/**
	 * @return the tableFiles
	 */
	public List<ProfileGroup> getProfiles() {
		return myProfileGroups;
	}

	public void newProfileGroup(String theName) {
		myProfileGroups.add(new ProfileGroup(theName));
		myIdToProfileGroups = null;
		firePropertyChange(PROP_FILES, null, null);
	}

	public void removeProfile(ProfileProxy theSelectedFileOrTable) {
		myProfileGroups.remove(theSelectedFileOrTable);
		myIdToProfileGroups = null;
		firePropertyChange(PROP_FILES, null, null);
	}

	public void removeProfileGroup(ProfileGroup theSel) {
		myProfileGroups.remove(myProfileGroups.indexOf(theSel));
		myIdToProfileGroups = null;
		firePropertyChange(PROP_FILES, null, null);
	}

	public void updatePrefs() {
		ourLog.info("Flushing profile files to preferences");
		Prefs.getInstance().setOpenProfiles(myProfileGroups, myTableFileList);
	}

	public void importFile(ProfileGroup theProfileGroup) {
		myProfileGroups.add(theProfileGroup);
		firePropertyChange(PROP_FILES, null, null);
		updatePrefs();
	}

//	public void dumpImportedToWorkDirectory(File theDirectory) {
//		initIdToProfileGroups();
//		
//		IOUtils.deleteAllFromDirectory(theDirectory);
//
//		ourLog.info("Flushing work files to directory: " + theDirectory.getAbsolutePath());
//		
//		int index = 0;
//		for (ProfileGroup next : myIdToProfileGroups.values()) {
//			if (isBlank(next.getSourceUrl())) {
//				continue;
//			}
//			
//			index++;
//			String seq = StringUtils.leftPad(Integer.toString(index), 10, '0');
//
//			File nextFile = new File(theDirectory, next.getId() + "-" + seq + ".xml");
//
//			Writer nextWriter;
//			try {
//				nextWriter = new OutputStreamWriter(new FileOutputStream(nextFile), Charset.forName("UTF-8"));
//				nextWriter.append(next.exportConfigToXml());
//				nextWriter.close();
//			} catch (IOException e) {
//				ourLog.error("Failed to export profile group to file: " + nextFile.getAbsolutePath(), e);
//			}
//		
//		} // for
//
//	}

}
