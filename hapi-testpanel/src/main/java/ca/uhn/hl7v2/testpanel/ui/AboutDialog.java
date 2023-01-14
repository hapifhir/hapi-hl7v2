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
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
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

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
		setBounds(100, 100, 901, 767);
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
							open(new URI("https://hapifhir.github.io/hapi-hl7v2/"));
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
				createUIFAQ(panel); 
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
	
	   private static void createUIFAQ(JPanel panel){  
		      JEditorPane jEditorPane = new JEditorPane();
		      jEditorPane.setEditable(false);		
		      jEditorPane.setContentType("text/html");
				         
		       String faq = ""
		       		+ ""
		       		+ ""
		       		+ "<!DOCTYPE html>"
		       		+ "<html>"
		       		+ "<head>"
		       		+ "<style>"
		       		+ "body{"
		       		+ "    font-family: 'Work Sans', sans-serif;"
		       		+ "}"
		       		+ ".faq-heading{"
		       		+ "    border-bottom: #777;"
		       		+ "    padding: 20px 60px;"
		       		+ "}"
		       		+ ".faq-container{"
		       		+ "display: flex;"
		       		+ "justify-content: center;"
		       		+ "flex-direction: column;"
		       		+ "}"
		       		+ ".hr-line{"
		       		+ "  width: 100%;"
		       		+ "  margin: auto;"
		       		+ "  "
		       		+ "}"
		       		+ "/* Style the buttons that are used to open and close the faq-page body */"
		       		+ ".faq-page {"
		       		+ "    /* background-color: #eee; */"
		       		+ "    color: #444;"
		       		+ "    cursor: pointer;"
		       		+ "    padding: 30px 20px;"
		       		+ "    width: 100%;"
		       		+ "    border: none;"
		       		+ "    outline: none;"
		       		+ "    transition: 0.4s;"
		       		+ "    margin: auto;"
		       		+ "}"
		       		+ ".faq-body{"
		       		+ "    margin: auto;"
		       		+ "    /* text-align: center; */"
		       		+ "   width: 100%; "
		       		+ "   padding: auto;"
		       		+ "   "
		       		+ "}"
		       		+ "/* Add a background color to the button if it is clicked on (add the .active class with JS), and when you move the mouse over it (hover) */"
		       		+ ".active,"
		       		+ ".faq-page:hover {"
		       		+ "    background-color: #F9F9F9;"
		       		+ "}"
		       		+ "/* Style the faq-page panel. Note: hidden by default */"
		       		+ ".faq-body {"
		       		+ "    padding: 0 18px;"
		       		+ "    background-color: white;"
		       		+ "    display: none;"
		       		+ "    overflow: hidden;"
		       		+ "}"
		       		+ ".faq-page:after {"
		       		+ "    content: '\\02795';"
		       		+ "    /* Unicode character for \"plus\" sign (+) */"
		       		+ "    font-size: 13px;"
		       		+ "    color: #777;"
		       		+ "    float: right;"
		       		+ "    margin-left: 5px;"
		       		+ "}"
		       		+ ".active:after {"
		       		+ "    content: \"\\2796\";"
		       		+ "    /* Unicode character for \"minus\" sign (-) */"
		       		+ "}"
		       		+ "</style>"
		       		+ ""
		       		+ " <script type=\"text/javascript\">"
		       		+ " "
		       		+ " if(window.attachEvent) {"
		       		+ "    window.attachEvent('onload', loadInit);"
		       		+ "} else {"
		       		+ "    if(window.onload) {"
		       		+ "        var curronload = window.onload;"
		       		+ "        var newonload = function(evt) {"
		       		+ "            curronload(evt);"
		       		+ "            loadInit(evt);"
		       		+ "        };"
		       		+ "        window.onload = newonload;"
		       		+ "    } else {"
		       		+ "        window.onload = loadInit;"
		       		+ "    }"
		       		+ "}"
		       		+ "  function loadInit() {"
		       		+ "		var faq = document.getElementsByClassName(\"faq-page\");"
		       		+ "		var i;"
		       		+ "		for (i = 0; i < faq.length; i++) {"
		       		+ "			faq[i].addEventListener(\"click\", function () {"
		       		+ "				/* Toggle between adding and removing the \"active\" class,"
		       		+ "				to highlight the button that controls the panel */"
		       		+ "				this.classList.toggle(\"active\");"
		       		+ "				/* Toggle between hiding and showing the active panel */"
		       		+ "				var body = this.nextElementSibling;"
		       		+ "				if (body.style.display === \"block\") {"
		       		+ "					body.style.display = \"none\";"
		       		+ "				} else {"
		       		+ "					body.style.display = \"block\";"
		       		+ "				}"
		       		+ "			});"
		       		+ "	}"
		       		+ "}"
		       		+ "  </script>"
		       		+ "</head>"
		       		+ "<body>"
		       		+ "    <main>"
		       		+ "        <h1 class=\"faq-heading\">FAQ'S</h1>"
		       		+ "        <section class=\"faq-container\">"
		       		+ "            <div class=\"faq-one\">"
		       		+ "                <!-- faq question -->"
		       		+ "                <h1 class=\"faq-page\">What is HAPI TestPanel</h1>"
		       		+ "                <!-- faq answer -->"
		       		+ "                <div class=\"faq-body active\">"
		       		+ "                    <p>The HAPI TestPanel is a full featured HL7 message editor, transmitter and receiver. This software is still an alpha release, so please use it with caution!"
		       		+ "					TestPanel is free software, distributed under the MPL/GPL. TestPanel is also a demonstration of the many features of HAPI, the best HL7 programming API available for Java.</p>"
		       		+ "                </div>"
		       		+ "            </div>"
		       		+ "            <hr class=\"hr-line\">"
		       		+ "            <div class=\"faq-two\">"
		       		+ "                <!-- faq question -->"
		       		+ "                <h1 class=\"faq-page\">Message Validation</h1>"
		       		+ "                <!-- faq answer -->"
		       		+ "                <div class=\"faq-body\">"
		       		+ "                   <div class=\"faq-body active\">"
		       		+ "                    <p>By default, TestPanel uses HAPI's built in validation, known as DefaultValidation . The validation performs basic data type checks, such as making sure that NM datatype fields do not contain text, TS datatype fields contain valid dates, etc."
		       		+ "					To enable or disable this feature, click on the \"Validate\" selector, and choose either \"No Profile/Validation\" or \"Default HAPI Validation\". When validation is enabled, you will see any errors in the column to the left of the value column. "
		       		+ "					You can test this out by enabling validation and changing the MSH-7 (Timestamp) value so that it contains letters within the timestamp. Hovering over the red \"X\" will give more information about what is wrong."
		       		+ "					</p>"
		       		+ "                </div>"
		       		+ "                </div>"
		       		+ "            </div>"
		       		+ "            <hr class=\"hr-line\">"
		       		+ "            <div class=\"faq-three\">"
		       		+ "                <!-- faq question -->"
		       		+ "				<h1 class=\"faq-page \">Conformance Profiles</h1>"
		       		+ "                <!-- faq answer -->"
		       		+ "                <div class=\"faq-body active\">"
		       		+ "                    <p>TestPanel supports validating messages using HL7 Conformance Profiles. Conformance profiles are special XML-based files which constrain the standard HL7 message definitions, allowing you to specify maximum field lengths, required cardinalities, etc."
		       		+ "					Conformance profiles are generally created using a tool called Message Workbench (MWB)."
		       		+ "					To create a conformance profile, use the MWB tool to create your profile, and then select \"Export XML Profile\" from the File menu to create an XML version which can be loaded into TestPanel.</p>"
		       		+ "                </div>"
		       		+ "            </div>"
		       		+ "			<hr class=\"hr-line\">"
		       		+ "            <div class=\"faq-three\">"
		       		+ "                <!-- faq question -->"
		       		+ "				<h1 class=\"faq-page \">Creating a Profile Group</h1>"
		       		+ "                <!-- faq answer -->"
		       		+ "                <div class=\"faq-body active\">"
		       		+ "                    <p>TestPanel arranges profiles in what it calls a \"Profile Group\". A profile group is a collection of one or more conformance profiles. Within a profile group, each profile is marked as applying to specific message types, so that for instance you could create a profile group with one profile for ADT^A01 messages and another profile for ORU^R01."
		       		+ "						To create a profile group, choose \"Profiles and Tables...\" from the Conformance menu. This opens the profiles dialog."
		       		+ "						Click on \"New Profile Group\" to create a new profile group."
		       		+ "						Select the newly created group, and click on \"Add Profile\" to add a conformance profile to the group. The allows you to select an XML based conformance profile, and then assign it to one or more message types."
		       		+ "						To apply your new profile group to a message (or a collection of messages), open the messages in the main message editor, and choose your new profile group from the \"Validate\" picker, near the top right of the window."
		       		+ "						If there are any problems with your message, you will now see them highlighted. Try removing values, or putting in very long values to see new problems. If you can't see any errors, you might want to make sure that your profile group matches the message type of the message you are using. (e.g. ADT^A04 vs. ADT^A01)"
		       		+ "					</p>"
		       		+ "                </div>"
		       		+ "            </div>"
		       		+ "			<hr class=\"hr-line\">"
		       		+ "            <div class=\"faq-three\">"
		       		+ "                <!-- faq question -->"
		       		+ "				<h1 class=\"faq-page \">Tables</h1>"
		       		+ "                <!-- faq answer -->"
		       		+ "                <div class=\"faq-body active\">"
		       		+ "                    <p>TestPanel also allows you to define tables from which coded values are drawn. Tables are stored in table files, and a table file contains one ore more tables."
		       		+ "					To create a table file, choose \"Profiles and Tables...\" from the Conformance menu, and navigate to the Tables tab. Click on \"Add File\" and create a new file."
		       		+ "					Now, create a new table. HL7 tables are generally represented by four digits. For example, component 1 of a CE such as MSH-3 \"Sending Application\" is table 0300. To create a validation table, add the prefix HL7, as shown in the screenshot."
		       		+ "					Once you have created your tables, return to the Profiles tab, and assign your table file to the Profile Group by clicking on the word \"None\" with the small circle next to it."
		       		+ "					</p>"
		       		+ "                </div>"
		       		+ "            </div>"
		       		+ "			<hr class=\"hr-line\">"
		       		+ "            <div class=\"faq-three\">"
		       		+ "                <!-- faq question -->"
		       		+ "				<h1 class=\"faq-page \">File Diff</h1>"
		       		+ "                <!-- faq answer -->"
		       		+ "                <div class=\"faq-body active\">"
		       		+ "                    <p>The HL7 v2 File Diff can be used to compare two files, each containing raw HL7 messages, for differences."
		       		+ "					Each message is parsed, and the parsed message is then compared at a segment-by-segment and field-by-field level. This means that messages are compared to see if they are semantically identical as opposed to performing a rigid byte level comparison."
		       		+ "					This means for example that the following segments are considered identical:"
		       		+ "					PID|||7000135^^^UHN|||||"
		       		+ "					PID|||7000135^^^UHN"
		       		+ "					</p>"
		       		+ "                </div>"
		       		+ "            </div>"
		       		+ "			<hr class=\"hr-line\">"
		       		+ "            <div class=\"faq-three\">"
		       		+ "                <!-- faq question -->"
		       		+ "				<h1 class=\"faq-page\">Using the HL7 v2 File Diff</h1>"
		       		+ "                <!-- faq answer -->"
		       		+ "                <div class=\"faq-body active\">"
		       		+ "                    <p>To access the file diff, start the Test Panel, and choose \"HL7 v2 File Diff\" from the tools menu. This will bring up the diff dialog. In this dialog, two files (file 1, and file 2) must be selected. These files must contain raw HL7 messages. Note that any lines beginning with hash (#) will be treated as comments and ignored."
		       		+ "					When both files have been selected, you may click on the \"begin\" button to start comparing. Any differences which are found will be highlighted."
		       		+ "					</p>"
		       		+ "                </div>"
		       		+ "            </div>"
		       		+ "        </section>"
		       		+ "    </main>"
		       		+ "   </body>"
		       		+ "</html>"
		       		+ "";  
		         
		         
		    
		    
		         
		        jEditorPane.setContentType("text/html");
		        jEditorPane.setText(faq);
		      
		      JScrollPane jScrollPane = new JScrollPane(jEditorPane);
		      jScrollPane.setPreferredSize(new Dimension(580,400));      

		      GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
				gbc_lblNewLabel_3.gridwidth = 2;
				gbc_lblNewLabel_3.gridx = 0;
				gbc_lblNewLabel_3.gridy = 7;
		      
		      panel.add(jScrollPane,gbc_lblNewLabel_3);
		     
		    
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
