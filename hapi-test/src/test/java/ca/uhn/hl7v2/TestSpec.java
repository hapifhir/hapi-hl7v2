package ca.uhn.hl7v2;

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
    private Object result;
    private Class<? extends Throwable> resultException;

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

    public I getInput() {
        return input;
    }

    public O getExpected() {
        return expected;
    }

    public Class<? extends Throwable> getExpectedException() {
        return expectedException;
    }

    public Object getResult() {
        return result;
    }

    public final void assertSpec() throws Throwable {
        try {
            result = transform(input);
            assertExpectedResult();
        } catch (AssertionError ae) {
            throw new RuntimeException("For input <" + String.valueOf(input) + "> "
                    + ae.getMessage(), ae);
        } catch (Throwable e) {
            resultException = e.getClass();
            try {
                assertExpectedFailure();
            } catch (AssertionError ae) {
                throw new RuntimeException("For input <" + String.valueOf(input) + "> "
                        + ae.getMessage(), ae);
            }
        }
    }

    public Class<? extends Throwable> getResultException() {
        return resultException;
    }

    protected void assertExpectedResult() {
        assertEquals(expectedException != null ? expectedException : expected, result);
    }

    protected void assertExpectedFailure() {
        assertEquals(expectedException != null ? expectedException : expected, resultException);
    }

    protected abstract O transform(I input) throws Throwable;

}
