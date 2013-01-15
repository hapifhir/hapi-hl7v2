package ca.uhn.hl7v2.examples;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.message.ADT_A01;
import ca.uhn.hl7v2.model.v25.message.ADT_A02;
import ca.uhn.hl7v2.model.v25.message.ADT_AXX;
import ca.uhn.hl7v2.model.v25.segment.PID;
import ca.uhn.hl7v2.parser.CanonicalModelClassFactory;

public class ExampleSuperStructures {

   public static void main(String[] args) throws HL7Exception {

      /*
       * When writing HL7 compliant applications, a common complaint is that
       * different message types use different structures which are similar, but
       * not identical.
       * 
       * When your application receives an ADT^A01 message, it will parse it
       * into an ADT_A01 structure. When your application receives an ADT^A17
       * message, it will parse it into an ADT_A17 structure.
       * 
       * Naturally you can use casting as a means of dealing with this:
       */

      DefaultHapiContext ctx = new DefaultHapiContext();
      Message msg = ctx.getPipeParser().parse(" .. some hl7 message ..");
      if (msg instanceof ADT_A01) {
         processAdtA01((ADT_A01) msg);
      } else if (msg instanceof ADT_A02) {
         processAdtA02((ADT_A02) msg);
      } // etc...

      /*
       * An alternative way of accomplishing this is to use a SuperStructure.
       * The ADT_AXX structure is a single message structure class which
       * contains all of the segments for *every* possible ADT message. This
       * allows you to write a single routine which handles all ADT messages.
       * 
       * To take advantage of the ADT_AXX structure, you configure your
       * HapiContext to use a special ModelClassFactory, which tells parsers to
       * always use the same structure.
       */

      ctx.setModelClassFactory(new CanonicalModelClassFactory(ADT_AXX.class));

      msg = ctx.getPipeParser().parse(" .. some hl7 message ..");

      // Since we configured the ModelClassFactory to use the ADT_AXX above, we
      // can cast
      ADT_AXX axx = (ADT_AXX) msg;

      // We can now always ask for the patient from the message in the same way
      processPID(axx.getPID());

      // Some segments are specific to certain message types only
      String trigger = axx.getMSH().getMsh9_MessageType().getMsg2_TriggerEvent().getValue();
      if ("A17".equals(trigger)) {
         PID pid1 = axx.getPID();
         PID pid2 = axx.getPID2(); // This exists only in ADT^A17
         processBedSwap(pid1, pid2);
      }
      
      /*
       * It is important to stress that the AXX Superstructure has placeholders
       * for every possible segment in every ADT message structure, but for
       * any given message only some segments will be used (except MSH and PID, 
       * which are common to all ADT messages). This means you will need to 
       * be careful to check the MSH-9-2 value to figure out which data belongs.
       */
      
      /*
       * The Superstructure can also be used to create messages for sending.
       * As with receiving, you need to be careful to only populate segments
       * which belong to a given message type. If you do not, the validator
       * will throw an exception 
       */

   }

   private static void processBedSwap(PID thePid1, PID thePid2) {
      // swap beds
   }

   private static void processAdtA01(ADT_A01 theMsg) {
      // Process the PID segment
      processPID(theMsg.getPID());

      // do other things...
   }

   private static void processAdtA02(ADT_A02 theMsg) {
      // Process the PID segment
      processPID(theMsg.getPID());

      // do other things...
   }

   private static void processPID(PID thePid) {
      // do things...
   }

}
