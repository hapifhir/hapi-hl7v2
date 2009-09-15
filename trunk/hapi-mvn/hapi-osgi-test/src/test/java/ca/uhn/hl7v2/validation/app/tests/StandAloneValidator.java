package ca.uhn.hl7v2.validation.app.tests;

import ca.uhn.hl7v2.app.SimpleServer;
import ca.uhn.hl7v2.llp.MinLowerLayerProtocol;
import ca.uhn.hl7v2.parser.GenericParser;
import ca.uhn.hl7v2.validation.app.ProfileTestApplication;

public class StandAloneValidator {
    
    public static void main(String args[]) {
        SimpleServer s = new SimpleServer(8888, 
            new MinLowerLayerProtocol(), 
            new GenericParser());
        
        //Here's the profile part ... 
        //Note that the profiles have to be stored in 
        //      the files ./profiles/A.xml and ./profiles/B.xml. 
        s.registerApplication("ADT", "A01", new ProfileTestApplication("A"));
        s.registerApplication("ADT", "A02", new ProfileTestApplication("B"));

        try {
            s.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
