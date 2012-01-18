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

import ca.uhn.hl7v2.validation.ValidationContext;
import ca.uhn.hl7v2.validation.ValidationException;

/**
 * <p>Source of <code>ValidationContext</code>.  </p>
 * 
 * <p>The <code>ValidationContext</code> returned by <code>getContext()</code>
 * is determined by the system property "ca.uhn.hl7v2.validation.context_class".
 * This factory defines two inner classes that can be used: DefaultValidation 
 * and NoValidation.  You can also create your own context, setting whatever rules
 * you want in its constructor, and reference it instead (it must have a zero-arg
 * constructor).  If this property is not set, DefaultValidation is used. </p>
 * 
 * <p>Also note that the contexts provided here extend <code>ValidationContextImpl</code>, 
 * so rule bindings can be added or removed programmatically from the starting set. </p>  
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:40 $ by $Author: jamesagnew $
 */
public class ValidationContextFactory {

    private static ValidationContext ourContext;
    
    public static final String CONTEXT_PROPERTY = "ca.uhn.hl7v2.validation.context_class";
    
    private static final ValidationContext NO_VALIDATION = new NoValidation();
    private static final ValidationContext DEFAULT_VALIDATION = new DefaultValidation();
    
    /**
     * Returns a singleton <code>ValidationContext</code>, creating it if necessary.
     * 
     * @return <code>ValidationContext</code> 
     */
	public synchronized static ValidationContext getContext() throws ValidationException {
        if (ourContext == null) {
            String contextClassName = System.getProperty(CONTEXT_PROPERTY);            
            ourContext = contextClassName == null ? 
            		defaultValidation() : 
            		customValidation(contextClassName);
        }
        return ourContext;
    }
    
    public static ValidationContext noValidation() {
    	return NO_VALIDATION;
    }
    
    public static ValidationContext defaultValidation() {
    	return DEFAULT_VALIDATION;
    }
    
    @SuppressWarnings("unchecked")
	public static ValidationContext customValidation(String contextClassName) throws ValidationException {
        try {
        	Class<? extends ValidationContext> c = (Class<? extends ValidationContext>) Class.forName(contextClassName);
            return c.newInstance();
        } catch (Exception e) {
            throw new ValidationException(e);
        }
    }    

}
