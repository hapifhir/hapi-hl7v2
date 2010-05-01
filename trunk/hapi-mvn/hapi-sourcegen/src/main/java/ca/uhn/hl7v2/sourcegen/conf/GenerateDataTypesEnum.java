package ca.uhn.hl7v2.sourcegen.conf;

/**
 * Enum class to specify whether custom data type classes should be generated
 */
public enum GenerateDataTypesEnum {

    /** No data types should be generated */
    NONE,
    
    /** A single instance of each data type will be generated */
    SINGLE,

    /** Individual datatypes should be made for each spot they are used */
    ALL
    
}
