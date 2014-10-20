package be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command;

import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.TypeTestBuilder.aType;
import static be.vanpeerdevelopment.eclipse.builder.jdt.element.ITypeTestBuilder.CLASS_DEFINITION_NAME;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.UnitTest;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.ValidationException;

public class TypeTest extends UnitTest {

	@Test
	public void testBuilderCreatesDefaultValidType() {
		expectNoException();

		aType().build();
	}

	@Test
	public void whenNoName_throwsValidationException() {
		expectExceptionWithMessage(
				ValidationException.class,
				"Name can not be blank.");

		aType()
				.withName(null)
				.build();
	}

	@Test
	public void whenEmptyName_throwsValidationException() {
		expectExceptionWithMessage(
				ValidationException.class,
				"Name can not be blank.");

		aType()
				.withName("")
				.build();
	}

	@Test
	public void whenBlankName_throwsValidationException() {
		expectExceptionWithMessage(
				ValidationException.class,
				"Name can not be blank.");

		aType()
				.withName(" ")
				.build();
	}

	@Test
	public void toCode() {
		Type type = aType()
				.withName(CLASS_DEFINITION_NAME)
				.build();

		String result = type.toCode();

		assertThat(result).isEqualTo(CLASS_DEFINITION_NAME);
	}
}