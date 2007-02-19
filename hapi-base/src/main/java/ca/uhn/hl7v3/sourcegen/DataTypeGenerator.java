/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "DataTypeGenerator.java".  Description: 
"Creates source code for RIM DataTypes" 

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

package ca.uhn.hl7v3.sourcegen;

/**
 * Creates source code for RIM DataTypes.  
 * @author Bryan Tripp
 */
public class DataTypeGenerator {

    /** Creates a new instance of DataTypeGenerator */
    public DataTypeGenerator() {
    }
    
    public String makeDataType(DataTypeDefinition type) {
        String code = null;
        if (type.getType().equalsIgnoreCase("Primitive")) {
            code = makePrimitive(type);
        } else if (type.getType().equalsIgnoreCase("Composite")) {
            code = makeComposite(type);
        } else if (type.getType().equalsIgnoreCase("Generic")) {
            code = makeGeneric(type);
        } else if (type.getType().equalsIgnoreCase("Instance")) {
            code = makeInstance(type);
        }
        return code;
    }
    
    public String makePrimitive(DataTypeDefinition primitiveType) {
        StringBuffer code = new StringBuffer();
        code.append("package ");
        code.append(SourceGenerator.getRIMDataTypePackage());
        code.append("; \r\n\r\n");
        code.append(SourceGenerator.makeJavaDocComment(primitiveType.getDescription(), 0));
        code.append("public class ");
        code.append(primitiveType.getName());
        code.append(" extends ");
        if (primitiveType.getSuperClass() != null) {
            code.append(primitiveType.getSuperClass());
        } else {
            code.append("Primitive");
        }
        code.append(" { \r\n\r\n");
        code.append("} \r\n");
        return code.toString();
    }
        
    public String makeComposite(DataTypeDefinition compositeType) {
        StringBuffer code = new StringBuffer();
        code.append("package ");
        code.append(SourceGenerator.getRIMDataTypePackage());
        code.append("; \r\n\r\n");
        code.append(SourceGenerator.makeJavaDocComment(compositeType.getDescription(), 0));
        code.append("public class ");
        code.append(compositeType.getName());
        code.append(" extends ");
        if (compositeType.getSuperClass() != null) {
            code.append(compositeType.getSuperClass());
        } else {
            code.append("Composite");
        }
        code.append(" { \r\n\r\n");
        ComponentDefinition[] components = compositeType.getComponents();
        for (int i = 0; i < components.length; i++) {
            code.append(makeAttributeDeclaration(components[i]));
        }
        code.append("\r\n");
        for (int i = 0; i < components.length; i++) {
            code.append(makeSetter(components[i]));
            code.append(makeGetter(components[i]));
            code.append("\r\n");
        }       
        code.append("} \r\n");        
        return code.toString();
    }

    public String makeGeneric(DataTypeDefinition genericType) {
        StringBuffer code = new StringBuffer();
        code.append("package ");
        code.append(SourceGenerator.getRIMDataTypePackage());
        code.append("; \r\n\r\n");
        code.append(SourceGenerator.makeJavaDocComment(genericType.getDescription(), 0));
        code.append("public class ");
        code.append(genericType.getName());
        code.append(" extends ");
        if (genericType.getSuperClass() != null) {
            code.append(genericType.getSuperClass());
        } else {
            code.append("Generic");
        }
        code.append(" { \r\n\r\n");
        code.append("} \r\n");
        return code.toString();
    }
    
    public String makeInstance(DataTypeDefinition instanceType) {
        StringBuffer code = new StringBuffer();
        code.append("package ");
        code.append(SourceGenerator.getRIMDataTypePackage());
        code.append("; \r\n\r\n");
        code.append(SourceGenerator.makeJavaDocComment(instanceType.getDescription(), 0));
        code.append("public class ");
        code.append(DataTypeDefinition.mapInstanceName(instanceType.getName()));
        code.append(" extends ");
        code.append(DataTypeDefinition.getAssociatedGeneric(instanceType.getName()));
        code.append(" { \r\n");
        code.append("} \r\n");
        return code.toString();        
    }
   
    public String makeAttributeDeclaration(ComponentDefinition component) {
        StringBuffer code = new StringBuffer();
        code.append("    public ");
        code.append(component.getDataType());
        code.append(" ");
        code.append(component.getName());
        code.append("; \r\n");
        return code.toString();
    }
    
    public String makeGetter(ComponentDefinition component) {
        StringBuffer code = new StringBuffer();
        code.append(SourceGenerator.makeJavaDocComment(component.getDescription(), 4));
        code.append("    public ");
        code.append(component.getDataType());
        code.append(" get");
        code.append(capitalize(component.getName()));
        code.append("() { \r\n");
        code.append("        return this.");
        code.append(component.getName());
        code.append("; \r\n");
        code.append("    } \r\n");
        return code.toString();
    }
    
    public String makeSetter(ComponentDefinition component) {
        StringBuffer code = new StringBuffer();
        code.append(SourceGenerator.makeJavaDocComment(component.getDescription(), 4));
        code.append("    public void set");
        code.append(capitalize(component.getName()));
        code.append("(");
        code.append(component.getDataType());
        code.append(" ");
        code.append(component.getName());
        code.append(") { \r\n");
        code.append("        this.");
        code.append(component.getName());
        code.append(" = ");
        code.append(component.getName());        
        code.append("; \r\n");
        code.append("    } \r\n");        
        return code.toString();
    }
    
    private static String capitalize(String s) {
        StringBuffer result = new StringBuffer();
        if (s != null && s.length() > 0) { 
            result.append(s.substring(0, 1).toUpperCase());
            if (s.length() > 1) result.append(s.substring(1, s.length()));
        }
        return result.toString();
    }
}
