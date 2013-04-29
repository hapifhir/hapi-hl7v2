/**
The contents of this file are subject to the Mozilla Public License Version 1.1
(the "License"); you may not use this file except in compliance with the License.
You may obtain a copy of the License at http://www.mozilla.org/MPL/
Software distributed under the License is distributed on an "AS IS" basis,
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
specific language governing rights and limitations under the License.

The Original Code is "EncodingCharacters.java".  Description:
"Represents the set of special characters used to encode traditionally encoded HL7 messages."

The Initial Developer of the Original Code is University Health Network. Copyright (C)
2001.  All Rights Reserved.

Contributor(s): ______________________________________.

Alternatively, the contents of this file may be used under the terms of the
GNU General Public License (the  "GPL"), in which case the provisions of the GPL are
applicable instead of those above.  If you wish to allow use of your version of this
file only under the terms of the GPL and not to allow others to use your version
of this file under the MPL, indicate your decision by deleting  the provisions above
and replace  them with the notice and other provisions required by the GPL License.
If you do not delete the provisions above, a recipient may use your version of
this file under either the MPL or the GPL.

*/



package ca.uhn.hl7v2.parser;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;



/**
 * Represents the set of special characters used to encode traditionally
 * encoded HL7 messages.
 *
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 */

public class EncodingCharacters implements Cloneable {
    
    private char fieldSep;
    private char[] encChars;
    
    /**
     * Creates new EncodingCharacters object with the given character
     * values. If the encodingCharacters argument is null, the default
     * values are used.
     *
     * @param fieldSeparator field seperator
     * @param encodingCharacters consists of the characters that appear in
     *      MSH-2 (see section 2.8 of the HL7 spec).  The characters are
     *      Component Separator, Repetition Separator, Escape Character, and
     *      Subcomponent Separator (in that order).
     */
    
    public EncodingCharacters(char fieldSeparator, String encodingCharacters) {
        this.fieldSep = fieldSeparator;
        this.encChars = new char[4];
        
        if (encodingCharacters == null) {
            this.encChars[0] = '^';            
            this.encChars[1] = '~';            
            this.encChars[2] = '\\';
            this.encChars[3] = '&';
        } else {
            encodingCharacters.getChars(0, 4, this.encChars, 0);
        }
        
    }

    /**
     * Returns an instance using the MSH-1 and MSH-2 values of the given message
     *
     * @param message the message
     * @return the encoding characters for this message
     * @throws HL7Exception If either MSH-1 or MSH-2 are not populated
     * @since 1.0
     */
    public static EncodingCharacters getInstance(Message message) throws HL7Exception {

        final String encodingCharactersValue = message.getEncodingCharactersValue();
        if (encodingCharactersValue == null || encodingCharactersValue.length() == 0) {
            throw new HL7Exception("encoding characters not populated");
        }

        final Character fieldSeparatorValue = message.getFieldSeparatorValue();
        if (fieldSeparatorValue == null) {
            throw new HL7Exception("Field separator not populated");
        }

        return new EncodingCharacters(fieldSeparatorValue, encodingCharactersValue);
    }

    
    
    public EncodingCharacters(char fieldSeparator, char componentSeparator, char repetitionSeparator,
                              char escapeCharacter, char subcomponentSeparator) {
        this(fieldSeparator, String.valueOf(componentSeparator) + repetitionSeparator + escapeCharacter + subcomponentSeparator);
    }
    
    
    
    /** copies contents of "other" */
    
    public EncodingCharacters(EncodingCharacters other) {
        this.fieldSep = other.getFieldSeparator();
        this.encChars = new char[4];
        this.encChars[0] = other.getComponentSeparator();
        this.encChars[1] = other.getRepetitionSeparator();
        this.encChars[2] = other.getEscapeCharacter();
        this.encChars[3] = other.getSubcomponentSeparator();
    }
    
    /**
     * Returns the field separator.
     *
     * @return the field separator
     */
    public char getFieldSeparator() {
        return this.fieldSep;
    }
    
    /**
     * Returns the component separator.
     *
     * @return the component separator
     */
    public char getComponentSeparator() {
        return this.encChars[0];
    }
    
    /**
     * Returns the repetition separator.
     *
     * @return the repetition separator
     */
    public char getRepetitionSeparator() {
        return this.encChars[1];
    }
    
    /**
     * Returns the escape character.
     *
     * @return the escape character
     */
    public char getEscapeCharacter() {
        return this.encChars[2];
    }
    
    /**
     * Returns the subcomponent separator.
     *
     * @return the subcomponent separator
     */
    public char getSubcomponentSeparator() {
        return this.encChars[3];
    }
    
    /**
     * Returns the encoding characters (not including field separator)
     * as a string.
     */
    public String toString() {
        return String.valueOf(encChars);
    }
    
    public Object clone() throws CloneNotSupportedException
    {
        return new EncodingCharacters(this);
    }
    
    public void setFieldSeparator(char newFieldSep) {
        this.fieldSep = newFieldSep;
    }
    
    public void setComponentSeparator(char newComponentSep) {
        this.encChars[0] = newComponentSep;
    }
    
    public void setRepetitionSeparator(char newRepetitionSep) {
        this.encChars[1] = newRepetitionSep;
    }
    
    public void setEscapeCharacter(char newEscapeChar) {
        this.encChars[2] = newEscapeChar;
    }
    
    public void setSubcomponentSeparator(char newSubcomponentSep) {
        this.encChars[3] = newSubcomponentSep;
    }
    
    /** @see java.lang.Object#equals */
    public boolean equals(Object o) {
        if (o instanceof EncodingCharacters) {
            EncodingCharacters other = (EncodingCharacters) o;
            return (this.getFieldSeparator() == other.getFieldSeparator()
                && this.getComponentSeparator() == other.getComponentSeparator()
                && this.getEscapeCharacter() == other.getEscapeCharacter() 
                && this.getRepetitionSeparator() == other.getRepetitionSeparator()
                && this.getSubcomponentSeparator() == other.getSubcomponentSeparator());
        } else {
            return false;
        }   
    }
    
    /** @see java.lang.Object#hashCode */
    public int hashCode() {
        return 7 * (int) this.getComponentSeparator()
            * (int) this.getEscapeCharacter()
            * (int) this.getFieldSeparator()
            * (int) this.getRepetitionSeparator()
            * (int) this.getSubcomponentSeparator();
    }

    /**
     * Returns an instance of encoding characters with the standard ER7 encoding characters
     * defined: |^~\&
     *
     * @return a default instance of encoding characters
     */
	public static EncodingCharacters defaultInstance() {
		return new EncodingCharacters('|', null);
	}        
    
    /**
     *
     * Test harness ...
     *
     */
    
    /*
     
    public static void main(String args[]) {
     
        String testChars = "^~\\&";
     
        String testChars2 = "$%*+";
     
     
     
        EncodingCharacters ec = new EncodingCharacters('|', testChars);
     
        System.out.println("test 1: " + ec.getFieldSeparator() + ec.toString());
     
        ec = new EncodingCharacters('|', testChars2);
     
        System.out.println("test 2: " + ec.getFieldSeparator() + ec.getComponentSeparator() + ec.getRepetitionSeparator() + ec.getEscapeCharacter() + ec.getSubcomponentSeparator());
     
        ec = new EncodingCharacters('[', null);
     
        System.out.println("test 3: " + ec.getFieldSeparator() + ec.toString());
     
    }*/
    
}

