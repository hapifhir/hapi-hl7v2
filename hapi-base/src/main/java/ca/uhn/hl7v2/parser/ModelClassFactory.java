/*
 * Created on 21-Apr-2005
 */
package ca.uhn.hl7v2.parser;

import java.io.Serializable;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Type;

/**
 * Looks up classes for message model components (e.g. concrete implementations of Message, Group,
 * Segment). A custom factory can be used to point to custom model components.
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.3 $ updated on $Date: 2009-10-03 15:25:46 $ by $Author: jamesagnew $
 */
public interface ModelClassFactory extends Serializable {

	/**
	 * @param theName name of message
	 * @param theVersion HL7 version
	 * @param isExplicit true if the structure was specified explicitly in MSH-9-3, false if it was
	 *            inferred from MSH-9-1 and MSH-9-2. If false, a lookup may be performed to find an
	 *            alternate structure corresponding to that message type and event.
	 * @return a class that implements the specified message
	 * @throws HL7Exception if the version if not recognized or an appropriate class can not be
	 *             found
	 */
	public Class<? extends Message> getMessageClass(String theName, String theVersion,
			boolean isExplicit) throws HL7Exception;

	/**
	 * Retrieves a message class by looking in a specific java package for the message type.
	 * 
	 * @param theName The message structure type (e.g. "ADT_A01")
	 * @param theVersion The HL7 version (e.g. "2.3.1")
	 * @param isExplicit If false, the message structure is looked up using
	 *            {@link Parser#getMessageStructureForEvent(String, String)} and converted to the
	 *            appropriate structure type. For example, "ADT_A04" would be converted to "ADT_A01"
	 *            because the A04 trigger uses the A01 message structure according to HL7.
	 * @param packageName The package name to use. Note that if the message type can't be found in
	 *            this package, HAPI will return the standard type returned by
	 *            {@link #getMessageClass(String, String, boolean)}
     * @return message class
	 * @since 2.0
	 */
	public Class<? extends Message> getMessageClassInASpecificPackage(String theName,
			String theVersion, boolean isExplicit, String packageName) throws HL7Exception;

	/**
	 * @param theName name of group
	 * @param theVersion HL7 version
	 * @return a class that implements the specified group
	 * @throws HL7Exception if the version if not recognized or an appropriate class can not be
	 *             found
	 */
	public Class<? extends Group> getGroupClass(String theName, String theVersion)
			throws HL7Exception;

	/**
	 * @param theName name of segment
	 * @param theVersion HL7 version
	 * @return a class that implements the specified segment
	 * @throws HL7Exception if the version if not recognized or an appropriate class can not be
	 *             found
	 */
	public Class<? extends Segment> getSegmentClass(String theName, String theVersion)
			throws HL7Exception;

	/**
	 * @param theName name of type
	 * @param theVersion HL7 version
	 * @return a class that implements the specified type
	 * @throws HL7Exception if the version if not recognized or an appropriate class can not be
	 *             found
	 */
	public Class<? extends Type> getTypeClass(String theName, String theVersion)
			throws HL7Exception;

	/**
	 * @param eventName event name
	 * @param version HL7 version
	 * @return message structure name for the eventName and version or <code>null</code> if none
	 *         could be found
	 * @throws HL7Exception if the version is unknown or the message structure list is inaccessible
	 */
	public String getMessageStructureForEvent(String eventName, Version version)
			throws HL7Exception;
}
