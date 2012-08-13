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

import static org.apache.commons.lang.StringUtils.*;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import javax.swing.event.DocumentEvent;

import org.apache.commons.lang.StringUtils;

import ca.uhn.hl7v2.testpanel.controller.Controller;
import ca.uhn.hl7v2.testpanel.controller.Prefs;
import ca.uhn.hl7v2.testpanel.model.conn.AbstractConnection;
import ca.uhn.hl7v2.testpanel.model.conn.AbstractConnection.StatusEnum;
import ca.uhn.hl7v2.testpanel.model.conn.OutboundConnection;
import ca.uhn.hl7v2.testpanel.model.conn.TransportStyleEnum;
import ca.uhn.hl7v2.testpanel.ui.IDestroyable;
import ca.uhn.hl7v2.testpanel.util.SimpleDocumentListener;
import ca.uhn.hl7v2.testpanel.xsd.Hl7V2EncodingTypeEnum;

public class Hl7ConnectionPanelBackup extends JPanel implements IDestroyable {
	private static final Color ERROR_BG = new Color(1.0f, 0.8f, 0.8f);
	private static final String IFACE_TYPE_CARD_HOH = "hohCard";
	private static final String IFACE_TYPE_CARD_MLLP = "name_1344598061103376000";

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(Hl7ConnectionPanelBackup.class);
	private final ButtonGroup charsetButtonGroup = new ButtonGroup();
	private final ButtonGroup encodingButtonGroup = new ButtonGroup();
	private JCheckBox myCaptureByteStreamCheckbox;
	private JComboBox myCharsetCombo;
	private JRadioButton myCharsetDetectRadio;
	private JRadioButton myCharsetSelectRadio;
	private AbstractConnection myConnection;
	private Controller myController;
	private JTextField myDualIncomingTextBox;
	private JTextField myDualOutgoingTextBox;
	private JRadioButton myDualPortRadio;
	private JRadioButton myEr7Radio;
	private JRadioButton myHl7OverHttpRadioButton;
	private JPanel myHoHCard;
	private JTextField myHohSecurityKeyPwTextBox;
	private boolean myHohSecurityKeystoreCheckIsScheduled;
	private JButton myHohSecurityKeystoreChooseBtn;
	private JTextField myHohSecurityKeystoreTextbox;
	private JLabel myHohSecurityProfileKeystoreStatus;
	private JCheckBox myHohTlsCheckbox;
	private JTextField myHoHUrlTextField;
	private boolean myHohUrlTextFieldUpdating;
	private JTextField myHostBox;
	private JPanel myInterfaceTypeCardPanel;
	private JLabel mylabel;
	private JLabel mylabel_1;
	private JLabel mylabel_2;
	private JLabel mylabel_3;
	private JLabel mylabel_4;
	private JPanel myMllpCard;
	private JPanel mypanel;
	private JPanel mypanel_1;
	private final ButtonGroup myPortButtonGroup = new ButtonGroup();
	private JRadioButton mySinglePortRadio;
	private JTextField mySinglePortTextBox;
	private PropertyChangeListener myStatusLinePropertyChangeListener;
	private PropertyChangeListener myStatusPropertyChangeListener;
	private JCheckBox myTlsCheckbox;
	private JRadioButton myXmlRadio;

	private JPanel securityProfilePanel;

	private JPanel tlsKeystorePanel;
	private JLabel mylabel_5;
	private JPanel mypanel_2;
	private JLabel mylabel_6;
	private JPanel hohAuthPanel;
	private JCheckBox myHohAuthEnabledCheckbox;
	private JLabel mylabel_7;
	private JTextField myHohAuthUsernameTextbox;
	private JLabel mylabel_8;
	private JTextField myHohAuthPasswordTextbox;

