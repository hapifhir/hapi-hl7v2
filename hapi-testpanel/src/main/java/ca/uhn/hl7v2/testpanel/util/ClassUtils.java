/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is ""  Description:
 * ""
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2001.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  "GPL"), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 */
package ca.uhn.hl7v2.testpanel.util;

import java.lang.reflect.InvocationTargetException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.validation.ValidationContext;

public class ClassUtils {

	private static final Logger ourLog = LoggerFactory.getLogger(ClassUtils.class);
	
	public static <T> T instantiateOrReturnNull(Class<? extends T> theClass) {
		try {
			return theClass.getConstructor().newInstance();
		} catch (IllegalArgumentException e) {
			ourLog.warn("Could not instantiate {}: {}", theClass.getName(), e.getMessage());
			return null;
		} catch (SecurityException e) {
			ourLog.warn("Could not instantiate {}: {}", theClass.getName(), e.getMessage());
			return null;
		} catch (InstantiationException e) {
			ourLog.warn("Could not instantiate {}: {}", theClass.getName(), e.getMessage());
			return null;
		} catch (IllegalAccessException e) {
			ourLog.warn("Could not instantiate {}: {}", theClass.getName(), e.getMessage());
			return null;
		} catch (InvocationTargetException e) {
			ourLog.warn("Could not instantiate {}: {}", theClass.getName(), e.getMessage());
			return null;
		} catch (NoSuchMethodException e) {
			ourLog.warn("Could not instantiate {}: {}", theClass.getName(), e.getMessage());
			return null;
		}
	}

	public static <T> T instantiateOrReturnNull(String theClassName, Class<? extends T> theSuperclass) {
		try {
			
			@SuppressWarnings("unchecked")
			Class<? extends T> clazz = (Class<? extends T>) Class.forName(theClassName);
			
			if (!theSuperclass.isAssignableFrom(clazz)) {
				ourLog.warn("Could not instantiate {}: {}", theClassName, "Not a subclass of " + theSuperclass.getName());
				return null;
			}
			
			return instantiateOrReturnNull(clazz);
			
		} catch (ClassNotFoundException e) {
			return null;
		}
	}

	
}
