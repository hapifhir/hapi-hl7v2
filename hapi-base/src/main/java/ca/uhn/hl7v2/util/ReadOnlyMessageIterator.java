/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "ReadOnlyMessageIterator.java".  Description:
 * "Iterator though existing Stuctures in a message.   "
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2005.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the "GPL"), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 *
 */
package ca.uhn.hl7v2.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Structure;
import ca.uhn.hl7v2.parser.EncodingCharacters;
import ca.uhn.hl7v2.parser.PipeParser;

/**
 * Iterator though existing Stuctures in a message.  No new repetitions or optional 
 * structures are created during iteration (in contrast to MessageIterator).  
 * 
 * Note that some structures are created during parsing, so the iteration may include 
 * structures which were not present in the original encoded message.  If these are 
 * not desired they can be skipped using a FilterIterator.  In fact to obtain an  
 * iterator only over populated segments (not groups or empty segments) use the factory 
 * method in this class.  
 *  
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:27 $ by $Author: jamesagnew $
 */
public class ReadOnlyMessageIterator implements Iterator {

    private List myRemaining; //remaining nodes in reverse order (i.e. last is next)
    
    /**
     * @param theRoot root of depth first iteration, which starts with the first child  
     */
    public ReadOnlyMessageIterator(Group theRoot) {
        myRemaining = new ArrayList(40);
        addChildren(theRoot);
    }
    
    /**
     * @param theRoot root of depth first iteration, which starts with the first child
     * @return an iterator that skips groups and empty segments, returning only populated 
     *      segments  
     */
    public static Iterator createPopulatedSegmentIterator(Group theRoot) {
        Iterator allIterator = new ReadOnlyMessageIterator(theRoot);
        
        FilterIterator.Predicate segmentsOnly = new FilterIterator.Predicate() {
            public boolean evaluate(Object obj) {
                if (Segment.class.isAssignableFrom(obj.getClass())) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        FilterIterator segmentIterator = new FilterIterator(allIterator, segmentsOnly);
        
        final EncodingCharacters ec = new EncodingCharacters('|', "^~\\&");
        FilterIterator.Predicate populatedOnly = new FilterIterator.Predicate() {
            public boolean evaluate(Object obj) {
                String encoded = PipeParser.encode((Segment) obj, ec);                
                if (encoded.length() > 3) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        return new FilterIterator(segmentIterator, populatedOnly);        
    }
    
    private void addChildren(Group theParent) {
        String[] names = theParent.getNames();
        for (int i = names.length - 1; i >= 0; i--) {
            try {
                Structure[] reps = theParent.getAll(names[i]);
                for (int j = reps.length - 1; j >= 0; j--) {
                    myRemaining.add(reps[j]);
                }
            } catch (HL7Exception e) {
                throw new Error("Internal error: an invalid child name was obtained from its parent.");
            }
        }
    }

    /** 
     * @see java.util.Iterator#hasNext()
     */
    public boolean hasNext() {
        return !myRemaining.isEmpty();
    }

    /** 
     * @see java.util.Iterator#next()
     */
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more nodes in message");
        }
        
        Structure next = (Structure) myRemaining.remove(myRemaining.size() - 1);
        
        if (next instanceof Group) {
            addChildren((Group) next);
        }
        
        return next;
    }

    /** 
     * Not supported.  
     */
    public void remove() {
        throw new UnsupportedOperationException("Can't remove a node from a message");
    }

}
