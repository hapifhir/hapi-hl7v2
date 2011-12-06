/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "Defaultalidation.java".  Description: 
"A ValidationContext with a default set of rules initially defined." 

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

import ca.uhn.hl7v2.validation.Rule;


/**
 * A <code>ValidationContext</code> with a default set of rules initially defined.
 * This can be used as-is for a reasonable level of primitive type validation.   
 *  
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.3 $ updated on $Date: 2010-08-23 01:14:44 $ by $Author: jamesagnew $
 */
@SuppressWarnings("serial")
public class DefaultValidation extends ValidationContextImpl {
    public DefaultValidation() {
        Rule trim = new TrimLeadingWhitespace();
        getPrimitiveRuleBindings().add(new RuleBinding("*", "FT", trim));
        getPrimitiveRuleBindings().add(new RuleBinding("*", "ST", trim));
        getPrimitiveRuleBindings().add(new RuleBinding("*", "TX", trim));                 

        Rule size200 = new SizeRule(200);
        Rule size32000 = new SizeRule(32000);
        getPrimitiveRuleBindings().add(new RuleBinding("*", "FT", size32000));
        getPrimitiveRuleBindings().add(new RuleBinding("*", "ID", size200));
        getPrimitiveRuleBindings().add(new RuleBinding("*", "IS", size200));

        Rule nonNegativeInteger = new RegexPrimitiveRule("\\d*", "");
        getPrimitiveRuleBindings().add(new RuleBinding("*", "SI", nonNegativeInteger));                                    

        Rule number = new RegexPrimitiveRule("(\\+|\\-)?\\d*\\.?\\d*", "");
        getPrimitiveRuleBindings().add(new RuleBinding("*", "NM", number));
        
        Rule telephoneNumber 
            = new RegexPrimitiveRule("(\\d{1,2} )?(\\(\\d{3}\\))?\\d{3}-\\d{4}(X\\d{1,5})?(B\\d{1,5})?(C.*)?", 
                "Version 2.4 Section 2.9.45");
        getPrimitiveRuleBindings().add(new RuleBinding("*", "TN", telephoneNumber));        
        
        String datePattern = "(\\d{4}([01]\\d(\\d{2})?)?)?"; //YYYY[MM[DD]]
        Rule date = new RegexPrimitiveRule(datePattern, "Version 2.5 Section 2.16.24");
        getPrimitiveRuleBindings().add(new RuleBinding("*", "DT", date));
        
        String timePattern  //HH[MM[SS[.S[S[S[S]]]]]][+/-ZZZZ] 
            = "([012]\\d([0-5]\\d([0-5]\\d(\\.\\d(\\d(\\d(\\d)?)?)?)?)?)?)?([\\+\\-]\\d{4})?";
        Rule time = new RegexPrimitiveRule(timePattern, "Version 2.5 Section 2.16.79");
        getPrimitiveRuleBindings().add(new RuleBinding("*", "TM", time));
                
        String datetimePattern   
            = "(\\d{4}([01]\\d(\\d{2}([012]\\d([0-5]\\d([0-5]\\d(\\.\\d(\\d(\\d(\\d)?)?)?)?)?)?)?)?)?)?([\\+\\-]\\d{4})?";
        Rule datetime = new RegexPrimitiveRule(datetimePattern, "Version 2.5 Section 2.16.25");
        getPrimitiveRuleBindings().add(new RuleBinding("*", "TSComponentOne", datetime));
        getPrimitiveRuleBindings().add(new RuleBinding("*", "DTM", datetime));
        
        // NULLDT shouldn't have a value
        getPrimitiveRuleBindings().add(new RuleBinding("*", "NULLDT", new WithdrawnDatatypeRule()));
    }
}