package ca.uhn.hl7v2.conf.store;

import junit.framework.TestCase;
import ca.uhn.hl7v2.conf.ProfileException;

/**
 * @author Administrator
 * Created on 2-Sep-2003
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class ProfileCodeStoreTest extends TestCase {

	private java.net.URL url 
		= ProfileCodeStoreTest.class.getClassLoader().getResource("ca/uhn/hl7v2/conf/store/sampleTables.xml");
	private String codeSys = "HL70001";
	//private String profileId = "{ConfSig(1) CCO(1) 2.4(7) static-profile(1) ADT(3) A01(1) null(0) ADT_A01(4) HL7 2.4(1) Sender(1)}";
	private String code = "M";
	private String[] codeArray = { "M", "F", "O", "U" };
	private ProfileCodeStore codeStore;

	/** 
	 * @throws Exception 
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		codeStore = new ProfileCodeStore(url);
	} //end setup 

	/**
	* Constructor for ProfileCodeStoreTest.
	* @param arg0
	*/
	public ProfileCodeStoreTest(String arg0) {
		super(arg0);
	}

	/**
	 * @throws ProfileException
	 * void
	 * Test valid single code from getValidCodes()
	 */
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
	public void testKnowsCodesPos() throws ProfileException {
		assertTrue(codeStore.knowsCodes(codeSys));
	} //end method    

	/**
	 * @throws ProfileException
	 * void
	 * Test isValidCode()
	 */
	public void testIsValidCodePos() throws ProfileException {
		assertTrue(codeStore.isValidCode(codeSys, code));
	} //end method

	/**
	* @throws ProfileException
	* void
	* Test isValidCode() using a code that maps to table values containing wildcard characters
	*/
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
    public void testIsValidCodePos3() throws ProfileException {
        String codeSys = "HL70361";
        String code1 = "Misys CPR"; 
        codeStore.getValidCodes(codeSys);
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
	public void testGetValidCodesNeg2() throws ProfileException {
		try {
			codeStore.getValidCodes("HL7XXXX");
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
	public void testGetValidCodesNeg3() throws ProfileException {
		try {
			codeStore.getValidCodes(null);
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
	public void testGetValidCodesNeg4() throws ProfileException {
		try {
			codeStore.getValidCodes("XXX");
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
	public void testKnowsCodesNeg() throws ProfileException {
		assertTrue(!codeStore.knowsCodes("XXX"));
	} //end method

	/**
	 * @throws ProfileException
	 * void
	 * Test for invalid code
	 */
	public void testIsValidCodeNeg() throws ProfileException {
		assertTrue(!codeStore.isValidCode("HL70001", "X"));
	} //end method

} //end class
