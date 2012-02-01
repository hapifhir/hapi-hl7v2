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
package ca.uhn.hl7v2.testpanel.controller;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

import javax.xml.bind.JAXB;

import org.apache.commons.io.output.StringBuilderWriter;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.testpanel.model.conf.ProfileGroup;
import ca.uhn.hl7v2.testpanel.model.conf.ProfileGroup;
import ca.uhn.hl7v2.testpanel.util.FontUtil;
import ca.uhn.hl7v2.testpanel.util.LineEndingsEnum;
import ca.uhn.hl7v2.util.StringUtil;

public class Prefs {

	private static final String GET_OPEN_PATH_CONFORMANCE_PROFILE = "getOpenPathConformanceProfile";
	private static final String GET_HL7_EDITOR_SPLIT = "getHl7EditorSplit";
	private static final String GET_OPEN_PATH_MESSAGES = "getOpenPathMessages";
	private static final String GET_RECENT_MESSAGE_FILES = "getRecentMessageFiles";
	private static final Preferences ourPrefs = Preferences.userNodeForPackage(Prefs.class);
	private static final String GET_SAVE_PATH_MESSAGES = "getSavePathMessages";
	private static final String GET_SAVE_LINE_ENDINGS = "getSaveLineEndings";
	private static final String GET_OPENSAVE_CHARSET = "getOpenOrSaveCharset";
	private static final String GET_OPEN_TABLE_FILES = "getOpenTableFiles";
	private static final String GET_OPEN_PROFILE_FILES = "getOpenProfileFiles";
	private static final String GET_SAVE_STRIP_COMMENTS = "getSaveStripComments";
	private static final String GET_SHOW_LOG_CONSOLE = "getShowLogConsole";
	private static final String GET_OUTBOUND_CONNECTION_LIST = "getOutboundConnectionList";
	private static final String GET_INBOUND_CONNECTION_LIST = "getInboundConnectionList";
	private static final String GET_WINDOW_MAXIMIZED = "getWindowMaximized";
	private static final String GET_WINDOW_POSITIONX = "getWindowPositionX";
	private static final String GET_WINDOW_POSITIONY = "getWindowPositionY";
	private static final String GET_WINDOW_POSITIONH = "getWindowPositionH";
	private static final String GET_WINDOW_POSITIONW = "getWindowPositionW";
	private static Font myHl7EditorFont;

	private static final Logger ourLog = LoggerFactory.getLogger(Prefs.class);

	/** Non instantiable */
	private Prefs() {

	}

	public static String getOpenPathConformanceProfile() {
		return ourPrefs.get(GET_OPEN_PATH_CONFORMANCE_PROFILE, ".");
	}

	public static String getOpenPathMessages() {
		return ourPrefs.get(GET_OPEN_PATH_MESSAGES, ".");
	}

	public static File getTempWorkfilesDirectory() throws IOException {
		File testPanelHome = getTestpanelHomeDirectory();
		File retVal = new File(testPanelHome, "workfiles");
		retVal.mkdirs();
		return retVal;

		// String path = ourPrefs.get(GET_TEMP_WORKFILES_DIRECTORY, null);
		// File retVal;
		// if (path == null) {
		// retVal = File.createTempFile("hapi_testpanel_work", "");
		// retVal.delete();
		// retVal.mkdirs();
		// } else {
		// retVal = new File(path);
		// if (retVal.exists() == false || retVal.isDirectory() == false) {
		// retVal.delete();
		// retVal = File.createTempFile("hapi_testpanel_work", "");
		// retVal.delete();
		// retVal.mkdirs();
		// }
		// }
		// ourPrefs.put(GET_TEMP_WORKFILES_DIRECTORY, retVal.getAbsolutePath());
		// return retVal;
	}

	public static File getTestpanelHomeDirectory() {
		File userHome = new File(System.getProperty("user.home"));
		File testPanelHome = new File(userHome, "HapiTestPanel");
		return testPanelHome;
	}

	public static void setOpenPathConformanceProfile(String theValue) {
		StringUtil.validateNotEmpty(theValue);

		if (theValue.lastIndexOf(File.separatorChar) > 0) {
			theValue = theValue.substring(0, theValue.lastIndexOf(File.separatorChar));
		}

		ourPrefs.put(GET_OPEN_PATH_CONFORMANCE_PROFILE, theValue);
	}

	public static void setOpenPathMessages(String theValue) {
		StringUtil.validateNotEmpty(theValue);

		if (theValue.lastIndexOf(File.separatorChar) > 0) {
			theValue = theValue.substring(0, theValue.lastIndexOf(File.separatorChar));
		}

		ourPrefs.put(GET_OPEN_PATH_MESSAGES, theValue);
	}

