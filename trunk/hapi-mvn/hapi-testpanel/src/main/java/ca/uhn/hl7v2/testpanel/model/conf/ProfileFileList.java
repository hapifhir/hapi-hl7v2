package ca.uhn.hl7v2.testpanel.model.conf;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;

import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.hl7v2.testpanel.controller.Prefs;
import ca.uhn.hl7v2.testpanel.model.AbstractModelClass;

public class ProfileFileList extends AbstractModelClass {

	private static final Logger ourLog = org.slf4j.LoggerFactory.getLogger(ProfileFileList.class);
	public static final String PROP_FILES = ProfileFileList.class.getName() + "_FILES";

	private List<ProfileGroup> myProfileGroups = new ArrayList<ProfileGroup>();

	public ProfileFileList() {
		myProfileGroups = Prefs.getOpenProfiles();
	}

	public void addNewFile(File theFile) throws IOException, ProfileException {
		ProfileProxy file = ProfileProxy.loadFromFile(theFile);
		myProfileGroups.add(new ProfileGroup(file));

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
		firePropertyChange(PROP_FILES, null, null);
	}

	private void updatePrefs() {
		Prefs.setOpenProfiles(myProfileGroups);
	}

	public void newProfileGroup() {
		myProfileGroups.add(new ProfileGroup("New Profile Group"));
		firePropertyChange(PROP_FILES, null, null);
	}

}
