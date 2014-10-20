package be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command;

import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.FieldTestBuilder.aField;
import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.TypeTestBuilder.aType;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.UnitTest;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.ValidationException;

public class FieldTest extends UnitTest {

	@Test
	public void testBuilderCreatesDefaultValidField() {
		expectNoException();

		aField().build();
	}

	@Test
	public void whenNoType_throwsValidationException() {
		expectExceptionWithMessage(
				ValidationException.class,
				"Type is required.");

		aField()
				.withType(null)
				.build();
	}

	@Test
	public void whenNoName_throwsValidationException() {
		expectExceptionWithMessage(
				ValidationException.class,
				"Name can not be blank.");

		aField()
				.withName(null)
				.build();
	}

	@Test
	public void whenEmptyName_throwsValidationException() {
		expectExceptionWithMessage(
				ValidationException.class,
				"Name can not be blank.");

		aField()
				.withName("")
				.build();
	}

	@Test
	public void whenBlankName_throwsValidationException() {
		expectExceptionWithMessage(
				ValidationException.class,
				"Name can not be blank.");

		aField()
				.withName(" ")
				.build();
	}

	@Test
	public void toCode() {
		Field field = aField()
				.withType(aType()
						.withName("Person")
						.build())
				.withName("person")
				.build();

		String result = field.toCode();

		assertThat(result).isEqualTo("private Person person;");
	}
}