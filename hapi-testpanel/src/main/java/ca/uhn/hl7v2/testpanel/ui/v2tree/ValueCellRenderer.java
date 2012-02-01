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
package ca.uhn.hl7v2.testpanel.ui.v2tree;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import ca.uhn.hl7v2.testpanel.ui.v2tree.Hl7V2MessageTree.TreeNodeBase;
import ca.uhn.hl7v2.testpanel.ui.v2tree.Hl7V2MessageTree.TreeNodeGroupBase;
import ca.uhn.hl7v2.testpanel.ui.v2tree.Hl7V2MessageTree.TreeNodeSegment;
import ca.uhn.hl7v2.testpanel.ui.v2tree.Hl7V2MessageTree.TreeNodeType;
import ca.uhn.hl7v2.testpanel.util.FormatUtil;

class ValueCellRenderer extends DefaultTableCellRenderer {

	/**
	 * 
	 */
	private final Hl7V2MessageTree myTree;

	/**
	 * @param theHl7v2MessageTree
	 */
	ValueCellRenderer(Hl7V2MessageTree theHl7v2MessageTree) {
		myTree = theHl7v2MessageTree;
	}

	@Override
	public Component getTableCellRendererComponent(JTable theTable, Object theValue, boolean theIsSelected, boolean theHasFocus, int theRow, int theColumn) {
		super.getTableCellRendererComponent(theTable, null, theIsSelected, theHasFocus, theRow, theColumn);

		if (theValue == null) {

			return this;

		} else if (theValue instanceof TreeNodeGroupBase) {

			TreeNodeGroupBase group = (TreeNodeGroupBase) theValue;
			int segs = group.countPopulatedSegments();

			switch (segs) {
			case 0:
				setText("<html><span style=\"color: #808080;\">(Empty)</span></html>");
				break;
			case 1:
				setText("<html><span style=\"color: #808080;\">(" + segs + " populated segment)</span></html>");
				break;
			default:
				setText("<html><span style=\"color: #808080;\">(" + segs + " populated segments)</span></html>");
				break;
			}
			return this;

		} else if (theValue instanceof TreeNodeType || theValue instanceof TreeNodeSegment) {
			String value = ((TreeNodeBase) theValue).getPipeEncodedValue();
			
			boolean isType = false;
			if (theValue instanceof TreeNodeType) {
				isType = true;
			} else if (theValue instanceof TreeNodeSegment) {
				if (!((TreeNodeSegment)theValue).isHasContent()) {
					setText("<html><span style=\"color: #808080;\">" + value + "</span></html>");
					return this;
				}
			}

			String html = FormatUtil.formatEr7(value, isType);
			setText(html);
			return this;

		} else {

			TreeNodeBase base = (TreeNodeBase) theValue;
			setText(base.getPipeEncodedValue());
			return this;

		}

	}

}