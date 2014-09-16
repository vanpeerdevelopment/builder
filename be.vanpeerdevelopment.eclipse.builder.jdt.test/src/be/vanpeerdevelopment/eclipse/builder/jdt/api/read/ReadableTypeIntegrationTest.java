package be.vanpeerdevelopment.eclipse.builder.jdt.api.read;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.EclipseTest;

public class ReadableTypeIntegrationTest extends EclipseTest {

	private JdtReadModel jdtReadModel;
	private ReadableType type;

	@Before
	public void setup() {
		jdtReadModel = new JdtReadModel();
		ReadableCompilationUnit compilationUnit = jdtReadModel.getCompilationUnit(javaClassLocation());
		type = compilationUnit.getOnlyType();
	}

	@Test
	public void getSimpleName() {
		String typeSimpleName = type.getSimpleName();

		assertThat(typeSimpleName).isEqualTo(JAVA_CLASS_NAME);
	}
}