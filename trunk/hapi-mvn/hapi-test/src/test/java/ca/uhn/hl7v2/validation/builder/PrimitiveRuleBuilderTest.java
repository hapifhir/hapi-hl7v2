package ca.uhn.hl7v2.validation.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.codehaus.plexus.util.StringUtils;
import org.junit.Before;
import org.junit.Test;

import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.validation.ValidationException;
import ca.uhn.hl7v2.validation.impl.RuleBinding;

public class PrimitiveRuleBuilderTest {

    private static final String X = "some string";
    private static final int SPACE_LENGTH = 13;  // > 0
    
    // don't change constants below
    private static final String SPACES = StringUtils.repeat(" ", SPACE_LENGTH);
    private static final int MAX_LENGTH = X.length() + SPACE_LENGTH;
    private static final String XX = SPACES + X + SPACES;
    private static final int pos = XX.indexOf(X);
    private static final String XX_LEFT = XX.substring(pos);
    private static final String XX_RIGHT = XX.substring(0, pos + X.length());
    private static final String XX_ALL = XX.substring(pos, pos + X.length());
    
    private PrimitiveRuleBuilder b;

    @Before
    public void setUp() throws Exception {
        b = new ValidationRuleBuilder().forVersion(Version.V25).primitive("ST");
    }

    @Test
    public void testIs() {
        assertTrimmedCorrectly(b.is(b.maxLength(MAX_LENGTH)), XX, 1, 1);
    }

    @Test
    public void testLeftTrimPredicate() {
        assertTrimmedCorrectly(b.leftTrim(b.maxLength(MAX_LENGTH)), XX_LEFT, 0, 1);
    }

    @Test
    public void testLeftTrimmed() throws ValidationException {
        assertTrimmedCorrectly(b.leftTrim(), XX_LEFT, 0, 0);
    }

    @Test
    public void testRightTrimPredicate() {
        assertTrimmedCorrectly(b.rightTrim(b.maxLength(MAX_LENGTH)), XX_RIGHT, 0, 1);
    }

    @Test
    public void testRightTrimmed() {
        assertTrimmedCorrectly(b.rightTrim(), XX_RIGHT, 0, 0);
    }

    @Test
    public void testAllTrimPredicate() {
        assertTrimmedCorrectly(b.allTrim(b.maxLength(MAX_LENGTH)), XX_ALL, 0, 1);
    }

    @Test
    public void testAllTrimmed() {
        assertTrimmedCorrectly(b.allTrim(), XX_ALL, 0, 0);
    }

    private static void assertTrimmedCorrectly(PrimitiveRuleBuilder builder, String expectedWhenTrimmed,
            int exceptionExpected1, int exceptionExpected2) {
        RuleBinding<?> binding = builder.getRules().iterator().next();
        PredicatePrimitiveTypeRule r = (PredicatePrimitiveTypeRule) binding.getRule();
        assertEquals(exceptionExpected1, r.apply(XX).length);
        assertEquals(expectedWhenTrimmed, r.correct(XX));
        assertEquals(exceptionExpected2, r.apply(XX + XX).length);
        assertNull(r.correct(null));
        assertEquals("", r.correct(""));
        assertEquals(0, r.apply(null).length);
        assertEquals(0, r.apply("").length);
    }

}
