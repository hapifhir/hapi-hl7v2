/*
 The contents of this file are subject to the Mozilla Public License Version 1.1
 (the "License"); you may not use this file except in compliance with the License.
 You may obtain a copy of the License at http://www.mozilla.org/MPL/
 Software distributed under the License is distributed on an "AS IS" basis,
 WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 specific language governing rights and limitations under the License.

 The Original Code is "Unmodifiable.java".  Description:
 "Factory for unmodifiable wrappers of model classes"

 The Initial Developer of the Original Code is University Health Network. Copyright (C)
 2015.  All Rights Reserved.

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

import ca.uhn.hl7v2.AcknowledgmentCode;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.Location;
import ca.uhn.hl7v2.parser.Parser;

import java.io.IOException;

/**
 * A static helper class that allows to obtain unmodifiable message wrappers, i.e. all modification to these wrappers
 * result in an {@link java.lang.UnsupportedOperationException} or {@link java.lang.IllegalArgumentException}.
 * <p/>
 * Note that these wrappers have no HL7-specific type information, e.g. an {@link UnmodifiableMessage}
 * just implements {@link ca.uhn.hl7v2.model.Message} but not some concrete event type. It is possible
 * to use the {@link ca.uhn.hl7v2.util.Terser}, generic Getter methods, message iterators or visitors.
 * All structures or types returned by these methods will be unmodifiable as well.
 * <p/>
 * Also note that the original message does not automatically become immutable.
 */
public final class Unmodifiable {

    private Unmodifiable() {
    }


    /**
     * Returns an unmodifiable wrapper around the message. When accessing structures or types of the
     * {@link UnmodifiableMessage}, they will be unmodifiable as well. Copying these message parts into a regular
     * message should therefore be done using {@link ca.uhn.hl7v2.util.DeepCopy}.
     *
     * @param msg message to be wrapped
     * @return unmodifiable message wrapper
     */
    public static Message unmodifiableMessage(Message msg) {
        return isUnmodifiable(msg) ? msg : new UnmodifiableMessage(msg);
    }

    /**
     * Parses the string to an {@link UnmodifiableMessage} using the specific HapiContext. When accessing structures or types of the
     * returned message, they will be unmodifiable as well. The returned message caches the original message string,
     * which is returned when calling {@link Message#encode()} or {@link Message#toString()}.
     *
     * @param context HapiContext
     * @param s       message string
     * @return unmodifiable message wrapper
     * @throws HL7Exception if parsing fails
     */
    public static Message unmodifiableMessage(HapiContext context, String s) throws HL7Exception {
        Message msg = context.getGenericParser().parse(s);
        return new UnmodifiableMessage(msg, s);
    }

    /**
     * Returns true if the message instance (or a part thereof) is unmodifiable
     *
     * @param o something HAPI-related
     * @return true if unmodifiable
     */
    public static boolean isUnmodifiable(Object o) {
        return o instanceof UnmodifiableModel;
    }


