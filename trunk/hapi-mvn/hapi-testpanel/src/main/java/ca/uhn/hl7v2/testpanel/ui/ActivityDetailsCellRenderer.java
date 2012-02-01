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
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JTable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.testpanel.model.ActivityBytesBase;
import ca.uhn.hl7v2.testpanel.model.ActivityInfo;
import ca.uhn.hl7v2.testpanel.model.ActivityInfoError;
import ca.uhn.hl7v2.testpanel.model.ActivityMessage;
import ca.uhn.hl7v2.testpanel.util.FormatUtil;
import ca.uhn.hl7v2.testpanel.xsd.Hl7V2EncodingTypeEnum;

public class ActivityDetailsCellRenderer extends ActivityCellRendererBase {

	private static final Logger ourLog = LoggerFactory.getLogger(ActivityDetailsCellRenderer.class);

	private Font myFixedWidthFont;
	private Font myVarWidthFont;

	public ActivityDetailsCellRenderer(ActivityTable theTablePanel) {
		super(theTablePanel);

		myFixedWidthFont = new Font("Lucida Console", Font.PLAIN, 12);
		myVarWidthFont = new Font("Lucida", Font.PLAIN, 12);
	}

	@Override
	public Component getTableCellRendererComponent(final JTable theTable, Object theValue, boolean theIsSelected, boolean theHasFocus, int theRow, int theColumn) {
		super.getTableCellRendererComponent(theTable, theValue, theIsSelected, theHasFocus, theRow, theColumn);

		if (theValue instanceof ActivityInfo) {

			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("<html>");

			if (theValue instanceof ActivityInfoError) {
				stringBuilder.append("<font color=\"#800000\">");
			}
			
			stringBuilder.append("<nobr>");
			stringBuilder.append(((ActivityInfo) theValue).getMessage());
			stringBuilder.append("</nobr>");
			
			if (theValue instanceof ActivityInfoError) {
				stringBuilder.append("</font>");
			}

			stringBuilder.append("</html>");
			String text = stringBuilder.toString();

			setText(text);
			setFont(myVarWidthFont);

		} else if (theValue instanceof ActivityMessage) {
			
			ActivityMessage msg = (ActivityMessage) theValue;
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
			setFont(myFixedWidthFont);

		} else if (theValue instanceof ActivityBytesBase) {

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

		}

		int prefHeight = getPreferredSize().height;
		prefHeight = Math.max(prefHeight, 10);
		if (prefHeight != theTable.getRowHeight(theRow)) {
			ourLog.trace("Setting height of row {} to {}", theRow, prefHeight);
			theTable.setRowHeight(theRow, prefHeight);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				int minWidth = getPreferredSize().width + 200;

				if (minWidth > theTable.getColumnModel().getColumn(2).getWidth()) {
					theTable.getColumnModel().getColumn(2).setMinWidth(getPreferredSize().width);
					theTable.getColumnModel().getColumn(2).setMaxWidth(getPreferredSize().width);
					theTable.getColumnModel().getColumn(2).setPreferredWidth(getPreferredSize().width);
				}
			}});

		return this;
	}

}
