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
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.FlowLayout;
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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.awt.Component;
import javax.swing.Box;

public class AboutDialog extends JDialog {

	private final JPanel mycontentPanel = new JPanel();
	private static final Logger ourLog = LoggerFactory.getLogger(AboutDialog.class);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AboutDialog dialog = new AboutDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AboutDialog() {
		setBounds(100, 100, 583, 553);
		getContentPane().setLayout(new BorderLayout());
		mycontentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(mycontentPanel, BorderLayout.CENTER);
		mycontentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(Color.GRAY));
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setVgap(0);
			flowLayout.setHgap(0);
			panel.setBackground(Color.WHITE);
			mycontentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon(AboutDialog.class.getResource("/ca/uhn/hl7v2/testpanel/images/hapi_logo.png")));
				panel.add(label);
			}
		}
		{
			StringBuilder aboutText = new StringBuilder();

			aboutText.append("<html>");
			aboutText.append("This software is licensed under the terms of the GNU Public License (Version 2) and the Mozilla Public License (Version 1.0).");
			aboutText.append("</html>");
		}
		{
			JPanel panel = new JPanel();
			mycontentPanel.add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 203, 0, 0 };
			gbl_panel.rowHeights = new int[] { 16, 0, 0, 0, 0, 0, 0, 0, 0 };
			gbl_panel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);

			JLabel lblNewLabel = new JLabel("Welcome to the HAPI TestPanel. ");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.gridwidth = 2;
			gbc_lblNewLabel.insets = new Insets(10, 0, 5, 0);
			gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			panel.add(lblNewLabel, gbc_lblNewLabel);
			{
				JLabel lblThisSoftwareIs = new JLabel(
						"<html><center>This is free software, licensed under the terms of the GNU General Public License (Version 2) and the Mozilla Public License (Version 1.0).</center></html>");
				lblThisSoftwareIs.setHorizontalAlignment(SwingConstants.CENTER);
				GridBagConstraints gbc_lblThisSoftwareIs = new GridBagConstraints();
				gbc_lblThisSoftwareIs.gridwidth = 2;
				gbc_lblThisSoftwareIs.fill = GridBagConstraints.HORIZONTAL;
				gbc_lblThisSoftwareIs.insets = new Insets(0, 20, 5, 20);
				gbc_lblThisSoftwareIs.gridx = 0;
				gbc_lblThisSoftwareIs.gridy = 1;
				panel.add(lblThisSoftwareIs, gbc_lblThisSoftwareIs);
			}
			{
				JLabel lblLearnMore = new JLabel("Learn More");
				lblLearnMore.setHorizontalAlignment(SwingConstants.CENTER);
				lblLearnMore.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							open(new URI("http://hl7api.sourceforge.net/newtestpanel.html"));
						} catch (URISyntaxException e1) {
							ourLog.error("Failed to create hyperlink", e1);
						}
					}
				});
				lblLearnMore.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblLearnMore.setForeground(Color.BLUE);
				GridBagConstraints gbc_lblLearnMore = new GridBagConstraints();
				gbc_lblLearnMore.gridwidth = 2;
				gbc_lblLearnMore.insets = new Insets(10, 0, 5, 0);
				gbc_lblLearnMore.gridx = 0;
				gbc_lblLearnMore.gridy = 2;
				panel.add(lblLearnMore, gbc_lblLearnMore);
			}
			{
				JLabel lblThisSoftwareAlso = new JLabel("This software also makes use of the following great open source projects:");
				GridBagConstraints gbc_lblThisSoftwareAlso = new GridBagConstraints();
				gbc_lblThisSoftwareAlso.gridwidth = 2;
				gbc_lblThisSoftwareAlso.insets = new Insets(10, 0, 5, 0);
				gbc_lblThisSoftwareAlso.gridx = 0;
				gbc_lblThisSoftwareAlso.gridy = 3;
				panel.add(lblThisSoftwareAlso, gbc_lblThisSoftwareAlso);
			}
			{
				JLabel lblJsyntaxpane = new JLabel("JSyntaxPane");
				GridBagConstraints gbc_lblJsyntaxpane = new GridBagConstraints();
				gbc_lblJsyntaxpane.insets = new Insets(0, 0, 5, 5);
				gbc_lblJsyntaxpane.gridx = 0;
				gbc_lblJsyntaxpane.gridy = 4;
				panel.add(lblJsyntaxpane, gbc_lblJsyntaxpane);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("NetBeans.org Outline");
				GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
				gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
				gbc_lblNewLabel_1.gridx = 1;
				gbc_lblNewLabel_1.gridy = 4;
				panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
			}
			{
				JLabel lblJflex = new JLabel("JFlex");
				GridBagConstraints gbc_lblJflex = new GridBagConstraints();
				gbc_lblJflex.insets = new Insets(0, 0, 5, 5);
				gbc_lblJflex.gridx = 0;
				gbc_lblJflex.gridy = 5;
				panel.add(lblJflex, gbc_lblJflex);
			}
			{
				JLabel lblGnuPublicLicense = new JLabel("log4j");
				GridBagConstraints gbc_lblGnuPublicLicense = new GridBagConstraints();
				gbc_lblGnuPublicLicense.insets = new Insets(0, 0, 5, 0);
				gbc_lblGnuPublicLicense.gridx = 1;
				gbc_lblGnuPublicLicense.gridy = 5;
				panel.add(lblGnuPublicLicense, gbc_lblGnuPublicLicense);
			}
			{
				Component verticalGlue = Box.createVerticalGlue();
				GridBagConstraints gbc_verticalGlue = new GridBagConstraints();
				gbc_verticalGlue.insets = new Insets(0, 0, 5, 5);
				gbc_verticalGlue.gridx = 0;
				gbc_verticalGlue.gridy = 6;
				panel.add(verticalGlue, gbc_verticalGlue);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("");
				lblNewLabel_2.setIcon(new ImageIcon(AboutDialog.class.getResource("/ca/uhn/hl7v2/testpanel/images/dogs_waiting_175.jpg")));
				GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
				gbc_lblNewLabel_2.gridwidth = 2;
				gbc_lblNewLabel_2.gridx = 0;
				gbc_lblNewLabel_2.gridy = 7;
				panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setSelected(true);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						AboutDialog.this.setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

	private static void open(URI uri) {
		if (Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().browse(uri);
			} catch (IOException e) {
				ourLog.error("Failed to create hyperlink", e);
			}
		} else {
			ourLog.error("Failed to create hyperlink, no desktop available");
		}
	}
}
