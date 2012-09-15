package ca.uhn.hl7v2.testpanel.ui.find;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Hl7V2FindDialog extends JDialog {

	private final JPanel mycontentPanel = new JPanel();
	private JTextField myFindTextField;
	private JComboBox myFindTypeCombobox;
	private JCheckBox myIgnoreCaseCheckbox;
	private JComboBox myInComboBox;
	private JTextField myTerserPathTextField;
	private JTextField myReplaceWithTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Hl7V2FindDialog dialog = new Hl7V2FindDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Hl7V2FindDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		mycontentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(mycontentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		mycontentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblFind = new JLabel("Find");
			GridBagConstraints gbc_lblFind = new GridBagConstraints();
			gbc_lblFind.insets = new Insets(0, 0, 5, 5);
			gbc_lblFind.anchor = GridBagConstraints.EAST;
			gbc_lblFind.gridx = 0;
			gbc_lblFind.gridy = 0;
			mycontentPanel.add(lblFind, gbc_lblFind);
		}
		{
			myFindTypeCombobox = new JComboBox();
			myFindTypeCombobox.setModel(new DefaultComboBoxModel(new String[] {"Text", "Regex"}));
			myFindTypeCombobox.setSelectedIndex(0);
			GridBagConstraints gbc_FindTypeCombobox = new GridBagConstraints();
			gbc_FindTypeCombobox.insets = new Insets(0, 0, 5, 5);
			gbc_FindTypeCombobox.fill = GridBagConstraints.HORIZONTAL;
			gbc_FindTypeCombobox.gridx = 1;
			gbc_FindTypeCombobox.gridy = 0;
			mycontentPanel.add(myFindTypeCombobox, gbc_FindTypeCombobox);
		}
		{
			myFindTextField = new JTextField();
			GridBagConstraints gbc_FindTextField = new GridBagConstraints();
			gbc_FindTextField.insets = new Insets(0, 0, 5, 0);
			gbc_FindTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_FindTextField.gridx = 2;
			gbc_FindTextField.gridy = 0;
			mycontentPanel.add(myFindTextField, gbc_FindTextField);
			myFindTextField.setColumns(10);
		}
		{
			myIgnoreCaseCheckbox = new JCheckBox("Ignore Case");
			GridBagConstraints gbc_IgnoreCaseCheckbox = new GridBagConstraints();
			gbc_IgnoreCaseCheckbox.insets = new Insets(0, 0, 5, 5);
			gbc_IgnoreCaseCheckbox.gridx = 1;
			gbc_IgnoreCaseCheckbox.gridy = 1;
			mycontentPanel.add(myIgnoreCaseCheckbox, gbc_IgnoreCaseCheckbox);
		}
		{
			Component verticalStrut = Box.createVerticalStrut(20);
			GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
			gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
			gbc_verticalStrut.gridx = 0;
			gbc_verticalStrut.gridy = 2;
			mycontentPanel.add(verticalStrut, gbc_verticalStrut);
		}
		{
			JLabel lblIn = new JLabel("In");
			GridBagConstraints gbc_lblIn = new GridBagConstraints();
			gbc_lblIn.anchor = GridBagConstraints.EAST;
			gbc_lblIn.insets = new Insets(0, 0, 5, 5);
			gbc_lblIn.gridx = 0;
			gbc_lblIn.gridy = 3;
			mycontentPanel.add(lblIn, gbc_lblIn);
		}
		{
			myInComboBox = new JComboBox();
			myInComboBox.setModel(new DefaultComboBoxModel(new String[] {"Anywhere", "Field Contents", "Terser Path"}));
			GridBagConstraints gbc_InComboBox = new GridBagConstraints();
			gbc_InComboBox.insets = new Insets(0, 0, 5, 5);
			gbc_InComboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_InComboBox.gridx = 1;
			gbc_InComboBox.gridy = 3;
			mycontentPanel.add(myInComboBox, gbc_InComboBox);
		}
		{
			myTerserPathTextField = new JTextField();
			GridBagConstraints gbc_TerserPathTextField = new GridBagConstraints();
			gbc_TerserPathTextField.insets = new Insets(0, 0, 5, 0);
			gbc_TerserPathTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_TerserPathTextField.gridx = 2;
			gbc_TerserPathTextField.gridy = 3;
			mycontentPanel.add(myTerserPathTextField, gbc_TerserPathTextField);
			myTerserPathTextField.setColumns(10);
		}
		{
			Component verticalStrut = Box.createVerticalStrut(20);
			GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
			gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
			gbc_verticalStrut.gridx = 0;
			gbc_verticalStrut.gridy = 4;
			mycontentPanel.add(verticalStrut, gbc_verticalStrut);
		}
		{
			JLabel lblReplace = new JLabel("Replace");
			GridBagConstraints gbc_lblReplace = new GridBagConstraints();
			gbc_lblReplace.insets = new Insets(0, 0, 0, 5);
			gbc_lblReplace.gridx = 0;
			gbc_lblReplace.gridy = 5;
			mycontentPanel.add(lblReplace, gbc_lblReplace);
		}
		{
			myReplaceWithTextField = new JTextField();
			GridBagConstraints gbc_ReplaceWithTextField = new GridBagConstraints();
			gbc_ReplaceWithTextField.gridwidth = 2;
			gbc_ReplaceWithTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_ReplaceWithTextField.gridx = 1;
			gbc_ReplaceWithTextField.gridy = 5;
			mycontentPanel.add(myReplaceWithTextField, gbc_ReplaceWithTextField);
			myReplaceWithTextField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
