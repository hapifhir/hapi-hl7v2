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

import static org.apache.commons.lang.StringUtils.*;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.hoh.util.IOUtils;
import ca.uhn.hl7v2.testpanel.model.conf.ExportedProfileGroupFile;
import ca.uhn.hl7v2.testpanel.model.conf.ProfileFileList;
import ca.uhn.hl7v2.testpanel.model.conf.ProfileGroup;
import ca.uhn.hl7v2.testpanel.model.conf.TableFileList;
import ca.uhn.hl7v2.testpanel.model.msg.Hl7V2MessageCollection;
import ca.uhn.hl7v2.testpanel.model.msg.Hl7V2MessageCollection.XmlFormat;
import ca.uhn.hl7v2.testpanel.util.CharsetUtils;
import ca.uhn.hl7v2.testpanel.util.FileNameComparator;
import ca.uhn.hl7v2.testpanel.util.FontUtil;
import ca.uhn.hl7v2.testpanel.util.LineEndingsEnum;
import ca.uhn.hl7v2.util.StringUtil;

@XmlRootElement(name = "TestPanelPrefs", namespace = "urn:ca.uhn.hapi:testpanel:prefs")
@XmlAccessorType(XmlAccessType.FIELD)
public class Prefs {

	private static final String GET_EXPORT_PROFILE_GROUP_DIRECTORY = "getExportProfileGroupDirectory";
	private static final String GET_HL7_EDITOR_SPLIT = "getHl7EditorSplit";
	private static final String GET_HL7V2_DIFF_FILE1 = "getHl7V2DiffFile1";
	private static final String GET_HL7V2_DIFF_FILE2 = "getHl7V2DiffFile2";
	private static final String GET_HL7V2_DIFF_SHOW_WHOLE_MESSAGE_ON_ERROR = "getHl7V2DiffShowWholeMessageOnError";
	private static final String GET_HL7V2_DIFF_STOP_ON_FIRST_ERROR = "getHl7V2DiffStopOnFirstError";
	private static final String GET_HL7V2_SORT_BY = "getHl7V2SortBy";
	private static final String GET_HL7V2_SORT_INPUT = "getHl7V2SortInputFile";
	private static final String GET_HL7V2_SORT_OUTPUT = "getHl7V2SortOutputFile";
	private static final String GET_HL7V2_SORT_OVERWRITE_MODE = "getHl7V2SortOverwriteMode";
	private static final String GET_INBOUND_CONNECTION_LIST = "getInboundConnectionList";
	private static final String GET_INTERFACE_HOH_SECURITY_KEYSTORE_DIRECTORY = "getInterfaceHohSecurityKeystoreDirectory";
	private static final String GET_MOST_RECENT_CONNECTION_CHARSET = "getMostRecentConnectionCharset";
	private static final String GET_MOST_RECENTLY_SELECTED_ITEM_ID = "getMostRecentlySelectedItemId";
	private static final String GET_OPEN_PATH_CONFORMANCE_PROFILE = "getOpenPathConformanceProfile";
	private static final String GET_OPEN_PATH_MESSAGES = "getOpenPathMessages";
	private static final String GET_OPEN_TABLE_FILES = "getOpenTableFiles";
	private static final String GET_OPENSAVE_CHARSET = "getOpenOrSaveCharset";
	private static final String GET_OUTBOUND_CONNECTION_LIST = "getOutboundConnectionList";
	private static final String GET_RECENT_MESSAGE_FILES = "getRecentMessageFiles";
	private static final String GET_SAVE_LINE_ENDINGS = "getSaveLineEndings";
	private static final String GET_SAVE_PATH_MESSAGES = "getSavePathMessages";
	private static final String GET_SAVE_STRIP_COMMENTS = "getSaveStripComments";
	private static final String GET_SHOW_LOG_CONSOLE = "getShowLogConsole";
	private static final String GET_WINDOW_MAXIMIZED = "getWindowMaximized";
	private static final String GET_WINDOW_POSITIONH = "getWindowPositionH";
	private static final String GET_WINDOW_POSITIONW = "getWindowPositionW";
	private static final String GET_WINDOW_POSITIONX = "getWindowPositionX";
	private static final String GET_WINDOW_POSITIONY = "getWindowPositionY";

