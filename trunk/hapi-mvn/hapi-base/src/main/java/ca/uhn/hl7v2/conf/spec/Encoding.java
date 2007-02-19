package ca.uhn.hl7v2.conf.spec;

/**
 * A class that indicated an HL7 encoding acceptable within a 
 * specification. 
 * @author Bryan Tripp
 */
public class Encoding {
    
    /** Creates a new instance of Encoding */
    public Encoding() {
    }
    
    public static class ER7 extends Encoding {}    
    public static class XML extends Encoding {}
    
}
