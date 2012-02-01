package ca.uhn.hl7v2.testpanel.ui.conf;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import ca.uhn.hl7v2.testpanel.model.conf.Table;
import ca.uhn.hl7v2.testpanel.model.conf.TableFile;
import ca.uhn.hl7v2.testpanel.ui.ImageFactory;

public class TableTreeRenderer extends DefaultTreeCellRenderer {

	@Override
	public Component getTreeCellRendererComponent(JTree theTree, Object theValue, boolean theSel, boolean theExpanded, boolean theLeaf, int theRow, boolean theHasFocus) {
		super.getTreeCellRendererComponent(theTree, theValue, theSel, theExpanded, theLeaf, theRow, theHasFocus);
		
		StringBuilder b = new StringBuilder();
		b.append("<html>");
		
		if (!theHasFocus) {
			setBackground(Color.white);
		}
		
		Object obj = ((DefaultMutableTreeNode)theValue).getUserObject();
		if (obj instanceof TableFile) {
			TableFile tf = (TableFile)obj;
			b.append(tf.getName());
			b.append(" (");
			b.append(tf.getFileName());
			b.append(")");
			setIcon(ImageFactory.getFile());
		} else if (obj instanceof Table) {
			Table t = (Table)obj;
			b.append(t.getCodeSystemName());
			b.append(" (");
			b.append(t.getCodeSystemId());
			b.append(") ");
			b.append(t.getCodes().size());
			b.append(" code");
			if (t.getCodes().size() != 1) {
				b.append('s');
			}
			setIcon(ImageFactory.getTable());
		} else {
			setIcon(null);
		}
		
		b.append("</html>");
		setText(b.toString());
		
		return this;
	}

}
