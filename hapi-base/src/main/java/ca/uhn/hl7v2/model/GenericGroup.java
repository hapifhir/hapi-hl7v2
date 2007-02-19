package ca.uhn.hl7v2.model;

import ca.uhn.hl7v2.parser.ModelClassFactory;

/**
 * An undefined segment group.  This is for storing undefined groups
 * that appear in XML-encoded messages.  Note that if an undefined group appears 
 * in an ER7-encoded message, the group structure won't be clear and we'll just assume 
 * it's a flat list of segments.    
 * @author Bryan Tripp
 */
public class GenericGroup extends AbstractGroup {
    
    private String name;
    
    /** Creates a new instance of GenericGroup */
    public GenericGroup(Group parent, String name, ModelClassFactory factory) {
        super(parent, factory);
        this.name = name;
    }
    
    /** Returns the Message object to which this segment belongs.  This should normally be set at
     * construction time.  A Structure can only belong to a single Message.  This is primarily
     * to avoid a situation where intended changes in one message cause unintended changes
     * in another that shares one of the same Structure objects.
     */
    /*public Message getMessage() {
        return super.message;
    }*/
    
    /**
     * Returns the name specified at construction time. 
     * @see Structure#getName() 
     */
    public String getName() {
        return this.name;
    }
    
}
