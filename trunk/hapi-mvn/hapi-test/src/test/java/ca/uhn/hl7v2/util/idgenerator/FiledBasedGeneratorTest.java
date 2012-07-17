package ca.uhn.hl7v2.util.idgenerator;


public class FiledBasedGeneratorTest extends AbstractContinuousGeneratorTest<FileBasedGenerator> {

	@Override
	protected FileBasedGenerator getGenerator() {
		return new FileBasedGenerator();
	}


}
