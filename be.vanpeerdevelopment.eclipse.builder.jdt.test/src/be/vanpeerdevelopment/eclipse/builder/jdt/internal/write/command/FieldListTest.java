package be.vanpeerdevelopment.eclipse.builder.jdt.internal.write.command;

import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.FieldTestBuilder.aField;
import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.TypeTestBuilder.aType;
import static be.vanpeerdevelopment.eclipse.builder.jdt.internal.write.command.FieldListTestBuilder.aFieldList;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.UnitTest;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.ValidationException;

public class FieldListTest extends UnitTest {

	@Test
	public void testBuilderCreatesDefaultValidFieldList() {
		expectNoException();

		aFieldList().build();
	}

	@Test
	public void whenNullField_throwsValidationException() {
		expectExceptionWithMessage(
				ValidationException.class,
				"Field can not be null.");

		aFieldList()
				.withField(null)
				.build();
	}

	@Test
	public void toCode_emptyFieldList_returnsEmptyString() {
		FieldList emptyFieldList = aFieldList().build();

		String result = emptyFieldList.toCode();

		assertThat(result).isEmpty();
	}

	@Test
	public void toCode_oneField_returnOneFieldString() {
		FieldList fieldList = aFieldList()
				.withField(aField()
						.withType(aType()
								.withName("Person")
								.build())
						.withName("person")
						.build())
				.build();

		String result = fieldList.toCode();

		assertThat(result).isEqualTo("private Person person;");
	}

	@Test
	public void toCode_twoFields_returnTwoFieldsString() {
		FieldList fieldList = aFieldList()
				.withField(aField()
						.withType(aType()
								.withName("Person")
								.build())
						.withName("person")
						.build())
				.withField(aField()
						.withType(aType()
								.withName("Dog")
								.build())
						.withName("dog")
						.build())
				.build();

		String result = fieldList.toCode();

		assertThat(result).isEqualTo("private Person person;\nprivate Dog dog;");
	}
}