package ca.uhn.hl7v2.model;

/**
 * An unspecified Primitive datatype that imposes no constraints on its string 
 * value.  This is used to store Varies data, when the data type is unknown.  It is also 
 * used to store unrecognized message constituents.  
 * @author Bryan Tripp
 */
@SuppressWarnings("serial")
public class GenericPrimitive extends AbstractPrimitive implements Primitive {

    /**
     * Create a generic primitive
     * @param message message to which the primitive is linked to
     */
    public GenericPrimitive(Message message) {
        super(message);
    }

    public String getName() {
        return "UNKNOWN";
    }

    /**
     * As this is a generic primitive, this method returns <code>null</code> to
     * inidicate that it is not associated with a dedicated HL7 version
     * @return null
     */
    public String getVersion() {
        return null;
    }
    
    
}
