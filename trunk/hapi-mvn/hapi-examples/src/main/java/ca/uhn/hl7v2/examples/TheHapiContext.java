/*
 The contents of this file are subject to the Mozilla Public License Version 1.1
 (the "License"); you may not use this file except in compliance with the License.
 You may obtain a copy of the License at http://www.mozilla.org/MPL/
 Software distributed under the License is distributed on an "AS IS" basis,
 WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 specific language governing rights and limitations under the License.

 The Original Code is "TheHapiContext.java ".  Description:
 "Exception containing a Location and Error Code"

 The Initial Developer of the Original Code is University Health Network. Copyright (C)
 2013.  All Rights Reserved.

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

package ca.uhn.hl7v2.examples;

import java.util.concurrent.Executors;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.app.HL7Service;
import ca.uhn.hl7v2.validation.builder.support.DefaultValidationBuilder;
import ca.uhn.hl7v2.validation.builder.support.NoValidationBuilder;

public class TheHapiContext {

	/**
	 * Introducing the HAPI context
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		/*
		 * Since HAPI 2.1, before using most parts of HAPI you sould create a context
		 * object. The HAPI Context acts as a central place for configuration and
		 * instantiation of HAPI objects.
		 * 
		 * Contructing one is simple:
		 */
		HapiContext ctx = new DefaultHapiContext();
		
		/*
		 * The context is the "one stop shop" for configuring and instantiating
		 * HAPI's rich toolset. The other example pages will explain in detail 
		 * how to use these features, so here we'll just focus on the HAPI context 
		 * itself. 
		 */
		
		/*
		 * As a simple example, let's configure this context to have message 
		 * validation disabled. 
		 */
		ctx.setValidationRuleBuilder(new NoValidationBuilder());
		
		/*
		 * We can now use this context as much as we want, and it's configuration
		 * will be applied every time.
		 * 
		 * Here we create two servers on ports 8080 and 8081.
		 */
		HL7Service server1 = ctx.newServer(8080, false);
		HL7Service server2 = ctx.newServer(8081, false);
		
		/*
		 * If we want these servers to have different configurations, we just
		 * use a separate context for each server. 
		 */
		HapiContext ctx1 = new DefaultHapiContext();
		ctx1.setValidationRuleBuilder(new NoValidationBuilder());
		server1 = ctx1.newServer(8080, false);
		
		HapiContext ctx2 = new DefaultHapiContext();
		ctx2.setValidationRuleBuilder(new DefaultValidationBuilder());
		server2 = ctx2.newServer(8081, false);

		/*
		 * Many of HAPI's internal tasks rely on background threads to
		 * do work (in particular, HL7 servers require several execution
		 * threads). HAPI uses the "java.util.concurrent.ExecutorService"
		 * facility to schedule background work. 
		 * 
		 * By default all instances of DefaultHapiContext will share a 
		 * single thread pool executor instance. This should be fine for 
		 * most use cases as the shared shared executor will grow as needed
		 * and close completely when it isn't.
		 * 
		 * You can override this if you want different behaviour. 
		 */
		ctx = new DefaultHapiContext();
		ctx.setExecutorService(Executors.newCachedThreadPool());
		
		/*
		 * See the rest of the examples for more information on how to 
		 * use the context:
		 * http://hl7api.sourceforge.net/devbyexample.html
		 */


	}

}
