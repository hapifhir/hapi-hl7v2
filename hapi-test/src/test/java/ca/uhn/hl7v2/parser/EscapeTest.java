package ca.uhn.hl7v2.parser;

import junit.framework.*;
import java.io.*;

/**
 * JUnit test cases for Escape.  
 * @author bryan
 */
public class EscapeTest extends TestCase {
    
    private EncodingCharacters enc;
    
    public EscapeTest(java.lang.String testName) {
        super(testName);
        this.enc = new EncodingCharacters('|', null);
    }
    
    public static void main(java.lang.String[] args) {
        junit.textui.TestRunner.run(suite());
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite(EscapeTest.class);
        return suite;
    }
    
    public void testUnescape() throws Exception {
        String uu = getUuencodedEscapedString();
        String result = Escape.unescape(uu, enc); 
        //System.out.println(uu);
        //System.out.println(result);
        //BufferedWriter out = new BufferedWriter(new FileWriter("c:/hapi/foo.txt"));
        //out.write(result);
        //out.close();
    }
    
    /** 
     * Loads an escaped, uuencoded string from a file -- this is real data
     * provided by Mark Lee of Skeva Tech.  
     */
    private String getUuencodedEscapedString() throws IOException {
        ClassLoader loader = this.getClass().getClassLoader();
        InputStream inStream = loader.getResourceAsStream("ca/uhn/hl7v2/parser/uuencoded_escaped.txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(inStream));
        String line = null;
        StringBuffer content = new StringBuffer();
        while ( (line = in.readLine()) != null) {
            content.append(line);
        }
        in.close();
        return content.toString();
    }
    
    /** 
     * Loads a uuencoded string from a file (not escaped) -- this is real data
     * provided by Mark Lee of Skeva Tech.  
     */
    private String getUuencodedString() throws IOException {
        ClassLoader loader = this.getClass().getClassLoader();
        InputStream inStream = loader.getResourceAsStream("ca/uhn/hl7v2/parser/uuencoded.txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(inStream));
        String line = null;
        StringBuffer content = new StringBuffer();
        while ( (line = in.readLine()) != null) {
            content.append(line);
        }
        in.close();
        return content.toString();
    }
    
}
