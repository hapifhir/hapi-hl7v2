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
