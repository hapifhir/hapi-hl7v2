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
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.testpanel.controller.Controller;
import ca.uhn.hl7v2.testpanel.model.AbstractConnection;
import ca.uhn.hl7v2.testpanel.model.ActivityBase;
import ca.uhn.hl7v2.testpanel.model.ActivityIncomingBytes;
import ca.uhn.hl7v2.testpanel.model.ActivityIncomingMessage;
import ca.uhn.hl7v2.testpanel.model.ActivityMessage;
import ca.uhn.hl7v2.testpanel.model.ActivityOutgoingBytes;
import ca.uhn.hl7v2.testpanel.model.ActivityOutgoingMessage;
import ca.uhn.hl7v2.testpanel.model.InboundConnection;

public class ActivityTable extends JPanel implements IDestroyable {
	private static final Logger ourLog = LoggerFactory.getLogger(ActivityTable.class);

	private static final SimpleDateFormat ourTimestampFormat = new SimpleDateFormat("HH:mm:ss.SSS");
	private ActivityTableModel myActivityTableModel;
	private AbstractConnection myConnection;
	private Controller myController;
	private JMenuItem myEditAllButton;
	private JButton myEditButton;
	private JPopupMenu myEditMenu;
	private JMenuItem myEditSelectedButton;	
	private boolean myInboundConnection;
	private PropertyChangeListener myRecentActivityListener;
	private JMenuItem mySaveAllButton;
	private JButton mySaveButton;

	/**
	 * @wbp.nonvisual location=44,371
	 */
	private JPopupMenu mySaveMenu;

	private JMenuItem mySaveSelectedButton;
	private JScrollPane myscrollPane;
	private JTable myTable;
	
	public ActivityTable() {
		super(new BorderLayout());
		setBorder(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setRollover(true);
		toolBar.setFloatable(false);
		add(toolBar, BorderLayout.NORTH);
		
		mySaveButton = new JButton("Save");
		mySaveButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mySaveButton.setBorderPainted(true && mySaveButton.isEnabled());
			}
			@Override
			public void mouseExited(MouseEvent e) {
				mySaveButton.setBorderPainted(false);
			}
		});
		mySaveButton.setBorderPainted(false);
		mySaveButton.setEnabled(false);
		mySaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mySaveMenu.show(mySaveButton, mySaveButton.getX(), mySaveButton.getY() + mySaveButton.getHeight());
			}
		});
		mySaveButton.setIcon(new ImageIcon(ActivityTable.class.getResource("/ca/uhn/hl7v2/testpanel/images/save.png")));
		toolBar.add(mySaveButton);
		
		myEditButton = new JButton("Edit");		
		myEditButton.setEnabled(false);
		myEditButton.setBorderPainted(false);
		myEditButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				myEditButton.setBorderPainted(true && myEditButton.isEnabled());
			}
			@Override
			public void mouseExited(MouseEvent e) {
				myEditButton.setBorderPainted(false);
			}
		});
		myEditButton.setIcon(new ImageIcon(ActivityTable.class.getResource("/ca/uhn/hl7v2/testpanel/images/edit_one.png")));
		myEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myEditMenu.show(myEditButton, myEditButton.getX(), myEditButton.getY() + myEditButton.getHeight());
			}
		});
		toolBar.add(myEditButton);
		
		myscrollPane = new JScrollPane();
		add(myscrollPane, BorderLayout.CENTER);
		
		myTable = new JTable();
		myTable.setGridColor(Color.LIGHT_GRAY);
