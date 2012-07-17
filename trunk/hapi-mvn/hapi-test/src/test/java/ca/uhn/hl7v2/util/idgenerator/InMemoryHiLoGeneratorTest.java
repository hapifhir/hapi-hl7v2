package ca.uhn.hl7v2.util.idgenerator;


public class InMemoryHiLoGeneratorTest extends AbstractContinuousGeneratorTest<HiLoGenerator>{

	@Override
	protected HiLoGenerator getGenerator() {
		return new DelegatingHiLoGenerator(
				new InMemoryIDGenerator(100));
	};
}
