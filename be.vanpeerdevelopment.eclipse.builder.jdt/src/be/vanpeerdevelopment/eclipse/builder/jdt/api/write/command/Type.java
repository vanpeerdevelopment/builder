package be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command;

import be.vanpeerdevelopment.eclipse.builder.jdt.internal.common.ValueObject;

public class Type extends ValueObject {

	private String name;

	private Type() {
	}

	public String toCode() {
		return new StringBuilder()
				.append("public class ")
				.append(name)
				.append("{}")
				.toString();
	}

	public static class TypeBuilder {

		private Type type;

		private TypeBuilder() {
			this.type = new Type();
		}

		public static TypeBuilder type() {
			return new TypeBuilder();
		}

		public Type build() {
			return type;
		}

		public TypeBuilder withName(String name) {
			type.name = name;
			return this;
		}
	}
}