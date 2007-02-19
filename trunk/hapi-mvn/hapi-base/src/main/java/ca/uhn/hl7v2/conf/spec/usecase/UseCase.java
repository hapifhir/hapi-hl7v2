package ca.uhn.hl7v2.conf.spec.usecase;

/**
 * The use case portion of a conformance specification.  
 * @author Bryan Tripp
 */
public class UseCase {
    
    /** Holds value of property actor. */
    private Actor actor;
    
    /** Utility field used by bound properties. */
    private java.beans.PropertyChangeSupport propertyChangeSupport =  new java.beans.PropertyChangeSupport(this);
    
    /** Utility field used by constrained properties. */
    private java.beans.VetoableChangeSupport vetoableChangeSupport =  new java.beans.VetoableChangeSupport(this);
    
    /** Holds value of property preCondition. */
    private PreCondition preCondition;
    
    /** Holds value of property postCondition. */
    private PostCondition postCondition;
    
    /** Holds value of property eventFlow. */
    private EventFlow eventFlow;
    
    /** Holds value of property derivativeEvent. */
    private DerivativeEvent derivativeEvent;
    
    /** Creates a new instance of UseCase */
    public UseCase() {
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
    
    /** Getter for property actor.
     * @return Value of property actor.
     */
    public Actor getActor() {
        return this.actor;
    }
    
    /** Setter for property actor.
     * @param actor New value of property actor.
     *
     * @throws PropertyVetoException
     */
    public void setActor(Actor actor) throws java.beans.PropertyVetoException {
        Actor oldActor = this.actor;
        vetoableChangeSupport.fireVetoableChange("actor", oldActor, actor);
        this.actor = actor;
        propertyChangeSupport.firePropertyChange("actor", oldActor, actor);
    }
    
    /** Getter for property preCondition.
     * @return Value of property preCondition.
     */
    public PreCondition getPreCondition() {
        return this.preCondition;
    }
    
    /** Setter for property preCondition.
     * @param preCondition New value of property preCondition.
     *
     * @throws PropertyVetoException
     */
    public void setPreCondition(PreCondition preCondition) throws java.beans.PropertyVetoException {
        PreCondition oldPreCondition = this.preCondition;
        vetoableChangeSupport.fireVetoableChange("preCondition", oldPreCondition, preCondition);
        this.preCondition = preCondition;
        propertyChangeSupport.firePropertyChange("preCondition", oldPreCondition, preCondition);
    }
    
    /** Getter for property postCondition.
     * @return Value of property postCondition.
     */
    public PostCondition getPostCondition() {
        return this.postCondition;
    }
    
    /** Setter for property postCondition.
     * @param postCondition New value of property postCondition.
     *
     * @throws PropertyVetoException
     */
    public void setPostCondition(PostCondition postCondition) throws java.beans.PropertyVetoException {
        PostCondition oldPostCondition = this.postCondition;
        vetoableChangeSupport.fireVetoableChange("postCondition", oldPostCondition, postCondition);
        this.postCondition = postCondition;
        propertyChangeSupport.firePropertyChange("postCondition", oldPostCondition, postCondition);
    }
    
    /** Getter for property eventFlow.
     * @return Value of property eventFlow.
     */
    public EventFlow getEventFlow() {
        return this.eventFlow;
    }
    
    /** Setter for property eventFlow.
     * @param eventFlow New value of property eventFlow.
     *
     * @throws PropertyVetoException
     */
    public void setEventFlow(EventFlow eventFlow) throws java.beans.PropertyVetoException {
        EventFlow oldEventFlow = this.eventFlow;
        vetoableChangeSupport.fireVetoableChange("eventFlow", oldEventFlow, eventFlow);
        this.eventFlow = eventFlow;
        propertyChangeSupport.firePropertyChange("eventFlow", oldEventFlow, eventFlow);
    }
    
    /** Getter for property derivativeEvent.
     * @return Value of property derivativeEvent.
     */
    public DerivativeEvent getDerivativeEvent() {
        return this.derivativeEvent;
    }
    
    /** Setter for property derivativeEvent.
     * @param derivativeEvent New value of property derivativeEvent.
     *
     * @throws PropertyVetoException
     */
    public void setDerivativeEvent(DerivativeEvent derivativeEvent) throws java.beans.PropertyVetoException {
        DerivativeEvent oldDerivativeEvent = this.derivativeEvent;
        vetoableChangeSupport.fireVetoableChange("derivativeEvent", oldDerivativeEvent, derivativeEvent);
        this.derivativeEvent = derivativeEvent;
        propertyChangeSupport.firePropertyChange("derivativeEvent", oldDerivativeEvent, derivativeEvent);
    }
    
}
