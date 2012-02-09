package ca.uhn.hl7v2.testpanel.model.conf;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import ca.uhn.hl7v2.testpanel.controller.Prefs;
import ca.uhn.hl7v2.testpanel.model.AbstractModelClass;

public class TableFileList extends AbstractModelClass {

	private static final Logger ourLog = org.slf4j.LoggerFactory.getLogger(TableFileList.class);
	public static final String PROP_FILES = TableFileList.class.getName() + "_FILES";
	
	private List<TableFile> myTableFiles = new ArrayList<TableFile>();
	private HashMap<String, TableFile> myIdToTableFiles;

	public TableFileList() {
		List<File> files = Prefs.getOpenTableFiles();
		for (File file : files) {
			ourLog.info("Loading table file {}", file.getAbsoluteFile());
			try {
				TableFile next = TableFile.readFromFile(file);
				if (!myTableFiles.contains(next)) {
					myTableFiles.add(next);
				}
			} catch (IOException e) {
				continue;
			}
		}
	}
	
	/**
	 * @return the tableFiles
	 */
	public List<TableFile> getTableFiles() {
		return myTableFiles;
	}

	@Override
	public Object exportConfigToXml() {
		return null;
	} 
	
	public void addNewFile(File theFileName) {
		TableFile file = new TableFile();
		file.setId(UUID.randomUUID().toString());
		file.setFileName(theFileName);

		if (!myTableFiles.contains(file)) {
			myIdToTableFiles = null;
			myTableFiles.add(file);
		}
		
		try {
			file.flushToFile();
		} catch (IOException e) {
			ourLog.error("Failed to save file!", e);
			return;
		}
		
		firePropertyChange(PROP_FILES, null, null);
		
		updatePrefs();
	}

	private void updatePrefs() {
		ArrayList<File> files = new ArrayList<File>();
		for (TableFile next : myTableFiles) {
			files.add(next.getFileName());
		}
		Prefs.setOpenTableFiles(files);
	}

	public boolean openFile(File theChosenFile) {
		try {
			TableFile newFile = TableFile.readFromFile(theChosenFile);
			if (!myTableFiles.contains(newFile)) {
				myIdToTableFiles = null;
				myTableFiles.add(newFile);
			}
			firePropertyChange(PROP_FILES, null, null);
			
			if (StringUtils.isNotBlank(newFile.getId())) {
				return true;
			}
		} catch (IOException e) {
			return false;
		}
		return false;
	}

	public void removeTableFile(TableFile theSelectedFileOrTable) {
		myTableFiles.remove(theSelectedFileOrTable);
		myIdToTableFiles = null;
		firePropertyChange(PROP_FILES, null, null);
	}

	public TableFile getTableFile(String theTableFileId) {
		if (myIdToTableFiles == null) {
			myIdToTableFiles = new HashMap<String, TableFile>();
			for (TableFile next : myTableFiles) {
				myIdToTableFiles.put(next.getId(), next);
			}
		}
		return myIdToTableFiles.get(theTableFileId);
	}
	
}
