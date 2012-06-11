/**
The contents of this file are subject to the Mozilla Public License Version 1.1
(the "License"); you may not use this file except in compliance with the License.
You may obtain a copy of the License at http://www.mozilla.org/MPL/
Software distributed under the License is distributed on an "AS IS" basis,
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
specific language governing rights and limitations under the License.

The Initial Developer of the Original Code is University Health Network. Copyright (C)
2001.  All Rights Reserved.

Contributor(s): ______________________________________.

Alternatively, the contents of this file may be used under the terms of the
GNU General Public License (the  �GPL�), in which case the provisions of the GPL are
applicable instead of those above.  If you wish to allow use of your version of this
file only under the terms of the GPL and not to allow others to use your version
of this file under the MPL, indicate your decision by deleting  the provisions above
and replace  them with the notice and other provisions required by the GPL License.
If you do not delete the provisions above, a recipient may use your version of
this file under either the MPL or the GPL.

*/
package ca.uhn.hl7v2.parser;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Structure;

/**
 * <p>A default XMLParser.  This class assigns segment elements (in an XML-encoded message) 
 * to Segment objects (in a Message object) using the name of a segment and the names 
 * of any groups in which the segment is nested.  The names of group classes must correspond
 * to the names of group elements (they must be identical except that a dot in the element 
 * name, following the message name, is replaced with an underscore, in order to consitute a 
 * valid class name). </p>
 * <p>At the time of writing, the group names in the XML spec are changing.  Many of the group 
 * names have been automatically generated based on the group contents.  However, these automatic 
 * names are gradually being replaced with manually assigned names.  This process is expected to 
 * be complete by November 2002.  As a result, mismatches are likely.  Messages could be  
 * transformed prior to parsing (using XSLT) as a work-around.  Alternatively the group class names 
 * could be changed to reflect updates in the XML spec.  Ultimately, HAPI group classes will be 
 * changed to correspond with the official group names, once these are all assigned.  </p>
 * @author Bryan Tripp
 */
public class DefaultXMLParser extends XMLParser {

    private static final Logger log = LoggerFactory.getLogger(DefaultXMLParser.class);

    private static final Set<String> ourForceGroupNames;
    
    static {
    	ourForceGroupNames = new HashSet<String>();
    	ourForceGroupNames.add("DIET");
    }
    
    /** Creates a new instance of DefaultXMLParser */
    public DefaultXMLParser() {
    	super();
    }

    /** 
     * Creates a new instance of DefaultXMLParser 
     *  
     * @param theFactory custom factory to use for model class lookup 
     */
    public DefaultXMLParser(ModelClassFactory theFactory) {
    	super(theFactory);
    }
    
    /**
     * <p>Creates an XML Document that corresponds to the given Message object. </p>
     * <p>If you are implementing this method, you should create an XML Document, and insert XML Elements
     * into it that correspond to the groups and segments that belong to the message type that your subclass
     * of XMLParser supports.  Then, for each segment in the message, call the method
     * <code>encode(Segment segmentObject, Element segmentElement)</code> using the Element for
     * that segment and the corresponding Segment object from the given Message.</p>
     */
    public Document encodeDocument(Message source) throws HL7Exception {
        String messageClassName = source.getClass().getName();
        String messageName = messageClassName.substring(messageClassName.lastIndexOf('.') + 1);
        org.w3c.dom.Document doc = null;
        try {
            doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element root = doc.createElement(messageName);
            doc.appendChild(root);
        }
        catch (Exception e) {
            throw new HL7Exception(
                "Can't create XML document - " + e.getClass().getName(),
                HL7Exception.APPLICATION_INTERNAL_ERROR,
                e);
        }
        encode(source, doc.getDocumentElement());
        return doc;
    }

