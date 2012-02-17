/**
The contents of this file are subject to the Mozilla Public License Version 1.1
(the "License"); you may not use this file except in compliance with the License.
You may obtain a copy of the License at http://www.mozilla.org/MPL/
Software distributed under the License is distributed on an "AS IS" basis,
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
specific language governing rights and limitations under the License.

The Original Code is "GroupPointer.java".  Description:
"A GroupPointer is used when parsing traditionally encoded HL7 messages"

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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Primitive;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.util.Terser;

/**
 * This class has been deprecated and should not be used.
 * 
 * PipeParser has been optimized and is now roughly 20% faster than FastParser (see
 * FastParserTest for a test of this) 
 *    
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.3 $ updated on $Date: 2009-10-03 15:25:46 $ by $Author: jamesagnew $
 * 
 * @deprecated
 */
public class FastParser extends Parser {

    private static final Logger ourLog = LoggerFactory.getLogger(FastParser.class);
    
    private static char ourSegmentSeparator = '\r';
    private Map<Object, StructRef> myEventGuideMap;
    private PipeParser myPipeParser;
    
    /**
     * @param theEventGuideMap a map with keys in the form "type^event" (like MSH-9 
     *      components 1 and 2).  Values are corresponding parsing guides for those events.  
     *      A parsing guide is a group of StructRef that identify which segments to parse, 
     *      the relationships between them, and where to find them in a message hierarchy.
     *      The value in the map is the RootRef of the message root.  It must return the 
     *      StructRef for the MSH segment from getSuccessor("MSH").  References to other 
     *      segments can be included as needed.   
     */
    public FastParser(Map<Object, StructRef> theEventGuideMap) {
    	this(null, theEventGuideMap);
    }

    /**
     * @param theFactory custom factory to use for model class lookup 
     * @param theEventGuideMap a map with keys in the form "type^event" (like MSH-9 
     *      components 1 and 2).  Values are corresponding parsing guides for those events.  
     *      A parsing guide is a group of StructRef that identify which segments to parse, 
     *      the relationships between them, and where to find them in a message hierarchy.
     *      The value in the map is the RootRef of the message root.  It must return the 
     *      StructRef for the MSH segment from getSuccessor("MSH").  References to other 
     *      segments can be included as needed.   
     */
    public FastParser(ModelClassFactory theFactory, Map<Object, StructRef> theEventGuideMap) {
    	super(theFactory);
        myEventGuideMap = theEventGuideMap;
        myPipeParser = new PipeParser();
    }
    
