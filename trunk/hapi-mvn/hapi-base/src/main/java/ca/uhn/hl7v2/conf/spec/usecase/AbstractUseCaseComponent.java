package ca.uhn.hl7v2.conf.spec.usecase;

/**
 * An abstraction of the parts of a use case (eg EventFlow), all of which have a name and a body.  
 * @author Bryan Tripp 
 */
public class AbstractUseCaseComponent {
    
    /** Holds value of property name. */
    private String name;
    
    /** Utility field used by bound properties. */
    private java.beans.PropertyChangeSupport propertyChangeSupport =  new java.beans.PropertyChangeSupport(this);
    
    /** Utility field used by constrained properties. */
    private java.beans.VetoableChangeSupport vetoableChangeSupport =  new java.beans.VetoableChangeSupport(this);
    
    /** Holds value of property body. */
    private String body;
    
    /** Creates a new instance of AbstractUseCaseComponent */
    public AbstractUseCaseComponent() {
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
    
    /** Getter for property name.
     * @return Value of property name.
     */
    public String getName() {
        return this.name;
    }
    
    /** Setter for property name.
     * @param name New value of property name.
     *
     * @throws PropertyVetoException
     */
    public void setName(String name) throws java.beans.PropertyVetoException {
        String oldName = this.name;
        vetoableChangeSupport.fireVetoableChange("name", oldName, name);
        this.name = name;
        propertyChangeSupport.firePropertyChange("name", oldName, name);
    }
    
    /** Getter for property body.
     * @return Value of property body.
     */
    public String getBody() {
        return this.body;
    }
    
    /** Setter for property body.
     * @param body New value of property body.
     *
     * @throws PropertyVetoException
     */
    public void setBody(String body) throws java.beans.PropertyVetoException {
        String oldBody = this.body;
        vetoableChangeSupport.fireVetoableChange("body", oldBody, body);
        this.body = body;
        propertyChangeSupport.firePropertyChange("body", oldBody, body);
    }
    
}
