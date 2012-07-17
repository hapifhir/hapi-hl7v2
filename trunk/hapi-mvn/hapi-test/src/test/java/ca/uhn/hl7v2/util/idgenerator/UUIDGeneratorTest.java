package ca.uhn.hl7v2.util.idgenerator;


public class UUIDGeneratorTest extends AbstractNonContinuousGeneratorTest<UUIDGenerator> {

	@Override
	protected UUIDGenerator getGenerator() {
		return new UUIDGenerator();
	}


}
