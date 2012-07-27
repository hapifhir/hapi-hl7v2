package ca.uhn.hl7v2.conf.spec;

import ca.uhn.hl7v2.conf.spec.usecase.UseCase;
import ca.uhn.hl7v2.conf.spec.message.StaticDef;

/**
 * A conformance specification (see HL7 2.5 section 2.12).  
 * @author Bryan Tripp
 */
public class Specification {
    
    private ImpNote impNote;
    private UseCase useCase;
    private Conformance conformance;
    private Encoding[] encodings;
        
    /** Utility field used by bound properties. */
    private java.beans.PropertyChangeSupport propertyChangeSupport =  new java.beans.PropertyChangeSupport(this);
    
    /** Utility field used by constrained properties. */
    private java.beans.VetoableChangeSupport vetoableChangeSupport =  new java.beans.VetoableChangeSupport(this);
    
    /** Holds value of property message. */
    private StaticDef message;
    
    /** Holds value of property specName. */
    private String specName;
    
    /** Holds value of property orgName. */
    private String orgName;
    
    /** Holds value of property HL7Version. */
    private String HL7Version;
    
    /** Holds value of property specVersion. */
    private String specVersion;
    
    /** Holds value of property status. */
    private String status;
    
    /** Holds value of property role. */
    private String role;
    
    /** Holds value of property HL7OID. */
    private String HL7OID;
    
    /** Holds value of property conformanceType. */
    private String conformanceType;
    
