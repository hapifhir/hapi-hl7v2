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
package ca.uhn.hl7v2.testpanel.model.conn;

import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.Validate;

import ca.uhn.hl7v2.testpanel.controller.Controller;
import ca.uhn.hl7v2.testpanel.model.AbstractModelClass;
import ca.uhn.hl7v2.testpanel.xsd.Hl7V2EncodingTypeEnum;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InboundConnectionList")
public class InboundConnectionList extends AbstractModelClass {

	public static final String PROP_LIST = InboundConnectionList.class.getName() + "_LIST";
	
	private List<InboundConnection> myConnections = new ArrayList<InboundConnection>();

	private transient Controller myController;
	
	public InboundConnectionList() {
	}

	public InboundConnection createDefaultConnection(int port) {
		InboundConnection initialConnection = new InboundConnection();
		initialConnection.setCharSet(Charset.defaultCharset().displayName());
		initialConnection.setDualPort(false);
		initialConnection.setIncomingOrSinglePort(port);
		initialConnection.setHost("localhost");
		initialConnection.setEncoding(Hl7V2EncodingTypeEnum.ER_7);
		initialConnection.setController(myController);
		return initialConnection;
	}

	@Override
	public String exportConfigToXml() {
		StringWriter writer = new StringWriter();
		JAXB.marshal(this, writer);
		return writer.toString();
	}

	public static InboundConnectionList fromXml(Controller theController, String theXml) {
		InboundConnectionList retVal = JAXB.unmarshal(new StringReader(theXml), InboundConnectionList.class);
		retVal.myController = theController;
		
		for (InboundConnection next : retVal.getConnections()) {
			next.setController(theController);
		}
		
		return retVal;
	}

	/**
	 * @return the connections
	 */
	public List<InboundConnection> getConnections() {
		return myConnections;
	}

	public void addConnection(InboundConnection theCon) {
		Validate.notNull(theCon);
		
		myConnections.add(theCon);
		theCon.setController(myController);
		
		firePropertyChange(PROP_LIST, null, null);
	}

	public void removeConnecion(InboundConnection theCon) {
		Validate.notNull(theCon);
		myConnections.remove(theCon);
		firePropertyChange(PROP_LIST, null, null);
	}

	/**
	 * Remove all connections from this list which are not {@link AbstractConnection#isPersistent() persistent}
	 */
	public void removeNonPersistantConnections() {
		for (Iterator<InboundConnection> iter = myConnections.iterator(); iter.hasNext(); ) {
			if (!iter.next().isPersistent()) {
				iter.remove();
			}
		}
	}

	
}
