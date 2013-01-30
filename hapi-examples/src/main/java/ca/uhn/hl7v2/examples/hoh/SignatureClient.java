package ca.uhn.hl7v2.examples.hoh;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.Connection;
import ca.uhn.hl7v2.hoh.api.DecodeException;
import ca.uhn.hl7v2.hoh.api.EncodeException;
import ca.uhn.hl7v2.hoh.api.IReceivable;
import ca.uhn.hl7v2.hoh.api.ISendable;
import ca.uhn.hl7v2.hoh.llp.Hl7OverHttpLowerLayerProtocol;
import ca.uhn.hl7v2.hoh.raw.client.HohRawClientSimple;
import ca.uhn.hl7v2.hoh.sign.BouncyCastleCmsMessageSigner;
import ca.uhn.hl7v2.hoh.util.KeystoreUtils;
import ca.uhn.hl7v2.hoh.util.ServerRoleEnum;

public class SignatureClient {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws CertificateException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyStoreException 
	 * @throws EncodeException 
	 * @throws DecodeException 
	 * @throws HL7Exception 
	 */
	@SuppressWarnings("unused")
   public static void main(String[] args) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException, DecodeException, EncodeException, HL7Exception {

		ISendable<?> sendable=null;
		{
// START SNIPPET: client 
// Create a client
HohRawClientSimple client = new HohRawClientSimple("remotehost", 8080, "/");

// Create a message signer
BouncyCastleCmsMessageSigner signer = new BouncyCastleCmsMessageSigner();
signer.setKeyStore(KeystoreUtils.loadKeystore("/path/to/keystore/keystore.jks", "store_password"));
signer.setKeyAlias("keyalias");
signer.setAliasPassword("key_password");

client.setSigner(signer);

// Send a message
IReceivable<String> response = client.sendAndReceive(sendable);
// END SNIPPET: client 
	}

// START SNIPPET: llp
Hl7OverHttpLowerLayerProtocol llp;
llp = new Hl7OverHttpLowerLayerProtocol(ServerRoleEnum.CLIENT);

//Create a message signer
BouncyCastleCmsMessageSigner signer = new BouncyCastleCmsMessageSigner();
signer.setKeyStore(KeystoreUtils.loadKeystore("/path/to/keystore/keystore.jks", "store_password"));
signer.setKeyAlias("keyalias");
signer.setAliasPassword("key_password");
llp.setSigner(signer);

// Create the ConnectionHub
String host = "localhost";
int port = 8080;
boolean tls = false;

DefaultHapiContext ctx = new DefaultHapiContext();
ctx.setLowerLayerProtocol(llp);

// Connect
Connection connection = ctx.newClient(host, port, tls);
//END SNIPPET: llp


	}

}
