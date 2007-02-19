/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "Escape.java".  Description: 
"Handles "escaping" and "unescaping" of text according to the HL7 escape sequence rules
   defined in section 2.10 of the standard (version 2.4)" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): Mark Lee (Skeva Technologies); Elmar Hinz 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  “GPL”), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 
*/

package ca.uhn.hl7v2.parser;

import java.util.*;

/**
 * Handles "escaping" and "unescaping" of text according to the HL7 escape sequence rules
 * defined in section 2.10 of the standard (version 2.4).  Currently, escape sequences for 
 * multiple character sets are unsupported.  The highlighting, hexademical, and locally 
 * defined escape sequences are also unsupported.  
 * @author Bryan Tripp
 */
public class Escape {
   
    private static HashMap variousEncChars = new HashMap(5);

    /** Creates a new instance of Escape */
    public Escape() {
    }
    
    public static String escape(String text, EncodingCharacters encChars) {
        StringBuffer result = new StringBuffer();
        int textLength = text.length();
        HashMap esc = getEscapeSequences(encChars);
        Set keys = esc.keySet();
	String escChar = String.valueOf(encChars.getEscapeCharacter());
	int position = 0;
	while(position < textLength){
	    Iterator it = keys.iterator();
	    boolean isReplaced = false;
	    while (it.hasNext() && !isReplaced) {
		String seq = (String)it.next();
		String val = (String)esc.get(seq);
		if(text.substring(position,position+1).equals(val)){
		    result.append(seq);
		    isReplaced = true;
		}
	    }
	    if(!isReplaced){
		result.append(text.substring(position,(position + 1)));
	    }
	    position++;
	}
        return result.toString();
    }

    public static String unescape(String text, EncodingCharacters encChars) {
        StringBuffer result = new StringBuffer();
        int textLength = text.length();
        HashMap esc = getEscapeSequences(encChars);
        Set keys = esc.keySet();
	String escChar = String.valueOf(encChars.getEscapeCharacter());
	int position = 0;
	while(position < textLength){
	    Iterator it = keys.iterator();
	    boolean isReplaced = false;
	    while (it.hasNext() && !isReplaced) {
		String seq = (String)it.next();
		String val = (String)esc.get(seq);
		int seqLength = seq.length();
		if(position + seqLength <= textLength){
		    if(text.substring(position, position + seqLength).equals(seq)){
			result.append(val);
			isReplaced = true;
			position = position + seq.length();
		    }
		}
	    }
	    if(!isReplaced){
		result.append(text.substring(position,(position + 1)));
		position++;
	    }
	}
        return result.toString();
    }

    /**
     * Applies escape sequences so that the given text can be safely transmitted 
     * in a delimited message.  A double escape character (e.g. \\) in the given 
     * text is not itself escaped (e.g. \E\\E\) but is instead translated into a 
     * single escape character for transmission (e.g. \).  This allows you to 
     * add escape sequences not handled by this method (e.g. to send \.br\ across
     * the wire you would set the text of a field to \\.br\\). 
     */

    /*
    public static String escape_old(String text, EncodingCharacters encChars) {
        String result = text;
        HashMap esc = getEscapeSequences(encChars);
        Set keys = esc.keySet();
        Iterator it = keys.iterator();

        //need to do the escape for the escape character first, and skip it in the loop
        result = escapeEscapeCharacters(result, encChars);
        String escChar = String.valueOf(encChars.getEscapeCharacter());
        while (it.hasNext()) {
            String seq = (String)it.next();
            String val = (String)esc.get(seq);
            if (!val.equals(escChar)) result = replace(result, val, seq); //don't escape the escape character here
        }
        return result;
    }
    */

    /**
     * Removes escape sequences, replacing them with the text they represent.  
     */
    /*
    public static String unescape_old(String text, EncodingCharacters encChars) {
        String result = text;
        HashMap esc = getEscapeSequences(encChars);
        Set keys = esc.keySet();
        Iterator it = keys.iterator();
        while (it.hasNext()) {
            String seq = (String)it.next();
            String val = (String)esc.get(seq);
            result = replace(result, seq, val);
        }
        return result;
    }
    */

