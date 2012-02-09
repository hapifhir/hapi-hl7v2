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
package ca.uhn.hl7v2.testpanel;

import java.awt.EventQueue;
import java.lang.reflect.Method;

import javax.swing.UIManager;

import org.apache.log4j.xml.DOMConfigurator;

import ca.uhn.hl7v2.testpanel.controller.Controller;
import ca.uhn.hl7v2.testpanel.controller.Prefs;

public class App {
	
//	private static final Logger ourLog = LoggerFactory.getLogger(App.class);
	private static Controller myController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.setProperty("apple.laf.useScreenMenuBar", "true");
		System.setProperty("com.apple.mrj.application.apple.menu.about.name", "HAPI TestPanel");

		try {
			// Set System L&F
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		} 

		System.setProperty("tespanel.log.dir", Prefs.getTestpanelHomeDirectory().getAbsolutePath());
		DOMConfigurator.configure(App.class.getClassLoader().getResource("log4j_testpanel.xml"));
		
		myController = new Controller();
		
		// only do this setup if we know this is a Mac
		if (System.getProperty("os.name").startsWith("Mac OS X")) {
			try {
				Class<?> clazz = Class.forName("ca.uhn.hl7v2.testpanel.OSXInitializer");
				Method runMethod = clazz.getMethod("run", Controller.class);
				runMethod.invoke(clazz.newInstance(), myController);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// only do this setup if we know this is Windows
		if (System.getProperty("os.name").toLowerCase().contains("win")) {
			try {
				Class<?> clazz = Class.forName("ca.uhn.hl7v2.testpanel.WindowsInitializer");
				Method runMethod = clazz.getMethod("run", Controller.class);
				runMethod.invoke(clazz.newInstance(), myController);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					myController.start();
//					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
