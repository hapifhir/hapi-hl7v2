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

import java.awt.Color;
import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import ca.uhn.hl7v2.testpanel.controller.Controller;

public class NothingSelectedPanel extends BaseMainPanel {

	/**
	 * Create the panel.
	 */
	public NothingSelectedPanel(final Controller theController) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(NothingSelectedPanel.class.getResource("/ca/uhn/hl7v2/testpanel/images/hapi_logo.png")));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("<html><center>" +
				"Welcome to HAPI TestPanel!<br><br>" +
				"This is free software, licensed under the Mozilla Public License. " +
				"<br><br>Get Started:" +
				"</center></html>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnCreateHlV = new JButton("Create Samples");
		btnCreateHlV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				theController.populateWithSampleMessageAndConnections();
			}
		});
		GridBagConstraints gbc_btnCreateHlV = new GridBagConstraints();
		gbc_btnCreateHlV.insets = new Insets(0, 0, 5, 0);
		gbc_btnCreateHlV.gridx = 0;
		gbc_btnCreateHlV.gridy = 2;
		add(btnCreateHlV, gbc_btnCreateHlV);
		
		JLabel lblNewLabel_2 = new JLabel("<html><center>" +
				"<br><br>" +
				"Let us know what you think!" +
				"</center></html>");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblViewLicenseInformation = new JLabel("<html><center>Licensed under the <a href=\"\">Mozilla Public License</a></center></html>");
		lblViewLicenseInformation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("http://hl7api.sourceforge.net/license.html"));
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
			}
		});
		lblViewLicenseInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewLicenseInformation.setForeground(Color.BLACK);
		GridBagConstraints gbc_lblViewLicenseInformation = new GridBagConstraints();
		gbc_lblViewLicenseInformation.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblViewLicenseInformation.anchor = GridBagConstraints.SOUTH;
		gbc_lblViewLicenseInformation.gridx = 0;
		gbc_lblViewLicenseInformation.gridy = 4;
		add(lblViewLicenseInformation, gbc_lblViewLicenseInformation);

	}

}
