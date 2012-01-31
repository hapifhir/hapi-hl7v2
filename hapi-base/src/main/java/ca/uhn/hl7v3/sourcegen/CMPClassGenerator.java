/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "CMPClassGenerator.java".  Description: 
"Generates EJB code related to RIM classes, for an entity bean 
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
 * Generates EJB code related to RIM classes, for an entity bean 
 * with container managed persistence.    
 * @author Bryan Tripp
 * @deprecated
 */
public class CMPClassGenerator {

    CMPAttributeGenerator attGen;
    
    /** Creates a new instance of CMPClassGenerator */
    public CMPClassGenerator() {
        attGen = new CMPAttributeGenerator();
    }

    public String makeRemoteCode(ClassDefinition cls) {
        StringBuffer code = new StringBuffer();
        code.append("package ");
        code.append(SourceGenerator.getRIMPackage());
        code.append("; \r\n\r\n");
        code.append("import ");
        code.append(SourceGenerator.getRIMDataTypePackage());
        code.append(".*; \r\n"); 
        code.append("import java.rmi.RemoteException; \r\n");
        code.append("import javax.ejb.*; \r\n\r\n");
        code.append(SourceGenerator.makeJavaDocComment(cls.getDescription(), 0));
        code.append("public interface ");
        code.append(cls.getName());
        code.append(" extends ");
        if (cls.getSuperClass() == null) {
            code.append("EJBObject");
        } else {
            code.append(cls.getSuperClass());
        }
        code.append(" { \r\n\r\n");
        AttributeDefinition[] atts = cls.getAttributes();
        for (int i = 0; i < atts.length; i++) {
            code.append(attGen.makeRemoteCode(atts[i]));
            code.append("\r\n");
        }
        code.append("}\r\n");
        return code.toString();
    }
    
    public String makeHomeCode(ClassDefinition cls) {
        StringBuffer code = new StringBuffer();
        code.append("package ");
        code.append(SourceGenerator.getRIMPackage());
        code.append("; \r\n\r\n");
        code.append("import javax.ejb.*; \r\n");
        code.append("import java.rmi.RemoteException; \r\n");
        code.append("\r\n");
        code.append("/** Home interface for the RIM '");
        code.append(cls.getName());
        code.append("' Entity Bean. */ \r\n");
        code.append("public interface ");
        code.append(cls.getName());
        code.append("Home extends EJBHome { \r\n");
        code.append("    public ");
        code.append(cls.getName());
        code.append(" create(String UID) throws CreateException, RemoteException; \r\n");
        code.append("    public ");
        code.append(cls.getName());
        code.append(" findByPrimaryKey(String UID) throws FinderException, RemoteException; \r\n");
        code.append("} \r\n");
        return code.toString();
    }
    
    public String makeBeanCode(ClassDefinition cls) {
        AttributeDefinition[] atts = cls.getAttributes();
        StringBuffer code = new StringBuffer();
        code.append("package ");
        code.append(SourceGenerator.getRIMPackage());
        code.append("; \r\n\r\n");
        code.append("import javax.ejb.*; \r\n");
        code.append("import java.rmi.RemoteException; \r\n");
        code.append("import ");
        code.append(SourceGenerator.getRIMDataTypePackage());
        code.append(".*; \r\n\r\n");
        code.append(SourceGenerator.makeJavaDocComment("Container-Managed Entity Bean for the RIM class '" + cls.getName() + "'. " + cls.getDescription(), 0));
        code.append("public class ");
        code.append(cls.getName());
        code.append("Bean extends ");
        if (cls.getSuperClass() == null) {
            code.append("RIMClass");
        } else {
            code.append(cls.getSuperClass());
            code.append("Bean");
        }
        code.append(" { \r\n\r\n");
        for (int i = 0; i < atts.length; i++) {
            code.append(attGen.makeBeanAttribute(atts[i]));
        }
        code.append("\r\n");
        for (int i = 0; i < atts.length; i++) {
            code.append(attGen.makeBeanCode(atts[i]));
            code.append("\r\n");
        }
        code.append("} \r\n");        
        return code.toString();
    }
    
    public static void main(String args[]) {
        ClassDefinition cls = new ClassDefinition();
        cls.setDescription("Entities are physical things or organizations and groupings of physical things. A physical thing is anything that has extent in space, and has mass. This hierarchy encompasses human beings, organizations, living organisms, devices, pharmaceutical substances, etc. This does not include events/acts/actions, the definition of things, the roles that things can play (e.g. patient, provider), nor the relationships among things.");
        cls.setIsAbstract(false);
        cls.setName("Entity");
        AttributeDefinition[] atts = new AttributeDefinition[2];
        atts[0] = new AttributeDefinition();
        atts[0].setDataType("CE");
        atts[0].setName("cd");
        atts[0].setDescription("This is the main classifying attribute of the Entity class and all of its subclasses.  This code indicates what kind of Entity is meant using a code from one of several coding systems depending on the class of entities, such as living subjects (typed by animal and plant taxonomies), chemical substance (e.g., IUPAC code), organizations, insurance company, government agency, hospital, park, lake, syringe, etc. Note that the entity type code may be so fine grained that some types may only have one known instance.  Types with an extension of one instance are very similar to names. An example is the CDC vaccine manufacturer code, which is modeled as a concept vocabulary, when in fact each concept refers to only one instance. However, type codes SHOULD NOT normally be so fine grained as of overlap with instance identification.");
        atts[1] = new AttributeDefinition();
        atts[1].setDataType("CE");
        atts[1].setName("class_cd");
        atts[1].setDescription("A code specifying on a high, technical, and tightly controlled level the kind of entity. This code is similar in nature as the names of the classes derived from entity in a refined message information model (R-MIM.)");
        cls.setAttributes(atts);
        
        CMPClassGenerator cgen = new CMPClassGenerator();
        System.out.println(cgen.makeRemoteCode(cls));
        System.out.println(cgen.makeBeanCode(cls));
        System.out.println(cgen.makeHomeCode(cls));
    }
}
