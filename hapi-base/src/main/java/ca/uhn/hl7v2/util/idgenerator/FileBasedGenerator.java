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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.util.Home;

/**
 * Replacement for {@link ca.uhn.hl7v2.util.MessageIDGenerator}. You should not use this class
 * directly, however, but wrap it into a {@link DelegatingHiLoGenerator} generator. Its primary
 * improvement over {@link ca.uhn.hl7v2.util.MessageIDGenerator} is that you can set path and file
 * name.
 * <p>
 * Reading and writing to the file is thread-safe, however, you should not use the same file from
 * different Java processes because no read/write locks are being checked.
 */
public class FileBasedGenerator extends InMemoryIDGenerator {

	private static final Logger LOG = LoggerFactory.getLogger(FileBasedGenerator.class.getName());

	private String directory = Home.getHomeDirectory().getAbsolutePath();
	private String fileName = "id_file";
	private boolean neverFail = false;
	private boolean used = false;
	private ReentrantLock lock = new ReentrantLock();

	public FileBasedGenerator() {
		this(1);
	}

	FileBasedGenerator(int increment) {
		super(increment);
	}

	public String getID() throws IOException {
		// If ID is 0, read initial value from file if possible
		if (!used) {
			set(readInitialValue(getFilePath()));
			used = true;
		}
		try {
			lock.lock();
			String id = super.getID();
			// The id held in the file is always <increment> larger so that
			// the ID is still unique after a restart.
			writeNextValue(Long.parseLong(id) + getIncrement());
			return id;
		} finally {
			lock.unlock();
		}
	}


	private void writeNextValue(long id) throws IOException {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileOutputStream(getFilePath(), false));
			pw.println(Long.toString(id));
		} catch (IOException e) {
			if (neverFail) {
				LOG.warn("Could not write ID to file {}, going to use internal ID generator. {}",
						getFilePath(), e.getMessage());
				return;
			}
			throw e;
		} finally {
			if (pw != null)
				pw.close();
		}
	}

	private long readInitialValue(String path) {
		BufferedReader br = null;
		String id = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
			id = br.readLine();
			return Long.parseLong(id);
		} catch (IOException e) {
			LOG.info("Could not read ID file {} ", path);
			return 0;
		} catch (NumberFormatException e) {
			LOG.info("ID {} read from file is not a number", id);
			return 0;
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
				}
		}
	}

	private String getFilePath() {
		return new File(directory, fileName).getAbsolutePath();
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

	public void setNeverFail(boolean neverFail) {
		this.neverFail = neverFail;
	}

	public void reset() {
		try {
			lock.lock();
			super.reset();
			writeNextValue(0l);
		} catch (IOException e) {
			throw new IllegalStateException("Cannot initialize persistent ID generator", e);
		} finally {
			lock.unlock();
		}
	}

}
