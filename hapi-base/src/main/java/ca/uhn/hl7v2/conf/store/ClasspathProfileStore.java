/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "ClasspathProfileStore.java".  Description:
 * "A read-only profile store that loads profiles from the classpath"
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2012.  All Rights Reserved.
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

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Looks up the profile in a file "ID.xml" somewhere in in classpath
 * (where ID is the profile ID).
 *
 * @author Christian Ohr
 */
public class ClasspathProfileStore extends URLProfileStore {

    public static final String DEFAULT_PROFILE_PREFIX = "/ca/uhn/hl7v2/conf/store";
    
    private String prefix;
    
    public ClasspathProfileStore() {
        this(DEFAULT_PROFILE_PREFIX);
    }
    
    public ClasspathProfileStore(String prefix) {
        super();
        this.prefix = prefix;
    }

    @Override
    public URL getURL(String ID) throws MalformedURLException {
        return getClass().getResource(prefix + "/" + ID + ".xml");
    }

}
