package ca.uhn.hl7v2.testpanel.ui.tools;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import org.apache.commons.lang.StringUtils;

import ca.uhn.hl7v2.testpanel.controller.Hl7V2FileDiffController;
import ca.uhn.hl7v2.testpanel.controller.Prefs;
import ca.uhn.hl7v2.testpanel.util.SimpleDocumentListener;

public class Hl7V2FileDiffDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private JButton myBeginButton;
	private final JPanel mycontentPanel = new JPanel();
	private Hl7V2FileDiffController myController;
	private JTextField myFile1Text;
	private JTextField myFile2Text;
	private JButton myPickFile1Button;
	private JButton myPickFile2Button;
	private JButton myStopButton;
	private JCheckBox myStopOnFirstErrorCheck;
	private JProgressBar myProgressBar;
	private JCheckBox myShowWholeMessageOnErrorCheckbox;
	/**
	 * Create the dialog.
	 */
	public Hl7V2FileDiffDialog(Hl7V2FileDiffController theHl7v2FileDiffController) {
		myController = theHl7v2FileDiffController;
		initListeners();
		
		setTitle("HL7 v2 File Diff");
		setBounds(100, 100, 546, 414);
		getContentPane().setLayout(new BorderLayout());
		mycontentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(mycontentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 73, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		mycontentPanel.setLayout(gbl_contentPanel);
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 0);
			gbc_panel.fill = GridBagConstraints.HORIZONTAL;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 0;
			mycontentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
			gbl_panel.rowHeights = new int[] { 0, 0, 0 };
			gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			{
				JLabel lblFile = new JLabel(
						"<html><center>HL7 v2 File Diff compares two files, each containing one or more HL7 v2 messages, and presents a friendly view of any differences. Messages are compared semantically, meaning that empty fields and components are not compared.</center></html>");
				GridBagConstraints gbc_lblFile = new GridBagConstraints();
				gbc_lblFile.insets = new Insets(0, 0, 5, 0);
				gbc_lblFile.fill = GridBagConstraints.HORIZONTAL;
				gbc_lblFile.weightx = 1.0;
				gbc_lblFile.gridwidth = 6;
				gbc_lblFile.gridx = 0;
				gbc_lblFile.gridy = 0;
				panel.add(lblFile, gbc_lblFile);
			}
			{
				JLabel lblFile_1 = new JLabel("File 1:");
				GridBagConstraints gbc_lblFile_1 = new GridBagConstraints();
				gbc_lblFile_1.anchor = GridBagConstraints.EAST;
				gbc_lblFile_1.insets = new Insets(0, 0, 0, 5);
				gbc_lblFile_1.gridx = 0;
				gbc_lblFile_1.gridy = 1;
				panel.add(lblFile_1, gbc_lblFile_1);
			}
			{
				myFile1Text = new JTextField();
				myFile1Text.setText(Prefs.getInstance().getHl7V2DiffFile1());
				GridBagConstraints gbc_File1Text = new GridBagConstraints();
				gbc_File1Text.insets = new Insets(0, 0, 0, 5);
				gbc_File1Text.fill = GridBagConstraints.HORIZONTAL;
				gbc_File1Text.gridx = 1;
				gbc_File1Text.gridy = 1;
				panel.add(myFile1Text, gbc_File1Text);
				myFile1Text.setColumns(10);
				myFile1Text.getDocument().addDocumentListener(new SimpleDocumentListener() {
					@Override
					public void update(DocumentEvent theE) {
						Prefs.getInstance().setHl7V2DiffFile1(myFile1Text.getText());
						updateButtonStates();
					}
				});
			}
			{
				myPickFile1Button = new JButton("");
				myPickFile1Button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JTextField textField = myFile1Text;
						chooseFile(textField);
					}
				});
				myPickFile1Button.setIcon(new ImageIcon(Hl7V2FileDiffDialog.class.getResource("/ca/uhn/hl7v2/testpanel/images/open.png")));
				GridBagConstraints gbc_PickFile1Button = new GridBagConstraints();
				gbc_PickFile1Button.insets = new Insets(0, 0, 0, 5);
				gbc_PickFile1Button.gridx = 2;
				gbc_PickFile1Button.gridy = 1;
				panel.add(myPickFile1Button, gbc_PickFile1Button);
			}
			{
				JLabel lblNewLabel = new JLabel("File 2:");
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
				gbc_lblNewLabel.gridx = 3;
				gbc_lblNewLabel.gridy = 1;
				panel.add(lblNewLabel, gbc_lblNewLabel);
			}
			{
				myFile2Text = new JTextField();
				myFile2Text.setText(Prefs.getInstance().getHl7V2DiffFile2());
				GridBagConstraints gbc_File2TextField = new GridBagConstraints();
				gbc_File2TextField.insets = new Insets(0, 0, 0, 5);
				gbc_File2TextField.fill = GridBagConstraints.HORIZONTAL;
				gbc_File2TextField.gridx = 4;
				gbc_File2TextField.gridy = 1;
				panel.add(myFile2Text, gbc_File2TextField);
				myFile2Text.setColumns(10);
				myFile2Text.getDocument().addDocumentListener(new SimpleDocumentListener() {
					@Override
					public void update(DocumentEvent theE) {
						Prefs.getInstance().setHl7V2DiffFile2(myFile2Text.getText());
						updateButtonStates();
					}
				});
			}
			{
				myPickFile2Button = new JButton("");
				myPickFile2Button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						chooseFile(myFile2Text);
					}
				});
				myPickFile2Button.setIcon(new ImageIcon(Hl7V2FileDiffDialog.class.getResource("/ca/uhn/hl7v2/testpanel/images/open.png")));
				GridBagConstraints gbc_PickFile2Button = new GridBagConstraints();
				gbc_PickFile2Button.gridx = 5;
				gbc_PickFile2Button.gridy = 1;
				panel.add(myPickFile2Button, gbc_PickFile2Button);
			}
		}
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 0);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 1;
			mycontentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
			gbl_panel.rowHeights = new int[] { 0 };
			gbl_panel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0 };
			gbl_panel.rowWeights = new double[] { Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			myBeginButton = new JButton("Begin");
			myBeginButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					myController.begin();
				}
			});
			myBeginButton.setIcon(new ImageIcon(Hl7V2FileDiffDialog.class.getResource("/ca/uhn/hl7v2/testpanel/images/start_all.png")));
			GridBagConstraints gbc_BeginButton = new GridBagConstraints();
			gbc_BeginButton.anchor = GridBagConstraints.WEST;
			gbc_BeginButton.insets = new Insets(0, 0, 0, 5);
			gbc_BeginButton.gridx = 0;
			gbc_BeginButton.gridy = 0;
			panel.add(myBeginButton, gbc_BeginButton);
			{
				myStopButton = new JButton("Stop");
				myStopButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						myController.cancel();
					}
				});
				myStopButton.setIcon(new ImageIcon(Hl7V2FileDiffDialog.class.getResource("/ca/uhn/hl7v2/testpanel/images/stop_all.png")));
				GridBagConstraints gbc_StopButton = new GridBagConstraints();
				gbc_StopButton.insets = new Insets(0, 0, 0, 5);
				gbc_StopButton.gridx = 1;
				gbc_StopButton.gridy = 0;
				panel.add(myStopButton, gbc_StopButton);
			}
			{
				myStopOnFirstErrorCheck = new JCheckBox("Stop");
				myStopOnFirstErrorCheck.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent e) {
						Prefs.getInstance().setHl7V2DiffStopOnFirstError(myStopButton.isSelected());
					}
				});
				{
					JLabel lblOnDifference = new JLabel("On Difference:");
					GridBagConstraints gbc_lblOnDifference = new GridBagConstraints();
					gbc_lblOnDifference.insets = new Insets(0, 0, 0, 5);
					gbc_lblOnDifference.gridx = 3;
					gbc_lblOnDifference.gridy = 0;
					panel.add(lblOnDifference, gbc_lblOnDifference);
				}
				{
					myShowWholeMessageOnErrorCheckbox = new JCheckBox("Show Whole Message");
					GridBagConstraints gbc_ShowWholeMessageOnErrorCheckbox = new GridBagConstraints();
					gbc_ShowWholeMessageOnErrorCheckbox.insets = new Insets(0, 0, 0, 5);
					gbc_ShowWholeMessageOnErrorCheckbox.gridx = 4;
					gbc_ShowWholeMessageOnErrorCheckbox.gridy = 0;
					panel.add(myShowWholeMessageOnErrorCheckbox, gbc_ShowWholeMessageOnErrorCheckbox);
					myShowWholeMessageOnErrorCheckbox.setSelected(Prefs.getInstance().getHl7V2DiffShowWholeMessageOnError());
					myShowWholeMessageOnErrorCheckbox.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent theE) {
							Prefs.getInstance().setHl7V2DiffShowWholeMessageOnError(myShowWholeMessageOnErrorCheckbox.isSelected());
						}
					});
				}
				myStopOnFirstErrorCheck.setSelected(Prefs.getInstance().getHl7V2DiffStopOnFirstError());
				GridBagConstraints gbc_StopOnFirstErrorCheck = new GridBagConstraints();
				gbc_StopOnFirstErrorCheck.gridx = 5;
				gbc_StopOnFirstErrorCheck.gridy = 0;
				panel.add(myStopOnFirstErrorCheck, gbc_StopOnFirstErrorCheck);
			}

		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Results", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 2;
			mycontentPanel.add(panel, gbc_panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane);
				{
					JList list = new JList();
					list.setModel(new OutputListModel());
					scrollPane.setViewportView(list);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				myProgressBar = new JProgressBar();
				myProgressBar.setStringPainted(true);
				myProgressBar.setOpaque(true);
				myProgressBar.setValue(0);
				myProgressBar.setMaximum(100);
				myProgressBar.setPreferredSize(new Dimension(400, 20));
				buttonPane.add(myProgressBar);
			}
			{
				JButton cancelButton = new JButton("Close");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		updateButtonStates();
	}

	/**
	 * Launch the application.
	 */

	private void chooseFile(JTextField textField) {
		File currentDir = null;
		try {
			currentDir = new File(textField.getText());
			if (currentDir.isFile()) {
				currentDir = currentDir.getParentFile();
			}
		} catch (Exception e2) {
			// ignore
		}
		JFileChooser chooser = new JFileChooser(currentDir);
		int result = chooser.showOpenDialog(Hl7V2FileDiffDialog.this);
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			textField.setText(file.getAbsolutePath());
		}
	}

	public boolean isShowWholeMessageOnError() {
		return myShowWholeMessageOnErrorCheckbox.isSelected();
	}
	
	public String getFile1Text() {
		return myFile1Text.getText();
	}

	public String getFile2Text() {
		return myFile2Text.getText();
	}

	private void initListeners() {
		myController.addPropertyChangeListener(Hl7V2FileDiffController.PROP_RUNNING, new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent theEvt) {
				updateButtonStates();
				updateProgress();
			}
		});
		myController.addPropertyChangeListener(Hl7V2FileDiffController.PROP_FAILED, new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent theEvt) {
				updateProgress();
			}
		});
		myController.addPropertyChangeListener(Hl7V2FileDiffController.PROP_PERCENT_DONE, new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent theEvt) {
				updateProgress();
			}
		});
	}

	private void updateProgress() {
		int percentDone = myController.getPercentDone();
		myProgressBar.setValue(percentDone);
		
		if (myController.isFailed()) {
			myProgressBar.setString("Failed - " + percentDone + "%");
		} else if (myController.isRunning()) {
			myProgressBar.setString("Working - " + percentDone + "%");
		} else {
			myProgressBar.setString("");
		}
	}

	public boolean isStopOnFirstError() {
		return myStopOnFirstErrorCheck.isSelected();
	}

	private void updateButtonStates() {
		boolean running = myController.isRunning();
		myPickFile1Button.setEnabled(!running);
		myPickFile2Button.setEnabled(!running);
		myShowWholeMessageOnErrorCheckbox.setEnabled(!running);
		myFile1Text.setEnabled(!running);
		myFile2Text.setEnabled(!running);
		
		boolean haveFiles = (StringUtils.isNotBlank(myFile1Text.getText()) && StringUtils.isNotBlank(myFile2Text.getText()));
		myBeginButton.setEnabled(haveFiles && !running);
		myStopButton.setEnabled(running);
		myStopOnFirstErrorCheck.setEnabled(!running);
	}

	public class OutputListModel implements ListModel {

		private List<ListDataListener> myListeners = new ArrayList<ListDataListener>();
		
		public OutputListModel() {
			myController.addPropertyChangeListener(Hl7V2FileDiffController.PROP_OUTPUT, new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent theEvt) {
					for (ListDataListener next : myListeners) {
						// TODO: this could be more efficient...
						next.contentsChanged(new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0, getSize()));
					}
				}
			});
		}
		
		public void addListDataListener(ListDataListener theL) {
			myListeners.add(theL);
		}

		public String getElementAt(int theIndex) {
			String retVal = myController.getOutputLine(theIndex);
			return retVal;
		}

		public int getSize() {
			int retVal = myController.getOutputSize();
			return retVal;
		}

		public void removeListDataListener(ListDataListener theL) {
			myListeners.remove(theL);
		}

	}

}
