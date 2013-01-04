package ca.uhn.hl7v2.examples;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.app.Connection;
import ca.uhn.hl7v2.app.HL7Service;
import ca.uhn.hl7v2.hoh.sockets.CustomCertificateTlsSocketFactory;
import ca.uhn.hl7v2.hoh.util.HapiSocketTlsFactoryWrapper;

public class UsingTls {

	/**
	 * Example for how to use TLS/SSL
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) throws HL7Exception {
		// http://example.com/ewre

		/*
		 * http://example.com/ewre
		 */
		/**
		 * http://example.com/ewre
		 */

		/*
		 * To create a client or a server which uses TLS/SSL, you simply pass
		 * "true" to the factory methods in question on the context.
		 */
		HapiContext ctx = new DefaultHapiContext();

		boolean useTls = true;
		int port = 8888;
		HL7Service server = ctx.newServer(port, useTls); // server
		Connection client = ctx.newClient("localhost", port, useTls); // client

		/*
		 * Note that in most cases you will need to import certificates in order
		 * to make this work.
		 * 
		 * (TODO: this could use more information)
		 */

		/*
		 * Another option is to use a custom certificate socket factory, which
		 * allows you to use different keystores for different connections. This
		 * is a more flexible option if you are running multiple applications on
		 * one JVM.
		 * 
		 * Note that CustomCertificateTlsSocketFactory comes from the
		 * HL7-over-HTTP library, so that library must be added to your
		 * classpath in order for this class to be visible. See here:
		 * http://hl7api.sourceforge.net/getting_started.html
		 */
		CustomCertificateTlsSocketFactory sfac = new CustomCertificateTlsSocketFactory();
		sfac.setKeystoreFilename("file://C:/keystores/client.jks");
		sfac.setKeystorePassphrase("keystorepass");

		// Use the following adapter to pass the socket factory to the context
		ctx.setSocketFactory(new HapiSocketTlsFactoryWrapper(sfac));

		// Your client will now use the socket factory
		client = ctx.newClient("localhost", port, useTls);
	}

}
