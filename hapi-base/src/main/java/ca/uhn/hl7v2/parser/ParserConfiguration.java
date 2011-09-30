package ca.uhn.hl7v2.parser;


public class ParserConfiguration {

    private boolean myEncodeEmptySegments = false;

    /**
     * Returns the value returned by {@link #isEncodeEmptySegments()}, default is <code>false</code> 
     * 
     * @see #isEncodeEmptySegments()
     */
	public boolean isEncodeEmptySegments() {
		return myEncodeEmptySegments;
	}


    /**
     * <p>
     * If set to <code>true</code> (default is <code>false</code>), segments will be encoded
     * even if they are empty (i.e. if the corresponding getXXX() method has been called at
     * least once but no content has been added to the segment). Note that this doesn't mean
     * that all segments in the message will automatically be encoded, you will need to
     * call the getXXX method at least once on any segments you wish to have encoded.
     * </p>
     * <p>
     * While empty segments do not generally have any meaning according
     * to HL7, this may be useful when transmitting to systems which rely on segments
     * being received even if they have no content.
     * </p>
     */
	public void setEncodeEmptySegments(boolean theEncodeEmptySegments) {
		myEncodeEmptySegments = theEncodeEmptySegments;
	}
    
	
}
