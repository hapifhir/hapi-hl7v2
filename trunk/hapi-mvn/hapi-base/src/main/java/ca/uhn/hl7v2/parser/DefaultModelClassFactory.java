/*
 * Created on 21-Apr-2005
 */
package ca.uhn.hl7v2.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.GenericMessage;
import ca.uhn.hl7v2.sourcegen.SourceGenerator;
import ca.uhn.log.HapiLog;
import ca.uhn.log.HapiLogFactory;

/**
 * Default implementation of ModelClassFactory.  See packageList() for configuration instructions. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.2 $ updated on $Date: 2009-03-18 23:27:58 $ by $Author: jamesagnew $
 */
public class DefaultModelClassFactory implements ModelClassFactory {

    private static final HapiLog log = HapiLogFactory.getHapiLog(DefaultModelClassFactory.class);
    
    private static final String CUSTOM_PACKAGES_RESOURCE_NAME_TEMPLATE = "custom_packages/{0}";
    private static final HashMap packages = new HashMap();

    static {
        reloadPackages();
    }
    
    
    /** 
     * <p>Attempts to return the message class corresponding to the given name, by 
     * searching through default and user-defined (as per packageList()) packages. 
     * Returns GenericMessage if the class is not found.</p>
     * <p>It is important to note that there can only be one implementation of a particular message 
     * structure (i.e. one class with the message structure name, regardless of its package) among 
     * the packages defined as per the <code>packageList()</code> method.  If there are duplicates 
     * (e.g. two ADT_A01 classes) the first one in the search order will always be used.  However, 
     * this restriction only applies to message classes, not (normally) segment classes, etc.  This is because 
     * classes representing parts of a message are referenced explicitly in the code for the message 
     * class, rather than being looked up (using findMessageClass() ) based on the String value of MSH-9. 
     * The exception is that Segments may have to be looked up by name when they appear 
     * in unexpected locations (e.g. by local extension) -- see findSegmentClass().</p>  
     * <p>Note: the current implementation will be slow if there are multiple user-
     * defined packages, because the JVM will try to load a number of non-existent 
     * classes every parse.  This should be changed so that specific classes, rather 
     * than packages, are registered by name.</p>
     * 
     * @param name name of the desired structure in the form XXX_YYY
     * @param version HL7 version (e.g. "2.3")  
     * @param isExplicit true if the structure was specified explicitly in MSH-9-3, false if it 
     *      was inferred from MSH-9-1 and MSH-9-2.  If false, a lookup may be performed to find 
     *      an alternate structure corresponding to that message type and event.   
     * @return corresponding message subclass if found; GenericMessage otherwise
     */
    public Class getMessageClass(String theName, String theVersion, boolean isExplicit) throws HL7Exception {
        Class mc = null;
        if (!isExplicit) {
            theName = Parser.getMessageStructureForEvent(theName, theVersion);
        } 
        mc = findClass(theName, theVersion, "message");
        if (mc == null) 
            mc = GenericMessage.getGenericMessageClass(theVersion);
        return mc;
    }

    /**
     * @see ca.uhn.hl7v2.parser.ModelClassFactory#getGroupClass(java.lang.String, java.lang.String)
     */
    public Class getGroupClass(String theName, String theVersion) throws HL7Exception {
        return findClass(theName, theVersion, "group");
    }

    /** 
     * @see ca.uhn.hl7v2.parser.ModelClassFactory#getSegmentClass(java.lang.String, java.lang.String)
     */
    public Class getSegmentClass(String theName, String theVersion) throws HL7Exception {
        return findClass(theName, theVersion, "segment");
    }

    /** 
     * @see ca.uhn.hl7v2.parser.ModelClassFactory#getTypeClass(java.lang.String, java.lang.String)
     */
    public Class getTypeClass(String theName, String theVersion) throws HL7Exception {
        return findClass(theName, theVersion, "datatype");
    }

    /** 
     * <p>Lists all the packages (user-definable) where classes for standard and custom 
     * messages may be found.  Each package has subpackages called "message", 
     * "group", "segment", and "datatype" in which classes for these message elements 
     * can be found. </p> 
     * <p>At a minimum, this method returns the standard package for the 
     * given version.  For example, for version 2.4, the package list contains <code>
     * ca.uhn.hl7v2.model.v24</code>.  In addition, user-defined packages may be specified
     * for custom messages.</p>
     * <p>If you define custom message classes, and want Parsers to be able to 
     * find them, you must register them as follows (otherwise you will get an exception when 
     * the corresponding messages are parsed).  For each HL7 version you want to support, you must 
     * put a text file on your classpath, under the folder /custom_packages, named after the version.  For example, 
     * for version 2.4, you might put the file "custom_packages/2.4" in your application JAR.  Each line in the  
     * file should name a package to search for message classes of that version.  For example, if you 
     * work at foo.org, you might create a v2.4 message structure called "ZFO" and define it in the class
     * <code>org.foo.hl7.custom.message.ZFO<code>.  In order for parsers to find this message
     * class, you would need to enter the following line in custom_packages/2.4:</p>
     * <p>org.foo.hl7.custom</p>
     * <p>Packages are searched in the order specified.  The standard package for a given version
     * is searched last, allowing you to override the default implementation.  Please note that 
     * if you create custom classes for messages, segments, etc., their names must correspond exactly 
     * to their names in the message text.  For example, if you subclass the QBP segment in order to 
     * add your own fields, your subclass must also be called QBP. although it will obviously be in 
     * a different package.  To make sure your class is used instead of the default implementation, 
     * put your package in the package list.  User-defined packages are searched first, so yours 
     * will be found first and used.  </p>
     * <p>It is important to note that there can only be one implementation of a particular message 
     * structure (i.e. one class with the message structure name, regardless of its package) among 
     * the packages defined as per the <code>packageList()</code> method.  If there are duplicates 
     * (e.g. two ADT_A01 classes) the first one in the search order will always be used.  However, 
     * this restriction only applies to message classes, not segment classes, etc.  This is because 
     * classes representing parts of a message are referenced explicitly in the code for the message 
     * class, rather than being looked up (using findMessageClass() ) based on the String value of MSH-9.<p>  
     */
    public static String[] packageList(String version) throws HL7Exception {
        //get package list for this version 
        return (String[]) packages.get(version);
    }

