/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "Group.java".  Description: 
"An abstraction representing >1 message parts which may repeated together.
  An implementation of Group should enforce contraints about on the contents of the group
  and throw an exception if an attempt is made to add a Structure that the Group instance
  does not recognize.
  @author Bryan Tripp (bryan_tripp@sourceforge.net)" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  �GPL�), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

*/

package ca.uhn.hl7v2.model;

import ca.uhn.hl7v2.HL7Exception;

/**
 * An abstraction representing >1 message parts which may repeated together.
 * An implementation of Group should enforce contraints about on the contents of the group
 * and throw an exception if an attempt is made to add a Structure that the Group instance
 * does not recognize.
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 */
public interface Group extends Structure {

  /**
   * Returns an array of Structure objects by name.  For example, if the Group contains
   * an MSH segment and "MSH" is supplied then this call would return a 1-element array 
   * containing the MSH segment.  Multiple elements are returned when the segment or 
   * group repeats.  The array may be empty if no repetitions have been accessed
   * yet using the get(...) methods.
   *
   * @param name of the structure
   * @return array of Structure objects
   * @throws HL7Exception if the named Structure is not part of this Group. 
   */
  public Structure[] getAll(String name) throws HL7Exception;

  /**
   * Returns the named structure.  If this Structure is repeating then the first 
   * repetition is returned.  Creates the Structure if necessary.
   *
   * @param name of the structure
   * @return first (or only) structure object
   * @throws HL7Exception if the named Structure is not part of this Group. 
   */
  public Structure get(String name) throws HL7Exception;
  
  /**
   * Returns a particular repetition of the named Structure. If the given repetition
   * number is one greater than the existing number of repetitions then a new  
   * Structure is created.
   *
   * @param name name of the structure
   * @param rep repetition (zero-based)
   * @return particular repetition of the named structure
   * @throws HL7Exception if the named Structure is not part of this group,
   *    if the structure is not repeatable and the given rep is > 0,  
   *    or if the given repetition number is more than one greater than the 
   *    existing number of repetitions.  
   */
  public Structure get(String name, int rep) throws HL7Exception;
  
  /**
   * Returns true if the named structure is required.
   *
   * @param name name of the structure nested in this group
   * @return true if structure is required
   * @throws HL7Exception if the named Structure is not part of this group
   */
  public boolean isRequired(String name) throws HL7Exception;
  
  /**
   * Returns true if the named structure is repeating.
   *
   * @param name name of the structure nested in this group
   * @return true if structure is repeating
   * @throws HL7Exception if the named Structure is not part of this group
   */
  public boolean isRepeating(String name) throws HL7Exception;

  /**
   * Returns true if the named structure is a "choice element". 
   * Some HL7 structures (e.g. ORM_O01 in v2.5) have groups that have
   * several possible first segments. In these structures, one of these
   * "choice elements" must be present, but not more than one.
   *
   * @param name name of the structure nested in this group
   * @return true if structure is a choice element
   * @throws HL7Exception if the named Structure is not part of this group
   *
   */
  public boolean isChoiceElement(String name) throws HL7Exception;

  /**
   * Returns true if the named structure is a group.
   *
   * @param name name of the structure nested in this group
   * @return true if structure is a choice element
   * @throws HL7Exception if the named Structure is not part of this group
   * @since 1.2
   */
  public boolean isGroup(String name) throws HL7Exception;
  
  /**
   * Returns an ordered array of the names of the Structures in this 
   * Group.  These names can be used to iterate through the group using 
   * repeated calls to <code>get(name)</code>.
   *
   * @return an ordered array of the names of the Structures in this Group
   */
  public String[] getNames();
  
  /**
   * Returns the Class of the Structure at the given name index.  
   * @param name name of the structure nested in this group
   * @return class of the structure or null if the class does not exist
   */
  public Class<? extends Structure> getClass(String name);
  
  /**
   * Expands the group by introducing a new child Structure (i.e. 
   * a new Segment or Group).  This method is used to support handling 
   * of unexpected segments (e.g. Z-segments).  
   * @param c class of the structure to insert (e.g. NTE.class) 
   * @param required whether the child is required 
   * @param repeating whether the child is repeating 
   * @param index index at which to insert the new child
   * @param name the child name (e.g. "NTE")
   * @return the name used to index the structure (may be appended with a number if 
   *        name already used)
   */
  //public String insert(Class c, boolean required, boolean repeating, int index, String name) throws HL7Exception;
  
    /**
     * Expands the group definition to include a segment that is not 
     * defined by HL7 to be part of this group (eg an unregistered Z segment). 
     * The new segment is slotted at the end of the group.  Thenceforward if 
     * such a segment is encountered it will be parsed into this location. 
     * If the segment name is unrecognized a GenericSegment is used.  The 
     * segment is defined as repeating and not required.
     *
     * @param name name of the segment
     * @return the final name of the segment (may be renamed if a segment of this
     * name already exists.
     * @throws HL7Exception if the segment could not be added
     */
    public String addNonstandardSegment(String name) throws HL7Exception;

    /**
     * Expands the group definition to include a segment that is not 
     * defined by HL7 to be part of this group (eg an unregistered Z segment).
     *
     * @param name name of the segment
     * @param theIndex index (zero-based) at which to insert this segment
     * @return the name used to index the structure (may be appended with a number if
     *        name already used)
     * @throws HL7Exception if the segment could not be added
     */
    public String addNonstandardSegment(String name, int theIndex) throws HL7Exception;

}

