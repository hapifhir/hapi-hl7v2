package ca.uhn.hl7v2.testpanel.ui.tools;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import org.apache.commons.lang.StringUtils;

import ca.uhn.hl7v2.testpanel.controller.Hl7V2FileSortController;
import ca.uhn.hl7v2.testpanel.controller.Prefs;
import ca.uhn.hl7v2.testpanel.util.Hl7V2MessageStringComparatorByControlId;
import ca.uhn.hl7v2.testpanel.util.Hl7V2MessageStringComparatorByTimestamp;
import ca.uhn.hl7v2.testpanel.util.IProgressCallback;
import ca.uhn.hl7v2.testpanel.util.LimitedQueue;
import ca.uhn.hl7v2.testpanel.util.SimpleDocumentListener;

public class Hl7V2FileSortDialog extends JDialog {

	private static final String CONTROL_ID = "Control ID (MSH-10)";

	private static final long serialVersionUID = 1L;
	private static final String TIMESTAMP = "Message Timestamp (MSH-7)";
	private JButton myBeginButton;
	private boolean myCancelled = false;
	private final JPanel mycontentPanel = new JPanel();
	private Hl7V2FileSortController myController;
	private JTextField myInputFileText;
	private JTextField myOutputFileText;
	private OutputListModel myOutputListModel;
	private JButton myPickFile1Button;

	private JButton myPickFile2Button;
	private JProgressBar myProgressBar;

	private boolean myRunning = false;

	private JComboBox mySortByComboBox;

	private SortByComboBoxModel mySortByComboBoxModel;

	private JButton myStopButton;

	private JScrollPane myOutputScrollPane;

