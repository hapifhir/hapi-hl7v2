package ca.uhn.hl7v2.conf.store;

import java.io.IOException;

/**
 * A repository for conformance profile documents.
 * 
 * @author Bryan Tripp
 */
public interface ProfileStore {
    
    /**
     * Retrieves profile from persistent storage (by ID). 
     */
    public String getProfile(String ID) throws IOException;
    
    /**
     * Stores profile in persistent storage with given ID. 
     */
    public void persistProfile(String ID, String profile) throws IOException;
    
}
