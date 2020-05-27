package ca.uhn.hl7v2.hoh.relay;

import java.io.FileNotFoundException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import ca.uhn.hl7v2.hoh.util.IOUtils;
import ca.uhn.hl7v2.hoh.util.VersionLogger;

public class Launcher {
	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(Launcher.class);

	private FileSystemXmlApplicationContext myAppContext;

	public Launcher() {
		this("conf" + IOUtils.FILE_PATH_SEP + "config.xml");
	}

	public Launcher(String configFile) {
		long start = System.currentTimeMillis();

        String b = "HAPI HL7 over HTTP Relay is starting. This software is Licensed under the " +
                "Apache Software License (version 2.0) and is Copyright(c) " +
                "2012 University Health Network.";
        ourLog.info(b);

		VersionLogger.init();

		Runtime.getRuntime().addShutdownHook(new ShutdownHook());

		myAppContext = new FileSystemXmlApplicationContext(configFile);
		myAppContext.start();

		long delay = System.currentTimeMillis() - start;
		ourLog.info("HAPI HL7 over HTTP Relay started in {} ms", delay);
	}

	public ApplicationContext getAppCtx() {
		return myAppContext;
	}

	public void shutdown() {
		ourLog.info("Shutdown request detected, stopping all services");
		if (myAppContext != null) {
			myAppContext.close();
			myAppContext = null;
		}
		ourLog.info("Shutdown request completed");
	}

	public static void main(String[] args) throws FileNotFoundException {

		// System.setProperty("relay.port.in",
		// RandomServerPortProvider.findFreePort() + "");
		// System.setProperty("relay.port.out",
		// RandomServerPortProvider.findFreePort() + "");
		new Launcher();
	}

	private final class ShutdownHook extends Thread {
		@Override
		public void run() {
			shutdown();
		}
	}

}
