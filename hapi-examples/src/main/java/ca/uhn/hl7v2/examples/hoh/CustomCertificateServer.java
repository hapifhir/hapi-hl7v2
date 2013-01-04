package ca.uhn.hl7v2.examples.hoh;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.security.SslSelectChannelConnector;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.app.HL7Service;
import ca.uhn.hl7v2.hoh.llp.Hl7OverHttpLowerLayerProtocol;
import ca.uhn.hl7v2.hoh.sockets.CustomCertificateTlsSocketFactory;
import ca.uhn.hl7v2.hoh.util.HapiSocketTlsFactoryWrapper;
import ca.uhn.hl7v2.hoh.util.ServerRoleEnum;
import ca.uhn.hl7v2.llp.LowerLayerProtocol;

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

SslSelectChannelConnector ssl = new SslSelectChannelConnector();
ssl.setKeystore("src/test/resources/keystore.jks");
ssl.setPassword("changeit");
ssl.setKeyPassword("changeit");
ssl.setPort(443);

s.addConnector(ssl);
s.start();
// END SNIPPET: server 
	}

}