    /**
     * Copies data from a group object into the corresponding group element, creating any 
     * necessary child nodes.  
     */
    private void encode(ca.uhn.hl7v2.model.Group groupObject, org.w3c.dom.Element groupElement) throws HL7Exception {
        String[] childNames = groupObject.getNames();
        String messageName = groupObject.getMessage().getName();
        
        try {
            for (int i = 0; i < childNames.length; i++) {
                Structure[] reps = groupObject.getAll(childNames[i]);
                for (int j = 0; j < reps.length; j++) {
                    String elementName = makeGroupElementName(messageName, childNames[i]);
					Element childElement;
					try {
						childElement = groupElement.getOwnerDocument().createElement(elementName);
			        } catch (DOMException e) {
			            throw new HL7Exception(
			                "Can't encode element " + elementName + " in group " + groupObject.getClass().getName(),
			                HL7Exception.APPLICATION_INTERNAL_ERROR,
			                e);
			        }
                    groupElement.appendChild(childElement);
                    if (reps[j] instanceof Group) {
                        encode((Group) reps[j], childElement);
                    }
                    else if (reps[j] instanceof Segment) {
                        encode((Segment) reps[j], childElement);
                    }
                }
            }
        } catch (DOMException e) {
            throw new HL7Exception(
                "Can't encode group " + groupObject.getClass().getName(),
                HL7Exception.APPLICATION_INTERNAL_ERROR,
                e);
        }
    }

    /**
     * <p>Creates and populates a Message object from an XML Document that contains an XML-encoded HL7 message.</p>
     * <p>The easiest way to implement this method for a particular message structure is as follows:
     * <ol><li>Create an instance of the Message type you are going to handle with your subclass
     * of XMLParser</li>
     * <li>Go through the given Document and find the Elements that represent the top level of
     * each message segment. </li>
     * <li>For each of these segments, call <code>parse(Segment segmentObject, Element segmentElement)</code>,
     * providing the appropriate Segment from your Message object, and the corresponding Element.</li></ol>
     * At the end of this process, your Message object should be populated with data from the XML
     * Document.</p>
     * @throws HL7Exception if the message is not correctly formatted.
     * @throws EncodingNotSupportedException if the message encoded
     *     is not supported by this parser.
     */
    public Message parseDocument(org.w3c.dom.Document XMLMessage, String version) throws HL7Exception {
        String messageName = XMLMessage.getDocumentElement().getTagName();
        Message message = instantiateMessage(messageName, version, true);
        parse(message, XMLMessage.getDocumentElement());
        return message;
    }

    /**
     * Populates the given group object with data from the given group element, ignoring 
     * any unrecognized nodes.  
     */
    private void parse(ca.uhn.hl7v2.model.Group groupObject, org.w3c.dom.Element groupElement) throws HL7Exception {
        String[] childNames = groupObject.getNames();
        String messageName = groupObject.getMessage().getName();
        
        NodeList allChildNodes = groupElement.getChildNodes();
        List<String> unparsedElementList = new ArrayList<String>();
        for (int i = 0; i < allChildNodes.getLength(); i++) {
            Node node = allChildNodes.item(i);
            String name = node.getNodeName();
            if (node.getNodeType() == Node.ELEMENT_NODE && !unparsedElementList.contains(name)) {
                unparsedElementList.add(name);                
            }
        }
        
        //we're not too fussy about order here (all occurrences get parsed as repetitions) ... 
        for (int i = 0; i < childNames.length; i++) {
            unparsedElementList.remove(childNames[i]);
            
            // 4 char segment names are second occurrences of a segment within a single message
            // structure. e.g. the second PID segment in an A17 patient swap message is known
            // to hapi's code represenation as PID2
            if (childNames[i].length() != 4) {   
            	parseReps(groupElement, groupObject, messageName, childNames[i], childNames[i]);
            } else {
            	log.debug("Skipping rep segment: {}", childNames[i]);
            }
        }
        
        for (int i = 0; i < unparsedElementList.size(); i++) {
            String segName = (String) unparsedElementList.get(i);            
            String segIndexName = groupObject.addNonstandardSegment(segName);
            parseReps(groupElement, groupObject, messageName, segName, segIndexName);
        }
    }
    
    //param childIndexName may have an integer on the end if >1 sibling with same name (e.g. NTE2) 
    private void parseReps(Element groupElement, Group groupObject, 
            String messageName, String childName, String childIndexName) throws HL7Exception {
        
        List<Element> reps = getChildElementsByTagName(groupElement, makeGroupElementName(messageName, childName));
        log.debug("# of elements matching {}: {}", 
        		makeGroupElementName(messageName, childName), reps.size());

		if (groupObject.isRepeating(childIndexName)) {
			for (int i = 0; i < reps.size(); i++) {
				parseRep(reps.get(i), groupObject.get(childIndexName, i));
			}        			        
		} else {
			if (reps.size() > 0) {
				parseRep(reps.get(0), groupObject.get(childIndexName, 0));				
			}

//			if (reps.size() > 1) {			
//				String newIndexName = groupObject.addNonstandardSegment(childName);			
//				for (int i = 1; i < reps.size(); i++) {
//					parseRep((Element) reps.get(i), groupObject.get(newIndexName, i-1));
//				}        			        			
//			}
			if (reps.size() > 1) {
				String newIndexName = "";
				int i=1;
				try	{
					for (i = 1; i < reps.size(); i++) {
						newIndexName = childName+(i+1);
						Structure st = groupObject.get(newIndexName);
						parseRep(reps.get(i), st);
					}
				} catch(Throwable t) {
					log.info("Issue Parsing: " + t);
					newIndexName = groupObject.addNonstandardSegment(childName);
					for (int j = i; j < reps.size(); j++) {
						parseRep(reps.get(j), groupObject.get(newIndexName, j-i));
					}
				}
			}
			
		}
    }
    
