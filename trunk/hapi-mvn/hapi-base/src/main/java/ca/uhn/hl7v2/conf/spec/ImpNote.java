package ca.uhn.hl7v2.conf.spec;

/**
 * An implementation note.  
 * @author Bryan Tripp
 */
public class ImpNote {
    
    /** Holds value of property text. */
    private String text;
    
    /** Utility field used by bound properties. */
    private java.beans.PropertyChangeSupport propertyChangeSupport =  new java.beans.PropertyChangeSupport(this);
    
    /** Utility field used by constrained properties. */
    private java.beans.VetoableChangeSupport vetoableChangeSupport =  new java.beans.VetoableChangeSupport(this);
    
    /** Creates a new instance of ImpNote */
    public ImpNote() {
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
    
    /** Getter for property text.
     * @return Value of property text.
     */
    public String getText() {
        return this.text;
    }
    
    /** Setter for property text.
     * @param text New value of property text.
     *
     * @throws PropertyVetoException
     */
    public void setText(String text) throws java.beans.PropertyVetoException {
        String oldText = this.text;
        vetoableChangeSupport.fireVetoableChange("text", oldText, text);
        this.text = text;
        propertyChangeSupport.firePropertyChange("text", oldText, text);
    }
    
}
