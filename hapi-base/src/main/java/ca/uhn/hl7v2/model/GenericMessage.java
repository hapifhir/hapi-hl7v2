package ca.uhn.hl7v2.model;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.*;

/**
 * A generic HL7 message, meant for parsing message with unrecognized structures
 * into a flat list of segments.
 * @author Bryan Tripp
 */
public abstract class GenericMessage extends AbstractMessage {
    
    /** 
     * Creates a new instance of GenericMessage. 
     * 
     * @param factory class factory for contained structures 
     */
    public GenericMessage(ModelClassFactory factory) {
        super(factory);
        try {
            this.addNonstandardSegment("MSH");
        } catch(HL7Exception e) {
            String message = "Unexpected error adding GenericSegment to GenericMessage.";
            HapiLogFactory.getHapiLog(this.getClass()).error(message, e);
            throw new Error(message);
        }        
    }
    
    /**
     * Returns a subclass of GenericMessage corresponding to a certain version.  
     * This is needed so that version-specific segments can be added as the message
     * is parsed.  
     */
    public static Class getGenericMessageClass(String version) {
        if (!Parser.validVersion(version))
            throw new IllegalArgumentException("The version " + version + " is not recognized");
        
        Class c = null;
        if (version.equals("2.1")) {
            c = V21.class;
        } else if (version.equals("2.2")) {
            c = V22.class;
        } else if (version.equals("2.3")) {
            c = V23.class;
        } else if (version.equals("2.3.1")) {
            c = V231.class;
        } else if (version.equals("2.4")) {
            c = V24.class;
        } else if (version.equals("2.5")) {
            c = V25.class;
        }         
        return c;
    }
    
    public static class V21 extends GenericMessage {
        public V21(ModelClassFactory factory) {
            super(factory);
        }
        public String getVersion() { return "2.1"; }
    }
    
    public static class V22 extends GenericMessage {
        public V22(ModelClassFactory factory) {
            super(factory);
        }
        public String getVersion() { return "2.2"; }
    }
    
    public static class V23 extends GenericMessage {
        public V23(ModelClassFactory factory) {
            super(factory);
        }
        public String getVersion() { return "2.3"; }
    }
    
    public static class V231 extends GenericMessage {
        public V231(ModelClassFactory factory) {
            super(factory);
        }
        public String getVersion() { return "2.3.1"; }
    }
    
    public static class V24 extends GenericMessage {
        public V24(ModelClassFactory factory) {
            super(factory);
        }
        public String getVersion() { return "2.4"; }
    }
    
    public static class V25 extends GenericMessage {
        public V25(ModelClassFactory factory) {
            super(factory);
        }
        public String getVersion() { return "2.5"; }
    }
    
}
