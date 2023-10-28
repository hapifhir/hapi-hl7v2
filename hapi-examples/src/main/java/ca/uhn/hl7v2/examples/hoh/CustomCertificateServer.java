package ca.uhn.hl7v2.examples.hoh;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.app.HL7Service;
import ca.uhn.hl7v2.hoh.llp.Hl7OverHttpLowerLayerProtocol;
import ca.uhn.hl7v2.hoh.sockets.CustomCertificateTlsSocketFactory;
import ca.uhn.hl7v2.hoh.util.HapiSocketTlsFactoryWrapper;
import ca.uhn.hl7v2.hoh.util.ServerRoleEnum;
import ca.uhn.hl7v2.llp.LowerLayerProtocol;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.SecureRequestCustomizer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.SslConnectionFactory;
import org.eclipse.jetty.util.ssl.SslContextFactory;

public class CustomCertificateServer {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

//START SNIPPET: llp 
// Create a socketfactory which references the keystore
CustomCertificateTlsSocketFactory serverSocketFactory = new CustomCertificateTlsSocketFactory();
serverSocketFactory.setKeystoreFilename("/path/to/keystore/keystore.jks");
serverSocketFactory.setKeystorePassphrase("changeit");

// Create a new HAPI context
HapiContext ctx = new DefaultHapiContext();

// The socket factory needs to be wrapped for use in HAPI
HapiSocketTlsFactoryWrapper hapiSocketFactory = new HapiSocketTlsFactoryWrapper(serverSocketFactory);
ctx.setSocketFactory(hapiSocketFactory);

// Create an HoH LLP instance
LowerLayerProtocol llp = new Hl7OverHttpLowerLayerProtocol(ServerRoleEnum.SERVER);

// Start a server listening on port 443 with a pipe parseer
ctx.setLowerLayerProtocol(llp);

HL7Service server = ctx.newServer(443, true);

// ...Register applications...

server.start();
//END SNIPPET: llp 

// START SNIPPET: server 
// Create a Jetty Server
Server s = new Server();

HttpConfiguration https = new HttpConfiguration();
https.addCustomizer(new SecureRequestCustomizer());

SslContextFactory.Server ssl = new SslContextFactory.Server();
ssl.setKeyStorePath("src/test/resources/keystore.jks");
ssl.setKeyStorePassword("changeit");
ssl.setKeyManagerPassword("changeit");

ServerConnector sslConnector = new ServerConnector(s,
		new SslConnectionFactory(ssl, "http/1.1"),
		new HttpConnectionFactory(https));
sslConnector.setPort(443);
sslConnector.setIdleTimeout(50000);

s.setConnectors(new Connector[]{ sslConnector });

s.start();
// END SNIPPET: server 
	}

}
