package be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command;

import static be.vanpeerdevelopment.eclipse.builder.jdt.internal.write.command.FieldList.FieldListBuilder.fieldList;
import static org.apache.commons.lang3.StringUtils.isBlank;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.ValidationException;
import be.vanpeerdevelopment.eclipse.builder.jdt.internal.common.ValueObject;
import be.vanpeerdevelopment.eclipse.builder.jdt.internal.write.command.FieldList;
import be.vanpeerdevelopment.eclipse.builder.jdt.internal.write.command.FieldList.FieldListBuilder;

public class ClassDefinition extends ValueObject {

	private String name;
	private FieldList fieldList;

	private ClassDefinition() {
	}

	public String getName() {
		return name;
	}

	public boolean hasName(String name) {
		return this.name.equals(name);
	}

	public String toCode() {
		return new StringBuilder()
				.append("public class ")
				.append(name)
				.append("{")
				.append("\n")
				.append(fieldList.toCode())
				.append("\n")
				.append("}")
				.toString();
	}

	private void validate() {
		if (isBlank(name))
			throw new ValidationException("Name can not be blank.");
	}

	public static class ClassDefinitionBuilder {

		private ClassDefinition classDefinition;
		private FieldListBuilder fieldListBuilder;

		private ClassDefinitionBuilder() {
			this.classDefinition = new ClassDefinition();
			fieldListBuilder = fieldList();
		}

		public static ClassDefinitionBuilder classDefinition() {
			return new ClassDefinitionBuilder();
		}

		public ClassDefinition build() {
			classDefinition.fieldList = fieldListBuilder.build();
			classDefinition.validate();
			return classDefinition;
		}

		public ClassDefinitionBuilder withName(String name) {
			classDefinition.name = name;
			return this;
		}

		public ClassDefinitionBuilder withField(Field field) {
			fieldListBuilder.withField(field);
			return this;
		}
	}
}