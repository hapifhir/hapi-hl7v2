package ca.uhn.hl7v2.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.ErrorCode;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Implements CodeMapper using files to store code values.  Files are arranged
 * in the following directory structure.  The base directory is called "codemap".
 * This should be created under the hapi.home directory (see Home class; defaults to .).
 * Under the base directory, there should be one directory for each interface, and
 * each of these directories should be named after the interface.  For example if you
 * had interfaces to pharmacy and lab systems you might have the following directories:</p>
 * <p> <hapi.home>/codemap/pharmacy<br>
 * <hapi.home>/codemap/lab</p>
 * <p>Each directory should contain two files per HL7 table, named after the table numbers as
 * follows: "hl7nnnn.li" and "hl7nnnn.il", where nnnn is the 4 digit table number.  The .il
 * file contains maps from interface codes to local codes, and the .li file contains maps from
 * local codes to interface codes (these unfortunately may not be symmetrical).</p>
 * <p>Each line of a file contains a single code map, with the "from" value and the "to" value
 * separated by a tab.  For example, the file <hapi.home>/lab/HL70001.li (to map local codes to interface
 * codes for the HL7 admnistrative sex table in your lab system interface) might contain the
 * following line: </p>
 * <p>male&tab;M</p>
 * <p>This means that the local code "male" maps to the interface code "M".</p>
 * <p>Lines that start with "//" are treated as comments.</p>
 * @author Bryan Tripp
 */
public class FileCodeMapper extends CodeMapper {

    private static final Logger log = LoggerFactory.getLogger(FileCodeMapper.class);

    private boolean throwIfNoMatch = false;
    File baseDir;
    private Map<String, Map<String, Map<String, String>>> interfaceToLocal;
    private Map<String, Map<String, Map<String, String>>> localToInterface;

    /**
     * Creates a new instance of FileCodeMapper.  You should probably not
     * construct a FileCodeMapper directly.  Use CodeMapper.getInstance()
     * instead ... this will ensure that only a single instance is created,
     * which is important for performance because code maps are loaded from
     * disk every time this constructor is called.
     */
    public FileCodeMapper() throws HL7Exception {
        baseDir = new File(Home.getHomeDirectory().getAbsolutePath() + "/codemap");
        refreshCache();
    }

    /**
     * If values are cached in such a way that they are not guaranteed to be current, a call
     * to this method refreshes the values.
     */
    public void refreshCache() throws HL7Exception {
        localToInterface = new HashMap<String, Map<String, Map<String, String>>>(10);
        interfaceToLocal = new HashMap<String, Map<String, Map<String, String>>>(10);

        log.info("Refreshing cache");

        try {
            //get list of child directories
            File[] interfaceDirs = this.baseDir.listFiles(new FileFilter() {
                public boolean accept(File pathname) {
                    boolean acc = false;
                    if (pathname.isDirectory())
                        acc = true;
                    return acc;
                }
            });

            //loop through directories and set up maps
            for (int i = 0; i < interfaceDirs.length; i++) {

                log.info(
                    "Checking directory {} for interface code maps.", interfaceDirs[i].getName());

                //get list of .li (local -> interface) and .il (interface -> local) files
                File[] mapFiles = interfaceDirs[i].listFiles(new FilenameFilter() {
                    public boolean accept(File dir, String name) {
                        boolean acc = false;
                        if (name.toUpperCase().startsWith("HL7")) {
                            if (name.substring(name.lastIndexOf('.')).equals(".li")
                                || name.substring(name.lastIndexOf('.')).equals(".il"))
                                acc = true;
                        }
                        return acc;
                    }
                });

                //read map entries from each file and add to hash maps for li and il codes
                HashMap<String, Map<String, String>> li = new HashMap<String, Map<String, String>>(50);
                HashMap<String, Map<String, String>> il = new HashMap<String, Map<String, String>>(50);
                for (int j = 0; j < mapFiles.length; j++) {
                    log.info("Reading map entries from file {}", mapFiles[j]);

                    String fName = mapFiles[j].getName();
                    String tableName = fName.substring(0, fName.lastIndexOf('.'));
                    String mapDirection = fName.substring(fName.lastIndexOf('.') + 1);

                    //read values and store in HashMap
	                Map<String, String> codeMap = new HashMap<String, String>(25);
                    BufferedReader in = null;
                    try {
		                in = new BufferedReader(new FileReader(mapFiles[j]));
		                while (in.ready()) {
		                    String line = in.readLine();
		                    if (!line.startsWith("//")) {
		                        StringTokenizer tok = new StringTokenizer(line, "\t", false);
		                        String from = null;
		                        String to = null;
		                        if (tok.hasMoreTokens())
		                            from = tok.nextToken();
		                        if (tok.hasMoreTokens())
		                            to = tok.nextToken();
		                        if (from != null && to != null)
		                            codeMap.put(from, to);
		                    }
		                }
                    }
                    finally {
                    	if (in != null) in.close();
                    }

                    //add to appropriate map for this interface
                    if (mapDirection.equals("il")) {
                        il.put(tableName.toUpperCase(), codeMap);
                        log.debug("Adding {} codes to interface -> local map for {} in {} interface",
                                new Object[] {codeMap.size(), tableName, interfaceDirs[i].getName()});
                    }
                    else {
                        li.put(tableName.toUpperCase(), codeMap);
                        log.debug("Adding {} codes to local -> interface map for {} in {} interface",
                                new Object[] {codeMap.size(), tableName, interfaceDirs[i].getName()});
                    }
                }

                //add maps for this interface (this directory) to global list
                interfaceToLocal.put(interfaceDirs[i].getName(), il);
                localToInterface.put(interfaceDirs[i].getName(), li);
            }

        }
        catch (IOException e) {
            throw new HL7Exception(
                "Can't read interface code maps from disk", e);
        }
    }

