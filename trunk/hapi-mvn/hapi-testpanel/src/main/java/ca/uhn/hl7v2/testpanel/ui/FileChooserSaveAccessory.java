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

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import ca.uhn.hl7v2.testpanel.controller.Prefs;
import ca.uhn.hl7v2.testpanel.util.LineEndingsEnum;

public class FileChooserSaveAccessory extends JPanel {
	private JCheckBox mySaveCommentsCheckbox;
	private JRadioButton myHl7LineEndingsRadio;
	private JRadioButton myUnixLineEndingsRadio;
	private JRadioButton myWindowsLineEndingsRadio;
	private final ButtonGroup myLineEndingsButtonGroup = new ButtonGroup();
	private JLabel mylabel;
	private Component myverticalStrut;
	private JComboBox myCharsetCombo;

	/**
	 * Create the panel.
	 */
	public FileChooserSaveAccessory() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblComments = new JLabel("Comments");
		GridBagConstraints gbc_lblComments = new GridBagConstraints();
		gbc_lblComments.insets = new Insets(0, 0, 5, 5);
		gbc_lblComments.gridx = 0;
		gbc_lblComments.gridy = 0;
		add(lblComments, gbc_lblComments);

		mySaveCommentsCheckbox = new JCheckBox("Strip Comments");
		mySaveCommentsCheckbox.setSelected(Prefs.getSaveStripComments());
		GridBagConstraints gbc_SaveCommentsCheckbox = new GridBagConstraints();
		gbc_SaveCommentsCheckbox.insets = new Insets(0, 0, 5, 0);
		gbc_SaveCommentsCheckbox.anchor = GridBagConstraints.WEST;
		gbc_SaveCommentsCheckbox.gridx = 1;
		gbc_SaveCommentsCheckbox.gridy = 0;
		add(mySaveCommentsCheckbox, gbc_SaveCommentsCheckbox);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 0;
		gbc_verticalStrut.gridy = 1;
		add(verticalStrut, gbc_verticalStrut);

		JLabel lblLineEndings = new JLabel("Line Endings");
		GridBagConstraints gbc_lblLineEndings = new GridBagConstraints();
		gbc_lblLineEndings.insets = new Insets(0, 0, 5, 5);
		gbc_lblLineEndings.gridx = 0;
		gbc_lblLineEndings.gridy = 2;
		add(lblLineEndings, gbc_lblLineEndings);

		myHl7LineEndingsRadio = new JRadioButton("HL7 (ASCII-13)");
		myLineEndingsButtonGroup.add(myHl7LineEndingsRadio);
		GridBagConstraints gbc_Hl7LineEndingsRadio = new GridBagConstraints();
		gbc_Hl7LineEndingsRadio.insets = new Insets(0, 0, 5, 0);
		gbc_Hl7LineEndingsRadio.anchor = GridBagConstraints.WEST;
		gbc_Hl7LineEndingsRadio.gridx = 1;
		gbc_Hl7LineEndingsRadio.gridy = 2;
		add(myHl7LineEndingsRadio, gbc_Hl7LineEndingsRadio);

		myUnixLineEndingsRadio = new JRadioButton("Unix (ASCII-10)");
		myLineEndingsButtonGroup.add(myUnixLineEndingsRadio);
		GridBagConstraints gbc_UnixLineEndingsRadio = new GridBagConstraints();
		gbc_UnixLineEndingsRadio.insets = new Insets(0, 0, 5, 0);
		gbc_UnixLineEndingsRadio.anchor = GridBagConstraints.WEST;
		gbc_UnixLineEndingsRadio.gridx = 1;
		gbc_UnixLineEndingsRadio.gridy = 3;
		add(myUnixLineEndingsRadio, gbc_UnixLineEndingsRadio);

		myWindowsLineEndingsRadio = new JRadioButton("WIndows (ASCII-13,10)");
		myLineEndingsButtonGroup.add(myWindowsLineEndingsRadio);
		GridBagConstraints gbc_WindowsLineEndingsRadio = new GridBagConstraints();
		gbc_WindowsLineEndingsRadio.insets = new Insets(0, 0, 5, 0);
		gbc_WindowsLineEndingsRadio.anchor = GridBagConstraints.WEST;
		gbc_WindowsLineEndingsRadio.gridx = 1;
		gbc_WindowsLineEndingsRadio.gridy = 4;
		add(myWindowsLineEndingsRadio, gbc_WindowsLineEndingsRadio);

		myverticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut2 = new GridBagConstraints();
		gbc_verticalStrut2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut2.gridx = 0;
		gbc_verticalStrut2.gridy = 5;
		add(myverticalStrut, gbc_verticalStrut2);

		mylabel = new JLabel("Charset");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 6;
		add(mylabel, gbc_label);

		myCharsetCombo = new JComboBox();
		myCharsetCombo.setMaximumSize(new Dimension(180, 32767));
		myCharsetCombo.setPreferredSize(new Dimension(180, 27));
		myCharsetCombo.setMinimumSize(new Dimension(180, 27));
		GridBagConstraints gbc_CharsetCombo = new GridBagConstraints();
		gbc_CharsetCombo.anchor = GridBagConstraints.WEST;
		gbc_CharsetCombo.gridx = 1;
		gbc_CharsetCombo.gridy = 6;
		add(myCharsetCombo, gbc_CharsetCombo);

		List<String> charSets = new ArrayList<String>(Charset.availableCharsets().keySet());
		Collections.sort(charSets);
		ComboBoxModel charsetModel = new DefaultComboBoxModel(charSets.toArray(new String[0]));
		myCharsetCombo.setModel(charsetModel);
		Charset openOrSaveCharset = Prefs.getOpenOrSaveCharset();
		myCharsetCombo.setSelectedItem(openOrSaveCharset.name());

		initLocal();
	}

	private void initLocal() {
		LineEndingsEnum lineEndings = Prefs.getSaveLineEndings();
		switch (lineEndings) {
		case HL7:
			myHl7LineEndingsRadio.setSelected(true);
			break;
		case UNIX:
			myUnixLineEndingsRadio.setSelected(true);
			break;
		case WINDOWS:
			myWindowsLineEndingsRadio.setSelected(true);
			break;
		}

	}

	/**
	 * Note: Saves the value as a preference
	 */
	public Charset getSelectedCharset() {
		Charset retVal = Charset.forName((String) myCharsetCombo.getSelectedItem());
		Prefs.setOpenOrSaveCharset(retVal);
		return retVal;
	}

	/**
	 * Note: Saves the value as a preference
	 */
	public LineEndingsEnum getSelectedLineEndings() {
		LineEndingsEnum retVal = LineEndingsEnum.WINDOWS;
		if (myHl7LineEndingsRadio.isSelected()) {
			retVal = LineEndingsEnum.HL7;
		} else if (myUnixLineEndingsRadio.isSelected()) {
			retVal = LineEndingsEnum.UNIX;
		}
		Prefs.setSaveLineEndings(retVal);
		return retVal;
	}

	/**
	 * Note: Saves the value as a preference
	 */
	public boolean isSelectedSaveStripComments() {
		boolean retVal = mySaveCommentsCheckbox.isSelected();
		Prefs.setSaveStripComments(retVal);
		return retVal;
	}

}
