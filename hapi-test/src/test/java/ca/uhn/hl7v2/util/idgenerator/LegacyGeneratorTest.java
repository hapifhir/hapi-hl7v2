package ca.uhn.hl7v2.util.idgenerator;


public class LegacyGeneratorTest extends AbstractContinuousGeneratorTest<LegacyGenerator>{

	@Override
	protected LegacyGenerator getGenerator() {
		return new LegacyGenerator();
	};
}