	private static Prefs ourInstance;
	private static JAXBContext ourJaxbContext;
	private static final Logger ourLog = LoggerFactory.getLogger(Prefs.class);
	private static final Preferences ourPrefs = Preferences.userNodeForPackage(ca.uhn.hl7v2.testpanel.controller.Prefs.class);
	private transient Controller myController;

	@XmlElement(name = "export_profile_group_directory")
	private String myExportProfileGroupDirectory;

	@XmlElement(name = "hl7v2_editor_split")
	private Integer myHl7EditorSplit;

	@XmlElement(name = "hl7v2_diff_file1")
	private String myHl7V2DiffFile1;

	@XmlElement(name = "hl7v2_diff_file2")
	private String myHl7V2DiffFile2;

	@XmlElement(name = "hl7v2_show_whole_message_on_error")
	private boolean myHl7V2DiffShowWholeMessageOnError;

	@XmlElement(name = "hl7v2_diff_stop_on_first_error")
	private boolean myHl7V2DiffStopOnFirstError;

	@XmlElement(name = "hl7v2_sort_by")
	private String myHl7V2SortBy;

	@XmlElement(name = "hl7v2_sort_input_file")
	private String myHl7V2SortInputFile;

	@XmlElement(name = "hl7v2_output_file")
	private String myHl7V2SortOutputFile;

	@XmlElement(name = "hl7v2_sort_override_mode")
	private String myHl7V2SortOverwriteMode;

	@XmlElement(name = "import_profile_group_directory")
	private String myImportProfileGroupDirectory;

	@XmlElement(name = "inbound_connection_list")
	private String myInboundConnectionList;

	@XmlElement(name = "interface_hoh_security_keystore_directory")
	private String myInterfaceHohSecurityKeystoreDirectory;

	private transient String myLastPrefsFileSaveValue;

	@XmlElement(name = "most_recent_communication_charset")
	private String myMostRecentConnectionCharset;

	@XmlElement(name = "most_recently_selected_item_id")
	private String myMostRecentlySelectedItemId;

	// private List<OpenImportedProfileGroupFile>
	// myOpenImportedProfileGroupFile;

	@XmlElement(name = "open_or_save_charset")
	private String myOpenOrSaveCharset;

	@XmlElement(name = "open_path_conformance_profile")
	private String myOpenPathConformanceProfile;

	@XmlElement(name = "open_path_messages")
	private String myOpenPathMessages;

	@XmlElement(name = "open_table_files")
	private ArrayList<String> myOpenTableFiles;

	@XmlElement(name = "outbound_connection_list")
	private String myOutboundConnectionList;

	@XmlElement(name = "recent_message_xml_files")
	private List<XmlFormat> myRecentMessageXmlFiles;

	@XmlElement(name = "save_line_endings")
	private String mySaveLineEndings;

	@XmlElement(name = "save_path_messages")
	private String mySavePathMessages;

	@XmlElement(name = "save_strip_comments")
	private boolean mySaveStripComments;

	@XmlElement(name = "show_log_console")
	private boolean myShowLogConsole;

	@XmlElement(name = "window_maximized")
	private boolean myWindowMaximized;

	@XmlElement(name = "window_position_h")
	private int myWindowPositionH;

	@XmlElement(name = "window_position_w")
	private int myWindowPositionW;

	@XmlElement(name = "window_position_x")
	private Integer myWindowPositionX;

	@XmlElement(name = "window_position_y")
	private Integer myWindowPositionY;

	/**
	 * Non instantiable
	 */
	private Prefs() {
	}

