/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "ValidationContextFactory.java".  Description: 
"Source of ValidationContext" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2004.  All Rights Reserved. 

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
package ca.uhn.hl7v2.validation.impl;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.util.ReflectionUtil;
import ca.uhn.hl7v2.validation.ValidationContext;
import ca.uhn.hl7v2.validation.builder.ValidationRuleBuilder;
import ca.uhn.hl7v2.validation.builder.support.DefaultValidationBuilder;
import ca.uhn.hl7v2.validation.builder.support.NoValidationBuilder;

/**
 * <p>
 * The <code>ValidationContext</code> returned by <code>getContext()</code> is
 * determined by the system property "ca.uhn.hl7v2.validation.context_class".
 * This factory defines two inner classes that can be used: DefaultValidation
 * and NoValidation. You can also create your own context, setting whatever
 * rules you want in its constructor, and reference it instead (it must have a
 * zero-arg constructor). If this property is not set, DefaultValidation is
 * used.
 * </p>
 * 
 * <p>
 * Also note that the contexts provided here use
 * <code>ValidationContextImpl</code>, so rule bindings can be added or removed
 * programmatically from the starting set.
 * </p>
 * 
 * @author Bryan Tripp
 * @author Christian Ohr
 * 
 */
public class ValidationContextFactory {

    private static ValidationContext ourContext;

    public static final String CONTEXT_PROPERTY = "ca.uhn.hl7v2.validation.context_class";

    /**
     * Returns a singleton <code>ValidationContext</code>, creating it if
     * necessary.
     * 
     * @return <code>ValidationContext</code>
     */
    public synchronized static ValidationContext getContext() throws HL7Exception {
        if (ourContext == null) {
            String contextClassName = System.getProperty(CONTEXT_PROPERTY);
            ourContext = contextClassName == null ? defaultValidation()
                    : customValidation(contextClassName);
        }
        return ourContext;
    }

    /**
     * @return an instance of a non-validating context
     */
    @SuppressWarnings("unchecked")
	public static <T extends ValidationContext> T noValidation() {
        return (T) new ValidationContextImpl(new NoValidationBuilder());
    }

    /**
     * @return an instance of a default validation context
     */
    @SuppressWarnings("unchecked")
	public static <T extends ValidationContext> T defaultValidation() {
        return (T)new ValidationContextImpl(new DefaultValidationBuilder());
    }

    /**
     * @param ruleBuilderClassName class name of a {@link ValidationRuleBuilder}
     *            subclass
     * @return a validation rule builder instance
     * @throws HL7Exception if builder cannot be built
     */
    @SuppressWarnings("unchecked")
    public static ValidationRuleBuilder customBuilder(String ruleBuilderClassName)
            throws HL7Exception {
        Class<? extends ValidationRuleBuilder> c;
        try {
            c = (Class<? extends ValidationRuleBuilder>) Class.forName(ruleBuilderClassName);
        } catch (ClassNotFoundException e) {
            throw new HL7Exception(e);
        }
        return ReflectionUtil.instantiate(c);
    }

    public static ValidationContext fromBuilder(String ruleBuilderClassName) throws HL7Exception {
        return new ValidationContextImpl(customBuilder(ruleBuilderClassName));
    }

    public static ValidationContext fromBuilder(ValidationRuleBuilder builder) {
        return new ValidationContextImpl(builder);
    }

    /**
     * @param contextClassName class name of a {@link ValidationContext}
     *            subclass
     * @return instance of the ValidationContext
     * @throws HL7Exception if context cannot be obtained
     */
    @SuppressWarnings("unchecked")
    public static ValidationContext customValidation(String contextClassName) throws HL7Exception {
        Class<? extends ValidationContext> c;
        try {
            c = (Class<? extends ValidationContext>) Class.forName(contextClassName);
        } catch (Exception e) {
            throw new HL7Exception(e);
        }
        return ReflectionUtil.instantiate(c);

    }

}
