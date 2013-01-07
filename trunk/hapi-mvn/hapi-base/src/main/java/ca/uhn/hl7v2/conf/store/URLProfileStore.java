/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "URLProfileStore.java".  Description:
 * "A read-only profile store that loads profiles from URLs."
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2003.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the "GPL"), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 *
 */
package ca.uhn.hl7v2.conf.store;

import java.io.*;
import java.net.*;

/**
 * A read-only profile store that loads profiles from URLs.  The URL 
 * for a profile is determined by the method getURL().  An 
 * attempt is also made to write 
 * @author Bryan Tripp
 */
public abstract class URLProfileStore extends ReadOnlyProfileStore {
    
    /** Creates a new instance of URLProfileStore */
    public URLProfileStore() {
    }
    
    /** Retrieves profile from persistent storage (by ID).
     */
    public String getProfile(String ID) throws IOException {
        String profile;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(getURL(ID).openStream()));
            StringBuffer buf = new StringBuffer();
            int c;
            while ( (c = in.read()) != -1) {
                buf.append( (char) c );
            } 
            in.close();
            profile = buf.toString();
        } catch (MalformedURLException e) {
            throw new IOException("MalformedURLException: " + e.getMessage());
        }
        return profile;
    }


    /**
     * Returns the URL from which to read a profile given the profile ID.  For example
     * given "123" it could return ftp://hospital_x.org/hl7/123.xml, or 
     * http://hl7_conformance_service.com?profile=123.  
     */
    public abstract URL getURL(String ID) throws MalformedURLException;
    

    /** Stores profile in persistent storage with given ID.
     */
    /*public void persistProfile(String ID, String profile) throws IOException {
        try {
            URL url = getWriteURL(ID);
            if (url == null) {
                throw new IOException("Can't persist profile -- this profile store is read-only");
            } else {
                URLConnection uc = url.openConnection();
                uc.connect();
                uc.getOutputStream().write(profile.getBytes());
                uc.getOutputStream().flush();
                uc.getOutputStream().close();
            }
        } catch (MalformedURLException e) {
            throw new IOException("MalformedURLException: " + e.getMessage());
        }
    }*/
        
    /**
     * Returns the URL to which a profile should be written, given the 
     * profile ID.  This defaults to getReadURL() but can be over-ridden.  
     * For read-only stores, over-ride this method to return null.
     */
    /*public URL getWriteURL(String ID) throws MalformedURLException {
        return getReadURL(ID);
    }*/
    
}