    @SuppressWarnings("unchecked")
    private static <T extends Type> T unmodifiableType(T type) {
        if (isUnmodifiable(type)) return type;
        if (type instanceof Primitive) return (T) new UnmodifiablePrimitive((Primitive) type);
        if (type instanceof Composite) return (T) new UnmodifiableComposite((Composite) type);
        return (T) new UnmodifiableVaries((Variable) type);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Structure> T unmodifiableStructure(T structure) {
        if (isUnmodifiable(structure)) return structure;
        if (structure instanceof Message) return (T) new UnmodifiableMessage((Message) structure);
        if (structure instanceof Group) return (T) new UnmodifiableGroup((Group) structure);
        return (T) new UnmodifiableSegment((Segment) structure);
    }

    @SuppressWarnings("unchecked")
    private static <T extends MessageVisitor> T unmodifiableVisitor(T visitor) {
        return isUnmodifiable(visitor) ? visitor : (T) new UnmodifiableMessageVisitor(visitor);
    }

    @SuppressWarnings("unchecked")
    private static ExtraComponents unmodifiableExtraComponents(ExtraComponents ec) {
        return isUnmodifiable(ec) ? ec : new UnmodifiableExtraComponents(ec);
    }

    /**
     * Marker interface for unmodifiable message (parts)
     */
    private static interface UnmodifiableModel {
    }


    private static class Delegating<S> {
        private S delegate;

        protected Delegating(S delegate) {
            this.delegate = delegate;
        }

        public S getDelegate() {
            return delegate;
        }

        @Override
        public String toString() {
            return delegate.toString();
        }

        /**
         * Unmodifiable structures should compare against their modifiable
         * delegate. Otherwise a number of iterators and finders would
         * not work properly
         *
         * @param o
         * @return
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o instanceof Delegating) {
                Delegating that = (Delegating) o;
                return delegate.equals(that.delegate);
            }
            if (o.getClass().isAssignableFrom(delegate.getClass())) {
                return delegate.equals(o);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return delegate.hashCode();
        }
    }

    private static class UnmodifiableVisitable<S extends Visitable> extends Delegating<S> implements Visitable, UnmodifiableModel {

        public UnmodifiableVisitable(S delegate) {
            super(delegate);
        }

        public boolean accept(MessageVisitor visitor, Location currentLocation) throws HL7Exception {
            return getDelegate().accept(unmodifiableVisitor(visitor), currentLocation);
        }

        public Location provideLocation(Location parentLocation, int index, int repetition) {
            return getDelegate().provideLocation(parentLocation, index, repetition);
        }

        public boolean isEmpty() throws HL7Exception {
            return getDelegate().isEmpty();
        }
    }


    private abstract static class UnmodifiableStructure<S extends Structure> extends UnmodifiableVisitable<S>
            implements Structure {

        private UnmodifiableStructure(S delegate) {
            super(delegate);
        }

        public Message getMessage() {
            return getDelegate().getMessage();
        }

        public String getName() {
            return getDelegate().getName();
        }

        public Group getParent() {
            return unmodifiableStructure(getDelegate().getParent());
        }

    }

    private static class UnmodifiableSegment<S extends Segment> extends UnmodifiableStructure<S> implements Segment {

        public UnmodifiableSegment(S delegate) {
            super(delegate);
        }

        public String encode() throws HL7Exception {
            return getDelegate().encode();
        }

        public Type[] getField(int number) throws HL7Exception {
            if (number < 1 || number > numFields()) {
                throw new IllegalArgumentException(String.format("Cannot add field with index %d to unmodifiable segment %s " +
                        " - there are currently only %d fields.", number, getName(), numFields()));
            }
            Type[] types = getDelegate().getField(number);
            Type[] unmodifiableTypes = new Type[types.length];
            if (types.length > 0) {
                for (int i = 0; i < types.length; i++) {
                    unmodifiableTypes[i] = unmodifiableType(types[i]);
                }
            }
            return unmodifiableTypes;
        }

        public Type getField(int number, int rep) throws HL7Exception {
            Type[] types = getField(number);
            if (rep >= types.length) {
                throw new IllegalArgumentException(String.format("Cannot add repetition with index %d to unmodifiable field %d " +
                        " - there are currently only %d fields.", rep, number, types.length));
            }
            return types[rep];
        }

        public int getLength(int number) throws HL7Exception {
            return getDelegate().getLength(number);
        }

        public int getMaxCardinality(int number) throws HL7Exception {
            return getDelegate().getMaxCardinality(number);
        }

        public String[] getNames() {
            return getDelegate().getNames();
        }

        public boolean isRequired(int number) throws HL7Exception {
            return getDelegate().isRequired(number);
        }

        public int numFields() {
            return getDelegate().numFields();
        }

        public void parse(String string) throws HL7Exception {
            throw new UnsupportedOperationException("This segment is unmodifiable");
        }
    }

    private static class UnmodifiableGroup<S extends Group> extends UnmodifiableStructure<S> implements Group {
        public UnmodifiableGroup(S delegate) {
            super(delegate);
        }

        public Structure[] getAll(String name) throws HL7Exception {
            Structure[] structures = getDelegate().getAll(name);
            Structure[] unmodifiableStructures = new Structure[structures.length];
            if (structures.length > 0) {
                for (int i = 0; i < structures.length; i++) {
                    unmodifiableStructures[i] = unmodifiableStructure(structures[i]);
                }
            }
            return unmodifiableStructures;
        }

        public Structure get(String name) throws HL7Exception {
            return get(name, 0);
        }

        /**
         * This method does NOT append a trailing repetition, but will instead throw an {@link IndexOutOfBoundsException}
         *
         * @param name name of the structure
         * @param rep  repetition (zero-based)
         * @return element of the repeating structure
         * @throws HL7Exception              if name does not exist
         * @throws IndexOutOfBoundsException if repetition does not exist
         */
        public Structure get(String name, int rep) throws HL7Exception {
            return getAll(name)[rep];
        }

        public boolean isRequired(String name) throws HL7Exception {
            return getDelegate().isRequired(name);
        }

        public boolean isRepeating(String name) throws HL7Exception {
            return getDelegate().isRepeating(name);
        }

        public boolean isChoiceElement(String name) throws HL7Exception {
            return getDelegate().isChoiceElement(name);
        }

        public boolean isGroup(String name) throws HL7Exception {
            return getDelegate().isGroup(name);
        }

        public String[] getNames() {
            return getDelegate().getNames();
        }

        public Class<? extends Structure> getClass(String name) {
            return getDelegate().getClass(name);
        }

        public String addNonstandardSegment(String name) throws HL7Exception {
            throw new UnsupportedOperationException("This group is unmodifiable");
        }

        public String addNonstandardSegment(String name, int theIndex) throws HL7Exception {
            throw new UnsupportedOperationException("This group is unmodifiable");
        }
    }

    private static class UnmodifiableMessage extends UnmodifiableGroup<Message> implements Message {

        private String originalMessage;

        public UnmodifiableMessage(Message delegate, String originalMessage) {
            this(delegate);
            this.originalMessage = originalMessage;
        }

        public UnmodifiableMessage(Message delegate) {
            super(delegate);
        }

        public String getVersion() {
            return getDelegate().getVersion();
        }

        public Character getFieldSeparatorValue() throws HL7Exception {
            return getDelegate().getFieldSeparatorValue();
        }

        public String getEncodingCharactersValue() throws HL7Exception {
            return getDelegate().getEncodingCharactersValue();
        }

        public void setParser(Parser parser) {
            throw new UnsupportedOperationException("This message is unmodifiable");
        }

        public Parser getParser() {
            return getDelegate().getParser();
        }

        public void parse(String string) throws HL7Exception {
            throw new UnsupportedOperationException("This message is unmodifiable");
        }

        public String encode() throws HL7Exception {
            return originalMessage != null ? originalMessage : getDelegate().encode();
        }

        public Message generateACK() throws HL7Exception, IOException {
            return getDelegate().generateACK();
        }

        public Message generateACK(String theAcknowlegementCode, HL7Exception theException) throws HL7Exception, IOException {
            return getDelegate().generateACK(theAcknowlegementCode, theException);
        }

        public Message generateACK(AcknowledgmentCode theAcknowlegementCode, HL7Exception theException) throws HL7Exception, IOException {
            return getDelegate().generateACK(theAcknowlegementCode, theException);
        }

        public String printStructure() throws HL7Exception {
            return getDelegate().printStructure();
        }
    }

    private abstract static class UnmodifiableType<T extends Type> extends UnmodifiableVisitable<T>
            implements Type {

        public UnmodifiableType(T delegate) {
            super(delegate);
        }

        public String getName() {
            return getDelegate().getName();
        }

        public ExtraComponents getExtraComponents() {
            return unmodifiableExtraComponents(getDelegate().getExtraComponents());
        }

        public Message getMessage() {
            return unmodifiableMessage(getDelegate().getMessage());
        }

        public void parse(String string) throws HL7Exception {
            throw new UnsupportedOperationException("This type is unmodifiable");
        }

        public String encode() throws HL7Exception {
            return getDelegate().encode();
        }

        public void clear() {
            throw new UnsupportedOperationException("This type is unmodifiable");
        }

        public Location provideLocation(Location parentLocation, int index, int repetition) {
            return getDelegate().provideLocation(parentLocation, index, repetition);
        }

    }

    private static class UnmodifiablePrimitive extends UnmodifiableType<Primitive> implements Primitive {

        public UnmodifiablePrimitive(Primitive delegate) {
            super(delegate);
        }

        public String getValue() {
            return getDelegate().getValue();
        }

        public void setValue(String value) throws DataTypeException {
            throw new UnsupportedOperationException("This Primitive is unmodifiable");
        }
    }

    private static class UnmodifiableComposite extends UnmodifiableType<Composite> implements Composite {

        public UnmodifiableComposite(Composite delegate) {
            super(delegate);
        }

        public Type[] getComponents() {
            Type[] types = getDelegate().getComponents();
            Type[] unmodifiableTypes = new Type[types.length];
            if (types.length > 0) {
                for (int i = 0; i < types.length; i++) {
                    unmodifiableTypes[i] = unmodifiableType(types[i]);
                }
            }
            return unmodifiableTypes;
        }

        public Type getComponent(int number) throws DataTypeException {
            Type type = getDelegate().getComponent(number);
            return unmodifiableType(type);
        }

    }

    private static class UnmodifiableVaries extends UnmodifiableType<Variable> implements Variable {

        public UnmodifiableVaries(Variable delegate) {
            super(delegate);
        }

        public Type getData() {
            return unmodifiableType(getDelegate().getData());
        }

        public void setData(Type data) throws DataTypeException {
            throw new UnsupportedOperationException("This Varies is unmodifiable");
        }

    }

    private static class UnmodifiableExtraComponents extends ExtraComponents {

        private ExtraComponents delegate;

        public UnmodifiableExtraComponents(ExtraComponents delegate) {
            super(delegate.getMessage());
            this.delegate = delegate;
        }

        @Override
        public int numComponents() {
            return delegate.numComponents();
        }

        @Override
        public boolean isEmpty() throws HL7Exception {
            return delegate.isEmpty();
        }

        @Override
        public Message getMessage() {
            return unmodifiableMessage(delegate.getMessage());
        }

        @Override
        public String toString() {
            return delegate.toString();
        }

        @Override
        public Variable getComponent(int comp) {
            if (comp >= numComponents()) {
                throw new IllegalArgumentException(String.format(
                        "Extra Component with index %d is not available and cannot be added to unmodifiable type", comp));
            }
            return unmodifiableType(delegate.getComponent(comp));
        }

        @Override
        void clear() {
            throw new UnsupportedOperationException("This ExtraComponents is unmodifiable");
        }
    }


    private static class UnmodifiableMessageVisitor extends Delegating<MessageVisitor> implements MessageVisitor, UnmodifiableModel {


        public UnmodifiableMessageVisitor(MessageVisitor delegate) {
            super(delegate);
        }

        public boolean start(Message message) throws HL7Exception {
            return getDelegate().start(unmodifiableMessage(message));
        }

        public boolean end(Message message) throws HL7Exception {
            return getDelegate().end(unmodifiableMessage(message));
        }

        public boolean start(Group group, Location location) throws HL7Exception {
            return getDelegate().start(unmodifiableStructure(group), location);
        }

        public boolean end(Group group, Location location) throws HL7Exception {
            return getDelegate().end(unmodifiableStructure(group), location);
        }

        public boolean start(Segment segment, Location location) throws HL7Exception {
            return getDelegate().start(unmodifiableStructure(segment), location);
        }

        public boolean end(Segment segment, Location location) throws HL7Exception {
            return getDelegate().end(unmodifiableStructure(segment), location);
        }

        public boolean start(Field field, Location location) throws HL7Exception {
            // Field is immutable anyway
            return getDelegate().start(field, location);
        }

        public boolean end(Field field, Location location) throws HL7Exception {
            // Field is immutable anyway
            return getDelegate().end(field, location);
        }

        public boolean start(Composite type, Location location) throws HL7Exception {
            return getDelegate().start(unmodifiableType(type), location);
        }

        public boolean end(Composite type, Location location) throws HL7Exception {
            return getDelegate().end(unmodifiableType(type), location);
        }

        public boolean visit(Primitive type, Location location) throws HL7Exception {
            return getDelegate().visit(unmodifiableType(type), location);
        }
    }

}
