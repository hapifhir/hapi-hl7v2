package ca.uhn.hl7v2.examples;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.util.Hl7InputStreamMessageIterator;
import ca.uhn.hl7v2.util.Hl7InputStreamMessageStringIterator;

public class ReadMessagesFromFile {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws FileNotFoundException {

		/*
		 * This example shows how to read a series of messages from a file
		 * containing a number of HL7 messages. Assume you have a text file
		 * containing a number of messages.
		 */
		
		// Open an InputStream to read from the file
		File file = new File("hl7_messages.txt");
		InputStream is = new FileInputStream(file);
		
		// It's generally a good idea to buffer file IO
		is = new BufferedInputStream(is);
		
		// The following class is a HAPI utility that will iterate over
		// the messages which appear over an InputStream
		Hl7InputStreamMessageIterator iter = new Hl7InputStreamMessageIterator(is);
		
		while (iter.hasNext()) {
			
			Message next = iter.next();
			
			// Do something with the message
			
		}
		
		/*
		 * If you don't want the message parsed, you can also just
		 * read them in as strings.
		 */
		
		file = new File("hl7_messages.txt");
		is = new FileInputStream(file);
		is = new BufferedInputStream(is);
		Hl7InputStreamMessageStringIterator iter2 = new Hl7InputStreamMessageStringIterator(is); 
		
		while (iter2.hasNext()) {
			
			String next = iter2.next();
			
			// Do something with the message
			
		}
		
	}

}
