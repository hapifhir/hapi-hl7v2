package ca.uhn.hl7v2.conf.store;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ca.uhn.hl7v2.conf.ProfileException;

/**
 * @author Administrator Created on 2-Sep-2003 To change this generated comment go to
 *         Window>Preferences>Java>Code Generation>Code and Comments
 */
public class ProfileCodeStoreTest {

	private java.net.URL url = ProfileCodeStoreTest.class.getClassLoader().getResource(
			"ca/uhn/hl7v2/conf/store/sampleTables.xml");
	private String codeSys = "HL70001";
	// private String profileId =
	// "{ConfSig(1) CCO(1) 2.4(7) static-profile(1) ADT(3) A01(1) null(0) ADT_A01(4) HL7 2.4(1) Sender(1)}";
	private String code = "M";
	private String[] codeArray = { "M", "F", "O", "U" };
	private ProfileCodeStore codeStore;

	@Before
	public void setUp() throws Exception {
		codeStore = new ProfileCodeStore(url);
	}

	@Test
	public void testGetValidCodesPos1() throws ProfileException {
		assertTrue(Arrays.asList(codeStore.getValidCodes(codeSys)).contains(code));
	}

	@Test
	public void testGetValidCodesPos2() throws ProfileException {
		List<String> codes = Arrays.asList(codeStore.getValidCodes(codeSys));
		for (String code : codeArray) {
			assertTrue(codes.contains(code));
		}
	}

	@Test
	public void testKnowsCodesPos() throws ProfileException {
		assertTrue(codeStore.knowsCodes(codeSys));
	}

	@Test
	public void testIsValidCodePos() throws ProfileException {
		assertTrue(codeStore.isValidCode(codeSys, code));
	}

	/**
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
	}

	/**
	 * Test isValidCode() using a code that has a space
	 */
	@Test
	public void testIsValidCodePos3() throws ProfileException {
		String codeSys = "HL70361";
		String code1 = "Misys CPR";
		codeStore.getValidCodes(codeSys);
		assertTrue(codeStore.isValidCode(codeSys, code1));
	}

	/**
	 * @throws ProfileException void Test for presence of invalid codeSys
	 */
	@Test(expected = ProfileException.class)
	public void testGetValidCodesNeg2() throws ProfileException {
		codeStore.getValidCodes("HL7XXXX");
	}

	/**
	 * Test for null check on codeSys
	 */
	@Test
	public void testGetValidCodesNeg3() throws ProfileException {
		try {
			codeStore.getValidCodes(null);
			fail("codeSystem should not exist");
		} catch (ProfileException e) {
			assertEquals(e.getMessage(), "The input codeSystem parameter cannot be null");
		}
	}

	/**
	 * Test for invalid codeSys length
	 */
	@Test
	public void testGetValidCodesNeg4() throws ProfileException {
		try {
			codeStore.getValidCodes("XXX");
			fail("codeSystem should not exist");
		} catch (ProfileException e) {
			assertEquals(e.getMessage(),
					"The input codeSystem parameter cannot be less than 4 characters long");
		}
	}

	/**
	 * Test for invalid codeSys
	 */
	@Test
	public void testKnowsCodesNeg() throws ProfileException {
		assertTrue(!codeStore.knowsCodes("XXX"));
	}

	/**
	 * Test for invalid code
	 */
	@Test
	public void testIsValidCodeNeg() throws ProfileException {
		assertTrue(!codeStore.isValidCode("HL70001", "X"));
	}

}
