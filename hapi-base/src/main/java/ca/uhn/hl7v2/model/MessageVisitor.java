/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uhn.hl7v2.model;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.Location;

/**
 * A MessageVisitor can be used to traverse a message structure. Everytime a
 * message element is found, the corresponding visitable method is called. If
 * a method returns <code>true</code>, the visiting process is continued,
 * otherwise abandoned.
 * <p>
 * A MessageVisitor should usually only be called by
 * {@link Visitable#accept(MessageVisitor, Location)}.
 * </p>
 */
public interface MessageVisitor {

    /**
     * Enters a message
     * @param message message
     * @return true if the visitor shall descend into the nested structures
     * @throws HL7Exception if an error occurred while visiting
     */    
    public boolean start(Message message) throws HL7Exception;

    /**
     * Leaves a message
     * @param message message
     * @return true if the visitor shall descend into the nested structures
     * @throws HL7Exception if an error occurred while visiting
     */
    public boolean end(Message message) throws HL7Exception;

    /**
     * Enters a group (or message)
     * @param group group
     * @param location Location object describing the location within the message
     * @return true if the visitor shall descend into the nested structures
     * @throws HL7Exception if an error occurred while visiting
     */
    boolean start(Group group, Location location) throws HL7Exception;

    /**
     * Leaves a group (or message)
     * @param group group
     * @param location Location object describing the location within the message
     * @return true if the visitor shall continue visiting the parent structure
     * @throws HL7Exception if an error occurred while visiting
     */
    boolean end(Group group, Location location) throws HL7Exception;

    /**
     * Enters a segment
     * @param segment segment
     * @param location Location object describing the location within the message
     * @return true if the visitor shall descend into the nested structures
     * @throws HL7Exception if an error occurred while visiting
     */
    boolean start(Segment segment, Location location) throws HL7Exception;

    /**
     * Leaves a segment
     * @param segment segment
     * @param location Location object describing the location within the message
     * @return true if the visitor shall continue visiting the parent structure
     * @throws HL7Exception if an error occurred while visiting
     */
    boolean end(Segment segment, Location location) throws HL7Exception;

    /**
     * Enters a field. Note that a field is *not* a physical part of the HAPI
     * model class hierarchy; it merely encapsulates all repetitions of a specific
     * field along with its substructures.
     * 
     * @param field field
     * @param location Location object describing the location within the message
     * @return true if the visitor shall descend into the nested structures
     * @throws HL7Exception if an error occurred while visiting
     */
    boolean start(Field field, Location location) throws HL7Exception;

    /**
     * Leaves a field. Note that a field is *not* a physical part of the HAPI
     * model class hierarchy; it merely encapsulates all repetitions of a specific
     * field along with its substructures.
     * 
     * @param field field
     * @param location Location object describing the location within the message
     * @return true if the visitor shall continue visiting the parent structure
     * @throws HL7Exception if an error occurred while visiting
     */
    boolean end(Field field, Location location) throws HL7Exception;
    
    /**
     * Enters a composite
     * @param type composite
     * @param location Location object describing the location within the message
     * @return true if the visitor shall descend into the nested structures
     * @throws HL7Exception if an error occurred while visiting
     */
    boolean start(Composite type, Location location) throws HL7Exception;

    /**
     * Leaves a composite
     * @param type composite
     * @param location Location object describing the location within the message
     * @return true if the visitor shall continue visiting the parent structure
     * @throws HL7Exception if an error occurred while visiting
     */
    boolean end(Composite type, Location location) throws HL7Exception;

    /**
     * Visits a primitive
     * @param type primitive
     * @param location Location object describing the location within the message
     * @return true if the visitor shall descend into the nested structures
     * @throws HL7Exception if an error occurred while visiting
     */
    boolean visit(Primitive type, Location location) throws HL7Exception;

}