	public void addMessagesFileXmlToRecents(ProfileFileList theProfileFileList, List<Hl7V2MessageCollection> theMessageFiles) {
		List<Hl7V2MessageCollection> current = getRecentMessageXmlFiles(theProfileFileList);
		for (Hl7V2MessageCollection next : theMessageFiles) {
			if (StringUtils.isBlank(next.getSaveFileName())) {
				continue;
			}
			if (current.contains(next) == false) {
				current.add(0, next);
			}
		}

		if (current.size() > 10) {
			current = current.subList(0, 10);
		}

		myRecentMessageXmlFiles = new ArrayList<Hl7V2MessageCollection.XmlFormat>();
		for (Hl7V2MessageCollection string : current) {
			myRecentMessageXmlFiles.add(string.exportConfigToXmlWithoutContents());
		}
		sync();
	}

	// public void addOpenImportedProfileGroupFile(OpenImportedProfileGroupFile
	// theFile) {
	// getOpenImportedProfileGroupFile().add(theFile);
	// sync();
	// }

	public void clearRecentMessageXmlFiles() {
		myRecentMessageXmlFiles = new ArrayList<Hl7V2MessageCollection.XmlFormat>();
		sync();
	}

	public String getExportProfileGroupDirectory() {
		return defaultString(myExportProfileGroupDirectory);
	}

	public Font getHl7EditorFont() {
		Font retVal;

		List<String> fonts = FontUtil.getMonospacedFontNames();
		if (fonts.contains("Monaco")) {
			retVal = new Font("Monaco", Font.PLAIN, 12);
		} else if (fonts.contains("Andale Mono")) {
			retVal = new Font("Andale Mono", Font.PLAIN, 12);
		} else if (fonts.contains("Lucida Console")) {
			retVal = new Font("Lucida Console", Font.PLAIN, 12);
		} else if (fonts.contains("Consolas")) {
			retVal = new Font("Consolas", Font.PLAIN, 12);
		} else if (fonts.contains("Lucida Sans Typewriter")) {
			retVal = new Font("Lucida Sans Typewriter", Font.PLAIN, 12);
		} else {
			retVal = new Font("Monospace", Font.PLAIN, 12);
		}

		ourLog.info("Got font for HL7 editor: {}", retVal);
		return retVal;
	}

	public double getHl7EditorSplit() {
		Double hl7EditorSplit = myHl7EditorSplit != null ? myHl7EditorSplit / 100.0 : 0.4;
		return enforceHl7EditorSplitLimits(hl7EditorSplit);
	}

	public String getHl7V2DiffFile1() {
		return myHl7V2DiffFile1 == null ? "" : myHl7V2DiffFile1;
	}

	public String getHl7V2DiffFile2() {
		return myHl7V2DiffFile2 == null ? "" : myHl7V2DiffFile2;
	}

	public boolean getHl7V2DiffShowWholeMessageOnError() {
		return myHl7V2DiffShowWholeMessageOnError;
	}

	public boolean getHl7V2DiffStopOnFirstError() {
		return myHl7V2DiffStopOnFirstError;
	}

	public String getHl7V2SortBy() {
		return myHl7V2SortBy;
	}

	public String getHl7V2SortInputFile() {
		return myHl7V2SortInputFile;
	}

	public String getHl7V2SortOutputFile() {
		return myHl7V2SortOutputFile;
	}

	public String getHl7V2SortOverwriteMode() {
		return myHl7V2SortOverwriteMode;
	}

	public File getImportProfileGroupDirectory() {
		return new File(defaultString(myImportProfileGroupDirectory, "."));
	}

	public String getInboundConnectionList() {
		return myInboundConnectionList;
	}

	public String getInterfaceHohSecurityKeystoreDirectory() {
		return myInterfaceHohSecurityKeystoreDirectory;
	}

	public Charset getMostRecentConnectionCharset() {
		String charset = isNotBlank(myMostRecentConnectionCharset) ? myMostRecentConnectionCharset : CharsetUtils.DEFAULT_CONNECTION_CHARSET.displayName();
		try {
			return Charset.forName(charset);
		} catch (Exception e) {
			return CharsetUtils.DEFAULT_CONNECTION_CHARSET;
		}
	}

	public String getMostRecentlySelectedItemId() {
		return myMostRecentlySelectedItemId;
	}

