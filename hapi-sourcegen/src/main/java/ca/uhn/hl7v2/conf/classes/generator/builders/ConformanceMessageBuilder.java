/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "DBTableRepository.java".  Description: 
"Implements TableRepository by looking up values from the default HL7
  normative database" 

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

import ca.uhn.hl7v2.conf.spec.message.*;
import ca.uhn.hl7v2.conf.spec.*;
import ca.uhn.hl7v2.conf.classes.generator.genclasses.*;

/** This method builds the Conformance Message Class
 * @author <table><tr>James Agnew</tr>
 *                <tr>Paul Brohman</tr>
 *                <tr>Mitch Delachevrotiere</tr>
 *                <tr>Shawn Dyck</tr>
 * 				  <tr>Cory Metcalf</tr></table>
 */
public class ConformanceMessageBuilder {
   private GeneratedConformanceMessage confMsg;
   private StaticDef msg;
   private String packageName;

   /** This constructor will create a new ConformanceMessageBuilder
    * @param packageName the name of the package
    */
   public ConformanceMessageBuilder(String packageName) {
      this.packageName = packageName;
   }

   /** This method builds a Conformance Message Class
    * @param runtimeProfile the profile which to genrate Conformance Classes for
    * @param depManager the DeploymentManager
    */
   public void buildClass(RuntimeProfile runtimeProfile, DeploymentManager depManager){
      this.msg = runtimeProfile.getMessage();
      this.confMsg = new GeneratedConformanceMessage();
         
      ProfileName profileName = new ProfileName(msg.getMsgStructID(), ProfileName.PS_MSG);

      String version = "v" + runtimeProfile.getHL7Version().replaceAll("\\.", "");
      String underlyingDataType = "ca.uhn.hl7v2.model." + version + ".message." + msg.getMsgStructID();

      ConformanceSegmentBuilder confSegBuilder = new ConformanceSegmentBuilder(packageName, version, depManager);
      ConformanceSegGroupBuilder confSegGroupBuilder = new ConformanceSegGroupBuilder(packageName, version, depManager, msg.getMsgStructID());
      DocumentationBuilder docBuilder = DocumentationBuilder.getDocumentationBuilder();

      // Add class package and imports
      confMsg.setClassPackage(packageName);
      confMsg.addClassImport("ca.uhn.hl7v2.conf.classes.abs.*");
      confMsg.addClassImport("ca.uhn.hl7v2.conf.classes.exceptions.*");

      // Set class properties
      confMsg.setName(profileName.getClassName());
      confMsg.setProperties("extends AbstractConformanceContainer");

      // Decorate the class with comments
      docBuilder.decorateConformanceMessage(confMsg, runtimeProfile);
      docBuilder.decorateConstructor( confMsg.getConstructor(), msg.getMsgType() );

      // add hapi message
      confMsg.addHAPIMessage(underlyingDataType);

      for (int i = 1; i <= msg.getChildren(); i++) {
		 //don't build not supported, backward, or unknown types
		 String usage = msg.getChild(i).getUsage();
		 if( usage.equals("X") || usage.equals("B") || usage.equals("U") )
			continue;
			
         if (msg.getChild(i) instanceof Seg) {
            ProfileName childProfileName = profileName.newInstance(msg.getChild(i).getName(), ProfileName.PS_SEG);

            // Add the member variable vector to hold them
            confMsg.addMemberVariable("private FiniteList " + childProfileName.getMemberName() + ";");
            confMsg.getConstructor().addToBody(childProfileName.getMemberName() + " = new FiniteList( " + childProfileName.getClassName() + ".class, hapiMessage );");

				UnderlyingAccessor childAccessor = new UnderlyingAccessor(underlyingDataType, childProfileName.getAccessorName());
            GeneratedRepGetter repGetter = new GeneratedRepGetter(childProfileName, childAccessor.getAcceptsRep());

            docBuilder.decorateRepGetter(repGetter, (Seg) msg.getChild(i), childProfileName.getAccessorName());

            confMsg.addMethod(repGetter);
            if (depManager.getVerbose())
               System.out.println("Generating Segment: " + packageName + "." + confMsg.getName());

            confSegBuilder.buildClass((Seg) msg.getChild(i), underlyingDataType, childProfileName.clearNameMap());

         } else if (msg.getChild(i) instanceof SegGroup) {
               ProfileName childProfileName = profileName.newInstance(msg.getChild(i).getName(), ProfileName.PS_SEGG);

               // Add the member variable vector to hold them
               confMsg.addMemberVariable("private FiniteList " + childProfileName.getMemberName() + ";");
               confMsg.getConstructor().addToBody(childProfileName.getMemberName() + " = new FiniteList( " + childProfileName.getClassName() + ".class, hapiMessage );");

					String underlyingAccessorName = "get" + msg.getMsgStructID() + "_" + ConformanceSegGroupBuilder.generateSegGroupName((SegGroup)msg.getChild(i));
					UnderlyingAccessor childAccessor = new UnderlyingAccessor(underlyingDataType, underlyingAccessorName);
               GeneratedRepGetter repGetter = new GeneratedRepGetter(childProfileName, childAccessor.getAcceptsRep());

               docBuilder.decorateRepGetter(repGetter, (SegGroup) msg.getChild(i), childProfileName.getOriginalName());
               confMsg.addMethod(repGetter);
               if (depManager.getVerbose())
                  System.out.println("Generating SegGroup: " + packageName + "." + confMsg.getName());

               confSegGroupBuilder.buildClass((SegGroup) msg.getChild(i), underlyingDataType, childProfileName.clearNameMap());
            }

      }

      depManager.generateFile(confMsg, packageName, profileName.getClassName());
   }
}
