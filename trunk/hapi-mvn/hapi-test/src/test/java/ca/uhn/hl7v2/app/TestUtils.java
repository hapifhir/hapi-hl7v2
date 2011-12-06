package ca.uhn.hl7v2.app;

import java.util.ArrayList;
import java.util.List;

class TestUtils {
	
	public static <T> List<T> fill(T element, int amount) {
		List<T> list = new ArrayList<T>();
		for (int i = 0; i < amount; i++) {
			list.add(element);
		}
		return list;
	}

}