    /** Creates a new instance of Specification */
    public Specification() {
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
    public ImpNote getImpNote() {
        return this.impNote;
    }
    
    /** Setter for property impNote.
     * @param impNote New value of property impNote.
     *
     * @throws PropertyVetoException
     */
    public void setImpNote(ImpNote impNote) throws java.beans.PropertyVetoException {
        ImpNote oldImpNote = this.impNote;
        vetoableChangeSupport.fireVetoableChange("impNote", oldImpNote, impNote);
        this.impNote = impNote;
        propertyChangeSupport.firePropertyChange("impNote", oldImpNote, impNote);
    }
    
    /** Getter for property useCase.
     * @return Value of property useCase.
     */
    public UseCase getUseCase() {
        return this.useCase;
    }
    
    /** Setter for property useCase.
     * @param useCase New value of property useCase.
     *
     * @throws PropertyVetoException
     */
    public void setUseCase(UseCase useCase) throws java.beans.PropertyVetoException {
        UseCase oldUseCase = this.useCase;
        vetoableChangeSupport.fireVetoableChange("useCase", oldUseCase, useCase);
        this.useCase = useCase;
        propertyChangeSupport.firePropertyChange("useCase", oldUseCase, useCase);
    }
    
    /** Getter for property conformance.
     * @return Value of property conformance.
     */
    public Conformance getConformance() {
        return this.conformance;
    }
    
    /** Setter for property conformance.
     * @param conformance New value of property conformance.
     *
     * @throws PropertyVetoException
     */
    public void setConformance(Conformance conformance) throws java.beans.PropertyVetoException {
        Conformance oldConformance = this.conformance;
        vetoableChangeSupport.fireVetoableChange("conformance", oldConformance, conformance);
        this.conformance = conformance;
        propertyChangeSupport.firePropertyChange("conformance", oldConformance, conformance);
    }
    
    /** Indexed getter for property encodings.
     * @param index Index of the property.
     * @return Value of the property at <CODE>index</CODE>.
     */
    public Encoding getEncodings(int index) {
        return this.encodings[index];
    }
    
    /** Indexed setter for property encodings.
     * @param index Index of the property.
     * @param encodings New value of the property at <CODE>index</CODE>.
     *
     * @throws PropertyVetoException
     */
    public void setEncodings(int index, Encoding encodings) throws java.beans.PropertyVetoException {
        Encoding oldEncodings = this.encodings[index];
        this.encodings[index] = encodings;
        try {
            vetoableChangeSupport.fireVetoableChange("encodings", null, null );
        }
        catch(java.beans.PropertyVetoException vetoException ) {
            this.encodings[index] = oldEncodings;
            throw vetoException;
        }
        propertyChangeSupport.firePropertyChange("encodings", null, null );
    }
    
    /** Getter for property message.
     * @return Value of property message.
     */
    public StaticDef getMessage() {
        return this.message;
    }
    
    /** Setter for property message.
     * @param message New value of property message.
     *
     * @throws PropertyVetoException
     */
    public void setMessage(StaticDef message) throws java.beans.PropertyVetoException {
        StaticDef oldMessage = this.message;
        vetoableChangeSupport.fireVetoableChange("message", oldMessage, message);
        this.message = message;
        propertyChangeSupport.firePropertyChange("message", oldMessage, message);
    }
    
    /** Getter for property specName.
     * @return Value of property specName.
     */
    public String getSpecName() {
        return this.specName;
    }
    
    /** Setter for property specName.
     * @param specName New value of property specName.
     *
     * @throws PropertyVetoException
     */
    public void setSpecName(String specName) throws java.beans.PropertyVetoException {
        String oldSpecName = this.specName;
        vetoableChangeSupport.fireVetoableChange("specName", oldSpecName, specName);
        this.specName = specName;
        propertyChangeSupport.firePropertyChange("specName", oldSpecName, specName);
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
     * @throws PropertyVetoException
     */
    public void setOrgName(String orgName) throws java.beans.PropertyVetoException {
        String oldOrgName = this.orgName;
        vetoableChangeSupport.fireVetoableChange("orgName", oldOrgName, orgName);
        this.orgName = orgName;
        propertyChangeSupport.firePropertyChange("orgName", oldOrgName, orgName);
    }
    
    /** Getter for property HL7Version.
     * @return Value of property HL7Version.
     */
    public String getHL7Version() {
        return this.HL7Version;
    }
    
    /** Setter for property HL7Version.
     * @param HL7Version New value of property HL7Version.
     *
     * @throws PropertyVetoException
     */
    public void setHL7Version(String HL7Version) throws java.beans.PropertyVetoException {
        String oldHL7Version = this.HL7Version;
        vetoableChangeSupport.fireVetoableChange("HL7Version", oldHL7Version, HL7Version);
        this.HL7Version = HL7Version;
        propertyChangeSupport.firePropertyChange("HL7Version", oldHL7Version, HL7Version);
    }
    
    /** Getter for property specVersion.
     * @return Value of property specVersion.
     */
    public String getSpecVersion() {
        return this.specVersion;
    }
    
    /** Setter for property specVersion.
     * @param specVersion New value of property specVersion.
     *
     * @throws PropertyVetoException
     */
    public void setSpecVersion(String specVersion) throws java.beans.PropertyVetoException {
        String oldSpecVersion = this.specVersion;
        vetoableChangeSupport.fireVetoableChange("specVersion", oldSpecVersion, specVersion);
        this.specVersion = specVersion;
        propertyChangeSupport.firePropertyChange("specVersion", oldSpecVersion, specVersion);
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
     * @throws PropertyVetoException
     */
    public void setStatus(String status) throws java.beans.PropertyVetoException {
        String oldStatus = this.status;
        vetoableChangeSupport.fireVetoableChange("status", oldStatus, status);
        this.status = status;
        propertyChangeSupport.firePropertyChange("status", oldStatus, status);
    }
    
    /** Getter for property role.
     * @return Value of property role.
     */
    public String getRole() {
        return this.role;
    }
    
    /** Setter for property role.
     * @param role New value of property role.
     *
     * @throws PropertyVetoException
     */
    public void setRole(String role) throws java.beans.PropertyVetoException {
        String oldRole = this.role;
        vetoableChangeSupport.fireVetoableChange("role", oldRole, role);
        this.role = role;
        propertyChangeSupport.firePropertyChange("role", oldRole, role);
    }
    
    /** Getter for property HL7OID.
     * @return Value of property HL7OID.
     */
    public String getHL7OID() {
        return this.HL7OID;
    }
    
    /** Setter for property HL7OID.
     * @param HL7OID New value of property HL7OID.
     *
     * @throws PropertyVetoException
     */
    public void setHL7OID(String HL7OID) throws java.beans.PropertyVetoException {
        String oldHL7OID = this.HL7OID;
        vetoableChangeSupport.fireVetoableChange("HL7OID", oldHL7OID, HL7OID);
        this.HL7OID = HL7OID;
        propertyChangeSupport.firePropertyChange("HL7OID", oldHL7OID, HL7OID);
    }
    
    /** Getter for property conformanceType.
     * @return Value of property conformanceType.
     */
    public String getConformanceType() {
        return this.conformanceType;
    }
    
    /** Setter for property conformanceType.
     * @param conformanceType New value of property conformanceType.
     *
     * @throws PropertyVetoException
     */
    public void setConformanceType(String conformanceType) throws java.beans.PropertyVetoException {
        String oldConformanceType = this.conformanceType;
        vetoableChangeSupport.fireVetoableChange("conformanceType", oldConformanceType, conformanceType);
        this.conformanceType = conformanceType;
        propertyChangeSupport.firePropertyChange("conformanceType", oldConformanceType, conformanceType);
    }
    
}
