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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Type;

/**
 * ModelClassFactory which allows custom packages to search to be specified.
 * These packages will be searched first, and if nothing is found for a particular
 * structure, DefaultModelClassFactory is used.
 *
 * @author Based on implementation by Christian Ohr
 * @author James Agnew
 * @since 1.0
 */
public class CustomModelClassFactory implements ModelClassFactory {

    private static final long serialVersionUID = 1;
    private final ModelClassFactory defaultFactory;
    private Map<String, String[]> customModelClasses;
    private static Logger LOG = LoggerFactory.getLogger(CustomModelClassFactory.class);

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
        defaultFactory = new DefaultModelClassFactory();
        customModelClasses = new HashMap<String, String[]>();

        if (!packageName.endsWith(".")) {
            packageName += ".";
        }

        for (Version v : Version.values()) {
            customModelClasses.put(v.getVersion(), new String[] {packageName + v.getPackageVersion()});
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
        defaultFactory = new DefaultModelClassFactory();
        customModelClasses = map;
    }


    /**
     * {@inheritDoc }
     */
    @SuppressWarnings("unchecked")
	public Class<? extends Message> getMessageClass(String name, String version, boolean isExplicit) throws HL7Exception {
        if (!isExplicit) {
            name = Parser.getMessageStructureForEvent(name, version);
        }
        Class<? extends Message> retVal = (Class<? extends Message>) findClass("message", name, version);
        if (retVal == null) {
            retVal = defaultFactory.getMessageClass(name, version, isExplicit);
        }
        return retVal;
    }

    /**
     * {@inheritDoc }
     */
    @SuppressWarnings("unchecked")
	public Class<? extends Group> getGroupClass(String name, String version) throws HL7Exception {
        Class<? extends Group> retVal = (Class<? extends Group>) findClass("group", name, version);
        if (retVal == null) {
            retVal = defaultFactory.getGroupClass(name, version);
        }
        return retVal;
    }

    /**
     * {@inheritDoc }
     */
    @SuppressWarnings("unchecked")
	public Class<? extends Segment> getSegmentClass(String name, String version) throws HL7Exception {
        Class<? extends Segment> retVal = (Class<? extends Segment>) findClass("segment", name, version);
        if (retVal == null) {
            retVal = defaultFactory.getSegmentClass(name, version);
        }
        return retVal;
    }

    /**
     * {@inheritDoc }
     */
    @SuppressWarnings("unchecked")
	public Class<? extends Type> getTypeClass(String name, String version) throws HL7Exception {
        Class<? extends Type> retVal = (Class<? extends Type>) findClass("datatype", name, version);
        if (retVal == null) {
            retVal = defaultFactory.getTypeClass(name, version);
        }
        return retVal;
    }

    /**
     * Finds appropriate classes to be loaded for the given structure/type
     */
    protected Class<?> findClass(String subpackage, String name, String version) throws HL7Exception {
        Parser.assertVersionExists(version);
        Class<?> classLoaded = null;
        if (customModelClasses != null) {
            if (customModelClasses.containsKey(version)) {
                for (String next : customModelClasses.get(version)) {
                    if (!next.endsWith(".")) {
                        next += ".";
                    }
                    String fullyQualifiedName = next + subpackage + '.' + name;
                    try {
                        classLoaded = Class.forName(fullyQualifiedName);
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
		return defaultFactory.getMessageClassInASpecificPackage(theName, theVersion, theIsExplicit, thePackageName);
	}
}
