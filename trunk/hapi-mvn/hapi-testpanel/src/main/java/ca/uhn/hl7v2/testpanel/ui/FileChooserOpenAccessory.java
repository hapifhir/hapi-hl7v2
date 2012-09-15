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
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ca.uhn.hl7v2.testpanel.controller.Prefs;

public class FileChooserOpenAccessory extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel mylabel;
	private JComboBox myCharsetCombo;

	/**
	 * Create the panel.
	 */
	public FileChooserOpenAccessory() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		mylabel = new JLabel("Charset");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		add(mylabel, gbc_label);

		myCharsetCombo = new JComboBox();
		myCharsetCombo.setMaximumSize(new Dimension(180, 32767));
		myCharsetCombo.setPreferredSize(new Dimension(180, 27));
		myCharsetCombo.setMinimumSize(new Dimension(180, 27));
		GridBagConstraints gbc_CharsetCombo = new GridBagConstraints();
		gbc_CharsetCombo.anchor = GridBagConstraints.WEST;
		gbc_CharsetCombo.gridx = 1;
		gbc_CharsetCombo.gridy = 0;
		add(myCharsetCombo, gbc_CharsetCombo);

		List<String> charSets = new ArrayList<String>(Charset.availableCharsets().keySet());
		Collections.sort(charSets);
		ComboBoxModel charsetModel = new DefaultComboBoxModel(charSets.toArray(new String[0]));
		myCharsetCombo.setModel(charsetModel);
		Charset openOrSaveCharset = Prefs.getInstance().getOpenOrSaveCharset();
		myCharsetCombo.setSelectedItem(openOrSaveCharset.name());

	}

	/**
	 * Note: Saves the value as a preference
	 */
	public Charset getSelectedCharset() {
		Charset retVal = Charset.forName((String) myCharsetCombo.getSelectedItem());
		Prefs.getInstance().setOpenOrSaveCharset(retVal);
		return retVal;
	}


}
