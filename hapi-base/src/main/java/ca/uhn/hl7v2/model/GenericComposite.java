package ca.uhn.hl7v2.model;

import java.util.ArrayList;
import java.util.List;

/**
 * An unspecified Composite datatype that has an undefined number of components, each 
 * of which is a Varies.  
 * This is used to store Varies data, when the data type is unknown.  It is also 
 * used to store unrecognized message constituents.  
 * @author Bryan Tripp
 */
@SuppressWarnings("serial")
public class GenericComposite extends AbstractComposite {
    
    private List<Type> components;
    private Message message;

    /**
     * Creates a generic composite
     *
     * @param message message this object is linked to
     */
    public GenericComposite(Message message) {
        super(message);
        this.message = message;
        components = new ArrayList<Type>(20);
    }
    
    /** 
     * Returns the single component of this composite at the specified position (starting at 0) - 
     * Creates it (and any nonexistent components before it) if necessary.  
     */
    public Type getComponent(int number) throws DataTypeException {
        for (int i = components.size(); i <= number; i++) {
            components.add(new Varies(message));
        }
        return components.get(number);
    }    
    
    /** 
     * Returns an array containing the components of this field.
     */
    public Type[] getComponents() {
    	return components.toArray(new Type[components.size()]);
    }    
    
    /** Returns the name of the type (used in XML encoding and profile checking)  */
    public String getName() {
        return "UNKNOWN";
    }


}
