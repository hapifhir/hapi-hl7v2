package ca.uhn.hl7v2.testpanel.controller;

import static org.apache.commons.lang.StringUtils.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.concurrent.DefaultExecutorService;
import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.hl7v2.testpanel.model.conf.ExportedProfileGroupFile;
import ca.uhn.hl7v2.testpanel.model.conf.ProfileFileList;
import ca.uhn.hl7v2.testpanel.model.conf.ProfileGroup;
import ca.uhn.hl7v2.testpanel.model.conf.ProfileProxy;
import ca.uhn.hl7v2.testpanel.model.conf.TableFile;
import ca.uhn.hl7v2.testpanel.model.conf.TableFileList;
import ca.uhn.hl7v2.testpanel.ui.conf.ConformanceEditorPanel;
import ca.uhn.hl7v2.testpanel.ui.conf.ImportProfileGroupDialog;
import ca.uhn.hl7v2.testpanel.ui.conf.ProfileGroupNameDialog;
import ca.uhn.hl7v2.testpanel.util.AllFileFilter;
import ca.uhn.hl7v2.testpanel.util.ExtensionFilter;
import ca.uhn.hl7v2.testpanel.util.IOkCancelCallback;

public class ConformanceEditorController {

	private static final Logger ourLog = LoggerFactory.getLogger(ConformanceEditorController.class);

	private JFileChooser myAddProfileFileChooser;
	private JFileChooser myAddTableFileChooser;
	private Controller myParentController;

	private ConformanceEditorPanel myView;

	public ConformanceEditorController(Controller theParentController) {
		myParentController = theParentController;
		myView = new ConformanceEditorPanel(this);
	}

	public void addProfile(ProfileGroup theProfileGroup) {
		if (myAddProfileFileChooser == null) {
			myAddProfileFileChooser = new JFileChooser(Prefs.getInstance().getOpenPathConformanceProfile());
			myAddProfileFileChooser.setDialogTitle("Choose an HL7 Conformance Profile");

			createFileSelectionExtentionFolder(myAddProfileFileChooser);
		}

		int result = myAddProfileFileChooser.showDialog(myView.getFrame(), "Open");
		if (result == JFileChooser.APPROVE_OPTION) {

			File chosenFile = myAddProfileFileChooser.getSelectedFile();
			try {
				ProfileProxy profile = ProfileProxy.loadFromFile(chosenFile);
				theProfileGroup.addProfile(profile);
				myParentController.getProfileFileList().updatePrefs();
			} catch (IOException e) {
				ourLog.error("Failed to load profile", e);
				myParentController.showDialogError("Failed to load profile: " + e.getMessage());
			} catch (ProfileException e) {
				ourLog.error("Failed to load profile", e);
				myParentController.showDialogError("Failed to load profile: " + e.getMessage());
			}

		}

	}

	public static void createFileSelectionExtentionFolder(JFileChooser theChooser) {
		theChooser.addChoosableFileFilter(new ExtensionFilter("XML Files", new String[] { ".xml" }));
		theChooser.addChoosableFileFilter(new AllFileFilter());
	}

	public void addTableFile() {
		if (myAddTableFileChooser == null) {
			myAddTableFileChooser = new JFileChooser(Prefs.getDefaultTableFileDirectory());
			createFileSelectionExtentionFolder(myAddTableFileChooser);
		}

		int outcome = myAddTableFileChooser.showDialog(myView.getFrame(), "Create");
		if (outcome == JFileChooser.APPROVE_OPTION) {

			File chosenFile = myAddTableFileChooser.getSelectedFile();
			if (chosenFile.exists()) {
				myParentController.getTableFileList().openFile(chosenFile);
			} else {
				myParentController.getTableFileList().addNewFile(chosenFile);
			}

		}

	}

	public void closeFile(TableFile theSelectedFileOrTable) {
		myParentController.getTableFileList().removeTableFile(theSelectedFileOrTable);
		myParentController.getProfileFileList().updatePrefs();
	}

	public void closeProfileGroup(ProfileGroup theSel) {
		if (showDialogYesNo("Are you sure you want to close this Profile Group?") == JOptionPane.YES_OPTION) {
			getProfileFileList().removeProfileGroup(theSel);
			myParentController.getProfileFileList().updatePrefs();
		}
	}

	public void exportProfileGroup(ProfileGroup theSelectedProfileGroupOrFile) {
		String directory = Prefs.getInstance().getExportProfileGroupDirectory();
		JFileChooser chooser = new JFileChooser(new File(directory));
		chooser.setName("Export Profile Group to file...");
		int value = chooser.showDialog(myView.getFrame(), "Export");
		if (value == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			if (file.isDirectory()) {
				myParentController.showDialogError("Must enter a file to save to");
				return;
			}

			if (file.exists()) {
				if (JOptionPane.YES_OPTION != myParentController.showDialogYesNo("File exists, overwrite it: " + file.getName())) {
					return;
				}
			}

			Prefs.getInstance().setExportProfileGroupDirectory(file.getParent());

			try {

				ExportedProfileGroupFile exported = new  ExportedProfileGroupFile(theSelectedProfileGroupOrFile, getTableFileList());
				FileWriter w = new FileWriter(file, false);
				w.append(exported.exportConfigToXm());
				w.close();

				myParentController.showDialogInfo("Exported conformance group to file:\n" + file.getName());

			} catch (IOException e) {
				ourLog.error("Failed to export profile", e);
				myParentController.showDialogError("Failed to export profile: " + e.getMessage());
			}
		}
	}

