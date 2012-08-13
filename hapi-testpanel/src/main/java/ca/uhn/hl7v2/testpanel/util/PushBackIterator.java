package ca.uhn.hl7v2.testpanel.util;

import java.util.Iterator;

public class PushBackIterator<E> implements Iterator<E> {
	private E myPreviousValue = null;
	private E mySavedValue = null;
	private final Iterator<E> myWrappedIterator;
	
	/**
	 * Constructor
	 */
	public PushBackIterator(Iterator<E> theIteratorToWrap) {
		this.myWrappedIterator = theIteratorToWrap;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean hasNext() {
		return mySavedValue != null || myWrappedIterator.hasNext();
	}


	/**
	 * {@inheritDoc}
	 */
	public E next() {
		if (mySavedValue != null) {
			try {
				return myPreviousValue = mySavedValue;
			} finally {
				mySavedValue = null;
			}
		}
		return myPreviousValue = myWrappedIterator.next();
	}


	public E previous() {
		return myPreviousValue;
	}


	public void pushBack() {
		mySavedValue = myPreviousValue;
	}


	/**
	 * {@inheritDoc}
	 */
	public void remove() {
		if (mySavedValue != null) {
			throw new IllegalStateException("Cannot remove when next element has been pushed back");
		}
		myWrappedIterator.remove();
	}
}