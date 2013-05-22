/*
 The contents of this file are subject to the Mozilla Public License Version 1.1
 (the "License"); you may not use this file except in compliance with the License.
 You may obtain a copy of the License at http://www.mozilla.org/MPL/
 Software distributed under the License is distributed on an "AS IS" basis,
 WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 specific language governing rights and limitations under the License.

 The Original Code is "LazyConnection.java".  Description:
 "Connection that lazily connects right before sending the first message"

 The Initial Developer of the Original Code is University Health Network. Copyright (C)
 2013.  All Rights Reserved.

 Contributor(s): ______________________________________.

 Alternatively, the contents of this file may be used under the terms of the
 GNU General Public License (the "GPL"), in which case the provisions of the GPL are
 applicable instead of those above.  If you wish to allow use of your version of this
 file only under the terms of the GPL and not to allow others to use your version
 of this file under the MPL, indicate your decision by deleting  the provisions above
 and replace  them with the notice and other provisions required by the GPL License.
 If you do not delete the provisions above, a recipient may use your version of
 this file under either the MPL or the GPL.
 */

package ca.uhn.hl7v2.app;

import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.model.Message;

/**
 * A LazyConnection behaves like an ordinary connection except for the fact
 * that the actual socket connection is created lazily right before the
 * first message is sent over the associated Initiator. Server-side connections
 * are always non-lazy.
 */
public class LazyConnection implements Connection {

    private ConnectionData data;
    private ExecutorService executor;
    private Connection activeConnection;
    private LazyInitiator initiator;

    public LazyConnection(ConnectionData data, ExecutorService executor) {
        this.data = data;
        this.executor = executor;
        this.initiator = new LazyInitiator(this);
    }

    public void activate() {
        if (isEstablished()) activeConnection.activate();
    }

    public Initiator getInitiator() {
        if (isEstablished()) return activeConnection.getInitiator();
        return initiator;
    }

    public void close() {
        if (isEstablished()) {
            activeConnection.close();
            activeConnection = null;
        }
    }

    public boolean isOpen() {
        return isEstablished() && activeConnection.isOpen();
    }

    public ExecutorService getExecutorService() {
        if (isEstablished()) return activeConnection.getExecutorService();
        return executor;
    }

    public InetAddress getRemoteAddress() {
        if (isEstablished())
            return activeConnection.getRemoteAddress();
        return null;
    }

	public Integer getRemotePort() {
        if (isEstablished()) {
            return activeConnection.getRemotePort();
        }
        return null;
	}

    boolean isEstablished() {
        return activeConnection != null && activeConnection.isOpen();
    }

    void establishConnection() throws HL7Exception {
        try {
            activeConnection = ConnectionFactory.openEagerly(data, executor);
        } catch (Exception e) {
            throw new HL7Exception(e);
        }
    }


    class LazyInitiator implements Initiator {

        private LazyConnection connection;
        private long timeoutMillis = 10000;

        LazyInitiator(LazyConnection connection) {
            this.connection = connection;
        }

        public synchronized Message sendAndReceive(Message out) throws HL7Exception, LLPException, IOException {
            if (!connection.isEstablished()) {
                connection.establishConnection();
                setTimeout(timeoutMillis, TimeUnit.MILLISECONDS);
            }
            return connection.getInitiator().sendAndReceive(out);
        }

        public synchronized void setTimeout(long timeout, TimeUnit timeunit) {
            if (connection.isEstablished())
                connection.getInitiator().setTimeout(timeout, timeunit);
            else
                this.timeoutMillis = timeunit.toMillis(timeout);
        }

        public void setTimeoutMillis(int timeout) {
            setTimeout(timeout, TimeUnit.MILLISECONDS);
        }
    }

}
