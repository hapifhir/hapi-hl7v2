/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "FileBasedGenerator.java".  Description: 
"Replacement for the legagy MessageIDGenerator class" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  "GPL"), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 
 */
package ca.uhn.hl7v2.util.idgenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.util.Home;

/**
 * Replacement for {@link ca.uhn.hl7v2.util.MessageIDGenerator}. You should not
 * use this class directly, however, but wrap it into a
 * {@link DelegatingHiLoGenerator} generator. Its primary improvement over
 * {@link ca.uhn.hl7v2.util.MessageIDGenerator} is that you can set path and
 * file name.
 * <p>
 * Reading and writing to the file is thread-safe, however, you should not use
 * the same file from different Java processes because no read/write locks are
 * being checked.
 */
public class FileBasedGenerator extends InMemoryIDGenerator {

	private static final Logger LOG = LoggerFactory
			.getLogger(FileBasedGenerator.class.getName());

	private String directory = Home.getHomeDirectory().getAbsolutePath();
	private String fileName = "id_file";
	private boolean neverFail = false;

	private final ReentrantLock lock = new ReentrantLock();

	public FileBasedGenerator() {
		super();
	}

	FileBasedGenerator(int increment) {
		super(increment);
	}

	public String getID() throws IOException {
		String innerId = null;
		try {
			lock.lock();
			innerId = super.getID();
			return new File(getFilePath()).createNewFile() ? increment(0)
					: increment(Long.parseLong(innerId));
		} catch (IOException e) {
			if (neverFail) {
				LOG.warn(
						"Could not read ID from file {}, going to use internal ID generator. {}",
						getFilePath(), e.getMessage());
				return innerId;
			}
			throw e;
		} finally {
			lock.unlock();
		}
	}

	private String increment(long next) throws IOException {
		BufferedWriter bw = null;
		String r = Long.toString(next);
		String s = Long.toString(next + getIncrement());
		try {
			bw = new BufferedWriter(new FileWriter(getFilePath(), false));
			bw.write(s);
			bw.flush();
			return r;
		} finally {
			if (bw != null)
				bw.close();
		}
	}

	private String getFilePath() {
		return directory + "/" + fileName;
	}

	public void setDirectory(String directory) {
		try {
			lock.lock();
			this.directory = directory;
		} finally {
			lock.unlock();
		}
	}

	public void setFileName(String fileName) {
		try {
			lock.lock();
			this.fileName = fileName;
		} finally {
			lock.unlock();
		}
	}

	public void reset() {
		try {
			lock.lock();
			super.reset();
			new File(getFilePath()).delete();
		} finally {
			lock.unlock();
		}
	}

}
