package org.extendedStringBuilder;

@SuppressWarnings("javadoc")
public class ConditionalStringBuilder implements ExtStringBuilder {

	private final ExtStringBuilder builder;
	private final boolean condition;

	ConditionalStringBuilder(ExtStringBuilder builder, boolean condition) {
		this.builder = builder;
		this.condition = condition;
	}


	public ExtStringBuilder endIf() {
		return builder;
	}

	@Override
	public String toString() {
		return endIf().toString();
	}

	@Override
	public ExtStringBuilder breakLine() {
		if(condition) {
			builder.breakLine();
		}
		return this;
	}


	@Override
	public ExtStringBuilder tab() {
		if(condition) {
			builder.tab();
		}
		return this;
	}


	@Override
	public ExtStringBuilder append(String str) {
		if(condition) {
			builder.append(str);
		}
		return this;
	}


	@Override
	public ExtStringBuilder append(Object str) {
		if(condition) {
			builder.append(str);
		}
		return this;
	}


	@Override
	public ExtStringBuilder append(Iterable<?> iterable, CharSequence delimiter, String emptyMessage) {
		if(condition) {
			builder.append(iterable, delimiter, emptyMessage);
		}
		return this;
	}


	@Override
	public ExtStringBuilder append(Iterable<?> iterable, CharSequence delimiter) {
		if(condition) {
			builder.append(iterable, delimiter);
		}
		return this;
	}


	@Override
	public ConditionalStringBuilder appendIf(boolean condition) {
		if(this.condition) {
			return new ConditionalStringBuilder(this, condition);
		}
		return this;
	}


	@Override
	public ExtStringBuilder appendIf(boolean condition, String str) {
		if(this.condition) {
			builder.appendIf(condition, str);
		}
		return this;
	}


	@Override
	public ExtStringBuilder appendIf(boolean condition, String str, String elseStr) {
		if(this.condition) {
			builder.appendIf(condition, str, elseStr);
		}
		return this;
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
		ConditionalStringBuilder other = (ConditionalStringBuilder) obj;
		if (builder == null) {
			if (other.builder != null) {
				return false;
			}
		} else if (!builder.equals(other.builder)) {
			return false;
		}
		return true;
	}

}
