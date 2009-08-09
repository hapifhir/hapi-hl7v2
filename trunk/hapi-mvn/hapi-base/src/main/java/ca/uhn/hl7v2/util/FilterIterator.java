/**
 * This class is based on the Iterators.FilterIterator class from
 * araSpect (araspect.sourceforge.net).  The original copyright follows ...
 *
 * =================================================================
 * Copyright (c) 2001,2002 aragost ag, Z�rich, Switzerland.
 * All rights reserved.
 *
 * This software is provided 'as-is', without any express or implied
 * warranty. In no event will the authors be held liable for any
 * damages arising from the use of this software.
 *
 * Permission is granted to anyone to use this software for any
 * purpose, including commercial applications, and to alter it and
 * redistribute it freely, subject to the following restrictions:
 *
 * 1. The origin of this software must not be misrepresented; you
 *    must not claim that you wrote the original software. If you
 *    use this software in a product, an acknowledgment in the
 *    product documentation would be appreciated but is not required.
 *
 * 2. Altered source versions must be plainly marked as such, and
 *    must not be misrepresented as being the original software.
 *
 * 3. This notice may not be removed or altered from any source
 *    distribution.
 *
 * ==================================================================
 *
 * Changes (c) 2003 University Health Network include the following:
 * - move to non-nested class
 * - collapse inherited method remove()
 * - accept iterator instead of object in constructor
 * - moved to HAPI package
 * - Predicate added as an inner class; also changed to an interface
 *
 * These changes are distributed under the same terms as the original (above). 
 */
package ca.uhn.hl7v2.util;

import java.util.*;

public class FilterIterator<T> implements Iterator<T> {
    
    private Predicate<T> predicate;
    private Iterator<T> iter;
    private T nextObject;
    private boolean nextObjectSet = false;
    
    public FilterIterator(Iterator<T> iter, Predicate<T> predicate) {
        this.iter = iter;
        this.predicate = predicate;
    }
    
    public boolean hasNext() {
        if (nextObjectSet) {
            return true;
        } else {
            return setNextObject();
        }
    }
    
    public T next() {
        if (!nextObjectSet) {
            if (!setNextObject()) {
                throw new NoSuchElementException();
            }
        }
        nextObjectSet = false;
        return nextObject;
    }
    
    /**
     * Set nextObject to the next object. If there are no more
     * objects then return false. Otherwise, return true.
     */
    private boolean setNextObject() {
        while (iter.hasNext()) {
            T object = iter.next();
            if (predicate.evaluate(object)) {
                nextObject = object;
                nextObjectSet = true;
                return true;
            }
        }
        return false;
    }
    
    /** Throws UnsupportedOperationException */
    public void remove() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Interface for evaluating whether an object should be returned by the iterator
     */
    public interface Predicate<T> {
        public boolean evaluate(T obj);
    }
    
}
