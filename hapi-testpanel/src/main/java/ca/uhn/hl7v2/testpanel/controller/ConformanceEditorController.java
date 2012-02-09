package ca.uhn.hl7v2.testpanel.controller;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.concurrent.DefaultExecutorService;
import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.hl7v2.testpanel.model.conf.ProfileFileList;
import ca.uhn.hl7v2.testpanel.model.conf.ProfileGroup;
import ca.uhn.hl7v2.testpanel.model.conf.ProfileProxy;
import ca.uhn.hl7v2.testpanel.model.conf.TableFile;
import ca.uhn.hl7v2.testpanel.model.conf.TableFileList;
import ca.uhn.hl7v2.testpanel.ui.conf.ConformanceEditorPanel;
import ca.uhn.hl7v2.testpanel.ui.conf.ProfileGroupNameDialog;
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
			myAddProfileFileChooser = new JFileChooser(Prefs.getOpenPathConformanceProfile());
			myAddProfileFileChooser.setDialogTitle("Choose an HL7 Conformance Profile");

			ExtensionFilter type = new ExtensionFilter("XML Files", new String[] { ".xml" });
			myAddProfileFileChooser.addChoosableFileFilter(type);
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

	public void addTableFile() {
		if (myAddTableFileChooser == null) {
			myAddTableFileChooser = new JFileChooser(Prefs.getDefaultTableFileDirectory());

			ExtensionFilter type = new ExtensionFilter("XML Files", new String[] { ".xml" });
			myAddTableFileChooser.addChoosableFileFilter(type);
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

	public ProfileFileList getProfileFileList() {
		return myParentController.getProfileFileList();
	}

	public TableFileList getTableFileList() {
		return myParentController.getTableFileList();
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

			public void ok(String theArg) {
				if (StringUtils.isBlank(theArg)) {
					return;
				}
				
				myParentController.getProfileFileList().newProfileGroup(theArg);
				myParentController.getProfileFileList().updatePrefs();
			}

			public void cancel(String theArg) {
				// ignore
			}
		};
		
		ProfileGroupNameDialog dialog = new ProfileGroupNameDialog();
		dialog.setName("New Profile Group");
		dialog.setCallback(callback);
		dialog.start();
		
	}

	public void show() {
		myView.show();
	}

	public int showDialogYesNo(String message) {
		return JOptionPane.showConfirmDialog(myView.getFrame(), message, Controller.DIALOG_TITLE, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	}

	public void renameProfileGroup(final ProfileGroup theSel) {
		IOkCancelCallback<String> callback = new IOkCancelCallback<String>() {

			public void ok(String theArg) {
				if (StringUtils.isBlank(theArg)) {
					return;
				}
				
				theSel.setName(theArg);
				myParentController.getProfileFileList().updatePrefs();
			}

			public void cancel(String theArg) {
				// ignore
			}
		};
		
		ProfileGroupNameDialog dialog = new ProfileGroupNameDialog();
		dialog.setCallback(callback);
		dialog.setName(theSel.getName());
		dialog.start();
	}

}
