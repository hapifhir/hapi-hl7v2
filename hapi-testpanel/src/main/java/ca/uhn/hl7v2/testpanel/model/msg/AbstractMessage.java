/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is ""  Description:
 * ""
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2001.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  "GPL"), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 */
package ca.uhn.hl7v2.testpanel.model.msg;

import java.beans.PropertyVetoException;
import java.util.UUID;

import ca.uhn.hl7v2.testpanel.model.AbstractModelClass;
import ca.uhn.hl7v2.testpanel.xsd.MessageDefinition;

public abstract class AbstractMessage<T> extends AbstractModelClass {

	public static final String PARSED_MESSAGE_PROPERTY = AbstractMessage.class.getName() + "PARSED_MESSAGE_PROPERTY";
	public static final String SOURCE_MESSAGE_PROPERTY = AbstractMessage.class.getName() + "SOURCE_MESSAGE_PROPERTY";

	private String myId;

	/**
	 * Constructor
	 */
	public AbstractMessage() {
		super();
		myId = UUID.randomUUID().toString();
	}

	public AbstractMessage(MessageDefinition theConfig) {
		myId = theConfig.getId();
	}

	public AbstractMessage(String theId) {
		myId = theId;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean equals(Object theObj) {
		return this == theObj;
	}

	/**
	 * Subclasses should make use of this method to export AbstractInterface
	 * properties into the return value for {@link #exportConfigToXml()}
	 */
	protected MessageDefinition exportConfig(MessageDefinition theConfig) {
		return theConfig;
	}

	/**
	 * Declare a concrete type for subclass implementations of this method
	 */
	@Override
	public abstract MessageDefinition exportConfigToXml();

	public String getId() {
		return myId;
	}

	// ~ Methods
	// --------------------------------------------------------------------------------------------------------

	public abstract Class<? extends T> getMessageClass();

	public abstract T getParsedMessage();

	public abstract String getSourceMessage();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int hashCode() {
		return super.hashCode();
	}

	/**
	 * On successful completion, should fire {@link #SOURCE_MESSAGE_PROPERTY}
	 */
	public abstract void setSourceMessage(String theSourceMessage) throws PropertyVetoException;

}
