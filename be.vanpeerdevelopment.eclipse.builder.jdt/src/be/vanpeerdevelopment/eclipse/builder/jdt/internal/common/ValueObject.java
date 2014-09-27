package be.vanpeerdevelopment.eclipse.builder.jdt.internal.common;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

public abstract class ValueObject {

	@Override
	public int hashCode() {
		return reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object other) {
		return reflectionEquals(this, other);
	}

	@Override
	public String toString() {
		return reflectionToString(this);
	}
}