package ca.uhn.hl7v2.hoh.server.raw;

import java.io.IOException;
import java.util.Enumeration;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.uhn.hl7v2.hoh.AuthorizationFailureException;
import ca.uhn.hl7v2.hoh.DecodeException;
import ca.uhn.hl7v2.hoh.Hl7OverHttpRequestDecoder;
import ca.uhn.hl7v2.hoh.auth.IAuthorizationServerCallback;
import ca.uhn.hl7v2.hoh.server.MessageMetadataKeys;
import ca.uhn.hl7v2.hoh.server.MessageProcessingException;
import ca.uhn.hl7v2.hoh.util.HTTPUtils;

public class Hl7OverHttpRawMessageServlet extends HttpServlet {

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(Hl7OverHttpRawMessageServlet.class);
	private static final long serialVersionUID = 1L;
	private IAuthorizationServerCallback myAuthorizationCallback;
	private IRawMessageHandler myMessageHandler;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest theReq, HttpServletResponse theResp) throws ServletException, IOException {
		
		theResp.setStatus(400);
		theResp.setContentType("text/html");
		
		String message = "GET method is not supported by this server";
		HTTPUtils.write400BadRequest(theResp.getOutputStream(), message, false);
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doPost(HttpServletRequest theReq, HttpServletResponse theResp) throws ServletException, IOException {
		
		Hl7OverHttpRequestDecoder decoder = new Hl7OverHttpRequestDecoder();
		decoder.setHeaders(new LinkedHashMap<String, String>());
		
		Enumeration<?> headerNames = theReq.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String nextName = (String) headerNames.nextElement();
			decoder.getHeaders().put(nextName, theReq.getHeader(nextName));
		}
		
		decoder.setUri(theReq.getRequestURI());
		decoder.setAuthorizationCallback(myAuthorizationCallback);
		try {
			decoder.readContentsFromInputStreamAndDecode(theReq.getInputStream());
		} catch (AuthorizationFailureException e) {
			ourLog.error("Authorization failed on request for {}", theReq.getRequestURI());
			theResp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			HTTPUtils.write401Unauthorized(theResp.getOutputStream(), false);
			return;
		} catch (DecodeException e) {
			ourLog.error("Request failure for " + theReq.getRequestURI(), e.getMessage(), e);
			theResp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			HTTPUtils.write400BadRequest(theResp.getOutputStream(), e.getMessage(), false);
			return;
		}
		
		StringRawMessage rawMessage = new StringRawMessage(decoder.getMessage());
		rawMessage.addMetadata(MessageMetadataKeys.REMOTE_HOST_ADDRESS.name(), theReq.getRemoteAddr());

		IRawMessageResponse response;
		try {
			response = myMessageHandler.messageReceived(rawMessage);
		} catch (MessageProcessingException e) {
			ourLog.error("Processing problem for " + theReq.getRequestURI(), e.getMessage(), e);
			theResp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			HTTPUtils.write500InternalServerError(theResp.getOutputStream(), e.getMessage(), false);
			return;
		}
		
		theResp.setContentType(response.getEncodingStyle().getContentType());
		theResp.setStatus(response.getResponseCode().getCode());
		
		response.writeMessage(theResp.getWriter());
		theResp.flushBuffer();
		
	}

	/**
	 * If set, provides a callback which will be used to validate incoming credentials
	 */
	public void setAuthorizationCallback(IAuthorizationServerCallback theAuthorizationCallback) {
		myAuthorizationCallback = theAuthorizationCallback;
	}

	/**
	 * @param theMessageHandler the messageHandler to set
	 */
	public void setMessageHandler(IRawMessageHandler theMessageHandler) {
		myMessageHandler = theMessageHandler;
	}

	
	
}
