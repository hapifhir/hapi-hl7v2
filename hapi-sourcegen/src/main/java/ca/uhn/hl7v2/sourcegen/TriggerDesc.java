package ca.uhn.hl7v2.sourcegen;

public class TriggerDesc implements Comparable<TriggerDesc> {

    private String description;
    private String returnStructure;
    private String structure;
    private String type;
    private String version;

    public String getDescription() {
        return description;
    }

    public String getReturnStructure() {
        return returnStructure;
    }

    public String getStructure() {
        return structure;
    }

    public String getType() {
        return type;
    }

    public String getVersion() {
        return version;
    }

    public void setDescription(String theDescription) {
        description = theDescription;
    }

    public void setReturnStructure(String theReturnStructure) {
        returnStructure = theReturnStructure;
    }

    public void setStructure(String theStructure) {
        structure = theStructure;
    }

    public void setType(String theType) {
        type = theType;
    }

    public void setVersion(String theVersion) {
        version = theVersion;
    }

    /**
     * {@inheritDoc}}
     */
    public int compareTo(TriggerDesc theO) {
        return type.compareTo(theO.type);
    }

}