    private void parseRep(Element theElem, Structure theObj) throws HL7Exception {
		if (theObj instanceof Group) {
			parse((Group) theObj, theElem);
		}
		else if (theObj instanceof Segment) {
			parse((Segment) theObj, theElem);
		}                
		log.debug("Parsed element: {}", theElem.getNodeName());    	
    }
    
    //includes direct children only
    private List<Element> getChildElementsByTagName(Element theElement, String theName) {
    	List<Element> result = new ArrayList<Element>(10);
    	NodeList children = theElement.getChildNodes();
    	
    	for (int i = 0; i < children.getLength(); i++) {
    		Node child = children.item(i);
    		if (child.getNodeType() == Node.ELEMENT_NODE && child.getNodeName().equals(theName)) {
    			result.add((Element)child);
    		}
    	}
    	
    	return result; 
    }
    
    /** 
     * Given the name of a group element in an XML message, returns the corresponding 
     * group class name.  This name is identical except in order to be a valid class 
     * name, the dot character immediately following the message name is replaced with 
     * an underscore.  For example, there is a group element called ADT_A01.INSURANCE and the 
     * corresponding group Class is called ADT_A01_INSURANCE. 
     */
//    protected static String makeGroupClassName(String elementName) {
//        return elementName.replace('.', '_');
//    }

    /** 
     * Given the name of a message and a Group class, returns the corresponding group element name in an 
     * XML-encoded message.  This is the message name and group name separated by a dot. For example, 
     * ADT_A01.INSURANCE.
     * 
     * If it looks like a segment name (i.e. has 3 characters), no change is made. 
     */
    protected static String makeGroupElementName(String messageName, String className) {
        String ret = null;
        
        if (className.length() > 4 || ourForceGroupNames.contains(className)) {
            StringBuilder elementName = new StringBuilder();
            elementName.append(messageName);
            elementName.append('.');
            elementName.append(className);
            ret = elementName.toString();
        } else if (className.length() == 4) {
            // It is not clear why this case is needed.. We should figure out
        	// why it was added, since removing it or optimizing its use would
        	// prevent the need for "ourForGroupNames" above
        	ret = className.substring(0,3);
        } else {
            ret = className;
        }
        
        return ret;
    }

    /** Test harness */
    public static void main(String args[]) {
        if (args.length != 1) {
            System.out.println("Usage: DefaultXMLParser pipe_encoded_file");
            System.exit(1);
        }

        //read and parse message from file 
        try {
            File messageFile = new File(args[0]);
            long fileLength = messageFile.length();
            FileReader r = new FileReader(messageFile);
            char[] cbuf = new char[(int) fileLength];
            System.out.println("Reading message file ... " + r.read(cbuf) + " of " + fileLength + " chars");
            r.close();
            String messString = String.valueOf(cbuf);

            Parser inParser = null;
            Parser outParser = null;
            PipeParser pp = new PipeParser();
            ca.uhn.hl7v2.parser.XMLParser xp = new DefaultXMLParser();
            System.out.println("Encoding: " + pp.getEncoding(messString));
            if (pp.getEncoding(messString) != null) {
                inParser = pp;
                outParser = xp;
            }
            else if (xp.getEncoding(messString) != null) {
                inParser = xp;
                outParser = pp;
            }

            Message mess = inParser.parse(messString);
            System.out.println("Got message of type " + mess.getClass().getName());

            String otherEncoding = outParser.encode(mess);
            System.out.println(otherEncoding);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}
     */
	@Override
	public void parse(Message theMessage, String theString) throws HL7Exception {
		Document doc = parseStringIntoDocument(theString);
        parse(theMessage, doc.getDocumentElement());
	}


}
