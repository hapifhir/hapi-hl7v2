/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "CMPAttributeGenerator.java".  Description: 
"Generates EJB code related to RIM class attributes, for an entity bean 
  with container managed persistence" 

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

/**
 * Generates EJB code related to RIM class attributes, for an entity bean 
 * with container managed persistence.    
 * @author Bryan Tripp
 * @deprecated
 */
public class CMPAttributeGenerator {

    /** Creates a new instance of AttributeGenerator */
    public CMPAttributeGenerator() {
    }

    /** 
     * Returns source code for the method signatures that represent the given
     * attribute in the EJB remote interface.
     */ 
    public String makeRemoteCode(AttributeDefinition att) {
        StringBuffer code = new StringBuffer();
        code.append(SourceGenerator.makeJavaDocComment(att.getDescription(), 4));
        code.append("    ");        
        code.append(SourceGenerator.makeSetterSignature(att));
        code.append(" throws RemoteException; \r\n");
        code.append("    ");        
        code.append(SourceGenerator.makeGetterSignature(att));
        code.append(" throws RemoteException; \r\n");
        return code.toString();
    }
    
    /**
     * Returns source code for the methods that represent the given attribute 
     * in a CMP Entity EJB implementation. 
     */ 
    public String makeBeanCode(AttributeDefinition att) {
        StringBuffer code = new StringBuffer();
        code.append(SourceGenerator.makeJavaDocComment(att.getDescription(), 4));

        code.append("    ");        
        code.append(SourceGenerator.makeSetterSignature(att));
        code.append(" { \r\n");
        code.append("        this.");
        code.append(att.getName());
        code.append(" = ");
        code.append(att.getName());
        code.append("; \r\n");
        code.append("    } \r\n");
        
        code.append("    ");        
        code.append(SourceGenerator.makeGetterSignature(att));
        code.append(" { \r\n");
        code.append("        return ");
        code.append(att.getName());
        code.append("; \r\n");
        code.append("    } \r\n\r\n");
               
        return code.toString();
    }
    
    /** Returns public attribute declaration associated with this attribute in CMP Entity Bean. */
    public String makeBeanAttribute(AttributeDefinition att) {
        StringBuffer code = new StringBuffer();
        code.append("    public ");
        code.append(att.getDataType());
        code.append(" ");
        code.append(att.getName());
        code.append("; \r\n");
        return code.toString();
    }
}
