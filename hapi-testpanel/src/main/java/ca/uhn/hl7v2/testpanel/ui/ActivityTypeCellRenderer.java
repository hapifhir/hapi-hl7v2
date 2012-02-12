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

import java.awt.Component;

import javax.swing.JTable;

import ca.uhn.hl7v2.testpanel.model.ActivityBase;
import ca.uhn.hl7v2.testpanel.model.ActivityIncomingBytes;
import ca.uhn.hl7v2.testpanel.model.ActivityIncomingMessage;
import ca.uhn.hl7v2.testpanel.model.ActivityInfo;
import ca.uhn.hl7v2.testpanel.model.ActivityInfoError;
import ca.uhn.hl7v2.testpanel.model.ActivityOutgoingBytes;
import ca.uhn.hl7v2.testpanel.model.ActivityOutgoingMessage;
import ca.uhn.hl7v2.testpanel.model.ActivityValidationOutcome;

public class ActivityTypeCellRenderer extends ActivityCellRendererBase {

	private String myOutgoingDescription;
	private String myIncomingDescription;
	private String myOutgoingBytesDescription;
	private String myIncomingBytesDescription;

	public ActivityTypeCellRenderer(ActivityTable theTablePanel, boolean theForIncomingInterface) {
		super(theTablePanel);
		
		if (theForIncomingInterface) {
			myIncomingDescription = "Incoming";
			myOutgoingDescription = "Response";
			myIncomingBytesDescription = "Incoming Bytes";
			myOutgoingBytesDescription = "Response Bytes";
		} else {
			myIncomingDescription = "Response";
			myOutgoingDescription = "Outgoing";
			myIncomingBytesDescription = "Response Bytes";
			myOutgoingBytesDescription = "Outgoing Bytes";
		}
		
//		myContainerPanel.add(this, BorderLayout.WEST);
//		
//		myActionsLabel = new JLabel("Actions ");
//		myActionsLabel.setForeground(Color.blue);
//		
//		myContainerPanel.add(myActionsLabel, BorderLayout.EAST);
	}

	@Override
	public Component getTableCellRendererComponent(JTable theTable, Object theValue, boolean theIsSelected, boolean theHasFocus, int theRow, int theColumn) {
		super.getTableCellRendererComponent(theTable, theValue, theIsSelected, theHasFocus, theRow, theColumn);

		ActivityBase obj = (ActivityBase) theValue;
//		boolean actionLabelVisible = false;
		
		if (obj instanceof ActivityIncomingMessage) {
			setText(myIncomingDescription);
			setIcon(ImageFactory.getMessageIn());
//			actionLabelVisible = true;
		} else if (obj instanceof ActivityOutgoingMessage) {
			setText(myOutgoingDescription);
			setIcon(ImageFactory.getMessageOut());
//			actionLabelVisible = true;
		} else if (obj instanceof ActivityIncomingBytes) {
			setText(myIncomingBytesDescription);
			setIcon(ImageFactory.getMessageIn());
		} else if (obj instanceof ActivityOutgoingBytes) {
			setText(myOutgoingBytesDescription);
			setIcon(ImageFactory.getMessageOut());
		} else if (obj instanceof ActivityValidationOutcome) {
			ActivityValidationOutcome v = (ActivityValidationOutcome)obj;
			if (v.isValidated()) {
				setIcon(ImageFactory.getValPassedGreen());
			} else {
				setIcon(ImageFactory.getValFailed());
			}
			setText("Validation");
//			setIcon(null);
		} else if (obj instanceof ActivityInfoError) {
			setText("Error");
			setIcon(null);
		} else if (obj instanceof ActivityInfo) {
			setText("Info");
			setIcon(null);
		} else {
			setIcon(null);
		}

//		myActionsLabel.setVisible(actionLabelVisible);
//		myContainerPanel.setBackground(this.getBackground());
//		
//		return myContainerPanel;

		return this;
	}

}
