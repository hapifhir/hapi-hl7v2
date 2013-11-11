/**
The contents of this file are subject to the Mozilla Public License Version 1.1
(the "License"); you may not use this file except in compliance with the License.
You may obtain a copy of the License at http://www.mozilla.org/MPL/
Software distributed under the License is distributed on an "AS IS" basis,
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
specific language governing rights and limitations under the License.

The Initial Developer of the Original Code is University Health Network. Copyright (C)
2001.  All Rights Reserved.

Contributor(s): ______________________________________.

Alternatively, the contents of this file may be used under the terms of the
GNU General Public License (the  "GPL"), in which case the provisions of the GPL are
applicable instead of those above.  If you wish to allow use of your version of this
file only under the terms of the GPL and not to allow others to use your version
of this file under the MPL, indicate your decision by deleting  the provisions above
and replace  them with the notice and other provisions required by the GPL License.
If you do not delete the provisions above, a recipient may use your version of
this file under either the MPL or the GPL.

 */
package ca.uhn.hl7v2.parser;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.util.ReflectionUtil;

/**
 * Specialized version of ModelClassFactory that always returns the same version
 * or even structure. This is useful when designing applications which are
 * expected to handle multiple versions of HL7. The recommended approach is to
 * configure this factory to handle the newest version of HL7 you intend to
 * support. Since HL7 is a backwards compatible protocol, older versions should
 * always be able to parse correctly into a newer message structure.
 * 
 * @version $Revision: 1.2 $ updated on $Date: 2009-10-03 15:25:46 $ by $Author:
 *          jamesagnew $
 * @author This ModelClassFactory implementation is modified by
 *         Niranjan.Sharma@med.ge.com on 27-Jul-2009 for CanonicalModel of V2.6
 */
public class CanonicalModelClassFactory extends DefaultModelClassFactory {

	private static final long serialVersionUID = -1795680089524220526L;

	private Class<? extends Message> myMessageClass;

	private String myVersion;

	/**
	 * Constructor which selects the newest version of HAPI known to
	 */
	public CanonicalModelClassFactory() {
		myVersion = getHighestKnownVersion();
	}

	/**
	 * Constructor for a model class factory which always returns the same
	 * message type.
	 * 
	 * @see ca.uhn.hl7v2.model.SuperStructure
	 */
	public CanonicalModelClassFactory(Class<? extends Message> theClass) {
		if (theClass == null) {
			throw new NullPointerException("Class may not be null");
		}
		myMessageClass = theClass;
	}

	/**
	 * Constructor
	 * 
	 * @param theVersion
	 *            The version to always return (e.g. "2.6")
	 */
	public CanonicalModelClassFactory(String theVersion) {
		if (theVersion == null || !Version.supportsVersion(theVersion)) {
			throw new IllegalArgumentException("Unknown version: " + theVersion);
		}
		myVersion = theVersion;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Class<? extends Group> getGroupClass(String theName, String theVersion) throws HL7Exception {
		return super.getGroupClass(theName, myVersion);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Class<? extends Message> getMessageClass(String theName, String theVersion, boolean theIsExplicit) throws HL7Exception {
		if (myMessageClass != null) {
			return myMessageClass;
		}
		initVersionIfNeeded();
		return super.getMessageClass(theName, myVersion, theIsExplicit);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Class<? extends Segment> getSegmentClass(String theName, String theVersion) throws HL7Exception {
		initVersionIfNeeded();
		return super.getSegmentClass(theName, myVersion);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Class<? extends Type> getTypeClass(String theName, String theVersion) throws HL7Exception {
		initVersionIfNeeded();
		return super.getTypeClass(theName, myVersion);
	}

	private void initVersionIfNeeded() throws HL7Exception {
		if (myMessageClass != null && myVersion == null) {
			myVersion = ReflectionUtil.instantiateMessage(myMessageClass, this).getVersion();
		}
	}

}
