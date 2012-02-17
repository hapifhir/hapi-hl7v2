package ca.uhn.hl7v2.testpanel.model.conf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="ExportedProfileGroupFile")
public class ExportedProfileGroupFile {

//	private List<TableFile>
	
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name="ExportedConformanceProfile")
	public static class ExportedConformanceProfile {
		
		@XmlAttribute(name="id")
		private String myId;
		
		@XmlElement(name="profile")
		private String myProfileText;

		/**
		 * @return the id
		 */
		public String getId() {
			return myId;
		}

		/**
		 * @param theId the id to set
		 */
		public void setId(String theId) {
			myId = theId;
		}

		/**
		 * @return the profileText
		 */
		public String getProfileText() {
			return myProfileText;
		}

		/**
		 * @param theProfileText the profileText to set
		 */
		public void setProfileText(String theProfileText) {
			myProfileText = theProfileText;
		}
		
	}
	
}
