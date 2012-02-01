package ca.uhn.hl7v2.testpanel.ui.conf;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.AbstractLayoutCache;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import org.netbeans.swing.outline.DefaultOutlineModel;
import org.netbeans.swing.outline.Outline;
import org.netbeans.swing.outline.RenderDataProvider;
import org.netbeans.swing.outline.RowModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.testpanel.controller.ConformanceEditorController;
import ca.uhn.hl7v2.testpanel.model.conf.Code;
import ca.uhn.hl7v2.testpanel.model.conf.ProfileFileList;
import ca.uhn.hl7v2.testpanel.model.conf.ProfileGroup;
import ca.uhn.hl7v2.testpanel.model.conf.ProfileGroup.Entry;
import ca.uhn.hl7v2.testpanel.model.conf.Table;
import ca.uhn.hl7v2.testpanel.model.conf.TableFile;
import ca.uhn.hl7v2.testpanel.model.conf.TableFileList;
import ca.uhn.hl7v2.testpanel.ui.HoverButtonMouseAdapter;
import ca.uhn.hl7v2.testpanel.util.SimpleDocumentListener;

public class ConformanceEditorPanel {

	private static final String CARD_BLANK = "name_1327851037962818000";







	private static final String CARD_CODES = "name_1327850619969970000";

	private static final String CARD_TABLE_FILE = "name_1327850895484802000";

	private static final Logger ourLog = LoggerFactory.getLogger(ConformanceEditorPanel.class);
	private JButton myAddTableButton;
	private JPanel myBlankPanel;
	
	private JButton myCloseFileButton;
	private JButton myCloseTableButton;
	private JPanel myCodesPanel;
	private JTable myCodesTable;
	private MyCodesTableModel myCodesTableModel;
	private ConformanceEditorController myController;
	private JDialog myframe;
	private Outline myProfilesOutline;
	private MyProfilesOutlineModel myProfilesOutlineModel;
	private DefaultMutableTreeNode myProfilesOutlineRoot = new DefaultMutableTreeNode();
	private MyProfilesTreeModel myProfilesOutlineTreeModel;
	private boolean myRespondingToChange;
	private JPanel myRightCardPanel;
	private JTextField myTableFileNameTextF;
	private JPanel myTableFilePanel;
	private JTree myTableFilesTable;
	private DefaultTreeModel myTableFilesTreeModel;
	private DefaultMutableTreeNode myTableFilesTreeRoot;
	private JTextField myTableIdTextField;
	private JTextField myTableNameTextField;

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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		myframe = new JDialog();
		myframe.setBounds(100, 100, 665, 571);
		myframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		myTableFilesTreeRoot = new DefaultMutableTreeNode();
		myTableFilesTreeModel = new DefaultTreeModel(myTableFilesTreeRoot);
		myCodesTableModel = new MyCodesTableModel();

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		myframe.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel profilesPanel = new JPanel();
		tabbedPane.addTab("Profiles", null, profilesPanel, null);
		profilesPanel.setLayout(new BorderLayout(0, 0));
		
		JToolBar profilesToolbar = new JToolBar();
		profilesToolbar.setFloatable(false);
		profilesPanel.add(profilesToolbar, BorderLayout.NORTH);
		