	// /**
	// * @return the openImportedProfileGroupFile
	// */
	// public List<OpenImportedProfileGroupFile>
	// getOpenImportedProfileGroupFile() {
	// if (myOpenImportedProfileGroupFile == null) {
	// myOpenImportedProfileGroupFile = new
	// ArrayList<Prefs.OpenImportedProfileGroupFile>();
	// }
	// return myOpenImportedProfileGroupFile;
	// }

	public Charset getOpenOrSaveCharset() {
		String savedVal = defaultString(myOpenOrSaveCharset, Charset.defaultCharset().name());

		Charset retVal;
		try {
			retVal = Charset.forName(savedVal);
		} catch (Exception e) {
			retVal = Charset.defaultCharset();
		}
		return retVal;
	}

	public String getOpenPathConformanceProfile() {
		return defaultString(myOpenPathConformanceProfile, ".");
	}

	public String getOpenPathMessages() {
		return defaultString(myOpenPathMessages, ".");
	}

	public List<File> getOpenTableFiles() {
		ArrayList<File> retVal = new ArrayList<File>();
		if (myOpenTableFiles == null) {
			myOpenTableFiles = new ArrayList<String>();
		}
		for (String next : myOpenTableFiles) {
			retVal.add(new File(next));
		}
		return retVal;

	}

	public String getOutboundConnectionList() {
		return myOutboundConnectionList;
	}

	public List<Hl7V2MessageCollection> getRecentMessageXmlFiles(ProfileFileList theProfileFileList) {
		List<Hl7V2MessageCollection> retVal = new ArrayList<Hl7V2MessageCollection>();
		List<XmlFormat> savedVals = myRecentMessageXmlFiles;
		for (XmlFormat string : savedVals) {
			try {
				Hl7V2MessageCollection nextMsg = Hl7V2MessageCollection.fromXml(theProfileFileList, string);
				assert nextMsg.getSourceMessage() == null;
				if (StringUtils.isNotBlank(nextMsg.getSaveFileName())) {
					retVal.add(nextMsg);
				}
			} catch (Exception e) {
				ourLog.error("Failed to restore profile", e);
			}
		}
		return retVal;

	}

	public LineEndingsEnum getSaveLineEndings() {
		String savedVal = defaultString(mySaveLineEndings, LineEndingsEnum.HL7.name());
		LineEndingsEnum retVal;
		try {
			retVal = LineEndingsEnum.valueOf(savedVal);
		} catch (Exception e) {
			retVal = LineEndingsEnum.HL7;
		}
		return retVal;

	}

	public String getSavePathMessages() {
		return defaultString(mySavePathMessages, ".");
	}

	public boolean getSaveStripComments() {
		return mySaveStripComments;
	}

	public boolean getShowLogConsole() {
		return myShowLogConsole;
	}

	/**
	 * Returns (0,0) if nothing was stored
	 */
	public Dimension getWindowDimension() {
		int width = myWindowPositionW;
		int height = myWindowPositionH;
		return new Dimension(width, height);
	}

	public boolean getWindowMaximized() {
		return myWindowMaximized;
	}

	/**
	 * Returns (-1,-1) if nothing was stored
	 */
	public Point getWindowPosition() {
		int x = myWindowPositionX != null ? myWindowPositionX : -1;
		int y = myWindowPositionY != null ? myWindowPositionY : -1;
		return new Point(x, y);
	}

