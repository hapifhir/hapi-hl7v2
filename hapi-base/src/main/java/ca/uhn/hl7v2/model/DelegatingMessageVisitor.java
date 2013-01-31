/*
 The contents of this file are subject to the Mozilla Public License Version 1.1
 (the "License"); you may not use this file except in compliance with the License.
 You may obtain a copy of the License at http://www.mozilla.org/MPL/
 Software distributed under the License is distributed on an "AS IS" basis,
 WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 specific language governing rights and limitations under the License.

 The Original Code is "DelegatingMessageVisitor.java ".  Description:
 "Delegating visitor base class"

 The Initial Developer of the Original Code is University Health Network. Copyright (C)
 2013.  All Rights Reserved.

 Contributor(s): ______________________________________.

 Alternatively, the contents of this file may be used under the terms of the
 GNU General Public License (the "GPL"), in which case the provisions of the GPL are
 applicable instead of those above.  If you wish to allow use of your version of this
 file only under the terms of the GPL and not to allow others to use your version
 of this file under the MPL, indicate your decision by deleting  the provisions above
 and replace  them with the notice and other provisions required by the GPL License.
 If you do not delete the provisions above, a recipient may use your version of
 this file under either the MPL or the GPL.
 */

package ca.uhn.hl7v2.model;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.Location;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Delegates all visit method calls to the wrapped MessageVisitor. This class can be used
 */
public class DelegatingMessageVisitor<T extends MessageVisitor> implements MessageVisitor {

    private T delegate;
    protected static final Logger LOG = LoggerFactory.getLogger(DelegatingMessageVisitor.class);

    /**
     * @param delegate MessageVisitor to which all calls are delegated to
     */
    public DelegatingMessageVisitor(T delegate) {
        this.delegate = delegate;
    }

    /**
     * @return MessageVisitor to which all calls are delegated to
     */
    public T getDelegate() {
        return delegate;
    }

    public boolean start(Message message) throws HL7Exception {
        return delegate.start(message);
    }

    public boolean end(Message message) throws HL7Exception {
        return delegate.end(message);
    }

    public boolean start(Group group, Location location) throws HL7Exception {
        return delegate.start(group, location);
    }

    public boolean end(Group group, Location location) throws HL7Exception {
        return delegate.end(group, location);
    }

    public boolean start(Segment segment, Location location) throws HL7Exception {
        return delegate.start(segment, location);
    }

    public boolean end(Segment segment, Location location) throws HL7Exception {
        return delegate.end(segment, location);
    }

    public boolean start(Field field, Location location) throws HL7Exception {
        return delegate.start(field, location);
    }

    public boolean end(Field Field, Location location) throws HL7Exception {
        return delegate.end(Field, location);
    }
    
    public boolean start(Composite type, Location location) throws HL7Exception {
        return delegate.start(type, location);
    }

    public boolean end(Composite type, Location location) throws HL7Exception {
        return delegate.end(type, location);
    }

    public boolean visit(Primitive type, Location location) throws HL7Exception {
        return delegate.visit(type, location);
    }

}
