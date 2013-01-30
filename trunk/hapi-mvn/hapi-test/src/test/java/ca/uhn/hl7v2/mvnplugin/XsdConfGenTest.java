package ca.uhn.hl7v2.mvnplugin;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Date;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.commons.lang.Validate;
import org.junit.Test;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Structure;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.v25.datatype.ST;
import ca.uhn.hl7v2.model.v25.datatype.TS;
import ca.uhn.hl7v2.model.v25.message.ADT_A01;
import ca.uhn.hl7v2.parser.DefaultXMLParser;
import ca.uhn.hl7v2.validation.impl.ValidationContextImpl;

public class XsdConfGenTest {

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(XsdConfGenTest.class);

	@Test
	public void testGeneratedXsd() throws SAXException, IOException, HL7Exception {

		InputStream xsdInputStream = XsdConfGenMojo.class.getResourceAsStream("/XSDGEN.xsd");
		Validate.notNull(xsdInputStream);

		Source xsdSource = new StreamSource(xsdInputStream);
		Validate.notNull(xsdSource);

		// InputStream xsdXsdInputStream =
		// XsdConfGenMojo.class.getResourceAsStream("/XMLSchema.xsd");
		// Validate.notNull(xsdXsdInputStream);
		//
		// StreamSource xsdXsdSource = new StreamSource(xsdXsdInputStream);
		// Validate.notNull(xsdXsdSource);

		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(xsdSource);

		Validator validator = schema.newValidator();

		DefaultHapiContext ctx = new DefaultHapiContext(new ValidationContextImpl());
		
		ADT_A01 a01 = new ADT_A01();
		a01.initQuickstart("ADT", "A01", "T");
		a01.setParser(ctx.getXMLParser());

		try {
			validator.validate(new StreamSource(new StringReader(a01.encode())));
			fail();
		} catch (SAXParseException e) {
			// expected
		}
		
		populateFully(a01);
		ourLog.info("Message:\n{}", ctx.getPipeParser().encode(a01).replace('\r', '\n'));

		validator.validate(new StreamSource(new StringReader(a01.encode())));

	}

	private void populateFully(Group theA01) throws HL7Exception {
		for (String nextName : theA01.getNames()) {
			if (nextName.equals("MSH")) {
				continue;
			}
			
			Structure nextStruct = theA01.get(nextName);
			if (nextStruct instanceof Segment) {
				Segment seg = (Segment)nextStruct;
				for (int i = 1; i <= seg.numFields(); i++ ) {
					populateFully(seg.getField(i, 0));
				}
			} else {
				populateFully((Group) nextStruct);
			}
		}
	}

	private void populateFully(Type theField) throws DataTypeException {
		if (theField instanceof ST) {
			((ST) theField).setValue("A");
		}
		if (theField instanceof TS) {
			((TS) theField).getTs1_Time().setValue(new Date());
		}
	}

}
