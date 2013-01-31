/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "Composite.java".  Description: 
"Represents the category of HL7 data types that contain more than one component (e.g" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

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

/**
 * <p>Represents the category of HL7 data types that contain more than one component (e.g. CE).
 * Implementing classes (i.e. composite data types) should initialize their components
 * either when they are initialized or when they are first accessed.  Only leaf values
 * (values of primitives) should ever be returned as null.</p>
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 */
public interface Composite extends Type {

  /**
   * Returns an array containing the components of this field.
   *
   * @return array of components of this composite type
   */
  public Type[] getComponents();

  /**
   * Returns the single component of this composite at the specified position (starting at 0).
   *
   * @param number index of the component to be retrieved (zero-based)
   * @return component at this index
   * @throws DataTypeException
   */
  public Type getComponent(int number) throws DataTypeException;

}
