/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "MinLowerLayerProtocol.java".  Description: 
"Implements the "Minimal Lower Layer Protocol" from the HL7 Implementation 
  Guide, Appendix C" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the "GPL"), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

*/

package ca.uhn.hl7v2.llp;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Implements the "Minimal Lower Layer Protocol" from the HL7 Implementation 
 * Guide, Appendix C.  In other words, provides a reader and a writer that can be 
 * used to communicate with a server that uses the minimal LLP.
 * 
 * @see MinLLPReader
 * @see MinLLPWriter 
 * @author Bryan Tripp
 */
public class MinLowerLayerProtocol extends LowerLayerProtocol {

	private Charset charset;

    /** 
     * Creates new MinLowerLayerProtocol 
     */
    public MinLowerLayerProtocol() {
    }
    
    /**
     * Creates an HL7Reader that implements message reading according to 
     * this protocol.  
     */
    public HL7Reader getReader(InputStream in) throws LLPException {
        try {
        	if (charset != null) {
        		return new MinLLPReader(in, charset);
        	} else {
        		return new MinLLPReader(in);
        	}
        } catch (IOException e) {
            throw new LLPException("Can't create MinLLPReader with the given input stream: " + e.getMessage(), e);
        }
    }
    
    /**
     * Creates an HL7Writer that implements message writing according to 
     * this protocol.  
     */
    public HL7Writer getWriter(OutputStream out) throws LLPException {
        try {
        	if (charset != null) {
        		return new MinLLPWriter(out, charset);
        	} else {
        		return new MinLLPWriter(out);
        	}
        } catch (IOException e) {
            throw new LLPException("Can't create MinLLPWriter with the given output stream: " + e.getMessage(), e);
        }
    }
    
    /**
     * Provides a charset to use for character encoding
     * @param theCharset The charset to use
     * @since 1.3
     */
	public void setCharset(Charset theCharset) {
		charset = theCharset;
	}

}
