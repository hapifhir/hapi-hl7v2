package ca.uhn.hl7v2.conf.spec.message;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.hl7v2.conf.ProfileException;

/**
 * The specification for a specific field in a message profile.  
 * @author Bryan Tripp
 */
public class Field extends AbstractComponent<Field> {
    
    /** Utility field used by bound properties. */
    private java.beans.PropertyChangeSupport propertyChangeSupport =  new java.beans.PropertyChangeSupport(this);
    
    /** Utility field used by constrained properties. */
    private java.beans.VetoableChangeSupport vetoableChangeSupport =  new java.beans.VetoableChangeSupport(this);
    
    private short min;
    private short max;
    private short itemNo;

    private final List<Component> components = new ArrayList<Component>();
    
    /** Creates a new instance of Field */
    public Field() {
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
    
    /** Getter for property itemNo.
     * @return Value of property itemNo.
     */
    public short getItemNo() {
        return this.itemNo;
    }
    
    /** Setter for property itemNo.
     * @param itemNo New value of property itemNo.
     *
     * @throws ProfileException
     */
    public void setItemNo(short itemNo) throws ProfileException {
        short oldItemNo = this.itemNo;
        try {
            vetoableChangeSupport.fireVetoableChange("itemNo", new Short(oldItemNo), new Short(itemNo));
        } catch (Exception e) {
            throw new ProfileException(null, e);
        }            
        this.itemNo = itemNo;
        propertyChangeSupport.firePropertyChange("itemNo", new Short(oldItemNo), new Short(itemNo));
    }    
    
    /** Indexed getter for property components (index starts at 1 following HL7 convention).
     * @param index Index of the property (starts at 1 following HL7 convention).
     * @return Value of the property at <CODE>index</CODE>.
     */
    public Component getComponent(int index) {
        return this.components.get(index - 1);
    }
    
    /** Indexed setter for property components (index starts at 1 following HL7 convention).
     * @param index Index of the property (starts at 1 following HL7 convention).
     * @param component New value of the property at <CODE>index</CODE>.
     *
     * @throws ProfileException
     */
    public void setComponent(int index, Component component) throws ProfileException {
        index--;
        while (components.size() <= index) {
        	components.add(null);
        }
        Component oldComponent = this.components.get(index);
        this.components.set(index, component);
        try {
            vetoableChangeSupport.fireVetoableChange("components", null, null );
        }
        catch(java.beans.PropertyVetoException vetoException ) {
            this.components.set(index, oldComponent);
            throw new ProfileException(null, vetoException);
        }
        propertyChangeSupport.firePropertyChange("components", null, null );
    }    

    
    /** Returns the number of components */
    public int getComponents() {
		return this.components.size();
    }

    /** Returns the number of components */
    public List<Component> getChildrenAsList() {
        return (this.components);
    }
    
}
    

