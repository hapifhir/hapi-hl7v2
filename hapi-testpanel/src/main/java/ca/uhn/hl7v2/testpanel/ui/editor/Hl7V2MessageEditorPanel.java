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
package ca.uhn.hl7v2.testpanel.ui.editor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Highlighter;

import jsyntaxpane.DefaultSyntaxKit;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.mortbay.xml.XmlParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.Location;
import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.hl7v2.model.AbstractGroup;
import ca.uhn.hl7v2.model.AbstractPrimitive;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.AbstractStructure;
import ca.uhn.hl7v2.model.GenericMessage;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Structure;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.parser.DefaultXMLParser;
import ca.uhn.hl7v2.parser.GenericModelClassFactory;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.ParserConfiguration;
import ca.uhn.hl7v2.testpanel.controller.Controller;
import ca.uhn.hl7v2.testpanel.controller.Prefs;
import ca.uhn.hl7v2.testpanel.model.conf.ProfileFileList;
import ca.uhn.hl7v2.testpanel.model.conf.ProfileGroup;
import ca.uhn.hl7v2.testpanel.model.conn.OutboundConnection;
import ca.uhn.hl7v2.testpanel.model.conn.OutboundConnectionList;
import ca.uhn.hl7v2.testpanel.model.msg.Hl7V2MessageCollection;
import ca.uhn.hl7v2.testpanel.model.msg.Hl7V2MessageEr7;
import ca.uhn.hl7v2.testpanel.model.msg.Hl7V2MessageXml;
import ca.uhn.hl7v2.testpanel.ui.ActivityTable;
import ca.uhn.hl7v2.testpanel.ui.BaseMainPanel;
import ca.uhn.hl7v2.testpanel.ui.Er7SyntaxKit;
import ca.uhn.hl7v2.testpanel.ui.HoverButtonMouseAdapter;
import ca.uhn.hl7v2.testpanel.ui.IDestroyable;
import ca.uhn.hl7v2.testpanel.ui.ShowEnum;
import ca.uhn.hl7v2.testpanel.ui.v2tree.Hl7V2MessageTree;
import ca.uhn.hl7v2.testpanel.ui.v2tree.Hl7V2MessageTree.IWorkingListener;
import ca.uhn.hl7v2.testpanel.util.IOkCancelCallback;
import ca.uhn.hl7v2.testpanel.util.Range;
import ca.uhn.hl7v2.testpanel.xsd.Hl7V2EncodingTypeEnum;
import ca.uhn.hl7v2.validation.impl.DefaultValidation;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.AttributedString;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class Hl7V2MessageEditorPanel extends BaseMainPanel implements IDestroyable {
	private static final String CREATE_NEW_CONNECTION = "Create New Connection...";
	private static final String NO_CONNECTIONS = "No Connections";
	private static final Logger ourLog = LoggerFactory.getLogger(Hl7V2MessageEditorPanel.class);
	private SendOptionsPopupDialog mySendOptionsPopupDialog;

	static {

		System.setProperty("DefaultFont", "ARIAL-PLAIN-13");

		try {
			DefaultSyntaxKit.initKit();
			DefaultSyntaxKit.registerContentType("text/er7", Er7SyntaxKit.class.getName());
			ourLog.info("Registered syntaxKit");
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	private boolean myDontRespondToSourceMessageChanges;
	private Component myhorizontalStrut_4;
	private JPanel bottomPanel;
	private JPanel messageEditorContainerPanel;
	private JComboBox myShowCombo;
	private Controller myController;
	private boolean myDisableCaretUpdateHandling;
	private DocumentListener myDocumentListener;
	private JToggleButton myFollowToggle;
	private JLabel mylabel;
	private JLabel mylabel_1;
	private JLabel mylabel_2;
	private JLabel mylabel_3;
	private Hl7V2MessageCollection myMessage;
	private JEditorPane myMessageEditor;
	private PropertyChangeListener myMessageListeneer;
	private JScrollPane myMessageScrollPane;
	private PropertyChangeListener myOutboundConnectionsListener;
	private JComboBox myOutboundInterfaceCombo;
	private DefaultComboBoxModel myOutboundInterfaceComboModel;
	private JComboBox myProfileCombobox;
	private ProfileComboModel myProfileComboboxModel;
	private PropertyChangeListener myRangeListener;
	private JRadioButton myRdbtnEr7;
	private JRadioButton myRdbtnXml;
	private JRadioButton myRdbtnTableView;
	private PropertyChangeListener mySelectedPathListener;
	private JButton mySendButton;
	private JSplitPane mysplitPane;
	private JLabel myTerserPathTextField;
	private JToolBar mytoolBar;
	private Hl7V2MessageTree myTreePanel;
	private JScrollPane myTreeScrollPane;
	private JPanel treeContainerPanel;
	private JTabbedPane myTopTabBar;
	// private JPanel mySendingPanel;
	private ActivityTable mySendingActivityTable;
	private PropertyChangeListener myWindowTitleListener;
	private Component myhorizontalStrut;
	private Component myhorizontalStrut_1;
	private boolean myOutboundInterfaceComboModelIsUpdating;
	private ArrayList<OutboundConnection> myOutboundInterfaceComboModelShadow;
	private final JPopupMenu myTerserPathPopupMenu = new JPopupMenu();
	private boolean myHandlingProfileComboboxChange;
	private JLabel mylabel_4;
	private JToolBar mytoolBar_1;
	private TablesComboModel myTablesComboModel;
	private PropertyChangeListener myProfilesListener;
	private PropertyChangeListener myProfilesNamesListener;
	private JButton mySpinner;
	private Component myhorizontalGlue;
	private ImageIcon mySpinnerIconOn;
	private ImageIcon mySpinnerIconOff;
	private JButton collapseAllButton;
	private JButton expandAllButton;
	private Component myhorizontalStrut_2;
	private JButton mySendOptionsButton;

	/**
	 * Create the panel.
	 */
	public Hl7V2MessageEditorPanel(final Controller theController) {
		setBorder(null);
		myController = theController;

		ButtonGroup encGrp = new ButtonGroup();
		setLayout(new BorderLayout(0, 0));

		mysplitPane = new JSplitPane();
		mysplitPane.setResizeWeight(0.5);
		mysplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(mysplitPane);

		mysplitPane.addPropertyChangeListener(JSplitPane.DIVIDER_LOCATION_PROPERTY, new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent theEvt) {
				double ratio = (double) mysplitPane.getDividerLocation() / mysplitPane.getHeight();
				ourLog.debug("Resizing split to ratio: {}", ratio);
				Prefs.getInstance().setHl7EditorSplit(ratio);
			}
		});

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				mysplitPane.setDividerLocation(Prefs.getInstance().getHl7EditorSplit());
			}
		});

		messageEditorContainerPanel = new JPanel();
		messageEditorContainerPanel.setBorder(null);
		mysplitPane.setRightComponent(messageEditorContainerPanel);
		messageEditorContainerPanel.setLayout(new BorderLayout(0, 0));

		myMessageEditor = new JEditorPane();
		Highlighter h = new UnderlineHighlighter();
		myMessageEditor.setHighlighter(h);
		// myMessageEditor.setFont(Prefs.getHl7EditorFont());
		myMessageEditor.setSelectedTextColor(Color.black);

		myMessageEditor.setCaret(new EditorCaret());

		myMessageScrollPane = new JScrollPane(myMessageEditor);
		messageEditorContainerPanel.add(myMessageScrollPane);

		JToolBar toolBar = new JToolBar();
		messageEditorContainerPanel.add(toolBar, BorderLayout.NORTH);
		toolBar.setFloatable(false);
		toolBar.setRollover(true);

		myFollowToggle = new JToggleButton("Follow");
		myFollowToggle.setToolTipText("Keep the message tree (above) and the message editor (below) in sync");
		myFollowToggle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				theController.setMessageEditorInFollowMode(myFollowToggle.isSelected());
			}
		});
		myFollowToggle.setIcon(
				new ImageIcon(Hl7V2MessageEditorPanel.class.getResource("/ca/uhn/hl7v2/testpanel/images/updown.png")));
		myFollowToggle.setSelected(theController.isMessageEditorInFollowMode());
		toolBar.add(myFollowToggle);

		myhorizontalStrut = Box.createHorizontalStrut(20);
		toolBar.add(myhorizontalStrut);

		mylabel_4 = new JLabel("Encoding");
		toolBar.add(mylabel_4);

		myRdbtnEr7 = new JRadioButton("ER7");
		myRdbtnEr7.setMargin(new Insets(1, 2, 0, 1));
		toolBar.add(myRdbtnEr7);
		myRdbtnEr7.setSelected(true);

		myRdbtnXml = new JRadioButton("XML");
		myRdbtnXml.setMargin(new Insets(1, 5, 0, 1));
		toolBar.add(myRdbtnXml);

		myRdbtnTableView = new JRadioButton("View as Table");
		myRdbtnTableView.setMargin(new Insets(1, 5, 0, 1));
		toolBar.add(myRdbtnTableView);
		encGrp.add(myRdbtnEr7);
		encGrp.add(myRdbtnXml);
		encGrp.add(myRdbtnTableView);

		treeContainerPanel = new JPanel();
		mysplitPane.setLeftComponent(treeContainerPanel);
		treeContainerPanel.setLayout(new BorderLayout(0, 0));

		mySpinnerIconOn = new ImageIcon(
				Hl7V2MessageEditorPanel.class.getResource("/ca/uhn/hl7v2/testpanel/images/spinner.gif"));
		mySpinnerIconOff = new ImageIcon();

		myTreePanel = new Hl7V2MessageTree(theController);
		myTreePanel.setWorkingListener(new IWorkingListener() {

			public void startedWorking() {
				mySpinner.setText("");
				mySpinner.setIcon(mySpinnerIconOn);
				mySpinnerIconOn.setImageObserver(mySpinner);
			}

			public void finishedWorking(String theStatus) {
				mySpinner.setText(theStatus);

				mySpinner.setIcon(mySpinnerIconOff);
				mySpinnerIconOn.setImageObserver(null);
			}
		});
		myTreeScrollPane = new JScrollPane(myTreePanel);

		myTopTabBar = new JTabbedPane();
		treeContainerPanel.add(myTopTabBar);
		myTopTabBar.setBorder(null);

		JPanel treeContainer = new JPanel();
		treeContainer.setLayout(new BorderLayout(0, 0));
		treeContainer.add(myTreeScrollPane);

		myTopTabBar.add("Message Tree", treeContainer);

		mytoolBar_1 = new JToolBar();
		mytoolBar_1.setFloatable(false);
		treeContainer.add(mytoolBar_1, BorderLayout.NORTH);

		mylabel_3 = new JLabel("Show");
		mytoolBar_1.add(mylabel_3);

		myShowCombo = new JComboBox();
		mytoolBar_1.add(myShowCombo);
		myShowCombo.setPreferredSize(new Dimension(130, 27));
		myShowCombo.setMinimumSize(new Dimension(130, 27));
		myShowCombo.setMaximumSize(new Dimension(130, 32767));

		collapseAllButton = new JButton();
		collapseAllButton.setBorderPainted(false);
		collapseAllButton.addMouseListener(new HoverButtonMouseAdapter(collapseAllButton));
		collapseAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myTreePanel.collapseAll();
			}
		});
		collapseAllButton.setToolTipText("Collapse All");
		collapseAllButton.setIcon(new ImageIcon(
				Hl7V2MessageEditorPanel.class.getResource("/ca/uhn/hl7v2/testpanel/images/collapse_all.png")));
		mytoolBar_1.add(collapseAllButton);

		expandAllButton = new JButton();
		expandAllButton.setBorderPainted(false);
		expandAllButton.addMouseListener(new HoverButtonMouseAdapter(expandAllButton));
		expandAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myTreePanel.expandAll();
			}
		});
		expandAllButton.setToolTipText("Expand All");
		expandAllButton.setIcon(new ImageIcon(
				Hl7V2MessageEditorPanel.class.getResource("/ca/uhn/hl7v2/testpanel/images/expand_all.png")));
		mytoolBar_1.add(expandAllButton);

		myhorizontalGlue = Box.createHorizontalGlue();
		mytoolBar_1.add(myhorizontalGlue);

		mySpinner = new JButton("");
		mySpinner.setForeground(Color.DARK_GRAY);
		mySpinner.setHorizontalAlignment(SwingConstants.RIGHT);
		mySpinner.setMaximumSize(new Dimension(200, 15));
		mySpinner.setPreferredSize(new Dimension(200, 15));
		mySpinner.setMinimumSize(new Dimension(200, 15));
		mySpinner.setBorderPainted(false);
		mySpinner.setSize(new Dimension(16, 16));
		mytoolBar_1.add(mySpinner);
		myProfileComboboxModel = new ProfileComboModel();

		myTablesComboModel = new TablesComboModel(myController);

		mytoolBar = new JToolBar();
		mytoolBar.setFloatable(false);
		mytoolBar.setRollover(true);
		treeContainerPanel.add(mytoolBar, BorderLayout.NORTH);

		myOutboundInterfaceCombo = new JComboBox();
		myOutboundInterfaceComboModel = new DefaultComboBoxModel();

		mylabel_1 = new JLabel("Send");
		mytoolBar.add(mylabel_1);
		myOutboundInterfaceCombo.setModel(myOutboundInterfaceComboModel);
		myOutboundInterfaceCombo.setMaximumSize(new Dimension(200, 32767));
		mytoolBar.add(myOutboundInterfaceCombo);

		mySendButton = new JButton("Send");
		mySendButton.addMouseListener(new HoverButtonMouseAdapter(mySendButton));
		mySendButton.setBorderPainted(false);
		mySendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// int selectedIndex =
				// myOutboundInterfaceComboModel.getIndexOf(myOutboundInterfaceComboModel.getSelectedItem());
				int selectedIndex = myOutboundInterfaceCombo.getSelectedIndex();
				OutboundConnection connection = myController.getOutboundConnectionList().getConnections()
						.get(selectedIndex);
				activateSendingActivityTabForConnection(connection);
				myController.sendMessages(connection, myMessage, mySendingActivityTable.provideTransmissionCallback());
			}
		});

		myhorizontalStrut_2 = Box.createHorizontalStrut(20);
		myhorizontalStrut_2.setPreferredSize(new Dimension(2, 0));
		myhorizontalStrut_2.setMinimumSize(new Dimension(2, 0));
		myhorizontalStrut_2.setMaximumSize(new Dimension(2, 32767));
		mytoolBar.add(myhorizontalStrut_2);

		mySendOptionsButton = new JButton("Options");
		mySendOptionsButton.setBorderPainted(false);
		final HoverButtonMouseAdapter sendOptionsHoverAdaptor = new HoverButtonMouseAdapter(mySendOptionsButton);
		mySendOptionsButton.addMouseListener(sendOptionsHoverAdaptor);
		mySendOptionsButton.setIcon(new ImageIcon(
				Hl7V2MessageEditorPanel.class.getResource("/ca/uhn/hl7v2/testpanel/images/sendoptions.png")));
		mytoolBar.add(mySendOptionsButton);
		mySendOptionsButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent theE) {
				if (mySendOptionsPopupDialog != null) {
					mySendOptionsPopupDialog.doHide();
					mySendOptionsPopupDialog = null;
					return;
				}
				mySendOptionsPopupDialog = new SendOptionsPopupDialog(Hl7V2MessageEditorPanel.this, myMessage,
						mySendOptionsButton, sendOptionsHoverAdaptor);
				Point los = mySendOptionsButton.getLocationOnScreen();
				mySendOptionsPopupDialog.setLocation(los.x, los.y + mySendOptionsButton.getHeight());
				mySendOptionsPopupDialog.setVisible(true);
			}
		});

		mySendButton.setIcon(new ImageIcon(
				Hl7V2MessageEditorPanel.class.getResource("/ca/uhn/hl7v2/testpanel/images/button_execute.png")));
		mytoolBar.add(mySendButton);

		myhorizontalStrut_1 = Box.createHorizontalStrut(20);
		mytoolBar.add(myhorizontalStrut_1);

		mylabel_2 = new JLabel("Validate");
		mytoolBar.add(mylabel_2);

		myProfileCombobox = new JComboBox();
		mytoolBar.add(myProfileCombobox);
		myProfileCombobox.setPreferredSize(new Dimension(200, 27));
		myProfileCombobox.setMinimumSize(new Dimension(200, 27));
		myProfileCombobox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (myHandlingProfileComboboxChange) {
					return;
				}

				myHandlingProfileComboboxChange = true;
				try {
					if (myProfileCombobox.getSelectedIndex() == 0) {
						myMessage.setValidationContext(null);
					} else if (myProfileCombobox.getSelectedIndex() == 1) {
						myMessage.setValidationContext(new DefaultValidation());
					} else if (myProfileCombobox.getSelectedIndex() > 0) {
						ProfileGroup profile = myProfileComboboxModel.myProfileGroups
								.get(myProfileCombobox.getSelectedIndex());
						myMessage.setRuntimeProfile(profile);

						// } else if (myProfileCombobox.getSelectedItem() ==
						// ProfileComboModel.APPLY_CONFORMANCE_PROFILE) {
						// IOkCancelCallback<Void> callback = new
						// IOkCancelCallback<Void>() {
						// public void ok(Void theArg) {
						// myProfileComboboxModel.update();
						// }
						//
						// public void cancel(Void theArg) {
						// myProfileCombobox.setSelectedIndex(0);
						// }
						// };
						// myController.chooseAndLoadConformanceProfileForMessage(myMessage,
						// callback);
					}
				} catch (ProfileException e2) {
					ourLog.error("Failed to load profile", e2);
				} finally {
					myHandlingProfileComboboxChange = false;
				}
			}
		});
		myProfileCombobox.setMaximumSize(new Dimension(300, 32767));
		myProfileCombobox.setModel(myProfileComboboxModel);

		myhorizontalStrut_4 = Box.createHorizontalStrut(20);
		myhorizontalStrut_4.setPreferredSize(new Dimension(2, 0));
		myhorizontalStrut_4.setMinimumSize(new Dimension(2, 0));
		myhorizontalStrut_4.setMaximumSize(new Dimension(2, 32767));
		mytoolBar.add(myhorizontalStrut_4);

		// mySendingPanel = new JPanel();
		// mySendingPanel.setBorder(null);
		// myTopTabBar.addTab("Sending", null, mySendingPanel, null);
		// mySendingPanel.setLayout(new BorderLayout(0, 0));

		mySendingActivityTable = new ActivityTable();
		mySendingActivityTable.setController(myController);
		myTopTabBar.addTab("Sending", null, mySendingActivityTable, null);

		// mySendingPanelScrollPanel = new JScrollPane();
		// mySendingPanelScrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		// mySendingPanelScrollPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		// mySendingPanelScrollPanel.setColumnHeaderView(mySendingActivityTable);
		//
		// mySendingPanel.add(mySendingPanelScrollPanel, BorderLayout.CENTER);

		bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(10, 20));
		bottomPanel.setMinimumSize(new Dimension(10, 20));
		add(bottomPanel, BorderLayout.SOUTH);
		GridBagLayout gbl_bottomPanel = new GridBagLayout();
		gbl_bottomPanel.columnWidths = new int[] { 98, 74, 0 };
		gbl_bottomPanel.rowHeights = new int[] { 16, 0 };
		gbl_bottomPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_bottomPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		bottomPanel.setLayout(gbl_bottomPanel);

		mylabel = new JLabel("Terser Path:");
		mylabel.setHorizontalTextPosition(SwingConstants.LEFT);
		mylabel.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.VERTICAL;
		gbc_label.weighty = 1.0;
		gbc_label.anchor = GridBagConstraints.NORTHWEST;
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		bottomPanel.add(mylabel, gbc_label);

		myTerserPathTextField = new JLabel();
		myTerserPathTextField.setForeground(Color.BLUE);
		myTerserPathTextField.setFont(new Font("Lucida Console", Font.PLAIN, 13));
		myTerserPathTextField.setBorder(null);
		myTerserPathTextField.setBackground(SystemColor.control);
		myTerserPathTextField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (StringUtils.isNotEmpty(myTerserPathTextField.getText())) {
					myTerserPathPopupMenu.show(myTerserPathTextField, 0, 0);
				}
			}
		});

		GridBagConstraints gbc_TerserPathTextField = new GridBagConstraints();
		gbc_TerserPathTextField.weightx = 1.0;
		gbc_TerserPathTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_TerserPathTextField.gridx = 1;
		gbc_TerserPathTextField.gridy = 0;
		bottomPanel.add(myTerserPathTextField, gbc_TerserPathTextField);

		initLocal();

	}

	public void destroy() {
		myMessage.removePropertyChangeListener(Hl7V2MessageCollection.SOURCE_MESSAGE_PROPERTY, myMessageListeneer);
		myMessage.removePropertyChangeListener(Hl7V2MessageCollection.PROP_HIGHLITED_RANGE, myRangeListener);
		myMessage.removePropertyChangeListener(Hl7V2MessageCollection.SAVED_PROPERTY, myWindowTitleListener);
		myMessage.removePropertyChangeListener(Hl7V2MessageCollection.PROP_SAVE_FILENAME, myWindowTitleListener);

		myTreePanel.destroy();
		myController.getOutboundConnectionList().addPropertyChangeListener(OutboundConnectionList.PROP_LIST,
				myOutboundConnectionsListener);

		myTablesComboModel.destroy();
		unregisterProfileNamesListeners();
	}

	private void initLocal() {

		myDocumentListener = new DocumentListener() {

			public void changedUpdate(DocumentEvent theE) {
				ourLog.info("Document change: " + theE);
				handleChange(theE);
			}

			private void handleChange(DocumentEvent theE) {
				myDontRespondToSourceMessageChanges = true;
				try {
					long start = System.currentTimeMillis();

					String newSource = myMessageEditor.getText();
					int changeStart = theE.getOffset();
					int changeEnd = changeStart + theE.getLength();
					myMessage.updateSourceMessage(newSource, changeStart, changeEnd);

					ourLog.info("Handled document update in {} ms", System.currentTimeMillis() - start);
				} finally {
					myDontRespondToSourceMessageChanges = false;
				}
			}

			public void insertUpdate(DocumentEvent theE) {
				ourLog.info("Document insert: " + theE);
				handleChange(theE);
			}

			public void removeUpdate(DocumentEvent theE) {
				ourLog.info("Document removed: " + theE);
				handleChange(theE);
			}
		};
		myMessageEditor.getDocument().addDocumentListener(myDocumentListener);

		myMessageEditor.addCaretListener(new CaretListener() {

			public void caretUpdate(final CaretEvent theE) {
				removeMostHighlights();
				if (!myDisableCaretUpdateHandling) {
					myController.invokeInBackground(new Runnable() {
						public void run() {
							myMessage.setHighlitedPathBasedOnRange(new Range(theE.getDot(), theE.getMark()));
							myTreePanel.repaint();
						}
					});
				}
			}
		});

		updateOutboundConnectionsBox();
		myOutboundConnectionsListener = new PropertyChangeListener() {

			public void propertyChange(PropertyChangeEvent theEvt) {
				updateOutboundConnectionsBox();
			}
		};
		myController.getOutboundConnectionList().addPropertyChangeListener(OutboundConnectionList.PROP_LIST,
				myOutboundConnectionsListener);

		myOutboundInterfaceCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent theE) {
				if (!myOutboundInterfaceComboModelIsUpdating) {
					updateSendButton();
				}
			}

		});

		JMenuItem copyMenuItem = new JMenuItem("Copy to Clipboard");
		copyMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent theE) {
				String selection = myTerserPathTextField.getText();
				StringSelection data = new StringSelection(selection);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(data, data);
			}
		});
		myTerserPathPopupMenu.add(copyMenuItem);

		myProfilesListener = new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent theEvt) {
				myProfileComboboxModel.update();
				registerProfileNamesListeners();
			}
		};
		myController.getProfileFileList().addPropertyChangeListener(ProfileFileList.PROP_FILES, myProfilesListener);
		registerProfileNamesListeners();

		myProfilesNamesListener = new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent theEvt) {
				myProfileComboboxModel.update();
			}
		};

	}

	private void registerProfileNamesListeners() {
		unregisterProfileNamesListeners();
		for (ProfileGroup next : myController.getProfileFileList().getProfiles()) {
			next.addPropertyChangeListener(ProfileGroup.PROP_NAME, myProfilesNamesListener);
		}
	}

	private void unregisterProfileNamesListeners() {
		for (ProfileGroup next : myController.getProfileFileList().getProfiles()) {
			next.removePropertyChangeListener(ProfileGroup.PROP_NAME, myProfilesNamesListener);
		}
	}

	private void updateSendButton() {
		String selected = (String) myOutboundInterfaceCombo.getSelectedItem();
		if (selected == null || selected == NO_CONNECTIONS) {
			mySendButton.setEnabled(false);
			if (myMessage != null) {
				myMessage.setLastSendToInterfaceId(null);
			}
			return;
		}

		if (selected == CREATE_NEW_CONNECTION) {
			IOkCancelCallback<OutboundConnection> handler = new IOkCancelCallback<OutboundConnection>() {
				public void ok(OutboundConnection theArg) {
					myMessage.setLastSendToInterfaceId(theArg.getId());
					myOutboundInterfaceCombo.setSelectedIndex(myOutboundInterfaceComboModel.getSize() - 2);
				}

				public void cancel(OutboundConnection theArg) {
					myOutboundInterfaceCombo.setSelectedIndex(0);
				}
			};
			myController.addOutboundConnectionToSendTo(handler);
			return;
		}

		if (myMessage != null) {
			int selectedIndex = myOutboundInterfaceCombo.getSelectedIndex();
			OutboundConnection connection = myController.getOutboundConnectionList().getConnections()
					.get(selectedIndex);
			myMessage.setLastSendToInterfaceId(connection.getId());
		}

		mySendButton.setEnabled(true);
	}

	/**
	 * @param theMessage the message to set
	 */
	public void setMessage(Hl7V2MessageCollection theMessage) {
		Validate.isTrue(myMessage == null);

		myMessage = theMessage;

		myShowCombo.setModel(new ShowComboModel());

		// Prepopulate the "send to interface" combo to the last value it had
		if (StringUtils.isNotBlank(myMessage.getLastSendToInterfaceId())) {
			for (int i = 0; i < myOutboundInterfaceComboModelShadow.size(); i++) {
				if (myOutboundInterfaceComboModelShadow != null && myMessage != null
						&& myOutboundInterfaceComboModelShadow.get(i) != null && myOutboundInterfaceComboModelShadow
								.get(i).getId().equals(myMessage.getLastSendToInterfaceId())) {
					myOutboundInterfaceCombo.setSelectedIndex(i);
					break;
				}
			}
		}
		
		myRdbtnEr7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent theE) {
				removeHighlights();
				myMessage.setEncoding(Hl7V2EncodingTypeEnum.ER_7);
			}
		});
		myRdbtnXml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent theE) {
				removeHighlights();
				myMessage.setEncoding(Hl7V2EncodingTypeEnum.XML);
			}
		});

		
		  myRdbtnTableView.addActionListener(new ActionListener() { 
			 public void actionPerformed(ActionEvent theE) { 
				 removeHighlights();
				 myMessage.setEncoding(Hl7V2EncodingTypeEnum.ER_7); 
				 } 
			 });
		 

		try {
			myDisableCaretUpdateHandling = true;
			updateMessageEditor();
		} finally {
			myDisableCaretUpdateHandling = false;
		}

		myMessageListeneer = new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent theEvt) {
				if (myDontRespondToSourceMessageChanges) {
					return;
				}
				try {
					myDisableCaretUpdateHandling = true;
					updateMessageEditor();
				} finally {
					myDisableCaretUpdateHandling = false;
				}
			}
		};
		myMessage.addPropertyChangeListener(Hl7V2MessageCollection.SOURCE_MESSAGE_PROPERTY, myMessageListeneer);

		mySelectedPathListener = new PropertyChangeListener() {

			public void propertyChange(PropertyChangeEvent theEvt) {
				String path = myMessage.getHighlitedPath();
				if (path == null) {
					path = "";
				}

				int index = path.indexOf('/');
				if (index > -1) {
					path = path.substring(index);
				}

				myTerserPathTextField.setText(path);
			}
		};
		myMessage.addPropertyChangeListener(Hl7V2MessageCollection.PROP_HIGHLITED_PATH, mySelectedPathListener);

		myTreePanel.setMessage(myMessage);

		myRangeListener = new PropertyChangeListener() {

			public void propertyChange(PropertyChangeEvent theEvt) {
				if (theEvt.getNewValue() == null || !myFollowToggle.isSelected()) {
					return;
				}
				Range range = (Range) theEvt.getNewValue();

				// myMessageScrollPane.getHorizontalScrollBar().setValue(0);

				// myMessageEditor.select(range.getStart(), range.getEnd());
				// myMessageEditor.setCaretPosition(range.getStart());

				myMessageEditor.setCaretPosition(range.getStart());
				myMessageEditor.moveCaretPosition(range.getEnd());

				myMessageEditor.setCaretPosition(range.getEnd());
				myMessageEditor.moveCaretPosition(range.getStart());

				// myMessageEditor.grabFocus();
				myMessageEditor.repaint();

				String substring = myMessage.getSourceMessage().substring(range.getStart(), range.getEnd());
				ourLog.info("Selected range set to " + range + " which is " + substring);
			}
		};
		myMessage.addPropertyChangeListener(Hl7V2MessageCollection.PROP_HIGHLITED_RANGE, myRangeListener);

		myProfileComboboxModel.update();

		// Window Title
		myWindowTitleListener = new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent theEvt) {
				updateWindowTitle();
			}
		};
		myMessage.addPropertyChangeListener(Hl7V2MessageCollection.SAVED_PROPERTY, myWindowTitleListener);
		myMessage.addPropertyChangeListener(Hl7V2MessageCollection.PROP_SAVE_FILENAME, myWindowTitleListener);
		updateWindowTitle();

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				myMessageEditor.setCaretPosition(0);
				myMessageEditor.grabFocus();
			}
		});

	}

	private void removeHighlights() {
		Highlighter hilite = myMessageEditor.getHighlighter();
		Highlighter.Highlight[] hilites = hilite.getHighlights();
		for (int i = 0; i < hilites.length; i++) {
			hilite.removeHighlight(hilites[i]);
		}
	}

	// Removes all but the 2 most recent highlights - the last tag pair
	// selected.
	private void removeMostHighlights() {
		Highlighter hilite = myMessageEditor.getHighlighter();
		Highlighter.Highlight[] hilites = hilite.getHighlights();
		for (int i = 0; i < hilites.length - 2; i++) {
			hilite.removeHighlight(hilites[i]);
		}
	}

	private void updateWindowTitle() {
		StringBuilder b = new StringBuilder();

		if (myMessage.isSaved() == false) {
			b.append("Unsaved");
		}

		if (b.length() > 0) {
			b.append(" - ");
		}
		if (StringUtils.isNotBlank(myMessage.getSaveFileName())) {
			b.append(myMessage.getSaveFileName());
		} else {
			b.append("New File");
		}

		setWindowTitle(b.toString());
	}


	private void updateMessageEditor() {

		final JScrollBar vsb = myMessageScrollPane.getVerticalScrollBar();
		int initialVerticalValue = vsb.getValue();

		myMessageEditor.getDocument().removeDocumentListener(myDocumentListener);
		
		String sourceMessage = myMessage.getSourceMessage();
		

		if (myMessage.getEncoding() == Hl7V2EncodingTypeEnum.XML) {
			myMessageEditor.setContentType("text/xml");
		} else if (myMessage.getEncoding() == Hl7V2EncodingTypeEnum.ER_7) {
			myMessageEditor.setContentType("text/er7");
			sourceMessage = sourceMessage.replace('\r', '\n');
		} 
		
		 if (myRdbtnTableView.isSelected()) {			
			sourceMessage = ConvertMessageToHtml(sourceMessage.trim().replaceAll("((\r\n)|\r)|(\n)", "\n"), myMessage);

			myMessageEditor.setContentType("text/html");
			myMessageEditor.disable();
		}
		myMessageEditor.setText(sourceMessage);
		myMessageEditor.getDocument().addDocumentListener(myDocumentListener);
		myMessageEditor.repaint();
		final int verticalValue = Math.min(initialVerticalValue, vsb.getMaximum());

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// myMessageEditor.setFont(Prefs.getHl7EditorFont());
				myMessageEditor.repaint();
				vsb.setValue(verticalValue);
			}
		});

	}
	


	private void updateOutboundConnectionsBox() {
		int currentSelection = myOutboundInterfaceCombo.getSelectedIndex();

		List<OutboundConnection> conn = myController.getOutboundConnectionList().getConnections();

		myOutboundInterfaceComboModelIsUpdating = true;

		myOutboundInterfaceComboModel.removeAllElements();
		myOutboundInterfaceComboModelShadow = new ArrayList<OutboundConnection>();
		if (conn.isEmpty()) {
			myOutboundInterfaceComboModel.addElement(NO_CONNECTIONS);
			myOutboundInterfaceComboModelShadow.add(null);
		} else {
			for (OutboundConnection next : conn) {
				myOutboundInterfaceComboModel.addElement(next.getName());
				myOutboundInterfaceComboModelShadow.add(next);
			}
		}

		myOutboundInterfaceComboModel.addElement(CREATE_NEW_CONNECTION);
		myOutboundInterfaceComboModelShadow.add(null);

		if (currentSelection != -1 && currentSelection < myOutboundInterfaceComboModel.getSize()) {
			myOutboundInterfaceCombo.setSelectedIndex(currentSelection);
		} else {
			myOutboundInterfaceCombo.setSelectedIndex(0);
		}

		myOutboundInterfaceComboModelIsUpdating = false;

		updateSendButton();
	}

	private class ProfileComboModel extends DefaultComboBoxModel {

		// private static final String APPLY_CONFORMANCE_PROFILE =
		// "Apply Conformance Profile...";
		private ArrayList<ProfileGroup> myProfileGroups;

		public void update() {
			myHandlingProfileComboboxChange = true;
			try {
				super.removeAllElements();
				myProfileGroups = new ArrayList<ProfileGroup>();

				addElement("No Profile/Validation");
				myProfileGroups.add(null);

				addElement("Default Datatype Validation (HAPI)");
				myProfileGroups.add(null);

				// ProfileGroup profile = myMessage.getRuntimeProfile();
				// if (profile != null) {
				// String name = "Conf Profile (" +
				// profile.getMessage().getMsgType() + "^" +
				// profile.getMessage().getEventType() + ")";
				// String profName = myMessage.getRuntimeProfile().getName();
				// if (StringUtils.isNotBlank(profName)) {
				// name = name + ":" + profName;
				// }
				//
				// addElement(name);
				// }

				// addElement(APPLY_CONFORMANCE_PROFILE);

				for (ProfileGroup nextProfile : myController.getProfileFileList().getProfiles()) {
					String nextString = "Profile Group: " + nextProfile.getName();
					addElement(nextString);
					myProfileGroups.add(nextProfile);
					if (myMessage.getRuntimeProfile() == nextProfile) {
						setSelectedItem(nextString);
					}
				}

				if (myMessage.getValidationContext() instanceof DefaultValidation) {
					setSelectedItem(getElementAt(1));
				} else if (getSelectedItem() == null) {
					setSelectedItem(getElementAt(0));
				}
			} finally {
				myHandlingProfileComboboxChange = false;
			}
		}
	}

	public class ShowComboModel extends DefaultComboBoxModel implements ActionListener {
		private static final String ALL = "All";
		private static final String ERRORS = "Errors";
		private static final String POPULATED = "Populated";
		private static final String SUPPORTED = "Supported";

		public ShowComboModel() {
			addElement(POPULATED);
			addElement(ALL);
			addElement(ERRORS);
			addElement(SUPPORTED);

			switch (myMessage.getEditorShowMode()) {
			case ALL:
				setSelectedItem(ALL);
				break;
			case ERROR:
				setSelectedItem(ERRORS);
				break;
			case POPULATED:
				setSelectedItem(POPULATED);
				break;
			case SUPPORTED:
				setSelectedItem(SUPPORTED);
				break;
			}

			myShowCombo.addActionListener(this);
		}

		public void actionPerformed(ActionEvent theE) {
			String value = (String) myShowCombo.getSelectedItem();

			if (value == ALL) {
				myTreePanel.setEditorShowModeAndUpdateAccordingly(ShowEnum.ALL);
			} else if (value == ERRORS) {
				myTreePanel.setEditorShowModeAndUpdateAccordingly(ShowEnum.ERROR);
			} else if (value == SUPPORTED) {
				myTreePanel.setEditorShowModeAndUpdateAccordingly(ShowEnum.SUPPORTED);
			} else {
				myTreePanel.setEditorShowModeAndUpdateAccordingly(ShowEnum.POPULATED);
			}

		}
	}

	private void activateSendingActivityTabForConnection(OutboundConnection theConnection) {
		mySendingActivityTable.setConnection(theConnection, false);
		myTopTabBar.setSelectedComponent(mySendingActivityTable);
	}

	public Frame getWindow() {
		return myController.getWindow();
	}

	/**
	 * Creates html elements to add tables in View as Table
	 * @param xml
	 * @param theMessage
	 * @return html code in a string format
	 */
	private String ConvertMessageToHtml(String xml, Hl7V2MessageCollection theMessage) {

		
		StringBuilder html = new StringBuilder("<html><body>\r\n");
		try {
			int index=getFirstMessage(theMessage);
			Message message = (Message) ((Hl7V2MessageEr7) theMessage.getMessages().get(index)).getParsedMessage();
			Map<String, List<Structure>> map = message.getAllStructure();
			String version=message.getMessage().getVersion();

			Iterator<Entry<String, List<Structure>>> itr = map.entrySet().iterator();
			List<Segment> segs=new ArrayList<>();
			while (itr.hasNext()) {
				Entry<String, List<Structure>> entry = itr.next();

				if (entry.getValue().size() > 0) {
					
					for (Structure item : entry.getValue()) {
						String segName;
						Structure subItem= item;
						getSegments(item, segs);
		
					}

				}
			}
			
			//Create Table header
			html.append("<table align='left' " + "border: 1px solid"+" class='headerTable' border-collapse: collapse>\n" + "<caption> <b>Header</b> </caption>"+"<tr>\n"+ "<th>Field Name</th>\n" + "<th>Value</th>\n" + " </tr>\n");
		for(Segment subItem: segs) {
			String name=subItem.getName();

			if(name.equals("MSH") ) {
				 headerTable(html, subItem.getName(),version, subItem);
				}
		}

			html.append("</table>\n"+ "<br>");//table header
			//Table about patient
			html.append("<table align='left' " + "border: 1px solid"+" class='patTable'  border-collapse: collapse >\n" + "<caption> <b> Patient </b> </caption>"+"<tr>\n"+ "<th>Field Name</th>\n" + "<th>Value</th>\n" + " </tr>\n" );
			for(Segment subItem: segs) {
				String name=subItem.getName();

				if(name.equals("PID") ) {
					patientTable(html, subItem.getName(),version, subItem);
					}
			}
			html.append("</table>\n"+ "<br>");//table patient
			
			//Table about examination
			html.append("<table align='left' " + "border: 1px solid"+" class='examTable' border-collapse: collapse>\n" + "<caption> <b>Examination </b> </caption>"+"<tr>\n"+ "<th>Field Name</th>\n" + "<th>Value</th>\n" + " </tr>\n");
			for(Segment subItem: segs) {
				String name=subItem.getName();
	
				if(name.equals("OBR") || name.equals("ZDS") ||name.equals("ORC") || name.equals("ZEI")) {
					examTable(html, subItem.getName(),version, subItem);
					}
			}

			html.append("</table>\n"+ "<br>");//table request
			
			//Create Table request
			html.append("<table align='left' " + "border: 1px solid"+" class='reqTable' border-collapse: collapse>\n" + "<caption> <b>Request</b> </caption>"+"<tr>\n"+ "<th>Field Name</th>\n" + "<th>Value</th>\n" + " </tr>\n");
		for(Segment subItem: segs) {
			String name=subItem.getName();

			if(name.equals("OBR") || name.equals("OBX") ||name.equals("ORC") || name.equals("PV1")) {
				requestTable(html, subItem.getName(),version, subItem);
				}
		}

			html.append("</table>\n"+ "<br>");//table request
			
			
			html.append("</body></html>");
		} catch (Exception e) {
			return xml;
		}

		return html.toString();
	}

	
	void getSegments(Structure group, List<Segment> segs) throws HL7Exception {
		
		if(group instanceof Segment) {
			segs.add((Segment)group);

		}
		else {
			AbstractGroup absgroup=(AbstractGroup)group;
			String[] names=absgroup.getNames();

			for(String name : names) {
					for(Structure elem : absgroup.getAll(name)) {
						getSegments(elem, segs);
					}
			}
		}
		
		
	}
	
	int getFirstMessage(Hl7V2MessageCollection theMessage) {
		int index=0;
		String myClass;
		
	for(Range msg : theMessage.getMessageRanges()) {
		
		myClass=theMessage.getMessages().get(index).getParsedMessage().getClass().toString();
		if(myClass.contains("ca.uhn.hl7v2.model."))
			return index;
		else
			index++;
		
	}
				
		return index;
	}
	
	
	
 /**	
  * Creates html table with some rows of message HL7 fields associated with request/order
  * @param html
  * @param name of the segment
  * @param HL7 message version 
  * @param Structure (segment)
  * @return html StringBuilder
  * @throws HL7Exception
  */
	private  StringBuilder requestTable(StringBuilder html, String segName, String version, Structure subItem) throws HL7Exception {

		AbstractSegment seg = (AbstractSegment) subItem;
		int[] val= {};
		List<List<Type>> fields=seg.getAllFields();
		String[] fieldNames=seg.getNames();
		int[] obr= {3,13,16,5,31};
		int[] obx= {2,5,7,16,20};
		int[] orc= {12};
		int[] pv1= {8};

	
		if(segName.equals("OBR"))
			val=obr;
		if(segName.equals("OBX"))
			val=obx;
		if(segName.equals("ORC"))
			val=orc;
		if(segName.equals("PV1"))
			val=pv1;
		
			for(int i : val) {		
				if(i <= fieldNames.length && !fields.get(i-1).isEmpty()) {

					html.append("<tr border:1px solid>");
					html.append("<td border:1px solid>" + fieldNames[i-1] + "</td>");
					html.append("<td border:1px solid>" + fields.get(i-1).toString() + "</td>"); //valor do campo
					html.append("</tr>\n"); 
					
				}
			}

		return html;
	}
	
	/**	
	  * Creates html table with some rows of message HL7 fields associated with patient
	  * @param html
	  * @param name of the segment
	  * @param HL7 message version 
	  * @param Structure (segment)
	  * @return html StringBuilder
	  * @throws HL7Exception
	  */
	private  StringBuilder patientTable(StringBuilder html, String segName, String version, Structure subItem) throws HL7Exception {

		AbstractSegment seg = (AbstractSegment) subItem;
		List<List<Type>> fields=seg.getAllFields();
		String[] fieldNames=seg.getNames();
		int[] pid= {2,5,7,8,29,30};
		
		
			for(int i : pid) {		
				if(i <= fieldNames.length && !fields.get(i-1).isEmpty()) {

					html.append("<tr border:1px solid black>");
					html.append("<td border:1px solid black>" + fieldNames[i-1] + "</td>");
					html.append("<td border:1px solid black>" + fields.get(i-1).toString() + "</td>"); //valor do campo
					html.append("</tr>"); 
				
				}
			}

		return html;
	}
	
	/**	
	  * Creates html table with some rows of message HL7 fields associated with examination
	  * @param html
	  * @param name of the segment
	  * @param HL7 message version 
	  * @param Structure (segment)
	  * @return html StringBuilder
	  * @throws HL7Exception
	  */
	private  StringBuilder examTable(StringBuilder html, String segName, String version, Structure subItem) throws HL7Exception {

		int[] val= {};
		AbstractSegment seg = (AbstractSegment) subItem;
		List<List<Type>> fields=seg.getAllFields();
		String[] fieldNames=seg.getNames();
		int[] obr= {19,4,21,27,20,32,24,15,28};
		int[] zds= {1};
		int[] orc= {5,};
		int[] zei= {7,8};

	
		if(segName.equals("OBR"))
			val=obr;
		if(segName.equals("ZEI"))
			val=zei;
		if(segName.equals("ORC"))
			val=orc;
		if(segName.equals("ZDS"))
			val=zds;
		
		
			for(int i : val) {		
				if(i <= fieldNames.length && !fields.get(i-1).isEmpty()) {

					html.append("<tr border:1px solid black>");
					html.append("<td border:1px solid black>" + fieldNames[i-1] + "</td>");
					html.append("<td border:1px solid black>" + fields.get(i-1).toString() + "</td>"); //valor do campo
					html.append("</tr>"); 
				
				}
			}

		return html;
	}
	
	/**	
	  * Creates html table with some rows of message HL7 fields associated with header 
	  * @param html
	  * @param name of the segment
	  * @param HL7 message version 
	  * @param Structure (segment)
	  * @return html StringBuilder
	  * @throws HL7Exception
	  */
	private  StringBuilder headerTable(StringBuilder html, String segName, String version, Structure subItem) throws HL7Exception {

		AbstractSegment seg = (AbstractSegment) subItem;
		List<List<Type>> fields=seg.getAllFields();
		String[] fieldNames=seg.getNames();
		int[] msh= {3,4,5,6,7,9,10,12};
		
		
			for(int i : msh) {		
				if(i <= fieldNames.length && !fields.get(i-1).isEmpty()) {

					html.append("<tr border:1px solid black>");
					html.append("<td border:1px solid black>" + fieldNames[i-1] + "</td>");
					html.append("<td border:1px solid black>" + fields.get(i-1).toString() + "</td>"); //valor do campo
					html.append("</tr>"); 
				
				}
			}

		return html;
	}
}
