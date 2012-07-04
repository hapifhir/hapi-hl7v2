package ca.uhn.hl7v2.testpanel.api;

public interface IMessageTransformer<T> {

	public T transform(T theInput);
	
}
