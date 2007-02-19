/*
 * HL7ServerTest.java
 */

package ca.uhn.hl7v2.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PushbackReader;
import java.io.Reader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;

/**
 * Helper class used to send messages from a flat file to 
 * an ip and port. 
 * 
 * Messasges are sent using MLLP and ACK protocal
 * 
 * <mailto:laura.bright@uhn.on.ca>Laura Bright</mailto>
 * <mailto:neal.acharya@uhn.on.ca>Neal Acharya</mailto>
 * <mailto:james.agnew@uhn.on.ca>James Agnew</mailto>
 * 
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:37 $ by $Author: jamesagnew $
 */
public class HL7ServerTestHelper {
    
    private static final Log ourLog = LogFactory.getLog(HL7ServerTestHelper.class);
    
    private static final String HL7_START_OF_MESSAGE = "\u000b";
    private static final String HL7_SEGMENT_SEPARATOR = "\r";
    private static final String HL7_END_OF_MESSGAE = "\u001c";
    
    private int receivedAckCount;

    private String host = null;
    
    private int port = 0;

    private Socket socket = null;

    private OutputStream os = null;
    private InputStream is = null;
    
    public HL7ServerTestHelper(String host, int port) {
        this.host = host;
        this.port = port;
    }

    /*
     * 
     */
    public void openSocket() throws IOException{
        socket = new Socket(host, port);
        socket.setSoLinger(true, 1000);
        
        os = socket.getOutputStream();
        is = socket.getInputStream();
    }
    
    /**
     * 
     *
     */
    public void closeSocket() {
        try {
            Socket sckt = socket;
            socket = null;
            if (sckt != null)
                sckt.close();
        }
        catch (Exception e) {
            ourLog.error(e);
        }
    }
 
    
    public int process( InputStream theMsgInputStream ) throws FileNotFoundException, IOException
    {
        Parser hapiParser = new PipeParser(); 
        
        BufferedReader in =
            new BufferedReader( 
                new CommentFilterReader( new InputStreamReader( theMsgInputStream ) )
            );
        	
        StringBuffer rawMsgBuffer = new StringBuffer();
        
        //String line = in.readLine();
        int c = 0;
		while( (c = in.read()) >= 0) {
			rawMsgBuffer.append( (char) c);
		}
		
		String[] messages = getHL7Messages(rawMsgBuffer.toString());
        int retVal = 0;
        
        //start time
        long startTime = new GregorianCalendar().getTimeInMillis(); 
            
            
		for (int i = 0; i < messages.length; i++) {
			sendMessage(messages[i]);	
			readAck();	
            retVal++;
		}
        
        //end time
        long endTime =  new GregorianCalendar().getTimeInMillis();
        
        //elapsed time
        long elapsedTime = (endTime - startTime) / 1000;
        
        ourLog.info(retVal + " messages sent.");
        ourLog.info("Elapsed Time in seconds:  " + elapsedTime);
        return retVal;
			
            /*line = line.trim();
            
            if ( line.length()!=0 ) {
                rawMsgBuffer.append( line );
                rawMsgBuffer.append( HL7_SEGMENT_SEPARATOR );
            }
            else {
                if (rawMsgBuffer.length()!=0) {
                    String rawMsg = rawMsgBuffer.toString();
                    sendMessage( rawMsg );
                    //clear buffer 
                    rawMsgBuffer = new StringBuffer(); 
                    //do not wait for ACK, we just want to feed the Hl7Server
                    
                    //TODO look into this, the HL7Server should perform better. JMS integration should fix this.
                    
                    try {
                        //wait a sec, give some time to the HL7Server
                        Thread.sleep(1000); //1 seconds
                    }
                    catch (InterruptedException e) {
                    }
                }
            }
			            
            line = in.readLine();    
        }*/
        
    }
    
	private String readAck() throws IOException
	{
		StringBuffer stringbuffer = new StringBuffer();
		int i = 0;
		do {
			i = is.read();
			if (i == -1)
				return null;
            
			stringbuffer.append((char) i);
		}
		while (i != 28);        
		return stringbuffer.toString();
	}
    
    
    
	/** 
	 * Given a string that contains HL7 messages, and possibly other junk, 
	 * returns an array of the HL7 messages.  
	 * An attempt is made to recognize segments even if there is other 
	 * content between segments, for example if a log file logs segments 
	 * individually with timestamps between them.  
	 * 
	 * @param theSource a string containing HL7 messages 
	 * @return the HL7 messages contained in theSource
	 */
	public static String[] getHL7Messages(String theSource) {
		ArrayList messages = new ArrayList(20); 
		Pattern startPattern = Pattern.compile("^MSH", Pattern.MULTILINE);
		Matcher startMatcher = startPattern.matcher(theSource);

		while (startMatcher.find()) {
			String messageExtent = 
				getMessageExtent(theSource.substring(startMatcher.start()), startPattern);
			
			char fieldDelim = messageExtent.charAt(3);
			Pattern segmentPattern = Pattern.compile("^[A-Z\\d]{3}\\" + fieldDelim + ".*$", Pattern.MULTILINE);
			Matcher segmentMatcher = segmentPattern.matcher(messageExtent);
			StringBuffer msg = new StringBuffer();
			while (segmentMatcher.find()) {
				msg.append(segmentMatcher.group().trim());
				msg.append('\r');
			}
			messages.add(msg.toString());
		}
		return (String[]) messages.toArray(new String[0]);
	}
    
