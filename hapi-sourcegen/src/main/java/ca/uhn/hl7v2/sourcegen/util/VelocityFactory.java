/*
 * Created on Apr 19, 2006
 */
package ca.uhn.hl7v2.sourcegen.util;


/**
 * Simple utility class to generate velocity engines.
 * 
 * Copied from UHN internal class under "commons-se"
 * 
 * @author <a href="mailto:jamesagnew@users.sourceforge.net">James Agnew </a>
 * @version $Revision: 1.1 $ updated on $Date: 2010-03-16 17:13:22 $ by $Author:
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
//   public static Template getClasspathTemplateInstance(String theTemplate) throws Exception {
//      VelocityEngine engine = getEngineInstance();
//      return engine.getTemplate(theTemplate);
//   }


   /**
    * @return Returns a velocity engine
    * @throws Exception
    *                If engine fails to initialize
    */
//   public static VelocityEngine getEngineInstance() throws Exception {
//      VelocityEngine engine = new VelocityEngine();
//      engine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
//      engine.setProperty("classpath." + RuntimeConstants.RESOURCE_LOADER + ".class", ClasspathResourceLoader.class
//            .getName());
//      engine.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS, CommonsLoggingLogSystem.class.getName());
//      engine.setProperty(RuntimeConstants.VM_LIBRARY, "");
//      engine.init();
//      return engine;
//   }

}