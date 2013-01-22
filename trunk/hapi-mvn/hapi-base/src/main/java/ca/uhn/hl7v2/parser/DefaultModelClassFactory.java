/**
The contents of this file are subject to the Mozilla Public License Version 1.1
(the "License"); you may not use this file except in compliance with the License.
You may obtain a copy of the License at http://www.mozilla.org/MPL/
Software distributed under the License is distributed on an "AS IS" basis,
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
specific language governing rights and limitations under the License.

The Initial Developer of the Original Code is University Health Network. Copyright (C)
2001.  All Rights Reserved.

Contributor(s): ______________________________________.

Alternatively, the contents of this file may be used under the terms of the
GNU General Public License (the  �GPL�), in which case the provisions of the GPL are
applicable instead of those above.  If you wish to allow use of your version of this
file only under the terms of the GPL and not to allow others to use your version
of this file under the MPL, indicate your decision by deleting  the provisions above
and replace  them with the notice and other provisions required by the GPL License.
If you do not delete the provisions above, a recipient may use your version of
this file under either the MPL or the GPL.

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
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.ErrorCode;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.model.GenericMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Type;

/**
 * Default implementation of ModelClassFactory.  See packageList() for configuration instructions. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.9 $ updated on $Date: 2010-08-05 17:51:16 $ by $Author: jamesagnew $
 */
public class DefaultModelClassFactory extends AbstractModelClassFactory {

    private static final long serialVersionUID = 1;

    private static final Logger log = LoggerFactory.getLogger(DefaultModelClassFactory.class);
    
    static final String CUSTOM_PACKAGES_RESOURCE_NAME_TEMPLATE = "custom_packages/{0}";
    private static final Map<String, String[]> packages = new HashMap<String, String[]>();
    private static List<String> ourVersions = null;

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
     * @param theName name of the desired structure in the form XXX_YYY
     * @param theVersion HL7 version (e.g. "2.3")
     * @param isExplicit true if the structure was specified explicitly in MSH-9-3, false if it 
     *      was inferred from MSH-9-1 and MSH-9-2.  If false, a lookup may be performed to find 
     *      an alternate structure corresponding to that message type and event.   
     * @return corresponding message subclass if found; GenericMessage otherwise
     */
    @SuppressWarnings("unchecked")
	public Class<? extends Message> getMessageClass(String theName, String theVersion, boolean isExplicit) throws HL7Exception {
        if (!isExplicit) {
        	theName = getMessageStructureForEvent(theName, Version.versionOf(theVersion));
        }
        Class<? extends Message> mc = (Class<? extends Message>) findClass(theName, theVersion, "message");
        if (mc == null) 
            mc = GenericMessage.getGenericMessageClass(theVersion);
        return mc;
    }

    /**
     * @see ca.uhn.hl7v2.parser.ModelClassFactory#getGroupClass(java.lang.String, java.lang.String)
     */
    @SuppressWarnings("unchecked")
	public Class<? extends Group> getGroupClass(String theName, String theVersion) throws HL7Exception {
        return (Class<? extends Group>) findClass(theName, theVersion, "group");
    }

    /** 
     * @see ca.uhn.hl7v2.parser.ModelClassFactory#getSegmentClass(java.lang.String, java.lang.String)
     */
    @SuppressWarnings("unchecked")
	public Class<? extends Segment> getSegmentClass(String theName, String theVersion) throws HL7Exception {
        return (Class<? extends Segment>) findClass(theName, theVersion, "segment");
    }

    /** 
     * @see ca.uhn.hl7v2.parser.ModelClassFactory#getTypeClass(java.lang.String, java.lang.String)
     */
    @SuppressWarnings("unchecked")
	public Class<? extends Type> getTypeClass(String theName, String theVersion) throws HL7Exception {
        return (Class<? extends Type>) findClass(theName, theVersion, "datatype");
    }
    
