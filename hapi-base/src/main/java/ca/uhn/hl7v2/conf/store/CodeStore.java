/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "CodeStore.java".  Description:
 * "Interface used retrieving and validating codes"
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2012.  All Rights Reserved.
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
package ca.uhn.hl7v2.conf.store;

import ca.uhn.hl7v2.conf.ProfileException;

/**
 * Interface used retrieving and validating codes from user defined and HL7 specific tables that
 * correspond to a conformance profile.
 * 
 * @author Neal Acharya
 */
public interface CodeStore {

    /**
     * Retrieves all codes for a given conformance profile and codeSystem.
     * 
     * @param codeSystem a table of codes (for example, HL70001 for administrative sex) valid tables
     *            are defined in the HL7 table 0396
     * @return a list of valid codes
     * @throws ProfileException
     */
    public String[] getValidCodes(String codeSystem) throws ProfileException;

    /**
     * Validates the codeSystem against the input conformance profile. If valid then output is
     * 'true' else 'false'.
     * 
     * @param codeSystem
     * @return <code>true</code> if CodeStore knows the codeSystem
     */
    public boolean knowsCodes(String codeSystem);

    /**
     * Validates the input code value against the input conformance profile and corresponding input
     * codeSystem. Returns true if the code is valid and false if it isn't.
     * 
     * @param codeSystem
     * @param code
     * @return <code>true</code> if code is valid for the codeSystem
     */
    public boolean isValidCode(String codeSystem, String code);

}
