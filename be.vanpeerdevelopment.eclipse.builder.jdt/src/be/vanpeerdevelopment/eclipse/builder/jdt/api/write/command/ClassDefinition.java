package be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command;

import be.vanpeerdevelopment.eclipse.builder.jdt.internal.common.ValueObject;

public class ClassDefinition extends ValueObject {

	private String name;

	private ClassDefinition() {
	}

	public String toCode() {
		return new StringBuilder()
				.append("public class ")
				.append(name)
				.append("{}")
				.toString();
	}

	public static class ClassDefinitionBuilder {

		private ClassDefinition classDefinition;

		private ClassDefinitionBuilder() {
			this.classDefinition = new ClassDefinition();
		}

		public static ClassDefinitionBuilder classDefinition() {
			return new ClassDefinitionBuilder();
		}

		public ClassDefinition build() {
			return classDefinition;
		}

		public ClassDefinitionBuilder withName(String name) {
			classDefinition.name = name;
			return this;
		}
	}
}