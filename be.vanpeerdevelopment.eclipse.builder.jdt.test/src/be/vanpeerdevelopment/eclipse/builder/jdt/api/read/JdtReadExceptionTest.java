package be.vanpeerdevelopment.eclipse.builder.jdt.api.read;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.UnitTest;

public class JdtReadExceptionTest extends UnitTest {

	@Test
	public void constructor_SetsMessage() {
		JdtReadException jdtReadException = new JdtReadException("message");

		assertThat(jdtReadException.getMessage()).isEqualTo("message");
	}

	@Test
	public void constructor_SetsMessageAndCause() throws Exception {
		Throwable cause = new Throwable("This is the cause.");
		JdtReadException jdtReadException = new JdtReadException("message", cause);

		assertThat(jdtReadException.getMessage()).isEqualTo("message");
		assertThat(jdtReadException.getCause()).isEqualTo(cause);
	}
}
