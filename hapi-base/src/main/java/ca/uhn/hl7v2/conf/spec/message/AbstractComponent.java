package ca.uhn.hl7v2.conf.spec.message;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.hl7v2.conf.ProfileException;

/**
 * An abstraction of the common features of Field, Component, and SubComponent.  
 * @author Bryan Tripp
 */
public class AbstractComponent<T> {
    
    /** Creates a new instance of AbstractComponent */
    public AbstractComponent() {
    }
    
    
    /** Utility field used by bound properties. */
    protected java.beans.PropertyChangeSupport propertyChangeSupport =  new java.beans.PropertyChangeSupport(this);
    
    /** Utility field used by constrained properties. */
    protected java.beans.VetoableChangeSupport vetoableChangeSupport =  new java.beans.VetoableChangeSupport(this);
    
    private String impNote;
    private String description;
    private String reference;
    private String predicate;
    private final List<DataValue> dataValues = new ArrayList<DataValue>();
    private String name;
    private String usage;
    private String datatype;
    private long length;
    private String constantValue;
    private String table;
    
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
    
    /** Indexed getter for property dataValues.
     * @param index Index of the property.
     * @return Value of the property at <CODE>index</CODE>.
     */
    public DataValue getDataValues(int index) {
        return this.dataValues.get(index);
    }
    
    /** Indexed setter for property dataValues.
     * @param index Index of the property.
     * @param dataValues New value of the property at <CODE>index</CODE>.
     *
     * @throws ProfileException
     */
    public void setDataValues(int index, DataValue dataValue) throws ProfileException {
        while (dataValues.size() <= index) {
        	dataValues.add(null);
        }
        DataValue oldDataValues = this.dataValues.get(index);
        this.dataValues.set(index, dataValue);
        try {
            vetoableChangeSupport.fireVetoableChange("dataValues", null, null );
        }
        catch(java.beans.PropertyVetoException vetoException ) {
            this.dataValues.set(index, oldDataValues);
            throw new ProfileException(null, vetoException);
        }
        propertyChangeSupport.firePropertyChange("dataValues", null, null );
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
    
    /** Getter for property datatype.
     * @return Value of property datatype.
     */
    public String getDatatype() {
        return this.datatype;
    }
    
    /** Setter for property datatype.
     * @param datatype New value of property datatype.
     *
     * @throws ProfileException
     */
    public void setDatatype(String datatype) throws ProfileException {
        String oldDatatype = this.datatype;
        try {
            vetoableChangeSupport.fireVetoableChange("datatype", oldDatatype, datatype);
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }
        this.datatype = datatype;
        propertyChangeSupport.firePropertyChange("datatype", oldDatatype, datatype);
    }
    
    /** Getter for property length.
     * @return Value of property length.
     */
    public long getLength() {
        return this.length;
    }
    
    /** Setter for property length.
     * @param length New value of property length.
     *
     * @throws ProfileException
     */
    public void setLength(long length) throws ProfileException {
        long oldLength = this.length;
        try {
            vetoableChangeSupport.fireVetoableChange("length", new Long(oldLength), new Long(length));
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }
        this.length = length;
        propertyChangeSupport.firePropertyChange("length", new Long(oldLength), new Long(length));
    }
    
    /** Getter for property constantValue.
     * @return Value of property constantValue.
     */
    public String getConstantValue() {
        return this.constantValue;
    }
    
    /** Setter for property constantValue.
     * @param constantValue New value of property constantValue.
     *
     * @throws ProfileException
     */
    public void setConstantValue(String constantValue) throws ProfileException {
        String oldConstantValue = this.constantValue;
        try {
            vetoableChangeSupport.fireVetoableChange("constantValue", oldConstantValue, constantValue);
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }
        this.constantValue = constantValue;
        propertyChangeSupport.firePropertyChange("constantValue", oldConstantValue, constantValue);
    }
    
    /** Getter for property table.
     * @return Value of property table.
     */
    public String getTable() {
        return this.table;
    }
    
    /** Setter for property table.
     * @param table New value of property table.
     *
     * @throws ProfileException
     */
    public void setTable(String table) throws ProfileException {
        String oldTable = this.table;
        try {
            vetoableChangeSupport.fireVetoableChange("table", oldTable, table);
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }
        this.table = table;
        propertyChangeSupport.firePropertyChange("table", oldTable, table);
    }
    
}
