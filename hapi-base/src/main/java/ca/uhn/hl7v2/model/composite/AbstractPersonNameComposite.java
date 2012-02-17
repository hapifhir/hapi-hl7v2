package ca.uhn.hl7v2.model.composite;

import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.Message;

/**
 * NOT YET IN USE
 */
public abstract class AbstractPersonNameComposite extends AbstractType implements Composite {

	/**
	 * Constructor
	 */
	public AbstractPersonNameComposite(Message theMessage) {
		super(theMessage);
	}


//	/**
//	 * Returns the value as 
//	 */
//	public String createPractitionerName(XCN practitioner) throws HL7Exception {
//		String prefix = practitioner.getPrefixEgDR().getValue();
//		prefix = (prefix != null) ? prefix + ". " : "";
//		String lname = practitioner.getFamilyName().getFn1_Surname().getValue();
//		lname = (lname != null) ? lname + ", " : "";
//		String fname = practitioner.getGivenName().getValue();
//		fname = (fname != null) ? fname : "";
//		String mname = practitioner.getSecondAndFurtherGivenNamesOrInitialsThereof().getValue();
//		mname = (mname != null) ? " " + mname : "";
//		String name = prefix + lname + fname + mname;
//		if (name.equals("")) {
//			name = null;
//		}
//		return name;
//	}
}
