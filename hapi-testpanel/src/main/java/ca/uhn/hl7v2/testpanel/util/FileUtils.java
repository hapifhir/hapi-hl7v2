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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

public class FileUtils {

	@SuppressWarnings("unused")
	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(FileUtils.class);

	public static String loadResourceFromClasspath(String thePath) throws IOException {
		InputStream is = FileUtils.class.getClassLoader().getResourceAsStream(thePath);
		return readFromReaderIntoString(new InputStreamReader(is));
	}

	public static String readFile(File file) throws FileNotFoundException, IOException {
		return readFile(file, null);
	}

	public static String readFile(File theFile, Charset theCharset) throws IOException {
		if (theCharset == null) {
			theCharset = Charset.defaultCharset();
		}
		Reader reader = new InputStreamReader(new FileInputStream(theFile), theCharset);
		return readFromReaderIntoString(reader);
	}

	public static String readFromReaderIntoString(Reader theReader) throws IOException {
		int next;
		StringBuilder b = new StringBuilder();
		char[] buf = new char[1000];
		while ((next = theReader.read(buf)) > 0) {
			b.append(buf, 0, next);
		}

		String profileString = b.toString();
		return profileString;
	}

}
