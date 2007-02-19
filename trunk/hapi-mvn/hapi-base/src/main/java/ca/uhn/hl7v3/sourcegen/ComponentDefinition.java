package ca.uhn.hl7v3.sourcegen;

/**
 * Contains information about a RIM data type component, for the purpose of generating source 
 * code for a RIM data type.  
 * @author Bryan Tripp
 */
public class ComponentDefinition {

    private String name;
    private String dataType;
    private String description;

    /** Creates a new instance of ComponentDefinition */
    public ComponentDefinition() {
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    
    public void setDataType(String dataType) {
        if (DataTypeDefinition.isInstance(dataType)) {
            this.dataType = DataTypeDefinition.mapInstanceName(dataType);
        } else {
            this.dataType = dataType;
        }
    }
    public String getDataType() {
        return this.dataType;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }

}
