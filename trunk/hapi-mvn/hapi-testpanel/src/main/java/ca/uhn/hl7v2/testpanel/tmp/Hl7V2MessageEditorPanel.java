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
package ca.uhn.hl7v2.testpanel.tmp;

import javax.swing.JPanel;

public class Hl7V2MessageEditorPanel extends JPanel /*implements IDestroyable*/ {
//	private static final Log ourLog = LogFactory.getLog(Hl7V2MessageEditorPanel.class);
//
//	private Hl7V2MessageCollection myMessage;
//	private JEditorPane myMessageEditor;
//	private PropertyChangeListener myMessageListeneer;
//	private JRadioButton myRdbtnEr7;
//	private JRadioButton myRdbtnXml;
//	private JSplitPane mysplitPane;
//	private JScrollPane myTreeScrollPane;
//	private JScrollPane myMessageScrollPane;
//	private Hl7V2MessageTree myTreePanel;
//	private Hl7V2MessageEditorHighlighter myHighlighter;
//	private PropertyChangeListener myRangeListener;
//	private JPanel messageEditorContainerPanel;
//	private JPanel treeContainerPanel;
//	private JToolBar mytoolBar;
//	private JCheckBox myShowEmptyCheckBox;
//
//	private DocumentListener myDocumentListener;
//
//	static {
//		
//		System.setProperty("DefaultFont", "ARIAL-PLAIN-13");
//		
//		try {
//			DefaultSyntaxKit.initKit();
//			DefaultSyntaxKit.registerContentType("text/er7", Er7SyntaxKit.class.getName());
//			ourLog.info("Registered syntaxKit");
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * Create the panel.
//	 */
//	public Hl7V2MessageEditorPanel() {
//		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.columnWidths = new int[] { 0, 0 };
//		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
//		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
//		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
//		setLayout(gridBagLayout);
//
//		ButtonGroup encGrp = new ButtonGroup();
//
//		mysplitPane = new JSplitPane();
//		mysplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
//		GridBagConstraints gbc_splitPane = new GridBagConstraints();
//		gbc_splitPane.gridheight = 3;
//		gbc_splitPane.weightx = 1.0;
//		gbc_splitPane.weighty = 1.0;
//		gbc_splitPane.fill = GridBagConstraints.BOTH;
//		gbc_splitPane.gridx = 0;
//		gbc_splitPane.gridy = 0;
//		add(mysplitPane, gbc_splitPane);
//		
//		messageEditorContainerPanel = new JPanel();
//		mysplitPane.setRightComponent(messageEditorContainerPanel);
//				messageEditorContainerPanel.setLayout(new BorderLayout(0, 0));
//		
//				myMessageEditor = new JEditorPane();
//				myMessageEditor.setFont(new Font("Arial", Font.PLAIN, 13));
//				
//						myMessageScrollPane = new JScrollPane(myMessageEditor);
//						messageEditorContainerPanel.add(myMessageScrollPane);
//												
//														JToolBar toolBar = new JToolBar();
//														messageEditorContainerPanel.add(toolBar, BorderLayout.NORTH);
//														toolBar.setFloatable(false);
//														toolBar.setRollover(true);
//														
//																myRdbtnEr7 = new JRadioButton("ER7");
//																toolBar.add(myRdbtnEr7);
//																
//																		myRdbtnXml = new JRadioButton("XML");
//																		toolBar.add(myRdbtnXml);
//																		encGrp.add(myRdbtnEr7);
//																		encGrp.add(myRdbtnXml);
//												
//												treeContainerPanel = new JPanel();
//												mysplitPane.setLeftComponent(treeContainerPanel);
//														treeContainerPanel.setLayout(new BorderLayout(0, 0));
//												
//														myTreePanel = new Hl7V2MessageTree();
//														myTreeScrollPane = new JScrollPane(myTreePanel);
//														treeContainerPanel.add(myTreeScrollPane);
//														
//														mytoolBar = new JToolBar();
//														mytoolBar.setFloatable(false);
//														mytoolBar.setRollover(true);
//														treeContainerPanel.add(mytoolBar, BorderLayout.NORTH);
//														
//														myShowEmptyCheckBox = new JCheckBox("Show Empty");
//														myShowEmptyCheckBox.addChangeListener(new ChangeListener() {
//															public void stateChanged(ChangeEvent e) {
//																myTreePanel.setShowEmpty(myShowEmptyCheckBox.getModel().isSelected());
//															}
//														});
//														
//														mytoolBar.add(myShowEmptyCheckBox);
//		mysplitPane.setDividerLocation(150);
//		
//		init();
//		
//	}
//
//	private void init() {
//		
//		myDocumentListener = new DocumentListener() {
//			
//			public void removeUpdate(DocumentEvent theE) {
//				ourLog.info("Document removed: " + theE);
//				handleChange(theE);
//			}
//			
//			private void handleChange(DocumentEvent theE) {
//				String newSource = myMessageEditor.getText();
//				int changeStart = theE.getOffset();
//				int changeEnd = changeStart + theE.getLength();
//				myMessage.updateSourceMessage(newSource, changeStart, changeEnd);
//			}
//
//			public void insertUpdate(DocumentEvent theE) {
//				ourLog.info("Document insert: " + theE);
//				handleChange(theE);
//			}
//			
//			public void changedUpdate(DocumentEvent theE) {
//				ourLog.info("Document change: " + theE);
//				handleChange(theE);				
//			}
//		};
//		myMessageEditor.getDocument().addDocumentListener(myDocumentListener);
//		
//		myMessageEditor.addCaretListener(new CaretListener() {
//			
//			public void caretUpdate(CaretEvent theE) {
//				myMessage.setHighlitedRange(new Range(theE.getDot(), theE.getMark()));
//			}
//		});
//		
//		myShowEmptyCheckBox.setSelected(myTreePanel.isShowEmpty());
//	}
//
//	public void destroy() {
//		myMessage.removePropertyChangeListener(Hl7V2MessageCollection.SOURCE_MESSAGE_PROPERTY, myMessageListeneer);
//		myHighlighter.destroy();
//		myMessage.removePropertyChangeListener(Hl7V2MessageCollection.PROP_HIGHLITED_RANGE, myRangeListener);
//		myTreePanel.destroy();
//	}
//
//	/**
//	 * @param theMessage
//	 *            the message to set
//	 */
//	public void setMessage(Hl7V2MessageCollection theMessage) {
//		Validate.isTrue(myMessage == null);
//
//		myMessage = theMessage;
//
//		updateEncodingButtons();
//		myRdbtnEr7.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent theE) {
//				myMessage.setEncoding(Hl7V2EncodingTypeEnum.ER_7);
//			}
//		});
//		myRdbtnXml.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent theE) {
//				myMessage.setEncoding(Hl7V2EncodingTypeEnum.XML);
//			}
//		});
//
//		updateMessageEditor();
//		myMessageListeneer = new PropertyChangeListener() {
//			public void propertyChange(PropertyChangeEvent theEvt) {
//				updateMessageEditor();
//			}
//		};
//		myMessage.addPropertyChangeListener(Hl7V2MessageCollection.SOURCE_MESSAGE_PROPERTY, myMessageListeneer);
//
//		myTreePanel.setMessage(myMessage);
//		
//		myHighlighter = new Hl7V2MessageEditorHighlighter(myMessageEditor, myMessage);
//		
//		myRangeListener = new PropertyChangeListener() {
//			
//			public void propertyChange(PropertyChangeEvent theEvt) {
//				if (theEvt.getNewValue() == null) {
//					return;
//				}
//				Range range = (Range)theEvt.getNewValue();
//				myMessageEditor.setCaretPosition(range.getStart());
//			}
//		};
//		myMessage.addPropertyChangeListener(Hl7V2MessageCollection.PROP_HIGHLITED_RANGE, myRangeListener);
//		
//	}
//
//	private void updateEncodingButtons() {
//		switch (myMessage.getEncoding()) {
//		case XML:
//			myRdbtnXml.setSelected(true);
//			myRdbtnEr7.setSelected(false);
//			break;
//		case ER_7:
//			myRdbtnXml.setSelected(false);
//			myRdbtnEr7.setSelected(true);
//		}
//	}
//
//	private void updateMessageEditor() {
//		myMessageEditor.getDocument().removeDocumentListener(myDocumentListener);
//		
//		String sourceMessage = myMessage.getSourceMessage();
//
//		if (myMessage.getEncoding() == Hl7V2EncodingTypeEnum.XML) {
//			myMessageEditor.setContentType("text/xml");
//		} else {
//			myMessageEditor.setContentType("text/er7");
//			sourceMessage = sourceMessage.replace('\r', '\n');
//		}
//
//		myMessageEditor.setText(sourceMessage);
//
//		myMessageEditor.getDocument().addDocumentListener(myDocumentListener);
//	}
//
}
