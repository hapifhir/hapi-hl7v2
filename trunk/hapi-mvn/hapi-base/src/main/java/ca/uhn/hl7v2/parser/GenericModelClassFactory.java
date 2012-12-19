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
import ca.uhn.hl7v2.model.GenericComposite;
import ca.uhn.hl7v2.model.GenericGroup;
import ca.uhn.hl7v2.model.GenericMessage;
import ca.uhn.hl7v2.model.GenericSegment;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Type;

/**
 * <p>
 * GenericModelClassFactory is a {@link ModelClassFactory} implementation 
 * which always returns generic types:
 * </p>
 * <ul>
 * 	<li>{@link GenericMessage}</li>
 * 	<li>{@link GenericSegment}</li>
 * 	<li>{@link GenericGroup}</li>
 * </ul> 
 * 
 * <p>
 * This can be used to run HAPI without any structure JARs, as the generic MCF
 * has no structure dependencies. See the
 * <a href="http://hl7api.sourceforge.net/xref/ca/uhn/hl7v2/examples/HandlingMultipleVersions.html">using multiple versions</a>
 * example for more information.
 * </p>
 * 
 * <p>
 * In combination with {@link ParserConfiguration#setAllowUnknownVersions(boolean)}, the GenericModelClassFactory
 * can be used to parse future versions of HL7 for which HAPI has no support.
 * </p>
 * 
 * @author James Agnew
 */
public class GenericModelClassFactory extends AbstractModelClassFactory {

	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}
	 */
	public Class<? extends Message> getMessageClass(String theName, String theVersion, boolean theIsExplicit) throws HL7Exception {
		return GenericMessage.getGenericMessageClass(theVersion);
	}

	/**
	 * {@inheritDoc}
	 */
	public Class<? extends Message> getMessageClassInASpecificPackage(String theName, String theVersion, boolean theIsExplicit, String thePackageName) throws HL7Exception {
		return GenericMessage.getGenericMessageClass(theVersion);
	}

	/**
	 * {@inheritDoc}
	 */
	public Class<? extends Group> getGroupClass(String theName, String theVersion) throws HL7Exception {
		return GenericGroup.class;
	}

	/**
	 * {@inheritDoc}
	 */
	public Class<? extends Segment> getSegmentClass(String theName, String theVersion) throws HL7Exception {
		return GenericSegment.class;
	}

	/**
	 * {@inheritDoc}
	 */
	public Class<? extends Type> getTypeClass(String theName, String theVersion) throws HL7Exception {
		return GenericComposite.class;
	}

}
