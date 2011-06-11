package ca.uhn.hl7v2.parser.testmodel;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.AbstractGroup;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.v25.segment.EVN;
import ca.uhn.hl7v2.model.v25.segment.MSH;
import ca.uhn.hl7v2.model.v25.segment.NTE;
import ca.uhn.hl7v2.model.v25.segment.OBX;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;

public class MessageWithMandatorySegmentAfterSubgroup extends AbstractMessage {

	private static final long serialVersionUID = 1L;

	public MessageWithMandatorySegmentAfterSubgroup() throws HL7Exception {
		super(new DefaultModelClassFactory());

		this.add(MSH.class, true, false);
		this.add(MyGroup.class, true, false);

	}

	@Override
	public String getVersion() {
		return "2.5";
	}

	public MSH getMSH() throws HL7Exception {
		return (MSH) this.get("MSH");
	}

	public MyGroup getMyGroup() throws HL7Exception {
		return (MyGroup) this.get("MyGroup");
	}

	public static class MyGroup extends AbstractGroup {

		private static final long serialVersionUID = 1L;

		public MyGroup(Group theParent, ModelClassFactory theFactory) throws HL7Exception {
			super(theParent, theFactory);

			this.add(MySubGroup.class, true, false);
			this.add(EVN.class, true, false);
		}

		public EVN getEVN() throws HL7Exception {
			return (EVN) this.get("EVN");
		}

		public MySubGroup getMySubGroup() throws HL7Exception {
			return (MySubGroup) this.get("MySubGroup");
		}

	}

	
	public static class MySubGroup extends AbstractGroup {

		private static final long serialVersionUID = 1L;

		public MySubGroup(Group theParent, ModelClassFactory theFactory) throws HL7Exception {
			super(theParent, theFactory);

			this.add(OBX.class, true, false);
			this.add(NTE.class, true, false);
		}

		public OBX getOBX() throws HL7Exception {
			return (OBX) this.get("OBX");
		}

		public NTE getNTE() throws HL7Exception {
			return (NTE) this.get("NTE");
		}

	}
	
}
