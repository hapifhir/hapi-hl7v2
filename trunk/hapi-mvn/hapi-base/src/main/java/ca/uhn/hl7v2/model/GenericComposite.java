package ca.uhn.hl7v2.model;

import java.util.ArrayList;

/**
 * An unspecified Composite datatype that has an undefined number of components, each 
 * of which is a Varies.  
 * This is used to store Varies data, when the data type is unknown.  It is also 
 * used to store unrecognized message constituents.  
 * @author Bryan Tripp
 */
public class GenericComposite extends AbstractType implements Composite {
    
    private ArrayList<Type> components;
    private Message message;
    
    /** Creates a new instance of GenericComposite */
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
        return (Type) components.get(number);
    }    
    
    /** 
     * Returns an array containing the components of this field.
     */
    public Type[] getComponents() {
        Type[] ret = new Type[components.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (Type) components.get(i);
        }
        return ret;
    }    
    
    /** Returns the name of the type (used in XML encoding and profile checking)  */
    public String getName() {
        return "UNKNOWN";
    }

	
	/**
	 * {@inheritDoc }
	 */
	public void clear() {
		for (Type next : components) {
			next.clear();
		}
	}




}
