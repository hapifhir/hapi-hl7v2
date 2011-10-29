/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "AbstractConformanceContainer.java".  Description: 
"This class contains the functionality for a parent class in the Conformance
 class set heirarchy to hold Repeatable children."

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): James Agnew
                Paul Brohman
                Mitch Delachevrotiere
                Shawn Dyck
  				Cory Metcalf
  				
Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the "GPL"), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

*/

package ca.uhn.hl7v2.conf.classes.abs;
import ca.uhn.hl7v2.conf.classes.exceptions.*;

/** This class contains the functionality for a parent class in the Conformance
 * class set heirarchy to hold <i>Repeatable</i> children.
 * @author <table><tr>James Agnew</tr>
 *                <tr>Paul Brohman</tr>
 *                <tr>Mitch Delachevrotiere</tr>
 *                <tr>Shawn Dyck</tr>
 * 				  <tr>Cory Metcalf</tr></table>
 */
public abstract class AbstractConformanceContainer {
   /** Default constructor */
   public AbstractConformanceContainer() {
   }

   /** Returns a repetition of a child of the extending class, creating
   * it if necessary.
   * @param finiteList the finiteList containing the desired repetitions
   * @param rep the repetition number with a <b>0 based index</b>
   * @throws ConfRepException if repetition can not be accessed
   * @return repetition
   */
   protected Repeatable getChild(FiniteList finiteList, int rep) throws ConfRepException {
      return finiteList.getRep(rep);
   }

}
