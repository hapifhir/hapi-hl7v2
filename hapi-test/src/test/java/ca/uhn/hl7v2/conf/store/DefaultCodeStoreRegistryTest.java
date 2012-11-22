package ca.uhn.hl7v2.conf.store;

import static org.junit.Assert.assertTrue;

import java.net.URL;

import org.junit.Test;

/**
 * JUnit test cases for DefaultCodeStoreRegistryTest
 *  
 * @author Christian Ohr
 */
public class DefaultCodeStoreRegistryTest  {
    
    @Test
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
        
        CodeStoreRegistry registry = new DefaultCodeStoreRegistry();
        
        registry.addCodeStore(cs1, "foo"); //for foo profile
        registry.addCodeStore(cs2, ".*test.*"); 
        registry.addCodeStore(cs3);  //for all profiles
        
        CodeStore codeStore = registry.getCodeStore("foo", "HL70001");
        assertTrue(codeStore.knowsCodes("HL70396"));
        
        assertTrue( ! registry.getCodeStore("xxxtestxxx", "HL70001").knowsCodes("HL70061") );
        assertTrue( ! registry.getCodeStore("xxx", "HL70061").knowsCodes("HL70001"));
        assertTrue(null == registry.getCodeStore("xxx", "xxx"));
        
    }
}
