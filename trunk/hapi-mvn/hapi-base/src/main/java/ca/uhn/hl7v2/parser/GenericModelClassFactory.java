package ca.uhn.hl7v2.parser;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.GenericComposite;
import ca.uhn.hl7v2.model.GenericGroup;
import ca.uhn.hl7v2.model.GenericMessage;
import ca.uhn.hl7v2.model.GenericSegment;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.parser.ModelClassFactory;

public class GenericModelClassFactory implements ModelClassFactory {

	private static final long serialVersionUID = 1L;

	public Class<? extends Message> getMessageClass(String theName, String theVersion, boolean theIsExplicit) throws HL7Exception {
		return GenericMessage.getGenericMessageClass(theVersion);
	}

	public Class<? extends Message> getMessageClassInASpecificPackage(String theName, String theVersion, boolean theIsExplicit, String thePackageName) throws HL7Exception {
		return GenericMessage.getGenericMessageClass(theVersion);
	}

	public Class<? extends Group> getGroupClass(String theName, String theVersion) throws HL7Exception {
		return GenericGroup.class;
	}

	public Class<? extends Segment> getSegmentClass(String theName, String theVersion) throws HL7Exception {
		return GenericSegment.class;
	}

	public Class<? extends Type> getTypeClass(String theName, String theVersion) throws HL7Exception {
		return GenericComposite.class;
	}


}
