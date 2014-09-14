package be.vanpeerdevelopment.eclipse.builder.jdt;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public abstract class UnitTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	protected void expectExceptionWithMessage(Class<? extends Throwable> exceptionClass, String message) {
		expectedException.expect(exceptionClass);
		expectedException.expectMessage(message);
	}
}