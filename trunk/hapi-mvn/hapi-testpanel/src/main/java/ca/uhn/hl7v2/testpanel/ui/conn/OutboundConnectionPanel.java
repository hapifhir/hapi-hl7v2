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

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import ca.uhn.hl7v2.testpanel.controller.Controller;
import ca.uhn.hl7v2.testpanel.model.conn.AbstractConnection;
import ca.uhn.hl7v2.testpanel.model.conn.OutboundConnection;
import ca.uhn.hl7v2.testpanel.model.conn.AbstractConnection.StatusEnum;
import ca.uhn.hl7v2.testpanel.ui.ActivityTable;
import ca.uhn.hl7v2.testpanel.ui.BaseMainPanel;
import ca.uhn.hl7v2.testpanel.ui.IDestroyable;

public class OutboundConnectionPanel extends BaseMainPanel implements IDestroyable {

	private ActivityTable myActivityTable;
	private OutboundConnection myConnection;
	private PropertyChangeListener myNameListener;
	private Hl7ConnectionPanel mySettingPanel;
	private JTabbedPane myTabbedPane;
	private JPanel myActivityPanelTab;
	private Hl7ConnectionPanelHeader myHeaderPanel;
	private PropertyChangeListener myStatusPropertyChangeListener;

	/**
	 * Create the panel.
	 */
	public OutboundConnectionPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 593, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 313, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
		
		myHeaderPanel = new Hl7ConnectionPanelHeader();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(myHeaderPanel, gbc_panel);
		
		myTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_TabbedPane = new GridBagConstraints();
		gbc_TabbedPane.fill = GridBagConstraints.BOTH;
		gbc_TabbedPane.gridx = 0;
		gbc_TabbedPane.gridy = 1;
		add(myTabbedPane, gbc_TabbedPane);
		mySettingPanel = new Hl7ConnectionPanel();
		myTabbedPane.addTab("Settings", null, mySettingPanel, null);
		mySettingPanel.setBorder(null);
		
				myActivityPanelTab = new JPanel();
				myTabbedPane.addTab("Activity", null, myActivityPanelTab, null);
				myActivityPanelTab.setLayout(new BorderLayout(0, 0));
				
						JLabel lblActivity = new JLabel("Activity");
						myActivityPanelTab.add(lblActivity, BorderLayout.NORTH);
						
								myActivityTable = new ActivityTable();
								myActivityPanelTab.add(myActivityTable, BorderLayout.CENTER);

	}

	public void destroy() {
		mySettingPanel.destroy();
		myActivityTable.destroy();
		myHeaderPanel.destroy();
		myConnection.removePropertyChangeListener(OutboundConnection.NAME_PROPERTY, myNameListener);
		myConnection.removePropertyChangeListener(AbstractConnection.STATUS_PROPERTY, myStatusPropertyChangeListener);
	}

	public void setConnection(OutboundConnection theConnection) {
		mySettingPanel.setConnection(theConnection);
		myHeaderPanel.setConnection(theConnection);
		myActivityTable.setConnection(theConnection);
		myConnection = theConnection;

		myNameListener = new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent theEvt) {
				updateWindowTitle();
			}
		};
		theConnection.addPropertyChangeListener(OutboundConnection.NAME_PROPERTY, myNameListener);
		updateWindowTitle();

		if (theConnection.getStatus() == StatusEnum.STARTED || theConnection.getStatus() == StatusEnum.TRYING_TO_START) {
			myTabbedPane.setSelectedIndex(1);
		} else {
			myTabbedPane.setSelectedIndex(0);
		}

		myStatusPropertyChangeListener = new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent theEvt) {
				StatusEnum oldVal = (StatusEnum) theEvt.getOldValue();
				StatusEnum newVal = (StatusEnum) theEvt.getNewValue();
				if (oldVal == StatusEnum.STOPPED && (newVal == StatusEnum.TRYING_TO_START||newVal == StatusEnum.STARTED)) {
					myTabbedPane.setSelectedIndex(1);
				}else if ((oldVal == StatusEnum.TRYING_TO_START||oldVal == StatusEnum.STARTED) && newVal == StatusEnum.STOPPED) {
					myTabbedPane.setSelectedIndex(0);
				}
			}
		};
		myConnection.addPropertyChangeListener(AbstractConnection.STATUS_PROPERTY, myStatusPropertyChangeListener);

	}

	public void setController(Controller theController) {
		myActivityTable.setController(theController);
	}

	private void updateWindowTitle() {
		setWindowTitle(myConnection.getName());
	}

}