/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "TM.java".  Description:
 * "Note: The class description below has been excerpted from the Hl7 2.3.0 documentation"
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2001.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the "GPL"), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 *
 */

package ca.uhn.hl7v2.model.v21.datatype;

import ca.uhn.hl7v2.model.Message;

/**
 * Note: The class description below has been excerpted from the Hl7 2.3.0 documentation. Sectional
 * references made below also refer to the same documentation.
 *
 * Format: HH[MM[SS[.S[S[S[S]]]]]][+/-ZZZZ]
 * In prior versions of HL7, this data type was always specified to be in the
 * format HHMM[SS[.SSSS]][+/-ZZZZ] using a 24 hour clock notation. In the
 * current and future versions, the precision of a time may be expressed by
 * limiting the number of digits used with the format specification as shown
 * above. By site-specific agreement, HHMM[SS[.SSSS]][+/-ZZZZ] may be used where
 * backward compatibility must be maintained.
 * Thus, HH is used to specify a precision of "hour," HHMM is used to specify a
 * precision of "minute," HHMMSS is used to specify a precision of seconds, and
 * HHMMSS.SSSS is used to specify a precision of ten-thousandths of a second.
 * In each of these cases, the time zone is an optional component. The fractional
 * seconds could be sent by a transmitter who requires greater precision than whole
 * seconds. Fractional representations of minutes, hours or other higher-order units
 * of time are not permitted.
 * Note: The time zone [+/-ZZZZ], when used, is restricted to legally-defined time zones
 * and is represented in HHMM format.
 * The time zone of the sender may be sent optionally as an offset from the coordinated
 * universal time (previously known as Greenwich Mean Time). Where the time zone
 * is not present in a particular TM field but is included as part of the date/time
 * field in the MSH segment, the MSH value will be used as the default time zone.
 * Otherwise, the time is understood to refer to the local time of the sender.
 * Midnight is represented as 0000.
 * Examples:|235959+1100| 1 second before midnight in a time zone eleven hours
 * ahead of Universal Coordinated Time (i.e., east of Greenwich).
 * |0800| Eight AM, local time of the sender.
 * |093544.2312| 44.2312 seconds after Nine thirty-five AM, local time of sender.
 * |13| 1pm (with a precision of hours), local time of sender.
 * @author Neal Acharya
 */

public class TM extends ca.uhn.hl7v2.model.primitive.TM {
    
    /**
     * @param theMessage message to which this Type belongs
     */
    public TM(Message theMessage) {
        super(theMessage);
    }

    /**
     * @return "2.1"
     */
    public String getVersion() {
        return "2.1";
    }
}