/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "Type.java".  Description: 
"An HL7 datatype" 

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

package ca.uhn.hl7v2.model;

import ca.uhn.hl7v2.HL7Exception;
import java.io.Serializable;

/**
 * An HL7 datatype.  Datatypes normally implement either Composite or Primitive.    
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 */
public interface Type extends Serializable, Visitable {

    /**
     * Returns the name of the type (used in XML encoding and profile checking)
     *
     * @return the name of the type
     */
    public String getName();
    
    /**
     * Returns an object containing any extra (non-standard) components that 
     * have been added to this type at run-time.  This object can also be used
     * to add components.
     *
     * @return an object containing any extra (non-standard) components
     */
    public ExtraComponents getExtraComponents();
    
    /**
     * @return the message to which this Type belongs
     */
    public Message getMessage();

    /**
     * <p>
     * Parses the string into this type and replaces the current contents with
     * the parsed value. This method accepts HL7 encoded text and treats its
     * input as such.
     * </p>
     * <p>
     * Note that this method is subtly different from calling {@link Primitive#setValue(String)}, but
     * can be quite powerful. For example, using the argument of "milk&cookies" on an ST datatype:
     * <ul>
     * <li>
     * If you are using {@link Primitive#setValue(String)}, the ampersand is treated as an actual ampersand 
     * in the text, and the field will be treated as a single field which is encoded as "milk\T\cookies" (\T\ is the 
     * escape sequence for the subcomponent delimiter).
     * </li>
     * <li>
     * If you are using parse(String), the ampersand is treated as a subcomponent delimiter, meaning that
     * the value is set to "milk", and a second component is added with the value of "cookies".
     * </li>
     * </ul>
     * </p>  
     * <p>
     * This method makes use of the parser which is stored within the enclosing {@link #getMessage() Message}.
     * At this time, only PipeParsers are supported. 
     * </p>
     *
     * @param string the message to be parsed
     * @throws HL7Exception if errors occurred while parsing
     */
    public void parse(String string) throws HL7Exception;


    /**
     * Encodes this type using HL7 encoding.
     *
     * @return the encoded message
     * @throws HL7Exception if errors occurred while encoding
     */
    public String encode() throws HL7Exception;


	/**
	 * Clears all data from this type
	 */
	void clear();

} 
