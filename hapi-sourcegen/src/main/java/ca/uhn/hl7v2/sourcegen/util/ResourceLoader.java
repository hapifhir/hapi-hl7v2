package ca.uhn.hl7v2.sourcegen.util;

import java.io.InputStream;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

public class ResourceLoader extends ClasspathResourceLoader {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader#
	 * getResourceStream(java.lang.String)
	 */
	@Override
	public InputStream getResourceStream(String theArg0) throws ResourceNotFoundException {
		System.out.println("** Trying to load: " + theArg0);
		
		InputStream resourceStream = ResourceLoader.class.getResourceAsStream(theArg0);
		if (resourceStream == null) {
			resourceStream = ResourceLoader.class.getResourceAsStream("/" + theArg0);
		}
		if (resourceStream == null) {
			throw new ResourceNotFoundException("Can not find: " + theArg0);
		}

		return resourceStream;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.velocity.runtime.resource.loader.ResourceLoader#resourceExists
	 * (java.lang.String)
	 */
	@Override
	public boolean resourceExists(String theArg0) {
		System.out.println("** Checking Exists: " + theArg0);
		boolean resourceExists = super.resourceExists(theArg0);
		System.out.println("** Exists: " + resourceExists);
		return resourceExists;
	}
	
	public static void main(String[] args) {
		new ResourceLoader().getResourceStream("ca/uhn/hl7v2/sourcegen/templates/group.vsm");
	}

}
