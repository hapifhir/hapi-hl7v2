/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "HL7Writer.java".  Description: 
"An HL7Writer implements writing to an output stream using a particular lower 
  layer protocol" 

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

/**
 * An HL7Writer implements writing to an output stream using a particular lower 
 * layer protocol.
 *
 * @author Bryan Tripp
 */
public interface HL7Writer {

    /** 
     * Sends a complete message to the underlying output stream using the  
     * lower layer protocol implemented by this HL7Writer.  
     */
    public void writeMessage(String message) throws LLPException, IOException;
    
    /**
     * Sets the OutputStream to which to write messages.  The OutputStream must be set 
     * before any calls to <code>()</code>.
     */
    public void setOutputStream(OutputStream out) throws IOException;

    /** 
     * Closes the underlying stream and any other resources that should be closed. 
     */
    public void close() throws java.io.IOException;
    
}
