package ca.uhn.hl7v2.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.parser.ModelClassFactory;

/**
 * A generic HL7 message, meant for parsing message with unrecognized structures
 * into a flat list of segments.
 * 
 * @author Bryan Tripp
 * @author Christian Ohr
 */
@SuppressWarnings("serial")
public abstract class GenericMessage extends AbstractMessage {
    
	private static final Logger log = LoggerFactory.getLogger(GenericMessage.class);
	
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
            log.error(message, e);
            throw new Error(message); // TODO better throw RuntimeException
        }        
    }
    
    /**
     * Returns a subclass of GenericMessage corresponding to a certain version.  
     * This is needed so that version-specific segments can be added as the message
     * is parsed.
     *
     * @param version the HL7 version
     * @return the class of the generic message
     */
	@SuppressWarnings("unchecked")
	public static Class<? extends Message> getGenericMessageClass(String version) {
		
		Version v = Version.versionOf(version);
        if (v != null) {       
        	try {
        		String className = GenericMessage.class.getName() + "$" + v.name();
        		return (Class<? extends Message>)Class.forName(className);
        	} catch (ClassNotFoundException e) {
        		// should not happen as long Version corresponds with the static
        		// subclasses of GenericMessage
        	}
        }

        log.debug("Unknown version for generic type {}", version);
        return UnknownVersion.class;
    }


    public static class UnknownVersion extends GenericMessage {
		private static final long serialVersionUID = 4773366840392833956L;

		public UnknownVersion(ModelClassFactory factory) {
            super(factory);
        }
        public String getVersion() {
        	return Version.latestVersion().getVersion();
        }

    }

    public static class V21 extends GenericMessage {
		private static final long serialVersionUID = 4773366840392833956L;
		public V21(ModelClassFactory factory) {
            super(factory);
        }
        public String getVersion() { return Version.V21.getVersion(); }
    }
    
    public static class V22 extends GenericMessage {
		private static final long serialVersionUID = 7124224621400437244L;
		public V22(ModelClassFactory factory) {
            super(factory);
        }
        public String getVersion() { return Version.V22.getVersion(); }
    }
    
    public static class V23 extends GenericMessage {
		private static final long serialVersionUID = -8794048442253389190L;
		public V23(ModelClassFactory factory) {
            super(factory);
        }
        public String getVersion() { return Version.V23.getVersion(); }
    }
    
    public static class V231 extends GenericMessage {
		private static final long serialVersionUID = 5979370667795858995L;
		public V231(ModelClassFactory factory) {
            super(factory);
        }
        public String getVersion() { return Version.V231.getVersion(); }
    }
    
    public static class V24 extends GenericMessage {
		private static final long serialVersionUID = -4944772617600551061L;
		public V24(ModelClassFactory factory) {
            super(factory);
        }
        public String getVersion() { return Version.V24.getVersion(); }
    }
    
    public static class V25 extends GenericMessage {
		private static final long serialVersionUID = 3937051332672967947L;
		public V25(ModelClassFactory factory) {
            super(factory);
        }
        public String getVersion() { return Version.V25.getVersion(); }
    }
    
    public static class V251 extends GenericMessage {
		private static final long serialVersionUID = -767282165482145544L;
		public V251(ModelClassFactory factory) {
            super(factory);
        }
        public String getVersion() { return Version.V251.getVersion(); }
    }

    public static class V26 extends GenericMessage {
		private static final long serialVersionUID = -1693277295151324396L;
		public V26(ModelClassFactory factory) {
            super(factory);
        }
        public String getVersion() { return Version.V26.getVersion(); }
    }

}
