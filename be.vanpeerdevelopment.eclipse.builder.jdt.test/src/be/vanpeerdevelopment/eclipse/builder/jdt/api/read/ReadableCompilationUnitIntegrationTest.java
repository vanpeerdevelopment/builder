package be.vanpeerdevelopment.eclipse.builder.jdt.api.read;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.EclipseTest;

public class ReadableCompilationUnitIntegrationTest extends EclipseTest {

	private JdtReadModel jdtReadModel;
	private ReadableCompilationUnit compilationUnit;

	@Before
	public void setup() {
		jdtReadModel = new JdtReadModel();
		compilationUnit = jdtReadModel.getCompilationUnit(javaClassLocation());
	}

	@Test
	public void getName() {
		String name = compilationUnit.getName();

		assertThat(name).isEqualTo(JAVA_CLASS_NAME + ".java");
	}

	@Test
	public void getOnlyType() {
		ReadableType onlyType = compilationUnit.getOnlyType();

		assertThat(onlyType.getSimpleName()).isEqualTo(JAVA_CLASS_NAME);
	}
}