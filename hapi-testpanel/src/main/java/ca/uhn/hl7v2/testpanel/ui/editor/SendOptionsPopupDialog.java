package ca.uhn.hl7v2.testpanel.ui.editor;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.text.NumberFormat;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;

import ca.uhn.hl7v2.testpanel.model.msg.Hl7V2MessageCollection;
import ca.uhn.hl7v2.testpanel.ui.HoverButtonMouseAdapter;
import ca.uhn.hl7v2.testpanel.util.SimpleDocumentListener;

public class SendOptionsPopupDialog extends JDialog {

	private final JPanel mycontentPanel = new JPanel();
	private JButton mySendOptionsButton;
	private HoverButtonMouseAdapter mySendOptionsHoverAdaptor;
	private Hl7V2MessageCollection myMessage;

	/**
	 * Create the dialog.
	 */
	public SendOptionsPopupDialog(Hl7V2MessageEditorPanel theParent, Hl7V2MessageCollection theMessage, JButton theSendOptionsButton, HoverButtonMouseAdapter theSendOptionsHoverAdaptor) {
		super(theParent.getWindow());

		mySendOptionsButton = theSendOptionsButton;
		mySendOptionsHoverAdaptor = theSendOptionsHoverAdaptor;
		myMessage = theMessage;

		mySendOptionsButton.setBorderPainted(true);
		mySendOptionsHoverAdaptor.setEnabled(false);

		setUndecorated(true);
		setBounds(100, 100, 234, 114);
		getContentPane().setLayout(new BorderLayout());
		mycontentPanel.setBorder(null);
		getContentPane().add(mycontentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		mycontentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblSendOptions = new JLabel("Send Options");
			GridBagConstraints gbc_lblSendOptions = new GridBagConstraints();
			gbc_lblSendOptions.gridwidth = 2;
			gbc_lblSendOptions.insets = new Insets(0, 0, 5, 0);
			gbc_lblSendOptions.gridx = 0;
			gbc_lblSendOptions.gridy = 0;
			mycontentPanel.add(lblSendOptions, gbc_lblSendOptions);
		}
		{
			Component verticalStrut = Box.createVerticalStrut(20);
			verticalStrut.setPreferredSize(new Dimension(0, 10));
			verticalStrut.setMinimumSize(new Dimension(0, 10));
			verticalStrut.setMaximumSize(new Dimension(32767, 10));
			GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
			gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
			gbc_verticalStrut.gridx = 0;
			gbc_verticalStrut.gridy = 1;
			mycontentPanel.add(verticalStrut, gbc_verticalStrut);
		}
		{
			JLabel lblNumberOfTimes = new JLabel("Send # Times:");
			GridBagConstraints gbc_lblNumberOfTimes = new GridBagConstraints();
			gbc_lblNumberOfTimes.insets = new Insets(0, 0, 0, 5);
			gbc_lblNumberOfTimes.anchor = GridBagConstraints.EAST;
			gbc_lblNumberOfTimes.gridx = 0;
			gbc_lblNumberOfTimes.gridy = 2;
			mycontentPanel.add(lblNumberOfTimes, gbc_lblNumberOfTimes);
		}
		{
			final JFormattedTextField sendTimes = new JFormattedTextField(NumberFormat.getIntegerInstance());
			sendTimes.setText(Integer.toString(myMessage.getSendNumberOfTimes()));
			GridBagConstraints gbc_mySendTimes = new GridBagConstraints();
			gbc_mySendTimes.fill = GridBagConstraints.HORIZONTAL;
			gbc_mySendTimes.gridx = 1;
			gbc_mySendTimes.gridy = 2;
			mycontentPanel.add(sendTimes, gbc_mySendTimes);
			sendTimes.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent theE) {
					if (theE.getKeyCode() == KeyEvent.VK_ENTER || theE.getKeyCode() == KeyEvent.VK_ESCAPE) {
						doHide();
					}
				}
			});
			sendTimes.getDocument().addDocumentListener(new SimpleDocumentListener() {
				@Override
				public void update(DocumentEvent theE) {
					String newTValue = sendTimes.getText();
					int newValue = 1;
					try {
						newValue = Integer.parseInt(newTValue);
					} catch (Exception e) {
						// ignore
					}
					if (newValue < 1) {
						newValue = 1;
					}
					myMessage.setSendNumberOfTimes(newValue);
					final String repTValue = Integer.toString(newValue);
					if (!newTValue.equals(sendTimes.getText())) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								sendTimes.setText(repTValue);
							}
						});
					}
				}
			});
		}

		addWindowFocusListener(new WindowFocusListener() {

			@Override
			public void windowGainedFocus(WindowEvent theE) {
				ourLog.info("Focus gained");
			}

			@Override
			public void windowLostFocus(WindowEvent theE) {
				ourLog.info("Focus lost");
				SendOptionsPopupDialog.this.setVisible(false);
				mySendOptionsButton.setBorderPainted(false);
				mySendOptionsHoverAdaptor.setEnabled(true);
			}
		});

	}

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(SendOptionsPopupDialog.class);

	public void doHide() {
		setVisible(false);
		mySendOptionsButton.setBorderPainted(false);
		mySendOptionsHoverAdaptor.setEnabled(false);
	}

}
