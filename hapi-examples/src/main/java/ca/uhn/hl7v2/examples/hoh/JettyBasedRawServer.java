package ca.uhn.hl7v2.examples.hoh;

import jakarta.servlet.Servlet;
import org.eclipse.jetty.ee10.servlet.ServletContextHandler;
import org.eclipse.jetty.ee10.servlet.ServletHolder;
import org.eclipse.jetty.server.Server;

public class JettyBasedRawServer {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

// START SNIPPET: server 
// The port to listen on
int port = 8080;

// Create a Jetty server instance
Server server = new Server(port);
ServletContextHandler context = new ServletContextHandler("/Hl7Listener");
Servlet servlet = new ExampleRawHl7OverHttpServlet();

/* 
 * Adds the servlet to listen at 
 * http://localhost:8080/Hl7Listener/Incoming
 */
context.addServlet(new ServletHolder(servlet), "/Incoming");

// Start the server
server.start();

// .. let the application run ..

/*
 * Later it will probably be appropriate to shut the server
 * down.
 */
server.stop();
// END SNIPPET: server 

	}

}
