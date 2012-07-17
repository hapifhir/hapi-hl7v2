package ca.uhn.hl7v2.util.idgenerator;


public class NanoTimeGeneratorTest extends AbstractNonContinuousGeneratorTest<NanoTimeGenerator> {

	@Override
	protected NanoTimeGenerator getGenerator() {
		return new NanoTimeGenerator();
	}


}
