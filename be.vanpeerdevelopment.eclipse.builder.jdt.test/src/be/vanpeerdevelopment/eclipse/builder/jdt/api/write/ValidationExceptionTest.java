package be.vanpeerdevelopment.eclipse.builder.jdt.api.write;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.UnitTest;

public class ValidationExceptionTest extends UnitTest {

	@Test
	public void constructor_SetsMessage() {
		ValidationException validationException = new ValidationException("message");

		assertThat(validationException.getMessage()).isEqualTo("message");
	}
}