    /**
     * Replaces single escape characters with the escape sequence, and double escape characters 
     * with single escape characters. 
     */
    /*
    private static String escapeEscapeCharacters(String text, EncodingCharacters encChars) {
        String result = text;
        StringBuffer escCharSeq = new StringBuffer();
        escCharSeq.append(encChars.getEscapeCharacter());
        escCharSeq.append('E');
        escCharSeq.append(encChars.getEscapeCharacter());
        String escChar = String.valueOf(encChars.getEscapeCharacter());
        result = replace(result, escChar, escCharSeq.toString());
        result = replace(result, escCharSeq.toString() + escCharSeq.toString(), escChar);
        return result;        
    }
    */
    
    /**
     * Replaces all occurences of the string "replace" with the string "with", in 
     * the string "originalText". 
     */
    /*
    private static String replace(String originalText, String replace, String with) {
        StringBuffer result = new StringBuffer();
        int replaceLength = replace.length();
        boolean done = false;
        int cursor = 0; 
        while (!done) {
            int nextPosition = originalText.indexOf(replace, cursor);
            if (nextPosition < 0) {
                done = true;
                result.append(originalText.substring(cursor));
                break;
            }
            result.append(originalText.substring(cursor, nextPosition));
            result.append(with);
            cursor = nextPosition + replaceLength;
        }
        return result.toString();
    }
    */
    
    /**
     * Returns a HashTable with escape sequences as keys, and corresponding 
     * Strings as values.  
     */
    private static HashMap getEscapeSequences(EncodingCharacters encChars) {
        //escape sequence strings must be assembled using the given escape character 
        
        //see if this has already been done for this set of encoding characters
        HashMap escapeSequences = null;
        Object o = variousEncChars.get(encChars);
        if (o == null) {
            //this means we haven't got the sequences for these encoding characters yet - let's make them
            escapeSequences = makeEscapeSequences(encChars);
            variousEncChars.put(encChars, escapeSequences);
        } else {
            //we already have escape sequences for these encoding characters
            escapeSequences = (HashMap)o;
        }
        return escapeSequences;            
    }

    /**
     * Constructs escape sequences using the given escape character - this should only 
     * be called by getEscapeCharacter(), which will cache the results for subsequent use.
     */
    private static HashMap makeEscapeSequences(EncodingCharacters ec) {
        HashMap seqs = new HashMap();
        char[] codes = {'F', 'S', 'T', 'R', 'E'}; 
        char[] values = {ec.getFieldSeparator(), ec.getComponentSeparator(), ec.getSubcomponentSeparator(), ec.getRepetitionSeparator(), ec.getEscapeCharacter()};
        for (int i = 0; i < codes.length; i++) {
            StringBuffer seq = new StringBuffer();
            seq.append(ec.getEscapeCharacter());
            seq.append(codes[i]);
            seq.append(ec.getEscapeCharacter());
            seqs.put(seq.toString(), String.valueOf(values[i]));
        }
        seqs.put("\\X000d\\", String.valueOf('\r'));
        return seqs;
    }
    
    /**
     * Test harness
     */
    public static void main(String args[]) {
	String testString = "foo$r$this is $ $p$test$r$r$ string";
        //System.out.println(testString);
        //System.out.println(replace(testString, "$r$", "***"));
        //System.out.println(replace(testString, "$", "+"));
        
        //test speed gain with cache
        int n = 100000;
        HashMap seqs;
        EncodingCharacters ec = new EncodingCharacters('|', "^~\\&");
        //warm up the JIT 
        for (int i = 0; i < n; i++) {
            seqs = makeEscapeSequences(ec);
        }
        for (int i = 0; i < n; i++) {
            seqs = getEscapeSequences(ec);
        }
        //time
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            seqs = makeEscapeSequences(ec);
        }
        System.out.println("Time to make " + n + " times: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            seqs = getEscapeSequences(ec);
        }
        System.out.println("Time to get " + n + " times: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            seqs = makeEscapeSequences(ec);
        }
        System.out.println("Time to make " + n + " times: " + (System.currentTimeMillis() - start));
        
        //test escape: 
        testString = "this | is ^ a field \\T\\ with & some ~ bad stuff \\T\\";
        System.out.println("Original:  " + testString);
        String escaped = escape(testString, ec);
        System.out.println("Escaped:   " + escaped);
        System.out.println("Unescaped: " + unescape(escaped, ec));
        
    }

}

