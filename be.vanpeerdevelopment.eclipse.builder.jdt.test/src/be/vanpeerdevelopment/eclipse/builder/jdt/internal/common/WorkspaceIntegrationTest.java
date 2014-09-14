package be.vanpeerdevelopment.eclipse.builder.jdt.internal.common;

import static org.eclipse.core.resources.ResourcesPlugin.getWorkspace;
import static org.fest.assertions.Assertions.assertThat;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;
import org.junit.Before;
import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.EclipseTest;

public class WorkspaceIntegrationTest extends EclipseTest {

	private Workspace workspace;

	@Before
	public void setup() {
		workspace = new Workspace();
	}

	@Test
	public void getFile() throws Exception {
		IPath compilationUnitLocation = getWorkspace()
				.getRoot()
				.getLocation()
				.append(JAVA_PROJECT_NAME)
				.append(JAVA_SOURCE_FOLDER_NAME)
				.append(JAVA_PACKAGE_NAME)
				.append(JAVA_CLASS_NAME + ".java");

		ICompilationUnit compilationUnit = workspace.getCompilationUnit(compilationUnitLocation);

		assertThat(compilationUnit.getElementName()).isEqualTo(JAVA_CLASS_NAME + ".java");
	}

	@Test
	public void getPackage() {
		IPath packageLocation = getWorkspace()
				.getRoot()
				.getLocation()
				.append(JAVA_PROJECT_NAME)
				.append(JAVA_SOURCE_FOLDER_NAME)
				.append(JAVA_PACKAGE_NAME);

		IPackageFragment packageFragment = workspace.getPackage(packageLocation);

		assertThat(packageFragment.getElementName()).isEqualTo(JAVA_PACKAGE_NAME);
	}
}