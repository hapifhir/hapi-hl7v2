/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "PopulateOBXSegment.java".  Description:
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

import java.io.IOException;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Varies;
import ca.uhn.hl7v2.model.v25.datatype.CE;
import ca.uhn.hl7v2.model.v25.datatype.ST;
import ca.uhn.hl7v2.model.v25.datatype.TX;
import ca.uhn.hl7v2.model.v25.group.ORU_R01_OBSERVATION;
import ca.uhn.hl7v2.model.v25.group.ORU_R01_ORDER_OBSERVATION;
import ca.uhn.hl7v2.model.v25.message.ORU_R01;
import ca.uhn.hl7v2.model.v25.segment.OBR;
import ca.uhn.hl7v2.model.v25.segment.OBX;

/**
 * Example code for populating an OBX segment
 * 
 * @author <a href="mailto:jamesagnew@sourceforge.net">James Agnew</a>
 * @version $Revision: 1.1 $ updated on $Date: 2009-03-19 13:09:26 $ by $Author: jamesagnew $
 */
public class PopulateOBXSegment
{

    /**
     * We are going to create an ORU_R01 message, for the purpose of demonstrating the creation and
     * population of an OBX segment.
     * 
     * The following message snippet is drawn (and modified for simplicity) 
     * from section 7.4.2.4 of the HL7 2.5 specification.
     * 
     * <code>
     * OBR|1||1234^LAB|88304 
     * OBX|1|CE|88304|1|T57000^GALLBLADDER^SNM
     * OBX|2|TX|88304|1|THIS IS A NORMAL GALLBLADDER 
     * OBX|3|TX|88304&MDT|1|MICROSCOPIC EXAM SHOWS HISTOLOGICALLY NORMAL GALLBLADDER TISSUE
     * </code>
     * 
     * The following code attempts to generate this message structure.
     * 
     * The HL7 spec defines, the following structure for an ORU^R01 message, represented in HAPI by
     * the segment group:
     * 
     * <code>
     *                     ORDER_OBSERVATION start
     *       {
     *       [ ORC ]
     *       OBR
     *       [ { NTE } ]
     *                     TIMING_QTY start
     *          [{
     *          TQ1
     *          [ { TQ2 } ]
     *          }]
     *                     TIMING_QTY end
     *       [ CTD ]
     *                     OBSERVATION start
     *          [{
     *          OBX
     *          [ { NTE } ]
     *          }]
     *                     OBSERVATION end
     *       [ { FT1 } ]
     *       [ { CTI } ]
     *                     SPECIMEN start
     *          [{
     *          SPM
     *          [ { OBX } ]
     *          }]
     *                     SPECIMEN end
     *       }
     *                     ORDER_OBSERVATION end
     * </code>
     * 
     * @param args
     *            The arguments
     * @throws HL7Exception
     *             If any processing problem occurs
     * @throws IOException 
     */
    public static void main(String[] args) throws HL7Exception, IOException {

        // First, a message object is constructed
        ORU_R01 message = new ORU_R01();

        /*
         * The initQuickstart method populates all of the mandatory fields in the
         * MSH segment of the message, including the message type, the timestamp,
         * and the control ID.
         */
        message.initQuickstart("ORU", "R01", "T");
        
        /*
         * The OBR segment is contained within a group called ORDER_OBSERVATION, 
         * which is itself in a group called PATIENT_RESULT. These groups are
         * reached using named accessors.
         */
        ORU_R01_ORDER_OBSERVATION orderObservation = message.getPATIENT_RESULT().getORDER_OBSERVATION();

        // Populate the OBR
        OBR obr = orderObservation.getOBR();
        obr.getSetIDOBR().setValue("1");
        obr.getFillerOrderNumber().getEntityIdentifier().setValue("1234");
        obr.getFillerOrderNumber().getNamespaceID().setValue("LAB");
        obr.getUniversalServiceIdentifier().getIdentifier().setValue("88304");
        
        /*
         * The OBX segment is in a repeating group called OBSERVATION. You can 
         * use a named accessor which takes an index to access a specific 
         * repetition. You can ask for an index which is equal to the 
         * current number of repetitions,and a new repetition will be created.
         */
        ORU_R01_OBSERVATION observation = orderObservation.getOBSERVATION(0);

        // Populate the first OBX
		OBX obx = observation.getOBX();
        obx.getSetIDOBX().setValue("1");
        obx.getObservationIdentifier().getIdentifier().setValue("88304");
        obx.getObservationSubID().setValue("1");

        // The first OBX has a value type of CE. So first, we populate OBX-2 with "CE"...
        obx.getValueType().setValue("CE");
        
        // ... then we create a CE instance to put in OBX-5.
        CE ce = new CE(message);
        ce.getIdentifier().setValue("T57000");
        ce.getText().setValue("GALLBLADDER");
        ce.getNameOfCodingSystem().setValue("SNM");
        Varies value = obx.getObservationValue(0);
        value.setData(ce);
        
        // Now we populate the second OBX
        obx = orderObservation.getOBSERVATION(1).getOBX();
        obx.getSetIDOBX().setValue("2");
        obx.getObservationSubID().setValue("1");

        // The second OBX in the sample message has an extra subcomponent at
        // OBX-3-1. This component is actually an ST, but the HL7 specification allows
        // extra subcomponents to be tacked on to the end of a component. This is
        // uncommon, but HAPI nontheless allows it.
        ST observationIdentifier = obx.getObservationIdentifier().getIdentifier();
        observationIdentifier.setValue("88304");
        ST extraSubcomponent = new ST(message);
        extraSubcomponent.setValue("MDT");
        observationIdentifier.getExtraComponents().getComponent(0).setData(extraSubcomponent );

        // The first OBX has a value type of TX. So first, we populate OBX-2 with "TX"...
        obx.getValueType().setValue("TX");
        
        // ... then we create a CE instance to put in OBX-5.
        TX tx = new TX(message);
        tx.setValue("MICROSCOPIC EXAM SHOWS HISTOLOGICALLY NORMAL GALLBLADDER TISSUE");
        value = obx.getObservationValue(0);
        value.setData(tx);

        // Print the message (remember, the MSH segment was not fully or correctly populated)
        System.out.println(message.encode());

        /*
         * MSH|^~\&|||||20111102082111.435-0500||ORU^R01^ORU_R01|305|T|2.5
         * OBR|1||1234^LAB|88304
         * OBX|1|CE|88304|1|T57000^GALLBLADDER^SNM
         * OBX|2|TX|88304&MDT|1|MICROSCOPIC EXAM SHOWS HISTOLOGICALLY NORMAL GALLBLADDER TISSUE
         */
    }

}
