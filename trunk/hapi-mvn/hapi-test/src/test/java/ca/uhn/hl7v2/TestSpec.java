package ca.uhn.hl7v2;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import org.junit.rules.ErrorCollector;
import static org.junit.Assert.assertEquals;

/**
 * Abstract class of a test specification, that transforms an input into an
 * output (or throws an exception) and complains if the result is unexpected.
 * <p>
 * Implementations of this class must be defined as "public static" and should
 * be used together with a {@link TestSpecBuilder} to execute a set of different
 * test cases.
 * 
 * @param <I>
 * @param <O>
 * 
 * @see TestSpecBuilder
 */
public abstract class TestSpec<I, O> {

    private I input;
    private O expected;
    private Class<? extends Throwable> expectedException;

    public TestSpec() {
    }

    void setInput(I input) {
        this.input = input;
    }

    void setExpected(O expected) {
        this.expected = expected;
    }

    void setExpectedException(Class<? extends Throwable> expectedException) {
        this.expectedException = expectedException;
    }

    public static <I, O> void assertSpecs(IndexedErrorCollector collector, List<TestSpec<I, O>> specs) {
        int i = 0;
        for (TestSpec spec : specs) {
            spec.assertSpec(collector, i++);
        }
    }

    public final void assertSpec(IndexedErrorCollector collector, int i) {
        try {
            collector.checkThat(i, transform(input), equalTo(expectedException != null ? expectedException : expected));
        } catch (Throwable e) {
            collector.checkThat(i, e, instanceOf(expectedException != null ? expectedException : expected.getClass()));
        }
    }

    protected abstract O transform(I input) throws Throwable;

}