//		myTable.setCellSelectionEnabled(true);
//		myTable.setRowSelectionAllowed(true);
		myTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		myTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		myscrollPane.setViewportView(myTable);

		myEditMenu = new JPopupMenu();

		myEditSelectedButton = new JMenuItem("Edit Selected Message");
		myEditSelectedButton.setIcon(new ImageIcon(ActivityTable.class.getResource("/ca/uhn/hl7v2/testpanel/images/edit_one.png")));
		myEditSelectedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent theE) {
				ActivityMessage selected = (ActivityMessage) myActivityTableModel.getActivity(myTable.getSelectedRow());
				myController.editMessages(Collections.singletonList(selected));
			}
		});
		myEditMenu.add(myEditSelectedButton);
		
		myEditAllButton = new JMenuItem("Edit All Messages");
		myEditAllButton.setIcon(new ImageIcon(ActivityTable.class.getResource("/ca/uhn/hl7v2/testpanel/images/edit_all.png")));
		myEditAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent theE) {
				List<ActivityMessage> messages = myConnection.getRecentActivityEntriesOfType(ActivityMessage.class);
				myController.editMessages(messages);
			}
		});
		myEditMenu.add(myEditAllButton);

		mySaveMenu = new JPopupMenu();
		
		mySaveSelectedButton = new JMenuItem("Save Selected Message");
		mySaveSelectedButton.setIcon(new ImageIcon(ActivityTable.class.getResource("/ca/uhn/hl7v2/testpanel/images/save.png")));
		mySaveMenu.add(mySaveSelectedButton);
		
		mySaveAllButton = new JMenuItem("Save All Messages");
		mySaveAllButton.setIcon(new ImageIcon(ActivityTable.class.getResource("/ca/uhn/hl7v2/testpanel/images/save_all.png")));
		mySaveMenu.add(mySaveAllButton);
		
		myTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent theE) {
				updateUiBasedOnSelectedRow();
			}
		});
		updateUiBasedOnSelectedRow();
	}
	
	
	public void destroy() {
		removeListeners();
	}

	/**
	 * @return the connection
	 */
	public AbstractConnection getConnection() {
		return myConnection;
	}

	/**
	 * @return the inboundConnection
	 */
	public boolean isInboundConnection() {
		return myInboundConnection;
	}

	public boolean isResponseAtRow(int theRow) {
		ActivityBase activity = myConnection.getRecentActivity().get(theRow);
		if ((activity instanceof ActivityOutgoingMessage || activity instanceof ActivityOutgoingBytes) && isInboundConnection()) {
			return true;
		}

		if ((activity instanceof ActivityIncomingMessage || activity instanceof ActivityIncomingBytes) && !isInboundConnection()) {
			return true;
		}

		return false;
	}

	private void removeListeners() {
		if (myConnection != null) {
			myConnection.removePropertyChangeListener(AbstractConnection.RECENT_ACTIVITY_PROPERTY, myRecentActivityListener);
		}
	}

	public void setConnection(AbstractConnection theConnection) {
		setConnection(theConnection, true);
	}

	public void setConnection(AbstractConnection theConnection, boolean theIncludePreviousEvents) {
		removeListeners();

		myConnection = theConnection;
		if (myConnection instanceof InboundConnection) {
			myInboundConnection = true;
		}
		
		myActivityTableModel = new ActivityTableModel();
		myTable.setModel(myActivityTableModel);

		myRecentActivityListener = new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent theEvt) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						myActivityTableModel.update();
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								JScrollBar vsb = myscrollPane.getVerticalScrollBar();
								vsb.setValue(vsb.getMaximum());
							}
						});
					}
				});
			}
		};
		myConnection.addPropertyChangeListener(AbstractConnection.RECENT_ACTIVITY_PROPERTY, myRecentActivityListener);
		myActivityTableModel.update();

		myTable.getColumnModel().getColumn(0).setCellRenderer(new ActivityCellRendererBase(this));
		myTable.getColumnModel().getColumn(1).setCellRenderer(new ActivityTypeCellRenderer(this, theConnection instanceof InboundConnection));
		myTable.getColumnModel().getColumn(2).setCellRenderer(new ActivityDetailsCellRenderer(this));

		final int timestampWidth = 100;
		myTable.getColumnModel().getColumn(0).setMaxWidth(timestampWidth);
		myTable.getColumnModel().getColumn(0).setMinWidth(timestampWidth);
		myTable.getColumnModel().getColumn(0).setPreferredWidth(timestampWidth);

		final int activityWidth = 150;
		myTable.getColumnModel().getColumn(1).setMaxWidth(activityWidth);
		myTable.getColumnModel().getColumn(1).setMinWidth(activityWidth);
		myTable.getColumnModel().getColumn(1).setPreferredWidth(activityWidth);

		int detailWidth = 500;
		myTable.getColumnModel().getColumn(2).setMaxWidth(detailWidth);
		myTable.getColumnModel().getColumn(2).setMinWidth(detailWidth);
		myTable.getColumnModel().getColumn(2).setPreferredWidth(detailWidth);
	}

	/**
	 * @param theController the controller to set
	 */
	public void setController(Controller theController) {
		assert theController != null;
		
		myController = theController;
	}

	private void updateUiBasedOnSelectedRow() {
		boolean messageSelected = false;
		int selectedRow = myTable.getSelectedRow();
		if (selectedRow != -1) {
			Object activity = myActivityTableModel.getActivity(selectedRow);
			if (activity instanceof ActivityMessage) {
				messageSelected = true;
			}
		}
		
		mySaveSelectedButton.setEnabled(messageSelected);
		myEditSelectedButton.setEnabled(messageSelected);
	}

	private class ActivityTableModel implements TableModel {

		private List<TableModelListener> myTableListeners = new ArrayList<TableModelListener>();

		public ActivityTableModel() {
		}

		public void addTableModelListener(TableModelListener theL) {
			myTableListeners.add(theL);
		}

		public Object getActivity(int theRowIndex) {
			return myConnection.getRecentActivity().get(theRowIndex);
		}

		public Class<?> getColumnClass(int theColumnIndex) {
			return String.class;
		}

		public int getColumnCount() {
			return 3;
		}

		public String getColumnName(int theColumnIndex) {
			switch (theColumnIndex) {
			case 0:
				return "Timestamp";
			case 1:
				return "Activity";
			case 2:
				return "Details";
			default:
				throw new IllegalArgumentException(theColumnIndex + "");
			}
		}

		public int getRowCount() {
			return myConnection.getRecentActivity().size();
		}
		
		public Object getValueAt(int theRowIndex, int theColumnIndex) {
			ActivityBase activity = myConnection.getRecentActivity().get(theRowIndex);

			switch (theColumnIndex) {
			case 0:
				return ourTimestampFormat.format(activity.getTimestamp());
			case 1:
			case 2:
			default:
				return activity;
			}
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
			if (mySaveButton.isEnabled() == false && myConnection.getRecentActivity().isEmpty() == false) {
				mySaveButton.setEnabled(true);
				myEditButton.setEnabled(true);
			}
			for (TableModelListener next : myTableListeners) {
				TableModelEvent event = new TableModelEvent(this);
				next.tableChanged(event);
			}
		}

	}

}
