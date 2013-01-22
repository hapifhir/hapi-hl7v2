/*
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "ApplicationLoader.java".  Description: 
"A utility for loading Application bindings from configuration files." 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2004.  All Rights Reserved. 

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

package ca.uhn.hl7v2.protocol.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.Application;
import ca.uhn.hl7v2.protocol.ApplicationRouter;
import ca.uhn.hl7v2.protocol.ReceivingApplication;

/**
 * A utility for loading <code>Application</code> and <code>ReceivingApplication</code> bindings
 * from configuration files.  
 *  
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:26 $ by $Author: jamesagnew $
 */
public class ApplicationLoader {

    /**
     * <p>A convenience method for binding applications to an <code>ApplicationRouter</code>
     * Information about bindings is read from a file at a specified URL.  Each line in the 
     * file should have the following format (entries TAB delimited):</p>
     * 
     * <p>message_type &#009; trigger_event &#009; processing_id &#009; version_id &#009; app_class</p>
     * 
     * <p>Note that the first four fields can be the wildcard "*", which means any.</p>
     * 
     * <p>For example, if you write an Application called org.yourorganiztion.ADTProcessor
     * that processes several types of ADT messages, and another called 
     * org.yourorganization.ResultProcessor that processes result messages, you might have a 
     * file that looks like this: </p>
     * 
     * <p>ADT &#009; * &#009; * &#009; * &#009; org.yourorganization.ADTProcessor<br>
     * ORU &#009; R01 &#009; * &#009; * &#009; org.yourorganization.ResultProcessor</p>
     * 
     * <p>Each class listed in this file must implement either ca.uhn.hl7v2.app.Application or 
     * ca.uhn.hl7v2.protocol.ReceivingApplication, and must have a zero-argument constructor.</p>
     * 
     * @param theRouter the <code>ApplicationRouter</code> on which to make the binding
     * @param theSource a URL pointing to the bindings file 
     */
    public static void loadApplications(ApplicationRouter theRouter, URL theSource)
        throws IOException, HL7Exception, ClassNotFoundException, InstantiationException, IllegalAccessException {
        
        if (theSource == null) {
            throw new HL7Exception("Can't load application bindings: the given URL is null");
        }
        
        BufferedReader in = new BufferedReader(new InputStreamReader(theSource.openStream()));
        String line = null;
        while ((line = in.readLine()) != null) {
            //parse application registration information 
            StringTokenizer tok = new StringTokenizer(line, "\t", false);
            String type = null, event = null, procId = null, verId = null, className = null;

            if (tok.hasMoreTokens()) { //skip blank lines 
                try {
                    type = tok.nextToken();
                    event = tok.nextToken();
                    procId = tok.nextToken();
                    verId = tok.nextToken();
                    className = tok.nextToken();
                }
                catch (NoSuchElementException ne) {
                    throw new HL7Exception(
                        "Can't register applications from "
                            + theSource.toExternalForm()
                            + ". The line '"
                            + line
                            + "' is not of the form: message_type [tab] trigger_event " 
                            + "[tab] processing ID [tab] version ID [tab] application_class. "
                            + "*** NOTE TWO NEW FIELDS AS OF HAPI 0.5 ****. ");
                }

                Class<?> appClass = Class.forName(className); //may throw ClassNotFoundException 
                Object appObject = appClass.newInstance();
                ReceivingApplication app = null;
                if (appObject instanceof ReceivingApplication) {
                    app = (ReceivingApplication) appObject;
                } else if (appObject instanceof Application) {
                    app = new AppWrapper((Application) appObject);
                } else {
                    throw new HL7Exception(
                            "The specified class, " + appClass.getName() + 
                            ", doesn't implement Application or ReceivingApplication.");   
                }

                ApplicationRouter.AppRoutingData rd  
                    = new AppRoutingDataImpl(type, event, procId, verId);                    
                theRouter.bindApplication(rd, app);
            }
        }
    }    
}
