package ca.uhn.hl7v2.conf.spec.message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import ca.uhn.hl7v2.conf.ProfileException;

/**
 * An abstraction of SegGroup and MessageProfile (both are containers for segment specs).  
 * @author Bryan Tripp
 */
public class AbstractSegmentContainer implements Iterable<ProfileStructure> {
    
    private String description;
    private String reference;
    private String impNote;    
    private List<ProfileStructure> children = new ArrayList<ProfileStructure>();
    
    /** Utility field used by bound properties. */
    private java.beans.PropertyChangeSupport propertyChangeSupport =  new java.beans.PropertyChangeSupport(this);
    
    /** Utility field used by constrained properties. */
    private java.beans.VetoableChangeSupport vetoableChangeSupport =  new java.beans.VetoableChangeSupport(this);
    
    /** Creates a new instance of AbstractSegmentContainer */
    public AbstractSegmentContainer() {
    }
    
    public List<ProfileStructure> getChildrenAsList() {
    	return (children);
    }
    
    /** Adds a PropertyChangeListener to the listener list.
     * @param l The listener to add.
     */
    public void addPropertyChangeListener(java.beans.PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }
    
    /** Removes a PropertyChangeListener from the listener list.
     * @param l The listener to remove.
     */
    public void removePropertyChangeListener(java.beans.PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
    
    /** Adds a VetoableChangeListener to the listener list.
     * @param l The listener to add.
     */
    public void addVetoableChangeListener(java.beans.VetoableChangeListener l) {
        vetoableChangeSupport.addVetoableChangeListener(l);
    }
    
    /** Removes a VetoableChangeListener from the listener list.
     * @param l The listener to remove.
     */
    public void removeVetoableChangeListener(java.beans.VetoableChangeListener l) {
        vetoableChangeSupport.removeVetoableChangeListener(l);
    }
    
    /** Getter for property description.
     * @return Value of property description.
     */
    public String getDescription() {
        return this.description;
    }
    
    /** Setter for property description.
     * @param description New value of property description.
     *
     * @throws ProfileException
     */
    public void setDescription(String description) throws ProfileException {
        String oldDescription = this.description;
        try {
            vetoableChangeSupport.fireVetoableChange("description", oldDescription, description);
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }
        this.description = description;
        propertyChangeSupport.firePropertyChange("description", oldDescription, description);
    }
    
    /** Getter for property reference.
     * @return Value of property reference.
     */
    public String getReference() {
        return this.reference;
    }
    
    /** Setter for property reference.
     * @param reference New value of property reference.
     *
     * @throws ProfileException
     */
    public void setReference(String reference) throws ProfileException {
        String oldReference = this.reference;
        try {
            vetoableChangeSupport.fireVetoableChange("reference", oldReference, reference);
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }
        this.reference = reference;
        propertyChangeSupport.firePropertyChange("reference", oldReference, reference);
    }
    
    /** Getter for property impNote.
     * @return Value of property impNote.
     */
    public String getImpNote() {
        return this.impNote;
    }
    
    /** Setter for property impNote.
     * @param impNote New value of property impNote.
     *
     * @throws ProfileException
     */
    public void setImpNote(String impNote) throws ProfileException {
        String oldImpNote = this.impNote;
        try {
            vetoableChangeSupport.fireVetoableChange("impNote", oldImpNote, impNote);
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }
        this.impNote = impNote;
        propertyChangeSupport.firePropertyChange("impNote", oldImpNote, impNote);
    }
        
    
    /** Indexed getter for property structure (index starts at 1 following HL7 convention).
     * @param index Index of the property (starts at 1 following HL7 convention).
     * @return Value of the property at <CODE>index</CODE>.
     */
    public ProfileStructure getChild(int index) {
        return this.children.get(index - 1);
    }
    
    /** Indexed setter for property structure.  Lengthens child list if necessary.  
     * @param index Index of the property (starts at 1 following HL7 convention).
     * @param structure New value of the property at <CODE>index</CODE>.
     *
     * @throws ProfileException
     */
    public void setChild(int index, ProfileStructure structure) throws ProfileException {
        index--;
        while (children.size() <= index) {
        	children.add(null);
        }
        ProfileStructure oldStructure = this.children.get(index);
        this.children.set(index, structure);
        try {
            vetoableChangeSupport.fireVetoableChange("structure", null, null );
        }
        catch(java.beans.PropertyVetoException vetoException ) {
            this.children.set(index, oldStructure);
            throw new ProfileException(null, vetoException);
        }
        propertyChangeSupport.firePropertyChange("structure", null, null );
    }
    
    /** Returns the number of children */
    public int getChildren() {
        return this.children.size();
    }
    
	public Iterator<ProfileStructure> iterator() {
		return (this.children).iterator();
	}
    
}
