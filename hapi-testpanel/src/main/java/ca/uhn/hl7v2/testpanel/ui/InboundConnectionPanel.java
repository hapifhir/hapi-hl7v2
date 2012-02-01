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
package ca.uhn.hl7v2.testpanel.ui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import ca.uhn.hl7v2.testpanel.controller.Controller;
import ca.uhn.hl7v2.testpanel.model.AbstractConnection;
import ca.uhn.hl7v2.testpanel.model.AbstractConnection.StatusEnum;
import ca.uhn.hl7v2.testpanel.model.InboundConnection;

public class InboundConnectionPanel extends BaseMainPanel implements IDestroyable {
	
	private ActivityTable myActivityTable;
	private InboundConnection myConnection;
	private PropertyChangeListener myConnectionsListener;
	private JTable myConnectionsTable;
	private ConnectionsTableModel myConnectionsTableModel;
	private Hl7ConnectionPanel mySettingPanelTab;
	private PropertyChangeListener myNameListener;
	private Hl7ConnectionPanelHeader myHeaderPanel;
	private JSplitPane myActivitySplitPaneTab;
	private JTabbedPane myTabbedPane;
	private PropertyChangeListener myStatusPropertyChangeListener;

	
	/**
	 * Create the panel.
	 */
	public InboundConnectionPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 559, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 315, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
		
		myHeaderPanel = new Hl7ConnectionPanelHeader();
		myHeaderPanel.setBorder(null);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		add(myHeaderPanel, gbc_panel_2);
		
		myTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_TabbedPane = new GridBagConstraints();
		gbc_TabbedPane.fill = GridBagConstraints.BOTH;
		gbc_TabbedPane.gridx = 0;
		gbc_TabbedPane.gridy = 1;
		add(myTabbedPane, gbc_TabbedPane);
		mySettingPanelTab = new Hl7ConnectionPanel();
		myTabbedPane.addTab("Settings", null, mySettingPanelTab, null);
		mySettingPanelTab.setBorder(null);
		
				myActivitySplitPaneTab = new JSplitPane();
				myTabbedPane.addTab("Activity", null, myActivitySplitPaneTab, null);
				myActivitySplitPaneTab.setResizeWeight(0.3);
				
						JPanel panel_1 = new JPanel();
						myActivitySplitPaneTab.setLeftComponent(panel_1);
						panel_1.setLayout(new BorderLayout(0, 0));
						
								JLabel lblConnections = new JLabel("Connections");
								panel_1.add(lblConnections, BorderLayout.NORTH);
								
										JScrollPane scrollPane = new JScrollPane();
										panel_1.add(scrollPane, BorderLayout.CENTER);
										
										myConnectionsTableModel = new ConnectionsTableModel();
												myConnectionsTable = new JTable();
												myConnectionsTable.setModel(myConnectionsTableModel);
												scrollPane.setViewportView(myConnectionsTable);
												
														JPanel panel = new JPanel();
														myActivitySplitPaneTab.setRightComponent(panel);
														panel.setLayout(new BorderLayout(0, 0));
														
																JLabel lblActivity = new JLabel("Activity");
																panel.add(lblActivity, BorderLayout.NORTH);
																
																		myActivityTable = new ActivityTable();
																		panel.add(myActivityTable, BorderLayout.CENTER);
	}

	public void setController(Controller theController) {
		myActivityTable.setController(theController);
	}
	
	public void destroy() {
		mySettingPanelTab.destroy();
		myConnection.removePropertyChangeListener(InboundConnection.CONNECTIONS_PROPERTY, myConnectionsListener);
		myConnection.removePropertyChangeListener(InboundConnection.NAME_PROPERTY, myNameListener);
		myActivityTable.destroy();
		myHeaderPanel.destroy();
		myConnection.removePropertyChangeListener(AbstractConnection.STATUS_PROPERTY, myStatusPropertyChangeListener);
	}

	public void setConnection(InboundConnection theConnection) {
		mySettingPanelTab.setConnection(theConnection);
		myHeaderPanel.setConnection(theConnection);
		myConnection = theConnection;
		myActivityTable.setConnection(theConnection);

		myConnectionsListener = new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent theEvt) {
				myConnectionsTableModel.update();
			}
		};
		theConnection.addPropertyChangeListener(InboundConnection.CONNECTIONS_PROPERTY, myConnectionsListener);
		myConnectionsTableModel.update();
		
		myNameListener = new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent theEvt) {
				updateWindowTitle();
			}
		};
		theConnection.addPropertyChangeListener(InboundConnection.NAME_PROPERTY, myNameListener);
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


	private void updateWindowTitle() {
		setWindowTitle(myConnection.getName());
	}
	
	private class ConnectionsTableModel implements TableModel {

		private List<TableModelListener> myTableListeners = new ArrayList<TableModelListener>();

		public ConnectionsTableModel() {
		}

		public void addTableModelListener(TableModelListener theL) {
			myTableListeners.add(theL);
		}

		public Class<?> getColumnClass(int theColumnIndex) {
			return String.class;
		}

		public int getColumnCount() {
			return 1;
		}

		public String getColumnName(int theColumnIndex) {
			return "Address";
		}

		public int getRowCount() {
			return myConnection.getConnections().size();
		}

		public Object getValueAt(int theRowIndex, int theColumnIndex) {
			InetAddress address = myConnection.getConnections().get(theRowIndex).getRemoteAddress();
			int port = myConnection.getConnections().get(theRowIndex).getRemotePort();
			return address.getCanonicalHostName() + ":" + port; 
		}

		public boolean isCellEditable(int theRowIndex, int theColumnIndex) {
			return false;
		}

		public void removeTableModelListener(TableModelListener theL) {
			myTableListeners.remove(theL);
		}

		public void setValueAt(Object theAValue, int theRowIndex, int theColumnIndex) {
			throw new UnsupportedOperationException();
		}

		public void update() {
			for (TableModelListener next : myTableListeners) {
				TableModelEvent event = new TableModelEvent(this);
				next.tableChanged(event);
			}
		}

	}

}
