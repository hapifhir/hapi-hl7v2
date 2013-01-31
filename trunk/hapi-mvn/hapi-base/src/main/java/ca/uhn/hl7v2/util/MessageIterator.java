package ca.uhn.hl7v2.util;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Structure;

/**
 * Iterates over all defined nodes (ie segments, groups) in a message, 
 * regardless of whether they have been instantiated previously.  This is a 
 * tricky process, because the number of nodes is infinite, due to infinitely 
 * repeating segments and groups.  See <code>next()</code> for details on 
 * how this is handled. 
 * 
 * This implementation assumes that the first segment in each group is present (as per
 * HL7 rules).  Specifically, when looking for a segment location, an empty group that has 
 * a spot for the segment will be overlooked if there is anything else before that spot. 
 * This may result in surprising (but sensible) behaviour if a message is missing the 
 * first segment in a group. 
 *  
 * @author Bryan Tripp
 */
public class MessageIterator implements java.util.Iterator<Structure> {

    private Structure currentStructure; 
    private String direction;
    private Position next;
    private boolean handleUnexpectedSegments;
    
    private static final Logger log = LoggerFactory.getLogger(MessageIterator.class);
    
    /* may add configurability later ... 
    private boolean findUpToFirstRequired;
    private boolean findFirstDescendentsOnly;
    
    public static final String WHOLE_GROUP;
    public static final String FIRST_DESCENDENTS_ONLY;
    public static final String UP_TO_FIRST_REQUIRED;
    */
     
    /** Creates a new instance of MessageIterator */
    public MessageIterator(Structure start, String direction, boolean handleUnexpectedSegments) {
        this.currentStructure = start;
        this.direction = direction;
        this.handleUnexpectedSegments = handleUnexpectedSegments;
    }
    
    /* for configurability (maybe to add later, replacing hard-coded options
      in nextFromEndOfGroup) ... 
    public void setSearchLevel(String level) {
        if (WHOLE_GROUP.equals(level)) {
            this.findUpToFirstRequired = false;
            this.findFirstDescendentsOnly = false;
        } else if (FIRST_DESCENDENTS_ONLY.equals(level)) {
            this.findUpToFirstRequired = false;
            this.findFirstDescendentsOnly = true;
        } else if (UP_TO_FIRST_REQUIRED.equals(level)) {
            this.findUpToFirstRequired = true;
            this.findFirstDescendentsOnly = false;
        } else {
            throw IllegalArgumentException(level + " is not a valid search level.  Should be WHOLE_GROUP, etc.");
        }     
    }
    
    public String getSearchLevel() {
        String level = WHOLE_GROUP;
        if (this.findFirstDescendentsOnly) {
            level = FIRST_DESCENDENTS_ONLY;
        } else if (this.findUpTpFirstRequired) {
            level = UP_TO_FIRST_REQUIRED;
        }
        return level;
    }*/
     
    
    /**
     * Returns true if another object exists in the iteration sequence.  
     */
    public boolean hasNext() {
        boolean has = true;
        if (next == null) {
            if (Group.class.isAssignableFrom(currentStructure.getClass())) {
                groupNext((Group) currentStructure);
            } else {
                Group parent = currentStructure.getParent();
                Index i = getIndex(parent, currentStructure);
                Position currentPosition = new Position(parent, i);
                
                try {                    
                    if (parent.isRepeating(i.name) && currentStructure.getName().equals(direction)) {
                        nextRep(currentPosition);
                    } else {
                        has = nextPosition(currentPosition, this.direction, this.handleUnexpectedSegments);
                    }
                } catch (HL7Exception e) {
                    throw new Error("HL7Exception arising from bad index: " + e.getMessage());
                }
            }
        }
        log.debug("MessageIterator.hasNext() in direction {}? {}", direction, has);
        return has;
    }
    
    /**
     * Sets next to the first child of the given group (iteration 
     * always proceeds from group to first child). 
     */
    private void groupNext(Group current) {
        next = new Position(current, current.getNames()[0], 0);
    }
    
    /**
     * Sets next to the next repetition of the current structure.  
     */ 
    private void nextRep(Position current) {        
        next = new Position(current.parent, current.index.name, current.index.rep + 1);
    }
    
    /**
     * Sets this.next to the next position in the message (from the given position), 
     * which could be the next sibling, a new segment, or the next rep 
     * of the parent.  See next() for details. 
     */
    private boolean nextPosition(Position currPos, String direction, boolean makeNewSegmentIfNeeded) throws HL7Exception {
        boolean nextExists = true;
        if (isLast(currPos)) {
            nextExists = nextFromGroupEnd(currPos, direction, makeNewSegmentIfNeeded);
        } else {
            nextSibling(currPos);
        }
        return nextExists;
    }
    
