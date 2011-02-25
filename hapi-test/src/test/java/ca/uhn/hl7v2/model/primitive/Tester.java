package ca.uhn.hl7v2.model.primitive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.Application;
import ca.uhn.hl7v2.app.ApplicationException;
import ca.uhn.hl7v2.app.ApplicationExceptionHandler;
import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.hl7v2.conf.check.DefaultValidator;
import ca.uhn.hl7v2.conf.parser.ProfileParser;
import ca.uhn.hl7v2.conf.spec.RuntimeProfile;
import ca.uhn.hl7v2.conf.spec.message.StaticDef;
import ca.uhn.hl7v2.conf.store.CodeStore;
import ca.uhn.hl7v2.conf.store.ProfileCodeStore;
import ca.uhn.hl7v2.conf.store.ProfileStoreFactory;
import ca.uhn.hl7v2.model.GenericMessage;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.datatype.DTM;
import ca.uhn.hl7v2.model.v25.datatype.TS;
import ca.uhn.hl7v2.model.v25.message.ACK;
import ca.uhn.hl7v2.model.v25.message.ADT_A01;
import ca.uhn.hl7v2.model.v25.message.ORU_R01;
import ca.uhn.hl7v2.model.v25.segment.MSH;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.parser.PipeParser;

public class Tester {

	
	public static void main(String[] args) throws HL7Exception, IOException, ProfileException {
		{ORU_R01 msg = new ORU_R01();
		msg.initQuickstart("ORU", "R01", "T");
		
		TS ts = msg.getPATIENT_RESULT().getORDER_OBSERVATION().getORC().getDateTimeOfTransaction();
		DTM time = ts.getTime();
		time.setValue("20110201121233");
		
		Date date = time.getValueAsDate();
		System.out.println(date);
		// Tue Feb 01 12:12:33 EST 2011

		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.YEAR, 2010);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DATE, 29);
		cal.set(Calendar.HOUR_OF_DAY, 12);
		cal.set(Calendar.MINUTE, 59);
		time.setValueToMinute(cal);
		
		System.out.println(ts.encode());
		// 201001291259

		cal = time.getValueAsCalendar();
		System.out.println(cal.getTime());
		// Tue Feb 01 12:12:33 EST 2011
	}
		

		// Load the profile from the classpath
        ProfileParser parser = new ProfileParser(false);
        RuntimeProfile profile = parser.parseClasspath("ca/uhn/hl7v2/conf/parser/example_ack.xml");

        // Create a message to validate
        String message = "MSH|^~\\&|||||||ACK^A01|1|D|2.4|||||CAN|wrong|F^^HL70001^x^^HL78888|\r"; //note HL7888 doesn't exist
        ACK msg = (ACK) (new PipeParser()).parse(message);
		
        // Validate
		HL7Exception[] errors = new DefaultValidator().validate(msg, profile.getMessage());
		
		// Each exception is a validation error
		System.out.println("Validation errors: " + Arrays.asList(errors));
		
	}
	
	/**
	 * Example Application processor which always attempts to generate an
	 * ACK, even if exceptions are thrown
	 */
	private class MyApplication implements Application, ApplicationExceptionHandler {

		public String processException(String incomingMessage, String outgoingMessage, Exception e) throws HL7Exception {

			// Process/log the exception..?

			ADT_A01 message = new ADT_A01();
			try {
				message.parse(incomingMessage);
			} catch (HL7Exception e2) {
				// ignore
			}
			
			// create a new ACK message
			ACK ack = new ACK();
			try {
				ack.initQuickstart("ACK", null, null);
			} catch (IOException e1) {
				throw new HL7Exception(e1);
			}

			ack.getMSA().getMsa1_AcknowledgmentCode().setValue("AA");
			ack.getMSA().getMsa2_MessageControlID().setValue(message.getMSH().getMessageControlID().getValue());
			
			return ack.encode();
		}

		public Message processMessage(Message in) throws ApplicationException, HL7Exception {
			
			// do some processing
			
			try {
				return in.generateACK();
			} catch (IOException e) {
				throw new HL7Exception(e);
			}
		}

		public boolean canProcess(Message in) {
			return true;
		}
		
	}
	
}