	/**
	 * Create the panel.
	 */
	public Hl7ConnectionPanelBackup(Controller theController) {
		myController = theController;

		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 150, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		mySinglePortRadio = new JRadioButton("Single Port MLLP");
		mySinglePortRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePortsModel();
				updatePortsUi();
			}
		});
		myPortButtonGroup.add(mySinglePortRadio);
		GridBagConstraints gbc_SinglePortRadio = new GridBagConstraints();
		gbc_SinglePortRadio.anchor = GridBagConstraints.WEST;
		gbc_SinglePortRadio.insets = new Insets(0, 0, 5, 5);
		gbc_SinglePortRadio.gridx = 0;
		gbc_SinglePortRadio.gridy = 0;
		add(mySinglePortRadio, gbc_SinglePortRadio);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 0;
		add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_4.rowHeights = new int[] { 0, 0 };
		gbl_panel_4.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
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

		mylabel = new JLabel("Port");
		mylabel.setHorizontalAlignment(SwingConstants.CENTER);
		mylabel.setPreferredSize(new Dimension(60, 16));
		mylabel.setMinimumSize(new Dimension(60, 16));
		mylabel.setMaximumSize(new Dimension(60, 16));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel_4.add(mylabel, gbc_label);
		GridBagConstraints gbc_SinglePortTextBox = new GridBagConstraints();
		gbc_SinglePortTextBox.insets = new Insets(0, 5, 0, 0);
		gbc_SinglePortTextBox.anchor = GridBagConstraints.WEST;
		gbc_SinglePortTextBox.gridx = 1;
		gbc_SinglePortTextBox.gridy = 0;
		panel_4.add(mySinglePortTextBox, gbc_SinglePortTextBox);
		mySinglePortTextBox.setMinimumSize(new Dimension(100, 28));
		mySinglePortTextBox.setMaximumSize(new Dimension(100, 2147483647));
		mySinglePortTextBox.setColumns(10);

		myDualPortRadio = new JRadioButton("Dual Port MLLP");
		myDualPortRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePortsModel();
				updatePortsUi();
			}
		});
		myPortButtonGroup.add(myDualPortRadio);
		GridBagConstraints gbc_DualPortRadio = new GridBagConstraints();
		gbc_DualPortRadio.anchor = GridBagConstraints.WEST;
		gbc_DualPortRadio.insets = new Insets(0, 0, 5, 5);
		gbc_DualPortRadio.gridx = 0;
		gbc_DualPortRadio.gridy = 1;
		add(myDualPortRadio, gbc_DualPortRadio);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_BottomPanel = new GridBagConstraints();
		gbc_BottomPanel.insets = new Insets(0, 0, 5, 0);
		gbc_BottomPanel.fill = GridBagConstraints.BOTH;
		gbc_BottomPanel.gridx = 1;
		gbc_BottomPanel.gridy = 1;
		add(panel, gbc_BottomPanel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblInbound = new JLabel("Inbound");
		lblInbound.setHorizontalAlignment(SwingConstants.CENTER);
		lblInbound.setPreferredSize(new Dimension(60, 16));
		lblInbound.setMinimumSize(new Dimension(60, 16));
		lblInbound.setMaximumSize(new Dimension(60, 16));
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
		gbc_DualOutgoingTextBox.insets = new Insets(0, 0, 0, 5);
		gbc_DualOutgoingTextBox.anchor = GridBagConstraints.WEST;
		gbc_DualOutgoingTextBox.gridx = 3;
		gbc_DualOutgoingTextBox.gridy = 0;
		panel.add(myDualOutgoingTextBox, gbc_DualOutgoingTextBox);
		myDualOutgoingTextBox.setColumns(10);

		myHl7OverHttpRadioButton = new JRadioButton("HL7 over HTTP");
		myHl7OverHttpRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePortsModel();
				updatePortsUi();
			}
		});
		myPortButtonGroup.add(myHl7OverHttpRadioButton);
		GridBagConstraints gbc_Hl7OverHttpRadioButton = new GridBagConstraints();
		gbc_Hl7OverHttpRadioButton.anchor = GridBagConstraints.WEST;
		gbc_Hl7OverHttpRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_Hl7OverHttpRadioButton.gridx = 0;
		gbc_Hl7OverHttpRadioButton.gridy = 2;
		add(myHl7OverHttpRadioButton, gbc_Hl7OverHttpRadioButton);

		mypanel = new JPanel();
		mypanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		add(mypanel, gbc_panel);
		GridBagLayout gbl_panel2 = new GridBagLayout();
		gbl_panel2.columnWidths = new int[] { 0, 0 };
		gbl_panel2.rowHeights = new int[] { 0, 0 };
		gbl_panel2.columnWeights = new double[] { 0.0, 1.0 };
		gbl_panel2.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		mypanel.setLayout(gbl_panel2);

		mylabel_1 = new JLabel("URL");
		mylabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		mylabel_1.setPreferredSize(new Dimension(60, 16));
		mylabel_1.setMinimumSize(new Dimension(60, 16));
		mylabel_1.setMaximumSize(new Dimension(60, 16));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 0, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 0;
		mypanel.add(mylabel_1, gbc_label_1);

		myHoHUrlTextField = new JTextField();
		myHoHUrlTextField.getDocument().addDocumentListener(new SimpleDocumentListener() {
			@Override
			public void update(DocumentEvent theE) {
				if (myHohUrlTextFieldUpdating) {
					return;
				}

				String value = myHoHUrlTextField.getText();
				try {
					URL url = new URL(value);
					boolean tls;
					if (url.getProtocol().equals("http")) {
						tls = false;
					} else if (url.getProtocol().equals("https")) {
						tls = true;
					} else {
						ourLog.info("Unknown protocol: {}", url.getProtocol());
						myHoHUrlTextField.setBackground(ERROR_BG);
						return;
					}

					myConnection.setTls(tls);
					myConnection.setHost(url.getHost());
					myConnection.setIncomingOrSinglePort(url.getPort() != -1 ? url.getPort() : url.getDefaultPort());
					myConnection.setHttpUriPath(url.getPath());

					myHohUrlTextFieldUpdating = true;
					updatePortsUi();
					myHohUrlTextFieldUpdating = false;

					myTlsCheckbox.setSelected(tls);
					myHohTlsCheckbox.setSelected(tls);

					myHoHUrlTextField.setBackground(Color.white);
				} catch (MalformedURLException e) {
					myHoHUrlTextField.setBackground(ERROR_BG);
				}

			}
		});
		GridBagConstraints gbc_HohUsernameTextbox = new GridBagConstraints();
		gbc_HohUsernameTextbox.fill = GridBagConstraints.HORIZONTAL;
		gbc_HohUsernameTextbox.gridx = 1;
		gbc_HohUsernameTextbox.gridy = 0;
		mypanel.add(myHoHUrlTextField, gbc_HohUsernameTextbox);
		myHoHUrlTextField.setColumns(10);

		JLabel lblEncoding = new JLabel("Encoding");
		GridBagConstraints gbc_lblEncoding = new GridBagConstraints();
		gbc_lblEncoding.insets = new Insets(0, 0, 5, 5);
		gbc_lblEncoding.gridx = 0;
		gbc_lblEncoding.gridy = 3;
		add(lblEncoding, gbc_lblEncoding);

		JPanel encodingPanel = new JPanel();
		GridBagConstraints gbc_encodingPanel = new GridBagConstraints();
		gbc_encodingPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_encodingPanel.insets = new Insets(0, 0, 5, 0);
		gbc_encodingPanel.gridx = 1;
		gbc_encodingPanel.gridy = 3;
		add(encodingPanel, gbc_encodingPanel);
		encodingPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagLayout gbl_encodingPanel = new GridBagLayout();
		gbl_encodingPanel.columnWidths = new int[] { 144, 58, 0 };
		gbl_encodingPanel.rowHeights = new int[] { 23, 0 };
		gbl_encodingPanel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_encodingPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		encodingPanel.setLayout(gbl_encodingPanel);

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
		encodingPanel.add(myEr7Radio, gbc_Er7Radio);
		encodingButtonGroup.add(myXmlRadio);
		GridBagConstraints gbc_XmlRadio = new GridBagConstraints();
		gbc_XmlRadio.anchor = GridBagConstraints.NORTHWEST;
		gbc_XmlRadio.gridx = 1;
		gbc_XmlRadio.gridy = 0;
		encodingPanel.add(myXmlRadio, gbc_XmlRadio);

		JLabel lblCharset = new JLabel("Charset");
		GridBagConstraints gbc_lblCharset = new GridBagConstraints();
		gbc_lblCharset.insets = new Insets(0, 0, 5, 5);
		gbc_lblCharset.gridx = 0;
		gbc_lblCharset.gridy = 4;
		add(lblCharset, gbc_lblCharset);

		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 4;
		add(panel_2, gbc_panel_2);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
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
		
		mylabel_5 = new JLabel("Debug");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 5;
		add(mylabel_5, gbc_label_5);
		
		mypanel_2 = new JPanel();
		mypanel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_panel_75 = new GridBagConstraints();
		gbc_panel_75.insets = new Insets(0, 0, 5, 0);
		gbc_panel_75.fill = GridBagConstraints.BOTH;
		gbc_panel_75.gridx = 1;
		gbc_panel_75.gridy = 5;
		add(mypanel_2, gbc_panel_75);
		GridBagLayout gbl_panel_74 = new GridBagLayout();
		gbl_panel_74.columnWidths = new int[]{0, 0};
		gbl_panel_74.rowHeights = new int[]{0, 0};
		gbl_panel_74.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_74.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		mypanel_2.setLayout(gbl_panel_74);
		
				myCaptureByteStreamCheckbox = new JCheckBox("Capture Bytes");
				GridBagConstraints gbc_CaptureByteStreamCheckbox = new GridBagConstraints();
				gbc_CaptureByteStreamCheckbox.gridx = 0;
				gbc_CaptureByteStreamCheckbox.gridy = 0;
				mypanel_2.add(myCaptureByteStreamCheckbox, gbc_CaptureByteStreamCheckbox);
				myCaptureByteStreamCheckbox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						myConnection.setCaptureBytes(myCaptureByteStreamCheckbox.isSelected());
					}
				});
				myCaptureByteStreamCheckbox.setToolTipText("Check this box to capture the transport level communication");

		myInterfaceTypeCardPanel = new JPanel();
		myInterfaceTypeCardPanel.setBorder(null);
		GridBagConstraints gbc_InterfaceTypeCardPanel = new GridBagConstraints();
		gbc_InterfaceTypeCardPanel.gridwidth = 2;
		gbc_InterfaceTypeCardPanel.fill = GridBagConstraints.BOTH;
		gbc_InterfaceTypeCardPanel.gridx = 0;
		gbc_InterfaceTypeCardPanel.gridy = 6;
		add(myInterfaceTypeCardPanel, gbc_InterfaceTypeCardPanel);
		myInterfaceTypeCardPanel.setLayout(new CardLayout(0, 0));

		myMllpCard = new JPanel();
		myMllpCard.setBorder(null);
		myInterfaceTypeCardPanel.add(myMllpCard, IFACE_TYPE_CARD_MLLP);
		GridBagLayout gbl_MllpCard = new GridBagLayout();
		gbl_MllpCard.columnWidths = new int[] { 150, 0, 0 };
		gbl_MllpCard.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_MllpCard.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_MllpCard.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		myMllpCard.setLayout(gbl_MllpCard);

		JLabel lblHost = new JLabel("Host");
		GridBagConstraints gbc_lblHost = new GridBagConstraints();
		gbc_lblHost.insets = new Insets(0, 0, 5, 5);
		gbc_lblHost.gridx = 0;
		gbc_lblHost.gridy = 0;
		myMllpCard.add(lblHost, gbc_lblHost);

		mypanel_1 = new JPanel();
		mypanel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		myMllpCard.add(mypanel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 134, 0 };
		gbl_panel_1.rowHeights = new int[] { 28, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		mypanel_1.setLayout(gbl_panel_1);

		myHostBox = new JTextField();
		GridBagConstraints gbc_HostBox = new GridBagConstraints();
		gbc_HostBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_HostBox.anchor = GridBagConstraints.NORTH;
		gbc_HostBox.gridx = 0;
		gbc_HostBox.gridy = 0;
		mypanel_1.add(myHostBox, gbc_HostBox);
		myHostBox.getDocument().addDocumentListener(new SimpleDocumentListener() {
			@Override
			public void update(DocumentEvent theE) {
				myConnection.setHost(myHostBox.getText());
			}
		});
		myHostBox.setColumns(10);

		JLabel lblTransport = new JLabel("Transport");
		GridBagConstraints gbc_lblTransport = new GridBagConstraints();
		gbc_lblTransport.insets = new Insets(0, 0, 5, 5);
		gbc_lblTransport.gridx = 0;
		gbc_lblTransport.gridy = 1;
		myMllpCard.add(lblTransport, gbc_lblTransport);

		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_hohAuthPanel = new GridBagConstraints();
		gbc_hohAuthPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_hohAuthPanel.insets = new Insets(0, 0, 5, 0);
		gbc_hohAuthPanel.gridx = 1;
		gbc_hohAuthPanel.gridy = 1;
		myMllpCard.add(panel_3, gbc_hohAuthPanel);
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagLayout gbl_hohAuthPanel = new GridBagLayout();
		gbl_hohAuthPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_hohAuthPanel.rowHeights = new int[] { 0, 0 };
		gbl_hohAuthPanel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_hohAuthPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_hohAuthPanel);

		myTlsCheckbox = new JCheckBox("Use TLS/SSL");
		myTlsCheckbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myHohTlsCheckbox.setSelected(myTlsCheckbox.isSelected());
				myConnection.setTls(myTlsCheckbox.isSelected());
			}
		});
		GridBagConstraints gbc_TlsCheckbox = new GridBagConstraints();
		gbc_TlsCheckbox.insets = new Insets(0, 0, 0, 5);
		gbc_TlsCheckbox.anchor = GridBagConstraints.WEST;
		gbc_TlsCheckbox.gridx = 0;
		gbc_TlsCheckbox.gridy = 0;
		panel_3.add(myTlsCheckbox, gbc_TlsCheckbox);

		myHoHCard = new JPanel();
		myInterfaceTypeCardPanel.add(myHoHCard, IFACE_TYPE_CARD_HOH);
		GridBagLayout gbl_HoHCard = new GridBagLayout();
		gbl_HoHCard.columnWidths = new int[] { 150, 0, 0 };
		gbl_HoHCard.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_HoHCard.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_HoHCard.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		myHoHCard.setLayout(gbl_HoHCard);
		
		mylabel_6 = new JLabel("Authorization");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 0;
		gbc_label_6.gridy = 0;
		myHoHCard.add(mylabel_6, gbc_label_6);
		
		hohAuthPanel = new JPanel();
		hohAuthPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_hohAuthPanel2 = new GridBagConstraints();
		gbc_hohAuthPanel2.insets = new Insets(0, 0, 5, 0);
		gbc_hohAuthPanel2.fill = GridBagConstraints.BOTH;
		gbc_hohAuthPanel2.gridx = 1;
		gbc_hohAuthPanel2.gridy = 0;
		myHoHCard.add(hohAuthPanel, gbc_hohAuthPanel2);
		GridBagLayout gbl_hohAuthPanel3 = new GridBagLayout();
		gbl_hohAuthPanel3.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_hohAuthPanel3.rowHeights = new int[]{0, 0};
		gbl_hohAuthPanel3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_hohAuthPanel3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		hohAuthPanel.setLayout(gbl_hohAuthPanel3);
		
		myHohAuthEnabledCheckbox = new JCheckBox("Enabled");
		myHohAuthEnabledCheckbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent theE) {
				myConnection.setHohAuthenticationEnabled(myHohAuthEnabledCheckbox.isSelected());
			}
		});
		GridBagConstraints gbc_HohAuthEnabledCheckbox = new GridBagConstraints();
		gbc_HohAuthEnabledCheckbox.insets = new Insets(0, 0, 0, 5);
		gbc_HohAuthEnabledCheckbox.gridx = 0;
		gbc_HohAuthEnabledCheckbox.gridy = 0;
		hohAuthPanel.add(myHohAuthEnabledCheckbox, gbc_HohAuthEnabledCheckbox);
		
		mylabel_7 = new JLabel("Username:");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.insets = new Insets(0, 0, 0, 5);
		gbc_label_7.anchor = GridBagConstraints.EAST;
		gbc_label_7.gridx = 1;
		gbc_label_7.gridy = 0;
		hohAuthPanel.add(mylabel_7, gbc_label_7);
		
		myHohAuthUsernameTextbox = new JTextField();
		myHohAuthUsernameTextbox.getDocument().addDocumentListener(new SimpleDocumentListener() {
			@Override
			public void update(DocumentEvent theE) {
				myConnection.setHohAuthenticationUsername(myHohAuthUsernameTextbox.getText());
			}
		});
		myHohAuthUsernameTextbox.setMaximumSize(new Dimension(200, 2147483647));
		myHohAuthUsernameTextbox.setMinimumSize(new Dimension(100, 28));
		myHohAuthUsernameTextbox.setPreferredSize(new Dimension(100, 28));
		GridBagConstraints gbc_HohUsernameTextbox2 = new GridBagConstraints();
		gbc_HohUsernameTextbox2.insets = new Insets(0, 0, 0, 5);
		gbc_HohUsernameTextbox2.fill = GridBagConstraints.HORIZONTAL;
		gbc_HohUsernameTextbox2.gridx = 2;
		gbc_HohUsernameTextbox2.gridy = 0;
		hohAuthPanel.add(myHohAuthUsernameTextbox, gbc_HohUsernameTextbox2);
		myHohAuthUsernameTextbox.setColumns(10);
		
		mylabel_8 = new JLabel("Password:");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.insets = new Insets(0, 0, 0, 5);
		gbc_label_8.anchor = GridBagConstraints.EAST;
		gbc_label_8.gridx = 3;
		gbc_label_8.gridy = 0;
		hohAuthPanel.add(mylabel_8, gbc_label_8);
		
		myHohAuthPasswordTextbox = new JTextField();
		myHohAuthPasswordTextbox.getDocument().addDocumentListener(new SimpleDocumentListener() {
			@Override
			public void update(DocumentEvent theE) {
				myConnection.setHohAuthenticationPassword(myHohAuthPasswordTextbox.getText());
			}
		});
		myHohAuthPasswordTextbox.setPreferredSize(new Dimension(100, 28));
		myHohAuthPasswordTextbox.setMaximumSize(new Dimension(200, 2147483647));
		myHohAuthPasswordTextbox.setMinimumSize(new Dimension(100, 28));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 0;
		hohAuthPanel.add(myHohAuthPasswordTextbox, gbc_textField);
		myHohAuthPasswordTextbox.setColumns(10);

		mylabel_2 = new JLabel("Security Profile");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 1;
		myHoHCard.add(mylabel_2, gbc_label_2);

		securityProfilePanel = new JPanel();
		GridBagConstraints gbc_securityProfilePanel = new GridBagConstraints();
		gbc_securityProfilePanel.insets = new Insets(0, 0, 5, 0);
		gbc_securityProfilePanel.fill = GridBagConstraints.BOTH;
		gbc_securityProfilePanel.gridx = 1;
		gbc_securityProfilePanel.gridy = 1;
		myHoHCard.add(securityProfilePanel, gbc_securityProfilePanel);
		securityProfilePanel.setLayout(new BorderLayout(0, 0));

		myHohTlsCheckbox = new JCheckBox("TLS Enabled");
		myHohTlsCheckbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myConnection.setTls(myHohTlsCheckbox.isSelected());
				myTlsCheckbox.setSelected(myHohTlsCheckbox.isSelected());
				updatePortsUi();
			}
		});
		securityProfilePanel.add(myHohTlsCheckbox, BorderLayout.WEST);

		tlsKeystorePanel = new JPanel();
		tlsKeystorePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		securityProfilePanel.add(tlsKeystorePanel, BorderLayout.CENTER);
		GridBagLayout gbl_tlsKeystorePanel = new GridBagLayout();
		gbl_tlsKeystorePanel.columnWidths = new int[] { 58, 107, 77, 0, 0 };
		gbl_tlsKeystorePanel.rowHeights = new int[] { 28, 16, 0 };
		gbl_tlsKeystorePanel.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_tlsKeystorePanel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		tlsKeystorePanel.setLayout(gbl_tlsKeystorePanel);

		mylabel_3 = new JLabel("Keystore:");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.WEST;
		gbc_label_3.fill = GridBagConstraints.VERTICAL;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 0;
		tlsKeystorePanel.add(mylabel_3, gbc_label_3);

		myHohSecurityKeystoreTextbox = new JTextField();
		GridBagConstraints gbc_HohKeystoreTextbox = new GridBagConstraints();
		gbc_HohKeystoreTextbox.gridwidth = 2;
		gbc_HohKeystoreTextbox.anchor = GridBagConstraints.NORTH;
		gbc_HohKeystoreTextbox.fill = GridBagConstraints.HORIZONTAL;
		gbc_HohKeystoreTextbox.insets = new Insets(0, 0, 5, 5);
		gbc_HohKeystoreTextbox.gridx = 1;
		gbc_HohKeystoreTextbox.gridy = 0;
		tlsKeystorePanel.add(myHohSecurityKeystoreTextbox, gbc_HohKeystoreTextbox);
		myHohSecurityKeystoreTextbox.setColumns(10);
		myHohSecurityKeystoreTextbox.getDocument().addDocumentListener(new SimpleDocumentListener() {
			@Override
			public void update(DocumentEvent theE) {
				String text = myHohSecurityKeystoreTextbox.getText();
				myHohSecurityKeyPwTextBox.setEnabled(isNotBlank(text));
				myConnection.setTlsKeystoreLocation(text);
				scheduleHohSecurityKeystoreCheck();
			}
		});

		myHohSecurityKeystoreChooseBtn = new JButton("Choose");
		myHohSecurityKeystoreChooseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String directory = Prefs.getInterfaceHohSecurityKeystoreDirectory();
				directory = StringUtils.defaultString(directory, ".");
				JFileChooser chooser = new JFileChooser(directory);
				chooser.setDialogType(JFileChooser.OPEN_DIALOG);
				chooser.setDialogTitle("Select a Java Keystore");
				int result = chooser.showOpenDialog(Hl7ConnectionPanelBackup.this);
				if (result == JFileChooser.APPROVE_OPTION) {
					Prefs.setInterfaceHohSecurityKeystoreDirectory(chooser.getSelectedFile().getParent());
					myHohSecurityKeystoreTextbox.setText(chooser.getSelectedFile().getAbsolutePath());
				}
			}
		});
		myHohSecurityKeystoreChooseBtn.setIcon(new ImageIcon(Hl7ConnectionPanelBackup.class.getResource("/ca/uhn/hl7v2/testpanel/images/open.png")));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 3;
		gbc_button.gridy = 0;
		tlsKeystorePanel.add(myHohSecurityKeystoreChooseBtn, gbc_button);

		mylabel_4 = new JLabel("Store Pass:");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 0, 5);
		gbc_label_4.anchor = GridBagConstraints.EAST;
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 1;
		tlsKeystorePanel.add(mylabel_4, gbc_label_4);

		myHohSecurityKeyPwTextBox = new JTextField();
		myHohSecurityKeyPwTextBox.getDocument().addDocumentListener(new SimpleDocumentListener() {
			@Override
			public void update(DocumentEvent theE) {
				myConnection.setTlsKeystorePassword(myHohSecurityKeyPwTextBox.getText());
				scheduleHohSecurityKeystoreCheck();
			}
		});
		GridBagConstraints gbc_HohSecurityKeyPwTextBox = new GridBagConstraints();
		gbc_HohSecurityKeyPwTextBox.insets = new Insets(0, 0, 0, 5);
		gbc_HohSecurityKeyPwTextBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_HohSecurityKeyPwTextBox.gridx = 1;
		gbc_HohSecurityKeyPwTextBox.gridy = 1;
		tlsKeystorePanel.add(myHohSecurityKeyPwTextBox, gbc_HohSecurityKeyPwTextBox);
		myHohSecurityKeyPwTextBox.setColumns(10);

		myHohSecurityProfileKeystoreStatus = new JLabel("Value goes here");
		myHohSecurityProfileKeystoreStatus.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_HohSecurityProfileKeystoreStatus = new GridBagConstraints();
		gbc_HohSecurityProfileKeystoreStatus.anchor = GridBagConstraints.NORTH;
		gbc_HohSecurityProfileKeystoreStatus.fill = GridBagConstraints.HORIZONTAL;
		gbc_HohSecurityProfileKeystoreStatus.gridwidth = 2;
		gbc_HohSecurityProfileKeystoreStatus.gridx = 2;
		gbc_HohSecurityProfileKeystoreStatus.gridy = 1;
		tlsKeystorePanel.add(myHohSecurityProfileKeystoreStatus, gbc_HohSecurityProfileKeystoreStatus);

		init();

	}

	public void destroy() {
		myConnection.removePropertyChangeListener(OutboundConnection.STATUS_PROPERTY, myStatusPropertyChangeListener);
		myConnection.removePropertyChangeListener(OutboundConnection.STATUS_LINE_PROPERTY, myStatusLinePropertyChangeListener);
	}

	private void init() {
		List<String> charSets = new ArrayList<String>(Charset.availableCharsets().keySet());
		Collections.sort(charSets);
		ComboBoxModel charsetModel = new DefaultComboBoxModel(charSets.toArray(new String[0]));
		myCharsetCombo.setModel(charsetModel);
	}

	private boolean isChangesAllowed() {
		return myConnection.getStatus() == StatusEnum.STOPPED || myConnection.getStatus() == StatusEnum.FAILED;
	}

	private String portToString(int thePort) {
		if (thePort > 0) {
			return Integer.toString(thePort);
		} else {
			return "";
		}
	}

	private void scheduleHohSecurityKeystoreCheck() {
		myHohSecurityKeystoreCheckIsScheduled = true;
		myController.invokeInBackground(new CheckHohSecurityKeystoreRunnable());
	}

	public void setConnection(AbstractConnection theConnection) {
		myConnection = theConnection;

		myHohSecurityKeyPwTextBox.setText(myConnection.getTlsKeystorePassword());
		myHohSecurityKeystoreTextbox.setText(myConnection.getTlsKeystoreLocation());
		myHohSecurityProfileKeystoreStatus.setText("");

		myCharsetCombo.setSelectedItem(theConnection.getCharSet());

		myTlsCheckbox.setSelected(theConnection.isTls());
		myHohTlsCheckbox.setSelected(theConnection.isTls());
		myCaptureByteStreamCheckbox.setSelected(theConnection.isCaptureBytes());

		myHohAuthEnabledCheckbox.setSelected(myConnection.isHohAuthenticationEnabled());
		myHohAuthUsernameTextbox.setText(myConnection.getHohAuthenticationUsername());
		myHohAuthPasswordTextbox.setText(myConnection.getHohAuthenticationPassword());
		
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
			myConnection.setTransport(TransportStyleEnum.SINGLE_PORT_MLLP);
		} else if (myDualPortRadio.isSelected()) {
			myConnection.setTransport(TransportStyleEnum.DUAL_PORT_MLLP);
		} else {
			myConnection.setTransport(TransportStyleEnum.HL7_OVER_HTTP);
		}
	}

	private void updatePortsUi() {
		boolean changesAllowed = isChangesAllowed();
		CardLayout cl = (CardLayout) myInterfaceTypeCardPanel.getLayout();

		switch (myConnection.getTransport()) {
		case DUAL_PORT_MLLP: {
			mySinglePortRadio.setSelected(false);
			myDualPortRadio.setSelected(true);
			myHl7OverHttpRadioButton.setSelected(false);

			myDualIncomingTextBox.setText(portToString(myConnection.getIncomingOrSinglePort()));
			myDualOutgoingTextBox.setText(portToString(myConnection.getOutgoingPort()));

			mySinglePortTextBox.setEnabled(false);
			myDualIncomingTextBox.setEnabled(true && changesAllowed);
			myDualOutgoingTextBox.setEnabled(true && changesAllowed);
			myHoHUrlTextField.setEnabled(false);
			mySinglePortTextBox.repaint();
			myDualIncomingTextBox.repaint();
			myDualOutgoingTextBox.repaint();

			cl.show(myInterfaceTypeCardPanel, Hl7ConnectionPanelBackup.IFACE_TYPE_CARD_MLLP);
			break;
		}
		case SINGLE_PORT_MLLP: {
			mySinglePortRadio.setSelected(true);
			myDualPortRadio.setSelected(false);
			myHl7OverHttpRadioButton.setSelected(false);

			mySinglePortTextBox.setText(portToString(myConnection.getIncomingOrSinglePort()));

			mySinglePortTextBox.setEnabled(true && changesAllowed);
			myDualIncomingTextBox.setEnabled(false);
			myDualOutgoingTextBox.setEnabled(false);
			myHoHUrlTextField.setEnabled(false);
			mySinglePortTextBox.repaint();
			myDualIncomingTextBox.repaint();
			myDualOutgoingTextBox.repaint();

			cl.show(myInterfaceTypeCardPanel, Hl7ConnectionPanelBackup.IFACE_TYPE_CARD_MLLP);
			break;
		}
		case HL7_OVER_HTTP: {
			mySinglePortTextBox.setEnabled(false);
			myDualIncomingTextBox.setEnabled(false);
			myDualOutgoingTextBox.setEnabled(false);
			mySinglePortRadio.setSelected(false);
			myDualPortRadio.setSelected(false);
			myHl7OverHttpRadioButton.setSelected(true);

			cl.show(myInterfaceTypeCardPanel, Hl7ConnectionPanelBackup.IFACE_TYPE_CARD_HOH);

			StringBuilder urlBuilder = new StringBuilder();
			urlBuilder.append((myConnection.isTls() ? "https://" : "http://"));
			urlBuilder.append(StringUtils.defaultString(myConnection.getHost(), "localhost"));
			urlBuilder.append(":").append(myConnection.getIncomingOrSinglePort());
			urlBuilder.append(StringUtils.defaultString(myConnection.getHttpUriPath(), "/"));
			String url = urlBuilder.toString();
			if (!myHohUrlTextFieldUpdating) {
				myHohUrlTextFieldUpdating = true;
				myHoHUrlTextField.setText(url);
				myHohUrlTextFieldUpdating = false;
			}

			myHoHUrlTextField.setEnabled(true && changesAllowed);

			break;
		}
		}
	}

	private void updateStatus() {
		boolean changesAllowed = isChangesAllowed();
		myHostBox.setEnabled(changesAllowed);

		updatePortsUi();

		mySinglePortRadio.setEnabled(changesAllowed);
		myDualPortRadio.setEnabled(changesAllowed);
		myHl7OverHttpRadioButton.setEnabled(changesAllowed);
		myCharsetCombo.setEnabled(changesAllowed);
		myCharsetDetectRadio.setEnabled(changesAllowed);
		myCharsetSelectRadio.setEnabled(changesAllowed);
		myEr7Radio.setEnabled(changesAllowed);
		myTlsCheckbox.setEnabled(changesAllowed);
		myHohTlsCheckbox.setEnabled(changesAllowed);
		myXmlRadio.setEnabled(changesAllowed);
		myCaptureByteStreamCheckbox.setEnabled(changesAllowed);

	}

	private final class CheckHohSecurityKeystoreRunnable implements Runnable {
		@Override
		public void run() {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// wait a bit
			}

			if (!myHohSecurityKeystoreCheckIsScheduled) {
				return;
			}
			myHohSecurityKeystoreCheckIsScheduled = false;

			KeyStore keystore;
			try {
				keystore = myConnection.getTlsKeystore();
				if (keystore == null) {
					myHohSecurityProfileKeystoreStatus.setText("Using system keystore");
				} else {
					myHohSecurityProfileKeystoreStatus.setText("Keystore appears good");
				}
			} catch (KeyStoreException e) {
				ourLog.error("Keystore problem", e);
				myHohSecurityProfileKeystoreStatus.setText("<html>" + e.getMessage() + "</html>");
			}
		}
	}

}
