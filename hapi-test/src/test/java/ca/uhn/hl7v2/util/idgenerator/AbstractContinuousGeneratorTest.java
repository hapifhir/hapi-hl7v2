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
	private static final int ITERATIONS = 1000;
	
	@Test
	public void testGenerator() throws IOException {
		T gen = getGenerator();
		gen.reset();
		int oldId = 0;
		oldId = checkContinuousIDs(gen, oldId, ITERATIONS, 1);
		// After restarting, we are still in order
		checkContinuousIDs(gen, oldId, ITERATIONS,1 );
	}

	@Test
	public void testMultiThreadedGenerator() throws IOException,
			InterruptedException, ExecutionException {
		final T gen = getGenerator();
		gen.reset();
		ExecutorService service = Executors.newFixedThreadPool(THREADS);
		Collection<Incrementer> c = new ArrayList<Incrementer>();
		for (int i = 0; i < THREADS; i++) {
			c.add(new Incrementer(gen, ITERATIONS));
		}
		List<Future<Set<Integer>>> results = service.invokeAll(c, 60000,
				TimeUnit.MILLISECONDS);

		// Check that all IDs of all threads are unique
		Set<Integer> allIds = new HashSet<Integer>();
		for (Future<Set<Integer>> future : results) {
			Set<Integer> ids = future.get();
			assertEquals(ITERATIONS, ids.size());
			allIds.addAll(future.get());
		}
		assertEquals(ITERATIONS * THREADS, allIds.size());
	}

	private int checkContinuousIDs(T gen, int oldId, int max, int increment)
			throws IOException {
		for (int i = 0; i < max; i++) {
			int newId = Integer.parseInt(gen.getID());
			if (oldId > 0)
				assertEquals("Non consecutive IDs " + oldId, increment, newId - oldId);
			oldId = newId;
		}
		return oldId;
	}

	private Set<Integer> checkIncreasingIDs(T gen, int oldId, int max)
			throws IOException {
		Set<Integer> ids = new HashSet<Integer>();
		for (int i = 0; i < max; i++) {
			int newId = Integer.parseInt(gen.getID());
			if (oldId > 0)
				assertTrue("Non increasing IDs " + oldId, newId > oldId);
			oldId = newId;
			assertTrue(ids.add(newId));
		}
		return ids;
	}

	class Incrementer implements Callable<Set<Integer>> {

		private T gen;
		private int iterations;

		public Incrementer(T gen, int iterations) {
			this.gen = gen;
			this.iterations = iterations;
		}

		public Set<Integer> call() throws Exception {
			return checkIncreasingIDs(gen, 0, iterations);
		}

	};

	abstract protected T getGenerator();
	
	
}
