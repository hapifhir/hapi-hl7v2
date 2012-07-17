package ca.uhn.hl7v2.util.idgenerator;


public class FiledBasedHiLoGeneratorTest extends AbstractContinuousGeneratorTest<FileBasedHiLoGenerator> {

	@Override
	protected FileBasedHiLoGenerator getGenerator() {
		return new FileBasedHiLoGenerator(100);
	}


}
