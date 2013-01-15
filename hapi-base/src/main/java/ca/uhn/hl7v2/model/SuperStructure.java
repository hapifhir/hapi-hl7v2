package ca.uhn.hl7v2.model;

import java.util.List;
import java.util.Set;

/**
 * Represents a {@link Message} or {@link Group} which contains child elements 
 * for more than one structure type. Super structures are used for convenience since
 * they allow you to use the same code to handle multiple message types.  
 */
public interface SuperStructure extends Group {

	Set<String> getStructuresWhichChildAppliesTo(String theChildName);

	List<String> getChildNamesForStructure(String theStructure);
	
}