    /** Navigates from end of group */
    private boolean nextFromGroupEnd(Position currPos, String direction, boolean makeNewSegmentIfNeeded) throws HL7Exception {
        assert isLast(currPos);
        boolean nextExists = true;
        
        //the following conditional logic is a little convoluted -- its meant as an optimization 
        // i.e. trying to avoid calling matchExistsAfterCurrentPosition
        
        if (!makeNewSegmentIfNeeded && Message.class.isAssignableFrom(currPos.parent.getClass())) {
            nextExists = false;
        } else if (!makeNewSegmentIfNeeded || matchExistsAfterPosition(currPos, direction, false, true)) {     
            Group grandparent = currPos.parent.getParent();
            Index parentIndex = getIndex(grandparent, currPos.parent);
            Position parentPos = new Position(grandparent, parentIndex);
            
            try {
                boolean parentRepeats = parentPos.parent.isRepeating(parentPos.index.name);                
                if (parentRepeats && contains(parentPos.parent.get(parentPos.index.name, 0), direction, false, true)) {
                    nextRep(parentPos);
                } else {
                    nextExists = nextPosition(parentPos, direction, makeNewSegmentIfNeeded);
                }
            } catch (HL7Exception e) {
                throw new Error("HL7Exception arising from bad index: " + e.getMessage());
            }
        } else {
            newSegment(currPos.parent, direction);
        }
        return nextExists;
    }
    
    /** 
     * A match exists for the given name somewhere after the given position (in the 
     * normal serialization order).  
     * @param pos the message position after which to look (note that this specifies 
     *      the message instance)
     * @param name the name of the structure to look for
     * @param firstDescendentsOnly only searches the first children of a group 
     * @param upToFirstRequired only searches the children of a group up to the first 
     *      required child (normally the first one).  This is used when we are parsing 
     *      a message in order and looking for a place to parse a particular segment -- 
     *      if the message is correct then it can't go after a required position of a 
     *      different name. 
     */
    public static boolean matchExistsAfterPosition(Position pos, String name, boolean firstDescendentsOnly, boolean upToFirstRequired) throws HL7Exception {
        boolean matchExists = false;
        
        //check next rep of self (if any)
        if (pos.parent.isRepeating(pos.index.name)) {            
            Structure s = pos.parent.get(pos.index.name, pos.index.rep);
            matchExists = contains(s, name, firstDescendentsOnly, upToFirstRequired);
        } 
        
        //check later siblings (if any) 
        if (!matchExists) {
            String[] siblings = pos.parent.getNames();
            boolean after = false;
            for (int i = 0; i < siblings.length && !matchExists; i++) {
                if (after) {
                    matchExists = contains(pos.parent.get(siblings[i]), name, firstDescendentsOnly, upToFirstRequired);
                    if (upToFirstRequired && pos.parent.isRequired(siblings[i])) break; 
                }
                if (pos.index.name.equals(siblings[i])) after = true;                
            } 
        }
        
        //recurse to parent (if parent is not message root)
        if (!matchExists && !Message.class.isAssignableFrom(pos.parent.getClass())) {
            Group grandparent = pos.parent.getParent();
            Position parentPos = new Position(grandparent, getIndex(grandparent, pos.parent));
            matchExists = matchExistsAfterPosition(parentPos, name, firstDescendentsOnly, upToFirstRequired);
        }
        log.debug("Match exists after position {} for {}? {}", new Object[] {pos, name, matchExists});
        return matchExists;
    }
    
    /** 
     * Sets the next position to a new segment of the given name, within the 
     * given group. 
     */
    private void newSegment(Group parent, String name) throws HL7Exception {
        log.info("MessageIterator creating new segment: {}", name);
        parent.addNonstandardSegment(name);
        next = new Position(parent, parent.getNames()[parent.getNames().length-1], 0);
    }
    
    /** 
     * Determines whether the given structure matches the given name, or contains 
     * a child that does.  
     * @param s the structure to check 
     * @param name the name to look for 
     * @param firstDescendentsOnly only checks first descendents (i.e. first 
     *      child, first child of first child, etc.)  In theory the first child 
     *      of a group should always be present, and we don't use this method with 
     *      subsequent children because finding the next position within a group is 
     *      straightforward.  
     * @param upToFirstRequired only checks first descendents and of their siblings 
     *      up to the first required one.  This may be needed because in practice 
     *      some first children of groups are not required.  
     */
    public static boolean contains(Structure s, String name, boolean firstDescendentsOnly, boolean upToFirstRequired) {
        boolean contains = false;
        if (Segment.class.isAssignableFrom(s.getClass())) {
            if (s.getName().equals(name)) contains = true;            
        } else {
            Group g = (Group) s;
            String[] names = g.getNames();
            for (int i = 0; i < names.length && !contains; i++) {
                try {
                    contains = contains(g.get(names[i], 0), name, firstDescendentsOnly, upToFirstRequired);                
                    if (firstDescendentsOnly) break;
                    if (upToFirstRequired && g.isRequired(names[i])) break; 
                } catch (HL7Exception e) {
                    throw new Error("HL7Exception due to bad index: " + e.getMessage());
                }
            }
        }
        return contains;
    }
    
