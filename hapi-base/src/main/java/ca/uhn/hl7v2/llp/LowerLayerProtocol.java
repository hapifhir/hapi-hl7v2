/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "LowerLayerProtocol.java".  Description: 
"Represents a particular "lower layer protocol" over which HL7 messages can be 
  sent" 

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

package ca.uhn.hl7v2.llp;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents a particular "lower layer protocol" over which HL7 messages can be 
 * sent.  An example is the "minimal lower layer protocol" defines in the HL7
 * implementation guide (appendix C) - this is implemented by the class 
 * MinLowerLayerProtocol.  Implementations should call the static method 
 * <code>logCharacterReceived()</code> when a character is read from a remote system.  
 * This method may or may not log receipt, as configured (see docs for this method).
 *
 * @author  Bryan Tripp
 */
public abstract class LowerLayerProtocol {

    private static final Logger log = LoggerFactory.getLogger(LowerLayerProtocol.class);
    protected Charset charset;

    /** 
     * Returns a particular implementation of LowerLayerProtocol.
     * 
     *  @deprecated as there is now the choice between {@link MinLowerLayerProtocol}
     *  and {@link ExtendedMinLowerLayerProtocol}.
     */
    public static LowerLayerProtocol makeLLP() {
        return new MinLowerLayerProtocol();
    }

    /**
     * Returns a particular implementation of LowerLayerProtocol
     * @param respectMSH18
     * @return LowerLayerProtocol implementation
     */
    public static LowerLayerProtocol makeLLP(boolean respectMSH18) {
        return new MinLowerLayerProtocol(respectMSH18);
    }
    
    /** 
     * Returns an HL7Reader that implements message reading according to 
     * this protocol.  
     */ 
    public abstract HL7Reader getReader(InputStream in) throws LLPException;
          
    /** 
     * Returns an HL7Writer that implements message writing according to 
     * this protocol.  
     */ 
    public abstract HL7Writer getWriter(OutputStream out) throws LLPException;
    
    /**
     * <p>
     * Logs the fact that a character has been received, if configured to do so.
     * </p>
     * <p>
     * This logging is enabled by configuring the underlying log system to allow
     * the logger named "<code>ca.uhn.hl7v2.llp.LowerLayerProtocol</code>" to log
     * events at a level of "trace".
     * </p>
     */
    public static void logCharacterReceived(int c) {
        log.trace("Char received: {} ({})", c, (char) c);
    }

    /**
     * Provides a charset to use for character encoding
     * @param theCharset The charset to use
     * @since 1.3
     */
    public void setCharset(Charset theCharset) {
        charset = theCharset;
    }

    /**
     * Provides a charset to use for character encoding
     * @param charsetName The name of the charset to use
     * @since 2.1
     */
    public void setCharset(String charsetName) {
        charset = Charset.forName(charsetName);
    }
}

