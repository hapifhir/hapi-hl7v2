/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "AbstractType.java".  Description:
 * 
 * "An abstract Type that provides a default implementation of getName()" 
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2001.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  �GPL�), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 *
 */

package ca.uhn.hl7v2.model;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.Location;
import ca.uhn.hl7v2.parser.EncodingCharacters;
import ca.uhn.hl7v2.parser.PipeParser;

/**
 * An abstract Type that provides a default implementation of getName(). 
 * 
 * @author Bryan Tripp
 */
public abstract class AbstractType implements Type {

	private static final long serialVersionUID = -6976260024197429201L;
	
	private final ExtraComponents extra;
    private final Message message;
    
    /** 
     * Creates a new instance of AbstractType
     * @param message message to which this type belongs 
     */
    public AbstractType(Message message) {
        extra = new ExtraComponents(message);
        this.message = message;
    }
    
    /** Returns the name of the type (used in XML encoding and profile checking)  */
    public String getName() {
        String longClassName = this.getClass().getName();
        return longClassName.substring(longClassName.lastIndexOf('.') + 1);
    }
    
    /** @see Type#getExtraComponents */
    public ExtraComponents getExtraComponents() {
        return this.extra;
    }
    
    
    /**
     * @return the message to which this Type belongs
     */
    public Message getMessage() {
        return message;
    }


    /**
     * {@inheritDoc }
     */
    public void parse(String string) throws HL7Exception {
        clear();
		getMessage().getParser().parse(this, string, EncodingCharacters.getInstance(getMessage()));
    }


    /**
     * {@inheritDoc }
     */
    public String encode() throws HL7Exception {
        return getMessage().getParser().doEncode(this, EncodingCharacters.getInstance(getMessage()));
    }

	/**
	 * {@inheritDoc }
	 */
	public void clear() {
		extra.clear();
	}

	/**
	 * {@inheritDoc }
	 */	
	public boolean isEmpty() throws HL7Exception {
		return extra.isEmpty();
	}

	/**
	 * Returns the datatype and attempts to pipe-encode it. For example, a string implementation
	 * might return "ST[Value^Value2]". This is only intended for logging/debugging purposes.
	 */
	@Override
	public String toString() {
		return toString(this);
	}

	
	/**
	 * Returns the datatype and attempts to pipe-encode it. For example, a string implementation
	 * might return "ST[Value^Value2]". This is only intended for logging/debugging purposes.
	 */
	static String toString(Type theType) {
		StringBuilder b = new StringBuilder();
		b.append(theType.getClass().getSimpleName());
		b.append("[");
		b.append(PipeParser.encode(theType, EncodingCharacters.defaultInstance()));
		b.append("]");
		return b.toString();
	}

    public Location provideLocation(Location location, int index, int repetition) {
        if (location.getField() < 0)
            return new Location(location)
                .withField(index)
                .withFieldRepetition(repetition);
        if (location.getComponent() < 0)
            return new Location(location)
                .withComponent(index);
        return new Location(location)
            .withSubcomponent(index);
    }
	

}
