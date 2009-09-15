package ca.uhn.hl7v2.conf.store.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.ops4j.pax.exam.CoreOptions.equinox;
import static org.ops4j.pax.exam.CoreOptions.felix;
import static org.ops4j.pax.exam.CoreOptions.frameworks;
import static org.ops4j.pax.exam.CoreOptions.knopflerfish;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.options;
import static org.ops4j.pax.exam.CoreOptions.systemProperty;
import static org.ops4j.pax.exam.CoreOptions.wrappedBundle;
import static org.ops4j.pax.exam.container.def.PaxRunnerOptions.logProfile;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Inject;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.osgi.framework.BundleContext;

import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.hl7v2.conf.store.ProfileCodeStore;



/**
 * @author Administrator
 * Created on 2-Sep-2003
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 */
@RunWith(JUnit4TestRunner.class)
public class ProfileCodeStoreTest{

 // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(ProfileCodeStoreTest.class);
    
    @Inject
    BundleContext bundleContext;
    
    @Configuration
    public static Option[] configure() {
	return options(frameworks(equinox(), felix(), knopflerfish())
		, logProfile()
		, systemProperty("org.ops4j.pax.logging.DefaultServiceLog.level").value("INFO")
		, mavenBundle().groupId("org.ops4j.pax.url").artifactId("pax-url-mvn").version("0.4.0")
		, wrappedBundle(mavenBundle().groupId("org.ops4j.base").artifactId("ops4j-base-util").version("0.5.3"))
		, mavenBundle().groupId("ca.uhn.hapi").artifactId("hapi-osgi-base").version("1.0-beta1")
//		, vmOption("-Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5006" )


	);
    } 
    
    
	private java.net.URL url 
		= ProfileCodeStoreTest.class.getClassLoader().getResource("ca/uhn/hl7v2/conf/store/tests/sampleTables.xml");
	private String codeSys = "HL70001";
	//private String profileId = "{ConfSig(1) CCO(1) 2.4(7) static-profile(1) ADT(3) A01(1) null(0) ADT_A01(4) HL7 2.4(1) Sender(1)}";
	private String code = "M";
	private String[] codeArray = { "M", "F", "O", "U" };
	private ProfileCodeStore codeStore;

	@Before
	public void BeforeTheTest() throws Exception {
		codeStore = new ProfileCodeStore(url);
	} 

	/**
	 * @throws ProfileException
	 * void
	 * Test valid single code from getValidCodes()
	 */
	@Test
	public void testGetValidCodesPos1() throws ProfileException {
		String[] list = codeStore.getValidCodes(codeSys);
		boolean found = false;
		for (int i = 0; i < list.length; i++) {
			if (list[i].equals(code)) {
				found = true;
			} //end if
		} //end for
		assertTrue(found);
	} //end method

