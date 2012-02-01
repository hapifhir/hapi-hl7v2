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
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ca.uhn.hl7v2.testpanel.model.OutboundConnection;
import ca.uhn.hl7v2.testpanel.util.IOkCancelCallback;

public class CreateOutboundConnectionDialog extends JDialog implements IDestroyable {

	private Hl7ConnectionPanel myConnectionPanel;
	private final JPanel mycontentPanel = new JPanel();
	private boolean myDone;

	/**
	 * Create the dialog.
	 * 
	 * @param theHandler
	 */
	public CreateOutboundConnectionDialog(final OutboundConnection theConnection, final IOkCancelCallback<OutboundConnection> theHandler) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (!myDone) {
					theHandler.cancel(theConnection);
				}
			}
		});
		setModal(true);
		setBounds(100, 100, 687, 397);
		getContentPane().setLayout(new BorderLayout());
		mycontentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(mycontentPanel, BorderLayout.CENTER);
		mycontentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						theHandler.ok(theConnection);
						myDone = true;
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						theHandler.cancel(theConnection);
						myDone = true;
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

		myConnectionPanel = new Hl7ConnectionPanel();
		myConnectionPanel.setConnection(theConnection);
//		myConnectionPanel.markDisableStartingAndStopping();
//		myConnectionPanel.setLabelText("Create a new connection to send messages to");

		mycontentPanel.add(myConnectionPanel, BorderLayout.CENTER);

	}

	public void destroy() {
		myConnectionPanel.destroy();
	}

}