    /**
     * Tests whether the name of the given Index matches 
     * the name of the last child of the given group. 
     */
    public static boolean isLast(Position p) {
        String[] names = p.parent.getNames();
        return names[names.length-1].equals(p.index.name);
    }
    
    /**
     * Sets the next location to the next sibling of the given 
     * index.  
     */
    private void nextSibling(Position pos) {
        String[] names = pos.parent.getNames();
        int i = 0;
        for (; i < names.length && !names[i].equals(pos.index.name); i++) {}
        String nextName = names[i+1];
        
        this.next = new Position(pos.parent, nextName, 0);
    }
    
    /**
     * <p>Returns the next node in the message.  Sometimes the next node is 
     * ambiguous.  For example at the end of a repeating group, the next node 
     * may be the first segment in the next repetition of the group, or the 
     * next sibling, or an undeclared segment locally added to the group's end.  
     * Cases like this are disambiguated using getDirection(), which returns  
     * the name of the structure that we are "iterating towards".  
     * Usually we are "iterating towards" a segment of a certain name because we 
     * have a segment string that we would like to parse into that node. 
     * Here are the rules: </p>
     * <ol><li>If at a group, next means first child.</li>
     * <li>If at a non-repeating segment, next means next "position"</li>
     * <li>If at a repeating segment: if segment name matches 
     * direction then next means next rep, otherwise next means next "position".</li>
     * <li>If at a segment within a group (not at the end of the group), next "position" 
     * means next sibling</li>
     * <li>If at the end of a group: If name of group or any of its "first 
     * decendents" matches direction, then next position means next rep of group.  Otherwise 
     * if direction matches name of next sibling of the group, or any of its first 
     * descendents, next position means next sibling of the group.  Otherwise, next means a 
     * new segment added to the group (with a name that matches "direction").  </li>
     * <li>"First descendents" means first child, or first child of the first child, 
     * or first child of the first child of the first child, etc. </li> </ol>
     */
    public Structure next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more nodes in message");
        }
        try {
            this.currentStructure = next.parent.get(next.index.name, next.index.rep);
        } catch (HL7Exception e) {
            throw new NoSuchElementException("HL7Exception: " + e.getMessage());
        }
        clearNext();
        return this.currentStructure;
    }
    
    /** Not supported */
    public void remove() {
        throw new UnsupportedOperationException("Can't remove a node from a message");
    }
    
    public String getDirection() {
        return this.direction;
    }
    
    public void setDirection(String direction) {
        clearNext();
        this.direction = direction;
    }
    
    private void clearNext() {
        next = null;
    }
    
    /**
     * Returns the index of the given structure as a child of the 
     * given parent.  Returns null if the child isn't found. 
     */
    public static Index getIndex(Group parent, Structure child) {
        Index index = null;
        String[] names = parent.getNames();
        findChild : for (int i = 0; i < names.length; i++) {
            if (names[i].startsWith(child.getName())) {
                try {
                    Structure[] reps = parent.getAll(names[i]);
                    for (int j = 0; j < reps.length; j++) {
                        if (child == reps[j]) {
                            index = new Index(names[i], j);
                            break findChild; 
                        }
                    }
                } catch (HL7Exception e) {
                    log.error(e.getMessage(), e);
                    throw new Error("Internal HL7Exception finding structure index: " + e.getMessage());
                }
            }
        }
        return index;
    }
    
    /** 
     * An index of a child structure within a group, consisting of the name and rep of 
     * of the child.
     */
    public static class Index {
        public String name;
        public int rep;
        public Index(String name, int rep) {
            this.name = name;
            this.rep = rep;
        }
        
        /** @see Object#equals */
        public boolean equals(Object o) {
            boolean equals = false;
            if (o != null && o instanceof Index) {
                Index i = (Index) o;
                if (i.rep == rep && i.name.equals(name)) equals = true;
            }
            return equals;
        }
        
        /** @see Object#hashCode */
        public int hashCode() {
            return name.hashCode() + 700 * rep;
        }
        
        /** @see Object#toString */        
        public String toString() {
            return this.name + ":" + this.rep;
        }
    }
    
    /**
     * A structure position within a message. 
     */
    public static class Position {
        public Group parent;
        public Index index;
        public Position(Group parent, String name, int rep) {
            this.parent = parent;
            this.index = new Index(name, rep);
        }
        public Position(Group parent, Index i) {
            this.parent = parent;
            this.index = i;
        }

        /** @see Object#equals */
        public boolean equals(Object o) {
            boolean equals = false;
            if (o != null && o instanceof Position) {
                Position p = (Position) o;
                if (p.parent.equals(parent) && p.index.equals(index)) equals = true;
            }
            return equals;
        }
        
        /** @see Object#hashCode */
        public int hashCode() {
            return parent.hashCode() + index.hashCode();
        }
        
        public String toString() {
            StringBuffer ret = new StringBuffer(parent.getName());
            ret.append(":");
            ret.append(index.name);
            ret.append("(");
            ret.append(index.rep);
            ret.append(")");
            return ret.toString();           
        }
    }
}
