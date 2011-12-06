package ca.uhn.hl7v2.concurrent;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BlockingHashMapTest {

	private static ExecutorService executorService;
	private BlockingMap<String, Object> map;
	private static final String KEY = "KEY";
	
	@BeforeClass
	public static void setupBeforeClass() {
		executorService = DefaultExecutorService.getDefaultService();
	}
	
	@AfterClass
	public static void teardownAfterClass() {
		executorService.shutdown();
	}
	
	@Before
	public void setup() {
		map = new BlockingHashMap<String, Object>(executorService);
	}
	
	// Single and sequential producer/consumer
	
	@Test
	public void testTakeBeforePut() throws Exception {
		Object produced = new Object();
		Future<Object> future = map.asyncTake(KEY);
		Thread.sleep(100); // Make sure that thread listens
		assertFalse(map.containsKey(KEY));
		map.put(KEY, produced);
		Object consumed = future.get();
		assertEquals(produced, consumed);
		assertFalse(map.containsKey(KEY));
		assertTrue(map.isEmpty());
	}
	
	@Test
	public void testTakeAfterPut() throws Exception {
		Object produced = new Object();
		map.put(KEY, produced);
		assertEquals(produced, map.get(KEY));
		assertTrue(map.containsKey(KEY));
		Object consumed = map.asyncTake(KEY).get();
		assertEquals(produced, consumed);
		assertFalse(map.containsKey(KEY));
		assertTrue(map.isEmpty());
	}	
	
	@Test
	public void testPollBeforePut() throws Exception {
		Object produced = new Object();
		Future<Object> future = map.asyncPoll(KEY, 1000, TimeUnit.MILLISECONDS);
		Thread.sleep(500);
		assertFalse(map.containsKey(KEY));
		map.put(KEY, produced);
		Object consumed = future.get();
		assertEquals(produced, consumed);
		assertFalse(map.containsKey(KEY));
		assertTrue(map.isEmpty());
	}
	
	@Test
	public void testPollAfterPut() throws Exception {
		Object produced = new Object();
		assertFalse(map.containsKey(KEY));
		map.put(KEY, produced);
		assertTrue(map.containsKey(KEY));
		assertEquals(produced, map.get(KEY));
		Object consumed = map.asyncPoll(KEY, 1000, TimeUnit.MILLISECONDS).get();
		assertEquals(produced, consumed);
		assertFalse(map.containsKey(KEY));
		assertTrue(map.isEmpty());
	}	
	
	@Test
	public void testPollBeforePutTimesOut() throws Exception {
		Object produced = new Object();
		Future<Object> future = map.asyncPoll(KEY, 1000, TimeUnit.MILLISECONDS);
		Thread.sleep(1500);
		assertFalse(map.containsKey(KEY));
		map.put(KEY, produced);
		Object consumed = future.get();
		assertNull(consumed);
		assertTrue(map.containsKey(KEY));
		assertTrue(map.containsValue(produced));
		assertEquals(1, map.size());
		assertFalse(map.isEmpty());
	}	
	
	@Test
	public void testTakeBeforeGive() throws Exception {
		Object produced = new Object();
		Future<Object> future = map.asyncTake(KEY);
		Thread.sleep(100); // Make sure that thread listens
		assertTrue(map.give(KEY, produced));
		Object consumed = future.get();
		assertEquals(produced, consumed);
		assertFalse(map.containsKey(KEY));
	}
	
	@Test
	public void testGiveWithoutConsumer() throws Exception {
		Object produced = new Object();
		assertFalse(map.give(KEY, produced));
	}	
	
	@Test
	public void testRemoveAfterTake() throws Exception {
		Future<Object> future = map.asyncTake(KEY);
		Thread.sleep(100); // Make sure that thread listens
		assertNull(map.remove(KEY));
		Object consumed = future.get();
		assertNull(consumed);
		assertFalse(map.containsKey(KEY));
	}	
	
	@Test
	public void testClearAfterTake() throws Exception {
		Future<Object> future = map.asyncTake(KEY);
		Thread.sleep(100); // Make sure that thread listens
		map.clear();
		Object consumed = future.get();
		assertNull(consumed);
		assertFalse(map.containsKey(KEY));
	}
	
	// Parallel producer/consumer
}
