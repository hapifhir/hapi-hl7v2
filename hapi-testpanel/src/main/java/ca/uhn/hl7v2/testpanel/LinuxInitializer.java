package ca.uhn.hl7v2.testpanel;

import javax.swing.UIManager;

import ca.uhn.hl7v2.testpanel.controller.Controller;

public class LinuxInitializer {

	public void run(final Controller theController) {
		
		try {
			// Set System L&F
//			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		} 

		
	}

}
