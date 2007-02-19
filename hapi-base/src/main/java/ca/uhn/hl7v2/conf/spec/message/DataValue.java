package ca.uhn.hl7v2.conf.spec.message;

import ca.uhn.hl7v2.conf.ProfileException;

/**
 * An explicit data value specified in a message profile.  
 * @author Bryan Tripp
 */
public class DataValue {
    
    /** Holds value of property exValue. */
    private String exValue;
    
    /** Utility field used by bound properties. */
    private java.beans.PropertyChangeSupport propertyChangeSupport =  new java.beans.PropertyChangeSupport(this);
    
    /** Utility field used by constrained properties. */
    private java.beans.VetoableChangeSupport vetoableChangeSupport =  new java.beans.VetoableChangeSupport(this);
    
    /** Creates a new instance of DataValue */
    public DataValue() {
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
    
    /** Getter for property exValue.
     * @return Value of property exValue.
     */
    public String getExValue() {
        return this.exValue;
    }
    
    /** Setter for property exValue.
     * @param exValue New value of property exValue.
     *
     * @throws ProfileException
     */
    public void setExValue(String exValue) throws ProfileException {
        String oldExValue = this.exValue;
        try {
            vetoableChangeSupport.fireVetoableChange("exValue", oldExValue, exValue);
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }
        this.exValue = exValue;
        propertyChangeSupport.firePropertyChange("exValue", oldExValue, exValue);
    }
    
}
