package ca.uhn.hl7v2.util.idgenerator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public abstract class AbstractContinuousGeneratorTest<T extends IDGenerator.Ordered> {

	private static final int THREADS = 10;
	private static final int ITERATIONS = 100;
	
	@Test
	public void testGenerator() throws IOException {
		T gen = getGenerator();
		gen.reset();
		long oldId = 0;
		oldId = checkContinuousIDs(gen, oldId, ITERATIONS, 1);
		// After restarting, we are still in order
		checkContinuousIDs(gen, oldId, ITERATIONS,1 );
	}

	@Test
	public void testMultiThreadedGenerator() throws
			InterruptedException, ExecutionException {
		final T gen = getGenerator();
		gen.reset();
		ExecutorService service = Executors.newFixedThreadPool(THREADS);
		Collection<Incrementer> c = new ArrayList<>();
		for (int i = 0; i < THREADS; i++) {
			c.add(new Incrementer(gen, ITERATIONS));
		}
		List<Future<Set<Long>>> results = service.invokeAll(c, 60000,
				TimeUnit.MILLISECONDS);

		// Check that all IDs of all threads are unique
		Set<Long> allIds = new HashSet<>();
		for (Future<Set<Long>> future : results) {
			Set<Long> ids = future.get();
			assertEquals(ITERATIONS, ids.size());
			allIds.addAll(future.get());
		}
		assertEquals(ITERATIONS * THREADS, allIds.size());
	}

	private long checkContinuousIDs(T gen, long oldId, int max, long increment)
			throws IOException {
		for (int i = 0; i < max; i++) {
			long newId = Long.parseLong(gen.getID());
			if (oldId > 0)
				assertEquals("Non consecutive IDs " + oldId, increment, newId - oldId);
			oldId = newId;
		}
		return oldId;
	}

	private Set<Long> checkIncreasingIDs(T gen, long oldId, int max)
			throws IOException {
		Set<Long> ids = new HashSet<>();
		for (int i = 0; i < max; i++) {
            long newId = Long.parseLong(gen.getID());
			if (oldId > 0)
				assertTrue("Non increasing IDs " + oldId, newId > oldId);
			oldId = newId;
			assertTrue(ids.add(newId));
		}
		return ids;
	}

	class Incrementer implements Callable<Set<Long>> {

		private final T gen;
		private final int iterations;

		public Incrementer(T gen, int iterations) {
			this.gen = gen;
			this.iterations = iterations;
		}

		public Set<Long> call() throws Exception {
			return checkIncreasingIDs(gen, 0, iterations);
		}

	}

    abstract protected T getGenerator();
	
	
}
