package be.vanpeerdevelopment.eclipse.builder.jdt.api.write;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.UnitTest;

public class JdtWriteExceptionTest extends UnitTest {

	@Test
	public void constructor_SetsMessage() {
		JdtWriteException jdtWriteException = new JdtWriteException("message");

		assertThat(jdtWriteException.getMessage()).isEqualTo("message");
	}

	@Test
	public void constructor_SetsMessageAndCause() throws Exception {
		Throwable cause = new Throwable("This is the cause.");
		JdtWriteException jdtWriteException = new JdtWriteException("message", cause);

		assertThat(jdtWriteException.getMessage()).isEqualTo("message");
		assertThat(jdtWriteException.getCause()).isEqualTo(cause);
	}
}
