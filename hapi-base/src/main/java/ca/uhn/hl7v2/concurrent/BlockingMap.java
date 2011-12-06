package ca.uhn.hl7v2.concurrent;

import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public interface BlockingMap<K, V> extends Map<K, V> {

	/**
	 * Adds an entry only if there's already a consumer waiting for the value.
	 * 
	 * @param key
	 * @param value
	 * @return true if entry was added and a consumer is already waiting for the
	 *         value, false otherwise
	 */
	boolean give(K key, V value);

	/**
	 * Waits for an entry for the given key and returns the associated value.
	 * May return null if the producer withdraws the entry without providing a
	 * value.
	 * 
	 * @param key
	 * @return the value of the entry
	 * @throws InterruptedException
	 */
	V take(K key) throws InterruptedException;
	
	/**
	 * Waits for an entry in a background thread.
	 * 
	 * @param key
	 * @return Future the result
	 * @throws InterruptedException
	 */
	Future<V> asyncTake(K key) throws InterruptedException;

	/**
	 * Waits for the specified amount of time for an entry with the given key
	 * and returns the associated value. Returns null if no value was provided
	 * within the poll time. May return null if the producer withdraws the entry
	 * without providing a value.
	 * 
	 * @param key
	 * @param timeout
	 * @param unit
	 * @return
	 * @throws InterruptedException
	 */
	V poll(K key, long timeout, TimeUnit unit) throws InterruptedException;

	/**
	 * Polls for an entry in a background thread.
	 * 
	 * @param key
	 * @return Future the result
	 * @throws InterruptedException
	 */
	Future<V> asyncPoll(K key, long timeout, TimeUnit unit) throws InterruptedException;
}

