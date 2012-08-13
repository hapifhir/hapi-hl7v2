package ca.uhn.hl7v2.testpanel.util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class CollectionUtils {

	public static <T> List<T> enumerationToList(Enumeration<T> theEnumeration) {
		ArrayList<T> retVal = new ArrayList<T>();
		while (theEnumeration.hasMoreElements()) {
			retVal.add(theEnumeration.nextElement());
		}
		return retVal;
	}

}