    /**
     * Returns a package list for the given version, including the standard package
     * for that version and also user-defined packages (see packageList()). 
     */
    private static String[] loadPackages(String version) throws HL7Exception {
        String[] retVal = null;
        
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        
        String customPackagesResourceName = 
            MessageFormat.format( CUSTOM_PACKAGES_RESOURCE_NAME_TEMPLATE, new Object[] { version } );
        
        InputStream resourceInputStream = classLoader.getResourceAsStream( customPackagesResourceName );
        
        List packageList = new ArrayList();
        
        if ( resourceInputStream != null) {
            BufferedReader in = new BufferedReader(new InputStreamReader(resourceInputStream));
            
            try {
                String line = in.readLine();
                while (line != null) {
                    log.info( "Adding package to user-defined package list: " + line );
                    packageList.add( line );
                    line = in.readLine();
                }
                
            } catch (IOException e) {
                log.error( "Can't load all the custom package list - user-defined classes may not be recognized", e );
            }
            
        }
        else {
            log.debug("No user-defined packages for version " + version);
        }

        //add standard package
        packageList.add( SourceGenerator.getVersionPackageName(version) );
        retVal = (String[]) packageList.toArray( new String[] {} );

        return retVal;
    }

    /**
     * Finds a message or segment class by name and version.
     * @param name the segment or message structure name 
     * @param version the HL7 version
     * @param type 'message', 'group', 'segment', or 'datatype'  
     */
    private static Class findClass(String name, String version, String type) throws HL7Exception {
        if (Parser.validVersion(version) == false) {
            throw new HL7Exception(
                "The HL7 version " + version + " is not recognized",
                HL7Exception.UNSUPPORTED_VERSION_ID);
        }

        //get list of packages to search for the corresponding message class 
        String[] packages = packageList(version);

        //get subpackage for component type
        String types = "message|group|segment|datatype";
        if (types.indexOf(type) < 0) 
            throw new HL7Exception("Can't find " + name + " for version " + version 
                        + " -- type must be " + types + " but is " + type);
        String subpackage = type;
        
        //try to load class from each package
        Class compClass = null;
        int c = 0;
        while (compClass == null && c < packages.length) {
            try {
                String p = packages[c];
                if (!p.endsWith("."))
                    p = p + ".";
                String classNameToTry = p + subpackage + "." + name;

                if (log.isDebugEnabled()) {
                    log.debug("Trying to load: " + classNameToTry);                    
                }
                compClass = Class.forName(classNameToTry);
                if (log.isDebugEnabled()) {
                    log.debug("Loaded: " + classNameToTry + " class: " + compClass);                    
                }
            }
            catch (ClassNotFoundException cne) {
                /* just try next one */
            }
            c++;
        }
        return compClass;
    }


    /**
     * Temporary delegate method for mavenizing
     * 
     * @see SourceGenerator#getVersionPackageName(String) 
     */
	public static String getVersionPackageName(String ver) throws HL7Exception {
		return SourceGenerator.getVersionPackageName(ver);
	}

	/**
     * Temporary delegate method for mavenizing
     * 
     * @see SourceGenerator#getVersionPackagePath(String) 
	 */
	public static String getVersionPackagePath(String ver) throws HL7Exception {
		return SourceGenerator.getVersionPackagePath(ver);
	}

	/**
	 * Reloads the packages. Note that this should not be performed
	 * after and messages have been parsed or otherwise generated,
	 * as undetermined behaviour may result. 
	 */
	public static void reloadPackages() {
        String[] versions = { "2.1", "2.2", "2.3", "2.3.1", "2.4", "2.5" };
        packages.clear();
        for (int i = 0; i < versions.length; i++) {
            try {
                packages.put(versions[i], loadPackages(versions[i]));
            } catch (HL7Exception e) {
                throw new Error("Version \"" + versions[i] + "\" is invalid. This is a programming error: ", e);
            }
        }		
	}


}
