/*
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "IntRef.java".  Description: 
"reference for an int value" 

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
package ca.uhn.hl7v2.protocol.impl;

/**
 * The class <code> IntRef </code> is a reference for an int value.
 * 
 * note:
 *  it's like a reference to an int value, meaning that the referred int value
 *  can be changed through the reference 
 * 
 * @author  Alexei Guevara <mailto:alexei.guevara@uhn.on.ca/>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:26 $ by $Author: jamesagnew $
 */
public class IntRef {
    
    private int myValue;
    
    /**
     * Returns the integer value of this <code>IntRef</code>
     *
     * @return the value of the integer in native int form
     */
    public int getValue() {
        return myValue;
    }

    /**
     * Sets the value.
     *
     * @param theValue The value to set
     */
    public void setValue(int theValue) {
        this.myValue = theValue;
    }

}
