package ca.uhn.hl7v2.testpanel.ui.conf;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ca.uhn.hl7v2.testpanel.util.IOkCancelCallback;

public class ProfileGroupNameDialog extends JDialog {

	private final JPanel mycontentPanel = new JPanel();
	private JTextField myNameTextField;
	private IOkCancelCallback<String> myCallback;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ProfileGroupNameDialog dialog = new ProfileGroupNameDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ProfileGroupNameDialog() {
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setModal(true);
		setBounds(100, 100, 329, 117);
		getContentPane().setLayout(new BorderLayout());
		mycontentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(mycontentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		mycontentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblChooseAName = new JLabel("Choose a name for the Profile Group");
			GridBagConstraints gbc_lblChooseAName = new GridBagConstraints();
			gbc_lblChooseAName.anchor = GridBagConstraints.WEST;
			gbc_lblChooseAName.insets = new Insets(0, 0, 5, 0);
			gbc_lblChooseAName.gridx = 0;
			gbc_lblChooseAName.gridy = 0;
			mycontentPanel.add(lblChooseAName, gbc_lblChooseAName);
		}
		{
			myNameTextField = new JTextField();
			GridBagConstraints gbc_NameTextField = new GridBagConstraints();
			gbc_NameTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_NameTextField.gridx = 0;
			gbc_NameTextField.gridy = 1;
			mycontentPanel.add(myNameTextField, gbc_NameTextField);
			myNameTextField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent theE) {
						myCallback.ok(getName());
						setVisible(false);
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener() {;
					public void actionPerformed(ActionEvent theE) {
						myCallback.cancel(getName());
						setVisible(false);
					}
				});
				buttonPane.add(cancelButton);
			}
		}
	}

	public void setCallback(IOkCancelCallback<String> theCallback) {
		myCallback = theCallback;
	}
	
	public void setName(String theName) {
		myNameTextField.setText(theName);
	}

	public String getName() {
		return myNameTextField.getText();
	}
	
	public void start() {
		setVisible(true);
		myNameTextField.grabFocus();
		myNameTextField.setSelectionEnd(0);
		myNameTextField.setSelectionEnd(myNameTextField.getText().length());
	}

}
