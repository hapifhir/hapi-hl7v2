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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Arrays;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.MockitoTest;
import ca.uhn.hl7v2.Version;

/**
 * Test the package list loading from the classpath.
 * 
 * @author <a href="mailto:alexei.guevara@uhn.on.ca">Alexei Guevara</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:49 $ by $Author: jamesagnew $
 */
public class ParserPackageLoadingTest extends MockitoTest {

    private static String versionPackage1 = "foo.bar.1";
    private static String versionPackage2 = "foo.bar.2";
    private static String versionPackage3 = "foo.bar.3";

    private void testPackageList(String theVersion) throws HL7Exception, NoSuchFieldException {

        String packageListResourceName = MessageFormat.format(
                DefaultModelClassFactory.CUSTOM_PACKAGES_RESOURCE_NAME_TEMPLATE, 
                new Object[] { theVersion });

        ClassLoader mockClassLoader = mock(ClassLoader.class);
        
        // Return a new stream each time - the first test loads the packages twice!
        when(mockClassLoader.getResourceAsStream(packageListResourceName))
            .thenAnswer(new Answer<InputStream>() {

            public InputStream answer(InvocationOnMock invocation) throws Throwable {
                return packageListStream();
            }

        });

        Thread.currentThread().setContextClassLoader(mockClassLoader);

        DefaultModelClassFactory.reloadPackages();
        String[] packages = DefaultModelClassFactory.packageList(theVersion);

        String[] expectedPackages = new String[] { 
                versionPackage1, 
                versionPackage2, 
                versionPackage3,
                DefaultModelClassFactory.getVersionPackageName(theVersion) };

        assertEquals(Arrays.asList(expectedPackages), Arrays.asList(packages));
    }

    private InputStream packageListStream() {
        return new ByteArrayInputStream((versionPackage1 + "\n" + versionPackage2 + "\n" + versionPackage3).getBytes());
    }

    @Test
    public void testPackageList() throws Exception {
        for (Version v : Version.values()) {
            testPackageList(v.getVersion());
        }
    }


}
