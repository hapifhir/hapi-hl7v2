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
GNU General Public License (the  "GPL"), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 
 */
package ca.uhn.hl7v2.app;

import ca.uhn.hl7v2.llp.LowerLayerProtocol;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.util.SocketFactory;
import ca.uhn.hl7v2.util.StandardSocketFactory;

/**
 * Connection meta data class.
 */
class ConnectionData {
	private final String host;
	private final int port;
	private final int port2;
	private final boolean tls;
	private final Parser parser;
	private final LowerLayerProtocol protocol;
	private SocketFactory socketFactory;
    private final boolean lazy;
	private final Integer connectionTimeout;

	public ConnectionData(String host, int port, Parser parser, LowerLayerProtocol protocol) {
		this(host, port, parser, protocol, false, null);
	}

	public ConnectionData(String host, int port, Parser parser, LowerLayerProtocol protocol, Integer connectionTimeout) {
		this(host, port, parser, protocol, false, connectionTimeout);
	}

	public ConnectionData(String host, int port, Parser parser, LowerLayerProtocol protocol, boolean tls) {
		this(host, port, 0, parser, protocol, tls, null);
	}

	public ConnectionData(String host, int port, Parser parser, LowerLayerProtocol protocol, boolean tls, Integer connectionTimeout) {
		this(host, port, 0, parser, protocol, tls, connectionTimeout);
	}

	public ConnectionData(String host, int outboundPort, int inboundPort, Parser parser, LowerLayerProtocol protocol, boolean tls) {
		this(host, outboundPort, inboundPort, parser, protocol, tls, null, false, null);
	}

	public ConnectionData(String host, int outboundPort, int inboundPort, Parser parser, LowerLayerProtocol protocol, boolean tls, Integer connectionTimeout) {
		this(host, outboundPort, inboundPort, parser, protocol, tls, null, false, connectionTimeout);
	}

	public ConnectionData(String host, int outboundPort, int inboundPort, Parser parser, LowerLayerProtocol protocol, boolean tls, SocketFactory socketFactory, boolean lazy) {
		this(host, outboundPort, inboundPort, parser, protocol, tls, socketFactory,lazy, null);
	}

	public ConnectionData(String host, int outboundPort, int inboundPort, Parser parser, LowerLayerProtocol protocol, boolean tls, SocketFactory socketFactory, boolean lazy, Integer connectionTimeout) {
		this.host = host;
		this.port = outboundPort;
		this.port2 = inboundPort;
		this.parser = parser;
		this.protocol = protocol;
		this.tls = tls;
		this.socketFactory = socketFactory;
		this.connectionTimeout = connectionTimeout;
		if (this.socketFactory == null) {
			StandardSocketFactory sf = new StandardSocketFactory();
			if (this.connectionTimeout != null) {
				sf.setAcceptedSocketTimeout(this.connectionTimeout);
			}
			this.socketFactory = sf;
		}
        this.lazy = lazy;
	}

	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}

	public int getPort2() {
		return port2;
	}

	public boolean isTls() {
		return tls;
	}

    boolean isLazy() {
        return lazy;
    }

    public Parser getParser() {
		return parser;
	}

	public LowerLayerProtocol getProtocol() {
		return protocol;
	}

	public SocketFactory getSocketFactory() {
		return socketFactory;
	}

	public void setSocketFactory(SocketFactory theSocketFactory) {
		socketFactory = theSocketFactory;
	}

	public Integer getConnectionTimeout() {
		return connectionTimeout;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((host == null) ? 0 : host.hashCode());
		result = prime * result + ((parser == null) ? 0 : parser.hashCode());
		result = prime * result + ((protocol == null) ? 0 : protocol.hashCode());
		result = prime * result + port;
		result = prime * result + port2;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConnectionData other = (ConnectionData) obj;
		if (host == null) {
			if (other.host != null)
				return false;
		} else if (!host.equals(other.host))
			return false;
		if (parser == null) {
			if (other.parser != null)
				return false;
		} else {
			if (other.parser == null)
				return false;
			else if (!parser.getClass().equals(other.parser.getClass()))
				return false;
		}
		if (protocol == null) {
			if (other.protocol != null)
				return false;
		} else {
			if (other.protocol == null)
				return false;
			else if (!protocol.getClass().equals(other.protocol.getClass()))
				return false;
		}
		if (port != other.port)
			return false;
		return port2 == other.port2;
	}

	@Override
	public String toString() {
		StringBuilder buf = new StringBuilder();
		buf.append(getHost()).append(":").append(getPort());
		if (port2 > 0)
			buf.append(",").append(port2);
		if (isTls())
			buf.append("(s)");
		return buf.toString();
	}

}