package ca.uhn.hl7v2.util;

import ca.uhn.hl7v2.parser.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Tests correctness of message parsing by testing equivalence of re-encoded
 * form with original.
 * @author Bryan Tripp
 * @deprecated
 */
public class ParseTester {
    
    private static GenericParser parser = new GenericParser();
    private BufferedReader source;
    private String context;
    
    /** Creates a new instance of ParseTester */
    public ParseTester() {
    }
    
    /**
     * Checks whether the given message parses correctly with a GenericParser.
     * Failure indicates that the parsed and re-encoded message is semantically
     * different than the original, or that the message could not be parsed.  This 
     * may stem from an error in the parser, or from an error in the message.  This 
     * may also arise from unexpected message components (e.g. Z-segments) although 
     * in future HAPI versions these will be parsed as well.
     * @param message an XML or ER7 encoded message string
     * @return null if it parses correctly, an HL7Exception otherwise
     */
    public static HL7Exception parsesCorrectly(String context, String message) {
        HL7Exception problem = null;
        try {
            Message m = parser.parse(message);
            String encoding = parser.getEncoding(message);
            String result = parser.encode(m, encoding);
            if (!EncodedMessageComparator.equivalent(message, result)) {
                problem = new HL7Exception(context + ": Original differs semantically from parsed/encoded message.\r\n-----Original:------------\r\n" 
                    + message + " \r\n------ Parsed/Encoded: ----------\r\n" + result + " \r\n-----Original Standardized: ---------\r\n"
                    + EncodedMessageComparator.standardize(message) + " \r\n---------------------\r\n");
            }            
        } catch (Exception e) {
            problem = new HL7Exception(context + ": " + e.getMessage() + " in message: \r\n-------------\r\n" + message + "\r\n-------------");;
        }
        return problem; 
    }
    
    /**
     * Sets the source of message data (messages must be delimited by blank lines)
     */
    public void setSource(Reader source) {
        this.source = new BufferedReader(new CommentFilterReader(source));
    }
    
    /**
     * Sets a description of the context of the messages (e.g. file name) that can be 
     * reported within error messages.  
     */
    public void setContext(String description) {
        this.context = description;
    }
    
    /**
     * Sets the source reader to point to the given file, and tests
     * all the messages therein (if a directory, processes all contained
     * files recursively).
     */
    public HL7Exception[] testAll(File source) throws IOException {
        List<HL7Exception> list = new ArrayList<HL7Exception>();
        System.out.println("Testing " + source.getPath());
        if (source.isDirectory()) {
            File[] contents = source.listFiles();
            for (int i = 0; i < contents.length; i++) {
                HL7Exception[] exceptions = testAll(contents[i]);
                list.addAll(Arrays.asList(exceptions));
            }
        } else if (source.isFile()) {          
            FileReader in = new FileReader(source);
            setSource(in);
            setContext(source.getAbsolutePath());
            HL7Exception[] exceptions = testAll();
            list.addAll(Arrays.asList(exceptions));
        } else {
            System.out.println("Warning: " + source.getPath() + " is not a normal file");
        }
        return list.toArray(new HL7Exception[0]);
    }
    
    /**
     * Tests all remaining messages available from the currrent source.
     */
    public HL7Exception[] testAll() throws IOException {
    	List<HL7Exception> list = new ArrayList<HL7Exception>();

        String message = null;
        while ((message = getNextMessage()).length() > 0) {
            HL7Exception e = parsesCorrectly(this.context, message);
            if (e != null) list.add(e);
        }
        
        return list.toArray(new HL7Exception[0]);
    }
    
    /**
     * Retrieves the next message (setSource() must be called first).  The next message
     * is interpreted as everything up to the next blank line, not including
     * C or C++ style comments (or blank lines themselves).  An empty string
     * indicates that there are no more messages.
     */
    public String getNextMessage() throws IOException {
        if (this.source == null) throw new IOException("Message source is null -- call setSource() first");
        
        StringBuffer message = new StringBuffer();
        boolean started = false; //got at least one non-blank line
        boolean finished = false; //got a blank line after started, or end of stream
        while (!finished) {
            String line = this.source.readLine();
            if (line == null || (started && line.trim().length() == 0)) {
                finished = true;
            } else {
                if (line.trim().length() > 0) {
                    started = true;
                    message.append(line);
                    message.append("\r");
                }
            }
        }
        if (message.toString().trim().length() == 0) {
            return "";
        } else {
            return message.toString(); // can't trim by default (will omit final end-segment)
        }
    }
    
    /**
     * Command line tool for testing messages in files.
     */
    public static void main(String args[]) {
        if (args.length != 1
        || args[0].equalsIgnoreCase("-?")
        || args[0].equalsIgnoreCase("-h")
        || args[0].equalsIgnoreCase("-help")) {
            System.out.println("USAGE:");
            System.out.println("  ParseTester <source>");
            System.out.println();
            System.out.println("  <source> must be either a file containing HL7 messages or a directory containing such files");
            System.out.println();
            System.out.println("Notes:");
            System.out.println(" - Messages can be XML or ER7 encoded. ");
            System.out.println(" - If there are multiple messages in a file they must be delimited by blank lines");
            System.out.println(" - C and C++ style comments are skipped");
            
        } else {
            try {                
                System.out.println("Testing ... ");
                File source = new File(args[0]);
                ParseTester tester = new ParseTester();
                HL7Exception[] exceptions = tester.testAll(source);
                if (exceptions.length > 0) System.out.println("Parsing problems with tested messages: ");
                for (int i = 0; i < exceptions.length; i++) {
                    System.out.println("PROBLEM #" + (i+1));
                    System.out.println(exceptions[i].getMessage());
                }
            } catch (IOException e) {
                System.out.println("Testing failed to complete because of a problem reading source file(s) ... \r\n");
                e.printStackTrace();
            }
        }
    }
    
    /**
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
            return super.read();            
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
