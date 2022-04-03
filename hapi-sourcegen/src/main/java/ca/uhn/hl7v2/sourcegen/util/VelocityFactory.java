/*
 * Created on Apr 19, 2006
 */
package ca.uhn.hl7v2.sourcegen.util;

import org.apache.velocity.Template;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;


/**
 * Simple utility class to generate velocity engines.
 * 
 * Copied from UHN internal class under "commons-se"
 * 
 * @author <a href="mailto:jamesagnew@users.sourceforge.net">James Agnew </a>
 * @version $Revision: 1.3 $ updated on $Date: 2011-04-01 13:24:45 $ by $Author:
 *              jagnew $
 */
public class VelocityFactory
{
   /**
    * non instantiable
    */
   private VelocityFactory() {
      // nothing
   }


   /**
    * Creates a velocity template
    * 
    * @param theTemplate
    *                The template
    * @return A template engine
    */
   public static Template getClasspathTemplateInstance(String theTemplate) {
      VelocityEngine engine = getEngineInstance();
      return engine.getTemplate(theTemplate);
   }


   /**
    * @return Returns a velocity engine
    */
   public static VelocityEngine getEngineInstance() {
      VelocityEngine engine = new VelocityEngine();
//      RuntimeConstants.RESOURCE_MANAGER_CLASS
      engine.setProperty(RuntimeConstants.RESOURCE_LOADERS, "classpath");
      engine.setProperty(RuntimeConstants.RESOURCE_LOADER + ".classpath.class", ResourceLoader.class.getName());
      engine.setProperty(RuntimeConstants.VM_LIBRARY, "");
      engine.setProperty(RuntimeConstants.RUNTIME_REFERENCES_STRICT, Boolean.TRUE);
      engine.init();
      return engine;
   }

}