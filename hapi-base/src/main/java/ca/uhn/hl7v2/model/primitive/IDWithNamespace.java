package ca.uhn.hl7v2.model.primitive;

import ca.uhn.hl7v2.model.Message;

/**
 * HL7 ID type which also stores a namespace string
 */
@SuppressWarnings("serial")
public class IDWithNamespace extends ID {

	private String myNamespace;
	private String myHl7Version;

	public IDWithNamespace(Message theMessage, String theHl7Version, String theNamespace, int theTable) {
		super(theMessage, theTable);
		myHl7Version = theHl7Version;
		myNamespace = theNamespace;
	}


	public IDWithNamespace(Message theMessage, String theHl7Version, String theNamespace, Integer theTable) {
		super(theMessage, theTable);
		myHl7Version = theHl7Version;
		myNamespace = theNamespace;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return "ID";
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
