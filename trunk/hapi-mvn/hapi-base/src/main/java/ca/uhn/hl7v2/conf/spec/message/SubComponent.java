package ca.uhn.hl7v2.conf.spec.message;

import java.util.Collections;
import java.util.List;

/**
 * The specification for a particular field sub-component in a message profile.  
 * @author Bryan Tripp
 */
public class SubComponent extends AbstractComponent<SubComponent> {
    
    /** Creates a new instance of SubComponent */
    public SubComponent() {
    }
    
    public List<Object> getChildrenAsList() {
    	return Collections.emptyList();
    }
    
}
