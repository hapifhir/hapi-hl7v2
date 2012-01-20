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
package ca.uhn.hl7v2.testpanel.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.swing.SwingUtilities;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.WriterAppender;
import org.apache.log4j.spi.LoggingEvent;

public class SwingLogAppender extends WriterAppender {

	private static Map<String, ArrayList<ILogListener>> listeners = new HashMap<String, ArrayList<ILogListener>>();

	private ConcurrentLinkedQueue<LoggingEvent> buf;

	public SwingLogAppender() {
		super();
		this.buf = new ConcurrentLinkedQueue<LoggingEvent>();
		setLayout(new PatternLayout(PatternLayout.TTCC_CONVERSION_PATTERN));
		BasicConfigurator.configure(this);
	}

	@Override
	public void append(LoggingEvent event) {
		buf.offer(event);

		// if (getLayout().ignoresThrowable()) {
		// String[] exception = event.getThrowableStrRep();
		// if (exception != null) {
		// for (String line : exception) {
		// buf.offer(line);
		// }
		// }
		// }
		display();
	}

	void display() {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				while (!buf.isEmpty()) {
					LoggingEvent next = buf.poll();
					String formattedLine = getLayout().format(next);
					String ndc = next.getNDC();
					fireEvent("", next, formattedLine);
					if (ndc != null) {
						fireEvent(ndc, next, formattedLine);
					}
				}
				buf.clear();
			}

		});
	}

	private void fireEvent(String theNdc, LoggingEvent theEvent, String theFormatted) {
		ArrayList<ILogListener> list = listeners.get(theNdc);
		if (list != null) {
			for (ILogListener next : list) {
				next.handle(theEvent, theFormatted);
			}
		}
	}

	public static void addListener(ILogListener theListener) {
		addListener("", theListener);
	}

	public static void addListener(String theNdc, ILogListener theListener) {
		if (!listeners.containsKey(theNdc)) {
			listeners.put(theNdc, new ArrayList<ILogListener>());
		}
		listeners.get(theNdc).add(theListener);
	}

	public static void removeListener(ILogListener theListener) {
		removeListener("", theListener);
	}

	public static void removeListener(String theNdc, ILogListener theListener) {
		listeners.get(theNdc).remove(theListener);
	}

	public interface ILogListener {

		void handle(LoggingEvent theEvent, String theFormattedLine);

	}

}
