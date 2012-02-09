package ca.uhn.hl7v2.testpanel.ui.conf;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.tree.DefaultMutableTreeNode;

import ca.uhn.hl7v2.testpanel.ui.ImageFactory;
import ca.uhn.hl7v2.testpanel.ui.conf.ConformanceEditorPanel.ProfileNode;

public class ProfilesTreeRenderer extends DefaultTableCellRenderer {

	private ConformanceEditorPanel myPanel;

	public ProfilesTreeRenderer(ConformanceEditorPanel thePanel) {
		myPanel = thePanel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.swing.table.DefaultTableCellRenderer#getTableCellRendererComponent
	 * (javax.swing.JTable, java.lang.Object, boolean, boolean, int, int)
	 */
	@Override
	public Component getTableCellRendererComponent(JTable theTable, Object theValue, boolean theIsSelected, boolean theHasFocus, int theRow, int theColumn) {
		Component retVal = super.getTableCellRendererComponent(theTable, theValue, theIsSelected, theHasFocus, theRow, theColumn);

		DefaultMutableTreeNode node = myPanel.getNodeForRow(theRow);
		if (node instanceof ProfileNode) {

			if (theColumn == ConformanceEditorPanel.MyProfilesRowModel.COL_TABLES + 1) {
				if (theValue != null) {
					setIcon(ImageFactory.getTable());
				} else {
					setText("None");
					setIcon(ImageFactory.getNo());
				}
			} else {
				setIcon(null);
			}
			setBorder(new LineBorder(Color.lightGray, 1, true));
			
		} else {
			
			setIcon(null);
			setBorder(null);
			
		}
		
		
		return this;
	}

}