	private void initFromJavaPrefs() {
		myOpenTableFiles = new ArrayList<String>();
		String savedValsSplit = ourPrefs.get(GET_OPEN_TABLE_FILES, "");
		String[] savedVals = defaultString(savedValsSplit).split("\\n");
		for (String string : savedVals) {
			if (StringUtils.isNotBlank(string)) {
				myOpenTableFiles.add(string);
			}
		}

		myOutboundConnectionList = ourPrefs.get(GET_OUTBOUND_CONNECTION_LIST, null);
		myOpenPathConformanceProfile = ourPrefs.get(GET_OPEN_PATH_CONFORMANCE_PROFILE, ".");
		myOpenPathMessages = ourPrefs.get(GET_OPEN_PATH_MESSAGES, ".");
		myInterfaceHohSecurityKeystoreDirectory = ourPrefs.get(GET_INTERFACE_HOH_SECURITY_KEYSTORE_DIRECTORY, null);
		myMostRecentlySelectedItemId = ourPrefs.get(GET_MOST_RECENTLY_SELECTED_ITEM_ID, "");
		myOpenOrSaveCharset = ourPrefs.get(GET_OPENSAVE_CHARSET, Charset.defaultCharset().name());
		myHl7V2SortInputFile = ourPrefs.get(GET_HL7V2_SORT_INPUT, "");
		myHl7V2SortOverwriteMode = ourPrefs.get(GET_HL7V2_SORT_OVERWRITE_MODE, "");
		myInboundConnectionList = ourPrefs.get(GET_INBOUND_CONNECTION_LIST, null);
		myHl7V2SortOutputFile = ourPrefs.get(GET_HL7V2_SORT_OUTPUT, "");
		myHl7V2DiffStopOnFirstError = ourPrefs.getBoolean(GET_HL7V2_DIFF_STOP_ON_FIRST_ERROR, false);
		myExportProfileGroupDirectory = ourPrefs.get(GET_EXPORT_PROFILE_GROUP_DIRECTORY, "");
		myHl7V2DiffShowWholeMessageOnError = ourPrefs.getBoolean(GET_HL7V2_DIFF_SHOW_WHOLE_MESSAGE_ON_ERROR, false);
		myHl7V2SortBy = ourPrefs.get(GET_HL7V2_SORT_BY, "");
		myMostRecentConnectionCharset = ourPrefs.get(GET_MOST_RECENT_CONNECTION_CHARSET, CharsetUtils.DEFAULT_CONNECTION_CHARSET.displayName());
		myHl7EditorSplit = (int) (ourPrefs.getDouble(GET_HL7_EDITOR_SPLIT, 0.4) * 100.0);
		myHl7V2DiffFile1 = ourPrefs.get(GET_HL7V2_DIFF_FILE1, "");
		myHl7V2DiffFile2 = ourPrefs.get(GET_HL7V2_DIFF_FILE2, "");
		mySavePathMessages = ourPrefs.get(GET_SAVE_PATH_MESSAGES, ".");

		String recentMessageXmlFiles = ourPrefs.get(GET_RECENT_MESSAGE_FILES, "");
		ArrayList<String> recentMessageXmlFilesSplit = new ArrayList<String>(Arrays.asList(defaultString(recentMessageXmlFiles).split("\\n")));
		myRecentMessageXmlFiles = new ArrayList<Hl7V2MessageCollection.XmlFormat>();
		for (String string : recentMessageXmlFilesSplit) {
			myRecentMessageXmlFiles.add(JAXB.unmarshal(new StringReader(string), Hl7V2MessageCollection.XmlFormat.class));
		}

		mySaveLineEndings = ourPrefs.get(GET_SAVE_LINE_ENDINGS, LineEndingsEnum.HL7.name());
		mySaveStripComments = ourPrefs.getBoolean(GET_SAVE_STRIP_COMMENTS, false);
		myWindowMaximized = ourPrefs.getBoolean(GET_WINDOW_MAXIMIZED, false);
		myWindowPositionX = ourPrefs.getInt(GET_WINDOW_POSITIONX, -1);
		myWindowPositionY = ourPrefs.getInt(GET_WINDOW_POSITIONY, -1);
		myWindowPositionW = ourPrefs.getInt(GET_WINDOW_POSITIONW, 0);
		myWindowPositionH = ourPrefs.getInt(GET_WINDOW_POSITIONH, 0);
		myShowLogConsole = ourPrefs.getBoolean(GET_SHOW_LOG_CONSOLE, false);

	}

	// public void
	// removeOpenImportedProfileGroupFile(OpenImportedProfileGroupFile theFile)
	// {
	// getOpenImportedProfileGroupFile().remove(theFile);
	// sync();
	// }

	/**
	 * @param theController
	 *            the controller to set
	 */
	public void setController(Controller theController) {
		myController = theController;
	}

