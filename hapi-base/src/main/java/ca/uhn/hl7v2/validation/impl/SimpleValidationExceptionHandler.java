/*
 The contents of this file are subject to the Mozilla Public License Version 1.1
 (the "License"); you may not use this file except in compliance with the License.
 You may obtain a copy of the License at http://www.mozilla.org/MPL/
 Software distributed under the License is distributed on an "AS IS" basis,
 WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 specific language governing rights and limitations under the License.

 The Original Code is "SimpleValidationExceptionHandler.java ".  Description:
 "Exception containing a Location and Error Code"

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

package ca.uhn.hl7v2.validation.impl;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.validation.CollectingValidationExceptionHandler;
import ca.uhn.hl7v2.validation.ValidationExceptionHandler;
import ca.uhn.hl7v2.validation.ValidationExceptionHandlerFactory;

/**
 * A very simple example of a validation handler that simply returns a boolean
 * value as validation {@link #result() result}.
 */
public class SimpleValidationExceptionHandler extends CollectingValidationExceptionHandler<Boolean> implements ValidationExceptionHandlerFactory<Boolean> {

    /**
     * @param context Hapi context
     */
    public SimpleValidationExceptionHandler(HapiContext context) {
        super(context);
    }

    public Boolean result() throws HL7Exception {
        return hasFailed();
    }

    public ValidationExceptionHandler<Boolean> getNewInstance(HapiContext context) {
        return new SimpleValidationExceptionHandler(context);
    }
}
