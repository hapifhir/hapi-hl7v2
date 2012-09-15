package ca.uhn.hl7v2.testpanel.model.conf;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;

import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.hl7v2.testpanel.model.AbstractModelClass;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProfileGroup")
public class ProfileGroup extends AbstractModelClass implements Cloneable {

	public static final String PROP_NAME = ProfileGroup.class.getName() + "_NAME";

	public static final String PROP_PROFILES = ProfileGroup.class.getName() + "_PROFILES";

	@XmlElement(name = "entry")
	private List<Entry> myEntries;
	
	@XmlElement(name = "id")
	private String myId;

	@XmlElement(name = "name")
	private String myName;

	@XmlElement(name = "sourceUrl")
	private String mySourceUrl;

	public ProfileGroup() {
		super();
		
		myId = UUID.randomUUID().toString();
	}
	
	public ProfileGroup(ProfileProxy theFile) throws IOException, ProfileException {
		this();
		Entry e = new Entry();
		e.setEventType("*");
		e.setMessageType("*");
		e.setProfileProxy(theFile);
		e.myParentProfileGroup = this;
		getEntries().add(e);
		
		myName = theFile.getProfile().getName();
	}

	public ProfileGroup(String theName) {
		this();
		myName = theName;
	}

	public void addProfile(ProfileProxy theProfile) {
		Entry entry = new Entry();
		entry.setMessageType(theProfile.getStructureMessageType());
		entry.setEventType(theProfile.getStructureEventType());
		entry.setParentProfileGroup(this);
		entry.setProfileProxy(theProfile);
		myEntries.add(entry);
		firePropertyChange(PROP_PROFILES, null, entry);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	 public ProfileGroup clone() throws CloneNotSupportedException {
		throw new UnsupportedOperationException();
	}

	public void dumpToFile(File theFile) throws IOException {
		FileWriter w = new FileWriter(theFile, false);
		JAXB.marshal(this, w);
		w.close();
	}

	@Override
	public String exportConfigToXml() {
		StringWriter writer = new StringWriter();
		JAXB.marshal(this, writer);
		return writer.toString();
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
	 * @return the id
	 */
	public String getId() {
		return myId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return myName;
	}

	public Entry getProfileForMessage(String theEventType, String theTrigger) throws IOException, ProfileException {
		for (Entry next : myEntries) {
			if (next.getMessageType().equals("*") || next.getMessageType().equals(theEventType)) {
				if (theTrigger == null || StringUtils.isBlank(theTrigger) || next.getEventType().equals("*") || next.getEventType().equals(theTrigger)) {
					return next;
				}
			}
		}
		return null;
	}

//	/**
//	 * @return the tableFiles
//	 */
//	public List<TableFile> getTableFiles() {
//		if (myTableFiles == null) {
//			myTableFiles = new ArrayList<TableFile>();
//		}
//		return myTableFiles;
//	}

	/**
	 * @return the sourceUrl
	 */
	public String getSourceUrl() {
		return mySourceUrl;
	}

	public void removeEntry(Entry theSel) {
		for (Iterator<Entry> iter = myEntries.iterator(); iter.hasNext(); ) {
			if (iter.next() == theSel) {
				iter.remove();
			}
		}
		firePropertyChange(PROP_PROFILES, null, null);
	}

	/**
	 * @param theId the id to set
	 */
	public void setId(String theId) {
		myId = theId;
	}

	public void setName(String theName) {
		String oldValue = myName;
		myName = theName;
		firePropertyChange(PROP_NAME, oldValue, theName);
	}

	public void setSourceUrl(String theSourceUrl) {
		mySourceUrl =theSourceUrl;
	}

	public static ProfileGroup createFromRuntimeProfile(String theProfileString) throws IOException, ProfileException {
		ProfileGroup retVal = new ProfileGroup(ProfileProxy.createFromProfileString(theProfileString));
		return retVal;
	}

	public static ProfileGroup readFromFile(File theFile) throws IOException {
		FileReader r = new FileReader(theFile);
		ProfileGroup retVal = JAXB.unmarshal(r, ProfileGroup.class);
		if (StringUtils.isBlank(retVal.getId())) {
			throw new IOException("Invalid file, no ID tag found");
		}
		return retVal;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "ProfileGroupEntry")
	public static class Entry extends AbstractModelClass {
		
		public static final String PROP_DESC = Entry.class.getName() + "_DESC";
		
		@XmlElement(name = "evtType")
		private String myEventType;
		
		@XmlElement(name = "msgType")
		private String myMessageType;

		private transient ProfileGroup myParentProfileGroup;

		@XmlElement(name = "profile")
		private ProfileProxy myProfileProxy;

		@XmlElement(name = "tablesId")
		private String myTablesId;
		
		@Override
		public Object exportConfigToXml() {
			// TODO Auto-generated method stub
			return null;
		}

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
		 * @return the profileGroup
		 */
		public ProfileGroup getParentProfileGroup() {
			return myParentProfileGroup;
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

		public void setParentProfileGroup(ProfileGroup theGroup) {
			myParentProfileGroup = theGroup;
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
	}
	
}
