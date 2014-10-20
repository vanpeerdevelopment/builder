package be.vanpeerdevelopment.eclipse.builder.jdt.internal.write.command;

import static be.vanpeerdevelopment.eclipse.builder.jdt.internal.write.command.FieldList.FieldListBuilder.fieldList;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.Field;
import be.vanpeerdevelopment.eclipse.builder.jdt.internal.write.command.FieldList.FieldListBuilder;

public class FieldListTestBuilder {

	private FieldListBuilder builder;

	private FieldListTestBuilder() {
		builder = fieldList();
	}

	public static FieldListTestBuilder aFieldList() {
		return new FieldListTestBuilder();
	}

	public FieldList build() {
		return builder.build();
	}

	public FieldListTestBuilder withField(Field field) {
		builder.withField(field);
		return this;
	}
}