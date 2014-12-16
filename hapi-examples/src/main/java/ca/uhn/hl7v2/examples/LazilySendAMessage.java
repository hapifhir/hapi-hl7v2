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

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.app.Connection;
import ca.uhn.hl7v2.app.HL7Service;
import ca.uhn.hl7v2.app.Initiator;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.protocol.ReceivingApplication;

/**
 * Example code
 *
 * @author Christian Ohr
 */
public class LazilySendAMessage {

    /**
     * Example for how to send messages on a lazy client connection
     */
    public static void main(String[] args) throws Exception {


        HapiContext context = new DefaultHapiContext();
        int port = 1011; // The port to listen on
        boolean useTls = false; // Should we use TLS/SSL?

        // A connection object represents a socket attached to an HL7 server. Because the
        // server has not been started yet, we need to construct a lazy client.
        Connection connection = context.newLazyClient("localhost", port, useTls);
        Initiator initiator = connection.getInitiator();

      /*
       * Now create a server to listen for incoming
       * messages.
       */
        HL7Service server = context.newServer(port, useTls);

      /*
       * The server may have any number of "application" objects registered to
       * handle messages. We are going to create an application to listen to
       * ADT^A01 messages.
       * 
       * You might want to look at the source of ExampleReceiverApplication
       * (it's a nested class below) to see how it works.
       */
        ReceivingApplication<Message> handler = new ExampleReceiverApplication();
        server.registerApplication("*", "*", handler);

        // Start the server listening for messages
        server.startAndWait();

      /*
       * Note: if you don't want to wait for the server to initialize itself, it
       * can start in the background:
       */

        // server.start();


        // Create a message to send it to the server. The physical connection is
        // established transparently.
        String msg = "MSH|^~\\&|HIS|RIH|EKG|EKG|199904140038||ADT^A01|12345|P|2.2\r"
                + "PID|0001|00009874|00001122|A00977|SMITH^JOHN^M|MOM|19581119|F|NOTREAL^LINDA^M|C|564 SPRING ST^^NEEDHAM^MA^02494^US|0002|(818)565-1551|(425)828-3344|E|S|C|0000444444|252-00-4414||||SA|||SA||||NONE|V1|0001|I|D.ER^50A^M110^01|ER|P00055|11B^M011^02|070615^BATMAN^GEORGE^L|555888^NOTREAL^BOB^K^DR^MD|777889^NOTREAL^SAM^T^DR^MD^PHD|ER|D.WT^1A^M010^01|||ER|AMB|02|070615^NOTREAL^BILL^L|ER|000001916994|D||||||||||||||||GDD|WA|NORM|02|O|02|E.IN^02D^M090^01|E.IN^01D^M080^01|199904072124|199904101200|199904101200||||5555112333|||666097^NOTREAL^MANNY^P\r"
                + "NK1|0222555|NOTREAL^JAMES^R|FA|STREET^OTHER STREET^CITY^ST^55566|(222)111-3333|(888)999-0000|||||||ORGANIZATION\r"
                + "PV1|0001|I|D.ER^1F^M950^01|ER|P000998|11B^M011^02|070615^BATMAN^GEORGE^L|555888^OKNEL^BOB^K^DR^MD|777889^NOTREAL^SAM^T^DR^MD^PHD|ER|D.WT^1A^M010^01|||ER|AMB|02|070615^VOICE^BILL^L|ER|000001916994|D||||||||||||||||GDD|WA|NORM|02|O|02|E.IN^02D^M090^01|E.IN^01D^M080^01|199904072124|199904101200|||||5555112333|||666097^DNOTREAL^MANNY^P\r"
                + "PV2|||0112^TESTING|55555^PATIENT IS NORMAL|NONE|||19990225|19990226|1|1|TESTING|555888^NOTREAL^BOB^K^DR^MD||||||||||PROD^003^099|02|ER||NONE|19990225|19990223|19990316|NONE\r"
                + "AL1||SEV|001^POLLEN\r"
                + "GT1||0222PL|NOTREAL^BOB^B||STREET^OTHER STREET^CITY^ST^77787|(444)999-3333|(222)777-5555||||MO|111-33-5555||||NOTREAL GILL N|STREET^OTHER STREET^CITY^ST^99999|(111)222-3333\r"
                + "IN1||022254P|4558PD|BLUE CROSS|STREET^OTHER STREET^CITY^ST^00990||(333)333-6666||221K|LENIX|||19980515|19990515|||PATIENT01 TEST D||||||||||||||||||02LL|022LP554";
        Parser p = context.getPipeParser();
        Message adt = p.parse(msg);
        Message response = initiator.sendAndReceive(adt);

        String responseString = p.encode(response);
        System.out.println("Received response:\n" + responseString);

      /*
       * MSH|^~\&|||||20070218200627.515-0500||ACK|54|P|2.2 MSA|AA|12345
       */

      /*
       * Close the connection when you are done with it. If you are designing a
       * system which will continuously send out messages, you may want to
       * consider not closing the connection until you have no more messages to
       * send out. This is more efficient, as most (if not all) HL7 receiving
       * applications are capable of receiving lots of messages in a row over
       * the same connection, even with a long delay between messages.
       * 
       * See
       * http://hl7api.sourceforge.net/xref/ca/uhn/hl7v2/examples/SendLotsOfMessages.html 
       * for an example of this.
       */
        connection.close();

        // Stop the receiving server and client
        server.stopAndWait();

    }


}
