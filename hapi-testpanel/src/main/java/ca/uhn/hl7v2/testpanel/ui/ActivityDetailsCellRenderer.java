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

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JScrollBar;
import javax.swing.JTable;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.testpanel.model.ActivityBytesBase;
import ca.uhn.hl7v2.testpanel.model.ActivityInfo;
import ca.uhn.hl7v2.testpanel.model.ActivityInfoError;
import ca.uhn.hl7v2.testpanel.model.ActivityMessage;
import ca.uhn.hl7v2.testpanel.model.ActivityValidationOutcome;
import ca.uhn.hl7v2.testpanel.util.FormatUtil;
import ca.uhn.hl7v2.testpanel.xsd.Hl7V2EncodingTypeEnum;

public class ActivityDetailsCellRenderer extends ActivityCellRendererBase {

	private static final Logger ourLog = LoggerFactory.getLogger(ActivityDetailsCellRenderer.class);

	private Font myFixedWidthFont;
	private Font myVarWidthFont;

	private boolean myScrollToBottom;

	public ActivityDetailsCellRenderer(ActivityTable theTablePanel) {
		super(theTablePanel);

		myFixedWidthFont = new Font("Lucida Console", Font.PLAIN, 12);
		myVarWidthFont = new Font("Lucida", Font.PLAIN, 12);
	}

