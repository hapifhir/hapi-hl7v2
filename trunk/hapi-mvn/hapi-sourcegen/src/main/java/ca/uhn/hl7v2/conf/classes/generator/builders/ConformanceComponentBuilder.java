/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "ConformanceComponentBuilder.java".  Description: 
"This method builds Conformance Component Classes" 

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

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.hl7v2.conf.classes.exceptions.ConformanceError;
import ca.uhn.hl7v2.conf.classes.generator.genclasses.GeneratedConformanceContainer;
import ca.uhn.hl7v2.conf.spec.message.Component;
import ca.uhn.hl7v2.conf.spec.message.SubComponent;
import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.Message;

/** This class builds Conformance Component Classes
 * @author <table><tr>James Agnew</tr>
 *                <tr>Paul Brohman</tr>
 *                <tr>Mitch Delachevrotiere</tr>
 *                <tr>Shawn Dyck</tr>
 * 				  <tr>Cory Metcalf</tr></table>
 */
public class ConformanceComponentBuilder {
	
	private static final Logger ourLog = LoggerFactory.getLogger(ConformanceComponentBuilder.class);
	
   private DeploymentManager depManager; // The deployment manager
   private DocumentationBuilder docBuilder;
   private String packageName;
   private String versionString;

   /** This constructor will create a new ConformanceComponentBuilder
    * @param packageName the name of the package
    * @param versionString the version of HL7 which these classes are conforming to
    * @param depManager the instance of DeploymentManager
    */
   public ConformanceComponentBuilder(String packageName, DeploymentManager depManager, String versionString) {
      this.packageName = packageName;
      this.docBuilder = DocumentationBuilder.getDocumentationBuilder();
      this.depManager = depManager;
      this.versionString = versionString;
   }

   /** This method builds a Conformance Component Class
    * @param comp the Component to build
    */
   public void buildClass(Component comp) {

      ProfileName profileName = new ProfileName(comp.getName(), ProfileName.PS_COMP);
      GeneratedConformanceContainer gcc = new GeneratedConformanceContainer();

      gcc.setClassPackage(packageName);

      gcc.addClassImport("ca.uhn.hl7v2.conf.classes.abs.*");
      gcc.addClassImport("ca.uhn.hl7v2.conf.classes.exceptions.*");
      gcc.addClassImport("ca.uhn.hl7v2.model.*");
      gcc.addClassImport(packageName + "." + profileName.getPackageName() + ".*");

      gcc.setName(profileName.getClassName());
      gcc.setProperties("extends AbstractConformanceContainer");
      gcc.addMemberVariable("private Composite hapiType;");

      gcc.getConstructor().addToComments("Creates new instances of all SubComponents contained in this Component");
      gcc.getConstructor().addToBody("this.hapiType = hapiType;");

	  docBuilder.decorateConstructor( gcc.getConstructor(), profileName.getClassName() );
      // Add member variables and getters for subcomponents
      gcc.getConstructor().addToBody("try{");
      for (int i = 1; i <= comp.getSubComponents(); i++) {
		//don't build not supported, backward, or unknown types
		 String usage = comp.getSubComponent(i).getUsage();
		 if( usage != null && (usage.equals("X") || usage.equals("B") || usage.equals("U")) )
			continue;
			
			// The following is a workaround to allow for composite subcomponents. 
			Class<?> c;
			Object instance;
			try {
            
        	 String className = "ca.uhn.hl7v2.model." + versionString + ".datatype." + comp.getSubComponent(i).getDatatype();
        	 ourLog.info("Analyzing class: "+ className);
            
			c = Class.forName(className);
            Constructor<?> constructor = c.getConstructors()[0];
			if (constructor.getParameterTypes().length == 1) {
				instance = constructor.newInstance((Message)null);
			} else {
				instance = constructor.newInstance((Message)null, 0);
			}
         } catch ( Exception e ) {
				throw new ConformanceError("Could not find underlying SubComponent datatype. This is a bug. Exception: " + e.toString(), e);
			}

         if ( instance instanceof Composite ) {
        	 	
        	 	@SuppressWarnings("unchecked")
				Class<? extends Composite> cComp = (Class<? extends Composite>) c;
        	 
				// In this case, the child is a composite subcomponent
				Component generatedComponent = createSubComponentProfile(cComp, comp.getSubComponent(i).getName());
				gcc.addComponent(new ProfileName(comp.getSubComponent(i).getName(), ProfileName.PS_COMP), i - 1, true);
				ConformanceComponentBuilder childBuilder = new ConformanceComponentBuilder(packageName + "." + profileName.getPackageName(), depManager, versionString);
				childBuilder.buildClass(generatedComponent);
         } else { 
				// In this case, the child is a primitive (this is the normal case)
				gcc.addSubComponent(new ProfileName(comp.getSubComponent(i).getName(), ProfileName.PS_SUBC), i - 1);
				ConformancePrimitiveBuilder childBuilder = new ConformancePrimitiveBuilder(packageName + "." + profileName.getPackageName(), depManager);
				childBuilder.buildClass(comp.getSubComponent(i), ProfileName.PS_SUBC);
         }

      }

      gcc.getConstructor().addParam("Composite hapiType", "Reference to the underlying HAPI Composite data type.");
      gcc.getConstructor().addToBody("} catch ( DataTypeException e ) {");
      gcc.getConstructor().addToBody("   throw new ConformanceError(\"Invalid Attempt to access a rep. This is a Conformance Class Bug\");");
      gcc.getConstructor().addToBody("}");

      // Decorate with comments
      docBuilder.decorateComponent(gcc, comp);

      if (depManager.getVerbose())
         System.out.println("Generating Component: " + packageName + "." + gcc.getName());

      depManager.generateFile(gcc, packageName, gcc.getName());
   }

   /** This method creates a Sub Component profile 
    * @param compositeClass - the Class
    * @param name - the Component name
    * @return Component - the Component
    */
   private Component createSubComponentProfile(Class<? extends Composite> compositeClass, String name) {
      Component theComponent = new Component();
      int numSubComponents = 0;

      try {
         theComponent.setName(name);
         theComponent.setDatatype(compositeClass.getName().substring(compositeClass.getName().lastIndexOf('.') + 1));
         Method[] methods = compositeClass.getMethods();

         for (int i = 0; i < methods.length; i++) {

            if (methods[i].getReturnType().getName().length() > 18 && methods[i].getReturnType().getName().substring(0, 18).equals("ca.uhn.hl7v2.model") && methods[i].getParameterTypes().length == 0 && methods[i].getName().subSequence(0, 3).equals("get")) {

               SubComponent sc = new SubComponent();
               sc.setName(methods[i].getName().substring(3));
               sc.setDatatype(methods[i].getReturnType().getName().substring(methods[i].getReturnType().getName().lastIndexOf('.') + 1));
               sc.setConstantValue("");

               numSubComponents++;
               theComponent.setSubComponent(numSubComponents, sc);
            }

         }

         /* Workaround for the TS datatype, as it does not currently
          * provide named getters for its subcomponents. */	
         if (theComponent.getDatatype().equals("TS") && theComponent.getSubComponents() == 0) {
            SubComponent sc = new SubComponent();
            sc.setName("DateTime");
            sc.setDatatype("NM");
            sc.setConstantValue("");
            theComponent.setSubComponent(1, sc);

            sc = new SubComponent();
            sc.setName("DegreeOfPrecision");
            sc.setDatatype("ST");
            sc.setConstantValue("");
            theComponent.setSubComponent(2, sc);
         }

      } catch (ProfileException e) {
         e.printStackTrace();
      }

      return theComponent;
   }
}
