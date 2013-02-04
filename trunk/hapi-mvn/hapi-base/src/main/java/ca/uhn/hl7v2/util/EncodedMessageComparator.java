package ca.uhn.hl7v2.util;

import java.util.regex.Pattern;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.GenericParser;

/**
 * Tools for testing message strings for semantic equivalence without assuming the correctness
 * of parsers.  
 * @author Bryan Tripp
 */
public class EncodedMessageComparator {
    
    static final GenericParser parser = new GenericParser();  
    
    /**
     * Returns a "standardized" equivalent of the given message string.  For delimited
     * messages, the returned value is the shortest string that has an equivalent
     * meaning in HL7.  For XML-encoded messages, the returned value is equivalent XML output
     * using a standard pretty-print format.  An automatic determination is made about whether 
     * the given string is XML or ER7 (i.e. traditionally) encoded.
     * @param message an XML-encoded or ER7-encoded message string
     */
    public static String standardize(String message) throws SAXException {
        String result = null;
        String encoding = parser.getEncoding(message);
        if (encoding.equals("XML")) {
            result = standardizeXML(message);
        } else {
            result = standardizeER7(message);
        }
        return result;
    }
    
    /**
     * Returns the shortest string that is semantically equivalent to a given ER7-encoded 
     * message string.
     */
    public static String standardizeER7(String message) {
        
        //make delimiter sequences (must quote with \ if not alphanumeric; can't otherwise because of regexp rules)
        char fieldDelimChar = message.charAt(3);
        String fieldDelim = String.valueOf(fieldDelimChar);
        if (!Character.isLetterOrDigit(fieldDelimChar)) fieldDelim = "\\" + fieldDelimChar;
        
        char compSepChar = message.charAt(4);
        String compSep = String.valueOf(compSepChar);
        if (!Character.isLetterOrDigit(compSepChar)) compSep = "\\" + compSepChar;
        
        char repSepChar = message.charAt(5);
        String repSep = String.valueOf(repSepChar);
        if (!Character.isLetterOrDigit(repSepChar)) repSep = "\\" + repSepChar;
        
        char subSepChar = message.charAt(7);
        String subSep = String.valueOf(subSepChar);
        if (!Character.isLetterOrDigit(subSepChar)) subSep = "\\" + subSepChar;
        
        //char space = ' ';
        
        /* Things to strip (cumulative):
         *  - all delimiters and repetition separators before end line (i.e. end segment)
         *  - repetition separators, comp and subcomp delims before new field
         *  - subcomponent delimiters before new component
         */
        Pattern endSegment = Pattern.compile("[" + fieldDelim + compSep + repSep + subSep + "]*[\n\r]+");
        message = endSegment.matcher(message).replaceAll("\r");
        
        Pattern endField = Pattern.compile("[" + repSep + compSep + subSep + "]*" + fieldDelim);
        message = endField.matcher(message).replaceAll(String.valueOf(fieldDelim));
        
        Pattern endComp = Pattern.compile("[" + subSep + "]*" + compSep);
        message = endComp.matcher(message).replaceAll(String.valueOf(compSep));
        
        //Pattern endSub = Pattern.compile("[ ]*" + subSep);
        //message = endSub.matcher(message).replaceAll(String.valueOf(subSep));
        
        //handle special case of subcomp delim in encoding characters
        message = message.substring(0, 7) + subSepChar + message.substring(7);
        
        return message;
    }
    
    /**
     * Returns a semantic equivalent of a given XML-encoded message in a default format.
     * Attributes, comments, and processing instructions are not considered to change the 
     * HL7 meaning of the message, and are removed in the standardized representation.    
     */
    public static String standardizeXML(String message) throws SAXException {
        try {
        	Document doc = XMLUtils.parse(message);
            clean(doc.getDocumentElement());
            return XMLUtils.serialize(doc, true);
        } catch (Exception e) {
            throw new RuntimeException("Exception while standardizing XML ", e);
        }

    }
    
    /** Removes attributes, comments, and processing instructions. */
    private static void clean(Element elem) {
        NodeList children = elem.getChildNodes();        
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.PROCESSING_INSTRUCTION_NODE 
                || child.getNodeType() == Node.COMMENT_NODE)
            {
				elem.removeChild(child);
            } else if (child.getNodeType() == Node.ELEMENT_NODE) {
                clean((Element) child);
            }
        }
        
        NamedNodeMap attributes = elem.getAttributes();
        //get names
        String[] names = new String[attributes.getLength()];
        for (int i = 0; i < names.length; i++) {
            names[i] = attributes.item(i).getNodeName();
        }
        //remove by name
        for (int i = 0; i < names.length; i++) {
            attributes.removeNamedItem(names[i]);
        }

    }
    
    /**
     * <p>Compares two HL7 messages to see if they are equivalent (in terms of their  
     * HL7 meaning).  Semantically irrelevant differences (e.g. spaces in an XML tag; 
     * extra field delimiters at the end of a segment; XML vs. ER7 encoding; XML attributes)
     * are ignored. This check is performed without assuming the correctness of the HAPI parsers, 
     * and can therefore be used to test them.  This is done by parsing a message, encoding it
     * again, and comparing the result with this original.  </p>
     * <p>If one message is in XML and the other in ER7, the former is converted to ER7 to 
     * perform the comparison.  This process relies on the HAPI parsers.  However, the 
     * parsed message is first encoded as XML and compared to the original, so that the 
     * integrity of the parser can be verified.  An exception is thrown if this comparison 
     * is unsuccessful.  </p>
     * @return true if given messages are semantically equivalent 
     */
    public static boolean equivalent(String message1, String message2) throws HL7Exception {
    	Pair<String> messages = standardize(message1, message2);
        return messages.getValue1().equals(messages.getValue2());
    }
    
    static Pair<String> standardize(String message1, String message2) throws HL7Exception {
        String encoding1 = parser.getEncoding(message1);
        String encoding2 = parser.getEncoding(message2);
        
        if (!encoding1.equals(encoding2)) {
            if (encoding1.equals("XML")) {
                message1 = safeER7Conversion(message1);
            } else {
                message2 = safeER7Conversion(message2);
            }
        }
        
        String std1, std2;
        try {
            std1 = standardize(message1);
            std2 = standardize(message2);
        } catch (SAXException e) {
            throw new HL7Exception("Equivalence check failed due to SAXException: " + e.getMessage());
        }
        
        return new Pair<String>(std1, std2);
	}

	/** 
     * Converts XML message to ER7, first checking integrity of parse and throwing 
     * an exception if parse not correct
     */
    static String safeER7Conversion(String xmlMessage) throws HL7Exception {
        Message m = parser.parse(xmlMessage);

        String check = parser.encode(m, "XML");
        if (!equivalent(xmlMessage, check)) {
            throw new HL7Exception("Parsed and encoded message not equivalent to original (possibilities: invalid message, bug in parser)");
        }
        
        return parser.encode(m, "VB");        
    }
   

    
}
