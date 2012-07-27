package ca.uhn.hl7v2.conf.spec;

import ca.uhn.hl7v2.conf.spec.usecase.UseCase;
import ca.uhn.hl7v2.conf.spec.message.StaticDef;
import ca.uhn.hl7v2.conf.ProfileException;

/**
 * A conformance specification (see HL7 2.5 section 2.12).  
 * @author Bryan Tripp
 */
public class RuntimeProfile {
    
    private Conformance conformance;
    /** Holds value of property conformanceType. */
    private String conformanceType;
    private Encoding[] encodings;
    /** Holds value of property HL7OID. */
    private String HL7OID;
    /** Holds value of property HL7Version. */
    private String HL7Version;
        
    private String impNote;
    
    /** Holds value of property message. */
    private StaticDef message;
    
    /** Holds value of property orgName. */
    private String orgName;
    
    /** Utility field used by bound properties. */
    private java.beans.PropertyChangeSupport propertyChangeSupport =  new java.beans.PropertyChangeSupport(this);
    
    /** Holds value of property role. */
    private String role;
    
    /** Holds value of property specName. */
    private String specName;
    
    /** Holds value of property specVersion. */
    private String specVersion;
    
    /** Holds value of property status. */
    private String status;
    
    private UseCase useCase;
    
    /** Utility field used by constrained properties. */
    private java.beans.VetoableChangeSupport vetoableChangeSupport =  new java.beans.VetoableChangeSupport(this);
	private String name;
    
    /** Creates a new instance of Specification */
    public RuntimeProfile() {
    }
    
    /** Adds a PropertyChangeListener to the listener list.
     * @param l The listener to add.
     */
    public void addPropertyChangeListener(java.beans.PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }
    
    /** Adds a VetoableChangeListener to the listener list.
     * @param l The listener to add.
     */
    public void addVetoableChangeListener(java.beans.VetoableChangeListener l) {
        vetoableChangeSupport.addVetoableChangeListener(l);
    }
    
    /** Getter for property conformance.
     * @return Value of property conformance.
     */
    public Conformance getConformance() {
        return this.conformance;
    }
    
    /** Getter for property conformanceType.
     * @return Value of property conformanceType.
     */
    public String getConformanceType() {
        return this.conformanceType;
    }
    
    /** Indexed getter for property encodings.
     * @param index Index of the property.
     * @return Value of the property at <CODE>index</CODE>.
     */
    public Encoding getEncodings(int index) {
        return this.encodings[index];
    }
    
    /** Getter for property HL7OID.
     * @return Value of property HL7OID.
     */
    public String getHL7OID() {
        return this.HL7OID;
    }
    
    /** Getter for property HL7Version.
     * @return Value of property HL7Version.
     */
    public String getHL7Version() {
        return this.HL7Version;
    }
    
    /** Getter for property impNote.
     * @return Value of property impNote.
     */
    public String getImpNote() {
        return this.impNote;
    }
    
    /** Getter for property message.
     * @return Value of property message.
     */
    public StaticDef getMessage() {
        return this.message;
    }
    
    /** Getter for property orgName.
     * @return Value of property orgName.
     */
    public String getOrgName() {
        return this.orgName;
    }
    
    /** Getter for property role.
     * @return Value of property role.
     */
    public String getRole() {
        return this.role;
    }
    
    /** Getter for property specName.
     * @return Value of property specName.
     */
    public String getSpecName() {
        return this.specName;
    }
    
    /** Getter for property specVersion.
     * @return Value of property specVersion.
     */
    public String getSpecVersion() {
        return this.specVersion;
    }
    
    /** Getter for property status.
     * @return Value of property status.
     */
    public String getStatus() {
        return this.status;
    }
    
    /** Getter for property useCase.
     * @return Value of property useCase.
     */
    public UseCase getUseCase() {
        return this.useCase;
    }
    
