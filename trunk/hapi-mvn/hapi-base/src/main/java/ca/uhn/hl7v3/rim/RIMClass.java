/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "RIMClass.java".  Description: 
"Base class for EJB implementation of all classes in the RIM" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  “GPL”), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

*/

package ca.uhn.hl7v3.rim;

import javax.ejb.*;
import java.rmi.RemoteException;

/**
 * Base class for EJB implementation of all classes in the RIM.  
 * @author Bryan Tripp
 */
public abstract class RIMClass implements javax.ejb.EntityBean {

    private EntityContext context = null;
    public String UID;
    
    public String ejbCreate(String UID) {
        System.out.println(this.getClass().getName() + " bean created with ID " + UID);
        this.UID = UID;
        return null;
    }
    
    public void ejbPostCreate(String UID) {
    }
    
    public void setEntityContext(EntityContext context) {
        this.context = context;
        System.out.println(this.getClass().getName() + " context set");
    }
    
    public void unsetEntityContext() {
        this.context = null;
        System.out.println(this.getClass().getName() + " context unset");        
    }
    
    public void ejbLoad() {
        
    }
    
    public void ejbStore() {
        
    }

    public void ejbRemove() {
        
    }

    public void ejbActivate() {
        System.out.println(this.getClass().getName() + " bean activated");
    }
    
    public void ejbPassivate() {
        System.out.println(this.getClass().getName() + " bean passivated");
    }
    
}
