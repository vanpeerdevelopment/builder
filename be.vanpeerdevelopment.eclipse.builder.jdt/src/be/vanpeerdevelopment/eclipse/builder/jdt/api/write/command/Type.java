package be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command;

import static org.apache.commons.lang3.StringUtils.isBlank;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.ValidationException;
import be.vanpeerdevelopment.eclipse.builder.jdt.internal.common.ValueObject;

public class Type extends ValueObject {

	private String name;

	private Type() {
	}

	public String toCode() {
		return name;
	}

	private void validate() {
		if (isBlank(name))
			throw new ValidationException("Name can not be blank.");
	}

	public static class TypeBuilder {

		private Type type;

		private TypeBuilder() {
			type = new Type();
		}

		public static TypeBuilder type() {
			return new TypeBuilder();
		}

		public Type build() {
			type.validate();
			return type;
		}

		public TypeBuilder withName(String name) {
			type.name = name;
			return this;
		}
	}
}