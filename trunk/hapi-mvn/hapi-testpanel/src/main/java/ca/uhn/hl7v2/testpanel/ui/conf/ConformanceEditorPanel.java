package ca.uhn.hl7v2.testpanel.ui.conf;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.Box;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.AbstractLayoutCache;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import org.apache.commons.lang.StringUtils;
import org.netbeans.swing.outline.DefaultOutlineModel;
import org.netbeans.swing.outline.Outline;
import org.netbeans.swing.outline.RenderDataProvider;
import org.netbeans.swing.outline.RowModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.testpanel.controller.ConformanceEditorController;
import ca.uhn.hl7v2.testpanel.model.conf.Code;
import ca.uhn.hl7v2.testpanel.model.conf.ProfileFileList;
import ca.uhn.hl7v2.testpanel.model.conf.ProfileGroup;
import ca.uhn.hl7v2.testpanel.model.conf.ProfileGroup.Entry;
import ca.uhn.hl7v2.testpanel.model.conf.ProfileProxy;
import ca.uhn.hl7v2.testpanel.model.conf.Table;
import ca.uhn.hl7v2.testpanel.model.conf.TableFile;
import ca.uhn.hl7v2.testpanel.model.conf.TableFileList;
import ca.uhn.hl7v2.testpanel.ui.HoverButtonMouseAdapter;
import ca.uhn.hl7v2.testpanel.ui.ImageFactory;
import ca.uhn.hl7v2.testpanel.util.SimpleDocumentListener;

public class ConformanceEditorPanel {

	public static final String ACK = "ACK";

	private static final String CARD_BLANK = "name_1327851037962818000";
	private static final String CARD_CODES = "name_1327850619969970000";
	private static final String CARD_TABLE_FILE = "name_1327850895484802000";

	private static final Logger ourLog = LoggerFactory.getLogger(ConformanceEditorPanel.class);
	private JButton myAddProfileButton;
	private JButton myAddTableButton;
	private JPanel myBlankPanel;
	private JButton myCloseFileButton;
	private JButton myCloseTableButton;
	private JPanel myCodesPanel;
	private JTable myCodesTable;
	private MyCodesTableModel myCodesTableModel;
	private ConformanceEditorController myController;
	private JDialog myframe;
	private JButton myNewProfileGroupButton;
	private Outline myProfilesOutline;
	private MyProfilesOutlineModel myProfilesOutlineModel;
	private DefaultMutableTreeNode myProfilesOutlineRoot = new DefaultMutableTreeNode();
	private MyProfilesTreeModel myProfilesOutlineTreeModel;
	private JButton myRemoveProfileButton;
	private JButton myRemoveProfileGroupButton;
	private boolean myRespondingToChange;
	private JPanel myRightCardPanel;
	private JTextField myTableFileNameTextF;
	private JPanel myTableFilePanel;

	private JTree myTableFilesTable;

	private DefaultTreeModel myTableFilesTreeModel;

	private DefaultMutableTreeNode myTableFilesTreeRoot;

	private JTextField myTableIdTextField;

	private JTextField myTableNameTextField;

	private JButton myRenameButton;

	private JButton myExportButton;

	/**
	 * Create the application.
	 * 
	 * @param theConformanceEditorController
	 */
	public ConformanceEditorPanel(ConformanceEditorController theController) {
		myController = theController;

		initialize();

		myController.getTableFileList().addPropertyChangeListener(TableFileList.PROP_FILES, new PropertyChangeListener() {

			public void propertyChange(PropertyChangeEvent theEvt) {
				updateFileTree(null);
			}
		});

		myController.getProfileFileList().addPropertyChangeListener(ProfileFileList.PROP_FILES, new PropertyChangeListener() {

			public void propertyChange(PropertyChangeEvent theEvt) {
				updateProfileTree(null);
			}

		});

		updateProfileTree(null);
	}

	private void addTable() {
		Object selectedObject = getSelectedFileOrTable();

		TableFile file;
		if (selectedObject instanceof TableFile) {
			file = (TableFile) selectedObject;
		} else if (selectedObject instanceof Table) {
			file = ((Table) selectedObject).getTableFile();
		} else {
			ourLog.error("Selected object isn't a table or file: {}", selectedObject);
			return;
		}

		file = (TableFile) selectedObject;
		Table table = file.addTable();

		myController.markFileForSaving(file);

		updateFileTree(table);

	}

	public Component getFrame() {
		return myframe;
	}

