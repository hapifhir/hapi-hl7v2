/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "ProfileName.java".  Description: 
"This Class represents the name of a conformance class. It is used to generate
names for classes, accessors for those classes, member variable to hold those
classes, etc. It is also responsable for tracking the names of all siblings
within a package, to ensure that no two classes have the same name."

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): James Agnew
                Paul Brohman
                Mitch Delachevrotiere
                Shawn Dyck
  				Cory Metcalf
  				
Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  ?GPL?), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

*/
package ca.uhn.hl7v2.conf.classes.generator.builders;

import java.util.HashMap;

import ca.uhn.hl7v2.sourcegen.SourceGenerator;

/** This Class represents the name of a conformance class. It is used to generate
 * names for classes, accessors for those classes, member variable to hold those
 * classes, etc. It is also responsable for tracking the names of all siblings
 * within a package, to ensure that no two classes have the same name.
 * @author <table><tr>James Agnew</tr>
 *                <tr>Paul Brohman</tr>
 *                <tr>Mitch Delachevrotiere</tr>
 *                <tr>Shawn Dyck</tr>
 * 				  <tr>Cory Metcalf</tr></table>
 */
public final class ProfileName {

   /** Integer value representing the <code>profileName</code> value for Component */
   public static final int PS_COMP = 4;

   /** Integer value representing the <code>profileName</code> value for Field */
   public static final int PS_FIELD = 3;

   /** Integer value representing the <code>profileName</code> value for Message */
   public static final int PS_MSG = 0;

   /** Integer value representing the <code>profileName</code> value for Segment */
   public static final int PS_SEG = 2;

   /** Integer value representing the <code>profileName</code> value for SegGroup */
   public static final int PS_SEGG = 1;

   /** Integer value representing the <code>profileName</code> value for SubComponent */
   public static final int PS_SUBC = 5;

   private static final String[] PS_TYPES = { "Msg", "SegGrp", "Seg", "Field", "Comp", "SubComp" };
   protected HashMap<String, Object> nameMap; // Map containing the name of the parent and all children at any given level
   private String parentName; // The name of the parent name assosiated with this ProfileName

   private String profileName; // The name that this ProfileName represents
   private int profileStructureType; // The HL7 structure level that this ProfileName represents

   /** Creates a new instance of ProfileName 
    * @param profileName the name of the profile
    * @param profileStructureType The Profile Structure Type for this Name. The
    * Profile Structure Type is prepended to each class in the class hierarchy
    * both for clarity and to avoid name collisions.
    */
   public ProfileName(String profileName, int profileStructureType) {
      this(profileName, profileStructureType, new HashMap<String, Object>(50), profileName);
   }

   /** Creates a new instance of ProfileName 
    * @param profileName the name of the profile
    * @param profileStructureType The Profile Structure Type for this Name. The
    * Profile Structure Type is prepended to each class in the class hierarchy
    * both for clarity and to avoid name collisions.
    * @param nameMap a list of all the children in ProfileName
    * @param parentName the name of the parent to the child 
    */
   private ProfileName(String profileName, int profileStructureType, HashMap<String, Object> nameMap, String parentName) {
      this.profileName = new String(profileName);
      this.profileStructureType = profileStructureType;
      this.nameMap = nameMap;
      this.parentName = parentName;

      // TODO: These are workarounds.. These should probably be resolved somehow.
      if (profileName.equals("Acknowledgment Code"))
         this.profileName = "Acknowledgement Code";
      if (this.parentName != null && this.parentName.equals("NK1") && profileName.equals("Name"))
         this.profileName = "NKName";

      // Append a number to the name if there is already a ProfileName with this particular name
      int i = 1;
      while (nameMap.containsKey(this.profileStructureType + this.profileName)) {
         i++;
         this.profileName = new String(profileName + i);
      }

      // Store the new name in the hashmap 
      nameMap.put(this.profileStructureType + this.profileName, null);
   }

   /** This method clears the name map for this Profile Name, meaning that new names
    * entered after the map was cleared will not collide with names entered
    * before. This should be used when a ProfileName object is passed to a child
    * builder class.
    * @return ProfileName Returns the ProfileName object
    */
   public ProfileName clearNameMap() {
      this.nameMap = new HashMap<String, Object>(50);
      nameMap.put(this.profileStructureType + this.profileName, null);
      this.parentName = this.profileName;
      return this;
   }

   /** Compares two ProfileName objects by comparing their <code>getAccessorName()</code>
    * method return value.
    * @return true if the names are equivalent
    */
   public boolean equals(ProfileName n) {
      if (getAccessorName().equals(n.getAccessorName()))
         return true;
      else
         return false;
   }

   /** Returns the accessor name
    * @return the Accessor name
    */
   public String getAccessorName() {
      // SegGroup names are a special case because makeAccessorName() chews out the
      // underscores they have to contain.
      if (profileStructureType == PS_SEGG)
         return "get" + this.profileName;
      else
         return "get" + (SourceGenerator.makeAccessorName(this.profileName, this.parentName));
   }

   /** Returns the Class name
    * @return the Class name
    */
   public String getClassName() {
      String name = getAccessorName().substring(3, 4).toUpperCase() + getAccessorName().substring(4);
      return PS_TYPES[profileStructureType] + name;
   }

   /** Returns the Member name
    * @return the Member name
    */
   public String getMemberName() {
      String memberName = getAccessorName().substring(3, 4).toLowerCase() + getAccessorName().substring(4);
      if (!Character.isJavaIdentifierStart(memberName.charAt(0)))
         memberName = "_" + memberName;

      return memberName;
   }

   /** Returns the original name
    * @return the original name
    */
   public String getOriginalName() {
      return this.profileName;
   }

   /** Returns the Package name
    * @return the Package name
    */
   public String getPackageName() {
      return getAccessorName().substring(3) + "children";
   }

   /** creates a new instance of ProfileName
    * @return the new ProfileName
    */
   public ProfileName newInstance(String profileName, int profileStructureType) {
      ProfileName newPN = new ProfileName(profileName, profileStructureType, this.nameMap, this.profileName);
      return newPN;
   }

}
