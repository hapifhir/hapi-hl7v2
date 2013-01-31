/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "MessageNaviagtor.java".  Description:
 * "Used to navigate the nested group structure of a message."
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2002.  All Rights Reserved.
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

import java.util.*;
import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Used to navigate the nested group structure of a message.  This is an alternate
 * way of accessing parts of a message, ie rather than getting a segment through
 * a chain of getXXX() calls on the message, you can create a MessageNavigator
 * for the message, "navigate" to the desired segment, and then call
 * getCurrentStructure() to get the segment you have navigated to.  A message
 * navigator always has a "current location" pointing to some structure location (segment
 * or group location) within the message.  Note that a location exists whether or
 * not there are any instances of the structure at that location. </p>
 * <p>This class is used by Terser, which presents an even more convenient way
 * of navigating a message.  </p>
 * <p>This class also has an iterate() method, which iterates over
 * segments (and optionally groups).  </p>
 * @author Bryan Tripp
 */
public class MessageNavigator {
    
    private Group root;
    private Stack<GroupContext> ancestors;
    private int currentChild; // -1 means current structure is current group (special case used for root)
    private Group currentGroup;
    private String[] childNames;
    
    /**
     * Creates a new instance of MessageNavigator
     * @param root the root of navigation -- may be a message or a group
     *      within a message.  Navigation will only occur within the subtree
     *      of which the given group is the root.
     */
    public MessageNavigator(Group root) {
        this.root = root;
        reset();
    }
    
    public Group getRoot() {
        return this.root;
    }
       
    /**
     * Drills down into the group at the given index within the current
     * group -- ie sets the location pointer to the first structure within the child
     * @param childNumber the index of the group child into which to drill
     * @param rep the group repetition into which to drill
     */
    public void drillDown(int childNumber, int rep) throws HL7Exception {
        if (childNumber != -1) {
            Structure s = currentGroup.get(childNames[childNumber], rep);
            if (!(s instanceof Group)) {
                throw new HL7Exception("Can't drill into segment");
            }
            Group group = (Group) s;
            
            //stack the current group and location
            GroupContext gc = new GroupContext(this.currentGroup, this.currentChild);
            this.ancestors.push(gc);
            
            this.currentGroup = group;
        }
        
        this.currentChild = 0;
        this.childNames = this.currentGroup.getNames();
    }
    
    /**
     * Drills down into the group at the CURRENT location.
     */
    public void drillDown(int rep) throws HL7Exception {
        drillDown(this.currentChild, rep);
    }
    
    /**
     * Switches the group context to the parent of the current group,
     * and sets the child pointer to the next sibling.
     * @return false if already at root
     */
    public boolean drillUp() {
        //pop the top group and resume search there
        if (!this.ancestors.empty()) {
            GroupContext gc = (GroupContext) this.ancestors.pop();
            this.currentGroup = gc.group;
            this.currentChild = gc.child;
            this.childNames = this.currentGroup.getNames();
            return true;
        } else {
            if (this.currentChild == -1) {
                return false;
            } else {
                this.currentChild = -1;
                return true;
            }
        }
    }
    
    /**
     * Returns true if there is a sibling following the current location.
     */
    public boolean hasNextChild() {
        return (this.childNames.length > this.currentChild + 1);
    }
    
    /**
     * Moves to the next sibling of the current location.
     */
    public void nextChild() throws HL7Exception {
        toChild(this.currentChild + 1);
    }
    
    /**
     * Moves to the sibling of the current location at the specified index.
     * @return 
     */
    public String toChild(int child) throws HL7Exception {
        if (child >= 0 && child < this.childNames.length) {
            this.currentChild = child;
            return this.childNames[child];
        } else {
            throw new HL7Exception("Can't advance to child " + child + " -- only " + this.childNames.length + " children");
        }
    }
    
    /** Resets the location to the beginning of the tree (the root) */
    public void reset() {
        this.ancestors = new Stack<GroupContext>();
        this.currentGroup = root;
        this.currentChild = -1;
        this.childNames = currentGroup.getNames();
    }
    