	public DefaultMutableTreeNode getNodeForRow(int theRowIndex) {
		final AbstractLayoutCache layout = myProfilesOutlineModel.getLayout();
		TreePath selectionPath = layout.getPathForRow(theRowIndex);
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) selectionPath.getLastPathComponent();
		return selectedNode;
	}

	private Object getSelectedFileOrTable() {
		TreePath selectionPath = myTableFilesTable.getSelectionPath();
		Object selectedObject;
		if (selectionPath == null) {
			selectedObject = null;
		} else {
			DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) selectionPath.getLastPathComponent();
			if (selectedNode == null) {
				selectedObject = null;
			} else {
				selectedObject = selectedNode.getUserObject();
			}
		}
		return selectedObject;
	}

	private Object getSelectedProfileGroupOrFile() {
		int selIndex = myProfilesOutline.getSelectionModel().getLeadSelectionIndex();
		if (selIndex == -1) {
			return null;
		}

		final AbstractLayoutCache layout = myProfilesOutlineModel.getLayout();
		TreePath selectionPath = layout.getPathForRow(selIndex);
		Object selectedObject;
		if (selectionPath == null) {
			selectedObject = null;
		} else {
			DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) selectionPath.getLastPathComponent();
			if (selectedNode == null) {
				selectedObject = null;
			} else {
				selectedObject = selectedNode.getUserObject();
			}
		}
		return selectedObject;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		myframe = new JDialog();
		myframe.setBounds(100, 100, 726, 571);
		myframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		myTableFilesTreeRoot = new DefaultMutableTreeNode();
		myTableFilesTreeModel = new DefaultTreeModel(myTableFilesTreeRoot);
		myCodesTableModel = new MyCodesTableModel();

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		myframe.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JPanel profilesPanel = new JPanel();
		tabbedPane.addTab("Profiles", null, profilesPanel, null);
		profilesPanel.setLayout(new BorderLayout(0, 0));

		myProfilesOutlineTreeModel = new MyProfilesTreeModel();
		myProfilesOutlineModel = new MyProfilesOutlineModel(myProfilesOutlineTreeModel);

		myProfilesOutline = new Outline(myProfilesOutlineModel);
		// myProfilesOutline.setFullyEditable(true);
		myProfilesOutline.setFillsViewportHeight(true);
		myProfilesOutline.setCellSelectionEnabled(false);
		myProfilesOutline.setRowSelectionAllowed(false);
		myProfilesOutline.setRootVisible(false);
		myProfilesOutline.setGridColor(Color.WHITE);
		myProfilesOutline.setColumnHidingAllowed(false);
		myProfilesOutline.setRenderDataProvider(new MyProfilesOutlinesRenderProvider());
		myProfilesOutline.setDefaultEditor(Object.class, new ProfileGroupCellEditor());
		myProfilesOutline.setDefaultEditor(String.class, new ProfileGroupCellComboboxEditor());
		myProfilesOutline.setDefaultRenderer(String.class, new ProfilesTreeRenderer(this));
		myProfilesOutline.getColumnModel().getColumn(1).setPreferredWidth(60);
		myProfilesOutline.getColumnModel().getColumn(1).setMinWidth(60);
		myProfilesOutline.getColumnModel().getColumn(1).setMaxWidth(60);
		myProfilesOutline.getColumnModel().getColumn(2).setPreferredWidth(60);
		myProfilesOutline.getColumnModel().getColumn(2).setMinWidth(60);
		myProfilesOutline.getColumnModel().getColumn(2).setMaxWidth(60);
		myProfilesOutline.getColumnModel().getColumn(3).setPreferredWidth(200);
		myProfilesOutline.getColumnModel().getColumn(3).setMinWidth(200);
		myProfilesOutline.getColumnModel().getColumn(3).setMaxWidth(200);
		myProfilesOutline.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent theE) {
				updateSelectedProfilesItem();
			}
		});

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setViewportView(myProfilesOutline);
		profilesPanel.add(scrollPane_2, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		profilesPanel.add(panel_1, BorderLayout.NORTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 644, 0 };
		gbl_panel_1.rowHeights = new int[] { 48, 24, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblNewLabel_1 = new JLabel(
				"<html><center>\nConformance profiles are arranged in groups called <b>Profile Groups</b>. Each Profile Group can define different conformance profiles to be used to validate specific message types. You may also optionally define <b>Table Sets</b> (see the tables tab) to validate code values within messages.\n</center></html>");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 10, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);

		JToolBar profilesToolbar = new JToolBar();
		GridBagConstraints gbc_profilesToolbar = new GridBagConstraints();
		gbc_profilesToolbar.anchor = GridBagConstraints.NORTH;
		gbc_profilesToolbar.fill = GridBagConstraints.HORIZONTAL;
		gbc_profilesToolbar.gridx = 0;
		gbc_profilesToolbar.gridy = 1;
		panel_1.add(profilesToolbar, gbc_profilesToolbar);
		profilesToolbar.setFloatable(false);

		myNewProfileGroupButton = new JButton("New Profile Group");
		myNewProfileGroupButton.setToolTipText("Creates a new profile group (which may contain multiple conformance profiles associated with different message types and table mappings)");
		myNewProfileGroupButton.setBorderPainted(false);
		myNewProfileGroupButton.setIcon(new ImageIcon(ConformanceEditorPanel.class.getResource("/ca/uhn/hl7v2/testpanel/images/new_tree.png")));
		myNewProfileGroupButton.addMouseListener(new HoverButtonMouseAdapter(myNewProfileGroupButton));
		myNewProfileGroupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent theE) {
				newProfileGroup();
			}
		});
		profilesToolbar.add(myNewProfileGroupButton);

		myAddProfileButton = new JButton("Add Profile");
		myAddProfileButton.addMouseListener(new HoverButtonMouseAdapter(myAddProfileButton));
		myAddProfileButton.setBorderPainted(false);
		myAddProfileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object sel = getSelectedProfileGroupOrFile();
				if (sel instanceof ProfileGroup) {
					myController.addProfile((ProfileGroup) sel);
				} else if (sel instanceof ProfileGroup.Entry) {
					myController.addProfile(((ProfileGroup.Entry) sel).getParentProfileGroup());
				}
			}
		});

		myRemoveProfileGroupButton = new JButton("Remove");
		myRemoveProfileGroupButton.setToolTipText("Close the selected profile group");
		myRemoveProfileGroupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfileGroup sel = (ProfileGroup) getSelectedProfileGroupOrFile();
				myController.closeProfileGroup(sel);
			}
		});

		myRenameButton = new JButton("Rename");
		myRenameButton.setToolTipText("Rename the selected profile group");
		myRenameButton.addMouseListener(new HoverButtonMouseAdapter(myRenameButton));
		myRenameButton.setBorderPainted(false);
		myRenameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfileGroup sel = (ProfileGroup) getSelectedProfileGroupOrFile();
				myController.renameProfileGroup(sel);
			}
		});
		myRenameButton.setIcon(new ImageIcon(ConformanceEditorPanel.class.getResource("/ca/uhn/hl7v2/testpanel/images/rename.png")));
		profilesToolbar.add(myRenameButton);
		myRemoveProfileGroupButton.setBorderPainted(false);
		myRemoveProfileGroupButton.setIcon(new ImageIcon(ConformanceEditorPanel.class.getResource("/ca/uhn/hl7v2/testpanel/images/delete.png")));
		myRemoveProfileGroupButton.addMouseListener(new HoverButtonMouseAdapter(myRemoveProfileGroupButton));
		profilesToolbar.add(myRemoveProfileGroupButton);
		
		myExportButton = new JButton("Export");
		myExportButton.setToolTipText("Export the selected profile group to a single file that may be shared with other people");
		myExportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myController.exportProfileGroup((ProfileGroup)getSelectedProfileGroupOrFile());
			}
		});
		myExportButton.setIcon(new ImageIcon(ConformanceEditorPanel.class.getResource("/ca/uhn/hl7v2/testpanel/images/save_all.png")));
		myExportButton.setBorderPainted(false);
		myExportButton.addMouseListener(new HoverButtonMouseAdapter(myExportButton));
		profilesToolbar.add(myExportButton);
		
		JButton btnImport = new JButton("Import");
		btnImport.setToolTipText("Import a profile group");
		btnImport.addMouseListener(new HoverButtonMouseAdapter(btnImport));
		btnImport.setBorderPainted(false);
		btnImport.setIcon(new ImageIcon(ConformanceEditorPanel.class.getResource("/ca/uhn/hl7v2/testpanel/images/open.png")));
		btnImport.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent theE) {
				myController.importProfileGroup();
			}
		});
		profilesToolbar.add(btnImport);
		myAddProfileButton.setIcon(new ImageIcon(ConformanceEditorPanel.class.getResource("/ca/uhn/hl7v2/testpanel/images/profile.png")));
		profilesToolbar.add(myAddProfileButton);

		myRemoveProfileButton = new JButton("Remove Profile");
		myRemoveProfileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfileGroup.Entry sel = (Entry) getSelectedProfileGroupOrFile();
				sel.getParentProfileGroup().removeEntry(sel);
			}
		});
		myRemoveProfileButton.setIcon(new ImageIcon(ConformanceEditorPanel.class.getResource("/ca/uhn/hl7v2/testpanel/images/close.png")));
		myRemoveProfileButton.setBorderPainted(false);
		myRemoveProfileButton.addMouseListener(new HoverButtonMouseAdapter(myRemoveProfileButton));
		profilesToolbar.add(myRemoveProfileButton);

		JPanel tablesPanel = new JPanel();
		tabbedPane.addTab("Tables", null, tablesPanel, null);
		GridBagLayout gbl_tablesPanel = new GridBagLayout();
		gbl_tablesPanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_tablesPanel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_tablesPanel.columnWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_tablesPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		tablesPanel.setLayout(gbl_tablesPanel);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 1;
		gbc_horizontalStrut.gridy = 0;
		tablesPanel.add(horizontalStrut, gbc_horizontalStrut);

		JToolBar toolBar = new JToolBar();
		toolBar.setAlignmentX(Component.LEFT_ALIGNMENT);
		toolBar.setFloatable(false);
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.anchor = GridBagConstraints.WEST;
		gbc_toolBar.insets = new Insets(0, 0, 5, 5);
		gbc_toolBar.gridx = 0;
		gbc_toolBar.gridy = 1;
		tablesPanel.add(toolBar, gbc_toolBar);

		JButton btnAddTableFile = new JButton("Add File");
		btnAddTableFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myController.addTableFile();
			}
		});
		btnAddTableFile.setToolTipText("New Table File...");
		btnAddTableFile.setBorderPainted(false);
		btnAddTableFile.setIcon(new ImageIcon(ConformanceEditorPanel.class.getResource("/ca/uhn/hl7v2/testpanel/images/file.png")));
		btnAddTableFile.addMouseListener(new HoverButtonMouseAdapter(btnAddTableFile));
		toolBar.add(btnAddTableFile);

		myAddTableButton = new JButton("Add Table");
		myAddTableButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTable();
			}

		});

		myCloseFileButton = new JButton("Close File");
		myCloseFileButton.setIcon(new ImageIcon(ConformanceEditorPanel.class.getResource("/ca/uhn/hl7v2/testpanel/images/close.png")));
		myCloseFileButton.addMouseListener(new HoverButtonMouseAdapter(myCloseFileButton));
		myCloseFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object selectedFileOrTable = getSelectedFileOrTable();
				if (selectedFileOrTable instanceof TableFile) {
					myController.closeFile((TableFile) selectedFileOrTable);
				} else if (selectedFileOrTable instanceof Table) {
					myController.closeFile(((Table) selectedFileOrTable).getTableFile());
				}
			}
		});
		myCloseFileButton.setBorderPainted(false);
		toolBar.add(myCloseFileButton);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setMaximumSize(new Dimension(100, 32767));
		horizontalStrut_1.setPreferredSize(new Dimension(100, 0));
		horizontalStrut_1.setMinimumSize(new Dimension(100, 0));
		toolBar.add(horizontalStrut_1);

		myAddTableButton.setBorderPainted(false);
		myAddTableButton.setIcon(new ImageIcon(ConformanceEditorPanel.class.getResource("/ca/uhn/hl7v2/testpanel/images/table.png")));
		myAddTableButton.addMouseListener(new HoverButtonMouseAdapter(myAddTableButton));
		toolBar.add(myAddTableButton);

		myCloseTableButton = new JButton("Remove Table");
		myCloseTableButton.setIcon(new ImageIcon(ConformanceEditorPanel.class.getResource("/ca/uhn/hl7v2/testpanel/images/close.png")));
		myCloseTableButton.setBorderPainted(false);
		myCloseTableButton.addMouseListener(new HoverButtonMouseAdapter(myCloseTableButton));
		myCloseTableButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent theE) {
				TableFile tableFile;
				Object sel = getSelectedFileOrTable();
				Table table;
				if (sel instanceof Table) {
					table = (Table) sel;
					tableFile = table.getTableFile();
				} else {
					return;
				}
				tableFile.removeTable(table);
				myController.markFileForSaving(tableFile);
			}
		});
		toolBar.add(myCloseTableButton);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		tablesPanel.add(scrollPane, gbc_scrollPane);

		myTableFilesTable = new JTree();
		myTableFilesTable.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				updateSelectedCodesItem();
			}
		});
		myTableFilesTable.setCellRenderer(new TableTreeRenderer());
		myTableFilesTable.setShowsRootHandles(true);
		myTableFilesTable.setRootVisible(false);
		myTableFilesTable.setModel(myTableFilesTreeModel);
		scrollPane.setViewportView(myTableFilesTable);

		JLabel lblNewLabel = new JLabel(
				"<html><center>\nA <b>Table</b> contains a list of allowed values which may be used within\na particular field. Any field with a datatype of ID or IS will have an associated table number, and a Table may be used to define values for it. \n<br><br>\nA <b>Table File</b> contains one or more tables, and may be applied to a message to validate the various coded fields within it.\n</center></html>");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		tablesPanel.add(lblNewLabel, gbc_lblNewLabel);

		myRightCardPanel = new JPanel();
		GridBagConstraints gbc_RightCardPanel = new GridBagConstraints();
		gbc_RightCardPanel.gridheight = 4;
		gbc_RightCardPanel.fill = GridBagConstraints.BOTH;
		gbc_RightCardPanel.gridx = 2;
		gbc_RightCardPanel.gridy = 0;
		tablesPanel.add(myRightCardPanel, gbc_RightCardPanel);
		myRightCardPanel.setLayout(new CardLayout(0, 0));

		myCodesPanel = new JPanel();
		myRightCardPanel.add(myCodesPanel, CARD_CODES);
		GridBagLayout gbl_CodesPanel = new GridBagLayout();
		gbl_CodesPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_CodesPanel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_CodesPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_CodesPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		myCodesPanel.setLayout(gbl_CodesPanel);

		JLabel lblValues = new JLabel("Codes");
		GridBagConstraints gbc_lblValues = new GridBagConstraints();
		gbc_lblValues.gridwidth = 2;
		gbc_lblValues.insets = new Insets(0, 0, 5, 5);
		gbc_lblValues.gridx = 0;
		gbc_lblValues.gridy = 0;
		myCodesPanel.add(lblValues, gbc_lblValues);

		JLabel lblTable = new JLabel("Table");
		GridBagConstraints gbc_lblTable = new GridBagConstraints();
		gbc_lblTable.insets = new Insets(0, 0, 5, 5);
		gbc_lblTable.gridx = 0;
		gbc_lblTable.gridy = 1;
		myCodesPanel.add(lblTable, gbc_lblTable);

		myTableIdTextField = new JTextField();
		GridBagConstraints gbc_TableIdTextField = new GridBagConstraints();
		gbc_TableIdTextField.insets = new Insets(0, 0, 5, 0);
		gbc_TableIdTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_TableIdTextField.gridx = 1;
		gbc_TableIdTextField.gridy = 1;
		myCodesPanel.add(myTableIdTextField, gbc_TableIdTextField);
		myTableIdTextField.setColumns(10);
		myTableIdTextField.getDocument().addDocumentListener(new SimpleDocumentListener() {
			@Override
			public void update(DocumentEvent theE) {
				if (myRespondingToChange) {
					return;
				}
				if (getSelectedFileOrTable() instanceof Table) {
					Table table = (Table) getSelectedFileOrTable();
					table.setCodeSystemId(myTableIdTextField.getText());
					myController.markFileForSaving(table.getTableFile());
				}
			}
		});

		JLabel lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 2;
		myCodesPanel.add(lblName, gbc_lblName);

		myTableNameTextField = new JTextField();
		GridBagConstraints gbc_TableNameTextField = new GridBagConstraints();
		gbc_TableNameTextField.insets = new Insets(0, 0, 5, 0);
		gbc_TableNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_TableNameTextField.gridx = 1;
		gbc_TableNameTextField.gridy = 2;
		myCodesPanel.add(myTableNameTextField, gbc_TableNameTextField);
		myTableNameTextField.setColumns(10);
		myTableNameTextField.getDocument().addDocumentListener(new SimpleDocumentListener() {
			@Override
			public void update(DocumentEvent theE) {
				if (myRespondingToChange) {
					return;
				}
				if (getSelectedFileOrTable() instanceof Table) {
					Table table = (Table) getSelectedFileOrTable();
					table.setCodeSystemName(myTableNameTextField.getText());
					myController.markFileForSaving(table.getTableFile());
				}
			}
		});

		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridwidth = 2;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 3;
		myCodesPanel.add(scrollPane_1, gbc_scrollPane_1);

		myCodesTable = new JTable();
		myCodesTable.setGridColor(Color.LIGHT_GRAY);
		scrollPane_1.setViewportView(myCodesTable);
		myCodesTable.setModel(myCodesTableModel);

		myTableFilePanel = new JPanel();
		myRightCardPanel.add(myTableFilePanel, CARD_TABLE_FILE);
		GridBagLayout gbl_TableFilePanel = new GridBagLayout();
		gbl_TableFilePanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_TableFilePanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_TableFilePanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_TableFilePanel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		myTableFilePanel.setLayout(gbl_TableFilePanel);

		JLabel lblTable_1 = new JLabel("Table");
		lblTable_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblTable_1 = new GridBagConstraints();
		gbc_lblTable_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblTable_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTable_1.gridwidth = 2;
		gbc_lblTable_1.gridx = 0;
		gbc_lblTable_1.gridy = 0;
		myTableFilePanel.add(lblTable_1, gbc_lblTable_1);

		JLabel lblName_1 = new JLabel("Name");
		GridBagConstraints gbc_lblName_1 = new GridBagConstraints();
		gbc_lblName_1.anchor = GridBagConstraints.EAST;
		gbc_lblName_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblName_1.gridx = 0;
		gbc_lblName_1.gridy = 1;
		myTableFilePanel.add(lblName_1, gbc_lblName_1);

		myTableFileNameTextF = new JTextField();
		GridBagConstraints gbc_TableFileNameTextF = new GridBagConstraints();
		gbc_TableFileNameTextF.fill = GridBagConstraints.HORIZONTAL;
		gbc_TableFileNameTextF.gridx = 1;
		gbc_TableFileNameTextF.gridy = 1;
		myTableFilePanel.add(myTableFileNameTextF, gbc_TableFileNameTextF);
		myTableFileNameTextF.setColumns(10);
		myTableFileNameTextF.getDocument().addDocumentListener(new SimpleDocumentListener() {
			@Override
			public void update(DocumentEvent theE) {
				if (myRespondingToChange) {
					return;
				}
				if (getSelectedFileOrTable() instanceof TableFile) {
					TableFile file = (TableFile) getSelectedFileOrTable();
					file.setName(myTableFileNameTextF.getText());
					myController.markFileForSaving(file);
				}
			}
		});

		myBlankPanel = new JPanel();
		myRightCardPanel.add(myBlankPanel, CARD_BLANK);

		JPanel controlButtonsPanel = new JPanel();
		myframe.getContentPane().add(controlButtonsPanel, BorderLayout.SOUTH);
		GridBagLayout gbl_controlButtonsPanel = new GridBagLayout();
		gbl_controlButtonsPanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_controlButtonsPanel.rowHeights = new int[] { 0, 0 };
		gbl_controlButtonsPanel.columnWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_controlButtonsPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		controlButtonsPanel.setLayout(gbl_controlButtonsPanel);

		JButton saveButton = new JButton("Close");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myframe.setVisible(false);
			}
		});
		GridBagConstraints gbc_saveButton = new GridBagConstraints();
		gbc_saveButton.gridx = 2;
		gbc_saveButton.gridy = 0;
		controlButtonsPanel.add(saveButton, gbc_saveButton);

	}

	private void newProfileGroup() {
		myController.newProfileGroup();
	}

	public void show() {
		myframe.setVisible(true);

		updateFileTree(null);
		updateSelectedCodesItem();
		updateSelectedProfilesItem();
	}

	private void updateFileTree(Object theSelectedObject) {

		List<TableFile> tableFiles = myController.getTableFileList().getTableFiles();
		int row = 0;
		for (int i = 0; i < tableFiles.size(); i++) {
			TableFile nextFile = tableFiles.get(i);

			if (myTableFilesTreeRoot.getChildCount() <= i || ((DefaultMutableTreeNode) myTableFilesTreeRoot.getChildAt(i)).getUserObject() != nextFile) {
				myTableFilesTreeRoot.insert(new DefaultMutableTreeNode(nextFile), i);
				nextFile.addPropertyChangeListener(TableFile.PROP_TABLES, new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent theEvt) {
						updateFileTree(null);
					}
				});
			}

			DefaultMutableTreeNode nextNode = (DefaultMutableTreeNode) myTableFilesTreeRoot.getChildAt(i);
			if (nextNode.getUserObject() == theSelectedObject) {
				myTableFilesTable.expandRow(row);
				myTableFilesTable.setSelectionRow(row);
			} else {
				myTableFilesTable.collapseRow(row);
			}

			final int parentRow = row;

			DefaultMutableTreeNode nextFileNode = (DefaultMutableTreeNode) myTableFilesTreeRoot.getChildAt(i);
			for (int j = 0; j < nextFile.getTables().size(); j++) {

				Table nextTable = nextFile.getTables().get(j);
				if (nextFileNode.getChildCount() <= j || ((DefaultMutableTreeNode) nextFileNode.getChildAt(j)).getUserObject() != nextTable) {
					nextFileNode.insert(new DefaultMutableTreeNode(nextTable), j);
					nextTable.addPropertyChangeListener(Table.PROP_CODES, new PropertyChangeListener() {

						public void propertyChange(PropertyChangeEvent theEvt) {
							myTableFilesTable.repaint();
						}
					});
				}

				while (nextFileNode.getChildCount() > nextFile.getTables().size()) {
					nextFileNode.remove(nextFile.getTables().size());
				}

				row++;

				DefaultMutableTreeNode nextTableNode = (DefaultMutableTreeNode) nextFileNode.getChildAt(j);
				if (nextTableNode.getUserObject() == theSelectedObject) {
					final int curRow = row;
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							myTableFilesTable.expandRow(parentRow);
							myTableFilesTable.setSelectionInterval(curRow, curRow);
						}
					});
				}

			}

			row++;
		}

		while (myTableFilesTreeRoot.getChildCount() > tableFiles.size()) {
			myTableFilesTreeRoot.remove(tableFiles.size());
		}

		myTableFilesTreeModel.nodeStructureChanged(myTableFilesTreeRoot);
	}

	private void updateProfileTree(Object theSelectedObject) {

		List<ProfileGroup> profileFiles = myController.getProfileFileList().getProfiles();
		int row = 0;
		for (int i = 0; i < profileFiles.size(); i++) {
			final ProfileGroup nextGroup = profileFiles.get(i);

			if (myProfilesOutlineRoot.getChildCount() <= i || ((DefaultMutableTreeNode) myProfilesOutlineRoot.getChildAt(i)).getUserObject() != nextGroup) {
				myProfilesOutlineRoot.insert(new ProfileGroupNode(nextGroup), i);
				nextGroup.addPropertyChangeListener(ProfileGroup.PROP_PROFILES, new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent theEvt) {
						updateProfileTree(theEvt.getNewValue());
					}
				});
			}

			DefaultMutableTreeNode nextNode = (DefaultMutableTreeNode) myProfilesOutlineRoot.getChildAt(i);
			final AbstractLayoutCache layout = myProfilesOutlineModel.getLayout();
			TreePath path = layout.getPathForRow(row);
			if (nextNode.getUserObject() == theSelectedObject) {
				myProfilesOutline.expandPath(path);
				myProfilesOutline.getSelectionModel().setSelectionInterval(row, row);
			} else {
				myProfilesOutline.collapsePath(path);
			}

			final int parentRow = row;

			ProfileGroupNode nextFileNode = (ProfileGroupNode) myProfilesOutlineRoot.getChildAt(i);
			for (int j = 0; j < nextGroup.getEntries().size(); j++) {

				Entry nextEntry = nextGroup.getEntries().get(j);
				if (nextFileNode.getChildCount() <= j || ((DefaultMutableTreeNode) nextFileNode.getChildAt(j)).getUserObject() != nextEntry) {
					nextFileNode.insert(new ProfileNode(nextEntry), j);
					nextEntry.addPropertyChangeListener(ProfileGroup.Entry.PROP_DESC, new PropertyChangeListener() {

						public void propertyChange(PropertyChangeEvent theEvt) {
							myProfilesOutline.repaint();
						}
					});
				}

				row++;

				DefaultMutableTreeNode nextTableNode = (DefaultMutableTreeNode) nextFileNode.getChildAt(j);
				if (nextTableNode.getUserObject() == theSelectedObject) {
					final int curRow = row;
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							TreePath path = layout.getPathForRow(parentRow);
							myProfilesOutline.expandPath(path);
							myProfilesOutline.getSelectionModel().setSelectionInterval(curRow, curRow);
						}
					});
				}

			}

			while (nextFileNode.getChildCount() > nextGroup.getEntries().size()) {
				nextFileNode.remove(nextGroup.getEntries().size());
			}

			row++;
		}

		while (myProfilesOutlineRoot.getChildCount() > profileFiles.size()) {
			myProfilesOutlineRoot.remove(profileFiles.size());
		}

		myProfilesOutlineTreeModel.reload();
	}

	private void updateSelectedCodesItem() {
		myRespondingToChange = true;
		CardLayout cl = (CardLayout) (myRightCardPanel.getLayout());

		Object selectedItem = getSelectedFileOrTable();
		if (selectedItem instanceof Table) {

			Table table = (Table) selectedItem;
			myTableIdTextField.setText(table.getCodeSystemId());
			myTableNameTextField.setText(table.getCodeSystemName());
			myCodesTableModel.setTable(table);
			myAddTableButton.setEnabled(true);
			myCloseFileButton.setEnabled(true);
			myCloseTableButton.setEnabled(true);

			cl.show(myRightCardPanel, CARD_CODES);

		} else if (selectedItem instanceof TableFile) {

			TableFile tf = (TableFile) selectedItem;
			myTableFileNameTextF.setText(tf.getName());
			cl.show(myRightCardPanel, CARD_TABLE_FILE);
			myAddTableButton.setEnabled(true);
			myCloseFileButton.setEnabled(true);
			myCloseTableButton.setEnabled(false);

		} else {

			cl.show(myRightCardPanel, CARD_BLANK);
			myAddTableButton.setEnabled(false);
			myCloseFileButton.setEnabled(false);
			myCloseTableButton.setEnabled(false);

		}

		myRespondingToChange = false;
	}

	private void updateSelectedProfilesItem() {

		Object sel = getSelectedProfileGroupOrFile();
		if (sel instanceof ProfileGroup) {
			myExportButton.setEnabled(true);
			myRemoveProfileGroupButton.setEnabled(true);
			myRemoveProfileButton.setEnabled(false);
			myAddProfileButton.setEnabled(true);
			myRenameButton.setEnabled(true);
		} else if (sel instanceof ProfileGroup.Entry) {
			myExportButton.setEnabled(false);
			myRemoveProfileGroupButton.setEnabled(false);
			myRemoveProfileButton.setEnabled(true);
			myAddProfileButton.setEnabled(true);
			myRenameButton.setEnabled(false);
		} else {
			myExportButton.setEnabled(false);
			myRemoveProfileGroupButton.setEnabled(false);
			myRemoveProfileButton.setEnabled(false);
			myAddProfileButton.setEnabled(false);
			myRenameButton.setEnabled(false);
		}

	}

	private class MyCodesTableModel extends DefaultTableModel {

		private Table myTable;

		public MyCodesTableModel() {
			addColumn("Code");
			addColumn("Name");
		}

		@Override
		public int getRowCount() {
			if (myTable == null) {
				return 0;
			}
			return myTable.getCodes().size() + 1;
		}

		@Override
		public Object getValueAt(int theRow, int theColumn) {
			if (myTable.getCodes().size() == theRow) {
				return "";
			}

			Code code = myTable.getCodes().get(theRow);
			switch (theColumn) {
			case 0:
				return code.getCode();
			case 1:
				return code.getDisplayName();
			}

			return "";
		}

		@Override
		public boolean isCellEditable(int theRow, int theColumn) {
			return true;
		}

		private void setTable(Table theTable) {
			if (myTable != theTable) {
				myTable = theTable;
				fireTableDataChanged();
			}
		}

		@Override
		public void setValueAt(Object theAValue, int theRow, int theColumn) {
			Code code;
			if (myTable.getCodes().size() == theRow) {
				code = new Code();
				myTable.addCode(code);
			}

			code = myTable.getCodes().get(theRow);

			switch (theColumn) {
			case 0:
				code.setCode(theAValue.toString());
				break;
			case 1:
				code.setDisplayName(theAValue.toString());
				break;
			}

			myController.markFileForSaving(myTable.getTableFile());
		}

	}

	public class MyProfilesOutlineModel extends DefaultOutlineModel {

		protected MyProfilesOutlineModel(TreeModel theTreeModel) {
			super(theTreeModel, new MyProfilesRowModel(), false, "Profiles");
		}

		@Override
		public boolean isCellEditable(int theRowIndex, int theColumnIndex) {
			if (theColumnIndex == 0) {
				DefaultMutableTreeNode selectedNode = getNodeForRow(theRowIndex);
				if (selectedNode instanceof ProfileGroupNode) {
					return true;
				} else {
					return false;
				}
			}
			return super.isCellEditable(theRowIndex, theColumnIndex);
		}

		@Override
		protected void setTreeValueAt(Object theAValue, int theRowIndex) {
			DefaultMutableTreeNode selectedNode = getNodeForRow(theRowIndex);
			if (selectedNode instanceof ProfileGroupNode) {
				((ProfileGroupNode) selectedNode).getUserObject().setName(theAValue.toString());
			} else {
				ourLog.error("Unknown type {}", selectedNode.getClass());
			}

			myController.getProfileFileList().updatePrefs();
		}
	}

	private class MyProfilesOutlinesRenderProvider implements RenderDataProvider {

		public Color getBackground(Object theArg0) {
			return Color.white;
		}

		public String getDisplayName(Object theArg0) {
			if (theArg0 instanceof ProfileGroupNode) {
				return ((ProfileGroupNode) theArg0).getUserObject().getName();
			}

			if (theArg0 instanceof ProfileNode) {
				ProfileProxy profileProxy = ((ProfileNode) theArg0).getUserObject().getProfileProxy();
				return profileProxy.getName();
			}

			return "Unknown";
		}

		public Color getForeground(Object theArg0) {
			return Color.black;
		}

		public Icon getIcon(Object theArg0) {
			if (theArg0 instanceof ProfileGroupNode) {
				return ImageFactory.getProfileGroup();
			} else {
				return ImageFactory.getProfile();
			}
		}

		public String getTooltipText(Object theArg0) {
			return null;
		}

		public boolean isHtmlDisplayName(Object theArg0) {
			return true;
		}

	}

	public class MyProfilesRowModel implements RowModel {

		public static final int COL_MSG_TYPE = 0;
		public static final int COL_TABLES = 2;
		public static final int COL_TRIGGER = 1;

		public Class<?> getColumnClass(int theArg0) {
			return String.class;
		}

		public int getColumnCount() {
			return 3;
		}

		public String getColumnName(int theArg0) {
			switch (theArg0) {
			case COL_MSG_TYPE:
				return "Msg Type";
			case COL_TRIGGER:
				return "Trigger";
			case COL_TABLES:
				return "Table File";
			}
			return null;
		}

		public Object getValueFor(Object theNode, int theColumn) {
			if (theNode instanceof ProfileNode) {
				ProfileNode pn = (ProfileNode) theNode;
				switch (theColumn) {
				case COL_MSG_TYPE:
					return pn.getUserObject().getMessageType();
				case COL_TRIGGER:
					return pn.getUserObject().getEventType();
				case COL_TABLES:
					String tableFileId = pn.getUserObject().getTablesId();
					if (tableFileId == null) {
						return null;
					}
					TableFile tableFile = myController.getTableFileList().getTableFile(tableFileId);
					if (tableFile == null) {
						return null;
					}
					return tableFile.getName();
				}
			}
			return null;
		}

		public boolean isCellEditable(Object theNode, int theColumn) {
			if (theNode instanceof ProfileGroupNode) {
				return false;
			} else if (theNode instanceof ProfileNode) {
				return true;
			} else {
				ourLog.error("Unknown type {}", theNode.getClass());
				return false;
			}
		}

		public void setValueFor(Object theNode, int theColumn, Object theValue) {
			if (theNode instanceof ProfileNode) {
				ProfileNode pn = (ProfileNode) theNode;
				switch (theColumn) {
				case COL_MSG_TYPE:
					pn.getUserObject().setMessageType(theValue.toString());
					break;
				case COL_TRIGGER:
					pn.getUserObject().setEventType(theValue.toString());
					break;
				case COL_TABLES:
					if (TBL_OPT_NONE.equals(theValue.toString())) {
						pn.getUserObject().setTablesId(null);
					} else if (theValue.toString().contains(":") == false) {
						// the value isn't changing in this case
						return;
					} else {
						String value = theValue.toString().replaceAll(":.*", "");
						int index = Integer.parseInt(value) - 1;
						String tblId = myController.getTableFileList().getTableFiles().get(index).getId();
						pn.getUserObject().setTablesId(tblId);
					}
					break;
				}

				myController.getProfileFileList().updatePrefs();

			}
		}

	}

	public class MyProfilesTreeModel extends DefaultTreeModel {

		public MyProfilesTreeModel() {
			super(myProfilesOutlineRoot);
		}

	}

	private static final String TBL_OPT_NONE = "None";

	public class ProfileGroupCellComboboxEditor extends DefaultCellEditor {

		public ProfileGroupCellComboboxEditor() {
			super(new JComboBox());
		}

		private List<String> getSortedStructures() {
			ArrayList<String> retVal = new ArrayList<String>();
			try {
				for (Object next : Parser.getMessageStructures(Version.latestVersion().getVersion()).keySet()) {
					retVal.add(next.toString());
				}
			} catch (IOException e) {
				ourLog.error("Failed to load structures", e);
			}

			Collections.sort(retVal);

			return retVal;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * javax.swing.DefaultCellEditor#getTableCellEditorComponent(javax.swing
		 * .JTable, java.lang.Object, boolean, int, int)
		 */
		@Override
		public Component getTableCellEditorComponent(JTable theTable, Object theValue, boolean theIsSelected, int theRow, int theColumn) {

			final AbstractLayoutCache layout = myProfilesOutlineModel.getLayout();
			TreePath selectionPath = layout.getPathForRow(theRow);
			ProfileNode selectedNode = (ProfileNode) selectionPath.getLastPathComponent();

			JComboBox retVal = (JComboBox) super.getTableCellEditorComponent(theTable, theValue, theIsSelected, theRow, theColumn);
			retVal.removeAllItems();

//			Properties structures = new Properties();
//			try {
//				structures = Parser.getMessageStructures(Version.latestVersion().getVersion());
//			} catch (IOException e) {
//				ourLog.error("Failed to load message types", e);
//			}

			if (theColumn - 1 == MyProfilesRowModel.COL_MSG_TYPE) {

				if (!"*".equals(theValue)) {
					retVal.addItem("*");
				}

				if (!ACK.equals(theValue)) {
					retVal.addItem(ACK);
				}

				String prevKey = "";
				for (String nextStruct : getSortedStructures()) {
					String[] nextParts = nextStruct.split("_");
					if (StringUtils.isNotBlank(nextParts[0]) && nextParts[0].equals(prevKey) == false) {
						prevKey = nextParts[0];
						retVal.addItem(prevKey);
					}
				}

				retVal.setSelectedItem(theValue);

			} else if (theColumn - 1 == MyProfilesRowModel.COL_TRIGGER) {

				if (!"*".equals(theValue)) {
					retVal.addItem("*");
				}

				for (String nextStruct : getSortedStructures()) {
					String[] nextParts = nextStruct.split("_");
					String selMsgType = selectedNode.getUserObject().getMessageType();
					if (nextParts.length > 1 && StringUtils.isNotBlank(nextParts[0]) && StringUtils.isNotBlank(nextParts[1]) && (nextParts[0].equals(selMsgType) || "*".equals(selMsgType))) {
						retVal.addItem(nextParts[1]);
					}
				}

				retVal.setSelectedItem(theValue);

			} else if (theColumn - 1 == MyProfilesRowModel.COL_TABLES) {

				retVal.addItem(TBL_OPT_NONE);
				retVal.setSelectedIndex(0);

				for (int i = 1; i <= myController.getTableFileList().getTableFiles().size(); i++) {
					TableFile tableFile = myController.getTableFileList().getTableFiles().get(i - 1);
					retVal.addItem((i) + ": " + tableFile.getName());

					if (tableFile.getId().equals(selectedNode.getUserObject().getTablesId())) {
						retVal.setSelectedIndex(i);
					}

				}

			}

			return retVal;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * javax.swing.DefaultCellEditor#getTreeCellEditorComponent(javax.swing
		 * .JTree, java.lang.Object, boolean, boolean, boolean, int)
		 */
		@Override
		public Component getTreeCellEditorComponent(JTree theTree, Object theValue, boolean theIsSelected, boolean theExpanded, boolean theLeaf, int theRow) {
			return super.getTreeCellEditorComponent(theTree, theValue, theIsSelected, theExpanded, theLeaf, theRow);
		}

	}

	private final class ProfileGroupCellEditor extends DefaultCellEditor {
		public ProfileGroupCellEditor() {
			super(new JTextField());
			setClickCountToStart(1);
		}

		private ProfileGroupCellEditor(JTextField theTextField) {
			super(theTextField);
		}

		@Override
		public Component getTableCellEditorComponent(JTable theTable, Object theValue, boolean theIsSelected, int theRow, int theColumn) {
			Component retVal = super.getTableCellEditorComponent(theTable, theValue, theIsSelected, theRow, theColumn);
			if (theValue instanceof ProfileGroupNode) {
				ProfileGroupNode value = (ProfileGroupNode) theValue;
				((JTextField) retVal).setText(value.getUserObject().getName());
				// } else {
				// ProfileNode value = (ProfileNode) theValue;
				// ((JTextField)
				// retVal).setText(value.getUserObject().getName());
			}
			return retVal;
		}

		@Override
		public Component getTreeCellEditorComponent(JTree theTree, Object theValue, boolean theIsSelected, boolean theExpanded, boolean theLeaf, int theRow) {
			Component retVal = super.getTreeCellEditorComponent(theTree, theValue, theIsSelected, theExpanded, theLeaf, theRow);
			return retVal;
		}
	}

	public class ProfileGroupNode extends DefaultMutableTreeNode {
		public ProfileGroupNode(ProfileGroup theProfileGroup) {
			super(theProfileGroup);
		}

		@Override
		public ProfileGroup getUserObject() {
			return (ProfileGroup) super.getUserObject();
		}
	}

	public class ProfileNode extends DefaultMutableTreeNode {
		public ProfileNode(ProfileGroup.Entry theProfile) {
			super(theProfile);
		}

		@Override
		public ProfileGroup.Entry getUserObject() {
			return (ProfileGroup.Entry) super.getUserObject();
		}
	}

}
