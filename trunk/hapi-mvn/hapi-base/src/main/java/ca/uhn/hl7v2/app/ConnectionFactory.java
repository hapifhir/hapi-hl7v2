/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "Connection.java".  Description: 
"A TCP/IP connection to a remote HL7 server." 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2002.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  �GPL�), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 
 */
package ca.uhn.hl7v2.app;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

/**
 * Static Connection factory that creates client-side {@link Connection}s from
 * {@link ConnectionData} objects.
 */
class ConnectionFactory {

	public static Connection open(ConnectionData connectionData,
			ExecutorService executorService) throws Exception {
		Connection connection;
		if (connectionData.getPort2() == 0) {
			connection = new Connection(connectionData.getParser(),
					connectionData.getProtocol(), createSocket(connectionData.getSocketFactory(),
							connectionData.getHost(), connectionData.getPort(),
							connectionData.isTls()), executorService);
		} else {
			Socket outbound = createSocket(connectionData.getSocketFactory(), connectionData.getHost(),
					connectionData.getPort(), connectionData.isTls());
			Socket inbound = createSocket(connectionData.getSocketFactory(), connectionData.getHost(),
					connectionData.getPort2(), connectionData.isTls());
			connection = new Connection(connectionData.getParser(),
					connectionData.getProtocol(), inbound, outbound,
					executorService);
		}
		connection.activate();
		return connection;
	}

	private static Socket createSocket(ca.uhn.hl7v2.util.SocketFactory socketFactory, String host, int port, boolean tls) throws IOException {
		Socket socket;
		if (tls) {
			socket = socketFactory.createTlsSocket();
		} else {
			socket = socketFactory.createSocket();
		}
		socket.connect(new InetSocketAddress(host, port));
		return socket;
	}

//	private static Socket createSocket(String host, int port, boolean ssl)
//			throws UnknownHostException, IOException {
//		SocketFactory sf = ssl ? SSLSocketFactory.getDefault() : SocketFactory
//				.getDefault();
//		Socket socket = sf.createSocket(host, port);
//		socket.setKeepAlive(true); // enable TCP KeepAlive packets
//		// There are more socket parameters that could be set by configuration:
//		// socket.setReuseAddress(true);
//		// socket.setSoTimeout(...)
//		// socket.setTcpNoDelay(...)
//		return socket;
//	}

}