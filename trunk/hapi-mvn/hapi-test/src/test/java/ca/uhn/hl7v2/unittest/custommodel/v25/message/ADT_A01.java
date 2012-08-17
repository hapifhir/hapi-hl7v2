/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uhn.hl7v2.unittest.custommodel.v25.message;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.unittest.custommodel.v25.segment.ZFA;

/**
 * Example custom model class. This is a ADT^A01, which is an ADT^A01 with
 * an extra ZPI segment after the PID segment
 *
 * Since we're extending an existing HL7 message type, we just extend from the model class
 * representing that type
 */
public class ADT_A01 extends ca.uhn.hl7v2.model.v25.message.ADT_A01 {

 	/**
	 * Constructor
     *
     * We always have to have a constructor with this one argument
	 */
	public ADT_A01(ModelClassFactory factory) throws HL7Exception {
	   super(factory);

	   this.add(ZFA.class, false, true);
	}


    /**
     * Add an accessor for the ZFA segment
     */
    public ZFA getZFA() throws HL7Exception {
        return (ZFA) get("ZFA");
    }

}
