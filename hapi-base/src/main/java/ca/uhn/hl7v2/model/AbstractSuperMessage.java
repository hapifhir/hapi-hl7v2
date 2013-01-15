package ca.uhn.hl7v2.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.util.StringUtil;
import ca.uhn.hl7v2.util.Terser;

/**
 * Base class for a {@link SuperStructure} message.
 * 
 * @see SuperStructure
 * @see Message
 */
public abstract class AbstractSuperMessage extends AbstractMessage implements SuperStructure {

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(AbstractSuperMessage.class);
	private Map<String, Set<String>> myChildNameToStructures = new HashMap<String, Set<String>>();

	private String myName;

	/**
	 * Constructor
	 * 
	 * @param theFactory
	 *            The model class factory
	 */
	public AbstractSuperMessage(ModelClassFactory theFactory) {
		super(theFactory);
	}

	protected void addSuperstructureApplication(String theChild, String theStructure) {
		StringUtil.validateNotEmpty(theChild);
		StringUtil.validateNotEmpty(theStructure);

		if (!myChildNameToStructures.containsKey(theChild)) {
			myChildNameToStructures.put(theChild, new HashSet<String>());
		}
		myChildNameToStructures.get(theChild).add(theStructure);
	}

	/**
	 * Returns the name of this structure (e.g. "ADT_A01", or "ORU_R01"). Note
	 * that for super structures this value is explicitly set by the parser.
	 */
	public String getName() {
		if (StringUtil.isBlank(myName)) {
			String retVal = null;
			try {
				Terser t = new Terser(this);
				retVal = t.get("/MSH-9-3");

				if (StringUtil.isBlank(retVal)) {
					String msh91 = t.get("/MSH-9-1");
					String msh92 = t.get("/MSH-9-2");
					if (StringUtil.isNotBlank(msh91) && StringUtil.isNotBlank(msh92)) {
						retVal = msh91 + "_" + msh92;
					}
				}
			} catch (HL7Exception e) {
				ourLog.debug("Failed to retrieve MSH-9", e);
			}
			return retVal;
		}

		return myName;
	}

	/**
	 * {@inheritDoc}
	 */
	public Set<String> getStructuresWhichChildAppliesTo(String theChildName) {
		return Collections.unmodifiableSet(myChildNameToStructures.get(theChildName));
	}

	/**
	 * Provide the name that will be returned by {@link #getName()}
	 */
	public void setName(String theName) {
		myName = theName;
	}

}
