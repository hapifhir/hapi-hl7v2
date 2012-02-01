package ca.uhn.hl7v2.testpanel.controller;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.concurrent.DefaultExecutorService;
import ca.uhn.hl7v2.testpanel.model.conf.ProfileFileList;
import ca.uhn.hl7v2.testpanel.model.conf.TableFile;
import ca.uhn.hl7v2.testpanel.model.conf.TableFileList;
import ca.uhn.hl7v2.testpanel.ui.conf.ConformanceEditorPanel;
import ca.uhn.hl7v2.testpanel.util.ExtensionFilter;

public class ConformanceEditorController {

	private static final Logger ourLog = LoggerFactory.getLogger(ConformanceEditorController.class);

	private JFileChooser myAddTableFileChooser;
	private Controller myParentController;
	private ConformanceEditorPanel myView;

	public ConformanceEditorController(Controller theParentController) {
		myParentController = theParentController;
		myView = new ConformanceEditorPanel(this);
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

	public void show() {
		myView.show();
	}

	public ProfileFileList getProfileFileList() {
		return myParentController.getProfileFileList();
	}

	public void newProfileGroup() {
		myParentController.getProfileFileList().newProfileGroup();
	}

}
