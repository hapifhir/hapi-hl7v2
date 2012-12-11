package ca.uhn.hl7v2.hoh.relay.listener;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import ca.uhn.hl7v2.app.SimpleServer;
import ca.uhn.hl7v2.hoh.util.Validate;
import ca.uhn.hl7v2.llp.ExtendedMinLowerLayerProtocol;
import ca.uhn.hl7v2.llp.LowerLayerProtocol;
import ca.uhn.hl7v2.parser.GenericModelClassFactory;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.protocol.ApplicationRouter.AppRoutingData;
import ca.uhn.hl7v2.protocol.ReceivingApplication;

public class RelayMllpListener implements InitializingBean, DisposableBean, IRelayListener, BeanNameAware {

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(RelayMllpListener.class);
	private List<ReceivingApplication> myApplications = new ArrayList<ReceivingApplication>();
	private List<AppRoutingData> myAppRoutingData = new ArrayList<AppRoutingData>();
	private String myBeanName;
	private int myPort;
	private SimpleServer myServer;

	/**
	 * Fired automatically by the container when
	 * the bean is ready to start
	 */
	public void afterPropertiesSet() throws Exception {
		if (myPort <= 0) {
			throw new IllegalStateException("Port not set");
		}
		
		LowerLayerProtocol llp = new ExtendedMinLowerLayerProtocol();
		Parser parser = new PipeParser(new GenericModelClassFactory());
		myServer = new SimpleServer(myPort, llp, parser);

		for (int i = 0; i < myAppRoutingData.size(); i++) {
			myServer.registerApplication(myAppRoutingData.get(i), myApplications.get(i));
		}
		
		ourLog.info("Starting listener on port {}", myPort);
		myServer.startAndWait();
		ourLog.info("Listener on port {} has started, and is ready for processing", myPort);

		if (myServer.getServiceExitedWithException() != null) {
			Throwable ex = myServer.getServiceExitedWithException();
			ourLog.error("Server failed to start", ex);
			if (ex instanceof Exception) {
				throw (Exception) ex;
			} else {
				throw new Error(ex);
			}
		}

	}

	
	/**
	 * Fired automatically by the container when
	 * the bean is shutting down
	 */
	public void destroy() throws Exception {
		ourLog.info("Stopping listener on port {}", myPort);
		myServer.stopAndWait();
		ourLog.info("Listener on port {} has stopped", myPort);
	}

	public String getBeanName() {
		return myBeanName;
	}


	public void registerApplication(AppRoutingData theAppRouting, ReceivingApplication theReceivingApplication) {
		Validate.notNull(theAppRouting, "appRouting");
		Validate.notNull(theReceivingApplication, "receivingApplication");
		
		if (myServer != null) {
			myServer.registerApplication(theAppRouting, theReceivingApplication);
		} else {
			myAppRoutingData.add(theAppRouting);
			myApplications.add(theReceivingApplication);
		}
	}


	public void setBeanName(String theBeanName) {
		myBeanName = theBeanName;
	}

	public void setPort(int thePort) {
		myPort = thePort;
	}


}
