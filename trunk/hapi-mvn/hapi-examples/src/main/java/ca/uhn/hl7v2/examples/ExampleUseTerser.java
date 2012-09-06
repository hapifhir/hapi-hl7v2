/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "ExampleUseTerser.java".  Description:
 * "Example Code"
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2001.  All Rights Reserved.
 *
 * Contributor(s): James Agnew
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  �GPL�), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 *
 */

package ca.uhn.hl7v2.examples;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.message.ORU_R01;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.util.Terser;

/**
 * Example code for using the {@link Terser}
 * 
 * @author <a href="mailto:jamesagnew@sourceforge.net">James Agnew</a>
 * @version $Revision: 1.3 $ updated on $Date: 2009-08-06 22:43:33 $ by $Author: jamesagnew $
 */
public class ExampleUseTerser
{

    /**
     * A simple example of parsing a message
     * 
     * @throws HL7Exception
     * @throws EncodingNotSupportedException
     */
    public static void main(String[] args) throws Exception {
        String msg = "MSH|^~\\&|HIS|RIH|EKG|EKG|199904140038||ADT^A01||P|2.2\r"
                + "PID|0001|00009874|00001122|A00977|SMITH^JOHN^M|MOM|19581119|F|NOTREAL^LINDA^M|C|564 SPRING ST^^NEEDHAM^MA^02494^US|0002|(818)565-1551|(425)828-3344|E|S|C|0000444444|252-00-4414||||SA|||SA||||NONE|V1|0001|I|D.ER^50A^M110^01|ER|P00055|11B^M011^02|070615^BATMAN^GEORGE^L|555888^NOTREAL^BOB^K^DR^MD|777889^NOTREAL^SAM^T^DR^MD^PHD|ER|D.WT^1A^M010^01|||ER|AMB|02|070615^NOTREAL^BILL^L|ER|000001916994|D||||||||||||||||GDD|WA|NORM|02|O|02|E.IN^02D^M090^01|E.IN^01D^M080^01|199904072124|199904101200|199904101200||||5555112333|||666097^NOTREAL^MANNY^P\r"
                + "NK1|0222555|NOTREAL^JAMES^R|FA|STREET^OTHER STREET^CITY^ST^55566|(222)111-3333|(888)999-0000|||||||ORGANIZATION\r"
                + "PV1|0001|I|D.ER^1F^M950^01|ER|P000998|11B^M011^02|070615^BATMAN^GEORGE^L|555888^OKNEL^BOB^K^DR^MD|777889^NOTREAL^SAM^T^DR^MD^PHD|ER|D.WT^1A^M010^01|||ER|AMB|02|070615^VOICE^BILL^L|ER|000001916994|D||||||||||||||||GDD|WA|NORM|02|O|02|E.IN^02D^M090^01|E.IN^01D^M080^01|199904072124|199904101200|||||5555112333|||666097^DNOTREAL^MANNY^P\r"
                + "PV2|||0112^TESTING|55555^PATIENT IS NORMAL|NONE|||19990225|19990226|1|1|TESTING|555888^NOTREAL^BOB^K^DR^MD||||||||||PROD^003^099|02|ER||NONE|19990225|19990223|19990316|NONE\r"
                + "AL1||SEV|001^POLLEN\r"
                + "AL1||SEV|003^DUST\r"
                + "GT1||0222PL|NOTREAL^BOB^B||STREET^OTHER STREET^CITY^ST^77787|(444)999-3333|(222)777-5555||||MO|111-33-5555||||NOTREAL GILL N|STREET^OTHER STREET^CITY^ST^99999|(111)222-3333\r"
                + "IN1||022254P|4558PD|BLUE CROSS|STREET^OTHER STREET^CITY^ST^00990||(333)333-6666||221K|LENIX|||19980515|19990515|||PATIENT01 TEST D||||||||||||||||||02LL|022LP554";
        
        HapiContext context = new DefaultHapiContext();
        Parser p = context.getGenericParser();
        Message hapiMsg = p.parse(msg);
        
        /*
         * Another way of reading messages is to use a Terser. The terser 
         * accepts a particular syntax to retrieve segments. See the API
         * documentation for the Terser for more information.
         */
        Terser terser = new Terser(hapiMsg);
        
        /* 
         * Sending Application is in MSH-3-1 (the first component of the third
         * field of the MSH segment)
         */ 
        String sendingApplication = terser.get("/.MSH-3-1");
        System.out.println(sendingApplication);
        // HIS
        
        /*
         * We can use brackets to get particular repetitions
         */
        String secondAllergyType = terser.get("/AL1(1)-3-2");
        System.out.println(secondAllergyType);
        // DUST
        
        // We can also use the terser to set values
        terser.set("/.MSH-3-1", "new_sending_app");
        
        // Let's try something more complicated, adding values to an OBX in an ORU^R01
        ORU_R01 oru = new ORU_R01();
        oru.initQuickstart("ORU", "R01", "P");
        
        terser = new Terser(oru);
        for (int i = 0; i < 5; i++) {
            terser.set("/PATIENT_RESULT/ORDER_OBSERVATION/OBSERVATION(" + i + ")/OBX-1", "" + (i + 1));
            terser.set("/PATIENT_RESULT/ORDER_OBSERVATION/OBSERVATION(" + i + ")/OBX-3", "ST");
            terser.set("/PATIENT_RESULT/ORDER_OBSERVATION/OBSERVATION(" + i + ")/OBX-5", "This is the value for rep " + i);
        }
        
        System.out.println(p.encode(oru));
        
        /*
         *   MSH|^~\&|||||||ORU^R01|||2.5
         *   OBX|1||ST||This is the value for rep 0
         *   OBX|2||ST||This is the value for rep 1
         *   OBX|3||ST||This is the value for rep 2
         *   OBX|4||ST||This is the value for rep 3
         *   OBX|5||ST||This is the value for rep 4
         */
    }

}
