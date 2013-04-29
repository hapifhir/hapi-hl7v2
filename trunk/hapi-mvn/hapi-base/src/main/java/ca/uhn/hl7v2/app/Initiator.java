/*
 The contents of this file are subject to the Mozilla Public License Version 1.1
 (the "License"); you may not use this file except in compliance with the License.
 You may obtain a copy of the License at http://www.mozilla.org/MPL/
 Software distributed under the License is distributed on an "AS IS" basis,
 WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 specific language governing rights and limitations under the License.

 The Original Code is "Initiator.java ".  Description:
 "Initiator interface"

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
import java.util.concurrent.TimeUnit;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.model.Message;

/**
 * Interface for an Initiator
 */
public interface Initiator {

    /**
     * Sends a message to a server and waits for the response
     *
     * @param outgoing outgoing message
     * @return resposne message
     * @throws HL7Exception
     * @throws LLPException
     * @throws IOException
     */
    Message sendAndReceive(Message outgoing) throws HL7Exception,
            LLPException, IOException;

    /**
     * Sets the time that the initiator will wait for a
     * response for a given message before timing out and throwing an exception
     * (default is 10 seconds).
     *
     * @param timeout  time duration
     * @param timeUnit time unit
     */
    void setTimeout(long timeout, TimeUnit timeUnit);

    /**
     * Sets the time (in milliseconds) that the initiator will wait for a
     * response for a given message before timing out and throwing an exception
     * (default is 10 seconds).
     *
     * @param timeout time in milliseconds
     * @deprecated use {@link #setTimeout(long, java.util.concurrent.TimeUnit)}}
     */
    void setTimeoutMillis(int timeout);
}
