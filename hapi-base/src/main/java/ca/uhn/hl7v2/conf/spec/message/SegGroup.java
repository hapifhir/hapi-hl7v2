package ca.uhn.hl7v2.conf.spec.message;

import ca.uhn.hl7v2.conf.ProfileException;

/**
 * A specification for a segment group in a conformance profile.  
 * @author Bryan Tripp
 */
public class SegGroup extends AbstractSegmentContainer implements ProfileStructure {
    
    private String predicate;
    private String name;
    private String longName;
    private String usage;
    private short min;
    private short max;
    
    /** Utility field used by bound properties. */
    private java.beans.PropertyChangeSupport propertyChangeSupport =  new java.beans.PropertyChangeSupport(this);
    
    /** Utility field used by constrained properties. */
    private java.beans.VetoableChangeSupport vetoableChangeSupport =  new java.beans.VetoableChangeSupport(this);
    
    /** Creates a new instance of SegGroup */
    public SegGroup() {
    }
    
    /**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "SegGroup[" + getName() + "]";
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
     * @param usage New value of property usage.
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
    
}
