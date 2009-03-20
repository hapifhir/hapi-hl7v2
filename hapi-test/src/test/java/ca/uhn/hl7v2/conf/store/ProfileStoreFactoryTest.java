package ca.uhn.hl7v2.conf.store;

import java.net.URL;

import junit.framework.*;

/**
 * JUnit test cases for ProfileStoreFactory 
 * @author Bryan Tripp
 */
public class ProfileStoreFactoryTest extends TestCase {
    
    public ProfileStoreFactoryTest(java.lang.String testName) {
        super(testName);
    }
    
    /*public static void main(java.lang.String[] args) {
        junit.textui.TestRunner.run(suite());
    }*/
    
    public static Test suite() {
        TestSuite suite = new TestSuite(ProfileStoreFactoryTest.class);
        return suite;
    }
    
    public void testCodeStoreRegistration() throws Exception {
        URL specURLAll = this.getClass().getClassLoader().getResource(
				"ca/uhn/hl7v2/conf/store/sampleTables.xml");        
		URL specURL1 = this.getClass().getClassLoader().getResource(
				"ca/uhn/hl7v2/conf/store/sampleTable1.xml");        
		URL specURL61 = this.getClass().getClassLoader().getResource(
				"ca/uhn/hl7v2/conf/store/sampleTable61.xml");        
        CodeStore cs1 = new ProfileCodeStore(specURLAll);
        CodeStore cs2 = new ProfileCodeStore(specURL1);
        CodeStore cs3 = new ProfileCodeStore(specURL61);
        
        ProfileStoreFactory.addCodeStore(cs1, "foo"); //for foo profile
        ProfileStoreFactory.addCodeStore(cs2, ".*test.*"); 
        ProfileStoreFactory.addCodeStore(cs3);  //for all profiles
        
        CodeStore codeStore = ProfileStoreFactory.getCodeStore("foo", "HL70001");
        assertTrue(codeStore.knowsCodes("HL70396"));
        
        assertTrue( ! ProfileStoreFactory.getCodeStore("xxxtestxxx", "HL70001").knowsCodes("HL70061") );
        assertTrue( ! ProfileStoreFactory.getCodeStore("xxx", "HL70061").knowsCodes("HL70001"));
        assertTrue(null == ProfileStoreFactory.getCodeStore("xxx", "xxx"));
        
    }
}
