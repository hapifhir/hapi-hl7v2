package ca.uhn.hl7v2.hoh.llp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import ca.uhn.hl7v2.app.TwoPortService;
import ca.uhn.hl7v2.hoh.auth.IAuthorizationClientCallback;
import ca.uhn.hl7v2.hoh.auth.IAuthorizationServerCallback;
import ca.uhn.hl7v2.hoh.util.ServerRoleEnum;
import ca.uhn.hl7v2.llp.HL7Reader;
import ca.uhn.hl7v2.llp.HL7Writer;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.llp.LowerLayerProtocol;

/**
 * <p>
 * LowerLayerProtocol implementation which use the HL7 over HTTP specification
 * as a transport layer.
 * </p>
 * 
 * <p>
 * Note that this implementation has limitations:
 * <ul>
 * <li>It will not work on a duel socket server such as {@link TwoPortService}
 * </ul>
 * </p>
 */
public class Hl7OverHttpLowerLayerProtocol extends LowerLayerProtocol {

	private IAuthorizationClientCallback myAuthorizationClientCallback;
	private IAuthorizationServerCallback myAuthorizationServerCallback;
	private HohLlpReader myNextReader;
	private HohLlpWriter myNextWriter;
	private ServerRoleEnum myRole;
	private String myUriPath = "/";

	public Hl7OverHttpLowerLayerProtocol(ServerRoleEnum theRole) {
		myRole = theRole;

		if (myRole == null) {
			throw new NullPointerException("Role can not be null");
		}
	}

	/**
	 * @return the authorizationClientCallback
	 */
	IAuthorizationClientCallback getAuthorizationClientCallback() {
		return myAuthorizationClientCallback;
	}

	/**
	 * Provide the authorization callback, if any
	 */
	IAuthorizationServerCallback getAuthorizationServerCallback() {
		return myAuthorizationServerCallback;
	}

	@Override
	public HL7Reader getReader(InputStream theArg0) throws LLPException {
		if (myNextReader == null && myNextWriter != null) {
			myNextWriter = null;
			throw new LLPException("Hl7OverHttpLowerLayerProtocol can not be used with a multi socket implementation");
		}
		prepareReadersIfNeeded();
		HohLlpReader retVal = myNextReader;
		try {
			retVal.setInputStream(theArg0);
		} catch (IOException e) {
			throw new LLPException("Failed to set stream: " + e.getMessage(), e);
		}

		myNextReader = null;
		return retVal;
	}

	/**
	 * Returns the server role this protocol implementation is being used for
	 */
	public ServerRoleEnum getRole() {
		return myRole;
	}

	/**
	 * @return The URI to use for this LLP implementation
	 * @see #setUriPath(String)
	 */
	public String getUriPath() {
		return myUriPath;
	}

	@Override
	public HL7Writer getWriter(OutputStream theArg0) throws LLPException {
		if (myNextReader != null && myNextWriter == null) {
			myNextReader = null;
			throw new LLPException("Hl7OverHttpLowerLayerProtocol can not be used with a multi socket implementation");
		}
		prepareReadersIfNeeded();
		HohLlpWriter retVal = myNextWriter;
		try {
			retVal.setOutputStream(theArg0);
		} catch (IOException e) {
			throw new LLPException("Failed to set stream: " + e.getMessage(), e);
		}

		myNextWriter = null;
		return retVal;
	}

	private void prepareReadersIfNeeded() {
		if (myNextReader == null && myNextWriter == null) {
			myNextReader = new HohLlpReader(this);
			myNextWriter = new HohLlpWriter(this);
			myNextReader.setWriter(myNextWriter);
		}
	}

	/**
	 * Provides an authorization callback for authorizing incoming requests. This method
	 * must only be called of this LLP instance is in {@link ServerRoleEnum#SERVER SERVER} mode.
	 */
	public void setAuthorizationCallback(IAuthorizationClientCallback theAuthorizationClientCallback) {
		if (myRole == ServerRoleEnum.SERVER) {
			throw new IllegalStateException("This LLP implementation is in CLIENT mode, so it can not use an authorization callback");
		}
		myAuthorizationClientCallback = theAuthorizationClientCallback;
	}

	/**
	 * Provides an authorization callback for authorizing incoming requests. This method
	 * must only be called of this LLP instance is in {@link ServerRoleEnum#SERVER SERVER} mode.
	 */
	public void setAuthorizationCallback(IAuthorizationServerCallback theAuthorizationCallback) {
		if (myRole == ServerRoleEnum.CLIENT) {
			throw new IllegalStateException("This LLP implementation is in CLIENT mode, so it can not use an authorization callback");
		}
		myAuthorizationServerCallback = theAuthorizationCallback;
	}

	/**
	 * The URI path to use for this protocol. The URI path is the portion of the address (URL) which
	 * is being accessed which designates the location on the host (i.e. the "path"). By 
	 * default this is set to "/" 
	 * 
	 * @param theUriPath the uri to set
	 */
	public void setUriPath(String theUriPath) {
		myUriPath = theUriPath;
	}

}
