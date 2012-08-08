package ca.uhn.hl7v2.validation.builder;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.UUID;

import org.junit.Test;

import ca.uhn.hl7v2.validation.ValidationException;

/**
 * All predicates are also implicitly tested in DefaultValidationTest
 * 
 */
public class BuilderSupportTest {

	private static String TEST1 = "TEST";
	private static String TEST2 = "TESTTEST";

	@SuppressWarnings("serial")
	private static BuilderSupport b = new BuilderSupport() {
	};

	@Test
	public void testIsEqual() throws ValidationException {
		assertFalse(b.isEqual(TEST1).evaluate(null));
		assertFalse(b.isEqual("").evaluate(null));
		assertTrue(b.isEqual(null).evaluate(null));
		assertTrue(b.isEqual(TEST1).evaluate(TEST1));
		assertFalse(b.isEqual(TEST1).evaluate(TEST2));
		assertFalse(b.isEqual(TEST1).evaluate(TEST1.toLowerCase()));
	}

	@Test
	public void testIsEqualIgnoreCase() throws ValidationException {
		assertFalse(b.isEqualIgnoreCase(TEST1).evaluate(null));
		assertFalse(b.isEqualIgnoreCase("").evaluate(null));
		assertTrue(b.isEqualIgnoreCase(null).evaluate(null));
		assertTrue(b.isEqualIgnoreCase(TEST1).evaluate(TEST1));
		assertFalse(b.isEqualIgnoreCase(TEST1).evaluate(TEST2));
		assertTrue(b.isEqualIgnoreCase(TEST1).evaluate(TEST1.toLowerCase()));
	}

	@Test
	public void testEmpty() throws ValidationException {
		assertTrue(b.empty().evaluate(null));
		assertTrue(b.empty().evaluate(""));
		assertTrue(b.empty().evaluate("\"\""));
		assertFalse(b.empty().evaluate(TEST1));
	}

	@Test
	public void testEmptyOr() throws ValidationException {
		assertTrue(b.emptyOr(b.isEqual(TEST1)).evaluate(null));
		assertTrue(b.emptyOr(b.isEqual(TEST1)).evaluate(""));
		assertTrue(b.emptyOr(b.isEqual(TEST1)).evaluate("\"\""));
		assertTrue(b.emptyOr(b.isEqual(TEST1)).evaluate(TEST1));
		assertFalse(b.emptyOr(b.isEqual(TEST1)).evaluate(TEST2));
	}

	@Test
	public void testMatchesString() throws ValidationException {
		assertFalse(b.matches(TEST1).evaluate(null));
		assertTrue(b.matches(TEST1).evaluate(TEST1));
		assertTrue(b.matches(".+").evaluate(TEST1));
		assertFalse(b.matches(TEST1).evaluate(TEST1.toLowerCase()));
	}

	@Test
	public void testStartsWith() throws ValidationException {
		assertFalse(b.startsWith(TEST1).evaluate(null));
		assertTrue(b.startsWith(TEST1).evaluate(TEST1));
		assertTrue(b.startsWith(TEST1).evaluate(TEST2));
		assertFalse(b.startsWith(TEST1).evaluate(TEST1.toLowerCase()));
	}

	@Test
	public void testNonNegativeInteger() throws ValidationException {
		assertFalse(b.nonNegativeInteger().evaluate(null));
		assertTrue(b.nonNegativeInteger().evaluate(0));
		assertTrue(b.nonNegativeInteger().evaluate("0"));
		assertTrue(b.nonNegativeInteger().evaluate("1"));
		assertFalse(b.nonNegativeInteger().evaluate("1.5"));
		assertFalse(b.nonNegativeInteger().evaluate("-1"));
	}

	@Test
	public void testNumber() throws ValidationException {
		assertFalse(b.number().evaluate(null));
		assertTrue(b.number().evaluate(0));
		assertTrue(b.number().evaluate("0"));
		assertTrue(b.number().evaluate("1"));
		assertTrue(b.number().evaluate("1.5"));
		assertTrue(b.number().evaluate("-1"));
		assertFalse(b.number().evaluate(TEST1));
	}

