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
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.message.ORU_R01;
import ca.uhn.hl7v2.parser.CanonicalModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.util.Terser;

/**
 * Example code illustrating how to handle multiple versions of HL7 from one codebase
 * 
 * @author <a href="mailto:jamesagnew@sourceforge.net">James Agnew</a>
 * @version $Revision: 1.1 $ updated on $Date: 2011-05-22 16:52:21 $ by $Author: jamesagnew $
 */
public class HandlingMultipleVersions {

	public static void main(String[] args) throws Exception {

		/*
		 * Often, you will need to handle multiple versions of HL7 from a sending system
		 * from within the same code base. Because HAPI uses different model classes for
		 * each version, this can seem difficult.
		 * 
		 * The following example shows two ways of dealing with this situation. First,
		 * for this example, consider the following messages. Each is identical, aside
		 * from the version string: "2.5" and "2.3".
		 */
		
        String v25message = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838-v25|T|2.5\r"
			+ "PID|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r"
			+ "PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST\r"
			+ "ORC|RE||T09-100442-RET-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r"
			+ "OBR|0||T09-100442-RET-0^^OLIS_Site_ID^ISO|RET^RETICULOCYTE COUNT^HL79901 literal|||200905011106|||||||200905011106||OLIST^BLAKE^DONALD^THOR^^^^L^921379||7870279|7870279|T09-100442|MOHLTC|200905011130||B7|F||1^^^200905011106^^R\r"
			+ "OBX|1|ST|||Test Value";
		
        String v23message = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838-v23|T|2.3\r"
			+ "PID|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r"
			+ "PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST\r"
			+ "ORC|RE||T09-100442-RET-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r"
			+ "OBR|0||T09-100442-RET-0^^OLIS_Site_ID^ISO|RET^RETICULOCYTE COUNT^HL79901 literal|||200905011106|||||||200905011106||OLIST^BLAKE^DONALD^THOR^^^^L^921379||7870279|7870279|T09-100442|MOHLTC|200905011130||B7|F||1^^^200905011106^^R\r"
			+ "OBX|1|ST|||Test Value";
		
        /*
         * The first (and probably better in most ways) technique is as follows. Use a model class
         * factory called the CanonicalModelClassFactory. This class forces a specific version of
         * HL7 to be used. Because HL7 v2.x is a backwards compatible standard, you can choose the
         * highest version you need to support, and the model classes will be compatible with
         * messages from previous versions.
         */
		
        HapiContext context = new DefaultHapiContext();
        // Create the MCF. We want all parsed messages to be for HL7 version 2.5,
        // despite what MSH-12 says.
        CanonicalModelClassFactory mcf = new CanonicalModelClassFactory("2.5");
        context.setModelClassFactory(mcf);

        // Pass the MCF to the parser in its constructor
        PipeParser parser = context.getPipeParser();
        
        // The parser parses the v2.3 message to a "v25" structure
        ca.uhn.hl7v2.model.v25.message.ORU_R01 msg = (ORU_R01) parser.parse(v23message);
        
        // 20169838-v23
        System.out.println(msg.getMSH().getMessageControlID().getValue());

        // The parser also parses the v2.5 message to a "v25" structure
        msg = (ORU_R01) parser.parse(v25message);
        
        // 20169838-v25
        System.out.println(msg.getMSH().getMessageControlID().getValue());
        
        /*
         * The second technique is to use the Terser. The Terser allows you
         * to access field values using a path-like notation. For more information
         * on the Terser, see the example here:
         * http://hl7api.sourceforge.net/xref/ca/uhn/hl7v2/examples/ExampleUseTerser.html
         */

        // This time we just use a normal ModelClassFactory, which means we will be
        // using the standard version-specific model classes
        context.setModelClassFactory(new DefaultModelClassFactory());

        // 20169838-v23
        Message v23Message = parser.parse(v23message);
        Terser t23 = new Terser(v23Message);
        System.out.println(t23.get("/MSH-10"));

        // 20169838-v25
        Message v25Message = parser.parse(v25message);
        Terser t25 = new Terser(v25Message);
        System.out.println(t25.get("/MSH-10"));
        
        /*
         * Note that this second technique has one major drawback: Although 
         * message definitions are backwards compatible, some group names
         * change between versions. If you are accessing a group within
         * a complex message structure, this can cause issues.
         * 
         * This is less of an issue for some message types where groups are
         * not used much (e.g. ADT)
         */

        // This works and prints "Test Value"
        System.out.println(t23.get("/RESPONSE/ORDER_OBSERVATION/OBSERVATION(0)/OBX-5"));

        // This fails...
        // System.out.println(t25.get("/RESPONSE/ORDER_OBSERVATION/OBSERVATION(0)/OBX-5"));
        
        // ...because this would be required to extract the OBX-5 value from a v2.5 message
        System.out.println(t25.get("/PATIENT_RESULT/ORDER_OBSERVATION/OBSERVATION(0)/OBX-5"));
        
	}

}
