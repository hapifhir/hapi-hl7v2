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

public abstract class AbstractNonContinuousGeneratorTest<T extends IDGenerator> {

	private static final int THREADS = 10;
	private static final int ITERATIONS = 100;

	@Test
	public void testGenerator() throws IOException {
		T gen = getGenerator();
		checkIDs(gen, ITERATIONS);
	}

	@Test
	public void testMultiThreadedGenerator() throws IOException,
			InterruptedException, ExecutionException {
		ExecutorService service = Executors.newFixedThreadPool(THREADS);
		try {
			final T gen = getGenerator();
			Collection<Incrementer> c = new ArrayList<Incrementer>();
			for (int i = 0; i < THREADS; i++) {
				c.add(new Incrementer(gen, ITERATIONS));
			}
			List<Future<Set<String>>> results = service.invokeAll(c, 60000,
					TimeUnit.MILLISECONDS);

			// Check that all IDs of all threads are unique
			Set<String> allIds = new HashSet<String>();
			for (Future<Set<String>> future : results) {
				Set<String> ids = future.get();
				assertEquals(ITERATIONS, ids.size());
				allIds.addAll(future.get());
			}
			assertEquals(ITERATIONS * THREADS, allIds.size());
		} finally {
			service.shutdown();
		}
	}

	private Set<String> checkIDs(T gen, int max) throws IOException {
		Set<String> ids = new HashSet<String>();
		for (int i = 0; i < max; i++) {
			String newId = gen.getID();
			assertTrue(ids.add(newId));
		}
		return ids;
	}

	class Incrementer implements Callable<Set<String>> {

		private T gen;
		private int iterations;

		public Incrementer(T gen, int iterations) {
			this.gen = gen;
			this.iterations = iterations;
		}

		public Set<String> call() throws Exception {
			return checkIDs(gen, iterations);
		}

	};

	abstract protected T getGenerator();
}
