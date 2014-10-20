package be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command;

import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.Field.FieldBuilder.field;
import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.TypeTestBuilder.aType;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.Field.FieldBuilder;

public class FieldTestBuilder {

	private static final Type DEFAULT_TYPE = aType().build();
	private static final String DEFAULT_NAME = "person";

	private FieldBuilder builder;

	private FieldTestBuilder() {
		builder = field();
	}

	public static FieldTestBuilder aField() {
		return new FieldTestBuilder()
				.withType(DEFAULT_TYPE)
				.withName(DEFAULT_NAME);
	}

	public Field build() {
		return builder.build();
	}

	public FieldTestBuilder withType(Type type) {
		builder.withType(type);
		return this;
	}

	public FieldTestBuilder withName(String name) {
		builder.withName(name);
		return this;
	}
}