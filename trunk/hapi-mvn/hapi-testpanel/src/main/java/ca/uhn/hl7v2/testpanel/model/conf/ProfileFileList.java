package ca.uhn.hl7v2.testpanel.model.conf;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;

import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.hl7v2.testpanel.controller.Prefs;
import ca.uhn.hl7v2.testpanel.model.AbstractModelClass;
import ca.uhn.hl7v2.testpanel.model.conf.ProfileGroup.Entry;

public class ProfileFileList extends AbstractModelClass {

	@SuppressWarnings("unused")
	private static final Logger ourLog = org.slf4j.LoggerFactory.getLogger(ProfileFileList.class);
	
	public static final String PROP_FILES = ProfileFileList.class.getName() + "_FILES";

	private List<ProfileGroup> myProfileGroups = new ArrayList<ProfileGroup>();

	private HashMap<String, ProfileGroup> myIdToProfileGroups;

	public ProfileFileList() {
		myProfileGroups = Prefs.getOpenProfiles();
		for (ProfileGroup nextGroup : myProfileGroups) {
			for (Entry nextEntry : nextGroup.getEntries()) {
				nextEntry.setProfileGroup(nextGroup);
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
	 * @return the tableFiles
	 */
	public List<ProfileGroup> getProfiles() {
		return myProfileGroups;
	}

	public void removeProfile(ProfileProxy theSelectedFileOrTable) {
		myProfileGroups.remove(theSelectedFileOrTable);
		myIdToProfileGroups = null;
		firePropertyChange(PROP_FILES, null, null);
	}

	public void updatePrefs() {
		ourLog.info("Flushing profile files to preferences");
		Prefs.setOpenProfiles(myProfileGroups);
	}

	public void newProfileGroup(String theName) {
		myProfileGroups.add(new ProfileGroup(theName));
		myIdToProfileGroups = null;
		firePropertyChange(PROP_FILES, null, null);
	}

	public void removeProfileGroup(ProfileGroup theSel) {
		myProfileGroups.remove(myProfileGroups.indexOf(theSel));
		myIdToProfileGroups = null;
		firePropertyChange(PROP_FILES, null, null);
	}

	public ProfileGroup getProfile(String theProfileId) {
		if (		myIdToProfileGroups == null) {
			myIdToProfileGroups = new HashMap<String, ProfileGroup>();
		}
		for (ProfileGroup next : myProfileGroups) {
			myIdToProfileGroups.put(next.getId(), next);
		}
		return myIdToProfileGroups.get(theProfileId);
	}

}
