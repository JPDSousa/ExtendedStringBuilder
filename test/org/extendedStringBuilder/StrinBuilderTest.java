package org.extendedStringBuilder;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("javadoc")
public class StrinBuilderTest {

	private static StringBuilder guineaPig;
	
	@Before
	public final void setUp() {
		guineaPig = StringBuilder.create();
	}
	
	@Test
	public final void createTest() {
		assertNotNull(StringBuilder.create());
		assertNotNull(StringBuilder.create(128));
		assertNotNull(StringBuilder.create("test"));
		assertNotNull(StringBuilder.create((CharSequence) "that"));
		assertNotNull(StringBuilder.fromJavaStringBuilder(new java.lang.StringBuilder()));
	}
	
	@Test
	public final void equalsTest() {
		final String expected = "test";
		assertEquals(guineaPig, guineaPig.append(expected));
	}
	
	@Test
	public final void toStringTest() {
		final String expected = "test";
		guineaPig.append(expected);
		assertEquals(expected, guineaPig.toString());
	}
	
	@Test
	public final void breakLineTest() {
		final StringBuilder b1 = StringBuilder.create().breakLine();
		final StringBuilder b2 = StringBuilder.create().append("\n");
		assertEquals(b1, b2);
	}

}
