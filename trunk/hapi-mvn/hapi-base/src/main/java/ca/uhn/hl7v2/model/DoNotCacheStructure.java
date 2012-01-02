/**
 * 
 */
package ca.uhn.hl7v2.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * {@link Message} classes marked with this annotation should not have their structure cached by
 * the parser. In other words, this annotation is a signal to the parser that one instance
 * of a particular {@link Message} subclass will not have the same structure as another.
 * </p>
 * <p>
 * This annotation is only read if it is applied to a subclass of {@link Message}
 * </p>  
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value=ElementType.TYPE)
public @interface DoNotCacheStructure {

}
