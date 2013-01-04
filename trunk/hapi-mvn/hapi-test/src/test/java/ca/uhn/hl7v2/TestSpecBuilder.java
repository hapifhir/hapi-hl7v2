package ca.uhn.hl7v2;

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
    private Class<? extends Throwable> defaultException;
    
    /**
     * Creates a builder instance
     * 
     * @param resultClass resulting TestSpec class
     * @return a builder instance that builds TestSpec instances of the given type
     */
    public static <I, O> TestSpecBuilder<I, O> buildSpecs(Class<? extends TestSpec<I, O>> resultClass) {
        return new TestSpecBuilder<I, O>(resultClass, Exception.class);        
    }

    public static <I, O> TestSpecBuilder<I, O> buildSpecs(Class<? extends TestSpec<I, O>> resultClass, Class<? extends Throwable> defaultException) {
        return new TestSpecBuilder<I, O>(resultClass, defaultException);        
    }
    
    private TestSpecBuilder(Class<? extends TestSpec<I, O>> resultClass, Class<? extends Throwable> defaultException) {
        this.resultClass = resultClass;
        this.defaultException = defaultException;
    }
    
    private TestSpecBuilder<I, O> add(TestSpec<I, O> spec) {
        specs.add(spec);
        return this;
    }

    /**
     * Adds a new test with regular result to the list of tests to be executed
     * @param input input data
     * @param expected output data
     * @return this builder to add more tests
     */
    public TestSpecBuilder<I, O> add(I input, O expected) {
        TestSpec<I, O> spec = instance(); 
        spec.setInput(input);
        spec.setExpected(expected);
        return add(spec);
    }
    
    @SuppressWarnings("unchecked")
    public TestSpecBuilder<I, O> accept(I input) {
        return add(input, (O)input);
    }
    
    public TestSpecBuilder<I, O> accept(I... input) {
        for (I i : input) {
            accept(i);
        }
        return this;
    }     

    /**
     * Adds a new test with exceptional result to the list of tests to be executed
     * @param input input data
     * @param expected expected exception
     * @return this builder to add more tests
     */
    public TestSpecBuilder<I, O> add(I input, Class<? extends Throwable> expected) {
        TestSpec<I, O> spec = instance(); 
        spec.setInput(input);
        spec.setExpectedException(expected);
        return add(spec);           
    }
    
    public TestSpecBuilder<I, O> reject(I input) {
        return add(input, defaultException);
    }
    
    public TestSpecBuilder<I, O> reject(I... input) {
        for (I i : input) {
            reject(i);
        }
        return this;
    }    

    private TestSpec<I, O> instance() {
        try {
            return resultClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void executeTests(IndexedErrorCollector collector) {
        TestSpec.assertSpecs(collector, specs);
    }
    
    public static int[] ints(int... ints) {
        return ints;
    }    
}