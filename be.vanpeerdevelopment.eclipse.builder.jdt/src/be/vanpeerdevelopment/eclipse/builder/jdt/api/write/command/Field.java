package be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command;

import static org.apache.commons.lang3.StringUtils.isBlank;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.ValidationException;
import be.vanpeerdevelopment.eclipse.builder.jdt.internal.common.ValueObject;

public class Field extends ValueObject {

	private Type type;
	private String name;

	private Field() {
	}

	public String toCode() {
		return new StringBuilder()
				.append("private ")
				.append(type.toCode())
				.append(" ")
				.append(name)
				.append(";")
				.toString();
	}

	private void validate() {
		validateType();
		validateName();
	}

	private void validateType() {
		if (type == null)
			throw new ValidationException("Type is required.");
	}

	private void validateName() {
		if (isBlank(name))
			throw new ValidationException("Name can not be blank.");
	}

	public static class FieldBuilder {

		private Field field;

		private FieldBuilder() {
			field = new Field();
		}

		public static FieldBuilder field() {
			return new FieldBuilder();
		}

		public Field build() {
			field.validate();
			return field;
		}

		public FieldBuilder withType(Type type) {
			field.type = type;
			return this;
		}

		public FieldBuilder withName(String name) {
			field.name = name;
			return this;
		}
	}
}