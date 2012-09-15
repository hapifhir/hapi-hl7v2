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
package ca.uhn.hl7v2.testpanel.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.hoh.util.IOUtils;
import ca.uhn.hl7v2.testpanel.controller.Controller;
import ca.uhn.hl7v2.testpanel.model.msg.Hl7V2MessageCollection;
import ca.uhn.hl7v2.testpanel.util.FileUtils;

public class MessagesList extends AbstractModelClass {

	private static final Logger ourLog = LoggerFactory.getLogger(MessagesList.class);
	public static final String PROP_LIST = MessagesList.class.getName() + "_LIST";

	private Controller myController;
	private List<Hl7V2MessageCollection> myMessages = new ArrayList<Hl7V2MessageCollection>();

	public MessagesList(Controller theController) {
		myController = theController;
		
//		Message initialMessage;
//		String string = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r" // -
//				+ "ZPI|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r" // -
//				+ "PID|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r" // -
//				+ "PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST\r" // -
//				+ "ORC|RE||T09-100442-RET-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r" // -
//				+ "OBR|0||T09-100442-RET-0^^OLIS_Site_ID^ISO|RET^RETICULOCYTE COUNT^HL79901 literal|||200905011106|||||||200905011106||OLIST^BLAKE^DONALD^THOR^^^^L^921379||7870279|7870279|T09-100442|MOHLTC|200905011130||B7|F||1^^^200905011106^^R\r" // -
//				+ "OBX|1|IS|Z114099^Erc^L||ABC||||||F|||200905011111|PMH\r";
		// initialMessage = new ORU_R01();
		// initialMessage.parse(string);
//		Hl7V2MessageCollection initialMessageObj = new Hl7V2MessageCollection();

		// try {
		// InputStream is =
		// MessagesList.class.getClassLoader().getResourceAsStream("testpanel/profiles/ADT_A01.xml");
		// StringBuffer profileString = new StringBuffer();
		// byte[] buffer = new byte[1000];
		// int bytesRead;
		// while ((bytesRead = is.read(buffer)) > 0) {
		// profileString.append(new String(buffer, 0, bytesRead));
		// }
		// RuntimeProfile rp = new
		// ProfileParser(false).parse(profileString.toString());
		// initialMessageObj.setRuntimeProfile(rp);
		// } catch (Exception e) {
		// throw new Error(e);
		// }

//		initialMessageObj.setSourceMessage(string);

//		myMessages.add(initialMessageObj);

	}

	public void addMessage(Hl7V2MessageCollection theMessageCollection) {
		myMessages.add(theMessageCollection);
		firePropertyChange(PROP_LIST, null, null);
	}

	/**
	 * Save all files to work directory
	 */
	public void dumpToWorkDirectory(File theWorkfilesDir) throws IOException {
		ourLog.info("Flushing work files to directory: " + theWorkfilesDir.getAbsolutePath());

		IOUtils.deleteAllFromDirectory(theWorkfilesDir);

		int index = 0;
		for (Hl7V2MessageCollection next : myMessages) {
			index++;
			String seq = StringUtils.leftPad(Integer.toString(index), 10, '0');

			File nextFile = new File(theWorkfilesDir, next.getId() + "-" + seq + ".xml");
			nextFile.delete();
			Writer nextWriter = new OutputStreamWriter(new FileOutputStream(nextFile), Charset.forName("UTF-8"));
			nextWriter.append(next.exportConfigToXml());
			nextWriter.close();
		}

	}

	@Override
	public Object exportConfigToXml() {
		return null;
	}

	public List<Hl7V2MessageCollection> getMessages() {
		return Collections.unmodifiableList(myMessages);
	}

	public Hl7V2MessageCollection getWithId(String theId) {
		for (Hl7V2MessageCollection next : myMessages) {
			if (next.getId().equals(theId)) {
				return next;
			}
		}
		return null;
	}

	public void removeMessage(Hl7V2MessageCollection theMsg) {
		myMessages.remove(theMsg);
		firePropertyChange(PROP_LIST, null, null);
	}

	public void restoreFromWorkDirectory(File theWorkfilesDir) {
		myMessages.clear();

		File[] listFiles = theWorkfilesDir.listFiles();
		Arrays.sort(listFiles, new Comparator<File>() {
			public int compare(File theO1, File theO2) {
				String n1 = theO1.getAbsolutePath();
				String n2 = theO2.getAbsolutePath();
				int lastDash1 = n1.lastIndexOf('-');
				int lastDash2 = n2.lastIndexOf('-');

				if (lastDash1 == -1 && lastDash2 == -1) {
					return 0;
				}
				if (lastDash1 == -1) {
					return -1;
				}
				if (lastDash2 == -1) {
					return 1;
				}
				return lastDash2 - lastDash1;
			}
		});

		for (File next : listFiles) {
			if (next.getAbsolutePath().toLowerCase().endsWith(".xml") == false) {
				continue;
			}

			ourLog.info("Restoring work file: {}", next.getName());
			String contents;
			try {
				contents = FileUtils.readFile(next);
			} catch (FileNotFoundException e) {
				ourLog.error("Failed to restore work file", e);
				continue;
			} catch (IOException e) {
				ourLog.error("Failed to restore work file", e);
				continue;
			}

			Hl7V2MessageCollection nextMsg = Hl7V2MessageCollection.fromXml(myController.getProfileFileList(), contents);
			if (StringUtils.isNotBlank(nextMsg.getSaveFileName())) {
				try {
					File saveFile = new File(nextMsg.getSaveFileName());
					contents = FileUtils.readFile(saveFile, nextMsg.getSaveCharset());
					
					nextMsg.setSourceMessage(contents);
					nextMsg.setSaveFileTimestamp(next.lastModified());
					nextMsg.setSaved(true);
				} catch (FileNotFoundException e) {
					myController.showDialogError("Could not restore the following file as it could not be found:<br>" + nextMsg.getSaveFileName());
					continue;
				} catch (IOException e) {
					myController.showDialogError("Could not restore the following file.<br>Error: " + e.getMessage() + "<br>File: " + nextMsg.getSaveFileName());
					continue;
				}
			}
			
			myMessages.add(nextMsg);

		}
	}

}
