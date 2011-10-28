package ca.uhn.hl7v2.examples;

import java.nio.charset.Charset;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.Connection;
import ca.uhn.hl7v2.app.ConnectionHub;
import ca.uhn.hl7v2.app.SimpleServer;
import ca.uhn.hl7v2.llp.ExtendedMinLowerLayerProtocol;
import ca.uhn.hl7v2.llp.MinLLPReader;
import ca.uhn.hl7v2.llp.MinLowerLayerProtocol;
import ca.uhn.hl7v2.parser.PipeParser;

public class HandlingCharacterEncodings {

	public static void main(String[] args) throws HL7Exception {
		
		/*
		 * When you use ConnectionHub, SimpleServer, or other network related classes within
		 * HAPI to transmit and receive messages, you may need to consider character sets if
		 * you plan on dealing with messages that contain characters beyond basic ASCII.
		 */
		
		/*
		 * Character sets are handled by the Lower Layer Protocol implementation, as shown in the two
		 * examples below. The most common implementation is MinLowerLayerProtocol.
		 * 
		 * By default, MinLowerLayerProtocol uses the "US-ASCII" character set, which is not likely
		 * what you are looking for if you want to process accents or characters that don't
		 * appear in the English alphabet.
		 */
		SimpleServer s = new SimpleServer(123, new MinLowerLayerProtocol(), new PipeParser());

		/*
		 * Using MinLowerLayerProtocol, it is possible to set the use of a specific character set
		 * by using a system property. For example, if you wanted to receive Central and Eastern 
		 * European characters, you probably need the ISO-8859-2 charset. Setting the following
		 * system property before using MinLowerLayerProtocol tells the LLP that incoming 
		 * messages should be received using this encoding. Note that you can not change this
		 * value after a connection is established. 
		 */
		System.setProperty(MinLLPReader.CHARSET_KEY, "ISO-8859-2");
		s = new SimpleServer(123, new MinLowerLayerProtocol(), new PipeParser());
		
		/*
		 * If the systems sending you messages are correctly
		 * populating MSH-18, as in the following message which specified "8859/1", or 
		 * ISO-8859-1 encoding, you have another option.
		 * 
		 * MSH|^~\&|4265-ADT|4265|eReferral|eReferral|201004141020||ADT^A45^ADT_A45|102416|T^|2.5^^|||NE|AL|CAN|8859/1
         * EVN|A45|201004141020|
		 * PID|1||7010226^^^4265^MR~0000000000^^^CANON^JHN^^^^^^GP~1736465^^^4265^VN||Park^Green^^^MS.^^L||19890812|F|||123 TestingLane^^TORONTO^CA-ON^M5G2C2^CAN^H^~^^^^^^^||^PRN^PH^^1^416^2525252^|^^^^^^^||||||||||||||||N
		 * PV1|1|I||||^^^WP^1469^^^^^^^^|||||||||||^Derkach^Peter.^^^Dr.||20913000131|||||||||||||||||||||||||201004011340|201004141018
		 * 
		 * Another possibility (only available in HAPI 1.3+) is to read the value from MSH-18
		 * and use that to identify the character set. This can be advantageous if you want
		 * to be able to receive multiple CharSets. To do this, you need to use the 
		 * ExtendedMinLowerLayerProtocol.
		 */
		s = new SimpleServer(123, new ExtendedMinLowerLayerProtocol(), new PipeParser());
		
		/*
		 * The same LLP implementations may be also be used for transmitting messages.
		 * 
		 * If you want to transmit using the same encoding all of the time, you may use
		 * MinLowerLayerProtocol. In the example below, messages will be sent out using
		 * ISO-8859-2
		 */
		System.setProperty(MinLLPReader.CHARSET_KEY, "ISO-8859-2");
		Connection c = ConnectionHub.getInstance().attach("localhost", 8888, new PipeParser(), MinLowerLayerProtocol.class);

		/*
		 * You may also use ExtendedMinLowerLayerProtocol to send out messages using
		 * the value you have placed in MSH-18. 
		 */
		c = ConnectionHub.getInstance().attach("localhost", 8888, new PipeParser(), ExtendedMinLowerLayerProtocol.class);
		
	}
	
	

}
