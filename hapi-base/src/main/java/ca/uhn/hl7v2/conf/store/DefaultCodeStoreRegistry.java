package ca.uhn.hl7v2.conf.store;

import java.util.ArrayList;
import java.util.List;

/**
 * Default Implementation of a {@link CodeStoreRegistry} 
 * 
 * @author Christian Ohr
 */
public class DefaultCodeStoreRegistry implements CodeStoreRegistry {

    private static List<CodeStoreRegistration> codeStores = new ArrayList<CodeStoreRegistration>();

    public void addCodeStore(CodeStore store) {
        addCodeStore(store, ".*");
    }

    public void addCodeStore(CodeStore store, String profileID) {
        codeStores.add(new CodeStoreRegistration(store, profileID));
    }

    public CodeStore getCodeStore(String profileID, String codeSystem) {
        CodeStore store = null;
        for (CodeStoreRegistration reg : codeStores) {
            if ((store = reg.matchingCodeStore(codeSystem, profileID)) != null)
                break;
        }
        return store;
    }

}
