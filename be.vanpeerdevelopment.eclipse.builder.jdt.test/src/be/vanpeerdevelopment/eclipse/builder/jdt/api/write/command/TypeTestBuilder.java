package be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command;

import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.Type.TypeBuilder.type;
import static be.vanpeerdevelopment.eclipse.builder.jdt.element.ITypeTestBuilder.CLASS_DEFINITION_NAME;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.Type.TypeBuilder;

public class TypeTestBuilder {

	private static final String DEFAULT_NAME = CLASS_DEFINITION_NAME;

	private TypeBuilder builder;

	private TypeTestBuilder() {
		builder = type();
	}

	public static TypeTestBuilder aType() {
		return new TypeTestBuilder()
				.withName(DEFAULT_NAME);
	}

	public Type build() {
		return builder.build();
	}

	public TypeTestBuilder withName(String name) {
		builder.withName(name);
		return this;
	}
}