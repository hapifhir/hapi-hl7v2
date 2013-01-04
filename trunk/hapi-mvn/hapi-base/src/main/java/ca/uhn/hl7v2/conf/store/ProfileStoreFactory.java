package ca.uhn.hl7v2.conf.store;

import ca.uhn.hl7v2.util.Home;

/**
 * Provides access to a (configurable) ProfileStore.
 * 
 * @author Bryan Tripp
 */
public class ProfileStoreFactory {

	/**
	 * The default profile store directory
	 */
    public static final String DEFAULT_PROFILE_STORE_DIRECTORY = Home.getHomeDirectory().getAbsolutePath() + "/profiles";
    
	private static ProfileStore instance;
    private static CodeStoreRegistry codeRegistry = new DefaultCodeStoreRegistry();

    /** Non instantiable */
    private ProfileStoreFactory() {
    	super();
    }
    
    /**
     * Returns a single configurable instance of a ProfileStore. Configurable by calling setStore().
     * Defaults to FileProfileStore using the current <hapi.home>/profiles as a base directory Note:
     * not a singleton (by design) in that nothing prevents creation of profile stores by other
     * means.
     */
    public synchronized static ProfileStore getProfileStore() {
        if (instance == null)
            instance = new FileProfileStore(DEFAULT_PROFILE_STORE_DIRECTORY);

        return instance;
    }

    /**
     * Sets the profile store that will be returned in subsequent calls to getProfileStore().
     * 
     * @deprecated use HapiContext to define the ProfileStore to be used
     */
    public synchronized static void setStore(ProfileStore store) {
        instance = store;
    }

    /**
     * Registers a code store for use with all profiles.
     * 
     * @deprecated use {@link CodeStoreRegistry#addCodeStore(CodeStore)}
     */
    public static void addCodeStore(CodeStore store) {
        codeRegistry.addCodeStore(store);
    }

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
     * 
     * @deprecated use {@link CodeStoreRegistry#addCodeStore(CodeStore, String)}
     */
    public static void addCodeStore(CodeStore store, String profileID) {
        codeRegistry.addCodeStore(store, profileID);
    }

    /**
     * Returns the first code store that knows the codes in the given code system (as per
     * CodeStore.knowsCodes) and is registered for the given profile. Code stores are checked in the
     * order in which they are added (with addCodeStore()).
     * 
     * @return null if none are found
     * 
     * @deprecated use {@link CodeStoreRegistry#getCodeStore(String, String)}
     */
    public static CodeStore getCodeStore(String profileID, String codeSystem) {
        return codeRegistry.getCodeStore(profileID, codeSystem);
    }
}