	@Test
	public void testDate() throws ValidationException {
		assertFalse(b.date().evaluate(null));
		assertTrue(b.date().evaluate("20120604"));
		assertTrue(b.date().evaluate("201206"));
		assertTrue(b.date().evaluate("2012"));
		assertFalse(b.date().evaluate("20120"));
		assertFalse(b.date().evaluate("2012060"));
		assertFalse(b.date().evaluate("201206045"));
	}

	@Test
	public void testTime() throws ValidationException {
		assertFalse(b.time().evaluate(null));
		assertTrue(b.time().evaluate("08"));
		assertTrue(b.time().evaluate("0800"));
		assertTrue(b.time().evaluate("080005"));
		assertTrue(b.time().evaluate("080005.1"));
		assertTrue(b.time().evaluate("080005.14"));
		assertTrue(b.time().evaluate("080005.1479"));
		assertTrue(b.time().evaluate("08-0100"));
		assertTrue(b.time().evaluate("080005-0100"));
		assertTrue(b.time().evaluate("080005.1479-0100"));
		assertFalse(b.time().evaluate("0"));
		assertFalse(b.time().evaluate("080"));
		assertFalse(b.time().evaluate("08750"));
		assertFalse(b.time().evaluate("0800051"));
		assertFalse(b.time().evaluate("0800051.14793"));
		assertFalse(b.time().evaluate("0+0600"));
	}

	@Test
	public void testDateTime() throws ValidationException {
		assertFalse(b.dateTime().evaluate(null));
		assertTrue(b.dateTime().evaluate("20120604"));
		assertTrue(b.dateTime().evaluate("201206"));
		assertTrue(b.dateTime().evaluate("2012"));
		assertFalse(b.dateTime().evaluate("20120"));
		assertFalse(b.dateTime().evaluate("2012060"));
		assertFalse(b.dateTime().evaluate("201206045"));
		assertFalse(b.dateTime().evaluate("2012060408")); // partial time not allowed
		assertTrue(b.dateTime().evaluate("20120608000527+0010"));
		assertTrue(b.dateTime().evaluate("20120608000527.1"));
		assertFalse(b.dateTime().evaluate("20120608000577.1"));
	}

	@Test
	public void testDateTime25() throws ValidationException {
		assertFalse(b.dateTime25().evaluate(null));
		assertTrue(b.dateTime25().evaluate("20120604"));
		assertTrue(b.dateTime25().evaluate("201206"));
		assertTrue(b.dateTime25().evaluate("2012"));
		assertFalse(b.dateTime25().evaluate("20120"));
		assertFalse(b.dateTime25().evaluate("2012060"));
		assertFalse(b.dateTime25().evaluate("201206045"));
		assertTrue(b.dateTime25().evaluate("2012060408")); // partial time allowed
		assertTrue(b.dateTime25().evaluate("20120608000527+0010"));
		assertTrue(b.dateTime25().evaluate("20120608000527.1"));
		assertFalse(b.dateTime25().evaluate("20120608000577.1"));
	}

	@Test
	public void testUsPhoneNumber() throws ValidationException {
		assertFalse(b.usPhoneNumber().evaluate(null));
		assertTrue(b.usPhoneNumber().evaluate("(705)267-2131"));
		assertFalse(b.usPhoneNumber().evaluate("(705)267-21312"));
		assertFalse(b.usPhoneNumber().evaluate(TEST1));
	}

	@Test
	public void testOid() throws ValidationException {
		assertFalse(b.oid().evaluate(null));
		assertTrue(b.oid().evaluate("1.2.3.4.5"));
		assertTrue(b.oid().evaluate("2.21.0.4.55"));
		assertFalse(b.oid().evaluate("1.2.05.4.5"));
		assertFalse(b.oid().evaluate("9.2.5.4.5")); // must start with 0..2
		assertFalse(b.oid().evaluate(TEST1));
		assertFalse(b.oid().evaluate("1"));
	}

	@Test
	public void testUuid() throws ValidationException {
		assertTrue(b.uuid().evaluate(UUID.randomUUID()));
	}

