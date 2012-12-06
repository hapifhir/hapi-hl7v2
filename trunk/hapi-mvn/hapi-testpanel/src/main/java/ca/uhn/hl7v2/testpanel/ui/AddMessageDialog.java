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
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.testpanel.controller.Controller;
import ca.uhn.hl7v2.testpanel.util.EventMapUtil;
import ca.uhn.hl7v2.testpanel.xsd.Hl7V2EncodingTypeEnum;

public class AddMessageDialog extends JDialog {
	private static final Logger ourLog = LoggerFactory.getLogger(AddMessageDialog.class);

	private final JPanel mycontentPanel = new JPanel();
	private JList myVersionList;
	private JList myMessageTypeList;
	private JRadioButton myEr7Radio;
	private final ButtonGroup encodingButtonGroup = new ButtonGroup();
	private String myCurrentSelectedVersion;
	private DefaultListModel myMessageTypeListModel;

	private Controller myController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddMessageDialog dialog = new AddMessageDialog(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddMessageDialog(Controller theController) {
		myController = theController;

		setMinimumSize(new Dimension(450, 400));
		setPreferredSize(new Dimension(450, 400));
		setSize(new Dimension(450, 400));
		setResizable(false);
		setMaximumSize(new Dimension(450, 400));
		setTitle("Add Message");
		setBounds(100, 100, 450, 401);
		getContentPane().setLayout(new BorderLayout());
		mycontentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(mycontentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		mycontentPanel.setLayout(gbl_contentPanel);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Message Type", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.weighty = 1.0;
			gbc_panel.insets = new Insets(0, 0, 5, 0);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 0;
			mycontentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 0, 0, 0 };
			gbl_panel.rowHeights = new int[] { 0, 0, 0 };
			gbl_panel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			{
				JLabel lblVersion = new JLabel("Version");
				GridBagConstraints gbc_lblVersion = new GridBagConstraints();
				gbc_lblVersion.insets = new Insets(0, 0, 5, 5);
				gbc_lblVersion.gridx = 0;
				gbc_lblVersion.gridy = 0;
				panel.add(lblVersion, gbc_lblVersion);
			}
			{
				JLabel lblType = new JLabel("Type");
				GridBagConstraints gbc_lblType = new GridBagConstraints();
				gbc_lblType.insets = new Insets(0, 0, 5, 0);
				gbc_lblType.gridx = 1;
				gbc_lblType.gridy = 0;
				panel.add(lblType, gbc_lblType);
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setViewportBorder(null);
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.weighty = 1.0;
				gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.gridx = 0;
				gbc_scrollPane.gridy = 1;
				panel.add(scrollPane, gbc_scrollPane);
				{
					myVersionList = new JList();
					myVersionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(myVersionList);
				}
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setViewportBorder(null);
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.weighty = 1.0;
				gbc_scrollPane.weightx = 1.0;
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.gridx = 1;
				gbc_scrollPane.gridy = 1;
				panel.add(scrollPane, gbc_scrollPane);
				{
					myMessageTypeList = new JList();
					myMessageTypeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(myMessageTypeList);
				}
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 1;
			mycontentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 0, 0, 0 };
			gbl_panel.rowHeights = new int[] { 0, 0 };
			gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			{
				JLabel lblEncoding = new JLabel("Encoding");
				GridBagConstraints gbc_lblEncoding = new GridBagConstraints();
				gbc_lblEncoding.insets = new Insets(0, 0, 0, 5);
				gbc_lblEncoding.gridx = 0;
				gbc_lblEncoding.gridy = 0;
				panel.add(lblEncoding, gbc_lblEncoding);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(null);
				GridBagConstraints gbc_panel_1 = new GridBagConstraints();
				gbc_panel_1.anchor = GridBagConstraints.WEST;
				gbc_panel_1.fill = GridBagConstraints.VERTICAL;
				gbc_panel_1.gridx = 1;
				gbc_panel_1.gridy = 0;
				panel.add(panel_1, gbc_panel_1);
				{
					myEr7Radio = new JRadioButton("ER7");
					myEr7Radio.setSelected(true);
					encodingButtonGroup.add(myEr7Radio);
					panel_1.add(myEr7Radio);
				}
				{
					JRadioButton myXmlRadio = new JRadioButton("XML");
					encodingButtonGroup.add(myXmlRadio);
					panel_1.add(myXmlRadio);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							String version = (String) myVersionList.getSelectedValue();
							String fullType = (String) myMessageTypeList.getSelectedValue();
							String structure = myTypesToStructures.get(fullType);
							String[] fullTypeBits = fullType.split("\\^");
							String type = fullTypeBits[0];
							String trigger = fullTypeBits[1];
							
							Hl7V2EncodingTypeEnum encoding = myEr7Radio.isSelected() ? Hl7V2EncodingTypeEnum.ER_7 : Hl7V2EncodingTypeEnum.XML;
							myController.addMessage(version, type, trigger, structure, encoding);
						} finally {
							setVisible(false);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						AddMessageDialog.this.setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

		initLocal();
	}

	private void initLocal() {

		DefaultListModel versionListModel = new DefaultListModel();
		myVersionList.setModel(versionListModel);
		for (Version nextVersion : Version.values()) {
			versionListModel.addElement(nextVersion.getVersion());
		}

		myVersionList.setSelectedIndex(versionListModel.getSize() - 1);
		myVersionList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent theE) {
				updateTypes();
			}
		});

		myMessageTypeListModel = new DefaultListModel();
		myMessageTypeList.setModel(myMessageTypeListModel);

		updateTypes();

	}

	private Map<String, String> myTypesToStructures = new HashMap<String, String>();

	private void updateTypes() {
		String newVersion = (String) myVersionList.getSelectedValue();
		if (StringUtils.equals(newVersion, myCurrentSelectedVersion)) {
			return;
		}
		myCurrentSelectedVersion = newVersion;

		Map<String, String> structures;
		try {
			structures = EventMapUtil.getEventMap(myCurrentSelectedVersion);
		} catch (HL7Exception e) {
			ourLog.error("Couldn't load structures", e);
			return;
		}

		ArrayList<String> structureNames = new ArrayList<String>();
		for (Object next : structures.keySet()) {
			String nextType = next.toString();
			String nextStructure = structures.get(nextType);

			nextType = nextType.replace('_', '^');
			structureNames.add(nextType);

			myTypesToStructures.put(nextType, nextStructure);
		}

		Collections.sort(structureNames);

		for (int i = 0; i < structureNames.size(); i++) {
			String next = structureNames.get(i);
			if (myMessageTypeListModel.size() <= i) {
				myMessageTypeListModel.addElement(next);
			} else if (!myMessageTypeListModel.getElementAt(i).equals(next)) {
				myMessageTypeListModel.insertElementAt(next, i);
			}
		}

		while (myMessageTypeListModel.size() > structureNames.size()) {
			myMessageTypeListModel.removeElementAt(myMessageTypeListModel.size() - 1);
		}

		if (myMessageTypeList.getSelectedIndex() == -1) {
			myMessageTypeList.setSelectedIndex(0);
		}
	}

}
