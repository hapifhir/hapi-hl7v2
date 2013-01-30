package ca.uhn.hl7v2.conf.spec.message;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.hl7v2.conf.ProfileException;

/**
 * The specification for a particular field component in a message profile.
 * 
 * @author Bryan Tripp
 */
public class Component extends AbstractComponent<Component> {

	private final List<SubComponent> components = new ArrayList<SubComponent>();

	/** Creates a new instance of Component */
	public Component() {
	}

	/**
	 * Indexed getter for property components (index starts at 1 following HL7
	 * convention).
	 * 
	 * @param index
	 *            Index of the property (starts at 1 following HL7 convention).
	 * @return Value of the property at <CODE>index</CODE>.
	 */
	public SubComponent getSubComponent(int index) {
		return this.components.get(index - 1);
	}

	/**
	 * Indexed setter for property components (index starts at 1 following HL7
	 * convention).
	 * 
	 * @param index
	 *            Index of the property (starts at 1 following HL7 convention).
	 * @param component
	 *            New value of the property at <CODE>index</CODE>.
	 * 
	 * @throws ProfileException
	 */
	public void setSubComponent(int index, SubComponent component) throws ProfileException {
		index--;
		while (components.size() <= index) {
			components.add(null);
		}
		SubComponent oldComponent = this.components.get(index);
		this.components.set(index, component);
		try {
			vetoableChangeSupport.fireVetoableChange("components", null, null);
		} catch (java.beans.PropertyVetoException vetoException) {
			this.components.set(index, oldComponent);
			throw new ProfileException(null, vetoException);
		}
		propertyChangeSupport.firePropertyChange("components", null, null);
	}


	/** Returns the number of subcomponents in this component */
	public int getSubComponents() {
		return this.components.size();
	}

	public List<SubComponent> getChildrenAsList() {
		return (this.components);
	}

	@Override
	public String toString() {
		return "Component[" + getName() + "]";
	}

}