    /** Removes a PropertyChangeListener from the listener list.
     * @param l The listener to remove.
     */
    public void removePropertyChangeListener(java.beans.PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
    
    /** Removes a VetoableChangeListener from the listener list.
     * @param l The listener to remove.
     */
    public void removeVetoableChangeListener(java.beans.VetoableChangeListener l) {
        vetoableChangeSupport.removeVetoableChangeListener(l);
    }
    
    /** Setter for property conformance.
     * @param conformance New value of property conformance.
     *
     * @throws ProfileException
     */
    public void setConformance(Conformance conformance) throws ProfileException {
        Conformance oldConformance = this.conformance;
        try {
            vetoableChangeSupport.fireVetoableChange("conformance", oldConformance, conformance);
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }
        this.conformance = conformance;
        propertyChangeSupport.firePropertyChange("conformance", oldConformance, conformance);
    }
    
    /** Setter for property conformanceType.
     * @param conformanceType New value of property conformanceType.
     *
     * @throws ProfileException
     */
    public void setConformanceType(String conformanceType) throws ProfileException {
        String oldConformanceType = this.conformanceType;
        try {
            vetoableChangeSupport.fireVetoableChange("conformanceType", oldConformanceType, conformanceType);
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }
        this.conformanceType = conformanceType;
        propertyChangeSupport.firePropertyChange("conformanceType", oldConformanceType, conformanceType);
    }
    
    /** Indexed setter for property encodings.
     * @param index Index of the property.
     * @param encodings New value of the property at <CODE>index</CODE>.
     *
     * @throws ProfileException
     */
    public void setEncodings(int index, Encoding encodings) throws ProfileException {
        Encoding oldEncodings = this.encodings[index];
        this.encodings[index] = encodings;
        try {
            vetoableChangeSupport.fireVetoableChange("encodings", null, null );
        }
        catch(java.beans.PropertyVetoException vetoException ) {
            this.encodings[index] = oldEncodings;
            throw new ProfileException(null, vetoException);
        }
        propertyChangeSupport.firePropertyChange("encodings", null, null );
    }
    
    /** Setter for property HL7OID.
     * @param HL7OID New value of property HL7OID.
     *
     * @throws ProfileException
     */
    public void setHL7OID(String HL7OID) throws ProfileException {
        String oldHL7OID = this.HL7OID;
        try {
            vetoableChangeSupport.fireVetoableChange("HL7OID", oldHL7OID, HL7OID);
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }
        this.HL7OID = HL7OID;
        propertyChangeSupport.firePropertyChange("HL7OID", oldHL7OID, HL7OID);
    }
    
    /** Setter for property HL7Version.
     * @param HL7Version New value of property HL7Version.
     *
     * @throws ProfileException
     */
    public void setHL7Version(String HL7Version) throws ProfileException {
        String oldHL7Version = this.HL7Version;
        try {
            vetoableChangeSupport.fireVetoableChange("HL7Version", oldHL7Version, HL7Version);
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }
        this.HL7Version = HL7Version;
        propertyChangeSupport.firePropertyChange("HL7Version", oldHL7Version, HL7Version);
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
    
    /** Setter for property message.
     * @param message New value of property message.
     *
     * @throws ProfileException
     */
    public void setMessage(StaticDef message) throws ProfileException {
        StaticDef oldMessage = this.message;
        try {
            vetoableChangeSupport.fireVetoableChange("message", oldMessage, message);
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }
        this.message = message;
        propertyChangeSupport.firePropertyChange("message", oldMessage, message);
    }
    
    public void setName(String theName) throws ProfileException {
        String oldOrgName = this.name;
        try {
            vetoableChangeSupport.fireVetoableChange("name", oldOrgName, theName);
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }
        this.name = theName;
        propertyChangeSupport.firePropertyChange("name", oldOrgName, theName);
	}
    
    /**
	 * @return the name for this profile (as drawn from the MetaData tag within the overall profile tag)
	 */
	public String getName() {
		return name;
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
    
    /** Setter for property role.
     * @param role New value of property role.
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
    
    /** Setter for property specName.
     * @param specName New value of property specName.
     *
     * @throws ProfileException
     */
    public void setSpecName(String specName) throws ProfileException {
        String oldSpecName = this.specName;
        try {
            vetoableChangeSupport.fireVetoableChange("specName", oldSpecName, specName);
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }
        this.specName = specName;
        propertyChangeSupport.firePropertyChange("specName", oldSpecName, specName);
    }
    
    /** Setter for property specVersion.
     * @param specVersion New value of property specVersion.
     *
     * @throws ProfileException
     */
    public void setSpecVersion(String specVersion) throws ProfileException {
        String oldSpecVersion = this.specVersion;
        try {
            vetoableChangeSupport.fireVetoableChange("specVersion", oldSpecVersion, specVersion);
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }
        this.specVersion = specVersion;
        propertyChangeSupport.firePropertyChange("specVersion", oldSpecVersion, specVersion);
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

	/** Setter for property useCase.
     * @param useCase New value of property useCase.
     *
     * @throws ProfileException
     */
    public void setUseCase(UseCase useCase) throws ProfileException {
        UseCase oldUseCase = this.useCase;
        try {
            vetoableChangeSupport.fireVetoableChange("useCase", oldUseCase, useCase);
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }
        this.useCase = useCase;
        propertyChangeSupport.firePropertyChange("useCase", oldUseCase, useCase);
    }
    
}
