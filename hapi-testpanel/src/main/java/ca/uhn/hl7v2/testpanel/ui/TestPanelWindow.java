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
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.testpanel.controller.Controller;
import ca.uhn.hl7v2.testpanel.controller.Prefs;
import ca.uhn.hl7v2.testpanel.model.AbstractConnection;
import ca.uhn.hl7v2.testpanel.model.InboundConnection;
import ca.uhn.hl7v2.testpanel.model.InboundConnectionList;
import ca.uhn.hl7v2.testpanel.model.MessagesList;
import ca.uhn.hl7v2.testpanel.model.OutboundConnection;
import ca.uhn.hl7v2.testpanel.model.OutboundConnectionList;
import ca.uhn.hl7v2.testpanel.model.msg.Hl7V2MessageCollection;
import ca.uhn.hl7v2.testpanel.util.ScreenBoundsUtil;
import ca.uhn.hl7v2.testpanel.util.SwingLogAppender;

/**
 * This is the main outer window for the TestPanel
 */
public class TestPanelWindow implements IDestroyable {

	private Controller myController;
	private JFrame myframe;
	private JList myMessagesList;
	private MyMessagesListModel myMessagesListModel;
	private final PropertyChangeListener myMessageDescriptionListener;
	private MyOutboundConnectionsListModel myOutboundConnectionsListModel;
	private SwingLogAppender myLogAppender;
	private MyInboundConnectionsListModel myInboundConnectionsListModel;
	private JButton myMsgSaveButton;
	private PropertyChangeListener myOutboundConnectionsListListener;
	private PropertyChangeListener myInboundConnectionsListListener;
	private JButton myDeleteOutboundConnectionButton;
	private JButton myAddInboundConnectionButton;
	private PropertyChangeListener myPanelTitleListener;
	private AboutDialog myAboutDialog;
	private JButton myStartOneOutboundButton;
	private JButton myStartAllOutboundButton;
	private JButton myStopAllOutboundButton;