	public void setExportProfileGroupDirectory(String theDirectory) {
		myExportProfileGroupDirectory = theDirectory;
		sync();
	}

	public void setHl7EditorSplit(double theRatio) {
		theRatio = enforceHl7EditorSplitLimits(theRatio);
		myHl7EditorSplit = (int) (theRatio * 100.0);
		sync();
	}

	public void setHl7V2DiffFile1(String theFile) {
		myHl7V2DiffFile1 = theFile;
		sync();

	}

	public void setHl7V2DiffFile2(String theFile) {
		myHl7V2DiffFile2 = theFile;
		sync();
	}

	public void setHl7V2DiffShowWholeMessageOnError(boolean theSelected) {
		myHl7V2DiffShowWholeMessageOnError = theSelected;
		sync();
	}

	public void setHl7V2DiffStopOnFirstError(boolean theValue) {
		myHl7V2DiffStopOnFirstError = theValue;
		sync();
	}

	public void setHl7V2SortBy(String theSelectedItem) {
		myHl7V2SortBy = theSelectedItem;
		sync();
	}

	public void setHl7V2SortInputFile(String theText) {
		myHl7V2SortInputFile = theText;
		sync();
	}

	public void setHl7V2SortOutputFile(String theText) {
		myHl7V2SortOutputFile = theText;
		sync();
	}

	public void setHl7V2SortOverwriteMode(String theMode) {
		myHl7V2SortOverwriteMode = theMode;
		sync();
	}

	/**
	 * @param theImportProfileGroupDirectory
	 *            the importProfileGroupDirectory to set
	 */
	public void setImportProfileGroupDirectory(File theImportProfileGroupDirectory) {
		if (theImportProfileGroupDirectory.isDirectory()) {
			myImportProfileGroupDirectory = theImportProfileGroupDirectory.getAbsolutePath();
			sync();
		}

	}

	public void setInboundConnectionList(String theValue) {
		Validate.notNull(theValue);
		myInboundConnectionList = theValue;
		sync();
	}

	public void setInterfaceHohSecurityKeystoreDirectory(String theValue) {
		myInterfaceHohSecurityKeystoreDirectory = theValue;
		sync();
	}

	public void setMostRecentConnectionCharset(String theCharSet) {
		assert theCharSet != null;
		myMostRecentConnectionCharset = theCharSet;
		sync();
	}

	public void setMostRecentlySelectedItemId(String theId) {
		assert theId != null;
		myMostRecentlySelectedItemId = theId;
		sync();
	}

	public void setOpenOrSaveCharset(Charset theValue) {
		Validate.notNull(theValue);
		myOpenOrSaveCharset = theValue.name();
		sync();
	}

	public void setOpenPathConformanceProfile(String theValue) {
		StringUtil.validateNotEmpty(theValue);

		if (theValue.lastIndexOf(File.separatorChar) > 0) {
			theValue = theValue.substring(0, theValue.lastIndexOf(File.separatorChar));
		}

		myOpenPathConformanceProfile = theValue;
		sync();
	}

	public void setOpenPathMessages(String theValue) {
		StringUtil.validateNotEmpty(theValue);

		if (theValue.lastIndexOf(File.separatorChar) > 0) {
			theValue = theValue.substring(0, theValue.lastIndexOf(File.separatorChar));
		}

		myOpenPathMessages = theValue;
		sync();
	}

	public void setOpenProfiles(List<ProfileGroup> theProfiles, TableFileList theTableFileList) {
		int index = 0;
		List<File> files = new ArrayList<File>();
		try {

			for (ProfileGroup profileGroup : theProfiles) {
				index++;
				String seq = StringUtils.leftPad(Integer.toString(index), 10, '0');
				File fileName = createProfileGroupFileName(seq, profileGroup);
				files.add(fileName);

				FileOutputStream fos = new FileOutputStream(fileName);
				Writer nextWriter = new OutputStreamWriter(fos, Charset.forName("UTF-8"));
				if (isNotBlank(profileGroup.getSourceUrl())) {
					ExportedProfileGroupFile exported = new ExportedProfileGroupFile(profileGroup, theTableFileList);
					nextWriter.append(exported.exportConfigToXm());
				} else {
					nextWriter.append(profileGroup.exportConfigToXml());
				}

				nextWriter.close();
			}

			IOUtils.deleteAllFromDirectoryExcept(getProfileGroupFileDirectory(), files);
			
		} catch (IOException e) {
			ourLog.error("Failed to flush profile group file", e);
		}
	}

