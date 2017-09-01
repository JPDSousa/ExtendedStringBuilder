package org.extendedStringBuilder;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("javadoc")
public class StrinBuilderTest {

	private static ExtStringBuilder guineaPig;
	
	@Before
	public final void setUp() {
		guineaPig = ExtStringBuilder.create();
	}
	
	@Test
	public final void createTest() {
		assertNotNull(ExtStringBuilder.create());
		assertNotNull(ExtStringBuilder.create(128));
		assertNotNull(ExtStringBuilder.create("test"));
		assertNotNull(ExtStringBuilder.create((CharSequence) "that"));
		assertNotNull(ExtStringBuilder.fromJavaStringBuilder(new java.lang.StringBuilder()));
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
		final ExtStringBuilder b1 = ExtStringBuilder.create().breakLine();
		final ExtStringBuilder b2 = ExtStringBuilder.create().append("\n");
		assertEquals(b1, b2);
	}

}
