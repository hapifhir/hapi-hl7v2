package ca.uhn.hl7v2.model.primitive;

import ca.uhn.hl7v2.model.Message;

/**
 * Base class for an ID type which also stores a namespace string
 */
@SuppressWarnings("serial")
public class ISWithNamespace extends IS {

	private String myNamespace;
	private String myHl7Version;

	/**
	 * Constructor
	 */
	public ISWithNamespace(Message theMessage, String theHl7Version, String theNamespace, int theTable) {
		super(theMessage, theTable);
		myHl7Version = theHl7Version;
		myNamespace = theNamespace;
	}


	/**
	 * Constructor
	 */
	public ISWithNamespace(Message theMessage, String theHl7Version, String theNamespace, Integer theTable) {
		super(theMessage, theTable);
		myHl7Version = theHl7Version;
		myNamespace = theNamespace;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return "IS";
	}


	/**
	 * Returns the HL7 version associated with this type instance
	 */
	public String getVersion() {
		return myHl7Version;
	}

	/**
	 * @return Returns the namespace associated with the table for this type
	 */
	public String getTableNamespace() {
		return myNamespace;
	}
	
}
