/*
 The contents of this file are subject to the Mozilla Public License Version 1.1
 (the "License"); you may not use this file except in compliance with the License.
 You may obtain a copy of the License at http://www.mozilla.org/MPL/
 Software distributed under the License is distributed on an "AS IS" basis,
 WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 specific language governing rights and limitations under the License.

 The Original Code is "Visitable.java ".  Description:
 "Callback method for the visitor"

 The Initial Developer of the Original Code is University Health Network. Copyright (C)
 2013.  All Rights Reserved.

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

package ca.uhn.hl7v2.model;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.Location;

/**
 * Interface that marks implementing classes as being capable to be visited by a
 * {@link MessageVisitor}
 */
public interface Visitable {

    /**
     * Callback method for the visitor. This method is supposed to either directly
     * call one of the visitors methods, passing <code>this</code> as parameter, or
     * traverse through a hierarchical substructure and call accept(MessageVisitor)
     * for each visited element.
     *
     * @param visitor MessageVisitor instance to be called back
     * @param currentLocation location of this object
     * @return <code>true</code> if the visit process shall continue
     * @throws HL7Exception if a problem occurred during visiting
     */
    boolean accept(MessageVisitor visitor, Location currentLocation) throws HL7Exception;
    
    /**
     * Reusing the location of this object's parent, this method returns its own
     * location within the message.
     * 
     * @param parentLocation the parents location
     * @param index index of this object
     * @param repetition repetition of this object
     * @return this objects location
     */
    Location provideLocation(Location parentLocation, int index, int repetition);

    /**
     * Returns true if this Visitable has actual content
     *
     * @return true if Visitable is empty
     * @throws HL7Exception if an error occurred while determining emptiness
     */
    boolean isEmpty() throws HL7Exception;
}
