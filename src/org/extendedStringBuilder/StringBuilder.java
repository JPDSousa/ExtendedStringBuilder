package org.extendedStringBuilder;

@SuppressWarnings("javadoc")
public interface StringBuilder {
	
	final int DEFAULT_SIZE = 32;
	
	public static StringBuilder create() {
		final java.lang.StringBuilder builder = new java.lang.StringBuilder(DEFAULT_SIZE);
		return fromJavaStringBuilder(builder);
	}
	
	public static StringBuilder create(int capacity) {
		final java.lang.StringBuilder builder = new java.lang.StringBuilder(capacity);
		return fromJavaStringBuilder(builder);
	}
	
	public static StringBuilder create(CharSequence string) {
		final java.lang.StringBuilder builder = new java.lang.StringBuilder(string);
		return fromJavaStringBuilder(builder);
	}
	
	public static StringBuilder create(String string) {
		final java.lang.StringBuilder builder = new java.lang.StringBuilder(string);
		return fromJavaStringBuilder(builder);
	}
	
	public static StringBuilder fromJavaStringBuilder(java.lang.StringBuilder strBuilder) {
		return new StringBuilderImpl(strBuilder);
	}
	
	@Override
	String toString();
	
	@Override
	boolean equals(Object obj);

	StringBuilder breakLine();

	StringBuilder append(String str);

	StringBuilder append(Iterable<?> iterable, CharSequence delimiter, String emptyMessage);

	StringBuilder append(Iterable<?> iterable, CharSequence delimiter);

	ConditionalStringBuilder appendIf(boolean condition);

	StringBuilder appendIf(boolean condition, String str);

}
