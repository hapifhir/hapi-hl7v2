package ca.uhn.hl7v2.concurrent;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Default Implementation of a {@link BlockingMap}.
 * <p>
 * Note: While it is not actively prevented that more then one thread waits for
 * an entry, it is not guaranteed that all waiting threads will receive the
 * entry once it became available. Other implementations may choose to count the
 * waiting threads and/or to remove an available value after a grace period.
 * 
 * @param <K>
 * @param <V>
 */
public class BlockingHashMap<K, V> implements BlockingMap<K, V> {

	private final ConcurrentMap<K, V> map = new ConcurrentHashMap<K, V>();
	private final ConcurrentMap<K, CountDownLatch> latches = new ConcurrentHashMap<K, CountDownLatch>();
	private final ExecutorService executor;
	
	public BlockingHashMap() {
		this(Executors.newCachedThreadPool());
	}
	
	public BlockingHashMap(ExecutorService executor) {
		super();
		this.executor = executor;
	}

	/**
	 * Returns the keys of available entries
	 * 
	 * @see java.util.Map#keySet()
	 */
	public Set<K> keySet() {
		return map.keySet();
	}

	/**
	 * Returns an available entry without removing it from the map
	 * 
	 * @see java.util.Map#get(java.lang.Object)
	 */
	public V get(Object key) {
		return map.get(key);
	}

	/**
	 * Returns <code>true</code> if an entry with the given key is available
	 * 
	 * @see java.util.Map#containsKey(java.lang.Object)
	 */
	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	/**
	 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
	 */
	synchronized public V put(K key, V value) {
		V result = map.put(key, value);
		latchFor(key).countDown();
		return result;
	}

	/**
	 * @see ca.uhn.hl7v2.concurrent.BlockingMap#give(java.lang.Object,
	 *      java.lang.Object)
	 */
	synchronized public boolean give(K key, V value) {
		if (!latches.containsKey(key)) {
			return false;
		}
		put(key, value);
		return true;
	}

	public V take(K key) throws InterruptedException {
		latchFor(key).await();
		latches.remove(key);
		return map.remove(key); // likely to fail there are n > 1 consumers
	}
	

	public Future<V> asyncTake(final K key) throws InterruptedException {
		latchFor(key);
		return executor.submit(new Callable<V>() {

			public V call() throws Exception {
				return take(key);
			}
		});
	}

	public V poll(K key, long timeout, TimeUnit unit)
			throws InterruptedException {
		if (latchFor(key).await(timeout, unit)) {
			latches.remove(key);
			return map.remove(key);
		}
		return null;
	}
	
	public Future<V> asyncPoll(final K key, final long timeout, final TimeUnit unit) {
		latchFor(key);
		return executor.submit(new Callable<V>() {

			public V call() throws Exception {
				return poll(key, timeout, unit);
			}
		});		
	}
	

	/**
	 * Returns true if no entry is available for consumers
	 * 
	 * @see java.util.Map#isEmpty()
	 */
	public boolean isEmpty() {
		return map.isEmpty();
	}

	/**
	 * Returns the number of available values
	 * 
	 * @see java.util.Map#size()
	 */
	public int size() {
		return map.size();
	}

	/**
	 * Removes an entry, regardless whether a value has been set or not. Waiting
	 * consumers will receive a null value.
	 * 
	 * @see java.util.Map#remove(java.lang.Object)
	 */
	synchronized public V remove(Object key) {
		V result = map.remove(key);
		CountDownLatch latch = latches.remove(key);
		if (latch != null)
			latch.countDown();
		return result;
	}

	/**
	 * Clears all existing entries. Waiting consumers will receive a null value
	 * for each removed entry.
	 * 
	 * @see java.util.Map#clear()
	 */
	public void clear() {
		for (K key : latches.keySet()) {
			remove(key);
		}
	}

	public Collection<V> values() {
		return map.values();
	}

	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return map.entrySet();
	}

	public void putAll(Map<? extends K, ? extends V> t) {
		for (Entry<? extends K, ? extends V> entry : t.entrySet()) {
			put(entry.getKey(), entry.getValue());
		}
	}

	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}

	private synchronized CountDownLatch latchFor(K key) {
		CountDownLatch latch = latches.get(key);
		if (latch == null) {
			latch = new CountDownLatch(1);
			latches.put(key, latch);
		}
		return latch;
	}

}
