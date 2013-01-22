package ca.uhn.hl7v2.model;

import ca.uhn.hl7v2.parser.ModelClassFactory;

/**
 * An undefined segment group.  This is for storing undefined groups
 * that appear in XML-encoded messages.  Note that if an undefined group appears 
 * in an ER7-encoded message, the group structure won't be clear and we'll just assume 
 * it's a flat list of segments.    
 * @author Bryan Tripp
 */
@SuppressWarnings("serial")
public class GenericGroup extends AbstractGroup {
    
    private String name;

    /**
     * Creates a generic group
     *
     * @param parent parent group
     * @param name name of the group
     * @param factory ModelClassFactory to be used
     */
    public GenericGroup(Group parent, String name, ModelClassFactory factory) {
        super(parent, factory);
        this.name = name;
    }
    
    /**
     * Returns the name specified at construction time. 
     * @see Structure#getName() 
     */
    public String getName() {
        return this.name;
    }
    
}
