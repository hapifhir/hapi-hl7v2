/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "DefaultExecutorService.java".  Description: 
"Provides a global cached thread pool if Connections and Servers are not
initialized with their specific {@link ExecutorService} instances" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the "GPL"), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

 */
package ca.uhn.hl7v2.concurrent;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Provides a global cached thread pool if Connections and Servers are not
 * initialized with their specific {@link ExecutorService} instances.
 */
public class DefaultExecutorService {

	static ExecutorService defaultExecutorService;

	public static <V> CompletionService<V> completionService(ExecutorService executor) {
		return new ExecutorCompletionService<V>(executor);
	}

	public static synchronized ExecutorService getDefaultService() {
		if (defaultExecutorService == null || defaultExecutorService.isShutdown()) {
			defaultExecutorService = Executors.newCachedThreadPool(new MyThreadFactory());
		}
		return defaultExecutorService;
	}

	/**
	 * @return true if the service is not null and was created by this class
	 */
	public static boolean isDefaultService(ExecutorService service) {
		return service != null && service == defaultExecutorService;
	}

	/**
	 * @see {@link ExecutorService#shutdown()}
	 */
	public static void shutdown() {
		defaultExecutorService.shutdown();
	}

	/**
	 * @see {@link ExecutorService#shutdownNow()}
	 */
	public static void shutdownNow() {
		defaultExecutorService.shutdownNow();
	}

	private static class MyThreadFactory implements ThreadFactory {

		private ThreadGroup group;
		private AtomicInteger threadNum;

		public MyThreadFactory() {
			group = Thread.currentThread().getThreadGroup();
			threadNum = new AtomicInteger(1);
		}

		public Thread newThread(Runnable theR) {
			String name = "hapi-worker-" + threadNum.getAndIncrement();
			Thread t = new Thread(group, theR, name, 0);
			if (t.isDaemon()) {
				t.setDaemon(false);
			}
			if (t.getPriority() != Thread.NORM_PRIORITY) {
				t.setPriority(Thread.NORM_PRIORITY);
			}
			return t;
		}

	}

}
