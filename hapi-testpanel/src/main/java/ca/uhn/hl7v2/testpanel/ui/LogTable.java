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
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;

import ca.uhn.hl7v2.testpanel.util.SwingLogAppender;
import ca.uhn.hl7v2.testpanel.util.SwingLogAppender.ILogListener;

public class LogTable extends JScrollPane {
	private static final Color CLR_NORMAL = Color.black;
	private static final Color CLR_ERROR = new Color(1.0f, 0.0f, 0.0f);
	private static final Color CLR_WARN = new Color(0.5f, 0.5f, 0.0f);

	private JTable myLogTable;
	private Model myModel;

	public LogTable() {
		this("");
	}
	
	public LogTable(String theNdc) {
		
		myLogTable = new JTable();
        myLogTable.setFillsViewportHeight(true);
        myLogTable.setShowHorizontalLines(false);
        myLogTable.setShowVerticalLines(false);
        
        setViewportView(myLogTable);
		
        myModel = new Model();
        myLogTable.setModel(myModel);
        myLogTable.setDefaultRenderer(Object.class, new Renderer());
        
        myLogTable.getColumnModel().getColumn(0).setMaxWidth(60);
        myLogTable.getColumnModel().getColumn(0).setPreferredWidth(60);
        myLogTable.getColumnModel().getColumn(1).setMaxWidth(120);
        myLogTable.getColumnModel().getColumn(1).setPreferredWidth(120);
        
        SwingLogAppender.addListener(theNdc, myModel);
	}

	private class Renderer extends DefaultTableCellRenderer
	{


		/**
		 * {@inheritDoc}
		 */
		@Override
		public Component getTableCellRendererComponent(JTable theTable, Object theValue, boolean theIsSelected, boolean theHasFocus, int theRow, int theColumn) {
			Component retVal = super.getTableCellRendererComponent(theTable, theValue, theIsSelected, theHasFocus, theRow, theColumn);
			
			Level level = (Level) myModel.getValueAt(theRow, 0);
			if (level == Level.WARN) {
				retVal.setForeground(CLR_WARN);
			} else if (level == Level.ERROR || level == Level.FATAL) {
				retVal.setForeground(CLR_ERROR);
			} else {
				retVal.setForeground(CLR_NORMAL);
			}
			
			if (theColumn == 0) {
				String levelName;
				if (level == Level.INFO) {
					levelName = "INFO";
				} else if (level == Level.WARN) {
					levelName = "WARN";
				} else if (level == Level.ERROR) {
					levelName = "ERROR";
				} else if (level == Level.FATAL) {
					levelName = "FATAL";
				} else if (level == Level.DEBUG) {
					levelName = "DEBUG";
				} else if (level == Level.ALL) {
					levelName = "ALL";
				} else if (level == Level.TRACE) {
					levelName = "TRACE";
				} else {
					levelName = "UNKNOWN";
				}
				setText(levelName);
			}
			
			return retVal;
		}
		
	}
	
	private class Model extends DefaultTableModel implements ILogListener
	{
		private SimpleDateFormat ourDateFmt = new SimpleDateFormat("HH:mm:ss.SSS");
		
		public Model() {
			addColumn("Level");
			addColumn("Time");
			addColumn("Log");
		}

		public void handle(LoggingEvent theEvent, String theFormattedLine) {
			
			String date = ourDateFmt.format(new Date(theEvent.getTimeStamp()));
			Level level = theEvent.getLevel();
			super.addRow(new Object[] {level, date, theEvent.getMessage()});
			
			SwingUtilities.invokeLater(new Runnable() {

				public void run() {
					JScrollBar vsb = LogTable.this.getVerticalScrollBar();
					vsb.setValue(vsb.getMaximum());
				}});
		}
		
	}
	
}
