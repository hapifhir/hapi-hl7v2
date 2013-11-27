/*
 The contents of this file are subject to the Mozilla Public License Version 1.1
 (the "License"); you may not use this file except in compliance with the License.
 You may obtain a copy of the License at http://www.mozilla.org/MPL/
 Software distributed under the License is distributed on an "AS IS" basis,
 WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 specific language governing rights and limitations under the License.

 The Original Code is "HaveFieldsMessageVisitor.java".  Description:
 "Visitor that checks if configured segments and fields are available in the message"

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

package ca.uhn.hl7v2.examples;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.Location;
import ca.uhn.hl7v2.model.Field;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.validation.ValidationException;
import ca.uhn.hl7v2.validation.builder.support.ValidatingMessageVisitor;

/**
 * Example for a validating visitor that check availability of mandatory fields
 */
public class MandatoryFieldsVisitor extends ValidatingMessageVisitor {

    private final Map<String, Integer[]> requiredFields;

    public MandatoryFieldsVisitor(Map<String, Integer[]> requiredFields) {
        this.requiredFields = requiredFields;
    }

    // required fields left to be checked
    private Set<Location> fieldsLeft;

    @Override
    public boolean start(Message message) throws HL7Exception {
        fieldsLeft = new HashSet<Location>();
        // Initialize the field expressions to be visited
        for (Map.Entry<String, Integer[]> entry : requiredFields.entrySet()) {
            if (!(entry.getValue().length == 0)) {
                for (int fieldId : entry.getValue()) {
                    fieldsLeft.add(
                            new Location()
                                    .withSegmentName(entry.getKey())
                                    .withField(fieldId));
                }
            }
        }
        return true;
    }

    @Override
    public boolean end(Message message) throws HL7Exception {
        for (Location l : fieldsLeft) {
            ValidationException ve = new ValidationException("Mandatory field is empty");
            ve.setLocation(l);
            addValidationException(ve);
        }
        fieldsLeft.clear();
        return true;
    }

    @Override
    public boolean start(Segment segment, Location location) throws HL7Exception {
        // If we don't require a fields for this segment, there is no need to
        // visit the fields
        return requiredFields.containsKey(segment.getName());
    }

    @Override
    public boolean start(Field field, Location location) throws HL7Exception {
        if (!field.isEmpty()) fieldsLeft.remove(location);
        return false; // no need to go deeper
    }


}