	public void setOpenTableFiles(List<File> theFiles) {
		myOpenTableFiles = new ArrayList<String>();
		for (File file : theFiles) {
			myOpenTableFiles.add(file.getAbsolutePath());
		}
		sync();
	}

	public void setOutboundConnectionList(String theValue) {
		Validate.notNull(theValue);
		myOutboundConnectionList = theValue;
		sync();
	}

	public void setSaveLineEndings(LineEndingsEnum theValue) {
		Validate.notNull(theValue);
		mySaveLineEndings = theValue.name();
		sync();
	}

	public void setSavePathMessages(String theValue) {
		StringUtil.validateNotEmpty(theValue);

		if (theValue.lastIndexOf(File.separatorChar) > 0) {
			theValue = theValue.substring(0, theValue.lastIndexOf(File.separatorChar));
		}

		mySavePathMessages = theValue;
		sync();
	}

	public void setSaveStripComments(boolean theValue) {
		Validate.notNull(theValue);
		mySaveStripComments = theValue;
		sync();
	}

	public void setShowLogConsole(boolean theValue) {
		Validate.notNull(theValue);

		myShowLogConsole = theValue;
		sync();
	}

	public void setWindowDimension(Dimension theDimension) {
		assert theDimension != null;

		myWindowPositionH = theDimension.height;
		myWindowPositionY = theDimension.width;
		sync();
	}

	public void setWindowMaximized(boolean theWindowMaximized) {
		myWindowMaximized = theWindowMaximized;
		sync();
	}

	public void setWindowPosition(Point thePosition) {
		assert thePosition != null;

		myWindowPositionX = thePosition.x;
		myWindowPositionY = thePosition.y;
		sync();
	}

	private void sync() {

		Runnable r = new Runnable() {
			@Override
			public void run() {
				StringWriter writer = new StringWriter();
				try {
					ourJaxbContext.createMarshaller().marshal(Prefs.this, writer);
				} catch (JAXBException e) {
					ourLog.error("Failed to marshall prefs! This shouldn't happen", e);
				}

				final String prefs = writer.toString();
				if (StringUtils.equals(myLastPrefsFileSaveValue, prefs)) {
					return;
				}

				ourLog.info("Syncing user preferences to disk");

				try {
					FileWriter w = new FileWriter(getPrefsFile(), false);
					w.append(prefs);
					w.close();

					ourLog.info("Done synchronizing user prefs ({} chars)", prefs.length());
					myLastPrefsFileSaveValue = prefs;

					try {
						ourPrefs.clear();
					} catch (BackingStoreException e) {
						// we can ignore this
					}

				} catch (IOException e) {
					ourLog.error("Failed to write prefs file to disk", e);
				}

			}
		};

		if (myController != null) {
			myController.invokeInBackground(r);
		}

	}

	private static File createProfileGroupFileName(String theSeq, ProfileGroup profileGroup) {
		File dir = getProfileGroupFileDirectory();
		dir.mkdirs();
		return new File(dir, theSeq + "-" + profileGroup.getId() + ".xml");
	}

	private static double enforceHl7EditorSplitLimits(double theRatio) {
		theRatio = Math.min(0.8, theRatio);
		theRatio = Math.max(0.2, theRatio);
		return theRatio;
	}

	public static File getDefaultTableFileDirectory() {
		File testPanelHome = getTestpanelHomeDirectory();
		File retVal = new File(testPanelHome, "tables");
		retVal.mkdirs();
		return retVal;
	}

