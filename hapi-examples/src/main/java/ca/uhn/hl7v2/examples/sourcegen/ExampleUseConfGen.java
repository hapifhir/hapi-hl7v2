package ca.uhn.hl7v2.examples.sourcegen;

import java.io.IOException;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.Connection;
import ca.uhn.hl7v2.app.HL7Service;
import ca.uhn.hl7v2.examples.custommodel.v25.message.ZDT_A01;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.CanonicalModelClassFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;

public class ExampleUseConfGen {

@SuppressWarnings("unused")
public static void main(String[] args) throws HL7Exception, IOException, LLPException {
// Sending a message

{   
// Create a new instance of the message and initialize it
ZDT_A01 outMsg = new ZDT_A01();
outMsg.initQuickstart("ZDT", "A01", "T");

// .. populate other segments ..
// e.g. outMsg.getPID().getPid3_PatientIdentifierList(0).......

// Create a hapi context and send the message
DefaultHapiContext ctx = new DefaultHapiContext();
Connection conn = ctx.newClient("someserver.com", 8888, false);

// Send the message
Message response = conn.getInitiator().sendAndReceive(outMsg);
}


DefaultHapiContext ctx = new DefaultHapiContext();
ModelClassFactory mcf = new CanonicalModelClassFactory(ZDT_A01.class);
ctx.setModelClassFactory(mcf);

HL7Service server = ctx.newServer(8888, false);
server.start();
   
}
   
   
   
}
