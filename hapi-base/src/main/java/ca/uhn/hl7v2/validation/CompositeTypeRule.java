package ca.uhn.hl7v2.validation;

import ca.uhn.hl7v2.model.Composite;

/**
 * A validation rule that applies to a fully populated composite type. Composite rules may be called
 * (depending on runtime configuration) just after an inbound message is parsed, or just before an
 * outbound message is encoded.
 * 
 * @author Christian Ohr
 */
public interface CompositeTypeRule extends Rule<Composite> {

}
