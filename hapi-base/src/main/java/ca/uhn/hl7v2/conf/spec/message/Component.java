package ca.uhn.hl7v2.conf.spec.message;

import ca.uhn.hl7v2.conf.ProfileException;

/**
 * The specification for a particular field component in a message profile.  
 * @author Bryan Tripp
 */
public class Component extends AbstractComponent {

    private SubComponent[] components;

    /** Creates a new instance of Component */
    public Component() {
        components = new SubComponent[0];
    }
    
    /** Indexed getter for property components (index starts at 1 following HL7 convention).
     * @param index Index of the property (starts at 1 following HL7 convention).
     * @return Value of the property at <CODE>index</CODE>.
     */
    public SubComponent getSubComponent(int index) {
        return this.components[index - 1];
    }
    
    /** Indexed setter for property components (index starts at 1 following HL7 convention).
     * @param index Index of the property (starts at 1 following HL7 convention).
     * @param component New value of the property at <CODE>index</CODE>.
     *
     * @throws ProfileException
     */
    public void setSubComponent(int index, SubComponent component) throws ProfileException {
        index--;
        extendChildList(index);
        SubComponent oldComponent = this.components[index];
        this.components[index] = component;
        try {
            vetoableChangeSupport.fireVetoableChange("components", null, null );
        }
        catch(java.beans.PropertyVetoException vetoException ) {
            this.components[index] = oldComponent;
            throw new ProfileException(null, vetoException);
        }
        propertyChangeSupport.firePropertyChange("components", null, null );
    }    

    /** Makes child list long enough to accommodate setter.  */
    private void extendChildList(int index) {
        if (index >= this.components.length) {
            SubComponent[] newCopy = new SubComponent[index + 1];
            System.arraycopy(this.components, 0, newCopy, 0, this.components.length);
            this.components = newCopy;
        }        
    }        

    /** Returns the number of subcomponents in this component */
    public int getSubComponents() {
        return this.components.length;
    }
    
}
