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

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.hl7v2.conf.check.DefaultValidator;
import ca.uhn.hl7v2.conf.parser.ProfileParser;
import ca.uhn.hl7v2.conf.spec.RuntimeProfile;
import ca.uhn.hl7v2.conf.store.ProfileStoreFactory;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.util.Terser;
import ca.uhn.hl7v2.validation.MessageRule;
import ca.uhn.hl7v2.validation.ValidationException;
import ca.uhn.log.HapiLog;
import ca.uhn.log.HapiLogFactory;

/**
 * A MessageRule that checks conformance to message profiles. Messges can either be tested 
 * agaist the profiles they declare, or against a pre-defined profile. If you want both, 
 * use two <code>ConformanceProfileRule</code>s.  
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:40 $ by $Author: jamesagnew $
 */
public class ConformanceProfileRule implements MessageRule {

    private static final HapiLog log = HapiLogFactory.getHapiLog(ConformanceProfileRule.class);

    private String myProfileID;

    /**
     * Creates an instance that tests messages against whatever profiles they declare in 
     * MSH-21. 
     */
    public ConformanceProfileRule() {
    }
    
    /**
     * @param theProfileID the ID of a constant profile against which to test all messages
     *      (instead of the profiles they declare in MSH-21) 
     */
    public ConformanceProfileRule(String theProfileID) {
        myProfileID = theProfileID;
    }
    

    /** 
     * @see ca.uhn.hl7v2.validation.MessageRule#test(ca.uhn.hl7v2.model.Message)
     */
    public ValidationException[] test(Message msg) {
        ArrayList<ValidationException> problems = new ArrayList<ValidationException>(20);
        String[] ids = {myProfileID};
        
        try {
            if (myProfileID == null) {
                ids = getDeclaredProfileIDs(msg);
            }
            
            for (int i = 0; i < ids.length; i++) {
                log.debug("Testing message against profile: " + ids[i]);
                try {
                    ValidationException[] shortList = testAgainstProfile(msg, ids[i]);
                    log.debug(shortList.length + " non-conformances");
                    for (int j = 0; j < shortList.length; j++) {
                        problems.add(shortList[j]);
                    }
                } catch (ProfileException e) {
                    problems.add(new ValidationException("Can't validate", e));
                }
            }            
        } catch (HL7Exception e) {
            problems.add(new ValidationException("Can't validate", e));
        }
        
        return (ValidationException[]) problems.toArray(new ValidationException[0]);
    }
    
    private String[] getDeclaredProfileIDs(Message theMessage) throws HL7Exception {
        Terser t = new Terser(theMessage);
        boolean noMore = false;
        int c = 0;
        ArrayList<String> declaredProfiles = new ArrayList<String>(8);
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
        return (String[]) declaredProfiles.toArray(new String[0]);
    }
    
    private ValidationException[] testAgainstProfile(Message message, String id) throws ProfileException, HL7Exception {
        HL7Exception[] exceptions = null;
        DefaultValidator val = new DefaultValidator();
        try {
            String profileString = ProfileStoreFactory.getProfileStore().getProfile(id);
            if (profileString != null) {
                ProfileParser profParser = new ProfileParser(true);
                RuntimeProfile profile = profParser.parse(profileString);
                
                exceptions = val.validate(message, profile.getMessage());
            } else {
                throw new ProfileException("Unable to find the profile " + id);
            }
        } catch (IOException e) {
            throw new ProfileException("Error retreiving profile " + id, e);
        }
        
        ValidationException[] result = new ValidationException[exceptions.length];
        for (int i = 0; i < exceptions.length; i++) {
            result[i] = new ValidationException(exceptions[i].getMessage(), exceptions[i]);
        }
        return result;
    }
    

    /** 
     * @see ca.uhn.hl7v2.validation.Rule#getDescription()
     */
    public String getDescription() {
        return "Checks conformance to declared or predefined message profiles";
    }

    /** 
     * @see ca.uhn.hl7v2.validation.Rule#getSectionReference()
     */
    public String getSectionReference() {
        return "HL7 2.5 section 2.12";
    }

}
