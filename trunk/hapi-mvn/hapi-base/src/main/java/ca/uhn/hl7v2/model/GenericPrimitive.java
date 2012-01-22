package ca.uhn.hl7v2.model;

/**
 * An unspecified Primitive datatype that imposes no constraints on its string 
 * value.  This is used to store Varies data, when the data type is unknown.  It is also 
 * used to store unrecognized message constituents.  
 * @author Bryan Tripp
 */
@SuppressWarnings("serial")
public class GenericPrimitive extends AbstractPrimitive implements Primitive {
    
//    String value = null;
    
    /** 
     * Creates a new instance of GenericPrimitive 
     */
    public GenericPrimitive(Message message) {
        super(message);
    }
    
//    /** 
//     * Returns a String representation of the value of this field.
//     */
//    public String getValue() {
//        return this.value;
//    }
    
//    /** 
//     * Sets the value of this field if the given value is legal in the context of the
//     * implementing class.
//     * @throws DataTypeException if the given value is not valid in this context.
//     */
//    public void setValue(String value) throws DataTypeException {
//        this.value = value;
//    }
    
    /** Returns the name of the type (used in XML encoding and profile checking)  */
    public String getName() {
        return "UNKNOWN";
    }
    
    /**
     * @see ca.uhn.hl7v2.model.Primitive#getVersion()
     */
    public String getVersion() {
        return null;
    }
    
    
}
