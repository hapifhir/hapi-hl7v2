package ca.uhn.hl7v2.testpanel.model.conf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.hl7v2.testpanel.model.AbstractModelClass;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProfileGroup")
public class ProfileGroup extends AbstractModelClass {

	public static final String PROP_GROUPS = ProfileGroup.class.getName() + "_GROUPS";
	
	@XmlElement(name = "entry")
	private List<Entry> myEntries;

	@XmlElement(name = "name")
	private String myName;

	public ProfileGroup() {
		super();
	}

	public ProfileGroup(ProfileProxy theFile) throws IOException, ProfileException {
		Entry e = new Entry();
		e.setEventType("*");
		e.setMessageType("*");
		e.setProfileProxy(theFile);
		getEntries().add(e);
		
		myName = theFile.getProfile().getName();
	}

	public ProfileGroup(String theName) {
		myName = theName;
	}

	/**
	 * @return the entries
	 */
	public List<Entry> getEntries() {
		if (myEntries == null) {
			myEntries = new ArrayList<ProfileGroup.Entry>();
		}
		return myEntries;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return myName;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "ProfileGroupEntry")
	public static class Entry extends AbstractModelClass {
		
		public static final String PROP_DESC = Entry.class.getName() + "_DESC";
		
		@XmlElement(name = "evtType")
		private String myEventType;
		
		@XmlElement(name = "msgType")
		private String myMessageType;

		@XmlElement(name = "profile")
		private ProfileProxy myProfileProxy;

		@XmlElement(name = "tablesId")
		private String myTablesId;

		/**
		 * @return the eventType
		 */
		public String getEventType() {
			return myEventType;
		}

		/**
		 * @return the messageType
		 */
		public String getMessageType() {
			return myMessageType;
		}

		/**
		 * @return the profileProxy
		 */
		public ProfileProxy getProfileProxy() {
			return myProfileProxy;
		}

		/**
		 * @return the tablesId
		 */
		public String getTablesId() {
			return myTablesId;
		}

		/**
		 * @param theEventType
		 *            the eventType to set
		 */
		public void setEventType(String theEventType) {
			String oldValue = myEventType;
			myEventType = theEventType;
			firePropertyChange(PROP_DESC, oldValue, myEventType);
		}

		/**
		 * @param theMessageType
		 *            the messageType to set
		 */
		public void setMessageType(String theMessageType) {
			String oldValue = myMessageType;
			myMessageType = theMessageType;
			firePropertyChange(PROP_DESC, oldValue, myMessageType);
		}

		/**
		 * @param theProfileProxy
		 *            the profileProxy to set
		 */
		public void setProfileProxy(ProfileProxy theProfileProxy) {
			myProfileProxy = theProfileProxy;
		}

		/**
		 * @param theTablesId
		 *            the tablesId to set
		 */
		public void setTablesId(String theTablesId) {
			String oldValue = myTablesId;
			myTablesId = theTablesId;
			firePropertyChange(PROP_DESC, oldValue, myTablesId);
		}

		@Override
		public Object exportConfigToXml() {
			// TODO Auto-generated method stub
			return null;
		}
	}

	@Override
	public Object exportConfigToXml() {
		// TODO Auto-generated method stub
		return null;
	}

}
