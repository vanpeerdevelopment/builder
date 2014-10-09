package be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command;

import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.ClassDefinitionTestBuilder.aClassDefinition;
import static be.vanpeerdevelopment.eclipse.builder.jdt.element.ITypeTestBuilder.CLASS_DEFINITION_NAME;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.UnitTest;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.ValidationException;

public class ClassDefinitionTest extends UnitTest {

	@Test
	public void testBuilderCreatesDefaultValidClassDefinition() {
		expectNoException();

		aClassDefinition().build();
	}

	@Test
	public void whenNoName_throwsValidationException() {
		expectExceptionWithMessage(
				ValidationException.class,
				"Name can not be blank.");

		aClassDefinition()
				.withName(null)
				.build();
	}

	@Test
	public void whenEmptyName_throwsValidationException() {
		expectExceptionWithMessage(
				ValidationException.class,
				"Name can not be blank.");

		aClassDefinition()
				.withName("")
				.build();
	}

	@Test
	public void whenBlankName_throwsValidationException() {
		expectExceptionWithMessage(
				ValidationException.class,
				"Name can not be blank.");

		aClassDefinition()
				.withName(" ")
				.build();
	}

	@Test
	public void toCode() {
		ClassDefinition classDefinition = aClassDefinition()
				.withName(CLASS_DEFINITION_NAME)
				.build();

		String code = classDefinition.toCode();

		assertThat(code).isEqualTo("public class " + CLASS_DEFINITION_NAME + "{}");
	}
}