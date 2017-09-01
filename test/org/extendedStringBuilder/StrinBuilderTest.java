package org.extendedStringBuilder;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

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
	public final void toStringObjectTest() {
		final Integer obj = new Integer(5);
		final String expected = obj.toString();
		guineaPig.append(obj);
		assertEquals(expected, guineaPig.toString());
	}
	
	@Test
	public final void breakLineTest() {
		final ExtStringBuilder b1 = ExtStringBuilder.create().breakLine();
		final ExtStringBuilder b2 = ExtStringBuilder.create().append("\n");
		assertEquals(b1, b2);
	}
	
	@Test
	public final void appendIterableTest() {
		final String emptyMsg = "empty";
		final Iterable<String> strings = Arrays.asList("a", "b", "c");
		final Iterable<String> singleString = Arrays.asList("a");
		final String delimiter = ".";
		assertEquals(String.join(delimiter, strings), ExtStringBuilder.create().append(strings, delimiter).toString());
		assertEquals("", ExtStringBuilder.create().append(new ArrayList<>(), delimiter).toString());
		assertEquals("a", ExtStringBuilder.create().append(singleString, delimiter).toString());
		assertEquals(String.join(delimiter, strings), ExtStringBuilder.create().append(strings, delimiter, emptyMsg).toString());
		assertEquals(emptyMsg, ExtStringBuilder.create().append(new ArrayList<>(), delimiter, emptyMsg).toString());
		assertEquals("a", ExtStringBuilder.create().append(singleString, delimiter, emptyMsg).toString());
	}

}