	@Test
	public void testInObjectArray() throws ValidationException {
		assertFalse(b.in(TEST1, TEST2).evaluate(null));
		assertTrue(b.in(TEST1, TEST2).evaluate(TEST1));
		assertFalse(b.in(TEST1).evaluate(TEST2));
	}

	@Test
	public void testInCollectionOfQ() throws ValidationException {
		assertFalse(b.in(Arrays.asList(new String[] { TEST1, TEST2 })).evaluate(null));
		assertTrue(b.in(Arrays.asList(new String[] { TEST1, TEST2 })).evaluate(TEST1));
		assertFalse(b.in(Arrays.asList(new String[] { TEST1 })).evaluate(TEST2));
	}

	@Test
	public void testAnyOfIterableOfPredicate() throws ValidationException {
		assertFalse(b.anyOf(Arrays.asList(new Predicate[] { b.isEqual(TEST1), b.isEqual(TEST2) }))
				.evaluate(null));
		assertTrue(b.anyOf(Arrays.asList(new Predicate[] { b.isEqual(TEST1), b.isEqual(TEST2) }))
				.evaluate(TEST1));
		assertFalse(b.anyOf(Arrays.asList(new Predicate[] { b.isEqual(TEST1) })).evaluate(TEST2));
	}

	@Test
	public void testAllOfIterableOfPredicate() throws ValidationException {
		assertFalse(b.allOf(
				Arrays.asList(new Predicate[] { b.startsWith(TEST1), b.isEqual(TEST2) })).evaluate(
				null));
		assertTrue(b
				.allOf(Arrays.asList(new Predicate[] { b.startsWith(TEST1), b.isEqual(TEST2) }))
				.evaluate(TEST2));
		assertFalse(b.allOf(Arrays.asList(new Predicate[] { b.isEqual(TEST1) })).evaluate(TEST2));
	}

	@Test
	public void testAnyOfPredicateArray() throws ValidationException {
		assertFalse(b.anyOf(new Predicate[] { b.isEqual(TEST1), b.isEqual(TEST2) }).evaluate(null));
		assertTrue(b.anyOf(new Predicate[] { b.isEqual(TEST1), b.isEqual(TEST2) }).evaluate(TEST1));
		assertFalse(b.anyOf(new Predicate[] { b.isEqual(TEST1) }).evaluate(TEST2));
	}

	@Test
	public void testAllOfPredicateArray() throws ValidationException {
		assertFalse(b.allOf(new Predicate[] { b.startsWith(TEST1), b.isEqual(TEST2) }).evaluate(
				null));
		assertTrue(b.allOf(new Predicate[] { b.startsWith(TEST1), b.isEqual(TEST2) }).evaluate(
				TEST2));
		assertFalse(b.allOf(new Predicate[] { b.isEqual(TEST1) }).evaluate(TEST2));
	}

	@Test
	public void testNot() throws ValidationException {
		assertTrue(b.not(b.isEqual(TEST1)).evaluate(null));
		assertTrue(b.not(b.isEqual(TEST1)).evaluate(TEST2));
		assertFalse(b.not(b.isEqual(TEST1)).evaluate(TEST1));
	}

	@Test
	public void testMaxLength() throws ValidationException {
		assertTrue(b.maxLength(TEST1.length()).evaluate(null));
		assertTrue(b.maxLength(TEST1.length()).evaluate(""));
		assertTrue(b.maxLength(TEST1.length()).evaluate(TEST1));
		assertFalse(b.maxLength(TEST1.length()).evaluate(TEST2));
	}

	@Test
	public void testWithdrawn() throws ValidationException {
		assertTrue(b.withdrawn().evaluate(null));
		assertTrue(b.withdrawn().evaluate(""));
		assertFalse(b.withdrawn().evaluate(TEST1));
	}

	@Test
	public void testAlways() throws ValidationException {
		assertTrue(b.always(true).evaluate(TEST1));
		assertTrue(b.always(true).evaluate(null));
		assertFalse(b.always(false).evaluate(TEST1));
		assertFalse(b.always(false).evaluate(null));
	}

	@Test
	public void testAlwaysFails() throws ValidationException {
		assertFalse(b.alwaysFails().evaluate(TEST1));
		assertFalse(b.alwaysFails().evaluate(null));
	}

}
