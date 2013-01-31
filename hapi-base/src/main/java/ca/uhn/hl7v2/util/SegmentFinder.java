/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "SegmentFinder.java".  Description:
 * "A tool for getting segments by name within a message or part of a message."
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

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.HL7Exception;
import java.util.regex.*;

/**
 * A tool for getting segments by name within a message or part of a message.
 * @author Bryan Tripp
 */
public class SegmentFinder extends MessageNavigator {
    
    /**
     * Creates a new instance of SegmentFinder.
     * @param root the scope of searches -- may be a whole message or only a branch
     */
    public SegmentFinder(Group root) {
        super(root);
    }
    
    /**
     * Returns the first segment with a name that matches the given pattern, in a depth-first search.  
     * Repeated searches are initiated from the location just AFTER where the last segment was found.
     * Call reset() is this is not desired.  Note: this means that the current location will not be found.
     * @param namePattern the name of the segment to find.  The wildcard * means any number
     *      of arbitrary characters; the wildcard ? one arbitrary character
     *      (eg "P*" or "*ID" or "???" or "P??" would match on PID).
     * @param rep the repetition of the segment to return
     */
    public Segment findSegment(String namePattern, int rep) throws HL7Exception {
        Structure s = null;
        do {
            s = findStructure(namePattern, rep);
        } while (!Segment.class.isAssignableFrom(s.getClass()));
        return (Segment) s;
    }
    
    /**
     * As findSegment(), but will only return a group.
     */
    public Group findGroup(String namePattern, int rep) throws HL7Exception {
        Structure s;
        do {
            s = findStructure(namePattern, rep);
        } while (!Group.class.isAssignableFrom(s.getClass()));
        return (Group) s;
    }
    
    /**
     * Returns the first matching structure AFTER the current position
     */
    private Structure findStructure(String namePattern, int rep) throws HL7Exception {
        Structure s = null;
        
        while (s == null) {
            String currentNameInParent = iterate(false, false);
            String currentName = getCurrentStructure(0).getName();
            if (matches(namePattern, currentName) || matches(namePattern, currentNameInParent)) {
                s = getCurrentStructure(rep);
            }
        }
        return s;
    }
    
    /**
     * Returns the first segment with a name matching the given pattern that is a sibling of
     * the structure at the current location.  Other parts of the message are
     * not searched (in contrast to findSegment).
     * As a special case, if the pointer is at the root, the children of the root
     * are searched.
     * @param namePattern the name of the segment to get.  The wildcad * means any number
     *      of arbitrary characters; the wildard ? one arbitrary character
     *      (eg "P*" or "*ID" or "???" or "P??" would match on PID).
     * @param rep the repetition of the segment to return
     */
    public Segment getSegment(String namePattern, int rep) throws HL7Exception {
        Structure s = getStructure(namePattern, rep);
        if (!Segment.class.isAssignableFrom(s.getClass())) {
            throw new HL7Exception(s.getName() + " is not a segment");
        }
        return (Segment) s;
    }
    
    /**
     * As getSegment() but will only return a group.
     */
    public Group getGroup(String namePattern, int rep) throws HL7Exception {
        Structure s = getStructure(namePattern, rep);
        if (!Group.class.isAssignableFrom(s.getClass())) {
            throw new HL7Exception(s.getName() + " is not a group");
        }
        return (Group) s;
    }
    
    private Structure getStructure(String namePattern, int rep) throws HL7Exception {
        Structure s = null;
        
        if (getCurrentStructure(0).equals(this.getRoot()))
            drillDown(0);
        
        String[] names = getCurrentStructure(0).getParent().getNames();
        for (int i = 0; i < names.length && s == null; i++) {
            if (matches(namePattern, names[i])) {
                toChild(i);
                s = getCurrentStructure(rep);
            }
        }
        
        if (s == null)
            throw new HL7Exception("Can't find " + namePattern + " as a direct child");
        
        return s;
    }
    
    /**
     * Tests whether the given name matches the given pattern.
     */
    /*private boolean matches(String pattern, String candidate) {
        boolean matches = false;
        boolean substring = false;
        if (pattern.substring(0, 1).equals("*")) {
            substring = true;
            pattern = pattern.substring(1);
        }
        
        if (substring && (candidate.indexOf(pattern) >= 0)) {
            matches = true;
        } else if (!substring && candidate.equals(pattern)) {
            matches = true;
        }
        return matches;
    }*/
    
    /**
     * Tests whether the given name matches the given pattern.
     */
    private boolean matches(String pattern, String candidate) {
        //shortcut ...
        if (pattern.equals(candidate)) {
            return true;
        }
        
        if (!Pattern.matches("[\\w\\*\\?]*", pattern)) 
            throw new IllegalArgumentException("The pattern " + pattern + " is not valid.  Only [\\w\\*\\?]* allowed.");
        
        pattern = Pattern.compile("\\*").matcher(pattern).replaceAll(".*");
        pattern = Pattern.compile("\\?").matcher(pattern).replaceAll(".");
        
        return Pattern.matches(pattern, candidate);
    }
}
