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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents a particular "lower layer protocol" over which HL7 messages can be 
 * sent.  An example is the "minimal lower layer protocol" defines in the HL7
 * implementation guide (appendix C) - this is implemented by the class 
 * MinLowerLayerProtocol.  Implementations should call the static method 
 * <code>logCharacterReceived()</code> when a character is read from a remote system.  
 * This method may or may not log receipt, as configured (see docs for this method).  
 * @author  Bryan Tripp
 */
public abstract class LowerLayerProtocol {

    private static final Logger log = LoggerFactory.getLogger(LowerLayerProtocol.class);
    
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
     * Logs the fact that a character has been received, if configured to do so.  This is a 
     * debugging feature.  This is enabled by setting the system property 
     * ca.uhn.hl7v2.llp.logBytesRead=TRUE (before LowerLayerProtocol is instantiated).  
     * A message is logged for each character.  THIS IS VERY SLOW and should
     * normally be turned off. 
     * </p><p>
     * Note that as of HAPI 1.3, this will be logged using commons-logging at
     * a level of "info" instead of being printed to System.out
     * </p>
     */
    public static void logCharacterReceived(int c) {
        log.trace("Char received: {} ({})", c, (char) c);
    }
    
}

