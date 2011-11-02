package ca.uhn.hl7v2.model;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import junit.framework.TestCase;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AssignableTypeFilter;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.v251.message.ADT_A01;

public class ModelInstantiationTest extends TestCase {

	private static final Logger log = Logger.getLogger(ModelInstantiationTest.class.getName());

	public void testDataTypes() throws IOException, ClassNotFoundException {
		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(true);
		scanner.addIncludeFilter(new AssignableTypeFilter(AbstractType.class));
		Set<BeanDefinition> components = scanner.findCandidateComponents("ca/uhn/hl7v2/model/*/datatype");

		Map<Class<?>, Throwable> failures = new HashMap<Class<?>, Throwable>();
		for (BeanDefinition beanDefinition : components) {

			String nextBeanClassName = beanDefinition.getBeanClassName();
			log.info("Scanning class: " + nextBeanClassName);
			Class<?> clazz = Class.forName(nextBeanClassName);

			try {

				Constructor<?> constructor = clazz.getConstructor(new Class[] { Message.class });
				constructor.newInstance(new ADT_A01());

			} catch (Exception e) {

				failures.put(clazz, e);

			}

		}

		log.info("Done scanning");

		if (failures.isEmpty() == false) {

			StringBuilder m = new StringBuilder();
			m.append("Got the following failures: \n");

			for (Map.Entry<Class<?>, Throwable> next : failures.entrySet()) {
				m.append(" * ").append(next.getKey().getName()).append("\n");
				m.append("   ").append(next.getValue().toString()).append("\n");
			}

			fail(m.toString());

		}

	}

	public void testMessageTypes() throws IOException, ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, HL7Exception {
		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(true);
		scanner.addIncludeFilter(new AssignableTypeFilter(Message.class));
		Set<BeanDefinition> components = scanner.findCandidateComponents("ca/uhn/hl7v2/model/*/message");

		for (BeanDefinition beanDefinition : components) {

			String nextBeanClassName = beanDefinition.getBeanClassName();
			
//			nextBeanClassName = "ca.uhn.hl7v2.model.v251.message.ORL_O34";
			
			log.info("Scanning class: " + nextBeanClassName);
			Class<?> clazz = Class.forName(nextBeanClassName);
			Constructor<?> constructor = clazz.getConstructor(new Class[] {});
			Message instance = (Message) constructor.newInstance();
			instantiateStructure(instance, new HashSet<String>());
		}

		log.info("Done scanning");

	}

	private void instantiateStructure(Structure theInstance, Set<String> theTypesInStructure) throws HL7Exception {
//		log.info("* Instantiating structure: " + theInstance.getName());
		
		String typeName = theInstance.getClass().getName();
		theTypesInStructure.add(typeName);
		
		if (theInstance instanceof Group) {
			Group group = (Group) theInstance;

			String[] names = group.getNames();
			for (String string : names) {
				Structure child = group.get(string);
				
				if (theTypesInStructure.contains(child.getClass().getName())) {
					// This sometimes happened, e.g. in 2.5.1 ORL_O34 because the spec defines
					// multiple groups in the same structure with the same name. It probably shouldn't
					// do this.
					log.info("ERROR: Recursive structure found in " + typeName + " - Trying to add " + child.getClass().getName());
					continue;
				}
				
				instantiateStructure(child, theTypesInStructure);
				
			}

		}
		
		theTypesInStructure.remove(typeName);
		
	}

}
