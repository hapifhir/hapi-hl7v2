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

import java.io.IOException;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.Application;
import ca.uhn.hl7v2.app.Connection;
import ca.uhn.hl7v2.app.ConnectionHub;
import ca.uhn.hl7v2.app.Initiator;
import ca.uhn.hl7v2.app.SimpleServer;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.llp.LowerLayerProtocol;
import ca.uhn.hl7v2.llp.MinLowerLayerProtocol;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.GenericParser;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;

/**
 * Example code
 * 
 * @author <a href="mailto:james.agnew@uhn.on.ca">James Agnew</a>
 * @version $Revision: 1.2 $ updated on $Date: 2010-09-06 17:29:21 $ by $Author: jamesagnew $
 */
public class SendAndReceiveAMessage
{

    /**
     * @param args
     * @throws HL7Exception
     * @throws EncodingNotSupportedException
     * @throws IOException
     * @throws LLPException
     */
    public static void main(String[] args) throws EncodingNotSupportedException, HL7Exception, LLPException,
            IOException {

        /*
         * Create a server to listen for incoming messages
         */

        int port = 1011; // The port to listen on
        LowerLayerProtocol llp = LowerLayerProtocol.makeLLP(); // The transport protocol
        PipeParser parser = new PipeParser(); // The message parser
        SimpleServer server = new SimpleServer(port, llp, parser);

        /*
         * The server may have any number of "application" objects registered to handle messages. We
         * are going to create an application to listen to ADT^A01 messages.
         */
        Application handler = new ExampleReceiverApplication();
        server.registerApplication("ADT", "A01", handler);

        /*
         * We are going to register the same application to handle ADT^A02 messages. Of course, we
         * coud just as easily have specified a different handler.
         */
        server.registerApplication("ADT", "A02", handler);

        /*
         * Another option would be to specify a single application to handle all messages, like
         * this:
         * 
         * server.registerApplication("*", "*", handler);
         */

        // Start the server listening for messages
        server.start();

        /*
         * Now, create a connection to that server, and send a message
         */

        // Create a message to send
        String msg = "MSH|^~\\&|HIS|RIH|EKG|EKG|199904140038||ADT^A01|12345|P|2.2\r"
                + "PID|0001|00009874|00001122|A00977|SMITH^JOHN^M|MOM|19581119|F|NOTREAL^LINDA^M|C|564 SPRING ST^^NEEDHAM^MA^02494^US|0002|(818)565-1551|(425)828-3344|E|S|C|0000444444|252-00-4414||||SA|||SA||||NONE|V1|0001|I|D.ER^50A^M110^01|ER|P00055|11B^M011^02|070615^BATMAN^GEORGE^L|555888^NOTREAL^BOB^K^DR^MD|777889^NOTREAL^SAM^T^DR^MD^PHD|ER|D.WT^1A^M010^01|||ER|AMB|02|070615^NOTREAL^BILL^L|ER|000001916994|D||||||||||||||||GDD|WA|NORM|02|O|02|E.IN^02D^M090^01|E.IN^01D^M080^01|199904072124|199904101200|199904101200||||5555112333|||666097^NOTREAL^MANNY^P\r"
                + "NK1|0222555|NOTREAL^JAMES^R|FA|STREET^OTHER STREET^CITY^ST^55566|(222)111-3333|(888)999-0000|||||||ORGANIZATION\r"
                + "PV1|0001|I|D.ER^1F^M950^01|ER|P000998|11B^M011^02|070615^BATMAN^GEORGE^L|555888^OKNEL^BOB^K^DR^MD|777889^NOTREAL^SAM^T^DR^MD^PHD|ER|D.WT^1A^M010^01|||ER|AMB|02|070615^VOICE^BILL^L|ER|000001916994|D||||||||||||||||GDD|WA|NORM|02|O|02|E.IN^02D^M090^01|E.IN^01D^M080^01|199904072124|199904101200|||||5555112333|||666097^DNOTREAL^MANNY^P\r"
                + "PV2|||0112^TESTING|55555^PATIENT IS NORMAL|NONE|||19990225|19990226|1|1|TESTING|555888^NOTREAL^BOB^K^DR^MD||||||||||PROD^003^099|02|ER||NONE|19990225|19990223|19990316|NONE\r"
                + "AL1||SEV|001^POLLEN\r"
                + "GT1||0222PL|NOTREAL^BOB^B||STREET^OTHER STREET^CITY^ST^77787|(444)999-3333|(222)777-5555||||MO|111-33-5555||||NOTREAL GILL N|STREET^OTHER STREET^CITY^ST^99999|(111)222-3333\r"
                + "IN1||022254P|4558PD|BLUE CROSS|STREET^OTHER STREET^CITY^ST^00990||(333)333-6666||221K|LENIX|||19980515|19990515|||PATIENT01 TEST D||||||||||||||||||02LL|022LP554";
        Parser p = new GenericParser();
        Message adt = p.parse(msg);

        // The connection hub connects to listening servers
        ConnectionHub connectionHub = ConnectionHub.getInstance();

        // A connection object represents a socket attached to an HL7 server
        Connection connection = connectionHub
                .attach("localhost", port, new PipeParser(), MinLowerLayerProtocol.class);

        // The initiator is used to transmit unsolicited messages
        Initiator initiator = connection.getInitiator();
        Message response = initiator.sendAndReceive(adt);

        String responseString = parser.encode(response);
        System.out.println("Received response:\n" + responseString);

        /*
         * MSH|^~\&|||||20070218200627.515-0500||ACK|54|P|2.2 MSA|AA|12345
         */

        /* 
         * Close the connection and server. Note that this method may close 
         * the connection. If you are designing a system which will continuously
         * send out messages, you may want to consider keeping a copy of the 
         * Connection object between messages. That way, the same connection
         * will be reused.
         * 
         * See 
         * http://hl7api.sourceforge.net/xref/ca/uhn/hl7v2/examples/SendLotsOfMessages.html
         * for an example of this.
         */
        connectionHub.discard(connection);
        
        // Stop the receiving server and client
        server.stopAndWait();
        ConnectionHub.shutdown();

    }

}
