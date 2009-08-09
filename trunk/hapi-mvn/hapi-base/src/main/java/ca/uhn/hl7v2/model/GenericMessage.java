package ca.uhn.hl7v2.model;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.util.Terser;
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
        } else if (version.equals("2.5.1")) {
            c = V251.class;
        } else if (version.equals("2.6")) {
            c = V26.class;
        } else {
        	return UnknownVersion.class;
        }
        return c;
    }

    public static class UnknownVersion extends GenericMessage {
		private static final long serialVersionUID = 4773366840392833956L;

		public UnknownVersion(ModelClassFactory factory) {
            super(factory);
        }
        public String getVersion() {
        	// FIXME: use from somewhere
        	return "2.6";
        }
    }

    public static class V21 extends GenericMessage {
		private static final long serialVersionUID = 4773366840392833956L;
		public V21(ModelClassFactory factory) {
            super(factory);
        }
        public String getVersion() { return "2.1"; }
    }
    
    public static class V22 extends GenericMessage {
		private static final long serialVersionUID = 7124224621400437244L;
		public V22(ModelClassFactory factory) {
            super(factory);
        }
        public String getVersion() { return "2.2"; }
    }
    
    public static class V23 extends GenericMessage {
		private static final long serialVersionUID = -8794048442253389190L;
		public V23(ModelClassFactory factory) {
            super(factory);
        }
        public String getVersion() { return "2.3"; }
    }
    
    public static class V231 extends GenericMessage {
		private static final long serialVersionUID = 5979370667795858995L;
		public V231(ModelClassFactory factory) {
            super(factory);
        }
        public String getVersion() { return "2.3.1"; }
    }
    
    public static class V24 extends GenericMessage {
		private static final long serialVersionUID = -4944772617600551061L;
		public V24(ModelClassFactory factory) {
            super(factory);
        }
        public String getVersion() { return "2.4"; }
    }
    
    public static class V25 extends GenericMessage {
		private static final long serialVersionUID = 3937051332672967947L;
		public V25(ModelClassFactory factory) {
            super(factory);
        }
        public String getVersion() { return "2.5"; }
    }
    
    public static class V251 extends GenericMessage {
		private static final long serialVersionUID = -767282165482145544L;
		public V251(ModelClassFactory factory) {
            super(factory);
        }
        public String getVersion() { return "2.5.1"; }
    }

    public static class V26 extends GenericMessage {
		private static final long serialVersionUID = -1693277295151324396L;
		public V26(ModelClassFactory factory) {
            super(factory);
        }
        public String getVersion() { return "2.6"; }
    }

}
