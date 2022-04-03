package ca.uhn.hl7v2.sourcegen;

import ca.uhn.hl7v2.Version;
import com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl;
import com.sun.xml.xsom.XSSchema;
import com.sun.xml.xsom.parser.XSOMParser;
import net.lingala.zip4j.ZipFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.XMLConstants;
import javax.xml.parsers.SAXParserFactory;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public abstract class AbstractXsdGenerator {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractXsdGenerator.class);

    public static final String URN_HL7_ORG_V2XML = "urn:hl7-org:v2xml";
    public static final String PROP_PASSWORD = "xsd.password";

    protected final String templatePackage;
    protected final String targetDirectory;

    public AbstractXsdGenerator(String templatePackage, String targetDirectory) {
        this.templatePackage = templatePackage.replace(".", "/");
        this.targetDirectory = targetDirectory;
    }

    public void parse(Version version, String folder, String file) throws Exception {
        SAXParserFactory factory = new SAXParserFactoryImpl();
        factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        XSOMParser parser = new XSOMParser(factory);

        String xsdFileName = String.format("/%s/%s", version.getVersion(), file);
        File xsdFile = new File(folder, xsdFileName);
        parser.setErrorHandler(new SimpleErrorHandler());
        parser.parse(xsdFile);

        asStream(parser.getResult().iterateSchema())
                .filter(schema -> URN_HL7_ORG_V2XML.equals(schema.getTargetNamespace()))
                .findFirst()
                .ifPresent(schema -> doParse(schema, version));
    }

    protected void writeFile(String source, String dirSuffix, String fileName) {
        try {
            String dirName = String.format("%s/ca/uhn/hl7v2/%s", targetDirectory, dirSuffix);
            File dir = new File(dirName);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            String targetFile = String.format("%s/%s", dirName, fileName);
            LOG.debug("Writing file {}", targetFile);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile, false))) {
                writer.write(source);
                writer.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected <T> Stream<T> asStream(Iterator<T> sourceIterator) {
        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(sourceIterator, Spliterator.ORDERED),
                false);
    }

    protected abstract void doParse(XSSchema schema, Version version);

}
