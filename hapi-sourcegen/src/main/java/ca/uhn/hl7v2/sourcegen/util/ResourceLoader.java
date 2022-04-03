package ca.uhn.hl7v2.sourcegen.util;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

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
	public Reader getResourceReader(String theArg0, String encoding) throws ResourceNotFoundException {

		InputStream resourceStream = ResourceLoader.class.getResourceAsStream(theArg0);
		if (resourceStream == null) {
			resourceStream = ResourceLoader.class.getResourceAsStream("/" + theArg0);
		}
		if (resourceStream == null) {
			throw new ResourceNotFoundException("Can not find: " + theArg0);
		}

		try {
			return new InputStreamReader(resourceStream, encoding);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
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
		new ResourceLoader().getResourceReader("ca/uhn/hl7v2/sourcegen/templates/group.vsm", "UTF-8");
	}

}
