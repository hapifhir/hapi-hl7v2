package ca.uhn.hl7v2.conf.spec.message;

import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.hl7v2.conf.spec.MetaData;


/**
 * <p>A "static message profile" (see HL7 2.5 section 2.12).  Message profiles are 
 * a precise method of documenting message constraints, using a standard XML syntax 
 * defined by HL7 (introduced in version 2.5).  XML message profiles define
 * constraints on message content and structure in a well-defined manner, so that 
 * the conformance of a certain message to a certain profile can be tested automatically.  
 * There are several types of profiles: 
 * <ul><li>HL7 Profiles - the standard messages (relatively loosely constrained)</li>
 * <li>Implementable Profiles - profiles with additional constraints such that all optionality 
 *      has been removed (e.g. optional fields marked as "required" or "not supported").   
 * <li>Constrainable Profiles - any profile with optionality that can be further constrained.</li></ul>
 * Thus profiles can constrain other profiles.  A typical case would be for a country to create a 
 * constrainable profile based on an HL7 profile, for a vendor to create a different constrainable 
 * profile based on the same HL7 profile, and for a hospital to create an implementable profile for 
 * a particular implementation that constrains both.  </p>
 * <p>The MessageProfile class is a parsed object representation of the XML profile.</p>
 * @author Bryan Tripp
 */
public class StaticDef extends AbstractSegmentContainer {
    
    private MetaData metaData; 
    private String msgType;
    private String eventType;
    private String msgStructID;
    private String orderControl;
    private String eventDesc;
    private String identifier;
    private String role;
    
    /** Utility field used by bound properties. */
    private java.beans.PropertyChangeSupport propertyChangeSupport =  new java.beans.PropertyChangeSupport(this);
    
    /** Utility field used by constrained properties. */
    private java.beans.VetoableChangeSupport vetoableChangeSupport =  new java.beans.VetoableChangeSupport(this);
    
    /** Creates a new instance of MessageProfile */
    public StaticDef() {
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
    
    /** Getter for property metaData.
     * @return Value of property metaData.
     */
    public MetaData getMetaData() {
        return this.metaData;
    }
    
    /** Setter for property metaData.
     * @param msgType New value of property metaData.
     *
     * @throws ProfileException
     */
    public void setMetaData(MetaData metaData) throws ProfileException {
        MetaData oldMetaData = this.metaData;
        try {
            vetoableChangeSupport.fireVetoableChange("metaData", oldMetaData, metaData);
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }
        this.metaData = metaData;
        propertyChangeSupport.firePropertyChange("metaData", oldMetaData, metaData);
    }
    
    /** Getter for property msgType.
     * @return Value of property msgType.
     */
    public String getMsgType() {
        return this.msgType;
    }
    
    /** Setter for property msgType.
     * @param msgType New value of property msgType.
     *
     * @throws ProfileException
     */
    public void setMsgType(String msgType) throws ProfileException {
        String oldMsgType = this.msgType;
        try {
            vetoableChangeSupport.fireVetoableChange("msgType", oldMsgType, msgType);
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }
        this.msgType = msgType;
        propertyChangeSupport.firePropertyChange("msgType", oldMsgType, msgType);
    }
    
    /** Getter for property eventType.
     * @return Value of property eventType.
     */
    public String getEventType() {
        return this.eventType;
    }
    
    /** Setter for property eventType.
     * @param eventType New value of property eventType.
     *
     * @throws ProfileException
     */
    public void setEventType(String eventType) throws ProfileException {
        String oldEventType = this.eventType;
        try {
            vetoableChangeSupport.fireVetoableChange("eventType", oldEventType, eventType);
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }
        this.eventType = eventType;
        propertyChangeSupport.firePropertyChange("eventType", oldEventType, eventType);
    }
    
    /** Getter for property msgStructID.
     * @return Value of property msgStructID.
     */
    public String getMsgStructID() {
        return this.msgStructID;
    }
    
    /** Setter for property msgStructID.
     * @param msgStructID New value of property msgStructID.
     *
     * @throws ProfileException
     */
    public void setMsgStructID(String msgStructID) throws ProfileException {
        String oldMsgStructID = this.msgStructID;
        try {
            vetoableChangeSupport.fireVetoableChange("msgStructID", oldMsgStructID, msgStructID);
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }
        this.msgStructID = msgStructID;
        propertyChangeSupport.firePropertyChange("msgStructID", oldMsgStructID, msgStructID);
    }
    
    /** Getter for property orderControl.
     * @return Value of property orderControl.
     */
    public String getOrderControl() {
        return this.orderControl;
    }
    
    /** Setter for property orderControl.
     * @param orderControl New value of property orderControl.
     *
     * @throws ProfileException
     */
    public void setOrderControl(String orderControl) throws ProfileException {
        String oldOrderControl = this.orderControl;
        try {
            vetoableChangeSupport.fireVetoableChange("orderControl", oldOrderControl, orderControl);
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }
        this.orderControl = orderControl;
        propertyChangeSupport.firePropertyChange("orderControl", oldOrderControl, orderControl);
    }
    
    /** Getter for property eventDesc.
     * @return Value of property eventDesc.
     */
    public String getEventDesc() {
        return this.eventDesc;
    }
    
    /** Setter for property eventDesc.
     * @param eventDesc New value of property eventDesc.
     *
     * @throws ProfileException
     */
    public void setEventDesc(String eventDesc) throws ProfileException {
        String oldEventDesc = this.eventDesc;
        try {
            vetoableChangeSupport.fireVetoableChange("eventDesc", oldEventDesc, eventDesc);
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }
        this.eventDesc = eventDesc;
        propertyChangeSupport.firePropertyChange("eventDesc", oldEventDesc, eventDesc);
    }
    
    /** Getter for property identifier.
     * @return Value of property identifier.
     */
    public String getIdentifier() {
        return this.identifier;
    }
    
    /** Setter for property identifier.
     * @param eventDesc New value of property identifier.
     *
     * @throws ProfileException
     */
    public void setIdentifier(String identifier) throws ProfileException {
        String oldIdentifier = this.identifier;
        try {
            vetoableChangeSupport.fireVetoableChange("identifier", oldIdentifier, identifier);
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }
        this.identifier = identifier;
        propertyChangeSupport.firePropertyChange("identifier", oldIdentifier, identifier);
    }
    
    /** Getter for property role.
     * @return Value of property role.
     */
    public String getRole() {
        return this.role;
    }
    
    /** Setter for property role.
     * @param eventDesc New value of property role.
     *
     * @throws ProfileException
     */
    public void setRole(String role) throws ProfileException {
        String oldRole = this.role;
        try {
            vetoableChangeSupport.fireVetoableChange("role", oldRole, role);
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }
        this.role = role;
        propertyChangeSupport.firePropertyChange("role", oldRole, role);
    }
    
}
