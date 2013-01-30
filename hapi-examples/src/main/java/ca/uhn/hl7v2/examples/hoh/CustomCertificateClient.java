package ca.uhn.hl7v2.examples.hoh;

import java.io.IOException;

import ca.uhn.hl7v2.hoh.api.DecodeException;
import ca.uhn.hl7v2.hoh.api.EncodeException;
import ca.uhn.hl7v2.hoh.api.IReceivable;
import ca.uhn.hl7v2.hoh.api.ISendable;
import ca.uhn.hl7v2.hoh.raw.client.HohRawClientSimple;
import ca.uhn.hl7v2.hoh.sockets.CustomCertificateTlsSocketFactory;

public class CustomCertificateClient {

	/**
	 * @param args
	 * @throws EncodeException 
	 * @throws IOException 
	 * @throws DecodeException 
	 */
	@SuppressWarnings("unused")
   public static void main(String[] args) throws DecodeException, IOException, EncodeException {
		ISendable<?> sendable = null;

// START SNIPPET: client 
// Create a client
HohRawClientSimple client = new HohRawClientSimple("remotehost", 443, "/");

// Assign a socketfactory which references the truststore
CustomCertificateTlsSocketFactory clientSocketFactory = new CustomCertificateTlsSocketFactory();
clientSocketFactory.setKeystoreFilename("/path/to/truststore/truststore.jks");
clientSocketFactory.setKeystorePassphrase("trustpassword");
client.setSocketFactory(clientSocketFactory);

// Send a message
IReceivable<String> response = client.sendAndReceive(sendable);
// END SNIPPET: client 



	}

}
