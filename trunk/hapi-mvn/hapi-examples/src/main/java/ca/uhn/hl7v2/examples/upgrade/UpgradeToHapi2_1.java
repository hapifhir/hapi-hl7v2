package ca.uhn.hl7v2.examples.upgrade;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Map;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.HL7Service;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.protocol.ReceivingApplicationException;
import ca.uhn.hl7v2.protocol.impl.AppRoutingDataImpl;
import ca.uhn.hl7v2.protocol.impl.ApplicationRouterImpl;
import ca.uhn.hl7v2.protocol.impl.HL7Server;
import ca.uhn.hl7v2.protocol.impl.NullSafeStorage;

public class UpgradeToHapi2_1 {

   /**
    * @param args
    * @throws IOException
    */
   public static void main(String[] args) throws IOException {

   }

   @SuppressWarnings("unused")
   private void oldWay() throws IOException {

      // START SNIPPET: oldServer
      // Create a router
      ApplicationRouterImpl router = new ApplicationRouterImpl();
      AppRoutingDataImpl routingData = new AppRoutingDataImpl("*", "*", "*", "*");

      // Create an application and bind it to the router
      MyReceivingApplication application = new MyReceivingApplication();
      router.bindApplication(routingData, application);

      // Create a server and start it
      ServerSocket socket = new ServerSocket(8888);
      NullSafeStorage storage = new NullSafeStorage();
      HL7Server hl7Server = new HL7Server(socket, router, storage);
      hl7Server.start(null);
      // END SNIPPET: oldServer

   }

   @SuppressWarnings("unused")
   private void newWay() {

      // START SNIPPET: newServer
      // Create a context and ask it for a service
      DefaultHapiContext ctx = new DefaultHapiContext();
      HL7Service server = ctx.newServer(8888, false);

      // Create an application and bind it to the server
      MyReceivingApplication application = new MyReceivingApplication();
      server.registerApplication(application);

      // Start the server
      server.start();
      // END SNIPPET: newServer

   }

// START SNIPPET: newApp
public class MyReceivingApplication implements ca.uhn.hl7v2.protocol.ReceivingApplication<Message> {

   public Message processMessage(Message theMessage, Map<String, Object> theMetadata) throws ReceivingApplicationException, HL7Exception {

      // ...Do something with theMessage...

      try {
         return theMessage.generateACK();
      } catch (IOException e) {
         throw new HL7Exception(e);
      }
   }

   public boolean canProcess(Message theMessage) {
      return true;
   }

}

// END SNIPPET: newApp

// START SNIPPET: oldApp
public class MyApplication implements ca.uhn.hl7v2.app.Application {

   public Message processMessage(Message theMessage) throws HL7Exception {
      // ...Do something with theMessage...
      try {
         return theMessage.generateACK();
      } catch (IOException e) {
         throw new HL7Exception(e);
      }
   }

   public boolean canProcess(Message theMessage) {
      return true;
   }

}
// END SNIPPET: oldApp

}