	public static Prefs getInstance() {
		try {
			ourJaxbContext = JAXBContext.newInstance(Prefs.class, XmlFormat.class);
		} catch (JAXBException e) {
			throw new Error(e);
		}

		if (ourInstance == null) {
			File prefsFile = getPrefsFile();
			if (prefsFile.exists() && prefsFile.isFile() && prefsFile.canRead()) {
				try {
					ourInstance = (Prefs) ourJaxbContext.createUnmarshaller().unmarshal(prefsFile);
				} catch (Exception e) {
					ourLog.error("Failed to load prefs- Using default!", e);
					ourInstance = new Prefs();
				}
			} else {
				ourInstance = new Prefs();
				try {
					if (ourPrefs.keys().length > 0) {
						ourInstance.initFromJavaPrefs(); // hopefully we will do
															// away
															// with this
															// eventually
					}
				} catch (BackingStoreException e) {
					// we can ignore this
				}
			}
		}
		return ourInstance;
	}

	public static List<ProfileGroup> getOpenProfiles() {
		ArrayList<ProfileGroup> retVal = new ArrayList<ProfileGroup>();

		File dir = getProfileGroupFileDirectory();
		dir.mkdirs();

		ArrayList<File> files = new ArrayList<File>(Arrays.asList(dir.listFiles()));
		Collections.sort(files, new FileNameComparator());
		
		for (File next : files) {
			if (next.getName().toLowerCase().contains(".xml")) {
				try {
					retVal.add(ProfileGroup.readFromFile(next));
				} catch (Exception e) {
					ourLog.error("Failed to unmarshall profile file", e);
				}
			}
		}

		return retVal;
	}

	private static File getPrefsFile() {
		return new File(getTestpanelHomeDirectory(), "prefs.xml");
	}

	public static File getProfileGroupFileDirectory() {
		File testPanelHome = getTestpanelHomeDirectory();
		File retVal = new File(testPanelHome, "profilegroups");
		retVal.mkdirs();
		return retVal;
	}

	public static File getTempWorkfilesDirectory() throws IOException {
		File testPanelHome = getTestpanelHomeDirectory();
		File retVal = new File(testPanelHome, "workfiles");
		retVal.mkdirs();
		return retVal;
	}

	public static File getTestpanelHomeDirectory() {
		File userHome = new File(System.getProperty("user.home"));
		File testPanelHome = new File(userHome, "HapiTestPanel");
		return testPanelHome;
	}

	// @XmlType()
	// @XmlAccessorType(XmlAccessType.FIELD)
	// public static class OpenImportedProfileGroupFile {
	//
	// private String myId;
	// private String myUrl;
	//
	// public OpenImportedProfileGroupFile() {
	// super();
	// }
	//
	// public OpenImportedProfileGroupFile(String theUrl, String theId) {
	// super();
	// myUrl = theUrl;
	// myId = theId;
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see java.lang.Object#equals(java.lang.Object)
	// */
	// @Override
	// public boolean equals(Object obj) {
	// if (this == obj) {
	// return true;
	// }
	// if (obj == null) {
	// return false;
	// }
	// if (!(obj instanceof OpenImportedProfileGroupFile)) {
	// return false;
	// }
	// OpenImportedProfileGroupFile other = (OpenImportedProfileGroupFile) obj;
	// if (myId == null) {
	// if (other.myId != null) {
	// return false;
	// }
	// } else if (!myId.equals(other.myId)) {
	// return false;
	// }
	// return true;
	// }
	//
	// /**
	// * @return the id
	// */
	// public String getId() {
	// return myId;
	// }
	//
	// /**
	// * @return the url
	// */
	// public String getUrl() {
	// return myUrl;
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see java.lang.Object#hashCode()
	// */
	// @Override
	// public int hashCode() {
	// final int prime = 31;
	// int result = 1;
	// result = prime * result + ((myId == null) ? 0 : myId.hashCode());
	// return result;
	// }
	//
	// /**
	// * @param theId
	// * the id to set
	// */
	// public void setId(String theId) {
	// myId = theId;
	// }
	//
	// /**
	// * @param theUrl
	// * the url to set
	// */
	// public void setUrl(String theUrl) {
	// myUrl = theUrl;
	// }
	//
	// }

}
