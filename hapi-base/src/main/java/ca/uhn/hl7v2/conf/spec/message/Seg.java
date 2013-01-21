package ca.uhn.hl7v2.conf.spec.message;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.hl7v2.conf.ProfileException;

/**
 * A specification for a message segment in a conformance profile.  
 * @author Bryan Tripp
 */
public class Seg implements ProfileStructure {
    
    
    /** Utility field used by bound properties. */
    private java.beans.PropertyChangeSupport propertyChangeSupport =  new java.beans.PropertyChangeSupport(this);
    
    /** Utility field used by constrained properties. */
    private java.beans.VetoableChangeSupport vetoableChangeSupport =  new java.beans.VetoableChangeSupport(this);
    
    private String impNote;    
    private String description;
    private String reference;
    private String predicate;
    private final List<Field> fields = new ArrayList<Field>();
    private String name;
    private String longName;
    private String usage;
    private short min;
    private short max;
    
    /** Creates a new instance of Segment */
    public Seg() {
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
    
    /** Getter for property predicate.
     * @return Value of property predicate.
     */
    public String getPredicate() {
        return this.predicate;
    }
    
    /** Setter for property predicate.
     * @param predicate New value of property predicate.
     *
     * @throws ProfileException
     */
    public void setPredicate(String predicate) throws ProfileException {
        String oldPredicate = this.predicate;
        try {
            vetoableChangeSupport.fireVetoableChange("predicate", oldPredicate, predicate);
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }
        this.predicate = predicate;
        propertyChangeSupport.firePropertyChange("predicate", oldPredicate, predicate);
    }
    
    /** Indexed getter for property field (index starts at 1 following HL7 convention).
     * @param index Index of the property (starts at 1 following HL7 convention).
     * @return Value of the property at <CODE>index</CODE>.
     */
    public Field getField(int index) {
        return this.fields.get(index - 1);
    }
    
    /** Indexed setter for property field (index starts at 1 following HL7 convention).
     * @param index Index of the property (starts at 1 following HL7 convention).
     * @param field New value of the property at <CODE>index</CODE>.
     *
     * @throws ProfileException
     */
    public void setField(int index, Field field) throws ProfileException {
        index--;
        while (fields.size() <= index) {
        	fields.add(null);
        }
        Field oldField = this.fields.get(index);
        this.fields.set(index,field);
        try {
            vetoableChangeSupport.fireVetoableChange("fields", null, null );
        }
        catch(java.beans.PropertyVetoException vetoException ) {
            this.fields.set(index, oldField);
            throw new ProfileException(null, vetoException);
        }
        propertyChangeSupport.firePropertyChange("fields", null, null );
    }
    
    /** Getter for property name.
     * @return Value of property name.
     */
    public String getName() {
        return this.name;
    }
    
    /** Setter for property name.
     * @param name New value of property name.
     *
     * @throws ProfileException
     */
    public void setName(String name) throws ProfileException {
        String oldName = this.name;
        try {
            vetoableChangeSupport.fireVetoableChange("name", oldName, name);
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }
        this.name = name;
        propertyChangeSupport.firePropertyChange("name", oldName, name);
    }
    
    /** Getter for property longName.
     * @return Value of property longName.
     */
    public String getLongName() {
        return this.longName;
    }
    
    /** Setter for property longName.
     * @param longName New value of property longName.
     *
     * @throws ProfileException
     */
    public void setLongName(String longName) throws ProfileException {
        String oldLongName = this.longName;
        try {
            vetoableChangeSupport.fireVetoableChange("longName", oldLongName, longName);
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }
        this.longName = longName;
        propertyChangeSupport.firePropertyChange("longName", oldLongName, longName);
    }
    
    /** Getter for property usage.
     * @return Value of property usage.
     */
    public String getUsage() {
        return this.usage;
    }
    
    /** Setter for property usage.
     * @param optionality New value of property usage.
     *
     * @throws ProfileException
     */
    public void setUsage(String usage) throws ProfileException {
        String oldUsage = this.usage;
        try {
            vetoableChangeSupport.fireVetoableChange("usage", oldUsage, usage);
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }            
        this.usage = usage;
        propertyChangeSupport.firePropertyChange("usage", oldUsage, usage);
    }
    
    /** Getter for property min.
     * @return Value of property min.
     */
    public short getMin() {
        return this.min;
    }
    
    /** Setter for property min.
     * @param min New value of property min.
     *
     * @throws ProfileException
     */
    public void setMin(short min) throws ProfileException {
        short oldMin = this.min;
        try {
            vetoableChangeSupport.fireVetoableChange("min", new Short(oldMin), new Short(min));
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }            
        this.min = min;
        propertyChangeSupport.firePropertyChange("min", new Short(oldMin), new Short(min));
    }
    
    /** Getter for property max.
     * @return Value of property max.
     */
    public short getMax() {
        return this.max;
    }
    
    /** Setter for property max.
     * @param max New value of property max.
     *
     * @throws ProfileException
     */
    public void setMax(short max) throws ProfileException {
        short oldMax = this.max;
        try {
            vetoableChangeSupport.fireVetoableChange("max", new Short(oldMax), new Short(max));
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }
        this.max = max;
        propertyChangeSupport.firePropertyChange("max", new Short(oldMax), new Short(max));
    }
    

    /** Returns the number of fields in the segment */
    public int getFields() {
        return this.fields.size();
    }

    /** Returns the number of fields in the segment */
    public List<Field> getFieldsAsList() {
        return (this.fields);
    }

    /** Returns the number of fields in the segment */
    public List<Field> getChildrenAsList() {
        return (this.fields);
    }

}
