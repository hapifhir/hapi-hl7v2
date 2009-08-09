/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "ValidationContextImpl.java".  Description: 
"A default implementation of ValidationContext." 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2004.  All Rights Reserved. 

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
package ca.uhn.hl7v2.validation.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ca.uhn.hl7v2.model.Primitive;
import ca.uhn.hl7v2.validation.PrimitiveTypeRule;
import ca.uhn.hl7v2.validation.EncodingRule;
import ca.uhn.hl7v2.validation.MessageRule;
import ca.uhn.hl7v2.validation.ValidationContext;

/**
 * A default implementation of <code>ValidationContext</code>. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.2 $ updated on $Date: 2009-08-09 13:31:13 $ by $Author: jamesagnew $
 */
public class ValidationContextImpl implements ValidationContext, Serializable {

    private List myPrimitiveRuleBindings;
    private List myMessageRuleBindings;
    private List myEncodingRuleBindings;
    private boolean myCheckPrimitivesFlag;
    
    public ValidationContextImpl() {
        myPrimitiveRuleBindings = new ArrayList(30);
        myMessageRuleBindings = new ArrayList(20);
        myEncodingRuleBindings = new ArrayList(10);
        myCheckPrimitivesFlag = true;
    }

    /** 
     * @see ca.uhn.hl7v2.validation.ValidationContext#getDataTypeRules(java.lang.String, java.lang.String)
     * @param theType ignored 
     */
    public PrimitiveTypeRule[] getPrimitiveRules(String theVersion, String theTypeName, Primitive theType) {
        List active = new ArrayList(myPrimitiveRuleBindings.size());
        for (int i = 0; i < myPrimitiveRuleBindings.size(); i++) {
            Object o = myPrimitiveRuleBindings.get(i);
            if ( !(o instanceof RuleBinding) ) {
                throw new ClassCastException("Item in rule binding list is not a RuleBinding");
            }
            
            RuleBinding binding = (RuleBinding) o;
            if (binding.getActive() 
                    && binding.appliesToVersion(theVersion) 
                    && binding.appliesToScope(theTypeName)) {
                active.add(binding.getRule());
            }
        }
        return (PrimitiveTypeRule[]) active.toArray(new PrimitiveTypeRule[0]);
    }
    
    /**
     * @return a List of <code>RuleBinding</code>s for <code>PrimitiveTypeRule</code>s.    
     */
    public List getPrimitiveRuleBindings() {
        return myPrimitiveRuleBindings;
    }

    /**
     * @see ca.uhn.hl7v2.validation.ValidationContext
     *      #getMessageRules(java.lang.String, java.lang.String, java.lang.String)
     */
    public MessageRule[] getMessageRules(String theVersion, String theMessageType, String theTriggerEvent) {
            
        List active = new ArrayList(myMessageRuleBindings.size());
        for (int i = 0; i < myMessageRuleBindings.size(); i++) {
            Object o = myMessageRuleBindings.get(i);
            if ( !(o instanceof RuleBinding) ) {
                throw new ClassCastException("Item in rule binding list is not a RuleBinding");
            }
        
            RuleBinding binding = (RuleBinding) o;
            if (binding.getActive() 
                    && binding.appliesToVersion(theVersion) 
                    && binding.appliesToScope(theMessageType + "^" + theTriggerEvent)) {
                active.add(binding.getRule());
            }
        }
        return (MessageRule[]) active.toArray(new MessageRule[0]);
    }

    /**
     * @return a List of <code>RuleBinding</code>s for <code>MessageRule</code>s.    
     */
    public List getMessageRuleBindings() {
        return myMessageRuleBindings;
    }

    /** 
     * @see ca.uhn.hl7v2.validation.ValidationContext#getEncodingRules(java.lang.String, java.lang.String)
     */
    public EncodingRule[] getEncodingRules(String theVersion, String theEncoding) {
        List active = new ArrayList(myEncodingRuleBindings.size());
        for (int i = 0; i < myEncodingRuleBindings.size(); i++) {
            Object o = myEncodingRuleBindings.get(i);
            if ( !(o instanceof RuleBinding) ) {
                throw new ClassCastException("Item in rule binding list is not a RuleBinding");
            }
            
            RuleBinding binding = (RuleBinding) o;
            if (binding.getActive() 
                    && binding.appliesToVersion(theVersion) 
                    && binding.appliesToScope(theEncoding)) {
                active.add(binding.getRule());
            }
        }
        return (EncodingRule[]) active.toArray(new EncodingRule[0]);
    }

    /**
     * @return a List of <code>RuleBinding</code>s for <code>EncodingRule</code>s.    
     */
    public List getEncodingRuleBindings() {
        return myEncodingRuleBindings;
    }

//    /**
//     * @see ca.uhn.hl7v2.validation.ValidationContext#getCheckPrimitivesOnSet()
//     */
//    public boolean getCheckPrimitivesOnSet() {
//        return myCheckPrimitivesFlag;
//    }
//
//    /**
//     * @see ca.uhn.hl7v2.validation.ValidationContext#setCheckPrimitivesOnSet(boolean)
//     */
//    public void setCheckPrimitivesOnSet(boolean check) {
//        myCheckPrimitivesFlag = check;
//    }
    
}
