/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is ""  Description:
 * ""
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2001.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  "GPL"), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 */
package ca.uhn.hl7v2.testpanel.ui.conn;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;

import org.apache.commons.lang.StringUtils;

import ca.uhn.hl7v2.testpanel.model.conn.AbstractConnection;
import ca.uhn.hl7v2.testpanel.model.conn.AbstractConnection.StatusEnum;
import ca.uhn.hl7v2.testpanel.model.conn.InboundConnection;
import ca.uhn.hl7v2.testpanel.model.conn.OutboundConnection;
import ca.uhn.hl7v2.testpanel.ui.IDestroyable;
import ca.uhn.hl7v2.testpanel.util.SimpleDocumentListener;

public class Hl7ConnectionPanelHeader extends JPanel implements IDestroyable {
	private JTextField myNameBox;
	private AbstractConnection myConnection;
	private PropertyChangeListener myNamePropertyChangeListener;
	private PropertyChangeListener myStatusPropertyChangeListener;
	private boolean myIgnoreNameChanges;
	private JButton myStartButton;
	private JButton myStopButton;
	private PropertyChangeListener myStatusLinePropertyChangeListener;
	private JLabel myStatusLabel;
	private JCheckBox myRememberAsCheckBox;


	public void setConnection(AbstractConnection theConnection) {
		myConnection = theConnection;

		if (myConnection instanceof InboundConnection) {
			setLabelText("Incoming Message Receiver");
		} else {
			setLabelText("Outgoing Message Sender");
		}
		
		myNameBox.setText(theConnection.getName());

		myNamePropertyChangeListener = new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent theEvt) {
				if (!myIgnoreNameChanges) {
					myNameBox.setText(myConnection.getName());
				}
			}
		};
		myConnection.addPropertyChangeListener(OutboundConnection.NAME_PROPERTY, myNamePropertyChangeListener);

		myStatusPropertyChangeListener = new PropertyChangeListener() {

			public void propertyChange(PropertyChangeEvent theEvt) {
				updateStatus();
			}
		};
		myConnection.addPropertyChangeListener(OutboundConnection.STATUS_PROPERTY, myStatusPropertyChangeListener);

		myStatusLinePropertyChangeListener = new PropertyChangeListener() {

			public void propertyChange(PropertyChangeEvent theEvt) {
				updateStatus();
			}
		};
		myConnection.addPropertyChangeListener(OutboundConnection.STATUS_LINE_PROPERTY, myStatusLinePropertyChangeListener);

		updateStatus();
		
		updateRememberAsUi();
		
	}

	private void updateRememberAsUi() {
		boolean newState = myConnection.isPersistent();
		myRememberAsCheckBox.setSelected(newState);
		myNameBox.setEnabled(newState);
	}

	private void updateStatus() {

		if (myConnection.getStatus() == StatusEnum.FAILED) {
			myStatusLabel.setForeground(Color.red);
		} else {
			myStatusLabel.setForeground(Color.black);
		}
		if (StringUtils.isNotBlank(myConnection.getStatusLine())) {
			myStatusLabel.setText(myConnection.getStatusLine());
		} else {
			myStatusLabel.setText("");
		}
		
		switch (myConnection.getStatus()) {
		case FAILED:
		case STOPPED:
			myStartButton.setEnabled(true);
			myStopButton.setEnabled(false);
			break;
		case STARTED:
		case TRYING_TO_START:
			myStartButton.setEnabled(false);
			myStopButton.setEnabled(true);
			break;
		}
		
	}

	/**
	 * Don't allow the user to start and stop this interface
	 */
	public void markDisableStartingAndStopping() {
		myStartButton.setEnabled(false);
		myStopButton.setEnabled(false);
	}
	
	public void setLabelText(String theText) {
		assert StringUtils.isNotBlank(theText);
		
		TitledBorder titledBorder = (TitledBorder)getBorder();
		titledBorder.setTitle(theText);
	}
	
	/**
	 * Create the panel.
	 */
	public Hl7ConnectionPanelHeader() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Outbound Message Sender", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 138, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		myNameBox = new JTextField();
		myNameBox.getDocument().addDocumentListener(new SimpleDocumentListener() {
			@Override
			public void update(DocumentEvent theE) {
				myIgnoreNameChanges = true;
				try {
					myConnection.setNameExplicitly(myNameBox.getText());
				} finally {
					myIgnoreNameChanges = false;
				}
			}
		});
		
		myRememberAsCheckBox = new JCheckBox("Save With Name:");
		myRememberAsCheckBox.setToolTipText("If checked, this connection will be saved for the next time you start TestPanel");
		myRememberAsCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myConnection.setPersistent(myRememberAsCheckBox.isSelected());
				updateRememberAsUi();
			}
		});
		GridBagConstraints gbc_RememberAsCheckBox = new GridBagConstraints();
		gbc_RememberAsCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_RememberAsCheckBox.gridx = 0;
		gbc_RememberAsCheckBox.gridy = 0;
		add(myRememberAsCheckBox, gbc_RememberAsCheckBox);
		GridBagConstraints gbc_NameBox = new GridBagConstraints();
		gbc_NameBox.insets = new Insets(0, 0, 5, 0);
		gbc_NameBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_NameBox.gridx = 1;
		gbc_NameBox.gridy = 0;
		add(myNameBox, gbc_NameBox);
		myNameBox.setColumns(10);

		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.anchor = GridBagConstraints.WEST;
		gbc_panel_5.fill = GridBagConstraints.VERTICAL;
		gbc_panel_5.gridx = 1;
		gbc_panel_5.gridy = 1;
		add(panel_5, gbc_panel_5);

		myStartButton = new JButton("Start");
		myStartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myConnection.start();
			}
		});
		panel_5.add(myStartButton);

		myStopButton = new JButton("Stop");
		myStopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myConnection.stop();
			}
		});
		panel_5.add(myStopButton);
		
		myStatusLabel = new JLabel("New label");
		panel_5.add(myStatusLabel);

	}

	public void destroy() {
		myConnection.removePropertyChangeListener(OutboundConnection.NAME_PROPERTY, myNamePropertyChangeListener);
		myConnection.removePropertyChangeListener(OutboundConnection.STATUS_PROPERTY, myStatusPropertyChangeListener);
		myConnection.removePropertyChangeListener(OutboundConnection.STATUS_LINE_PROPERTY, myStatusLinePropertyChangeListener);
	}

}