    /**
     * Returns the local code for the given interface code as it appears in
     * the given interface.
     */
    public String getLocalCode(String interfaceName, int hl7Table, String interfaceCode) throws HL7Exception {
        String localCode = null;
        try {
            Map<String, Map<String, String>> interfaceMap = interfaceToLocal.get(interfaceName);
            localCode = getCode(interfaceMap, hl7Table, interfaceCode);
        }
        catch (NullPointerException npe) {
            if (this.throwIfNoMatch)
                throw new HL7Exception(
                    "No local mapping for the interface code "
                        + interfaceCode
                        + " for HL7 table "
                        + hl7Table
                        + " for the interface '"
                        + interfaceName
                        + "'",
                    ErrorCode.TABLE_VALUE_NOT_FOUND);
        }
        return localCode;
    }

    /**
     * Common code for getLocalcode and getInterfaceCode
     */
    private String getCode(Map<String, Map<String, String>> interfaceMap, int hl7Table, String code) {
        String ret = null;

        //get map for the given table
        StringBuffer tableName = new StringBuffer();
        tableName.append("HL7");
        if (hl7Table < 1000)
            tableName.append("0");
        if (hl7Table < 100)
            tableName.append("0");
        if (hl7Table < 10)
            tableName.append("0");
        tableName.append(hl7Table);
        Map<String, String> tableMap = interfaceMap.get(tableName.toString());

        //get code
        ret = tableMap.get(code).toString();
        return ret;
    }

    /**
     * Returns the interface code for the given local code, for use in the context
     * of the given interface.
     */
    public String getInterfaceCode(String interfaceName, int hl7Table, String localCode) throws HL7Exception {
        String interfaceCode = null;
        try {
            Map<String, Map<String, String>> interfaceMap = localToInterface.get(interfaceName);
            interfaceCode = getCode(interfaceMap, hl7Table, localCode);
        }
        catch (NullPointerException npe) {
            if (this.throwIfNoMatch)
                throw new HL7Exception(
                    "No interface mapping for the local code "
                        + localCode
                        + " for HL7 table "
                        + hl7Table
                        + " for the interface '"
                        + interfaceName
                        + "'",
                    ErrorCode.TABLE_VALUE_NOT_FOUND);
        }
        return interfaceCode;
    }

    /**
     * Determines what happens if no matching code is found during a lookup.  If set to true,
     * an HL7Exception is thrown if there is no match.  If false, null is returned.  The default
     * is false.
     */
    public void throwExceptionIfNoMatch(boolean throwException) {
        this.throwIfNoMatch = throwException;
    }

    /**
     * Test harness.
     */
    public static void main(String args[]) {
        try {
            //FileCodeMapper mapper = new FileCodeMapper();
            CodeMapper.getInstance().throwExceptionIfNoMatch(true);
            System.out.println("Local code for M is " + CodeMapper.getLocal("test", 1, "M"));
            System.out.println("Interface code for female is " + CodeMapper.getInt("test", 1, "female"));

        }
        catch (HL7Exception e) {
            e.printStackTrace();
        }
    }

}
