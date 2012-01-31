/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "DataTypeDefinition.java".  Description: 
"Contains information about a RIM data type, sufficient to generate source code for it" 

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

package ca.uhn.hl7v3.sourcegen;

import java.util.StringTokenizer;

/**
 * Contains information about a RIM data type, sufficient to generate source code for it.   
 * @author Bryan Tripp
 * @deprecated
 */
public class DataTypeDefinition {

    private String name; 
    private String longName;
    private String description;
    private String type;
    private String superClass;
    private ComponentDefinition[] components;
    
    /** Creates a new instance of DataTypeDefinition */
    public DataTypeDefinition() {
    }
    
    public void setName(String name) {
        if (isInstance(name)) {
            this.name = mapInstanceName(name);
        } else {
            this.name = name;
        }
    } 
    public String getName() {
        return this.name;
    }
    
    public void setLongName(String longName) {
        this.longName = longName;
    }
    public String getLongName() {
        return this.longName;
    }
    
    public void setDescription(String description) {
        this.description = description;
    } 
    public String getDescription() {
        return this.description;
    }
    
    public void setType(String type) {
        this.type = type;
    } 
    public String getType() {
        return this.type;
    }
    
    public void setSuperClass(String superClass) {        
        if (superClass != null && isInstance(superClass)) {
            this.superClass = mapInstanceName(superClass);
        } else {
            this.superClass = superClass;
        }
    } 
    public String getSuperClass() {
        return this.superClass;
    }
    
    public void setComponents(ComponentDefinition[] components) {
        this.components = components;
    } 
    public ComponentDefinition[] getComponents() {
        return this.components;
    }

    /** 
     * Given the name of an Instance RIM data type (i.e. a restriction of a Generic type), 
     * provides the Java class name that will be used to represent it.  
     */
    public static String mapInstanceName(String instanceRIMName) {
        StringTokenizer tok = new StringTokenizer(instanceRIMName.trim(), "<>", false);
        StringBuffer name = new StringBuffer();
        while (tok.hasMoreTokens()) {
            name.append(tok.nextToken());
            if (tok.hasMoreTokens()) name.append("_");
        }
        return name.toString();
    }
    
    /** Performs the reverse mapping to mapInstanceName. */
    public static String unmapInstanceName(String instanceJavaName) {
        return instanceJavaName.replace('_', '<') + ">";
    }
    
    /**
     * Given a name of the Java class for an Instance RIM data type (i.e. a restriction of a Generic type), 
     * returns the name of the associated Generic class.  
     */
    public static String getAssociatedGeneric(String instanceJavaName) {
        return instanceJavaName.substring(0, instanceJavaName.indexOf('_'));
    }
    
    /** Returns true if the given datatype name is an Instance (i.e. specialization of a Generic). */
    public static boolean isInstance(String datatypeName) {
        boolean is = false;
        if (datatypeName.indexOf('<') > 0) is = true;
        return is;
    }
    
    
}