    /**
     * Returns the given rep of the structure at the current location.  
     * If at root, always returns the root (the rep is ignored).  
     */
    public Structure getCurrentStructure(int rep) throws HL7Exception {
        if (this.currentChild != -1) {
            String childName = this.childNames[this.currentChild];
            return this.currentGroup.get(childName, rep);
        }
        return this.currentGroup;
    }
    
    /** 
     * Returns the group within which the pointer is currently located. 
     * If at the root, the root is returned.  
     */
    public Group getCurrentGroup() {
        return this.currentGroup;
    }
    
    /**
     * Returns the array of structures at the current location.  
     * Throws an exception if pointer is at root.  
     */
    public Structure[] getCurrentChildReps() throws HL7Exception {
        if (this.currentGroup == this.root && this.currentChild == -1) 
            throw new HL7Exception("Pointer is at root of navigator: there is no current child");
        
        String childName = this.childNames[this.currentChild];
        return this.currentGroup.getAll(childName);
    }
    
    /**
     * Iterates through the message tree to the next segment/group location (regardless
     * of whether an instance of the segment exists).  If the end of the tree is
     * reached, starts over at the root.  Only enters the first repetition of a
     * repeating group -- explicit navigation (using the drill...() methods) is
     * necessary to get to subsequent reps.
     * @param segmentsOnly if true, only stops at segments (not groups)
     * @param loop if true, loops back to beginning when end of msg reached; if false,
     *      throws HL7Exception if end of msg reached
     * @return Returns the name of the next item within its parent, or "" for the root (message)
     */
    public String iterate(boolean segmentsOnly, boolean loop) throws HL7Exception { 
        Structure start = null;
        
        if (this.currentChild == -1) {
            start = this.currentGroup; 
        } else {
            start = (this.currentGroup.get(this.childNames[this.currentChild]));
        }
        
        //using a non-existent direction and not allowing segment creation means that only
        //the first rep of anything is traversed.
        Iterator<Structure> it = new MessageIterator(start, "doesn't exist", false);
        if (segmentsOnly) {
            it = new FilterIterator<Structure>(it, new StructurePredicate(Segment.class));
        }
        
        if (it.hasNext()) {
            Structure next = it.next();
            return drillHere(next);
        } else if (loop) {
            this.reset();
            return "";
        } else {
            throw new HL7Exception("End of message reached while iterating without loop");
        }
            
    }
    
    /**
     * Navigates to a specific location in the message
     * @return 
     */
    private String drillHere(Structure destination) throws HL7Exception {
        Structure pathElem = destination;
        Stack<Structure> pathStack = new Stack<Structure>();
        Stack<MessageIterator.Index> indexStack = new Stack<MessageIterator.Index>();
        do {
            MessageIterator.Index index = MessageIterator.getIndex(pathElem.getParent(), pathElem);
            indexStack.push(index);
            pathElem = pathElem.getParent();
            pathStack.push(pathElem);
        } while (!root.equals(pathElem) && !Message.class.isAssignableFrom(pathElem.getClass()));
        
        if (!root.equals(pathElem)) {
            throw new HL7Exception("The destination provided is not under the root of this navigator");
        }
        
        this.reset();
        String retVal = null;
        while (!pathStack.isEmpty()) {
            Group parent = (Group) pathStack.pop();
            MessageIterator.Index index = indexStack.pop();
            int child = search(parent.getNames(), index.name);
            if (!pathStack.isEmpty()) {
                this.drillDown(child, 0);
            } else {
                retVal= this.toChild(child);
            }
        }
        
        return retVal;
    }
    
    /** Like Arrays.binarySearch, only probably slower and doesn't require
     * a sorted list.  Also just returns -1 if item isn't found. */
    private int search(Object[] list, Object item) {
        int found = -1;
        for (int i = 0; i < list.length && found == -1; i++) {
            if (list[i].equals(item)) found = i;
        }
        return found;
    }
    
    /**
     * A structure to hold current location information at
     * one level of the message tree.  A stack of these
     * identifies the current location completely.
     */
    private class GroupContext {
        public Group group;
        public int child;
        
        public GroupContext(Group g, int c) {
            group = g;
            child = c;
        }
    }
    
}
