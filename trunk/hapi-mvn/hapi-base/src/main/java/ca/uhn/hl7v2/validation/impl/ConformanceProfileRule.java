/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "ConformanceProfileRule.java".  Description: 
"A MessageRule that checks conformance to message profiles." 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2005.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the "GPL"), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 
*/
package ca.uhn.hl7v2.validation.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.hl7v2.conf.check.Validator;
import ca.uhn.hl7v2.conf.parser.ProfileParser;
import ca.uhn.hl7v2.conf.spec.RuntimeProfile;
import ca.uhn.hl7v2.conf.store.ProfileStore;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.util.Terser;
import ca.uhn.hl7v2.validation.ValidationException;

/**
 * A MessageRule that checks conformance to message profiles. Messages can either be tested 
 * against the profiles they declare, or against a pre-defined profile. If you want both, 
 * use two <code>ConformanceProfileRule</code>s.  
 * 
 * @author Bryan Tripp
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:40 $ by $Author: jamesagnew $
 */
@SuppressWarnings("serial")
public class ConformanceProfileRule extends AbstractMessageRule {

    private static final Logger log = LoggerFactory.getLogger(ConformanceProfileRule.class);
    private static final ProfileParser PARSER = new ProfileParser(true);
    private String myProfileID;
    private boolean enableCaching = true;

    private static final LinkedHashMap<String, RuntimeProfile> PROFILE_CACHE = new LinkedHashMap<String, RuntimeProfile>(100, 0.75f, true) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<String, RuntimeProfile> eldest) {
            return size() > 100;
        }
    };

    /**
     * Creates an instance that tests messages against whatever profiles they declare in 
     * MSH-21. The ID declared in MSH-21 is evaluated in a way that the corresponding
     * profile file is expected to be BASEDIR/profiles/ID.xml.
     */
    public ConformanceProfileRule() {
    	super();
    	setDescription("Unknown segments found in message");
    	setSectionReference("HL7 2.5 section 2.12");
    }
    
    /**
     * @param theProfileID the ID of a constant profile against which to test all messages
     *      (instead of the profiles they declare in MSH-21). The ID is evaluated in a way
     *      that the corresponding profile file is expected to be BASEDIR/profiles/ID.xml.
     */
    public ConformanceProfileRule(String theProfileID) {
    	this();
        myProfileID = theProfileID;
    }
    

    /** 
     * @see ca.uhn.hl7v2.validation.MessageRule#test(ca.uhn.hl7v2.model.Message)
     */
    public ValidationException[] apply(Message msg) {
        List<ValidationException> problems = new ArrayList<ValidationException>();
        String[] ids = {myProfileID};
        
        try {
            if (myProfileID == null) {
                ids = getDeclaredProfileIDs(msg);
            }
            
            for (String id : ids) {
                log.debug("Testing message against profile: {}", id);
                try {
                    ValidationException[] shortList = testAgainstProfile(msg, id);
                    log.debug("{} non-conformances", shortList.length);
                    problems.addAll(Arrays.asList(shortList));
                } catch (ProfileException e) {
                    problems.add(new ValidationException("Can't validate against profile: " + e.getMessage(), e));
                }
            }            
        } catch (HL7Exception e) {
            problems.add(new ValidationException("Can't validate against profile: " + e.getMessage(), e));
        }
        
        return problems.toArray(new ValidationException[problems.size()]);
    }
    
    private String[] getDeclaredProfileIDs(Message theMessage) throws HL7Exception {
        Terser t = new Terser(theMessage);
        boolean noMore = false;
        int c = 0;
        List<String> declaredProfiles = new ArrayList<String>(8);
        while (!noMore) {
            String path = "MSH-21(" + c++ + ")";
            String idRep = t.get(path);
            //FIXME fails if empty rep precedes full rep ... should add getAll() to Terser and use that
            if (idRep == null || idRep.equals("")) {
                noMore = true;
            } else {
                declaredProfiles.add(idRep);
            }
        }
        return declaredProfiles.toArray(new String[declaredProfiles.size()]);
    }

    private synchronized RuntimeProfile getProfile(String profileString) throws ProfileException {
        RuntimeProfile profile = PROFILE_CACHE.get(profileString);
        if (profile == null) {
            profile = PARSER.parse(profileString);
            if (enableCaching) PROFILE_CACHE.put(profileString, profile);
        }
        return profile;
    }

    private ValidationException[] testAgainstProfile(Message message, String id) throws ProfileException, HL7Exception {
        HL7Exception[] exceptions;
        HapiContext context = message.getParser().getHapiContext();
        Validator validator = context.getConformanceValidator();
        try {
            ProfileStore profileStore = context.getProfileStore();
            String profileString = profileStore.getProfile(id);
            if (profileString != null) {
                RuntimeProfile profile = getProfile(profileString);
                exceptions = validator.validate(message, profile.getMessage());
            } else {
                throw new ProfileException("Unable to find the profile " + id);
            }
        } catch (IOException e) {
            throw new ProfileException("Error retreiving profile " + id, e);
        }
        
        ValidationException[] result = new ValidationException[exceptions.length];
        for (int i = 0; i < exceptions.length; i++) {
            result[i] = ValidationException.fromHL7Exception(exceptions[i]);
        }
        return result;
    }
    

    /** 
     * @see ca.uhn.hl7v2.validation.Rule#getDescription()
     */
    public String getDescription() {
        return "expected conformance to declared or predefined message profiles";
    }

    /** 
     * @see ca.uhn.hl7v2.validation.Rule#getSectionReference()
     */
    public String getSectionReference() {
        return "HL7 2.5 section 2.12";
    }

	public String getProfileID() {
		return myProfileID;
	}

    public void setEnableCaching(boolean enableCaching) {
        this.enableCaching = enableCaching;
    }
}
