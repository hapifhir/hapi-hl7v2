package ca.uhn.hl7v2.testpanel.model.conf;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.UUID;

import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.hl7v2.conf.parser.ProfileParser;
import ca.uhn.hl7v2.conf.spec.RuntimeProfile;
import ca.uhn.hl7v2.testpanel.util.FileUtils;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProfileProxy")
public class ProfileProxy {

	@XmlElement(name = "fileName")
	private String myFileName;

	@XmlElement(name = "id")
	private String myId;

	@XmlElement(name = "name")
	private String myName;

	private transient RuntimeProfile myProfile;

	@XmlElement(name = "evtType")
	private String myStructureEventType;

	@XmlElement(name = "msgType")
	private String myStructureMessageType;

	public File getFile() {
		return new File(myFileName);
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return myFileName;
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

	public RuntimeProfile getProfile() throws IOException, ProfileException {
		if (myProfile == null) {
			String profileString;
			profileString = FileUtils.readFile(getFile());
			myProfile = new ProfileParser(false).parse(profileString);
		}
		return myProfile;
	}

	/**
	 * @return the structureEventType
	 */
	public String getStructureEventType() {
		return myStructureEventType;
	}

	/**
	 * @return the structureMessageType
	 */
	public String getStructureMessageType() {
		return myStructureMessageType;
	}

	/**
	 * @param theFileName the fileName to set
	 */
	public void setFileName(String theFileName) {
		myFileName = theFileName;
	}

	/**
	 * @param theId the id to set
	 */
	public void setId(String theId) {
		myId = theId;
	}

	/**
	 * @param theName the name to set
	 */
	public void setName(String theName) {
		myName = theName;
	}

	/**
	 * @param theStructureEventType the structureEventType to set
	 */
	public void setStructureEventType(String theStructureEventType) {
		myStructureEventType = theStructureEventType;
	}

	/**
	 * @param theStructureMessageType the structureMessageType to set
	 */
	public void setStructureMessageType(String theStructureMessageType) {
		myStructureMessageType = theStructureMessageType;
	}

	public static ProfileProxy createFromProfileString(String theProfile) throws IOException, ProfileException {
		ProfileProxy profileProxy = new ProfileProxy();
		profileProxy.setId(UUID.randomUUID().toString());
		
		profileProxy.myProfile = new ProfileParser(false).parse(theProfile);
		RuntimeProfile p = profileProxy.getProfile();
		profileProxy.setName(p.getName());
		profileProxy.setStructureMessageType(p.getMessage().getMsgType());
		profileProxy.setStructureEventType(p.getMessage().getEventType());
		
		return profileProxy;
	}

	public static ProfileProxy loadFromFile(File theFile) throws IOException, ProfileException {
		ProfileProxy profileProxy = new ProfileProxy();
		profileProxy.setFileName(theFile.getAbsolutePath());
		profileProxy.setId(UUID.randomUUID().toString());
		
		RuntimeProfile p = profileProxy.getProfile();
		profileProxy.setName(p.getName());
		profileProxy.setStructureMessageType(p.getMessage().getMsgType());
		profileProxy.setStructureEventType(p.getMessage().getEventType());
		
		return profileProxy;
	}

	public static ProfileProxy loadFromString(String theString) {
		StringReader r = new StringReader(theString);
		ProfileProxy retVal = JAXB.unmarshal(r, ProfileProxy.class);
		return retVal;
	}

	

}
