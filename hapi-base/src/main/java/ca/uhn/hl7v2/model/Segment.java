/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "Segment.java".  Description: 
"Represents an HL7 message segment, which is a unit of data that contains multiple fields.
@author Bryan Tripp (bryan_tripp@sourceforge.net)" 

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

/**
 * Represents an HL7 message segment, which is a unit of data that contains multiple fields.
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 */
public interface Segment extends Structure {

    /**
     * Encodes this message using the parser returned by {@link Message#getParser() }
     *
     * @return the string-encoded segment
     * @throws HL7Exception if errors occurred during encoding
     */
    public String encode() throws HL7Exception;

    /**
     * Returns the array of Fields at the specified index.  The array will be of length 1 for
     * non-repeating fields, and >1 for repeating fields.  Fields are numbered from 1.
     *
     * @param number field number (starting at 1)
     * @return the array of Fields at the specified field number
     * @throws HL7Exception if field index is out of range.
     */
    public Type[] getField(int number) throws HL7Exception;

    /**
     * Returns a specific repetition of field at the specified index.  If there exist
     * fewer repetitions than are required, the number of repetitions can be increased
     * by specifying the lowest repetition that does not yet exist.  For example
     * if there are two repetitions but three are needed, the third can be created
     * and accessed using the following code: <br>
     * <code>Type t = getField(x, 2);</code>
     * @param number the field number (starting at 1)
     * @param rep the repetition number (starting at 0)
     * @return field at the specified field number and repetition
     * @throws HL7Exception if field index is out of range, or if the specified
     *    repetition is more than 1 greater than the highest index of existing repetitions.
     *    NOTE: to facilitate local extensions, no exception is thrown if
     *    rep > max cardinality
     */
    public Type getField(int number, int rep) throws HL7Exception;

    /**
     * Returns the maximum length of the field at the given index, in characters.
     * @param number field number starting at 1
     * @return maximum length of the field
     * @throws HL7Exception if field index is out of range.
     */
    public int getLength(int number) throws HL7Exception;

    /**
     * Returns the maximum number of repetitions of this field that are allowed.
     * The current cardinality can be obtained by checking the length
     * of the array returned by getLength(n).
     * @param number field number starting at 1
     * @return maximum number of repetitions of this field
     * @throws HL7Exception if field index is out of range.
     */
    public int getMaxCardinality(int number) throws HL7Exception;

    /**
     * Returns the names of the fields in this segment.
     * @return array of names
     *
     * @since 1.0 - Note that if user defined types are being used, there is a possibility that some entries may be null. All official hapi structures will have all entries populated, but older user defined structures may not have populated all values, since this feature did not exist prior to release 1.0.
     */
    public String[] getNames();

    /**
     * Returns true if the field at the given index is required, false otherwise.
     *
     * @param number field number starting at 1
     * @return true if the field is required
     * @throws HL7Exception if field index is out of range.
     */
    public boolean isRequired(int number) throws HL7Exception;


    /**
     * Returns the number of fields defined by this segment (repeating
     * fields are not counted multiple times).
     * @return number of fields
     */
    public int numFields();


    /**
     * Parses the string into this segment using the parser returned by {@link Message#getParser() }
     * @param string encoded segment
     * @throws HL7Exception if errors occurred during parsing
     */
    public void parse(String string) throws HL7Exception;

    
}
