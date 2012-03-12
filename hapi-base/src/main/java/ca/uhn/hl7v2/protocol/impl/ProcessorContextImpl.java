/*
 * Created on 19-Apr-2004
 */
package ca.uhn.hl7v2.protocol.impl;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.hl7v2.protocol.AcceptValidator;
import ca.uhn.hl7v2.protocol.ApplicationRouter;
import ca.uhn.hl7v2.protocol.ProcessorContext;
import ca.uhn.hl7v2.protocol.SafeStorage;
import ca.uhn.hl7v2.protocol.TransportLayer;

/**
 * Default implementation of <code>ProcessorContext</code>. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:26 $ by $Author: jamesagnew $
 */
public class ProcessorContextImpl implements ProcessorContext {

    private final ApplicationRouter myRouter;
    private final TransportLayer myLocallyDrivenTransport;
    private final TransportLayer myRemotelyDrivenTransport;
    private final SafeStorage mySafeStorage;
    private final List<AcceptValidator> myValidators;
    private final List<String> myMetadataFields;

    /**
     * Creates a new instance that uses the given resources.  
     * 
     * @param theRouter 
     * @param theTransport a <code>TransportLayer</code> used for both locally-initiated
     *      and remotely-initiated message exchanges 
     * @param theStorage
     */    
    public ProcessorContextImpl(
            ApplicationRouter theRouter,
            TransportLayer theTransport, 
            SafeStorage theStorage) {
                
        myRouter = theRouter;
        myRemotelyDrivenTransport = theTransport;
        myLocallyDrivenTransport = theTransport;
        mySafeStorage = theStorage;
        
        myValidators = new ArrayList<AcceptValidator>(8);
        myMetadataFields = new ArrayList<String>(30);
    }

    /**
     * Creates a new instance that uses the given resources.  
     * 
     * @param theRouter 
     * @param theLocallyDrivenTransport a <code>TransportLayer</code> used for locally-initiated
     *      and message exchanges 
     * @param theRemotelyDrivenTransport a <code>TransportLayer</code> used for remotely-initiated
     *      and message exchanges 
     * @param theStorage
     */    
    public ProcessorContextImpl(
            ApplicationRouter theRouter,
            TransportLayer theLocallyDrivenTransport,
            TransportLayer theRemotelyDrivenTransport,  
            SafeStorage theStorage) {
                
        myRouter = theRouter;
        myRemotelyDrivenTransport = theRemotelyDrivenTransport;
        myLocallyDrivenTransport = theLocallyDrivenTransport;
        mySafeStorage = theStorage;
        
        myValidators = new ArrayList<AcceptValidator>(8);
        myMetadataFields = new ArrayList<String>(30);
    }

    /**
     * @see ca.uhn.hl7v2.protocol.ProcessorContext#getRouter()
     */
    public ApplicationRouter getRouter() {
        return myRouter;
    }

    /**
     * @see ca.uhn.hl7v2.protocol.ProcessorContext#getRemotelyDrivenTransportLayer()
     */
    public TransportLayer getRemotelyDrivenTransportLayer() {
        return myRemotelyDrivenTransport;
    }

    /**
     * @see ca.uhn.hl7v2.protocol.ProcessorContext#getLocallyDrivenTransportLayer()
     */
    public TransportLayer getLocallyDrivenTransportLayer() {
        return myLocallyDrivenTransport;
    }

    /**
     * @see ca.uhn.hl7v2.protocol.ProcessorContext#getValidators()
     */
    public AcceptValidator[] getValidators() {
        return myValidators.toArray(new AcceptValidator[0]);
    }
    
    /**
     * Adds a new validator to the list of those returned by 
     * <code>getValidators()</code>.  
     *  
     * @param theValidator the validator to add 
     */
    public void addValidator(AcceptValidator theValidator) {
        myValidators.add(theValidator);
    }

    /**
     * @see ca.uhn.hl7v2.protocol.ProcessorContext#getSafeStorage()
     */
    public SafeStorage getSafeStorage() {
        return mySafeStorage;
    }

    /** 
     * @see ca.uhn.hl7v2.protocol.ProcessorContext#getMetadataFields()
     */
    public List<String> getMetadataFields() {
        return myMetadataFields;
    }

}
