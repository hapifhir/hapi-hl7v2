/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "SendAndReceiveAMessage.java".  Description:
 * "Example Code"
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2001.  All Rights Reserved.
 *
 * Contributor(s): James Agnew
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  �GPL�), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 *
 */
package ca.uhn.hl7v2.examples;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.app.HL7Service;
import ca.uhn.hl7v2.app.SimpleServer;
import ca.uhn.hl7v2.llp.MinLowerLayerProtocol;
import ca.uhn.hl7v2.parser.PipeParser;

/**
 * Example code
 * 
 * @author James Agnew
 * @author Christian Ohr
 */
public class CustomThreading {


	@SuppressWarnings("unused")
   public static void main(String[] args) throws Exception {

        // Instantiate a custom executor service to be used
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10, 100,
                30, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(100));
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

		/*
		 * Custom Threading with HapiContext (HAPI 2.1)
		 */
		int port = 1011; // The port to listen on
		HapiContext context = new DefaultHapiContext();
        context.setExecutorService(executor);
		HL7Service server = context.newServer(port, false);
        // server.startAndWait();

		/*
		 * Custom Threading without HapiContext (HAPI 2.0)
		 */
        server = new SimpleServer(port, new MinLowerLayerProtocol(true), new PipeParser(), false, executor);
        // server.startAndWait();

        executor.shutdown();

	}

}
