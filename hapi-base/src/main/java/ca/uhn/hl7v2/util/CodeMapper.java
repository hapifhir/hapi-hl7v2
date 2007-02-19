package ca.uhn.hl7v2.util;

import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Maps local codes to interface codes and vice versa.  The default implementation
 * of CodeMapper is FileCodeMapper.  An instance of FileCodeMapper can be obtained  
 * by calling <code>CodeMapper.getInstance()</code>.  See FileCodeMapper for instructions
 * on how to set up code map files.  </p>
 * <p>Please note that this class is not intended for the purpose of enumerating valid codes. 
 * If that is what you are looking for please see <code>ca.uhn.hl7v2.TableRepository</code></p>
 * @author Bryan Tripp  
 */
public abstract class CodeMapper {

    private static CodeMapper codeMapper = null;
    
    /**
     * Returns a singleton instance of CodeMapper.  This is currently 
     * a FileCodeMapper by default.  
     */
    public synchronized static CodeMapper getInstance() throws HL7Exception {
        if (codeMapper == null) {
            //create new file code mapper 
            codeMapper = new FileCodeMapper();
        }
        return codeMapper;
    }
    
    /** 
     * A convenience method that returns a local code from an underlying 
     * CodeMapper instance by calling <code>CodeMapper.getInstance().getLocalCode(...)</code>
     */
    public static String getLocal(String interfaceName, int hl7Table, String interfaceCode) throws HL7Exception {
        return CodeMapper.getInstance().getLocalCode(interfaceName, hl7Table, interfaceCode);
    }

    /** 
     * A convenience method that returns an interface code from an underlying 
     * CodeMapper instance by calling <code>CodeMapper.getInstance().getInterfaceCode(...)</code>
     */
    public static String getInt(String interfaceName, int hl7Table, String localCode) throws HL7Exception {
        return CodeMapper.getInstance().getInterfaceCode(interfaceName, hl7Table, localCode);
    }
    
    /**
     * Returns the interface code for the given local code, for use in the context 
     * of the given interface.  
     */
    public abstract String getInterfaceCode(String interfaceName, int hl7Table, String localCode) throws HL7Exception;
     
    /**
     * Returns the local code for the given interface code as it appears in  
     * the given interface.  
     */
    public abstract String getLocalCode(String interfaceName, int hl7Table, String interfaceCode) throws HL7Exception;
    
    /**
     * Determines what happens if no matching code is found during a lookup.  If set to true, 
     * an HL7Exception is thrown if there is no match.  If false, null is returned.  The default
     * is false. 
     */
    public abstract void throwExceptionIfNoMatch(boolean throwException);
    
    /**
     * If values are cached in such a way that they are not guaranteed to be current, a call 
     * to this method refreshes the values.  
     */
    public abstract void refreshCache() throws HL7Exception; 
    
    /* may add these functions later to allow consistent maintenance e.g via a UI ... 
    public abstract String[] getInterfaceNames();
    public abstract void addInterface(String name);
    public abstract void addCodeMap(String interface, int hl7table, String localCode, String interfaceCode);
    */
}
