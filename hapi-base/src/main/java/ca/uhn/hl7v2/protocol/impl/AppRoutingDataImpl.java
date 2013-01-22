/*
 * Created on 21-Apr-2004
 */
package ca.uhn.hl7v2.protocol.impl;

import ca.uhn.hl7v2.protocol.ApplicationRouter;
import ca.uhn.hl7v2.protocol.ApplicationRouter.AppRoutingData;

/**
 * A default implementation of <code>ApplicationRouter.AppRoutingData</code>. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:26 $ by $Author: jamesagnew $
 */
public class AppRoutingDataImpl implements ApplicationRouter.AppRoutingData {

    private final String myMessageType;
    private final String myTriggerEvent;
    private final String myProcessingId;
    private final String myVersionId;
     
    /**
     * Creates a new instance with args used as values that will be returned 
     * by the corresponding getters.
     */
    public AppRoutingDataImpl(String theMessageType, String theTriggerEvent, 
                String theProcessingId, String theVersionId) {
        myMessageType = theMessageType;
        myTriggerEvent = theTriggerEvent;
        myProcessingId = theProcessingId;
        myVersionId = theVersionId;
    }

    /**
     * @see ca.uhn.hl7v2.protocol.ApplicationRouter.AppRoutingData#getMessageType()
     */
    public String getMessageType() {
        return myMessageType;
    }

    /**
     * @see ca.uhn.hl7v2.protocol.ApplicationRouter.AppRoutingData#getTriggerEvent()
     */
    public String getTriggerEvent() {
        return myTriggerEvent;
    }

    /** 
     * @see ca.uhn.hl7v2.protocol.ApplicationRouter.AppRoutingData#getProcessingId()
     */
    public String getProcessingId() {
        return myProcessingId;
    }

    /** 
     * @see ca.uhn.hl7v2.protocol.ApplicationRouter.AppRoutingData#getVersion()
     */
    public String getVersion() {
        return myVersionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppRoutingDataImpl)) return false;

        AppRoutingDataImpl that = (AppRoutingDataImpl) o;

        if (myMessageType != null ? !myMessageType.equals(that.myMessageType) : that.myMessageType != null)
            return false;
        if (myProcessingId != null ? !myProcessingId.equals(that.myProcessingId) : that.myProcessingId != null)
            return false;
        if (myTriggerEvent != null ? !myTriggerEvent.equals(that.myTriggerEvent) : that.myTriggerEvent != null)
            return false;
        if (myVersionId != null ? !myVersionId.equals(that.myVersionId) : that.myVersionId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = myMessageType != null ? myMessageType.hashCode() : 0;
        result = 31 * result + (myTriggerEvent != null ? myTriggerEvent.hashCode() : 0);
        result = 31 * result + (myProcessingId != null ? myProcessingId.hashCode() : 0);
        result = 31 * result + (myVersionId != null ? myVersionId.hashCode() : 0);
        return result;
    }

    /**
     * Returns an instance of AppRoutingData which accepts all
     * message types, versions, etc.
     */
	public static AppRoutingData withAll() {
		return new AppRoutingDataImpl("*","*", "*", "*");
	}

}