		JButton btnNewProfileGroup = new JButton("New Profile Group");
		btnNewProfileGroup.setBorderPainted(false);
		btnNewProfileGroup.setIcon(new ImageIcon(ConformanceEditorPanel.class.getResource("/ca/uhn/hl7v2/testpanel/images/new_tree.png")));
		btnNewProfileGroup.addMouseListener(new HoverButtonMouseAdapter(btnNewProfileGroup));
		btnNewProfileGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent theE) {
				newProfileGroup();
			}
		});
		profilesToolbar.add(btnNewProfileGroup);

		myProfilesOutlineTreeModel = new MyProfilesTreeModel();
		myProfilesOutlineModel = new MyProfilesOutlineModel(myProfilesOutlineTreeModel);
		myProfilesOutline = new Outline(myProfilesOutlineModel);
		myProfilesOutline.setRootVisible(false);
		myProfilesOutline.setGridColor(Color.LIGHT_GRAY);
		myProfilesOutline.setColumnHidingAllowed(false);
		myProfilesOutline.setRenderDataProvider(new MyProfilesOutlinesRenderProvider());
		profilesPanel.add(myProfilesOutline, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Tables", null, panel, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 1;
		gbc_horizontalStrut.gridy = 0;
		panel.add(horizontalStrut, gbc_horizontalStrut);

		JToolBar toolBar = new JToolBar();
		toolBar.setAlignmentX(Component.LEFT_ALIGNMENT);
		toolBar.setFloatable(false);
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.anchor = GridBagConstraints.WEST;
		gbc_toolBar.insets = new Insets(0, 0, 5, 5);
		gbc_toolBar.gridx = 0;
		gbc_toolBar.gridy = 1;
		panel.add(toolBar, gbc_toolBar);

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
		
		myAddTableButton.setBorderPainted(false);
		myAddTableButton.setIcon(new ImageIcon(ConformanceEditorPanel.class.getResource("/ca/uhn/hl7v2/testpanel/images/table.png")));
		myAddTableButton.addMouseListener(new HoverButtonMouseAdapter(myAddTableButton));
		toolBar.add(myAddTableButton);

		myCloseTableButton = new JButton("Close Table");
		myCloseTableButton.setBorderPainted(false);
		myCloseTableButton.addMouseListener(new HoverButtonMouseAdapter(myCloseTableButton));
		myCloseTableButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent theE) {
				Table table = (Table) getSelectedFileOrTable();
				TableFile tableFile = table.getTableFile();
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
		panel.add(scrollPane, gbc_scrollPane);

		myTableFilesTable = new JTree();
		myTableFilesTable.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				updateSelectedItem();
			}
		});
		myTableFilesTable.setCellRenderer(new TableTreeRenderer());
		myTableFilesTable.setShowsRootHandles(true);
		myTableFilesTable.setRootVisible(false);
		myTableFilesTable.setModel(myTableFilesTreeModel);
		scrollPane.setViewportView(myTableFilesTable);

		JLabel lblNewLabel = new JLabel("Tables");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		myRightCardPanel = new JPanel();
		GridBagConstraints gbc_RightCardPanel = new GridBagConstraints();
		gbc_RightCardPanel.gridheight = 4;
		gbc_RightCardPanel.fill = GridBagConstraints.BOTH;
		gbc_RightCardPanel.gridx = 2;
		gbc_RightCardPanel.gridy = 0;
		panel.add(myRightCardPanel, gbc_RightCardPanel);
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
		updateSelectedItem();
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
			ProfileGroup nextGroup = profileFiles.get(i);

			if (myProfilesOutlineRoot.getChildCount() <= i || ((DefaultMutableTreeNode) myProfilesOutlineRoot.getChildAt(i)).getUserObject() != nextGroup) {
				myProfilesOutlineRoot.insert(new ProfileGroupNode(nextGroup), i);
				nextGroup.addPropertyChangeListener(ProfileGroup.PROP_GROUPS, new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent theEvt) {
						updateProfileTree(null);
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

				while (nextFileNode.getChildCount() > nextGroup.getEntries().size()) {
					nextFileNode.remove(nextGroup.getEntries().size());
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

			row++;
		}

		while (myProfilesOutlineRoot.getChildCount() > profileFiles.size()) {
			myProfilesOutlineRoot.remove(profileFiles.size());
		}

		myProfilesOutlineTreeModel.reload();
	}

	private void updateSelectedItem() {
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
			myCloseTableButton.setEnabled(true);

		} else {

			cl.show(myRightCardPanel, CARD_BLANK);
			myAddTableButton.setEnabled(false);
			myCloseFileButton.setEnabled(false);
			myCloseTableButton.setEnabled(false);

		}

		myRespondingToChange = false;
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

	}

	public class MyProfilesOutlinesRenderProvider implements RenderDataProvider {

		public Color getBackground(Object theArg0) {
			return Color.white;
		}

		public String getDisplayName(Object theArg0) {
			return null;
		}

		public Color getForeground(Object theArg0) {
			return Color.black;
		}

		public Icon getIcon(Object theArg0) {
			// TODO Auto-generated method stub
			return null;
		}

		public String getTooltipText(Object theArg0) {
			// TODO Auto-generated method stub
			return null;
		}

		public boolean isHtmlDisplayName(Object theArg0) {
			// TODO Auto-generated method stub
			return false;
		}

	}

	public class MyProfilesRowModel implements RowModel {

		private static final int COL_MSG_TYPE = 0;
		private static final int COL_TABLES = 2;
		private static final int COL_TRIGGER = 1;
		
		public Class<?> getColumnClass(int theArg0) {
			return String.class;
		}

		public int getColumnCount() {
			return 3;
		}

		public String getColumnName(int theArg0) {
			switch (theArg0) {
			case COL_MSG_TYPE: return "Msg Type";
			case COL_TRIGGER: return "Trigger";
			case COL_TABLES: return "Tables";
			}
			return null;
		}

		public Object getValueFor(Object theNode, int theColumn) {
			if (theNode instanceof ProfileNode) {
				ProfileNode pn = (ProfileNode)theNode;
				switch (theColumn) {
				case COL_MSG_TYPE:
					return pn.getUserObject().getMessageType();
				case COL_TRIGGER:
					return pn.getUserObject().getEventType();
				case COL_TABLES:
					return pn.getUserObject().getTablesId();
				}
			}
			return null;
		}

		public boolean isCellEditable(Object theNode, int theColumn) {
			if (theNode instanceof ProfileNode) {
				ProfileNode pn = (ProfileNode)theNode;
				switch (theColumn) {
				case COL_TABLES:
					return true;
				}
			}
			return false;
		}

		public void setValueFor(Object theNode, int theColumn, Object theValue) {
			if (theNode instanceof ProfileNode) {
				ProfileNode pn = (ProfileNode)theNode;
				switch (theColumn) {
				case COL_TABLES:
					// TODO: handle
				}
			}
		}

	}

	public class MyProfilesTreeModel extends DefaultTreeModel {

		public MyProfilesTreeModel() {
			super(myProfilesOutlineRoot );
		}

	}
	
	private class ProfileGroupNode extends DefaultMutableTreeNode
	{
		public ProfileGroupNode(ProfileGroup theProfileGroup) {
			super(theProfileGroup);
		}
		
		@Override
		public ProfileGroup getUserObject() {
			return (ProfileGroup) super.getUserObject();
		}
	}

	
	
	
	
	
	
	private class ProfileNode extends DefaultMutableTreeNode
	{
		public ProfileNode(ProfileGroup.Entry theProfile) {
			super(theProfile);
		}
		
		@Override
		public ProfileGroup.Entry getUserObject() {
			return (ProfileGroup.Entry) super.getUserObject();
		}
	}

}
