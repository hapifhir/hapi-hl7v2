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

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.util.StringUtil;

/**
 * ModelClassFactory which allows custom packages to search to be specified.
 * These packages will be searched first, and if nothing is found for a particular
 * structure, a delegate ModelClassFactory (by default DefaultModelClassFactory) is used. 
 * <p>
 * Also, a custom event map location is supported (by setting {@link #setEventMapDirectory(String)}
 * in a way that only new or modified structures needs to be defined there. If no structure was
 * found, the event map of the delegate ModelClassFactory serves as fallback.
 *
 * @author Christian Ohr
 * @author James Agnew
 * @since 1.0
 */
public class CustomModelClassFactory extends AbstractModelClassFactory {

    private static final long serialVersionUID = 1;
    private static Logger LOG = LoggerFactory.getLogger(CustomModelClassFactory.class);

    private final ModelClassFactory delegate;
    private Map<String, String[]> customModelClasses;

    /**
     * Constructor which just delegated to {@link DefaultModelClassFactory}
     */
    public CustomModelClassFactory() {
        this((Map<String, String[]>)null);
    }


    /**
     * Constructor
     *
     * @param packageName The base package name to use.
     * <p>
     * When searching, package specified here will be appended with .[version].[structure type].
     * </p>
     * <p>
     * So, for instance, when looking for a v2.5 segment object, if "<code>com.foo</code>" is passed in, HAPI will look in "<code>com.foo.v25.segment.*</code>"
     * </p>
     */
    public CustomModelClassFactory(String packageName) {
        this(new HashMap<String, String[]>());

        if (!packageName.endsWith(".")) {
            packageName += ".";
        }
        for (Version v : Version.values()) {
        	addModel(v.getVersion(), new String[] {packageName + v.getPackageVersion()});
        }
    }

    
    /**
     * Constructor
     * @param map Map of packages to include.
     * <p>
     * Keys are versions of HL7, e.g. "2.5".
     * </p>
     * <p>
     * Values are an array of packages to search in for custom model classes.
     * When searching, the package name here will be appended with "<b>.[structure type]</b>".
     * So, for example, to specify a custom message type, you could create the class
     * <code>foo.example.v23.message.ZRM_Z01</code>, and pass in the string "<code>foo.example.v23</code>".
     * </p>
     */
    public CustomModelClassFactory(Map<String, String[]> map) {
        this(new DefaultModelClassFactory(), map);
    }
    
    /**
     * Set an explicit {@link ModelClassFactory} is underlying delegate
     * @param defaultFactory default factory to be delegated to
     * @param map custom model map
     */
    public CustomModelClassFactory(ModelClassFactory defaultFactory, Map<String, String[]> map) {
        this.delegate = defaultFactory;
        customModelClasses = map;
    }    

    /**
     * {@inheritDoc }
     */
	public Class<? extends Message> getMessageClass(String name, String version, boolean isExplicit) throws HL7Exception {
        if (!isExplicit) {
            name = getMessageStructureForEvent(name, Version.versionOf(version));
        }
        Class<? extends Message> retVal = findClass("message", name, version);
        if (retVal == null) {
            retVal = delegate.getMessageClass(name, version, isExplicit);
        }
        return retVal;
    }

    /**
     * {@inheritDoc }
     */
	public Class<? extends Group> getGroupClass(String name, String version) throws HL7Exception {
        Class<? extends Group> retVal = findClass("group", name, version);
        if (retVal == null) {
            retVal = delegate.getGroupClass(name, version);
        }
        return retVal;
    }

    /**
     * {@inheritDoc }
     */
	public Class<? extends Segment> getSegmentClass(String name, String version) throws HL7Exception {
        Class<? extends Segment> retVal = findClass("segment", name, version);
        if (retVal == null) {
            retVal = delegate.getSegmentClass(name, version);
        }
        return retVal;
    }

    /**
     * {@inheritDoc }
     */
	public Class<? extends Type> getTypeClass(String name, String version) throws HL7Exception {
        Class<? extends Type> retVal = findClass("datatype", name, version);
        if (retVal == null) {
            retVal = delegate.getTypeClass(name, version);
        }
        return retVal;
    }

    /**
     * Finds appropriate classes to be loaded for the given structure/type
     */
    @SuppressWarnings("unchecked")
	protected <T> Class<T> findClass(String subpackage, String name, String version) throws HL7Exception {
        Parser.assertVersionExists(version);
        Class<T> classLoaded = null;
        if (customModelClasses != null) {
            if (customModelClasses.containsKey(version)) {
                for (String next : customModelClasses.get(version)) {
                    if (!next.endsWith(".")) {
                        next += ".";
                    }
                    String fullyQualifiedName = next + subpackage + '.' + name;
                    try {
                        classLoaded = (Class<T>) Class.forName(fullyQualifiedName);
                        LOG.debug("Found " + fullyQualifiedName + " in custom HL7 model");
                    } catch (ClassNotFoundException e) {
                        // ignore
                    }
                }
            }
        }
        return classLoaded;
    }

    /**
     * Delegates calls to {@link DefaultModelClassFactory#getMessageClassInASpecificPackage(String, String, boolean, String)}
     */
	public Class<? extends Message> getMessageClassInASpecificPackage(String theName, String theVersion, boolean theIsExplicit, String thePackageName) throws HL7Exception {
		return delegate.getMessageClassInASpecificPackage(theName, theVersion, theIsExplicit, thePackageName);
	}

    /**
     * Returns the configured custom model classes
     * @return a map of custom model classes
     */
    public Map<String, String[]> getCustomModelClasses() {
		return customModelClasses;
	}

	/**
	 * Add model class packages after the object has been instantiated
	 * 
	 * @param addedModelClasses map with version number as key and package names has value
	 */
	public void addModels(Map<String, String[]> addedModelClasses) {
        if (customModelClasses == null) {
        	customModelClasses = new HashMap<String, String[]>();
        }
        for (Entry<String, String[]> entry : addedModelClasses.entrySet()) {
        	addModel(entry.getKey(), entry.getValue());
        }
    }
	
	private void addModel(String version, String[] newPackageNames) {
        if (customModelClasses.containsKey(version)) {
            // the new packages must be added after the existing ones.
            String[] existingPackageNames = customModelClasses.get(version);
            customModelClasses.put(version, StringUtil.concatenate(existingPackageNames, newPackageNames));
        } else {
        	customModelClasses.put(version, newPackageNames);
        }		
	}


	/**
	 * Looks up its own event map. If no structure was found, the call is delegated to
	 * the default ModelClassFactory. If nothing can be found, the eventName is returned
	 * as structure.
	 * 
	 * @see ca.uhn.hl7v2.parser.AbstractModelClassFactory#getMessageStructureForEvent(java.lang.String, ca.uhn.hl7v2.Version)
	 */
	@Override
	public String getMessageStructureForEvent(String eventName, Version version) throws HL7Exception {
		String structure = super.getMessageStructureForEvent(eventName, version);
		if (structure == null) {
			structure = delegate.getMessageStructureForEvent(eventName, version);
		}
		if (structure != null) {
			structure = eventName;
		}
		return structure;
	}
	
	
	
}