	/** 
	 * Given a string that contains at least one HL7 message, returns the 
	 * smallest string that contains the first of these messages.  
	 */
	private static String getMessageExtent(String theSource, Pattern theStartPattern) {
		Matcher startMatcher = theStartPattern.matcher(theSource);
		if (!startMatcher.find()) {
			throw new IllegalArgumentException(theSource + "does not contain message start pattern" 
				+ theStartPattern.toString());
		}
    	
		int start = startMatcher.start();
		int end = theSource.length();
		if (startMatcher.find()) {
			end = startMatcher.start();
		}
 	
		return theSource.substring(start, end).trim();
	}
    
    
    private void sendMessage(String theMessage) throws IOException
    {
        os.write( HL7_START_OF_MESSAGE.getBytes() );
        os.write( theMessage.getBytes() );
        os.write( HL7_END_OF_MESSGAE.getBytes() );
        os.write(13);
        os.flush();
        ourLog.info("Sent: " + theMessage);
    }
     
    
    
    /**
     * Main method for running the application
     * 
     * example command lines args:
     * 
     * -f UHN_PRO_DEV_PATIENTS.dat -h 142.224.178.152 -p 3999
     * 
     */
    public static void main( String[] theArgs ) {

        //parse command line arguments        

        //create the command line parser
        CommandLineParser parser = new PosixParser();

        //create the Options
        Options options = new Options();

        options.addOption("h", "host", true, "IP of host to send to");
        options.addOption("p", "port", true, "port to send to");
        options.addOption("f", "file", true, "file to read HL7 messages from");
        
        CommandLine cmdLine = null;
        try
        {
            // parse the command line arguments
            cmdLine = parser.parse(options, theArgs);
        }
        catch (ParseException e)
        {
            ourLog.error(e);
            return;
        }

        String portString = cmdLine.getOptionValue("p");
        int port = 0;
        String host = cmdLine.getOptionValue("h");        
        String file = cmdLine.getOptionValue("f");
        
        if (portString == null || host == null || file == null)
        {
            //automatically generate the help statement
            HelpFormatter formatter = new HelpFormatter();
            //assuming that a shell script named serverTest will be created
            formatter.printHelp( "serverTest", options );
            return;
        }
        else {
            //parse portAsString
            port = Integer.parseInt(portString);
        }
        
        HL7ServerTestHelper serverTest = new HL7ServerTestHelper( host, port );
        
        //InputStream msgInputStream = HL7ServerTestHelper.class.getResourceAsStream( file );
		InputStream msgInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(file);		
        try{            
            serverTest.openSocket();
            serverTest.process( msgInputStream );
        }
        catch(Exception e){
        	e.printStackTrace();
            HelpFormatter formatter = new HelpFormatter();
            //assuming that a shell script named hl7mom will be created
            formatter.printHelp( "serverTest", options );
            System.exit(-1);
        }
        
        serverTest.closeSocket();
    }
    
	/**
	 * TODO: this code is copied from HAPI ... should make it part of HAPI public API instead
	 * Removes C and C++ style comments from a reader stream.  C style comments are
	 * distinguished from URL protocol delimiters by the preceding colon in the
	 * latter.
	 */
	public static class CommentFilterReader extends PushbackReader {
        
		private final char[] startCPPComment = {'/', '*'};
		private final char[] endCPPComment = {'*', '/'};
		private final char[] startCComment = {'/', '/'};
		private final char[] endCComment = {'\n'};
		private final char[] protocolDelim = {':', '/', '/'};
        
		public CommentFilterReader(Reader in) {
			super(in, 5);
		}
        
		/**
		 * Returns the next character, not including comments.
		 */
		public int read() throws IOException {
			if (atSequence(protocolDelim)) {
				//proceed normally
			} else if (atSequence(startCPPComment)) {
				//skip() doesn't seem to work for some reason
				while (!atSequence(endCPPComment)) super.read();
				for (int i = 0; i < endCPPComment.length; i++) super.read();
			} else if (atSequence(startCComment)) {
				while (!atSequence(endCComment)) super.read();
				for (int i = 0; i < endCComment.length; i++) super.read();
			}
			int ret = super.read();
			if (ret == 65535) ret = -1;
			return ret;            
		}
                
		public int read(char[] cbuf, int off, int len) throws IOException {
			int i = -1;
			boolean done = false;
			while (++i < len) {
				int next = read();
				if (next == 65535 || next == -1) { //Pushback causes -1 to convert to 65535
					done = true;
					break;  
				}
				cbuf[off + i] = (char) next;
			}
			if (i == 0 && done) i = -1; 
			return i; 
		}            
        
		/**
		 * Tests incoming data for match with char sequence, resets reader when done.
		 */
		private boolean atSequence(char[] sequence) throws IOException {
			boolean result = true;
			int i = -1;
			int[] data = new int[sequence.length];
			while (++i < sequence.length && result == true) {
				data[i] = super.read();
				if ((char) data[i] != sequence[i]) result = false; //includes case where end of stream reached
			}
			for (int j = i-1; j >= 0; j--) {
				this.unread(data[j]);
			}
			return result;
		}        
	}
    

}
