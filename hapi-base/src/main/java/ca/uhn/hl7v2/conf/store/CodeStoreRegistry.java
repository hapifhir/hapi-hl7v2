/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "CodeStoreRegistry.java".  Description:
 * "Registry containing CodeStore instances"
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

/**
 * Registry containing {@link CodeStore} instances registered for Conformance Profile IDs
 * or ID patterns.
 * 
 * @author Christian Ohr
 */
public interface CodeStoreRegistry {

    /**
     * Registers a code store for use with all profiles.
     */
    void addCodeStore(CodeStore store);
    
    /**
     * Registers a code store for use with certain profiles. The profiles with which the code store
     * are used are determined by profileIdPattern, which is a regular expression that will be
     * matched against profile IDs. For example suppose there are three profiles in the profile
     * store, with the following IDs:
     * <ol>
     * <li>ADT:confsig-UHN-2.4-profile-AL-NE-Immediate</li>
     * <li>ADT:confsig-CIHI-2.4-profile-AL-NE-Immediate</li>
     * <li>ADT:confsig-CIHI-2.3-profile-AL-NE-Immediate</li>
     * </ol>
     * Then to use a code store with only the first profile, the profileIdPattern would be
     * "ADT:confsig-UHN-2.4-profile-AL-NE-Immediate". To use a code store with both of the 2.4
     * profiles, the pattern would be ".*2\\.4.*". To use a code store with all profiles, the
     * pattern would be '.*". Multiple stores can be registered for use with the same profile. If
     * this happens, the first one that returned true for knowsCodes(codeSystem) will used. Stores
     * are searched in the order they are added here.
     */    
    void addCodeStore(CodeStore store, String profileID);
    
    /**
     * Returns the first code store that knows the codes in the given code system (as per
     * CodeStore.knowsCodes) and is registered for the given profile. Code stores are checked in the
     * order in which they are added (with addCodeStore()).
     * 
     * @return null if none are found
     */    
    CodeStore getCodeStore(String profileID, String codeSystem);
    
}
