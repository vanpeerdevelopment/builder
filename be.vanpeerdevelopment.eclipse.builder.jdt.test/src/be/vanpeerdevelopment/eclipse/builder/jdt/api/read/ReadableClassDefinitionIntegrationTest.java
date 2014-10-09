package be.vanpeerdevelopment.eclipse.builder.jdt.api.read;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.EclipseTest;

public class ReadableClassDefinitionIntegrationTest extends EclipseTest {

	private JdtReadModel jdtReadModel;
	private ReadableClassDefinition classDefinition;

	@Before
	public void setup() {
		jdtReadModel = new JdtReadModel();
		ReadableCompilationUnit compilationUnit = jdtReadModel.getCompilationUnit(javaClassLocation());
		classDefinition = compilationUnit.getOnlyClassDefinition();
	}

	@Test
	public void getSimpleName() {
		String classDefinitionSimpleName = classDefinition.getSimpleName();

		assertThat(classDefinitionSimpleName).isEqualTo(JAVA_CLASS_NAME);
	}
}