package be.vanpeerdevelopment.eclipse.builder.jdt.api.read;

import static org.eclipse.core.resources.ResourcesPlugin.getWorkspace;
import static org.fest.assertions.Assertions.assertThat;

import org.eclipse.core.runtime.IPath;
import org.junit.Before;
import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.EclipseTest;

public class ReadableTypeIntegrationTest extends EclipseTest {

	private JdtReadModel jdtReadModel;
	private ReadableType type;

	@Before
	public void setup() {
		jdtReadModel = new JdtReadModel();
		ReadableCompilationUnit compilationUnit = jdtReadModel.getCompilationUnit(compilationUnitLocation());
		type = compilationUnit.getOnlyType();
	}

	private IPath compilationUnitLocation() {
		return getWorkspace()
				.getRoot()
				.getLocation()
				.append(JAVA_PROJECT_NAME)
				.append(JAVA_SOURCE_FOLDER_NAME)
				.append(JAVA_PACKAGE_NAME)
				.append(JAVA_CLASS_NAME + ".java");
	}

	@Test
	public void getSimpleName() {
		String typeSimpleName = type.getSimpleName();

		assertThat(typeSimpleName).isEqualTo(JAVA_CLASS_NAME);
	}
}