	@Override
	public Component getTableCellRendererComponent(final JTable theTable, Object theValue, boolean theIsSelected, boolean theHasFocus, final int theRow, int theColumn) {
		super.getTableCellRendererComponent(theTable, theValue, theIsSelected, theHasFocus, theRow, theColumn);

		if (theValue instanceof ActivityInfo) {

			renderInfo(theTable, theValue, theRow);

		} else if (theValue instanceof ActivityMessage) {

			renderMessage(theTable, theValue, theRow, theIsSelected);

		} else if (theValue instanceof ActivityBytesBase) {

			renderBytes(theTable, theValue, theRow);

		} else if (theValue instanceof ActivityValidationOutcome) {

			renderValidation(theTable, (ActivityValidationOutcome) theValue, theRow);

		}

		// int prefHeight = getPreferredSize().height;
		// prefHeight = Math.max(prefHeight, 10);
		// if (prefHeight != theTable.getRowHeight(theRow)) {
		// ourLog.trace("Setting height of row {} to {}", theRow, prefHeight);
		// theTable.setRowHeight(theRow, prefHeight);
		// }

		// EventQueue.invokeLater(new Runnable() {
		// public void run() {
		// int minWidth = getPreferredSize().width + 200;
		//
		// if (minWidth > theTable.getColumnModel().getColumn(2).getWidth()) {
		// theTable.getColumnModel().getColumn(2).setMinWidth(getPreferredSize().width);
		// theTable.getColumnModel().getColumn(2).setMaxWidth(getPreferredSize().width);
		// theTable.getColumnModel().getColumn(2).setPreferredWidth(getPreferredSize().width);
		// }
		// }});

		// ourLog.info("Rendering row {}", theRow);

		// EventQueue.invokeLater(new Runnable() {
		// public void run() {
		// getTablePanel().
		// JScrollBar vsb = myscrollPane.getVerticalScrollBar();
		// vsb.setValue(vsb.getMaximum());
		// ourLog.info("Setting scrollbar to bottom: {}", vsb.getMaximum());
		// }
		// });
		if (myScrollToBottom) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					JScrollBar vsb = getTablePanel().getScrollPane().getVerticalScrollBar();
					int newValue = vsb.getMaximum();
					int existingValue = vsb.getValue();
					if (newValue != existingValue) {
						vsb.setValue(newValue);
						ourLog.debug("Setting scrollbar to bottom, from {} to {}", existingValue, newValue);
					}

					if (theRow == getTablePanel().getTableModel().getRowCount() - 1) {
						myScrollToBottom = false;
					}
				}
			});

		}

		return this;
	}

	private void renderValidation(JTable theTable, ActivityValidationOutcome theValue, int theRow) {
		if (theValue.isValidated()) {

			setText("No Errors");

		} else {

			StringBuilder b = new StringBuilder("<html>");

			b.append("<font color=\"#800000\">");
			b.append("<ul>");

			for (HL7Exception next : theValue.getIssues()) {
				b.append("<li>");
				if (StringUtils.isNotBlank(next.getSegmentName())) {
					b.append("<b>");
					b.append(next.getSegmentName());
					if (next.getSegmentRepetition() > 1) {
						b.append("(").append(next.getSegmentRepetition()).append(")");
					}
					if (next.getFieldPosition() > 0) {
						b.append("-");
						b.append(next.getFieldPosition());
					}
					b.append("</b>: ");
				}
				b.append("<nobr>").append(next.getMessage()).append("</nobr>");
				b.append("</li>");
			}

			b.append("</ul>");
			b.append("</font>");
			b.append("</html>");
			setText(b.toString());

		}

		updatePreferredHeight(theTable, theRow);

	}

	private void renderBytes(final JTable theTable, Object theValue, final int theRow) {
		ActivityBytesBase msg = (ActivityBytesBase) theValue;

		StringBuilder b = new StringBuilder();
		b.append("<html>");
		b.append("<table>");

		StringBuilder charsB = new StringBuilder();
		StringBuilder bytesB = new StringBuilder();

		byte[] bytes = msg.getBytes();
		for (int i = 0; i < bytes.length; i++) {

			if (i == 0) {
				b.append("<tr>");
			} else if (i % 20 == 0) {
				b.append("<td><nobr>");
				b.append(charsB.toString());
				for (int j = charsB.toString().length(); j < 20; j++) {
					b.append("&nbsp;");
				}
				b.append("</nobr></td><td><nobr>");
				b.append(bytesB.toString());
				b.append("</nobr></td></tr><tr>");
				charsB.setLength(0);
				bytesB.setLength(0);
			}

			byte nextByte = bytes[i];
			if (nextByte < 32) {
				charsB.append("&nbsp;");
			} else {
				charsB.append(new String(new byte[] { nextByte }));
			}

			String byteToString = Integer.toString(nextByte);
			if (nextByte < 32) {
				byteToString = "<font color=\"#FF0000\">" + byteToString + "</font>";
			}

			if (nextByte < 100) {
				bytesB.append("&nbsp;");
			}
			bytesB.append(byteToString).append("&nbsp;");

		}

		b.append("<td><nobr>");
		b.append(charsB.toString());
		for (int j = charsB.toString().length(); j < 20; j++) {
			b.append("&nbsp;");
		}
		b.append("</nobr></td><td><nobr>");
		b.append(bytesB.toString());
		b.append("</nobr></td></tr><tr>");
		b.append("</tr>");
		b.append("</table>");
		b.append("</html>");

		String rawMessage = b.toString();
		setText(rawMessage);
		setFont(myFixedWidthFont);
		setForeground(Color.black);

		updatePreferredHeight(theTable, theRow);
//		updateHeight(theTable, theRow);
	}

	private void renderInfo(final JTable theTable, Object theValue, final int theRow) {
		if (theValue instanceof ActivityInfoError) {
			setForeground(Color.red);
		} else {
			setForeground(Color.black);
		}

		String message = ((ActivityInfo) theValue).getMessage();
		setText(message);
		// setText(text);

		setFont(myVarWidthFont);

		if (theTable.getRowHeight(theRow) != theTable.getRowHeight()) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					theTable.setRowHeight(theRow, theTable.getRowHeight());
				}
			});
		}
	}

	private void renderMessage(final JTable theTable, Object theValue, final int theRow, boolean theSelected) {
		ActivityMessage msg = (ActivityMessage) theValue;

		if (theSelected) {

			String rawMessage;
			if (msg.getEncoding() == Hl7V2EncodingTypeEnum.XML) {
				StringBuilder b = new StringBuilder();
				b.append("<html>");

				String raw = msg.getRawMessage();
				for (int c = 0; c < raw.length(); c++) {
					char nextChar = raw.charAt(c);
					boolean isSpecial = nextChar == msg.getEncodingCharacters().getComponentSeparator();
					isSpecial |= nextChar == msg.getEncodingCharacters().getFieldSeparator();
					isSpecial |= nextChar == msg.getEncodingCharacters().getEscapeCharacter();
					isSpecial |= nextChar == msg.getEncodingCharacters().getRepetitionSeparator();
					isSpecial |= nextChar == msg.getEncodingCharacters().getSubcomponentSeparator();

					if (isSpecial) {
						b.append("<font color=\"#48A0A0\">");
					}

					switch (nextChar) {
					case '\r':
					case '\n':
						b.append("<br>");
						break;
					case ' ':
						b.append("&nbsp;");
						break;
					case '&':
						b.append("&amp;");
						break;
					case '<':
						b.append("&lt;");
						break;
					case '>':
						b.append("&gt;");
						break;
					default:
						b.append(nextChar);
					}

					if (isSpecial) {
						b.append("</font>");
					}

				}

				b.append("</html>");

				rawMessage = b.toString();

			} else {

				rawMessage = FormatUtil.formatEr7(msg.getRawMessage(), false).replace("\r", "<br>");

			}

			setText(rawMessage);

		} else {

			setText("<html>" + msg.getRawMessage().replace("\r", "<br>") + "</html>");
		}

		setBackground(Color.white);
		setForeground(Color.black);
		setFont(myFixedWidthFont);

		updatePreferredHeight(theTable, theRow);
	}

	private void updatePreferredHeight(final JTable theTable, final int theRow) {
		final int newHeight = (int) getPreferredSize().getHeight();
		if (theTable.getRowHeight(theRow) != newHeight) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					theTable.setRowHeight(theRow, newHeight);
				}
			});
		}
	}

	public void markScrollToBottom() {
		myScrollToBottom = true;
	}
}