	public static String getSavePathMessages() {
		return ourPrefs.get(GET_SAVE_PATH_MESSAGES, ".");
	}

	public static void setSavePathMessages(String theValue) {
		StringUtil.validateNotEmpty(theValue);

		if (theValue.lastIndexOf(File.separatorChar) > 0) {
			theValue = theValue.substring(0, theValue.lastIndexOf(File.separatorChar));
		}

		ourPrefs.put(GET_SAVE_PATH_MESSAGES, theValue);
	}

	public static void setSaveLineEndings(LineEndingsEnum theValue) {
		Validate.notNull(theValue);
		ourPrefs.put(GET_SAVE_LINE_ENDINGS, theValue.name());
	}

	public static LineEndingsEnum getSaveLineEndings() {
		String savedVal = ourPrefs.get(GET_SAVE_LINE_ENDINGS, LineEndingsEnum.HL7.name());
		LineEndingsEnum retVal;
		try {
			retVal = LineEndingsEnum.valueOf(savedVal);
		} catch (Exception e) {
			retVal = LineEndingsEnum.HL7;
		}
		return retVal;
	}

	public static void setSaveStripComments(boolean theValue) {
		Validate.notNull(theValue);
		ourPrefs.putBoolean(GET_SAVE_STRIP_COMMENTS, theValue);
	}

	public static boolean getSaveStripComments() {
		boolean retVal = ourPrefs.getBoolean(GET_SAVE_STRIP_COMMENTS, false);
		return retVal;
	}

	public static List<File> getOpenTableFiles() {
		ArrayList<File> retVal = new ArrayList<File>();
		String[] savedVals = ourPrefs.get(GET_OPEN_TABLE_FILES, "").split("\\n");
		for (String string : savedVals) {
			if (StringUtils.isNotBlank(string)) {
				retVal.add(new File(string));
			}
		}
		return retVal;
	}

	public static void setOpenTableFiles(List<File> theFiles) {
		StringBuilder b = new StringBuilder();
		for (File file : theFiles) {
			b.append(file.getAbsolutePath());
			b.append("\n");
		}
		ourPrefs.put(GET_OPEN_TABLE_FILES, b.toString());
	}

	public static Charset getOpenOrSaveCharset() {
		String defaultVal = Charset.defaultCharset().name();
		String savedVal = ourPrefs.get(GET_OPENSAVE_CHARSET, defaultVal);

		Charset retVal;
		try {
			retVal = Charset.forName(savedVal);
		} catch (Exception e) {
			retVal = Charset.defaultCharset();
		}
		return retVal;
	}

	public static void setOpenOrSaveCharset(Charset theValue) {
		Validate.notNull(theValue);
		ourPrefs.put(GET_OPENSAVE_CHARSET, theValue.name());
	}

	public static boolean getShowLogConsole() {
		boolean retVal = ourPrefs.getBoolean(GET_SHOW_LOG_CONSOLE, false);
		return retVal;
	}

	public static void setShowLogConsole(boolean theValue) {
		Validate.notNull(theValue);
		ourPrefs.putBoolean(GET_SHOW_LOG_CONSOLE, theValue);
	}

	public static String getOutboundConnectionList() {
		String retVal = ourPrefs.get(GET_OUTBOUND_CONNECTION_LIST, null);
		return retVal;
	}

	public static void setOutboundConnectionList(String theValue) {
		Validate.notNull(theValue);
		ourPrefs.put(GET_OUTBOUND_CONNECTION_LIST, theValue);
	}

	public static String getInboundConnectionList() {
		String retVal = ourPrefs.get(GET_INBOUND_CONNECTION_LIST, null);
		return retVal;
	}

	public static void setInboundConnectionList(String theValue) {
		Validate.notNull(theValue);
		ourPrefs.put(GET_INBOUND_CONNECTION_LIST, theValue);
	}

	public static void setWindowMaximized(boolean theWindowMaximized) {
		ourPrefs.putBoolean(GET_WINDOW_MAXIMIZED, theWindowMaximized);
	}

	public static boolean getWindowMaximized() {
		return ourPrefs.getBoolean(GET_WINDOW_MAXIMIZED, false);
	}

	public static void setWindowDimension(Dimension theDimension) {
		assert theDimension != null;

		ourPrefs.putInt(GET_WINDOW_POSITIONH, theDimension.height);
		ourPrefs.putInt(GET_WINDOW_POSITIONW, theDimension.width);
	}

	/**
	 * Returns (0,0) if nothing was stored
	 */
	public static Dimension getWindowDimension() {
		int width = ourPrefs.getInt(GET_WINDOW_POSITIONW, 0);
		int height = ourPrefs.getInt(GET_WINDOW_POSITIONH, 0);
		return new Dimension(width, height);
	}