    /**
     * Retrieves and instantiates a message class by looking in a specific java package for the 
     * message type.
     *  
     * @param theName The message structure type (e.g. "ADT_A01")
     * @param theVersion The HL7 version (e.g. "2.3.1")
     * @param isExplicit If false, the message structure is looked up using {@link Parser#getMessageStructureForEvent(String, String)} and converted to the appropriate structure type. For example, "ADT_A04" would be converted to "ADT_A01" because the A04 trigger uses the A01 message structure according to HL7.
     * @param packageName The package name to use. Note that if the message type can't be found in this package, HAPI will return the standard type returned by {@link #getMessageClass(String, String, boolean)}
     * @since 1.3 
     */
	@SuppressWarnings("unchecked")
	public Class<? extends Message> getMessageClassInASpecificPackage(String theName, String theVersion, boolean isExplicit, String packageName) throws HL7Exception {
        if (!isExplicit) { 
        	theName = getMessageStructureForEvent(theName, Version.versionOf(theVersion));
        }

        Class<? extends Message> mc = (Class<? extends Message>) findClassInASpecificPackage(theName, theVersion, "message", packageName);
        if (mc == null) {
            mc = GenericMessage.getGenericMessageClass(theVersion);
        }
        
        return mc; 
    } 


    private static Class<?> findClassInASpecificPackage(String name, String version, String type, String packageName) throws HL7Exception { 
         
		if (packageName == null || packageName.length() == 0) { 
			return findClass(name, version, type); 
		}

		String classNameToTry = packageName + "." + name; 
		 
		try {
            return Class.forName(classNameToTry);
		} catch (ClassNotFoundException e) { 
			if (log.isDebugEnabled()) {
				log.debug("Unable to find class " + classNameToTry + ", using default", e);
			}
			return findClass(name, version, type); 
		} 

    } 
    

    /**
	 * Returns the path to the base package for model elements of the given version
	 * - e.g. "ca/uhn/hl7v2/model/v24/".
	 * This package should have the packages datatype, segment, group, and message
	 * under it. The path ends in with a slash.
     *
     * @param ver HL7 version
     * @return package path of the version
     * @throws HL7Exception if the HL7 version is unknown
	 */
	public static String getVersionPackagePath(String ver) throws HL7Exception {
		Version v = Version.versionOf(ver);
	    if (v == null) { 
	        throw new HL7Exception("The HL7 version " + ver + " is unknown", ErrorCode.UNSUPPORTED_VERSION_ID);
	    }
	    String pkg = v.modelPackageName();
	    return pkg.replace('.', '/');
	}

	/**
	 * Returns the package name for model elements of the given version - e.g.
	 * "ca.uhn.hl7v2.model.v24.".  This method
	 * is identical to <code>getVersionPackagePath(...)</code> except that path
	 * separators are replaced with dots.
     *
     * @param ver HL7 version
     * @return package name of the version
     * @throws HL7Exception if the HL7 version is unknown
     */
	public static String getVersionPackageName(String ver) throws HL7Exception {
	    String path = DefaultModelClassFactory.getVersionPackagePath(ver);
	    String packg = path.replace('/', '.');
	    packg = packg.replace('\\', '.');
	    return packg;
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
     *
     * @param version HL7 version
     * @return array of package prefix names
     */
    public static String[] packageList(String version) throws HL7Exception {
        //get package list for this version 
        return packages.get(version);
    }

    /**
     * Returns a package list for the given version, including the standard package
     * for that version and also user-defined packages (see packageList()). 
     */
    private static String[] loadPackages(String version) throws HL7Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        
        String customPackagesResourceName = 
            MessageFormat.format( CUSTOM_PACKAGES_RESOURCE_NAME_TEMPLATE, version);
        
        InputStream resourceInputStream = classLoader.getResourceAsStream( customPackagesResourceName );
        
        List<String> packageList = new ArrayList<String>();
        
        if ( resourceInputStream != null) {
            BufferedReader in = new BufferedReader(new InputStreamReader(resourceInputStream));
            
            try {
                String line = in.readLine();
                while (line != null) {
                    log.info( "Adding package to user-defined package list: {}", line );
                    packageList.add( line );
                    line = in.readLine();
                }
                
            } catch (IOException e) {
                log.error( "Can't load all the custom package list - user-defined classes may not be recognized", e );
            }
            
        }
        else {
            log.debug("No user-defined packages for version {}", version);
        }

        //add standard package
        packageList.add( getVersionPackageName(version) );
        return packageList.toArray(new String[packageList.size()]);
    }

