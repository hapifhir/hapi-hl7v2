package ca.uhn.hl7v2.examples.hoh;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import ca.uhn.hl7v2.hoh.hapi.server.HohServlet;
import ca.uhn.hl7v2.hoh.sign.BouncyCastleCmsMessageSigner;
import ca.uhn.hl7v2.hoh.util.KeystoreUtils;

//START SNIPPET: servlet 
public class SignatureServlet extends HohServlet {

	@Override
	public void init(ServletConfig theConfig) throws ServletException {
		
		//Create a message signer and pass it to the servlet
		BouncyCastleCmsMessageSigner signer = new BouncyCastleCmsMessageSigner();
		try {
			signer.setKeyStore(KeystoreUtils.loadKeystore("/path/to/keystore/keystore.jks", "store_password"));
		} catch (Exception e) {
			throw new ServletException(e);
		}
		signer.setKeyAlias("keyalias");
		signer.setAliasPassword("key_password");
		setSigner(signer);
	
		// ... also provide a message handler ...
		
	}

}
//END SNIPPET: servlet 