	/**
	 * Create the dialog.
	 */
	public Hl7V2FileSortDialog(Hl7V2FileSortController theHl7v2FileSortController) {
		myController = theHl7v2FileSortController;

		setTitle("HL7 v2 File Sort");
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
				JLabel lblFile = new JLabel("<html><center>HL7 v2 File Sort takes an input file containing raw HL7 v2 messages, sorts them, and produces a resulting output file. This application uses a large merge-sort, so it can handle very large files.</center></html>");
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
				JLabel lblFile_1 = new JLabel("Input:");
				GridBagConstraints gbc_lblFile_1 = new GridBagConstraints();
				gbc_lblFile_1.anchor = GridBagConstraints.EAST;
				gbc_lblFile_1.insets = new Insets(0, 0, 0, 5);
				gbc_lblFile_1.gridx = 0;
				gbc_lblFile_1.gridy = 1;
				panel.add(lblFile_1, gbc_lblFile_1);
			}
			{
				myInputFileText = new JTextField();
				myInputFileText.setText(Prefs.getInstance().getHl7V2SortInputFile());
				GridBagConstraints gbc_File1Text = new GridBagConstraints();
				gbc_File1Text.insets = new Insets(0, 0, 0, 5);
				gbc_File1Text.fill = GridBagConstraints.HORIZONTAL;
				gbc_File1Text.gridx = 1;
				gbc_File1Text.gridy = 1;
				panel.add(myInputFileText, gbc_File1Text);
				myInputFileText.setColumns(10);
				myInputFileText.getDocument().addDocumentListener(new SimpleDocumentListener() {
					@Override
					public void update(DocumentEvent theE) {
						Prefs.getInstance().setHl7V2SortInputFile(myInputFileText.getText());
						updateButtonStates();
					}
				});
			}
			{
				myPickFile1Button = new JButton("");
				myPickFile1Button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JTextField textField = myInputFileText;
						chooseFile(textField);
					}
				});
				myPickFile1Button.setIcon(new ImageIcon(Hl7V2FileSortDialog.class.getResource("/ca/uhn/hl7v2/testpanel/images/open.png")));
				GridBagConstraints gbc_PickFile1Button = new GridBagConstraints();
				gbc_PickFile1Button.insets = new Insets(0, 0, 0, 5);
				gbc_PickFile1Button.gridx = 2;
				gbc_PickFile1Button.gridy = 1;
				panel.add(myPickFile1Button, gbc_PickFile1Button);
			}
			{
				JLabel lblNewLabel = new JLabel("Output:");
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
				gbc_lblNewLabel.gridx = 3;
				gbc_lblNewLabel.gridy = 1;
				panel.add(lblNewLabel, gbc_lblNewLabel);
			}
			{
				myOutputFileText = new JTextField();
				myOutputFileText.setText(Prefs.getInstance().getHl7V2SortOutputFile());
				GridBagConstraints gbc_File2TextField = new GridBagConstraints();
				gbc_File2TextField.insets = new Insets(0, 0, 0, 5);
				gbc_File2TextField.fill = GridBagConstraints.HORIZONTAL;
				gbc_File2TextField.gridx = 4;
				gbc_File2TextField.gridy = 1;
				panel.add(myOutputFileText, gbc_File2TextField);
				myOutputFileText.setColumns(10);
				myOutputFileText.getDocument().addDocumentListener(new SimpleDocumentListener() {
					@Override
					public void update(DocumentEvent theE) {
						Prefs.getInstance().setHl7V2SortOutputFile(myOutputFileText.getText());
						updateButtonStates();
					}
				});
			}
			{
				myPickFile2Button = new JButton("");
				myPickFile2Button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						chooseFile(myOutputFileText);
					}
				});
				myPickFile2Button.setIcon(new ImageIcon(Hl7V2FileSortDialog.class.getResource("/ca/uhn/hl7v2/testpanel/images/open.png")));
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
			gbl_panel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 1.0 };
			gbl_panel.rowWeights = new double[] { Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			myBeginButton = new JButton("Begin");
			myBeginButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Prefs.getInstance().setHl7V2SortBy(getSortBy());
					myController.begin();
				}
			});
			myBeginButton.setIcon(new ImageIcon(Hl7V2FileSortDialog.class.getResource("/ca/uhn/hl7v2/testpanel/images/start_all.png")));
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
						myCancelled = true;
						updateButtonStates();
					}
				});
				myStopButton.setIcon(new ImageIcon(Hl7V2FileSortDialog.class.getResource("/ca/uhn/hl7v2/testpanel/images/stop_all.png")));
				GridBagConstraints gbc_StopButton = new GridBagConstraints();
				gbc_StopButton.insets = new Insets(0, 0, 0, 5);
				gbc_StopButton.gridx = 1;
				gbc_StopButton.gridy = 0;
				panel.add(myStopButton, gbc_StopButton);
			}
			{
				JLabel lblSortBy = new JLabel("Sort By:");
				GridBagConstraints gbc_lblSortBy = new GridBagConstraints();
				gbc_lblSortBy.insets = new Insets(0, 0, 0, 5);
				gbc_lblSortBy.anchor = GridBagConstraints.EAST;
				gbc_lblSortBy.gridx = 4;
				gbc_lblSortBy.gridy = 0;
				panel.add(lblSortBy, gbc_lblSortBy);
			}
			{
				mySortByComboBox = new JComboBox();
				mySortByComboBoxModel = new SortByComboBoxModel();
				mySortByComboBox.setModel(mySortByComboBoxModel);
				mySortByComboBox.setSelectedItem(Prefs.getInstance().getHl7V2SortBy());
				if (mySortByComboBox.getSelectedIndex() == -1) {
					mySortByComboBox.setSelectedIndex(0);
				}
				GridBagConstraints gbc_comboBox = new GridBagConstraints();
				gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBox.gridx = 5;
				gbc_comboBox.gridy = 0;
				panel.add(mySortByComboBox, gbc_comboBox);
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
				myOutputScrollPane = new JScrollPane();
				panel.add(myOutputScrollPane);
				{
					JList list = new JList();
					myOutputListModel = new OutputListModel();
					list.setModel(myOutputListModel);
					myOutputScrollPane.setViewportView(list);
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

	public void addMessage(String theMsg) {
		myOutputListModel.add(theMsg);
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				myOutputScrollPane.getVerticalScrollBar().setValue(myOutputScrollPane.getVerticalScrollBar().getMaximum());
			}
		});
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
		int result = chooser.showOpenDialog(Hl7V2FileSortDialog.this);
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			textField.setText(file.getAbsolutePath());
		}
	}

	public String getInputFileText() {
		return myInputFileText.getText();
	}

	public String getOutputFileText() {
		return myOutputFileText.getText();
	}

	private String getSortBy() {
		return (String) mySortByComboBox.getSelectedItem();
	}

	public Comparator<String> provideMessageComparator() {
		if (CONTROL_ID.equals(getSortBy())) {
			return new Hl7V2MessageStringComparatorByControlId();
		}

		return new Hl7V2MessageStringComparatorByTimestamp();
	}

	public IProgressCallback provideProgressCallback() {
		return new IProgressCallback() {

			@Override
			public void activityStarted() {
				myRunning = true;
				myCancelled = false;
				EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						updateButtonStates();
					}
				});
			}

			@Override
			public void activityStopped() {
				myRunning = false;
				EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						updateButtonStates();
					}
				});
			}

			@Override
			public void progressUpdate(final double theProgress) throws OperationCancelRequestedException {
				EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						myProgressBar.setValue((int) (myProgressBar.getMaximum() * theProgress));
					}
				});
				if (myCancelled) {
					throw new OperationCancelRequestedException();
				}
			}
		};
	}

	private void updateButtonStates() {
		myPickFile1Button.setEnabled(!myRunning);
		myPickFile2Button.setEnabled(!myRunning);
		myInputFileText.setEnabled(!myRunning);
		myOutputFileText.setEnabled(!myRunning);

		boolean haveFiles = (StringUtils.isNotBlank(myInputFileText.getText()) && StringUtils.isNotBlank(myOutputFileText.getText()));
		myBeginButton.setEnabled(haveFiles && !myRunning);
		myStopButton.setEnabled(myRunning && !myCancelled);
	}

	public class OutputListModel implements ListModel {

		private LimitedQueue<String> myData = new LimitedQueue<String>(1000);
		private List<ListDataListener> myListeners = new ArrayList<ListDataListener>();

		public OutputListModel() {
			super();
		}

		public void add(String theString) {
			myData.add(theString);
			for (ListDataListener next : myListeners) {
				next.contentsChanged(new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0, myData.size()));
			}
		}

		public void addListDataListener(ListDataListener theL) {
			myListeners.add(theL);
		}

		public String getElementAt(int theIndex) {
			String retVal = myData.get(theIndex);
			return retVal;
		}

		public int getSize() {
			int retVal = myData.size();
			return retVal;
		}

		public void removeListDataListener(ListDataListener theL) {
			myListeners.remove(theL);
		}

	}

	public class SortByComboBoxModel extends DefaultComboBoxModel {
		public SortByComboBoxModel() {
			addElement(CONTROL_ID);
			addElement(TIMESTAMP);
		}
	}

}
