/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "IStructureDefinition.java"
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2001.  All Rights Reserved.
 *
 * Contributor(s):
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  �GPL�), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 *
 */


package ca.uhn.hl7v2.parser;

import java.util.List;
import java.util.Set;

import ca.uhn.hl7v2.model.Structure;

/**
 * Contains information about the composition of a given type of {@link Structure}.
 * At runtime, parsers will use accessors provided by various structure types (messages, groups,
 * segments) to determine the structure of a messages. Structure definitions are used
 * to cache that information between parse calls.
 */
public interface IStructureDefinition {

    /**
     * @return Returns this structure's first sibling (in other words, its
     *         parent's first child). Returns
     *         <code>null<code> if this is the first sibling, or if this has no parent
     */
    IStructureDefinition getFirstSibling();

    /**
     * @return Returns the next leaf (segment) after this one, within the same
     * group, only if one exists and this structure is also a leaf. Otherwise returns <code>null</code>.
     */
    IStructureDefinition getNextLeaf();

    /**
     * @return The name of the segment, as it is known to it's parent. This
     * will differ from {{@link #getName()}} in the case of multiple segments
     * with the same name in a group, e.g. the two PID segments in ADT_A17,
     * where the second one it known as PID2 to it's parent. 
     */
    String getNameAsItAppearsInParent();
    
    /**
     * @return Returns the name of this structure
     */
    String getName();

    /**
     * @return Returns true if this structure is a segment
     */
    boolean isSegment();

    /**
     * @return Returns true if this is a repeatable structure
     */
    boolean isRepeating();

    /**
     * @return Returns all children of this structure definition
     */
    List<StructureDefinition> getChildren();

    /**
     * @return Returns the index of the position of this structure
     * within it's parent's children
     */
    int getPosition();

    /**
     * @return Returns the parent structure of this structure, if one exists.
     * Otherwise, returns null.
     */
    IStructureDefinition getParent();

    /**
     * @return Returns true if this structure is the final child of it's parent.
     */
    boolean isFinalChildOfParent();

    /**
     * @return Returns this structure's next sibling within it's parent, if any.
     */
    IStructureDefinition getNextSibling();

    /**
     * @return Does this structure have children (i.e. is it not a segment)
     */
    boolean hasChildren();

    /**
     * Should only be called on a leaf node (segment). Returns the names
     * of all valid children which may follow this one, at any level in the
     * hierarchy (including as later siblings of parent structures to
     * this one)
     */
    Set<String> getNamesOfAllPossibleFollowingLeaves();

    /**
     * May return null
     * @return
     */
    IStructureDefinition getFirstChild();

    /**
     * Returns the names of any possible children that could be the first
     * required child of this group.
     *
     * For instance, for the group below "ORC" and "OBR" would both be
     * returned, as they are both potential first children of this group.
     *
     * Note that the name returned by {@link #getName() this.getName()}
     * is also returned.
     *
     * <code>
     *               ORDER_OBSERVATION
     *	  {
     *	  [ ORC ]
     *	  OBR
     *	  [ { NTE } ]
     *	  [ CTD ]
     *	                OBSERVATION
     *	     {
     *	     [ OBX ]
     *	     [ { NTE } ]
     *	     }
     *	                OBSERVATION
     *	  [ { FT1 } ]
     *	  [ { CTI } ]
     *	  }
     *	                ORDER_OBSERVATION
     *	   </code>
     *
     */
    Set<String> getAllPossibleFirstChildren();

    /**
     * @return Returns the names of all children of this structure, including first elements within child groups
     */
    Set<String> getAllChildNames();

    /**
     * @return Is this a required structure within it's parent
     */
    boolean isRequired();

}
