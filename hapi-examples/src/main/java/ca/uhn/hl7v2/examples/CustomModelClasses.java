/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uhn.hl7v2.examples;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.examples.custommodel.v25.message.ZDT_A01;
import ca.uhn.hl7v2.examples.custommodel.v25.segment.ZPI;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.v25.message.ADT_A01;
import ca.uhn.hl7v2.parser.CustomModelClassFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.Parser;


/**
 * Example using custom model classes
 */
public class CustomModelClasses {

    public static void main(String[] args) throws HL7Exception {

        // Suppose we need to parse a message that has some local customization
        // or quirk. The most common example is Z-segments in messages, but we
        // could even be talking about completely non conformant structures.

        // For this example, let's imagine an application that has a custom
        // patient segment called ZPI after the PID segment in an ADT^A01 message.
        // This ZPI segment has two fields:
        //   1 - a repeating ST called "Pet Name"
        //   2 - a non repeating NM called "shoe size"

        // Here's an example message
		String messageText = "MSH|^~\\&|IRIS|SANTER|AMB_R|SANTER|200803051508||ADT^A01|263206|P|2.5\r"
				+ "EVN||200803051509||||200803031508\r"
				+ "PID|||5520255^^^PK^PK~ZZZZZZ83M64Z148R^^^CF^CF~ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103^99991231~^^^^TEAM||ZZZ^ZZZ||19830824|F||||||||||||||||||||||N\r"
				+ "ZPI|Fido~Fred|13\r"
				+ "PV1||I|6402DH^^^^^^^^MED. 1 - ONCOLOGIA^^OSPEDALE MAGGIORE DI LODI&LODI|||^^^^^^^^^^OSPEDALE MAGGIORE DI LODI&LODI|13936^TEST^TEST||||||||||5068^TEST2^TEST2||2008003369||||||||||||||||||||||||||200803031508\r"
				+ "PR1|1||1111^Mastoplastica|Protesi|20090224|02|";

        // HAPI will still parse this message fine
		HapiContext context = new DefaultHapiContext();
		Parser parser = context.getPipeParser();
        ADT_A01 message = (ADT_A01) parser.parse(messageText);
        
        // If we want to access the data in the ZPI segment, it's pretty easy
        Segment zpiGenericSegment = (Segment) message.get("ZPI");

        String firstPetName  = zpiGenericSegment.getField(1, 0).encode();
        String secondPetName = zpiGenericSegment.getField(1, 1).encode();
        System.out.println(firstPetName); // Fido
        System.out.println(secondPetName); // Fred

        String shoeSize = zpiGenericSegment.getField(2, 0).encode();
        System.out.println(shoeSize); // 13


        // Now, suppose our message is actually called ZDT^A01, and we plan on
        // using it frequently, so we want to explicitly define a class to
        // handle it. That can be done as well.

        // Here is a segment class we have created (click to view):
        ZPI zpi;

        // Here is a message class we have created (click to view):
        ZDT_A01 zdtA01;

        // These classes are both in the package ca.uhn.hl7v2.examples.custommodel.[version].[type]
        // We associated the HapiContext with a custom model class factory to use it
        ModelClassFactory cmf = new CustomModelClassFactory("ca.uhn.hl7v2.examples.custommodel");
        context.setModelClassFactory(cmf);

        // The resulting message will be an instance of our custom type (this time, MSH-9 says ZDT^A01)
		messageText = "MSH|^~\\&|IRIS|SANTER|AMB_R|SANTER|200803051508||ZDT^A01|263206|P|2.5\r"
				+ "EVN||200803051509||||200803031508\r"
				+ "PID|||5520255^^^PK^PK~ZZZZZZ83M64Z148R^^^CF^CF~ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103^99991231~^^^^TEAM||ZZZ^ZZZ||19830824|F||||||||||||||||||||||N\r"
				+ "ZPI|Fido~Fred|13\r"
				+ "PV1||I|6402DH^^^^^^^^MED. 1 - ONCOLOGIA^^OSPEDALE MAGGIORE DI LODI&LODI|||^^^^^^^^^^OSPEDALE MAGGIORE DI LODI&LODI|13936^TEST^TEST||||||||||5068^TEST2^TEST2||2008003369||||||||||||||||||||||||||200803031508\r"
				+ "PR1|1||1111^Mastoplastica|Protesi|20090224|02|";
        zdtA01 = (ZDT_A01) parser.parse(messageText);

        // Now we have easy access to our new segment and fields
        zpi = zdtA01.getZPI();

        System.out.println(zpi.getPetName()[0].encode()); // Fido
        System.out.println(zpi.getPetName()[1].encode()); // Fred
        System.out.println(zpi.getShoeSize().encode()); // 13

    }

}