    /**
     * Finds a message or segment class by name and version.
     * @param name the segment or message structure name 
     * @param version the HL7 version
     * @param type 'message', 'group', 'segment', or 'datatype'  
     */
    private static Class<?> findClass(String name, String version, String type) throws HL7Exception {
        Parser.assertVersionExists(version);

        //get list of packages to search for the corresponding message class 
        String[] packageList = packageList(version);

        if (packageList == null) {
        	return null;
        }
        
        //get subpackage for component type
        String types = "message|group|segment|datatype";
        if (!types.contains(type))
            throw new HL7Exception("Can't find " + name + " for version " + version 
                        + " -- type must be " + types + " but is " + type);
        
        //try to load class from each package
        Class<?> compClass = null;
        int c = 0;
        while (compClass == null && c < packageList.length) {
            String classNameToTry = null;
            try {
                String p = packageList[c];
                if (!p.endsWith("."))
                    p = p + ".";
                classNameToTry = p + type + "." + name;

                if (log.isDebugEnabled()) {
                    log.debug("Trying to load: {}", classNameToTry);                    
                }
                compClass = Class.forName(classNameToTry);
                if (log.isDebugEnabled()) {
                    log.debug("Loaded: {} class: {}", classNameToTry, compClass);                    
                }
            }
            catch (ClassNotFoundException cne) {
                log.debug("Failed to load: {}", classNameToTry);                    
                /* just try next one */
            }
            c++;
        }
        return compClass;
    }


    /**
	 * Reloads the packages. Note that this should not be performed
	 * after and messages have been parsed or otherwise generated,
	 * as undetermined behaviour may result. 
	 */
	public static void reloadPackages() {
        packages.clear();
        ourVersions = new ArrayList<String>();
        for (Version v : Version.values()) {
            try {
                String[] versionPackages = loadPackages(v.getVersion());
                if (versionPackages.length > 0) {
                    ourVersions.add(v.getVersion());
                }
                packages.put(v.getVersion(), versionPackages);
            } catch (HL7Exception e) {
                throw new Error("Version \"" + v.getVersion() + "\" is invalid. This is a programming error: ", e);
            }
        }		
	}

	
	/**
	 * Returns a string containing the highest known version of HL7 known to HAPI (i.e. "2.6"). Note that this
	 * is determined by checking which structure JARs are available on the classpath, so if this release of
	 * HAPI supports version 2.6, but only the hapi-structures-v23.jar is available on the classpath,
	 * "2.3" will be returned
     *
     * @return the most recent HL7 version known to HAPI
	 */
	public static String getHighestKnownVersion() {
	    if (ourVersions == null || ourVersions.size() == 0) {
	        return null;
	    }
	    return ourVersions.get(ourVersions.size() - 1);
	}
	
	/**
	 * Returns the event structure. If nothing could be found, the event name is returned
	 * 
	 * @see ca.uhn.hl7v2.parser.AbstractModelClassFactory#getMessageStructureForEvent(java.lang.String, ca.uhn.hl7v2.Version)
	 */
	@Override
	public String getMessageStructureForEvent(String name, Version version) throws HL7Exception {
		String structure = super.getMessageStructureForEvent(name, version);
		return structure != null ? structure : name;
	}



}
