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

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import javax.swing.event.DocumentEvent;

import org.apache.commons.lang.StringUtils;

import ca.uhn.hl7v2.testpanel.model.AbstractConnection;
import ca.uhn.hl7v2.testpanel.model.AbstractConnection.StatusEnum;
import ca.uhn.hl7v2.testpanel.model.OutboundConnection;
import ca.uhn.hl7v2.testpanel.util.SimpleDocumentListener;
import ca.uhn.hl7v2.testpanel.xsd.Hl7V2EncodingTypeEnum;

public class Hl7ConnectionPanel extends JPanel implements IDestroyable {
	private JTextField myHostBox;
	private JTextField mySinglePortTextBox;
	private JTextField myDualIncomingTextBox;
	private JTextField myDualOutgoingTextBox;
	private final ButtonGroup encodingButtonGroup = new ButtonGroup();
	private final ButtonGroup charsetButtonGroup = new ButtonGroup();
	private final ButtonGroup portButtonGroup = new ButtonGroup();
	private JRadioButton mySinglePortRadio;
	private JRadioButton myDualPortRadio;
	private JCheckBox myTlsCheckbox;
	private JRadioButton myEr7Radio;
	private JRadioButton myXmlRadio;
	private JRadioButton myCharsetSelectRadio;
	private JComboBox myCharsetCombo;
	private JRadioButton myCharsetDetectRadio;
	private AbstractConnection myConnection;
	private PropertyChangeListener myStatusPropertyChangeListener;
	private PropertyChangeListener myStatusLinePropertyChangeListener;
	private JCheckBox myCaptureByteStreamCheckbox;


	public void setConnection(AbstractConnection theConnection) {
		myConnection = theConnection;

		myCharsetCombo.setSelectedItem(theConnection.getCharSet());

		myTlsCheckbox.setSelected(theConnection.isTls());
		myCaptureByteStreamCheckbox.setSelected(theConnection.isCaptureBytes());

		updateCharset();

		Hl7V2EncodingTypeEnum encoding = theConnection.getEncoding();
		myEr7Radio.setSelected(encoding == Hl7V2EncodingTypeEnum.ER_7);
		myXmlRadio.setSelected(encoding == Hl7V2EncodingTypeEnum.XML);
		myHostBox.setText(theConnection.getHost());

		updatePortsUi();

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
		
	}

	private void updateStatus() {
		boolean changesAllowed = isChangesAllowed();
		myHostBox.setEnabled(changesAllowed);

		updatePortsUi();

		mySinglePortRadio.setEnabled(changesAllowed);
		myDualPortRadio.setEnabled(changesAllowed);
		myCharsetCombo.setEnabled(changesAllowed);
		myCharsetDetectRadio.setEnabled(changesAllowed);
		myCharsetSelectRadio.setEnabled(changesAllowed);
		myEr7Radio.setEnabled(changesAllowed);
		myTlsCheckbox.setEnabled(changesAllowed);
		myXmlRadio.setEnabled(changesAllowed);
		myCaptureByteStreamCheckbox.setEnabled(changesAllowed);

	}

	private boolean isChangesAllowed() {
		return myConnection.getStatus() == StatusEnum.STOPPED || myConnection.getStatus() == StatusEnum.FAILED;
	}

	private void updatePortsUi() {
		boolean changesAllowed = isChangesAllowed();

		if (myConnection.isDualPort()) {

			mySinglePortRadio.setSelected(false);
			myDualPortRadio.setSelected(true);

			myDualIncomingTextBox.setText(portToString(myConnection.getIncomingOrSinglePort()));
			myDualOutgoingTextBox.setText(portToString(myConnection.getOutgoingPort()));

			mySinglePortTextBox.setEnabled(false);
			myDualIncomingTextBox.setEnabled(true && changesAllowed);
			myDualOutgoingTextBox.setEnabled(true && changesAllowed);
			mySinglePortTextBox.repaint();
			myDualIncomingTextBox.repaint();
			myDualOutgoingTextBox.repaint();

		} else {

			mySinglePortRadio.setSelected(true);
			myDualPortRadio.setSelected(false);

			mySinglePortTextBox.setText(portToString(myConnection.getIncomingOrSinglePort()));

			mySinglePortTextBox.setEnabled(true && changesAllowed);
			myDualIncomingTextBox.setEnabled(false);
			myDualOutgoingTextBox.setEnabled(false);
			mySinglePortTextBox.repaint();
			myDualIncomingTextBox.repaint();
			myDualOutgoingTextBox.repaint();

		}
	}
	
