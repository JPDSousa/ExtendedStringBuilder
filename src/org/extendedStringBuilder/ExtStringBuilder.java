package org.extendedStringBuilder;

@SuppressWarnings("javadoc")
public interface ExtStringBuilder {
	
	final int DEFAULT_SIZE = 32;
	
	public static ExtStringBuilder create() {
		final java.lang.StringBuilder builder = new java.lang.StringBuilder(DEFAULT_SIZE);
		return fromJavaStringBuilder(builder);
	}
	
	public static ExtStringBuilder create(int capacity) {
		final java.lang.StringBuilder builder = new java.lang.StringBuilder(capacity);
		return fromJavaStringBuilder(builder);
	}
	
	public static ExtStringBuilder create(CharSequence string) {
		final java.lang.StringBuilder builder = new java.lang.StringBuilder(string);
		return fromJavaStringBuilder(builder);
	}
	
	public static ExtStringBuilder create(String string) {
		final java.lang.StringBuilder builder = new java.lang.StringBuilder(string);
		return fromJavaStringBuilder(builder);
	}
	
	public static ExtStringBuilder fromJavaStringBuilder(java.lang.StringBuilder strBuilder) {
		return new StringBuilderImpl(strBuilder);
	}
	
	@Override
	String toString();
	
	@Override
	boolean equals(Object obj);

	ExtStringBuilder breakLine();
	ExtStringBuilder tab();
	ExtStringBuilder tab(int n);

	ExtStringBuilder append(String str);
	
	ExtStringBuilder append(Object str);

	ExtStringBuilder append(Iterable<?> iterable, CharSequence delimiter, String emptyMessage);

	ExtStringBuilder append(Iterable<?> iterable, CharSequence delimiter);

	ConditionalStringBuilder appendIf(boolean condition);

	ExtStringBuilder appendIf(boolean condition, String str);
	ExtStringBuilder appendIf(boolean condition, String str, String elseStr);

}
