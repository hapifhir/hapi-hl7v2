package ca.uhn.hl7v2.conf.spec;

/**
 * Part of a specification that defines application behavior and IDs 
 * for other parts of the spec.   
 * @author Bryan Tripp
 */
public class Conformance {
    
    /** Holds value of property acceptAck. */
    private String acceptAck;
    
    /** Utility field used by bound properties. */
    private java.beans.PropertyChangeSupport propertyChangeSupport =  new java.beans.PropertyChangeSupport(this);
    
    /** Utility field used by constrained properties. */
    private java.beans.VetoableChangeSupport vetoableChangeSupport =  new java.beans.VetoableChangeSupport(this);
    
    /** Holds value of property applicationAck. */
    private String applicationAck;
    
    /** Holds value of property staticID. */
    private String staticID;
    
    /** Holds value of property dnamicID. */
    private String dnamicID;
    
    /** Holds value of property msgAckMode. */
    private String msgAckMode;
    
    /** Creates a new instance of Conformance */
    public Conformance() {
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
    
    /** Getter for property acceptAck.
     * @return Value of property acceptAck.
     */
    public String getAcceptAck() {
        return this.acceptAck;
    }
    
    /** Setter for property acceptAck.
     * @param acceptAck New value of property acceptAck.
     *
     * @throws PropertyVetoException
     */
    public void setAcceptAck(String acceptAck) throws java.beans.PropertyVetoException {
        String oldAcceptAck = this.acceptAck;
        vetoableChangeSupport.fireVetoableChange("acceptAck", oldAcceptAck, acceptAck);
        this.acceptAck = acceptAck;
        propertyChangeSupport.firePropertyChange("acceptAck", oldAcceptAck, acceptAck);
    }
    
    /** Getter for property applicationAck.
     * @return Value of property applicationAck.
     */
    public String getApplicationAck() {
        return this.applicationAck;
    }
    
    /** Setter for property applicationAck.
     * @param applicationAck New value of property applicationAck.
     *
     * @throws PropertyVetoException
     */
    public void setApplicationAck(String applicationAck) throws java.beans.PropertyVetoException {
        String oldApplicationAck = this.applicationAck;
        vetoableChangeSupport.fireVetoableChange("applicationAck", oldApplicationAck, applicationAck);
        this.applicationAck = applicationAck;
        propertyChangeSupport.firePropertyChange("applicationAck", oldApplicationAck, applicationAck);
    }
    
    /** Getter for property staticID.
     * @return Value of property staticID.
     */
    public String getStaticID() {
        return this.staticID;
    }
    
    /** Setter for property staticID.
     * @param staticID New value of property staticID.
     *
     * @throws PropertyVetoException
     */
    public void setStaticID(String staticID) throws java.beans.PropertyVetoException {
        String oldStaticID = this.staticID;
        vetoableChangeSupport.fireVetoableChange("staticID", oldStaticID, staticID);
        this.staticID = staticID;
        propertyChangeSupport.firePropertyChange("staticID", oldStaticID, staticID);
    }
    
    /** Getter for property dnamicID.
     * @return Value of property dnamicID.
     */
    public String getDnamicID() {
        return this.dnamicID;
    }
    
    /** Setter for property dnamicID.
     * @param dnamicID New value of property dnamicID.
     *
     * @throws PropertyVetoException
     */
    public void setDnamicID(String dnamicID) throws java.beans.PropertyVetoException {
        String oldDnamicID = this.dnamicID;
        vetoableChangeSupport.fireVetoableChange("dnamicID", oldDnamicID, dnamicID);
        this.dnamicID = dnamicID;
        propertyChangeSupport.firePropertyChange("dnamicID", oldDnamicID, dnamicID);
    }
    
    /** Getter for property msgAckMode.
     * @return Value of property msgAckMode.
     */
    public String getMsgAckMode() {
        return this.msgAckMode;
    }
    
    /** Setter for property msgAckMode.
     * @param msgAckMode New value of property msgAckMode.
     *
     * @throws PropertyVetoException
     */
    public void setMsgAckMode(String msgAckMode) throws java.beans.PropertyVetoException {
        String oldMsgAckMode = this.msgAckMode;
        vetoableChangeSupport.fireVetoableChange("msgAckMode", oldMsgAckMode, msgAckMode);
        this.msgAckMode = msgAckMode;
        propertyChangeSupport.firePropertyChange("msgAckMode", oldMsgAckMode, msgAckMode);
    }
    
}
