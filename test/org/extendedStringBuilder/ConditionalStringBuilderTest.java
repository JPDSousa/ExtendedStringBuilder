package org.extendedStringBuilder;

import static org.junit.Assert.*;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class ConditionalStringBuilderTest {

	@Test
	public final void SimpleAppendIfTest() {
		final String expected = "expected";
		assertEquals(expected, ExtStringBuilder.create().appendIf(true, expected).toString());
		assertEquals("", ExtStringBuilder.create().appendIf(false, expected).toString());
		assertEquals(expected, ExtStringBuilder.create().appendIf(false, "notExpected", expected).toString());
		assertEquals("", ExtStringBuilder.create().appendIf(true, "", expected).toString());
	}
}
