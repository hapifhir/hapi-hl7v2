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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.BoundedRangeModel;
import javax.swing.DefaultBoundedRangeModel;
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
import ca.uhn.hl7v2.testpanel.model.ActivityBase;
import ca.uhn.hl7v2.testpanel.model.ActivityIncomingBytes;
import ca.uhn.hl7v2.testpanel.model.ActivityIncomingMessage;
import ca.uhn.hl7v2.testpanel.model.ActivityMessage;
import ca.uhn.hl7v2.testpanel.model.ActivityOutgoingBytes;
import ca.uhn.hl7v2.testpanel.model.ActivityOutgoingMessage;
import ca.uhn.hl7v2.testpanel.model.conn.AbstractConnection;
import ca.uhn.hl7v2.testpanel.model.conn.InboundConnection;
import javax.swing.ScrollPaneConstants;

public class ActivityTable extends JPanel implements IDestroyable {
	private static final Logger ourLog = LoggerFactory.getLogger(ActivityTable.class);
	private static final SimpleDateFormat ourTimestampFormat = new SimpleDateFormat("HH:mm:ss.SSS");

	private JButton clearButton;
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
	private JScrollPane myScrollPane;
	private JTable myTable;
	private ActivityDetailsCellRenderer myDetailsCellRenderer;
	public ActivityTable() {
		super(new BorderLayout());
		setBorder(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setRollover(true);
		toolBar.setFloatable(false);
		add(toolBar, BorderLayout.NORTH);
		
		clearButton = new JButton("Clear");
		clearButton.addMouseListener(new HoverButtonMouseAdapter(clearButton));
		clearButton.setIcon(new ImageIcon(ActivityTable.class.getResource("/ca/uhn/hl7v2/testpanel/images/clear.png")));
		clearButton.setBorderPainted(false);
		clearButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent theE) {
				myConnection.clearRecentActivity();
			}
		});
		toolBar.add(clearButton);
		
		mySaveButton = new JButton("Save");
		mySaveButton.addMouseListener(new HoverButtonMouseAdapter(mySaveButton));
		mySaveButton.setBorderPainted(false);
		mySaveButton.setEnabled(false);
		mySaveButton.setIcon(new ImageIcon(ActivityTable.class.getResource("/ca/uhn/hl7v2/testpanel/images/save.png")));
		mySaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mySaveMenu.show(mySaveButton, mySaveButton.getX(), mySaveButton.getY() + mySaveButton.getHeight());
			}
		});
		toolBar.add(mySaveButton);
		
		
		
		myEditButton = new JButton("Edit");		
		myEditButton.setEnabled(false);
		myEditButton.setBorderPainted(false);
		myEditButton.addMouseListener(new HoverButtonMouseAdapter(myEditButton));
		myEditButton.setIcon(new ImageIcon(ActivityTable.class.getResource("/ca/uhn/hl7v2/testpanel/images/edit_one.png")));
		myEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myEditMenu.show(myEditButton, myEditButton.getX(), myEditButton.getY() + myEditButton.getHeight());
			}
		});
		toolBar.add(myEditButton);
		
		myScrollPane = new JScrollPane();
		myScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(myScrollPane, BorderLayout.CENTER);
		
		myTable = new JTable();
		myTable.setGridColor(Color.LIGHT_GRAY);
//		myTable.setCellSelectionEnabled(true);
//		myTable.setRowSelectionAllowed(true);
		myTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		myTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		myScrollPane.setViewportView(myTable);

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
	
	/**
	 * @return the scrollPane
	 */
	public JScrollPane getScrollPane() {
		return myScrollPane;
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
						myDetailsCellRenderer.markScrollToBottom();
						
					}
				});
			}
		};
		myConnection.addPropertyChangeListener(AbstractConnection.RECENT_ACTIVITY_PROPERTY, myRecentActivityListener);
		myActivityTableModel.update();

//		JScrollBar vsb = myscrollPane.getVerticalScrollBar();
//		BoundedRangeModel vsbModel = new MyVerticalScrollbarModel();
//		vsb.setModel(vsbModel);
		
		myTable.getColumnModel().getColumn(0).setCellRenderer(new ActivityCellRendererBase(this));
		myTable.getColumnModel().getColumn(1).setCellRenderer(new ActivityTypeCellRenderer(this, theConnection instanceof InboundConnection));
		
		myDetailsCellRenderer = new ActivityDetailsCellRenderer(this);
		myTable.getColumnModel().getColumn(2).setCellRenderer(myDetailsCellRenderer);

		final int timestampWidth = 100;
		myTable.getColumnModel().getColumn(0).setMaxWidth(timestampWidth);
		myTable.getColumnModel().getColumn(0).setMinWidth(timestampWidth);
		myTable.getColumnModel().getColumn(0).setPreferredWidth(timestampWidth);

		final int activityWidth = 150;
		myTable.getColumnModel().getColumn(1).setMaxWidth(activityWidth);
		myTable.getColumnModel().getColumn(1).setMinWidth(activityWidth);
		myTable.getColumnModel().getColumn(1).setPreferredWidth(activityWidth);

		int detailWidth = 5000;
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

	class ActivityTableModel implements TableModel {

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

	public ActivityTableModel getTableModel() {
		return myActivityTableModel;
	}

//	public class MyVerticalScrollbarModel extends DefaultBoundedRangeModel implements BoundedRangeModel {
//
//		@Override
//		public void setRangeProperties(int theNewValue, int theNewExtent, int theNewMin, int theNewMax, boolean theAdjusting) {
//			super.setRangeProperties(theNewValue, theNewExtent, theNewMin, theNewMax, theAdjusting);
//			
//			int oldVal = getValue();
//			int newVal = getMaximum();
//	        newVal = Math.min(newVal, Integer.MAX_VALUE - getExtent());
//
//	        newVal = Math.max(newVal, getMinimum());
//	        if (newVal + getExtent() > getMaximum()) {
//	            newVal = getMaximum() - getExtent(); 
//	        }
//
//			if (oldVal != newVal) {
//				ourLog.info("Changing scrollbar max from {} to {}", oldVal, newVal);
//				setValue(getMaximum());
//			}
//		}
//
//		@Override
//		public void setMaximum(int theN) {
//			super.setMaximum(theN);
//
//			int oldVal = getValue();
//			int newVal = getMaximum();
//			
//			if (oldVal != newVal) {
//				ourLog.info("Changing scrollbar max/max from {} to {}", oldVal, newVal);
//				setValue(getMaximum());
//			}
//		}
//		
//		 public void setValue(int n) {
//		        n = Math.min(n, Integer.MAX_VALUE - getExtent());
//
//		        int newValue = Math.max(n, getMinimum());
//		        if (newValue + getExtent() > getMaximum()) {
//		            newValue = getMaximum() - getExtent(); 
//		        }
//		        
//				ourLog.info("Changing scrollbarval to {}", newValue);
//
//		        super.setRangeProperties(newValue, getExtent(), getMinimum(), getMaximum(), getValueIsAdjusting());
//		    }
//
//	}

}
