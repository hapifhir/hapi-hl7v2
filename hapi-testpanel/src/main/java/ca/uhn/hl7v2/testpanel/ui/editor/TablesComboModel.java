package ca.uhn.hl7v2.testpanel.ui.editor;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.DefaultComboBoxModel;

import ca.uhn.hl7v2.testpanel.controller.Controller;
import ca.uhn.hl7v2.testpanel.model.conf.TableFile;
import ca.uhn.hl7v2.testpanel.model.conf.TableFileList;
import ca.uhn.hl7v2.testpanel.ui.IDestroyable;

public class TablesComboModel extends DefaultComboBoxModel implements IDestroyable {

	public static final String NONE_DEFINED = "None Defined";
	public static final String NONE = "None";

	private static PropertyChangeListener myFilesListener;
	private static TableFileList myTableFileList;

	/**
	 * Constructor
	 */
	public TablesComboModel(Controller theController) {

		myTableFileList = theController.getTableFileList();
		myFilesListener = new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent theEvt) {
				update();
			}
		};
		myTableFileList.addPropertyChangeListener(TableFileList.PROP_FILES, myFilesListener);
		update();
	}

	private void update() {
		int i = 0;

		if (myTableFileList.getTableFiles().size() > 0) {
			if (getSize() == 0) {
				addElement(NONE);
			} else if (getElementAt(0) != NONE) {
				insertElementAt(NONE, 0);
			}
		}

		for (TableFile next : myTableFileList.getTableFiles()) {
			String nextName = next.getName();
			if (getSize() <= (i + 1) || !getElementAt(i).equals(nextName)) {
				insertElementAt(nextName, i + 1);
			}

			i++;
		}

		if (this.getSize() == 0) {
			addElement(NONE_DEFINED);
		}

		while (Math.min(1, this.getSize()) > myTableFileList.getTableFiles().size()) {
			removeElementAt(this.getSize() - 1);
		}
	}

	public void destroy() {
		myTableFileList.removePropertyChangeListener(TableFileList.PROP_FILES, myFilesListener);
	}

}
