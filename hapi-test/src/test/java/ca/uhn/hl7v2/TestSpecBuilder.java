package ca.uhn.hl7v2;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

/**
 * Builder and executor for {@link TestSpec}s.
 *
 * @param <I>
 * @param <O>
 */
public class TestSpecBuilder<I, O> {

    private List<TestSpec<I, O>> specs = new ArrayList<TestSpec<I,O>>();
    private Class<? extends TestSpec<I, O>> resultClass;
    
    /**
     * Creates a builder instance
     * 
     * @param resultClass
     * @return a builder instance that builds TestSpec instances of the given type
     */
    public static <I, O> TestSpecBuilder<I, O> buildSpecs(Class<? extends TestSpec<I, O>> resultClass) {
        return new TestSpecBuilder<I, O>(resultClass);
        
    }
    private TestSpecBuilder(Class<? extends TestSpec<I, O>> resultClass) {
        this.resultClass = resultClass;
    }
    
    private TestSpecBuilder<I, O> add(TestSpec<I, O> spec) {
        specs.add(spec);
        return this;
    }

    /**
     * Adds a new test with regular result to the list of tests to be executed
     * @param input
     * @param expected
     * @return this builder to add more tests
     */
    public TestSpecBuilder<I, O> add(I input, O expected) {
        TestSpec<I, O> spec = instance(); 
        spec.setInput(input);
        spec.setExpected(expected);
        return add(spec);
    }

    /**
     * Adds a new test with exceptional result to the list of tests to be executed
     * @param input
     * @param expected
     * @return this builder to add more tests
     */
    public TestSpecBuilder<I, O> add(I input, Class<? extends Throwable> expected) {
        TestSpec<I, O> spec = instance(); 
        spec.setInput(input);
        spec.setExpectedException(expected);
        return add(spec);           
    }

    private TestSpec<I, O> instance() {
        try {
            return resultClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * 
     */
    public void executeTests() {
        StringBuilder builder = new StringBuilder();
        int failedTests = 0;
        for (int i = 0; i < specs.size(); i++) {
            try {
                specs.get(i).assertSpec();
            } catch (Throwable t) {
                builder.append("Test " + i + ": ").append(t.getMessage()).append("\n");
                failedTests++;
            }
        }
        if (failedTests > 0) {
            fail(failedTests + " test(s) failed: \n" + builder.toString());
        }
    }
}