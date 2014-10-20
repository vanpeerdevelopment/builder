package be.vanpeerdevelopment.eclipse.builder.jdt.internal.write.command;

import static org.apache.commons.lang3.StringUtils.join;

import java.util.ArrayList;
import java.util.List;

import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.ValidationException;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.Field;
import be.vanpeerdevelopment.eclipse.builder.jdt.internal.common.ValueObject;

public class FieldList extends ValueObject {

	private List<Field> fields;

	private FieldList() {
		fields = new ArrayList<>();
	}

	public String toCode() {
		return join(fieldsToCode(), "\n");
	}

	private List<String> fieldsToCode() {
		ArrayList<String> result = new ArrayList<>();
		for (Field field : fields) {
			result.add(field.toCode());
		}
		return result;
	}

	private void add(Field field) {
		canHaveAsField(field);
		fields.add(field);
	}

	private void canHaveAsField(Field field) {
		if (field == null)
			throw new ValidationException("Field can not be null.");
	}

	public static class FieldListBuilder {

		private FieldList fieldList;

		private FieldListBuilder() {
			fieldList = new FieldList();
		}

		public static FieldListBuilder fieldList() {
			return new FieldListBuilder();
		}

		public FieldList build() {
			return fieldList;
		}

		public FieldListBuilder withField(Field field) {
			fieldList.add(field);
			return this;
		}
	}
}