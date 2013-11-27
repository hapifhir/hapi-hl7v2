package ca.uhn.hl7v2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ca.uhn.hl7v2.HL7Exception;

/**
 * A set of "extra" components (sub-components) that are not a standard part 
 * of a field (component) but have been added at runtime.  The purpose is to allow 
 * processing of locally-defined extensions to datatypes without the need for a 
 * custom message definition.  
 * Extra components are not treated uniformly with standard components (e.g. 
 * they are not accessible through methods like Primitive.getValue() and 
 * Composite.getComponent()).  To do so would blur the distinction between 
 * primitive and composite types (i.e. leaf and non-leaf nodes), which seems 
 * nice and polymorphic for a moment but actually isn't helpful.  
 * Furthermore, the auto-generated classes do not define accessors to extra 
 * components, because they are meant to encourage and enforce use of the standard 
 * message structure -- stepping outside the standard structure must be 
 * deliberate. 
 * Note that a uniformity of access to standard and extra components is provided
 * by Terser.   
 * @author Bryan Tripp
 */
public class ExtraComponents implements Serializable {
    

	private static final long serialVersionUID = -2614683870975956395L;
    
    private List<Varies> comps;
    private Message message;

    public ExtraComponents(Message message) {
        this.comps = new ArrayList<Varies>();
        this.message = message; 
    }
    
    /**
     * Returns the number of existing extra components
     * @return number of existing extra components
     */
    public int numComponents() {
        return comps.size();
    }

    /**
     * Returns true if extra components are empty
     * @return true if extra components are empty, false otherwise
     * @throws HL7Exception
     */
    public boolean isEmpty() throws HL7Exception {
        for (Varies varies : comps) {
            if (!varies.isEmpty()) return false;
        }
        return true;
    }
    
    
    /** 
     * Returns the component at the given location, creating it 
     * and all preceeding components if necessary.
     *
     * @param comp the extra component number starting at 0 (i.e. 0 is the first 
     *      extra component)
     * @return component at the given index
     */
    public Varies getComponent(int comp) {
        ensureComponentAndPredecessorsExist(comp);
        return this.comps.get(comp);
    }
    
    /**
     * Checks that the component at the given location exists, and that 
     * all preceding components exist, creating any missing ones.  
     */
    private void ensureComponentAndPredecessorsExist(int comp) {
        for (int i = this.comps.size(); i <= comp; i++) {
            this.comps.add(new Varies(message));
        }
    }


	/**
	 * Clears all extra components
	 */
	void clear() {
		comps.clear();
	}

    /**
     * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "ExtraComponents" + comps;
	}

	
	
	
}