    /**
     * Loads a parsing guide map (as required for FastParser instantiation).  The URL should 
     * point to a file with one or more guides in sections delimited by blank lines.  Within 
     * a section, the first line must contain an event name of the for "type^event".  Subsequent 
     * lines define the parsed parts of messages with that event.  Each line begins with either 
     * a segment name or "{" (indicating group start) or "}" (indicating group end).  Group  
     * start lines then have whitespace and a Terser path to the group (relative to the closest 
     * ancestor group listed in the parsin guide).  Segment lines then have whitespace and a 
     * relative Terser path to the segment, followed by a colon and a comma-delimited list of field 
     * numbers, which indicates which fields for that segment are to be parsed.  Within Terser
     * paths, repetition numbers must be replaced with asterisks. An example follows: 
     * 
     * ORU^R01
     * MSH MSH:9,12
     * { ORU_R01_PIDNTEPV1ORCOBRNTEOBXNTE(*)
     *     { ORU_R01_PIDNTEPV1
     *         PID PID:3-5
     *     }
     *     { ORU_R01_ORCOBRNTEOBXNTE(*)
     *         { ORU_R01_OBXNTE(*)
     *             OBX OBX:2,5
     *         }
     *     }
     * }
     * 
     * ADT^A01
     * MSH MSH:9,12
     * PID PID:3
     * PV1 PV1:7-9
     * 
     * @param theMapURL an URL to a file of the form desribed above
     * @return the corresponding Map 
     */
    public static Map<Object, StructRef> loadEventGuideMap(URL theMapURL) throws HL7Exception {
        Map<Object, StructRef> result = new HashMap<Object, StructRef>();
        
        try {
            URLConnection conn = theMapURL.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            
            String eventName = null;
            StringBuffer spec = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line.length() == 0) {
                    finish(eventName, spec, result);
                    eventName = null;
                    spec = new StringBuffer();
                } else {
                    if (eventName == null) {
                        eventName = line;
                    } else {
                        spec.append(line + "\r");
                    }
                }
            }
            reader.close();            
            finish(eventName, spec, result);
        } catch (IOException e) {
            throw new HL7Exception(e);
        }
        
        return result;
    }
    
    private static void finish(String theEventName, StringBuffer theSpec, Map<Object, StructRef> theMap) {
        if (theEventName != null) {
            RootRef root = parseGuide(theSpec.toString());
            theMap.put(theEventName, root);
        }        
    }
    
    private static RootRef parseGuide(String theSpec) {
        StringTokenizer lines = new StringTokenizer(theSpec, "\r", false);
        RootRef result = new RootRef();
        Stack<StructRef> ancestry = new Stack<StructRef>();
        ancestry.push(result);
        Map<Object, StructRef> successors = new HashMap<Object, StructRef>();
        
        StructRef previous = result;
        while (lines.hasMoreTokens()) {
            String line = lines.nextToken();
            StringTokenizer parts = new StringTokenizer(line, "\t ", false);
            String segName = parts.nextToken();
            String path = parts.hasMoreTokens() ? parts.nextToken() : "";
            parts = new StringTokenizer(path, ":", false);
            path = parts.hasMoreTokens() ? parts.nextToken() : null;
            
            int[] fields = getFieldList(parts.hasMoreTokens() ? parts.nextToken() : ""); 
            
            if (segName.equals("}")) {                
                StructRef parent = (StructRef) ancestry.pop();
                if (parent.getChildName() != null && parent.getRelativePath().indexOf('*') >= 0) { //repeating group
                    previous.setSuccessor(parent.getChildName(), parent);                    
                }
            } else {
                boolean isSegment = !(segName.equals("{"));
                StructRef ref = new StructRef((StructRef) ancestry.peek(), path, isSegment, fields);
                if (isSegment) {
                    previous.setSuccessor(segName, ref);
                    if (path.indexOf('*') >= 0) ref.setSuccessor(segName, ref);
                    setGroupSuccessors(successors, segName);
                } else {
                    successors.put(previous, ref);
                }
                if (!isSegment) ancestry.push(ref);
                previous = ref;
            }
        }
        
        return result;
    }
    
    private static void setGroupSuccessors(Map<Object, StructRef> theSuccessors, String theSegName) {
        for (Iterator<Object> it = theSuccessors.keySet().iterator(); it.hasNext(); ) {
            StructRef from = (StructRef) it.next();
            StructRef to = (StructRef) theSuccessors.get(from);
            from.setSuccessor(theSegName, to);
        }
        theSuccessors.clear();
    }
    
    private static int[] getFieldList(String theSpec) {
        StringTokenizer tok = new StringTokenizer(theSpec, ",", false); 
        List<Integer> fieldList = new ArrayList<Integer>(30);
        while (tok.hasMoreTokens()) {
            String token = tok.nextToken();
            int index = token.indexOf('-');
            if (index >= 0) { //it's a range
                int start = Integer.parseInt(token.substring(0, index));
                int end = Integer.parseInt(token.substring(index+1));
                for (int i = start; i <= end; i++) {
                    fieldList.add(new Integer(i));
                }
            } else {
                fieldList.add(Integer.valueOf(token));
            }
        }
        
        int[] result = new int[fieldList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = ((Integer) fieldList.get(i)).intValue();
        }
        
        return result;
    }

    /** 
     * @see ca.uhn.hl7v2.parser.Parser#getEncoding(java.lang.String)
     */
    public String getEncoding(String message) {
        return myPipeParser.getEncoding(message);
    }

    /** 
     * @see ca.uhn.hl7v2.parser.Parser#supportsEncoding(java.lang.String)
     */
    public boolean supportsEncoding(String encoding) {
        return myPipeParser.supportsEncoding(encoding);
    }
    
    /**
     * @return the preferred encoding of this Parser
     */
    public String getDefaultEncoding() {
        return "VB";
    }    

    /** 
     * @see ca.uhn.hl7v2.parser.Parser#doParse(java.lang.String, java.lang.String)
     */
    protected Message doParse(String message, String version) throws HL7Exception, EncodingNotSupportedException {
        Message result = null;
        
        char fieldSep = message.charAt(3);
        EncodingCharacters ec = new EncodingCharacters(fieldSep, message.substring(4, 8));
        
        StringTokenizer tok = new StringTokenizer(message.substring(4), 
                String.valueOf(new char[]{fieldSep, ourSegmentSeparator}), true);
        
        String[] mshFields = getMSHFields(tok, fieldSep);
        Object[] structure = getStructure(mshFields[8], ec.getComponentSeparator());
        
        StructRef root = (StructRef) myEventGuideMap.get(structure[0]);
        if (root == null) {
            ourLog.debug("FastParser delegating to PipeParser because no metadata available for event {}", 
                    structure[0]);
            result = myPipeParser.parse(message);
        } else {
//            int csIndex = mshFields[11].indexOf(ec.getComponentSeparator());
            result = instantiateMessage((String) structure[1], version, ((Boolean) structure[2]).booleanValue());
                
            StructRef mshRef = null;
            synchronized (root) {
                mshRef = root.getSuccessor("MSH");
                root.reset();
            }
            Segment msh = (Segment) result.get("MSH");
            for (int i = 0; i < mshRef.getFields().length; i++) {
                int fieldNum = mshRef.getFields()[i];
                parse(mshFields[fieldNum-1], msh, fieldNum, ec);
            }            
            
            parse(tok, result, root, ec);
        }
        
        return result;
    }
    
    private String[] getMSHFields(StringTokenizer tok, char fieldSep) {
        String[] result = new String[21];
        result[0] = String.valueOf(fieldSep);
        String token = null;
        int field = 1;
        while (tok.hasMoreTokens() && (token = tok.nextToken()).charAt(0) != ourSegmentSeparator) {
            if (token.charAt(0) == fieldSep) {
                field++;
            } else {
                result[field] = token;
            }
        } 
        return result;
    }
    
    private void parse(StringTokenizer tok, Message message, StructRef root, EncodingCharacters ec) 
            throws HL7Exception {
        
        Terser t = new Terser(message);
        
        synchronized (root) {
            StructRef ref = root.getSuccessor("MSH");            
            
            int field = 0;
            Segment segment = null;
            int[] fields = new int[0];
            
            while (tok.hasMoreTokens()) {
                String token = tok.nextToken();
                if (token.charAt(0) == ec.getFieldSeparator()) {
                    field++;
                } else if (token.charAt(0) == ourSegmentSeparator) {
                    field = 0;
                } else if (field == 0) {
                    StructRef newref = drill(ref, token);
                    if (newref == null) {
                        segment = null;
                        fields = new int[0];
                    } else {
                        ref = newref;
                        ourLog.debug("Parsing into segment {}", ref.getFullPath());
                        segment = t.getSegment(ref.getFullPath());
                        fields = ref.getFields();
                    }
                } else if (segment != null && Arrays.binarySearch(fields, field) >= 0) {
                    parse(token, segment, field, ec);
                }
            }
            root.reset();
        }        
    }
    
    //drill through groups to a segment 
    private StructRef drill(StructRef ref, String name) {
        ref = ref.getSuccessor(name);
        while (ref != null && !ref.isSegment()) {
            ref = ref.getSuccessor(name);
        }
        return ref;
    }
    
    private void parse(String field, Segment segment, int num, EncodingCharacters ec) throws HL7Exception {
        if (field != null) {
            int rep = 0;
            int component = 1;
            int subcomponent = 1;
            Type type = segment.getField(num, rep);
            
            String delim = String.valueOf(new char[]{ec.getRepetitionSeparator(), 
                    ec.getComponentSeparator(), ec.getSubcomponentSeparator()});
            for (StringTokenizer tok = new StringTokenizer(field, delim, true); tok.hasMoreTokens(); ) {
                String token = tok.nextToken();
                char c = token.charAt(0);
                if (c == ec.getRepetitionSeparator()) {
                    rep++;
                    component = 1;
                    subcomponent = 1;
                    type = segment.getField(num, rep);
                } else if (c == ec.getComponentSeparator()) {
                    component++;
                    subcomponent = 1;
                } else if (c == ec.getSubcomponentSeparator()) {
                    subcomponent++;
                } else {
                    Primitive p = Terser.getPrimitive(type, component, subcomponent);
                    p.setValue(token);
                }
            }               
        }
    }
    
    /**
     * @returns the message structure from MSH-9-3
     */
    private Object[] getStructure(String msh9, char compSep) throws HL7Exception {
        String structure = null;
        String event = null;
        
        String[] components = new String[3];
        StringTokenizer tok = new StringTokenizer(msh9, String.valueOf(compSep), true);
        for (int i = 0; tok.hasMoreTokens() && i < components.length; ) {
            String token = tok.nextToken();
            if (token.charAt(0) == compSep) {
                i++;
            } else {
                components[i] = token;                
            }
        }

        boolean explicitlyDefined = (components[2] == null) ? false : true;

        if (explicitlyDefined) {
            structure = components[2];
        } else if (components[0] != null && components[0].equals("ACK")) {
            structure = "ACK";
        } else if (components[0] != null && components[1] != null) {
            structure = components[0] + "_" + components[1];
        } else {
            throw new HL7Exception("Can't determine message structure from MSH-9: " + msh9, 
                    HL7Exception.UNSUPPORTED_MESSAGE_TYPE);
        }
        
        if (components[1] == null) {
            event = components[0];
        } else {
            event = components[0] + "^" + components[1];
        }
        
        return new Object[] {event, structure, Boolean.valueOf(explicitlyDefined)};
    }
    

    /** 
     * @see ca.uhn.hl7v2.parser.Parser#encode(ca.uhn.hl7v2.model.Message, java.lang.String)
     */
    protected String doEncode(Message source, String encoding) throws HL7Exception,
            EncodingNotSupportedException {
        return myPipeParser.doEncode(source, encoding);
    }

    /** 
     * @see ca.uhn.hl7v2.parser.Parser#encode(ca.uhn.hl7v2.model.Message)
     */
    protected String doEncode(Message source) throws HL7Exception {
        return myPipeParser.doEncode(source);
    }

    /** 
     * @see ca.uhn.hl7v2.parser.Parser#getCriticalResponseData(java.lang.String)
     */
    public Segment getCriticalResponseData(String message) throws HL7Exception {
        return myPipeParser.getCriticalResponseData(message);
    }

    /** 
     * @see ca.uhn.hl7v2.parser.Parser#getAckID(java.lang.String)
     */
    public String getAckID(String message) {
        return myPipeParser.getAckID(message);
    }

    /** 
     * @see ca.uhn.hl7v2.parser.Parser#getVersion(java.lang.String)
     */
    public String getVersion(String message) throws HL7Exception {
        return myPipeParser.getVersion(message);
    }

    /**
     * Not supported, throws UnsupportedOperationException
     *
     * @throws UnsupportedOperationException
     */
    @Override
    public String doEncode(Segment structure, EncodingCharacters encodingCharacters) throws HL7Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Not supported, throws UnsupportedOperationException
     *
     * @throws UnsupportedOperationException
     */
    @Override
    public String doEncode(Type type, EncodingCharacters encodingCharacters) throws HL7Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Not supported, throws UnsupportedOperationException
     *
     * @throws UnsupportedOperationException
     */
    @Override
    public void parse(Type type, String string, EncodingCharacters encodingCharacters) throws HL7Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Not supported, throws UnsupportedOperationException
     *
     * @throws UnsupportedOperationException
     */
    @Override
    public void parse(Segment segment, String string, EncodingCharacters encodingCharacters) throws HL7Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    /**
     * Not supported, throws UnsupportedOperationException
     *
     * @throws UnsupportedOperationException
     */
    @Override
    public void parse(Message message, String string) throws HL7Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Throws unsupported operation exception
     *
     * @throws Unsupported operation exception
     */
    @Override
	protected Message doParseForSpecificPackage(String theMessage, String theVersion, String thePackageName) throws HL7Exception, EncodingNotSupportedException {
        throw new UnsupportedOperationException("Not supported yet.");
	}
    
    /**
     * A pointer to a distinct segment or group position in a message.  
     *  
     * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
     * @version $Revision: 1.3 $ updated on $Date: 2009-10-03 15:25:46 $ by $Author: jamesagnew $
     */
    public static class StructRef {

        private StructRef myParent;
        private String myRelativePath;
        private Map<Object, StructRef> mySuccessors;
        private int myRep;
        private boolean mySegmentFlag;
        //private boolean myResettableFlag;
        private int[] myFields;
        private List<StructRef> myChildren;
        
        /**
         * @param theParent a StructRef for the parent Group of the referenced Structure
         * @param theRelativePath the relative (from the parent) Terser path to the referenced 
         *      structure.  If the structure repeats, the rep number should be replaced with "*"
         *      (it will be incremented as needed). 
         * @param isSegment true iff the referenced Structure is a Segment (rather than a Group)
         * @param theFields a list of fields to be parsed for this segment (null or empty for groups)
         */
        public StructRef(StructRef theParent, String theRelativePath, boolean isSegment, int[] theFields) {
            myParent = theParent;
            myChildren = new ArrayList<StructRef>();
            if (myParent != null) myParent.addChild(this);
            
            myRelativePath = theRelativePath;
            if (!myRelativePath.startsWith("/")) {
                myRelativePath = "/" + myRelativePath;
            }
            mySegmentFlag = isSegment;
            mySuccessors = new HashMap<Object, StructRef>();
            myRep = -1;
            if (mySegmentFlag) {
                myFields = theFields;
                Arrays.sort(myFields);                
            } else {
                myFields = new int[0];
            }
            //myResettableFlag = (myParent == null) ? true : false;
        }
        
        /**
         * Indicates an immediately subsequent structure in parsing order.  A Structure in a list 
         * should point to the next Structure in the list.  A Structure that repeats should point to 
         * itself.  A Structure at the end of a repeating Group should point to the Group. 
         * A Group should point to its first child.  
         * 
         * @param theName name of the next Segment in this direction (ie if the next structure is a group, 
         *      not that one)
         * @param theSuccessor the immediately next StructRef in that direction
         */
        public void setSuccessor(String theName, StructRef theSuccessor) {
            mySuccessors.put(theName, theSuccessor);
        }
        
        /**
         * @return full Terser path, including parent and repetition information.  
         */
        public String getFullPath() {
            return myParent.getFullPath() + myRelativePath.replaceAll("\\*", String.valueOf(myRep));
        }
        
        /**
         * @return relative Terser path as defined in constructor
         */
        public String getRelativePath() {
            return myRelativePath;
        }
        
        /**
         * @param theName name of a successor in parse order, as set in setSuccessor()
         * @return the StructRef under that name 
         */
        public StructRef getSuccessor(String theName) {
            StructRef ref = (StructRef) mySuccessors.get(theName);
            if (ref != null) {
                ref.next();
            } 
            return ref;
        }
        
        /**
         * @return name of first successor, if available and if this is not a segment reference, 
         *      otherwise null 
         */
        public String getChildName() {
            String result = null;
            if (!mySegmentFlag && !mySuccessors.isEmpty()) {
                result = (String) mySuccessors.keySet().iterator().next();                
            }
            return result;
        }
        
        /**
         * @return true iff referenced Structure is a Segment 
         */
        public boolean isSegment() {
            return mySegmentFlag;
        }
        
        /**
         * Increments the repetition number of the underlying Structure, which is used in getFullPath() 
         */
        private void next() {
            myRep++;
            resetChildren();
        }
        
        private void addChild(StructRef theChild) {
            if (!isSegment()) {
                myChildren.add(theChild);
            }
        }
        
        /**
         * Resets the StructRef to its starting state, before its first iteration, and resets 
         * its children as well.  
         */
        public void reset() {
            myRep = -1;
            resetChildren();
        }
        
        private void resetChildren() {
            for (int i = 0; i < myChildren.size(); i++) {
                StructRef child = (StructRef) myChildren.get(i);
                child.reset();
            }            
        }
        
        /**
         * @return an ordered list of fields to be parsed for this segment (empty if not a segment)
         */
        public int[] getFields() {
            return myFields;
        }
        
    }
    
    /**
     * A convenience StructRef that points to a message root.  
     * 
     * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
     * @version $Revision: 1.3 $ updated on $Date: 2009-10-03 15:25:46 $ by $Author: jamesagnew $
     */
    public static class RootRef extends StructRef {
        public RootRef() {
            super(null, "", false, null);
        }
        
        public String getFullPath() { 
            return "";
        }
    }

}
