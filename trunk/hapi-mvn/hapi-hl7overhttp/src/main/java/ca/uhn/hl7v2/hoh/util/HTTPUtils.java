package ca.uhn.hl7v2.hoh.util;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

import javax.servlet.ServletOutputStream;

import ca.uhn.hl7v2.hoh.util.repackage.Base64;


public class HTTPUtils {

	/** ISO-8859-1 */
	public static final Charset DEFAULT_CHARSET;

	static {
		DEFAULT_CHARSET = Charset.forName("ISO-8859-1");
	}

	/**
	 * Non instantiable
	 */
	private HTTPUtils() {
		super();
	}

	public static void write400BadRequest(OutputStream theOutputStream, String theMessage) throws IOException {
		write400BadRequest(theOutputStream, theMessage, true);
	}

	public static void write400BadRequest(OutputStream theOutputStream, String theMessage, boolean theWriteHeaders) throws IOException {
		StringBuilder b = new StringBuilder();
		if (theWriteHeaders) {
			b.append("HTTP/1.1 401 Unauthorized\r\n");
			b.append("Content-Type: text/html; charset=ISO-8859-1\r\n");
			b.append("\r\n");
		}
		b.append("<html><head><title>400 - Bad Request</title></head>");
		b.append("<body>");
		b.append("<img src=\"data:image/png;base64,");
		b.append(Base64.encodeBase64String(IOUtils.readClasspathIntoByteArray("/ca/uhn/hl7v2/hoh/hapi_hoh_banner.png")));
		b.append("\"/>");
		b.append("<h1>HTTP 400 - Bad Request</h1>");
		b.append("<p>");
		b.append(theMessage);
		b.append("</p>");
		b.append("<p style=\"font-size: 0.7em; color: #606060;\">HAPI (HL7 over HTTP) version ");
		b.append(VersionLogger.getVersion());
		b.append("</p>");
		b.append("</body>");
		b.append("</html>");

		theOutputStream.write(b.toString().getBytes(DEFAULT_CHARSET));
		theOutputStream.flush();
	}

	public static void write400SignatureVerificationFailed(OutputStream theOutputStream, boolean theWriteHeaders) throws IOException {
		StringBuilder b = new StringBuilder();
		if (theWriteHeaders) {
			b.append("HTTP/1.1 401 Unauthorized\r\n");
			b.append("Content-Type: text/html; charset=ISO-8859-1\r\n");
			b.append("\r\n");
		}
		b.append("<html><head><title>400 - Bad Request</title></head>");
		b.append("<body>");
		b.append("<img src=\"data:image/png;base64,");
		b.append(Base64.encodeBase64String(IOUtils.readClasspathIntoByteArray("/ca/uhn/hl7v2/hoh/hapi_hoh_banner.png")));
		b.append("\"/>");
		b.append("<h1>HTTP 400 - Bad Request</h1>");
		b.append("<p>");
		b.append("Failed to verify message signature");
		b.append("</p>");
		b.append("<p style=\"font-size: 0.7em; color: #606060;\">HAPI (HL7 over HTTP) version ");
		b.append(VersionLogger.getVersion());
		b.append("</p>");
		b.append("</body>");
		b.append("</html>");

		theOutputStream.write(b.toString().getBytes(DEFAULT_CHARSET));
		theOutputStream.flush();
	}

	public static void write401Unauthorized(OutputStream theOutputStream) throws IOException {
		write401Unauthorized(theOutputStream, true);
	}

	public static void write401Unauthorized(OutputStream theOutputStream, boolean theWriteHeaders) throws IOException {
		StringBuilder b = new StringBuilder();
		if (theWriteHeaders) {
			b.append("HTTP/1.1 401 Unauthorized\r\n");
			b.append("Content-Type: text/html; charset=ISO-8859-1\r\n");
			b.append("\r\n");
		}
		b.append("<html><head><title>401 - Not Authorized</title></head>");
		b.append("<body>");
		b.append("<img src=\"data:image/png;base64,");
		b.append(Base64.encodeBase64String(IOUtils.readClasspathIntoByteArray("/ca/uhn/hl7v2/hoh/hapi_hoh_banner.png")));
		b.append("\"/>");
		b.append("<h1>HTTP 401 - Not Authorized</h1>");
		b.append("<p style=\"font-size: 0.7em; color: #606060;\">HAPI (HL7 over HTTP) version ");
		b.append(VersionLogger.getVersion());
		b.append("</p>");
		b.append("</body>");
		b.append("</html>");

		theOutputStream.write(b.toString().getBytes(DEFAULT_CHARSET));
		theOutputStream.flush();
	}

	public static void write500InternalServerError(ServletOutputStream theOutputStream, String theMessage, boolean theWriteHeaders) throws IOException {
		StringBuilder b = new StringBuilder();
		if (theWriteHeaders) {
			b.append("HTTP/1.1 500 Internal Server Error\r\n");
			b.append("Content-Type: text/html; charset=ISO-8859-1\r\n");
			b.append("\r\n");
		}
		b.append("<html><head><title>HTTP 500 - Internal Server Error</title></head>");
		b.append("<body>");
		b.append("<img src=\"data:image/png;base64,");
		b.append(Base64.encodeBase64String(IOUtils.readClasspathIntoByteArray("/ca/uhn/hl7v2/hoh/hapi_hoh_banner.png")));
		b.append("\"/>");
		b.append("<h1>HTTP 500 - Internal Server Error</h1>");
		b.append("<p>");
		b.append(theMessage);
		b.append("</p>");
		b.append("<p style=\"font-size: 0.7em; color: #606060;\">HAPI (HL7 over HTTP) version ");
		b.append(VersionLogger.getVersion());
		b.append("</p>");
		b.append("</body>");
		b.append("</html>");

		theOutputStream.write(b.toString().getBytes(DEFAULT_CHARSET));
		theOutputStream.flush();
	}

}