	public ProfileFileList getProfileFileList() {
		return myParentController.getProfileFileList();
	}

	public TableFileList getTableFileList() {
		return myParentController.getTableFileList();
	}

	public void importProfileGroup() {
		ImportProfileGroupDialog dialog = new ImportProfileGroupDialog();
		dialog.setVisible(true);

		URL importUrl;
		if (dialog.getUrlString() != null) {
			importUrl = dialog.getUrlString();
		} else if (dialog.getFileString() != null) {
			try {
				File file = dialog.getFileString();
				Prefs.getInstance().setImportProfileGroupDirectory(file.getParentFile());
				importUrl = file.toURI().toURL();
			} catch (MalformedURLException e) {
				myParentController.showDialogError(e.getMessage());
				return;
			}
		} else {
			ourLog.info("Aborting because neither a file nor a URL were selected");
			return;
		}

		ExportedProfileGroupFile file = ExportedProfileGroupFile.loadFromUrl(importUrl);
		if (file == null || file.getProfileGroup() == null || isBlank(file.getProfileGroup().getId())) {
			myParentController.showDialogError("File does not appear to hold an exported profile group:\n" + importUrl.toString());
			return;
		}

		try {
			file.hydrate();
		} catch (Exception e) {
			ourLog.error("Failed to hydrate exported profile group", e);
			myParentController.showDialogError("Experienced an error importing profile group file:\n" + importUrl.toString() + "\nMessage: " + e.getMessage());
			return;
		}

		String profileId = file.getProfileGroup().getId();
		if (getProfileFileList().getProfile(profileId) != null) {
			int overwrite = JOptionPane.showOptionDialog(null, "It appears that this profile group already exists. Do you want to overwrite it? Select no to add as a new profile group instead of overwriting.", "Overwrite?", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, null, JOptionPane.YES_OPTION);
			if (overwrite == JOptionPane.CANCEL_OPTION) {
				return;
			} else if (overwrite == JOptionPane.NO_OPTION) {
				file.renumberEverything();
			}
		}

		file.getProfileGroup().setSourceUrl(importUrl.toString());

		for (TableFile next : file.getTableFiles()) {
			getTableFileList().importFile(next);
		}

		getProfileFileList().importFile(file.getProfileGroup());

	}

	public void markFileForSaving(final TableFile theTableFile) {
		theTableFile.setUnsaved(true);

		// TODO: this is a pretty messy way of doing this
		DefaultExecutorService.getDefaultService().execute(new Runnable() {

			public void run() {
				synchronized (ConformanceEditorController.this) {
					if (theTableFile.isUnsaved()) {
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							// ignore
						}

						try {
							ourLog.info("Saving table file: {}", theTableFile.getFileName().getAbsolutePath());
							theTableFile.flushToFile();
							theTableFile.setUnsaved(false);
						} catch (IOException e) {
							ourLog.error("Failed to save table file " + theTableFile.getFileName().getAbsolutePath(), e);
						}

					}
				}
			}
		});
	}

	public void newProfileGroup() {

		IOkCancelCallback<String> callback = new IOkCancelCallback<String>() {

			public void cancel(String theArg) {
				// ignore
			}

			public void ok(String theArg) {
				if (StringUtils.isBlank(theArg)) {
					return;
				}

				myParentController.getProfileFileList().newProfileGroup(theArg);
				myParentController.getProfileFileList().updatePrefs();
			}
		};

		ProfileGroupNameDialog dialog = new ProfileGroupNameDialog();
		dialog.setName("New Profile Group");
		dialog.setCallback(callback);
		dialog.start();

	}

	public void renameProfileGroup(final ProfileGroup theSel) {
		IOkCancelCallback<String> callback = new IOkCancelCallback<String>() {

			public void cancel(String theArg) {
				// ignore
			}

			public void ok(String theArg) {
				if (StringUtils.isBlank(theArg)) {
					return;
				}

				theSel.setName(theArg);
				myParentController.getProfileFileList().updatePrefs();
			}
		};

		ProfileGroupNameDialog dialog = new ProfileGroupNameDialog();
		dialog.setCallback(callback);
		dialog.setName(theSel.getName());
		dialog.start();
	}

	public void show() {
		myView.show();
	}

	public int showDialogYesNo(String message) {
		return JOptionPane.showConfirmDialog(myView.getFrame(), message, Controller.DIALOG_TITLE, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	}

}
