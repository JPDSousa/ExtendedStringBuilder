package org.extendedStringBuilder;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.commons.collections4.IterableUtils;

final class StringBuilderImpl implements ExtStringBuilder {

	private final java.lang.StringBuilder builder;
	
	StringBuilderImpl(java.lang.StringBuilder builder) {
		this.builder = builder;
	}
	
	@Override
	public ExtStringBuilder appendIf(boolean condition, String str) {
		if(condition) {
			builder.append(str);
		}
		return this;
	}
	
	@Override
	public ConditionalStringBuilder appendIf(boolean condition) {
		return new ConditionalStringBuilder(this, condition);
	}
	
	@Override
	public ExtStringBuilder append(Iterable<?> iterable, CharSequence delimiter) {
		return append(iterable, delimiter, null);
	}
	
	@Override
	public ExtStringBuilder append(Iterable<?> iterable, CharSequence delimiter, String emptyMessage) {
		if(emptyMessage != null && IterableUtils.isEmpty(iterable)){
			builder.append(emptyMessage);
		}
		else {
			StreamSupport.stream(iterable.spliterator(), false).map(Object::toString).collect(Collectors.joining(delimiter));
		}
		return this;
	}
	
	@Override
	public ExtStringBuilder append(String str) {
		builder.append(str);
		return this;
	}
	
	@Override
	public ExtStringBuilder append(Object str) {
		builder.append(str);
		return this;
	}

	@Override
	public ExtStringBuilder breakLine() {
		builder.append("\n");
		return this;
	}
	
	@Override
	public String toString() {
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((builder == null) ? 0 : builder.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		StringBuilderImpl other = (StringBuilderImpl) obj;
		if (builder == null) {
			if (other.builder != null) {
				return false;
			}
		} else if (!builder.toString().equals(other.builder.toString())) {
			return false;
		}
		return true;
	}
}
