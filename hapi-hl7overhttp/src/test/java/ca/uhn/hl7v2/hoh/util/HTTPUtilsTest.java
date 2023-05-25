package ca.uhn.hl7v2.hoh.util;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import ca.uhn.hl7v2.hoh.util.repackage.Base64;
import org.junit.Test;
import org.junit.Before;

public class HTTPUtilsTest {
    OutputStream outputStream;

    @Before
    public void initializeOutputStream(){
        outputStream = new ByteArrayOutputStream();
    }

    @Test
    public void testWrite400BadRequest() throws IOException {
        HTTPUtils.write400BadRequest(outputStream, "Invalid Content-Type: text/plain", true);
        String actual = outputStream.toString();
        String expected = "HTTP/1.1 400 Bad Request\r\nContent-Type: text/html; charset=ISO-8859-1\r\n\r\n<html><head><title>400 - Bad Request</title></head><body><img src=\"data:image/png;base64," +
                Base64.encodeBase64String(IOUtils.readClasspathIntoByteArray("/ca/uhn/hl7v2/hoh/hapi_hoh_banner.png")) +
                "\"/><h1>HTTP 400 - Bad Request</h1><p>Invalid Content-Type: text/plain</p><p style=\"font-size: 0.7em; color: #606060;\">HAPI (HL7 over HTTP) version 2.4-SNAPSHOT</p></body></html>";
        assertEquals(expected, actual);
    }

    @Test
    public void testWrite400SignatureVerificationFailed() throws IOException {
        HTTPUtils.write400SignatureVerificationFailed(outputStream,  true);
        String actual = outputStream.toString();
        String expected = "HTTP/1.1 400 Bad Request\r\nContent-Type: text/html; charset=ISO-8859-1\r\n\r\n<html><head><title>400 - Bad Request</title></head><body><img src=\"data:image/png;base64," +
                Base64.encodeBase64String(IOUtils.readClasspathIntoByteArray("/ca/uhn/hl7v2/hoh/hapi_hoh_banner.png")) +
                "\"/><h1>HTTP 400 - Bad Request</h1><p>Failed to verify message signature</p><p style=\"font-size: 0.7em; color: #606060;\">HAPI (HL7 over HTTP) version 2.4-SNAPSHOT</p></body></html>";
        assertEquals(expected, actual);
    }
}