	public static void setWindowPosition(Point thePosition) {
		assert thePosition != null;

		ourPrefs.putInt(GET_WINDOW_POSITIONX, thePosition.x);
		ourPrefs.putInt(GET_WINDOW_POSITIONY, thePosition.y);
	}

	/**
	 * Returns (-1,-1) if nothing was stored
	 */
	public static Point getWindowPosition() {
		int x = ourPrefs.getInt(GET_WINDOW_POSITIONX, -1);
		int y = ourPrefs.getInt(GET_WINDOW_POSITIONY, -1);
		return new Point(x, y);
	}

	public static Font getHl7EditorFont() {
		if (myHl7EditorFont == null) {
			List<String> fonts = FontUtil.getMonospacedFontNames();
			if (fonts.contains("Monaco")) {
				myHl7EditorFont = new Font("Monaco", Font.PLAIN, 12);
			} else if (fonts.contains("Andale Mono")) {
				myHl7EditorFont = new Font("Andale Mono", Font.PLAIN, 12);
			} else if (fonts.contains("Lucida Console")) {
				myHl7EditorFont = new Font("Lucida Console", Font.PLAIN, 12);
			} else if (fonts.contains("Consolas")) {
				myHl7EditorFont = new Font("Consolas", Font.PLAIN, 12);
			} else if (fonts.contains("Lucida Sans Typewriter")) {
				myHl7EditorFont = new Font("Lucida Sans Typewriter", Font.PLAIN, 12);
			} else {
				myHl7EditorFont = new Font("Monospace", Font.PLAIN, 12);
			}

			ourLog.info("Got font for HL7 editor: {}", myHl7EditorFont);
		}

		return myHl7EditorFont;
	}

	public static void setHl7EditorSplit(double theRatio) {
		theRatio = enforceHl7EditorSplitLimits(theRatio);
		ourPrefs.putDouble(GET_HL7_EDITOR_SPLIT, theRatio);
	}

	private static double enforceHl7EditorSplitLimits(double theRatio) {
		theRatio = Math.min(0.8, theRatio);
		theRatio = Math.max(0.2, theRatio);
		return theRatio;
	}

	public static double getHl7EditorSplit() {
		double retVal = ourPrefs.getDouble(GET_HL7_EDITOR_SPLIT, 0.4);
		return enforceHl7EditorSplitLimits(retVal);
	}

	public static File getDefaultTableFileDirectory() {
		File testPanelHome = getTestpanelHomeDirectory();
		File retVal = new File(testPanelHome, "tables");
		retVal.mkdirs();
		return retVal;
	}

	public static List<String> getRecentMessageFiles() {
		ArrayList<String> retVal = new ArrayList<String>();
		String[] savedVals = ourPrefs.get(GET_RECENT_MESSAGE_FILES, "").split("\\n");
		for (String string : savedVals) {
			if (StringUtils.isNotBlank(string)) {
				retVal.add(string);
			}
		}
		return retVal;
	}

	public static void addMessagesFileToRecents(List<String> theMessageFiles) {
		List<String> current = getRecentMessageFiles();
		for (String next : theMessageFiles) {
			if (current.contains(next) == false) {
				current.add(0, next);
			}
		}

		if (current.size() > 10) {
			current = current.subList(0, 10);
		}

		StringBuilder b = new StringBuilder();
		for (String string : current) {
			b.append(string).append('\n');
		}
		ourPrefs.put(GET_RECENT_MESSAGE_FILES, b.toString());
	}

	public static List<ProfileGroup> getOpenProfiles() {
		ArrayList<ProfileGroup> retVal = new ArrayList<ProfileGroup>();
		String[] parts = ourPrefs.get(GET_OPEN_PROFILE_FILES, "").split("\\n\\n\\n");
		for (String next : parts) {
			if (StringUtils.isNotBlank(next)) {
				try {
					retVal.add(JAXB.unmarshal(new StringReader(next), ProfileGroup.class));
				} catch (Exception e) {
					ourLog.error("Failed to unmarshall profile file", e);
				}
			}
		}
		return retVal;
	}

	public static void setOpenProfiles(List<ProfileGroup> theProfiles) {
		StringBuilder b = new StringBuilder();
		for (ProfileGroup profileProxy : theProfiles) {
			StringWriter w = new StringWriter();
			JAXB.marshal(profileProxy, w);
			b.append(w.toString());
			b.append("\n\n\n");
		}
		ourPrefs.put(GET_OPEN_TABLE_FILES, b.toString());
	}
}
