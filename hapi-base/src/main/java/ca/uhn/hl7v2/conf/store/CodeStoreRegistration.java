package ca.uhn.hl7v2.conf.store;

import java.util.regex.Pattern;

/**
 * Registered CodeStore instances identified by a conformance profile ID pattern
 */
class CodeStoreRegistration  {

    private CodeStore codeStore;
    private Pattern pattern;
    
    public CodeStoreRegistration(CodeStore codeStore, String regex) {
        this.codeStore = codeStore;
        pattern = Pattern.compile(regex);
    }

    public CodeStore matchingCodeStore(String codeSystem, String id) {
        return pattern.matcher(id).matches() && codeStore.knowsCodes(codeSystem) ?
                codeStore : null;
    }

}