package ca.uhn.hl7v2.conf.spec.message;

import ca.uhn.hl7v2.conf.ProfileException;

/**
 * A message profile Segment or SegGroup. 
 * @author Bryan Tripp
 */
public interface ProfileStructure {

    /** Getter for property name.
     * @return Value of property name.
     */
    String getName();
    
    /** Setter for property name.
     * @param name New value of property name.
     *
     * @throws ProfileException
     */
    void setName(String name) throws ProfileException;
    
    /** Getter for property longName.
     * @return Value of property longName.
     */
    String getLongName();
    
    /** Setter for property longName.
     * @param longName New value of property longName.
     *
     * @throws ProfileException
     */
    void setLongName(String longName) throws ProfileException;
    
    /** Getter for property usage.
     * @return Value of property usage.
     */
    String getUsage();
    
    /** Setter for property usage.
     * @param usage New value of property usage.
     *
     * @throws ProfileException
     */
    void setUsage(String usage) throws ProfileException;
    
    /** Getter for property min.
     * @return Value of property min.
     */
    short getMin();
    
    /** Setter for property min.
     * @param min New value of property min.
     *
     * @throws ProfileException
     */
    void setMin(short min) throws ProfileException;
    
    /** Getter for property max.
     * @return Value of property max.
     */
    short getMax();
    
    /** Setter for property max.
     * @param max New value of property max.
     *
     * @throws ProfileException
     */
    void setMax(short max) throws ProfileException;
            
    /** Getter for property impNote.
     * @return Value of property impNote.
     */
    String getImpNote();
    
    /** Setter for property impNote.
     * @param impNote New value of property impNote.
     *
     * @throws ProfileException
     */
    void setImpNote(String impNote) throws ProfileException;
    
    /** Getter for property description.
     * @return Value of property description.
     */
    String getDescription();
    
    /** Setter for property description.
     * @param description New value of property description.
     *
     * @throws ProfileException
     */
    void setDescription(String description) throws ProfileException;
    
    /** Getter for property reference.
     * @return Value of property reference.
     */
    String getReference();
    
    /** Setter for property reference.
     * @param reference New value of property reference.
     *
     * @throws ProfileException
     */
    void setReference(String reference) throws ProfileException;
    
    /** Getter for property predicate.
     * @return Value of property predicate.
     */
    String getPredicate();
    
    /** Setter for property predicate.
     * @param predicate New value of property predicate.
     *
     * @throws ProfileException
     */
    void setPredicate(String predicate) throws ProfileException;
        
}
