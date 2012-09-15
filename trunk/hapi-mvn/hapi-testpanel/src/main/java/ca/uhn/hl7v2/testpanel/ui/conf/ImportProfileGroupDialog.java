package ca.uhn.hl7v2.testpanel.ui.conf;

import static org.apache.commons.lang.StringUtils.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;

import ca.uhn.hl7v2.testpanel.controller.ConformanceEditorController;
import ca.uhn.hl7v2.testpanel.controller.Prefs;
import ca.uhn.hl7v2.testpanel.util.ColorUtil;
import ca.uhn.hl7v2.testpanel.util.SimpleDocumentListener;

public class ImportProfileGroupDialog extends JDialog {

	private final JPanel mycontentPanel = new JPanel();
	private final ButtonGroup fileOrUrlButtonGroup = new ButtonGroup();
	private JTextField myFileTextField;
	private JTextField myUrlTextField;
	private JRadioButton myUrlRadioButton;
	private JRadioButton myFileRadioButton;
	private JButton myOkButton;
	private File myFileString;
	private URL myUrlString;

	/**
	 * Create the dialog.
	 */
	public ImportProfileGroupDialog() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setResizable(false);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("Import Profile Group");
		setBounds(100, 100, 450, 158);
		getContentPane().setLayout(new BorderLayout());
		mycontentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(mycontentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		mycontentPanel.setLayout(gbl_contentPanel);
		{
			myFileRadioButton = new JRadioButton("File:");
			myFileRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					updateOk();
				}
			});
			fileOrUrlButtonGroup.add(myFileRadioButton);
			GridBagConstraints gbc_myFileRadioButton = new GridBagConstraints();
			gbc_myFileRadioButton.insets = new Insets(0, 0, 5, 5);
			gbc_myFileRadioButton.gridx = 0;
			gbc_myFileRadioButton.gridy = 0;
			mycontentPanel.add(myFileRadioButton, gbc_myFileRadioButton);
		}
		{
			myFileTextField = new JTextField();
			myFileTextField.setOpaque(true);
			myFileTextField.getDocument().addDocumentListener(new SimpleDocumentListener() {
				@Override
				public void update(DocumentEvent theE) {
					myFileRadioButton.setSelected(true);
					updateOk();
				}
			});
			GridBagConstraints gbc_FileTextField = new GridBagConstraints();
			gbc_FileTextField.insets = new Insets(0, 0, 5, 5);
			gbc_FileTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_FileTextField.gridx = 1;
			gbc_FileTextField.gridy = 0;
			mycontentPanel.add(myFileTextField, gbc_FileTextField);
			myFileTextField.setColumns(10);
		}
		{
			JButton btnBrowse = new JButton("Browse...");
			btnBrowse.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					File importProfileGroupDir = Prefs.getInstance().getImportProfileGroupDirectory();
					JFileChooser chooser = new JFileChooser(importProfileGroupDir);
					ConformanceEditorController.createFileSelectionExtentionFolder(chooser);
					int result = chooser.showDialog(ImportProfileGroupDialog.this, "Select");
					if (result == JFileChooser.APPROVE_OPTION) {
						myFileTextField.setText(chooser.getSelectedFile().getAbsolutePath());
					}
				}
			});
			GridBagConstraints gbc_btnBrowse = new GridBagConstraints();
			gbc_btnBrowse.insets = new Insets(0, 0, 5, 0);
			gbc_btnBrowse.gridx = 2;
			gbc_btnBrowse.gridy = 0;
			mycontentPanel.add(btnBrowse, gbc_btnBrowse);
		}
		{
			myUrlRadioButton = new JRadioButton("URL:");
			myUrlRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					updateOk();
				}
			});
			fileOrUrlButtonGroup.add(myUrlRadioButton);
			GridBagConstraints gbc_myUrlRadioButton = new GridBagConstraints();
			gbc_myUrlRadioButton.insets = new Insets(0, 0, 0, 5);
			gbc_myUrlRadioButton.gridx = 0;
			gbc_myUrlRadioButton.gridy = 1;
			mycontentPanel.add(myUrlRadioButton, gbc_myUrlRadioButton);
		}
		{
			myUrlTextField = new JTextField();
			myUrlTextField.getDocument().addDocumentListener(new SimpleDocumentListener() {
				@Override
				public void update(DocumentEvent theE) {
					myUrlRadioButton.setSelected(true);
					updateOk();
				}
			});
			myUrlTextField.setOpaque(true);
			GridBagConstraints gbc_UrlTextField = new GridBagConstraints();
			gbc_UrlTextField.insets = new Insets(0, 0, 0, 5);
			gbc_UrlTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_UrlTextField.gridx = 1;
			gbc_UrlTextField.gridy = 1;
			mycontentPanel.add(myUrlTextField, gbc_UrlTextField);
			myUrlTextField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				myOkButton = new JButton("OK");
				myOkButton.setActionCommand("OK");
				myOkButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent theE) {
						updateOk();
						dispose();
					}
				});
				buttonPane.add(myOkButton);
				getRootPane().setDefaultButton(myOkButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						myFileString = null;
						myUrlString = null;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

		updateOk();
	}

	public File getFileString() {
		return myFileString;
	}

	public URL getUrlString() {
		return myUrlString;
	}

	private void updateOk() {
		if (myFileRadioButton.isSelected() && isNotBlank(myFileTextField.getText())) {
			myFileString = new File(myFileTextField.getText());
			if (myFileString.exists() && myFileString.isFile() && myFileString.canRead()) {
				myFileTextField.setBackground(ColorUtil.OK_BG);
			} else {
				myFileTextField.setBackground(ColorUtil.ERROR_BG);
			}
		} else {
			myFileString = null;
			myFileTextField.setBackground(ColorUtil.OK_BG);
		}

		if (myUrlRadioButton.isSelected() && isNotBlank(myUrlTextField.getText())) {
			try {
				myUrlString = new URL(myUrlTextField.getText());
				myUrlTextField.setBackground(ColorUtil.OK_BG);
			} catch (MalformedURLException e) {
				myUrlTextField.setBackground(ColorUtil.ERROR_BG);
			}
		} else {
			myUrlString = null;
			myUrlTextField.setBackground(ColorUtil.OK_BG);
		}

		boolean okEnabled = getFileString() != null || getUrlString() != null;
		myOkButton.setEnabled(okEnabled);
	}
}