	private String portToString(int thePort) {
		if (thePort > 0) {
			return Integer.toString(thePort);
		} else {
			return "";
		}
	}

	private void updateCharset() {
		if (myConnection.isDetectCharSetInMessage()) {
			myCharsetDetectRadio.setSelected(true);
			myCharsetSelectRadio.setSelected(false);
			myCharsetCombo.setEnabled(false);
		} else {
			myCharsetDetectRadio.setSelected(false);
			myCharsetSelectRadio.setSelected(true);
			myCharsetCombo.setEnabled(true);
		}
	}

	/**
	 * Create the panel.
	 */
	public Hl7ConnectionPanel() {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 138, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblHost = new JLabel("Host");
		GridBagConstraints gbc_lblHost = new GridBagConstraints();
		gbc_lblHost.anchor = GridBagConstraints.WEST;
		gbc_lblHost.insets = new Insets(0, 5, 5, 5);
		gbc_lblHost.gridx = 0;
		gbc_lblHost.gridy = 0;
		add(lblHost, gbc_lblHost);

		myHostBox = new JTextField();
		myHostBox.getDocument().addDocumentListener(new SimpleDocumentListener() {
			@Override
			public void update(DocumentEvent theE) {
				myConnection.setHost(myHostBox.getText());
			}
		});
		GridBagConstraints gbc_HostBox = new GridBagConstraints();
		gbc_HostBox.insets = new Insets(0, 0, 5, 0);
		gbc_HostBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_HostBox.gridx = 1;
		gbc_HostBox.gridy = 0;
		add(myHostBox, gbc_HostBox);
		myHostBox.setColumns(10);

		mySinglePortRadio = new JRadioButton("Single Port");
		mySinglePortRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePortsModel();
				updatePortsUi();
			}
		});
		portButtonGroup.add(mySinglePortRadio);
		GridBagConstraints gbc_SinglePortRadio = new GridBagConstraints();
		gbc_SinglePortRadio.anchor = GridBagConstraints.WEST;
		gbc_SinglePortRadio.insets = new Insets(0, 0, 5, 5);
		gbc_SinglePortRadio.gridx = 0;
		gbc_SinglePortRadio.gridy = 1;
		add(mySinglePortRadio, gbc_SinglePortRadio);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 1;
		add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 0, 0 };
		gbl_panel_4.rowHeights = new int[] { 0, 0 };
		gbl_panel_4.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		mySinglePortTextBox = new JTextField();
		mySinglePortTextBox.getDocument().addDocumentListener(new SimpleDocumentListener() {
			@Override
			public void update(DocumentEvent theE) {
				String text = mySinglePortTextBox.getText();
				text = text.replaceAll("[^0-9]+", "");
				if (!StringUtils.equals(mySinglePortTextBox.getText(), text)) {
					final String newVal = text;
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							mySinglePortTextBox.setText(newVal);
						}
					});
				}
				if (mySinglePortRadio.isSelected()) {
					if (text.length() > 0) {
						myConnection.setIncomingOrSinglePort(Integer.parseInt(text));
					} else {
						myConnection.setIncomingOrSinglePort(-1);
					}
				}
			}
		});
		GridBagConstraints gbc_SinglePortTextBox = new GridBagConstraints();
		gbc_SinglePortTextBox.insets = new Insets(0, 5, 0, 0);
		gbc_SinglePortTextBox.anchor = GridBagConstraints.WEST;
		gbc_SinglePortTextBox.gridx = 0;
		gbc_SinglePortTextBox.gridy = 0;
		panel_4.add(mySinglePortTextBox, gbc_SinglePortTextBox);
		mySinglePortTextBox.setMinimumSize(new Dimension(100, 28));
		mySinglePortTextBox.setMaximumSize(new Dimension(100, 2147483647));
		mySinglePortTextBox.setColumns(10);

		myDualPortRadio = new JRadioButton("Dual Port");
		myDualPortRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePortsModel();
				updatePortsUi();
			}
		});
		portButtonGroup.add(myDualPortRadio);
		GridBagConstraints gbc_DualPortRadio = new GridBagConstraints();
		gbc_DualPortRadio.anchor = GridBagConstraints.WEST;
		gbc_DualPortRadio.insets = new Insets(0, 0, 5, 5);
		gbc_DualPortRadio.gridx = 0;
		gbc_DualPortRadio.gridy = 2;
		add(myDualPortRadio, gbc_DualPortRadio);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_BottomPanel = new GridBagConstraints();
		gbc_BottomPanel.insets = new Insets(0, 0, 5, 0);
		gbc_BottomPanel.fill = GridBagConstraints.BOTH;
		gbc_BottomPanel.gridx = 1;
		gbc_BottomPanel.gridy = 2;
		add(panel, gbc_BottomPanel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblInbound = new JLabel("Inbound");
		GridBagConstraints gbc_lblInbound = new GridBagConstraints();
		gbc_lblInbound.insets = new Insets(0, 5, 0, 5);
		gbc_lblInbound.anchor = GridBagConstraints.EAST;
		gbc_lblInbound.gridx = 0;
		gbc_lblInbound.gridy = 0;
		panel.add(lblInbound, gbc_lblInbound);

		myDualIncomingTextBox = new JTextField();
		myDualIncomingTextBox.getDocument().addDocumentListener(new SimpleDocumentListener() {
			@Override
			public void update(DocumentEvent theE) {
				String text = myDualIncomingTextBox.getText();
				text = text.replaceAll("[^0-9]+", "");
				if (!StringUtils.equals(myDualIncomingTextBox.getText(), text)) {
					final String newVal = text;
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							myDualIncomingTextBox.setText(newVal);
						}
					});
				}
				if (myDualPortRadio.isSelected()) {
					if (text.length() > 0) {
						myConnection.setIncomingOrSinglePort(Integer.parseInt(text));
					} else {
						myConnection.setIncomingOrSinglePort(-1);
					}
				}
			}
		});
		myDualIncomingTextBox.setMaximumSize(new Dimension(100, 2147483647));
		myDualIncomingTextBox.setMinimumSize(new Dimension(100, 28));
		GridBagConstraints gbc_DualIncomingTextBox = new GridBagConstraints();
		gbc_DualIncomingTextBox.anchor = GridBagConstraints.WEST;
		gbc_DualIncomingTextBox.insets = new Insets(0, 0, 0, 5);
		gbc_DualIncomingTextBox.gridx = 1;
		gbc_DualIncomingTextBox.gridy = 0;
		panel.add(myDualIncomingTextBox, gbc_DualIncomingTextBox);
		myDualIncomingTextBox.setColumns(10);

		JLabel lblOutbound = new JLabel("Outbound");
		GridBagConstraints gbc_lblOutbound = new GridBagConstraints();
		gbc_lblOutbound.anchor = GridBagConstraints.EAST;
		gbc_lblOutbound.insets = new Insets(0, 0, 0, 5);
		gbc_lblOutbound.gridx = 2;
		gbc_lblOutbound.gridy = 0;
		panel.add(lblOutbound, gbc_lblOutbound);

		myDualOutgoingTextBox = new JTextField();
		myDualOutgoingTextBox.getDocument().addDocumentListener(new SimpleDocumentListener() {
			@Override
			public void update(DocumentEvent theE) {
				String text = myDualOutgoingTextBox.getText();
				text = text.replaceAll("[^0-9]+", "");
				if (!StringUtils.equals(myDualOutgoingTextBox.getText(), text)) {
					final String newVal = text;
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							myDualOutgoingTextBox.setText(newVal);
						}
					});
				}
				if (myDualPortRadio.isSelected()) {
					if (text.length() > 0) {
						myConnection.setOutgoingPort(Integer.parseInt(text));
					} else {
						myConnection.setOutgoingPort(-1);
					}
				}
			}
		});
		myDualOutgoingTextBox.setMinimumSize(new Dimension(100, 28));
		myDualOutgoingTextBox.setMaximumSize(new Dimension(100, 2147483647));
		GridBagConstraints gbc_DualOutgoingTextBox = new GridBagConstraints();
		gbc_DualOutgoingTextBox.anchor = GridBagConstraints.WEST;
		gbc_DualOutgoingTextBox.gridx = 3;
		gbc_DualOutgoingTextBox.gridy = 0;
		panel.add(myDualOutgoingTextBox, gbc_DualOutgoingTextBox);
		myDualOutgoingTextBox.setColumns(10);

		JLabel lblTransport = new JLabel("Transport");
		GridBagConstraints gbc_lblTransport = new GridBagConstraints();
		gbc_lblTransport.anchor = GridBagConstraints.WEST;
		gbc_lblTransport.insets = new Insets(0, 5, 5, 5);
		gbc_lblTransport.gridx = 0;
		gbc_lblTransport.gridy = 3;
		add(lblTransport, gbc_lblTransport);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 3;
		add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_3.rowHeights = new int[] { 0, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		myTlsCheckbox = new JCheckBox("Use TLS/SSL");
		myTlsCheckbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myConnection.setTls(myTlsCheckbox.isSelected());
			}
		});
		GridBagConstraints gbc_TlsCheckbox = new GridBagConstraints();
		gbc_TlsCheckbox.insets = new Insets(0, 0, 0, 5);
		gbc_TlsCheckbox.anchor = GridBagConstraints.WEST;
		gbc_TlsCheckbox.gridx = 0;
		gbc_TlsCheckbox.gridy = 0;
		panel_3.add(myTlsCheckbox, gbc_TlsCheckbox);
		
		myCaptureByteStreamCheckbox = new JCheckBox("Capture Bytes");
		myCaptureByteStreamCheckbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myConnection.setCaptureBytes(myCaptureByteStreamCheckbox.isSelected());
			}
		});
		myCaptureByteStreamCheckbox.setToolTipText("Check this box to capture the transport level communication");
		GridBagConstraints gbc_CaptureByteStreamCheckbox = new GridBagConstraints();
		gbc_CaptureByteStreamCheckbox.gridx = 1;
		gbc_CaptureByteStreamCheckbox.gridy = 0;
		panel_3.add(myCaptureByteStreamCheckbox, gbc_CaptureByteStreamCheckbox);

		JLabel lblEncoding = new JLabel("Encoding");
		GridBagConstraints gbc_lblEncoding = new GridBagConstraints();
		gbc_lblEncoding.anchor = GridBagConstraints.WEST;
		gbc_lblEncoding.insets = new Insets(0, 5, 5, 5);
		gbc_lblEncoding.gridx = 0;
		gbc_lblEncoding.gridy = 4;
		add(lblEncoding, gbc_lblEncoding);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 4;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 144, 58, 0 };
		gbl_panel_1.rowHeights = new int[] { 23, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		myXmlRadio = new JRadioButton("XML");
		myXmlRadio.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent theE) {
				updateEncodingModel();
			}
		});

		myEr7Radio = new JRadioButton("ER7 (Pipe and hat)");
		myEr7Radio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateEncodingModel();
			}
		});
		encodingButtonGroup.add(myEr7Radio);
		GridBagConstraints gbc_Er7Radio = new GridBagConstraints();
		gbc_Er7Radio.anchor = GridBagConstraints.NORTHWEST;
		gbc_Er7Radio.insets = new Insets(0, 0, 0, 5);
		gbc_Er7Radio.gridx = 0;
		gbc_Er7Radio.gridy = 0;
		panel_1.add(myEr7Radio, gbc_Er7Radio);
		encodingButtonGroup.add(myXmlRadio);
		GridBagConstraints gbc_XmlRadio = new GridBagConstraints();
		gbc_XmlRadio.anchor = GridBagConstraints.NORTHWEST;
		gbc_XmlRadio.gridx = 1;
		gbc_XmlRadio.gridy = 0;
		panel_1.add(myXmlRadio, gbc_XmlRadio);

		JLabel lblCharset = new JLabel("Charset");
		GridBagConstraints gbc_lblCharset = new GridBagConstraints();
		gbc_lblCharset.anchor = GridBagConstraints.WEST;
		gbc_lblCharset.insets = new Insets(0, 5, 5, 5);
		gbc_lblCharset.gridx = 0;
		gbc_lblCharset.gridy = 5;
		add(lblCharset, gbc_lblCharset);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 5;
		add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 28, 198, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 27, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		myCharsetSelectRadio = new JRadioButton("");
		myCharsetSelectRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateCharsetModel();
			}
		});
		charsetButtonGroup.add(myCharsetSelectRadio);
		GridBagConstraints gbc_CharsetSelectRadio = new GridBagConstraints();
		gbc_CharsetSelectRadio.anchor = GridBagConstraints.WEST;
		gbc_CharsetSelectRadio.insets = new Insets(0, 0, 0, 5);
		gbc_CharsetSelectRadio.gridx = 0;
		gbc_CharsetSelectRadio.gridy = 0;
		panel_2.add(myCharsetSelectRadio, gbc_CharsetSelectRadio);

		myCharsetCombo = new JComboBox();
		myCharsetCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateCharsetModel();
			}
		});
		GridBagConstraints gbc_CharsetCombo = new GridBagConstraints();
		gbc_CharsetCombo.anchor = GridBagConstraints.NORTHWEST;
		gbc_CharsetCombo.insets = new Insets(0, 0, 0, 5);
		gbc_CharsetCombo.gridx = 1;
		gbc_CharsetCombo.gridy = 0;
		panel_2.add(myCharsetCombo, gbc_CharsetCombo);

		myCharsetDetectRadio = new JRadioButton("Detect in Message (MSH-18)");
		myCharsetDetectRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateCharsetModel();
			}
		});
		charsetButtonGroup.add(myCharsetDetectRadio);
		GridBagConstraints gbc_CharsetDetectRadio = new GridBagConstraints();
		gbc_CharsetDetectRadio.anchor = GridBagConstraints.NORTH;
		gbc_CharsetDetectRadio.gridwidth = 2;
		gbc_CharsetDetectRadio.gridx = 2;
		gbc_CharsetDetectRadio.gridy = 0;
		panel_2.add(myCharsetDetectRadio, gbc_CharsetDetectRadio);

		init();

	}

	private void init() {
		List<String> charSets = new ArrayList<String>(Charset.availableCharsets().keySet());
		Collections.sort(charSets);
		ComboBoxModel charsetModel = new DefaultComboBoxModel(charSets.toArray(new String[0]));
		myCharsetCombo.setModel(charsetModel);
	}

	private void updateCharsetModel() {
		if (myCharsetDetectRadio.isSelected()) {
			myConnection.setDetectCharSetInMessage(true);
		} else {
			myConnection.setDetectCharSetInMessage(false);
			myConnection.setCharSet((String) myCharsetCombo.getSelectedItem());
		}
	}

	private void updateEncodingModel() {
		if (myEr7Radio.isSelected()) {
			myConnection.setEncoding(Hl7V2EncodingTypeEnum.ER_7);
		} else {
			myConnection.setEncoding(Hl7V2EncodingTypeEnum.XML);
		}
	}

	private void updatePortsModel() {
		if (mySinglePortRadio.isSelected()) {
			myConnection.setDualPort(false);
		} else {
			myConnection.setDualPort(true);
		}
	}

	public void destroy() {
		myConnection.removePropertyChangeListener(OutboundConnection.STATUS_PROPERTY, myStatusPropertyChangeListener);
		myConnection.removePropertyChangeListener(OutboundConnection.STATUS_LINE_PROPERTY, myStatusLinePropertyChangeListener);
	}

}
