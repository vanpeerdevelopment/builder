package be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command;

import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.ClassDefinition.ClassDefinitionBuilder.classDefinition;
import static be.vanpeerdevelopment.eclipse.builder.jdt.element.ITypeTestBuilder.CLASS_DEFINITION_NAME;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.ClassDefinition.ClassDefinitionBuilder;

public class ClassDefinitionTestBuilder {

	private static final String DEFAULT_NAME = CLASS_DEFINITION_NAME;

	private ClassDefinitionBuilder builder;

	private ClassDefinitionTestBuilder() {
		builder = classDefinition();
	}

	public static ClassDefinitionTestBuilder aClassDefinition() {
		return new ClassDefinitionTestBuilder()
				.withName(DEFAULT_NAME);
	}

	public ClassDefinition build() {
		return builder.build();
	}

	public ClassDefinitionTestBuilder withName(String name) {
		builder.withName(name);
		return this;
	}
}