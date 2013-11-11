/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "AbstractPrimitive.java".  Description:
 * "Base class for Primitives.  Performs validation in setValue()."
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2001-2005.  All Rights Reserved.
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

import java.util.Collection;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.Location;
import ca.uhn.hl7v2.parser.EncodingCharacters;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.validation.PrimitiveTypeRule;
import ca.uhn.hl7v2.validation.ValidationContext;
import ca.uhn.hl7v2.validation.ValidationException;

/**
 * Base class for Primitives.  Performs validation in setValue().
 *    
 * @author Bryan Tripp
 */
@SuppressWarnings("serial")
public abstract class AbstractPrimitive extends AbstractType implements Primitive {
    
    /**
     * @param message message to which this type belongs
     */
    public AbstractPrimitive(Message message) {
        super(message);
    }

    private String myValue;
    
    /** 
     * Returns the value of getValue() 
     * @see java.lang.Object#toString 
     */
    public String toString() {
        return this.getValue();
    }
    
    /**
     * @see ca.uhn.hl7v2.model.Primitive#getValue()
     */
    public String getValue() {
        return myValue;
    }

    /**
     * Sets the value of this Primitive, first performing validation as specified 
     * by <code>getMessage().getValidationContext()</code>.  No validation is performed 
     * if getMessage() returns null. 
     * <p>
     * Note: as of the next HAPI release, the ValidationContext will be retrieved
     * from getParser().getValidationContext(), which ultimately is the ValidationContext
     * of the active HapiContext.
     * 
     * @see ca.uhn.hl7v2.model.Primitive#setValue(String)
     */    
    public void setValue(String theValue) throws DataTypeException {
        Message message = getMessage();

        if (message != null) {
        	// Note: this will change in future to reuse the Parser's/HapiContext's
        	// ValidationContext.
            ValidationContext context = message.getValidationContext();
            String version = message.getVersion();

            if (context != null) {
                Collection<PrimitiveTypeRule> rules = context.getPrimitiveRules(version, getName(), this); 
        
                for (PrimitiveTypeRule rule : rules) {
                    theValue = rule.correct(theValue);
                    ValidationException[] ve = rule.apply(theValue);
                    if (ve.length > 0) {
                        throw new DataTypeException(ve[0]);
                    }
                }
            }
        }
        
        myValue = theValue;
    }

    
    /**
     * {@inheritDoc }
     */
    @Override
    public String encode() throws HL7Exception {
        Parser p = getMessage().getParser();
        return p.doEncode(this, EncodingCharacters.getInstance(getMessage()));
    }


    /**
     * {@inheritDoc }
     */
    @Override
    public void parse(String string) throws HL7Exception {
        if (string == null) {
        	clear();
        	return;
        }
    	
    	EncodingCharacters encodingCharacters = EncodingCharacters.getInstance(getMessage());
        char subc = encodingCharacters.getSubcomponentSeparator();
        char cmpc = encodingCharacters.getComponentSeparator();

        clear();
        
        // If the string contains subcomponent delimiters, parse
        // these as extra components
        int subcIndex = string.indexOf(subc);
        int cmpcIndex = string.indexOf(cmpc);
        if (subcIndex != -1 || cmpcIndex != -1) {
            
            //Object ancestor = AbstractMessage.findAncestorOf(this);
            
            int index;
            char escapeChar;
            if (cmpcIndex != -1) {
            	index = cmpcIndex;
            	escapeChar = cmpc;
            } else {
    			index = subcIndex;
    			escapeChar = subc;
            }
            
			setValue(string.substring(0, index));
            while (index != -1) {
                int prevIndex = index + 1;
                index = string.indexOf(escapeChar, prevIndex);
                if (index != -1) {
                    String nextSubComponent = string.substring(prevIndex, index);
                    getExtraComponents().getComponent(getExtraComponents().numComponents()).parse(nextSubComponent);
                } else {
                    String nextSubComponent = string.substring(prevIndex);
                    if (nextSubComponent.length() > 0) {
                    	getExtraComponents().getComponent(getExtraComponents().numComponents()).parse(nextSubComponent);
                    }
                }
            }
            
        } else {
        
        	String escaped = getMessage().getParser().getParserConfiguration()
                .getEscaping().unescape(string, encodingCharacters);
            setValue(escaped);
        
        }
    }


    /**
     * {@inheritDoc }
     */
    @Override
    public void clear() {
        super.clear();
        myValue = null;
    }

	@Override
	public boolean isEmpty() throws HL7Exception {
		return (myValue == null || myValue.length() == 0) && super.isEmpty();
	}

    public boolean accept(MessageVisitor visitor, Location location) throws HL7Exception {
        return visitor.visit(this, location);
    }  
    
}