	/**
	 * @throws ProfileException
	 * void
	 * test valid multiple codes from getValidCodes()
	 */
	@Test
	public void testGetValidCodesPos2() throws ProfileException {
		String[] list = codeStore.getValidCodes(codeSys);
		int found = 0;
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < codeArray.length; j++) {
				if (list[i].equals(codeArray[j])) {
					found = found + 1;
					//System.out.println(found);
				} //end if
			} //end for			
		} //end for
		assertTrue(found == codeArray.length);
	} //end method    

	/**
	 * @throws ProfileException
	 * void
	 * Test knowsCodes()
	 */
	@Test
	public void testKnowsCodesPos() throws ProfileException {
		assertTrue(codeStore.knowsCodes(codeSys));
	} //end method    

	/**
	 * @throws ProfileException
	 * void
	 * Test isValidCode()
	 */
	@Test
	public void testIsValidCodePos() throws ProfileException {
		assertTrue(codeStore.isValidCode(codeSys, code));
	} //end method

	/**
	* @throws ProfileException
	* void
	* Test isValidCode() using a code that maps to table values containing wildcard characters
	*/
	@Test
	public void testIsValidCodePos2() throws ProfileException {
        String codeSys = "HL70396";
        String code1 = "99cbc";
        String code2 = "L";
        String code3 = "99zzz";
        String code4 = "HL76666";
		assertTrue(codeStore.isValidCode(codeSys, code1));
        assertTrue(codeStore.isValidCode(codeSys, code2));
        assertTrue(codeStore.isValidCode(codeSys, code3));
        assertTrue(codeStore.isValidCode(codeSys, code4));        
	} //end method
    
    /**
    * @throws ProfileException
    * void
    * Test isValidCode() using a code that has a space
    */
    @Test
    public void testIsValidCodePos3() throws ProfileException {
        String codeSys = "HL70361";
        String code1 = "Misys CPR"; 
        String[] list = codeStore.getValidCodes(codeSys);
        //for (int i = 0; i < list.length; i++) {
        //        System.out.println(list[i]);   
        //} //end for
        assertTrue(codeStore.isValidCode(codeSys, code1));            
    } //end method
    
    

	//	  /**
	//     * @throws ProfileException
	//     * void
	//     * Test for invalid profile
	//     */
	//    public void testGetValidCodesNeg1() throws ProfileException {
	//        try{
	//            String[] list = codeStore.getValidCodes("XXX", "HL70001");
	//            fail("profile should not exist");
	//        }//end try
	//        catch(ProfileException e){
	//            assertEquals(e.getMessage(),"The input profileId is not valid or is not specified for the spec xml table doc");            
	//        }//end catch        
	//    } //end method
          

	/**
	 * @throws ProfileException
	 * void
	 * Test for presence of invalid codeSys
	 */
    	@Test
	public void testGetValidCodesNeg2() throws ProfileException {
		try {
			String[] list = codeStore.getValidCodes("HL7XXXX");
			fail("codeSystem should not exist");
		} //end try
		catch (ProfileException e) {
			assertTrue(true);
		} //end catch        
	} //end method

	/**
	 * @throws ProfileException
	 * void
	 * Test for null check on codeSys
	 */
    	@Test
	public void testGetValidCodesNeg3() throws ProfileException {
		try {
			String[] list = codeStore.getValidCodes(null);
			fail("codeSystem should not exist");
		} //end try
		catch (ProfileException e) {
			assertEquals(e.getMessage(), "The input codeSystem parameter cannot be null");
		} //end catch        
	} //end method

	/**
	 * @throws ProfileException
	 * void
	 * Test for invalid codeSys length
	 */
    	@Test
	public void testGetValidCodesNeg4() throws ProfileException {
		try {
			String[] list = codeStore.getValidCodes("XXX");
			fail("codeSystem should not exist");
		} //end try
		catch (ProfileException e) {
			assertEquals(e.getMessage(), "The input codeSystem parameter cannot be less than 4 characters long");
		} //end catch        
	} //end method

	/**
	 * @throws ProfileException
	 * void
	 * Test for presence of invalid code in the list
	 */
    	@Test
	public void testGetValidCodesNeg5() throws ProfileException {
		String[] list = codeStore.getValidCodes(codeSys);
		boolean notfound = true;
		for (int i = 0; i < list.length; i++) {
			if (list[i].equals("X")) {
				notfound = false;
			} //end if
		} //end for
		assertTrue(notfound);
	} //end method      

	/**
	 * @throws ProfileException
	 * void
	 * Test for invalid codeSys
	 */
    	@Test
	public void testKnowsCodesNeg() throws ProfileException {
		assertTrue(!codeStore.knowsCodes("XXX"));
	} //end method

	/**
	 * @throws ProfileException
	 * void
	 * Test for invalid code
	 */
    	@Test
	public void testIsValidCodeNeg() throws ProfileException {
		assertTrue(!codeStore.isValidCode("HL70001", "X"));
	} //end method

} //end class
