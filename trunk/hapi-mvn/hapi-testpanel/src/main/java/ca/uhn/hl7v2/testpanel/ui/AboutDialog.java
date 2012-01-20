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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.awt.Component;
import javax.swing.border.LineBorder;

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
		setBounds(100, 100, 450, 300);
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
			gbl_panel.columnWidths = new int[] { 203, 0 };
			gbl_panel.rowHeights = new int[] { 16, 0, 0, 0 };
			gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);

			JLabel lblNewLabel = new JLabel("Welcome to the HAPI TestPanel. ");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(10, 0, 5, 0);
			gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			panel.add(lblNewLabel, gbc_lblNewLabel);
			{
				JLabel lblThisSoftwareIs = new JLabel(
						"<html><center>This is free software, licensed under the terms of the GNU Public License (Version 2) and the Mozilla Public License (Version 1.0).</center></html>");
				lblThisSoftwareIs.setHorizontalAlignment(SwingConstants.CENTER);
				GridBagConstraints gbc_lblThisSoftwareIs = new GridBagConstraints();
				gbc_lblThisSoftwareIs.fill = GridBagConstraints.HORIZONTAL;
				gbc_lblThisSoftwareIs.insets = new Insets(0, 20, 5, 20);
				gbc_lblThisSoftwareIs.gridx = 0;
				gbc_lblThisSoftwareIs.gridy = 1;
				panel.add(lblThisSoftwareIs, gbc_lblThisSoftwareIs);
			}
			{
				JLabel lblLearnMore = new JLabel("Learn More");
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
				gbc_lblLearnMore.insets = new Insets(10, 0, 0, 0);
				gbc_lblLearnMore.gridx = 0;
				gbc_lblLearnMore.gridy = 2;
				panel.add(lblLearnMore, gbc_lblLearnMore);
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
