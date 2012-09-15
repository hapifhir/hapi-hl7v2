package ca.uhn.hl7v2.testpanel.ui.conn;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import ca.uhn.hl7v2.testpanel.controller.Controller;
import ca.uhn.hl7v2.testpanel.model.conf.ProfileFileList;
import ca.uhn.hl7v2.testpanel.model.conf.ProfileGroup;
import ca.uhn.hl7v2.testpanel.model.conn.InboundConnection;
import ca.uhn.hl7v2.testpanel.ui.IDestroyable;

public class ValidationHeaderPanel extends JPanel implements IDestroyable {
	private InboundConnection myConnection;
	private Controller myController;
	private boolean myHandlingUpdate;
	private JComboBox myProfileGroupComboBox;
	private PropertyChangeListener myProfileGroupsListener;
	private DefaultComboBoxModel myProfileGroupsModel;
	private JCheckBox myValidateUsingProfileGroupCheckbox;
	private PropertyChangeListener myValidationListener;
	private PropertyChangeListener myStatusListener;

	/**
	 * Create the panel.
	 */
	public ValidationHeaderPanel(Controller theController) {
		setMaximumSize(new Dimension(32767, 60));
		myController = theController;

		setBorder(new TitledBorder(null, "Message Validation", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		myValidateUsingProfileGroupCheckbox = new JCheckBox("Validate Incoming Messages Using Profile Group:");
		myValidateUsingProfileGroupCheckbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateModel();
			}
		});
		GridBagConstraints gbc_ValidateUsingProfileGroupCheckbox = new GridBagConstraints();
		gbc_ValidateUsingProfileGroupCheckbox.insets = new Insets(0, 0, 0, 5);
		gbc_ValidateUsingProfileGroupCheckbox.gridx = 0;
		gbc_ValidateUsingProfileGroupCheckbox.gridy = 0;
		add(myValidateUsingProfileGroupCheckbox, gbc_ValidateUsingProfileGroupCheckbox);

		myProfileGroupsModel = new DefaultComboBoxModel();
		myProfileGroupComboBox = new JComboBox(myProfileGroupsModel);
		myProfileGroupComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateModel();
			}
		});
		myProfileGroupComboBox.setPreferredSize(new Dimension(400, 27));
		myProfileGroupComboBox.setMinimumSize(new Dimension(400, 27));
		GridBagConstraints gbc_ProfileGroupComboBox = new GridBagConstraints();
		gbc_ProfileGroupComboBox.anchor = GridBagConstraints.WEST;
		gbc_ProfileGroupComboBox.gridx = 1;
		gbc_ProfileGroupComboBox.gridy = 0;
		add(myProfileGroupComboBox, gbc_ProfileGroupComboBox);

	}

	public void destroy() {
		myConnection.removePropertyChangeListener(InboundConnection.PROP_VALIDATE_INCOMING, myValidationListener);
		myController.getProfileFileList().removePropertyChangeListener(ProfileFileList.PROP_FILES, myProfileGroupsListener);
		myConnection.removePropertyChangeListener(InboundConnection.STATUS_PROPERTY, myStatusListener);
	}

	public void setConnection(InboundConnection theConnection) {
		myConnection = theConnection;

		myValidationListener = new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent theEvt) {
				updateView();
			}
		};
		myConnection.addPropertyChangeListener(InboundConnection.PROP_VALIDATE_INCOMING, myValidationListener);
		updateView();

		myProfileGroupsListener = new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent theEvt) {
				updateView();
			}
		};
		myController.getProfileFileList().addPropertyChangeListener(ProfileFileList.PROP_FILES, myProfileGroupsListener);
		
		myStatusListener = new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent theEvt) {
				updateView();
			}
		};
		myConnection.addPropertyChangeListener(InboundConnection.STATUS_PROPERTY, myStatusListener);
		
	}

	private void updateView() {
		if (myHandlingUpdate) {
			return;
		}

		myHandlingUpdate = true;
		try {
			boolean validationActive = false;
			int index = 0;
			String profileGroupId = myConnection.getValidateIncomingUsingProfileGroupId();
			for (ProfileGroup nextGroup : myController.getProfileFileList().getProfiles()) {
				if (myProfileGroupsModel.getSize() <= index || myProfileGroupsModel.getElementAt(index).equals(nextGroup.getName())) {
					myProfileGroupsModel.insertElementAt(nextGroup.getName(), index);
				}

				String nextGroupId = nextGroup.getId();
				if (nextGroupId.equals(profileGroupId)) {
					myProfileGroupComboBox.setSelectedIndex(index);
					validationActive = true;
				}

				index++;
			}

			while (myProfileGroupsModel.getSize() > myController.getProfileFileList().getProfiles().size()) {
				myProfileGroupsModel.removeElementAt(myProfileGroupsModel.getSize() - 1);
			}

			if (validationActive) {
				myValidateUsingProfileGroupCheckbox.setEnabled(true);
				myValidateUsingProfileGroupCheckbox.setSelected(true);
				myProfileGroupComboBox.setEnabled(true);
			} else if (myProfileGroupsModel.getSize() > 0) {
				myValidateUsingProfileGroupCheckbox.setEnabled(true);
				myValidateUsingProfileGroupCheckbox.setSelected(false);
				myProfileGroupComboBox.setEnabled(true);
				if (myProfileGroupComboBox.getSelectedIndex() == -1) {
					myProfileGroupComboBox.setSelectedIndex(0);
				}
			} else {
				myValidateUsingProfileGroupCheckbox.setEnabled(false);
				myValidateUsingProfileGroupCheckbox.setSelected(false);
				myProfileGroupsModel.addElement("None Defined");
				myProfileGroupComboBox.setEnabled(false);
			}
			
			if (myConnection.getStatus().isRunning()) {
				myProfileGroupComboBox.setEnabled(false);
				myValidateUsingProfileGroupCheckbox.setEnabled(false);
			} 
			
		} finally {
			myHandlingUpdate = false;
		}
	}

	private void updateModel() {
		if (myHandlingUpdate) {
			return;
		}
		myHandlingUpdate = true;
		try {
			if (myValidateUsingProfileGroupCheckbox.isSelected() && myProfileGroupComboBox.getSelectedIndex() != -1) {
				String selectedId = myController.getProfileFileList().getProfiles().get(myProfileGroupComboBox.getSelectedIndex()).getId();
				myConnection.setValidateIncomingUsingProfileGroupId(selectedId);
			} else {
				myConnection.setValidateIncomingUsingProfileGroupId(null);
			}
		} finally {
			myHandlingUpdate = false;
		}
	}

}
