/*
 * Created on Apr 19, 2006
 */
package ca.uhn.hl7v2.sourcegen.util;

import org.apache.velocity.Template;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.springframework.ui.velocity.CommonsLoggingLogSystem;


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
    * @throws Exception
    *                If velocity fails to initialize
    */
   public static Template getClasspathTemplateInstance(String theTemplate) throws Exception {
      VelocityEngine engine = getEngineInstance();
      return engine.getTemplate(theTemplate);
   }


   /**
    * @return Returns a velocity engine
    * @throws Exception
    *                If engine fails to initialize
    */
   public static VelocityEngine getEngineInstance() throws Exception {
      VelocityEngine engine = new VelocityEngine();
      engine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
      engine.setProperty("classpath." + RuntimeConstants.RESOURCE_LOADER + ".class", ResourceLoader.class
            .getName());
      engine.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS, CommonsLoggingLogSystem.class.getName());
      engine.setProperty(RuntimeConstants.VM_LIBRARY, "");
      engine.setProperty(RuntimeConstants.RUNTIME_REFERENCES_STRICT, Boolean.TRUE);
      engine.init();
      engine.setProperty(RuntimeConstants.RUNTIME_REFERENCES_STRICT, Boolean.TRUE);
      return engine;
   }

}