	/**
	 * Create the application.
	 */
	public TestPanelWindow(Controller theController) {
		myController = theController;

		myMessageDescriptionListener = new MyMessageDescriptionListener();
		myLogAppender = new SwingLogAppender();

		initialize();
		initializeLocal();
		initWindowPosition();

		if (myController.getLeftSelectedItem() instanceof Hl7V2MessageCollection) {
			myMessagesList.setSelectedValue(myController.getLeftSelectedItem(), true);
		} else if (myController.getLeftSelectedItem() instanceof InboundConnection) {
			myInboundConnectionsList.setSelectedValue(myController.getLeftSelectedItem(), true);
		} else if (myController.getLeftSelectedItem() instanceof OutboundConnection) {
			myOutboundConnectionsList.setSelectedValue(myController.getLeftSelectedItem(), true);
		} else {
			ourLog.warn("Unknown type is selected: {}", myController.getLeftSelectedItem());
		}

		myPanelTitleListener = new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent theEvt) {
				updateWindowTitle();
			}
		};


	}

	/**
	 * @return the controller
	 */
	public Controller getController() {
		return myController;
	}

	private void initWindowPosition() {
		if (Prefs.getWindowMaximized()) {
			myframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
			return;
		}
		
		Rectangle screenBounds = ScreenBoundsUtil.getScreenBounds(myframe);
		int maxWidth = screenBounds.width;
		int maxHeight = screenBounds.height;
		int width;
		int height;

		Point position = Prefs.getWindowPosition();
		Dimension dimension = Prefs.getWindowDimension();
		if (dimension.width > 600 && dimension.height > 500) {
			if (position.x >= 0 && position.y >= 0) {
				if (dimension.width + position.x < maxWidth) {
					if (dimension.height + position.y < maxHeight) {
						ourLog.info("Restoring window size to {} and location to {}", dimension, position);
						myframe.setLocation(position);
						myframe.setSize(dimension);
						return;
					}
				}
			}
		}
		
		width = (int) (maxWidth * 0.7);
		if (width < 1024) {
			width = maxWidth;
		}
		width = Math.min(width, 1600);

		height = (int) (maxHeight * 0.7);
		if (height < 600) {
			height = maxHeight;
		}
		height = Math.min(height, 1000);

		if (width == maxWidth && height == maxHeight) {
			ourLog.info("Maximizing window");
			myframe.setExtendedState(Frame.MAXIMIZED_BOTH);
		} else {
			ourLog.info("Setting window size to {} x {}", width, height);
			myframe.setSize(width, height);
		}

		myframe.setLocationByPlatform(true);
	}

	private void updateWindowTitle() {
		String title = myMainPanel != null ? myMainPanel.getWindowTitle() : null;
		if (StringUtils.isNotBlank(title)) {
			myframe.setTitle("HAPI TestPanel " + myController.getAppVersionString() + " - " + title);
		} else {
			myframe.setTitle("HAPI TestPanel " + myController.getAppVersionString());
		}
	}

	public void clearMessagesListSelection() {
		myMessagesList.clearSelection();
	}

	private void updateLeftToolbarButtons() {

		boolean isMsg = (myController.getLeftSelectedItem() instanceof Hl7V2MessageCollection);
		myMsgSaveButton.setEnabled(isMsg);
		myDeleteMessageButton.setEnabled(isMsg);
		mySaveMenuItem.setEnabled(isMsg);
		mySaveAsMenuItem.setEnabled(isMsg);

		if (myController.getLeftSelectedItem() instanceof OutboundConnection) {
			myDeleteOutboundConnectionButton.setEnabled(true);
			myStartOneOutboundButton.setEnabled(true);
		} else {
			myDeleteOutboundConnectionButton.setEnabled(false);
			myStartOneOutboundButton.setEnabled(false);
		}

		if (myController.getLeftSelectedItem() instanceof InboundConnection) {
			myDeleteInboundConnectionButton.setEnabled(true);
			myStartOneInboundButton.setEnabled(true);
		} else {
			myDeleteInboundConnectionButton.setEnabled(false);
			myStartOneInboundButton.setEnabled(false);
		}

	}
	
	private void updateLeftToolbarInboundStatusButtons() {
		boolean haveStarted = false;
		boolean haveStopped = false;
		for (InboundConnection next : myController.getInboundConnectionList().getConnections()) {
			switch (next.getStatus()) {
			case FAILED:
			case STOPPED:
				haveStopped = true;
				break;
			case STARTED:
			case TRYING_TO_START:
				haveStarted = true;
				break;
								
			}
		}
		
		myStopAllInboundButton.setEnabled(haveStarted);
		myStartAllInboundButton.setEnabled(haveStopped);
	}

	private void updateLeftToolbarOutboundStatusButtons() {
		boolean haveStarted = false;
		boolean haveStopped = false;
		for (OutboundConnection next : myController.getOutboundConnectionList().getConnections()) {
			switch (next.getStatus()) {
			case FAILED:
			case STOPPED:
				haveStopped = true;
				break;
			case STARTED:
			case TRYING_TO_START:
				haveStarted = true;
				break;
								
			}
		}
		
		myStopAllOutboundButton.setEnabled(haveStarted);
		myStartAllOutboundButton.setEnabled(haveStopped);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		myframe = new JFrame();
		myframe.setVisible(false);
		
		List<Image> l = new ArrayList<Image>();
		l.add(Toolkit.getDefaultToolkit().getImage(TestPanelWindow.class.getResource("/ca/uhn/hl7v2/testpanel/images/hapi_16.png")));
		l.add(Toolkit.getDefaultToolkit().getImage(TestPanelWindow.class.getResource("/ca/uhn/hl7v2/testpanel/images/hapi_64.png")));
		
		myframe.setIconImages(l);
		myframe.setTitle("HAPI TestPanel");
		myframe.setBounds(100, 100, 796, 603);
		myframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		myframe.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent theE) {
				myController.close();
			}
		});

		JMenuBar menuBar = new JMenuBar();
		myframe.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic('f');
		menuBar.add(mnFile);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myController.close();
			}
		});

		JMenuItem mntmNewMessage = new JMenuItem("New Message...");
		mntmNewMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myController.addMessage();
			}
		});
		mntmNewMessage.setIcon(new ImageIcon(TestPanelWindow.class.getResource("/ca/uhn/hl7v2/testpanel/images/message_hl7.png")));
		mnFile.add(mntmNewMessage);

		mySaveMenuItem = new JMenuItem("Save");
		mySaveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		mySaveMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doSaveMessages();
			}
		});
		mnFile.add(mySaveMenuItem);

		mySaveAsMenuItem = new JMenuItem("Save As...");
		mySaveAsMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doSaveMessagesAs();
			}
		});
		mnFile.add(mySaveAsMenuItem);
		
		mymenuItem_3 = new JMenuItem("Open");
		mymenuItem_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		mymenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myController.openMessages();
			}
		});
		mnFile.add(mymenuItem_3);
		
		myRecentFilesMenu = new JMenu("Open Recent");
		mnFile.add(myRecentFilesMenu);

		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		mnFile.add(mntmExit);

		JMenu mnNewMenu = new JMenu("View");
		mnNewMenu.setMnemonic('v');
		menuBar.add(mnNewMenu);

		myShowLogConsoleMenuItem = new JMenuItem("Show Log Console");
		myShowLogConsoleMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Prefs.setShowLogConsole(!Prefs.getShowLogConsole());
				updateLogScrollPaneVisibility();
				myframe.validate();
			}
		});
		mnNewMenu.add(myShowLogConsoleMenuItem);
		
		mymenu_1 = new JMenu("Test");
		menuBar.add(mymenu_1);
		
		mymenuItem_1 = new JMenuItem("Populate TestPanel with Sample Message and Connections...");
		mymenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myController.populateWithSampleMessageAndConnections();
			}
		});
		mymenu_1.add(mymenuItem_1);
		
		mymenu_2 = new JMenu("Conformance");
		menuBar.add(mymenu_2);
		
		mymenuItem_2 = new JMenuItem("Profiles and Tables…");
		mymenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myController.showProfilesAndTablesEditor();
			}
		});
		mymenu_2.add(mymenuItem_2);
		
		mymenu = new JMenu("Help");
		mymenu.setMnemonic('H');
		menuBar.add(mymenu);
		
		mymenuItem = new JMenuItem("About HAPI TestPanel...");
		mymenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showAboutDialog();
			}
		});
		mymenuItem.setIcon(new ImageIcon(TestPanelWindow.class.getResource("/ca/uhn/hl7v2/testpanel/images/hapi_16.png")));
		mymenu.add(mymenuItem);
		
		mymenuItem_4 = new JMenuItem("Licenses...");
		mymenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LicensesDialog().setVisible(true);
			}
		});
		mymenu.add(mymenuItem_4);
		myframe.getContentPane().setLayout(new BorderLayout(0, 0));

		JSplitPane outerSplitPane = new JSplitPane();
		outerSplitPane.setBorder(null);
		myframe.getContentPane().add(outerSplitPane);

		JSplitPane leftSplitPane = new JSplitPane();
		leftSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		outerSplitPane.setLeftComponent(leftSplitPane);

		JPanel messagesPanel = new JPanel();
		leftSplitPane.setLeftComponent(messagesPanel);
		GridBagLayout gbl_messagesPanel = new GridBagLayout();
		gbl_messagesPanel.columnWidths = new int[] { 110, 0 };
		gbl_messagesPanel.rowHeights = new int[] { 20, 30, 118, 0, 0 };
		gbl_messagesPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_messagesPanel.rowWeights = new double[] { 0.0, 0.0, 100.0, 1.0, Double.MIN_VALUE };
		messagesPanel.setLayout(gbl_messagesPanel);

		JLabel lblMessages = new JLabel("Messages");
		GridBagConstraints gbc_lblMessages = new GridBagConstraints();
		gbc_lblMessages.insets = new Insets(0, 0, 5, 0);
		gbc_lblMessages.gridx = 0;
		gbc_lblMessages.gridy = 0;
		messagesPanel.add(lblMessages, gbc_lblMessages);

		JToolBar messagesToolBar = new JToolBar();
		messagesToolBar.setFloatable(false);
		messagesToolBar.setRollover(true);
		messagesToolBar.setAlignmentX(Component.LEFT_ALIGNMENT);
		GridBagConstraints gbc_messagesToolBar = new GridBagConstraints();
		gbc_messagesToolBar.insets = new Insets(0, 0, 5, 0);
		gbc_messagesToolBar.weightx = 1.0;
		gbc_messagesToolBar.anchor = GridBagConstraints.NORTHWEST;
		gbc_messagesToolBar.gridx = 0;
		gbc_messagesToolBar.gridy = 1;
		messagesPanel.add(messagesToolBar, gbc_messagesToolBar);

		JButton msgOpenButton = new JButton("");
		msgOpenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myController.openMessages();
			}
		});

		myAddMessageButton = new JButton("");
		myAddMessageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myController.addMessage();
			}
		});
		myAddMessageButton.setIcon(new ImageIcon(TestPanelWindow.class.getResource("/ca/uhn/hl7v2/testpanel/images/add.png")));
		myAddMessageButton.setToolTipText("New Message");
		myAddMessageButton.setBorderPainted(false);
		myAddMessageButton.addMouseListener(new HoverButtonMouseAdapter(myAddMessageButton));
		messagesToolBar.add(myAddMessageButton);

		myDeleteMessageButton = new JButton("");
		myDeleteMessageButton.setToolTipText("Close Selected Message");
		myDeleteMessageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myController.closeMessage((Hl7V2MessageCollection) myController.getLeftSelectedItem());
			}
		});
		myDeleteMessageButton.setBorderPainted(false);
		myDeleteMessageButton.addMouseListener(new HoverButtonMouseAdapter(myDeleteMessageButton));
		myDeleteMessageButton.setIcon(new ImageIcon(TestPanelWindow.class.getResource("/ca/uhn/hl7v2/testpanel/images/close.png")));
		messagesToolBar.add(myDeleteMessageButton);
		msgOpenButton.setBorderPainted(false);
		msgOpenButton.setToolTipText("Open Messages from File");
		msgOpenButton.setIcon(new ImageIcon(TestPanelWindow.class.getResource("/ca/uhn/hl7v2/testpanel/images/open.png")));
		msgOpenButton.addMouseListener(new HoverButtonMouseAdapter(msgOpenButton));
		messagesToolBar.add(msgOpenButton);

		myMsgSaveButton = new JButton("");
		myMsgSaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doSaveMessages();
			}
		});
		myMsgSaveButton.setBorderPainted(false);
		myMsgSaveButton.setToolTipText("Save Selected Messages to File");
		myMsgSaveButton.setIcon(new ImageIcon(TestPanelWindow.class.getResource("/ca/uhn/hl7v2/testpanel/images/save.png")));
		myMsgSaveButton.addMouseListener(new HoverButtonMouseAdapter(myMsgSaveButton));
		messagesToolBar.add(myMsgSaveButton);

		myMessagesList = new JList();
		myMessagesList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (myMessagesList.getSelectedIndex() >= 0) {
					ourLog.debug("New messages selection " + myMessagesList.getSelectedIndex());
					myController.setLeftSelectedItem(myMessagesList.getSelectedValue());
					myOutboundConnectionsList.clearSelection();
					myOutboundConnectionsList.repaint();
					myInboundConnectionsList.clearSelection();
					myInboundConnectionsList.repaint();
				}
				updateLeftToolbarButtons();
			}
		});
		GridBagConstraints gbc_MessagesList = new GridBagConstraints();
		gbc_MessagesList.gridheight = 2;
		gbc_MessagesList.weightx = 1.0;
		gbc_MessagesList.weighty = 1.0;
		gbc_MessagesList.fill = GridBagConstraints.BOTH;
		gbc_MessagesList.gridx = 0;
		gbc_MessagesList.gridy = 2;
		messagesPanel.add(myMessagesList, gbc_MessagesList);

		JPanel connectionsPanel = new JPanel();
		leftSplitPane.setRightComponent(connectionsPanel);
		GridBagLayout gbl_connectionsPanel = new GridBagLayout();
		gbl_connectionsPanel.columnWidths = new int[] { 194, 0 };
		gbl_connectionsPanel.rowHeights = new int[] { 0, 30, 0, 0, 0, 0, 0 };
		gbl_connectionsPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_connectionsPanel.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		connectionsPanel.setLayout(gbl_connectionsPanel);

		JLabel lblConnections = new JLabel("Sending Connections");
		lblConnections.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblConnections = new GridBagConstraints();
		gbc_lblConnections.insets = new Insets(0, 0, 5, 0);
		gbc_lblConnections.anchor = GridBagConstraints.NORTH;
		gbc_lblConnections.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblConnections.gridx = 0;
		gbc_lblConnections.gridy = 0;
		connectionsPanel.add(lblConnections, gbc_lblConnections);

		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.insets = new Insets(0, 0, 5, 0);
		gbc_toolBar.anchor = GridBagConstraints.NORTH;
		gbc_toolBar.fill = GridBagConstraints.HORIZONTAL;
		gbc_toolBar.gridx = 0;
		gbc_toolBar.gridy = 1;
		connectionsPanel.add(toolBar, gbc_toolBar);

		myAddConnectionButton = new JButton("");
		myAddConnectionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myController.addOutboundConnection();
			}
		});
		myAddConnectionButton.setBorderPainted(false);
		myAddConnectionButton.addMouseListener(new HoverButtonMouseAdapter(myAddConnectionButton));
		myAddConnectionButton.setBorder(null);
		myAddConnectionButton.setToolTipText("New Connection");
		myAddConnectionButton.setIcon(new ImageIcon(TestPanelWindow.class.getResource("/ca/uhn/hl7v2/testpanel/images/add.png")));
		toolBar.add(myAddConnectionButton);

		myDeleteOutboundConnectionButton = new JButton("");
		myDeleteOutboundConnectionButton.setToolTipText("Delete Selected Connection");
		myDeleteOutboundConnectionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (myController.getLeftSelectedItem() instanceof OutboundConnection) {
					myController.removeOutboundConnection((OutboundConnection) myController.getLeftSelectedItem());
				}
			}
		});
		myDeleteOutboundConnectionButton.setBorderPainted(false);
		myDeleteOutboundConnectionButton.addMouseListener(new HoverButtonMouseAdapter(myDeleteOutboundConnectionButton));
		myDeleteOutboundConnectionButton.setIcon(new ImageIcon(TestPanelWindow.class.getResource("/ca/uhn/hl7v2/testpanel/images/delete.png")));
		toolBar.add(myDeleteOutboundConnectionButton);

		myStartOneOutboundButton = new JButton("");
		myStartOneOutboundButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (myController.getLeftSelectedItem() instanceof OutboundConnection) {
					myController.startOutboundConnection((OutboundConnection) myController.getLeftSelectedItem());
				}
			}
		});
		myStartOneOutboundButton.setBorderPainted(false);
		myStartOneOutboundButton.setToolTipText("Start selected connection");
		myStartOneOutboundButton.setIcon(new ImageIcon(TestPanelWindow.class.getResource("/ca/uhn/hl7v2/testpanel/images/start_one.png")));
		myStartOneOutboundButton.addMouseListener(new HoverButtonMouseAdapter(myStartOneOutboundButton));
		toolBar.add(myStartOneOutboundButton);
		
		myStartAllOutboundButton = new JButton("");
		myStartAllOutboundButton.setBorderPainted(false);
		myStartAllOutboundButton.setToolTipText("Start all sending connections");
		myStartAllOutboundButton.setIcon(new ImageIcon(TestPanelWindow.class.getResource("/ca/uhn/hl7v2/testpanel/images/start_all.png")));
		myStartAllOutboundButton.addMouseListener(new HoverButtonMouseAdapter(myStartAllOutboundButton));
		myStartAllOutboundButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent theE) {
				myController.startAllOutboundConnections();
			}
		});
		toolBar.add(myStartAllOutboundButton);
		
		myStopAllOutboundButton = new JButton("");
		myStopAllOutboundButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myController.stopAllOutboundConnections();
			}
		});
		myStopAllOutboundButton.setIcon(new ImageIcon(TestPanelWindow.class.getResource("/ca/uhn/hl7v2/testpanel/images/stop_all.png")));
		myStopAllOutboundButton.setToolTipText("Stop all sending connections");
		myStopAllOutboundButton.setBorderPainted(false);
		myStopAllOutboundButton.addMouseListener(new HoverButtonMouseAdapter(myStopAllOutboundButton));
		toolBar.add(myStopAllOutboundButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		connectionsPanel.add(scrollPane, gbc_scrollPane);

		myOutboundConnectionsList = new JList();
		myOutboundConnectionsList.setBorder(null);
		myOutboundConnectionsList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (myOutboundConnectionsList.getSelectedIndex() >= 0) {
					ourLog.debug("New outbound connection selection " + myOutboundConnectionsList.getSelectedIndex());
					myController.setLeftSelectedItem(myOutboundConnectionsList.getSelectedValue());
					myMessagesList.clearSelection();
					myMessagesList.repaint();
					myInboundConnectionsList.clearSelection();
					myInboundConnectionsList.repaint();
				}
				updateLeftToolbarButtons();
			}
		});
		scrollPane.setViewportView(myOutboundConnectionsList);

		JLabel lblReceivingConnections = new JLabel("Receiving Connections");
		lblReceivingConnections.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblReceivingConnections = new GridBagConstraints();
		gbc_lblReceivingConnections.insets = new Insets(0, 0, 5, 0);
		gbc_lblReceivingConnections.gridx = 0;
		gbc_lblReceivingConnections.gridy = 3;
		connectionsPanel.add(lblReceivingConnections, gbc_lblReceivingConnections);

		JToolBar toolBar_1 = new JToolBar();
		toolBar_1.setFloatable(false);
		GridBagConstraints gbc_toolBar_1 = new GridBagConstraints();
		gbc_toolBar_1.anchor = GridBagConstraints.WEST;
		gbc_toolBar_1.insets = new Insets(0, 0, 5, 0);
		gbc_toolBar_1.gridx = 0;
		gbc_toolBar_1.gridy = 4;
		connectionsPanel.add(toolBar_1, gbc_toolBar_1);

		myAddInboundConnectionButton = new JButton("");
		myAddInboundConnectionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myController.addInboundConnection();
			}
		});
		myAddInboundConnectionButton.setIcon(new ImageIcon(TestPanelWindow.class.getResource("/ca/uhn/hl7v2/testpanel/images/add.png")));
		myAddInboundConnectionButton.setToolTipText("New Connection");
		myAddInboundConnectionButton.setBorderPainted(false);
		myAddInboundConnectionButton.addMouseListener(new HoverButtonMouseAdapter(myAddInboundConnectionButton));
		toolBar_1.add(myAddInboundConnectionButton);

		myDeleteInboundConnectionButton = new JButton("");
		myDeleteInboundConnectionButton.setToolTipText("Delete Selected Connection");
		myDeleteInboundConnectionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (myController.getLeftSelectedItem() instanceof InboundConnection) {
					myController.removeInboundConnection((InboundConnection) myController.getLeftSelectedItem());
				}
			}
		});
		myDeleteInboundConnectionButton.setBorderPainted(false);
		myDeleteInboundConnectionButton.addMouseListener(new HoverButtonMouseAdapter(myDeleteInboundConnectionButton));
		myDeleteInboundConnectionButton.setIcon(new ImageIcon(TestPanelWindow.class.getResource("/ca/uhn/hl7v2/testpanel/images/delete.png")));
		toolBar_1.add(myDeleteInboundConnectionButton);
		
		myStartOneInboundButton = new JButton("");
		myStartOneInboundButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (myController.getLeftSelectedItem() instanceof InboundConnection) {
					myController.startInboundConnection((InboundConnection) myController.getLeftSelectedItem());
				}
			}
		});
		myStartOneInboundButton.setBorderPainted(false);
		myStartOneInboundButton.setToolTipText("Start selected connection");
		myStartOneInboundButton.setIcon(new ImageIcon(TestPanelWindow.class.getResource("/ca/uhn/hl7v2/testpanel/images/start_one.png")));
		myStartOneInboundButton.addMouseListener(new HoverButtonMouseAdapter(myStartOneInboundButton));
		toolBar_1.add(myStartOneInboundButton);
		
		myStartAllInboundButton = new JButton("");
		myStartAllInboundButton.setBorderPainted(false);
		myStartAllInboundButton.setToolTipText("Start all receiving connections");
		myStartAllInboundButton.setIcon(new ImageIcon(TestPanelWindow.class.getResource("/ca/uhn/hl7v2/testpanel/images/start_all.png")));
		myStartAllInboundButton.addMouseListener(new HoverButtonMouseAdapter(myStartAllInboundButton));
		myStartAllInboundButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent theE) {
				myController.startAllInboundConnections();
			}
		});
		toolBar_1.add(myStartAllInboundButton);
		
		myStopAllInboundButton = new JButton("");
		myStopAllInboundButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myController.stopAllInboundConnections();
			}
		});
		myStopAllInboundButton.setIcon(new ImageIcon(TestPanelWindow.class.getResource("/ca/uhn/hl7v2/testpanel/images/stop_all.png")));
		myStopAllInboundButton.setToolTipText("Stop all receiving connections");
		myStopAllInboundButton.setBorderPainted(false);
		myStopAllInboundButton.addMouseListener(new HoverButtonMouseAdapter(myStopAllInboundButton));
		toolBar_1.add(myStopAllInboundButton);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(null);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 5;
		connectionsPanel.add(scrollPane_1, gbc_scrollPane_1);

		myInboundConnectionsList = new JList();
		myInboundConnectionsList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (myInboundConnectionsList.getSelectedIndex() >= 0) {
					ourLog.debug("New inbound connection selection " + myInboundConnectionsList.getSelectedIndex());
					myController.setLeftSelectedItem(myInboundConnectionsList.getSelectedValue());
					myMessagesList.clearSelection();
					myMessagesList.repaint();
					myOutboundConnectionsList.clearSelection();
					myOutboundConnectionsList.repaint();
					myInboundConnectionsList.repaint();
				}
				updateLeftToolbarButtons();
			}
		});
		scrollPane_1.setViewportView(myInboundConnectionsList);
		leftSplitPane.setDividerLocation(200);

		myWorkspacePanel = new JPanel();
		myWorkspacePanel.setBorder(null);
		outerSplitPane.setRightComponent(myWorkspacePanel);
		myWorkspacePanel.setLayout(new BorderLayout(0, 0));
		outerSplitPane.setDividerLocation(200);

		myLogScrollPane = new LogTable();
		myLogScrollPane.setPreferredSize(new Dimension(454, 120));
		myLogScrollPane.setMaximumSize(new Dimension(32767, 120));
		myframe.getContentPane().add(myLogScrollPane, BorderLayout.SOUTH);

		updateLogScrollPaneVisibility();

		updateLeftToolbarButtons();
	}

	private void updateLogScrollPaneVisibility() {
		if (Prefs.getShowLogConsole()) {
			myShowLogConsoleMenuItem.setSelected(true);
			myLogScrollPane.setVisible(true);
			myShowLogConsoleMenuItem.setIcon(new ImageIcon(TestPanelWindow.class.getResource("/ca/uhn/hl7v2/testpanel/images/menu_selected.png")));
		} else {
			myShowLogConsoleMenuItem.setSelected(false);
			myLogScrollPane.setVisible(false);
			myShowLogConsoleMenuItem.setIcon(null);
		}

	}

	/**
	 * @return the myframe
	 */
	public JFrame getMyframe() {
		return myframe;
	}

	private void initializeLocal() {
		myMessagesListModel = new MyMessagesListModel();
		myMessagesList.setModel(myMessagesListModel);
		myMessagesList.setCellRenderer(new MyMessagesListCellRencerer());
		myController.getMessagesList().addPropertyChangeListener(MessagesList.PROP_LIST, myMessagesListModel);
		updateMessagesList();

		myOutboundConnectionsListModel = new MyOutboundConnectionsListModel();
		myOutboundConnectionsList.setModel(myOutboundConnectionsListModel);
		myOutboundConnectionsList.setCellRenderer(new MyOutboundConnectionsListCellRenderer());
		updateOutboundConnectionsList();

		myOutboundConnectionsListListener = new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent theEvt) {
				updateOutboundConnectionsList();
			}
		};
		myController.getOutboundConnectionList().addPropertyChangeListener(OutboundConnectionList.PROP_LIST, myOutboundConnectionsListListener);

		myInboundConnectionsListModel = new MyInboundConnectionsListModel();
		myInboundConnectionsList.setModel(myInboundConnectionsListModel);
		myInboundConnectionsList.setCellRenderer(new MyInboundConnectionsListCellRenderer());
		updateInboundConnectionsList();

		myInboundConnectionsListListener = new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent theEvt) {
				updateInboundConnectionsList();
			}
		};
		myController.getInboundConnectionList().addPropertyChangeListener(InboundConnectionList.PROP_LIST, myInboundConnectionsListListener);

		updateLeftToolbarInboundStatusButtons();
		updateLeftToolbarOutboundStatusButtons();
	}

	public void updateOutboundConnectionsList() {

		int index = 0;
		myOutboundConnectionsList.clearSelection();
		for (OutboundConnection next : myController.getOutboundConnectionList().getConnections()) {

			if (myOutboundConnectionsListModel.size() <= index) {

				myOutboundConnectionsListModel.addElement(next);
				next.addPropertyChangeListener(OutboundConnection.NAME_PROPERTY, new MyOutboundConnectionDescriptionListener(next));
				next.addPropertyChangeListener(OutboundConnection.STATUS_PROPERTY, new MyOutboundConnectionDescriptionListener(next));
				next.addPropertyChangeListener(OutboundConnection.PERSISTENT_PROPERTY, new MyOutboundConnectionDescriptionListener(next));

			} else if (myOutboundConnectionsListModel.getElementAt(index) != next) {

				myOutboundConnectionsListModel.add(index, next);
				next.addPropertyChangeListener(OutboundConnection.NAME_PROPERTY, new MyOutboundConnectionDescriptionListener(next));
				next.addPropertyChangeListener(OutboundConnection.STATUS_PROPERTY, new MyOutboundConnectionDescriptionListener(next));
				next.addPropertyChangeListener(OutboundConnection.PERSISTENT_PROPERTY, new MyOutboundConnectionDescriptionListener(next));

			}

			if (next == myController.getLeftSelectedItem()) {
				myOutboundConnectionsList.setSelectedIndex(index);
			}

			index++;
		}

		while (myOutboundConnectionsListModel.size() > index) {
			OutboundConnection obj = (OutboundConnection) myOutboundConnectionsListModel.remove(index);
			obj.destroy();
			obj.removePropertyChangeListener(Hl7V2MessageCollection.PROP_DESCRIPTION, myMessageDescriptionListener);
		}

	}

	/**
	 * Save the currently selected message
	 */
	private void doSaveMessages() {
		ourLog.info("Selected index: {}", myMessagesList.getSelectedIndex());
		myController.saveMessages((Hl7V2MessageCollection) myController.getLeftSelectedItem());
	}

	private void doSaveMessagesAs() {
		ourLog.info("Selected index: {}", myMessagesList.getSelectedIndex());
		myController.saveMessagesAs((Hl7V2MessageCollection) myController.getLeftSelectedItem());
	}
	
	public void updateInboundConnectionsList() {

		int index = 0;
		myInboundConnectionsList.clearSelection();
		for (InboundConnection next : myController.getInboundConnectionList().getConnections()) {

			if (myInboundConnectionsListModel.size() <= index) {

				myInboundConnectionsListModel.addElement(next);
				next.addPropertyChangeListener(InboundConnection.NAME_PROPERTY, new MyInboundConnectionDescriptionListener(next));
				next.addPropertyChangeListener(InboundConnection.STATUS_PROPERTY, new MyInboundConnectionDescriptionListener(next));

			} else if (myInboundConnectionsListModel.getElementAt(index) != next) {

				myInboundConnectionsListModel.add(index, next);
				next.addPropertyChangeListener(InboundConnection.NAME_PROPERTY, new MyInboundConnectionDescriptionListener(next));
				next.addPropertyChangeListener(InboundConnection.STATUS_PROPERTY, new MyInboundConnectionDescriptionListener(next));

			}

			if (next == myController.getLeftSelectedItem()) {
				myInboundConnectionsList.setSelectedIndex(index);
			}

			index++;
		}

		while (myInboundConnectionsListModel.size() > index) {
			InboundConnection obj = (InboundConnection) myInboundConnectionsListModel.remove(index);
			obj.destroy();
			obj.removePropertyChangeListener(Hl7V2MessageCollection.PROP_DESCRIPTION, myMessageDescriptionListener);
		}

	}

	private class MyInboundConnectionDescriptionListener implements PropertyChangeListener {

		private AbstractConnection myConnection;

		public MyInboundConnectionDescriptionListener(AbstractConnection theConnection) {
			myConnection = theConnection;
		}

		public void propertyChange(PropertyChangeEvent theEvt) {
			int rowIndex = myInboundConnectionsListModel.indexOf(myConnection);
			myInboundConnectionsListModel.fireChangeAtRow(rowIndex);
			
			if (theEvt.getPropertyName() == InboundConnection.STATUS_PROPERTY) {
				updateLeftToolbarInboundStatusButtons();
			}
		}

		
	}


	private class MyOutboundConnectionDescriptionListener implements PropertyChangeListener {

		private AbstractConnection myConnection;

		public MyOutboundConnectionDescriptionListener(AbstractConnection theConnection) {
			myConnection = theConnection;
		}

		public void propertyChange(PropertyChangeEvent theEvt) {
			int rowIndex = myOutboundConnectionsListModel.indexOf(myConnection);
			myOutboundConnectionsListModel.fireChangeAtRow(rowIndex);
			
			if (theEvt.getPropertyName() == InboundConnection.STATUS_PROPERTY) {
				updateLeftToolbarOutboundStatusButtons();
			}
		}

	}

	public void updateMessagesList() {

		int index = 0;
		myMessagesList.clearSelection();
		for (Hl7V2MessageCollection next : myController.getMessagesList().getMessages()) {

			if (myMessagesListModel.size() <= index) {
				myMessagesListModel.addElement(next);
				next.addPropertyChangeListener(Hl7V2MessageCollection.PROP_DESCRIPTION, myMessageDescriptionListener);
				next.addPropertyChangeListener(Hl7V2MessageCollection.SAVED_PROPERTY, myMessageDescriptionListener);
			} else if (myMessagesListModel.getElementAt(index) != next) {
				myMessagesListModel.add(index, next);
				next.addPropertyChangeListener(Hl7V2MessageCollection.PROP_DESCRIPTION, myMessageDescriptionListener);
				next.addPropertyChangeListener(Hl7V2MessageCollection.SAVED_PROPERTY, myMessageDescriptionListener);
			}

			if (next == myController.getLeftSelectedItem()) {
				myMessagesList.setSelectedIndex(index);
			}

			index++;
		}

		while (myMessagesListModel.size() > index) {
			Hl7V2MessageCollection obj = (Hl7V2MessageCollection) myMessagesListModel.remove(index);
			obj.removePropertyChangeListener(Hl7V2MessageCollection.PROP_DESCRIPTION, myMessageDescriptionListener);
			obj.removePropertyChangeListener(Hl7V2MessageCollection.SAVED_PROPERTY, myMessageDescriptionListener);
		}
	}

	private static final Logger ourLog = LoggerFactory.getLogger(TestPanelWindow.class);
	private static final Color BG_SELECTED = new Color(0.8f, 0.8f, 1.0f);
	private static final Color BG_NOT_SELECTED = Color.white;
	private JPanel myWorkspacePanel;
	private JButton myAddConnectionButton;
	private JList myOutboundConnectionsList;
	private JList myInboundConnectionsList;
	private JScrollPane myLogScrollPane;
	private BaseMainPanel myMainPanel;
	private JButton myAddMessageButton;
	private JButton myDeleteMessageButton;
	private JButton myDeleteInboundConnectionButton;
	private JMenuItem myShowLogConsoleMenuItem;
	private JMenuItem mySaveMenuItem;
	private JMenuItem mySaveAsMenuItem;
	private JButton myStartAllInboundButton;
	private JButton myStartOneInboundButton;
	private JButton myStopAllInboundButton;
	private JMenu mymenu;
	private JMenuItem mymenuItem;
	private JMenu mymenu_1;
	private JMenuItem mymenuItem_1;
	private JMenu mymenu_2;
	private JMenuItem mymenuItem_2;
	private JMenu myRecentFilesMenu;
	private JMenuItem mymenuItem_3;
	private JMenuItem mymenuItem_4;

	private final class MyMessageDescriptionListener implements PropertyChangeListener {
		public void propertyChange(PropertyChangeEvent theEvt) {
			Hl7V2MessageCollection source = (Hl7V2MessageCollection) theEvt.getSource();
			for (int i = 0; i < myMessagesListModel.getSize(); i++) {
				if (myMessagesListModel.elementAt(i) == source) {
					myMessagesListModel.fireChangeAtRow(i);
				}
			}
		}
	}

	private class MyMessagesListCellRencerer extends DefaultListCellRenderer {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * javax.swing.DefaultListCellRenderer#getListCellRendererComponent(
		 * javax.swing.JList, java.lang.Object, int, boolean, boolean)
		 */
		@Override
		public Component getListCellRendererComponent(JList theList, Object theValue, int theIndex, boolean theIsSelected, boolean theCellHasFocus) {
			if (theValue instanceof Hl7V2MessageCollection) {
				setIcon(ImageFactory.getMessageHl7());

				Hl7V2MessageCollection collection = (Hl7V2MessageCollection) theValue;
				String description = collection.getMessageDescription();
				if (collection.isSaved()) {
					setText(description);
				} else {
					setText("<html><nobr><font color=\"red\" size=\"2\">unsaved</font> " + description + "</nobr></html>");
				}

				if (theValue == myController.getLeftSelectedItem()) {
					setBackground(BG_SELECTED);
				} else {
					setBackground(BG_NOT_SELECTED);
				}

			} else {
				ourLog.error("Unknown message element type: " + theValue.getClass().getName());
			}
			return this;
		}

	}

	private class MyOutboundConnectionsListCellRenderer extends DefaultListCellRenderer {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * javax.swing.DefaultListCellRenderer#getListCellRendererComponent(
		 * javax.swing.JList, java.lang.Object, int, boolean, boolean)
		 */
		@Override
		public Component getListCellRendererComponent(JList theList, Object theValue, int theIndex, boolean theIsSelected, boolean theCellHasFocus) {
			OutboundConnection obj = (OutboundConnection) theValue;
			switch (obj.getStatus()) {
			case STARTED:
				setIcon(ImageFactory.getInterfaceOn());
				break;
			case STOPPED:
			case FAILED:
				setIcon(ImageFactory.getInterfaceOff());
				break;
			case TRYING_TO_START:
			default:
				setIcon(ImageFactory.getInterfaceStarting());
				break;
			}

			if (obj.isPersistent()) {
				setText(obj.getName());
			} else {
				setText("<html><nobr><font color=\"red\" size=\"2\">temp</font> " + obj.getName() + "</nobr></html>");
			}


			if (theValue == myController.getLeftSelectedItem()) {
				setBackground(BG_SELECTED);
			} else {
				setBackground(BG_NOT_SELECTED);
			}

			return this;
		}

	}

	private class MyInboundConnectionsListCellRenderer extends DefaultListCellRenderer {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * javax.swing.DefaultListCellRenderer#getListCellRendererComponent(
		 * javax.swing.JList, java.lang.Object, int, boolean, boolean)
		 */
		@Override
		public Component getListCellRendererComponent(JList theList, Object theValue, int theIndex, boolean theIsSelected, boolean theCellHasFocus) {
			InboundConnection obj = (InboundConnection) theValue;
			switch (obj.getStatus()) {
			case STARTED:
				setIcon(ImageFactory.getInterfaceOn());
				break;
			case STOPPED:
			case FAILED:
				setIcon(ImageFactory.getInterfaceOff());
				break;
			case TRYING_TO_START:
			default:
				setIcon(ImageFactory.getInterfaceStarting());
				break;
			}

			if (obj.isPersistent()) {
				setText(obj.getName());
			} else {
				setText("<html><nobr><font color=\"red\" size=\"2\">temp</font> " + obj.getName() + "</nobr></html>");
			}

			if (theValue == myController.getLeftSelectedItem()) {
				setBackground(BG_SELECTED);
			} else {
				setBackground(BG_NOT_SELECTED);
			}

			return this;
		}

	}

	public void setMainPanel(BaseMainPanel theOutboundPanel) {
		Validate.notNull(theOutboundPanel);

		if (myMainPanel != null) {
			if (myMainPanel instanceof IDestroyable) {
				((IDestroyable) myMainPanel).destroy();
			}
			myMainPanel.removePropertyChangeListener(BaseMainPanel.PROP_WINDOWTITLE, myPanelTitleListener);
		}

		myMainPanel = theOutboundPanel;
		myMainPanel.addPropertyChangeListener(BaseMainPanel.PROP_WINDOWTITLE, myPanelTitleListener);

		myWorkspacePanel.removeAll();
		myWorkspacePanel.add(theOutboundPanel, BorderLayout.CENTER);
		myWorkspacePanel.validate();

		myMessagesList.repaint();
		myInboundConnectionsList.repaint();
		myOutboundConnectionsList.repaint();

		updateLeftToolbarButtons();
		updateWindowTitle();
	}

	private class MyMessagesListModel extends DefaultListModel implements PropertyChangeListener {

		public void fireChangeAtRow(int theI) {
			fireContentsChanged(this, theI, theI);
		}

		public void propertyChange(PropertyChangeEvent theEvt) {
			updateMessagesList();
		}

	}

	private class MyOutboundConnectionsListModel extends DefaultListModel {

		public void fireChangeAtRow(int theI) {
			fireContentsChanged(this, theI, theI);
		}

	}

	private class MyInboundConnectionsListModel extends DefaultListModel {

		public void fireChangeAtRow(int theI) {
			fireContentsChanged(this, theI, theI);
		}

	}

	public JFrame getFrame() {
		return myframe;
	}

	/**
	 * {@inheritDoc}
	 */
	public void destroy() {
		int extState = myframe.getExtendedState();
		switch (extState) {
		case JFrame.MAXIMIZED_BOTH:
			Prefs.setWindowMaximized(true);
			break;
		default:
			Point location = myframe.getLocation();
			Dimension size = myframe.getSize();
			ourLog.info("Saving window location of {} and size of {}", location, size);
			Prefs.setWindowPosition(location);
			Prefs.setWindowDimension(size);
			break;
		}
	}

	public void showAboutDialog() {
		if (myAboutDialog == null) {
			myAboutDialog = new AboutDialog();
		}
		myAboutDialog.setVisible(true);
	}

	public void setRecentMessageFiles(List<String> theRecentMessageFiles) {
		myRecentFilesMenu.removeAll();
		for (final String fileName : theRecentMessageFiles) {
			JMenuItem nextItem = new JMenuItem(fileName);
			myRecentFilesMenu.add(nextItem);
			nextItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent theE) {
					myController.openOrSwitchToMessage(fileName);
				}
			});
		}
	}

}
