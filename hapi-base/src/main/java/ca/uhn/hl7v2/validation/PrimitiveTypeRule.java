/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "PrimitiveTypeRule.java".  Description: 
"A rule that applies to a primitive datatype. " 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2002.  All Rights Reserved. 

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

package ca.uhn.hl7v2.validation;

/**
 * A rule that applies to a primitive datatype. 
 * @author Bryan Tripp
 */
public interface PrimitiveTypeRule extends Rule<String> {
 
    /**
     * Optionally performs an automatic correction on given data to make it 
     * conform (eg trims leading whitespace).  This is to be called prior to 
     * test().  If no corrections are performed, the original value is returned. 
     * 
     * @param value an original value to be corrected 
     * @return a corrected version of the given value 
     */
    public String correct(String value);

    /**
     * Tests the given string against the criteria defined by this 
     * rule -- returns true if it passes the test, false otherwise.
     * 
     * @deprecated use {@link #apply(Object)}
     */
    public boolean test(String value);
    
}
