package ca.uhn.hl7v2.conf.store;

import java.io.*;
import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.log.*;

/**
 * Stores profiles in a local directory.  Profiles are stored as text
 * in files named ID.xml (where ID is the profile ID).
 * @author Bryan Tripp
 */
public class FileProfileStore implements ProfileStore {
    
    private File root;
    private static final HapiLog log = HapiLogFactory.getHapiLog(FileProfileStore.class);
    
    /** Creates a new instance of FileProfileStore */
    public FileProfileStore(String file) {
        root = new File(file);
        if (!root.isDirectory())
            if (!root.mkdirs()) 
                throw new IllegalArgumentException(file + " is not a directory");
    }
    
    /**
     * Retrieves profile from persistent storage (by ID).  Returns null
     * if the profile isn't found.
     */
    public String getProfile(String ID) throws IOException {
        String profile = null;
        
        File source = new File(getFileName(ID));
        if (source.isFile()) {
            BufferedReader in = new BufferedReader(new FileReader(source));
            char[] buf = new char[(int) source.length()];
            int check = in.read(buf, 0, buf.length);
            in.close();
            if (check != buf.length)
                throw new IOException("Only read " + check + " of " + buf.length
                + " bytes of file " + source.getAbsolutePath());
            profile = new String(buf);
        }
        log.info("Got profile " + ID + ": \r\n" + profile);
        return profile;
    }
    
    /**
     * Stores profile in persistent storage with given ID.
     */
    public void persistProfile(String ID, String profile) throws IOException {
        File dest = new File(getFileName(ID));
        BufferedWriter out = new BufferedWriter(new FileWriter(dest));
        out.write(profile);
        out.flush();
        out.close();
    }
    
    private String getFileName(String ID) {
        return root.getAbsolutePath() + "/" + ID + ".xml";
    }
}
