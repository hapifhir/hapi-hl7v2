package ca.uhn.hl7v2.model;

/**
 * An unspecified segment that has an undefined number of fields, each 
 * of which is a Varies.  The primary intended use is to store data from 
 * Z segments.  More precisely, any unknown segment that is encountered during
 * parsing will be handled with this class.  This includes segments that do 
 * not start with Z but nevertheless do not appear in the stated version 
 * of HL7.  Also, this class is not used to handle Z segments that have been 
 * explicitly defined and declared (see Parser.packageList() ).  
 * @author Bryan Tripp
 */
@SuppressWarnings("serial")
public class GenericSegment extends AbstractSegment {
    
    private String name;

    /**
     * Creates a genric segment
     * @param parent parent group
     * @param name name of the segment
     */
    public GenericSegment(Group parent, String name) {
        super(parent, null);
        this.name = name;
    }
    
    /**
     * Returns the name specified at construction time. 
     * @see Structure#getName() 
     */
    public String getName() {
        return this.name;
    }


    /**
     * {@inheritDoc}
     */
	protected Type createNewTypeWithoutReflection(int field) {
		return new Varies(getMessage());
	}
    
}
