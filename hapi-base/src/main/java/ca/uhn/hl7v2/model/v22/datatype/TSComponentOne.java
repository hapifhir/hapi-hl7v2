/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "TS.java".  Description:
 * 
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

package ca.uhn.hl7v2.model.v22.datatype;

import ca.uhn.hl7v2.model.Message;

/**
 * Note: The class description below has been excerpted from the Hl7 2.3.0 documentation. Sectional
 * references made below also refer to the same documentation.
 *
 * Format: YYYY[MM[DD[HHMM[SS[.S[S[S[S]]]]]]]][+/-ZZZZ]^<degree of precision>
 * Contains the exact time of an event, including the date and time. The date portion of a time stamp follows the rules of a
 * date field and the time portion follows the rules of a time field. The time zone (+/-ZZZZ) is represented as +/-HHMM
 * offset from UTC (formerly Greenwich Mean Time (GMT)), where +0000 or -0000 both represent UTC (without offset).
 * The specific data representations used in the HL7 encoding rules are compatible with ISO 8824-1987(E).
 * In prior versions of HL7, an optional second component indicates the degree of precision of the time stamp (Y = year, L
 * = month, D = day, H = hour, M = minute, S = second). This optional second component is retained only for purposes of
 * backward compatibility.
 * By site-specific agreement, YYYYMMDD[HHMM[SS[.S[S[S[S]]]]]][+/-ZZZZ]^<degree of precision> may be used
 * where backward compatibility must be maintained.
 * In the current and future versions of HL7, the precision is indicated by limiting the number of digits used, unless the
 * optional second component is present. Thus, YYYY is used to specify a precision of "year," YYYYMM specifies a
 * precision of "month," YYYYMMDD specifies a precision of "day," YYYYMMDDHH is used to specify a precision of
 * "hour," YYYYMMDDHHMM is used to specify a precision of "minute," YYYYMMDDHHMMSS is used to specify a
 * precision of seconds, and YYYYMMDDHHMMSS.SSSS is used to specify a precision of ten thousandths of a second.
 * In each of these cases, the time zone is an optional component. Also note that a TS valued field with the HHMM part set to "0000"
 * represents midnight of the night extending from the previous day to the day given by the YYYYMMDD part (see example
 * below). Maximum length of the time stamp is 26. Examples:
 * |19760704010159-0500|
 * 1:01:59 on July 4, 1976 in the Eastern Standard Time zone (USA).
 * |19760704010159-0400|
 * 1:01:59 on July 4, 1976 in the Eastern Daylight Saving Time zone (USA).
 * |198807050000|
 * Midnight of the night extending from July 4 to July 5, 1988 in the local time zone of the sender.
 * |19880705|
 * Same as prior example, but precision extends only to the day. Could be used for a birthdate, if the time of birth is
 * unknown.
 * |19981004010159+0100|
 * 1:01:59 on October 4, 1998 in Amsterdam, NL. (Time zone=+0100).
 * The HL7 Standard strongly recommends that all systems routinely send the time zone offset but does not require it. All
 * HL7 systems are required to accept the time zone offset, but its implementation is application specific. For many
 * applications the time of interest is the local time of the sender. For example, an application in the Eastern Standard Time
 * zone receiving notification of an admission that takes place at 11:00 PM in San Francisco on December 11 would prefer
 * to treat the admission as having occurred on December 11 rather than advancing the date to December 12.
 * Note: The time zone [+/-ZZZZ], when used, is restricted to legally-defined time zones and is represented in HHMM
 * format.
 * One exception to this rule would be a clinical system that processed patient data collected in a clinic and a nearby hospital
 * that happens to be in a different time zone. Such applications may choose to convert the data to a common
 * representation. Similar concerns apply to the transitions to and from daylight saving time. HL7 supports such requirements
 * by requiring that the time zone information be present when the information is sent. It does not, however, specify which of
 * the treatments discussed here will be applied by the receiving system.
 *
 * NOTE:  if the time zone is not included, the timezone
 * defaults to that of the local time zone of the sender.
 *
 * @author Neal Acharya
 */
public class TSComponentOne extends ca.uhn.hl7v2.model.primitive.TSComponentOne {
    
    /**
     * @param theMessage message to which this Type belongs
     */
    public TSComponentOne(Message theMessage) {
        super(theMessage);
    }

    /**
     * @return "2.2"
     */
    public String getVersion() {
        return "2.2";
    }
}