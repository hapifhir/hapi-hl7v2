package ca.uhn.hl7v2.conf.spec;

import ca.uhn.hl7v2.conf.ProfileException;

/**
 * Conformance Profile meta data (an element of ConformanceProfile and StaticDef).  
 * @author Bryan Tripp
 */
public class MetaData {
    
    /** Holds value of property name. */
    private String name;
    
    /** Utility field used by bound properties. */
    private java.beans.PropertyChangeSupport propertyChangeSupport =  new java.beans.PropertyChangeSupport(this);
    
    /** Utility field used by constrained properties. */
    private java.beans.VetoableChangeSupport vetoableChangeSupport =  new java.beans.VetoableChangeSupport(this);
    
    /** Holds value of property orgName. */
    private String orgName;
    
    /** Holds value of property version. */
    private String version;
    
    /** Holds value of property status. */
    private String status;
    
    /** Holds value of property topics. */
    private String topics;
    
    /** Creates a new instance of MetaData */
    public MetaData() {
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
    
    /** Getter for property orgName.
     * @return Value of property orgName.
     */
    public String getOrgName() {
        return this.orgName;
    }
    
    /** Setter for property orgName.
     * @param orgName New value of property orgName.
     *
     * @throws ProfileException
     */
    public void setOrgName(String orgName) throws ProfileException {
        String oldOrgName = this.orgName;
        try {
            vetoableChangeSupport.fireVetoableChange("orgName", oldOrgName, orgName);
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }
        this.orgName = orgName;
        propertyChangeSupport.firePropertyChange("orgName", oldOrgName, orgName);
    }
    
    /** Getter for property version.
     * @return Value of property version.
     */
    public String getVersion() {
        return this.version;
    }
    
    /** Setter for property version.
     * @param version New value of property version.
     *
     * @throws ProfileException
     */
    public void setVersion(String version) throws ProfileException {
        String oldVersion = this.version;
        try {
            vetoableChangeSupport.fireVetoableChange("version", oldVersion, version);
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }
        this.version = version;
        propertyChangeSupport.firePropertyChange("version", oldVersion, version);
    }
    
    /** Getter for property status.
     * @return Value of property status.
     */
    public String getStatus() {
        return this.status;
    }
    
    /** Setter for property status.
     * @param status New value of property status.
     *
     * @throws ProfileException
     */
    public void setStatus(String status) throws ProfileException {
        String oldStatus = this.status;
        try {
            vetoableChangeSupport.fireVetoableChange("status", oldStatus, status);
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }
        this.status = status;
        propertyChangeSupport.firePropertyChange("status", oldStatus, status);
    }
    
    /** Getter for property topics.
     * @return Value of property topics.
     */
    public String getTopics() {
        return this.topics;
    }
    
    /** Setter for property topics.
     * @param topics New value of property topics.
     *
     * @throws ProfileException
     */
    public void setTopics(String topics) throws ProfileException {
        String oldTopics = this.topics;
        try {
            vetoableChangeSupport.fireVetoableChange("topics", oldTopics, topics);
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }
        this.topics = topics;
        propertyChangeSupport.firePropertyChange("topics", oldTopics, topics);
    }
    
}
